package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

final class a$1
  implements TencentMap.OnInfoWindowClickListener
{
  a$1(a parama) {}
  
  public final void onInfoWindowClick(Marker paramMarker)
  {
    paramMarker = (a.d)this.gtW.ug((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", new Object[] { this });
      return;
    }
    if (this.gtW.gtz == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", new Object[] { this });
      return;
    }
    this.gtW.gtz.a(paramMarker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.1
 * JD-Core Version:    0.7.0.1
 */