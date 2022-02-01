package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.hq.a;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

final class j$10
  extends c<hq>
{
  j$10(j paramj)
  {
    AppMethodBeat.i(161374);
    this.__eventId = hq.class.getName().hashCode();
    AppMethodBeat.o(161374);
  }
  
  private static boolean a(hq arg0)
  {
    AppMethodBeat.i(24822);
    String str1;
    f.b localb;
    if ((???.diI.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.cIF()))
    {
      str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
      localb = f.a.cJg().cJe();
      if ((localb != null) && (!localb.sqp) && (System.currentTimeMillis() - localb.sqc <= 180000L) && (!m.cX(localb.sqn)) && (!m.cX(localb.sqm)) && (!m.cX(localb.sqo))) {
        break label114;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24822);
      return false;
      label114:
      ac.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.sqm, localb.sqn, localb.sqo, Long.valueOf(localb.sqc) });
      ac.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
      String str3 = m.afm("MicroMsg.FreeWifi.Protocol31Handler");
      if (m.afk(localb.sqm).equals(str3))
      {
        String str4 = m.afn("MicroMsg.FreeWifi.Protocol31Handler");
        String str5 = m.afo("MicroMsg.FreeWifi.Protocol31Handler");
        synchronized (f.a.cJg())
        {
          if (localb == f.a.cJg().cJe()) {}
        }
        ac.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
        new g(str3, str4, str5).c(new c.1(str2, localb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.10
 * JD-Core Version:    0.7.0.1
 */