package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$11
  implements Runnable
{
  b$11(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18591);
    if (!b.e(this.kks))
    {
      if (b.f(this.kks) != null)
      {
        b.f(this.kks).isStop = true;
        b.b(this.kks, null);
      }
      AppMethodBeat.o(18591);
      return;
    }
    if (this.kks.bao())
    {
      h.qsU.idkeyStat(664L, 3L, 1L, false);
      AppMethodBeat.o(18591);
      return;
    }
    if (b.f(this.kks) != null)
    {
      AppMethodBeat.o(18591);
      return;
    }
    b.b(this.kks, new c("message", b.baq(), b.bar(), b.g(this.kks)));
    b.d(this.kks).o(b.f(this.kks), 2000L);
    if (((Long)g.RL().Ru().get(ac.a.yHH, Long.valueOf(0L))).longValue() <= 0L) {
      g.RL().Ru().set(ac.a.yHH, Long.valueOf(bo.aox()));
    }
    AppMethodBeat.o(18591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.11
 * JD-Core Version:    0.7.0.1
 */