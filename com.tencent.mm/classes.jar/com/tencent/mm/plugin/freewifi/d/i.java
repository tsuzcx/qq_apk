package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgx;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(24862);
    cUl();
    bgw localbgw = (bgw)this.rr.hQD.hQJ;
    localbgw.dnO = paramString1;
    localbgw.txG = paramString2;
    localbgw.txH = paramString3;
    localbgw.txI = paramString4;
    localbgw.dqk = paramString5;
    localbgw.FJg = paramString6;
    AppMethodBeat.o(24862);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24861);
    b.a locala = new b.a();
    locala.hQF = new bgw();
    locala.hQG = new bgx();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24861);
  }
  
  public final String cUu()
  {
    return ((bgx)this.rr.hQE.hQJ).tyL;
  }
  
  public final String cUv()
  {
    return ((bgx)this.rr.hQE.hQJ).tyM;
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */