package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

final class a$2
  implements TencentMap.OnMapCameraChangeListener
{
  a$2(a parama, b.q paramq) {}
  
  public final void onCameraChange(CameraPosition paramCameraPosition)
  {
    if (this.gtX != null)
    {
      b.a locala = new b.a();
      locala.gul = new b.f(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      this.gtX.a(locala);
    }
  }
  
  public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    if (this.gtX != null)
    {
      b.a locala = new b.a();
      locala.gul = new b.f(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      this.gtX.a(locala, this.gtW.gtI);
    }
    a.a(this.gtW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.2
 * JD-Core Version:    0.7.0.1
 */