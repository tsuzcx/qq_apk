import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.widget.widget.WheelScroller;
import com.tencent.widget.widget.WheelScroller.ScrollingListener;

public class lul
  extends Handler
{
  public lul(WheelScroller paramWheelScroller) {}
  
  public void handleMessage(Message paramMessage)
  {
    WheelScroller.a(this.a).computeScrollOffset();
    int i = WheelScroller.a(this.a).getCurrY();
    int j = WheelScroller.a(this.a) - i;
    WheelScroller.a(this.a, i);
    if (j != 0) {
      WheelScroller.a(this.a).a(j);
    }
    if (Math.abs(i - WheelScroller.a(this.a).getFinalY()) < 1)
    {
      WheelScroller.a(this.a).getFinalY();
      WheelScroller.a(this.a).forceFinished(true);
    }
    if (!WheelScroller.a(this.a).isFinished())
    {
      WheelScroller.a(this.a).sendEmptyMessage(paramMessage.what);
      return;
    }
    if (paramMessage.what == 0)
    {
      WheelScroller.a(this.a);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lul
 * JD-Core Version:    0.7.0.1
 */