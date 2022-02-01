import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen;
import com.tencent.widget.widget.OnWheelScrollListener;
import com.tencent.widget.widget.WheelView;

public class hck
  implements OnWheelScrollListener
{
  public hck(WidgetDoyen paramWidgetDoyen) {}
  
  public void a(WheelView paramWheelView)
  {
    int i = WidgetDoyen.a(this.a).indexOfChild(paramWheelView);
    if ((i > 0) && (i != 0))
    {
      paramWheelView = (WheelView)WidgetDoyen.a(this.a).getChildAt(i - 1);
      paramWheelView.postDelayed(new hcl(this, paramWheelView), 100L);
    }
  }
  
  public void b(WheelView paramWheelView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hck
 * JD-Core Version:    0.7.0.1
 */