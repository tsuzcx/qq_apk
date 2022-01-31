package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class e$b
  extends k
{
  private final s.a fIv;
  private final s.b fIw;
  
  public e$b()
  {
    AppMethodBeat.i(58361);
    this.fIv = new s.a();
    this.fIw = new s.b();
    AppMethodBeat.o(58361);
  }
  
  public final l.d getReqObjImp()
  {
    return this.fIv;
  }
  
  public final l.e getRespObj()
  {
    return this.fIw;
  }
  
  public final int getType()
  {
    return 139;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/newinit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e.b
 * JD-Core Version:    0.7.0.1
 */