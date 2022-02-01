package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements b, c
{
  private final c aKw;
  private b aLf;
  private b aLg;
  private boolean isRunning;
  
  h()
  {
    this(null);
  }
  
  public h(c paramc)
  {
    this.aKw = paramc;
  }
  
  private boolean pJ()
  {
    AppMethodBeat.i(77693);
    if ((this.aKw != null) && (this.aKw.pq()))
    {
      AppMethodBeat.o(77693);
      return true;
    }
    AppMethodBeat.o(77693);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aLf = paramb1;
    this.aLg = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77703);
    if ((paramb instanceof h))
    {
      paramb = (h)paramb;
      if (this.aLf == null)
      {
        if (paramb.aLf != null) {
          break label68;
        }
        if (this.aLg != null) {
          break label75;
        }
        if (paramb.aLg != null) {
          break label68;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77703);
        return true;
        if (this.aLf.a(paramb.aLf)) {
          break;
        }
        label68:
        label75:
        do
        {
          AppMethodBeat.o(77703);
          return false;
        } while (!this.aLg.a(paramb.aLg));
      }
    }
    AppMethodBeat.o(77703);
    return false;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(77687);
    if ((this.aKw == null) || (this.aKw.b(this))) {}
    for (int i = 1; (i != 0) && ((paramb.equals(this.aLf)) || (!this.aLf.pp())); i = 0)
    {
      AppMethodBeat.o(77687);
      return true;
    }
    AppMethodBeat.o(77687);
    return false;
  }
  
  public final void begin()
  {
    AppMethodBeat.i(77694);
    this.isRunning = true;
    if ((!this.aLf.isComplete()) && (!this.aLg.isRunning())) {
      this.aLg.begin();
    }
    if ((this.isRunning) && (!this.aLf.isRunning())) {
      this.aLf.begin();
    }
    AppMethodBeat.o(77694);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77688);
    if ((this.aKw == null) || (this.aKw.c(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aLf)) && (!pq()); i = 0)
    {
      AppMethodBeat.o(77688);
      return true;
    }
    AppMethodBeat.o(77688);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(77696);
    this.isRunning = false;
    this.aLg.clear();
    this.aLf.clear();
    AppMethodBeat.o(77696);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77689);
    if ((this.aKw == null) || (this.aKw.d(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aLf)); i = 0)
    {
      AppMethodBeat.o(77689);
      return true;
    }
    AppMethodBeat.o(77689);
    return false;
  }
  
  public final void f(b paramb)
  {
    AppMethodBeat.i(77691);
    if (paramb.equals(this.aLg))
    {
      AppMethodBeat.o(77691);
      return;
    }
    if (this.aKw != null) {
      this.aKw.f(this);
    }
    if (!this.aLg.isComplete()) {
      this.aLg.clear();
    }
    AppMethodBeat.o(77691);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77692);
    if (!paramb.equals(this.aLf))
    {
      AppMethodBeat.o(77692);
      return;
    }
    if (this.aKw != null) {
      this.aKw.g(this);
    }
    AppMethodBeat.o(77692);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77700);
    boolean bool = this.aLf.isCancelled();
    AppMethodBeat.o(77700);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77698);
    if ((this.aLf.isComplete()) || (this.aLg.isComplete()))
    {
      AppMethodBeat.o(77698);
      return true;
    }
    AppMethodBeat.o(77698);
    return false;
  }
  
  public final boolean isFailed()
  {
    AppMethodBeat.i(77701);
    boolean bool = this.aLf.isFailed();
    AppMethodBeat.o(77701);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(77697);
    boolean bool = this.aLf.isRunning();
    AppMethodBeat.o(77697);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77695);
    this.isRunning = false;
    this.aLf.pause();
    this.aLg.pause();
    AppMethodBeat.o(77695);
  }
  
  public final boolean pp()
  {
    AppMethodBeat.i(77699);
    if ((this.aLf.pp()) || (this.aLg.pp()))
    {
      AppMethodBeat.o(77699);
      return true;
    }
    AppMethodBeat.o(77699);
    return false;
  }
  
  public final boolean pq()
  {
    AppMethodBeat.i(77690);
    if ((pJ()) || (pp()))
    {
      AppMethodBeat.o(77690);
      return true;
    }
    AppMethodBeat.o(77690);
    return false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77702);
    this.aLf.recycle();
    this.aLg.recycle();
    AppMethodBeat.o(77702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.f.h
 * JD-Core Version:    0.7.0.1
 */