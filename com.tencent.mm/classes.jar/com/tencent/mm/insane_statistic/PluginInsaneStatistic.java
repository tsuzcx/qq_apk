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
    AppMethodBeat.i(16183);
    if (paramg.SD())
    {
      com.tencent.mm.at.r.fGU = new b();
      com.tencent.mm.modelstat.r.fUK = new a();
    }
    AppMethodBeat.o(16183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.PluginInsaneStatistic
 * JD-Core Version:    0.7.0.1
 */