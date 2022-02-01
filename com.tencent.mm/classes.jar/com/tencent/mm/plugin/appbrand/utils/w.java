package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class w
  implements a, Runnable
{
  public static final a riV;
  private final Runnable mRunnable;
  private final AtomicBoolean riS;
  private final r<? super a> riT;
  private final String riU;
  
  static
  {
    AppMethodBeat.i(135611);
    riV = new a((byte)0);
    AppMethodBeat.o(135611);
  }
  
  private w(r<? super a> paramr, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(160940);
    this.riT = paramr;
    this.mRunnable = paramRunnable;
    this.riU = paramString;
    this.riS = new AtomicBoolean(false);
    AppMethodBeat.o(160940);
  }
  
  public static final w a(r<? super a> paramr, Runnable paramRunnable)
  {
    AppMethodBeat.i(160941);
    p.k(paramr, "registry");
    Runnable localRunnable = paramRunnable;
    if ((paramRunnable instanceof w)) {
      localRunnable = ((w)paramRunnable).mRunnable;
    }
    paramRunnable = android.util.Log.getStackTraceString(new Throwable());
    p.j(paramRunnable, "android.util.Log.getStackTraceString(Throwable())");
    paramRunnable = new w(paramr, localRunnable, paramRunnable);
    paramr.keep((a)paramRunnable);
    AppMethodBeat.o(160941);
    return paramRunnable;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(135609);
    this.riS.set(true);
    AppMethodBeat.o(135609);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135608);
    if (!this.riS.get()) {
      try
      {
        Runnable localRunnable = this.mRunnable;
        if (localRunnable != null) {
          localRunnable.run();
        }
        return;
      }
      finally
      {
        this.riT.a((a)this);
        AppMethodBeat.o(135608);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.riU);
    AppMethodBeat.o(135608);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "_runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.w
 * JD-Core Version:    0.7.0.1
 */