package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public final class o
  extends n
{
  private final t.a otX;
  private final t.b otY;
  
  public o()
  {
    AppMethodBeat.i(132307);
    this.otX = new t.a();
    this.otY = new t.b();
    AppMethodBeat.o(132307);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  protected final l.d getReqObjImp()
  {
    return this.otX;
  }
  
  public final l.e getRespObj()
  {
    return this.otY;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.o
 * JD-Core Version:    0.7.0.1
 */