package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class d
  extends o
{
  private static int jiX = 3941;
  private final l.e iNj;
  private final l.d req;
  
  public d()
  {
    AppMethodBeat.i(134153);
    this.req = new j.c();
    this.iNj = new j.d();
    AppMethodBeat.o(134153);
  }
  
  public final l.d getReqObjImp()
  {
    return this.req;
  }
  
  public final l.e getRespObj()
  {
    return this.iNj;
  }
  
  public final int getType()
  {
    return jiX;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/disasterauth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */