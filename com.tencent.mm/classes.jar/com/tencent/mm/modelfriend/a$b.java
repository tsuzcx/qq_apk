package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;

public final class a$b
  extends o
{
  private final n.a iUM;
  private final n.b iUN;
  
  public a$b()
  {
    AppMethodBeat.i(134114);
    this.iUM = new n.a();
    this.iUN = new n.b();
    AppMethodBeat.o(134114);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.iUM;
  }
  
  public final l.e getRespObj()
  {
    return this.iUN;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a.b
 * JD-Core Version:    0.7.0.1
 */