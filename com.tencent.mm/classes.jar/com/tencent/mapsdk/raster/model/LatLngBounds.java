package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;

public class LatLngBounds
{
  private int mVersionCode;
  private LatLng northeast;
  private LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(87583);
    paramLatLng1 = new Builder().include(paramLatLng1).include(paramLatLng2);
    this.southwest = new LatLng(paramLatLng1.mSouth, paramLatLng1.mWest);
    this.northeast = new LatLng(paramLatLng1.mNorth, paramLatLng1.mEast);
    this.mVersionCode = paramInt;
    AppMethodBeat.o(87583);
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  public static Builder builder()
  {
    AppMethodBeat.i(87584);
    Builder localBuilder = new Builder();
    AppMethodBeat.o(87584);
    return localBuilder;
  }
  
  private boolean containsLatitude(double paramDouble)
  {
    AppMethodBeat.i(87590);
    if ((this.southwest.getLatitude() <= paramDouble) && (paramDouble <= this.northeast.getLatitude()))
    {
      AppMethodBeat.o(87590);
      return true;
    }
    AppMethodBeat.o(87590);
    return false;
  }
  
  private boolean containsLongitude(double paramDouble)
  {
    AppMethodBeat.i(87591);
    if (this.southwest.getLongitude() <= this.northeast.getLongitude())
    {
      if ((this.southwest.getLongitude() <= paramDouble) && (paramDouble <= this.northeast.getLongitude()))
      {
        AppMethodBeat.o(87591);
        return true;
      }
      AppMethodBeat.o(87591);
      return false;
    }
    if ((this.southwest.getLongitude() <= paramDouble) || (paramDouble <= this.northeast.getLongitude()))
    {
      AppMethodBeat.o(87591);
      return true;
    }
    AppMethodBeat.o(87591);
    return false;
  }
  
  private boolean intersect(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(87588);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null) || (this.northeast == null) || (this.southwest == null))
    {
      AppMethodBeat.o(87588);
      return false;
    }
    double d1 = paramLatLngBounds.northeast.getLongitude();
    double d2 = paramLatLngBounds.southwest.getLongitude();
    double d3 = this.northeast.getLongitude();
    double d4 = this.southwest.getLongitude();
    double d5 = this.northeast.getLongitude();
    double d6 = this.southwest.getLongitude();
    double d7 = paramLatLngBounds.northeast.getLongitude();
    double d8 = paramLatLngBounds.southwest.getLongitude();
    double d9 = paramLatLngBounds.northeast.getLatitude();
    double d10 = paramLatLngBounds.southwest.getLatitude();
    double d11 = this.northeast.getLatitude();
    double d12 = this.southwest.getLatitude();
    double d13 = this.northeast.getLatitude();
    double d14 = this.southwest.getLatitude();
    double d15 = paramLatLngBounds.northeast.getLatitude();
    double d16 = paramLatLngBounds.southwest.getLatitude();
    if ((Math.abs(d1 + d2 - d3 - d4) < d5 - d6 + d7 - d8) && (Math.abs(d9 + d10 - d11 - d12) < d13 - d14 + d15 - d16))
    {
      AppMethodBeat.o(87588);
      return true;
    }
    AppMethodBeat.o(87588);
    return false;
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
    AppMethodBeat.i(87585);
    if ((containsLatitude(paramLatLng.getLatitude())) && (containsLongitude(paramLatLng.getLongitude())))
    {
      AppMethodBeat.o(87585);
      return true;
    }
    AppMethodBeat.o(87585);
    return false;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    boolean bool2 = false;
    AppMethodBeat.i(87586);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(87586);
      return false;
    }
    boolean bool1 = bool2;
    if (contains(paramLatLngBounds.southwest))
    {
      bool1 = bool2;
      if (contains(paramLatLngBounds.northeast)) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(87586);
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(87593);
    if (this == paramObject)
    {
      AppMethodBeat.o(87593);
      return true;
    }
    if (!(paramObject instanceof LatLngBounds))
    {
      AppMethodBeat.o(87593);
      return false;
    }
    paramObject = (LatLngBounds)paramObject;
    if ((this.southwest.equals(paramObject.southwest)) && (this.northeast.equals(paramObject.northeast)))
    {
      AppMethodBeat.o(87593);
      return true;
    }
    AppMethodBeat.o(87593);
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
    AppMethodBeat.i(87592);
    int i = Arrays.hashCode(new Object[] { this.southwest, this.northeast });
    AppMethodBeat.o(87592);
    return i;
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    AppMethodBeat.i(87589);
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
        break label138;
      }
      d1 = d3;
      d2 = d4;
    }
    for (;;)
    {
      paramLatLng = new LatLngBounds(new LatLng(d6, d1), new LatLng(d7, d2));
      AppMethodBeat.o(87589);
      return paramLatLng;
      label138:
      d2 = d3;
      d1 = d5;
    }
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(87587);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(87587);
      return false;
    }
    if ((intersect(paramLatLngBounds)) || (paramLatLngBounds.intersect(this)))
    {
      AppMethodBeat.o(87587);
      return true;
    }
    AppMethodBeat.o(87587);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(87594);
    String str = "southwest" + this.southwest + "northeast" + this.northeast;
    AppMethodBeat.o(87594);
    return str;
  }
  
  public static final class Builder
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
      AppMethodBeat.i(87544);
      LatLngBounds localLatLngBounds = new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
      AppMethodBeat.o(87544);
      return localLatLngBounds;
    }
    
    public final Builder include(LatLng paramLatLng)
    {
      AppMethodBeat.i(87542);
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
        AppMethodBeat.o(87542);
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
      AppMethodBeat.i(87543);
      if (paramIterable != null)
      {
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
          include((LatLng)paramIterable.next());
        }
      }
      AppMethodBeat.o(87543);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */