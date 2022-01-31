package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;

final class d
  extends k
{
  private final x.a fOD;
  private final x.b fOE;
  
  d()
  {
    AppMethodBeat.i(78563);
    this.fOD = new x.a();
    this.fOE = new x.b();
    AppMethodBeat.o(78563);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fOD;
  }
  
  public final l.e getRespObj()
  {
    return this.fOE;
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/sendcard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */