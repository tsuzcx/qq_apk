import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.widgets.ActiveSearchTipsContainer;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;

public class cqt
  extends Handler
{
  public cqt(ActiveSearchTipsContainer paramActiveSearchTipsContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ActiveSearchTipsContainer.a(this.a) != null)
    {
      if (paramMessage.obj != null) {
        ActiveSearchTipsContainer.a(this.a).a((String)paramMessage.obj);
      }
    }
    else {
      return;
    }
    ActiveSearchTipsContainer.a(this.a).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqt
 * JD-Core Version:    0.7.0.1
 */