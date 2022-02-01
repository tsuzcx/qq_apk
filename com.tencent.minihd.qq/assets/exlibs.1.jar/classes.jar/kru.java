import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class kru
  implements Handler.Callback
{
  public kru(JumpAction paramJumpAction) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    ((BaseActivity)JumpAction.a(this.a)).finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kru
 * JD-Core Version:    0.7.0.1
 */