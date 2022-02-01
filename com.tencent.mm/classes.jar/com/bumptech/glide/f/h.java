package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements b, c
{
  private b aLV;
  private b aLW;
  private final c aLm;
  private boolean isRunning;
  
  h()
  {
    this(null);
  }
  
  public h(c paramc)
  {
    this.aLm = paramc;
  }
  
  private boolean pT()
  {
    AppMethodBeat.i(77693);
    if ((this.aLm != null) && (this.aLm.pA()))
    {
      AppMethodBeat.o(77693);
      return true;
    }
    AppMethodBeat.o(77693);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aLV = paramb1;
    this.aLW = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77703);
    if ((paramb instanceof h))
    {
      paramb = (h)paramb;
      if (this.aLV == null)
      {
        if (paramb.aLV != null) {
          break label68;
        }
        if (this.aLW != null) {
          break label75;
        }
        if (paramb.aLW != null) {
          break label68;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77703);
        return true;
        if (this.aLV.a(paramb.aLV)) {
          break;
        }
        label68:
        label75:
        do
        {
          AppMethodBeat.o(77703);
          return false;
        } while (!this.aLW.a(paramb.aLW));
      }
    }
    AppMethodBeat.o(77703);
    return false;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(77687);
    if ((this.aLm == null) || (this.aLm.b(this))) {}
    for (int i = 1; (i != 0) && ((paramb.equals(this.aLV)) || (!this.aLV.pz())); i = 0)
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
    if ((!this.aLV.isComplete()) && (!this.aLW.isRunning())) {
      this.aLW.begin();
    }
    if ((this.isRunning) && (!this.aLV.isRunning())) {
      this.aLV.begin();
    }
    AppMethodBeat.o(77694);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77688);
    if ((this.aLm == null) || (this.aLm.c(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aLV)) && (!pA()); i = 0)
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
    this.aLW.clear();
    this.aLV.clear();
    AppMethodBeat.o(77696);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77689);
    if ((this.aLm == null) || (this.aLm.d(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aLV)); i = 0)
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
    if (paramb.equals(this.aLW))
    {
      AppMethodBeat.o(77691);
      return;
    }
    if (this.aLm != null) {
      this.aLm.f(this);
    }
    if (!this.aLW.isComplete()) {
      this.aLW.clear();
    }
    AppMethodBeat.o(77691);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77692);
    if (!paramb.equals(this.aLV))
    {
      AppMethodBeat.o(77692);
      return;
    }
    if (this.aLm != null) {
      this.aLm.g(this);
    }
    AppMethodBeat.o(77692);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77700);
    boolean bool = this.aLV.isCancelled();
    AppMethodBeat.o(77700);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77698);
    if ((this.aLV.isComplete()) || (this.aLW.isComplete()))
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
    boolean bool = this.aLV.isFailed();
    AppMethodBeat.o(77701);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(77697);
    boolean bool = this.aLV.isRunning();
    AppMethodBeat.o(77697);
    return bool;
  }
  
  public final boolean pA()
  {
    AppMethodBeat.i(77690);
    if ((pT()) || (pz()))
    {
      AppMethodBeat.o(77690);
      return true;
    }
    AppMethodBeat.o(77690);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77695);
    this.isRunning = false;
    this.aLV.pause();
    this.aLW.pause();
    AppMethodBeat.o(77695);
  }
  
  public final boolean pz()
  {
    AppMethodBeat.i(77699);
    if ((this.aLV.pz()) || (this.aLW.pz()))
    {
      AppMethodBeat.o(77699);
      return true;
    }
    AppMethodBeat.o(77699);
    return false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77702);
    this.aLV.recycle();
    this.aLW.recycle();
    AppMethodBeat.o(77702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.h
 * JD-Core Version:    0.7.0.1
 */