package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((d.uO(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (d.c(localWifiConfiguration) == paramInt)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static boolean aT(String paramString, int paramInt)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    Object localObject = c.getConfiguredNetworks();
    bool1 = bool3;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      bool1 = false;
      label46:
      if (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if ((d.uO(localWifiConfiguration.SSID).compareTo(paramString) != 0) || (d.c(localWifiConfiguration) != paramInt)) {
          break label118;
        }
        bool1 |= c.removeNetwork(localWifiConfiguration.networkId);
      }
    }
    label118:
    for (;;)
    {
      break label46;
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      c.saveConfiguration();
      return bool1;
    }
  }
  
  public static int b(WifiConfiguration paramWifiConfiguration)
  {
    if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId < 0))
    {
      paramWifiConfiguration.networkId = c.addNetwork(paramWifiConfiguration);
      return paramWifiConfiguration.networkId;
    }
    return -1;
  }
  
  public static boolean lJ(int paramInt)
  {
    boolean bool = false;
    if ((c.removeNetwork(paramInt)) || (c.disableNetwork(paramInt)))
    {
      bool = true;
      c.saveConfiguration();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b
 * JD-Core Version:    0.7.0.1
 */