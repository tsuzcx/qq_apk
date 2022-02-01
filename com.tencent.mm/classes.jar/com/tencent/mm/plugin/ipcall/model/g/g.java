package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends a
{
  public final void MC() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25524);
    if (paramc != null)
    {
      l locall = new l(paramc.roomId, paramc.ypI, paramc.yqk);
      bg.azz().a(locall, 0);
      Log.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[] { Integer.valueOf(paramc.roomId), Long.valueOf(paramc.ypI), Boolean.valueOf(paramc.yqk) });
    }
    AppMethodBeat.o(25524);
  }
  
  public final int[] eaF()
  {
    return new int[] { 227 };
  }
  
  public final int getServiceType()
  {
    return 7;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.g
 * JD-Core Version:    0.7.0.1
 */