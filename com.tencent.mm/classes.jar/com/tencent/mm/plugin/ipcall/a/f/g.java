package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends a
{
  public final int LW()
  {
    return 7;
  }
  
  public final void b(c paramc)
  {
    if (paramc != null)
    {
      l locall = new l(paramc.lpD, paramc.lpF, paramc.lqi);
      au.Dk().a(locall, 0);
      y.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[] { Integer.valueOf(paramc.lpD), Long.valueOf(paramc.lpF), Boolean.valueOf(paramc.lqi) });
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 227 };
  }
  
  public final void onDestroy() {}
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.g
 * JD-Core Version:    0.7.0.1
 */