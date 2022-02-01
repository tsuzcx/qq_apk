package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class NetworkSignalUtil
{
  public static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static Context context = null;
  private static long strength = 10000L;
  
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    context = paramContext;
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      private byte _hellAccFlag_;
      
      public final void run()
      {
        Log.i("MicroMsg.NetworkSignalUtil", "[InitNetworkSignalUtil] run.. %s", new Object[] { Looper.myLooper() });
        TelephonyManager localTelephonyManager = (TelephonyManager)NetworkSignalUtil.context.getSystemService("phone");
        Object localObject = new PhoneStateListener()
        {
          public void onSignalStrengthsChanged(SignalStrength paramAnonymous2SignalStrength)
          {
            super.onSignalStrengthsChanged(paramAnonymous2SignalStrength);
            NetworkSignalUtil.calSignalStrength(paramAnonymous2SignalStrength);
          }
        };
        localObject = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mars/comm/NetworkSignalUtil$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mars/comm/NetworkSignalUtil$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      }
    });
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
      Log.v("MicroMsg.NetworkSignalUtil", "Wifi Signal:" + j * 10);
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
    Log.v("MicroMsg.NetworkSignalUtil", "Can Not Get Wifi Signal");
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */