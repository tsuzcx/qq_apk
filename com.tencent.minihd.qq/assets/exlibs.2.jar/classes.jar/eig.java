import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

public class eig
  implements TextWatcher
{
  public eig(LoginActivity paramLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (LoginActivity.a(this.a) != null) {
        LoginActivity.a(this.a).setVisibility(0);
      }
    }
    while (paramCharSequence.length() > 4)
    {
      this.a.a(paramCharSequence.toString());
      return;
      if ((LoginActivity.a(this.a) != null) && (LoginActivity.a(this.a).isShown())) {
        LoginActivity.a(this.a).setVisibility(8);
      }
    }
    LoginActivity.b(this.a).setImageResource(2130838535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eig
 * JD-Core Version:    0.7.0.1
 */