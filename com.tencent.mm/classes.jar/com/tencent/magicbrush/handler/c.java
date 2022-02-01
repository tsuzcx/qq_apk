package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cNC;
  
  public c(a parama)
  {
    this.cNC = parama;
  }
  
  public final boolean OF()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cNC.OF();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String OG()
  {
    AppMethodBeat.i(185066);
    String str = this.cNC.OG();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(203677);
    if (this.cNC.OF())
    {
      paramRunnable.run();
      AppMethodBeat.o(203677);
      return;
    }
    this.cNC.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(203677);
  }
  
  public final <T> T c(Callable<T> paramCallable)
  {
    AppMethodBeat.i(140000);
    paramCallable = new f(paramCallable);
    p(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(140000);
    return paramCallable;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(203687);
    boolean bool = this.cNC.doInnerLoopTask();
    AppMethodBeat.o(203687);
    return bool;
  }
  
  public final void p(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.cNC.OF())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cNC.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(292878);
    a(paramRunnable, false);
    AppMethodBeat.o(292878);
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(203685);
    this.cNC.resumeLoopTasks();
    AppMethodBeat.o(203685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */