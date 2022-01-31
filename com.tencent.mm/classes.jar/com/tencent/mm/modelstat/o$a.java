package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class o$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78772);
    try
    {
      if (g.RJ().QU())
      {
        g.RJ();
        if (!com.tencent.mm.kernel.a.QP()) {}
      }
      else
      {
        bool = g.RJ().QU();
        g.RJ();
        ab.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.kernel.a.QP()) });
        AppMethodBeat.o(78772);
        return;
      }
      if ((paramIntent == null) || (bo.isNullOrNil(paramIntent.getAction())))
      {
        if (paramIntent == null) {}
        for (paramContext = "intent is null";; paramContext = "action is null")
        {
          ab.e("MicroMsg.NetTypeReporter", "onReceive %s  ", new Object[] { paramContext });
          AppMethodBeat.o(78772);
          return;
        }
      }
      paramContext = paramIntent.getAction();
      ab.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", new Object[] { paramContext, Boolean.valueOf(b.foreground) });
      boolean bool = b.foreground;
      if (!bool)
      {
        AppMethodBeat.o(78772);
        return;
      }
      if (paramContext.equals("android.net.wifi.supplicant.CONNECTION_CHANGE"))
      {
        o.run(1001);
        AppMethodBeat.o(78772);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      ab.e("MicroMsg.NetTypeReporter", "onReceive : %s", new Object[] { bo.l(paramContext) });
      AppMethodBeat.o(78772);
      return;
    }
    if (paramContext.equals("android.net.wifi.supplicant.STATE_CHANGE"))
    {
      o.run(1002);
      AppMethodBeat.o(78772);
      return;
    }
    if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
    {
      o.run(1003);
      AppMethodBeat.o(78772);
      return;
    }
    if (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED"))
    {
      o.run(1004);
      AppMethodBeat.o(78772);
      return;
    }
    if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
    {
      o.run(1005);
      AppMethodBeat.o(78772);
      return;
    }
    if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      o.run(1006);
      com.tencent.mm.sdk.b.a.ymk.l(new jp());
    }
    AppMethodBeat.o(78772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.a
 * JD-Core Version:    0.7.0.1
 */