package com.tencent.mm.plugin.appbrand.jsapi.ak.a.a;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.BitSet;

public final class e
{
  public static int sOo = -1;
  
  public static int a(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144730);
    if ((paramScanResult == null) || (paramScanResult.capabilities == null))
    {
      AppMethodBeat.o(144730);
      return -1;
    }
    if (paramScanResult.capabilities.contains("WEP"))
    {
      AppMethodBeat.o(144730);
      return 1;
    }
    if (paramScanResult.capabilities.contains("PSK"))
    {
      AppMethodBeat.o(144730);
      return 2;
    }
    if (paramScanResult.capabilities.contains("EAP"))
    {
      AppMethodBeat.o(144730);
      return 3;
    }
    AppMethodBeat.o(144730);
    return 0;
  }
  
  public static String acF(String paramString)
  {
    AppMethodBeat.i(144728);
    if (paramString == null)
    {
      AppMethodBeat.o(144728);
      return "";
    }
    int i = paramString.length();
    if ((i > 1) && (paramString.charAt(0) == '"') && (paramString.charAt(i - 1) == '"'))
    {
      paramString = paramString.substring(1, i - 1);
      AppMethodBeat.o(144728);
      return paramString;
    }
    AppMethodBeat.o(144728);
    return paramString;
  }
  
  public static int e(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144729);
    if (paramWifiConfiguration.allowedKeyManagement.get(1))
    {
      AppMethodBeat.o(144729);
      return 2;
    }
    if ((paramWifiConfiguration.allowedKeyManagement.get(2)) || (paramWifiConfiguration.allowedKeyManagement.get(3)))
    {
      AppMethodBeat.o(144729);
      return 3;
    }
    if (paramWifiConfiguration.wepKeys[0] != null)
    {
      AppMethodBeat.o(144729);
      return 1;
    }
    AppMethodBeat.o(144729);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e
 * JD-Core Version:    0.7.0.1
 */