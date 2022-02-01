import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class mab
  extends BroadcastReceiver
{
  private mab(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("qqwifi.plugin.onresume.broadcast".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQWiFiPluginInstallActivity.a(), 2, "WiFiPluginOnResumeReceiver, onReceive");
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mab
 * JD-Core Version:    0.7.0.1
 */