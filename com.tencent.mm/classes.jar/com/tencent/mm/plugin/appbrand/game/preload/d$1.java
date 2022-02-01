package com.tencent.mm.plugin.appbrand.game.preload;

import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.p.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

final class d$1
  implements d.b
{
  d$1(d paramd, String paramString) {}
  
  public final void a(a<AppBrandRuntime, Boolean> parama)
  {
    AppMethodBeat.i(267173);
    Log.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { this.opb });
    d.a(this.opc).addAndGet(1);
    AppMethodBeat.o(267173);
  }
  
  public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(267172);
    Log.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramWxaPkgLoadProgress });
    AppMethodBeat.o(267172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d.1
 * JD-Core Version:    0.7.0.1
 */