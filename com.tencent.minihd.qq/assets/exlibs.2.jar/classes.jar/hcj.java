import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen;

public class hcj
  implements View.OnClickListener
{
  public hcj(WidgetDoyen paramWidgetDoyen) {}
  
  public void onClick(View paramView)
  {
    if (WidgetDoyen.a(this.a) != null) {
      WidgetDoyen.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcj
 * JD-Core Version:    0.7.0.1
 */