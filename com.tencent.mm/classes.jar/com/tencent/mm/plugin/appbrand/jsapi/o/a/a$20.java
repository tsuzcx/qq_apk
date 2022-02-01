package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$20
  implements TencentMap.OnMapClickListener
{
  a$20(a parama) {}
  
  public final void onMapClick(LatLng paramLatLng)
  {
    AppMethodBeat.i(146478);
    Iterator localIterator = a.g(this.scU).values().iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      if ((localh.sec != null) && (localh.sec.sei != null) && (localh.sec.sei.seo == b.v.a.ses) && (localh.sdB != null) && (localh.sdB.isInfoWindowShown())) {
        localh.sdB.hideInfoWindow();
      }
    }
    if (a.h(this.scU) != null)
    {
      a.h(this.scU).h(paramLatLng.getLongitude(), paramLatLng.getLatitude());
      AppMethodBeat.o(146478);
      return;
    }
    AppMethodBeat.o(146478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.20
 * JD-Core Version:    0.7.0.1
 */