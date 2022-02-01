package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

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
    AppMethodBeat.i(87581);
    if (this == paramObject)
    {
      AppMethodBeat.o(87581);
      return true;
    }
    if (!(paramObject instanceof VisibleRegion))
    {
      AppMethodBeat.o(87581);
      return false;
    }
    paramObject = (VisibleRegion)paramObject;
    if ((getNearLeft().equals(paramObject.getNearLeft())) && (getNearRight().equals(paramObject.getNearRight())) && (getFarLeft().equals(paramObject.getFarLeft())) && (getFarRight().equals(paramObject.getFarRight())) && (getLatLngBounds().equals(paramObject.getLatLngBounds())))
    {
      AppMethodBeat.o(87581);
      return true;
    }
    AppMethodBeat.o(87581);
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
    AppMethodBeat.i(87580);
    int i = Arrays.hashCode(new Object[] { getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds() });
    AppMethodBeat.o(87580);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87582);
    String str = "nearLeft" + this.nearLeft + "nearRight" + this.nearRight + "farLeft" + this.farLeft + "farRight" + this.farRight + "latLngBounds" + this.latLngBounds;
    AppMethodBeat.o(87582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */