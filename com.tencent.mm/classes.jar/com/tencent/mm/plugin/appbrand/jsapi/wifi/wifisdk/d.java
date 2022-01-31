package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static boolean gHc = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> gHd = null;
  private static b gHe = null;
  private static a gHf;
  private static Context mContext;
  
  public static void C(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    if (gHd != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)gHd.get();
      if ((locala != null) && (!locala.alq())) {
        locala.uN("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(gHf, mContext);
    y.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2 + " psw:" + paramString3);
    locala.gGV = paramString1;
    locala.gGW = paramString2;
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label380;
      }
      paramString2 = null;
      List localList = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConfiguredNetworks();
      paramString3 = str;
      if (localList != null) {
        paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.a(paramString1, i, localList);
      }
      if (paramString2 == null) {
        break label540;
      }
      str = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.aT(paramString1, i)) {
          break label559;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.saveConfiguration();
      }
    }
    label540:
    label559:
    for (int i = 1;; i = 0)
    {
      str = paramString2;
      if (i == 0)
      {
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(paramString2);
        str = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gHp) {
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gHp) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(str);
      }
      if ((str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gHp) && (locala.a(str)))
      {
        y.i("MicroMsg.wifi_event", "CONNECTING");
        locala.lI(1);
        locala.gHj = str;
        if (!locala.gGR)
        {
          paramString1 = new IntentFilter();
          paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
          paramString1.addAction("android.net.wifi.STATE_CHANGE");
          paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          paramString1.setPriority(2147483647);
          locala.gGS = new WiFiConnector.2(locala);
          locala.gHg.registerReceiver(locala.gGS, paramString1);
          locala.gGR = true;
          y.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
        }
        locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
      }
      for (;;)
      {
        gHd = new WeakReference(locala);
        return;
        i = 2;
        break;
        label380:
        paramString2 = new WifiConfiguration();
        paramString2.allowedAuthAlgorithms.clear();
        paramString2.allowedGroupCiphers.clear();
        paramString2.allowedKeyManagement.clear();
        paramString2.allowedPairwiseCiphers.clear();
        paramString2.allowedProtocols.clear();
        paramString2.SSID = ("\"" + paramString1 + "\"");
        paramString2.hiddenSSID = true;
        switch (i)
        {
        default: 
          paramString2.allowedKeyManagement.set(0);
        }
        for (;;)
        {
          paramString2.status = 2;
          break;
          if (paramString3.length() != 0) {
            if (paramString3.matches("[0-9A-Fa-f]{64}")) {
              paramString2.preSharedKey = paramString3;
            } else {
              paramString2.preSharedKey = ("\"" + paramString3 + '"');
            }
          }
        }
        locala.g(false, "fail to connect wifi:invalid network id");
        y.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      }
    }
  }
  
  public static void a(a parama)
  {
    gHf = parama;
  }
  
  public static b alo()
  {
    WifiInfo localWifiInfo = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (localWifiInfo != null)
    {
      str2 = str4;
      str1 = str3;
      if (!TextUtils.isEmpty(localWifiInfo.getSSID()))
      {
        str1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uO(localWifiInfo.getSSID());
        str2 = bk.aM(localWifiInfo.getBSSID(), "");
      }
    }
    if ((gHe != null) && (gHe.gGV.compareTo(str1) == 0) && (gHe.gGW.compareTo(str2) == 0)) {
      return gHe;
    }
    if (localWifiInfo != null)
    {
      alp();
      return gHe;
    }
    return null;
  }
  
  public static c alp()
  {
    c localc = new c();
    gHe = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((gHc) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      localc.gHb = new ArrayList();
      localc.gio = "ok";
      if (localObject2 != null)
      {
        y.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        y.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label408;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uO(((WifiInfo)localObject1).getSSID());
        localObject1 = bk.aM(((WifiInfo)localObject1).getBSSID(), "");
      }
    }
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ScanResult localScanResult = (ScanResult)((Iterator)localObject2).next();
        if (localScanResult != null)
        {
          int j = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(localScanResult);
          if ((j == 0) || (j == 2))
          {
            b localb = new b();
            localb.gGV = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uO(localScanResult.SSID);
            localb.gGW = bk.aM(localScanResult.BSSID, "");
            int i = localScanResult.level;
            label248:
            boolean bool;
            if (i <= -100)
            {
              i = 0;
              localb.gGX = i;
              if (j != 2) {
                break label358;
              }
              bool = true;
              label261:
              localb.gGY = bool;
              if ((str == null) || (localObject1 == null) || (localb.gGV.compareTo(str) != 0) || (localb.gGW.compareTo((String)localObject1) != 0)) {
                break label363;
              }
            }
            label358:
            label363:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                gHe = localb;
              }
              localc.gHb.add(localb);
              break;
              if (i >= -55)
              {
                i = 99;
                break label248;
              }
              i = (int)((i + 100) * 99.0F / 45.0F);
              break label248;
              bool = false;
              break label261;
            }
            y.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
          }
        }
      }
      return localc;
      if (gHc)
      {
        localc.gio = "wifi is disable";
        return localc;
      }
      localc.gio = "sdk not init";
      return localc;
      label408:
      localObject1 = null;
      str = null;
    }
  }
  
  public static void cp(Context paramContext)
  {
    if ((!gHc) && (paramContext != null))
    {
      mContext = paramContext;
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.aVR = paramContext;
        gHc = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d
 * JD-Core Version:    0.7.0.1
 */