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
    if (paramg.aIE())
    {
      com.tencent.mm.ay.u.lRb = new b();
      com.tencent.mm.modelstat.q.meR = new a();
    }
    AppMethodBeat.o(20226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.PluginInsaneStatistic
 * JD-Core Version:    0.7.0.1
 */