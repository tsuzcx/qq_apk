package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class ab
  implements Runnable
{
  private final Runnable fKd;
  private volatile boolean isCanceled;
  private final int jlf;
  private volatile boolean rjf;
  public AtomicInteger rjg;
  public final Runnable rjh;
  
  public ab(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
  }
  
  public ab(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(246445);
    this.fKd = paramRunnable1;
    this.jlf = paramInt;
    this.rjh = paramRunnable2;
    this.rjg = new AtomicInteger(this.jlf);
    AppMethodBeat.o(246445);
  }
  
  public final boolean cmk()
  {
    AppMethodBeat.i(246441);
    if (this.rjg.get() <= 0)
    {
      AppMethodBeat.o(246441);
      return true;
    }
    AppMethodBeat.o(246441);
    return false;
  }
  
  public final void cml()
  {
    AppMethodBeat.i(246443);
    Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.rjg.decrementAndGet());
    if (cmk()) {
      run();
    }
    AppMethodBeat.o(246443);
  }
  
  public final void run()
  {
    AppMethodBeat.i(246444);
    if (this.isCanceled)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(246444);
      return;
    }
    if (!cmk())
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(246444);
      return;
    }
    if (this.rjf)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(246444);
      return;
    }
    this.fKd.run();
    this.rjf = true;
    AppMethodBeat.o(246444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ab
 * JD-Core Version:    0.7.0.1
 */