import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.DLRouterActivity;

public class k
  implements View.OnTouchListener
{
  public k(DLRouterActivity paramDLRouterActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      DLRouterActivity.a(this.a).setVisibility(8);
      DLRouterActivity.a(this.a).setImageResource(2130837573);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     k
 * JD-Core Version:    0.7.0.1
 */