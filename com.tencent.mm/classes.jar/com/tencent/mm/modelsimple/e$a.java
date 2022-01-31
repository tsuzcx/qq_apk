package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;

public final class e$a
  extends k
{
  private final m.a fOF;
  private final m.b fOG;
  
  public e$a()
  {
    AppMethodBeat.i(16553);
    this.fOF = new m.a();
    this.fOG = new m.b();
    AppMethodBeat.o(16553);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fOF;
  }
  
  public final l.e getRespObj()
  {
    return this.fOG;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.e.a
 * JD-Core Version:    0.7.0.1
 */