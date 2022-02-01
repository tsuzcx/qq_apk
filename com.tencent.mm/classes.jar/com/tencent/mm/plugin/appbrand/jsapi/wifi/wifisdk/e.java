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
  private static boolean kyc = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> kyd = null;
  private static c kye = null;
  private static a kyf;
  private static BroadcastReceiver kyg = null;
  private static volatile b kyh = null;
  private static Context mContext;
  
  public static void H(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(144701);
    if (kyd != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)kyd.get();
      if ((locala != null) && (!locala.beR())) {
        locala.JO("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(kyf, mContext);
    ad.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.kxV = paramString1;
    locala.kxW = paramString2;
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
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bC(paramString1, i)) {
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
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kys)
        {
          locala.kyp = true;
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kys) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(str);
      }
      if ((str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.kys) && (locala.a(str)))
      {
        ad.i("MicroMsg.wifi_event", "CONNECTING");
        locala.sq(1);
        locala.kyl = str;
        if (!locala.kxS)
        {
          paramString1 = new IntentFilter();
          paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
          paramString1.addAction("android.net.wifi.STATE_CHANGE");
          paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          paramString1.setPriority(2147483647);
          locala.kxT = new WiFiConnector.2(locala);
          locala.kyi.registerReceiver(locala.kxT, paramString1);
          locala.kxS = true;
          ad.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
        }
        locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
      }
      for (;;)
      {
        kyd = new WeakReference(locala);
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
        locala.m(false, "fail to connect wifi:invalid network id");
        ad.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      }
    }
  }
  
  public static void a(a parama)
  {
    kyf = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(193712);
    ad.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    kye = null;
    if ((kyc) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      ad.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      kyh = paramb;
      AppMethodBeat.o(193712);
      return;
    }
    d locald = new d();
    if (kyc) {}
    for (locald.hMd = "wifi is disable";; locald.hMd = "sdk not init")
    {
      paramb.a(locald);
      AppMethodBeat.o(193712);
      return;
    }
  }
  
  public static c beL()
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.JP(localWifiInfo.getSSID());
        str1 = bt.by(localWifiInfo.getBSSID(), "");
      }
    }
    if ((kye != null) && (((String)localObject).compareTo(kye.kxV) == 0) && (str1.compareTo(kye.kxW) == 0))
    {
      localObject = kye;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      ad.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      gr(true);
      localObject = kye;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static d beM()
  {
    AppMethodBeat.i(204025);
    d locald = gr(true);
    AppMethodBeat.o(204025);
    return locald;
  }
  
  public static void beN()
  {
    AppMethodBeat.i(193711);
    ad.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    kyh = null;
    AppMethodBeat.o(193711);
  }
  
  public static void dv(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!kyc) && (paramContext != null))
    {
      mContext = aj.getContext();
      ad.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (kyg == null) {
        kyg = new a((byte)0);
      }
      mContext.registerReceiver(kyg, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.bOZ = paramContext;
        kyc = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static d gr(boolean paramBoolean)
  {
    AppMethodBeat.i(193710);
    d locald = new d();
    kye = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((kyc) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      locald.kyb = new ArrayList();
      locald.hMd = "ok";
      if (localObject2 != null)
      {
        ad.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        ad.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label422;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.JP(((WifiInfo)localObject1).getSSID());
        localObject1 = bt.by(((WifiInfo)localObject1).getBSSID(), "");
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
            localc.kxV = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.JP(localScanResult.SSID);
            localc.kxW = bt.by(localScanResult.BSSID, "");
            localc.kxX = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.su(localScanResult.level);
            if (i == 2)
            {
              paramBoolean = true;
              label263:
              localc.kxY = paramBoolean;
              localc.frequency = localScanResult.frequency;
              if ((str == null) || (localObject1 == null) || (localc.kxV.compareTo(str) != 0) || (localc.kxW.compareTo((String)localObject1) != 0)) {
                break label343;
              }
            }
            label343:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                kye = localc;
              }
              locald.kyb.add(localc);
              break;
              paramBoolean = false;
              break label263;
            }
          }
        }
      }
      ad.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + kye);
      for (;;)
      {
        AppMethodBeat.o(193710);
        return locald;
        ad.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (kyc) {
          locald.hMd = "wifi is disable";
        } else {
          locald.hMd = "sdk not init";
        }
      }
      label422:
      localObject1 = null;
      str = null;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(193708);
      ad.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        ad.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(193708);
        return;
      }
      paramContext = e.beO();
      if (paramContext == null)
      {
        ad.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(193708);
        return;
      }
      paramContext.a(e.beP());
      AppMethodBeat.o(193708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e
 * JD-Core Version:    0.7.0.1
 */