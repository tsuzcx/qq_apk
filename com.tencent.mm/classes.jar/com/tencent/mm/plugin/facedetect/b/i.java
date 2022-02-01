package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class i
  extends n
{
  j.a zRE;
  j.b zRF;
  
  i()
  {
    AppMethodBeat.i(103590);
    this.zRE = new j.a();
    this.zRF = new j.b();
    AppMethodBeat.o(103590);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.zRE;
  }
  
  public final l.e getRespObj()
  {
    return this.zRF;
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i
 * JD-Core Version:    0.7.0.1
 */