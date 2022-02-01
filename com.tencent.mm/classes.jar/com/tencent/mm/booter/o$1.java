package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.j;

final class o$1
  implements Runnable
{
  o$1(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(19899);
    g.yhR.kvStat(10675, this.fFs + "," + j.cSc);
    AppMethodBeat.o(19899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.o.1
 * JD-Core Version:    0.7.0.1
 */