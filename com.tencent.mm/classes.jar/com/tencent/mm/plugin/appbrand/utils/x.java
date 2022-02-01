package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class x
  implements Runnable
{
  private final Runnable cDO;
  private final int fTM;
  private volatile boolean isCanceled;
  private volatile boolean mPl;
  public AtomicInteger mPm;
  public final Runnable mPn;
  
  public x(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
  }
  
  public x(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(197541);
    this.cDO = paramRunnable1;
    this.fTM = paramInt;
    this.mPn = paramRunnable2;
    this.mPm = new AtomicInteger(this.fTM);
    AppMethodBeat.o(197541);
  }
  
  public final boolean bBw()
  {
    AppMethodBeat.i(197538);
    if (this.mPm.get() <= 0)
    {
      AppMethodBeat.o(197538);
      return true;
    }
    AppMethodBeat.o(197538);
    return false;
  }
  
  public final void bBx()
  {
    AppMethodBeat.i(197539);
    ad.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.mPm.decrementAndGet());
    if (bBw()) {
      run();
    }
    AppMethodBeat.o(197539);
  }
  
  public final void run()
  {
    AppMethodBeat.i(197540);
    if (this.isCanceled)
    {
      ad.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(197540);
      return;
    }
    if (!bBw())
    {
      ad.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(197540);
      return;
    }
    if (this.mPl)
    {
      ad.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(197540);
      return;
    }
    this.cDO.run();
    this.mPl = true;
    AppMethodBeat.o(197540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */