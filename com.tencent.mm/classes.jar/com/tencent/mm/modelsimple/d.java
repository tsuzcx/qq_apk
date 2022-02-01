package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;

final class d
  extends l
{
  private final z.a hRJ;
  private final z.b hRK;
  
  d()
  {
    AppMethodBeat.i(150912);
    this.hRJ = new z.a();
    this.hRK = new z.b();
    AppMethodBeat.o(150912);
  }
  
  public final l.d getReqObjImp()
  {
    return this.hRJ;
  }
  
  public final l.e getRespObj()
  {
    return this.hRK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */