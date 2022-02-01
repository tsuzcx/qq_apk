import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qav.ipc.IQavService;
import com.tencent.qav.ipc.IQavService.Stub;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qav.log.AVLog;

public class ljo
  implements ServiceConnection
{
  private ljo(QavStateManager paramQavStateManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AVLog.d("QavStateManager", String.format("onServiceConnected this=%s service=%s", new Object[] { this.a, paramIBinder }));
    QavStateManager.a(this.a, IQavService.Stub.a(paramIBinder));
    QavStateManager.a(this.a, false);
    try
    {
      QavStateManager.a(this.a).a(QavStateManager.a(this.a));
      QavStateManager.a(this.a).asBinder().linkToDeath(this.a, 0);
      return;
    }
    catch (Exception paramComponentName)
    {
      AVLog.d("QavStateManager", "onServiceConnected fail.", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AVLog.d("QavStateManager", "onServiceDisconnected");
    if (QavStateManager.a(this.a) != null) {}
    try
    {
      QavStateManager.a(this.a).asBinder().unlinkToDeath(this.a, 0);
      QavStateManager.a(this.a, null);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        AVLog.e("QavStateManager", "onServiceDisconnected fail.", paramComponentName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljo
 * JD-Core Version:    0.7.0.1
 */