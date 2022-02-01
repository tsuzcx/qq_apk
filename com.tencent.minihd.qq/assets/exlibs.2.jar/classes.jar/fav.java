import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.SoftInputActivity;

public class fav
  implements TextView.OnEditorActionListener
{
  public fav(SoftInputActivity paramSoftInputActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = SoftInputActivity.a(this.a).getText().toString();
      if (!TextUtils.isEmpty(paramTextView))
      {
        paramKeyEvent = new Intent("do_search_text");
        paramKeyEvent.putExtra("keyword", paramTextView);
        this.a.sendBroadcast(paramKeyEvent);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fav
 * JD-Core Version:    0.7.0.1
 */