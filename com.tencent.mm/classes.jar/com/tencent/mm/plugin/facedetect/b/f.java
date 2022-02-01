package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class f
  extends l
{
  j.a rnW;
  j.b rnX;
  
  f()
  {
    AppMethodBeat.i(103588);
    this.rnW = new j.a();
    this.rnX = new j.b();
    AppMethodBeat.o(103588);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.rnW;
  }
  
  public final l.e getRespObj()
  {
    return this.rnX;
  }
  
  public final int getType()
  {
    return 931;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/registerfacersa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.f
 * JD-Core Version:    0.7.0.1
 */