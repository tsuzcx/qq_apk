package com.tencent.map.lib.util;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public class MathUtil
{
  public static double angle2Radian(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double calShortestAngleDistance(double paramDouble)
  {
    double d = paramDouble % 360.0D;
    if (d > 180.0D) {
      paramDouble = d - 360.0D;
    }
    do
    {
      return paramDouble;
      paramDouble = d;
    } while (d >= -180.0D);
    return d + 360.0D;
  }
  
  public static GeoPoint findClosetPoint(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, GeoPoint paramGeoPoint3)
  {
    AppMethodBeat.i(98212);
    int k = paramGeoPoint2.getLatitudeE6() - paramGeoPoint1.getLatitudeE6();
    int i = paramGeoPoint2.getLongitudeE6() - paramGeoPoint1.getLongitudeE6();
    if ((k == 0) && (i == 0))
    {
      AppMethodBeat.o(98212);
      return null;
    }
    double d = ((paramGeoPoint3.getLatitudeE6() - paramGeoPoint1.getLatitudeE6()) * k + (paramGeoPoint3.getLongitudeE6() - paramGeoPoint1.getLongitudeE6()) * i) / (k * k + i * i);
    if (d < 0.0D)
    {
      paramGeoPoint1 = new GeoPoint(paramGeoPoint1);
      AppMethodBeat.o(98212);
      return paramGeoPoint1;
    }
    if (d > 1.0D)
    {
      paramGeoPoint1 = new GeoPoint(paramGeoPoint2);
      AppMethodBeat.o(98212);
      return paramGeoPoint1;
    }
    int j = paramGeoPoint1.getLatitudeE6();
    k = (int)(k * d);
    int m = paramGeoPoint1.getLongitudeE6();
    paramGeoPoint1 = new GeoPoint(k + j, (int)(d * i) + m);
    AppMethodBeat.o(98212);
    return paramGeoPoint1;
  }
  
  public static Rect getBound(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(98211);
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null) || (paramGeoPoint1.equals(paramGeoPoint2)))
    {
      AppMethodBeat.o(98211);
      return null;
    }
    int i = Math.abs(paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6());
    int j = Math.abs(paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6());
    paramGeoPoint1 = new Rect(paramGeoPoint1.getLongitudeE6() - i, paramGeoPoint1.getLatitudeE6() - j, i + paramGeoPoint1.getLongitudeE6(), j + paramGeoPoint1.getLatitudeE6());
    AppMethodBeat.o(98211);
    return paramGeoPoint1;
  }
  
  public static double getDoubleByDecimalNum(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(98207);
    try
    {
      double d = new BigDecimal(paramDouble).setScale(paramInt, 4).doubleValue();
      AppMethodBeat.o(98207);
      return d;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98207);
    }
    return paramDouble;
  }
  
  public static Rect getExtendedBound(GeoPoint paramGeoPoint, Rect paramRect)
  {
    AppMethodBeat.i(98210);
    int i = Math.max(Math.abs(paramRect.left - paramGeoPoint.getLongitudeE6()), Math.abs(paramRect.right - paramGeoPoint.getLongitudeE6()));
    int j = Math.max(Math.abs(paramRect.top - paramGeoPoint.getLatitudeE6()), Math.abs(paramRect.bottom - paramGeoPoint.getLatitudeE6()));
    paramGeoPoint = new Rect(paramGeoPoint.getLongitudeE6() - j, paramGeoPoint.getLatitudeE6() - i, j + paramGeoPoint.getLongitudeE6(), i + paramGeoPoint.getLatitudeE6());
    AppMethodBeat.o(98210);
    return paramGeoPoint;
  }
  
  public static float getFloatByDecimalNum(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(98208);
    try
    {
      float f = new BigDecimal(paramFloat).setScale(paramInt, 4).floatValue();
      AppMethodBeat.o(98208);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98208);
    }
    return paramFloat;
  }
  
  public static PointF getPoiWith2Line(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    AppMethodBeat.i(98209);
    if ((paramPointF2.x == paramPointF1.x) || (paramPointF4.x == paramPointF3.x))
    {
      AppMethodBeat.o(98209);
      return null;
    }
    float f3 = (paramPointF2.y - paramPointF1.y) / (paramPointF2.x - paramPointF1.x);
    float f1 = (paramPointF4.y - paramPointF3.y) / (paramPointF4.x - paramPointF3.x);
    if (f3 == f1)
    {
      AppMethodBeat.o(98209);
      return null;
    }
    float f4 = (paramPointF1.y * paramPointF2.x - paramPointF2.y * paramPointF1.x) / (paramPointF2.x - paramPointF1.x);
    float f2 = (paramPointF3.y * paramPointF4.x - paramPointF4.y * paramPointF3.x) / (paramPointF4.x - paramPointF3.x);
    f3 = (f2 - f4) / (f3 - f1);
    paramPointF1 = new PointF(f3, f1 * f3 + f2);
    AppMethodBeat.o(98209);
    return paramPointF1;
  }
  
  public static double radian2Angle(double paramDouble)
  {
    return 180.0D * paramDouble / 3.141592653589793D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.util.MathUtil
 * JD-Core Version:    0.7.0.1
 */