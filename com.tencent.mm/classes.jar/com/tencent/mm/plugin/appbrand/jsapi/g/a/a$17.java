package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$17
  implements TencentMap.OnMapClickListener
{
  a$17(a parama) {}
  
  public final void onMapClick(LatLng paramLatLng)
  {
    AppMethodBeat.i(51166);
    paramLatLng = a.d(this.hOM).values().iterator();
    while (paramLatLng.hasNext())
    {
      a.d locald = (a.d)paramLatLng.next();
      if ((locald.hPr != null) && (locald.hPr.hPv != null) && (locald.hPr.hPv.hPC == b.r.a.hPD) && (locald.hPb.isInfoWindowShown())) {
        locald.hPb.hideInfoWindow();
      }
    }
    if (a.e(this.hOM) != null)
    {
      a.e(this.hOM).aDm();
      AppMethodBeat.o(51166);
      return;
    }
    AppMethodBeat.o(51166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.17
 * JD-Core Version:    0.7.0.1
 */