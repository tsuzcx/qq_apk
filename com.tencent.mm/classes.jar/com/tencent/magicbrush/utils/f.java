package com.tencent.magicbrush.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.concurrent.Callable;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"})
public final class f
{
  private static final Handler cBv;
  public static final f cBw;
  
  static
  {
    AppMethodBeat.i(140298);
    cBw = new f();
    cBv = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140298);
  }
  
  public static final Handler FR()
  {
    return cBv;
  }
  
  public static final boolean HP()
  {
    AppMethodBeat.i(140294);
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    boolean bool = p.i(localThread, localLooper.getThread());
    AppMethodBeat.o(140294);
    return bool;
  }
  
  public static void e(a<z> parama)
  {
    AppMethodBeat.i(140296);
    p.h(parama, "run");
    runOnUiThread((Runnable)new g(parama));
    AppMethodBeat.o(140296);
  }
  
  public static <T> T f(a<? extends T> parama)
  {
    AppMethodBeat.i(140297);
    p.h(parama, "cb");
    parama = new e((Callable)new f.a(parama));
    runOnUiThread((Runnable)parama);
    parama = parama.get();
    AppMethodBeat.o(140297);
    return parama;
  }
  
  public static final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140295);
    p.h(paramRunnable, "run");
    if (HP())
    {
      paramRunnable.run();
      AppMethodBeat.o(140295);
      return;
    }
    cBv.post(paramRunnable);
    AppMethodBeat.o(140295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.utils.f
 * JD-Core Version:    0.7.0.1
 */