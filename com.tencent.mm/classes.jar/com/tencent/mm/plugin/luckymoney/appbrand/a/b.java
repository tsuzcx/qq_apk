package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<bwt, bwu>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64871);
    bwt localbwt = new bwt();
    localbwt.dlB = paramString1;
    localbwt.DSY = paramString2;
    localbwt.DSZ = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    this.sYa = localbwt;
    AppMethodBeat.o(64871);
  }
  
  protected final void cKU()
  {
    AppMethodBeat.i(64872);
    ad.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    AppMethodBeat.o(64872);
  }
  
  protected final void cKV()
  {
    AppMethodBeat.i(64873);
    ad.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
    AppMethodBeat.o(64873);
  }
  
  public final int getFuncId()
  {
    return 2701;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.b
 * JD-Core Version:    0.7.0.1
 */