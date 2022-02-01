package com.tencent.common.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import java.io.InputStream;
import java.lang.reflect.Method;

public class AppSetting
{
  private static final String A = "V3";
  private static String B;
  private static final String C = "N";
  private static String D;
  public static int a = 537067382;
  public static final String a = "3468";
  public static final boolean a = true;
  public static int b = 0;
  public static final String b = "130";
  public static final boolean b = false;
  public static int c = 0;
  public static final String c = "1411F8F6E5D453F9";
  public static final boolean c = true;
  public static int d = 0;
  public static final String d = "2cb8ec";
  public static final boolean d = false;
  public static int e = 1000;
  public static final String e = "AQQ_2013 4.6";
  public static final boolean e = true;
  public static int f = e + 1;
  public static final String f = "2013";
  public static final boolean f = false;
  public static final String g = "5.9.3";
  public static boolean g = false;
  public static final String h = "5.6.0";
  public static final boolean h = true;
  public static final String i = "QQ/5.2";
  public static final boolean i = true;
  public static final String j = "V 5.9.3.3468";
  public static boolean j = false;
  public static final String k = "5.9.3.3468";
  public static boolean k = false;
  public static final String l = "5.9.3.3468.2021-11-21.r2cb8ec.YingYongBao";
  public static final boolean l = true;
  public static final String m = "2013 5.9.3";
  public static boolean m = false;
  public static final String n = "2013 5.9.33468";
  public static boolean n = false;
  public static final String o = "2002";
  public static boolean o = false;
  public static String p;
  public static final String q = "enable_ptt_roam";
  public static final String r = "c2c_del_msg_oper_enable";
  public static final String s = "flashlogo.png";
  public static final String t = "birthdayflashlogo.png";
  public static final String u = "android";
  private static final String v = "NA_0";
  private static final String w = "000000";
  private static final String x = "ADR";
  private static final String y = "18";
  private static final String z = Build.VERSION.RELEASE;
  
  static
  {
    g = false;
    j = false;
    d = 1048576;
    k = true;
    p = "use_msg_reflesh_delay";
    m = true;
    n = true;
    o = true;
  }
  
  public static final int a()
  {
    return a;
  }
  
  @TargetApi(10)
  private static int a(Context paramContext)
  {
    if (paramContext == null) {}
    while ((Build.VERSION.SDK_INT < 10) || (NfcAdapter.getDefaultAdapter(paramContext) == null)) {
      return 0;
    }
    return 1;
  }
  
  public static final String a()
  {
    return "1411F8F6E5D453F9";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    localObject2 = "";
    long l1 = DeviceInfoUtil.c() / 1048576L;
    int i1 = a(paramContext);
    localObject1 = localObject2;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = localObject2;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = localObject2;
      paramContext = QQDeviceInfo.a("master");
      localObject1 = paramContext;
      localObject2 = a(localTelephonyManager, localConnectivityManager);
      localObject1 = localObject2;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "//";
        localObject2 = localObject1;
      }
    }
    localStringBuffer.append((String)localObject2 + "/");
    localStringBuffer.append("2002/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(a + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(a(Build.MODEL) + "/");
    localStringBuffer.append(a(Build.BRAND) + "/");
    localStringBuffer.append(l1 + "/");
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(i1 + "/");
    return localStringBuffer.toString();
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      return "//";
    }
    String str3 = "";
    String str5 = "";
    String str4 = "";
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    String str1 = str4;
    paramConnectivityManager = str5;
    String str2 = str3;
    if (localNetworkInfo != null)
    {
      str1 = str4;
      paramConnectivityManager = str5;
      str2 = str3;
      if (localNetworkInfo.isAvailable()) {
        switch (localNetworkInfo.getType())
        {
        case 7: 
        case 8: 
        default: 
          paramConnectivityManager = "unknown";
          str1 = "unknown";
          str2 = str3;
        }
      }
    }
    for (;;)
    {
      return paramConnectivityManager + "/" + str2 + "/" + str1;
      paramConnectivityManager = "cable";
      str1 = str4;
      str2 = str3;
      continue;
      paramConnectivityManager = "WIFI";
      str1 = str4;
      str2 = str3;
      continue;
      str2 = a(paramTelephonyManager.getNetworkOperatorName());
      switch (paramTelephonyManager.getNetworkType())
      {
      default: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
        break;
      case 13: 
        paramConnectivityManager = "4G";
        str1 = "LTE";
        break;
      case 3: 
        paramConnectivityManager = "3G";
        str1 = "UMTS";
        break;
      case 5: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_0";
        break;
      case 6: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_A";
        break;
      case 8: 
        paramConnectivityManager = "3G";
        str1 = "SDPA";
        break;
      case 9: 
        paramConnectivityManager = "3G";
        str1 = "HSUPA";
        break;
      case 10: 
        paramConnectivityManager = "3G";
        str1 = "HSPA";
        break;
      case 12: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_B";
        break;
      case 14: 
        paramConnectivityManager = "3G";
        str1 = "EHRPD";
        break;
      case 15: 
        paramConnectivityManager = "3G";
        str1 = "HSPAP";
        break;
      case 1: 
        paramConnectivityManager = "2G";
        str1 = "GPRS";
        break;
      case 2: 
        paramConnectivityManager = "2G";
        str1 = "EDGE";
        break;
      case 4: 
        paramConnectivityManager = "2G";
        str1 = "CDMA";
        break;
      case 7: 
        paramConnectivityManager = "2G";
        str1 = "1xRTT";
        break;
      case 11: 
        paramConnectivityManager = "2G";
        str1 = "IDEN";
        break;
      case 0: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i1));
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext.getResources().getDisplayMetrics().widthPixels;
    c = paramContext.getResources().getDisplayMetrics().heightPixels;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      int i1 = b;
      b = c;
      c = i1;
    }
    D = "" + b / 16 + c / 16;
  }
  
  public static final String b()
  {
    if (B != null) {
      return B;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label296;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < localObject2.length)
      {
        if ((localObject2[i1] > ' ') && (localObject2[i1] != '/') && (localObject2[i1] != '_') && (localObject2[i1] != '&') && (localObject2[i1] != '|') && (localObject2[i1] != '-')) {
          localStringBuffer.append(localObject2[i1]);
        }
        i1 += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      B = "AQQ_2013 4.6/2013 5.9.33468&NA_0/000000&ADR&" + D + "18" + "&" + (String)localObject2 + "&" + "2002" + "&" + "1411F8F6E5D453F9" + "&" + z + "&" + "V3";
      return B;
      label296:
      str2 = "ALL";
    }
  }
  
  public static String c()
  {
    return "2013 5.9.3";
  }
  
  public static final String d()
  {
    return "android 5.9.3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */