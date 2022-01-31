package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;

public final class a$b
  extends k
{
  private final n.a fBo;
  private final n.b fBp;
  
  public a$b()
  {
    AppMethodBeat.i(123397);
    this.fBo = new n.a();
    this.fBp = new n.b();
    AppMethodBeat.o(123397);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.fBo;
  }
  
  public final l.e getRespObj()
  {
    return this.fBp;
  }
  
  public final int getType()
  {
    return 145;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/bindopmobileforreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a.b
 * JD-Core Version:    0.7.0.1
 */