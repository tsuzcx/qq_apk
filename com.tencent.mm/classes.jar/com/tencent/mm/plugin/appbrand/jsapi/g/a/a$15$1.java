package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a.a;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

final class a$15$1
  implements Runnable
{
  a$15$1(a.15 param15, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(138422);
    d locald;
    double d1;
    double d2;
    if (this.hOZ.hOM.hOi != null)
    {
      if (a.c(this.hOZ.hOM) == null)
      {
        a.a(this.hOZ.hOM, new d(a.n(this.hOZ.hOM)));
        locald = a.c(this.hOZ.hOM);
        localObject = this.hOZ.hOM.hOi;
        a.a locala = this.hOY;
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.anchor(0.5F, 0.5F);
        localMarkerOptions.position(new LatLng(locala.latitude, locala.longitude));
        localMarkerOptions.markerView(locald);
        localMarkerOptions.zIndex(2147483647);
        localMarkerOptions.flat(true);
        locald.hPb = ((SoSoMapView)localObject).getMap().addMarker(localMarkerOptions);
      }
      locald = a.c(this.hOZ.hOM);
      d1 = this.hOY.latitude;
      d2 = this.hOY.longitude;
      Object localObject = this.hOY.bsd;
      double d3 = this.hOY.iYv;
      if ((locald.hPK != -1.0D) || (locald.hPL != -1.0D)) {
        break label390;
      }
      locald.hPK = d1;
      locald.hPI = d1;
      locald.hPL = d2;
      locald.hPJ = d2;
      if ((locald.hPK != -1.0D) && (locald.hPL != -1.0D)) {
        locald.hPP = f.a(locald.hPL, locald.hPK, d2, d1, (String)localObject, d3);
      }
      if ((locald.hPN != 900.0F) && (locald.hPM != 900.0F)) {
        break label425;
      }
      float f = (float)f.h(d1, d2);
      locald.hPM = f;
      locald.hPN = f;
    }
    for (;;)
    {
      if (locald.hPb != null) {
        locald.hPb.setPosition(new LatLng(d1, d2));
      }
      AppMethodBeat.o(138422);
      return;
      label390:
      locald.hPK = locald.hPI;
      locald.hPL = locald.hPJ;
      locald.hPJ = d2;
      locald.hPI = d1;
      break;
      label425:
      locald.hPN = locald.hPM;
      locald.hPM = ((float)f.h(d1, d2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.15.1
 * JD-Core Version:    0.7.0.1
 */