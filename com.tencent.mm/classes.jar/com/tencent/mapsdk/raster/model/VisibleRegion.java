package com.tencent.mapsdk.raster.model;

import com.tencent.tencentmap.mapsdk.a.h;

public final class VisibleRegion
{
  private final LatLng farLeft;
  private final LatLng farRight;
  private final LatLngBounds latLngBounds;
  private final int mVersionCode;
  private final LatLng nearLeft;
  private final LatLng nearRight;
  
  protected VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.mVersionCode = paramInt;
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this(1, paramLatLng1, paramLatLng2, paramLatLng3, paramLatLng4, paramLatLngBounds);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof VisibleRegion)) {
        return false;
      }
      paramObject = (VisibleRegion)paramObject;
    } while ((getNearLeft().equals(paramObject.getNearLeft())) && (getNearRight().equals(paramObject.getNearRight())) && (getFarLeft().equals(paramObject.getFarLeft())) && (getFarRight().equals(paramObject.getFarRight())) && (getLatLngBounds().equals(paramObject.getLatLngBounds())));
    return false;
  }
  
  public final LatLng getFarLeft()
  {
    return this.farLeft;
  }
  
  public final LatLng getFarRight()
  {
    return this.farRight;
  }
  
  public final LatLngBounds getLatLngBounds()
  {
    return this.latLngBounds;
  }
  
  public final LatLng getNearLeft()
  {
    return this.nearLeft;
  }
  
  public final LatLng getNearRight()
  {
    return this.nearRight;
  }
  
  protected final int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public final int hashCode()
  {
    return h.a(new Object[] { getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds() });
  }
  
  public final String toString()
  {
    return h.a(new String[] { h.a("nearLeft", getNearLeft()), h.a("nearRight", getNearRight()), h.a("farLeft", getFarLeft()), h.a("farRight", getFarRight()), h.a("latLngBounds", getLatLngBounds()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */