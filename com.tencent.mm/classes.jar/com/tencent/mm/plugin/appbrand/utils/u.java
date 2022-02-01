package com.tencent.mm.plugin.appbrand.utils;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.e.a;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class u
  implements a, Runnable
{
  public static final a mUh;
  private final Runnable mRunnable;
  private final AtomicBoolean mUe;
  private final p<? super a> mUf;
  private final String mUg;
  
  static
  {
    AppMethodBeat.i(135611);
    mUh = new a((byte)0);
    AppMethodBeat.o(135611);
  }
  
  private u(p<? super a> paramp, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(160940);
    this.mUf = paramp;
    this.mRunnable = paramRunnable;
    this.mUg = paramString;
    this.mUe = new AtomicBoolean(false);
    AppMethodBeat.o(160940);
  }
  
  public static final u a(p<? super a> paramp, Runnable paramRunnable)
  {
    AppMethodBeat.i(160941);
    d.g.b.p.h(paramp, "registry");
    if ((paramRunnable instanceof u))
    {
      paramp = (u)paramRunnable;
      AppMethodBeat.o(160941);
      return paramp;
    }
    paramp = new u(paramp, paramRunnable, Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(160941);
    return paramp;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(135609);
    this.mUe.set(true);
    AppMethodBeat.o(135609);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135608);
    if (!this.mUe.get()) {
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
        this.mUf.a((a)this);
        AppMethodBeat.o(135608);
      }
    }
    ae.w("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.mUg);
    AppMethodBeat.o(135608);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.u
 * JD-Core Version:    0.7.0.1
 */