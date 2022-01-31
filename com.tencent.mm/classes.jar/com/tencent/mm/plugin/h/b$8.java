package com.tencent.mm.plugin.h;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;

final class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public final void run()
  {
    if (b.f(this.ijs) != null)
    {
      if (b.d(this.ijs) != null)
      {
        b.d(this.ijs);
        ai.S(b.f(this.ijs));
      }
      b.f(this.ijs).isStop = true;
      b.b(this.ijs, null);
      h.nFQ.a(664L, 2L, 1L, false);
    }
    if (b.h(this.ijs) != null) {
      b.h(this.ijs).isStop = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.8
 * JD-Core Version:    0.7.0.1
 */