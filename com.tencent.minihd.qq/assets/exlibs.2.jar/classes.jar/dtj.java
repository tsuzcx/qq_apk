import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.managers.LoadingStateManager;

public class dtj
  extends Handler
{
  public dtj(Conversation paramConversation) {}
  
  public void handleMessage(Message paramMessage)
  {
    LoadingStateManager.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      Conversation.a(this.a, 1134013, 0L, false);
      return;
    }
    Conversation.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtj
 * JD-Core Version:    0.7.0.1
 */