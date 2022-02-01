package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static boolean lws = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> lwt = null;
  private static c lwu = null;
  private static a lwv;
  private static BroadcastReceiver lww = null;
  private static volatile b lwx = null;
  private static Context mContext;
  
  public static void G(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(144701);
    if (lwt != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)lwt.get();
      if ((locala != null) && (!locala.bpw())) {
        locala.Ru("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(lwv, mContext);
    ad.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.lwl = paramString1;
    locala.lwm = paramString2;
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label420;
      }
      paramString2 = null;
      List localList = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConfiguredNetworks();
      paramString3 = str;
      if (localList != null) {
        paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.a(paramString1, i, localList);
      }
      ad.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString2, paramString3 });
      if (paramString2 == null) {
        break label589;
      }
      str = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bJ(paramString1, i)) {
          break label620;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.saveConfiguration();
      }
    }
    label420:
    label589:
    label620:
    for (int i = 1;; i = 0)
    {
      str = paramString2;
      if (i == 0)
      {
        ad.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c(paramString2);
        str = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lwI)
        {
          ad.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
          locala.lwF = true;
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lwI) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c(str);
      }
      if (str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lwI)
      {
        if (locala.a(str))
        {
          ad.i("MicroMsg.wifi_event", "CONNECTING");
          locala.tK(1);
          locala.lwB = str;
          if (!locala.lwi)
          {
            paramString1 = new IntentFilter();
            paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            paramString1.addAction("android.net.wifi.STATE_CHANGE");
            paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramString1.setPriority(2147483647);
            locala.lwj = new WiFiConnector.2(locala);
            locala.lwy.registerReceiver(locala.lwj, paramString1);
            locala.lwi = true;
            ad.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
          }
          locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
          lwt = new WeakReference(locala);
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
        }
        ad.i("MicroMsg.WiFiConnector", "connect, connectWifi fail");
      }
      for (;;)
      {
        locala.q(false, "fail to connect wifi:invalid network id");
        ad.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        break;
        ad.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
      }
    }
  }
  
  public static void a(a parama)
  {
    lwv = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(195113);
    ad.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    lwu = null;
    if ((lws) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      ad.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      lwx = paramb;
      AppMethodBeat.o(195113);
      return;
    }
    d locald = new d();
    if (lws) {}
    for (locald.iFQ = "wifi is disable";; locald.iFQ = "sdk not init")
    {
      paramb.a(locald);
      AppMethodBeat.o(195113);
      return;
    }
  }
  
  public static c bpq()
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Rv(localWifiInfo.getSSID());
        str1 = bt.bI(localWifiInfo.getBSSID(), "");
      }
    }
    if ((lwu != null) && (((String)localObject).compareTo(lwu.lwl) == 0) && (str1.compareTo(lwu.lwm) == 0))
    {
      localObject = lwu;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      ad.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      gU(true);
      localObject = lwu;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static d bpr()
  {
    AppMethodBeat.i(221706);
    d locald = gU(true);
    AppMethodBeat.o(221706);
    return locald;
  }
  
  public static void bps()
  {
    AppMethodBeat.i(195112);
    ad.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    lwx = null;
    AppMethodBeat.o(195112);
  }
  
  public static void dC(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!lws) && (paramContext != null))
    {
      mContext = aj.getContext();
      ad.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (lww == null) {
        lww = new a((byte)0);
      }
      mContext.registerReceiver(lww, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.bWU = paramContext;
        lws = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static d gU(boolean paramBoolean)
  {
    AppMethodBeat.i(195111);
    d locald = new d();
    lwu = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((lws) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      locald.lwr = new ArrayList();
      locald.iFQ = "ok";
      if (localObject2 != null)
      {
        ad.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        ad.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label425;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Rv(((WifiInfo)localObject1).getSSID());
        localObject1 = bt.bI(((WifiInfo)localObject1).getBSSID(), "");
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
          c localc = new c();
          localc.lwl = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Rv(localScanResult.SSID);
          localc.lwm = bt.bI(localScanResult.BSSID, "");
          localc.lwn = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.tO(localScanResult.level);
          if (j == 2)
          {
            paramBoolean = true;
            label255:
            localc.lwo = paramBoolean;
            localc.frequency = localScanResult.frequency;
            if ((str == null) || (localObject1 == null) || (localc.lwl.compareTo(str) != 0) || (localc.lwm.compareTo((String)localObject1) != 0)) {
              break label346;
            }
          }
          label346:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              lwu = localc;
            }
            if ((j != 0) && (j != 2)) {
              break;
            }
            locald.lwr.add(localc);
            break;
            paramBoolean = false;
            break label255;
          }
        }
      }
      ad.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + lwu);
      for (;;)
      {
        AppMethodBeat.o(195111);
        return locald;
        ad.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (lws) {
          locald.iFQ = "wifi is disable";
        } else {
          locald.iFQ = "sdk not init";
        }
      }
      label425:
      localObject1 = null;
      str = null;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(195109);
      ad.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        ad.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(195109);
        return;
      }
      paramContext = e.bpt();
      if (paramContext == null)
      {
        ad.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(195109);
        return;
      }
      paramContext.a(e.bpu());
      AppMethodBeat.o(195109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e
 * JD-Core Version:    0.7.0.1
 */