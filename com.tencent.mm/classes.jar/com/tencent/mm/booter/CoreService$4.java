package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class CoreService$4
  implements ap.a
{
  CoreService$4(CoreService paramCoreService) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(57729);
    s locals = CoreService.a(this.dYN);
    int i;
    if (bo.av(locals.gjt) < locals.gjr)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + locals.gjt + ", cur=" + bo.yB() + ", retries=" + locals.gju);
      if (locals.gju <= 0)
      {
        i = 0;
        if (i != 0) {
          break label249;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(CoreService.c(this.dYN)), Long.valueOf(CoreService.d(this.dYN)), Long.valueOf(bo.aoy() - CoreService.e(this.dYN)) });
      CoreService.f(this.dYN);
      CoreService.g(this.dYN);
      CoreService.h(this.dYN);
      new ap(new CoreService.4.1(this), false).ag(500L, 500L);
      AppMethodBeat.o(57729);
      return true;
      for (locals.gju -= 1;; locals.gju = locals.gjs)
      {
        locals.gjt = bo.yB();
        i = 1;
        break;
      }
      label249:
      boolean bool1 = CoreService.b(this.dYN).gdz.adC();
      boolean bool2 = com.tencent.mm.network.ab.anF().ano();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2) && (g.a(1, 0, null, CoreService.b(this.dYN).gdz.jN(1), bo.aoy())))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
        AppMethodBeat.o(57729);
        return true;
      }
      CoreService.Id();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.4
 * JD-Core Version:    0.7.0.1
 */