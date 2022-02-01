package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class a$a
  extends n
{
  private final k.a uZN;
  private final k.b uZO;
  
  public a$a()
  {
    AppMethodBeat.i(21369);
    this.uZN = new k.a();
    this.uZO = new k.b();
    AppMethodBeat.o(21369);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.uZN;
  }
  
  public final l.e getRespObj()
  {
    return this.uZO;
  }
  
  public final int getType()
  {
    return 1000;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a.a
 * JD-Core Version:    0.7.0.1
 */