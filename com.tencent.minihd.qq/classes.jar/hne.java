import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;

public class hne
  implements OnPluginInstallListener
{
  public hne(QQAppInterface paramQQAppInterface) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(QQAppInterface.b, 4, "onInstallBegin, pluginId:" + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(QQAppInterface.b, 4, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.a.a = true;
    if (QLog.isDevelopLevel()) {
      QLog.i(QQAppInterface.b, 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.a = true;
    if (QLog.isDevelopLevel()) {
      QLog.i(QQAppInterface.b, 4, "onInstallFinish, pluginId:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hne
 * JD-Core Version:    0.7.0.1
 */