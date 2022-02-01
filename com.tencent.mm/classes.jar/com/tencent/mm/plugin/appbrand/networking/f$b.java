package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.sdk.platformtools.ac;

final class f$b
  implements IPCRunCgi.b
{
  public final b a(b paramb)
  {
    AppMethodBeat.i(186883);
    ac.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramb.getUri(), Integer.valueOf(paramb.getType()) });
    AppMethodBeat.o(186883);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.f.b
 * JD-Core Version:    0.7.0.1
 */