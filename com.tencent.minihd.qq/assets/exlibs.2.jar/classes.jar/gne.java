import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.flaotaio.TroopFloatChatPie;

public class gne
  extends Handler
{
  public gne(TroopFloatChatPie paramTroopFloatChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      TroopFloatChatPie.a(this.a, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gne
 * JD-Core Version:    0.7.0.1
 */