package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    AppMethodBeat.i(94401);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((d.Dh(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (d.c(localWifiConfiguration) == paramInt))
        {
          AppMethodBeat.o(94401);
          return localWifiConfiguration;
        }
      }
    }
    AppMethodBeat.o(94401);
    return null;
  }
  
  public static int b(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(94399);
    if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId < 0))
    {
      paramWifiConfiguration.networkId = c.addNetwork(paramWifiConfiguration);
      int i = paramWifiConfiguration.networkId;
      AppMethodBeat.o(94399);
      return i;
    }
    AppMethodBeat.o(94399);
    return -1;
  }
  
  public static boolean bk(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(94400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(94400);
      return false;
    }
    Object localObject = c.getConfiguredNetworks();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      bool = false;
      if (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if ((d.Dh(localWifiConfiguration.SSID).compareTo(paramString) != 0) || (d.c(localWifiConfiguration) != paramInt)) {
          break label115;
        }
        bool |= c.removeNetwork(localWifiConfiguration.networkId);
      }
    }
    label115:
    for (;;)
    {
      break;
      if (bool) {
        c.saveConfiguration();
      }
      AppMethodBeat.o(94400);
      return bool;
    }
  }
  
  public static boolean os(int paramInt)
  {
    AppMethodBeat.i(94402);
    boolean bool = false;
    if ((c.removeNetwork(paramInt)) || (c.disableNetwork(paramInt)))
    {
      bool = true;
      c.saveConfiguration();
    }
    AppMethodBeat.o(94402);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b
 * JD-Core Version:    0.7.0.1
 */