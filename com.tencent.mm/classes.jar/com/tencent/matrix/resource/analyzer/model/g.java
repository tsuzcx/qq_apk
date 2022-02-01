package com.tencent.matrix.resource.analyzer.model;

import com.c.a.b.h;
import com.c.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;

public final class g
{
  private final o cXW;
  public final l coS;
  
  public g(o paramo)
  {
    this.cXW = ((o)com.tencent.matrix.resource.analyzer.a.b.checkNotNull(paramo, "hprofFile"));
    paramo = new h(new com.c.a.b.a.b(new File(s.k(aa.z(paramo.mUri), true)), (byte)0)).Kh();
    a.a(paramo);
    this.coS = paramo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.g
 * JD-Core Version:    0.7.0.1
 */