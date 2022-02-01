import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;

public class edy
  implements View.OnTouchListener
{
  public edy(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      HongbaoShowerActivity.a(this.a, true);
      return false;
    }
    HongbaoShowerActivity.a(this.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edy
 * JD-Core Version:    0.7.0.1
 */