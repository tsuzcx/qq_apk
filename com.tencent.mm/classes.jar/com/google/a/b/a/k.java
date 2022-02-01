package com.google.a.b.a;

import com.google.a.f;
import com.google.a.j;
import com.google.a.q;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k<T>
  extends s<T>
{
  private s<T> bFw;
  final f bGS;
  private final q<T> bHe;
  private final j<T> bHf;
  private final com.google.a.c.a<T> bHg;
  private final t bHh;
  private final k<T>.a bHi;
  
  public k(q<T> paramq, j<T> paramj, f paramf, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107986);
    this.bHi = new a((byte)0);
    this.bHe = paramq;
    this.bHf = paramj;
    this.bGS = paramf;
    this.bHg = parama;
    this.bHh = null;
    AppMethodBeat.o(107986);
  }
  
  public final void a(com.google.a.d.a parama, T paramT)
  {
    AppMethodBeat.i(107987);
    if (this.bHe == null)
    {
      s locals = this.bFw;
      if (locals != null) {}
      for (;;)
      {
        locals.a(parama, paramT);
        AppMethodBeat.o(107987);
        return;
        locals = this.bGS.a(this.bHh, this.bHg);
        this.bFw = locals;
      }
    }
    if (paramT == null)
    {
      parama.xI();
      AppMethodBeat.o(107987);
      return;
    }
    com.google.a.b.k.a(this.bHe.xq(), parama);
    AppMethodBeat.o(107987);
  }
  
  final class a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */