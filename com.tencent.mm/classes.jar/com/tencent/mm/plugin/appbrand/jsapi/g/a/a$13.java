package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

final class a$13
  implements Runnable
{
  a$13(a parama, double paramDouble1, double paramDouble2, String paramString, double paramDouble3) {}
  
  public final void run()
  {
    if (this.gtW.gty != null)
    {
      if (this.gtW.gtS == null)
      {
        this.gtW.gtS = new d(this.gtW.context);
        d locald = this.gtW.gtS;
        SoSoMapView localSoSoMapView = this.gtW.gty;
        double d1 = this.elO;
        double d2 = this.elP;
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.anchor(0.5F, 0.5F);
        localMarkerOptions.position(new LatLng(d1, d2));
        localMarkerOptions.markerView(locald);
        localMarkerOptions.zIndex(2147483647);
        localMarkerOptions.flat(true);
        locald.guj = localSoSoMapView.getMap().addMarker(localMarkerOptions);
      }
      this.gtW.gtS.a(this.elO, this.elP, this.guh, this.elR);
      if (this.gtW.gtJ != null)
      {
        this.gtW.gtJ.run();
        this.gtW.gtJ = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.13
 * JD-Core Version:    0.7.0.1
 */