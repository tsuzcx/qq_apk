package com.tencent.map.lib.util;

import com.tencent.map.lib.basemap.data.GeoPoint;

public class d
{
  public static GeoPoint a(int paramInt1, int paramInt2)
  {
    double d2 = paramInt2 * 360.0F / 2.684355E+008F;
    double d1 = paramInt1 * 360.0F / 2.684355E+008F;
    d2 = Math.atan(Math.exp((180.0D - d2) * 0.0174532925199433D)) / 0.008726646259971648D;
    paramInt1 = (int)Math.ceil((d1 - 180.0D) * 1000000.0D);
    return new GeoPoint((int)Math.ceil((d2 - 90.0D) * 1000000.0D), paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.util.d
 * JD-Core Version:    0.7.0.1
 */