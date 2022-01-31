package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    ((ae)g.t(ae.class)).getFavItemInfoStorage().aQC();
    d.a(this.jYB, System.currentTimeMillis());
    y.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(this.jYB) - d.b(this.jYB)) });
    d.a(this.jYB, -1L);
    d.c(this.jYB);
    synchronized (d.d(this.jYB))
    {
      g.DP().Dz().c(ac.a.uqz, Boolean.valueOf(true));
      d.e(this.jYB);
      this.jYB.mHandler.sendEmptyMessage(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d.1
 * JD-Core Version:    0.7.0.1
 */