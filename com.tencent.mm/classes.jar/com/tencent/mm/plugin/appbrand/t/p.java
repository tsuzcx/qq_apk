package com.tencent.mm.plugin.appbrand.t;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import java.util.concurrent.atomic.AtomicBoolean;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRunnable", "(Ljava/lang/Runnable;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class p
  implements a, Runnable
{
  @Deprecated
  public static final p.a iXT;
  private final AtomicBoolean iXS;
  private final Runnable mRunnable;
  
  static
  {
    AppMethodBeat.i(87595);
    iXT = new p.a((byte)0);
    AppMethodBeat.o(87595);
  }
  
  private p(Runnable paramRunnable)
  {
    AppMethodBeat.i(87594);
    this.mRunnable = paramRunnable;
    this.iXS = new AtomicBoolean(false);
    AppMethodBeat.o(87594);
  }
  
  public static final p M(Runnable paramRunnable)
  {
    AppMethodBeat.i(87596);
    if ((paramRunnable instanceof p))
    {
      paramRunnable = (p)paramRunnable;
      AppMethodBeat.o(87596);
      return paramRunnable;
    }
    paramRunnable = new p(paramRunnable);
    AppMethodBeat.o(87596);
    return paramRunnable;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(87593);
    this.iXS.set(true);
    AppMethodBeat.o(87593);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87592);
    if (!this.iXS.get())
    {
      Runnable localRunnable = this.mRunnable;
      if (localRunnable != null)
      {
        localRunnable.run();
        AppMethodBeat.o(87592);
        return;
      }
    }
    AppMethodBeat.o(87592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.p
 * JD-Core Version:    0.7.0.1
 */