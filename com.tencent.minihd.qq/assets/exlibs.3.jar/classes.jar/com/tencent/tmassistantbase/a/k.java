package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class k
{
  private static Boolean A = Boolean.valueOf(true);
  private static ThreadLocal B = new l();
  protected static boolean a = false;
  protected static String b = "";
  protected static int c = 2;
  protected static int d = 4;
  protected static boolean e = true;
  protected static boolean f = false;
  protected static boolean g = false;
  protected static Context h;
  protected static boolean i = false;
  static LinkedBlockingQueue j;
  protected static BufferedWriter k;
  static long l = 0L;
  static final ReentrantLock m = new ReentrantLock();
  protected static int n;
  protected static String o = "";
  protected static String p = "";
  protected static long q = 0L;
  protected static SimpleDateFormat r = new SimpleDateFormat("yy-MM-dd HH:mm");
  protected static AtomicBoolean s = new AtomicBoolean(false);
  protected static AtomicBoolean t = new AtomicBoolean(false);
  protected static final int[] u = { 1, 2, 4, 8, 16, 29 };
  protected static AtomicInteger v = new AtomicInteger(0);
  protected static Handler w = new Handler(Looper.getMainLooper());
  protected static Runnable x = new m();
  static Thread y = new o();
  private static Field z;
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((paramInt < c()) && (paramInt < b())) {}
    label131:
    label141:
    label151:
    label161:
    label171:
    label179:
    for (;;)
    {
      return;
      if ((!e()) || (paramInt >= b()))
      {
        if ((paramInt == 2) && (a()))
        {
          if (paramThrowable != null) {
            break label131;
          }
          Log.v(paramString1, paramString2);
        }
        if ((paramInt == 3) && (a()))
        {
          if (paramThrowable != null) {
            break label141;
          }
          Log.d(paramString1, paramString2);
        }
        label70:
        if (paramInt == 4)
        {
          if (paramThrowable != null) {
            break label151;
          }
          Log.i(paramString1, paramString2);
        }
        label85:
        if (paramInt == 5)
        {
          if (paramThrowable != null) {
            break label161;
          }
          Log.w(paramString1, paramString2);
        }
        label100:
        if (paramInt == 6)
        {
          if (paramThrowable != null) {
            break label171;
          }
          Log.e(paramString1, paramString2);
        }
      }
      for (;;)
      {
        if (paramInt < c()) {
          break label179;
        }
        b(paramInt, paramString1, paramString2, paramThrowable);
        return;
        Log.v(paramString1, paramString2, paramThrowable);
        break;
        Log.d(paramString1, paramString2, paramThrowable);
        break label70;
        Log.i(paramString1, paramString2, paramThrowable);
        break label85;
        Log.w(paramString1, paramString2, paramThrowable);
        break label100;
        Log.e(paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (!i)
      {
        h = paramContext;
        x.run();
        i = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")) && (paramString.endsWith("/"))) {
      b = paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static int b()
  {
    return c;
  }
  
  public static void b(int paramInt)
  {
    d = paramInt;
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!g()) {}
    do
    {
      return;
      long l1 = Thread.currentThread().getId();
      StringBuilder localStringBuilder = l();
      if (f()) {
        localStringBuilder.append(i()).append("|");
      }
      localStringBuilder.append(c(paramInt)).append("|pid=").append(n).append("|tid=").append(String.valueOf(l1)).append("|").append(paramString1).append("|").append(paramString2).append("\n");
      paramString1 = localStringBuilder;
      if (paramThrowable != null) {
        paramString1 = localStringBuilder.append("\n").append(Log.getStackTraceString(paramThrowable)).append("\n");
      }
    } while (c(paramString1.toString()));
    Log.d("TMLog", "addLogToCache failed!");
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void b(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static int c()
  {
    return d;
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "D";
    case 2: 
      return "V";
    case 3: 
      return "D";
    case 4: 
      return "I";
    case 5: 
      return "W";
    }
    return "E";
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      j.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void d(String paramString)
  {
    if (!g()) {
      return;
    }
    long l1;
    if (k == null)
    {
      Log.d("TMLog", "can not write log.");
      l1 = System.currentTimeMillis();
      if (l == 0L) {
        l = l1;
      }
    }
    for (;;)
    {
      s.compareAndSet(true, false);
      return;
      if (l1 - l > 60000L)
      {
        try
        {
          m();
          l = l1;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        if (m.tryLock()) {}
        try
        {
          k.write(paramString);
          if (!d()) {
            k.flush();
          }
          m.unlock();
        }
        finally
        {
          m.unlock();
        }
        Log.d("TMLog", "addLogToCache failed!");
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2, null);
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return g;
  }
  
  public static boolean g()
  {
    return a;
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(b)) {
      b = Environment.getExternalStorageDirectory().getPath() + "/tencent/TMAssistantSDK/Logs/";
    }
    return b;
  }
  
  public static String i()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - q > 60000L)
    {
      q = l1;
      p = r.format(Long.valueOf(q));
    }
    return p;
  }
  
  private static StringBuilder l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (A.booleanValue())
      {
        z = StringBuilder.class.getSuperclass().getDeclaredField("value");
        z.setAccessible(true);
        A = Boolean.valueOf(false);
      }
      if (z != null) {
        z.set(localStringBuilder, B.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  /* Error */
  private static void m()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 271
    //   6: ldc_w 393
    //   9: invokestatic 167	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   12: pop
    //   13: new 341	java/io/File
    //   16: dup
    //   17: invokestatic 395	com/tencent/tmassistantbase/a/k:h	()Ljava/lang/String;
    //   20: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 399	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_1
    //   32: invokevirtual 402	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 341	java/io/File
    //   39: dup
    //   40: new 237	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 395	com/tencent/tmassistantbase/a/k:h	()Ljava/lang/String;
    //   50: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 81	com/tencent/tmassistantbase/a/k:o	Ljava/lang/String;
    //   56: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 404
    //   62: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 399	java/io/File:exists	()Z
    //   76: ifne +143 -> 219
    //   79: aload_1
    //   80: invokevirtual 407	java/io/File:createNewFile	()Z
    //   83: istore_0
    //   84: invokestatic 409	com/tencent/tmassistantbase/a/k:n	()V
    //   87: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   90: ifnull +100 -> 190
    //   93: invokestatic 217	com/tencent/tmassistantbase/a/k:g	()Z
    //   96: ifeq +94 -> 190
    //   99: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   102: new 237	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   109: invokestatic 235	com/tencent/tmassistantbase/a/k:i	()Ljava/lang/String;
    //   112: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 243
    //   117: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 81	com/tencent/tmassistantbase/a/k:o	Ljava/lang/String;
    //   123: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 243
    //   128: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 414	android/os/Build:MODEL	Ljava/lang/String;
    //   134: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 416
    //   140: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: getstatic 421	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   146: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 423
    //   152: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 426	java/io/File:getName	()Ljava/lang/String;
    //   159: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 416
    //   165: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_0
    //   169: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   172: ldc_w 260
    //   175: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 324	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   184: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   187: invokevirtual 329	java/io/BufferedWriter:flush	()V
    //   190: new 321	java/io/BufferedWriter
    //   193: dup
    //   194: new 431	java/io/FileWriter
    //   197: dup
    //   198: aload_1
    //   199: iconst_1
    //   200: invokespecial 434	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   203: sipush 8192
    //   206: invokespecial 437	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   209: putstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   212: invokestatic 409	com/tencent/tmassistantbase/a/k:n	()V
    //   215: ldc 2
    //   217: monitorexit
    //   218: return
    //   219: aload_1
    //   220: invokevirtual 440	java/io/File:length	()J
    //   223: ldc2_w 441
    //   226: lcmp
    //   227: iflt +49 -> 276
    //   230: aload_1
    //   231: invokevirtual 445	java/io/File:delete	()Z
    //   234: pop
    //   235: aload_1
    //   236: invokevirtual 407	java/io/File:createNewFile	()Z
    //   239: pop
    //   240: ldc_w 271
    //   243: new 237	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 447
    //   253: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 426	java/io/File:getName	()Ljava/lang/String;
    //   260: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 449
    //   266: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 167	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: invokestatic 409	com/tencent/tmassistantbase/a/k:n	()V
    //   279: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   282: ifnull -92 -> 190
    //   285: invokestatic 217	com/tencent/tmassistantbase/a/k:g	()Z
    //   288: ifeq -98 -> 190
    //   291: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   294: new 237	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   301: invokestatic 235	com/tencent/tmassistantbase/a/k:i	()Ljava/lang/String;
    //   304: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 243
    //   309: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: getstatic 81	com/tencent/tmassistantbase/a/k:o	Ljava/lang/String;
    //   315: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 243
    //   320: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: getstatic 414	android/os/Build:MODEL	Ljava/lang/String;
    //   326: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 416
    //   332: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: getstatic 421	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   338: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 451
    //   344: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_1
    //   348: invokevirtual 426	java/io/File:getName	()Ljava/lang/String;
    //   351: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 453
    //   357: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokevirtual 324	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   366: getstatic 298	com/tencent/tmassistantbase/a/k:k	Ljava/io/BufferedWriter;
    //   369: invokevirtual 329	java/io/BufferedWriter:flush	()V
    //   372: goto -182 -> 190
    //   375: astore_2
    //   376: aload_2
    //   377: invokevirtual 454	java/lang/Throwable:printStackTrace	()V
    //   380: goto -190 -> 190
    //   383: astore_1
    //   384: ldc 2
    //   386: monitorexit
    //   387: aload_1
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   83	86	0	bool	boolean
    //   23	325	1	localFile	File
    //   383	5	1	localObject	Object
    //   375	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   72	190	375	java/lang/Throwable
    //   219	276	375	java/lang/Throwable
    //   276	372	375	java/lang/Throwable
    //   3	36	383	finally
    //   36	72	383	finally
    //   72	190	383	finally
    //   190	215	383	finally
    //   219	276	383	finally
    //   276	372	383	finally
    //   376	380	383	finally
  }
  
  private static void n()
  {
    if ((k != null) && (g()))
    {
      k.write("SDK_VERSION = 1.0|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
      k.flush();
    }
  }
  
  /* Error */
  private static void o()
  {
    // Byte code:
    //   0: ldc_w 460
    //   3: invokestatic 463	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +465 -> 474
    //   12: new 468	java/util/Properties
    //   15: dup
    //   16: invokespecial 469	java/util/Properties:<init>	()V
    //   19: astore_1
    //   20: new 341	java/io/File
    //   23: dup
    //   24: new 237	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 339	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   34: invokevirtual 344	java/io/File:getPath	()Ljava/lang/String;
    //   37: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 471
    //   43: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 399	java/io/File:exists	()Z
    //   57: ifne +4 -> 61
    //   60: return
    //   61: aload_1
    //   62: new 473	java/io/FileInputStream
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 476	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: invokevirtual 480	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: ldc_w 482
    //   77: ldc 56
    //   79: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 489	java/lang/String:trim	()Ljava/lang/String;
    //   87: ldc_w 491
    //   90: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +340 -> 433
    //   96: iconst_1
    //   97: invokestatic 493	com/tencent/tmassistantbase/a/k:c	(Z)V
    //   100: aload_1
    //   101: ldc_w 495
    //   104: ldc 56
    //   106: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore_0
    //   115: iload_0
    //   116: ifne +13 -> 129
    //   119: aload_3
    //   120: invokestatic 500	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   123: invokevirtual 503	java/lang/Integer:intValue	()I
    //   126: invokestatic 505	com/tencent/tmassistantbase/a/k:b	(I)V
    //   129: aload_1
    //   130: ldc_w 507
    //   133: ldc 56
    //   135: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: istore_0
    //   146: iload_0
    //   147: ifne +14 -> 161
    //   150: aload 4
    //   152: invokestatic 500	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   155: invokevirtual 503	java/lang/Integer:intValue	()I
    //   158: invokestatic 509	com/tencent/tmassistantbase/a/k:a	(I)V
    //   161: aload_1
    //   162: ldc_w 511
    //   165: ldc 56
    //   167: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 5
    //   172: aload 5
    //   174: invokestatic 513	com/tencent/tmassistantbase/a/k:a	(Ljava/lang/String;)V
    //   177: aload_1
    //   178: ldc_w 515
    //   181: ldc 56
    //   183: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 6
    //   188: aload 6
    //   190: invokevirtual 489	java/lang/String:trim	()Ljava/lang/String;
    //   193: ldc_w 517
    //   196: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +261 -> 460
    //   202: iconst_0
    //   203: invokestatic 519	com/tencent/tmassistantbase/a/k:a	(Z)V
    //   206: aload_1
    //   207: ldc_w 521
    //   210: ldc 56
    //   212: invokevirtual 486	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 489	java/lang/String:trim	()Ljava/lang/String;
    //   218: ldc_w 491
    //   221: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +243 -> 467
    //   227: iconst_1
    //   228: invokestatic 523	com/tencent/tmassistantbase/a/k:b	(Z)V
    //   231: ldc_w 271
    //   234: new 237	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 525
    //   244: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 527
    //   254: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_3
    //   258: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 529
    //   264: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 4
    //   269: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 531
    //   275: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 533
    //   286: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 6
    //   291: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc_w 535
    //   297: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokestatic 158	com/tencent/tmassistantbase/a/k:e	()Z
    //   303: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: ldc_w 537
    //   309: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokestatic 232	com/tencent/tmassistantbase/a/k:f	()Z
    //   315: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 167	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   324: pop
    //   325: ldc_w 271
    //   328: new 237	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 539
    //   338: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 217	com/tencent/tmassistantbase/a/k:g	()Z
    //   344: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: ldc_w 527
    //   350: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokestatic 153	com/tencent/tmassistantbase/a/k:c	()I
    //   356: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 529
    //   362: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokestatic 155	com/tencent/tmassistantbase/a/k:b	()I
    //   368: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 531
    //   374: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokestatic 395	com/tencent/tmassistantbase/a/k:h	()Ljava/lang/String;
    //   380: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 533
    //   386: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokestatic 326	com/tencent/tmassistantbase/a/k:d	()Z
    //   392: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: ldc_w 535
    //   398: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokestatic 158	com/tencent/tmassistantbase/a/k:e	()Z
    //   404: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: ldc_w 537
    //   410: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokestatic 232	com/tencent/tmassistantbase/a/k:f	()Z
    //   416: invokevirtual 429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 167	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   425: pop
    //   426: return
    //   427: astore_1
    //   428: aload_1
    //   429: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: iconst_0
    //   434: invokestatic 493	com/tencent/tmassistantbase/a/k:c	(Z)V
    //   437: goto -337 -> 100
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 540	java/lang/NumberFormatException:printStackTrace	()V
    //   447: goto -318 -> 129
    //   450: astore 5
    //   452: aload 5
    //   454: invokevirtual 540	java/lang/NumberFormatException:printStackTrace	()V
    //   457: goto -296 -> 161
    //   460: iconst_1
    //   461: invokestatic 519	com/tencent/tmassistantbase/a/k:a	(Z)V
    //   464: goto -258 -> 206
    //   467: iconst_0
    //   468: invokestatic 523	com/tencent/tmassistantbase/a/k:b	(Z)V
    //   471: goto -240 -> 231
    //   474: iconst_0
    //   475: invokestatic 493	com/tencent/tmassistantbase/a/k:c	(Z)V
    //   478: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   114	33	0	bool	boolean
    //   19	188	1	localProperties	java.util.Properties
    //   427	2	1	localIOException	IOException
    //   52	196	2	localObject	Object
    //   109	149	3	str1	String
    //   138	130	4	str2	String
    //   440	3	4	localNumberFormatException1	java.lang.NumberFormatException
    //   170	109	5	str3	String
    //   450	3	5	localNumberFormatException2	java.lang.NumberFormatException
    //   186	104	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   20	60	427	java/io/IOException
    //   61	100	427	java/io/IOException
    //   100	115	427	java/io/IOException
    //   119	129	427	java/io/IOException
    //   129	146	427	java/io/IOException
    //   150	161	427	java/io/IOException
    //   161	206	427	java/io/IOException
    //   206	231	427	java/io/IOException
    //   231	426	427	java/io/IOException
    //   433	437	427	java/io/IOException
    //   442	447	427	java/io/IOException
    //   452	457	427	java/io/IOException
    //   460	464	427	java/io/IOException
    //   467	471	427	java/io/IOException
    //   119	129	440	java/lang/NumberFormatException
    //   150	161	450	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.k
 * JD-Core Version:    0.7.0.1
 */