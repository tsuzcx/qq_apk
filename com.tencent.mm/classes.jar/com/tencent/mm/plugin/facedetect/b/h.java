package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h
  extends l
{
  i.a qwh;
  i.b qwi;
  
  h()
  {
    AppMethodBeat.i(103590);
    this.qwh = new i.a();
    this.qwi = new i.b();
    AppMethodBeat.o(103590);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.qwh;
  }
  
  public final l.e getRespObj()
  {
    return this.qwi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.h
 * JD-Core Version:    0.7.0.1
 */