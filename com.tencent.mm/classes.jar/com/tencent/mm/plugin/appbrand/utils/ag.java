package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  implements Runnable
{
  private final Runnable hPJ;
  private volatile boolean isCanceled;
  private final int lNX;
  public final Runnable uru;
  private volatile boolean urv;
  public AtomicInteger urw;
  
  public ag(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
    AppMethodBeat.i(317344);
    AppMethodBeat.o(317344);
  }
  
  public ag(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(317336);
    this.hPJ = paramRunnable1;
    this.lNX = paramInt;
    this.uru = paramRunnable2;
    this.urw = new AtomicInteger(this.lNX);
    AppMethodBeat.o(317336);
  }
  
  public final boolean cNE()
  {
    AppMethodBeat.i(317350);
    if (this.urw.get() <= 0)
    {
      AppMethodBeat.o(317350);
      return true;
    }
    AppMethodBeat.o(317350);
    return false;
  }
  
  public final void cNF()
  {
    AppMethodBeat.i(317358);
    Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", s.X("countdown, curCount: ", Integer.valueOf(this.urw.decrementAndGet())));
    if (cNE()) {
      run();
    }
    AppMethodBeat.o(317358);
  }
  
  public final void run()
  {
    AppMethodBeat.i(317365);
    if (this.isCanceled)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(317365);
      return;
    }
    if (!cNE())
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(317365);
      return;
    }
    if (this.urv)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(317365);
      return;
    }
    this.hPJ.run();
    this.urv = true;
    AppMethodBeat.o(317365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ag
 * JD-Core Version:    0.7.0.1
 */