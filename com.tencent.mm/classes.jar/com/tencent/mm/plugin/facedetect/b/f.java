package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class f
  extends l
{
  j.a pNv;
  j.b pNw;
  
  f()
  {
    AppMethodBeat.i(103588);
    this.pNv = new j.a();
    this.pNw = new j.b();
    AppMethodBeat.o(103588);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.pNv;
  }
  
  public final l.e getRespObj()
  {
    return this.pNw;
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