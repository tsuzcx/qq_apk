package com.tencent.mm.plugin.h;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2) {}
  
  public final void run()
  {
    y.i("MicroMsg.CalcWxService", "start to calc");
    if (this.ijt.ijs.ayH())
    {
      b localb = this.ijt.ijs;
      if (bk.co(((Long)g.DP().Dz().get(ac.a.uxx, Long.valueOf(0L))).longValue()) >= 259200000L)
      {
        if (localb.ijh != null) {
          localb.ijh.isStop = true;
        }
        localb.ijh = new com.tencent.mm.plugin.h.c.b();
        localb.f(localb.ijh);
        g.DP().Dz().c(ac.a.uxx, Long.valueOf(bk.UY()));
      }
      return;
    }
    h.nFQ.a(664L, 1L, 1L, false);
    b.i(this.ijt.ijs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.2.1
 * JD-Core Version:    0.7.0.1
 */