package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends a<ckt, cku>
{
  public e(ckt paramckt)
  {
    this.sYa = paramckt;
  }
  
  protected final void cKU()
  {
    AppMethodBeat.i(64879);
    ad.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
    AppMethodBeat.o(64879);
  }
  
  protected final void cKV()
  {
    AppMethodBeat.i(64880);
    ad.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
    AppMethodBeat.o(64880);
  }
  
  public final int getFuncId()
  {
    return 2857;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */