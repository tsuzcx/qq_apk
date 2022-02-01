import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;

public class dic
  implements MessageQueue.IdleHandler
{
  public dic(BaseChatPie paramBaseChatPie) {}
  
  public boolean queueIdle()
  {
    BaseChatPie.a(this.a, this.a.a.getIntent());
    this.a.Q();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dic
 * JD-Core Version:    0.7.0.1
 */