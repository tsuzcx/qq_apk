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
  private final z.a hrh;
  private final z.b hri;
  
  d()
  {
    AppMethodBeat.i(150912);
    this.hrh = new z.a();
    this.hri = new z.b();
    AppMethodBeat.o(150912);
  }
  
  public final l.d getReqObjImp()
  {
    return this.hrh;
  }
  
  public final l.e getRespObj()
  {
    return this.hri;
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