package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;

public final class b$a
  implements com.tencent.mm.network.q
{
  private final t.a fIf;
  private final t.b fIg;
  private final boolean fIh;
  int uin;
  
  public b$a()
  {
    AppMethodBeat.i(58349);
    this.fIf = new t.a();
    this.fIg = new t.b();
    this.fIh = false;
    AppMethodBeat.o(58349);
  }
  
  public b$a(t.b paramb)
  {
    AppMethodBeat.i(58350);
    this.fIf = new t.a();
    this.fIg = paramb;
    this.fIh = true;
    AppMethodBeat.o(58350);
  }
  
  public final boolean getIsUserCmd()
  {
    return false;
  }
  
  public final int getOptions()
  {
    return 0;
  }
  
  public final l.d getReqObj()
  {
    AppMethodBeat.i(58351);
    this.fIf.setDeviceID(com.tencent.mm.compatible.e.q.LK());
    this.fIf.setDeviceType(d.eQs);
    this.fIf.setClientVersion(d.whH);
    this.fIf.setUin(this.uin);
    t.a locala = this.fIf;
    AppMethodBeat.o(58351);
    return locala;
  }
  
  public final l.e getRespObj()
  {
    return this.fIg;
  }
  
  public final int getTimeOut()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/newsync";
  }
  
  public final boolean isSingleSession()
  {
    return true;
  }
  
  public final void setConnectionInfo(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b.a
 * JD-Core Version:    0.7.0.1
 */