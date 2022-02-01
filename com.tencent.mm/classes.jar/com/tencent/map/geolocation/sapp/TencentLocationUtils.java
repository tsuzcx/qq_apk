package com.tencent.map.geolocation.sapp;

import android.content.Context;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationUtils
{
  public TencentLocationUtils()
  {
    AppMethodBeat.i(254944);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(254944);
    throw localUnsupportedOperationException;
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(254949);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      if (distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble)
      {
        AppMethodBeat.o(254949);
        return true;
      }
      AppMethodBeat.o(254949);
      return false;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(254949);
    throw paramTencentLocation1;
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(254947);
    paramDouble1 = q.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(254947);
    return paramDouble1;
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(254946);
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null))
    {
      double d = q.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
      AppMethodBeat.o(254946);
      return d;
    }
    paramTencentLocation1 = new NullPointerException();
    AppMethodBeat.o(254946);
    throw paramTencentLocation1;
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(254951);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(254951);
      return false;
    }
    boolean bool = "gps".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(254951);
    return bool;
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(254952);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(254952);
      return false;
    }
    boolean bool = "network".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(254952);
    return bool;
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    AppMethodBeat.i(254955);
    if (paramContext != null)
    {
      if ((q.g(paramContext) & 0x10) == 0)
      {
        AppMethodBeat.o(254955);
        return true;
      }
      AppMethodBeat.o(254955);
      return false;
    }
    paramContext = new NullPointerException();
    AppMethodBeat.o(254955);
    throw paramContext;
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(254950);
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null)) {
      try
      {
        if ((paramArrayOfDouble1.length == 2) && (paramArrayOfDouble2.length == 2))
        {
          boolean bool = TencentExtraKeys.wgs84ToGcj02(paramArrayOfDouble1, paramArrayOfDouble2);
          AppMethodBeat.o(254950);
          return bool;
        }
      }
      catch (Exception paramArrayOfDouble1)
      {
        AppMethodBeat.o(254950);
        return false;
      }
    }
    AppMethodBeat.o(254950);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */