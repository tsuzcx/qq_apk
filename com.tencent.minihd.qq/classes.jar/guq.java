import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qlink.QQProxyForQlink;

public class guq
  implements View.OnClickListener
{
  public guq(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).app.a().a("0X800474F", 1);
    QQProxyForQlink.a(BannerManager.a(this.a), 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guq
 * JD-Core Version:    0.7.0.1
 */