package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

final class a$41
  implements TencentMap.OnMapPoiClickListener
{
  a$41(a parama) {}
  
  public final void onClicked(MapPoi paramMapPoi)
  {
    AppMethodBeat.i(146480);
    if (a.m(this.scU) != null)
    {
      b.t localt = new b.t();
      localt.latitude = paramMapPoi.getPosition().getLatitude();
      localt.longitude = paramMapPoi.getPosition().getLongitude();
      localt.name = paramMapPoi.getName();
      if (((paramMapPoi instanceof IndoorMapPoi)) && (!Util.isNullOrNil(((IndoorMapPoi)paramMapPoi).getBuildingId())))
      {
        localt.buildingId = ((IndoorMapPoi)paramMapPoi).getBuildingId();
        localt.floorName = ((IndoorMapPoi)paramMapPoi).getFloorName();
      }
      a.m(this.scU).a(localt);
    }
    AppMethodBeat.o(146480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.41
 * JD-Core Version:    0.7.0.1
 */