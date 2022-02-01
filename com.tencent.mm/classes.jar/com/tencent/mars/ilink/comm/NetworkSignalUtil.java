package com.tencent.mars.ilink.comm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.Iterator;
import java.util.List;

public class NetworkSignalUtil
{
  private static final String INVALID_WIFI_BSSID = "02:00:00:00:00:00";
  private static final String INVALID_WIFI_SSID = "<unknown ssid>";
  private static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static Receiver connectivereceiver = null;
  private static Context context;
  private static MarsWifiInfo curwifiinfo = new MarsWifiInfo();
  private static boolean isinited;
  private static NetworkCallbackImpl24 netcallback;
  private static long strength = 10000L;
  
  static
  {
    context = null;
    isinited = false;
  }
  
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    if (isinited) {
      return;
    }
    context = paramContext;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext = new NetworkRequest.Builder();
      paramContext.addTransportType(0);
      paramContext.addTransportType(1);
      netcallback = new NetworkCallbackImpl24(null);
      ((ConnectivityManager)context.getSystemService("connectivity")).registerNetworkCallback(paramContext.build(), netcallback);
    }
    connectivereceiver = new Receiver(null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.net.wifi.SCAN_RESULTS");
    paramContext.addAction("android.net.wifi.RSSI_CHANGED");
    if (Build.VERSION.SDK_INT < 24) {
      paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    context.registerReceiver(connectivereceiver, paramContext);
    updateWiFiInfo();
    isinited = true;
  }
  
  public static String getBSSID()
  {
    return curwifiinfo.bssid;
  }
  
  public static long getGSMSignalStrength()
  {
    return strength;
  }
  
  public static long getNetworkSignalStrength(boolean paramBoolean)
  {
    return 0L;
  }
  
  public static String getSSID()
  {
    return curwifiinfo.ssid;
  }
  
  public static long getWifiSignalStrength()
  {
    return curwifiinfo.sig;
  }
  
  private static void updateWiFiInfo()
  {
    Log.d("MicroMsg.NetworkSignalUtil", "update wifiinfo!");
    Object localObject1 = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject1 == null)
    {
      curwifiinfo.reset();
      return;
    }
    if (((NetworkInfo)localObject1).getType() != 1)
    {
      curwifiinfo.reset();
      return;
    }
    localObject1 = (WifiManager)context.getSystemService("wifi");
    if (localObject1 == null)
    {
      curwifiinfo.reset();
      return;
    }
    if ((Build.VERSION.SDK_INT >= 29) && (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      Log.e("MicroMsg.NetworkSignalUtil", "access_fine_location perm not granted.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 27) {
      try
      {
        if ((context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
        {
          WifiInfo localWifiInfo2 = (WifiInfo)a.a(localObject1, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
          curwifiinfo.fill(localWifiInfo2.getRssi(), localWifiInfo2.getBSSID(), localWifiInfo2.getSSID(), localWifiInfo2.getNetworkId(), localWifiInfo2.getIpAddress());
          return;
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetworkSignalUtil", localThrowable2, "get wifi info failed directly", new Object[0]);
          try
          {
            Object localObject2 = (List)a.a(localObject1, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;");
            localObject1 = (WifiInfo)a.a(localObject1, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
            localObject2 = ((List)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (((WifiConfiguration)((Iterator)localObject2).next()).networkId != ((WifiInfo)localObject1).getNetworkId());
            curwifiinfo.fill(((WifiInfo)localObject1).getRssi(), ((WifiInfo)localObject1).getBSSID(), ((WifiInfo)localObject1).getSSID(), ((WifiInfo)localObject1).getNetworkId(), ((WifiInfo)localObject1).getIpAddress());
            return;
          }
          finally
          {
            Log.printErrStackTrace("MicroMsg.NetworkSignalUtil", localThrowable1, "get wifi info failed from configurations", new Object[0]);
            return;
          }
        }
      }
    }
    WifiInfo localWifiInfo1 = (WifiInfo)a.a(localThrowable1, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
    curwifiinfo.fill(localWifiInfo1.getRssi(), localWifiInfo1.getBSSID(), localWifiInfo1.getSSID(), localWifiInfo1.getNetworkId(), localWifiInfo1.getIpAddress());
  }
  
  static class MarsWifiInfo
  {
    public String bssid = "02:00:00:00:00:00";
    public int ipaddr = 0;
    public int networkId = 0;
    private int rssi = 0;
    public int sig = 0;
    public String ssid = "<unknown ssid>";
    
    void fill(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      int i = 10;
      this.rssi = paramInt1;
      this.bssid = paramString1;
      this.ssid = paramString2;
      this.networkId = paramInt2;
      this.ipaddr = paramInt3;
      paramInt1 = WifiManager.calculateSignalLevel(paramInt1, 10);
      if (paramInt1 > 10) {
        paramInt1 = i;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = 0;
        }
        this.sig = (paramInt2 * 10);
        return;
      }
    }
    
    void reset()
    {
      this.ssid = "<unknown ssid>";
      this.bssid = "02:00:00:00:00:00";
      this.rssi = 0;
      this.networkId = 0;
      this.ipaddr = 0;
      this.sig = 0;
    }
    
    void updateRssi(int paramInt)
    {
      int i = 10;
      this.rssi = paramInt;
      paramInt = WifiManager.calculateSignalLevel(paramInt, 10);
      if (paramInt > 10) {
        paramInt = i;
      }
      for (;;)
      {
        i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        this.sig = (i * 10);
        return;
      }
    }
  }
  
  static class NetworkCallbackImpl24
    extends ConnectivityManager.NetworkCallback
  {
    public void onAvailable(Network paramNetwork)
    {
      Log.i("MicroMsg.NetworkSignalUtil", "network available (from network callback)");
      NetworkSignalUtil.access$300();
    }
  }
  
  static class Receiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      int i = -1;
      switch (paramContext.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
          if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
          {
            i = 0;
            continue;
            if (paramContext.equals("android.net.wifi.RSSI_CHANGED"))
            {
              i = 1;
              continue;
              if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      Log.d("MicroMsg.NetworkSignalUtil", "WifiManager.SCAN_RESULTS_AVAILABLE_ACTION");
      return;
      Log.d("MicroMsg.NetworkSignalUtil", "WifiManager.RSSI_CHANGED_ACTION");
      i = paramIntent.getIntExtra("newRssi", 0);
      NetworkSignalUtil.curwifiinfo.updateRssi(i);
      return;
      Log.d("MicroMsg.NetworkSignalUtil", "ConnectivityManager.CONNECTIVITY_ACTION going to update wifiinfo");
      NetworkSignalUtil.access$300();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */