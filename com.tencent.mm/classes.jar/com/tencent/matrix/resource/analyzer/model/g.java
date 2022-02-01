package com.tencent.matrix.resource.analyzer.model;

import com.e.a.b.h;
import com.e.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.File;

public final class g
{
  private final k cHy;
  public final l ceo;
  
  public g(k paramk)
  {
    this.cHy = ((k)com.tencent.matrix.resource.analyzer.a.b.checkNotNull(paramk, "hprofFile"));
    paramk = new h(new com.e.a.b.a.b(new File(o.k(w.B(paramk.mUri), true)), (byte)0)).Bo();
    a.a(paramk);
    this.ceo = paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.g
 * JD-Core Version:    0.7.0.1
 */