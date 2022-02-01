import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import mqq.app.permission.PermissionCallback;

class knc
  implements PermissionCallback
{
  knc(knb paramknb, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new knd(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    com.tencent.mobileqq.troop.widget.AvatarWallAdapter.a = ProfileActivity.a(this.jdField_a_of_type_Knb.a, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knc
 * JD-Core Version:    0.7.0.1
 */