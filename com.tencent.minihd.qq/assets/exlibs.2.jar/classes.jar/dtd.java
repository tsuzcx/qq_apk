import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.qphone.base.util.QLog;

public class dtd
  implements NewFriendPushListener
{
  public dtd(Conversation paramConversation) {}
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onRecommendMsgPushed");
    }
    this.a.runOnUiThread(new dte(this));
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtd
 * JD-Core Version:    0.7.0.1
 */