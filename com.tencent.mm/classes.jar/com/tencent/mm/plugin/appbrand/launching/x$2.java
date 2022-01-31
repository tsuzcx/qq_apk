package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.y;

final class x$2
  implements a.a
{
  x$2(x paramx) {}
  
  public final String avB()
  {
    AppMethodBeat.i(131899);
    Object localObject = g.auM().a(this.ilP.ilG.toString(), this.ilP.cpE, new String[] { "versionMd5" });
    localObject = "_" + ((at)localObject).field_versionMd5;
    AppMethodBeat.o(131899);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x.2
 * JD-Core Version:    0.7.0.1
 */