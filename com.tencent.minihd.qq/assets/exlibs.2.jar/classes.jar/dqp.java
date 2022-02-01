import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class dqp
  implements DialogInterface.OnClickListener
{
  public dqp(ChatSettingForTroop paramChatSettingForTroop, BizTroopHandler paramBizTroopHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.d, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.c, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqp
 * JD-Core Version:    0.7.0.1
 */