package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cnw;
  
  public c(a parama)
  {
    this.cnw = parama;
  }
  
  public final boolean AU()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cnw.AU();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String AV()
  {
    AppMethodBeat.i(185066);
    String str = this.cnw.AV();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(190913);
    this.cnw.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(190913);
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
  
  public final void p(Runnable paramRunnable)
  {
    AppMethodBeat.i(140001);
    if (this.cnw.AU())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cnw.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(210240);
    a(paramRunnable, false);
    AppMethodBeat.o(210240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */