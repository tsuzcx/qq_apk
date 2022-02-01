import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.widget.widget.WheelScroller;

public class luk
  extends GestureDetector.SimpleOnGestureListener
{
  public luk(WheelScroller paramWheelScroller) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    WheelScroller.a(this.a, 0);
    WheelScroller.a(this.a).fling(0, WheelScroller.a(this.a), 0, (int)-paramFloat2, 0, 0, -2147483647, 2147483647);
    this.a.a(0);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     luk
 * JD-Core Version:    0.7.0.1
 */