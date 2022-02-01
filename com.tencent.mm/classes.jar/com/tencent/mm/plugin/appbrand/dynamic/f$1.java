package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.Log;

final class f$1
  implements IPCRunCgi.a
{
  f$1(f paramf) {}
  
  public final void callback(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(121163);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[] { paramString });
    }
    AppMethodBeat.o(121163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.1
 * JD-Core Version:    0.7.0.1
 */