package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class bv
  implements fu.a
{
  public static final double a = 1.0D;
  private static final fw d;
  fl b;
  double c;
  
  static
  {
    AppMethodBeat.i(222453);
    d = new fw(1.0D);
    AppMethodBeat.o(222453);
  }
  
  public bv(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public bv(LatLng paramLatLng, double paramDouble)
  {
    AppMethodBeat.i(222423);
    this.b = d.c(paramLatLng);
    if (paramDouble >= 0.0D)
    {
      this.c = paramDouble;
      AppMethodBeat.o(222423);
      return;
    }
    this.c = 1.0D;
    AppMethodBeat.o(222423);
  }
  
  private void a(double paramDouble)
  {
    if (paramDouble >= 0.0D)
    {
      this.c = paramDouble;
      return;
    }
    this.c = 1.0D;
  }
  
  private void a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222440);
    this.b = d.c(paramLatLng);
    AppMethodBeat.o(222440);
  }
  
  private LatLng b()
  {
    AppMethodBeat.i(222434);
    LatLng localLatLng = d.b(this.b);
    AppMethodBeat.o(222434);
    return localLatLng;
  }
  
  private double c()
  {
    return this.c;
  }
  
  public final fl a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bv
 * JD-Core Version:    0.7.0.1
 */