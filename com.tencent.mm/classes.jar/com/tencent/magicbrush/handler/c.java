package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cqp;
  
  public c(a parama)
  {
    this.cqp = parama;
  }
  
  public final boolean Bq()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cqp.Bq();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String Br()
  {
    AppMethodBeat.i(185066);
    String str = this.cqp.Br();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(193561);
    this.cqp.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(193561);
  }
  
  public final <T> T b(Callable<T> paramCallable)
  {
    AppMethodBeat.i(140000);
    paramCallable = new e(paramCallable);
    o(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(140000);
    return paramCallable;
  }
  
  public final void o(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.cqp.Bq())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cqp.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(203595);
    a(paramRunnable, false);
    AppMethodBeat.o(203595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */