package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;

public final class a$b
  extends l
{
  private final n.a hWW;
  private final n.b hWX;
  
  public a$b()
  {
    AppMethodBeat.i(134114);
    this.hWW = new n.a();
    this.hWX = new n.b();
    AppMethodBeat.o(134114);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.hWW;
  }
  
  public final l.e getRespObj()
  {
    return this.hWX;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a.b
 * JD-Core Version:    0.7.0.1
 */