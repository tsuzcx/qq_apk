package com.tencent.mars.ilink.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Method;

public class NetStatusUtil
{
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  private static final String TAG = "MicroMsg.NetStatusUtil";
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int UNKNOW_TYPE = 999;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  private static int nowStrength = 0;
  private byte _hellAccFlag_;
  
  public static void dumpNetStatus(Context paramContext)
  {
    try
    {
      Log.i("MicroMsg.NetStatusUtil", ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().toString());
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.NetStatusUtil", "", new Object[] { paramContext });
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0) {
          return 1;
        }
      }
      catch (Exception localException) {}
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        return 0;
      }
      if ((i == 1) || (i == 0)) {
        return 3;
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5)) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      int j = paramContext.length();
      int i = j;
      if (j > 6) {
        i = 6;
      }
      for (;;)
      {
        if (j < i) {
          if (!Character.isDigit(paramContext.charAt(j)))
          {
            if (localStringBuilder.length() <= 0) {
              break label119;
            }
          }
          else
          {
            localStringBuilder.append(paramContext.charAt(j));
            break label119;
          }
        }
        i = Integer.valueOf(localStringBuilder.toString()).intValue();
        return i;
        j = 0;
        continue;
        label119:
        j += 1;
      }
      return 0;
    }
    catch (Exception paramContext) {}
  }
  
  public static String getISPName(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    if (paramContext.getSimOperatorName().length() <= 100) {
      return paramContext.getSimOperatorName();
    }
    return paramContext.getSimOperatorName().substring(0, 100);
  }
  
  public static int getNetType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    if (paramContext == null) {
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 999;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      int i = paramContext.getSubtype();
      if (i == 0) {
        return 999;
      }
      return i * 1000;
    }
    catch (Exception paramContext) {}
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    if (paramContext.getExtraInfo() != null) {
      return paramContext.getExtraInfo();
    }
    return "MOBILE";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
      int j = 80;
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = Integer.parseInt(str);
        }
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int getStrength(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      if (getNetTypeForStat(paramContext) == 1) {
        return Math.abs(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi());
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Object localObject = new StrengthListener();
      localObject = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/ilink/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      int i = Math.abs(nowStrength);
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (1 == ((NetworkInfo)localObject).getType()))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return null;
        }
        paramContext = paramContext.getConnectionInfo();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return 102400;
      }
      int i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      label104:
      break label104;
    }
    return 102400;
    return 4096;
    return 8192;
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        int i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() >= 5)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    try
    {
      boolean bool = paramContext.isConnected();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    int i = getNetType(paramContext);
    return (6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0);
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    try
    {
      int i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      return i != 1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return paramContext.getState() == NetworkInfo.State.CONNECTED;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    return isWap(getNetType(paramContext));
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return isWifi(getNetType(paramContext));
  }
  
  /* Error */
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 369	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore 5
    //   6: aload 5
    //   8: iconst_0
    //   9: invokevirtual 375	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +269 -> 285
    //   19: aload 6
    //   21: invokeinterface 380 1 0
    //   26: ifle +259 -> 285
    //   29: iconst_0
    //   30: istore_2
    //   31: aload 6
    //   33: invokeinterface 380 1 0
    //   38: istore_3
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge +244 -> 285
    //   44: new 382	android/content/Intent
    //   47: dup
    //   48: invokespecial 383	android/content/Intent:<init>	()V
    //   51: astore 7
    //   53: aload 7
    //   55: aload 6
    //   57: iload_2
    //   58: invokeinterface 386 2 0
    //   63: checkcast 388	android/content/pm/PackageInfo
    //   66: getfield 391	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   69: invokevirtual 395	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   72: pop
    //   73: aload 5
    //   75: aload 7
    //   77: iconst_0
    //   78: invokevirtual 399	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   81: astore 8
    //   83: aload 8
    //   85: ifnull +176 -> 261
    //   88: aload 8
    //   90: invokeinterface 380 1 0
    //   95: istore_3
    //   96: iload_3
    //   97: ifle +180 -> 277
    //   100: iconst_0
    //   101: istore 4
    //   103: iload 4
    //   105: iload_3
    //   106: if_icmpge +171 -> 277
    //   109: aload 8
    //   111: iload 4
    //   113: invokeinterface 386 2 0
    //   118: checkcast 401	android/content/pm/ResolveInfo
    //   121: getfield 405	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   124: astore 7
    //   126: aload 7
    //   128: getfield 410	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   131: aload_1
    //   132: invokevirtual 414	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifeq +131 -> 266
    //   138: new 382	android/content/Intent
    //   141: dup
    //   142: ldc_w 416
    //   145: invokespecial 419	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   148: astore 8
    //   150: aload 8
    //   152: new 421	android/content/ComponentName
    //   155: dup
    //   156: aload 7
    //   158: getfield 422	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   161: aload 7
    //   163: getfield 410	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   166: invokespecial 424	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: invokevirtual 428	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   172: pop
    //   173: aload 8
    //   175: ldc_w 430
    //   178: invokevirtual 433	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   181: pop
    //   182: new 275	com/tencent/mm/hellhoundlib/b/a
    //   185: dup
    //   186: invokespecial 276	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   189: aload 8
    //   191: invokevirtual 286	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   194: astore 7
    //   196: aload_0
    //   197: aload 7
    //   199: invokevirtual 290	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   202: ldc_w 291
    //   205: ldc_w 434
    //   208: ldc_w 435
    //   211: ldc_w 437
    //   214: ldc_w 439
    //   217: ldc_w 441
    //   220: invokestatic 304	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload 7
    //   226: iconst_0
    //   227: invokevirtual 308	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   230: checkcast 382	android/content/Intent
    //   233: invokevirtual 443	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   236: aload_0
    //   237: ldc_w 291
    //   240: ldc_w 434
    //   243: ldc_w 435
    //   246: ldc_w 437
    //   249: ldc_w 439
    //   252: ldc_w 441
    //   255: invokestatic 315	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 8
    //   260: areturn
    //   261: iconst_0
    //   262: istore_3
    //   263: goto -167 -> 96
    //   266: iload 4
    //   268: iconst_1
    //   269: iadd
    //   270: istore 4
    //   272: goto -169 -> 103
    //   275: astore 7
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -250 -> 31
    //   284: astore_0
    //   285: aconst_null
    //   286: areturn
    //   287: astore 7
    //   289: goto -12 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramContext	Context
    //   0	292	1	paramString	String
    //   30	251	2	i	int
    //   38	225	3	j	int
    //   101	170	4	k	int
    //   4	70	5	localPackageManager	android.content.pm.PackageManager
    //   12	44	6	localList	java.util.List
    //   51	174	7	localObject1	Object
    //   275	1	7	localException1	Exception
    //   287	1	7	localException2	Exception
    //   81	178	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	83	275	java/lang/Exception
    //   88	96	275	java/lang/Exception
    //   0	14	284	java/lang/Exception
    //   19	29	284	java/lang/Exception
    //   31	39	284	java/lang/Exception
    //   109	258	287	java/lang/Exception
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 2: 
      try
      {
        Object localObject1 = new Intent("/");
        ((Intent)localObject1).setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        ((Intent)localObject1).setAction("android.intent.action.VIEW");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = new Intent("/");
          ((Intent)localObject2).setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          return;
        }
      }
    case 1: 
      try
      {
        Object localObject3 = new Intent("/");
        ((Intent)localObject3).setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        ((Intent)localObject3).setAction("android.intent.action.VIEW");
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        return;
      }
    }
    try
    {
      Object localObject4 = new Intent();
      ((Intent)localObject4).setAction("android.settings.WIFI_IP_SETTINGS");
      localObject4 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject4);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    catch (Exception localException4)
    {
      searchIntentByClass(paramContext, "AdvancedSettings");
    }
  }
  
  public static class StrengthListener
    extends PhoneStateListener
  {
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      if (!paramSignalStrength.isGsm())
      {
        NetStatusUtil.access$002(paramSignalStrength.getCdmaDbm());
        return;
      }
      NetStatusUtil.access$002(paramSignalStrength.getGsmSignalStrength());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */