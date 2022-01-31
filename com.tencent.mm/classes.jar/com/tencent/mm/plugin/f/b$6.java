package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$6
  implements Runnable
{
  b$6(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(18585);
    if (this.kky) {
      b.a(this.kks, true);
    }
    if (!b.a(this.kks))
    {
      AppMethodBeat.o(18585);
      return;
    }
    if (b.b(this.kks) == null)
    {
      jx localjx = new jx();
      if (this.kks.bao())
      {
        b.a(this.kks, false);
        localjx.czm.bVC = true;
        a.ymk.l(localjx);
        h.qsU.idkeyStat(664L, 9L, 1L, false);
        AppMethodBeat.o(18585);
        return;
      }
      if (this.kky) {
        h.qsU.idkeyStat(664L, 7L, 1L, false);
      }
      localjx.czm.progress = b.baq();
      localjx.czm.czn = b.ban();
      localjx.czm.bVC = false;
      a.ymk.l(localjx);
      b.a(this.kks, new c("message", b.baq(), b.bar(), b.c(this.kks)));
      b.d(this.kks).ac(b.b(this.kks));
      if (((Long)g.RL().Ru().get(ac.a.yHH, Long.valueOf(0L))).longValue() <= 0L) {
        g.RL().Ru().set(ac.a.yHH, Long.valueOf(bo.aox()));
      }
    }
    AppMethodBeat.o(18585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.6
 * JD-Core Version:    0.7.0.1
 */