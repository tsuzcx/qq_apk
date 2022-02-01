import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;

public class cfx
  extends Handler
{
  public cfx(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      SensorAPIJavaScript.a(this.a, (String)paramMessage.obj);
    }
    while (paramMessage.what != 291) {
      return;
    }
    this.a.a((String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfx
 * JD-Core Version:    0.7.0.1
 */