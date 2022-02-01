package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class z
  implements Runnable
{
  private final Runnable dQN;
  private final int gAZ;
  private volatile boolean isCanceled;
  private volatile boolean ohr;
  public AtomicInteger ohs;
  public final Runnable oht;
  
  public z(Runnable paramRunnable, byte paramByte)
  {
    this(paramRunnable);
  }
  
  public z(Runnable paramRunnable1, int paramInt, Runnable paramRunnable2)
  {
    AppMethodBeat.i(219789);
    this.dQN = paramRunnable1;
    this.gAZ = paramInt;
    this.oht = paramRunnable2;
    this.ohs = new AtomicInteger(this.gAZ);
    AppMethodBeat.o(219789);
  }
  
  public final boolean bZu()
  {
    AppMethodBeat.i(219786);
    if (this.ohs.get() <= 0)
    {
      AppMethodBeat.o(219786);
      return true;
    }
    AppMethodBeat.o(219786);
    return false;
  }
  
  public final void bZv()
  {
    AppMethodBeat.i(219787);
    Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.ohs.decrementAndGet());
    if (bZu()) {
      run();
    }
    AppMethodBeat.o(219787);
  }
  
  public final void run()
  {
    AppMethodBeat.i(219788);
    if (this.isCanceled)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      AppMethodBeat.o(219788);
      return;
    }
    if (!bZu())
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      AppMethodBeat.o(219788);
      return;
    }
    if (this.ohr)
    {
      Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      AppMethodBeat.o(219788);
      return;
    }
    this.dQN.run();
    this.ohr = true;
    AppMethodBeat.o(219788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */