package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onAuthResult"})
final class a$c$a
  implements d
{
  a$c$a(a.c paramc) {}
  
  public final void aBV()
  {
    AppMethodBeat.i(134648);
    a.aBU();
    ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.hDj.hDi);
    a.a(this.hDj.hDe);
    AppMethodBeat.o(134648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a.c.a
 * JD-Core Version:    0.7.0.1
 */