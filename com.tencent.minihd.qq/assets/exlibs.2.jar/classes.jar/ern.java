import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class ern
  implements View.OnTouchListener
{
  public ern(QQBrowserActivity paramQQBrowserActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQBrowserActivity.a(this.a).setVisibility(8);
    QQBrowserActivity.b(this.a).setVisibility(8);
    this.a.b.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ern
 * JD-Core Version:    0.7.0.1
 */