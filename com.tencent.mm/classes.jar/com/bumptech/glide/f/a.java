package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements b, c
{
  private final c aLm;
  private b aLn;
  private b aLo;
  
  public a(c paramc)
  {
    this.aLm = paramc;
  }
  
  private boolean e(b paramb)
  {
    AppMethodBeat.i(77632);
    if ((paramb.equals(this.aLn)) || ((this.aLn.isFailed()) && (paramb.equals(this.aLo))))
    {
      AppMethodBeat.o(77632);
      return true;
    }
    AppMethodBeat.o(77632);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aLn = paramb1;
    this.aLo = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77628);
    if ((paramb instanceof a))
    {
      paramb = (a)paramb;
      if ((this.aLn.a(paramb.aLn)) && (this.aLo.a(paramb.aLo)))
      {
        AppMethodBeat.o(77628);
        return true;
      }
      AppMethodBeat.o(77628);
      return false;
    }
    AppMethodBeat.o(77628);
    return false;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(77629);
    if ((this.aLm == null) || (this.aLm.b(this))) {}
    for (int i = 1; (i != 0) && (e(paramb)); i = 0)
    {
      AppMethodBeat.o(77629);
      return true;
    }
    AppMethodBeat.o(77629);
    return false;
  }
  
  public final void begin()
  {
    AppMethodBeat.i(77619);
    if (!this.aLn.isRunning()) {
      this.aLn.begin();
    }
    AppMethodBeat.o(77619);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77630);
    if ((this.aLm == null) || (this.aLm.c(this))) {}
    for (int i = 1; (i != 0) && (e(paramb)); i = 0)
    {
      AppMethodBeat.o(77630);
      return true;
    }
    AppMethodBeat.o(77630);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(77621);
    this.aLn.clear();
    if (this.aLo.isRunning()) {
      this.aLo.clear();
    }
    AppMethodBeat.o(77621);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77631);
    if ((this.aLm == null) || (this.aLm.d(this))) {}
    for (int i = 1; (i != 0) && (e(paramb)); i = 0)
    {
      AppMethodBeat.o(77631);
      return true;
    }
    AppMethodBeat.o(77631);
    return false;
  }
  
  public final void f(b paramb)
  {
    AppMethodBeat.i(77634);
    if (this.aLm != null) {
      this.aLm.f(this);
    }
    AppMethodBeat.o(77634);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77635);
    if (!paramb.equals(this.aLo))
    {
      if (!this.aLo.isRunning()) {
        this.aLo.begin();
      }
      AppMethodBeat.o(77635);
      return;
    }
    if (this.aLm != null) {
      this.aLm.g(this);
    }
    AppMethodBeat.o(77635);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77625);
    if (this.aLn.isFailed())
    {
      bool = this.aLo.isCancelled();
      AppMethodBeat.o(77625);
      return bool;
    }
    boolean bool = this.aLn.isCancelled();
    AppMethodBeat.o(77625);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77623);
    if (this.aLn.isFailed())
    {
      bool = this.aLo.isComplete();
      AppMethodBeat.o(77623);
      return bool;
    }
    boolean bool = this.aLn.isComplete();
    AppMethodBeat.o(77623);
    return bool;
  }
  
  public final boolean isFailed()
  {
    AppMethodBeat.i(77626);
    if ((this.aLn.isFailed()) && (this.aLo.isFailed()))
    {
      AppMethodBeat.o(77626);
      return true;
    }
    AppMethodBeat.o(77626);
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(77622);
    if (this.aLn.isFailed())
    {
      bool = this.aLo.isRunning();
      AppMethodBeat.o(77622);
      return bool;
    }
    boolean bool = this.aLn.isRunning();
    AppMethodBeat.o(77622);
    return bool;
  }
  
  public final boolean pA()
  {
    AppMethodBeat.i(77633);
    if ((this.aLm != null) && (this.aLm.pA())) {}
    for (int i = 1; (i != 0) || (pz()); i = 0)
    {
      AppMethodBeat.o(77633);
      return true;
    }
    AppMethodBeat.o(77633);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77620);
    if (!this.aLn.isFailed()) {
      this.aLn.pause();
    }
    if (this.aLo.isRunning()) {
      this.aLo.pause();
    }
    AppMethodBeat.o(77620);
  }
  
  public final boolean pz()
  {
    AppMethodBeat.i(77624);
    if (this.aLn.isFailed())
    {
      bool = this.aLo.pz();
      AppMethodBeat.o(77624);
      return bool;
    }
    boolean bool = this.aLn.pz();
    AppMethodBeat.o(77624);
    return bool;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77627);
    this.aLn.recycle();
    this.aLo.recycle();
    AppMethodBeat.o(77627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.a
 * JD-Core Version:    0.7.0.1
 */