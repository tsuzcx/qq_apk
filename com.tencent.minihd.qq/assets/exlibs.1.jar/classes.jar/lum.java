import com.tencent.widget.widget.WheelScroller;
import com.tencent.widget.widget.WheelScroller.ScrollingListener;
import com.tencent.widget.widget.WheelView;

public class lum
  implements WheelScroller.ScrollingListener
{
  public lum(WheelView paramWheelView) {}
  
  public void a()
  {
    WheelView.a(this.a, true);
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    WheelView.a(this.a, paramInt);
    paramInt = this.a.getHeight();
    if (WheelView.a(this.a) > paramInt)
    {
      WheelView.a(this.a, paramInt);
      WheelView.a(this.a).a();
    }
    while (WheelView.a(this.a) >= -paramInt) {
      return;
    }
    WheelView.a(this.a, -paramInt);
    WheelView.a(this.a).a();
  }
  
  public void b()
  {
    if (WheelView.a(this.a))
    {
      this.a.b();
      WheelView.a(this.a, false);
    }
    WheelView.a(this.a, 0);
    this.a.invalidate();
  }
  
  public void c()
  {
    if (Math.abs(WheelView.a(this.a)) > 1) {
      WheelView.a(this.a).a(WheelView.a(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lum
 * JD-Core Version:    0.7.0.1
 */