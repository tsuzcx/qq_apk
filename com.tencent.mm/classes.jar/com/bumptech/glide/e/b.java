package com.bumptech.glide.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements c, d
{
  private final d aNi;
  private c aNj;
  private c aNk;
  
  public b(d paramd)
  {
    this.aNi = paramd;
  }
  
  private boolean e(c paramc)
  {
    AppMethodBeat.i(77632);
    if ((paramc.equals(this.aNj)) || ((this.aNj.isFailed()) && (paramc.equals(this.aNk))))
    {
      AppMethodBeat.o(77632);
      return true;
    }
    AppMethodBeat.o(77632);
    return false;
  }
  
  public final void a(c paramc1, c paramc2)
  {
    this.aNj = paramc1;
    this.aNk = paramc2;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(77628);
    if ((paramc instanceof b))
    {
      paramc = (b)paramc;
      if ((this.aNj.a(paramc.aNj)) && (this.aNk.a(paramc.aNk)))
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
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(77629);
    if ((this.aNi == null) || (this.aNi.b(this))) {}
    for (int i = 1; (i != 0) && (e(paramc)); i = 0)
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
    if (!this.aNj.isRunning()) {
      this.aNj.begin();
    }
    AppMethodBeat.o(77619);
  }
  
  public final boolean c(c paramc)
  {
    AppMethodBeat.i(77630);
    if ((this.aNi == null) || (this.aNi.c(this))) {}
    for (int i = 1; (i != 0) && (e(paramc)); i = 0)
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
    this.aNj.clear();
    if (this.aNk.isRunning()) {
      this.aNk.clear();
    }
    AppMethodBeat.o(77621);
  }
  
  public final boolean d(c paramc)
  {
    AppMethodBeat.i(77631);
    if ((this.aNi == null) || (this.aNi.d(this))) {}
    for (int i = 1; (i != 0) && (e(paramc)); i = 0)
    {
      AppMethodBeat.o(77631);
      return true;
    }
    AppMethodBeat.o(77631);
    return false;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(77634);
    if (this.aNi != null) {
      this.aNi.f(this);
    }
    AppMethodBeat.o(77634);
  }
  
  public final void g(c paramc)
  {
    AppMethodBeat.i(77635);
    if (!paramc.equals(this.aNk))
    {
      if (!this.aNk.isRunning()) {
        this.aNk.begin();
      }
      AppMethodBeat.o(77635);
      return;
    }
    if (this.aNi != null) {
      this.aNi.g(this);
    }
    AppMethodBeat.o(77635);
  }
  
  public final boolean isComplete()
  {
    AppMethodBeat.i(77623);
    if (this.aNj.isFailed())
    {
      bool = this.aNk.isComplete();
      AppMethodBeat.o(77623);
      return bool;
    }
    boolean bool = this.aNj.isComplete();
    AppMethodBeat.o(77623);
    return bool;
  }
  
  public final boolean isFailed()
  {
    AppMethodBeat.i(77626);
    if ((this.aNj.isFailed()) && (this.aNk.isFailed()))
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
    if (this.aNj.isFailed())
    {
      bool = this.aNk.isRunning();
      AppMethodBeat.o(77622);
      return bool;
    }
    boolean bool = this.aNj.isRunning();
    AppMethodBeat.o(77622);
    return bool;
  }
  
  public final boolean qb()
  {
    AppMethodBeat.i(77624);
    if (this.aNj.isFailed())
    {
      bool = this.aNk.qb();
      AppMethodBeat.o(77624);
      return bool;
    }
    boolean bool = this.aNj.qb();
    AppMethodBeat.o(77624);
    return bool;
  }
  
  public final boolean qc()
  {
    AppMethodBeat.i(204488);
    if (this.aNj.isFailed())
    {
      bool = this.aNk.qc();
      AppMethodBeat.o(204488);
      return bool;
    }
    boolean bool = this.aNj.qc();
    AppMethodBeat.o(204488);
    return bool;
  }
  
  public final boolean qd()
  {
    AppMethodBeat.i(77633);
    if ((this.aNi != null) && (this.aNi.qd())) {}
    for (int i = 1; (i != 0) || (qb()); i = 0)
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
    this.aNj.recycle();
    this.aNk.recycle();
    AppMethodBeat.o(77627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.b
 * JD-Core Version:    0.7.0.1
 */