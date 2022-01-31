package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

final class a$1
  implements TencentMap.OnInfoWindowClickListener
{
  a$1(a parama) {}
  
  public final void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(51149);
    if (paramMarker == null)
    {
      AppMethodBeat.o(51149);
      return;
    }
    paramMarker = (a.d)this.hOM.Ch((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
      AppMethodBeat.o(51149);
      return;
    }
    if (a.a(this.hOM) == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
      AppMethodBeat.o(51149);
      return;
    }
    a.a(this.hOM).a(paramMarker);
    AppMethodBeat.o(51149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.1
 * JD-Core Version:    0.7.0.1
 */