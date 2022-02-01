package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class c
  extends l
{
  private static int hRI = 3941;
  private final l.e hwQ;
  private final l.d req;
  
  public c()
  {
    AppMethodBeat.i(134153);
    this.req = new j.c();
    this.hwQ = new j.d();
    AppMethodBeat.o(134153);
  }
  
  public final l.d getReqObjImp()
  {
    return this.req;
  }
  
  public final l.e getRespObj()
  {
    return this.hwQ;
  }
  
  public final int getType()
  {
    return hRI;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/disasterauth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */