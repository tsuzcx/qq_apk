package com.tencent.mm.booter;

import com.tencent.mm.network.a;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class CoreService$4
  implements am.a
{
  CoreService$4(CoreService paramCoreService) {}
  
  public final boolean tC()
  {
    s locals = CoreService.a(this.dhA);
    int i;
    if (bk.cp(locals.eRy) < locals.eRw)
    {
      y.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + locals.eRy + ", cur=" + bk.UZ() + ", retries=" + locals.eRz);
      if (locals.eRz <= 0)
      {
        i = 0;
        if (i != 0) {
          break label239;
        }
        y.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
      }
    }
    for (;;)
    {
      y.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(CoreService.c(this.dhA)), Long.valueOf(CoreService.d(this.dhA)), Long.valueOf(bk.UY() - CoreService.e(this.dhA)) });
      CoreService.f(this.dhA);
      CoreService.g(this.dhA);
      CoreService.h(this.dhA);
      new am(new CoreService.4.1(this), false).S(500L, 500L);
      return true;
      for (locals.eRz -= 1;; locals.eRz = locals.eRx)
      {
        locals.eRy = bk.UZ();
        i = 1;
        break;
      }
      label239:
      boolean bool1 = bk.bE(CoreService.b(this.dhA).eNL.Dj());
      boolean bool2 = aa.Uu().Ub();
      y.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (!bool2) && (f.a(1, 0, null, CoreService.b(this.dhA).eNL.Dj(), bk.UY())))
      {
        y.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
        return true;
      }
      CoreService.vU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.4
 * JD-Core Version:    0.7.0.1
 */