import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class dtb
  implements Runnable
{
  public dtb(Conversation paramConversation, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(37);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation));
    localHotChatHandler.a(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo, true, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtb
 * JD-Core Version:    0.7.0.1
 */