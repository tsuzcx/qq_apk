package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class i
  extends o
{
  j.b wvA;
  j.a wvz;
  
  i()
  {
    AppMethodBeat.i(103590);
    this.wvz = new j.a();
    this.wvA = new j.b();
    AppMethodBeat.o(103590);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.wvz;
  }
  
  public final l.e getRespObj()
  {
    return this.wvA;
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i
 * JD-Core Version:    0.7.0.1
 */