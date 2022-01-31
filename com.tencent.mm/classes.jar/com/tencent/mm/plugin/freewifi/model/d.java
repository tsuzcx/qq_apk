package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Integer, String> mKj;
  
  static
  {
    AppMethodBeat.i(20716);
    mKj = new d.1();
    AppMethodBeat.o(20716);
  }
  
  private static WifiConfiguration D(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20703);
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    localWifiConfiguration.status = 2;
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(20703);
      return localWifiConfiguration;
      localWifiConfiguration.wepKeys = new String[] { "\"" + paramString2 + "\"" };
      localWifiConfiguration.allowedKeyManagement.set(0);
      continue;
      localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
      localWifiConfiguration.allowedKeyManagement.set(1);
    }
  }
  
  public static int OB(String paramString)
  {
    AppMethodBeat.i(20699);
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
      AppMethodBeat.o(20699);
      return 0;
    }
    c localc = j.bAK().OK(paramString);
    if ((localc != null) && (paramString.equalsIgnoreCase(localc.field_ssid)))
    {
      if ((localc.field_connectState == 2) && (localc.field_expiredTime > 0L) && (localc.field_expiredTime - bo.aox() <= 0L))
      {
        localc.field_connectState = 1;
        boolean bool = j.bAK().update(localc, new String[0]);
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[] { Long.valueOf(localc.field_expiredTime), Long.valueOf(bo.aox()), Boolean.valueOf(bool) });
      }
      int i = localc.field_connectState;
      AppMethodBeat.o(20699);
      return i;
    }
    AppMethodBeat.o(20699);
    return 0;
  }
  
  public static boolean OC(String paramString)
  {
    AppMethodBeat.i(20700);
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
      AppMethodBeat.o(20700);
      return false;
    }
    String str = at.gX(ah.getContext());
    if ((!bo.isNullOrNil(str)) && (str.equals(paramString)))
    {
      AppMethodBeat.o(20700);
      return true;
    }
    AppMethodBeat.o(20700);
    return false;
  }
  
  public static int OD(String paramString)
  {
    AppMethodBeat.i(20701);
    WifiManager localWifiManager = (WifiManager)ah.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
      AppMethodBeat.o(20701);
      return -11;
    }
    int i = OF(paramString);
    if (i > 0) {
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
    }
    for (;;)
    {
      boolean bool = localWifiManager.enableNetwork(i, true);
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(20701);
      return 0;
      WifiConfiguration localWifiConfiguration = new WifiConfiguration();
      localWifiConfiguration.allowedAuthAlgorithms.clear();
      localWifiConfiguration.allowedGroupCiphers.clear();
      localWifiConfiguration.allowedKeyManagement.clear();
      localWifiConfiguration.allowedPairwiseCiphers.clear();
      localWifiConfiguration.allowedProtocols.clear();
      localWifiConfiguration.SSID = ("\"" + paramString + "\"");
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[] { Boolean.valueOf(OE(paramString)) });
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      i = localWifiManager.addNetwork(localWifiConfiguration);
    }
    AppMethodBeat.o(20701);
    return -14;
  }
  
  public static boolean OE(String paramString)
  {
    AppMethodBeat.i(20706);
    int i = OF(paramString);
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == -1)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[] { paramString });
      AppMethodBeat.o(20706);
      return false;
    }
    WifiManager localWifiManager = (WifiManager)ah.getContext().getSystemService("wifi");
    boolean bool = localWifiManager.removeNetwork(i);
    localWifiManager.saveConfiguration();
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(20706);
    return bool;
  }
  
  private static int OF(String paramString)
  {
    AppMethodBeat.i(20707);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
      AppMethodBeat.o(20707);
      return -1;
    }
    Object localObject = ((WifiManager)ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
    if (localObject == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
      AppMethodBeat.o(20707);
      return -1;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if (localWifiConfiguration.SSID.equals("\"" + paramString + "\""))
      {
        int i = localWifiConfiguration.networkId;
        AppMethodBeat.o(20707);
        return i;
      }
    }
    AppMethodBeat.o(20707);
    return -1;
  }
  
  public static void a(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(20709);
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[] { m.U(paramIntent), Integer.valueOf(m.V(paramIntent)), wl(paramInt), Integer.valueOf(paramInt) });
    paramIntent = j.bAK().OK(paramString);
    if (paramIntent != null)
    {
      paramIntent.field_connectState = paramInt;
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(j.bAK().update(paramIntent, new String[0])) });
    }
    AppMethodBeat.o(20709);
  }
  
  public static WifiInfo bAA()
  {
    AppMethodBeat.i(20712);
    Object localObject = (WifiManager)ah.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(20712);
      return null;
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      AppMethodBeat.o(20712);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(20712);
    }
    return null;
  }
  
  public static String bAB()
  {
    AppMethodBeat.i(20713);
    String str = at.gY(ah.getContext());
    AppMethodBeat.o(20713);
    return str;
  }
  
  public static String bAC()
  {
    AppMethodBeat.i(156900);
    String str = at.gX(ah.getContext());
    AppMethodBeat.o(156900);
    return str;
  }
  
  public static boolean bAx()
  {
    AppMethodBeat.i(20705);
    WifiManager localWifiManager = (WifiManager)ah.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(20705);
      return false;
    }
    boolean bool = localWifiManager.setWifiEnabled(true);
    AppMethodBeat.o(20705);
    return bool;
  }
  
  public static String bAy()
  {
    AppMethodBeat.i(20710);
    if (at.getNetType(ah.getContext()) == 0)
    {
      Object localObject = bAA();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[] { localObject });
        AppMethodBeat.o(20710);
        return localObject;
      }
    }
    AppMethodBeat.o(20710);
    return null;
  }
  
  public static int bAz()
  {
    AppMethodBeat.i(20711);
    if (at.getNetType(ah.getContext()) == 0)
    {
      WifiInfo localWifiInfo = bAA();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(20711);
        return i;
      }
    }
    AppMethodBeat.o(20711);
    return 0;
  }
  
  public static int c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20702);
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
      AppMethodBeat.o(20702);
      return -12;
    }
    if (paramInt == 0)
    {
      paramInt = OD(paramString1);
      AppMethodBeat.o(20702);
      return paramInt;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
      AppMethodBeat.o(20702);
      return -15;
    }
    WifiManager localWifiManager = (WifiManager)ah.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
      AppMethodBeat.o(20702);
      return -11;
    }
    label162:
    Object localObject;
    if (com.tencent.mm.compatible.util.d.fv(21)) {
      if (bo.isNullOrNil(paramString1))
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
        break label305;
        localObject = null;
        label165:
        if (localObject != null) {
          break label362;
        }
        paramString1 = D(paramString1, paramString2, paramInt);
        paramString1.hiddenSSID = paramBoolean;
        paramInt = localWifiManager.addNetwork(paramString1);
        localWifiManager.saveConfiguration();
      }
    }
    for (;;)
    {
      paramBoolean = localWifiManager.enableNetwork(paramInt, true);
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label612;
      }
      AppMethodBeat.o(20702);
      return 0;
      localObject = ((WifiManager)ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
      if (localObject == null)
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
        break label162;
      }
      ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      label305:
      if (!localIterator.hasNext()) {
        break label162;
      }
      localObject = (WifiConfiguration)localIterator.next();
      if (!((WifiConfiguration)localObject).SSID.equals("\"" + paramString1 + "\"")) {
        break;
      }
      break label165;
      label362:
      if (localObject != null)
      {
        ((WifiConfiguration)localObject).SSID = ("\"" + paramString1 + "\"");
        ((WifiConfiguration)localObject).status = 2;
        switch (paramInt)
        {
        default: 
          ab.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
      int i = OF(paramString1);
      if (i > 0) {
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[] { paramString1, Boolean.valueOf(localWifiManager.removeNetwork(i)) });
      }
      paramString1 = D(paramString1, paramString2, paramInt);
      paramString1.hiddenSSID = paramBoolean;
      paramInt = localWifiManager.addNetwork(paramString1);
      localWifiManager.saveConfiguration();
    }
    label612:
    AppMethodBeat.o(20702);
    return -14;
  }
  
  public static int getNetworkType()
  {
    AppMethodBeat.i(156901);
    int i = at.getNetType(ah.getContext());
    AppMethodBeat.o(156901);
    return i;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(20704);
    WifiManager localWifiManager = (WifiManager)ah.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(20704);
      return false;
    }
    boolean bool = localWifiManager.isWifiEnabled();
    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20704);
    return bool;
  }
  
  public static String wl(int paramInt)
  {
    AppMethodBeat.i(20708);
    String str = (String)mKj.get(Integer.valueOf(paramInt));
    if (str == null)
    {
      AppMethodBeat.o(20708);
      return "";
    }
    AppMethodBeat.o(20708);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d
 * JD-Core Version:    0.7.0.1
 */