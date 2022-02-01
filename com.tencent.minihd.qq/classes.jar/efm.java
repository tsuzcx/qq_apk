import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.JumpActivity;

public class efm
  implements Handler.Callback
{
  public efm(JumpActivity paramJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     efm
 * JD-Core Version:    0.7.0.1
 */