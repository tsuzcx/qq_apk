package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

final class a$2
  implements TencentMap.OnMapCameraChangeListener
{
  a$2(a parama, b.u paramu) {}
  
  public final void onCameraChange(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(146459);
    if (this.kva != null)
    {
      b.a locala = new b.a();
      locala.kvA = new b.h(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      locala.kvB = paramCameraPosition.getBearing();
      locala.skew = paramCameraPosition.getSkew();
      this.kva.a(locala, a.m(this.kuZ));
    }
    AppMethodBeat.o(146459);
  }
  
  public final void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(146460);
    if (this.kva != null)
    {
      b.a locala = new b.a();
      locala.kvA = new b.h(paramCameraPosition.getTarget().getLatitude(), paramCameraPosition.getTarget().getLongitude());
      locala.zoom = paramCameraPosition.getZoom();
      locala.kvB = paramCameraPosition.getBearing();
      locala.skew = paramCameraPosition.getSkew();
      this.kva.b(locala, a.m(this.kuZ));
    }
    a.i(this.kuZ);
    AppMethodBeat.o(146460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a.2
 * JD-Core Version:    0.7.0.1
 */