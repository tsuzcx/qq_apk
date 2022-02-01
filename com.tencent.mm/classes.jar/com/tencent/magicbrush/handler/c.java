package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a eIX;
  
  public c(a parama)
  {
    this.eIX = parama;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(228970);
    if (this.eIX.aoN())
    {
      paramRunnable.run();
      AppMethodBeat.o(228970);
      return;
    }
    this.eIX.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(228970);
  }
  
  public final boolean aoN()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.eIX.aoN();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String aoO()
  {
    AppMethodBeat.i(185066);
    String str = this.eIX.aoO();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final <T> T c(Callable<T> paramCallable)
  {
    AppMethodBeat.i(140000);
    paramCallable = new f(paramCallable);
    t(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(140000);
    return paramCallable;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(228990);
    boolean bool = this.eIX.doInnerLoopTask();
    AppMethodBeat.o(228990);
    return bool;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(369543);
    a(paramRunnable, false);
    AppMethodBeat.o(369543);
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(228987);
    this.eIX.resumeLoopTasks();
    AppMethodBeat.o(228987);
  }
  
  public final void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.eIX.aoN())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.eIX.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */