package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.MixedSignalStrength;
import com.tencent.mm.sdk.platformtools.Log;

public class NetworkSignalUtil
{
  public static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static final int WIFI_STRENGTH_MAX_LEVEL = 10;
  
  @Deprecated
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    ConnectivityCompat.Companion.initSignalStrengthListener();
  }
  
  private static long calWifiStrengthInNum(int paramInt)
  {
    paramInt = WifiManager.calculateSignalLevel(paramInt, 10);
    Log.v("MicroMsg.NetworkSignalUtil", "Wifi Signal:".concat(String.valueOf(paramInt)));
    return Math.max(Math.min(paramInt, 10), 0) * 10;
  }
  
  public static long getGSMSignalStrength()
  {
    ConnectivityCompat.MixedSignalStrength localMixedSignalStrength = ConnectivityCompat.Companion.getSignalStrength();
    int i;
    long l2;
    if (localMixedSignalStrength.isGsm())
    {
      i = localMixedSignalStrength.getGsmSignalStrength();
      if ((!localMixedSignalStrength.isGsm()) || (i != 99)) {
        break label56;
      }
      l2 = -1L;
    }
    label56:
    long l1;
    do
    {
      return l2;
      i = (localMixedSignalStrength.getCdmaDbm() + 113) / 2;
      break;
      l2 = (i * 3.225807F);
      l1 = l2;
      if (l2 > 100L) {
        l1 = 100L;
      }
      l2 = l1;
    } while (l1 >= 0L);
    return 0L;
  }
  
  public static long getWifiSignalStrength()
  {
    long l = calWifiStrengthInNum(ConnectivityCompat.Companion.getWiFiRssi());
    Log.d("MicroMsg.NetworkSignalUtil", "getWifiSignalStrength ".concat(String.valueOf(l)));
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */