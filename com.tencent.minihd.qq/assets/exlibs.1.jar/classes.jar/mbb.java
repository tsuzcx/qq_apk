import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

class mbb
  extends OnPluginInstallListener.Stub
{
  mbb(mba parammba) {}
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, Thread.currentThread().getName() + ":" + paramString + "：插件安装开始");
    }
    QZoneHelper.a(0);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, Thread.currentThread().getName() + ":" + paramString + "：插件安装错误");
    }
    QZoneHelper.a(-1);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, Thread.currentThread().getName() + ":" + paramString + "：插件安装完成");
    }
    QZoneHelper.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbb
 * JD-Core Version:    0.7.0.1
 */