import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;

public class hjm
  extends hkd
{
  private String a;
  
  public hjm()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    super.a();
    if (this.b >= 3L)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(1);
      this.b = 0L;
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.minihd.qq".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.minihd.qq".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjm
 * JD-Core Version:    0.7.0.1
 */