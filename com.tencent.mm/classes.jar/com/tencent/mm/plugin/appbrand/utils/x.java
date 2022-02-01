package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.concurrent.atomic.AtomicInteger;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class x
  implements Runnable
{
  private final Runnable csS;
  private final int fAw;
  private volatile boolean isCanceled;
  private volatile boolean moJ;
  public AtomicInteger moK;
  public final Runnable moL;
  
  public x(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
  }
  
  public x(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(193301);
    this.csS = paramRunnable1;
    this.fAw = paramInt;
    this.moL = paramRunnable2;
    this.moK = new AtomicInteger(this.fAw);
    AppMethodBeat.o(193301);
  }
  
  public final boolean bxs()
  {
    AppMethodBeat.i(193298);
    if (this.moK.get() <= 0)
    {
      AppMethodBeat.o(193298);
      return true;
    }
    AppMethodBeat.o(193298);
    return false;
  }
  
  public final void bxt()
  {
    AppMethodBeat.i(193299);
    ac.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.moK.decrementAndGet());
    if (bxs()) {
      run();
    }
    AppMethodBeat.o(193299);
  }
  
  public final void run()
  {
    AppMethodBeat.i(193300);
    if (this.isCanceled)
    {
      ac.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(193300);
      return;
    }
    if (!bxs())
    {
      ac.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(193300);
      return;
    }
    if (this.moJ)
    {
      ac.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(193300);
      return;
    }
    this.csS.run();
    this.moJ = true;
    AppMethodBeat.o(193300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */