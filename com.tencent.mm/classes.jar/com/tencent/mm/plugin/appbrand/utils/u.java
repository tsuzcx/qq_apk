package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class u
  implements a, Runnable
{
  public static final a ohi;
  private final Runnable mRunnable;
  private final AtomicBoolean ohf;
  private final p<? super a> ohg;
  private final String ohh;
  
  static
  {
    AppMethodBeat.i(135611);
    ohi = new a((byte)0);
    AppMethodBeat.o(135611);
  }
  
  private u(p<? super a> paramp, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(160940);
    this.ohg = paramp;
    this.mRunnable = paramRunnable;
    this.ohh = paramString;
    this.ohf = new AtomicBoolean(false);
    AppMethodBeat.o(160940);
  }
  
  public static final u a(p<? super a> paramp, Runnable paramRunnable)
  {
    AppMethodBeat.i(160941);
    kotlin.g.b.p.h(paramp, "registry");
    if ((paramRunnable instanceof u))
    {
      paramp = (u)paramRunnable;
      AppMethodBeat.o(160941);
      return paramp;
    }
    String str = android.util.Log.getStackTraceString(new Throwable());
    kotlin.g.b.p.g(str, "android.util.Log.getStackTraceString(Throwable())");
    paramp = new u(paramp, paramRunnable, str);
    AppMethodBeat.o(160941);
    return paramp;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(135609);
    this.ohf.set(true);
    AppMethodBeat.o(135609);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135608);
    if (!this.ohf.get()) {
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
        this.ohg.a((a)this);
        AppMethodBeat.o(135608);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.ohh);
    AppMethodBeat.o(135608);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.u
 * JD-Core Version:    0.7.0.1
 */