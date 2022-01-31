package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public final class ad$a
  extends k
{
  private final t.a gyg;
  private final t.b gyh;
  
  public ad$a()
  {
    AppMethodBeat.i(108456);
    this.gyg = new t.a();
    this.gyh = new t.b();
    AppMethodBeat.o(108456);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.gyg;
  }
  
  public final l.e getRespObj()
  {
    return this.gyh;
  }
  
  public final int getType()
  {
    return 429;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getsuggestalias";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad.a
 * JD-Core Version:    0.7.0.1
 */