package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(24849);
    cJr();
    ve localve = (ve)this.rr.hvr.hvw;
    localve.Epm = paramString1;
    localve.Epn = paramString2;
    localve.Epo = paramString3;
    localve.Epp = paramString4;
    localve.Epq = paramString5;
    localve.Epr = paramLong;
    localve.Eps = paramString6;
    localve.Ept = paramString7;
    AppMethodBeat.o(24849);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24848);
    b.a locala = new b.a();
    locala.hvt = new ve();
    locala.hvu = new vf();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24848);
  }
  
  public final vf cJx()
  {
    return (vf)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */