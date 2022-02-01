import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class gck
  implements Runnable
{
  public gck(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopNotificationHelper.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, TroopNewcomerNoticeActivity.class);
    localIntent.putExtra("troop_friend_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968769, 2130968770);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gck
 * JD-Core Version:    0.7.0.1
 */