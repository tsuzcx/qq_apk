package com.tencent.map.lib.util;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
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
    int k = paramGeoPoint2.getLatitudeE6() - paramGeoPoint1.getLatitudeE6();
    int i = paramGeoPoint2.getLongitudeE6() - paramGeoPoint1.getLongitudeE6();
    if ((k == 0) && (i == 0)) {
      return null;
    }
    double d = ((paramGeoPoint3.getLatitudeE6() - paramGeoPoint1.getLatitudeE6()) * k + (paramGeoPoint3.getLongitudeE6() - paramGeoPoint1.getLongitudeE6()) * i) / (k * k + i * i);
    if (d < 0.0D) {
      return new GeoPoint(paramGeoPoint1);
    }
    if (d > 1.0D) {
      return new GeoPoint(paramGeoPoint2);
    }
    int j = paramGeoPoint1.getLatitudeE6();
    k = (int)(k * d);
    int m = paramGeoPoint1.getLongitudeE6();
    return new GeoPoint(k + j, (int)(d * i) + m);
  }
  
  public static Rect getBound(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null) || (paramGeoPoint1.equals(paramGeoPoint2))) {
      return null;
    }
    int i = Math.abs(paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6());
    int j = Math.abs(paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6());
    return new Rect(paramGeoPoint1.getLongitudeE6() - i, paramGeoPoint1.getLatitudeE6() - j, i + paramGeoPoint1.getLongitudeE6(), j + paramGeoPoint1.getLatitudeE6());
  }
  
  public static double getDoubleByDecimalNum(double paramDouble, int paramInt)
  {
    try
    {
      double d = new BigDecimal(paramDouble).setScale(paramInt, 4).doubleValue();
      return d;
    }
    catch (Exception localException) {}
    return paramDouble;
  }
  
  public static Rect getExtendedBound(GeoPoint paramGeoPoint, Rect paramRect)
  {
    int i = Math.max(Math.abs(paramRect.left - paramGeoPoint.getLongitudeE6()), Math.abs(paramRect.right - paramGeoPoint.getLongitudeE6()));
    int j = Math.max(Math.abs(paramRect.top - paramGeoPoint.getLatitudeE6()), Math.abs(paramRect.bottom - paramGeoPoint.getLatitudeE6()));
    return new Rect(paramGeoPoint.getLongitudeE6() - j, paramGeoPoint.getLatitudeE6() - i, j + paramGeoPoint.getLongitudeE6(), i + paramGeoPoint.getLatitudeE6());
  }
  
  public static float getFloatByDecimalNum(float paramFloat, int paramInt)
  {
    try
    {
      float f = new BigDecimal(paramFloat).setScale(paramInt, 4).floatValue();
      return f;
    }
    catch (Exception localException) {}
    return paramFloat;
  }
  
  public static PointF getPoiWith2Line(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    if ((paramPointF2.x == paramPointF1.x) || (paramPointF4.x == paramPointF3.x)) {}
    float f1;
    do
    {
      return null;
      f3 = (paramPointF2.y - paramPointF1.y) / (paramPointF2.x - paramPointF1.x);
      f1 = (paramPointF4.y - paramPointF3.y) / (paramPointF4.x - paramPointF3.x);
    } while (f3 == f1);
    float f4 = (paramPointF1.y * paramPointF2.x - paramPointF2.y * paramPointF1.x) / (paramPointF2.x - paramPointF1.x);
    float f2 = (paramPointF3.y * paramPointF4.x - paramPointF4.y * paramPointF3.x) / (paramPointF4.x - paramPointF3.x);
    float f3 = (f2 - f4) / (f3 - f1);
    return new PointF(f3, f1 * f3 + f2);
  }
  
  public static double radian2Angle(double paramDouble)
  {
    return 180.0D * paramDouble / 3.141592653589793D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.util.MathUtil
 * JD-Core Version:    0.7.0.1
 */