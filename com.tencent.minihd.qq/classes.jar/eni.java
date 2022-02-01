import android.app.ProgressDialog;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.manager.ServerConfigManager.ConfigType;

public class eni
  implements View.OnClickListener
{
  public eni(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = DialogUtil.a(this.a, this.a.getResources().getDrawable(2130841600), 2131367565);
    localProgressDialog.setOnDismissListener(new enj(this));
    ReportLog.a(this.a.app.getAccount());
    paramView = null;
    if (this.a.app.getSid() != null) {
      paramView = this.a.app.getSid().getBytes();
    }
    ReportLog.a(paramView);
    paramView = this.a.app.a(ServerConfigManager.ConfigType.app, "log_upload");
    if ((!TextUtils.isEmpty(paramView)) && (paramView.equals("1")))
    {
      ReportLog.a(this.a.app.a(), this.a.app.a(), localProgressDialog);
      return;
    }
    ReportLog.a(this.a.app.a(), this.a.app.a(), localProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     eni
 * JD-Core Version:    0.7.0.1
 */