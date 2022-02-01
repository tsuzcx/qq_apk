import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class eik
  implements View.OnClickListener
{
  public eik(LoginActivity paramLoginActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LoginActivity.a(this.a) != null) && (LoginActivity.a(this.a).isShown())) {
      LoginActivity.a(this.a).setVisibility(8);
    }
    LoginActivity.a(this.a).setText("");
    LoginActivity.a(this.a).setText("");
    libsafeedit.clearPassBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eik
 * JD-Core Version:    0.7.0.1
 */