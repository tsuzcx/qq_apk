package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Integer, String> kow = new HashMap() {};
  
  public static int Dt(String paramString)
  {
    if (bk.bl(paramString)) {
      y.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
    }
    c localc;
    do
    {
      return 0;
      localc = j.aUi().DC(paramString);
    } while ((localc == null) || (!paramString.equalsIgnoreCase(localc.field_ssid)));
    if ((localc.field_connectState == 2) && (localc.field_expiredTime > 0L) && (localc.field_expiredTime - bk.UX() <= 0L))
    {
      localc.field_connectState = 1;
      boolean bool = j.aUi().c(localc, new String[0]);
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[] { Long.valueOf(localc.field_expiredTime), Long.valueOf(bk.UX()), Boolean.valueOf(bool) });
    }
    return localc.field_connectState;
  }
  
  public static boolean Du(String paramString)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
    }
    String str;
    do
    {
      return false;
      str = aTX();
    } while ((bk.bl(str)) || (!str.equals(paramString)));
    return true;
  }
  
  public static int Dv(String paramString)
  {
    WifiManager localWifiManager = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
      return -11;
    }
    int i = Dx(paramString);
    if (i > 0) {
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
    }
    for (;;)
    {
      boolean bool = localWifiManager.enableNetwork(i, true);
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      return 0;
      WifiConfiguration localWifiConfiguration = new WifiConfiguration();
      localWifiConfiguration.allowedAuthAlgorithms.clear();
      localWifiConfiguration.allowedGroupCiphers.clear();
      localWifiConfiguration.allowedKeyManagement.clear();
      localWifiConfiguration.allowedPairwiseCiphers.clear();
      localWifiConfiguration.allowedProtocols.clear();
      localWifiConfiguration.SSID = ("\"" + paramString + "\"");
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[] { Boolean.valueOf(Dw(paramString)) });
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      i = localWifiManager.addNetwork(localWifiConfiguration);
    }
    return -14;
  }
  
  public static boolean Dw(String paramString)
  {
    int i = Dx(paramString);
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == -1)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[] { paramString });
      return false;
    }
    WifiManager localWifiManager = (WifiManager)ae.getContext().getSystemService("wifi");
    boolean bool = localWifiManager.removeNetwork(i);
    localWifiManager.saveConfiguration();
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  private static int Dx(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
      return -1;
    }
    Object localObject = ((WifiManager)ae.getContext().getSystemService("wifi")).getConfiguredNetworks();
    if (localObject == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
      return -1;
    }
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if (localWifiConfiguration.SSID.equals("\"" + paramString + "\"")) {
        return localWifiConfiguration.networkId;
      }
    }
    return -1;
  }
  
  public static void a(String paramString, int paramInt, Intent paramIntent)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[] { m.B(paramIntent), Integer.valueOf(m.C(paramIntent)), rr(paramInt), Integer.valueOf(paramInt) });
    paramIntent = j.aUi().DC(paramString);
    if (paramIntent != null)
    {
      paramIntent.field_connectState = paramInt;
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(j.aUi().c(paramIntent, new String[0])) });
    }
  }
  
  public static boolean aTU()
  {
    WifiManager localWifiManager = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      return false;
    }
    return localWifiManager.setWifiEnabled(true);
  }
  
  public static String aTV()
  {
    if (aq.getNetType(ae.getContext()) == 0)
    {
      Object localObject = aTY();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        y.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[] { localObject });
        return localObject;
      }
    }
    return null;
  }
  
  public static int aTW()
  {
    if (aq.getNetType(ae.getContext()) == 0)
    {
      WifiInfo localWifiInfo = aTY();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        y.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[] { Integer.valueOf(i) });
        return i;
      }
    }
    return 0;
  }
  
  public static String aTX()
  {
    int i = aq.getNetType(ae.getContext());
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "networkType = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      Object localObject = aTY();
      if ((localObject != null) && (((WifiInfo)localObject).getSSID() != null))
      {
        localObject = ((WifiInfo)localObject).getSSID().replace("\"", "");
        y.i("MicroMsg.FreeWifi.FreeWifiManager", "get ssid now : %s", new Object[] { localObject });
        return localObject;
      }
    }
    return null;
  }
  
  public static WifiInfo aTY()
  {
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      return null;
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
  
  public static String aTZ()
  {
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject == null) {
          return "";
        }
        String str = ((WifiInfo)localObject).getBSSID();
        localObject = str;
        if (str == null) {
          return "";
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[] { localException.getMessage() });
      }
    }
    return "";
  }
  
  public static String aUa()
  {
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      return "";
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "";
      }
      localObject = ((WifiInfo)localObject).getSSID();
      if (localObject == null) {
        return "";
      }
      localObject = m.Dm((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[] { localException.getMessage() });
    }
    return "";
  }
  
  public static int c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
      return -12;
    }
    if (paramInt == 0) {
      return Dv(paramString1);
    }
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
      return -15;
    }
    WifiManager localWifiManager = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
      return -11;
    }
    label130:
    Object localObject;
    if (com.tencent.mm.compatible.util.d.gF(21)) {
      if (bk.bl(paramString1))
      {
        y.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
        break label267;
        localObject = null;
        label133:
        if (localObject != null) {
          break label324;
        }
        paramString1 = w(paramString1, paramString2, paramInt);
        paramString1.hiddenSSID = paramBoolean;
        paramInt = localWifiManager.addNetwork(paramString1);
        localWifiManager.saveConfiguration();
      }
    }
    for (;;)
    {
      paramBoolean = localWifiManager.enableNetwork(paramInt, true);
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label573;
      }
      return 0;
      localObject = ((WifiManager)ae.getContext().getSystemService("wifi")).getConfiguredNetworks();
      if (localObject == null)
      {
        y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
        break label130;
      }
      y.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      Iterator localIterator = ((List)localObject).iterator();
      label267:
      if (!localIterator.hasNext()) {
        break label130;
      }
      localObject = (WifiConfiguration)localIterator.next();
      if (!((WifiConfiguration)localObject).SSID.equals("\"" + paramString1 + "\"")) {
        break;
      }
      break label133;
      label324:
      if (localObject != null)
      {
        ((WifiConfiguration)localObject).SSID = ("\"" + paramString1 + "\"");
        ((WifiConfiguration)localObject).status = 2;
        switch (paramInt)
        {
        default: 
          y.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
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
      int i = Dx(paramString1);
      if (i > 0) {
        y.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[] { paramString1, Boolean.valueOf(localWifiManager.removeNetwork(i)) });
      }
      paramString1 = w(paramString1, paramString2, paramInt);
      paramString1.hiddenSSID = paramBoolean;
      paramInt = localWifiManager.addNetwork(paramString1);
      localWifiManager.saveConfiguration();
    }
    label573:
    return -14;
  }
  
  public static int getNetworkType()
  {
    return aq.getNetType(ae.getContext());
  }
  
  public static boolean isWifiEnabled()
  {
    WifiManager localWifiManager = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localWifiManager == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
      return false;
    }
    boolean bool = localWifiManager.isWifiEnabled();
    y.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void release() {}
  
  public static String rr(int paramInt)
  {
    String str2 = (String)kow.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  private static WifiConfiguration w(String paramString1, String paramString2, int paramInt)
  {
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    localWifiConfiguration.status = 2;
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[] { Integer.valueOf(paramInt) });
      return localWifiConfiguration;
    case 1: 
      localWifiConfiguration.wepKeys = new String[] { "\"" + paramString2 + "\"" };
      localWifiConfiguration.allowedKeyManagement.set(0);
      return localWifiConfiguration;
    }
    localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
    localWifiConfiguration.allowedKeyManagement.set(1);
    return localWifiConfiguration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d
 * JD-Core Version:    0.7.0.1
 */