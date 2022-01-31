package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(18579);
    this.kkw.kks.bam();
    ab.i("MicroMsg.CalcWxService", "start to calc");
    if (this.kkw.kks.bao())
    {
      b localb = this.kkw.kks;
      if (bo.hl(((Long)g.RL().Ru().get(ac.a.yHG, Long.valueOf(0L))).longValue()) >= 259200000L)
      {
        if (localb.kkh != null) {
          localb.kkh.isStop = true;
        }
        localb.kkh = new com.tencent.mm.plugin.f.c.b();
        localb.post(localb.kkh);
        g.RL().Ru().set(ac.a.yHG, Long.valueOf(bo.aoy()));
      }
      AppMethodBeat.o(18579);
      return;
    }
    h.qsU.idkeyStat(664L, 1L, 1L, false);
    b.i(this.kkw.kks);
    AppMethodBeat.o(18579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.4.1
 * JD-Core Version:    0.7.0.1
 */