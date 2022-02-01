import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public final class mad
  implements Runnable
{
  public void run()
  {
    Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qwallet_plugin.apk";
    localPluginParams.d = "Wallet";
    localPluginParams.e = "com.qwallet.receiver.QWallPreloadReceiver";
    localPluginParams.a = localIntent;
    IPluginManager.a(BaseApplicationImpl.getContext(), localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mad
 * JD-Core Version:    0.7.0.1
 */