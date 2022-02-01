package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public abstract interface ep
  extends Projection
{
  public abstract double a(Point paramPoint1, Point paramPoint2);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng3);
  
  public abstract PointF a(LatLng paramLatLng);
  
  public abstract GeoPoint a(fl paramfl);
  
  public abstract fl a(Context paramContext, LatLng paramLatLng);
  
  public abstract fl a(GeoPoint paramGeoPoint);
  
  public abstract LatLng a(PointF paramPointF);
  
  public abstract LatLng a(ft paramft);
  
  public abstract void a(List<? extends Boundable> paramList, List<GeoPoint> paramList1, Rect paramRect, a parama);
  
  public abstract LatLng[] a();
  
  public abstract ft b(LatLng paramLatLng);
  
  public abstract double metersPerPixel(double paramDouble);
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat, GeoPoint paramGeoPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ep
 * JD-Core Version:    0.7.0.1
 */