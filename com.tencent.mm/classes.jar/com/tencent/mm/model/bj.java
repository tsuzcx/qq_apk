package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;

public final class bj
  extends o
{
  private final x.a iDQ;
  private final x.b iDR;
  
  public bj()
  {
    AppMethodBeat.i(132250);
    this.iDQ = new x.a();
    this.iDR = new x.b();
    AppMethodBeat.o(132250);
  }
  
  public final l.d getReqObjImp()
  {
    return this.iDQ;
  }
  
  public final l.e getRespObj()
  {
    return this.iDR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bj
 * JD-Core Version:    0.7.0.1
 */