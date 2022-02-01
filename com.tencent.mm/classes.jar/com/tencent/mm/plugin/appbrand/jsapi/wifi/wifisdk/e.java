package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static boolean kZq = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> kZr = null;
  private static c kZs = null;
  private static a kZt;
  private static BroadcastReceiver kZu = null;
  private static volatile b kZv = null;
  private static Context mContext;
  
  public static void H(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(144701);
    if (kZr != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)kZr.get();
      if ((locala != null) && (!locala.blL())) {
        locala.NV("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(kZt, mContext);
    ac.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.kZj = paramString1;
    locala.kZk = paramString2;
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label387;
      }
      paramString2 = null;
      List localList = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConfiguredNetworks();
      paramString3 = str;
      if (localList != null) {
        paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.a(paramString1, i, localList);
      }
      if (paramString2 == null) {
        break label549;
      }
      str = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bG(paramString1, i)) {
          break label569;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.saveConfiguration();
      }
    }
    label387:
    label549:
    label569:
    for (int i = 1;; i = 0)
    {
      str = paramString2;
      if (i == 0)
      {
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(paramString2);
        str = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kZG)
        {
          locala.kZD = true;
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kZG) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(str);
      }
      if ((str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kZG) && (locala.a(str)))
      {
        ac.i("MicroMsg.wifi_event", "CONNECTING");
        locala.tg(1);
        locala.kZz = str;
        if (!locala.kZg)
        {
          paramString1 = new IntentFilter();
          paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
          paramString1.addAction("android.net.wifi.STATE_CHANGE");
          paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          paramString1.setPriority(2147483647);
          locala.kZh = new WiFiConnector.2(locala);
          locala.kZw.registerReceiver(locala.kZh, paramString1);
          locala.kZg = true;
          ac.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
        }
        locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
      }
      for (;;)
      {
        kZr = new WeakReference(locala);
        AppMethodBeat.o(144701);
        return;
        i = 2;
        break;
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
        locala.n(false, "fail to connect wifi:invalid network id");
        ac.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      }
    }
  }
  
  public static void a(a parama)
  {
    kZt = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(204985);
    ac.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    kZs = null;
    if ((kZq) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      ac.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      kZv = paramb;
      AppMethodBeat.o(204985);
      return;
    }
    d locald = new d();
    if (kZq) {}
    for (locald.imz = "wifi is disable";; locald.imz = "sdk not init")
    {
      paramb.a(locald);
      AppMethodBeat.o(204985);
      return;
    }
  }
  
  public static c blF()
  {
    AppMethodBeat.i(144699);
    WifiInfo localWifiInfo = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
    String str2 = "";
    String str3 = "";
    String str1 = str3;
    Object localObject = str2;
    if (localWifiInfo != null)
    {
      str1 = str3;
      localObject = str2;
      if (!TextUtils.isEmpty(localWifiInfo.getSSID()))
      {
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.NW(localWifiInfo.getSSID());
        str1 = bs.bG(localWifiInfo.getBSSID(), "");
      }
    }
    if ((kZs != null) && (((String)localObject).compareTo(kZs.kZj) == 0) && (str1.compareTo(kZs.kZk) == 0))
    {
      localObject = kZs;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      ac.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      gN(true);
      localObject = kZs;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static d blG()
  {
    AppMethodBeat.i(210382);
    d locald = gN(true);
    AppMethodBeat.o(210382);
    return locald;
  }
  
  public static void blH()
  {
    AppMethodBeat.i(204984);
    ac.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    kZv = null;
    AppMethodBeat.o(204984);
  }
  
  public static void dE(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!kZq) && (paramContext != null))
    {
      mContext = ai.getContext();
      ac.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (kZu == null) {
        kZu = new e.a((byte)0);
      }
      mContext.registerReceiver(kZu, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.bMH = paramContext;
        kZq = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static d gN(boolean paramBoolean)
  {
    AppMethodBeat.i(204983);
    d locald = new d();
    kZs = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((kZq) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      locald.kZp = new ArrayList();
      locald.imz = "ok";
      if (localObject2 != null)
      {
        ac.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        ac.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label422;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.NW(((WifiInfo)localObject1).getSSID());
        localObject1 = bs.bG(((WifiInfo)localObject1).getBSSID(), "");
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
          int i = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(localScanResult);
          if ((i == 0) || (i == 2))
          {
            c localc = new c();
            localc.kZj = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.NW(localScanResult.SSID);
            localc.kZk = bs.bG(localScanResult.BSSID, "");
            localc.kZl = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.tk(localScanResult.level);
            if (i == 2)
            {
              paramBoolean = true;
              label263:
              localc.kZm = paramBoolean;
              localc.frequency = localScanResult.frequency;
              if ((str == null) || (localObject1 == null) || (localc.kZj.compareTo(str) != 0) || (localc.kZk.compareTo((String)localObject1) != 0)) {
                break label343;
              }
            }
            label343:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                kZs = localc;
              }
              locald.kZp.add(localc);
              break;
              paramBoolean = false;
              break label263;
            }
          }
        }
      }
      ac.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + kZs);
      for (;;)
      {
        AppMethodBeat.o(204983);
        return locald;
        ac.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (kZq) {
          locald.imz = "wifi is disable";
        } else {
          locald.imz = "sdk not init";
        }
      }
      label422:
      localObject1 = null;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e
 * JD-Core Version:    0.7.0.1
 */