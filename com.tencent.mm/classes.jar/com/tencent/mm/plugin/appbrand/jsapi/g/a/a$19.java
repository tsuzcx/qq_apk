package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

final class a$19
  implements TencentMap.OnMapPoiClickListener
{
  a$19(a parama) {}
  
  public final void onClicked(MapPoi paramMapPoi)
  {
    AppMethodBeat.i(51168);
    if (a.h(this.hOM) != null)
    {
      b.p localp = new b.p();
      localp.latitude = paramMapPoi.getPosition().getLatitude();
      localp.longitude = paramMapPoi.getPosition().getLongitude();
      localp.name = paramMapPoi.getName();
      if (((paramMapPoi instanceof IndoorMapPoi)) && (!bo.isNullOrNil(((IndoorMapPoi)paramMapPoi).getBuildingId())))
      {
        localp.buildingId = ((IndoorMapPoi)paramMapPoi).getBuildingId();
        localp.floorName = ((IndoorMapPoi)paramMapPoi).getFloorName();
      }
      a.h(this.hOM).a(localp);
    }
    AppMethodBeat.o(51168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.19
 * JD-Core Version:    0.7.0.1
 */