package com.tencent.magicbrush.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"})
public final class g
{
  private static final Handler cQo;
  public static final g cQp;
  
  static
  {
    AppMethodBeat.i(140298);
    cQp = new g();
    cQo = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140298);
  }
  
  public static final Handler Ta()
  {
    return cQo;
  }
  
  public static final boolean Vr()
  {
    AppMethodBeat.i(140294);
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    boolean bool = p.h(localThread, localLooper.getThread());
    AppMethodBeat.o(140294);
    return bool;
  }
  
  public static void e(a<x> parama)
  {
    AppMethodBeat.i(140296);
    p.k(parama, "run");
    runOnUiThread((Runnable)new h(parama));
    AppMethodBeat.o(140296);
  }
  
  public static <T> T f(a<? extends T> parama)
  {
    AppMethodBeat.i(140297);
    p.k(parama, "cb");
    parama = new f((Callable)new a(parama));
    runOnUiThread((Runnable)parama);
    parama = parama.get();
    AppMethodBeat.o(140297);
    return parama;
  }
  
  public static final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140295);
    p.k(paramRunnable, "run");
    if (Vr())
    {
      paramRunnable.run();
      AppMethodBeat.o(140295);
      return;
    }
    cQo.post(paramRunnable);
    AppMethodBeat.o(140295);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class a<V>
    implements Callable<T>
  {
    a(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(140293);
      Object localObject = this.cQq.invoke();
      AppMethodBeat.o(140293);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.utils.g
 * JD-Core Version:    0.7.0.1
 */