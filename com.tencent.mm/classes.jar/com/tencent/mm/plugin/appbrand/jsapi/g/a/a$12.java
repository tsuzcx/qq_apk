package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

final class a$12
  implements TencentMap.OnMarkerClickListener
{
  a$12(a parama) {}
  
  public final boolean onMarkerClick(Marker paramMarker)
  {
    y.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramMarker.getTag() });
    if (bk.bl((String)paramMarker.getTag()))
    {
      y.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
      return false;
    }
    if (((String)paramMarker.getTag()).endsWith("#label"))
    {
      y.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
      return false;
    }
    paramMarker = (a.d)this.gtW.ug((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
      return false;
    }
    if (this.gtW.gtA == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
      return false;
    }
    Object localObject;
    if (paramMarker.gux != null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
      localObject = paramMarker.gux.guA;
      if ((localObject == null) || (((b.p.a)localObject).guH != b.p.a.guI) || (!paramMarker.guj.isInfoWindowShown())) {
        break label287;
      }
      paramMarker.guj.hideInfoWindow();
    }
    for (;;)
    {
      if (paramMarker.guj != null) {
        paramMarker.guj.set2Top();
      }
      if (paramMarker.guk != null) {
        paramMarker.guk.set2Top();
      }
      if (this.gtW.gtS != null)
      {
        localObject = this.gtW.gtS;
        if (((d)localObject).guj != null) {
          ((d)localObject).guj.set2Top();
        }
      }
      return this.gtW.gtA.b(paramMarker);
      label287:
      paramMarker.guj.showInfoWindow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.12
 * JD-Core Version:    0.7.0.1
 */