import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ForwardOperations;

public class dzp
  implements Handler.Callback
{
  public dzp(ForwardOperations paramForwardOperations) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    ForwardOperations.a(this.a).sendEmptyMessage(1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzp
 * JD-Core Version:    0.7.0.1
 */