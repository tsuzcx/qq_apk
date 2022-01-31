package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class f
  extends k
{
  j.a mgG;
  j.b mgH;
  
  f()
  {
    AppMethodBeat.i(63);
    this.mgG = new j.a();
    this.mgH = new j.b();
    AppMethodBeat.o(63);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.mgG;
  }
  
  public final l.e getRespObj()
  {
    return this.mgH;
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