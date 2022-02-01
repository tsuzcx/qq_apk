package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h
  extends n
{
  l.a zRC;
  l.b zRD;
  
  h()
  {
    AppMethodBeat.i(103589);
    this.zRC = new l.a();
    this.zRD = new l.b();
    AppMethodBeat.o(103589);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.zRC;
  }
  
  public final l.e getRespObj()
  {
    return this.zRD;
  }
  
  public final int getType()
  {
    return 930;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/verifyfacersa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.h
 * JD-Core Version:    0.7.0.1
 */