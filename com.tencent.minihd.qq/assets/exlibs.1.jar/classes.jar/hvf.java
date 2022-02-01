import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class hvf
  extends Handler
{
  private QQAnimationDrawable a;
  
  public hvf(QQAnimationDrawable paramQQAnimationDrawable)
  {
    this.a = paramQQAnimationDrawable;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof Long)) {
      this.a.scheduleSelf(this.a, ((Long)paramMessage.obj).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvf
 * JD-Core Version:    0.7.0.1
 */