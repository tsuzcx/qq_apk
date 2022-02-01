package com.bumptech.glide.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements c, d
{
  private c aNE;
  private c aNF;
  private final d aNi;
  private boolean isRunning;
  
  i()
  {
    this(null);
  }
  
  public i(d paramd)
  {
    this.aNi = paramd;
  }
  
  private boolean qm()
  {
    AppMethodBeat.i(77693);
    if ((this.aNi != null) && (this.aNi.qd()))
    {
      AppMethodBeat.o(77693);
      return true;
    }
    AppMethodBeat.o(77693);
    return false;
  }
  
  public final void a(c paramc1, c paramc2)
  {
    this.aNE = paramc1;
    this.aNF = paramc2;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(77703);
    if ((paramc instanceof i))
    {
      paramc = (i)paramc;
      if (this.aNE == null)
      {
        if (paramc.aNE != null) {
          break label68;
        }
        if (this.aNF != null) {
          break label75;
        }
        if (paramc.aNF != null) {
          break label68;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77703);
        return true;
        if (this.aNE.a(paramc.aNE)) {
          break;
        }
        label68:
        label75:
        do
        {
          AppMethodBeat.o(77703);
          return false;
        } while (!this.aNF.a(paramc.aNF));
      }
    }
    AppMethodBeat.o(77703);
    return false;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(77687);
    if ((this.aNi == null) || (this.aNi.b(this))) {}
    for (int i = 1; (i != 0) && ((paramc.equals(this.aNE)) || (!this.aNE.qb())); i = 0)
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
    if ((!this.aNE.isComplete()) && (!this.aNF.isRunning())) {
      this.aNF.begin();
    }
    if ((this.isRunning) && (!this.aNE.isRunning())) {
      this.aNE.begin();
    }
    AppMethodBeat.o(77694);
  }
  
  public final boolean c(c paramc)
  {
    AppMethodBeat.i(77688);
    if ((this.aNi == null) || (this.aNi.c(this))) {}
    for (int i = 1; (i != 0) && (paramc.equals(this.aNE)) && (!qd()); i = 0)
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
    this.aNF.clear();
    this.aNE.clear();
    AppMethodBeat.o(77696);
  }
  
  public final boolean d(c paramc)
  {
    AppMethodBeat.i(77689);
    if ((this.aNi == null) || (this.aNi.d(this))) {}
    for (int i = 1; (i != 0) && (paramc.equals(this.aNE)); i = 0)
    {
      AppMethodBeat.o(77689);
      return true;
    }
    AppMethodBeat.o(77689);
    return false;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(77691);
    if (paramc.equals(this.aNF))
    {
      AppMethodBeat.o(77691);
      return;
    }
    if (this.aNi != null) {
      this.aNi.f(this);
    }
    if (!this.aNF.isComplete()) {
      this.aNF.clear();
    }
    AppMethodBeat.o(77691);
  }
  
  public final void g(c paramc)
  {
    AppMethodBeat.i(77692);
    if (!paramc.equals(this.aNE))
    {
      AppMethodBeat.o(77692);
      return;
    }
    if (this.aNi != null) {
      this.aNi.g(this);
    }
    AppMethodBeat.o(77692);
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77698);
    if ((this.aNE.isComplete()) || (this.aNF.isComplete()))
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
    boolean bool = this.aNE.isFailed();
    AppMethodBeat.o(77701);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(77697);
    boolean bool = this.aNE.isRunning();
    AppMethodBeat.o(77697);
    return bool;
  }
  
  public final boolean qb()
  {
    AppMethodBeat.i(77699);
    if ((this.aNE.qb()) || (this.aNF.qb()))
    {
      AppMethodBeat.o(77699);
      return true;
    }
    AppMethodBeat.o(77699);
    return false;
  }
  
  public final boolean qc()
  {
    AppMethodBeat.i(204492);
    boolean bool = this.aNE.qc();
    AppMethodBeat.o(204492);
    return bool;
  }
  
  public final boolean qd()
  {
    AppMethodBeat.i(77690);
    if ((qm()) || (qb()))
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
    this.aNE.recycle();
    this.aNF.recycle();
    AppMethodBeat.o(77702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.i
 * JD-Core Version:    0.7.0.1
 */