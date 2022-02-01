package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements b, c
{
  private b aNM;
  private b aNN;
  private final c aNd;
  private boolean isRunning;
  
  h()
  {
    this(null);
  }
  
  public h(c paramc)
  {
    this.aNd = paramc;
  }
  
  private boolean ql()
  {
    AppMethodBeat.i(77693);
    if ((this.aNd != null) && (this.aNd.pS()))
    {
      AppMethodBeat.o(77693);
      return true;
    }
    AppMethodBeat.o(77693);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aNM = paramb1;
    this.aNN = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77703);
    if ((paramb instanceof h))
    {
      paramb = (h)paramb;
      if (this.aNM == null)
      {
        if (paramb.aNM != null) {
          break label68;
        }
        if (this.aNN != null) {
          break label75;
        }
        if (paramb.aNN != null) {
          break label68;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77703);
        return true;
        if (this.aNM.a(paramb.aNM)) {
          break;
        }
        label68:
        label75:
        do
        {
          AppMethodBeat.o(77703);
          return false;
        } while (!this.aNN.a(paramb.aNN));
      }
    }
    AppMethodBeat.o(77703);
    return false;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(77687);
    if ((this.aNd == null) || (this.aNd.b(this))) {}
    for (int i = 1; (i != 0) && ((paramb.equals(this.aNM)) || (!this.aNM.pR())); i = 0)
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
    if ((!this.aNM.isComplete()) && (!this.aNN.isRunning())) {
      this.aNN.begin();
    }
    if ((this.isRunning) && (!this.aNM.isRunning())) {
      this.aNM.begin();
    }
    AppMethodBeat.o(77694);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77688);
    if ((this.aNd == null) || (this.aNd.c(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aNM)) && (!pS()); i = 0)
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
    this.aNN.clear();
    this.aNM.clear();
    AppMethodBeat.o(77696);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77689);
    if ((this.aNd == null) || (this.aNd.d(this))) {}
    for (int i = 1; (i != 0) && (paramb.equals(this.aNM)); i = 0)
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
    if (paramb.equals(this.aNN))
    {
      AppMethodBeat.o(77691);
      return;
    }
    if (this.aNd != null) {
      this.aNd.f(this);
    }
    if (!this.aNN.isComplete()) {
      this.aNN.clear();
    }
    AppMethodBeat.o(77691);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77692);
    if (!paramb.equals(this.aNM))
    {
      AppMethodBeat.o(77692);
      return;
    }
    if (this.aNd != null) {
      this.aNd.g(this);
    }
    AppMethodBeat.o(77692);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77700);
    boolean bool = this.aNM.isCancelled();
    AppMethodBeat.o(77700);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77698);
    if ((this.aNM.isComplete()) || (this.aNN.isComplete()))
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
    boolean bool = this.aNM.isFailed();
    AppMethodBeat.o(77701);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(77697);
    boolean bool = this.aNM.isRunning();
    AppMethodBeat.o(77697);
    return bool;
  }
  
  public final boolean pR()
  {
    AppMethodBeat.i(77699);
    if ((this.aNM.pR()) || (this.aNN.pR()))
    {
      AppMethodBeat.o(77699);
      return true;
    }
    AppMethodBeat.o(77699);
    return false;
  }
  
  public final boolean pS()
  {
    AppMethodBeat.i(77690);
    if ((ql()) || (pR()))
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
    this.aNM.pause();
    this.aNN.pause();
    AppMethodBeat.o(77695);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77702);
    this.aNM.recycle();
    this.aNN.recycle();
    AppMethodBeat.o(77702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.h
 * JD-Core Version:    0.7.0.1
 */