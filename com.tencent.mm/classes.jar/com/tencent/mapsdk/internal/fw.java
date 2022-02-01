package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class fw
{
  final double d;
  
  public fw(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public final LatLng b(fl paramfl)
  {
    double d2 = 0.0D;
    AppMethodBeat.i(221947);
    double d3 = 360.0D * (paramfl.a / this.d - 0.5D);
    double d4 = 90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - paramfl.b / this.d) * 2.0D * 3.141592653589793D)) * 2.0D);
    double d1 = d4;
    if (Double.isNaN(d4)) {
      d1 = 0.0D;
    }
    if (Double.isNaN(d3)) {}
    for (;;)
    {
      paramfl = new LatLng(d1, d2);
      AppMethodBeat.o(221947);
      return paramfl;
      d2 = d3;
    }
  }
  
  public final fl c(LatLng paramLatLng)
  {
    AppMethodBeat.i(221940);
    double d1 = paramLatLng.longitude / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.latitude));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    paramLatLng = new fl((d1 + 0.5D) * this.d, (d2 + 0.5D) * this.d);
    AppMethodBeat.o(221940);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fw
 * JD-Core Version:    0.7.0.1
 */