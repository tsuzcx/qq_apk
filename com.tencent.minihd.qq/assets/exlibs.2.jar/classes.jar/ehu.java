import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView.DropdownViewDropIconClickListner;

public class ehu
  implements DropdownView.DropdownViewDropIconClickListner
{
  public ehu(LoginActivity paramLoginActivity) {}
  
  public void a(boolean paramBoolean)
  {
    LoginActivity.a(this.a).clearFocus();
    LoginActivity.a(this.a).clearFocus();
    if (LoginActivity.a(this.a))
    {
      LoginActivity.c(this.a);
      return;
    }
    LoginActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehu
 * JD-Core Version:    0.7.0.1
 */