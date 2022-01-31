package com.tencent.mm.plugin.h;

import com.tencent.mm.h.a.jo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.h.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$4
  implements Runnable
{
  b$4(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.ijv) {
      b.a(this.ijs, true);
    }
    if (!b.a(this.ijs)) {}
    do
    {
      do
      {
        return;
      } while (b.b(this.ijs) != null);
      jo localjo = new jo();
      if (this.ijs.ayH())
      {
        b.a(this.ijs, false);
        localjo.bRK.bur = true;
        a.udP.m(localjo);
        h.nFQ.a(664L, 9L, 1L, false);
        return;
      }
      if (this.ijv) {
        h.nFQ.a(664L, 7L, 1L, false);
      }
      localjo.bRK.bRL = b.ayJ();
      localjo.bRK.bRM = b.ayG();
      localjo.bRK.bur = false;
      a.udP.m(localjo);
      b.a(this.ijs, new c("message", b.ayJ(), b.ayK(), b.c(this.ijs)));
      b.d(this.ijs).O(b.b(this.ijs));
    } while (((Long)g.DP().Dz().get(ac.a.uxy, Long.valueOf(0L))).longValue() > 0L);
    g.DP().Dz().c(ac.a.uxy, Long.valueOf(bk.UX()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.4
 * JD-Core Version:    0.7.0.1
 */