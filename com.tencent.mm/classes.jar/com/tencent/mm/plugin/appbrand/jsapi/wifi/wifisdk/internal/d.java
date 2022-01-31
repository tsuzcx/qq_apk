package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.BitSet;

public final class d
{
  public static int ihY = -1;
  
  public static String Dh(String paramString)
  {
    AppMethodBeat.i(94413);
    if (paramString == null)
    {
      AppMethodBeat.o(94413);
      return "";
    }
    int i = paramString.length();
    if ((i > 1) && (paramString.charAt(0) == '"') && (paramString.charAt(i - 1) == '"'))
    {
      paramString = paramString.substring(1, i - 1);
      AppMethodBeat.o(94413);
      return paramString;
    }
    AppMethodBeat.o(94413);
    return paramString;
  }
  
  public static int a(ScanResult paramScanResult)
  {
    AppMethodBeat.i(94415);
    if ((paramScanResult == null) || (paramScanResult.capabilities == null))
    {
      AppMethodBeat.o(94415);
      return -1;
    }
    if (paramScanResult.capabilities.contains("WEP"))
    {
      AppMethodBeat.o(94415);
      return 1;
    }
    if (paramScanResult.capabilities.contains("PSK"))
    {
      AppMethodBeat.o(94415);
      return 2;
    }
    if (paramScanResult.capabilities.contains("EAP"))
    {
      AppMethodBeat.o(94415);
      return 3;
    }
    AppMethodBeat.o(94415);
    return 0;
  }
  
  public static int c(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(94414);
    if (paramWifiConfiguration.allowedKeyManagement.get(1))
    {
      AppMethodBeat.o(94414);
      return 2;
    }
    if ((paramWifiConfiguration.allowedKeyManagement.get(2)) || (paramWifiConfiguration.allowedKeyManagement.get(3)))
    {
      AppMethodBeat.o(94414);
      return 3;
    }
    if (paramWifiConfiguration.wepKeys[0] != null)
    {
      AppMethodBeat.o(94414);
      return 1;
    }
    AppMethodBeat.o(94414);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d
 * JD-Core Version:    0.7.0.1
 */