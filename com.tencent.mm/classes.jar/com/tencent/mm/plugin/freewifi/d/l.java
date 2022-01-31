package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.caz;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(20799);
    bAR();
    cay localcay = (cay)this.rr.fsV.fta;
    localcay.appId = paramString1;
    localcay.mOs = paramInt;
    localcay.crs = paramString2;
    AppMethodBeat.o(20799);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20798);
    b.a locala = new b.a();
    locala.fsX = new cay();
    locala.fsY = new caz();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20798);
  }
  
  public final int getType()
  {
    return 1761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.l
 * JD-Core Version:    0.7.0.1
 */