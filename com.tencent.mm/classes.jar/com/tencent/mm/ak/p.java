package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public final class p
  extends o
{
  private final t.a iMg;
  private final t.b iMh;
  
  public p()
  {
    AppMethodBeat.i(132307);
    this.iMg = new t.a();
    this.iMh = new t.b();
    AppMethodBeat.o(132307);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  protected final l.d getReqObjImp()
  {
    return this.iMg;
  }
  
  public final l.e getRespObj()
  {
    return this.iMh;
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
 * Qualified Name:     com.tencent.mm.ak.p
 * JD-Core Version:    0.7.0.1
 */