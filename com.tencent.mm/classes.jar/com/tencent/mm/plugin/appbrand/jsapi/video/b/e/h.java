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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
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
  public static final int SDK_INT;
  private static final AtomicInteger bty;
  private static String sDx;
  public static HashMap<String, String> sDy;
  private static HashMap<String, Boolean> sDz;
  
  static
  {
    AppMethodBeat.i(328612);
    SDK_INT = Build.VERSION.SDK_INT;
    sDx = "<html";
    sDy = new HashMap();
    bty = new AtomicInteger(1);
    sDz = new HashMap();
    AppMethodBeat.o(328612);
  }
  
  public static long U(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(328457);
    if (paramMap != null)
    {
      long l = ds((List)paramMap.get("x-server-error"));
      if ((l != -1L) && (l != 0L))
      {
        AppMethodBeat.o(328457);
        return l;
      }
      l = ds((List)paramMap.get("x-proxy-error"));
      if (l != -1L)
      {
        AppMethodBeat.o(328457);
        return l - 20000L;
      }
      l = ds((List)paramMap.get("error"));
      if (l != -1L)
      {
        AppMethodBeat.o(328457);
        return l;
      }
    }
    AppMethodBeat.o(328457);
    return -99999L;
  }
  
  private static String a(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(328590);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(328590);
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
      AppMethodBeat.o(328590);
      return paramThrowable;
    }
  }
  
  private static String a(Iterator<String> paramIterator, String paramString)
  {
    AppMethodBeat.i(328493);
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
    AppMethodBeat.o(328493);
    return localObject2;
  }
  
  private static void a(int paramInt, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(328597);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b(paramInt, paramString, (String)paramList.next(), null);
    }
    AppMethodBeat.o(328597);
  }
  
  public static boolean aZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(328502);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 100))
    {
      byte[] arrayOfByte = new byte[100];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 100);
      boolean bool = new String(arrayOfByte).toLowerCase().replaceAll("\\s", "").contains(sDx);
      AppMethodBeat.o(328502);
      return bool;
    }
    AppMethodBeat.o(328502);
    return false;
  }
  
  public static long acb(String paramString)
  {
    AppMethodBeat.i(328397);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(328397);
      return -1L;
    }
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getBlockSize();
      int i = paramString.getAvailableBlocks();
      long l2 = i;
      AppMethodBeat.o(328397);
      return l2 * l1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(328397);
    }
    return -1L;
  }
  
  public static long acc(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(328407);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(328407);
      return 0L;
    }
    paramString = new u(paramString);
    if (paramString.jKV())
    {
      l1 = paramString.length();
      AppMethodBeat.o(328407);
      return l1;
    }
    paramString = paramString.jKX();
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
          l2 = l1 + acc(ah.v(localObject.jKT()));
        }
        i += 1;
        l1 = l2;
      }
    }
    AppMethodBeat.o(328407);
    return l2;
  }
  
  private static List<String> acd(String paramString)
  {
    AppMethodBeat.i(328417);
    ArrayList localArrayList = new ArrayList((paramString.length() + 1000 - 1) / 1000);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + 1000)));
      i += 1000;
    }
    AppMethodBeat.o(328417);
    return localArrayList;
  }
  
  public static String ace(String paramString)
  {
    AppMethodBeat.i(328425);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)sDy.get(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AppMethodBeat.o(328425);
        return localObject;
      }
    }
    e locale = a.cvH().sAQ;
    Object localObject = locale;
    if (locale == null) {
      localObject = new g();
    }
    localObject = ((e)localObject).cj(paramString);
    sDy.put(paramString, localObject);
    AppMethodBeat.o(328425);
    return localObject;
  }
  
  public static String acf(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(328485);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(328485);
      return null;
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(328485);
      return "local";
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith(l.cvQ().sCf.cvR()))) {}
    for (i = j; i != 0; i = 0)
    {
      AppMethodBeat.o(328485);
      return "noproxy";
    }
    Map localMap = f.abY(paramString);
    if ((localMap == null) || (localMap.isEmpty()))
    {
      b(6, "PlayerUtils", "getVideoUuidFromVideoUrl fail ".concat(String.valueOf(paramString)), null);
      AppMethodBeat.o(328485);
      return null;
    }
    paramString = (String)localMap.get("id");
    AppMethodBeat.o(328485);
    return paramString;
  }
  
  public static boolean acg(String paramString)
  {
    AppMethodBeat.i(328525);
    if (sDz.containsKey(paramString))
    {
      bool = ((Boolean)sDz.get(paramString)).booleanValue();
      AppMethodBeat.o(328525);
      return bool;
    }
    if ((paramString.contains("m3u8")) || (paramString.contains("m3u"))) {}
    for (boolean bool = true;; bool = false)
    {
      sDz.put(paramString, Boolean.valueOf(bool));
      break;
    }
  }
  
  public static String ach(String paramString)
  {
    AppMethodBeat.i(328545);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(328545);
      return "";
    }
    if (!paramString.startsWith("#"))
    {
      AppMethodBeat.o(328545);
      return "";
    }
    int i = paramString.indexOf(":");
    if (i == -1)
    {
      AppMethodBeat.o(328545);
      return "";
    }
    String str2 = paramString.substring(i + 1);
    String str1 = str2;
    if (paramString.lastIndexOf(",") != -1) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    AppMethodBeat.o(328545);
    return str1;
  }
  
  public static int aci(String paramString)
  {
    AppMethodBeat.i(328551);
    paramString = ach(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(328551);
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
          b(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(paramString)), null);
          j = i;
        }
      }
      AppMethodBeat.o(328551);
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(localException)), null);
        i = -1;
      }
    }
  }
  
  public static String acj(String paramString)
  {
    AppMethodBeat.i(328557);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")))
    {
      paramString = "file://".concat(String.valueOf(paramString));
      AppMethodBeat.o(328557);
      return paramString;
    }
    AppMethodBeat.o(328557);
    return paramString;
  }
  
  public static boolean ack(String paramString)
  {
    AppMethodBeat.i(328564);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file:///android_asset")))
    {
      AppMethodBeat.o(328564);
      return true;
    }
    AppMethodBeat.o(328564);
    return false;
  }
  
  public static boolean acl(String paramString)
  {
    AppMethodBeat.i(328571);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("android.resource://")))
    {
      AppMethodBeat.o(328571);
      return true;
    }
    AppMethodBeat.o(328571);
    return false;
  }
  
  public static String acm(String paramString)
  {
    AppMethodBeat.i(328576);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("\\r\\n", "|").replaceAll("\\r|\\n", "|");
      AppMethodBeat.o(328576);
      return paramString;
    }
    AppMethodBeat.o(328576);
    return paramString;
  }
  
  public static long ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328469);
    int i = -2;
    String[] arrayOfString = cwc();
    if (arrayOfString != null)
    {
      i = -3;
      b(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    long l = i * 100000000;
    AppMethodBeat.o(328469);
    return l + 100000L * paramLong1 + paramLong2;
  }
  
  public static long af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328476);
    int i = -2;
    String[] arrayOfString = cwc();
    if (arrayOfString != null)
    {
      i = -3;
      b(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(arrayOfString).iterator(), "|"), null);
    }
    paramLong1 = (paramLong1 - paramLong2 - i * 100000000) / 100000L;
    AppMethodBeat.o(328476);
    return paramLong1;
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(328609);
    String str = paramString2;
    if (paramThrowable != null) {
      str = paramString2 + ":" + s(paramThrowable);
    }
    if (str.length() > 1000)
    {
      a(paramInt, paramString1, acd(str));
      AppMethodBeat.o(328609);
      return;
    }
    paramString2 = a.cvH().sAO;
    if (paramString2 == null)
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(328609);
        return;
      case 2: 
        AppMethodBeat.o(328609);
        return;
      case 3: 
        AppMethodBeat.o(328609);
        return;
      case 6: 
        AppMethodBeat.o(328609);
        return;
      case 4: 
        AppMethodBeat.o(328609);
        return;
      }
      AppMethodBeat.o(328609);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(328609);
      return;
      paramString2.v(paramString1, str);
      AppMethodBeat.o(328609);
      return;
      paramString2.d(paramString1, str);
      AppMethodBeat.o(328609);
      return;
      paramString2.e(paramString1, str);
      AppMethodBeat.o(328609);
      return;
      paramString2.i(paramString1, str);
      AppMethodBeat.o(328609);
      return;
      paramString2.w(paramString1, str);
    }
  }
  
  public static boolean b(URL paramURL)
  {
    Object localObject = null;
    AppMethodBeat.i(328510);
    try
    {
      paramURL = paramURL.getHost();
      if (paramURL == null)
      {
        AppMethodBeat.o(328510);
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
        AppMethodBeat.o(328510);
        return false;
      }
      if ((paramURL.isAnyLocalAddress()) || (paramURL.isLoopbackAddress()))
      {
        AppMethodBeat.o(328510);
        return true;
      }
      try
      {
        if (NetworkInterface.getByInetAddress(paramURL) != null)
        {
          AppMethodBeat.o(328510);
          return true;
        }
        AppMethodBeat.o(328510);
        return false;
      }
      catch (SocketException paramURL)
      {
        AppMethodBeat.o(328510);
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
  
  public static int cwa()
  {
    AppMethodBeat.i(328434);
    try
    {
      i = cwb();
      AppMethodBeat.o(328434);
      return i;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      int i = 0;
      while (i < 5) {
        try
        {
          int j = cwb();
          AppMethodBeat.o(328434);
          return j;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          b(5, "PlayerUtils", "retry findFreePort i=".concat(String.valueOf(i)), null);
          i += 1;
        }
      }
      IllegalStateException localIllegalStateException3 = new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=5");
      AppMethodBeat.o(328434);
      throw localIllegalStateException3;
    }
  }
  
  /* Error */
  private static int cwb()
  {
    // Byte code:
    //   0: ldc_w 507
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 509	java/net/ServerSocket
    //   9: dup
    //   10: iconst_0
    //   11: invokespecial 510	java/net/ServerSocket:<init>	(I)V
    //   14: astore_1
    //   15: aload_1
    //   16: iconst_1
    //   17: invokevirtual 514	java/net/ServerSocket:setReuseAddress	(Z)V
    //   20: aload_1
    //   21: invokevirtual 517	java/net/ServerSocket:getLocalPort	()I
    //   24: istore_0
    //   25: aload_1
    //   26: invokevirtual 520	java/net/ServerSocket:close	()V
    //   29: aload_1
    //   30: invokevirtual 520	java/net/ServerSocket:close	()V
    //   33: ldc_w 507
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iload_0
    //   40: ireturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 520	java/net/ServerSocket:close	()V
    //   52: new 493	java/lang/IllegalStateException
    //   55: dup
    //   56: ldc_w 522
    //   59: invokespecial 504	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: ldc_w 507
    //   66: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 520	java/net/ServerSocket:close	()V
    //   82: ldc_w 507
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
  private static String[] cwc()
  {
    // Byte code:
    //   0: ldc_w 525
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 527
    //   9: ldc_w 529
    //   12: iconst_0
    //   13: anewarray 531	java/lang/Class
    //   16: invokevirtual 535	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   19: astore_0
    //   20: invokestatic 271	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:cvH	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 541	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   28: ldc_w 543
    //   31: invokevirtual 549	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 527	android/net/ConnectivityManager
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 555	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnonnull +29 -> 75
    //   49: ldc_w 525
    //   52: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_0
    //   58: ldc_w 525
    //   61: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: ldc_w 525
    //   70: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: iconst_3
    //   76: anewarray 151	java/lang/String
    //   79: astore_1
    //   80: ldc_w 557
    //   83: invokestatic 561	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   86: astore_2
    //   87: aload_1
    //   88: iconst_0
    //   89: aload_2
    //   90: ldc_w 562
    //   93: iconst_0
    //   94: anewarray 531	java/lang/Class
    //   97: invokevirtual 535	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   100: aload_0
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokevirtual 555	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast 151	java/lang/String
    //   111: aastore
    //   112: aload_1
    //   113: iconst_1
    //   114: aload_2
    //   115: ldc_w 564
    //   118: iconst_0
    //   119: anewarray 531	java/lang/Class
    //   122: invokevirtual 535	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   125: aload_0
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokevirtual 555	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 378	java/lang/Integer
    //   136: invokestatic 332	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: aastore
    //   140: aload_1
    //   141: iconst_2
    //   142: aload_2
    //   143: ldc_w 566
    //   146: iconst_0
    //   147: anewarray 531	java/lang/Class
    //   150: invokevirtual 535	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   153: aload_0
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokevirtual 555	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 151	java/lang/String
    //   164: aastore
    //   165: aload_1
    //   166: iconst_0
    //   167: aaload
    //   168: ifnull +11 -> 179
    //   171: ldc_w 525
    //   174: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: areturn
    //   179: ldc_w 525
    //   182: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: ldc_w 525
    //   191: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aconst_null
    //   195: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	27	0	localObject	Object
    //   57	1	0	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   66	88	0	localException1	Exception
    //   187	1	0	localException2	Exception
    //   79	99	1	arrayOfString	String[]
    //   86	57	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   6	20	57	java/lang/NoSuchMethodException
    //   6	20	66	java/lang/Exception
    //   20	45	187	java/lang/Exception
    //   75	165	187	java/lang/Exception
    //   171	177	187	java/lang/Exception
  }
  
  private static long ds(List<String> paramList)
  {
    AppMethodBeat.i(328450);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (String)paramList.get(0);
      if (!TextUtils.isEmpty(paramList)) {
        try
        {
          long l = Long.parseLong(paramList);
          AppMethodBeat.o(328450);
          return l;
        }
        catch (NumberFormatException paramList)
        {
          b(6, "PlayerUtils", "getSubErrorCode: long string is ill-format", null);
        }
      }
    }
    AppMethodBeat.o(328450);
    return -1L;
  }
  
  public static String dt(List<String> paramList)
  {
    AppMethodBeat.i(328498);
    paramList = a(paramList.iterator(), "|");
    AppMethodBeat.o(328498);
    return paramList;
  }
  
  public static String ev(String paramString1, String paramString2)
  {
    AppMethodBeat.i(328536);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(328536);
      return paramString1;
    }
    if (paramString2.startsWith("http"))
    {
      AppMethodBeat.o(328536);
      return paramString2;
    }
    try
    {
      URL localURL = new URL(new URL(paramString1), paramString2);
      paramString1 = localURL.toString();
      AppMethodBeat.o(328536);
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
      AppMethodBeat.o(328536);
    }
    return paramString1;
  }
  
  public static boolean isNetworkAvailable()
  {
    AppMethodBeat.i(328375);
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        AppMethodBeat.o(328375);
        return true;
      }
      AppMethodBeat.o(328375);
      return false;
    }
    b(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?", null);
    AppMethodBeat.o(328375);
    return false;
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(370030);
    b(paramInt, paramString1, paramString2, null);
    AppMethodBeat.o(370030);
  }
  
  public static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    AppMethodBeat.i(328388);
    if ((SDK_INT != 19) && (SDK_INT != 20))
    {
      AppMethodBeat.o(328388);
      return;
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        int i = paramHttpURLConnection.read();
        if (i == -1) {
          AppMethodBeat.o(328388);
        }
      }
      else if (paramLong <= 2048L)
      {
        AppMethodBeat.o(328388);
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
      {
        localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      AppMethodBeat.o(328388);
      return;
    }
    catch (IOException paramHttpURLConnection)
    {
      AppMethodBeat.o(328388);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(328388);
    }
  }
  
  public static String s(Throwable paramThrowable)
  {
    AppMethodBeat.i(328580);
    paramThrowable = a(paramThrowable, false);
    AppMethodBeat.o(328580);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h
 * JD-Core Version:    0.7.0.1
 */