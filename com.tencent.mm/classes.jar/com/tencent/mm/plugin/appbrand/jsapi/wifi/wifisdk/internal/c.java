package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
{
  public static WifiManager bWU;
  
  public static int addNetwork(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144719);
    int i;
    try
    {
      i = bWU.addNetwork(paramWifiConfiguration);
      AppMethodBeat.o(144719);
      return i;
    }
    catch (Throwable paramWifiConfiguration)
    {
      i = d.lwI;
      AppMethodBeat.o(144719);
    }
    return i;
  }
  
  public static boolean disableNetwork(int paramInt)
  {
    AppMethodBeat.i(144722);
    try
    {
      boolean bool = bWU.disableNetwork(paramInt);
      AppMethodBeat.o(144722);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144722);
    }
    return false;
  }
  
  public static List<WifiConfiguration> getConfiguredNetworks()
  {
    AppMethodBeat.i(144718);
    try
    {
      List localList = bWU.getConfiguredNetworks();
      AppMethodBeat.o(144718);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144718);
    }
    return null;
  }
  
  public static WifiInfo getConnectionInfo()
  {
    AppMethodBeat.i(144724);
    try
    {
      WifiInfo localWifiInfo = bWU.getConnectionInfo();
      AppMethodBeat.o(144724);
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144724);
    }
    return null;
  }
  
  public static List<ScanResult> getScanResults()
  {
    AppMethodBeat.i(144725);
    try
    {
      List localList = bWU.getScanResults();
      AppMethodBeat.o(144725);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144725);
    }
    return null;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(144727);
    try
    {
      boolean bool = bWU.isWifiEnabled();
      AppMethodBeat.o(144727);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144727);
    }
    return false;
  }
  
  public static boolean removeNetwork(int paramInt)
  {
    AppMethodBeat.i(144720);
    try
    {
      boolean bool = bWU.removeNetwork(paramInt);
      AppMethodBeat.o(144720);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144720);
    }
    return false;
  }
  
  public static boolean saveConfiguration()
  {
    AppMethodBeat.i(144726);
    try
    {
      boolean bool = bWU.saveConfiguration();
      AppMethodBeat.o(144726);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144726);
    }
    return false;
  }
  
  public static boolean startScan()
  {
    AppMethodBeat.i(144723);
    try
    {
      boolean bool = bWU.startScan();
      AppMethodBeat.o(144723);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144723);
    }
    return false;
  }
  
  public static boolean tN(int paramInt)
  {
    AppMethodBeat.i(144721);
    try
    {
      boolean bool = bWU.enableNetwork(paramInt, true);
      AppMethodBeat.o(144721);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(144721);
    }
    return false;
  }
  
  public static int tO(int paramInt)
  {
    if (paramInt <= -100) {
      return 0;
    }
    if (paramInt >= -55) {
      return 99;
    }
    return (int)((paramInt + 100) * 99.0F / 45.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c
 * JD-Core Version:    0.7.0.1
 */