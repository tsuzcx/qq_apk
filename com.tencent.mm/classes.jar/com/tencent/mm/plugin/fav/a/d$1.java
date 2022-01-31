package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(102623);
    ((ae)g.G(ae.class)).getFavItemInfoStorage().bwR();
    d.a(this.msU, System.currentTimeMillis());
    ab.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(this.msU) - d.b(this.msU)) });
    d.a(this.msU, -1L);
    d.c(this.msU);
    synchronized (d.d(this.msU))
    {
      g.RL().Ru().set(ac.a.yAz, Boolean.TRUE);
      d.e(this.msU);
      this.msU.mHandler.sendEmptyMessage(0);
      AppMethodBeat.o(102623);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d.1
 * JD-Core Version:    0.7.0.1
 */