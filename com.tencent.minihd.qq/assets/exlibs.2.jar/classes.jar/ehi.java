import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class ehi
  implements View.OnClickListener
{
  public ehi(LoginActivity paramLoginActivity) {}
  
  public void onClick(View paramView)
  {
    LoginActivity.a(this.a, ((Integer)paramView.getTag()).intValue());
    this.a.showDialog(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehi
 * JD-Core Version:    0.7.0.1
 */