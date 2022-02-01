package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class kl
  implements kk
{
  private static final HashSet<String> Y;
  private static final kt.g<kl.a> Z;
  private static final AtomicInteger aa;
  private static final Map<String, Map<String, c>> ab;
  private static Pair<String, StringBuilder> ac;
  
  static
  {
    AppMethodBeat.i(224905);
    Y = new HashSet();
    g("DC");
    g("BD");
    g("GD");
    Z = kt.a(30, new kl.1());
    aa = new AtomicInteger();
    ab = Collections.synchronizedMap(new Hashtable());
    AppMethodBeat.o(224905);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(224663);
    Object localObject;
    if (h(paramString1))
    {
      localObject = (Map)ab.get(paramString1);
      if (localObject == null) {
        break label124;
      }
    }
    label124:
    for (paramString1 = (c)((Map)localObject).get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        localObject = paramString1.b(paramString2);
        if ((localObject instanceof AtomicInteger))
        {
          int i = paramInt;
          if (paramInt <= 0) {
            i = 1;
          }
          paramInt = ((AtomicInteger)localObject).get() + i;
          ((AtomicInteger)localObject).set(paramInt);
          AppMethodBeat.o(224663);
          return paramInt;
        }
        paramString1.a(paramString2, new AtomicInteger(1));
        AppMethodBeat.o(224663);
        return 1;
      }
      AppMethodBeat.o(224663);
      return -1;
    }
  }
  
  private static int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(224671);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224671);
      return -1;
    }
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString2 = paramString1.b(paramString3);
        if ((paramString2 instanceof AtomicInteger))
        {
          int i = paramInt;
          if (paramInt <= 0) {
            i = 1;
          }
          paramInt = ((AtomicInteger)paramString2).get() + i;
          ((AtomicInteger)paramString2).set(paramInt);
          AppMethodBeat.o(224671);
          return paramInt;
        }
        paramString1.a(paramString3, new AtomicInteger(1));
        AppMethodBeat.o(224671);
        return 1;
      }
      AppMethodBeat.o(224671);
      return -1;
    }
  }
  
  private static long a(c paramc)
  {
    AppMethodBeat.i(224766);
    long l1;
    long l2;
    if (paramc != null)
    {
      l1 = System.currentTimeMillis();
      if (paramc.c.size() > 0)
      {
        long l3 = ((Long)paramc.c.get(0)).longValue();
        l2 = l1 - ((Long)paramc.c.get(paramc.c.size() - 1)).longValue();
        l1 -= l3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramc.a()).append("\n");
        if (paramc.a.get() != 0) {
          localStringBuilder.append("idx:").append(paramc.a.get()).append("\n");
        }
        if (l1 > 0L) {
          localStringBuilder.append("ut:").append(l1).append("ms\n");
        }
        if (l2 > 0L) {
          localStringBuilder.append("it:").append(l2).append("ms\n");
        }
        if ((paramc.e != null) && (!paramc.e.isEmpty())) {
          localStringBuilder.append("val:").append(paramc.e).append("\n");
        }
        paramc = localStringBuilder.toString();
        kh.c("TT", paramc);
        k(paramc);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(224766);
      return l1;
      l2 = -1L;
      l1 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  private static long a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject)
  {
    AppMethodBeat.i(224749);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224749);
      return 0L;
    }
    a(paramString1, paramString2, paramString4, paramObject);
    paramString1 = i(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1.g = "Log";
      paramString1.a.incrementAndGet();
      paramString1.f = paramString3;
      paramString1.c.add(Long.valueOf(System.currentTimeMillis()));
    }
    long l = a(paramString1);
    AppMethodBeat.o(224749);
    return l;
  }
  
  private static kl.a a(int paramInt)
  {
    AppMethodBeat.i(224786);
    aa.incrementAndGet();
    kl.a locala = (kl.a)Z.a();
    locala.a = paramInt;
    AppMethodBeat.o(224786);
    return locala;
  }
  
  private static Object a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224605);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224605);
      return null;
    }
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString3);
        AppMethodBeat.o(224605);
        return paramString1;
      }
      AppMethodBeat.o(224605);
      return null;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 242
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +9 -> 18
    //   12: getstatic 252	com/tencent/mapsdk/internal/ry:d	Z
    //   15: ifeq +10 -> 25
    //   18: ldc 242
    //   20: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: new 254	java/io/File
    //   28: dup
    //   29: invokestatic 255	com/tencent/mapsdk/internal/kh:a	()Ljava/lang/String;
    //   32: ldc_w 257
    //   35: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic 264	com/tencent/mapsdk/internal/ka:d	(Ljava/io/File;)Ljava/util/List;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +28 -> 71
    //   46: aload_1
    //   47: invokeinterface 265 1 0
    //   52: ifne +19 -> 71
    //   55: aload_1
    //   56: iconst_0
    //   57: invokeinterface 133 2 0
    //   62: checkcast 267	java/lang/CharSequence
    //   65: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +76 -> 144
    //   71: new 140	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 270	com/tencent/mapsdk/internal/gw:a	()Ljava/lang/String;
    //   81: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 273	com/tencent/mapsdk/internal/ry:j	Ljava/lang/String;
    //   87: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: getstatic 275	com/tencent/mapsdk/internal/ry:i	I
    //   93: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: getstatic 277	com/tencent/mapsdk/internal/ry:c	Ljava/lang/String;
    //   99: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: getstatic 279	com/tencent/mapsdk/internal/ry:b	Ljava/lang/String;
    //   105: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 283	com/tencent/mapsdk/internal/km:a	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_1
    //   117: ldc_w 257
    //   120: aload_1
    //   121: invokestatic 285	com/tencent/mapsdk/internal/kh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +31 -> 159
    //   131: aload_1
    //   132: aload_0
    //   133: invokestatic 288	com/tencent/mapsdk/internal/km:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_0
    //   137: ldc 242
    //   139: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: areturn
    //   144: aload_1
    //   145: iconst_0
    //   146: invokeinterface 133 2 0
    //   151: checkcast 290	java/lang/String
    //   154: astore_1
    //   155: goto -31 -> 124
    //   158: astore_0
    //   159: ldc 242
    //   161: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: ldc_w 292
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -47 -> 124
    //   174: astore_2
    //   175: goto -51 -> 124
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -57 -> 124
    //   184: astore_2
    //   185: goto -61 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramString	String
    //   41	114	1	localObject1	Object
    //   168	1	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   170	1	1	localObject2	Object
    //   178	1	1	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   180	1	1	localObject3	Object
    //   174	1	2	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   184	1	2	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    // Exception table:
    //   from	to	target	type
    //   124	137	158	java/security/GeneralSecurityException
    //   109	117	168	java/io/UnsupportedEncodingException
    //   117	124	174	java/io/UnsupportedEncodingException
    //   109	117	178	java/security/NoSuchAlgorithmException
    //   117	124	184	java/security/NoSuchAlgorithmException
  }
  
  public static void a()
  {
    AppMethodBeat.i(224868);
    e();
    AppMethodBeat.o(224868);
  }
  
  private static void a(String paramString, kl.b paramb)
  {
    AppMethodBeat.i(224544);
    if (!h(paramString))
    {
      AppMethodBeat.o(224544);
      return;
    }
    a(paramString, paramString, paramb);
    AppMethodBeat.o(224544);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224520);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224520);
      return;
    }
    a(paramString1, paramString2, null);
    AppMethodBeat.o(224520);
  }
  
  private static void a(String paramString1, String paramString2, kl.b paramb)
  {
    AppMethodBeat.i(224556);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224556);
      return;
    }
    Object localObject = (Map)ab.get(paramString1);
    c localc;
    if (localObject == null)
    {
      localObject = new HashMap();
      localc = new c(paramString1, paramString2);
      ((Map)localObject).put(paramString2, localc);
      ab.put(paramString1, localObject);
      paramString1 = localc;
    }
    for (;;)
    {
      paramString1.b = paramString2;
      paramString1.d = paramb;
      paramString1.c.add(Long.valueOf(System.currentTimeMillis()));
      paramString1.g = "Begin";
      a(paramString1);
      AppMethodBeat.o(224556);
      return;
      localc = (c)((Map)localObject).get(paramString2);
      if (localc == null)
      {
        paramString1 = new c(paramString1, paramString2);
        ((Map)localObject).put(paramString2, paramString1);
      }
      else
      {
        localc.b();
        paramString1 = localc;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(224569);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224569);
      return;
    }
    a(paramString1, paramString1, paramString2, paramObject);
    AppMethodBeat.o(224569);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(224582);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224582);
      return;
    }
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1.a(paramString3, paramObject);
        paramString1.g = "Set";
        k(paramString1.a() + ":" + paramString3 + "=>" + paramObject + "\n");
      }
      AppMethodBeat.o(224582);
      return;
    }
  }
  
  private static void a(Throwable paramThrowable)
  {
    AppMethodBeat.i(224858);
    StringBuilder localStringBuilder;
    if (paramThrowable != null) {
      localStringBuilder = new StringBuilder();
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
        paramThrowable.printStackTrace(localPrintWriter);
      }
      localPrintWriter.close();
      localStringBuilder.append(localStringWriter.toString()).append("\n =============== ");
    }
    finally
    {
      label81:
      break label81;
    }
    kh.f("CRASH", localStringBuilder.toString());
    AppMethodBeat.o(224858);
  }
  
  public static void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(224480);
    if (!kh.d("TT"))
    {
      AppMethodBeat.o(224480);
      return;
    }
    aa.incrementAndGet();
    b(3, "TT", paramVarArgs);
    AppMethodBeat.o(224480);
  }
  
  private static int b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224627);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224627);
      return 0;
    }
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString3);
        if ((paramString1 instanceof AtomicInteger))
        {
          int i = ((AtomicInteger)paramString1).get();
          AppMethodBeat.o(224627);
          return i;
        }
      }
      AppMethodBeat.o(224627);
      return 0;
    }
  }
  
  public static long b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(224727);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224727);
      return 0L;
    }
    long l = a(paramString1, paramString1, "", paramString2, paramObject);
    AppMethodBeat.o(224727);
    return l;
  }
  
  private static void b(int paramInt, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(224493);
    Thread localThread;
    Object localObject4;
    StringBuilder localStringBuilder;
    if (kh.d("TT"))
    {
      if (Y.contains(paramString))
      {
        aa.set(0);
        AppMethodBeat.o(224493);
        return;
      }
      localThread = Thread.currentThread();
      localObject1 = localThread.getStackTrace();
      if ((localObject1 == null) || (localObject1.length <= aa.get() + 3))
      {
        AppMethodBeat.o(224493);
        return;
      }
      localObject4 = localObject1[(aa.get() + 3)];
      aa.set(0);
      localStringBuilder = new StringBuilder();
      localObject3 = null;
    }
    try
    {
      Method[] arrayOfMethod = Class.forName(localObject4.getClassName()).getDeclaredMethods();
      j = arrayOfMethod.length;
      i = 0;
      localObject1 = localObject3;
      if (i < j)
      {
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equals(localObject4.getMethodName())) {
          break label316;
        }
        localObject1 = ((Method)localObject1).getParameterTypes();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        int j;
        int i;
        int k;
        Object localObject2 = localObject3;
      }
    }
    if (localObject4.isNativeMethod()) {
      localStringBuilder.append("(Native Method)");
    }
    for (;;)
    {
      localStringBuilder.append("==").append(localThread.getName()).append(":").append(localThread.getId()).append("==");
      localStringBuilder.append("#").append(localObject4.getMethodName()).append("(");
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label451;
      }
      k = localObject1.length;
      i = 0;
      j = 0;
      while (i < k)
      {
        localStringBuilder.append(localObject1[i].getSimpleName());
        if (j != localObject1.length - 1) {
          localStringBuilder.append(",");
        }
        j += 1;
        i += 1;
      }
      label316:
      i += 1;
      break;
      if (localObject4.getFileName() != null)
      {
        if (localObject4.getLineNumber() >= 0) {
          localStringBuilder.append("(").append(localObject4.getFileName()).append(":").append(localObject4.getLineNumber()).append(")");
        } else {
          localStringBuilder.append("(").append(localObject4.getFileName()).append(")");
        }
      }
      else if (localObject4.getLineNumber() >= 0) {
        localStringBuilder.append("(Unknown Source:").append(localObject4.getLineNumber()).append(")");
      } else {
        localStringBuilder.append("(Unknown Source)");
      }
    }
    label451:
    localStringBuilder.append(")");
    Object localObject1 = new StringBuilder();
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      localObject3 = paramVarArgs[i];
      j += 1;
      ((StringBuilder)localObject1).append("[").append(j).append("] ").append(localObject3);
      i += 1;
    }
    if (j > 0) {
      localStringBuilder.append((CharSequence)localObject1);
    }
    paramVarArgs = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramVarArgs = "TT";
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(224493);
      return;
      kh.a(paramVarArgs, localStringBuilder.toString());
      AppMethodBeat.o(224493);
      return;
      kh.c(paramVarArgs, localStringBuilder.toString());
      AppMethodBeat.o(224493);
      return;
      kh.b(paramVarArgs, localStringBuilder.toString());
      AppMethodBeat.o(224493);
      return;
      kh.d(paramVarArgs, localStringBuilder.toString());
      AppMethodBeat.o(224493);
      return;
      kh.e(paramVarArgs, localStringBuilder.toString());
    }
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(224504);
    if (!h(paramString))
    {
      AppMethodBeat.o(224504);
      return;
    }
    a(paramString, paramString, null);
    AppMethodBeat.o(224504);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224531);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224531);
      return;
    }
    a(paramString1, paramString2, null);
    AppMethodBeat.o(224531);
  }
  
  private static int c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224650);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224650);
      return -1;
    }
    Object localObject = null;
    Map localMap = (Map)ab.get(paramString1);
    paramString1 = localObject;
    if (localMap != null) {
      paramString1 = (c)localMap.get(paramString2);
    }
    if (paramString1 != null)
    {
      paramString2 = paramString1.b(paramString3);
      if ((paramString2 instanceof AtomicInteger))
      {
        int i = ((AtomicInteger)paramString2).incrementAndGet();
        AppMethodBeat.o(224650);
        return i;
      }
      paramString1.a(paramString3, new AtomicInteger(1));
      AppMethodBeat.o(224650);
      return 1;
    }
    AppMethodBeat.o(224650);
    return -1;
  }
  
  public static Object c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224595);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224595);
      return null;
    }
    Map localMap;
    if (h(paramString1))
    {
      localMap = (Map)ab.get(paramString1);
      if (localMap == null) {
        break label82;
      }
    }
    label82:
    for (paramString1 = (c)localMap.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString2);
        AppMethodBeat.o(224595);
        return paramString1;
      }
      AppMethodBeat.o(224595);
      return null;
    }
  }
  
  public static void c(String paramString)
  {
    AppMethodBeat.i(224511);
    if (!h(paramString))
    {
      AppMethodBeat.o(224511);
      return;
    }
    a(paramString, paramString, null);
    AppMethodBeat.o(224511);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224616);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224616);
      return 0;
    }
    Map localMap;
    if (h(paramString1))
    {
      localMap = (Map)ab.get(paramString1);
      if (localMap == null) {
        break label97;
      }
    }
    label97:
    for (paramString1 = (c)localMap.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString2);
        if ((paramString1 instanceof AtomicInteger))
        {
          int i = ((AtomicInteger)paramString1).get();
          AppMethodBeat.o(224616);
          return i;
        }
      }
      AppMethodBeat.o(224616);
      return 0;
    }
  }
  
  private static int d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224694);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224694);
      return -1;
    }
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString3);
        if ((paramString1 instanceof AtomicInteger))
        {
          int j = ((AtomicInteger)paramString1).decrementAndGet();
          int i = j;
          if (j < 0)
          {
            ((AtomicInteger)paramString1).set(0);
            i = 0;
          }
          AppMethodBeat.o(224694);
          return i;
        }
      }
      AppMethodBeat.o(224694);
      return -1;
    }
  }
  
  public static long d(String paramString)
  {
    AppMethodBeat.i(224702);
    if (!h(paramString))
    {
      AppMethodBeat.o(224702);
      return 0L;
    }
    long l = f(paramString, paramString);
    AppMethodBeat.o(224702);
    return l;
  }
  
  private static boolean d()
  {
    AppMethodBeat.i(224451);
    boolean bool = kh.d("TT");
    AppMethodBeat.o(224451);
    return bool;
  }
  
  public static int e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224639);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224639);
      return -1;
    }
    if (h(paramString1))
    {
      c localc = null;
      Map localMap = (Map)ab.get(paramString1);
      if (localMap != null) {
        localc = (c)localMap.get(paramString1);
      }
      if (localc != null)
      {
        paramString1 = localc.b(paramString2);
        if ((paramString1 instanceof AtomicInteger))
        {
          int i = ((AtomicInteger)paramString1).incrementAndGet();
          AppMethodBeat.o(224639);
          return i;
        }
        localc.a(paramString2, new AtomicInteger(1));
        AppMethodBeat.o(224639);
        return 1;
      }
    }
    AppMethodBeat.o(224639);
    return -1;
  }
  
  public static long e(String paramString)
  {
    AppMethodBeat.i(224721);
    if (!h(paramString))
    {
      AppMethodBeat.o(224721);
      return 0L;
    }
    if (!h(paramString))
    {
      AppMethodBeat.o(224721);
      return 0L;
    }
    long l = a(paramString, paramString, paramString, "", null);
    AppMethodBeat.o(224721);
    return l;
  }
  
  private static void e()
  {
    AppMethodBeat.i(224843);
    StringBuilder localStringBuilder;
    if ((ac != null) && (ac.second != null) && (((StringBuilder)ac.second).length() != 0))
    {
      str1 = kj.d();
      localStringBuilder = (StringBuilder)ac.second;
      if (((String)ac.first).equals(str1)) {
        break label138;
      }
    }
    label138:
    String str2;
    for (String str1 = "TT-" + (String)ac.first;; str2 = "TT") {
      synchronized (ac)
      {
        localStringBuilder.append("\n ============= \n");
        kh.f(str1, localStringBuilder.toString());
        ac = null;
        AppMethodBeat.o(224843);
        return;
      }
    }
  }
  
  public static long f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224714);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224714);
      return 0L;
    }
    paramString2 = i(paramString1, paramString2);
    if (paramString2 != null) {
      paramString2.g = "End";
    }
    long l = a(paramString2);
    if (l != -1L) {
      ab.remove(paramString1);
    }
    AppMethodBeat.o(224714);
    return l;
  }
  
  public static kl.a f(String paramString)
  {
    AppMethodBeat.i(224815);
    aa.incrementAndGet();
    kl.a locala = (kl.a)Z.a();
    locala.b = paramString;
    AppMethodBeat.o(224815);
    return locala;
  }
  
  private static int g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224683);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224683);
      return -1;
    }
    Map localMap;
    if (h(paramString1))
    {
      localMap = (Map)ab.get(paramString1);
      if (localMap == null) {
        break label116;
      }
    }
    label116:
    for (paramString1 = (c)localMap.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.b(paramString2);
        if ((paramString1 instanceof AtomicInteger))
        {
          int j = ((AtomicInteger)paramString1).decrementAndGet();
          int i = j;
          if (j < 0)
          {
            ((AtomicInteger)paramString1).set(0);
            i = 0;
          }
          AppMethodBeat.o(224683);
          return i;
        }
      }
      AppMethodBeat.o(224683);
      return -1;
    }
  }
  
  public static void g(String paramString)
  {
    AppMethodBeat.i(224823);
    Y.add(paramString);
    AppMethodBeat.o(224823);
  }
  
  private static long h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224735);
    if (!h(paramString1))
    {
      AppMethodBeat.o(224735);
      return 0L;
    }
    long l = a(paramString1, paramString1, paramString2, "", null);
    AppMethodBeat.o(224735);
    return l;
  }
  
  private static boolean h(String paramString)
  {
    AppMethodBeat.i(224460);
    if ((kh.d("TT")) && (!Y.contains(paramString)))
    {
      AppMethodBeat.o(224460);
      return true;
    }
    AppMethodBeat.o(224460);
    return false;
  }
  
  private static c i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224772);
    paramString1 = (Map)ab.get(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = (c)paramString1.get(paramString2);; paramString1 = null)
    {
      if ((paramString1 != null) && (paramString1.a(paramString2)))
      {
        AppMethodBeat.o(224772);
        return paramString1;
      }
      AppMethodBeat.o(224772);
      return null;
    }
  }
  
  private static String i(String paramString)
  {
    return paramString;
  }
  
  private static boolean j(String paramString)
  {
    AppMethodBeat.i(224794);
    if (i(paramString, paramString) != null)
    {
      AppMethodBeat.o(224794);
      return true;
    }
    AppMethodBeat.o(224794);
    return false;
  }
  
  private static boolean j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224802);
    if (i(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(224802);
      return true;
    }
    AppMethodBeat.o(224802);
    return false;
  }
  
  private static void k(String paramString)
  {
    AppMethodBeat.i(224834);
    ??? = kj.d();
    if ((ac != null) && (!((String)ac.first).equals(???))) {
      e();
    }
    if (ac == null) {
      ac = new Pair(???, new StringBuilder());
    }
    StringBuilder localStringBuilder = (StringBuilder)ac.second;
    synchronized (ac)
    {
      localStringBuilder.append(System.currentTimeMillis()).append(" : ").append(paramString);
      if (localStringBuilder.length() >= 10240)
      {
        kh.f("TT", localStringBuilder.toString());
        ac = null;
      }
      AppMethodBeat.o(224834);
      return;
    }
  }
  
  private static String l(String paramString)
  {
    return paramString;
  }
  
  public static final class c
  {
    AtomicInteger a;
    String b;
    List<Long> c;
    kl.b d;
    Map<String, Object> e;
    String f;
    String g;
    private String h;
    
    c(String paramString1, String paramString2)
    {
      AppMethodBeat.i(221622);
      this.c = new CopyOnWriteArrayList();
      this.h = paramString1;
      this.b = paramString2;
      this.a = new AtomicInteger(0);
      AppMethodBeat.o(221622);
    }
    
    public final String a()
    {
      AppMethodBeat.i(221708);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      if (!TextUtils.isEmpty(this.g)) {
        ((StringBuilder)localObject).append(this.g);
      }
      if (!this.h.equals(this.b)) {
        ((StringBuilder)localObject).append("|").append(this.h).append("|").append(this.b);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.f)) {
          ((StringBuilder)localObject).append("|").append(this.f);
        }
        ((StringBuilder)localObject).append("]");
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(221708);
        return localObject;
        ((StringBuilder)localObject).append("|").append(this.h);
      }
    }
    
    public final void a(String paramString, Object paramObject)
    {
      AppMethodBeat.i(221712);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(221712);
        return;
      }
      if (this.e == null) {
        this.e = new Hashtable();
      }
      this.e.put(paramString, paramObject);
      AppMethodBeat.o(221712);
    }
    
    final boolean a(String paramString)
    {
      AppMethodBeat.i(221696);
      boolean bool = this.b.equals(paramString);
      AppMethodBeat.o(221696);
      return bool;
    }
    
    public final Object b(String paramString)
    {
      AppMethodBeat.i(221719);
      if (this.e != null)
      {
        paramString = this.e.get(paramString);
        AppMethodBeat.o(221719);
        return paramString;
      }
      AppMethodBeat.o(221719);
      return null;
    }
    
    final void b()
    {
      AppMethodBeat.i(221736);
      this.a.set(0);
      this.c.clear();
      this.d = null;
      if (this.e != null) {
        this.e.clear();
      }
      AppMethodBeat.o(221736);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221728);
      String str = "TraceInfo{id='" + this.b + '\'' + ", values=" + this.e + '}';
      AppMethodBeat.o(221728);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kl
 * JD-Core Version:    0.7.0.1
 */