import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

public class dpv
  implements Runnable
{
  public dpv(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l == 0) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l = 0;
    DBUtils.a(this.a.app.a(), "troop_notification_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpv
 * JD-Core Version:    0.7.0.1
 */