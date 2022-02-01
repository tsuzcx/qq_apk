import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class dri
  implements Handler.Callback
{
  public dri(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dri
 * JD-Core Version:    0.7.0.1
 */