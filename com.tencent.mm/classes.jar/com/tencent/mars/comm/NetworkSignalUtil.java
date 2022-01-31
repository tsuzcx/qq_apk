package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.ab;

public class NetworkSignalUtil
{
  public static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static Context context = null;
  private static long strength = 10000L;
  
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    context = paramContext;
    ((TelephonyManager)paramContext.getSystemService("phone")).listen(new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        NetworkSignalUtil.calSignalStrength(paramAnonymousSignalStrength);
      }
    }, 256);
  }
  
  private static void calSignalStrength(SignalStrength paramSignalStrength)
  {
    int i;
    long l;
    if (paramSignalStrength.isGsm())
    {
      i = paramSignalStrength.getGsmSignalStrength();
      if ((!paramSignalStrength.isGsm()) || (i != 99)) {
        break label47;
      }
      l = -1L;
    }
    for (;;)
    {
      strength = l;
      return;
      i = (paramSignalStrength.getCdmaDbm() + 113) / 2;
      break;
      label47:
      l = (i * 3.225807F);
      strength = l;
      if (l > 100L) {}
      for (l = 100L;; l = strength)
      {
        strength = l;
        if (l >= 0L) {
          break label92;
        }
        l = 0L;
        break;
      }
      label92:
      l = strength;
    }
  }
  
  public static long getGSMSignalStrength()
  {
    return strength;
  }
  
  public static long getNetworkSignalStrength(boolean paramBoolean)
  {
    return 0L;
  }
  
  public static long getWifiSignalStrength()
  {
    WifiInfo localWifiInfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
    if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
    {
      int j = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 10);
      ab.v("MicroMsg.NetworkSignalUtil", "Wifi Signal:" + j * 10);
      int i = j;
      if (j > 10) {
        i = 10;
      }
      j = i;
      if (i < 0) {
        j = 0;
      }
      return j * 10;
    }
    ab.v("MicroMsg.NetworkSignalUtil", "Can Not Get Wifi Signal");
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */