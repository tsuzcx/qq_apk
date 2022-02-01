package com.tencent.mm.plugin.appbrand.jsapi.ah.a;

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
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.a.2;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.a.3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static Context mContext;
  private static boolean pIT = false;
  private static WeakReference<a> pIU = null;
  private static d pIV = null;
  private static b pIW;
  private static BroadcastReceiver pIX = null;
  private static volatile c pIY = null;
  
  public static void a(b paramb)
  {
    pIW = paramb;
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(199907);
    Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    pIV = null;
    if ((pIT) && (com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYf()))
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYb();
      pIY = paramc;
      AppMethodBeat.o(199907);
      return;
    }
    e locale = new e();
    if (pIT) {}
    for (locale.mvQ = "wifi is disable";; locale.mvQ = "sdk not init")
    {
      paramc.a(locale);
      AppMethodBeat.o(199907);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(199922);
    Object localObject;
    if (pIU != null)
    {
      localObject = (a)pIU.get();
      if ((localObject != null) && (!((a)localObject).bXX())) {
        ((a)localObject).ajD("duplicated request");
      }
    }
    a locala = new a(pIW, mContext, paramBoolean);
    Log.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2);
    locala.pIL = paramString1;
    locala.pIM = paramString2;
    if (-1L != paramLong) {
      locala.pJg = paramLong;
    }
    if (locala.pJi)
    {
      Log.i("MicroMsg.WiFiConnector", "connect, use WifiConnector29Impl");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.c.pJl;
      com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.c.a(locala.pIZ, paramString1, paramString2, paramString3, paramLong, new a.3(locala));
      pIU = new WeakReference(locala);
      AppMethodBeat.o(199922);
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
      paramString3 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYa();
      if (paramString3 == null) {
        break label650;
      }
    }
    label650:
    for (paramString3 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b.a(paramString1, i, paramString3);; paramString3 = null)
    {
      Log.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString2, paramString3 });
      if (paramString2 == null) {
        break label663;
      }
      localObject = paramString2;
      if (paramString3 != null)
      {
        int j = 0;
        if (com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b.co(paramString1, i))
        {
          j = 1;
          com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYe();
        }
        localObject = paramString2;
        if (j == 0)
        {
          Log.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
          paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b.c(paramString2);
          localObject = paramString2;
          if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.pJw)
          {
            Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
            locala.pJh = true;
            localObject = paramString3;
          }
        }
      }
      if (((WifiConfiguration)localObject).networkId == com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.pJw) {
        ((WifiConfiguration)localObject).networkId = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b.c((WifiConfiguration)localObject);
      }
      if (((WifiConfiguration)localObject).networkId == com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.pJw) {
        break label683;
      }
      if (!locala.a((WifiConfiguration)localObject)) {
        break label655;
      }
      Log.i("MicroMsg.wifi_event", "CONNECTING");
      locala.Bl(1);
      locala.pJc = ((WifiConfiguration)localObject);
      if (!locala.pIH)
      {
        paramString1 = new IntentFilter();
        paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        paramString1.addAction("android.net.wifi.STATE_CHANGE");
        paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        paramString1.setPriority(2147483647);
        locala.pJd = new a.2(locala);
        locala.pIZ.registerReceiver(locala.pJd, paramString1);
        locala.pIH = true;
        Log.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
      }
      locala.mHandler.sendEmptyMessageDelayed(1, locala.pJg);
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
      locala.v(false, "fail to connect wifi:invalid network id");
      Log.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      break;
      label683:
      Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
    }
  }
  
  public static d bXR()
  {
    AppMethodBeat.i(144699);
    WifiInfo localWifiInfo = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYc();
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.ajE(localWifiInfo.getSSID());
        str1 = Util.nullAs(localWifiInfo.getBSSID(), "");
      }
    }
    if ((pIV != null) && (((String)localObject).compareTo(pIV.pIL) == 0) && (str1.compareTo(pIV.pIM) == 0))
    {
      localObject = pIV;
      AppMethodBeat.o(144699);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      Log.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      iN(true);
      localObject = pIV;
      AppMethodBeat.o(144699);
      return localObject;
    }
    AppMethodBeat.o(144699);
    return null;
  }
  
  public static e bXS()
  {
    AppMethodBeat.i(292882);
    e locale = iN(true);
    AppMethodBeat.o(292882);
    return locale;
  }
  
  public static void bXT()
  {
    AppMethodBeat.i(199902);
    Log.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    pIY = null;
    AppMethodBeat.o(199902);
  }
  
  public static void eb(Context paramContext)
  {
    AppMethodBeat.i(144698);
    if ((!pIT) && (paramContext != null))
    {
      mContext = MMApplicationContext.getContext();
      Log.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (pIX == null) {
        pIX = new a((byte)0);
      }
      mContext.registerReceiver(pIX, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)mContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.pJv = paramContext;
        pIT = true;
      }
    }
    AppMethodBeat.o(144698);
  }
  
  private static e iN(boolean paramBoolean)
  {
    AppMethodBeat.i(199899);
    e locale = new e();
    pIV = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((pIT) && (com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYf()))
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYb();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYd();
      locale.pIS = new ArrayList();
      locale.mvQ = "ok";
      if (localObject2 != null)
      {
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYc();
        Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label419;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.ajE(((WifiInfo)localObject1).getSSID());
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
          int j = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.a(localScanResult);
          d locald = new d();
          locald.pIL = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.ajE(localScanResult.SSID);
          locald.pIM = Util.nullAs(localScanResult.BSSID, "");
          locald.pIN = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.Br(localScanResult.level);
          if (j == 2)
          {
            paramBoolean = true;
            label253:
            locald.pIO = paramBoolean;
            locald.pIP = localScanResult.frequency;
            if ((str == null) || (localObject1 == null) || (locald.pIL.compareTo(str) != 0) || (locald.pIM.compareTo((String)localObject1) != 0)) {
              break label344;
            }
          }
          label344:
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              pIV = locald;
            }
            if ((j != 0) && (j != 2)) {
              break;
            }
            locale.pIS.add(locald);
            break;
            paramBoolean = false;
            break label253;
          }
        }
      }
      Log.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + pIV);
      for (;;)
      {
        AppMethodBeat.o(199899);
        return locale;
        Log.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
        continue;
        if (pIT) {
          locale.mvQ = "wifi is disable";
        } else {
          locale.mvQ = "sdk not init";
        }
      }
      label419:
      localObject1 = null;
      str = null;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(199143);
      Log.i("MicroMsg.WiFiManagerWrapper", "onReceive");
      if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
      {
        Log.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        AppMethodBeat.o(199143);
        return;
      }
      paramContext = f.bXU();
      if (paramContext == null)
      {
        Log.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        AppMethodBeat.o(199143);
        return;
      }
      paramContext.a(f.bXV());
      AppMethodBeat.o(199143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.f
 * JD-Core Version:    0.7.0.1
 */