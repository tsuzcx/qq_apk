package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gp.a;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class j$10
  extends c<gp>
{
  j$10(j paramj)
  {
    AppMethodBeat.i(20750);
    this.__eventId = gp.class.getName().hashCode();
    AppMethodBeat.o(20750);
  }
  
  private static boolean a(gp arg0)
  {
    AppMethodBeat.i(20751);
    String str1;
    f.b localb;
    if ((???.cvB.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.bAf()))
    {
      str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
      localb = f.a.bAG().bAE();
      if ((localb != null) && (!localb.mKr) && (System.currentTimeMillis() - localb.mKe <= 180000L) && (!m.isEmpty(localb.mKp)) && (!m.isEmpty(localb.mKo)) && (!m.isEmpty(localb.mKq))) {
        break label114;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(20751);
      return false;
      label114:
      ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.mKo, localb.mKp, localb.mKq, Long.valueOf(localb.mKe) });
      ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
      String str3 = m.Ow("MicroMsg.FreeWifi.Protocol31Handler");
      if (m.Ou(localb.mKo).equals(str3))
      {
        String str4 = m.Ox("MicroMsg.FreeWifi.Protocol31Handler");
        String str5 = m.Oy("MicroMsg.FreeWifi.Protocol31Handler");
        synchronized (f.a.bAG())
        {
          if (localb == f.a.bAG().bAE()) {}
        }
        ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
        new g(str3, str4, str5).c(new c.1(str2, localb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.10
 * JD-Core Version:    0.7.0.1
 */