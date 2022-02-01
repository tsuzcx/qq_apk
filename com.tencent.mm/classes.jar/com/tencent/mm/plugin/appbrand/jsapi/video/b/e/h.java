package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
{
  private static final AtomicInteger Qu;
  public static final int SDK_INT;
  private static String ltw;
  public static HashMap<String, String> ltx;
  private static HashMap<String, Boolean> lty;
  
  static
  {
    AppMethodBeat.i(211213);
    SDK_INT = Build.VERSION.SDK_INT;
    ltw = "<html";
    ltx = new HashMap();
    Qu = new AtomicInteger(1);
    lty = new HashMap();
    AppMethodBeat.o(211213);
  }
  
  public static long B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(211192);
    int i = -2;
    String[] arrayOfString = boC();
    if (arrayOfString != null)
    {
      i = -3;
      a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    long l = i * 100000000;
    AppMethodBeat.o(211192);
    return l + 100000L * paramLong1 + paramLong2;
  }
  
  public static long C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(211193);
    int i = -2;
    String[] arrayOfString = boC();
    if (arrayOfString != null)
    {
      i = -3;
      a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    paramLong1 = (paramLong1 - paramLong2 - i * 100000000) / 100000L;
    AppMethodBeat.o(211193);
    return paramLong1;
  }
  
  public static long R(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(211191);
    if (paramMap != null)
    {
      long l = bv((List)paramMap.get("x-server-error"));
      if ((l != -1L) && (l != 0L))
      {
        AppMethodBeat.o(211191);
        return l;
      }
      l = bv((List)paramMap.get("x-proxy-error"));
      if (l != -1L)
      {
        AppMethodBeat.o(211191);
        return l - 20000L;
      }
      l = bv((List)paramMap.get("error"));
      if (l != -1L)
      {
        AppMethodBeat.o(211191);
        return l;
      }
    }
    AppMethodBeat.o(211191);
    return -99999L;
  }
  
  public static long RC(String paramString)
  {
    AppMethodBeat.i(211184);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211184);
      return -1L;
    }
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getBlockSize();
      int i = paramString.getAvailableBlocks();
      long l2 = i;
      AppMethodBeat.o(211184);
      return l2 * l1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(211184);
    }
    return -1L;
  }
  
  public static long RD(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(211185);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211185);
      return 0L;
    }
    paramString = new k(paramString);
    if (paramString.isFile())
    {
      l1 = paramString.length();
      AppMethodBeat.o(211185);
      return l1;
    }
    paramString = paramString.fTj();
    long l2 = l1;
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        Object localObject = paramString[i];
        l2 = l1;
        if (localObject != null) {
          l2 = l1 + RD(w.B(localObject.fTh()));
        }
        i += 1;
        l1 = l2;
      }
    }
    AppMethodBeat.o(211185);
    return l2;
  }
  
  private static List<String> RE(String paramString)
  {
    AppMethodBeat.i(211186);
    ArrayList localArrayList = new ArrayList((paramString.length() + 1000 - 1) / 1000);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + 1000)));
      i += 1000;
    }
    AppMethodBeat.o(211186);
    return localArrayList;
  }
  
  public static String RF(String paramString)
  {
    AppMethodBeat.i(211187);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)ltx.get(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AppMethodBeat.o(211187);
        return localObject;
      }
    }
    e locale = a.boh().lqK;
    Object localObject = locale;
    if (locale == null) {
      localObject = new g();
    }
    localObject = ((e)localObject).generate(paramString);
    ltx.put(paramString, localObject);
    AppMethodBeat.o(211187);
    return localObject;
  }
  
  public static String RG(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(211194);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211194);
      return null;
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(211194);
      return "local";
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith(l.boq().lsa.bor()))) {}
    for (i = j; i != 0; i = 0)
    {
      AppMethodBeat.o(211194);
      return "noproxy";
    }
    Map localMap = f.Rz(paramString);
    if ((localMap == null) || (localMap.isEmpty()))
    {
      a(6, "PlayerUtils", "getVideoUuidFromVideoUrl fail ".concat(String.valueOf(paramString)), null);
      AppMethodBeat.o(211194);
      return null;
    }
    paramString = (String)localMap.get("id");
    AppMethodBeat.o(211194);
    return paramString;
  }
  
  public static boolean RH(String paramString)
  {
    AppMethodBeat.i(211200);
    if (lty.containsKey(paramString))
    {
      bool = ((Boolean)lty.get(paramString)).booleanValue();
      AppMethodBeat.o(211200);
      return bool;
    }
    if ((paramString.contains("m3u8")) || (paramString.contains("m3u"))) {}
    for (boolean bool = true;; bool = false)
    {
      lty.put(paramString, Boolean.valueOf(bool));
      break;
    }
  }
  
  public static String RI(String paramString)
  {
    AppMethodBeat.i(211202);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211202);
      return "";
    }
    if (!paramString.startsWith("#"))
    {
      AppMethodBeat.o(211202);
      return "";
    }
    int i = paramString.indexOf(":");
    if (i == -1)
    {
      AppMethodBeat.o(211202);
      return "";
    }
    String str2 = paramString.substring(i + 1);
    String str1 = str2;
    if (paramString.lastIndexOf(",") != -1) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    AppMethodBeat.o(211202);
    return str1;
  }
  
  public static int RJ(String paramString)
  {
    AppMethodBeat.i(211203);
    paramString = RI(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211203);
      return -1;
    }
    try
    {
      i = Integer.parseInt(paramString);
      j = i;
      if (i == -1) {}
      try
      {
        float f = Float.parseFloat(paramString);
        j = (int)f;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          a(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(paramString)), null);
          j = i;
        }
      }
      AppMethodBeat.o(211203);
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(localException)), null);
        i = -1;
      }
    }
  }
  
  public static String RK(String paramString)
  {
    AppMethodBeat.i(211204);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")))
    {
      paramString = "file://".concat(String.valueOf(paramString));
      AppMethodBeat.o(211204);
      return paramString;
    }
    AppMethodBeat.o(211204);
    return paramString;
  }
  
  public static boolean RL(String paramString)
  {
    AppMethodBeat.i(211205);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file:///android_asset")))
    {
      AppMethodBeat.o(211205);
      return true;
    }
    AppMethodBeat.o(211205);
    return false;
  }
  
  public static boolean RM(String paramString)
  {
    AppMethodBeat.i(211206);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("android.resource://")))
    {
      AppMethodBeat.o(211206);
      return true;
    }
    AppMethodBeat.o(211206);
    return false;
  }
  
  public static String RN(String paramString)
  {
    AppMethodBeat.i(211207);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("\\r\\n", "|").replaceAll("\\r|\\n", "|");
      AppMethodBeat.o(211207);
      return paramString;
    }
    AppMethodBeat.o(211207);
    return paramString;
  }
  
  private static String a(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(211209);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(211209);
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {}
    for (paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();; paramThrowable = paramThrowable.getCause())
    {
      if (paramThrowable != null)
      {
        localStringBuilder.append("caused by: ");
        localStringBuilder.append(paramThrowable.toString());
        localStringBuilder.append("\n");
        localStringBuilder.append(a(paramThrowable, true));
      }
      paramThrowable = localStringBuilder.toString();
      AppMethodBeat.o(211209);
      return paramThrowable;
    }
  }
  
  private static String a(Iterator<String> paramIterator, String paramString)
  {
    AppMethodBeat.i(211195);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramIterator != null) {
      for (;;)
      {
        localObject2 = localObject1;
        if (!paramIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localObject1 + (String)paramIterator.next();
        localObject1 = localObject2;
        if (paramIterator.hasNext()) {
          localObject1 = (String)localObject2 + paramString;
        }
      }
    }
    AppMethodBeat.o(211195);
    return localObject2;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(211212);
    String str = paramString2;
    if (paramThrowable != null) {
      str = paramString2 + ":" + i(paramThrowable);
    }
    if (str.length() > 1000)
    {
      a(paramInt, paramString1, RE(str));
      AppMethodBeat.o(211212);
      return;
    }
    paramString2 = a.boh().lqI;
    if (paramString2 == null)
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(211212);
        return;
      case 2: 
        AppMethodBeat.o(211212);
        return;
      case 3: 
        AppMethodBeat.o(211212);
        return;
      case 6: 
        AppMethodBeat.o(211212);
        return;
      case 4: 
        AppMethodBeat.o(211212);
        return;
      }
      AppMethodBeat.o(211212);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211212);
      return;
      paramString2.v(paramString1, str);
      AppMethodBeat.o(211212);
      return;
      paramString2.d(paramString1, str);
      AppMethodBeat.o(211212);
      return;
      paramString2.e(paramString1, str);
      AppMethodBeat.o(211212);
      return;
      paramString2.i(paramString1, str);
      AppMethodBeat.o(211212);
      return;
      paramString2.w(paramString1, str);
    }
  }
  
  private static void a(int paramInt, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(211210);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt, paramString, (String)paramList.next(), null);
    }
    AppMethodBeat.o(211210);
  }
  
  public static boolean aw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211197);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 100))
    {
      byte[] arrayOfByte = new byte[100];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 100);
      boolean bool = new String(arrayOfByte).toLowerCase().replaceAll("\\s", "").contains(ltw);
      AppMethodBeat.o(211197);
      return bool;
    }
    AppMethodBeat.o(211197);
    return false;
  }
  
  public static int boA()
  {
    AppMethodBeat.i(211188);
    try
    {
      i = boB();
      AppMethodBeat.o(211188);
      return i;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      int i = 0;
      while (i < 5) {
        try
        {
          int j = boB();
          AppMethodBeat.o(211188);
          return j;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          a(5, "PlayerUtils", "retry findFreePort i=".concat(String.valueOf(i)), null);
          i += 1;
        }
      }
      IllegalStateException localIllegalStateException3 = new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=5");
      AppMethodBeat.o(211188);
      throw localIllegalStateException3;
    }
  }
  
  /* Error */
  private static int boB()
  {
    // Byte code:
    //   0: ldc_w 476
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 478	java/net/ServerSocket
    //   9: dup
    //   10: iconst_0
    //   11: invokespecial 479	java/net/ServerSocket:<init>	(I)V
    //   14: astore_1
    //   15: aload_1
    //   16: iconst_1
    //   17: invokevirtual 483	java/net/ServerSocket:setReuseAddress	(Z)V
    //   20: aload_1
    //   21: invokevirtual 486	java/net/ServerSocket:getLocalPort	()I
    //   24: istore_0
    //   25: aload_1
    //   26: invokevirtual 489	java/net/ServerSocket:close	()V
    //   29: aload_1
    //   30: invokevirtual 489	java/net/ServerSocket:close	()V
    //   33: ldc_w 476
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iload_0
    //   40: ireturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 489	java/net/ServerSocket:close	()V
    //   52: new 462	java/lang/IllegalStateException
    //   55: dup
    //   56: ldc_w 491
    //   59: invokespecial 473	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: ldc_w 476
    //   66: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 489	java/net/ServerSocket:close	()V
    //   82: ldc_w 476
    //   85: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: goto -62 -> 29
    //   94: astore_1
    //   95: goto -62 -> 33
    //   98: astore_1
    //   99: goto -47 -> 52
    //   102: astore_2
    //   103: goto -21 -> 82
    //   106: astore_2
    //   107: aload_1
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: goto -39 -> 74
    //   116: astore_2
    //   117: goto -73 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	16	0	i	int
    //   14	16	1	localServerSocket	java.net.ServerSocket
    //   41	1	1	localIOException1	IOException
    //   43	27	1	localIllegalStateException	IllegalStateException
    //   71	18	1	localObject1	Object
    //   94	1	1	localIOException2	IOException
    //   98	10	1	localIOException3	IOException
    //   110	1	1	localObject2	Object
    //   73	6	2	localObject3	Object
    //   90	1	2	localIOException4	IOException
    //   102	1	2	localIOException5	IOException
    //   106	4	2	localObject4	Object
    //   112	1	2	localObject5	Object
    //   116	1	2	localIOException6	IOException
    //   108	4	3	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   6	15	41	java/io/IOException
    //   6	15	71	finally
    //   25	29	90	java/io/IOException
    //   29	33	94	java/io/IOException
    //   48	52	98	java/io/IOException
    //   78	82	102	java/io/IOException
    //   15	25	106	finally
    //   25	29	106	finally
    //   15	25	116	java/io/IOException
  }
  
  /* Error */
  private static String[] boC()
  {
    // Byte code:
    //   0: ldc_w 494
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 496
    //   9: ldc_w 498
    //   12: iconst_0
    //   13: anewarray 500	java/lang/Class
    //   16: invokevirtual 504	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 213	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:boh	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   24: getfield 508	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:appContext	Landroid/content/Context;
    //   27: ldc_w 510
    //   30: invokevirtual 516	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 496	android/net/ConnectivityManager
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnonnull +29 -> 74
    //   48: ldc_w 494
    //   51: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_0
    //   57: ldc_w 494
    //   60: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: ldc_w 494
    //   69: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: iconst_3
    //   75: anewarray 185	java/lang/String
    //   78: astore_1
    //   79: ldc_w 524
    //   82: invokestatic 528	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   85: astore_2
    //   86: aload_1
    //   87: iconst_0
    //   88: aload_2
    //   89: ldc_w 530
    //   92: iconst_0
    //   93: anewarray 500	java/lang/Class
    //   96: invokevirtual 504	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   99: aload_0
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 185	java/lang/String
    //   110: aastore
    //   111: aload_1
    //   112: iconst_1
    //   113: aload_2
    //   114: ldc_w 532
    //   117: iconst_0
    //   118: anewarray 500	java/lang/Class
    //   121: invokevirtual 504	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: aload_0
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 323	java/lang/Integer
    //   135: invokestatic 272	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   138: aastore
    //   139: aload_1
    //   140: iconst_2
    //   141: aload_2
    //   142: ldc_w 534
    //   145: iconst_0
    //   146: anewarray 500	java/lang/Class
    //   149: invokevirtual 504	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   152: aload_0
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   160: checkcast 185	java/lang/String
    //   163: aastore
    //   164: aload_1
    //   165: iconst_0
    //   166: aaload
    //   167: ifnull +11 -> 178
    //   170: ldc_w 494
    //   173: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: areturn
    //   178: ldc_w 494
    //   181: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: ldc_w 494
    //   190: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aconst_null
    //   194: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	26	0	localObject	Object
    //   56	1	0	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   65	88	0	localException1	Exception
    //   186	1	0	localException2	Exception
    //   78	99	1	arrayOfString	String[]
    //   85	57	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   6	20	56	java/lang/NoSuchMethodException
    //   6	20	65	java/lang/Exception
    //   20	44	186	java/lang/Exception
    //   74	164	186	java/lang/Exception
    //   170	176	186	java/lang/Exception
  }
  
  private static long bv(List<String> paramList)
  {
    AppMethodBeat.i(211190);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (String)paramList.get(0);
      if (!TextUtils.isEmpty(paramList)) {
        try
        {
          long l = Long.parseLong(paramList);
          AppMethodBeat.o(211190);
          return l;
        }
        catch (NumberFormatException paramList)
        {
          a(6, "PlayerUtils", "getSubErrorCode: long string is ill-format", null);
        }
      }
    }
    AppMethodBeat.o(211190);
    return -1L;
  }
  
  public static String bw(List<String> paramList)
  {
    AppMethodBeat.i(211196);
    paramList = a(paramList.iterator(), "|");
    AppMethodBeat.o(211196);
    return paramList;
  }
  
  public static boolean c(URL paramURL)
  {
    Object localObject = null;
    AppMethodBeat.i(211198);
    try
    {
      paramURL = paramURL.getHost();
      if (paramURL == null)
      {
        AppMethodBeat.o(211198);
        return false;
      }
    }
    catch (Exception paramURL)
    {
      for (;;)
      {
        paramURL = null;
      }
    }
    try
    {
      paramURL = InetAddress.getByName(paramURL);
      if (paramURL == null)
      {
        AppMethodBeat.o(211198);
        return false;
      }
      if ((paramURL.isAnyLocalAddress()) || (paramURL.isLoopbackAddress()))
      {
        AppMethodBeat.o(211198);
        return true;
      }
      try
      {
        if (NetworkInterface.getByInetAddress(paramURL) != null)
        {
          AppMethodBeat.o(211198);
          return true;
        }
        AppMethodBeat.o(211198);
        return false;
      }
      catch (SocketException paramURL)
      {
        AppMethodBeat.o(211198);
        return false;
      }
    }
    catch (UnknownHostException paramURL)
    {
      for (;;)
      {
        paramURL = localObject;
      }
    }
  }
  
  public static String dC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211201);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(211201);
      return paramString1;
    }
    if (paramString2.startsWith("http"))
    {
      AppMethodBeat.o(211201);
      return paramString2;
    }
    try
    {
      URL localURL = new URL(new URL(paramString1), paramString2);
      paramString1 = localURL.toString();
      AppMethodBeat.o(211201);
      return paramString1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      String str = paramString1;
      if (paramString1.endsWith("/")) {
        str = paramString1.substring(0, paramString1.length() - 1);
      }
      int i = str.lastIndexOf('/');
      paramString1 = str;
      if (i > 0) {
        paramString1 = str.substring(0, i);
      }
      paramString1 = paramString1 + paramString2;
      AppMethodBeat.o(211201);
    }
    return paramString1;
  }
  
  public static String i(Throwable paramThrowable)
  {
    AppMethodBeat.i(211208);
    paramThrowable = a(paramThrowable, false);
    AppMethodBeat.o(211208);
    return paramThrowable;
  }
  
  public static boolean isNetworkAvailable()
  {
    AppMethodBeat.i(211182);
    Object localObject = (ConnectivityManager)a.boh().appContext.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        AppMethodBeat.o(211182);
        return true;
      }
      AppMethodBeat.o(211182);
      return false;
    }
    a(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?", null);
    AppMethodBeat.o(211182);
    return false;
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(224438);
    a(paramInt, paramString1, paramString2, null);
    AppMethodBeat.o(224438);
  }
  
  public static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    AppMethodBeat.i(211183);
    if ((SDK_INT != 19) && (SDK_INT != 20))
    {
      AppMethodBeat.o(211183);
      return;
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        int i = paramHttpURLConnection.read();
        if (i == -1) {
          AppMethodBeat.o(211183);
        }
      }
      else if (paramLong <= 2048L)
      {
        AppMethodBeat.o(211183);
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
      {
        localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      AppMethodBeat.o(211183);
      return;
    }
    catch (IOException paramHttpURLConnection)
    {
      AppMethodBeat.o(211183);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(211183);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h
 * JD-Core Version:    0.7.0.1
 */