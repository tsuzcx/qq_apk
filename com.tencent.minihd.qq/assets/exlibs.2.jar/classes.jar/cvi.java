import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.network.module.common.b;
import com.tencent.component.network.utils.thread.PriorityThreadPool;

public class cvi
  extends BroadcastReceiver
{
  public cvi(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      PriorityThreadPool.a().a(new cvj(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cvi
 * JD-Core Version:    0.7.0.1
 */