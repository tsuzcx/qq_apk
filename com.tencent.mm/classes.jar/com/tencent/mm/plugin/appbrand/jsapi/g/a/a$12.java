package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

final class a$12
  implements TencentMap.OnMarkerClickListener
{
  a$12(a parama) {}
  
  public final boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(51158);
    if (paramMarker == null)
    {
      AppMethodBeat.o(51158);
      return false;
    }
    ab.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", new Object[] { this, paramMarker.getTag() });
    if (bo.isNullOrNil((String)paramMarker.getTag()))
    {
      ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
      AppMethodBeat.o(51158);
      return false;
    }
    if (((String)paramMarker.getTag()).endsWith("#label"))
    {
      ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
      AppMethodBeat.o(51158);
      return false;
    }
    paramMarker = (a.d)this.hOM.Ch((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", new Object[] { this });
      AppMethodBeat.o(51158);
      return false;
    }
    if (a.b(this.hOM) == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
      AppMethodBeat.o(51158);
      return false;
    }
    Object localObject;
    if (paramMarker.hPr != null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", new Object[] { this });
      localObject = paramMarker.hPr.hPv;
      if ((localObject == null) || (((b.r.a)localObject).hPC != b.r.a.hPD) || (!paramMarker.hPb.isInfoWindowShown())) {
        break label330;
      }
      paramMarker.hPb.hideInfoWindow();
    }
    for (;;)
    {
      if (paramMarker.hPb != null) {
        paramMarker.hPb.set2Top();
      }
      if (paramMarker.hPc != null) {
        paramMarker.hPc.set2Top();
      }
      if (a.c(this.hOM) != null)
      {
        localObject = a.c(this.hOM);
        if (((d)localObject).hPb != null) {
          ((d)localObject).hPb.set2Top();
        }
      }
      boolean bool = a.b(this.hOM).b(paramMarker);
      AppMethodBeat.o(51158);
      return bool;
      label330:
      paramMarker.hPb.showInfoWindow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.12
 * JD-Core Version:    0.7.0.1
 */