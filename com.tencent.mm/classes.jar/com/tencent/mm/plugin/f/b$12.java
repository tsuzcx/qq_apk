package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;

final class b$12
  implements Runnable
{
  b$12(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18592);
    if (b.f(this.kks) != null)
    {
      if (b.d(this.kks) != null)
      {
        b.d(this.kks);
        al.ae(b.f(this.kks));
      }
      b.f(this.kks).isStop = true;
      b.b(this.kks, null);
      h.qsU.idkeyStat(664L, 2L, 1L, false);
    }
    if (b.h(this.kks) != null) {
      b.h(this.kks).isStop = true;
    }
    AppMethodBeat.o(18592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.12
 * JD-Core Version:    0.7.0.1
 */