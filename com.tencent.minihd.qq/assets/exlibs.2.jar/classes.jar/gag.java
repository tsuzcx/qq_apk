import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class gag
  implements View.OnClickListener
{
  public gag(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.h = true;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    paramView = (SplashActivity)SplashActivity.a();
    if ((!paramView.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!paramView.permissionManager.checkPermission("android.permission.CAMERA")))
    {
      paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new gah(this, paramView));
      return;
    }
    PlusPanelUtils.a(FriendChatPie.b(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gag
 * JD-Core Version:    0.7.0.1
 */