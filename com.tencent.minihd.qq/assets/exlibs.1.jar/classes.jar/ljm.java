import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qav.log.AVLog;

public class ljm
  extends BroadcastReceiver
{
  public ljm(QavStateManager paramQavStateManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    AVLog.d("QavStateManager", String.format("onReceive action=%s", new Object[] { paramContext }));
    if (paramContext.equals("qav.Action.QavService.Start")) {
      QavStateManager.b(this.a);
    }
    while (!paramContext.equals("tencent.video.v2q.SmallScreenState")) {
      return;
    }
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    QavStateManager.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */