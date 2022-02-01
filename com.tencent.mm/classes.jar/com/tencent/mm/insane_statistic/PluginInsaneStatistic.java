package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginInsaneStatistic
  extends f
  implements com.tencent.mm.insane_statistic.a.a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(20226);
    if (paramg.ahL())
    {
      com.tencent.mm.av.r.hJW = new b();
      com.tencent.mm.modelstat.r.hXU = new a();
    }
    AppMethodBeat.o(20226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.PluginInsaneStatistic
 * JD-Core Version:    0.7.0.1
 */