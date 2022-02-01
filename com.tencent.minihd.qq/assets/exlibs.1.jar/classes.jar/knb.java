import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class knb
  implements ActionSheet.OnButtonClickListener
{
  public knb(AvatarWallAdapter paramAvatarWallAdapter, Activity paramActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = (SplashActivity)SplashActivity.a();
      if ((!paramView.permissionManager.checkPermission("android.permission.CAMERA")) || (!paramView.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new knc(this, paramView));
      }
      else
      {
        AvatarWallAdapter.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 15);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_AndroidAppActivity, 8 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knb
 * JD-Core Version:    0.7.0.1
 */