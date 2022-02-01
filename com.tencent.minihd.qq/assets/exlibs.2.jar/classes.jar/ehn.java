import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

public class ehn
  implements View.OnFocusChangeListener
{
  public ehn(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      LoginActivity.a(this.a);
      if (LoginActivity.a(this.a).isPopupShowing()) {
        LoginActivity.a(this.a).dismissDropDown();
      }
      if ((LoginActivity.a(this.a) != null) && (LoginActivity.a(this.a).getText().length() > 0)) {
        LoginActivity.a(this.a).setVisibility(0);
      }
      LoginActivity.a(this.a).setSelection(LoginActivity.a(this.a).getText().length());
    }
    while ((LoginActivity.a(this.a) == null) || (!LoginActivity.a(this.a).isShown())) {
      return;
    }
    LoginActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehn
 * JD-Core Version:    0.7.0.1
 */