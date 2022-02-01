import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.adapter.WebBaseFacePreloadExpandableListAdapter;

public class hfx
  extends Handler
{
  public hfx(WebBaseFacePreloadExpandableListAdapter paramWebBaseFacePreloadExpandableListAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hfx
 * JD-Core Version:    0.7.0.1
 */