import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class lwx
  implements Runnable
{
  public lwx(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public void run()
  {
    PluginInfo localPluginInfo = null;
    int i = 0;
    for (;;)
    {
      if (i < 300)
      {
        localPluginInfo = BuscardPluginInstallActivity.a(this.a).a("BuscardPlugin.apk");
        if ((localPluginInfo == null) && (!BuscardPluginInstallActivity.a(this.a).isReady())) {}
        try
        {
          Thread.sleep(100L);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      if (localPluginInfo == null) {
        break label190;
      }
      QLog.i(BuscardPluginInstallActivity.a(), 4, "pluginInfo.mState=" + localPluginInfo.mState);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(BuscardPluginInstallActivity.a(), 4, "mPluginManager.isReady()=" + BuscardPluginInstallActivity.a(this.a).isReady());
      }
      if (localPluginInfo != null) {
        break;
      }
      if (BuscardPluginInstallActivity.a(this.a).isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(BuscardPluginInstallActivity.a(), 4, "fail to load plugin");
        }
        BuscardPluginInstallActivity.a(this.a, false);
        this.a.finish();
      }
      return;
      label190:
      QLog.i(BuscardPluginInstallActivity.a(), 4, "pluginInfo is null");
    }
    BuscardPluginInstallActivity.a(this.a).post(new lwy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lwx
 * JD-Core Version:    0.7.0.1
 */