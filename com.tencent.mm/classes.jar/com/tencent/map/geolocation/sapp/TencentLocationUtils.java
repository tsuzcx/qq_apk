package com.tencent.map.geolocation.sapp;

import android.content.Context;
import c.t.m.sapp.c.r;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationUtils
{
  public TencentLocationUtils()
  {
    AppMethodBeat.i(210858);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(210858);
    throw localUnsupportedOperationException;
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(210883);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      if (distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble)
      {
        AppMethodBeat.o(210883);
        return true;
      }
      AppMethodBeat.o(210883);
      return false;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(210883);
    throw paramTencentLocation1;
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(210875);
    paramDouble1 = r.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(210875);
    return paramDouble1;
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(210867);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      double d = r.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
      AppMethodBeat.o(210867);
      return d;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(210867);
    throw paramTencentLocation1;
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210899);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(210899);
      return false;
    }
    boolean bool = "gps".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(210899);
    return bool;
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210905);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(210905);
      return false;
    }
    boolean bool = "network".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(210905);
    return bool;
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    AppMethodBeat.i(210913);
    if (paramContext != null)
    {
      if ((r.f(paramContext) & 0x10) == 0)
      {
        AppMethodBeat.o(210913);
        return true;
      }
      AppMethodBeat.o(210913);
      return false;
    }
    paramContext = new NullPointerException();
    AppMethodBeat.o(210913);
    throw paramContext;
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(210892);
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null)) {
      try
      {
        if ((paramArrayOfDouble1.length == 2) && (paramArrayOfDouble2.length == 2))
        {
          boolean bool = TencentExtraKeys.wgs84ToGcj02(paramArrayOfDouble1, paramArrayOfDouble2);
          AppMethodBeat.o(210892);
          return bool;
        }
      }
      catch (Exception paramArrayOfDouble1)
      {
        AppMethodBeat.o(210892);
        return false;
      }
    }
    AppMethodBeat.o(210892);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */