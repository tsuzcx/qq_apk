package com.tencent.magicbrush.d;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import android.os.Handler;
import android.os.Looper;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.MBJsThreadHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "runOnJsThreadIfAvailable", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "Ljava/lang/Runnable;", "runOnUiThread", "run", "Lkotlin/Function0;", "syncOnUiThread", "T", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"})
public final class c
{
  private static final Handler bLJ;
  public static final c bLK;
  
  static
  {
    AppMethodBeat.i(151511);
    bLK = new c();
    bLJ = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(151511);
  }
  
  public static void a(a<y> parama)
  {
    AppMethodBeat.i(151509);
    j.q(parama, "run");
    runOnUiThread((Runnable)new d(parama));
    AppMethodBeat.o(151509);
  }
  
  public static final void a(MBRuntime paramMBRuntime, Runnable paramRunnable)
  {
    AppMethodBeat.i(151510);
    j.q(paramMBRuntime, "runtime");
    j.q(paramRunnable, "runnable");
    if (paramMBRuntime.isDestroyedUnlock())
    {
      AppMethodBeat.o(151510);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = paramMBRuntime.getJsThreadHandler();
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(151510);
      return;
    }
    localMBJsThreadHandler.post((Runnable)new c.a(paramMBRuntime, paramRunnable));
    AppMethodBeat.o(151510);
  }
  
  public static final <T> T b(Callable<T> paramCallable)
  {
    AppMethodBeat.i(116015);
    j.q(paramCallable, "callable");
    paramCallable = new b(paramCallable);
    runOnUiThread((Runnable)paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(116015);
    return paramCallable;
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(116014);
    j.q(paramRunnable, "run");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    j.p(localLooper, "Looper.getMainLooper()");
    if (j.e(localThread, localLooper.getThread()))
    {
      paramRunnable.run();
      AppMethodBeat.o(116014);
      return;
    }
    bLJ.post(paramRunnable);
    AppMethodBeat.o(116014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.d.c
 * JD-Core Version:    0.7.0.1
 */