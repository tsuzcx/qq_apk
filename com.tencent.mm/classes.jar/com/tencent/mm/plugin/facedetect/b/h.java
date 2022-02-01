package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h
  extends l
{
  i.b pNA;
  i.a pNz;
  
  h()
  {
    AppMethodBeat.i(103590);
    this.pNz = new i.a();
    this.pNA = new i.b();
    AppMethodBeat.o(103590);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.pNz;
  }
  
  public final l.e getRespObj()
  {
    return this.pNA;
  }
  
  public final int getType()
  {
    return 733;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getbioconfigrsa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.h
 * JD-Core Version:    0.7.0.1
 */