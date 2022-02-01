import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;

public class fze
  extends Handler
{
  public fze(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (BusinessCmrTmpChatPie.a(this.a).isShown()) {
      BusinessCmrTmpChatPie.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fze
 * JD-Core Version:    0.7.0.1
 */