package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.c.q;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationUtils
{
  private TencentLocationUtils()
  {
    AppMethodBeat.i(136478);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(136478);
    throw localUnsupportedOperationException;
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(136481);
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null))
    {
      paramTencentLocation1 = new NullPointerException();
      AppMethodBeat.o(136481);
      throw paramTencentLocation1;
    }
    if (distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble)
    {
      AppMethodBeat.o(136481);
      return true;
    }
    AppMethodBeat.o(136481);
    return false;
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(136480);
    paramDouble1 = q.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(136480);
    return paramDouble1;
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    AppMethodBeat.i(136479);
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null))
    {
      paramTencentLocation1 = new NullPointerException();
      AppMethodBeat.o(136479);
      throw paramTencentLocation1;
    }
    double d = q.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
    AppMethodBeat.o(136479);
    return d;
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(136483);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(136483);
      return false;
    }
    boolean bool = "gps".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(136483);
    return bool;
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(136484);
    if (paramTencentLocation == null)
    {
      AppMethodBeat.o(136484);
      return false;
    }
    boolean bool = "network".equals(paramTencentLocation.getProvider());
    AppMethodBeat.o(136484);
    return bool;
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    AppMethodBeat.i(136485);
    if (paramContext == null)
    {
      paramContext = new NullPointerException();
      AppMethodBeat.o(136485);
      throw paramContext;
    }
    if ((q.g(paramContext) & 0x10) == 0)
    {
      AppMethodBeat.o(136485);
      return true;
    }
    AppMethodBeat.o(136485);
    return false;
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(136482);
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null)) {}
    try
    {
      if (paramArrayOfDouble1.length == 2)
      {
        int i = paramArrayOfDouble2.length;
        if (i == 2) {}
      }
      else
      {
        AppMethodBeat.o(136482);
        return false;
      }
      boolean bool = TencentExtraKeys.wgs84ToGcj02(paramArrayOfDouble1, paramArrayOfDouble2);
      AppMethodBeat.o(136482);
      return bool;
    }
    catch (Exception paramArrayOfDouble1)
    {
      AppMethodBeat.o(136482);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */