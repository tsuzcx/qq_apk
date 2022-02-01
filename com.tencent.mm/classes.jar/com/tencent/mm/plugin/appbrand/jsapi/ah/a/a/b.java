package com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;

import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static boolean Bn(int paramInt)
  {
    AppMethodBeat.i(144717);
    boolean bool = false;
    if ((d.Bo(paramInt)) || (d.Bq(paramInt)))
    {
      bool = true;
      d.bYe();
    }
    AppMethodBeat.o(144717);
    return bool;
  }
  
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    AppMethodBeat.i(144716);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((e.ajE(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (e.e(localWifiConfiguration) == paramInt))
        {
          AppMethodBeat.o(144716);
          return localWifiConfiguration;
        }
      }
    }
    AppMethodBeat.o(144716);
    return null;
  }
  
  public static int c(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144714);
    if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId < 0))
    {
      paramWifiConfiguration.networkId = d.d(paramWifiConfiguration);
      int i = paramWifiConfiguration.networkId;
      AppMethodBeat.o(144714);
      return i;
    }
    AppMethodBeat.o(144714);
    return -1;
  }
  
  public static boolean co(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(144715);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(144715);
      return false;
    }
    Object localObject = d.bYa();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      bool = false;
      if (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if ((e.ajE(localWifiConfiguration.SSID).compareTo(paramString) != 0) || (e.e(localWifiConfiguration) != paramInt)) {
          break label115;
        }
        bool |= d.Bo(localWifiConfiguration.networkId);
      }
    }
    label115:
    for (;;)
    {
      break;
      if (bool) {
        d.bYe();
      }
      AppMethodBeat.o(144715);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b
 * JD-Core Version:    0.7.0.1
 */