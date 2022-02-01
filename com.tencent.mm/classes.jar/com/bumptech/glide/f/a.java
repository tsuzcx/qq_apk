package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements b, c
{
  private final c aNd;
  private b aNe;
  private b aNf;
  
  public a(c paramc)
  {
    this.aNd = paramc;
  }
  
  private boolean e(b paramb)
  {
    AppMethodBeat.i(77632);
    if ((paramb.equals(this.aNe)) || ((this.aNe.isFailed()) && (paramb.equals(this.aNf))))
    {
      AppMethodBeat.o(77632);
      return true;
    }
    AppMethodBeat.o(77632);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aNe = paramb1;
    this.aNf = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77628);
    if ((paramb instanceof a))
    {
      paramb = (a)paramb;
      if ((this.aNe.a(paramb.aNe)) && (this.aNf.a(paramb.aNf)))
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
    if ((this.aNd == null) || (this.aNd.b(this))) {}
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
    if (!this.aNe.isRunning()) {
      this.aNe.begin();
    }
    AppMethodBeat.o(77619);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77630);
    if ((this.aNd == null) || (this.aNd.c(this))) {}
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
    this.aNe.clear();
    if (this.aNf.isRunning()) {
      this.aNf.clear();
    }
    AppMethodBeat.o(77621);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77631);
    if ((this.aNd == null) || (this.aNd.d(this))) {}
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
    if (this.aNd != null) {
      this.aNd.f(this);
    }
    AppMethodBeat.o(77634);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77635);
    if (!paramb.equals(this.aNf))
    {
      if (!this.aNf.isRunning()) {
        this.aNf.begin();
      }
      AppMethodBeat.o(77635);
      return;
    }
    if (this.aNd != null) {
      this.aNd.g(this);
    }
    AppMethodBeat.o(77635);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77625);
    if (this.aNe.isFailed())
    {
      bool = this.aNf.isCancelled();
      AppMethodBeat.o(77625);
      return bool;
    }
    boolean bool = this.aNe.isCancelled();
    AppMethodBeat.o(77625);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77623);
    if (this.aNe.isFailed())
    {
      bool = this.aNf.isComplete();
      AppMethodBeat.o(77623);
      return bool;
    }
    boolean bool = this.aNe.isComplete();
    AppMethodBeat.o(77623);
    return bool;
  }
  
  public final boolean isFailed()
  {
    AppMethodBeat.i(77626);
    if ((this.aNe.isFailed()) && (this.aNf.isFailed()))
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
    if (this.aNe.isFailed())
    {
      bool = this.aNf.isRunning();
      AppMethodBeat.o(77622);
      return bool;
    }
    boolean bool = this.aNe.isRunning();
    AppMethodBeat.o(77622);
    return bool;
  }
  
  public final boolean pR()
  {
    AppMethodBeat.i(77624);
    if (this.aNe.isFailed())
    {
      bool = this.aNf.pR();
      AppMethodBeat.o(77624);
      return bool;
    }
    boolean bool = this.aNe.pR();
    AppMethodBeat.o(77624);
    return bool;
  }
  
  public final boolean pS()
  {
    AppMethodBeat.i(77633);
    if ((this.aNd != null) && (this.aNd.pS())) {}
    for (int i = 1; (i != 0) || (pR()); i = 0)
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
    if (!this.aNe.isFailed()) {
      this.aNe.pause();
    }
    if (this.aNf.isRunning()) {
      this.aNf.pause();
    }
    AppMethodBeat.o(77620);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77627);
    this.aNe.recycle();
    this.aNf.recycle();
    AppMethodBeat.o(77627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.a
 * JD-Core Version:    0.7.0.1
 */