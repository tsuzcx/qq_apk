package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Integer, String> wOF;
  
  static
  {
    AppMethodBeat.i(24793);
    wOF = new d.1();
    AppMethodBeat.o(24793);
  }
  
  public static String Ne(int paramInt)
  {
    AppMethodBeat.i(24785);
    String str = (String)wOF.get(Integer.valueOf(paramInt));
    if (str == null)
    {
      AppMethodBeat.o(24785);
      return "";
    }
    AppMethodBeat.o(24785);
    return str;
  }
  
  private static WifiConfiguration T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(24780);
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    localWifiConfiguration.status = 2;
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[] { m.aw(paramIntent), Integer.valueOf(m.ax(paramIntent)), Ne(paramInt), Integer.valueOf(paramInt) });
    paramIntent = j.dNn().aya(paramString);
    if (paramIntent != null)
    {
      paramIntent.field_connectState = paramInt;
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(j.dNn().update(paramIntent, new String[0])) });
    }
    AppMethodBeat.o(24786);
  }
  
  public static int axR(String paramString)
  {
    AppMethodBeat.i(24776);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
      AppMethodBeat.o(24776);
      return 0;
    }
    c localc = j.dNn().aya(paramString);
    if ((localc != null) && (paramString.equalsIgnoreCase(localc.field_ssid)))
    {
      if ((localc.field_connectState == 2) && (localc.field_expiredTime > 0L) && (localc.field_expiredTime - Util.nowSecond() <= 0L))
      {
        localc.field_connectState = 1;
        boolean bool = j.dNn().update(localc, new String[0]);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[] { Long.valueOf(localc.field_expiredTime), Long.valueOf(Util.nowSecond()), Boolean.valueOf(bool) });
      }
      int i = localc.field_connectState;
      AppMethodBeat.o(24776);
      return i;
    }
    AppMethodBeat.o(24776);
    return 0;
  }
  
  public static boolean axS(String paramString)
  {
    AppMethodBeat.i(24777);
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
      AppMethodBeat.o(24777);
      return false;
    }
    String str = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    if ((!Util.isNullOrNil(str)) && (str.equals(paramString)))
    {
      AppMethodBeat.o(24777);
      return true;
    }
    AppMethodBeat.o(24777);
    return false;
  }
  
  public static int axT(String paramString)
  {
    AppMethodBeat.i(24778);
    WifiManager localWifiManager = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
      AppMethodBeat.o(24778);
      return -11;
    }
    int i = axV(paramString);
    if (i > 0) {
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
    }
    for (;;)
    {
      boolean bool = localWifiManager.enableNetwork(i, true);
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[] { Boolean.valueOf(axU(paramString)) });
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      i = localWifiManager.addNetwork(localWifiConfiguration);
    }
    AppMethodBeat.o(24778);
    return -14;
  }
  
  public static boolean axU(String paramString)
  {
    AppMethodBeat.i(24783);
    int i = axV(paramString);
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == -1)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[] { paramString });
      AppMethodBeat.o(24783);
      return false;
    }
    WifiManager localWifiManager = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    boolean bool = localWifiManager.removeNetwork(i);
    localWifiManager.saveConfiguration();
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(24783);
    return bool;
  }
  
  private static int axV(String paramString)
  {
    AppMethodBeat.i(24784);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
      AppMethodBeat.o(24784);
      return -1;
    }
    Object localObject = ((WifiManager)MMApplicationContext.getContext().getSystemService("wifi")).getConfiguredNetworks();
    if (localObject == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
      AppMethodBeat.o(24784);
      return -1;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
  
  public static int d(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24779);
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
      AppMethodBeat.o(24779);
      return -12;
    }
    if (paramInt == 0)
    {
      paramInt = axT(paramString1);
      AppMethodBeat.o(24779);
      return paramInt;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
      AppMethodBeat.o(24779);
      return -15;
    }
    WifiManager localWifiManager = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
      AppMethodBeat.o(24779);
      return -11;
    }
    label163:
    Object localObject;
    if (com.tencent.mm.compatible.util.d.oD(21)) {
      if (Util.isNullOrNil(paramString1))
      {
        Log.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
        break label308;
        localObject = null;
        label166:
        if (localObject != null) {
          break label365;
        }
        paramString1 = T(paramString1, paramString2, paramInt);
        paramString1.hiddenSSID = paramBoolean;
        paramInt = localWifiManager.addNetwork(paramString1);
        localWifiManager.saveConfiguration();
      }
    }
    for (;;)
    {
      paramBoolean = localWifiManager.enableNetwork(paramInt, true);
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label612;
      }
      AppMethodBeat.o(24779);
      return 0;
      localObject = ((WifiManager)MMApplicationContext.getContext().getSystemService("wifi")).getConfiguredNetworks();
      if (localObject == null)
      {
        Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
        break label163;
      }
      Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          Log.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
      int i = axV(paramString1);
      if (i > 0) {
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[] { paramString1, Boolean.valueOf(localWifiManager.removeNetwork(i)) });
      }
      paramString1 = T(paramString1, paramString2, paramInt);
      paramString1.hiddenSSID = paramBoolean;
      paramInt = localWifiManager.addNetwork(paramString1);
      localWifiManager.saveConfiguration();
    }
    label612:
    AppMethodBeat.o(24779);
    return -14;
  }
  
  public static boolean dNa()
  {
    AppMethodBeat.i(24782);
    WifiManager localWifiManager = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24782);
      return false;
    }
    boolean bool = localWifiManager.setWifiEnabled(true);
    AppMethodBeat.o(24782);
    return bool;
  }
  
  public static String dNb()
  {
    AppMethodBeat.i(24787);
    if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == 0)
    {
      Object localObject = dNd();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[] { localObject });
        AppMethodBeat.o(24787);
        return localObject;
      }
    }
    AppMethodBeat.o(24787);
    return null;
  }
  
  public static int dNc()
  {
    AppMethodBeat.i(24788);
    if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == 0)
    {
      WifiInfo localWifiInfo = dNd();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(24788);
        return i;
      }
    }
    AppMethodBeat.o(24788);
    return 0;
  }
  
  public static WifiInfo dNd()
  {
    AppMethodBeat.i(24789);
    Object localObject = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
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
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(24789);
    }
    return null;
  }
  
  public static String dNe()
  {
    AppMethodBeat.i(24790);
    String str = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    AppMethodBeat.o(24790);
    return str;
  }
  
  public static String dNf()
  {
    AppMethodBeat.i(258233);
    String str = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    AppMethodBeat.o(258233);
    return str;
  }
  
  public static int getNetworkType()
  {
    AppMethodBeat.i(258234);
    int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    AppMethodBeat.o(258234);
    return i;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(24781);
    WifiManager localWifiManager = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24781);
      return false;
    }
    boolean bool = localWifiManager.isWifiEnabled();
    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(24781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d
 * JD-Core Version:    0.7.0.1
 */