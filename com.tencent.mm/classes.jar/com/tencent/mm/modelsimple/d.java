package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;

final class d
  extends l
{
  private final z.a ikX;
  private final z.b ikY;
  
  d()
  {
    AppMethodBeat.i(150912);
    this.ikX = new z.a();
    this.ikY = new z.b();
    AppMethodBeat.o(150912);
  }
  
  public final l.d getReqObjImp()
  {
    return this.ikX;
  }
  
  public final l.e getRespObj()
  {
    return this.ikY;
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/sendcard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */