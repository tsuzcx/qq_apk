import android.os.IBinder;
import android.os.Process;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class lzu
  implements OnPluginInstallListener
{
  public lzu(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "mPluginBackgroundInstallListener, onInstallBegin");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "mPluginBackgroundInstallListener, onInstallDownloadProgress");
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "mPluginBackgroundInstallListener, onInstallError");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "mPluginBackgroundInstallListener, onInstallFinish, " + Process.myPid());
    }
    this.a.runOnUiThread(new lzv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzu
 * JD-Core Version:    0.7.0.1
 */