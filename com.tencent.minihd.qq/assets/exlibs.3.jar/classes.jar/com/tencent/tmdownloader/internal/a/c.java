package com.tencent.tmdownloader.internal.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.b.b;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class c
{
  public static final String a = c.class.getSimpleName();
  
  public static PowerManager.WakeLock a()
  {
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = paramString.replace("\r", "").replace("\n", "").trim();
    String str1 = new String(paramString);
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str2 = localUri.getLastPathSegment();
      paramString = str1;
      if (str2 != null)
      {
        paramString = str1;
        if (str2.length() > 0) {
          paramString = str1.replace(str2, URLEncoder.encode(localUri.getLastPathSegment()).replace("+", "%20"));
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      k.b(a, "exception: ", paramString);
    }
    return str1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = f.b(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Integer.toString(Math.abs(paramString1.hashCode()));
    }
    str2 = "";
    paramString1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!paramString2.equals("application/vnd.android.package-archive")) {
        break label68;
      }
      paramString1 = ".apk";
    }
    for (;;)
    {
      return str1 + paramString1;
      label68:
      if (paramString2.equals("application/tm.android.apkdiff"))
      {
        paramString1 = ".diff";
      }
      else
      {
        paramString1 = str2;
        if (paramString2.equals("resource/tm.android.unknown")) {
          paramString1 = ".other";
        }
      }
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    boolean bool = true;
    long l2 = 0L;
    long l1 = -1L;
    int i = h(paramString);
    long l3;
    if (i == 1)
    {
      paramString = new StatFs(Environment.getDataDirectory().getPath());
      l1 = paramString.getBlockSize();
      l3 = (paramString.getAvailableBlocks() - 4L) * l1;
      l1 = l3;
      if (l3 >= 0L) {
        break label175;
      }
      l1 = l2;
    }
    label175:
    for (;;)
    {
      paramLong = ((float)paramLong * 1.5F);
      if (paramLong <= 104857600L) {
        break label180;
      }
      if (l1 < paramLong) {
        break;
      }
      return true;
      if (i == 2)
      {
        l1 = l2;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          paramString = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
          l1 = paramString.getBlockSize();
          l3 = (paramString.getAvailableBlocks() - 4L) * l1;
          l1 = l2;
          if (l3 >= 0L) {
            l1 = l3;
          }
        }
      }
    }
    return false;
    label180:
    if (l1 >= 104857600L) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 170	com/tencent/tmassistantbase/a/f:a	()Lcom/tencent/tmassistantbase/a/f;
    //   6: invokevirtual 173	com/tencent/tmassistantbase/a/f:b	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 28
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc 175
    //   25: invokevirtual 180	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   28: ifeq +25 -> 53
    //   31: ldc 28
    //   33: astore_0
    //   34: goto -17 -> 17
    //   37: astore_0
    //   38: getstatic 16	com/tencent/tmdownloader/internal/a/c:a	Ljava/lang/String;
    //   41: ldc 69
    //   43: aload_0
    //   44: invokestatic 75	com/tencent/tmassistantbase/a/k:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: ldc 28
    //   49: astore_0
    //   50: goto -33 -> 17
    //   53: aload_0
    //   54: ldc 182
    //   56: invokevirtual 186	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   59: checkcast 188	android/net/ConnectivityManager
    //   62: invokevirtual 192	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnonnull +9 -> 76
    //   70: ldc 28
    //   72: astore_0
    //   73: goto -56 -> 17
    //   76: aload_0
    //   77: invokevirtual 197	android/net/NetworkInfo:getType	()I
    //   80: iconst_1
    //   81: if_icmpne +9 -> 90
    //   84: ldc 199
    //   86: astore_0
    //   87: goto -70 -> 17
    //   90: aload_0
    //   91: invokevirtual 202	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   94: astore_0
    //   95: aload_0
    //   96: ifnonnull +9 -> 105
    //   99: ldc 28
    //   101: astore_0
    //   102: goto -85 -> 17
    //   105: aload_0
    //   106: invokevirtual 205	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   109: astore_0
    //   110: getstatic 16	com/tencent/tmdownloader/internal/a/c:a	Ljava/lang/String;
    //   113: new 111	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   120: ldc 207
    //   122: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 210	com/tencent/tmassistantbase/a/k:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -118 -> 17
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	25	0	localObject1	Object
    //   37	7	0	localException	Exception
    //   49	77	0	localObject2	Object
    //   138	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	37	java/lang/Exception
    //   3	10	138	finally
    //   22	31	138	finally
    //   38	47	138	finally
    //   53	66	138	finally
    //   76	84	138	finally
    //   90	95	138	finally
    //   105	135	138	finally
  }
  
  public static String b(String paramString)
  {
    if (paramString.contains(".apk"))
    {
      String str = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      paramString = str;
      if (str.contains("?")) {
        paramString = str.substring(0, str.lastIndexOf("?"));
      }
      if (!TextUtils.isEmpty(paramString))
      {
        k.c(a, "file name = " + paramString);
        return e(paramString);
      }
    }
    return null;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = new File(b.b(a(paramString1, paramString2))).exists();
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      k.b(a, "exception: ", paramString1);
      paramString1.printStackTrace();
      return false;
    }
    finally {}
  }
  
  public static String c(String paramString)
  {
    if (paramString != null) {
      return URLDecoder.decode(paramString);
    }
    return null;
  }
  
  public static boolean c()
  {
    Object localObject = f.a().b();
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
  
  public static String d(String paramString)
  {
    return paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1)) {
      return paramString;
    }
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString.substring(0, i);
    arrayOfString[1] = paramString.substring(i, paramString.length());
    i = 0;
    if (i == 0) {}
    for (String str = paramString;; str = arrayOfString[0] + "(" + i + ")" + arrayOfString[1])
    {
      int j = i + 1;
      File localFile = new File(b.e() + File.separator + str);
      i = j;
      if (localFile == null) {
        break;
      }
      i = j;
      if (localFile.exists()) {
        break;
      }
      return str;
    }
  }
  
  public static boolean f(String paramString)
  {
    try
    {
      new URI(a(paramString));
      return true;
    }
    catch (Throwable paramString)
    {
      k.b(a, "exception: ", paramString);
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new File(b.b(paramString)).exists();
        if (!bool) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        k.b(a, "exception: ", paramString);
        paramString.printStackTrace();
        return false;
      }
      finally {}
    }
  }
  
  public static int h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if ((paramString != null) && (paramString.contains("/data/data"))) {
        return 1;
      }
    } while (!b.g());
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.c
 * JD-Core Version:    0.7.0.1
 */