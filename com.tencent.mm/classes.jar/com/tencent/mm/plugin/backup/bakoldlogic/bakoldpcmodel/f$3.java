package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.bakoldlogic.c.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class f$3
  implements com.tencent.mm.ah.f
{
  f$3(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    paramm = (d)paramm;
    y.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", new Object[] { paramm.id, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    synchronized (this.hOx.lock)
    {
      this.hOx.hNP.remove(paramm.id);
      y.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", new Object[] { Integer.valueOf(this.hOx.hNP.size()) });
      if (this.hOx.hNP.size() <= 10) {
        this.hOx.lock.notifyAll();
      }
      ??? = this.hOx;
      ???.hNW += 1;
      if (this.hOx.hNW % 300 == 0) {
        this.hOx.avJ();
      }
      this.hOx.avI();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.3
 * JD-Core Version:    0.7.0.1
 */