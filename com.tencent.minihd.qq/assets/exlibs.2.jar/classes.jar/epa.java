import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQBrowserLinkSpan;

public class epa
  extends QQBrowserLinkSpan
{
  public epa(PermisionPrivacyActivity paramPermisionPrivacyActivity, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004E73", "0X8004E73", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     epa
 * JD-Core Version:    0.7.0.1
 */