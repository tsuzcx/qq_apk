package com.tencent.mm.plugin.appbrand.utils;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.a;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class s
  implements a, Runnable
{
  public static final a mPc;
  private final AtomicBoolean mOZ;
  private final o<? super a> mPa;
  private final String mPb;
  private final Runnable mRunnable;
  
  static
  {
    AppMethodBeat.i(135611);
    mPc = new a((byte)0);
    AppMethodBeat.o(135611);
  }
  
  private s(o<? super a> paramo, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(160940);
    this.mPa = paramo;
    this.mRunnable = paramRunnable;
    this.mPb = paramString;
    this.mOZ = new AtomicBoolean(false);
    AppMethodBeat.o(160940);
  }
  
  public static final s a(o<? super a> paramo, Runnable paramRunnable)
  {
    AppMethodBeat.i(160941);
    p.h(paramo, "registry");
    if ((paramRunnable instanceof s))
    {
      paramo = (s)paramRunnable;
      AppMethodBeat.o(160941);
      return paramo;
    }
    paramo = new s(paramo, paramRunnable, Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(160941);
    return paramo;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(135609);
    this.mOZ.set(true);
    AppMethodBeat.o(135609);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135608);
    if (!this.mOZ.get()) {
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
        this.mPa.a((a)this);
        AppMethodBeat.o(135608);
      }
    }
    ad.w("Luggage.WXA.LifeCycleWrappedRunnable", "run() but dead, <init> stackTrace = " + this.mPb);
    AppMethodBeat.o(135608);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.s
 * JD-Core Version:    0.7.0.1
 */