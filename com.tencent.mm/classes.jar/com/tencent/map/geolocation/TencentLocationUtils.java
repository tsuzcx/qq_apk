package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.eq;
import c.t.m.g.j;

public class TencentLocationUtils
{
  private TencentLocationUtils()
  {
    throw new UnsupportedOperationException();
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null)) {
      throw new NullPointerException();
    }
    return distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble;
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return j.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null)) {
      throw new NullPointerException();
    }
    return j.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return false;
    }
    return "gps".equals(paramTencentLocation.getProvider());
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return false;
    }
    return "network".equals(paramTencentLocation.getProvider());
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException();
    }
    eq.a();
    return (eq.a(paramContext) & 0x10) == 0;
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble1.length != 2) || (paramArrayOfDouble2.length != 2)) {
      return false;
    }
    return j.a(paramArrayOfDouble1, paramArrayOfDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */