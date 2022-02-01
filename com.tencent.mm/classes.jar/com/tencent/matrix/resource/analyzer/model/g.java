package com.tencent.matrix.resource.analyzer.model;

import com.d.a.b.h;
import com.d.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class g
{
  public final l bUb;
  private final e cvU;
  
  public g(e parame)
  {
    this.cvU = ((e)com.tencent.matrix.resource.analyzer.a.b.checkNotNull(parame, "hprofFile"));
    parame = new h(new com.d.a.b.a.b(new File(i.k(q.B(parame.mUri), true)), (byte)0)).zQ();
    a.a(parame);
    this.bUb = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.g
 * JD-Core Version:    0.7.0.1
 */