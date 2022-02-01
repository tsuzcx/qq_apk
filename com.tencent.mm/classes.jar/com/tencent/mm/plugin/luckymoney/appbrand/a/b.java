package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends a<cxf, cxg>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64871);
    cxf localcxf = new cxf();
    localcxf.dNI = paramString1;
    localcxf.MBB = paramString2;
    localcxf.MBC = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.yPr = localcxf;
    AppMethodBeat.o(64871);
  }
  
  protected final void eeD()
  {
    AppMethodBeat.i(64872);
    Log.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    AppMethodBeat.o(64872);
  }
  
  protected final void eeE()
  {
    AppMethodBeat.i(64873);
    Log.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.b
 * JD-Core Version:    0.7.0.1
 */