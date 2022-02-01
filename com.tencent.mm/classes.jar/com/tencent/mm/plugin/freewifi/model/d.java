package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Integer, String> txB;
  
  static
  {
    AppMethodBeat.i(24793);
    txB = new d.1();
    AppMethodBeat.o(24793);
  }
  
  public static String Hf(int paramInt)
  {
    AppMethodBeat.i(24785);
    String str = (String)txB.get(Integer.valueOf(paramInt));
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
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[] { m.ap(paramIntent), Integer.valueOf(m.aq(paramIntent)), Hf(paramInt), Integer.valueOf(paramInt) });
    paramIntent = j.cUe().akW(paramString);
    if (paramIntent != null)
    {
      paramIntent.field_connectState = paramInt;
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(j.cUe().update(paramIntent, new String[0])) });
    }
    AppMethodBeat.o(24786);
  }
  
  public static int akN(String paramString)
  {
    AppMethodBeat.i(24776);
    if (bu.isNullOrNil(paramString))
    {
      ae.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
      AppMethodBeat.o(24776);
      return 0;
    }
    c localc = j.cUe().akW(paramString);
    if ((localc != null) && (paramString.equalsIgnoreCase(localc.field_ssid)))
    {
      if ((localc.field_connectState == 2) && (localc.field_expiredTime > 0L) && (localc.field_expiredTime - bu.aRi() <= 0L))
      {
        localc.field_connectState = 1;
        boolean bool = j.cUe().update(localc, new String[0]);
        ae.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[] { Long.valueOf(localc.field_expiredTime), Long.valueOf(bu.aRi()), Boolean.valueOf(bool) });
      }
      int i = localc.field_connectState;
      AppMethodBeat.o(24776);
      return i;
    }
    AppMethodBeat.o(24776);
    return 0;
  }
  
  public static boolean akO(String paramString)
  {
    AppMethodBeat.i(24777);
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
      AppMethodBeat.o(24777);
      return false;
    }
    String str = az.ja(ak.getContext());
    if ((!bu.isNullOrNil(str)) && (str.equals(paramString)))
    {
      AppMethodBeat.o(24777);
      return true;
    }
    AppMethodBeat.o(24777);
    return false;
  }
  
  public static int akP(String paramString)
  {
    AppMethodBeat.i(24778);
    WifiManager localWifiManager = (WifiManager)ak.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
      AppMethodBeat.o(24778);
      return -11;
    }
    int i = akR(paramString);
    if (i > 0) {
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
    }
    for (;;)
    {
      boolean bool = localWifiManager.enableNetwork(i, true);
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[] { Boolean.valueOf(akQ(paramString)) });
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      i = localWifiManager.addNetwork(localWifiConfiguration);
    }
    AppMethodBeat.o(24778);
    return -14;
  }
  
  public static boolean akQ(String paramString)
  {
    AppMethodBeat.i(24783);
    int i = akR(paramString);
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == -1)
    {
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[] { paramString });
      AppMethodBeat.o(24783);
      return false;
    }
    WifiManager localWifiManager = (WifiManager)ak.getContext().getSystemService("wifi");
    boolean bool = localWifiManager.removeNetwork(i);
    localWifiManager.saveConfiguration();
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(24783);
    return bool;
  }
  
  private static int akR(String paramString)
  {
    AppMethodBeat.i(24784);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
      AppMethodBeat.o(24784);
      return -1;
    }
    Object localObject = ((WifiManager)ak.getContext().getSystemService("wifi")).getConfiguredNetworks();
    if (localObject == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
      AppMethodBeat.o(24784);
      return -1;
    }
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
  
  public static boolean cTR()
  {
    AppMethodBeat.i(24782);
    WifiManager localWifiManager = (WifiManager)ak.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24782);
      return false;
    }
    boolean bool = localWifiManager.setWifiEnabled(true);
    AppMethodBeat.o(24782);
    return bool;
  }
  
  public static String cTS()
  {
    AppMethodBeat.i(24787);
    if (az.getNetType(ak.getContext()) == 0)
    {
      Object localObject = cTU();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        ae.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[] { localObject });
        AppMethodBeat.o(24787);
        return localObject;
      }
    }
    AppMethodBeat.o(24787);
    return null;
  }
  
  public static int cTT()
  {
    AppMethodBeat.i(24788);
    if (az.getNetType(ak.getContext()) == 0)
    {
      WifiInfo localWifiInfo = cTU();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        ae.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(24788);
        return i;
      }
    }
    AppMethodBeat.o(24788);
    return 0;
  }
  
  public static WifiInfo cTU()
  {
    AppMethodBeat.i(24789);
    Object localObject = (WifiManager)ak.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
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
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(24789);
    }
    return null;
  }
  
  public static String cTV()
  {
    AppMethodBeat.i(24790);
    String str = az.jb(ak.getContext());
    AppMethodBeat.o(24790);
    return str;
  }
  
  public static String cTW()
  {
    AppMethodBeat.i(224181);
    String str = az.ja(ak.getContext());
    AppMethodBeat.o(224181);
    return str;
  }
  
  public static int e(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24779);
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
      AppMethodBeat.o(24779);
      return -12;
    }
    if (paramInt == 0)
    {
      paramInt = akP(paramString1);
      AppMethodBeat.o(24779);
      return paramInt;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
      AppMethodBeat.o(24779);
      return -15;
    }
    WifiManager localWifiManager = (WifiManager)ak.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
      AppMethodBeat.o(24779);
      return -11;
    }
    label163:
    Object localObject;
    if (com.tencent.mm.compatible.util.d.lA(21)) {
      if (bu.isNullOrNil(paramString1))
      {
        ae.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
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
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label612;
      }
      AppMethodBeat.o(24779);
      return 0;
      localObject = ((WifiManager)ak.getContext().getSystemService("wifi")).getConfiguredNetworks();
      if (localObject == null)
      {
        ae.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
        break label163;
      }
      ae.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          ae.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
      int i = akR(paramString1);
      if (i > 0) {
        ae.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[] { paramString1, Boolean.valueOf(localWifiManager.removeNetwork(i)) });
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
    AppMethodBeat.i(224182);
    int i = az.getNetType(ak.getContext());
    AppMethodBeat.o(224182);
    return i;
  }
  
  public static boolean isWifiEnabled()
  {
    AppMethodBeat.i(24781);
    WifiManager localWifiManager = (WifiManager)ak.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      AppMethodBeat.o(24781);
      return false;
    }
    boolean bool = localWifiManager.isWifiEnabled();
    ae.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(24781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d
 * JD-Core Version:    0.7.0.1
 */