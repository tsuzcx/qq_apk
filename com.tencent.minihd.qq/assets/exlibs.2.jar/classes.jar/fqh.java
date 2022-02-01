import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.permission.PermissionCallback;

class fqh
  implements PermissionCallback
{
  fqh(fqe paramfqe, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new fqi(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PlusPanelUtils.a(this.jdField_a_of_type_Fqe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Fqe.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Fqe.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_a_of_type_Fqe.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_Fqe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C09", "0X8004C09", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fqh
 * JD-Core Version:    0.7.0.1
 */