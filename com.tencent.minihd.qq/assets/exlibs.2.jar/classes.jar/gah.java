import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import mqq.app.permission.PermissionCallback;

class gah
  implements PermissionCallback
{
  gah(gag paramgag, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new gai(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PlusPanelUtils.a(FriendChatPie.a(this.jdField_a_of_type_Gag.a), this.jdField_a_of_type_Gag.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Gag.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Gag.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.jdField_a_of_type_Gag.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gah
 * JD-Core Version:    0.7.0.1
 */