package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

final class i$3
  implements cf.a
{
  i$3(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(25384);
    ae.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = z.a(parama.gte.FNI);
    if ((parama == null) || (parama.length() == 0))
    {
      ae.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25384);
      return;
    }
    parama = bx.M(parama, "sysmsg");
    if (parama == null)
    {
      ae.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
      AppMethodBeat.o(25384);
      return;
    }
    if (parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
    {
      int i = bu.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      ae.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        parama = new g(2);
        bc.ajj().a(parama, 0);
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