package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;

public final class bc
  extends l
{
  private final x.a gNw;
  private final x.b gNx;
  
  public bc()
  {
    AppMethodBeat.i(132250);
    this.gNw = new x.a();
    this.gNx = new x.b();
    AppMethodBeat.o(132250);
  }
  
  public final l.d getReqObjImp()
  {
    return this.gNw;
  }
  
  public final l.e getRespObj()
  {
    return this.gNx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bc
 * JD-Core Version:    0.7.0.1
 */