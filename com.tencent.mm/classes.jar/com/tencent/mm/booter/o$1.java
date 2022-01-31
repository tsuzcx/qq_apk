package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.g;

final class o$1
  implements Runnable
{
  o$1(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(15863);
    h.qsU.kvStat(10675, this.dZH + "," + g.bWu);
    AppMethodBeat.o(15863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.o.1
 * JD-Core Version:    0.7.0.1
 */