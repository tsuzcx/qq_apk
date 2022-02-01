package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class v$1
  implements Runnable
{
  v$1(v paramv, WxaAttributes paramWxaAttributes) {}
  
  public final void run()
  {
    AppMethodBeat.i(44903);
    try
    {
      v.e(this.jeE);
      AppMethodBeat.o(44903);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WxaAttrStorageWC", localException, "flushContactInMainDB", new Object[0]);
      AppMethodBeat.o(44903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v.1
 * JD-Core Version:    0.7.0.1
 */