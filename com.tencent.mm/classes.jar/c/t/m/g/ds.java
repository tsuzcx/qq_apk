package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class ds
  extends BroadcastReceiver
{
  final dg a;
  boolean b;
  
  public ds(dg paramdg)
  {
    this.a = paramdg;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      if (paramIntent.getBooleanExtra("noConnectivity", false))
      {
        this.a.b(Integer.valueOf(-1));
        return;
      }
    }
    catch (Exception paramContext)
    {
      j.a("TxNetworkStateMonitor", "listenNetworkState: Exception", paramContext);
      return;
    }
    if (j.e(paramContext))
    {
      this.a.b(Integer.valueOf(1));
      return;
    }
    this.a.b(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.ds
 * JD-Core Version:    0.7.0.1
 */