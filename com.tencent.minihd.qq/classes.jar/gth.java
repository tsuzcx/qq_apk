import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class gth
  implements MessageQueue.IdleHandler
{
  public gth(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    ThreadManager.c(new gtl(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gth
 * JD-Core Version:    0.7.0.1
 */