package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;

public final class h$a
  extends k
{
  private final p.a fOK;
  private final p.b fOL;
  
  public h$a()
  {
    AppMethodBeat.i(16567);
    this.fOK = new p.a();
    this.fOL = new p.b();
    AppMethodBeat.o(16567);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fOK;
  }
  
  public final l.e getRespObj()
  {
    return this.fOL;
  }
  
  public final int getType()
  {
    return 10;
  }
  
  public final String getUri()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h.a
 * JD-Core Version:    0.7.0.1
 */