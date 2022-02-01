import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.DropdownView;

public class ehm
  implements View.OnTouchListener
{
  public ehm(LoginActivity paramLoginActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((LoginActivity.a(this.a)) && (!LoginActivity.b(this.a)) && (!LoginActivity.c(this.a)))
    {
      LoginActivity.d(this.a, false);
      LoginActivity.c(this.a);
      LoginActivity.a(this.a).setDropIconViewUp();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehm
 * JD-Core Version:    0.7.0.1
 */