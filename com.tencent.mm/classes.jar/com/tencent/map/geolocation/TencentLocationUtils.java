package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.c.q;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationUtils
{
  public TencentLocationUtils()
  {
    AppMethodBeat.i(40040);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(40040);
    throw localUnsupportedOperationException;
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(40043);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      if (distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble)
      {
        AppMethodBeat.o(40043);
        return true;
      }
      AppMethodBeat.o(40043);
      return false;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(40043);
    throw paramTencentLocation1;
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(40042);
    paramDouble1 = q.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(40042);
    return paramDouble1;
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(40041);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      double d = q.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
      AppMethodBeat.o(40041);
      return d;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(40041);
    throw paramTencentLocation1;
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(40045);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(40045);
      return false;
    }
    boolean bool = "gps".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(40045);
    return bool;
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(40046);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(40046);
      return false;
    }
    boolean bool = "network".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(40046);
    return bool;
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    AppMethodBeat.i(40047);
    if (paramContext != null)
    {
      if ((q.f(paramContext) & 0x10) == 0)
      {
        AppMethodBeat.o(40047);
        return true;
      }
      AppMethodBeat.o(40047);
      return false;
    }
    paramContext = new NullPointerException();
    AppMethodBeat.o(40047);
    throw paramContext;
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(40044);
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null)) {
      try
      {
        if ((paramArrayOfDouble1.length == 2) && (paramArrayOfDouble2.length == 2))
        {
          boolean bool = TencentExtraKeys.wgs84ToGcj02(paramArrayOfDouble1, paramArrayOfDouble2);
          AppMethodBeat.o(40044);
          return bool;
        }
      }
      catch (Exception paramArrayOfDouble1)
      {
        AppMethodBeat.o(40044);
        return false;
      }
    }
    AppMethodBeat.o(40044);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */