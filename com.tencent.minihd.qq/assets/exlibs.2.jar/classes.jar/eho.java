import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class eho
  implements View.OnFocusChangeListener
{
  public eho(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      LoginActivity.a(this.a);
      LoginActivity.a(this.a).setSelection(LoginActivity.a(this.a).getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eho
 * JD-Core Version:    0.7.0.1
 */