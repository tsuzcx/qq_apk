package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.vfs.q;
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
  private static final AtomicInteger OD;
  public static final int SDK_INT;
  private static String kSw;
  public static HashMap<String, String> kSx;
  private static HashMap<String, Boolean> kSy;
  
  static
  {
    AppMethodBeat.i(194374);
    SDK_INT = Build.VERSION.SDK_INT;
    kSw = "<html";
    kSx = new HashMap();
    OD = new AtomicInteger(1);
    kSy = new HashMap();
    AppMethodBeat.o(194374);
  }
  
  public static long B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194353);
    int i = -2;
    String[] arrayOfString = bkh();
    if (arrayOfString != null)
    {
      i = -3;
      a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    long l = i * 100000000;
    AppMethodBeat.o(194353);
    return l + 100000L * paramLong1 + paramLong2;
  }
  
  public static long C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194354);
    int i = -2;
    String[] arrayOfString = bkh();
    if (arrayOfString != null)
    {
      i = -3;
      a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    paramLong1 = (paramLong1 - paramLong2 - i * 100000000) / 100000L;
    AppMethodBeat.o(194354);
    return paramLong1;
  }
  
  public static long K(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(194352);
    if (paramMap != null)
    {
      long l = br((List)paramMap.get("x-server-error"));
      if ((l != -1L) && (l != 0L))
      {
        AppMethodBeat.o(194352);
        return l;
      }
      l = br((List)paramMap.get("x-proxy-error"));
      if (l != -1L)
      {
        AppMethodBeat.o(194352);
        return l - 20000L;
      }
      l = br((List)paramMap.get("error"));
      if (l != -1L)
      {
        AppMethodBeat.o(194352);
        return l;
      }
    }
    AppMethodBeat.o(194352);
    return -99999L;
  }
  
  public static String NA(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(194355);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194355);
      return null;
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(194355);
      return "local";
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith(l.bjV().kRa.bjW()))) {}
    for (i = j; i != 0; i = 0)
    {
      AppMethodBeat.o(194355);
      return "noproxy";
    }
    Map localMap = f.Nt(paramString);
    if ((localMap == null) || (localMap.isEmpty()))
    {
      a(6, "PlayerUtils", "getVideoUuidFromVideoUrl fail ".concat(String.valueOf(paramString)), null);
      AppMethodBeat.o(194355);
      return null;
    }
    paramString = (String)localMap.get("id");
    AppMethodBeat.o(194355);
    return paramString;
  }
  
  public static boolean NB(String paramString)
  {
    AppMethodBeat.i(194361);
    if (kSy.containsKey(paramString))
    {
      bool = ((Boolean)kSy.get(paramString)).booleanValue();
      AppMethodBeat.o(194361);
      return bool;
    }
    if ((paramString.contains("m3u8")) || (paramString.contains("m3u"))) {}
    for (boolean bool = true;; bool = false)
    {
      kSy.put(paramString, Boolean.valueOf(bool));
      break;
    }
  }
  
  public static String NC(String paramString)
  {
    AppMethodBeat.i(194363);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194363);
      return "";
    }
    if (!paramString.startsWith("#"))
    {
      AppMethodBeat.o(194363);
      return "";
    }
    int i = paramString.indexOf(":");
    if (i == -1)
    {
      AppMethodBeat.o(194363);
      return "";
    }
    String str2 = paramString.substring(i + 1);
    String str1 = str2;
    if (paramString.lastIndexOf(",") != -1) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    AppMethodBeat.o(194363);
    return str1;
  }
  
  public static int ND(String paramString)
  {
    AppMethodBeat.i(194364);
    paramString = NC(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194364);
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
      AppMethodBeat.o(194364);
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
  
  public static String NE(String paramString)
  {
    AppMethodBeat.i(194365);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")))
    {
      paramString = "file://".concat(String.valueOf(paramString));
      AppMethodBeat.o(194365);
      return paramString;
    }
    AppMethodBeat.o(194365);
    return paramString;
  }
  
  public static boolean NF(String paramString)
  {
    AppMethodBeat.i(194366);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file:///android_asset")))
    {
      AppMethodBeat.o(194366);
      return true;
    }
    AppMethodBeat.o(194366);
    return false;
  }
  
  public static boolean NG(String paramString)
  {
    AppMethodBeat.i(194367);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("android.resource://")))
    {
      AppMethodBeat.o(194367);
      return true;
    }
    AppMethodBeat.o(194367);
    return false;
  }
  
  public static String NH(String paramString)
  {
    AppMethodBeat.i(194368);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("\\r\\n", "|").replaceAll("\\r|\\n", "|");
      AppMethodBeat.o(194368);
      return paramString;
    }
    AppMethodBeat.o(194368);
    return paramString;
  }
  
  public static long Nw(String paramString)
  {
    AppMethodBeat.i(194345);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194345);
      return -1L;
    }
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getBlockSize();
      int i = paramString.getAvailableBlocks();
      long l2 = i;
      AppMethodBeat.o(194345);
      return l2 * l1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(194345);
    }
    return -1L;
  }
  
  public static long Nx(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(194346);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194346);
      return 0L;
    }
    paramString = new com.tencent.mm.vfs.e(paramString);
    if (paramString.isFile())
    {
      l1 = paramString.length();
      AppMethodBeat.o(194346);
      return l1;
    }
    paramString = paramString.fxX();
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
          l2 = l1 + Nx(q.B(localObject.fxV()));
        }
        i += 1;
        l1 = l2;
      }
    }
    AppMethodBeat.o(194346);
    return l2;
  }
  
  private static List<String> Ny(String paramString)
  {
    AppMethodBeat.i(194347);
    ArrayList localArrayList = new ArrayList((paramString.length() + 1000 - 1) / 1000);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + 1000)));
      i += 1000;
    }
    AppMethodBeat.o(194347);
    return localArrayList;
  }
  
  public static String Nz(String paramString)
  {
    AppMethodBeat.i(194348);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)kSx.get(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AppMethodBeat.o(194348);
        return localObject;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e locale = a.bjM().kPJ;
    Object localObject = locale;
    if (locale == null) {
      localObject = new g();
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e)localObject).generate(paramString);
    kSx.put(paramString, localObject);
    AppMethodBeat.o(194348);
    return localObject;
  }
  
  private static String a(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(194370);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(194370);
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
      AppMethodBeat.o(194370);
      return paramThrowable;
    }
  }
  
  private static String a(Iterator<String> paramIterator, String paramString)
  {
    AppMethodBeat.i(194356);
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
    AppMethodBeat.o(194356);
    return localObject2;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(194373);
    String str = paramString2;
    if (paramThrowable != null) {
      str = paramString2 + ":" + h(paramThrowable);
    }
    if (str.length() > 1000)
    {
      a(paramInt, paramString1, Ny(str));
      AppMethodBeat.o(194373);
      return;
    }
    paramString2 = a.bjM().kPH;
    if (paramString2 == null)
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194373);
        return;
      case 2: 
        AppMethodBeat.o(194373);
        return;
      case 3: 
        AppMethodBeat.o(194373);
        return;
      case 6: 
        AppMethodBeat.o(194373);
        return;
      case 4: 
        AppMethodBeat.o(194373);
        return;
      }
      AppMethodBeat.o(194373);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194373);
      return;
      paramString2.v(paramString1, str);
      AppMethodBeat.o(194373);
      return;
      paramString2.d(paramString1, str);
      AppMethodBeat.o(194373);
      return;
      paramString2.e(paramString1, str);
      AppMethodBeat.o(194373);
      return;
      paramString2.i(paramString1, str);
      AppMethodBeat.o(194373);
      return;
      paramString2.w(paramString1, str);
    }
  }
  
  private static void a(int paramInt, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(194371);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt, paramString, (String)paramList.next(), null);
    }
    AppMethodBeat.o(194371);
  }
  
  public static boolean aw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194358);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 100))
    {
      byte[] arrayOfByte = new byte[100];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 100);
      boolean bool = new String(arrayOfByte).toLowerCase().replaceAll("\\s", "").contains(kSw);
      AppMethodBeat.o(194358);
      return bool;
    }
    AppMethodBeat.o(194358);
    return false;
  }
  
  public static int bkf()
  {
    AppMethodBeat.i(194349);
    try
    {
      i = bkg();
      AppMethodBeat.o(194349);
      return i;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      int i = 0;
      while (i < 5) {
        try
        {
          int j = bkg();
          AppMethodBeat.o(194349);
          return j;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          a(5, "PlayerUtils", "retry findFreePort i=".concat(String.valueOf(i)), null);
          i += 1;
        }
      }
      IllegalStateException localIllegalStateException3 = new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=5");
      AppMethodBeat.o(194349);
      throw localIllegalStateException3;
    }
  }
  
  /* Error */
  private static int bkg()
  {
    // Byte code:
    //   0: ldc_w 477
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 479	java/net/ServerSocket
    //   9: dup
    //   10: iconst_0
    //   11: invokespecial 480	java/net/ServerSocket:<init>	(I)V
    //   14: astore_1
    //   15: aload_1
    //   16: iconst_1
    //   17: invokevirtual 484	java/net/ServerSocket:setReuseAddress	(Z)V
    //   20: aload_1
    //   21: invokevirtual 487	java/net/ServerSocket:getLocalPort	()I
    //   24: istore_0
    //   25: aload_1
    //   26: invokevirtual 490	java/net/ServerSocket:close	()V
    //   29: aload_1
    //   30: invokevirtual 490	java/net/ServerSocket:close	()V
    //   33: ldc_w 477
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iload_0
    //   40: ireturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 490	java/net/ServerSocket:close	()V
    //   52: new 463	java/lang/IllegalStateException
    //   55: dup
    //   56: ldc_w 492
    //   59: invokespecial 474	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: ldc_w 477
    //   66: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 490	java/net/ServerSocket:close	()V
    //   82: ldc_w 477
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
  private static String[] bkh()
  {
    // Byte code:
    //   0: ldc_w 495
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 497
    //   9: ldc_w 499
    //   12: iconst_0
    //   13: anewarray 501	java/lang/Class
    //   16: invokevirtual 505	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 344	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   24: getfield 509	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:appContext	Landroid/content/Context;
    //   27: ldc_w 511
    //   30: invokevirtual 517	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 497	android/net/ConnectivityManager
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokevirtual 523	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnonnull +29 -> 74
    //   48: ldc_w 495
    //   51: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_0
    //   57: ldc_w 495
    //   60: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: ldc_w 495
    //   69: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: iconst_3
    //   75: anewarray 142	java/lang/String
    //   78: astore_1
    //   79: ldc_w 525
    //   82: invokestatic 529	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   85: astore_2
    //   86: aload_1
    //   87: iconst_0
    //   88: aload_2
    //   89: ldc_w 531
    //   92: iconst_0
    //   93: anewarray 501	java/lang/Class
    //   96: invokevirtual 505	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   99: aload_0
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokevirtual 523	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 142	java/lang/String
    //   110: aastore
    //   111: aload_1
    //   112: iconst_1
    //   113: aload_2
    //   114: ldc_w 533
    //   117: iconst_0
    //   118: anewarray 501	java/lang/Class
    //   121: invokevirtual 505	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: aload_0
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokevirtual 523	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 249	java/lang/Integer
    //   135: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   138: aastore
    //   139: aload_1
    //   140: iconst_2
    //   141: aload_2
    //   142: ldc_w 535
    //   145: iconst_0
    //   146: anewarray 501	java/lang/Class
    //   149: invokevirtual 505	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   152: aload_0
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokevirtual 523	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   160: checkcast 142	java/lang/String
    //   163: aastore
    //   164: aload_1
    //   165: iconst_0
    //   166: aaload
    //   167: ifnull +11 -> 178
    //   170: ldc_w 495
    //   173: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: areturn
    //   178: ldc_w 495
    //   181: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: ldc_w 495
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
  
  private static long br(List<String> paramList)
  {
    AppMethodBeat.i(194351);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (String)paramList.get(0);
      if (!TextUtils.isEmpty(paramList)) {
        try
        {
          long l = Long.parseLong(paramList);
          AppMethodBeat.o(194351);
          return l;
        }
        catch (NumberFormatException paramList)
        {
          a(6, "PlayerUtils", "getSubErrorCode: long string is ill-format", null);
        }
      }
    }
    AppMethodBeat.o(194351);
    return -1L;
  }
  
  public static String bs(List<String> paramList)
  {
    AppMethodBeat.i(194357);
    paramList = a(paramList.iterator(), "|");
    AppMethodBeat.o(194357);
    return paramList;
  }
  
  public static boolean c(URL paramURL)
  {
    Object localObject = null;
    AppMethodBeat.i(194359);
    try
    {
      paramURL = paramURL.getHost();
      if (paramURL == null)
      {
        AppMethodBeat.o(194359);
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
        AppMethodBeat.o(194359);
        return false;
      }
      if ((paramURL.isAnyLocalAddress()) || (paramURL.isLoopbackAddress()))
      {
        AppMethodBeat.o(194359);
        return true;
      }
      try
      {
        if (NetworkInterface.getByInetAddress(paramURL) != null)
        {
          AppMethodBeat.o(194359);
          return true;
        }
        AppMethodBeat.o(194359);
        return false;
      }
      catch (SocketException paramURL)
      {
        AppMethodBeat.o(194359);
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
  
  public static String dy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194362);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(194362);
      return paramString1;
    }
    if (paramString2.startsWith("http"))
    {
      AppMethodBeat.o(194362);
      return paramString2;
    }
    try
    {
      URL localURL = new URL(new URL(paramString1), paramString2);
      paramString1 = localURL.toString();
      AppMethodBeat.o(194362);
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
      AppMethodBeat.o(194362);
    }
    return paramString1;
  }
  
  public static String h(Throwable paramThrowable)
  {
    AppMethodBeat.i(194369);
    paramThrowable = a(paramThrowable, false);
    AppMethodBeat.o(194369);
    return paramThrowable;
  }
  
  public static boolean isNetworkAvailable()
  {
    AppMethodBeat.i(194343);
    Object localObject = (ConnectivityManager)a.bjM().appContext.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        AppMethodBeat.o(194343);
        return true;
      }
      AppMethodBeat.o(194343);
      return false;
    }
    a(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?", null);
    AppMethodBeat.o(194343);
    return false;
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210401);
    a(paramInt, paramString1, paramString2, null);
    AppMethodBeat.o(210401);
  }
  
  public static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    AppMethodBeat.i(194344);
    if ((SDK_INT != 19) && (SDK_INT != 20))
    {
      AppMethodBeat.o(194344);
      return;
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        int i = paramHttpURLConnection.read();
        if (i == -1) {
          AppMethodBeat.o(194344);
        }
      }
      else if (paramLong <= 2048L)
      {
        AppMethodBeat.o(194344);
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
      {
        localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      AppMethodBeat.o(194344);
      return;
    }
    catch (IOException paramHttpURLConnection)
    {
      AppMethodBeat.o(194344);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(194344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h
 * JD-Core Version:    0.7.0.1
 */