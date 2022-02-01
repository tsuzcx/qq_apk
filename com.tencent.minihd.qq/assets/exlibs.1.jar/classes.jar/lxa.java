import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class lxa
  implements OnPluginInstallListener
{
  public lxa(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallBegin, pluginId:" + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    BuscardPluginInstallActivity.a(this.a, false);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(BuscardPluginInstallActivity.a(), 4, "onInstallFinish, pluginId:" + paramString);
    }
    BuscardPluginInstallActivity.a(this.a, "onInstallFinish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lxa
 * JD-Core Version:    0.7.0.1
 */