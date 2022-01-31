package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, bwo parambwo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(20796);
    bAR();
    if ((8 != paramInt) || (9 != paramInt)) {
      ab.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    lz locallz = (lz)this.rr.fsV.fta;
    locallz.wxM = paramString1;
    locallz.wAu = parambwo;
    locallz.wkX = paramInt;
    locallz.wkY = paramString2;
    AppMethodBeat.o(20796);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20795);
    b.a locala = new b.a();
    locala.fsX = new lz();
    locala.fsY = new ma();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20795);
  }
  
  public final String bBd()
  {
    AppMethodBeat.i(20797);
    Object localObject = ((ma)this.rr.fsW.fta).wAv;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((di)((LinkedList)localObject).get(0)).wpz;
      AppMethodBeat.o(20797);
      return localObject;
    }
    AppMethodBeat.o(20797);
    return null;
  }
  
  public final int getType()
  {
    return 1705;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.k
 * JD-Core Version:    0.7.0.1
 */