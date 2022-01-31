package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.r.b;

public final class l
  extends k
{
  private final r.a ftk;
  private final r.b ftl;
  
  public l()
  {
    AppMethodBeat.i(58161);
    this.ftk = new r.a();
    this.ftl = new r.b();
    AppMethodBeat.o(58161);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  protected final l.d getReqObjImp()
  {
    return this.ftk;
  }
  
  public final l.e getRespObj()
  {
    return this.ftl;
  }
  
  public final int getType()
  {
    return 381;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getcert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.l
 * JD-Core Version:    0.7.0.1
 */