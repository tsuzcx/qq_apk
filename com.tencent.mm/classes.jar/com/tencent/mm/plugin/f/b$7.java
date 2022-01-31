package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;

public final class b$7
  implements Runnable
{
  public b$7(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18586);
    b.a(this.kks, false);
    if (b.b(this.kks) != null)
    {
      if (b.d(this.kks) != null)
      {
        b.d(this.kks);
        al.ae(b.b(this.kks));
      }
      b.b(this.kks).isStop = true;
      b.a(this.kks, null);
      h.qsU.idkeyStat(664L, 8L, 1L, false);
    }
    AppMethodBeat.o(18586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.7
 * JD-Core Version:    0.7.0.1
 */