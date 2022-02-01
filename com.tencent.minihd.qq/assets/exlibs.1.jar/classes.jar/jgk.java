import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.model.TroopInfoManager;

public class jgk
  extends Handler
{
  public jgk(TroopInfoManager paramTroopInfoManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopInfoManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgk
 * JD-Core Version:    0.7.0.1
 */