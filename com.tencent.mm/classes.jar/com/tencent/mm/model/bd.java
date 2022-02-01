package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;

public final class bd
  extends l
{
  private final x.a hGo;
  private final x.b hGp;
  
  public bd()
  {
    AppMethodBeat.i(132250);
    this.hGo = new x.a();
    this.hGp = new x.b();
    AppMethodBeat.o(132250);
  }
  
  public final l.d getReqObjImp()
  {
    return this.hGo;
  }
  
  public final l.e getRespObj()
  {
    return this.hGp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bd
 * JD-Core Version:    0.7.0.1
 */