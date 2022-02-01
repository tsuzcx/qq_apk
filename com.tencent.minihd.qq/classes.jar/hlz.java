import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class hlz
  implements Runnable
{
  public hlz(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    Handler localHandler = MessageRoamManager.a(this.a).a(ChatHistoryForC2C.class);
    if (MessageRoamManager.b(this.a)) {}
    for (Message localMessage = localHandler.obtainMessage(24);; localMessage = localHandler.obtainMessage(25))
    {
      localHandler.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlz
 * JD-Core Version:    0.7.0.1
 */