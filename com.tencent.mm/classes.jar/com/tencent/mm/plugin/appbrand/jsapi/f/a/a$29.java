package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

final class a$29
  implements TencentMap.OnMapPoiClickListener
{
  a$29(a parama) {}
  
  public final void onClicked(MapPoi paramMapPoi)
  {
    AppMethodBeat.i(146480);
    if (a.j(this.kuZ) != null)
    {
      b.r localr = new b.r();
      localr.latitude = paramMapPoi.getPosition().getLatitude();
      localr.longitude = paramMapPoi.getPosition().getLongitude();
      localr.name = paramMapPoi.getName();
      if (((paramMapPoi instanceof IndoorMapPoi)) && (!bs.isNullOrNil(((IndoorMapPoi)paramMapPoi).getBuildingId())))
      {
        localr.buildingId = ((IndoorMapPoi)paramMapPoi).getBuildingId();
        localr.floorName = ((IndoorMapPoi)paramMapPoi).getFloorName();
      }
      a.j(this.kuZ).a(localr);
    }
    AppMethodBeat.o(146480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a.29
 * JD-Core Version:    0.7.0.1
 */