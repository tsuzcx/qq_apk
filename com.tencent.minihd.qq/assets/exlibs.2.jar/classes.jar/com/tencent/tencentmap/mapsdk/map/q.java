package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.tencentmap.mapsdk.a.c;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class q
{
  public static a a = a.c;
  public static Date b = null;
  public static HashMap<String, String> c = new HashMap();
  public static boolean d = false;
  public static String e = null;
  private static float f = 1.0F;
  private static String g = null;
  private static String h = null;
  private static String i = null;
  private static String j = null;
  private static String k = null;
  private static String l = null;
  private static int m = 0;
  private static String n = null;
  private static String o = null;
  
  public static double a(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    double d1 = paramLong2 / (paramLong1 - 1L);
    d1 *= d1;
    return (1.0D - d1 * d1) * (paramDouble1 - paramDouble2) + paramDouble2;
  }
  
  public static final Bitmap a(Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getAssets();
    Object localObject1 = null;
    paramContext = localObject1;
    try
    {
      localObject2 = ((AssetManager)localObject2).open("tencentmap/mapsdk/" + paramString);
      paramContext = localObject1;
      paramString = BitmapFactory.decodeStream((InputStream)localObject2);
      paramContext = paramString;
      ((InputStream)localObject2).close();
      paramContext = paramString;
    }
    catch (OutOfMemoryError paramContext)
    {
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return paramContext;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 66	com/tencent/tencentmap/mapsdk/map/q:c	Ljava/util/HashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 66	com/tencent/tencentmap/mapsdk/map/q:c	Ljava/util/HashMap;
    //   21: aload_0
    //   22: invokevirtual 121	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 123	java/lang/String
    //   28: astore_0
    //   29: goto -16 -> 13
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramString	String
    //   6	2	1	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	7	32	finally
    //   18	29	32	finally
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i1] & 0xFF)).append(paramString);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      n = Build.MODEL;
      n = d(n);
      n = URLEncoder.encode(n, "utf-8");
      label32:
      if (m == 0) {
        m = Build.VERSION.SDK_INT;
      }
      if (l == null) {}
      try
      {
        l = paramContext.getPackageName();
        l = d(l);
        l = URLEncoder.encode(l, "utf-8");
        label77:
        if (i == null) {}
        try
        {
          i = h(paramContext);
          i = d(i);
          i = URLEncoder.encode(i, "utf-8");
          label110:
          if (j == null) {}
          try
          {
            j = g(paramContext);
            j = d(j);
            j = URLEncoder.encode(j, "utf-8");
            label143:
            if (k == null) {}
            try
            {
              k = s.a(paramContext);
              k = d(k);
              k = URLEncoder.encode(k, "utf-8");
              label176:
              if (h == null) {}
              try
              {
                h = e(paramContext);
                h = c(h);
                h = URLEncoder.encode(h, "utf-8");
                label209:
                if (g == null) {}
                try
                {
                  g = f(paramContext);
                  g = d(g);
                  g = URLEncoder.encode(g, "utf-8");
                  label242:
                  if (e == null) {}
                  try
                  {
                    e = d(paramContext);
                    e = URLEncoder.encode(e, "utf-8");
                    label266:
                    if (o == null) {}
                    try
                    {
                      o = d();
                      o = URLEncoder.encode(o, "utf-8");
                      return;
                    }
                    catch (Exception paramContext) {}
                  }
                  catch (Exception paramContext)
                  {
                    break label266;
                  }
                }
                catch (Exception localException1)
                {
                  break label242;
                }
              }
              catch (Exception localException2)
              {
                break label209;
              }
            }
            catch (Exception localException3)
            {
              break label176;
            }
          }
          catch (Exception localException4)
          {
            break label143;
          }
        }
        catch (Exception localException5)
        {
          break label110;
        }
      }
      catch (Exception localException6)
      {
        break label77;
      }
    }
    catch (Exception localException7)
    {
      break label32;
    }
  }
  
  public static void a(Canvas paramCanvas, Bitmap paramBitmap, RectF paramRectF)
  {
    if ((paramCanvas == null) || (paramBitmap == null)) {
      return;
    }
    paramCanvas.drawBitmap(paramBitmap, null, paramRectF, null);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      if (c == null) {
        c = new HashMap();
      }
      if (c.containsKey(paramString1)) {
        c.remove(paramString1);
      }
      c.put(paramString1, paramString2);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return f > 1.0F;
  }
  
  public static boolean a(f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = new f(c());
    }
    localObject = ((f)localObject).c();
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = Boolean.valueOf(false);
    }
    return paramf.booleanValue();
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = a(((MessageDigest)localObject).digest(), "");
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  static Date b()
  {
    return Calendar.getInstance().getTime();
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        c.a().a(paramContext);
      }
      finally {}
    }
  }
  
  static String c()
  {
    return String.format("http://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsc=%s&mac=%s&nt=%s&suid=%s&ver=%s", new Object[] { e, i, "androidsdk", j, l, Integer.valueOf(m), n, g, h, k, o, "1.0.13" });
  }
  
  private static String c(String paramString)
    throws PatternSyntaxException
  {
    return Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
  }
  
  static void c(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    f = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private static String d()
  {
    return b(String.format("key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsc=%s&mac=%s", new Object[] { e, i, "androidsdk", j, l, Integer.valueOf(m), n, g, h }));
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
      if (paramContext.metaData == null) {
        return "";
      }
    }
    return paramContext.metaData.getString("TencentMapSDK");
  }
  
  private static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("&", "").replace("#", "").replace("?", "");
  }
  
  private static String e(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null) {
        return "";
      }
      str = paramContext.getMacAddress();
      paramContext = str;
    } while (str != null);
    return "";
  }
  
  private static String f(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getSubscriberId();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private static String g(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getDeviceId();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private static String h(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext.loadLabel(localPackageManager).toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.q
 * JD-Core Version:    0.7.0.1
 */