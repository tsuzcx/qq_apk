package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cyI;
  
  public c(a parama)
  {
    this.cyI = parama;
  }
  
  public final boolean Cw()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cyI.Cw();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String Cx()
  {
    AppMethodBeat.i(185066);
    String str = this.cyI.Cx();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(213312);
    this.cyI.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(213312);
  }
  
  public final <T> T b(Callable<T> paramCallable)
  {
    AppMethodBeat.i(140000);
    paramCallable = new e(paramCallable);
    p(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(140000);
    return paramCallable;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(213314);
    boolean bool = this.cyI.doInnerLoopTask();
    AppMethodBeat.o(213314);
    return bool;
  }
  
  public final void p(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.cyI.Cw())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cyI.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(224178);
    a(paramRunnable, false);
    AppMethodBeat.o(224178);
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(213313);
    this.cyI.resumeLoopTasks();
    AppMethodBeat.o(213313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */