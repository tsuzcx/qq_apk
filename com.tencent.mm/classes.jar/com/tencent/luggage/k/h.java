package com.tencent.luggage.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class h
{
  public static String SG()
  {
    AppMethodBeat.i(207626);
    int i = ConnectivityCompat.Companion.getWiFiIpAddress();
    if (i == 0)
    {
      AppMethodBeat.o(207626);
      return "127.0.0.1";
    }
    String str = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
    AppMethodBeat.o(207626);
    return str;
  }
  
  public static String SH()
  {
    i = 0;
    AppMethodBeat.i(207627);
    try
    {
      int j = ac.avq();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("Luggage.LuggageNetUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[] { localException1 });
      }
      if (i != 1) {
        break label64;
      }
      MMApplicationContext.getContext();
      Object localObject1 = SG();
      AppMethodBeat.o(207627);
      return localObject1;
      InetAddress localInetAddress;
      try
      {
        do
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          Object localObject2;
          while (!((Enumeration)localObject2).hasMoreElements())
          {
            do
            {
              if (!((Enumeration)localObject1).hasMoreElements()) {
                break;
              }
              localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
            } while (localObject2 == null);
            localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          }
          localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
        } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        if (Util.isNullOrNil(localInetAddress.getHostAddress()))
        {
          AppMethodBeat.o(207627);
          return "127.0.0.1";
        }
      }
      catch (Exception localException2)
      {
        AppMethodBeat.o(207627);
        return "127.0.0.1";
      }
      String str = localInetAddress.getHostAddress();
      AppMethodBeat.o(207627);
      return str;
    }
    if (i == 0)
    {
      AppMethodBeat.o(207627);
      return "127.0.0.1";
    }
  }
  
  public static boolean aL(Context paramContext)
  {
    AppMethodBeat.i(207629);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkInfo(1);
      if (paramContext == null) {}
    }
    for (boolean bool = paramContext.isConnected();; bool = false)
    {
      AppMethodBeat.o(207629);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.h
 * JD-Core Version:    0.7.0.1
 */