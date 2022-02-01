package com.j.a.a.a.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public final class h
  implements com.tencent.tencentmap.mapsdk.map.Projection
{
  private com.tencent.tencentmap.mapsdk.maps.Projection airw;
  private TencentMap mMap;
  
  public h(TencentMap paramTencentMap)
  {
    AppMethodBeat.i(207013);
    this.airw = paramTencentMap.getProjection();
    this.mMap = paramTencentMap;
    AppMethodBeat.o(207013);
  }
  
  public final double distanceBetween(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(207078);
    double d4 = paramLatLng1.getLongitude();
    double d3 = paramLatLng1.getLatitude();
    double d2 = paramLatLng2.getLongitude();
    double d1 = paramLatLng2.getLatitude();
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng1 = new double[3];
    paramLatLng2 = new double[3];
    paramLatLng1[0] = (d5 * d6);
    paramLatLng1[1] = (d6 * d1);
    paramLatLng1[2] = d2;
    paramLatLng2[0] = (d4 * d3);
    paramLatLng2[1] = (d4 * d7);
    paramLatLng2[2] = d8;
    d1 = Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D);
    AppMethodBeat.o(207078);
    return d1 * 12742001.579854401D;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng fromScreenLocation(Point paramPoint)
  {
    AppMethodBeat.i(207024);
    paramPoint = l.d(this.airw.fromScreenLocation(paramPoint));
    AppMethodBeat.o(207024);
    return paramPoint;
  }
  
  public final double getLatitudeSpan()
  {
    AppMethodBeat.i(207128);
    com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion localVisibleRegion = this.airw.getVisibleRegion();
    if (localVisibleRegion == null)
    {
      AppMethodBeat.o(207128);
      return -1.0D;
    }
    double d1 = localVisibleRegion.latLngBounds.southwest.latitude;
    double d2 = localVisibleRegion.latLngBounds.northeast.latitude;
    AppMethodBeat.o(207128);
    return d1 - d2;
  }
  
  public final double getLongitudeSpan()
  {
    AppMethodBeat.i(207143);
    com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion localVisibleRegion = this.airw.getVisibleRegion();
    if (localVisibleRegion == null)
    {
      AppMethodBeat.o(207143);
      return -1.0D;
    }
    double d1 = localVisibleRegion.latLngBounds.southwest.longitude;
    double d2 = localVisibleRegion.latLngBounds.northeast.longitude;
    AppMethodBeat.o(207143);
    return d1 - d2;
  }
  
  public final float getScalePerPixel()
  {
    AppMethodBeat.i(207159);
    float f = (float)this.airw.metersPerPixel(this.mMap.getCameraPosition().target.latitude);
    AppMethodBeat.o(207159);
    return f;
  }
  
  public final com.tencent.mapsdk.raster.model.VisibleRegion getVisibleRegion()
  {
    Object localObject2 = null;
    AppMethodBeat.i(207056);
    Object localObject1 = this.airw.getVisibleRegion();
    if (localObject1 == null)
    {
      AppMethodBeat.o(207056);
      return null;
    }
    com.tencent.mapsdk.raster.model.LatLng localLatLng1 = l.d(((com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion)localObject1).nearLeft);
    com.tencent.mapsdk.raster.model.LatLng localLatLng2 = l.d(((com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion)localObject1).nearRight);
    com.tencent.mapsdk.raster.model.LatLng localLatLng3 = l.d(((com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion)localObject1).farLeft);
    com.tencent.mapsdk.raster.model.LatLng localLatLng4 = l.d(((com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion)localObject1).farRight);
    com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds localLatLngBounds = ((com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion)localObject1).latLngBounds;
    localObject1 = localObject2;
    if (localLatLngBounds != null)
    {
      localObject1 = localObject2;
      if (localLatLngBounds.northeast != null) {
        if (localLatLngBounds.southwest != null) {
          break label119;
        }
      }
    }
    label119:
    for (localObject1 = localObject2;; localObject1 = new com.tencent.mapsdk.raster.model.LatLngBounds(new com.tencent.mapsdk.raster.model.LatLng(localLatLngBounds.southwest.latitude, localLatLngBounds.southwest.longitude), new com.tencent.mapsdk.raster.model.LatLng(localLatLngBounds.northeast.latitude, localLatLngBounds.northeast.longitude)))
    {
      localObject1 = new com.tencent.mapsdk.raster.model.VisibleRegion(localLatLng1, localLatLng2, localLatLng3, localLatLng4, (com.tencent.mapsdk.raster.model.LatLngBounds)localObject1);
      AppMethodBeat.o(207056);
      return localObject1;
    }
  }
  
  public final float metersToEquatorPixels(float paramFloat)
  {
    AppMethodBeat.i(207094);
    paramFloat = metersToPixels(0.0D, paramFloat);
    AppMethodBeat.o(207094);
    return paramFloat;
  }
  
  public final float metersToPixels(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(207111);
    float f = (float)(paramDouble2 / this.airw.metersPerPixel(paramDouble1));
    AppMethodBeat.o(207111);
    return f;
  }
  
  @Deprecated
  public final Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    AppMethodBeat.i(207180);
    paramGeoPoint = GeoPoint.g2l(paramGeoPoint);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(207180);
      return null;
    }
    paramGeoPoint = toScreenLocation(paramGeoPoint);
    AppMethodBeat.o(207180);
    return paramGeoPoint;
  }
  
  public final Point toScreenLocation(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207036);
    paramLatLng = this.airw.toScreenLocation(l.d(paramLatLng));
    AppMethodBeat.o(207036);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.j.a.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */