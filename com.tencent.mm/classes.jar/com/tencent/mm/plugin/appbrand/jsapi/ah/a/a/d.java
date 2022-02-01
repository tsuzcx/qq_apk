package com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class d
{
  public static WifiManager pJv;
  
  public static boolean Bo(int paramInt)
  {
    AppMethodBeat.i(144720);
    try
    {
      boolean bool = pJv.removeNetwork(paramInt);
      AppMethodBeat.o(144720);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "removeNetwork", new Object[0]);
      AppMethodBeat.o(144720);
    }
    return false;
  }
  
  public static boolean Bp(int paramInt)
  {
    AppMethodBeat.i(144721);
    try
    {
      boolean bool = pJv.enableNetwork(paramInt, true);
      AppMethodBeat.o(144721);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "enableNetwork", new Object[0]);
      AppMethodBeat.o(144721);
    }
    return false;
  }
  
  public static boolean Bq(int paramInt)
  {
    AppMethodBeat.i(144722);
    try
    {
      boolean bool = pJv.disableNetwork(paramInt);
      AppMethodBeat.o(144722);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "disableNetwork", new Object[0]);
      AppMethodBeat.o(144722);
    }
    return false;
  }
  
  public static int Br(int paramInt)
  {
    if (paramInt <= -100) {
      return 0;
    }
    if (paramInt >= -55) {
      return 99;
    }
    return (int)((paramInt + 100) * 99.0F / 45.0F);
  }
  
  public static List<WifiConfiguration> bYa()
  {
    AppMethodBeat.i(144718);
    try
    {
      List localList = pJv.getConfiguredNetworks();
      AppMethodBeat.o(144718);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "getConfiguredNetworks", new Object[0]);
      AppMethodBeat.o(144718);
    }
    return null;
  }
  
  public static boolean bYb()
  {
    AppMethodBeat.i(144723);
    try
    {
      boolean bool = ((Boolean)a.a(pJv, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "startScan", "()Z", "android/net/wifi/WifiManager", "startScan", "()Z")).booleanValue();
      AppMethodBeat.o(144723);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "startScan", new Object[0]);
      AppMethodBeat.o(144723);
    }
    return false;
  }
  
  public static WifiInfo bYc()
  {
    AppMethodBeat.i(144724);
    try
    {
      WifiInfo localWifiInfo = (WifiInfo)a.a(pJv, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      AppMethodBeat.o(144724);
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "getConnectionInfo", new Object[0]);
      AppMethodBeat.o(144724);
    }
    return null;
  }
  
  public static List<ScanResult> bYd()
  {
    AppMethodBeat.i(144725);
    try
    {
      List localList = (List)a.a(pJv, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "getScanResults", "()Ljava/util/List;", "android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;");
      AppMethodBeat.o(144725);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "getScanResults", new Object[0]);
      AppMethodBeat.o(144725);
    }
    return null;
  }
  
  public static boolean bYe()
  {
    AppMethodBeat.i(144726);
    try
    {
      boolean bool = pJv.saveConfiguration();
      AppMethodBeat.o(144726);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "saveConfiguration", new Object[0]);
      AppMethodBeat.o(144726);
    }
    return false;
  }
  
  public static boolean bYf()
  {
    AppMethodBeat.i(144727);
    try
    {
      boolean bool = pJv.isWifiEnabled();
      AppMethodBeat.o(144727);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", localThrowable, "isWifiEnabled", new Object[0]);
      AppMethodBeat.o(144727);
    }
    return false;
  }
  
  public static int d(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144719);
    int i;
    try
    {
      i = pJv.addNetwork(paramWifiConfiguration);
      AppMethodBeat.o(144719);
      return i;
    }
    catch (Throwable paramWifiConfiguration)
    {
      Log.printErrStackTrace("MicroMsg.WifiManagerInternalWrapper", paramWifiConfiguration, "addNetwork", new Object[0]);
      i = e.pJw;
      AppMethodBeat.o(144719);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d
 * JD-Core Version:    0.7.0.1
 */