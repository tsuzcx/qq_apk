package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class h$1
  implements cl.a
{
  h$1(h paramh) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(25383);
    Log.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = w.a(parama.mpN.YFG);
    if ((parama == null) || (parama.length() == 0))
    {
      Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25383);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
      AppMethodBeat.o(25383);
      return;
    }
    if (parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
    {
      int i = Util.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      Log.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        parama = new g(2);
        bh.aZW().a(parama, 0);
      }
    }
    AppMethodBeat.o(25383);
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.1
 * JD-Core Version:    0.7.0.1
 */