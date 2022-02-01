package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  implements a, Runnable
{
  public static final a ure;
  private final Runnable mRunnable;
  private final u<? super a> urf;
  private final String urg;
  private final AtomicBoolean urh;
  
  static
  {
    AppMethodBeat.i(135611);
    ure = new a((byte)0);
    AppMethodBeat.o(135611);
  }
  
  private ab(u<? super a> paramu, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(160940);
    this.urf = paramu;
    this.mRunnable = paramRunnable;
    this.urg = paramString;
    this.urh = new AtomicBoolean(false);
    AppMethodBeat.o(160940);
  }
  
  public static final ab a(u<? super a> paramu, Runnable paramRunnable)
  {
    AppMethodBeat.i(160941);
    s.u(paramu, "registry");
    Runnable localRunnable = paramRunnable;
    if ((paramRunnable instanceof ab)) {
      localRunnable = ((ab)paramRunnable).mRunnable;
    }
    paramRunnable = android.util.Log.getStackTraceString(new Throwable());
    s.s(paramRunnable, "getStackTraceString(Throwable())");
    paramRunnable = new ab(paramu, localRunnable, paramRunnable);
    paramu.keep((a)paramRunnable);
    AppMethodBeat.o(160941);
    return paramRunnable;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(135609);
    this.urh.set(true);
    AppMethodBeat.o(135609);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135608);
    if (!this.urh.get()) {
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
        this.urf.a((a)this);
        AppMethodBeat.o(135608);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("Luggage.WXA.LifeCycleWrappedRunnable", s.X("run() but dead, <init> stackTrace = ", this.urg));
    AppMethodBeat.o(135608);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "_runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ab
 * JD-Core Version:    0.7.0.1
 */