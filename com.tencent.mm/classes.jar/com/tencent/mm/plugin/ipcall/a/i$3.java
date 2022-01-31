package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class i$3
  implements bx.a
{
  i$3(i parami) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
    parama = aa.a(parama.dBs.svH);
    if ((parama == null) || (parama.length() == 0)) {
      y.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
    }
    int i;
    do
    {
      do
      {
        return;
        parama = bn.s(parama, "sysmsg");
        if (parama == null)
        {
          y.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
          return;
        }
      } while (!parama.containsKey(".sysmsg.WCONotify.NotifyGetBalance"));
      i = bk.getInt((String)parama.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
      y.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
    } while (i <= 0);
    parama = new g(2);
    au.Dk().a(parama, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.i.3
 * JD-Core Version:    0.7.0.1
 */