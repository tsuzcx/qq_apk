import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.activity.RecentSaidActivity.ListAdapter;

public class evu
  implements View.OnTouchListener
{
  public evu(RecentSaidActivity paramRecentSaidActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 2) && ((this.a.a == null) || (this.a.a.getCount() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evu
 * JD-Core Version:    0.7.0.1
 */