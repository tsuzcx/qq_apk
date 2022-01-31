package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h
  extends k
{
  i.a mgK;
  i.b mgL;
  
  h()
  {
    AppMethodBeat.i(65);
    this.mgK = new i.a();
    this.mgL = new i.b();
    AppMethodBeat.o(65);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.mgK;
  }
  
  public final l.e getRespObj()
  {
    return this.mgL;
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