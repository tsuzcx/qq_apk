package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

final class a$1
  implements TencentMap.OnInfoWindowClickListener
{
  a$1(a parama) {}
  
  public final void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(146458);
    if (paramMarker == null)
    {
      AppMethodBeat.o(146458);
      return;
    }
    paramMarker = this.scU.aaH((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
      AppMethodBeat.o(146458);
      return;
    }
    if (a.a(this.scU) == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
      AppMethodBeat.o(146458);
      return;
    }
    a.a(this.scU).a(paramMarker);
    AppMethodBeat.o(146458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.1
 * JD-Core Version:    0.7.0.1
 */