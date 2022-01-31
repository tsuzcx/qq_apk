package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
{
  public static WifiManager bmz;
  
  public static int addNetwork(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(94404);
    int i;
    try
    {
      i = bmz.addNetwork(paramWifiConfiguration);
      AppMethodBeat.o(94404);
      return i;
    }
    catch (Throwable paramWifiConfiguration)
    {
      i = d.ihY;
      AppMethodBeat.o(94404);
    }
    return i;
  }
  
  public static boolean disableNetwork(int paramInt)
  {
    AppMethodBeat.i(94407);
    try
    {
      boolean bool = bmz.disableNetwork(paramInt);
      AppMethodBeat.o(94407);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94407);
    }
    return false;
  }
  
  public static List<WifiConfiguration> getConfiguredNetworks()
  {
    AppMethodBeat.i(94403);
    try
    {
      List localList = bmz.getConfiguredNetworks();
      AppMethodBeat.o(94403);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94403);
    }
    return null;
  }
  
  public static WifiInfo getConnectionInfo()
  {
    AppMethodBeat.i(94409);
    try
    {
      WifiInfo localWifiInfo = bmz.getConnectionInfo();
      AppMethodBeat.o(94409);
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94409);
    }
    return null;
  }
  
  public static List<ScanResult> getScanResults()
  {
    AppMethodBeat.i(94410);
    try
    {
      List localList = bmz.getScanResults();
      AppMethodBeat.o(94410);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94410);
    }
    return null;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(94412);
    try
    {
      boolean bool = bmz.isWifiEnabled();
      AppMethodBeat.o(94412);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94412);
    }
    return false;
  }
  
  public static boolean ot(int paramInt)
  {
    AppMethodBeat.i(94406);
    try
    {
      boolean bool = bmz.enableNetwork(paramInt, true);
      AppMethodBeat.o(94406);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94406);
    }
    return false;
  }
  
  public static int ou(int paramInt)
  {
    if (paramInt <= -100) {
      return 0;
    }
    if (paramInt >= -55) {
      return 99;
    }
    return (int)((paramInt + 100) * 99.0F / 45.0F);
  }
  
  public static boolean removeNetwork(int paramInt)
  {
    AppMethodBeat.i(94405);
    try
    {
      boolean bool = bmz.removeNetwork(paramInt);
      AppMethodBeat.o(94405);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94405);
    }
    return false;
  }
  
  public static boolean saveConfiguration()
  {
    AppMethodBeat.i(94411);
    try
    {
      boolean bool = bmz.saveConfiguration();
      AppMethodBeat.o(94411);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94411);
    }
    return false;
  }
  
  public static boolean startScan()
  {
    AppMethodBeat.i(94408);
    try
    {
      boolean bool = bmz.startScan();
      AppMethodBeat.o(94408);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(94408);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c
 * JD-Core Version:    0.7.0.1
 */