package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.tracer.SignalAnrTracer;
import com.tencent.matrix.trace.tracer.SignalAnrTracer.a;
import com.tencent.matrix.trace.tracer.ThreadPriorityTracer;
import com.tencent.matrix.trace.tracer.ThreadPriorityTracer.a;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.CoreService.b;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.crash.CrashUploaderService;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.performance.watchdogs.d.b;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.threadpool.i;
import com.tencent.xweb.ao;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import junit.framework.AssertionFailedError;

public final class w
  implements CoreService.b, ICrashReporter, MMUncaughtExceptionHandler.IReporter
{
  public static final long hgL = ;
  private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> hgP = new HashSet();
  private static final Set<ICrashReporter.ICrashReportListener> hgQ = new HashSet();
  private static String hgV = "";
  private static String hgW = null;
  private static long hgX = 0L;
  private static boolean hgY = false;
  private static boolean hgZ = false;
  private static boolean hha = false;
  private static long[] hhb = { 0L, 0L, 0L };
  private static CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter = new w.1();
  private MMUncaughtExceptionHandler hgM = null;
  private a hgN;
  private volatile long hgO = 0L;
  HashSet<String> hgR;
  String hgS;
  String hgT;
  ConditionVariable hgU;
  volatile b hhc;
  
  private static String a(d.b paramb)
  {
    if (paramb != null) {
      return "\n" + paramb.gzz();
    }
    return "";
  }
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 119	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 146	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc 148
    //   21: invokespecial 149	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: new 119	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 151
    //   32: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload_1
    //   36: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 156
    //   41: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 4
    //   51: ifnull +19 -> 70
    //   54: aload 9
    //   56: aload 4
    //   58: getfield 161	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   61: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 10
    //   66: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 166	java/io/BufferedReader
    //   73: dup
    //   74: new 168	java/io/FileReader
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 169	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: iload 5
    //   89: istore_1
    //   90: aload 4
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: ifnull +245 -> 347
    //   105: iload_1
    //   106: tableswitch	default:+293 -> 399, 0:+26->132, 1:+99->205, 2:+157->263
    //   133: iconst_1
    //   134: astore_0
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -52 -> 90
    //   145: aload 4
    //   147: astore_0
    //   148: aload 11
    //   150: invokevirtual 185	java/lang/String:length	()I
    //   153: istore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 10
    //   160: aload 12
    //   162: iload 5
    //   164: iload 5
    //   166: bipush 19
    //   168: iadd
    //   169: invokevirtual 189	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 193	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 198	java/util/Date:getTime	()J
    //   178: lload_2
    //   179: lsub
    //   180: lstore 6
    //   182: lload 6
    //   184: ldc2_w 199
    //   187: lcmp
    //   188: iflt -98 -> 90
    //   191: lload 6
    //   193: ldc2_w 201
    //   196: lcmp
    //   197: ifgt -107 -> 90
    //   200: iconst_1
    //   201: istore_1
    //   202: goto -112 -> 90
    //   205: aload 4
    //   207: astore_0
    //   208: aload 9
    //   210: aload 12
    //   212: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: bipush 10
    //   217: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: astore_0
    //   224: aload 12
    //   226: ldc 204
    //   228: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   231: ifeq +8 -> 239
    //   234: iconst_2
    //   235: istore_1
    //   236: goto -146 -> 90
    //   239: aload 4
    //   241: astore_0
    //   242: aload 12
    //   244: ldc 206
    //   246: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   249: istore 8
    //   251: iload 8
    //   253: ifeq -163 -> 90
    //   256: aload 4
    //   258: invokevirtual 209	java/io/BufferedReader:close	()V
    //   261: aconst_null
    //   262: areturn
    //   263: aload 4
    //   265: astore_0
    //   266: aload 12
    //   268: ldc 211
    //   270: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +25 -> 298
    //   276: aload 4
    //   278: astore_0
    //   279: aload 9
    //   281: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 9
    //   286: aload 4
    //   288: invokevirtual 209	java/io/BufferedReader:close	()V
    //   291: aload 9
    //   293: areturn
    //   294: astore_0
    //   295: aload 9
    //   297: areturn
    //   298: aload 4
    //   300: astore_0
    //   301: aload 9
    //   303: aload 12
    //   305: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: bipush 10
    //   310: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: goto -224 -> 90
    //   317: astore 9
    //   319: aload 4
    //   321: astore_0
    //   322: ldc 213
    //   324: aload 9
    //   326: ldc 215
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload 4
    //   337: ifnull +8 -> 345
    //   340: aload 4
    //   342: invokevirtual 209	java/io/BufferedReader:close	()V
    //   345: aconst_null
    //   346: areturn
    //   347: aload 4
    //   349: invokevirtual 209	java/io/BufferedReader:close	()V
    //   352: goto -7 -> 345
    //   355: astore_0
    //   356: goto -11 -> 345
    //   359: astore 4
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 209	java/io/BufferedReader:close	()V
    //   371: aload 4
    //   373: athrow
    //   374: astore_0
    //   375: goto -114 -> 261
    //   378: astore_0
    //   379: goto -34 -> 345
    //   382: astore_0
    //   383: goto -12 -> 371
    //   386: astore 4
    //   388: goto -25 -> 363
    //   391: astore 9
    //   393: aconst_null
    //   394: astore 4
    //   396: goto -77 -> 319
    //   399: goto -309 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramString	String
    //   0	402	1	paramInt	int
    //   0	402	2	paramLong	long
    //   0	402	4	paramProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    //   1	168	5	i	int
    //   180	12	6	l	long
    //   249	3	8	bool	boolean
    //   13	289	9	localObject	Object
    //   317	8	9	localException1	Exception
    //   391	1	9	localException2	Exception
    //   24	135	10	localSimpleDateFormat	java.text.SimpleDateFormat
    //   47	102	11	str1	String
    //   98	206	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   286	291	294	java/io/IOException
    //   93	100	317	java/lang/Exception
    //   135	145	317	java/lang/Exception
    //   148	155	317	java/lang/Exception
    //   158	182	317	java/lang/Exception
    //   208	221	317	java/lang/Exception
    //   224	234	317	java/lang/Exception
    //   242	251	317	java/lang/Exception
    //   266	276	317	java/lang/Exception
    //   279	286	317	java/lang/Exception
    //   301	314	317	java/lang/Exception
    //   347	352	355	java/io/IOException
    //   70	87	359	finally
    //   256	261	374	java/io/IOException
    //   340	345	378	java/io/IOException
    //   367	371	382	java/io/IOException
    //   93	100	386	finally
    //   135	145	386	finally
    //   148	155	386	finally
    //   158	182	386	finally
    //   208	221	386	finally
    //   224	234	386	finally
    //   242	251	386	finally
    //   266	276	386	finally
    //   279	286	386	finally
    //   301	314	386	finally
    //   322	335	386	finally
    //   70	87	391	java/lang/Exception
  }
  
  /* Error */
  private static StringBuilder a(String paramString1, boolean paramBoolean, String paramString2, d.b paramb)
  {
    // Byte code:
    //   0: invokestatic 228	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3: astore 8
    //   5: new 119	java/lang/StringBuilder
    //   8: dup
    //   9: sipush 600
    //   12: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   15: astore 7
    //   17: aload 7
    //   19: ldc 230
    //   21: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 7
    //   27: new 119	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 232
    //   33: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: invokestatic 237	com/tencent/mm/sdk/platformtools/BuildInfo:info	()Ljava/lang/String;
    //   39: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: bipush 10
    //   50: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: ldc 239
    //   58: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: bipush 10
    //   67: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: ldc 241
    //   75: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iconst_4
    //   79: invokestatic 247	com/tencent/mm/model/cr:vq	(I)Ljava/lang/String;
    //   82: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: bipush 10
    //   87: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 7
    //   93: ldc 249
    //   95: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 252	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
    //   101: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: bipush 10
    //   106: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 7
    //   112: ldc 254
    //   114: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 260	com/tencent/mm/model/bg:okT	Lcom/tencent/mm/model/bg;
    //   120: ldc_w 262
    //   123: invokestatic 267	com/tencent/mm/compatible/deviceinfo/q:aPg	()Ljava/lang/String;
    //   126: invokevirtual 270	java/lang/String:hashCode	()I
    //   129: invokestatic 275	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   132: invokevirtual 279	com/tencent/mm/model/bg:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: bipush 10
    //   140: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: ldc_w 281
    //   149: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokestatic 267	com/tencent/mm/compatible/deviceinfo/q:aPg	()Ljava/lang/String;
    //   155: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: bipush 10
    //   160: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 7
    //   166: ldc_w 283
    //   169: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: getstatic 286	com/tencent/mm/sdk/platformtools/BuildInfo:TIME	Ljava/lang/String;
    //   175: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 288
    //   181: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: getstatic 291	com/tencent/mm/sdk/platformtools/BuildInfo:HOSTNAME	Ljava/lang/String;
    //   187: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 288
    //   193: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: getstatic 297	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   199: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: bipush 10
    //   204: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 7
    //   210: ldc_w 299
    //   213: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokestatic 78	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   219: getstatic 80	com/tencent/mm/app/w:hgL	J
    //   222: lsub
    //   223: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: ldc_w 304
    //   229: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: getstatic 93	com/tencent/mm/app/w:hgV	Ljava/lang/String;
    //   235: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 310
    //   244: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 7
    //   250: ldc_w 312
    //   253: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iconst_1
    //   257: invokestatic 316	com/tencent/mm/compatible/deviceinfo/q:eD	(Z)Ljava/lang/String;
    //   260: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: bipush 10
    //   265: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 7
    //   271: ldc_w 318
    //   274: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 323	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   280: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: bipush 10
    //   285: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 7
    //   291: ldc_w 325
    //   294: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 8
    //   299: invokestatic 331	com/tencent/xweb/ao:getInstalledTbsCoreVersion	(Landroid/content/Context;)I
    //   302: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: bipush 10
    //   307: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 7
    //   313: ldc_w 333
    //   316: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 8
    //   321: invokestatic 336	com/tencent/xweb/ao:getTbsSDKVersion	(Landroid/content/Context;)I
    //   324: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: bipush 10
    //   329: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 7
    //   335: ldc_w 338
    //   338: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: astore 8
    //   343: invokestatic 344	com/tencent/mm/sdk/crash/CrashReportFactory:isDualByTools	()Z
    //   346: ifeq +1184 -> 1530
    //   349: ldc_w 346
    //   352: astore_2
    //   353: aload 8
    //   355: aload_2
    //   356: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: bipush 10
    //   361: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 7
    //   367: ldc_w 348
    //   370: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: astore 8
    //   375: invokestatic 351	com/tencent/mm/sdk/crash/CrashReportFactory:isHookedByXposed	()Z
    //   378: ifeq +1159 -> 1537
    //   381: ldc_w 346
    //   384: astore_2
    //   385: aload 8
    //   387: aload_2
    //   388: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: bipush 10
    //   393: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 7
    //   399: ldc_w 353
    //   402: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: astore 8
    //   407: invokestatic 356	com/tencent/mm/sdk/crash/CrashReportFactory:isX86Env	()Z
    //   410: ifeq +1134 -> 1544
    //   413: ldc_w 346
    //   416: astore_2
    //   417: aload 8
    //   419: aload_2
    //   420: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: bipush 10
    //   425: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 7
    //   431: ldc_w 358
    //   434: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokestatic 361	com/tencent/xweb/ao:kge	()I
    //   440: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: bipush 10
    //   445: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 7
    //   451: ldc_w 363
    //   454: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: getstatic 369	com/tencent/mm/app/AppForegroundDelegate:heY	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   460: getfield 372	com/tencent/mm/app/AppForegroundDelegate:eLx	Z
    //   463: invokevirtual 375	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: bipush 10
    //   468: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 7
    //   474: ldc_w 377
    //   477: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokestatic 383	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   483: invokevirtual 386	java/lang/Thread:getName	()Ljava/lang/String;
    //   486: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: bipush 10
    //   491: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 7
    //   497: ldc_w 388
    //   500: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: astore_2
    //   504: getstatic 369	com/tencent/mm/app/AppForegroundDelegate:heY	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   507: astore 8
    //   509: aload_2
    //   510: invokestatic 391	com/tencent/mm/app/AppForegroundDelegate:aCa	()Ljava/lang/String;
    //   513: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: bipush 10
    //   518: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: new 195	java/util/Date
    //   525: dup
    //   526: invokespecial 392	java/util/Date:<init>	()V
    //   529: astore_2
    //   530: new 146	java/text/SimpleDateFormat
    //   533: dup
    //   534: ldc_w 394
    //   537: invokestatic 400	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   540: invokespecial 403	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   543: astore 8
    //   545: aload 7
    //   547: ldc_w 405
    //   550: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 8
    //   555: aload_2
    //   556: invokevirtual 409	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   559: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: bipush 10
    //   564: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 213
    //   570: ldc_w 411
    //   573: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: new 417	android/os/StatFs
    //   579: dup
    //   580: invokestatic 423	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   583: invokevirtual 428	java/io/File:getPath	()Ljava/lang/String;
    //   586: invokespecial 429	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   589: astore_2
    //   590: new 417	android/os/StatFs
    //   593: dup
    //   594: invokestatic 434	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   597: invokespecial 429	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   600: astore 8
    //   602: new 436	java/util/concurrent/CountDownLatch
    //   605: dup
    //   606: iconst_1
    //   607: invokespecial 437	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   610: astore 9
    //   612: getstatic 443	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   615: new 18	com/tencent/mm/app/w$7
    //   618: dup
    //   619: aload 9
    //   621: invokespecial 446	com/tencent/mm/app/w$7:<init>	(Ljava/util/concurrent/CountDownLatch;)V
    //   624: invokeinterface 452 2 0
    //   629: pop
    //   630: aload 9
    //   632: ldc2_w 453
    //   635: getstatic 460	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   638: invokevirtual 464	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   641: pop
    //   642: ldc_w 466
    //   645: bipush 11
    //   647: anewarray 4	java/lang/Object
    //   650: dup
    //   651: iconst_0
    //   652: invokestatic 423	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   655: invokevirtual 469	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   658: aastore
    //   659: dup
    //   660: iconst_1
    //   661: aload_2
    //   662: invokevirtual 472	android/os/StatFs:getBlockSizeLong	()J
    //   665: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: dup
    //   670: iconst_2
    //   671: aload_2
    //   672: invokevirtual 481	android/os/StatFs:getBlockCountLong	()J
    //   675: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   678: aastore
    //   679: dup
    //   680: iconst_3
    //   681: aload_2
    //   682: invokevirtual 484	android/os/StatFs:getAvailableBlocksLong	()J
    //   685: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   688: aastore
    //   689: dup
    //   690: iconst_4
    //   691: getstatic 110	com/tencent/mm/app/w:hhb	[J
    //   694: iconst_0
    //   695: laload
    //   696: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   699: aastore
    //   700: dup
    //   701: iconst_5
    //   702: getstatic 110	com/tencent/mm/app/w:hhb	[J
    //   705: iconst_1
    //   706: laload
    //   707: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   710: aastore
    //   711: dup
    //   712: bipush 6
    //   714: getstatic 110	com/tencent/mm/app/w:hhb	[J
    //   717: iconst_2
    //   718: laload
    //   719: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: aastore
    //   723: dup
    //   724: bipush 7
    //   726: invokestatic 434	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   729: aastore
    //   730: dup
    //   731: bipush 8
    //   733: aload 8
    //   735: invokevirtual 472	android/os/StatFs:getBlockSizeLong	()J
    //   738: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: aastore
    //   742: dup
    //   743: bipush 9
    //   745: aload 8
    //   747: invokevirtual 481	android/os/StatFs:getBlockCountLong	()J
    //   750: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   753: aastore
    //   754: dup
    //   755: bipush 10
    //   757: aload 8
    //   759: invokevirtual 484	android/os/StatFs:getAvailableBlocksLong	()J
    //   762: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   765: aastore
    //   766: invokestatic 487	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   769: astore_2
    //   770: aload 7
    //   772: ldc_w 489
    //   775: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_2
    //   779: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: bipush 10
    //   784: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 7
    //   790: ldc_w 491
    //   793: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokestatic 228	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   799: invokestatic 494	com/tencent/xweb/ao:getInstalledNewstVersion	(Landroid/content/Context;)I
    //   802: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   805: bipush 10
    //   807: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: invokestatic 497	com/tencent/xweb/ao:kgh	()Z
    //   814: ifeq +23 -> 837
    //   817: aload 7
    //   819: ldc_w 499
    //   822: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokestatic 502	com/tencent/xweb/ao:kgg	()I
    //   828: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: bipush 10
    //   833: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: invokestatic 508	com/tencent/xweb/xwalk/a/i:kjC	()Ljava/util/List;
    //   840: astore_2
    //   841: aload_2
    //   842: ifnull +503 -> 1345
    //   845: aload_2
    //   846: invokeinterface 513 1 0
    //   851: ifne +494 -> 1345
    //   854: aload 7
    //   856: ldc_w 515
    //   859: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload_2
    //   864: invokeinterface 519 1 0
    //   869: astore_2
    //   870: aload_2
    //   871: invokeinterface 524 1 0
    //   876: ifeq +75 -> 951
    //   879: aload_2
    //   880: invokeinterface 528 1 0
    //   885: checkcast 530	com/tencent/xweb/xwalk/a/g
    //   888: astore 8
    //   890: aload 8
    //   892: ifnull -22 -> 870
    //   895: aload 7
    //   897: ldc_w 532
    //   900: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 8
    //   905: invokevirtual 535	com/tencent/xweb/xwalk/a/g:kjs	()Ljava/lang/String;
    //   908: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: ldc_w 537
    //   914: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload 8
    //   919: getfield 540	com/tencent/xweb/xwalk/a/g:aipK	I
    //   922: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   925: bipush 10
    //   927: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: goto -61 -> 870
    //   934: astore_2
    //   935: ldc 213
    //   937: ldc_w 542
    //   940: iconst_1
    //   941: anewarray 4	java/lang/Object
    //   944: dup
    //   945: iconst_0
    //   946: aload_2
    //   947: aastore
    //   948: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   951: invokestatic 549	com/tencent/mm/app/w:aCB	()Ljava/lang/String;
    //   954: astore_2
    //   955: aload_2
    //   956: ifnull +31 -> 987
    //   959: aload 7
    //   961: ldc_w 551
    //   964: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload_2
    //   968: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: bipush 10
    //   973: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: invokestatic 556	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   980: ldc_w 558
    //   983: invokevirtual 562	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:remove	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   986: pop
    //   987: iload_1
    //   988: ifeq +37 -> 1025
    //   991: getstatic 108	com/tencent/mm/app/w:sCrashExtraMessageGetter	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   994: invokeinterface 567 1 0
    //   999: astore_2
    //   1000: aload_2
    //   1001: invokestatic 570	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1004: ifne +21 -> 1025
    //   1007: aload 7
    //   1009: ldc_w 572
    //   1012: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_2
    //   1016: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: bipush 10
    //   1021: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload_3
    //   1026: ifnull +58 -> 1084
    //   1029: ldc_w 574
    //   1032: invokestatic 580	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1035: checkcast 574	com/tencent/mm/plugin/expt/b/c
    //   1038: getstatic 586	com/tencent/mm/plugin/expt/b/c$a:zvq	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1041: ldc2_w 587
    //   1044: invokeinterface 591 4 0
    //   1049: lstore 5
    //   1051: aload_3
    //   1052: getfield 594	com/tencent/mm/plugin/performance/watchdogs/d$b:MOt	I
    //   1055: i2l
    //   1056: lload 5
    //   1058: lcmp
    //   1059: iflt +389 -> 1448
    //   1062: aload 7
    //   1064: ldc_w 596
    //   1067: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 7
    //   1073: ldc_w 598
    //   1076: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload_3
    //   1080: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: invokestatic 606	com/tencent/mm/plugin/expansions/e:dHE	()Z
    //   1087: ifeq +424 -> 1511
    //   1090: invokestatic 609	com/tencent/mm/plugin/expansions/e:dHB	()Ljava/lang/String;
    //   1093: astore_2
    //   1094: aload_2
    //   1095: invokestatic 614	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1098: ifne +366 -> 1464
    //   1101: aload 7
    //   1103: ldc_w 616
    //   1106: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload_2
    //   1110: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: bipush 10
    //   1115: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload 7
    //   1121: ldc_w 618
    //   1124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: invokestatic 383	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1130: invokevirtual 622	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   1133: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1136: bipush 10
    //   1138: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: invokestatic 627	com/tencent/mm/ag/a:bbZ	()Ljava/lang/String;
    //   1145: astore_3
    //   1146: aload_3
    //   1147: astore_2
    //   1148: aload_3
    //   1149: invokevirtual 185	java/lang/String:length	()I
    //   1152: sipush 1024
    //   1155: if_icmple +12 -> 1167
    //   1158: aload_3
    //   1159: iconst_0
    //   1160: sipush 1024
    //   1163: invokevirtual 189	java/lang/String:substring	(II)Ljava/lang/String;
    //   1166: astore_2
    //   1167: aload 7
    //   1169: ldc_w 629
    //   1172: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: aload_2
    //   1176: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: ldc_w 631
    //   1182: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: invokestatic 636	com/tencent/mm/plugin/performance/watchdogs/f:gzF	()I
    //   1189: istore 4
    //   1191: aload 7
    //   1193: ldc_w 638
    //   1196: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: iload 4
    //   1201: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: bipush 10
    //   1206: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: iload 4
    //   1212: sipush 130
    //   1215: if_icmpge +9 -> 1224
    //   1218: getstatic 641	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1221: ifeq +26 -> 1247
    //   1224: aload 7
    //   1226: ldc_w 643
    //   1229: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload 7
    //   1235: invokestatic 646	com/tencent/mm/plugin/performance/watchdogs/f:gzG	()Ljava/util/List;
    //   1238: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1241: bipush 10
    //   1243: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload_0
    //   1248: invokestatic 570	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1251: ifne +21 -> 1272
    //   1254: aload 7
    //   1256: ldc_w 648
    //   1259: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: aload_0
    //   1263: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: bipush 10
    //   1268: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 7
    //   1274: ldc_w 650
    //   1277: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: invokestatic 653	com/tencent/mm/app/w:aCC	()V
    //   1284: aload 7
    //   1286: areturn
    //   1287: astore_2
    //   1288: ldc 213
    //   1290: ldc_w 655
    //   1293: iconst_1
    //   1294: anewarray 4	java/lang/Object
    //   1297: dup
    //   1298: iconst_0
    //   1299: aload_2
    //   1300: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1303: aastore
    //   1304: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1307: ldc 91
    //   1309: astore_2
    //   1310: goto -540 -> 770
    //   1313: astore_2
    //   1314: ldc 213
    //   1316: aload_2
    //   1317: ldc 91
    //   1319: iconst_0
    //   1320: anewarray 4	java/lang/Object
    //   1323: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1326: goto -489 -> 837
    //   1329: astore_0
    //   1330: ldc 213
    //   1332: aload_0
    //   1333: ldc 91
    //   1335: iconst_0
    //   1336: anewarray 4	java/lang/Object
    //   1339: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1342: aload 7
    //   1344: areturn
    //   1345: aload 7
    //   1347: ldc_w 660
    //   1350: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: pop
    //   1354: invokestatic 228	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1357: invokestatic 664	com/tencent/xweb/xwalk/a/i:pd	(Landroid/content/Context;)Ljava/util/Map;
    //   1360: astore_2
    //   1361: aload_2
    //   1362: ifnull -411 -> 951
    //   1365: aload_2
    //   1366: invokeinterface 670 1 0
    //   1371: invokeinterface 673 1 0
    //   1376: astore_2
    //   1377: aload_2
    //   1378: invokeinterface 524 1 0
    //   1383: ifeq -432 -> 951
    //   1386: aload_2
    //   1387: invokeinterface 528 1 0
    //   1392: checkcast 675	java/util/Map$Entry
    //   1395: astore 8
    //   1397: aload 8
    //   1399: ifnull -22 -> 1377
    //   1402: aload 7
    //   1404: ldc_w 532
    //   1407: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: aload 8
    //   1412: invokeinterface 678 1 0
    //   1417: checkcast 177	java/lang/String
    //   1420: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: ldc_w 537
    //   1426: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: aload 8
    //   1431: invokeinterface 681 1 0
    //   1436: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1439: bipush 10
    //   1441: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: goto -68 -> 1377
    //   1448: aload 7
    //   1450: ldc_w 683
    //   1453: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: goto -386 -> 1071
    //   1460: astore_2
    //   1461: goto -390 -> 1071
    //   1464: invokestatic 686	com/tencent/mm/plugin/expansions/e:getLastObbErrorInfo	()Ljava/lang/String;
    //   1467: astore_2
    //   1468: aload_2
    //   1469: invokestatic 614	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1472: ifne +51 -> 1523
    //   1475: new 119	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 687	java/lang/StringBuilder:<init>	()V
    //   1482: ldc_w 689
    //   1485: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: ldc_w 304
    //   1491: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload_2
    //   1495: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: ldc_w 691
    //   1501: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: astore_2
    //   1508: goto -407 -> 1101
    //   1511: aload 7
    //   1513: ldc_w 693
    //   1516: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: pop
    //   1520: goto -378 -> 1142
    //   1523: ldc_w 689
    //   1526: astore_2
    //   1527: goto -426 -> 1101
    //   1530: ldc_w 695
    //   1533: astore_2
    //   1534: goto -1181 -> 353
    //   1537: ldc_w 695
    //   1540: astore_2
    //   1541: goto -1156 -> 385
    //   1544: ldc_w 695
    //   1547: astore_2
    //   1548: goto -1131 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1551	0	paramString1	String
    //   0	1551	1	paramBoolean	boolean
    //   0	1551	2	paramString2	String
    //   0	1551	3	paramb	d.b
    //   1189	27	4	i	int
    //   1049	8	5	l	long
    //   15	1497	7	localStringBuilder	StringBuilder
    //   3	1427	8	localObject	Object
    //   610	21	9	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   837	841	934	java/lang/Exception
    //   845	870	934	java/lang/Exception
    //   870	890	934	java/lang/Exception
    //   895	931	934	java/lang/Exception
    //   1345	1361	934	java/lang/Exception
    //   1365	1377	934	java/lang/Exception
    //   1377	1397	934	java/lang/Exception
    //   1402	1445	934	java/lang/Exception
    //   576	770	1287	java/lang/Exception
    //   788	837	1313	java/lang/Exception
    //   17	349	1329	java/lang/Exception
    //   353	381	1329	java/lang/Exception
    //   385	413	1329	java/lang/Exception
    //   417	576	1329	java/lang/Exception
    //   770	788	1329	java/lang/Exception
    //   935	951	1329	java/lang/Exception
    //   951	955	1329	java/lang/Exception
    //   959	987	1329	java/lang/Exception
    //   991	1025	1329	java/lang/Exception
    //   1071	1084	1329	java/lang/Exception
    //   1084	1101	1329	java/lang/Exception
    //   1101	1142	1329	java/lang/Exception
    //   1142	1146	1329	java/lang/Exception
    //   1148	1167	1329	java/lang/Exception
    //   1167	1210	1329	java/lang/Exception
    //   1218	1224	1329	java/lang/Exception
    //   1224	1247	1329	java/lang/Exception
    //   1247	1272	1329	java/lang/Exception
    //   1272	1284	1329	java/lang/Exception
    //   1288	1307	1329	java/lang/Exception
    //   1314	1326	1329	java/lang/Exception
    //   1464	1508	1329	java/lang/Exception
    //   1511	1520	1329	java/lang/Exception
    //   1029	1071	1460	finally
    //   1448	1457	1460	finally
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    d.b localb = null;
    int i = 1;
    if (paramInt == 6) {}
    for (;;)
    {
      try
      {
        str = aCA();
        if (str == null) {
          break label302;
        }
        str = a(str, Process.myPid(), System.currentTimeMillis(), null);
        localStringBuilder = new StringBuilder(1024);
        localStringBuilder.append("#[jin_crash]sig=").append(paramInt).append('\n');
        localStringBuilder.append("#crash.previous=").append(paramBoolean).append('\n');
        localStringBuilder.append("#crash.provider=").append(paramString2).append('\n');
        if (paramBoolean) {
          continue;
        }
        paramInt = i;
      }
      finally
      {
        StringBuilder localStringBuilder;
        Log.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "Failed reporting JNI crash.", new Object[0]);
        if (!(paramString1 instanceof RuntimeException)) {
          continue;
        }
        throw ((RuntimeException)paramString1);
        paramInt = 0;
        continue;
        paramInt = 8192;
        continue;
        if (!(paramString1 instanceof Error)) {
          break label301;
        }
      }
      if (paramInt != 0) {
        localb = com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 4);
      }
      localStringBuilder.append(a("", false, paramString3, localb));
      localStringBuilder.append(paramString1).append('\n');
      localStringBuilder.append(a(localb)).append('\n');
      if (str != null)
      {
        localStringBuilder.append("******* ANR Trace *******\n");
        localStringBuilder.append(str);
      }
      paramString1 = localStringBuilder.toString();
      if ("NativeCrash".equals(paramString2))
      {
        paramInt = 32768;
        f(paramString1, paramInt, true);
        paramString2 = hgQ.iterator();
        if (!paramString2.hasNext()) {
          break label301;
        }
        ((ICrashReporter.ICrashReportListener)paramString2.next()).onCrashDumped(paramString1);
        continue;
      }
      label301:
      return;
      label302:
      String str = null;
    }
  }
  
  private static String aCA()
  {
    try
    {
      localObject2 = ag.get("dalvik.vm.stack-trace-file");
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = "/data/anr/traces.txt";
      }
    }
    catch (Exception localException)
    {
      String str1;
      do
      {
        for (;;)
        {
          Object localObject1;
          int i;
          String str2;
          Log.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
          str1 = "/data/anr/traces.txt";
        }
        Object localObject2 = str1;
      } while (new File(str1).isFile());
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = MMApplicationContext.getProcessName();
      if (str2 != null)
      {
        localObject2 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        localObject2 = MMApplicationContext.getApplicationId();
      }
      localObject2 = ((String)localObject1).substring(0, i) + '_' + (String)localObject2 + ((String)localObject1).substring(i);
      if (new File((String)localObject2).isFile()) {
        return localObject2;
      }
    }
    return null;
  }
  
  private static String aCB()
  {
    return MultiProcessMMKV.getDefault().getString("webview_url_prefs_url", null);
  }
  
  private static void aCC()
  {
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        try
        {
          ((com.tencent.mm.plugin.performance.a.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.performance.a.d.class)).getThreadPoolProfiler().gzg();
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.MMCrashReporter", localThrowable, "", new Object[0]);
        }
      }
    });
  }
  
  private static String aCz()
  {
    String str2 = bg.okT.aM("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bg.okT.aM("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  public static void addOnUncaughtExceptionListener(MMUncaughtExceptionHandler.IOnUncaughtExceptionListener paramIOnUncaughtExceptionListener)
  {
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(paramIOnUncaughtExceptionListener);
  }
  
  private static void cy(Context paramContext)
  {
    int i = 0;
    String str = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("login_user_name", "never_login_crash");
    Object localObject = paramContext.getSharedPreferences("system_config_prefs", 0);
    localObject = "https://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
    paramContext = new u(paramContext.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
    if ((paramContext.jKS()) && (paramContext.isDirectory()))
    {
      paramContext = paramContext.jKX();
      int j = paramContext.length;
      while (i < j)
      {
        u localu = paramContext[i];
        if ((localu.isDirectory()) && (localu.getName().endsWith("_nf"))) {
          CrashUploaderService.a(localu, str, com.tencent.mm.loader.i.a.nsC, (String)localObject, "exception");
        }
        i += 1;
      }
    }
  }
  
  private static void f(String paramString, int paramInt, boolean paramBoolean)
  {
    io(paramString);
    com.tencent.mm.plugin.report.service.h.OAn.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (MMApplicationContext.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (j.ct(MMApplicationContext.getContext()) == 1)
      {
        int i = j.cu(MMApplicationContext.getContext());
        Log.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[] { Integer.valueOf(i) });
        localObject = paramString;
        if (paramString.length() > i) {
          localObject = paramString.substring(0, i);
        }
      }
      localContext = MMApplicationContext.getContext();
      str = MMApplicationContext.getProcessName();
      if (!paramBoolean) {
        break label352;
      }
    }
    label352:
    for (paramString = "jni";; paramString = "java")
    {
      j.f(localContext, str, paramString);
      paramString = (String)localObject;
      if (paramInt > 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).length() > paramInt) {
          paramString = ((String)localObject).substring(0, paramInt);
        }
      }
      if (com.tencent.mm.plugin.y.d.gdL() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", aCz());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.y.d.gdL().aB(MMApplicationContext.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.h.OAn;
      com.tencent.mm.plugin.report.service.h.gNW();
      return;
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (MMApplicationContext.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!MMApplicationContext.isMMProcess()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean f(boolean paramBoolean, String paramString)
  {
    Object localObject4 = null;
    boolean bool1 = true;
    hgV = paramString;
    if (com.tencent.mm.plugin.y.d.gdL() == null) {}
    try
    {
      localObject1 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException4)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, MMApplicationContext.getContext().getClassLoader());
        localObject4 = localClass;
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + hgV);
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + hgV);
        localObject1 = com.tencent.mm.br.c.pu("sandbox", ".SubCoreSandBox");
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + hgV);
        if (localObject1 == null) {}
      }
      catch (Exception localException4)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = (com.tencent.mm.plugin.y.c)((Class)localObject1).newInstance();
            com.tencent.mm.plugin.y.d.a((com.tencent.mm.plugin.y.c)localObject1);
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + hgV);
            try
            {
              localObject1 = (ICrashReporter)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((ICrashReporter)localObject1).init(MMApplicationContext.getContext(), paramBoolean);
              ((ICrashReporter)localObject1).setReportID(bg.okT.aM("last_login_uin", p.getString(q.aPg().hashCode())));
              CrashReportFactory.setupCrashReporter((ICrashReporter)localObject1);
              ((ICrashReporter)localObject1).setupSubReporter(new w.2());
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              Log.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              localObject3 = new w();
              ((w)localObject3).init(MMApplicationContext.getContext(), false);
              CrashReportFactory.setupCrashReporter((ICrashReporter)localObject3);
              if (paramString.contains(":tools")) {
                break;
              }
            }
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", localException1, "setup sanbox Failed printing stack trace1.", new Object[0]);
            localObject2 = null;
          }
          localException4 = localException4;
          Log.printErrStackTrace("MicroMsg.MMCrashReporter", localException4, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", localException2, "", new Object[0]);
            Log.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
          }
        }
      }
    }
    Object localObject3;
    int i;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support")))
    {
      i = 1;
      NativeCrash.class.getClassLoader();
      k.DA("wechatcrash");
      paramString = com.tencent.mm.crash.b.aTa();
      if (i != 0)
      {
        localObject3 = ao.getCrashExtraMessage(MMApplicationContext.getContext());
        com.tencent.mm.crash.b.customInfo((String)localObject3);
        Log.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
      }
      paramString.mbb = sCrashExtraMessageGetter;
      cr.Kg(com.tencent.mm.loader.i.b.bmr());
      if (e.aQh())
      {
        paramBoolean = MultiProcessMMKV.getDefault().getBoolean("clicfg_anr_trace", true);
        boolean bool2 = MultiProcessMMKV.getDefault().getBoolean("clicfg_print_trace", true);
        localObject3 = "";
        if ((!paramBoolean) && (!com.tencent.mm.protocal.d.Yxk) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
          break label906;
        }
        paramBoolean = true;
        label566:
        hgZ = paramBoolean;
        if (paramBoolean)
        {
          Log.i("MicroMsg.MMCrashReporter", "anrTrace is enabled");
          paramString = new File(MMApplicationContext.getContext().getFilesDir(), "anr");
          if (paramString.exists()) {
            break label911;
          }
          Log.i("MicroMsg.MMCrashReporter", "anrTraceDir not exists");
          Log.i("MicroMsg.MMCrashReporter", "anrTraceDir mkdirs = %b", new Object[] { Boolean.valueOf(paramString.mkdirs()) });
          label636:
          localObject3 = new File(paramString, "currentAnr.trace").getAbsolutePath();
          Log.i("MicroMsg.MMCrashReporter", "anrTraceFilePath = ".concat(String.valueOf(localObject3)));
        }
        localObject4 = "";
        paramBoolean = bool1;
        if (!bool2)
        {
          paramBoolean = bool1;
          if (!BuildInfo.IS_FLAVOR_PURPLE)
          {
            paramBoolean = bool1;
            if (!BuildInfo.IS_FLAVOR_RED)
            {
              if (!BuildInfo.DEBUG) {
                break label922;
              }
              paramBoolean = bool1;
            }
          }
        }
        label703:
        hha = paramBoolean;
        paramString = (String)localObject4;
        if (!paramBoolean) {
          break label969;
        }
        paramString = (String)localObject4;
      }
    }
    label906:
    label911:
    label922:
    label969:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MMCrashReporter", "printTrace is enabled");
        paramString = (String)localObject4;
        File localFile = new File(MMApplicationContext.getContext().getFilesDir(), "anr");
        paramString = (String)localObject4;
        if (!localFile.exists())
        {
          paramString = (String)localObject4;
          Log.i("MicroMsg.MMCrashReporter", "printTraceDir not exists");
          paramString = (String)localObject4;
          Log.i("MicroMsg.MMCrashReporter", "printTraceDir mkdirs = %b", new Object[] { Boolean.valueOf(localFile.mkdirs()) });
          paramString = (String)localObject4;
          localObject4 = new File(localFile, "print.trace").getAbsolutePath();
          paramString = (String)localObject4;
          Log.i("MicroMsg.MMCrashReporter", "printTraceFilePath = ".concat(String.valueOf(localObject4)));
          paramString = new SignalAnrTracer((Application)MMApplicationContext.getContext(), (String)localObject3, (String)localObject4);
          SignalAnrTracer.a(new SignalAnrTracer.a()
          {
            public final void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong, boolean paramAnonymousBoolean)
            {
              Object localObject = AppForegroundDelegate.heY;
              localObject = AppForegroundDelegate.aCa();
              int i;
              String str1;
              String str2;
              String str3;
              String str4;
              com.tencent.mm.plugin.report.f localf;
              if ((com.tencent.matrix.a.eLw.eLx) || (AppForegroundDelegate.heY.eLx))
              {
                i = 1;
                str1 = MMApplicationContext.getProcessName();
                str2 = com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L);
                str3 = BuildInfo.REV;
                str4 = BuildInfo.CLIENT_VERSION;
                localf = com.tencent.mm.plugin.report.f.Ozc;
                if (i == 0) {
                  break label267;
                }
                i = 1;
                label73:
                if (!paramAnonymousBoolean) {
                  break label273;
                }
              }
              label267:
              label273:
              for (int j = 1;; j = 0)
              {
                localf.b(19664, new Object[] { paramAnonymousString1, localObject, Integer.valueOf(0), Integer.valueOf(i), str1, str2, str3, paramAnonymousString2, Long.valueOf(paramAnonymousLong), Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), str4, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(1), "" });
                return;
                i = 0;
                break;
                i = 0;
                break label73;
              }
            }
            
            public final void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString3)
            {
              w.access$302(paramAnonymousLong);
              w.ip(paramAnonymousString2);
              w.dU(paramAnonymousBoolean);
              try
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1356L, 60L, 1L, true);
                w.a(paramAnonymousString1, paramAnonymousBoolean, paramAnonymousString3);
                com.tencent.threadpool.h.ahAA.bm(w.4..ExternalSyntheticLambda0.INSTANCE);
                if (!paramAnonymousBoolean) {
                  com.tencent.threadpool.h.ahAA.bm(w.4..ExternalSyntheticLambda1.INSTANCE);
                }
                com.tencent.mm.plugin.fcm.a.auL(paramAnonymousString1);
                w.awe();
                return;
              }
              finally
              {
                for (;;)
                {
                  Log.i("MicroMsg.MMCrashReporter", "ANR report PERFORMANCE_ANR_IDKEY_START_KEY failed");
                }
              }
            }
          });
          paramString.aAa();
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
          {
            paramString = new ThreadPriorityTracer();
            ThreadPriorityTracer.fgY = new ThreadPriorityTracer.a()
            {
              public final void onMainThreadPriorityModified(int paramAnonymousInt1, int paramAnonymousInt2)
              {
                Log.e("MicroMsg.MMCrashReporter", "Main Thread Priority Changed, priorityBefore = %d, priorityAfter = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                if (paramAnonymousInt2 >= 10) {
                  throw new RuntimeException("You Cannot set the the Main Thread to a background thread (nice value must be smaller than 10).");
                }
              }
            };
            paramString.aAa();
          }
          return false;
          i = 0;
          break;
          paramBoolean = false;
          break label566;
          Log.i("MicroMsg.MMCrashReporter", "anrTraceDir exists");
          break label636;
          paramBoolean = false;
          break label703;
        }
        paramString = (String)localObject4;
        Log.i("MicroMsg.MMCrashReporter", "printTraceDir exists");
        continue;
        String str = paramString;
      }
      finally
      {
        Log.e("MicroMsg.MMCrashReporter", "print trace failed, message : " + localObject5.getMessage());
      }
    }
  }
  
  private static void io(String paramString)
  {
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i)
        {
          Log.e("MicroMsg.MMCrashReporter", paramString.substring(0, 896));
          paramString = paramString.substring(897);
        }
        else
        {
          Log.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
          paramString = paramString.substring(i + 1);
        }
      }
      Log.e("MicroMsg.MMCrashReporter", paramString);
      Log.appenderFlush();
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  public static void w(Context arg0, String paramString)
  {
    hhb[0] = 0L;
    hhb[1] = 0L;
    hhb[2] = 0L;
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (hhb)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new w.6() });
          hhb.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            hhb[0] = -1L;
            hhb[1] = -1L;
            hhb[2] = -1L;
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (hhb)
            {
              hhb.notify();
            }
          }
        }
      }
    }
  }
  
  final void W(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.h.OAn.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(26L, 0L, 1L, true);
    io(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.gNW();
    long l = System.currentTimeMillis();
    if (l - this.hgO < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.hgO = l;
      j.f(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(a("", true, BuildInfo.CLIENT_VERSION, null));
      localStringBuilder.append("******* ANR Trace *******\n");
      localObject = paramString;
      if (paramString != null)
      {
        localObject = paramString;
        if (paramString.length() > 51200) {
          localObject = paramString.substring(0, 51200);
        }
      }
      localStringBuilder.append((String)localObject);
    } while (com.tencent.mm.plugin.y.d.gdL() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", bg.okT.aM("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.y.d.gdL().aB(MMApplicationContext.getContext(), paramString);
  }
  
  public final void addCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    if (paramICrashReportListener == null) {
      return;
    }
    hgQ.add(paramICrashReportListener);
  }
  
  public final void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter)
  {
    if (paramICrashReportExtraMessageGetter == null) {
      return;
    }
    hgP.add(paramICrashReportExtraMessageGetter);
  }
  
  /* Error */
  public final void cx(Context paramContext)
  {
    // Byte code:
    //   0: ldc 213
    //   2: ldc_w 1497
    //   5: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 1063	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 425	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 1083	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1499
    //   25: invokespecial 1371	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 16	com/tencent/mm/app/w$5
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1502	com/tencent/mm/app/w$5:<init>	(Lcom/tencent/mm/app/w;Ljava/lang/String;)V
    //   38: invokevirtual 1506	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 10
    //   43: aload 10
    //   45: ifnull +586 -> 631
    //   48: invokestatic 709	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 119	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 11
    //   65: sipush 1024
    //   68: newarray char
    //   70: astore 12
    //   72: aload 10
    //   74: arraylength
    //   75: istore 4
    //   77: iconst_0
    //   78: istore_2
    //   79: iload_2
    //   80: iload 4
    //   82: if_icmpge +517 -> 599
    //   85: aload 10
    //   87: iload_2
    //   88: aaload
    //   89: astore 13
    //   91: aload 13
    //   93: invokevirtual 1507	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1509
    //   99: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +179 -> 281
    //   105: aload 13
    //   107: invokevirtual 1507	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1511
    //   113: invokevirtual 1105	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +134 -> 250
    //   119: ldc 213
    //   121: ldc_w 1513
    //   124: aload 13
    //   126: invokestatic 812	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 815	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 13
    //   137: invokevirtual 428	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 1515
    //   147: ldc_w 1511
    //   150: invokevirtual 1518	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore 7
    //   155: aload 7
    //   157: aload 8
    //   159: invokevirtual 742	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +485 -> 647
    //   165: aconst_null
    //   166: astore 7
    //   168: iconst_0
    //   169: aload 8
    //   171: aload 7
    //   173: invokestatic 1521	com/tencent/mm/crash/b:i	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/b$a;
    //   176: astore 8
    //   178: ldc 213
    //   180: new 119	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1523
    //   187: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 8
    //   192: getfield 1528	com/tencent/mm/crash/b$a:mbd	I
    //   195: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 8
    //   206: getfield 1528	com/tencent/mm/crash/b$a:mbd	I
    //   209: aload 8
    //   211: getfield 1531	com/tencent/mm/crash/b$a:text	Ljava/lang/String;
    //   214: ldc_w 738
    //   217: iconst_1
    //   218: aload 8
    //   220: getfield 1534	com/tencent/mm/crash/b$a:clientVersion	Ljava/lang/String;
    //   223: invokestatic 1536	com/tencent/mm/app/w:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   226: aload 13
    //   228: invokevirtual 1539	java/io/File:delete	()Z
    //   231: pop
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: new 425	java/io/File
    //   240: dup
    //   241: aload 7
    //   243: invokespecial 976	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 1539	java/io/File:delete	()Z
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -175 -> 79
    //   257: astore 8
    //   259: ldc 213
    //   261: aload 8
    //   263: ldc_w 1541
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 13
    //   274: aastore
    //   275: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -52 -> 226
    //   281: ldc 213
    //   283: ldc_w 1513
    //   286: aload 13
    //   288: invokestatic 812	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 815	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   294: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: new 168	java/io/FileReader
    //   300: dup
    //   301: aload 13
    //   303: invokespecial 1544	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   306: astore 14
    //   308: aload 11
    //   310: iconst_0
    //   311: invokevirtual 1547	java/lang/StringBuilder:setLength	(I)V
    //   314: aload 14
    //   316: aload 12
    //   318: invokevirtual 1551	java/io/FileReader:read	([C)I
    //   321: istore_3
    //   322: iload_3
    //   323: iconst_m1
    //   324: if_icmpeq +50 -> 374
    //   327: aload 11
    //   329: aload 12
    //   331: iconst_0
    //   332: iload_3
    //   333: invokevirtual 1554	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: goto -23 -> 314
    //   340: astore 7
    //   342: aload 14
    //   344: invokevirtual 1555	java/io/FileReader:close	()V
    //   347: aload 7
    //   349: athrow
    //   350: astore 7
    //   352: ldc 213
    //   354: aload 7
    //   356: ldc_w 1541
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload 13
    //   367: aastore
    //   368: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: goto -121 -> 250
    //   374: aload 11
    //   376: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: astore 8
    //   381: aload 13
    //   383: invokevirtual 1507	java/io/File:getName	()Ljava/lang/String;
    //   386: ldc_w 1557
    //   389: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   392: ifeq +24 -> 416
    //   395: aload 8
    //   397: iconst_0
    //   398: iconst_0
    //   399: invokestatic 747	com/tencent/mm/app/w:f	(Ljava/lang/String;IZ)V
    //   402: aload 13
    //   404: invokevirtual 1539	java/io/File:delete	()Z
    //   407: pop
    //   408: aload 14
    //   410: invokevirtual 1555	java/io/FileReader:close	()V
    //   413: goto -163 -> 250
    //   416: getstatic 801	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   419: astore 9
    //   421: ldc_w 1559
    //   424: invokestatic 1565	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   427: aload 8
    //   429: invokevirtual 1569	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   432: astore 15
    //   434: aload 15
    //   436: invokevirtual 1574	java/util/regex/Matcher:find	()Z
    //   439: ifeq +197 -> 636
    //   442: aload 15
    //   444: iconst_1
    //   445: invokevirtual 1577	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   448: astore 9
    //   450: aload 9
    //   452: astore 7
    //   454: aload 9
    //   456: ldc_w 1579
    //   459: invokevirtual 181	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   462: ifne +42 -> 504
    //   465: aload 9
    //   467: invokestatic 1582	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   470: istore_3
    //   471: aload 9
    //   473: astore 7
    //   475: iload_3
    //   476: ifeq +28 -> 504
    //   479: new 119	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 1579
    //   486: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: iload_3
    //   490: invokestatic 1585	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   493: invokevirtual 1588	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   496: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: astore 7
    //   504: aload 8
    //   506: aload 15
    //   508: invokevirtual 1591	java/util/regex/Matcher:end	()I
    //   511: invokevirtual 975	java/lang/String:substring	(I)Ljava/lang/String;
    //   514: astore 9
    //   516: aload 7
    //   518: astore 8
    //   520: aload 9
    //   522: astore 7
    //   524: aload 7
    //   526: invokevirtual 1592	java/lang/String:isEmpty	()Z
    //   529: ifne +49 -> 578
    //   532: iconst_0
    //   533: istore_3
    //   534: ldc_w 1594
    //   537: invokestatic 1565	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   540: aload 7
    //   542: invokevirtual 1569	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   545: astore 9
    //   547: aload 9
    //   549: invokevirtual 1574	java/util/regex/Matcher:find	()Z
    //   552: ifeq +14 -> 566
    //   555: aload 9
    //   557: iconst_1
    //   558: invokevirtual 1577	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   561: iconst_0
    //   562: invokestatic 1597	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   565: istore_3
    //   566: iload_3
    //   567: aload 7
    //   569: ldc_w 1599
    //   572: iconst_1
    //   573: aload 8
    //   575: invokestatic 1536	com/tencent/mm/app/w:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   578: aload 13
    //   580: invokevirtual 1539	java/io/File:delete	()Z
    //   583: pop
    //   584: goto -176 -> 408
    //   587: astore 8
    //   589: aload 7
    //   591: aload 8
    //   593: invokevirtual 1603	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   596: goto -249 -> 347
    //   599: ldc 213
    //   601: ldc_w 1605
    //   604: iconst_2
    //   605: anewarray 4	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: lload 5
    //   612: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: invokestatic 709	java/lang/System:currentTimeMillis	()J
    //   621: lload 5
    //   623: lsub
    //   624: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   627: aastore
    //   628: invokestatic 819	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: aload_1
    //   632: invokestatic 1607	com/tencent/mm/app/w:cy	(Landroid/content/Context;)V
    //   635: return
    //   636: aload 8
    //   638: astore 7
    //   640: aload 9
    //   642: astore 8
    //   644: goto -120 -> 524
    //   647: goto -479 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	w
    //   0	650	1	paramContext	Context
    //   78	176	2	i	int
    //   321	246	3	j	int
    //   75	8	4	k	int
    //   51	571	5	l	long
    //   12	230	7	str	String
    //   340	8	7	localObject1	Object
    //   350	5	7	localException	Exception
    //   452	187	7	localObject2	Object
    //   140	79	8	localObject3	Object
    //   257	5	8	localIOException	java.io.IOException
    //   379	195	8	localObject4	Object
    //   587	50	8	localThrowable	Throwable
    //   642	1	8	localObject5	Object
    //   419	222	9	localObject6	Object
    //   41	45	10	arrayOfFile	File[]
    //   63	312	11	localStringBuilder	StringBuilder
    //   70	260	12	arrayOfChar	char[]
    //   89	490	13	localFile	File
    //   306	103	14	localFileReader	java.io.FileReader
    //   432	75	15	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   168	226	257	java/io/IOException
    //   308	314	340	finally
    //   314	322	340	finally
    //   327	337	340	finally
    //   374	408	340	finally
    //   416	450	340	finally
    //   454	471	340	finally
    //   479	504	340	finally
    //   504	516	340	finally
    //   524	532	340	finally
    //   534	547	340	finally
    //   547	566	340	finally
    //   566	578	340	finally
    //   578	584	340	finally
    //   297	308	350	java/lang/Exception
    //   347	350	350	java/lang/Exception
    //   408	413	350	java/lang/Exception
    //   589	596	350	java/lang/Exception
    //   342	347	587	finally
  }
  
  public final void init(Context paramContext, boolean paramBoolean)
  {
    MMUncaughtExceptionHandler.setReporter(this);
    if (hgV.endsWith(":push")) {}
    try
    {
      localObject2 = ag.get("dalvik.vm.stack-trace-file");
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = "/data/anr/traces.txt";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
        String str = "/data/anr/traces.txt";
      }
    }
    localObject2 = new File((String)localObject1);
    this.hgS = ((File)localObject2).getParent();
    if ((this.hgS == null) || (this.hgS.length() == 0)) {
      this.hgS = "/";
    }
    this.hgT = ((File)localObject2).getName();
    this.hgU = new ConditionVariable();
    Log.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.hgR = new HashSet();
    this.hgN = new a(this.hgS);
    this.hgN.startWatching();
    CoreService.a(this);
    if (MMApplicationContext.isMainProcess()) {
      paramContext.sendBroadcast(new Intent(paramContext, CrashUploadAlarmReceiver.class));
    }
  }
  
  public final void removeCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    if (paramICrashReportListener == null) {
      return;
    }
    hgQ.remove(paramICrashReportListener);
  }
  
  public final void reportCrashMessage(String paramString1, String paramString2)
  {
    d.b localb = com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 4);
    f(a(paramString1, true, BuildInfo.CLIENT_VERSION, localb) + paramString2 + '\n' + a(localb), 0, false);
  }
  
  public final void reportException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str = paramThrowable.getMessage();
      if (!Util.isNullOrNil(str))
      {
        paramMMUncaughtExceptionHandler = paramMMUncaughtExceptionHandler.getReportByAssertPrefix(str);
        if (Util.isNullOrNil(paramMMUncaughtExceptionHandler)) {}
      }
    }
    for (;;)
    {
      al.o(paramThrowable);
      paramThrowable = com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 4);
      f(paramString + '\n' + a(paramThrowable) + '\n', 0, false);
      com.tencent.mm.wlogcat.b.a.jPP().jPQ();
      Log.i("MicroMsg.MMCrashReporter", "Crash msg content size: %s", new Object[] { Integer.valueOf(paramString.length()) });
      return;
      paramMMUncaughtExceptionHandler = "";
    }
  }
  
  public final void reportJniCrash(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, BuildInfo.CLIENT_VERSION);
    com.tencent.mm.wlogcat.b.a.jPP().jPQ();
  }
  
  public final void reportRawMessage(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.y.d.gdL() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", aCz());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.y.d.gdL().aB(MMApplicationContext.getContext(), localIntent);
    }
  }
  
  public final void setCallbackForReset(CallbackForReset paramCallbackForReset)
  {
    MMUncaughtExceptionHandler.setCallbackForReset(paramCallbackForReset);
  }
  
  public final void setReportID(String paramString) {}
  
  public final void setupSubReporter(ISubReporter paramISubReporter) {}
  
  final class a
    extends FileObserver
  {
    a(String paramString)
    {
      super(712);
    }
    
    /* Error */
    public final void onEvent(int paramInt, String arg2)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: invokestatic 25	java/lang/System:currentTimeMillis	()J
      //   5: aload_0
      //   6: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   9: invokestatic 28	com/tencent/mm/app/w:a	(Lcom/tencent/mm/app/w;)J
      //   12: lsub
      //   13: ldc2_w 29
      //   16: lcmp
      //   17: ifge +5 -> 22
      //   20: iconst_1
      //   21: istore_3
      //   22: iload_3
      //   23: ifeq +4 -> 27
      //   26: return
      //   27: aload_0
      //   28: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   31: getfield 34	com/tencent/mm/app/w:hgR	Ljava/util/HashSet;
      //   34: astore 4
      //   36: aload 4
      //   38: monitorenter
      //   39: iload_1
      //   40: lookupswitch	default:+44->84, 8:+54->94, 64:+134->174, 128:+119->159, 512:+134->174
      //   85: iconst_1
      //   86: monitorexit
      //   87: return
      //   88: astore_2
      //   89: aload 4
      //   91: monitorexit
      //   92: aload_2
      //   93: athrow
      //   94: ldc 36
      //   96: ldc 38
      //   98: aload_2
      //   99: invokestatic 44	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   102: invokevirtual 48	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   105: invokestatic 54	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   108: aload_0
      //   109: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   112: getfield 58	com/tencent/mm/app/w:hgU	Landroid/os/ConditionVariable;
      //   115: invokevirtual 64	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   122: getfield 68	com/tencent/mm/app/w:hhc	Lcom/tencent/mm/app/w$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   132: new 70	com/tencent/mm/app/w$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   140: iconst_0
      //   141: invokespecial 73	com/tencent/mm/app/w$b:<init>	(Lcom/tencent/mm/app/w;B)V
      //   144: putfield 68	com/tencent/mm/app/w:hhc	Lcom/tencent/mm/app/w$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   151: getfield 68	com/tencent/mm/app/w:hhc	Lcom/tencent/mm/app/w$b;
      //   154: ldc 75
      //   156: invokestatic 81	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   163: getfield 34	com/tencent/mm/app/w:hgR	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/w$a:hhe	Lcom/tencent/mm/app/w;
      //   178: getfield 34	com/tencent/mm/app/w:hgR	Ljava/util/HashSet;
      //   181: aload_2
      //   182: invokevirtual 90	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   185: pop
      //   186: goto -102 -> 84
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	189	0	this	a
      //   0	189	1	paramInt	int
      //   1	22	3	i	int
      //   34	56	4	localHashSet	HashSet
      // Exception table:
      //   from	to	target	type
      //   84	87	88	finally
      //   94	159	88	finally
      //   159	171	88	finally
      //   174	186	88	finally
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    private static ActivityManager.ProcessErrorStateInfo aCJ()
    {
      Object localObject = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getProcessesInErrorState();
      if (localObject == null) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
        if ((localProcessErrorStateInfo.uid == Process.myUid()) && (localProcessErrorStateInfo.condition == 2)) {
          return localProcessErrorStateInfo;
        }
      }
      return null;
    }
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
      ??? = null;
      for (;;)
      {
        if (w.this.hgU.block(10000L)) {
          w.this.hgU.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = aCJ();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = aCJ();
            localObject2 = ???;
            if (??? == null)
            {
              Log.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              w.this.hhc = null;
              return;
            }
          }
          Log.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (w.this.hgR)
            {
              localObject4 = new ArrayList(w.this.hgR.size());
              int i = w.this.hgT.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = w.this.hgT.substring(0, i) + '_' + str + w.this.hgT.substring(i);
                if (w.this.hgR.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (w.this.hgR.remove(w.this.hgT)) {
                ((ArrayList)localObject4).add(w.this.hgT);
              }
              ((ArrayList)localObject4).addAll(w.this.hgR);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = w.this.hgS + '/' + (String)localObject4;
                str = w.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  w.this.W(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                Log.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                w.this.hhc = null;
                return;
              }
            }
            Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
          }
        }
        catch (Exception localException)
        {
          break label46;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */