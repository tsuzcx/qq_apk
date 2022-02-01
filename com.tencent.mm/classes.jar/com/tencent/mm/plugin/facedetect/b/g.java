package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class g
  extends l
{
  k.a rnY;
  k.b rnZ;
  
  g()
  {
    AppMethodBeat.i(103589);
    this.rnY = new k.a();
    this.rnZ = new k.b();
    AppMethodBeat.o(103589);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.rnY;
  }
  
  public final l.e getRespObj()
  {
    return this.rnZ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.g
 * JD-Core Version:    0.7.0.1
 */