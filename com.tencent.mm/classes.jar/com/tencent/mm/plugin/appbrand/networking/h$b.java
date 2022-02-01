package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.sdk.platformtools.Log;

final class h$b
  implements IPCRunCgi.b
{
  public final c a(c paramc)
  {
    AppMethodBeat.i(317271);
    Log.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramc.getUri(), Integer.valueOf(paramc.getType()) });
    AppMethodBeat.o(317271);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h.b
 * JD-Core Version:    0.7.0.1
 */