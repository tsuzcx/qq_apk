package com.tencent.luggage.l;

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
  public static String atk()
  {
    AppMethodBeat.i(219958);
    int i = ConnectivityCompat.Companion.getWiFiIpAddress();
    if (i == 0)
    {
      AppMethodBeat.o(219958);
      return "127.0.0.1";
    }
    String str = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
    AppMethodBeat.o(219958);
    return str;
  }
  
  public static String atl()
  {
    i = 0;
    AppMethodBeat.i(219963);
    try
    {
      int j = ac.aPK();
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
      Object localObject1 = atk();
      AppMethodBeat.o(219963);
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
          AppMethodBeat.o(219963);
          return "127.0.0.1";
        }
      }
      catch (Exception localException2)
      {
        AppMethodBeat.o(219963);
        return "127.0.0.1";
      }
      String str = localInetAddress.getHostAddress();
      AppMethodBeat.o(219963);
      return str;
    }
    if (i == 0)
    {
      AppMethodBeat.o(219963);
      return "127.0.0.1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.l.h
 * JD-Core Version:    0.7.0.1
 */