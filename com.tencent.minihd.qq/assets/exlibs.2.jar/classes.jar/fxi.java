import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;

public class fxi
  extends Handler
{
  public fxi(ThumbItemBuilder paramThumbItemBuilder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ThumbItemBuilder.a) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxi
 * JD-Core Version:    0.7.0.1
 */