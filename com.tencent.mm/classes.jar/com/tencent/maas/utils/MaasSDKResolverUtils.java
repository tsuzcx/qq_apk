package com.tencent.maas.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.tencent.maas.model.MJLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MaasSDKResolverUtils
{
  private static final ConcurrentHashMap<MJLocation, String> locationHashMap;
  
  static
  {
    AppMethodBeat.i(216784);
    locationHashMap = new ConcurrentHashMap();
    AppMethodBeat.o(216784);
  }
  
  public static String formatTimestamp(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(216765);
    paramString1 = MaasSDKTimestampUtils.INSTANCE.formatTimestamp(paramLong, paramString1, paramString2);
    AppMethodBeat.o(216765);
    return paramString1;
  }
  
  public static String[] getCities(Context paramContext, Object[] paramArrayOfObject, long paramLong)
  {
    AppMethodBeat.i(216768);
    if ((paramContext == null) || (paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      AppMethodBeat.o(216768);
      return null;
    }
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    try
    {
      localExecutorService.submit(new MaasSDKResolverUtils..ExternalSyntheticLambda0(paramArrayOfObject, paramContext)).get(paramLong, TimeUnit.MILLISECONDS);
      label56:
      localExecutorService.shutdown();
      paramContext = new String[paramArrayOfObject.length];
      int i = 0;
      if (i < paramArrayOfObject.length)
      {
        if (locationHashMap.containsKey((MJLocation)paramArrayOfObject[i])) {
          paramContext[i] = ((String)locationHashMap.get((MJLocation)paramArrayOfObject[i]));
        }
        for (;;)
        {
          i += 1;
          break;
          paramContext[i] = null;
        }
      }
      AppMethodBeat.o(216768);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label56;
    }
  }
  
  private static String getCity(Context paramContext, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(216773);
    try
    {
      paramContext = new Geocoder(paramContext, Locale.getDefault()).getFromLocation(paramDouble2, paramDouble1, 1);
      if (paramContext.size() > 0)
      {
        paramContext = ((Address)paramContext.get(0)).getLocality();
        AppMethodBeat.o(216773);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.maas.utils.MaasSDKResolverUtils
 * JD-Core Version:    0.7.0.1
 */