package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends a<cvz, cwa>
{
  public e(cvz paramcvz)
  {
    this.vvd = paramcvz;
  }
  
  protected final void dkL()
  {
    AppMethodBeat.i(64879);
    ae.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
    AppMethodBeat.o(64879);
  }
  
  protected final void dkM()
  {
    AppMethodBeat.i(64880);
    ae.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */