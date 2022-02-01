package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class i$3
  implements cj.a
{
  i$3(i parami) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(25384);
    Log.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = z.a(parama.heO.KHn);
    if ((parama == null) || (parama.length() == 0))
    {
      Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25384);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
      AppMethodBeat.o(25384);
      return;
    }
    if (parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
    {
      int i = Util.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      Log.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        parama = new g(2);
        bg.azz().a(parama, 0);
      }
    }
    AppMethodBeat.o(25384);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.3
 * JD-Core Version:    0.7.0.1
 */