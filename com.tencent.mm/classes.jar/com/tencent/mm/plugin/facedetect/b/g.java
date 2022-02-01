package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class g
  extends o
{
  k.a sPD;
  k.b sPE;
  
  g()
  {
    AppMethodBeat.i(103589);
    this.sPD = new k.a();
    this.sPE = new k.b();
    AppMethodBeat.o(103589);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.sPD;
  }
  
  public final l.e getRespObj()
  {
    return this.sPE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.g
 * JD-Core Version:    0.7.0.1
 */