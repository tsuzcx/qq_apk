package com.tencent.mapsdk.raster.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng
  implements Cloneable
{
  private static DecimalFormat df = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
  private final double latitude;
  private final double longitude;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.longitude = parseDouble(paramDouble2);; this.longitude = parseDouble(((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.latitude = parseDouble(Math.max(-85.0D, Math.min(85.0D, paramDouble1)));
      return;
    }
  }
  
  private static double parseDouble(double paramDouble)
  {
    return Double.parseDouble(df.format(paramDouble));
  }
  
  public final LatLng clone()
  {
    return new LatLng(this.latitude, this.longitude);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLng)) {
        return false;
      }
      paramObject = (LatLng)paramObject;
    } while ((Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(paramObject.latitude)) && (Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(paramObject.longitude)));
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
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    return (i + 31) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLng
 * JD-Core Version:    0.7.0.1
 */