package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    if ((this.gtW.gtS != null) && (this.gtW.gtR))
    {
      double d1 = this.gtW.gtS.getLatitude();
      double d2 = this.gtW.gtS.getLongitude();
      this.gtW.gty.getIController().animateTo(d1, d2);
      y.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.3
 * JD-Core Version:    0.7.0.1
 */