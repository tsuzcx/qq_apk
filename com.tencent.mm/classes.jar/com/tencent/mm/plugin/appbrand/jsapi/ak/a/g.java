package com.tencent.mm.plugin.appbrand.jsapi.ak.a;

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
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.a.2;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.a.3;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static Context mContext;
  private static boolean sNN = false;
  private static WeakReference<a> sNO = null;
  private static e sNP = null;
  private static c sNQ;
  private static BroadcastReceiver sNR = null;
  private static volatile d sNS = null;
  
  public static void a(c paramc)
  {
    sNQ = paramc;
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(325799);
    Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    sNP = null;
    if ((sNN) && (com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyv()))
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyr();
      sNS = paramd;
      AppMethodBeat.o(325799);
      return;
    }
    f localf = new f();
    if (sNN) {}
    for (localf.ppp = "wifi is disable";; localf.ppp = "sdk not init")
    {
      paramd.a(localf);
      AppMethodBeat.o(325799);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(325802);
    Object localObject;
    if (sNO != null)
    {
      localObject = (a)sNO.get();
      if ((localObject != null) && (!((a)localObject).cyn())) {
        ((a)localObject).acE("duplicated request");
      }
    }
    a locala = new a(sNQ, mContext, paramBoolean);
    Log.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.sNF = paramString1;
    locala.sNG = paramString2;
    if (-1L != paramLong) {
      locala.sOa = paramLong;
    }
    if (locala.sOc)
    {
      Log.i("MicroMsg.WiFiConnector", "connect, use WifiConnector29Impl");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.c.sOf;
      com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.c.a(locala.sNT, paramString1, paramString2, paramString3, paramLong, new a.3(locala));
      sNO = new WeakReference(locala);
      AppMethodBeat.o(325802);
      return;
    }
    int i;
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      label184:
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label483;
      }
      paramString2 = null;
      paramString3 = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyq();
      if (paramString3 == null) {
        break label650;
      }
    }
    label650:
    for (paramString3 = b.a(paramString1, i, paramString3);; paramString3 = null)
    {
      Log.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString2, paramString3 });
      if (paramString2 == null) {
        break label663;
      }
      localObject = paramString2;
      if (paramString3 != null)
      {
        int j = 0;
        if (b.cO(paramString1, i))
        {
          j = 1;
          com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyu();
        }
        localObject = paramString2;
        if (j == 0)
        {
          Log.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
          paramString2.networkId = b.c(paramString2);
          localObject = paramString2;
          if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.sOo)
          {
            Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
            locala.sOb = true;
            localObject = paramString3;
          }
        }
      }
      if (((WifiConfiguration)localObject).networkId == com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.sOo) {
        ((WifiConfiguration)localObject).networkId = b.c((WifiConfiguration)localObject);
      }
      if (((WifiConfiguration)localObject).networkId == com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.sOo) {
        break label683;
      }
      if (!locala.a((WifiConfiguration)localObject)) {
        break label655;
      }
      Log.i("MicroMsg.wifi_event", "CONNECTING");
      locala.By(1);
      locala.sNW = ((WifiConfiguration)localObject);
      if (!locala.sNz)
      {
        paramString1 = new IntentFilter();
        paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        paramString1.addAction("android.net.wifi.STATE_CHANGE");
        paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        paramString1.setPriority(2147483647);
        locala.sNX = new a.2(locala);
        locala.sNT.registerReceiver(locala.sNX, paramString1);
        locala.sNz = true;
        Log.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
      }
      locala.mHandler.sendEmptyMessageDelayed(1, locala.sOa);
      break;
      i = 2;
      break label184;
      label483:
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
    label655:
    Log.i("MicroMsg.WiFiConnector", "connect, connectWifi fail");
    for (;;)
    {
      label663:
      locala.H(false, "fail to connect wifi:invalid network id");
      Log.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      break;
      label683:
      Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
    }
  }
  
  public static e cyh()
  {
    AppMethodBeat.i(144699);
    WifiInfo localWifiInfo = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cys();
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.acF(localWifiInfo.getSSID());
        str1 = Util.nullAs(localWifiInfo.getBSSID(), "");
      }
    }
    if ((sNP != null) && (((String)localObject).compareTo(sNP.sNF) == 0) && (str1.compareTo(sNP.sNG) == 0))
    {
      localObject = sNP;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      jT(true);
      localObject = sNP;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static f cyi()
  {
    AppMethodBeat.i(370026);
    f localf = jT(true);
    AppMethodBeat.o(370026);
    return localf;
  }
  
  public static void cyj()
  {
    AppMethodBeat.i(325798);
    Log.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    sNS = null;
    AppMethodBeat.o(325798);
  }
  
  public static void eW(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!sNN) && (paramContext != null))
    {
      mContext = MMApplicationContext.getContext();
      Log.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (sNR == null) {
        sNR = new a((byte)0);
      }
      mContext.registerReceiver(sNR, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.sOn = paramContext;
        sNN = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static f jT(boolean paramBoolean)
  {
    AppMethodBeat.i(325797);
    f localf = new f();
    sNP = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((sNN) && (com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyv()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyr();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyt();
      localf.sNM = new ArrayList();
      localf.ppp = "ok";
      if (localObject2 != null)
      {
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cys();
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label428;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.acF(((WifiInfo)localObject1).getSSID());
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
          int j = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.a(localScanResult);
          e locale = new e();
          locale.sNF = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.acF(localScanResult.SSID);
          locale.sNG = Util.nullAs(localScanResult.BSSID, "");
          locale.sNH = Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.BE(localScanResult.level));
          if (j == 2)
          {
            paramBoolean = true;
            label256:
            locale.sNI = Boolean.valueOf(paramBoolean);
            locale.sNJ = Integer.valueOf(localScanResult.frequency);
            if ((str == null) || (localObject1 == null) || (locale.sNF.compareTo(str) != 0) || (locale.sNG.compareTo((String)localObject1) != 0)) {
              break label353;
            }
          }
          label353:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              sNP = locale;
            }
            if ((j != 0) && (j != 2)) {
              break;
            }
            localf.sNM.add(locale);
            break;
            paramBoolean = false;
            break label256;
          }
        }
      }
      Log.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + sNP);
      for (;;)
      {
        AppMethodBeat.o(325797);
        return localf;
        Log.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (sNN) {
          localf.ppp = "wifi is disable";
        } else {
          localf.ppp = "sdk not init";
        }
      }
      label428:
      localObject1 = null;
      str = null;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(325762);
      Log.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        Log.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(325762);
        return;
      }
      paramContext = g.cyk();
      if (paramContext == null)
      {
        Log.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(325762);
        return;
      }
      paramContext.a(g.cyl());
      AppMethodBeat.o(325762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.g
 * JD-Core Version:    0.7.0.1
 */