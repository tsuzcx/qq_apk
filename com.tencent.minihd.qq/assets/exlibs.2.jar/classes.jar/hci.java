import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen;
import com.tencent.widget.widget.OnWheelClickedListener;
import com.tencent.widget.widget.WheelView;

public class hci
  implements OnWheelClickedListener
{
  public hci(WidgetDoyen paramWidgetDoyen) {}
  
  public void a(WheelView paramWheelView, int paramInt)
  {
    if (WidgetDoyen.a(this.a) != null) {
      WidgetDoyen.a(this.a).onClick(paramWheelView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hci
 * JD-Core Version:    0.7.0.1
 */