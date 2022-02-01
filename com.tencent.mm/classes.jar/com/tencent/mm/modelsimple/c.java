package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class c
  extends l
{
  private static int hrg = 3941;
  private final l.e gWr;
  private final l.d req;
  
  public c()
  {
    AppMethodBeat.i(134153);
    this.req = new j.c();
    this.gWr = new j.d();
    AppMethodBeat.o(134153);
  }
  
  public final l.d getReqObjImp()
  {
    return this.req;
  }
  
  public final l.e getRespObj()
  {
    return this.gWr;
  }
  
  public final int getType()
  {
    return hrg;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/disasterauth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */