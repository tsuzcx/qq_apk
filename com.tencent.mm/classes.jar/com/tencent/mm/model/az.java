package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;

public final class az
  extends k
{
  private final v.a fmi;
  private final v.b fmj;
  
  public az()
  {
    AppMethodBeat.i(58106);
    this.fmi = new v.a();
    this.fmj = new v.b();
    AppMethodBeat.o(58106);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fmi;
  }
  
  public final l.e getRespObj()
  {
    return this.fmj;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/newreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.az
 * JD-Core Version:    0.7.0.1
 */