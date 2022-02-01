import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class dpy
  implements Runnable
{
  public dpy(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
      ChatSettingForTroop.a(this.a, "https://qqweb.qq.com/cgi-bin/qqactivity/unset_red_point", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, 1, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpy
 * JD-Core Version:    0.7.0.1
 */