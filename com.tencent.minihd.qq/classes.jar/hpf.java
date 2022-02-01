import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;

public class hpf
  implements View.OnClickListener
{
  public hpf(ScreenShot paramScreenShot) {}
  
  public void onClick(View paramView)
  {
    ScreenShot.a(this.a);
    ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
    if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
      KapalaiAdapterUtil.a().b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpf
 * JD-Core Version:    0.7.0.1
 */