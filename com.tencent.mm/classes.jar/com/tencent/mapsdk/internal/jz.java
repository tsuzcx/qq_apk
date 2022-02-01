package com.tencent.mapsdk.internal;

import android.graphics.Point;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class jz
{
  public static final int a = 256;
  public static final int b = 20;
  public static final double c = 42722829.723526977D;
  private static final int d = 20037508;
  private static final int e = 30240971;
  private static final double f = 111319.49077777778D;
  private static final double g = 0.0174532925199433D;
  private static final double h = 0.008726646259971648D;
  private static final double i = 114.59155902616465D;
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(223893);
    double d1 = c(paramDouble3 - paramDouble1);
    paramDouble2 = c(paramDouble4 - paramDouble2);
    paramDouble1 = c(paramDouble1);
    paramDouble3 = c(paramDouble3);
    paramDouble4 = Math.sin(d1 / 2.0D);
    d1 = Math.sin(d1 / 2.0D);
    double d2 = Math.sin(paramDouble2 / 2.0D);
    paramDouble1 = d1 * paramDouble4 + Math.sin(paramDouble2 / 2.0D) * d2 * Math.cos(paramDouble1) * Math.cos(paramDouble3);
    paramDouble1 = Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1));
    AppMethodBeat.o(223893);
    return paramDouble1 * 2.0D * 6371.0D * 1000.0D;
  }
  
  private static float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(223871);
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null))
    {
      paramGeoPoint1 = new IllegalArgumentException("point is null");
      AppMethodBeat.o(223871);
      throw paramGeoPoint1;
    }
    float f1 = (float)a(paramGeoPoint1.getLatitudeE6() / 1000000.0D, paramGeoPoint1.getLongitudeE6() / 1000000.0D, paramGeoPoint2.getLatitudeE6() / 1000000.0D, paramGeoPoint2.getLongitudeE6() / 1000000.0D);
    AppMethodBeat.o(223871);
    return f1;
  }
  
  private static int a(double paramDouble)
  {
    return (int)(111319.49077777778D * paramDouble + 20037508.0D);
  }
  
  private static int a(int paramInt)
  {
    return 20037508 + paramInt;
  }
  
  public static GeoPoint a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223989);
    double d1 = paramInt1 / 42722829.723526977D;
    GeoPoint localGeoPoint = new GeoPoint((int)(Math.toDegrees((Math.atan(Math.exp(3.141592653589793D - paramInt2 / 42722829.723526977D)) - 0.7853981633974483D) * 2.0D) * 1000000.0D), (int)(Math.toDegrees(d1 - 3.141592653589793D) * 1000000.0D));
    AppMethodBeat.o(223989);
    return localGeoPoint;
  }
  
  public static LatLng a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224007);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(224007);
      return null;
    }
    paramGeoPoint = new LatLng(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
    AppMethodBeat.o(224007);
    return paramGeoPoint;
  }
  
  public static List<LatLng> a(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(224017);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(224017);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((GeoPoint)paramList.next()));
    }
    AppMethodBeat.o(224017);
    return localArrayList;
  }
  
  private static void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(223881);
    Location.distanceBetween(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramArrayOfFloat);
    paramArrayOfFloat[0] = ((float)a(paramDouble1, paramDouble2, paramDouble3, paramDouble4));
    AppMethodBeat.o(223881);
  }
  
  private static float b(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(223999);
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null))
    {
      AppMethodBeat.o(223999);
      return 0.0F;
    }
    float[] arrayOfFloat = new float[10];
    double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
    double d3 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
    double d4 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
    Location.distanceBetween(d1, d2, d3, d4, arrayOfFloat);
    arrayOfFloat[0] = ((float)a(d1, d2, d3, d4));
    float f1 = arrayOfFloat[1];
    AppMethodBeat.o(223999);
    return f1;
  }
  
  private static int b(double paramDouble)
  {
    AppMethodBeat.i(223837);
    int j = (int)(Math.log(Math.tan((90.0D + paramDouble) * 0.008726646259971648D)) / 0.0174532925199433D * 111319.49077777778D + 30240971.0D);
    AppMethodBeat.o(223837);
    return j;
  }
  
  private static int b(int paramInt)
  {
    return 30240971 + paramInt;
  }
  
  private static Point b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223941);
    if (paramGeoPoint == null)
    {
      paramGeoPoint = new IllegalArgumentException("point is null");
      AppMethodBeat.o(223941);
      throw paramGeoPoint;
    }
    paramGeoPoint = new Point(a(paramGeoPoint.getLongitudeE6() / 1000000.0D), b(paramGeoPoint.getLatitudeE6() / 1000000.0D));
    AppMethodBeat.o(223941);
    return paramGeoPoint;
  }
  
  private static GeoPoint b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223932);
    GeoPoint localGeoPoint = new GeoPoint((int)(f(paramInt2) * 1000000.0D), (int)(e(paramInt1) * 1000000.0D));
    AppMethodBeat.o(223932);
    return localGeoPoint;
  }
  
  private static void b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(223924);
    double d5 = 0.0174532925199433D * paramDouble4 - 0.0174532925199433D * paramDouble2;
    paramDouble2 = 0.0D;
    paramDouble1 = Math.atan(Math.tan(0.0174532925199433D * paramDouble1) * 0.996647189328169D);
    paramDouble3 = Math.atan(Math.tan(0.0174532925199433D * paramDouble3) * 0.996647189328169D);
    double d6 = Math.cos(paramDouble1);
    double d7 = Math.cos(paramDouble3);
    double d8 = Math.sin(paramDouble1);
    double d9 = Math.sin(paramDouble3);
    double d10 = d6 * d7;
    double d11 = d8 * d9;
    double d3 = 0.0D;
    paramDouble3 = 0.0D;
    paramDouble4 = 0.0D;
    double d1 = 0.0D;
    double d2 = d5;
    int j = 0;
    paramDouble1 = paramDouble2;
    paramDouble2 = d3;
    if (j < 20)
    {
      paramDouble4 = Math.cos(d2);
      paramDouble1 = Math.sin(d2);
      paramDouble2 = d7 * paramDouble1;
      paramDouble3 = d6 * d9 - d8 * d7 * paramDouble4;
      double d12 = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble3 * paramDouble3);
      double d13 = d11 + d10 * paramDouble4;
      paramDouble2 = Math.atan2(d12, d13);
      if (d12 == 0.0D)
      {
        d1 = 0.0D;
        label202:
        paramDouble3 = 1.0D - d1 * d1;
        if (paramDouble3 != 0.0D) {
          break label497;
        }
      }
      label497:
      for (double d4 = 0.0D;; d4 = d13 - 2.0D * d11 / paramDouble3)
      {
        double d14 = paramDouble3 * 0.006739496756586903D;
        d3 = 1.0D + d14 / 16384.0D * (4096.0D + (-768.0D + (320.0D - 175.0D * d14) * d14) * d14);
        d14 = (d14 * (-128.0D + (74.0D - 47.0D * d14) * d14) + 256.0D) * (d14 / 1024.0D);
        double d15 = 0.0002095506669894369D * paramDouble3 * ((4.0D - paramDouble3 * 3.0D) * 0.00335281067183099D + 4.0D);
        paramDouble3 = d4 * d4;
        double d16 = d14 / 4.0D;
        paramDouble3 = (((-1.0D + 2.0D * paramDouble3) * d13 - (paramDouble3 * 4.0D - 3.0D) * (d14 / 6.0D * d4 * (-3.0D + 4.0D * d12 * d12))) * d16 + d4) * (d14 * d12);
        d1 = d5 + ((d4 + d13 * d15 * (-1.0D + 2.0D * d4 * d4)) * (d12 * d15) + paramDouble2) * (d1 * ((1.0D - d15) * 0.00335281067183099D));
        if (Math.abs((d1 - d2) / d1) < 1.0E-012D) {
          break label514;
        }
        j += 1;
        d2 = d1;
        d1 = paramDouble1;
        paramDouble1 = d3;
        break;
        d1 = d10 * paramDouble1 / d12;
        break label202;
      }
      label514:
      d1 = paramDouble1;
      paramDouble1 = d3;
    }
    paramArrayOfFloat[0] = ((float)(6356752.3141999999D * paramDouble1 * (paramDouble2 - paramDouble3)));
    if (paramArrayOfFloat.length > 1)
    {
      paramArrayOfFloat[1] = ((float)((float)Math.atan2(d7 * d1, d6 * d9 - d8 * d7 * paramDouble4) * 57.295779513082323D));
      if (paramArrayOfFloat.length > 2) {
        paramArrayOfFloat[2] = ((float)((float)Math.atan2(d1 * d6, -d8 * d7 + paramDouble4 * (d6 * d9)) * 57.295779513082323D));
      }
    }
    AppMethodBeat.o(223924);
  }
  
  private static double c(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  private static int c(int paramInt)
  {
    return paramInt - 20037508;
  }
  
  private static Point c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223964);
    if (paramGeoPoint == null)
    {
      paramGeoPoint = new IllegalArgumentException("point is null");
      AppMethodBeat.o(223964);
      throw paramGeoPoint;
    }
    paramGeoPoint = new Point(a(paramGeoPoint.getLongitudeE6() / 1000000.0D) - 20037508, b(paramGeoPoint.getLatitudeE6() / 1000000.0D) - 30240971);
    AppMethodBeat.o(223964);
    return paramGeoPoint;
  }
  
  private static GeoPoint c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223954);
    GeoPoint localGeoPoint = new GeoPoint((int)(f(30240971 + paramInt2) * 1000000.0D), (int)(e(20037508 + paramInt1) * 1000000.0D));
    AppMethodBeat.o(223954);
    return localGeoPoint;
  }
  
  private static int d(int paramInt)
  {
    return paramInt - 30240971;
  }
  
  private static Point d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223973);
    Point localPoint = new Point(a(paramInt1 / 1000000.0D) - 20037508, b(paramInt2 / 1000000.0D) - 30240971);
    AppMethodBeat.o(223973);
    return localPoint;
  }
  
  private static Point d(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(223982);
    if (paramGeoPoint == null)
    {
      paramGeoPoint = new IllegalArgumentException("point is null");
      AppMethodBeat.o(223982);
      throw paramGeoPoint;
    }
    double d2 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d1 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    d2 = Math.log(Math.tan((d2 + 90.0D) * 0.008726646259971648D)) / 0.0174532923847437D;
    paramGeoPoint = new Point();
    paramGeoPoint.x = ((int)((d1 + 180.0D) / 360.0D * 268435456.0D));
    paramGeoPoint.y = ((int)((180.0D - d2) / 360.0D * 268435456.0D));
    AppMethodBeat.o(223982);
    return paramGeoPoint;
  }
  
  private static double e(int paramInt)
  {
    return (paramInt - 20037508) / 111319.49077777778D;
  }
  
  private static double f(int paramInt)
  {
    AppMethodBeat.i(223859);
    double d1 = Math.atan(Math.exp((paramInt - 30240971) / 111319.49077777778D * 0.0174532925199433D));
    AppMethodBeat.o(223859);
    return d1 * 114.59155902616465D - 90.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jz
 * JD-Core Version:    0.7.0.1
 */