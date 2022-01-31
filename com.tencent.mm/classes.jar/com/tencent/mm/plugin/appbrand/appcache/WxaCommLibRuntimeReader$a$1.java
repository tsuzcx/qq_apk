package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WxaCommLibRuntimeReader$a$1
  implements Runnable
{
  WxaCommLibRuntimeReader$a$1(WxaCommLibRuntimeReader.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(59457);
    if (!g.RJ().eHg)
    {
      AppMethodBeat.o(59457);
      return;
    }
    try
    {
      ((b)g.E(b.class)).dF(false);
      AppMethodBeat.o(59457);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(59457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.a.1
 * JD-Core Version:    0.7.0.1
 */