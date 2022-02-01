package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;

public final class ow
  extends AccessibleTouchItem
{
  private MapPoi a;
  private sj b;
  
  public ow(sj paramsj, MapPoi paramMapPoi)
  {
    this.a = paramMapPoi;
    this.b = paramsj;
  }
  
  public final Rect getBounds()
  {
    AppMethodBeat.i(221889);
    Object localObject = ((VectorMap)this.b.e_).v().a(GeoPoint.from(new LatLng(this.a.getLatitude(), this.a.getLongitude())));
    localObject = new Rect((int)(((fl)localObject).a - gw.m() * 20.0F), (int)(((fl)localObject).b - gw.m() * 20.0F), (int)(((fl)localObject).a + gw.m() * 20.0F), (int)(((fl)localObject).b + gw.m() * 20.0F));
    AppMethodBeat.o(221889);
    return localObject;
  }
  
  public final String getContentDescription()
  {
    AppMethodBeat.i(221899);
    String str = this.a.getName();
    AppMethodBeat.o(221899);
    return str;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(221908);
    if (this.b != null)
    {
      TencentMap.OnMapPoiClickListener localOnMapPoiClickListener = this.b.A;
      if (localOnMapPoiClickListener != null)
      {
        MapPoi localMapPoi = new MapPoi();
        localMapPoi.position = new LatLng(this.a.getLatitude(), this.a.getLongitude());
        localMapPoi.name = this.a.getName();
        localOnMapPoiClickListener.onClicked(localMapPoi);
      }
    }
    AppMethodBeat.o(221908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ow
 * JD-Core Version:    0.7.0.1
 */