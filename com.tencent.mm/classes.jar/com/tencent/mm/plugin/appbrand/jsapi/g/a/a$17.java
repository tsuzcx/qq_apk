package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

final class a$17
  implements TencentMap.OnMapPoiClickListener
{
  a$17(a parama) {}
  
  public final void onClicked(MapPoi paramMapPoi)
  {
    if (this.gtW.gtH != null)
    {
      b.n localn = new b.n();
      localn.latitude = paramMapPoi.getPosition().getLatitude();
      localn.longitude = paramMapPoi.getPosition().getLongitude();
      localn.name = paramMapPoi.getName();
      this.gtW.gtH.a(localn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.17
 * JD-Core Version:    0.7.0.1
 */