package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class f
{
  protected static final String a = f.class.getSimpleName();
  protected static f b = null;
  protected static int e = 0;
  protected Context c;
  public String d = "";
  public final int f = 0;
  public final int g = 1;
  public final int h = 2;
  public final int i = 3;
  public final int j = 4;
  public final int k = 5;
  public HashMap l = null;
  
  protected f()
  {
    this.l.put(Integer.valueOf(1), "ReportLog");
    this.l.put(Integer.valueOf(2), "GetSettings");
    this.l.put(Integer.valueOf(3), "GetAppUpdate");
    this.l.put(Integer.valueOf(4), "GetAuthorized");
    this.l.put(Integer.valueOf(5), "GetAppSimpleDetail");
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static f a()
  {
    try
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
    case -21: 
      return 700;
    case -22: 
      return 732;
    case -23: 
      return 601;
    case -25: 
      return 602;
    case -27: 
      return 606;
    }
    return 701;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    int m = 0;
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      while (m < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[m] & 0xFF));
        m += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static int c(Context paramContext)
  {
    int m = 0;
    PackageManager localPackageManager;
    if (paramContext != null) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      m = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return m;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static ArrayList c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int m = 0;
      while (m < paramString.length)
      {
        CharSequence localCharSequence = paramString[m];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        m += 1;
      }
    }
    return localArrayList;
  }
  
  public static void d(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int i()
  {
    try
    {
      int m = e;
      e = m + 1;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 213	com/tencent/tmassistantbase/a/f:a	()Lcom/tencent/tmassistantbase/a/f;
    //   6: invokevirtual 216	com/tencent/tmassistantbase/a/f:b	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 41
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc 218
    //   25: invokevirtual 222	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   28: ifeq +16 -> 44
    //   31: ldc 41
    //   33: astore_0
    //   34: goto -17 -> 17
    //   37: astore_0
    //   38: ldc 41
    //   40: astore_0
    //   41: goto -24 -> 17
    //   44: aload_0
    //   45: ldc 224
    //   47: invokevirtual 228	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   50: checkcast 230	android/net/ConnectivityManager
    //   53: invokevirtual 234	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +9 -> 67
    //   61: ldc 41
    //   63: astore_0
    //   64: goto -47 -> 17
    //   67: aload_0
    //   68: invokevirtual 239	android/net/NetworkInfo:getType	()I
    //   71: iconst_1
    //   72: if_icmpne +9 -> 81
    //   75: ldc 241
    //   77: astore_0
    //   78: goto -61 -> 17
    //   81: aload_0
    //   82: invokevirtual 244	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnonnull +9 -> 96
    //   90: ldc 41
    //   92: astore_0
    //   93: goto -76 -> 17
    //   96: aload_0
    //   97: invokevirtual 247	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   100: astore_0
    //   101: getstatic 31	com/tencent/tmassistantbase/a/f:a	Ljava/lang/String;
    //   104: new 184	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   111: ldc 249
    //   113: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 254	com/tencent/tmassistantbase/a/k:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -109 -> 17
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	25	0	localObject1	Object
    //   37	1	0	localException	Exception
    //   40	77	0	localObject2	Object
    //   129	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	37	java/lang/Exception
    //   3	10	129	finally
    //   22	31	129	finally
    //   44	57	129	finally
    //   67	75	129	finally
    //   81	86	129	finally
    //   96	126	129	finally
  }
  
  public static boolean n()
  {
    Object localObject = a().b();
    if (localObject == null)
    {
      k.d(a, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject != null) {}
    for (boolean bool = ((NetworkInfo)localObject).isAvailable();; bool = false) {
      return bool;
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = paramContext;
    this.d = new j(paramContext).a();
    k.a(paramContext);
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (paramString == null);
      localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
  
  public Context b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.c = null;
    b = null;
  }
  
  public String d()
  {
    if (this.c == null) {
      return null;
    }
    return Settings.Secure.getString(b().getContentResolver(), "android_id");
  }
  
  public String e()
  {
    if (this.c == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public String f()
  {
    if (this.c == null) {
      return null;
    }
    return ((TelephonyManager)b().getSystemService("phone")).getDeviceId();
  }
  
  public String g()
  {
    if (this.c == null) {
      return null;
    }
    return ((TelephonyManager)b().getSystemService("phone")).getSubscriberId();
  }
  
  public String h()
  {
    if (this.c == null) {
      return null;
    }
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)b().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null) {
        return localWifiInfo.getMacAddress();
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public boolean j()
  {
    return "wifi".equals(m());
  }
  
  public int k()
  {
    if (this.c == null) {
      k.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      k.c("SelfUpdateSDK", "getQQDownloaderAPILevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.c.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        k.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int m = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          k.c("SelfUpdateSDK", "apiLevel:" + m);
          return m;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public int l()
  {
    if (this.c == null) {}
    for (;;)
    {
      return 0;
      Object localObject = this.c.getPackageManager();
      if (localObject != null) {
        try
        {
          localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
          if (localObject != null)
          {
            int m = ((PackageInfo)localObject).versionCode;
            return m;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.f
 * JD-Core Version:    0.7.0.1
 */