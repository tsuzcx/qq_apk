package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

final class i$3
  implements cd.a
{
  i$3(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(25384);
    ad.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = z.a(parama.gqE.Fvk);
    if ((parama == null) || (parama.length() == 0))
    {
      ad.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25384);
      return;
    }
    parama = bw.M(parama, "sysmsg");
    if (parama == null)
    {
      ad.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
      AppMethodBeat.o(25384);
      return;
    }
    if (parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
    {
      int i = bt.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      ad.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        parama = new g(2);
        ba.aiU().a(parama, 0);
      }
    }
    AppMethodBeat.o(25384);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.3
 * JD-Core Version:    0.7.0.1
 */