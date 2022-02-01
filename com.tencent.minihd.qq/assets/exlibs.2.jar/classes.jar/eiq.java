import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class eiq
  implements View.OnClickListener
{
  public eiq(LoginActivity paramLoginActivity) {}
  
  public void onClick(View paramView)
  {
    if (!LoginActivity.d(this.a)) {
      return;
    }
    LoginActivity.a(this.a, false);
    this.a.a.postDelayed(new eir(this), 1000L);
    paramView = new Intent(this.a, CommonWebActivity.class);
    paramView.putExtra("uin", this.a.app.a());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "https://ti.qq.com/doc/redirect/qqhd-privacy");
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eiq
 * JD-Core Version:    0.7.0.1
 */