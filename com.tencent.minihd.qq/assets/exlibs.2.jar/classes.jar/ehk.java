import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class ehk
  implements TextView.OnEditorActionListener
{
  public ehk(LoginActivity paramLoginActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (LoginActivity.a(this.a) != null) {
      LoginActivity.a(this.a).performClick();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehk
 * JD-Core Version:    0.7.0.1
 */