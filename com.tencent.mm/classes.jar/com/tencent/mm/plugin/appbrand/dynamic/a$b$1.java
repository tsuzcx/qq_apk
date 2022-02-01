package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.ad;

final class a$b$1
  implements Runnable
{
  a$b$1(a.b paramb, c paramc, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(121125);
    c localc = this.jkc;
    ad.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[] { localc.fDK });
    localc.arf = false;
    localc.cleanup();
    localc.gbB = null;
    localc.jkn = null;
    localc.fDK = null;
    localc.mSessionId = null;
    k.Hc(this.val$id);
    this.val$callback.bf(null);
    f.aVg().GT(this.val$id);
    AppMethodBeat.o(121125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.1
 * JD-Core Version:    0.7.0.1
 */