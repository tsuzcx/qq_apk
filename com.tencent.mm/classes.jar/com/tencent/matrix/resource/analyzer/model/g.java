package com.tencent.matrix.resource.analyzer.model;

import com.e.a.b.h;
import com.e.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class g
{
  private final e cGP;
  public final l ceo;
  
  public g(e parame)
  {
    this.cGP = ((e)com.tencent.matrix.resource.analyzer.a.b.checkNotNull(parame, "hprofFile"));
    parame = new h(new com.e.a.b.a.b(new File(i.k(q.B(parame.mUri), true)), (byte)0)).Bn();
    a.a(parame);
    this.ceo = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.g
 * JD-Core Version:    0.7.0.1
 */