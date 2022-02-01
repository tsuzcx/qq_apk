package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;

public final class h$a
  extends n
{
  private final m.a oSf;
  private final m.b oSg;
  
  public h$a()
  {
    AppMethodBeat.i(20598);
    this.oSf = new m.a();
    this.oSg = new m.b();
    AppMethodBeat.o(20598);
  }
  
  public final l.d getReqObjImp()
  {
    return this.oSf;
  }
  
  public final l.e getRespObj()
  {
    return this.oSg;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h.a
 * JD-Core Version:    0.7.0.1
 */