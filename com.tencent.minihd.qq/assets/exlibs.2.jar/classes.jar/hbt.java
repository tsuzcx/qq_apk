import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.app.QQAppInterface;

public class hbt
  extends Handler
{
  public hbt(WidgetContainer paramWidgetContainer) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = this.a.a.app.a(0);
      WidgetContainer.a(this.a, paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbt
 * JD-Core Version:    0.7.0.1
 */