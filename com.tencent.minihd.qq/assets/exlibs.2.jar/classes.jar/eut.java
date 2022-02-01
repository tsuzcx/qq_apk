import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;

public class eut
  implements DialogInterface.OnClickListener
{
  public eut(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "P_CliOper", "", "", "mp_msg_sys_16", "lixian_redelete", 0, 0, "", "", "", "");
    if (!this.a.isFinishing()) {
      this.a.showDialog(1);
    }
    paramDialogInterface = new Intent(this.a, WebProcessReceiver.class);
    paramDialogInterface.setAction("action_clear_cache");
    this.a.sendBroadcast(paramDialogInterface, "com.tencent.msg.permission.pushnotify2");
    ThreadManager.b(new euu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eut
 * JD-Core Version:    0.7.0.1
 */