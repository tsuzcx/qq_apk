package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class jy
{
  private static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(223822);
    double d4 = paramLatLng1.longitude;
    double d3 = paramLatLng1.latitude;
    double d2 = paramLatLng2.longitude;
    double d1 = paramLatLng2.latitude;
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng1 = new double[3];
    paramLatLng2 = new double[3];
    paramLatLng1[0] = (d5 * d6);
    paramLatLng1[1] = (d6 * d1);
    paramLatLng1[2] = d2;
    paramLatLng2[0] = (d4 * d3);
    paramLatLng2[1] = (d4 * d7);
    paramLatLng2[2] = d8;
    d1 = Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D);
    AppMethodBeat.o(223822);
    return d1 * 12742001.579854401D;
  }
  
  private static LatLng b(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(223835);
    paramLatLng1 = new LatLng(paramLatLng1.latitude * 2.0D - paramLatLng2.latitude, paramLatLng1.longitude * 2.0D - paramLatLng2.longitude);
    AppMethodBeat.o(223835);
    return paramLatLng1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jy
 * JD-Core Version:    0.7.0.1
 */