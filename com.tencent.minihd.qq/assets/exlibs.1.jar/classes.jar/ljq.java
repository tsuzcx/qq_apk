import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.qav.log.AVLog;

public class ljq
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      AVLog.d("AccountMonitor", String.format("onReceive action=%s", new Object[] { paramIntent.getAction() }));
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception paramContext)
    {
      AVLog.e("AccountMonitor", "onReceive fail.", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */