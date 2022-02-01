package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends a<cbn, cbo>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64871);
    cbn localcbn = new cbn();
    localcbn.djj = paramString1;
    localcbn.Fpu = paramString2;
    localcbn.Fpv = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    this.ugo = localcbn;
    AppMethodBeat.o(64871);
  }
  
  protected final void cYA()
  {
    AppMethodBeat.i(64872);
    ac.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    AppMethodBeat.o(64872);
  }
  
  protected final void cYB()
  {
    AppMethodBeat.i(64873);
    ac.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
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