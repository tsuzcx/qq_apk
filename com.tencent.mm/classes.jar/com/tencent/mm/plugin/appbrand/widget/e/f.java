package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static double jrI = 6378137.0D;
  final double jrJ;
  
  public f()
  {
    AppMethodBeat.i(51276);
    this.jrJ = (6.283185307179586D * jrI);
    AppMethodBeat.o(51276);
  }
  
  public final e b(LatLng paramLatLng)
  {
    AppMethodBeat.i(51277);
    double d1 = paramLatLng.getLongitude() / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.getLatitude()));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    paramLatLng = new e((d1 + 0.5D) * this.jrJ, (d2 + 0.5D) * this.jrJ);
    AppMethodBeat.o(51277);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.f
 * JD-Core Version:    0.7.0.1
 */