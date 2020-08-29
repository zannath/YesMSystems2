package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Case1 {

	@Test
	public void neagiveLogin() {
       WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver, 30);	
		
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("zannathk13@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("welcome");
		driver.findElement(By.id("send2")).click();
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		String error= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
	}
	@Test
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();

		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("khatune");
		driver.findElement(By.id("lastname")).sendKeys("zannath");
		driver.findElement(By.id("email_address")).sendKeys("zannathk13@gmail.com");
		Select type = new Select(driver.findElement(By.id("company_type")));
		type.selectByIndex(2);

		Select role = new Select(driver.findElement(By.id("individual_role")));
		role.selectByValue("technical/developer");

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("United States");

		driver.findElement(By.id("password")).sendKeys("life123");
		driver.findElement(By.id("password-confirmation")).sendKeys("life123");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")));
		
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]")).click();
		
		if (!driver.findElement(By.id("agree_terms")).isSelected())

		{
			driver.findElement(By.id("agree_terms")).click();
driver.quit();
		}

	}

	}
	

