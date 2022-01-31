package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;

public final class i$a
  extends k
{
  private final y.a fIK;
  private final y.b fIL;
  
  public i$a()
  {
    AppMethodBeat.i(58375);
    this.fIK = new y.a();
    this.fIL = new y.b();
    AppMethodBeat.o(58375);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.fIK;
  }
  
  public final l.e getRespObj()
  {
    return this.fIL;
  }
  
  public final int getType()
  {
    return 39;
  }
  
  public final String getUri()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i.a
 * JD-Core Version:    0.7.0.1
 */