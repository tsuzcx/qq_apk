package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"})
final class f$c
  implements j.a
{
  f$c(f paramf, b paramb) {}
  
  public final void r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(264329);
    Log.i("MicroMsg.AppBrandRecentDesktopViewModel", "fetchNextPageFromServer: " + paramBoolean + ' ' + paramString);
    f.a(this.rqs, this.jFa);
    AppMethodBeat.o(264329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.c
 * JD-Core Version:    0.7.0.1
 */