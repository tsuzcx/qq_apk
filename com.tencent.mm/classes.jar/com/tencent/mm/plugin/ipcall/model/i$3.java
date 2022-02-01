package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

final class i$3
  implements cc.a
{
  i$3(i parami) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(25384);
    ac.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = z.a(parama.fXi.DPV);
    if ((parama == null) || (parama.length() == 0))
    {
      ac.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25384);
      return;
    }
    parama = bv.L(parama, "sysmsg");
    if (parama == null)
    {
      ac.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
      AppMethodBeat.o(25384);
      return;
    }
    if (parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
    {
      int i = bs.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      ac.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        parama = new g(2);
        az.agi().a(parama, 0);
      }
    }
    AppMethodBeat.o(25384);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.3
 * JD-Core Version:    0.7.0.1
 */