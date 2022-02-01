package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.List;

public abstract interface ap
  extends ao, Polygon
{
  public abstract void a(PolygonOptions paramPolygonOptions);
  
  public abstract PolygonInfo b();
  
  public abstract List<GeoPoint> c();
  
  public abstract GeoPoint d();
  
  public abstract int k_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ap
 * JD-Core Version:    0.7.0.1
 */