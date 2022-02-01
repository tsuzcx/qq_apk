package com.tencent.luggage.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class g
{
  public static String DS()
  {
    i = 0;
    AppMethodBeat.i(200929);
    try
    {
      int j = ab.Yu();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ac.e("Luggage.LuggageNetUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[] { localException1 });
      }
      if (i != 1) {
        break label63;
      }
      Object localObject1 = aD(ai.getContext());
      AppMethodBeat.o(200929);
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
        if (bs.isNullOrNil(localInetAddress.getHostAddress()))
        {
          AppMethodBeat.o(200929);
          return "127.0.0.1";
        }
      }
      catch (Exception localException2)
      {
        AppMethodBeat.o(200929);
        return "127.0.0.1";
      }
      String str = localInetAddress.getHostAddress();
      AppMethodBeat.o(200929);
      return str;
    }
    if (i == 0)
    {
      AppMethodBeat.o(200929);
      return "127.0.0.1";
    }
  }
  
  public static String aD(Context paramContext)
  {
    AppMethodBeat.i(200928);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(200928);
        return "127.0.0.1";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      int i = paramContext.getIpAddress();
      paramContext = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
      AppMethodBeat.o(200928);
    }
    return paramContext;
  }
  
  public static boolean aE(Context paramContext)
  {
    AppMethodBeat.i(200930);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkInfo(1);
      if (paramContext == null) {}
    }
    for (boolean bool = paramContext.isConnected();; bool = false)
    {
      AppMethodBeat.o(200930);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.h.g
 * JD-Core Version:    0.7.0.1
 */