package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends a
{
  public final void b(c paramc)
  {
    AppMethodBeat.i(21909);
    if (paramc != null)
    {
      l locall = new l(paramc.nMZ, paramc.nNb, paramc.nNE);
      aw.Rc().a(locall, 0);
      ab.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[] { Integer.valueOf(paramc.nMZ), Long.valueOf(paramc.nNb), Boolean.valueOf(paramc.nNE) });
    }
    AppMethodBeat.o(21909);
  }
  
  public final int[] bJz()
  {
    return new int[] { 227 };
  }
  
  public final int getServiceType()
  {
    return 7;
  }
  
  public final void onDestroy() {}
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.g
 * JD-Core Version:    0.7.0.1
 */