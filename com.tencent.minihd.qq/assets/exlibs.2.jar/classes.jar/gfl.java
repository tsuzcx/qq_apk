import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.permission.PermissionCallback;

public class gfl
  implements PermissionCallback
{
  public gfl(AddContactsView paramAddContactsView, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new gfm(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayOfString);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfl
 * JD-Core Version:    0.7.0.1
 */