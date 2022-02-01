import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class exq
  implements View.OnClickListener
{
  public exq(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    if (!RegisterPhoneNumActivity.a(this.a)) {
      return;
    }
    RegisterPhoneNumActivity.a(this.a, false);
    this.a.b.postDelayed(new exr(this), 1000L);
    paramView = new Intent(this.a, CommonWebActivity.class);
    paramView.putExtra("uin", this.a.app.a());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "https://ti.qq.com/doc/redirect/qqhd-privacy");
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exq
 * JD-Core Version:    0.7.0.1
 */