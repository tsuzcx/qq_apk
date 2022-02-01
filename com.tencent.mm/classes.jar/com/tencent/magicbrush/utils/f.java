package com.tencent.magicbrush.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.concurrent.Callable;

@l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"})
public final class f
{
  private static final Handler cpW;
  public static final f cpX;
  
  static
  {
    AppMethodBeat.i(140298);
    cpX = new f();
    cpW = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140298);
  }
  
  public static final Handler Em()
  {
    return cpW;
  }
  
  public static final boolean Gm()
  {
    AppMethodBeat.i(140294);
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    k.g(localLooper, "Looper.getMainLooper()");
    boolean bool = k.g(localThread, localLooper.getThread());
    AppMethodBeat.o(140294);
    return bool;
  }
  
  public static void d(a<y> parama)
  {
    AppMethodBeat.i(140296);
    k.h(parama, "run");
    runOnUiThread((Runnable)new g(parama));
    AppMethodBeat.o(140296);
  }
  
  public static <T> T e(a<? extends T> parama)
  {
    AppMethodBeat.i(140297);
    k.h(parama, "cb");
    parama = new e((Callable)new a(parama));
    runOnUiThread((Runnable)parama);
    parama = parama.get();
    AppMethodBeat.o(140297);
    return parama;
  }
  
  public static final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140295);
    k.h(paramRunnable, "run");
    if (Gm())
    {
      paramRunnable.run();
      AppMethodBeat.o(140295);
      return;
    }
    cpW.post(paramRunnable);
    AppMethodBeat.o(140295);
  }
  
  @l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class a<V>
    implements Callable<T>
  {
    a(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(140293);
      Object localObject = this.cpY.invoke();
      AppMethodBeat.o(140293);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.utils.f
 * JD-Core Version:    0.7.0.1
 */