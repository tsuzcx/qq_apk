import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class eej
  implements Runnable
{
  public eej(HotChatListActivity paramHotChatListActivity, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.app.a(37)).a(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo, false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eej
 * JD-Core Version:    0.7.0.1
 */