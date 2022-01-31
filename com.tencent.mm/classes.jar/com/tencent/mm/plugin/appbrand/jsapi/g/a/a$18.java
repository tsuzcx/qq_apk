package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

final class a$18
  implements TencentMap.OnMapLoadedListener
{
  a$18(a parama) {}
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(51167);
    if (a.f(this.hOM) != null) {
      a.f(this.hOM);
    }
    a.g(this.hOM);
    AppMethodBeat.o(51167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.18
 * JD-Core Version:    0.7.0.1
 */