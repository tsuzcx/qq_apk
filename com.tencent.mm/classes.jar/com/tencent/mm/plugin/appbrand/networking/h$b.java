package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.sdk.platformtools.Log;

final class h$b
  implements IPCRunCgi.b
{
  public final d a(d paramd)
  {
    AppMethodBeat.i(278255);
    Log.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramd.getUri(), Integer.valueOf(paramd.getType()) });
    AppMethodBeat.o(278255);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h.b
 * JD-Core Version:    0.7.0.1
 */