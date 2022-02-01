import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class dfj
  implements View.OnTouchListener
{
  public dfj(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfj
 * JD-Core Version:    0.7.0.1
 */