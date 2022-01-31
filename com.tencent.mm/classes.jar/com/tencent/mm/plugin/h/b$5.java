package com.tencent.mm.plugin.h;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;

public final class b$5
  implements Runnable
{
  public b$5(b paramb) {}
  
  public final void run()
  {
    b.a(this.ijs, false);
    if (b.b(this.ijs) != null)
    {
      if (b.d(this.ijs) != null)
      {
        b.d(this.ijs);
        ai.S(b.b(this.ijs));
      }
      b.b(this.ijs).isStop = true;
      b.a(this.ijs, null);
      h.nFQ.a(664L, 8L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.5
 * JD-Core Version:    0.7.0.1
 */