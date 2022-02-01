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
  private s<T> bNs;
  final f bOO;
  private final q<T> bPa;
  private final j<T> bPb;
  private final com.google.a.c.a<T> bPc;
  private final t bPd;
  private final k<T>.a bPe;
  
  public k(q<T> paramq, j<T> paramj, f paramf, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107986);
    this.bPe = new a((byte)0);
    this.bPa = paramq;
    this.bPb = paramj;
    this.bOO = paramf;
    this.bPc = parama;
    this.bPd = null;
    AppMethodBeat.o(107986);
  }
  
  public final void a(com.google.a.d.a parama, T paramT)
  {
    AppMethodBeat.i(107987);
    if (this.bPa == null)
    {
      s locals = this.bNs;
      if (locals != null) {}
      for (;;)
      {
        locals.a(parama, paramT);
        AppMethodBeat.o(107987);
        return;
        locals = this.bOO.a(this.bPd, this.bPc);
        this.bNs = locals;
      }
    }
    if (paramT == null)
    {
      parama.yS();
      AppMethodBeat.o(107987);
      return;
    }
    com.google.a.b.k.a(this.bPa.yA(), parama);
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