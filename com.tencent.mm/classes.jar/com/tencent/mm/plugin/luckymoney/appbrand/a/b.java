package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a<bjh, bji>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41983);
    bjh localbjh = new bjh();
    localbjh.cwc = paramString1;
    localbjh.xxB = paramString2;
    localbjh.xxC = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    this.oin = localbjh;
    AppMethodBeat.o(41983);
  }
  
  protected final void bML()
  {
    AppMethodBeat.i(41984);
    ab.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    AppMethodBeat.o(41984);
  }
  
  protected final void bMM()
  {
    AppMethodBeat.i(41985);
    ab.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
    AppMethodBeat.o(41985);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.b
 * JD-Core Version:    0.7.0.1
 */