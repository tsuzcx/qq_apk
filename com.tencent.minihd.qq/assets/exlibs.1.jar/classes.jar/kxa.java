import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AntiphingToast;
import java.util.TimerTask;

public class kxa
  extends TimerTask
{
  public kxa(AntiphingToast paramAntiphingToast) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxa
 * JD-Core Version:    0.7.0.1
 */