import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.app.QQAppInterface;

public class hbv
  extends Handler
{
  public hbv(WidgetContainer paramWidgetContainer) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      this.a.a.app.a(4);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbv
 * JD-Core Version:    0.7.0.1
 */