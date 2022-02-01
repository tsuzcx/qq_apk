package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;

final class e
  extends o
{
  private final z.a jiY;
  private final z.b jiZ;
  
  e()
  {
    AppMethodBeat.i(150912);
    this.jiY = new z.a();
    this.jiZ = new z.b();
    AppMethodBeat.o(150912);
  }
  
  public final l.d getReqObjImp()
  {
    return this.jiY;
  }
  
  public final l.e getRespObj()
  {
    return this.jiZ;
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
 * Qualified Name:     com.tencent.mm.modelsimple.e
 * JD-Core Version:    0.7.0.1
 */