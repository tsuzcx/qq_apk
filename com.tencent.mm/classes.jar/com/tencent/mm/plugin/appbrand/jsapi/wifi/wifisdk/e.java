package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static Context mContext;
  private static boolean mIf = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> mIg = null;
  private static c mIh = null;
  private static a mIi;
  private static BroadcastReceiver mIj = null;
  private static volatile b mIk = null;
  
  public static void I(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(144701);
    Object localObject;
    if (mIg != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)mIg.get();
      if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)localObject).bLM())) {
        ((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)localObject).abI("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(mIi, mContext);
    Log.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.mHX = paramString1;
    locala.mHY = paramString2;
    if ((locala.mIl.getApplicationInfo().targetSdkVersion >= 29) && (Build.VERSION.SDK_INT >= 29))
    {
      Log.i("MicroMsg.WiFiConnector", "connect, use WifiConnector29Impl");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.mIv;
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.a(locala.mIl, paramString1, paramString2, paramString3, new a.2(locala));
      mIg = new WeakReference(locala);
      AppMethodBeat.o(144701);
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      label182:
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label470;
      }
      paramString2 = null;
      paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getConfiguredNetworks();
      if (paramString3 == null) {
        break label634;
      }
      paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.a(paramString1, i, paramString3);
      label210:
      Log.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString2, paramString3 });
      if (paramString2 == null) {
        break label647;
      }
      localObject = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bR(paramString1, i)) {
          break label678;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.saveConfiguration();
      }
    }
    label647:
    label678:
    for (int i = 1;; i = 0)
    {
      localObject = paramString2;
      if (i == 0)
      {
        Log.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c(paramString2);
        localObject = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE)
        {
          Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
          locala.mIs = true;
          localObject = paramString3;
        }
      }
      if (((WifiConfiguration)localObject).networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE) {
        ((WifiConfiguration)localObject).networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.c((WifiConfiguration)localObject);
      }
      if (((WifiConfiguration)localObject).networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE)
      {
        if (locala.a((WifiConfiguration)localObject))
        {
          Log.i("MicroMsg.wifi_event", "CONNECTING");
          locala.xN(1);
          locala.mIo = ((WifiConfiguration)localObject);
          if (!locala.mHU)
          {
            paramString1 = new IntentFilter();
            paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            paramString1.addAction("android.net.wifi.STATE_CHANGE");
            paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramString1.setPriority(2147483647);
            locala.mHV = new WiFiConnector.2(locala);
            locala.mIl.registerReceiver(locala.mHV, paramString1);
            locala.mHU = true;
            Log.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
          }
          locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
          break;
          i = 2;
          break label182;
          label470:
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
          label634:
          paramString3 = null;
          break label210;
        }
        Log.i("MicroMsg.WiFiConnector", "connect, connectWifi fail");
      }
      for (;;)
      {
        locala.q(false, "fail to connect wifi:invalid network id");
        Log.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        break;
        Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
      }
    }
  }
  
  public static void a(a parama)
  {
    mIi = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(215171);
    Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    mIh = null;
    if ((mIf) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled()))
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.startScan();
      mIk = paramb;
      AppMethodBeat.o(215171);
      return;
    }
    d locald = new d();
    if (mIf) {}
    for (locald.jFn = "wifi is disable";; locald.jFn = "sdk not init")
    {
      paramb.a(locald);
      AppMethodBeat.o(215171);
      return;
    }
  }
  
  public static c bLG()
  {
    AppMethodBeat.i(144699);
    WifiInfo localWifiInfo = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getConnectionInfo();
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(localWifiInfo.getSSID());
        str1 = Util.nullAs(localWifiInfo.getBSSID(), "");
      }
    }
    if ((mIh != null) && (((String)localObject).compareTo(mIh.mHX) == 0) && (str1.compareTo(mIh.mHY) == 0))
    {
      localObject = mIh;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      hT(true);
      localObject = mIh;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static d bLH()
  {
    AppMethodBeat.i(258609);
    d locald = hT(true);
    AppMethodBeat.o(258609);
    return locald;
  }
  
  public static void bLI()
  {
    AppMethodBeat.i(215170);
    Log.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    mIk = null;
    AppMethodBeat.o(215170);
  }
  
  public static void eb(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!mIf) && (paramContext != null))
    {
      mContext = MMApplicationContext.getContext();
      Log.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (mIj == null) {
        mIj = new a((byte)0);
      }
      mContext.registerReceiver(mIj, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.chC = paramContext;
        mIf = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static d hT(boolean paramBoolean)
  {
    AppMethodBeat.i(215169);
    d locald = new d();
    mIh = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((mIf) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.startScan();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getScanResults();
      locald.mIe = new ArrayList();
      locald.jFn = "ok";
      if (localObject2 != null)
      {
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getConnectionInfo();
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label425;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(((WifiInfo)localObject1).getSSID());
        localObject1 = Util.nullAs(((WifiInfo)localObject1).getBSSID(), "");
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
          int j = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.a(localScanResult);
          c localc = new c();
          localc.mHX = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(localScanResult.SSID);
          localc.mHY = Util.nullAs(localScanResult.BSSID, "");
          localc.mHZ = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.xR(localScanResult.level);
          if (j == 2)
          {
            paramBoolean = true;
            label255:
            localc.mIa = paramBoolean;
            localc.frequency = localScanResult.frequency;
            if ((str == null) || (localObject1 == null) || (localc.mHX.compareTo(str) != 0) || (localc.mHY.compareTo((String)localObject1) != 0)) {
              break label346;
            }
          }
          label346:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              mIh = localc;
            }
            if ((j != 0) && (j != 2)) {
              break;
            }
            locald.mIe.add(localc);
            break;
            paramBoolean = false;
            break label255;
          }
        }
      }
      Log.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + mIh);
      for (;;)
      {
        AppMethodBeat.o(215169);
        return locald;
        Log.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (mIf) {
          locald.jFn = "wifi is disable";
        } else {
          locald.jFn = "sdk not init";
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
      AppMethodBeat.i(215167);
      Log.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        Log.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(215167);
        return;
      }
      paramContext = e.bLJ();
      if (paramContext == null)
      {
        Log.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(215167);
        return;
      }
      paramContext.a(e.bLK());
      AppMethodBeat.o(215167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e
 * JD-Core Version:    0.7.0.1
 */