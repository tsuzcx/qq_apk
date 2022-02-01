package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng
  implements Cloneable
{
  private static DecimalFormat df;
  private final double latitude;
  private final double longitude;
  
  static
  {
    AppMethodBeat.i(87563);
    df = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    AppMethodBeat.o(87563);
  }
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(87556);
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.longitude = parseDouble(paramDouble2);; this.longitude = parseDouble(((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.latitude = parseDouble(Math.max(-85.0D, Math.min(85.0D, paramDouble1)));
      AppMethodBeat.o(87556);
      return;
    }
  }
  
  private static double parseDouble(double paramDouble)
  {
    AppMethodBeat.i(87557);
    paramDouble = Double.parseDouble(df.format(paramDouble));
    AppMethodBeat.o(87557);
    return paramDouble;
  }
  
  public final LatLng clone()
  {
    AppMethodBeat.i(87558);
    LatLng localLatLng = new LatLng(this.latitude, this.longitude);
    AppMethodBeat.o(87558);
    return localLatLng;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(87560);
    if (this == paramObject)
    {
      AppMethodBeat.o(87560);
      return true;
    }
    if (!(paramObject instanceof LatLng))
    {
      AppMethodBeat.o(87560);
      return false;
    }
    paramObject = (LatLng)paramObject;
    if ((Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(paramObject.latitude)) && (Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(paramObject.longitude)))
    {
      AppMethodBeat.o(87560);
      return true;
    }
    AppMethodBeat.o(87560);
    return false;
  }
  
  public final double getLatitude()
  {
    return this.latitude;
  }
  
  public final double getLongitude()
  {
    return this.longitude;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(87559);
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    int j = (int)(l ^ l >>> 32);
    AppMethodBeat.o(87559);
    return (i + 31) * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87561);
    String str = "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    AppMethodBeat.o(87561);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLng
 * JD-Core Version:    0.7.0.1
 */