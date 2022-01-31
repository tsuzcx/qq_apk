package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static boolean ihK = false;
  private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> ihL = null;
  private static b ihM = null;
  private static a ihN;
  private static Context mContext;
  
  public static void F(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(94386);
    if (ihL != null)
    {
      locala = (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a)ihL.get();
      if ((locala != null) && (!locala.aGu())) {
        locala.Dg("duplicated request");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a locala = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(ihN, mContext);
    ab.i("MicroMsg.WiFiConnector", "ssid:" + paramString1 + " bssid:" + paramString2 + " psw:" + paramString3);
    locala.ihD = paramString1;
    locala.ihE = paramString2;
    if (TextUtils.isEmpty(paramString3))
    {
      i = 0;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        break label396;
      }
      paramString2 = null;
      List localList = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConfiguredNetworks();
      paramString3 = str;
      if (localList != null) {
        paramString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.a(paramString1, i, localList);
      }
      if (paramString2 == null) {
        break label556;
      }
      str = paramString2;
      if (paramString3 != null)
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.bk(paramString1, i)) {
          break label576;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.saveConfiguration();
      }
    }
    label396:
    label556:
    label576:
    for (int i = 1;; i = 0)
    {
      str = paramString2;
      if (i == 0)
      {
        paramString2.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(paramString2);
        str = paramString2;
        if (paramString2.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.ihY)
        {
          locala.ihV = true;
          str = paramString3;
        }
      }
      if (str.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.ihY) {
        str.networkId = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b.b(str);
      }
      if ((str.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.ihY) && (locala.a(str)))
      {
        ab.i("MicroMsg.wifi_event", "CONNECTING");
        locala.oq(1);
        locala.ihR = str;
        if (!locala.ihz)
        {
          paramString1 = new IntentFilter();
          paramString1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
          paramString1.addAction("android.net.wifi.STATE_CHANGE");
          paramString1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          paramString1.setPriority(2147483647);
          locala.ihA = new WiFiConnector.2(locala);
          locala.ihO.registerReceiver(locala.ihA, paramString1);
          locala.ihz = true;
          ab.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
        }
        locala.mHandler.sendEmptyMessageDelayed(1, 13000L);
      }
      for (;;)
      {
        ihL = new WeakReference(locala);
        AppMethodBeat.o(94386);
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
        locala.k(false, "fail to connect wifi:invalid network id");
        ab.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
      }
    }
  }
  
  public static void a(a parama)
  {
    ihN = parama;
  }
  
  public static b aGr()
  {
    AppMethodBeat.i(94384);
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
        localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Dh(localWifiInfo.getSSID());
        str1 = bo.bf(localWifiInfo.getBSSID(), "");
      }
    }
    if ((ihM != null) && (((String)localObject).compareTo(ihM.ihD) == 0) && (str1.compareTo(ihM.ihE) == 0))
    {
      localObject = ihM;
      AppMethodBeat.o(94384);
      return localObject;
    }
    if (localWifiInfo != null)
    {
      aGs();
      localObject = ihM;
      AppMethodBeat.o(94384);
      return localObject;
    }
    AppMethodBeat.o(94384);
    return null;
  }
  
  public static c aGs()
  {
    AppMethodBeat.i(94385);
    c localc = new c();
    ihM = null;
    Object localObject2;
    Object localObject1;
    String str;
    if ((ihK) && (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.startScan();
      localObject2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getScanResults();
      localc.ihJ = new ArrayList();
      localc.hBF = "ok";
      if (localObject2 != null)
      {
        ab.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject2, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConnectionInfo();
        ab.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject1 });
        if ((localObject1 == null) || (TextUtils.isEmpty(((WifiInfo)localObject1).getSSID()))) {
          break label380;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Dh(((WifiInfo)localObject1).getSSID());
        localObject1 = bo.bf(((WifiInfo)localObject1).getBSSID(), "");
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
            b localb = new b();
            localb.ihD = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Dh(localScanResult.SSID);
            localb.ihE = bo.bf(localScanResult.BSSID, "");
            localb.ihF = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.ou(localScanResult.level);
            boolean bool;
            if (i == 2)
            {
              bool = true;
              label259:
              localb.ihG = bool;
              if ((str == null) || (localObject1 == null) || (localb.ihD.compareTo(str) != 0) || (localb.ihE.compareTo((String)localObject1) != 0)) {
                break label329;
              }
            }
            label329:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                ihM = localb;
              }
              localc.ihJ.add(localb);
              break;
              bool = false;
              break label259;
            }
            ab.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94385);
        return localc;
        if (ihK) {
          localc.hBF = "wifi is disable";
        } else {
          localc.hBF = "sdk not init";
        }
      }
      label380:
      localObject1 = null;
      str = null;
    }
  }
  
  public static void cR(Context paramContext)
  {
    AppMethodBeat.i(94383);
    if ((!ihK) && (paramContext != null))
    {
      paramContext = ah.getContext();
      mContext = paramContext;
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.bmz = paramContext;
        ihK = true;
      }
    }
    AppMethodBeat.o(94383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d
 * JD-Core Version:    0.7.0.1
 */