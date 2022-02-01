package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class o
{
  private static long A = 0L;
  private static String B;
  private static String C;
  private static FileWriter D;
  private static AtomicBoolean E;
  private static int F = 0;
  private static long G = 0L;
  private static AtomicBoolean H;
  private static final int[] I;
  private static AtomicInteger J;
  private static Handler K;
  private static volatile Context L;
  private static String M = "";
  private static boolean N = false;
  private static final String[] O = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private static final String P = "MSF.D.QLogImpl";
  private static final String Q = "QLog";
  private static final String R = "";
  private static boolean S = false;
  private static long T = 0L;
  protected static int a = 0;
  protected static final boolean b = false;
  protected static boolean c = false;
  protected static Object d;
  public static final String e = "LOGLEVEL_";
  public static final String f = "LOGLEVELTIME";
  public static final String g = "LOGSAVETIME";
  static k h;
  static final ReentrantLock i;
  public static Runnable j;
  static String k = "";
  static long l = 0L;
  static Thread m = new s();
  public static final String n = "D";
  public static final String o = "W";
  public static final String p = "E";
  static HashSet q = new HashSet();
  static long r = 0L;
  private static Field s;
  private static Boolean t = Boolean.valueOf(true);
  private static ThreadLocal u = new p();
  private static final String v = "appMemory";
  private static int w;
  private static String x;
  private static String y;
  private static long z;
  
  static
  {
    a = 1;
    w = a;
    c = true;
    d = new Object();
    x = "";
    y = "";
    B = "";
    C = "";
    h = new k(15000);
    i = new ReentrantLock();
    E = new AtomicBoolean(false);
    G = 0L;
    H = new AtomicBoolean(false);
    I = new int[] { 1, 2, 4, 8, 16, 29 };
    J = new AtomicInteger(0);
    K = new Handler(Looper.getMainLooper());
    L = null;
    j = new q();
  }
  
  public static String a()
  {
    int i1 = B.indexOf(":");
    if (i1 > 0) {
      return B.substring(0, i1);
    }
    return B;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String a(String paramString)
  {
    return B.replace(":", "_") + "." + paramString + ".log";
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = p();
    localStringBuilder.append("[");
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append("]");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    int i1 = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("QLog", 0);
    long l1 = ((SharedPreferences)localObject).getLong("", -1L);
    if ((l1 == -1L) || (System.currentTimeMillis() - l1 > 3600000L))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      i1 = 1;
    }
    if (i1 != 0)
    {
      paramString1 = new t(paramInt, paramString1, paramString2);
      paramString1.setName("doReportLogSelfThread");
      paramString1.start();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + ".zip";
    File localFile = new File(str);
    localFile.delete();
    try
    {
      localFile.createNewFile();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new a(paramString1));
      f.a(localArrayList, str);
      f.a(paramInt, str, paramString2, paramString3);
      localFile.delete();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf error " + paramString1);
    }
  }
  
  /* Error */
  static void a(long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 172	com/tencent/mobileqq/msf/sdk/o:L	Landroid/content/Context;
    //   6: invokestatic 354	com/tencent/mobileqq/msf/sdk/o:b	(Landroid/content/Context;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: new 219	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   25: invokestatic 360	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   28: invokevirtual 363	java/io/File:getPath	()Ljava/lang/String;
    //   31: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 365
    //   37: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 127	com/tencent/mobileqq/msf/sdk/o:C	Ljava/lang/String;
    //   43: ldc 232
    //   45: ldc_w 367
    //   48: invokevirtual 226	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   51: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 367
    //   57: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: putstatic 121	com/tencent/mobileqq/msf/sdk/o:x	Ljava/lang/String;
    //   66: new 219	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   73: invokestatic 360	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   76: invokevirtual 363	java/io/File:getPath	()Ljava/lang/String;
    //   79: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 369
    //   85: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 127	com/tencent/mobileqq/msf/sdk/o:C	Ljava/lang/String;
    //   91: ldc 232
    //   93: ldc_w 367
    //   96: invokevirtual 226	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   99: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 367
    //   105: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: putstatic 123	com/tencent/mobileqq/msf/sdk/o:y	Ljava/lang/String;
    //   114: new 312	java/io/File
    //   117: dup
    //   118: getstatic 121	com/tencent/mobileqq/msf/sdk/o:x	Ljava/lang/String;
    //   121: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore 4
    //   126: aload 4
    //   128: invokevirtual 372	java/io/File:exists	()Z
    //   131: ifne +9 -> 140
    //   134: aload 4
    //   136: invokevirtual 375	java/io/File:mkdirs	()Z
    //   139: pop
    //   140: new 219	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   147: getstatic 121	com/tencent/mobileqq/msf/sdk/o:x	Ljava/lang/String;
    //   150: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload_0
    //   154: invokestatic 378	com/tencent/mobileqq/msf/sdk/o:b	(J)Ljava/lang/String;
    //   157: invokestatic 380	com/tencent/mobileqq/msf/sdk/o:a	(Ljava/lang/String;)Ljava/lang/String;
    //   160: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: putstatic 189	com/tencent/mobileqq/msf/sdk/o:k	Ljava/lang/String;
    //   169: new 312	java/io/File
    //   172: dup
    //   173: getstatic 189	com/tencent/mobileqq/msf/sdk/o:k	Ljava/lang/String;
    //   176: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: astore_3
    //   180: aload_3
    //   181: invokevirtual 372	java/io/File:exists	()Z
    //   184: ifne +152 -> 336
    //   187: aload_3
    //   188: invokevirtual 320	java/io/File:createNewFile	()Z
    //   191: istore_2
    //   192: invokestatic 382	com/tencent/mobileqq/msf/sdk/o:q	()V
    //   195: aload_3
    //   196: astore 4
    //   198: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   201: ifnull +110 -> 311
    //   204: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   207: new 219	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   214: getstatic 179	com/tencent/mobileqq/msf/sdk/o:M	Ljava/lang/String;
    //   217: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 386
    //   223: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: getstatic 125	com/tencent/mobileqq/msf/sdk/o:B	Ljava/lang/String;
    //   229: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 388
    //   235: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 40
    //   240: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 386
    //   246: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: getstatic 393	android/os/Build:MODEL	Ljava/lang/String;
    //   252: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 395
    //   258: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: getstatic 400	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   264: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 402
    //   270: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_3
    //   274: invokevirtual 405	java/io/File:getName	()Ljava/lang/String;
    //   277: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 395
    //   283: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_2
    //   287: invokevirtual 408	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: ldc_w 410
    //   293: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 415	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   302: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   305: invokevirtual 418	java/io/FileWriter:flush	()V
    //   308: aload_3
    //   309: astore 4
    //   311: new 412	java/io/FileWriter
    //   314: dup
    //   315: aload 4
    //   317: iconst_1
    //   318: invokespecial 421	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   321: putstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   324: invokestatic 382	com/tencent/mobileqq/msf/sdk/o:q	()V
    //   327: goto -313 -> 14
    //   330: astore_3
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload_3
    //   335: athrow
    //   336: invokestatic 382	com/tencent/mobileqq/msf/sdk/o:q	()V
    //   339: aload_3
    //   340: astore 4
    //   342: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   345: ifnull -34 -> 311
    //   348: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   351: new 219	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   358: getstatic 179	com/tencent/mobileqq/msf/sdk/o:M	Ljava/lang/String;
    //   361: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 386
    //   367: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: getstatic 125	com/tencent/mobileqq/msf/sdk/o:B	Ljava/lang/String;
    //   373: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 423
    //   379: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 40
    //   384: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 386
    //   390: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: getstatic 393	android/os/Build:MODEL	Ljava/lang/String;
    //   396: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 395
    //   402: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: getstatic 400	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   408: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc_w 425
    //   414: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_3
    //   418: invokevirtual 405	java/io/File:getName	()Ljava/lang/String;
    //   421: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc_w 427
    //   427: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokevirtual 415	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   436: getstatic 384	com/tencent/mobileqq/msf/sdk/o:D	Ljava/io/FileWriter;
    //   439: invokevirtual 418	java/io/FileWriter:flush	()V
    //   442: aload_3
    //   443: astore 4
    //   445: goto -134 -> 311
    //   448: astore 4
    //   450: aload 4
    //   452: invokevirtual 428	java/lang/Throwable:printStackTrace	()V
    //   455: aload_3
    //   456: astore 4
    //   458: goto -147 -> 311
    //   461: astore 5
    //   463: aload 4
    //   465: astore_3
    //   466: aload 5
    //   468: astore 4
    //   470: goto -20 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramLong	long
    //   9	278	2	bool	boolean
    //   179	130	3	localFile	File
    //   330	126	3	localObject1	Object
    //   465	1	3	localObject2	Object
    //   124	320	4	localObject3	Object
    //   448	3	4	localThrowable1	Throwable
    //   456	13	4	localObject4	Object
    //   461	6	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	10	330	finally
    //   18	140	330	finally
    //   140	169	330	finally
    //   169	180	330	finally
    //   180	195	330	finally
    //   198	308	330	finally
    //   311	327	330	finally
    //   336	339	330	finally
    //   342	442	330	finally
    //   450	455	330	finally
    //   180	195	448	java/lang/Throwable
    //   198	308	448	java/lang/Throwable
    //   336	339	448	java/lang/Throwable
    //   342	442	448	java/lang/Throwable
    //   169	180	461	java/lang/Throwable
  }
  
  public static void a(Context paramContext)
  {
    L = paramContext.getApplicationContext();
    j.run();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.e(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.e(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Log.d("MSF.D.QLogImpl", "[s]" + paramString2);
  }
  
  private static void a(Calendar paramCalendar)
  {
    paramCalendar.add(11, 1);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    z = paramCalendar.getTimeInMillis();
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
    j.run();
  }
  
  public static void a(String[] paramArrayOfString)
  {
    r = System.currentTimeMillis();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.add(str);
      i1 += 1;
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.remove(str);
      i1 += 1;
    }
    if (paramBoolean) {
      a(paramInt, "mobileqq", paramString);
    }
  }
  
  public static String b()
  {
    return x;
  }
  
  private static String b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    Object localObject = new SimpleDateFormat("yy.MM.dd.HH");
    M = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    b(localCalendar);
    a(localCalendar);
    return localObject;
  }
  
  public static void b(int paramInt)
  {
    w = paramInt;
    QLog.d("MSF.D.QLogImpl", 1, "set UIN_REPORTLOG_LEVEL " + e());
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, paramString2, null);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.w(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.w(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  private static void b(Calendar paramCalendar)
  {
    paramCalendar.set(14, 0);
    A = paramCalendar.getTimeInMillis() + 1000L;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = N;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(O[0]) == 0)
        {
          N = true;
          bool1 = N;
        }
      }
    }
    return bool1;
    label48:
    N = true;
    return N;
  }
  
  public static String c()
  {
    return y;
  }
  
  /* Error */
  private static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lload_0
    //   4: getstatic 537	com/tencent/mobileqq/msf/sdk/o:A	J
    //   7: lcmp
    //   8: ifle +34 -> 42
    //   11: getstatic 119	com/tencent/mobileqq/msf/sdk/o:d	Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: getstatic 554	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:timeFormatter	Ljava/text/SimpleDateFormat;
    //   20: lload_0
    //   21: invokestatic 504	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: invokevirtual 508	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: putstatic 179	com/tencent/mobileqq/msf/sdk/o:M	Ljava/lang/String;
    //   30: getstatic 537	com/tencent/mobileqq/msf/sdk/o:A	J
    //   33: ldc2_w 534
    //   36: ladd
    //   37: putstatic 537	com/tencent/mobileqq/msf/sdk/o:A	J
    //   40: aload_2
    //   41: monitorexit
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: astore_3
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    //   51: astore_2
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramLong	long
    //   51	5	2	localObject2	Object
    //   46	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	42	46	finally
    //   47	49	46	finally
    //   3	17	51	finally
    //   49	51	51	finally
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    c(paramString1, paramInt, paramString2, null);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.i(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.i(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static SimpleDateFormat d()
  {
    return new SimpleDateFormat("yy.MM.dd.HH");
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.d(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.d(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static int e()
  {
    return w;
  }
  
  private static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (!c) {}
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if (l1 >= A) {
        c(l1);
      }
      if ((r != 0L) && (l1 - r > 1800000L))
      {
        r = 0L;
        q.clear();
      }
      String str = a(paramInt);
      l1 = Thread.currentThread().getId();
      StringBuilder localStringBuilder = p();
      localStringBuilder.append(M);
      localStringBuilder.append("|");
      localStringBuilder.append(B);
      localStringBuilder.append("[");
      localStringBuilder.append(F);
      localStringBuilder.append("]|");
      localStringBuilder.append(l1);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\n");
      if (paramThrowable != null)
      {
        localStringBuilder.append("\n");
        localStringBuilder.append(Log.getStackTraceString(paramThrowable));
        localStringBuilder.append("\n");
      }
      if (!f(localStringBuilder.toString()))
      {
        Log.d("QLogImpl", "addLogToCache failed!");
        return;
      }
    } while ((BaseApplication.getContext() == null) || (System.currentTimeMillis() - G <= 180000L));
    G = System.currentTimeMillis();
    r();
  }
  
  public static String f()
  {
    return B;
  }
  
  private static boolean f(String paramString)
  {
    try
    {
      h.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean g()
  {
    return w > 1;
  }
  
  private static boolean g(String paramString)
  {
    try
    {
      h.a(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void h(String paramString)
  {
    try
    {
      if (!c) {
        return;
      }
      if (!s()) {
        return;
      }
      if (D != null) {
        break label126;
      }
      System.out.println("can not write log.");
      l1 = System.currentTimeMillis();
      if (l != 0L) {
        break label91;
      }
      l = l1;
    }
    catch (Throwable paramString)
    {
      long l1;
      while (((paramString instanceof IOException)) && (paramString.getMessage().contains("ENOSPC")))
      {
        if (!H.compareAndSet(false, true)) {
          return;
        }
        paramString.printStackTrace();
        return;
        label91:
        long l2 = l;
        if (l1 - l2 > 60000L)
        {
          try
          {
            a(System.currentTimeMillis());
            l = l1;
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
          label126:
          l1 = System.currentTimeMillis();
          if (l1 > z) {
            a(l1);
          }
          boolean bool = i.tryLock();
          if (bool) {}
          try
          {
            D.write(paramString);
            D.flush();
            i.unlock();
          }
          finally
          {
            i.unlock();
          }
          Log.d("QLogImpl", "insertLogToCacheHead failed!");
        }
      }
      H.compareAndSet(true, false);
      paramString.printStackTrace();
      try
      {
        a(System.currentTimeMillis());
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    H.compareAndSet(true, false);
    return;
  }
  
  public static boolean h()
  {
    return w >= 4;
  }
  
  private static StringBuilder p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (t.booleanValue())
      {
        s = StringBuilder.class.getSuperclass().getDeclaredField("value");
        s.setAccessible(true);
        t = Boolean.valueOf(false);
      }
      if (s != null) {
        s.set(localStringBuilder, u.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  private static void q()
    throws IOException
  {
    if ((D != null) && (!"".equals(QLog.sBuildNumber)))
    {
      D.write(M + "|" + B + "|D||QQ_Version: " + QLog.sBuildNumber + "\r\n");
      D.flush();
    }
  }
  
  private static void r()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      if (QLog.isColorLevel()) {
        d("appMemory", 2, "availMem:" + localMemoryInfo.availMem / 1024L / 1024L + "M" + " lowThreshold:" + localMemoryInfo.threshold / 1024L / 1024L + "M");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      d("appMemory", 2, "printMemError " + localException, localException);
    }
  }
  
  private static boolean s()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - T > 2000L)
    {
      S = "mounted".equals(Environment.getExternalStorageState());
      T = l1;
    }
    return S;
  }
  
  public static class a
    extends File
  {
    public String a = "";
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    public a(String paramString)
    {
      super();
    }
  }
  
  protected static class b
  {
    String a;
    String b;
    String c;
    Throwable d;
    
    public b(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.o
 * JD-Core Version:    0.7.0.1
 */