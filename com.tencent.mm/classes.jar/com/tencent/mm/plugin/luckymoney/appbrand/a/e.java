package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends a<ers, ert>
{
  public e(ers paramers)
  {
    AppMethodBeat.i(284039);
    a(paramers);
    AppMethodBeat.o(284039);
  }
  
  protected final void fWr()
  {
    AppMethodBeat.i(64879);
    Log.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
    AppMethodBeat.o(64879);
  }
  
  protected final void fWs()
  {
    AppMethodBeat.i(64880);
    Log.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
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