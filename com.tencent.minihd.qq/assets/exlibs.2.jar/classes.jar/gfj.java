import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class gfj
  implements MessageQueue.IdleHandler
{
  public gfj(AddContactsActivity paramAddContactsActivity) {}
  
  public boolean queueIdle()
  {
    this.a.a.sendEmptyMessage(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfj
 * JD-Core Version:    0.7.0.1
 */