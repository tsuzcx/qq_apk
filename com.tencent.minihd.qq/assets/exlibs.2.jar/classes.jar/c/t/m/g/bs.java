package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

public final class bs
  extends BroadcastReceiver
{
  private final bf a;
  private Handler b;
  
  public bs(bf parambf)
  {
    this.a = parambf;
  }
  
  private Handler b()
  {
    try
    {
      Handler localHandler = this.b;
      return localHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(Handler paramHandler)
  {
    try
    {
      this.b = paramHandler;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  public final void a()
  {
    try
    {
      this.a.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void a(Handler paramHandler)
  {
    IntentFilter localIntentFilter;
    if (!b.a.a(paramHandler)) {
      localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }
    try
    {
      this.a.a.registerReceiver(this, localIntentFilter, null, paramHandler);
      b(paramHandler);
      return;
    }
    catch (Exception paramHandler)
    {
      cj.a("TxNetworkStateMonitor", "listenNetworkState: failed", paramHandler);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (b.a.a(paramIntent)) {
      return;
    }
    boolean bool = b.a.b(paramContext);
    paramContext = b();
    if ((bool) && (b.a.b(paramContext)))
    {
      paramContext.removeMessages(7999);
      paramContext.sendEmptyMessageDelayed(7999, 3000L);
    }
    paramIntent = new StringBuilder("onReceive: network is ");
    if (bool) {}
    for (paramContext = "connected";; paramContext = "disconnected")
    {
      cj.a("TxNetworkStateMonitor", paramContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bs
 * JD-Core Version:    0.7.0.1
 */