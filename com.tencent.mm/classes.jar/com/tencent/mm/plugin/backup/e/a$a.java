package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class a$a
  extends l
{
  private final k.a nwj;
  private final k.b nwk;
  
  public a$a()
  {
    AppMethodBeat.i(21369);
    this.nwj = new k.a();
    this.nwk = new k.b();
    AppMethodBeat.o(21369);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.nwj;
  }
  
  public final l.e getRespObj()
  {
    return this.nwk;
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