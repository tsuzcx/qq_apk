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
  private s<T> bDe;
  final f bEA;
  private final q<T> bEM;
  private final j<T> bEN;
  private final com.google.a.c.a<T> bEO;
  private final t bEP;
  private final k<T>.a bEQ;
  
  public k(q<T> paramq, j<T> paramj, f paramf, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107986);
    this.bEQ = new a((byte)0);
    this.bEM = paramq;
    this.bEN = paramj;
    this.bEA = paramf;
    this.bEO = parama;
    this.bEP = null;
    AppMethodBeat.o(107986);
  }
  
  public final void a(com.google.a.d.a parama, T paramT)
  {
    AppMethodBeat.i(107987);
    if (this.bEM == null)
    {
      s locals = this.bDe;
      if (locals != null) {}
      for (;;)
      {
        locals.a(parama, paramT);
        AppMethodBeat.o(107987);
        return;
        locals = this.bEA.a(this.bEP, this.bEO);
        this.bDe = locals;
      }
    }
    if (paramT == null)
    {
      parama.xv();
      AppMethodBeat.o(107987);
      return;
    }
    com.google.a.b.k.a(this.bEM.xd(), parama);
    AppMethodBeat.o(107987);
  }
  
  final class a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */