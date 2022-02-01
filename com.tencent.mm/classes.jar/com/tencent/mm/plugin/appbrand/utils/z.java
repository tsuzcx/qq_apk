package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class z
  implements Runnable
{
  private final Runnable cEv;
  private final int fVS;
  private volatile boolean isCanceled;
  private volatile boolean mUq;
  public AtomicInteger mUr;
  public final Runnable mUs;
  
  public z(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
  }
  
  public z(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(208171);
    this.cEv = paramRunnable1;
    this.fVS = paramInt;
    this.mUs = paramRunnable2;
    this.mUr = new AtomicInteger(this.fVS);
    AppMethodBeat.o(208171);
  }
  
  public final boolean bCq()
  {
    AppMethodBeat.i(208168);
    if (this.mUr.get() <= 0)
    {
      AppMethodBeat.o(208168);
      return true;
    }
    AppMethodBeat.o(208168);
    return false;
  }
  
  public final void bCr()
  {
    AppMethodBeat.i(208169);
    ae.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.mUr.decrementAndGet());
    if (bCq()) {
      run();
    }
    AppMethodBeat.o(208169);
  }
  
  public final void run()
  {
    AppMethodBeat.i(208170);
    if (this.isCanceled)
    {
      ae.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(208170);
      return;
    }
    if (!bCq())
    {
      ae.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(208170);
      return;
    }
    if (this.mUq)
    {
      ae.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(208170);
      return;
    }
    this.cEv.run();
    this.mUq = true;
    AppMethodBeat.o(208170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */