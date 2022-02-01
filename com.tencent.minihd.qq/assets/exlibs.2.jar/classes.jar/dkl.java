import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class dkl
  implements Runnable
{
  public dkl(Call paramCall, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityCall.app.a(37);
    this.jdField_a_of_type_ComTencentMobileqqActivityCall.app.a(Call.a(this.jdField_a_of_type_ComTencentMobileqqActivityCall));
    localHotChatHandler.a(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo, true, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkl
 * JD-Core Version:    0.7.0.1
 */