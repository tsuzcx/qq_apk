package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public final class m
  extends l
{
  private final t.a hvQ;
  private final t.b hvR;
  
  public m()
  {
    AppMethodBeat.i(132307);
    this.hvQ = new t.a();
    this.hvR = new t.b();
    AppMethodBeat.o(132307);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  protected final l.d getReqObjImp()
  {
    return this.hvQ;
  }
  
  public final l.e getRespObj()
  {
    return this.hvR;
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
 * Qualified Name:     com.tencent.mm.ak.m
 * JD-Core Version:    0.7.0.1
 */