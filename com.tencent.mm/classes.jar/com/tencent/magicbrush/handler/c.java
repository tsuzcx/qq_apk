package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cMP;
  
  public c(a parama)
  {
    this.cMP = parama;
  }
  
  public final boolean LO()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cMP.LO();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String LP()
  {
    AppMethodBeat.i(185066);
    String str = this.cMP.LP();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(206808);
    if (this.cMP.LO())
    {
      paramRunnable.run();
      AppMethodBeat.o(206808);
      return;
    }
    this.cMP.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(206808);
  }
  
  public final <T> T c(Callable<T> paramCallable)
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
    AppMethodBeat.i(206810);
    boolean bool = this.cMP.doInnerLoopTask();
    AppMethodBeat.o(206810);
    return bool;
  }
  
  public final void p(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.cMP.LO())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cMP.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(258581);
    a(paramRunnable, false);
    AppMethodBeat.o(258581);
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(206809);
    this.cMP.resumeLoopTasks();
    AppMethodBeat.o(206809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */