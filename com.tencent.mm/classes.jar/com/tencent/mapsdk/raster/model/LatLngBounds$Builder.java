package com.tencent.mapsdk.raster.model;

import java.util.Iterator;

public final class LatLngBounds$Builder
{
  private double mEast = (0.0D / 0.0D);
  private double mNorth = (-1.0D / 0.0D);
  private double mSouth = (1.0D / 0.0D);
  private double mWest = (0.0D / 0.0D);
  
  private boolean containsLongitude(double paramDouble)
  {
    if (this.mWest <= this.mEast) {
      if ((this.mWest > paramDouble) || (paramDouble > this.mEast)) {}
    }
    while ((this.mWest <= paramDouble) || (paramDouble <= this.mEast))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final LatLngBounds build()
  {
    return new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
  }
  
  public final Builder include(LatLng paramLatLng)
  {
    this.mSouth = Math.min(this.mSouth, paramLatLng.getLatitude());
    this.mNorth = Math.max(this.mNorth, paramLatLng.getLatitude());
    double d = paramLatLng.getLongitude();
    if (Double.isNaN(this.mWest)) {
      this.mWest = d;
    }
    do
    {
      this.mEast = d;
      do
      {
        return this;
      } while (containsLongitude(d));
    } while (LatLngBounds.access$400(this.mWest, d) >= LatLngBounds.access$500(this.mEast, d));
    this.mWest = d;
    return this;
  }
  
  public final Builder include(Iterable<LatLng> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        include((LatLng)paramIterable.next());
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds.Builder
 * JD-Core Version:    0.7.0.1
 */