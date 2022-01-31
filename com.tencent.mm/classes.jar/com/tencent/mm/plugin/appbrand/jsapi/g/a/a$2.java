package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

final class a$2
  implements TencentMap.OnMapCameraChangeListener
{
  a$2(a parama, b.s params) {}
  
  public final void onCameraChange(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(138412);
    if (this.hON != null)
    {
      b.a locala = new b.a();
      locala.hPd = new b.h(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      locala.rotate = paramCameraPosition.getBearing();
      locala.skew = paramCameraPosition.getSkew();
      this.hON.a(locala, a.k(this.hOM));
    }
    AppMethodBeat.o(138412);
  }
  
  public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(138413);
    a.a(this.hOM, paramCameraPosition);
    if (this.hON != null)
    {
      b.a locala = new b.a();
      locala.hPd = new b.h(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      locala.rotate = paramCameraPosition.getBearing();
      locala.skew = paramCameraPosition.getSkew();
      this.hON.b(locala, a.k(this.hOM));
    }
    a.g(this.hOM);
    AppMethodBeat.o(138413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.2
 * JD-Core Version:    0.7.0.1
 */