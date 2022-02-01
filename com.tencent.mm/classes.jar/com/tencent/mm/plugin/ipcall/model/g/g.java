package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends a
{
  public final void Dd() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25524);
    if (paramc != null)
    {
      l locall = new l(paramc.roomId, paramc.uLu, paramc.uLX);
      ba.aiU().a(locall, 0);
      ad.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[] { Integer.valueOf(paramc.roomId), Long.valueOf(paramc.uLu), Boolean.valueOf(paramc.uLX) });
    }
    AppMethodBeat.o(25524);
  }
  
  public final int[] ddT()
  {
    return new int[] { 227 };
  }
  
  public final int getServiceType()
  {
    return 7;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.g
 * JD-Core Version:    0.7.0.1
 */