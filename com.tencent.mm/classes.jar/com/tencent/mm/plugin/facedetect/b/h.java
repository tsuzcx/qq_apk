package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h
  extends o
{
  i.a sPF;
  i.b sPG;
  
  h()
  {
    AppMethodBeat.i(103590);
    this.sPF = new i.a();
    this.sPG = new i.b();
    AppMethodBeat.o(103590);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.sPF;
  }
  
  public final l.e getRespObj()
  {
    return this.sPG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.h
 * JD-Core Version:    0.7.0.1
 */