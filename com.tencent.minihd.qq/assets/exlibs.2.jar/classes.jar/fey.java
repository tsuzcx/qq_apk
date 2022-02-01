import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class fey
  implements View.OnFocusChangeListener
{
  public fey(SubLoginActivity paramSubLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      SubLoginActivity.a(this.a).setSelection(SubLoginActivity.a(this.a).getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fey
 * JD-Core Version:    0.7.0.1
 */