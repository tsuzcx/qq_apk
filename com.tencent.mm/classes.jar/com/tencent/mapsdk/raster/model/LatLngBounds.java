package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.g;

public class LatLngBounds
{
  private int mVersionCode;
  private LatLng northeast;
  private LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(101202);
    paramLatLng1 = new LatLngBounds.Builder().include(paramLatLng1).include(paramLatLng2);
    this.southwest = new LatLng(LatLngBounds.Builder.access$000(paramLatLng1), LatLngBounds.Builder.access$100(paramLatLng1));
    this.northeast = new LatLng(LatLngBounds.Builder.access$200(paramLatLng1), LatLngBounds.Builder.access$300(paramLatLng1));
    this.mVersionCode = paramInt;
    AppMethodBeat.o(101202);
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  public static LatLngBounds.Builder builder()
  {
    AppMethodBeat.i(101203);
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    AppMethodBeat.o(101203);
    return localBuilder;
  }
  
  private boolean containsLatitude(double paramDouble)
  {
    AppMethodBeat.i(101209);
    if ((this.southwest.getLatitude() <= paramDouble) && (paramDouble <= this.northeast.getLatitude()))
    {
      AppMethodBeat.o(101209);
      return true;
    }
    AppMethodBeat.o(101209);
    return false;
  }
  
  private boolean containsLongitude(double paramDouble)
  {
    AppMethodBeat.i(101210);
    if (this.southwest.getLongitude() <= this.northeast.getLongitude())
    {
      if ((this.southwest.getLongitude() <= paramDouble) && (paramDouble <= this.northeast.getLongitude()))
      {
        AppMethodBeat.o(101210);
        return true;
      }
      AppMethodBeat.o(101210);
      return false;
    }
    if ((this.southwest.getLongitude() <= paramDouble) || (paramDouble <= this.northeast.getLongitude()))
    {
      AppMethodBeat.o(101210);
      return true;
    }
    AppMethodBeat.o(101210);
    return false;
  }
  
  private boolean intersect(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(101207);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null) || (this.northeast == null) || (this.southwest == null))
    {
      AppMethodBeat.o(101207);
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
      AppMethodBeat.o(101207);
      return true;
    }
    AppMethodBeat.o(101207);
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
    AppMethodBeat.i(101204);
    if ((containsLatitude(paramLatLng.getLatitude())) && (containsLongitude(paramLatLng.getLongitude())))
    {
      AppMethodBeat.o(101204);
      return true;
    }
    AppMethodBeat.o(101204);
    return false;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    boolean bool2 = false;
    AppMethodBeat.i(101205);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(101205);
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
    AppMethodBeat.o(101205);
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101212);
    if (this == paramObject)
    {
      AppMethodBeat.o(101212);
      return true;
    }
    if (!(paramObject instanceof LatLngBounds))
    {
      AppMethodBeat.o(101212);
      return false;
    }
    paramObject = (LatLngBounds)paramObject;
    if ((this.southwest.equals(paramObject.southwest)) && (this.northeast.equals(paramObject.northeast)))
    {
      AppMethodBeat.o(101212);
      return true;
    }
    AppMethodBeat.o(101212);
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
    AppMethodBeat.i(101211);
    int i = g.a(new Object[] { this.southwest, this.northeast });
    AppMethodBeat.o(101211);
    return i;
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    AppMethodBeat.i(101208);
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
      AppMethodBeat.o(101208);
      return paramLatLng;
      label138:
      d2 = d3;
      d1 = d5;
    }
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(101206);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(101206);
      return false;
    }
    if ((intersect(paramLatLngBounds)) || (paramLatLngBounds.intersect(this)))
    {
      AppMethodBeat.o(101206);
      return true;
    }
    AppMethodBeat.o(101206);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101213);
    String str = g.a(new String[] { g.a("southwest", this.southwest), g.a("northeast", this.northeast) });
    AppMethodBeat.o(101213);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */