import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class krt
  implements Handler.Callback
{
  public krt(JumpAction paramJumpAction) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    ((BaseActivity)JumpAction.a(this.a)).finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     krt
 * JD-Core Version:    0.7.0.1
 */