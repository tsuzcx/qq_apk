package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcd;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(24862);
    cJr();
    bcc localbcc = (bcc)this.rr.hvr.hvw;
    localbcc.dbq = paramString1;
    localbcc.sqm = paramString2;
    localbcc.sqn = paramString3;
    localbcc.sqo = paramString4;
    localbcc.ddJ = paramString5;
    localbcc.DLD = paramString6;
    AppMethodBeat.o(24862);
  }
  
  public final String cJA()
  {
    return ((bcd)this.rr.hvs.hvw).srs;
  }
  
  public final String cJB()
  {
    return ((bcd)this.rr.hvs.hvw).srt;
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24861);
    b.a locala = new b.a();
    locala.hvt = new bcc();
    locala.hvu = new bcd();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24861);
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */