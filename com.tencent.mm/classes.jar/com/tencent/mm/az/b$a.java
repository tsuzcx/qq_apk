package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class b$a
  extends k
{
  private final b.b fLI;
  private final b.c fLJ;
  
  public b$a()
  {
    AppMethodBeat.i(59986);
    this.fLI = new b.b();
    this.fLJ = new b.c();
    AppMethodBeat.o(59986);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fLI;
  }
  
  public final l.e getRespObj()
  {
    return this.fLJ;
  }
  
  public final int getType()
  {
    return 681;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/oplog";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.az.b.a
 * JD-Core Version:    0.7.0.1
 */