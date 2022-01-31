package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.R.l;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class m
{
  private static SimpleDateFormat hJl = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  public static void A(Intent paramIntent)
  {
    if (isEmpty(paramIntent.getStringExtra("free_wifi_sessionkey"))) {
      d(paramIntent, aTB());
    }
  }
  
  public static String B(Intent paramIntent)
  {
    return Dn(paramIntent.getStringExtra("free_wifi_sessionkey"));
  }
  
  public static int C(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", i);
    return i;
  }
  
  public static int D(Intent paramIntent)
  {
    return paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
  }
  
  public static String Dm(String paramString)
  {
    String str;
    if (isEmpty(paramString)) {
      str = "";
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (!paramString.startsWith("\""));
      str = paramString;
    } while (!paramString.endsWith("\""));
    return paramString.substring(1, paramString.length() - 1);
  }
  
  public static String Dn(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String Do(String paramString)
  {
    if (!aTE())
    {
      y.i(paramString, "wifi not connected. getConnectedWifiSsid() is empty");
      return "";
    }
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null) {
      return "";
    }
    localObject = ((WifiManager)localObject).getConnectionInfo();
    if (localObject == null) {
      return "";
    }
    localObject = ((WifiInfo)localObject).getSSID();
    if (isEmpty((String)localObject))
    {
      y.i(paramString, "getConnectedWifiSsid() is empty");
      return "";
    }
    y.i(paramString, "getConnectedWifiSsid()=" + Dm((String)localObject));
    return Dm((String)localObject);
  }
  
  public static String Dp(String paramString)
  {
    if (!aTE())
    {
      y.i(paramString, "wifi not connected. getConnectedWifiBssid() is empty");
      return "";
    }
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null) {
      return "";
    }
    localObject = ((WifiManager)localObject).getConnectionInfo();
    if (localObject == null) {
      return "";
    }
    localObject = Dn(((WifiInfo)localObject).getBSSID()).toLowerCase();
    y.i(paramString, "getConnectedWifiBssid()=" + (String)localObject);
    return localObject;
  }
  
  public static String Dq(String paramString)
  {
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      y.e(paramString, "error wifiManager is null!!");
      return "";
    }
    localObject = ((WifiManager)localObject).getConnectionInfo();
    if (localObject == null)
    {
      y.e(paramString, "error wifiInfo is null!!");
      return "";
    }
    String str = ((WifiInfo)localObject).getMacAddress();
    localObject = str;
    if (Build.VERSION.SDK_INT > 22) {
      if (str != null)
      {
        localObject = str;
        if (!str.equals("02:00:00:00:00:00")) {}
      }
      else
      {
        localObject = aTC();
      }
    }
    localObject = Dn((String)localObject).toLowerCase();
    y.i(paramString, "getConnectedWifiClientMac()=" + (String)localObject);
    return localObject;
  }
  
  public static void Dr(String paramString)
  {
    y.i("FreeWifi", paramString);
  }
  
  public static int E(Intent paramIntent)
  {
    return paramIntent.getIntExtra("free_wifi_channel_id", 0);
  }
  
  public static String F(Intent paramIntent)
  {
    return paramIntent.getStringExtra("free_wifi_ap_key");
  }
  
  public static String a(int paramInt1, k.b paramb, int paramInt2)
  {
    y.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[] { Integer.valueOf(paramInt1), paramb.name, Long.valueOf(paramb.knD), Integer.valueOf(paramInt2) });
    paramInt2 = Math.abs(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%03d", new Object[] { Long.valueOf(paramb.knD) }));
    if (paramInt2 <= 999) {}
    for (paramb = String.format("%03d", new Object[] { Integer.valueOf(paramInt2) });; paramb = Integer.valueOf(paramInt2)) {
      return paramb;
    }
  }
  
  public static String a(String paramString1, LinkedHashMap<String, Class> paramLinkedHashMap, i parami, String paramString2)
  {
    if (paramLinkedHashMap.size() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("\r\n");
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramLinkedHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append((String)((Map.Entry)((Iterator)localObject2).next()).getKey()).append(",");
    }
    if (((StringBuilder)localObject1).length() > 0) {
      ((StringBuilder)localObject1).delete(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length());
    }
    localObject1 = "select " + ((StringBuilder)localObject1).toString() + " from " + paramString1;
    localObject2 = paramLinkedHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      localStringBuilder.append((String)((Map.Entry)((Iterator)localObject2).next()).getKey()).append("\t");
    }
    localStringBuilder.append("\r\n");
    parami = parami.rawQuery((String)localObject1, new String[0]);
    for (;;)
    {
      int i;
      try
      {
        if (!parami.moveToNext()) {
          break;
        }
        localObject1 = paramLinkedHashMap.entrySet().iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label513;
        }
        localObject2 = (Class)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject2 != String.class) {
          continue;
        }
        localStringBuilder.append(parami.getString(i));
      }
      catch (Exception paramLinkedHashMap)
      {
        y.i(paramString2, "print " + paramString1 + "error." + paramLinkedHashMap.getMessage());
        return "";
        if (localObject2 != Long.TYPE) {
          break label421;
        }
        localStringBuilder.append(parami.getLong(i));
        continue;
      }
      finally
      {
        parami.close();
      }
      localStringBuilder.append("\t");
      i += 1;
      continue;
      label513:
      if (localObject2 == Integer.TYPE) {
        localStringBuilder.append(parami.getInt(i));
      } else {
        label421:
        if (localObject2 == Float.TYPE)
        {
          localStringBuilder.append(parami.getFloat(i));
        }
        else if (localObject2 == Double.TYPE)
        {
          localStringBuilder.append(parami.getDouble(i));
        }
        else
        {
          y.e(paramString2, "unkonwn type " + ((Class)localObject2).toString());
          localStringBuilder.append(parami.getString(i));
          continue;
          localStringBuilder.append("\r\n");
        }
      }
    }
    y.i(paramString2, localStringBuilder.toString());
    paramLinkedHashMap = localStringBuilder.toString();
    parami.close();
    return paramLinkedHashMap;
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt1, int paramInt2, m.a parama, String paramString2)
  {
    j.aUl().aTT().post(new m.2(paramString2, paramString1, paramIntent, paramInt1, paramInt2, parama));
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt1, int paramInt2, FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString2)
  {
    a(paramIntent, paramString1, paramInt1, paramInt2, new m.1(paramString2, paramFreeWifiFrontPageUI, paramInt1), paramString2);
  }
  
  public static boolean aTA()
  {
    String str = bk.bC(ae.getContext());
    return (str != null) && (str.toLowerCase().startsWith(ae.getPackageName()));
  }
  
  public static String aTB()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static String aTC()
  {
    long l = System.currentTimeMillis();
    try
    {
      if (NetworkInterface.getNetworkInterfaces() != null)
      {
        Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
          {
            localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
            if (localObject1 == null)
            {
              y.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
              return "02:00:00:00:00:00";
            }
            localObject2 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
              i += 1;
            }
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            }
            y.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
            localObject1 = ((StringBuilder)localObject2).toString();
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + localException);
      y.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
    }
    return "02:00:00:00:00:00";
  }
  
  public static int aTD()
  {
    Object localObject = l.WP();
    if ((localObject == l.a.ffR) || (localObject == l.a.ffS)) {
      return 1;
    }
    au.Hx();
    localObject = (String)com.tencent.mm.model.c.Dz().get(6, null);
    if (isEmpty((String)localObject)) {
      return 1;
    }
    if (((String)localObject).startsWith("+")) {}
    for (localObject = ar.Ga((String)localObject); "86".equals(localObject); localObject = "86") {
      return 2;
    }
    return 3;
  }
  
  public static boolean aTE()
  {
    if (((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      y.i("TAG", "isWifiConnected()=true");
      return true;
    }
    y.i("TAG", "isWifiConnected()=false");
    return false;
  }
  
  public static ty aTF()
  {
    ty localty = new ty();
    localty.deviceBrand = com.tencent.mm.protocal.d.soU;
    if ((d.kmy != null) && (!d.kmy.equals(""))) {}
    for (localty.sQM = d.kmy;; localty.sQM = Dq("MicroMsg.FreeWifi.Utils"))
    {
      localty.deviceModel = com.tencent.mm.protocal.d.soV;
      localty.osName = com.tencent.mm.protocal.d.soX;
      localty.osVersion = com.tencent.mm.protocal.d.soY;
      return localty;
    }
  }
  
  public static boolean cR(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  public static boolean cS(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 <= -30000) && (paramInt2 > -31000);
  }
  
  public static void d(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("free_wifi_sessionkey", paramString);
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
  }
  
  private static boolean dd(String paramString1, String paramString2)
  {
    int i = bk.getInt(paramString1, 0);
    int j = bk.getInt(paramString2, 0);
    if ((i == 0) && (j != 0) && (com.tencent.mm.protocal.d.spa <= j)) {}
    while (((i != 0) && (j == 0) && (com.tencent.mm.protocal.d.spa >= i)) || ((i != 0) && (j != 0) && (com.tencent.mm.protocal.d.spa >= i) && (com.tencent.mm.protocal.d.spa <= j))) {
      return true;
    }
    return false;
  }
  
  public static void dl(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BindMContactUI.class);
    localIntent.putExtra("is_bind_for_safe_device", false);
    localIntent.putExtra("is_bind_for_change_mobile", false);
    Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    if (!bk.bl((String)localObject))
    {
      localObject = b.i(paramContext, (String)localObject, paramContext.getString(R.l.country_code));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).esg);
        localIntent.putExtra("couttry_code", ((b.a)localObject).esf);
      }
    }
    MMWizardActivity.C(paramContext, localIntent);
  }
  
  public static String f(Exception paramException)
  {
    Object localObject = new StringWriter();
    paramException.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = Dn(((StringWriter)localObject).toString());
    paramException = (Exception)localObject;
    if (((String)localObject).length() > 1024) {
      paramException = ((String)localObject).substring(0, 1024);
    }
    return paramException;
  }
  
  public static String g(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return Dn(localStringWriter.toString());
  }
  
  public static int h(Exception paramException)
  {
    int i = 101;
    if ((paramException instanceof SocketTimeoutException))
    {
      paramException = g(paramException);
      if (paramException.indexOf(".read") != -1) {
        i = 105;
      }
    }
    do
    {
      do
      {
        return i;
      } while (paramException.indexOf(".connect") == -1);
      return 104;
      if ((paramException instanceof ConnectException)) {
        return 106;
      }
    } while (!(paramException instanceof UnknownHostException));
    return 102;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean k(Map<String, String> paramMap, String paramString)
  {
    boolean bool2 = true;
    y.i(paramString, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.spa);
    String str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$minInclude");
    String str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$maxInclude");
    y.i(paramString, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[] { str1, str2 });
    boolean bool1;
    if ((isEmpty(str1)) && (isEmpty(str2))) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (dd(str1, str2));
    int i = 1;
    for (;;)
    {
      str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
      str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
      y.i(paramString, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[] { str1, str2 });
      if ((isEmpty(str1)) && (isEmpty(str2))) {
        break label265;
      }
      bool1 = bool2;
      if (dd(str1, str2)) {
        break;
      }
      i += 1;
    }
    label265:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m
 * JD-Core Version:    0.7.0.1
 */