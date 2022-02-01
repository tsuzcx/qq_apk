package com.tencent.magicbrush.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class g
{
  private static final Handler eLs;
  public static final g eLt;
  
  static
  {
    AppMethodBeat.i(140298);
    eLt = new g();
    eLs = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140298);
  }
  
  public static final Handler atF()
  {
    return eLs;
  }
  
  public static final boolean avU()
  {
    AppMethodBeat.i(140294);
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    s.r(localLooper, "Looper.getMainLooper()");
    boolean bool = s.p(localThread, localLooper.getThread());
    AppMethodBeat.o(140294);
    return bool;
  }
  
  public static final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140295);
    s.t(paramRunnable, "run");
    if (avU())
    {
      paramRunnable.run();
      AppMethodBeat.o(140295);
      return;
    }
    eLs.post(paramRunnable);
    AppMethodBeat.o(140295);
  }
  
  public static void w(a<ah> parama)
  {
    AppMethodBeat.i(140296);
    s.t(parama, "run");
    runOnUiThread((Runnable)new h(parama));
    AppMethodBeat.o(140296);
  }
  
  public static <T> T x(a<? extends T> parama)
  {
    AppMethodBeat.i(140297);
    s.t(parama, "cb");
    parama = new f((Callable)new a(parama));
    runOnUiThread((Runnable)parama);
    parama = parama.get();
    AppMethodBeat.o(140297);
    return parama;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "call", "()Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
  static final class a<V>
    implements Callable<T>
  {
    a(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(140293);
      Object localObject = this.eLu.invoke();
      AppMethodBeat.o(140293);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.utils.g
 * JD-Core Version:    0.7.0.1
 */