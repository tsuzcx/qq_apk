package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Integer, String> tmJ;
  
  static
  {
    AppMethodBeat.i(24793);
    tmJ = new d.1();
    AppMethodBeat.o(24793);
  }
  
  public static String GI(int paramInt)
  {
    AppMethodBeat.i(24785);
    String str = (String)tmJ.get(Integer.valueOf(paramInt));
    if (str == null)
    {
      AppMethodBeat.o(24785);
      return "";
    }
    AppMethodBeat.o(24785);
    return str;
  }
  
  private static WifiConfiguration S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(24780);
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    localWifiConfiguration.status = 2;
    switch (paramInt)
    {
    default: 
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(24780);
      return localWifiConfiguration;
      localWifiConfiguration.wepKeys = new String[] { "\"" + paramString2 + "\"" };
      localWifiConfiguration.allowedKeyManagement.set(0);
      continue;
      localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
      localWifiConfiguration.allowedKeyManagement.set(1);
    }
  }
  
  public static void a(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(24786);
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[] { m.ao(paramIntent), Integer.valueOf(m.ap(paramIntent)), GI(paramInt), Integer.valueOf(paramInt) });
    paramIntent = j.cRz().ajY(paramString);
    if (paramIntent != null)
    {
      paramIntent.field_connectState = paramInt;
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(j.cRz().update(paramIntent, new String[0])) });
    }
    AppMethodBeat.o(24786);
  }
  
  public static int ajP(String paramString)
  {
    AppMethodBeat.i(24776);
    if (bt.isNullOrNil(paramString))
    {
      ad.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
      AppMethodBeat.o(24776);
      return 0;
    }
    c localc = j.cRz().ajY(paramString);
    if ((localc != null) && (paramString.equalsIgnoreCase(localc.field_ssid)))
    {
      if ((localc.field_connectState == 2) && (localc.field_expiredTime > 0L) && (localc.field_expiredTime - bt.aQJ() <= 0L))
      {
        localc.field_connectState = 1;
        boolean bool = j.cRz().update(localc, new String[0]);
        ad.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[] { Long.valueOf(localc.field_expiredTime), Long.valueOf(bt.aQJ()), Boolean.valueOf(bool) });
      }
      int i = localc.field_connectState;
      AppMethodBeat.o(24776);
      return i;
    }
    AppMethodBeat.o(24776);
    return 0;
  }
  
  public static boolean ajQ(String paramString)
  {
    AppMethodBeat.i(24777);
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
      AppMethodBeat.o(24777);
      return false;
    }
    String str = ay.iV(aj.getContext());
    if ((!bt.isNullOrNil(str)) && (str.equals(paramString)))
    {
      AppMethodBeat.o(24777);
      return true;
    }
    AppMethodBeat.o(24777);
    return false;
  }
  
  public static int ajR(String paramString)
  {
    AppMethodBeat.i(24778);
    WifiManager localWifiManager = (WifiManager)aj.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
      AppMethodBeat.o(24778);
      return -11;
    }
    int i = ajT(paramString);
    if (i > 0) {
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
    }
    for (;;)
    {
      boolean bool = localWifiManager.enableNetwork(i, true);
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(24778);
      return 0;
      WifiConfiguration localWifiConfiguration = new WifiConfiguration();
      localWifiConfiguration.allowedAuthAlgorithms.clear();
      localWifiConfiguration.allowedGroupCiphers.clear();
      localWifiConfiguration.allowedKeyManagement.clear();
      localWifiConfiguration.allowedPairwiseCiphers.clear();
      localWifiConfiguration.allowedProtocols.clear();
      localWifiConfiguration.SSID = ("\"" + paramString + "\"");
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[] { Boolean.valueOf(ajS(paramString)) });
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      i = localWifiManager.addNetwork(localWifiConfiguration);
    }
    AppMethodBeat.o(24778);
    return -14;
  }
  
  public static boolean ajS(String paramString)
  {
    AppMethodBeat.i(24783);
    int i = ajT(paramString);
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == -1)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[] { paramString });
      AppMethodBeat.o(24783);
      return false;
    }
    WifiManager localWifiManager = (WifiManager)aj.getContext().getSystemService("wifi");
    boolean bool = localWifiManager.removeNetwork(i);
    localWifiManager.saveConfiguration();
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(24783);
    return bool;
  }
  
  private static int ajT(String paramString)
  {
    AppMethodBeat.i(24784);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
      AppMethodBeat.o(24784);
      return -1;
    }
    Object localObject = ((WifiManager)aj.getContext().getSystemService("wifi")).getConfiguredNetworks();
    if (localObject == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
      AppMethodBeat.o(24784);
      return -1;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if (localWifiConfiguration.SSID.equals("\"" + paramString + "\""))
      {
        int i = localWifiConfiguration.networkId;
        AppMethodBeat.o(24784);
        return i;
      }
    }
    AppMethodBeat.o(24784);
    return -1;
  }
  
  public static boolean cRm()
  {
    AppMethodBeat.i(24782);
    WifiManager localWifiManager = (WifiManager)aj.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24782);
      return false;
    }
    boolean bool = localWifiManager.setWifiEnabled(true);
    AppMethodBeat.o(24782);
    return bool;
  }
  
  public static String cRn()
  {
    AppMethodBeat.i(24787);
    if (ay.getNetType(aj.getContext()) == 0)
    {
      Object localObject = cRp();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        ad.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[] { localObject });
        AppMethodBeat.o(24787);
        return localObject;
      }
    }
    AppMethodBeat.o(24787);
    return null;
  }
  
  public static int cRo()
  {
    AppMethodBeat.i(24788);
    if (ay.getNetType(aj.getContext()) == 0)
    {
      WifiInfo localWifiInfo = cRp();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        ad.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(24788);
        return i;
      }
    }
    AppMethodBeat.o(24788);
    return 0;
  }
  
  public static WifiInfo cRp()
  {
    AppMethodBeat.i(24789);
    Object localObject = (WifiManager)aj.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24789);
      return null;
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      AppMethodBeat.o(24789);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(24789);
    }
    return null;
  }
  
  public static String cRq()
  {
    AppMethodBeat.i(24790);
    String str = ay.iW(aj.getContext());
    AppMethodBeat.o(24790);
    return str;
  }
  
  public static String cRr()
  {
    AppMethodBeat.i(221376);
    String str = ay.iV(aj.getContext());
    AppMethodBeat.o(221376);
    return str;
  }
  
  public static int e(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24779);
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
      AppMethodBeat.o(24779);
      return -12;
    }
    if (paramInt == 0)
    {
      paramInt = ajR(paramString1);
      AppMethodBeat.o(24779);
      return paramInt;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
      AppMethodBeat.o(24779);
      return -15;
    }
    WifiManager localWifiManager = (WifiManager)aj.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
      AppMethodBeat.o(24779);
      return -11;
    }
    label163:
    Object localObject;
    if (com.tencent.mm.compatible.util.d.ly(21)) {
      if (bt.isNullOrNil(paramString1))
      {
        ad.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
        break label308;
        localObject = null;
        label166:
        if (localObject != null) {
          break label365;
        }
        paramString1 = S(paramString1, paramString2, paramInt);
        paramString1.hiddenSSID = paramBoolean;
        paramInt = localWifiManager.addNetwork(paramString1);
        localWifiManager.saveConfiguration();
      }
    }
    for (;;)
    {
      paramBoolean = localWifiManager.enableNetwork(paramInt, true);
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label612;
      }
      AppMethodBeat.o(24779);
      return 0;
      localObject = ((WifiManager)aj.getContext().getSystemService("wifi")).getConfiguredNetworks();
      if (localObject == null)
      {
        ad.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
        break label163;
      }
      ad.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      label308:
      if (!localIterator.hasNext()) {
        break label163;
      }
      localObject = (WifiConfiguration)localIterator.next();
      if (!((WifiConfiguration)localObject).SSID.equals("\"" + paramString1 + "\"")) {
        break;
      }
      break label166;
      label365:
      if (localObject != null)
      {
        ((WifiConfiguration)localObject).SSID = ("\"" + paramString1 + "\"");
        ((WifiConfiguration)localObject).status = 2;
        switch (paramInt)
        {
        default: 
          ad.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      for (;;)
      {
        ((WifiConfiguration)localObject).hiddenSSID = paramBoolean;
        paramInt = ((WifiConfiguration)localObject).networkId;
        break;
        ((WifiConfiguration)localObject).wepKeys = new String[] { "\"" + paramString2 + "\"" };
        ((WifiConfiguration)localObject).allowedKeyManagement.set(0);
        continue;
        ((WifiConfiguration)localObject).preSharedKey = ("\"" + paramString2 + "\"");
        ((WifiConfiguration)localObject).allowedKeyManagement.set(1);
      }
      int i = ajT(paramString1);
      if (i > 0) {
        ad.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[] { paramString1, Boolean.valueOf(localWifiManager.removeNetwork(i)) });
      }
      paramString1 = S(paramString1, paramString2, paramInt);
      paramString1.hiddenSSID = paramBoolean;
      paramInt = localWifiManager.addNetwork(paramString1);
      localWifiManager.saveConfiguration();
    }
    label612:
    AppMethodBeat.o(24779);
    return -14;
  }
  
  public static int getNetworkType()
  {
    AppMethodBeat.i(221377);
    int i = ay.getNetType(aj.getContext());
    AppMethodBeat.o(221377);
    return i;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(24781);
    WifiManager localWifiManager = (WifiManager)aj.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24781);
      return false;
    }
    boolean bool = localWifiManager.isWifiEnabled();
    ad.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(24781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d
 * JD-Core Version:    0.7.0.1
 */