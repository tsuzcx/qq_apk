package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static double oyL = 6378137.0D;
  final double oyM;
  
  public f()
  {
    AppMethodBeat.i(146599);
    this.oyM = (6.283185307179586D * oyL);
    AppMethodBeat.o(146599);
  }
  
  public final e b(LatLng paramLatLng)
  {
    AppMethodBeat.i(146600);
    double d1 = paramLatLng.getLongitude() / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.getLatitude()));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    paramLatLng = new e((d1 + 0.5D) * this.oyM, (d2 + 0.5D) * this.oyM);
    AppMethodBeat.o(146600);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.f
 * JD-Core Version:    0.7.0.1
 */