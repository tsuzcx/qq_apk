import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.activity.flaotaio.FloatHbCircle;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import java.util.ArrayList;

public class glx
  extends Handler
{
  public glx(FloatHbCircle paramFloatHbCircle, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQMessageFacade.Message localMessage = null;
    int i = 0;
    if (i < FloatHbCircle.a(this.a).size())
    {
      long l = ((QQMessageFacade.Message)FloatHbCircle.a(this.a).get(i)).uniseq;
      if (paramMessage.what != (int)l) {
        break label127;
      }
      localMessage = (QQMessageFacade.Message)FloatHbCircle.a(this.a).get(i);
    }
    label127:
    for (;;)
    {
      i += 1;
      break;
      if (localMessage != null)
      {
        this.a.b(localMessage);
        Log.i("app2", "handleMessage remove=" + (int)localMessage.uniseq + "|" + localMessage.uniseq);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glx
 * JD-Core Version:    0.7.0.1
 */