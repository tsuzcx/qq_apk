import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class lxb
  extends BroadcastReceiver
{
  private lxb(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(BuscardPluginInstallActivity.a(), 4, "BuscardPluginOnResumeReceiver->onReceive, intent:" + paramIntent);
    }
    if (paramIntent == null) {}
    while (!"buscard.plugin.onresume.broadcast".equals(paramIntent.getAction())) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lxb
 * JD-Core Version:    0.7.0.1
 */