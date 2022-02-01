package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c
  implements a
{
  private a cyb;
  
  public c(a parama)
  {
    this.cyb = parama;
  }
  
  public final boolean Ct()
  {
    AppMethodBeat.i(139999);
    boolean bool = this.cyb.Ct();
    AppMethodBeat.o(139999);
    return bool;
  }
  
  public final String Cu()
  {
    AppMethodBeat.i(185066);
    String str = this.cyb.Cu();
    AppMethodBeat.o(185066);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(215081);
    this.cyb.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(215081);
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
    if (this.cyb.Ct())
    {
      paramRunnable.run();
      AppMethodBeat.o(140001);
      return;
    }
    this.cyb.a(paramRunnable, false);
    AppMethodBeat.o(140001);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(221621);
    a(paramRunnable, false);
    AppMethodBeat.o(221621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */