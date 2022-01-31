package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class g
  extends k
{
  k.a mgI;
  k.b mgJ;
  
  g()
  {
    AppMethodBeat.i(64);
    this.mgI = new k.a();
    this.mgJ = new k.b();
    AppMethodBeat.o(64);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.mgI;
  }
  
  public final l.e getRespObj()
  {
    return this.mgJ;
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.g
 * JD-Core Version:    0.7.0.1
 */