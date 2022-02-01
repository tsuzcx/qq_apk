package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class o$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151115);
    try
    {
      if (g.ajP().aiZ())
      {
        g.ajP();
        if (!com.tencent.mm.kernel.a.aiT()) {}
      }
      else
      {
        bool = g.ajP().aiZ();
        g.ajP();
        ae.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.kernel.a.aiT()) });
        AppMethodBeat.o(151115);
        return;
      }
      if ((paramIntent == null) || (bu.isNullOrNil(paramIntent.getAction())))
      {
        if (paramIntent == null) {}
        for (paramContext = "intent is null";; paramContext = "action is null")
        {
          ae.e("MicroMsg.NetTypeReporter", "onReceive %s  ", new Object[] { paramContext });
          AppMethodBeat.o(151115);
          return;
        }
      }
      paramContext = paramIntent.getAction();
      ae.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", new Object[] { paramContext, Boolean.valueOf(b.foreground) });
      boolean bool = b.foreground;
      if (!bool)
      {
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.wifi.supplicant.CONNECTION_CHANGE"))
      {
        o.run(1001);
        AppMethodBeat.o(151115);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      ae.e("MicroMsg.NetTypeReporter", "onReceive : %s", new Object[] { bu.o(paramContext) });
      AppMethodBeat.o(151115);
      return;
    }
    if (paramContext.equals("android.net.wifi.supplicant.STATE_CHANGE"))
    {
      o.run(1002);
      AppMethodBeat.o(151115);
      return;
    }
    if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
    {
      o.run(1003);
      AppMethodBeat.o(151115);
      return;
    }
    if (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED"))
    {
      o.run(1004);
      AppMethodBeat.o(151115);
      return;
    }
    if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
    {
      o.run(1005);
      AppMethodBeat.o(151115);
      return;
    }
    if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      o.run(1006);
      com.tencent.mm.sdk.b.a.IvT.l(new ll());
    }
    AppMethodBeat.o(151115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.a
 * JD-Core Version:    0.7.0.1
 */