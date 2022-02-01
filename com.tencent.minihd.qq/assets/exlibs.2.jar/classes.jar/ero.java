import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class ero
  implements View.OnTouchListener
{
  public ero(QQBrowserActivity paramQQBrowserActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQBrowserActivity.a(this.a).setVisibility(8);
    QQBrowserActivity.b(this.a).setVisibility(8);
    this.a.b.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ero
 * JD-Core Version:    0.7.0.1
 */