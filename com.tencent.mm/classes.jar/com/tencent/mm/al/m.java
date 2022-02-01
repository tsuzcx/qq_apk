package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public final class m
  extends l
{
  private final t.a hOf;
  private final t.b hOg;
  
  public m()
  {
    AppMethodBeat.i(132307);
    this.hOf = new t.a();
    this.hOg = new t.b();
    AppMethodBeat.o(132307);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  protected final l.d getReqObjImp()
  {
    return this.hOf;
  }
  
  public final l.e getRespObj()
  {
    return this.hOg;
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
 * Qualified Name:     com.tencent.mm.al.m
 * JD-Core Version:    0.7.0.1
 */