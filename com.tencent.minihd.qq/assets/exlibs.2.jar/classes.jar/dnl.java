import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class dnl
  implements Runnable
{
  public dnl(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void run()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.app.getManager(86);
    localMessageRoamManager.p();
    localMessageRoamManager.c();
    localMessageRoamManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnl
 * JD-Core Version:    0.7.0.1
 */