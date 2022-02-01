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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static boolean lAQ = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> lAR = null;
  private static c lAS = null;
  private static a lAT;
  private static BroadcastReceiver lAU = null;
  private static volatile b lAV = null;
  private static Context mContext;
  
  public static void G(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(144701);
    if (lAR != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)lAR.get();
      if ((locala != null) && (!locala.bqg())) {
        locala.Sd("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(lAT, mContext);
    ae.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.lAJ = paramString1;
    locala.lAK = paramString2;
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
      ae.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString2, paramString3 });
      if (paramString2 == null) {
        break label589;
      }
      str = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bM(paramString1, i)) {
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
        ae.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c(paramString2);
        str = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lBg)
        {
          ae.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
          locala.lBd = true;
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lBg) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c(str);
      }
      if (str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.lBg)
      {
        if (locala.a(str))
        {
          ae.i("MicroMsg.wifi_event", "CONNECTING");
          locala.tP(1);
          locala.lAZ = str;
          if (!locala.lAG)
          {
            paramString1 = new IntentFilter();
            paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            paramString1.addAction("android.net.wifi.STATE_CHANGE");
            paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramString1.setPriority(2147483647);
            locala.lAH = new WiFiConnector.2(locala);
            locala.lAW.registerReceiver(locala.lAH, paramString1);
            locala.lAG = true;
            ae.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
          }
          locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
          lAR = new WeakReference(locala);
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
        ae.i("MicroMsg.WiFiConnector", "connect, connectWifi fail");
      }
      for (;;)
      {
        locala.q(false, "fail to connect wifi:invalid network id");
        ae.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        break;
        ae.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
      }
    }
  }
  
  public static void a(a parama)
  {
    lAT = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(208362);
    ae.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    lAS = null;
    if ((lAQ) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      ae.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      lAV = paramb;
      AppMethodBeat.o(208362);
      return;
    }
    d locald = new d();
    if (lAQ) {}
    for (locald.iIJ = "wifi is disable";; locald.iIJ = "sdk not init")
    {
      paramb.a(locald);
      AppMethodBeat.o(208362);
      return;
    }
  }
  
  public static c bqa()
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Se(localWifiInfo.getSSID());
        str1 = bu.bI(localWifiInfo.getBSSID(), "");
      }
    }
    if ((lAS != null) && (((String)localObject).compareTo(lAS.lAJ) == 0) && (str1.compareTo(lAS.lAK) == 0))
    {
      localObject = lAS;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      ae.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      gU(true);
      localObject = lAS;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static d bqb()
  {
    AppMethodBeat.i(224572);
    d locald = gU(true);
    AppMethodBeat.o(224572);
    return locald;
  }
  
  public static void bqc()
  {
    AppMethodBeat.i(208361);
    ae.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    lAV = null;
    AppMethodBeat.o(208361);
  }
  
  public static void dG(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!lAQ) && (paramContext != null))
    {
      mContext = ak.getContext();
      ae.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (lAU == null) {
        lAU = new a((byte)0);
      }
      mContext.registerReceiver(lAU, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.bWU = paramContext;
        lAQ = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static d gU(boolean paramBoolean)
  {
    AppMethodBeat.i(208360);
    d locald = new d();
    lAS = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((lAQ) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      locald.lAP = new ArrayList();
      locald.iIJ = "ok";
      if (localObject2 != null)
      {
        ae.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        ae.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label425;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Se(((WifiInfo)localObject1).getSSID());
        localObject1 = bu.bI(((WifiInfo)localObject1).getBSSID(), "");
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
          localc.lAJ = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Se(localScanResult.SSID);
          localc.lAK = bu.bI(localScanResult.BSSID, "");
          localc.lAL = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.tT(localScanResult.level);
          if (j == 2)
          {
            paramBoolean = true;
            label255:
            localc.lAM = paramBoolean;
            localc.frequency = localScanResult.frequency;
            if ((str == null) || (localObject1 == null) || (localc.lAJ.compareTo(str) != 0) || (localc.lAK.compareTo((String)localObject1) != 0)) {
              break label346;
            }
          }
          label346:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              lAS = localc;
            }
            if ((j != 0) && (j != 2)) {
              break;
            }
            locald.lAP.add(localc);
            break;
            paramBoolean = false;
            break label255;
          }
        }
      }
      ae.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + lAS);
      for (;;)
      {
        AppMethodBeat.o(208360);
        return locald;
        ae.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (lAQ) {
          locald.iIJ = "wifi is disable";
        } else {
          locald.iIJ = "sdk not init";
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
      AppMethodBeat.i(208358);
      ae.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        ae.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(208358);
        return;
      }
      paramContext = e.bqd();
      if (paramContext == null)
      {
        ae.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(208358);
        return;
      }
      paramContext.a(e.bqe());
      AppMethodBeat.o(208358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e
 * JD-Core Version:    0.7.0.1
 */