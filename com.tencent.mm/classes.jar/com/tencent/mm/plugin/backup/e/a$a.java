package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class a$a
  extends k
{
  private final k.a jCo;
  private final k.b jCp;
  
  public a$a()
  {
    AppMethodBeat.i(17311);
    this.jCo = new k.a();
    this.jCp = new k.b();
    AppMethodBeat.o(17311);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.jCo;
  }
  
  public final l.e getRespObj()
  {
    return this.jCp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a.a
 * JD-Core Version:    0.7.0.1
 */