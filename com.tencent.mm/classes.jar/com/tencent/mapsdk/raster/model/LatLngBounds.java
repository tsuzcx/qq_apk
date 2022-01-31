package com.tencent.mapsdk.raster.model;

import com.tencent.tencentmap.mapsdk.a.h;

public class LatLngBounds
{
  private int mVersionCode;
  private LatLng northeast;
  private LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    paramLatLng1 = new LatLngBounds.Builder().include(paramLatLng1).include(paramLatLng2);
    this.southwest = new LatLng(LatLngBounds.Builder.access$000(paramLatLng1), LatLngBounds.Builder.access$100(paramLatLng1));
    this.northeast = new LatLng(LatLngBounds.Builder.access$200(paramLatLng1), LatLngBounds.Builder.access$300(paramLatLng1));
    this.mVersionCode = paramInt;
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  public static LatLngBounds.Builder builder()
  {
    return new LatLngBounds.Builder();
  }
  
  private boolean containsLatitude(double paramDouble)
  {
    return (this.southwest.getLatitude() <= paramDouble) && (paramDouble <= this.northeast.getLatitude());
  }
  
  private boolean containsLongitude(double paramDouble)
  {
    if (this.southwest.getLongitude() <= this.northeast.getLongitude()) {
      if ((this.southwest.getLongitude() > paramDouble) || (paramDouble > this.northeast.getLongitude())) {}
    }
    while ((this.southwest.getLongitude() <= paramDouble) || (paramDouble <= this.northeast.getLongitude()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean intersect(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null) || (this.northeast == null) || (this.southwest == null)) {}
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d8;
    double d9;
    double d10;
    double d11;
    double d12;
    double d13;
    double d14;
    double d15;
    double d16;
    do
    {
      return false;
      d1 = paramLatLngBounds.northeast.getLongitude();
      d2 = paramLatLngBounds.southwest.getLongitude();
      d3 = this.northeast.getLongitude();
      d4 = this.southwest.getLongitude();
      d5 = this.northeast.getLongitude();
      d6 = this.southwest.getLongitude();
      d7 = paramLatLngBounds.northeast.getLongitude();
      d8 = paramLatLngBounds.southwest.getLongitude();
      d9 = paramLatLngBounds.northeast.getLatitude();
      d10 = paramLatLngBounds.southwest.getLatitude();
      d11 = this.northeast.getLatitude();
      d12 = this.southwest.getLatitude();
      d13 = this.northeast.getLatitude();
      d14 = this.southwest.getLatitude();
      d15 = paramLatLngBounds.northeast.getLatitude();
      d16 = paramLatLngBounds.southwest.getLatitude();
    } while ((Math.abs(d1 + d2 - d3 - d4) >= d5 - d6 + d7 - d8) || (Math.abs(d9 + d10 - d11 - d12) >= d13 - d14 + d15 - d16));
    return true;
  }
  
  private static double longitudeDistanceHeadingEast(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  private static double longitudeDistanceHeadingWest(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    return (containsLatitude(paramLatLng.getLatitude())) && (containsLongitude(paramLatLng.getLongitude()));
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!contains(paramLatLngBounds.southwest)) || (!contains(paramLatLngBounds.northeast))) {
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds)) {
        return false;
      }
      paramObject = (LatLngBounds)paramObject;
    } while ((this.southwest.equals(paramObject.southwest)) && (this.northeast.equals(paramObject.northeast)));
    return false;
  }
  
  public LatLng getNortheast()
  {
    return this.northeast;
  }
  
  public LatLng getSouthwest()
  {
    return this.southwest;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return h.a(new Object[] { this.southwest, this.northeast });
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    double d6 = Math.min(this.southwest.getLatitude(), paramLatLng.getLatitude());
    double d7 = Math.max(this.northeast.getLatitude(), paramLatLng.getLatitude());
    double d4 = this.northeast.getLongitude();
    double d5 = this.southwest.getLongitude();
    double d3 = paramLatLng.getLongitude();
    double d1 = d5;
    double d2 = d4;
    if (!containsLongitude(d3))
    {
      if (longitudeDistanceHeadingWest(d5, d3) >= longitudeDistanceHeadingEast(d4, d3)) {
        break label126;
      }
      d1 = d3;
      d2 = d4;
    }
    for (;;)
    {
      return new LatLngBounds(new LatLng(d6, d1), new LatLng(d7, d2));
      label126:
      d2 = d3;
      d1 = d5;
    }
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!intersect(paramLatLngBounds)) && (!paramLatLngBounds.intersect(this))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return h.a(new String[] { h.a("southwest", this.southwest), h.a("northeast", this.northeast) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */