package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.m;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class a$d<T>
  implements d.a<Object>
{
  a$d(m paramm) {}
  
  public final void cn(Object paramObject)
  {
    AppMethodBeat.i(230181);
    if ((paramObject instanceof Exception)) {
      Log.e("MicroMsg.CgiCheckWxaShortLink", "checkAsync exception" + ((Exception)paramObject).getMessage());
    }
    this.nzd.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(230181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a.d
 * JD-Core Version:    0.7.0.1
 */