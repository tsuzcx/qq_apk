package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<cgy, cgz>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64871);
    cgy localcgy = new cgy();
    localcgy.dwb = paramString1;
    localcgy.HsF = paramString2;
    localcgy.HsG = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    this.vvd = localcgy;
    AppMethodBeat.o(64871);
  }
  
  protected final void dkL()
  {
    AppMethodBeat.i(64872);
    ae.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    AppMethodBeat.o(64872);
  }
  
  protected final void dkM()
  {
    AppMethodBeat.i(64873);
    ae.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
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