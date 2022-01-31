package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$15
  implements TencentMap.OnMapClickListener
{
  a$15(a parama) {}
  
  public final void onMapClick(LatLng paramLatLng)
  {
    paramLatLng = this.gtW.gtO.values().iterator();
    while (paramLatLng.hasNext())
    {
      a.d locald = (a.d)paramLatLng.next();
      if ((locald.gux != null) && (locald.gux.guA != null) && (locald.gux.guA.guH == b.p.a.guI) && (locald.guj.isInfoWindowShown())) {
        locald.guj.hideInfoWindow();
      }
    }
    if (this.gtW.gtG != null) {
      this.gtW.gtG.ajf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.15
 * JD-Core Version:    0.7.0.1
 */