package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements b, c
{
  private final c aKw;
  private b aKx;
  private b aKy;
  
  public a(c paramc)
  {
    this.aKw = paramc;
  }
  
  private boolean e(b paramb)
  {
    AppMethodBeat.i(77632);
    if ((paramb.equals(this.aKx)) || ((this.aKx.isFailed()) && (paramb.equals(this.aKy))))
    {
      AppMethodBeat.o(77632);
      return true;
    }
    AppMethodBeat.o(77632);
    return false;
  }
  
  public final void a(b paramb1, b paramb2)
  {
    this.aKx = paramb1;
    this.aKy = paramb2;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77628);
    if ((paramb instanceof a))
    {
      paramb = (a)paramb;
      if ((this.aKx.a(paramb.aKx)) && (this.aKy.a(paramb.aKy)))
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
    if ((this.aKw == null) || (this.aKw.b(this))) {}
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
    if (!this.aKx.isRunning()) {
      this.aKx.begin();
    }
    AppMethodBeat.o(77619);
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(77630);
    if ((this.aKw == null) || (this.aKw.c(this))) {}
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
    this.aKx.clear();
    if (this.aKy.isRunning()) {
      this.aKy.clear();
    }
    AppMethodBeat.o(77621);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(77631);
    if ((this.aKw == null) || (this.aKw.d(this))) {}
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
    if (this.aKw != null) {
      this.aKw.f(this);
    }
    AppMethodBeat.o(77634);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(77635);
    if (!paramb.equals(this.aKy))
    {
      if (!this.aKy.isRunning()) {
        this.aKy.begin();
      }
      AppMethodBeat.o(77635);
      return;
    }
    if (this.aKw != null) {
      this.aKw.g(this);
    }
    AppMethodBeat.o(77635);
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(77625);
    if (this.aKx.isFailed())
    {
      bool = this.aKy.isCancelled();
      AppMethodBeat.o(77625);
      return bool;
    }
    boolean bool = this.aKx.isCancelled();
    AppMethodBeat.o(77625);
    return bool;
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77623);
    if (this.aKx.isFailed())
    {
      bool = this.aKy.isComplete();
      AppMethodBeat.o(77623);
      return bool;
    }
    boolean bool = this.aKx.isComplete();
    AppMethodBeat.o(77623);
    return bool;
  }
  
  public final boolean isFailed()
  {
    AppMethodBeat.i(77626);
    if ((this.aKx.isFailed()) && (this.aKy.isFailed()))
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
    if (this.aKx.isFailed())
    {
      bool = this.aKy.isRunning();
      AppMethodBeat.o(77622);
      return bool;
    }
    boolean bool = this.aKx.isRunning();
    AppMethodBeat.o(77622);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77620);
    if (!this.aKx.isFailed()) {
      this.aKx.pause();
    }
    if (this.aKy.isRunning()) {
      this.aKy.pause();
    }
    AppMethodBeat.o(77620);
  }
  
  public final boolean pp()
  {
    AppMethodBeat.i(77624);
    if (this.aKx.isFailed())
    {
      bool = this.aKy.pp();
      AppMethodBeat.o(77624);
      return bool;
    }
    boolean bool = this.aKx.pp();
    AppMethodBeat.o(77624);
    return bool;
  }
  
  public final boolean pq()
  {
    AppMethodBeat.i(77633);
    if ((this.aKw != null) && (this.aKw.pq())) {}
    for (int i = 1; (i != 0) || (pp()); i = 0)
    {
      AppMethodBeat.o(77633);
      return true;
    }
    AppMethodBeat.o(77633);
    return false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77627);
    this.aKx.recycle();
    this.aKy.recycle();
    AppMethodBeat.o(77627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.f.a
 * JD-Core Version:    0.7.0.1
 */