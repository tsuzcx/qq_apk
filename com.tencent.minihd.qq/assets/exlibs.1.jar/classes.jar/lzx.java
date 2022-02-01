import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class lzx
  implements OnPluginInstallListener
{
  public lzx(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQWiFiPluginInstallActivity.a(), 2, "onInstallBegin, pluginId:" + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
    paramInt1 = (int)(paramInt1 * 100.0F / paramInt2);
    this.a.runOnUiThread(new lzy(this, paramInt1));
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQWiFiPluginInstallActivity.a(), 2, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    this.a.runOnUiThread(new lzz(this));
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(QQWiFiPluginInstallActivity.a(), 2, "onInstallFinish, pluginId:" + paramString);
    }
    QQWiFiPluginInstallActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzx
 * JD-Core Version:    0.7.0.1
 */