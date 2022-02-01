import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class gtq
  implements TextView.OnEditorActionListener
{
  public gtq(SendHbActivity paramSendHbActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (SendHbActivity.a(this.a).isEnabled()) {
        SendHbActivity.a(this.a).performClick();
      }
      ((InputMethodManager)SendHbActivity.a(this.a).getSystemService("input_method")).hideSoftInputFromWindow(SendHbActivity.c(this.a).getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gtq
 * JD-Core Version:    0.7.0.1
 */