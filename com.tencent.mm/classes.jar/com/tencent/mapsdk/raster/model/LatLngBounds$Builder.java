package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(101201);
    LatLngBounds localLatLngBounds = new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
    AppMethodBeat.o(101201);
    return localLatLngBounds;
  }
  
  public final Builder include(LatLng paramLatLng)
  {
    AppMethodBeat.i(101199);
    this.mSouth = Math.min(this.mSouth, paramLatLng.getLatitude());
    this.mNorth = Math.max(this.mNorth, paramLatLng.getLatitude());
    double d = paramLatLng.getLongitude();
    if (Double.isNaN(this.mWest))
    {
      this.mWest = d;
      this.mEast = d;
    }
    for (;;)
    {
      AppMethodBeat.o(101199);
      return this;
      if (!containsLongitude(d))
      {
        if (LatLngBounds.access$400(this.mWest, d) >= LatLngBounds.access$500(this.mEast, d)) {
          break;
        }
        this.mWest = d;
      }
    }
  }
  
  public final Builder include(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(101200);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        include((LatLng)paramIterable.next());
      }
    }
    AppMethodBeat.o(101200);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds.Builder
 * JD-Core Version:    0.7.0.1
 */