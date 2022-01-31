package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.jg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class o$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        if (g.DN().Dc())
        {
          g.DN();
          if (!com.tencent.mm.kernel.a.CW()) {}
        }
        else
        {
          boolean bool = g.DN().Dc();
          g.DN();
          y.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.kernel.a.CW()) });
          return;
        }
        if ((paramIntent != null) && (!bk.bl(paramIntent.getAction()))) {
          break;
        }
        if (paramIntent == null)
        {
          paramContext = "intent is null";
          y.e("MicroMsg.NetTypeReporter", "onReceive %s  ", new Object[] { paramContext });
          return;
        }
      }
      catch (Throwable paramContext)
      {
        y.e("MicroMsg.NetTypeReporter", "onReceive : %s", new Object[] { bk.j(paramContext) });
        return;
      }
      paramContext = "action is null";
    }
    paramContext = paramIntent.getAction();
    y.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", new Object[] { paramContext, Boolean.valueOf(b.foreground) });
    if (b.foreground)
    {
      if (paramContext.equals("android.net.wifi.supplicant.CONNECTION_CHANGE"))
      {
        o.jl(1001);
        return;
      }
      if (paramContext.equals("android.net.wifi.supplicant.STATE_CHANGE"))
      {
        o.jl(1002);
        return;
      }
      if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
      {
        o.jl(1003);
        return;
      }
      if (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED"))
      {
        o.jl(1004);
        return;
      }
      if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
      {
        o.jl(1005);
        return;
      }
      if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        o.jl(1006);
        com.tencent.mm.sdk.b.a.udP.m(new jg());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.a
 * JD-Core Version:    0.7.0.1
 */