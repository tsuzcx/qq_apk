package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class z$a
  extends k
{
  private r.a gyb;
  private r.b gyc;
  
  public z$a()
  {
    AppMethodBeat.i(108436);
    this.gyb = new r.a();
    this.gyc = new r.b();
    AppMethodBeat.o(108436);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.gyb;
  }
  
  public final l.e getRespObj()
  {
    return this.gyc;
  }
  
  public final int getType()
  {
    return 481;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/emailreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z.a
 * JD-Core Version:    0.7.0.1
 */