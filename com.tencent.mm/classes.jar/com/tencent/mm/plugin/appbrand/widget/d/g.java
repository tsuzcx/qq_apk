package com.tencent.mm.plugin.appbrand.widget.d;

import com.tencent.mapsdk.raster.model.LatLng;

public final class g
{
  public static double hzF = 6378137.0D;
  final double hzG = 6.283185307179586D * hzF;
  
  public final f b(LatLng paramLatLng)
  {
    double d1 = paramLatLng.getLongitude() / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.getLatitude()));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    return new f((d1 + 0.5D) * this.hzG, (d2 + 0.5D) * this.hzG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.g
 * JD-Core Version:    0.7.0.1
 */