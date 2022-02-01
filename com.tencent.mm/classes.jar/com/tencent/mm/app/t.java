package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.e.i;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.CoreService.b;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.crash.CrashUploaderService;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.watchdogs.c.b;
import com.tencent.mm.rabbiteye.a.a;
import com.tencent.mm.rabbiteye.a.b;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import junit.framework.AssertionFailedError;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements CoreService.b, ICrashReporter, MMUncaughtExceptionHandler.IReporter
{
  public static final long fcW = ;
  private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> fda = new HashSet();
  private static final Set<ICrashReporter.ICrashReportListener> fdb = new HashSet();
  private static String fdg = "";
  private static Message fdh = null;
  private static long fdi = 0L;
  private static boolean fdj = false;
  private static boolean fdk = false;
  private static long[] fdl = { 0L, 0L, 0L };
  private static CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter = new CrashMonitorForJni.CrashExtraMessageGetter()
  {
    public final String getExtraMessage()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = MMApplicationContext.getProcessName();
      Object localObject2;
      if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
      {
        localStringBuilder.append("\n");
        localObject1 = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { BuildInfo.CLIENT_VERSION });
          localObject1 = localObject2;
          if (((String)localObject2).length() > 8192) {
            localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
          }
          localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
          Log.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
        }
      }
      localObject1 = t.aaU().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ICrashReporter.ICrashReportExtraMessageGetter)((Iterator)localObject1).next();
        localStringBuilder.append('\n').append(((ICrashReporter.ICrashReportExtraMessageGetter)localObject2).getCrashReportExtraMessage());
      }
      return localStringBuilder.toString();
    }
  };
  private MMUncaughtExceptionHandler fcX = null;
  private a fcY;
  private volatile long fcZ = 0L;
  HashSet<String> fdc;
  String fdd;
  String fde;
  ConditionVariable fdf;
  volatile b fdm;
  
  private static String a(c.b paramb)
  {
    if (paramb != null) {
      return "\n" + paramb.foA();
    }
    return "";
  }
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 126	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 152	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 154	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc 156
    //   21: invokespecial 157	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: new 126	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 159
    //   32: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload_1
    //   36: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 164
    //   41: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 4
    //   51: ifnull +19 -> 70
    //   54: aload 9
    //   56: aload 4
    //   58: getfield 169	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   61: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 10
    //   66: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 174	java/io/BufferedReader
    //   73: dup
    //   74: new 176	java/io/FileReader
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 177	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: iload 5
    //   89: istore_1
    //   90: aload 4
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: ifnull +245 -> 347
    //   105: iload_1
    //   106: tableswitch	default:+293 -> 399, 0:+26->132, 1:+99->205, 2:+157->263
    //   133: iconst_1
    //   134: astore_0
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -52 -> 90
    //   145: aload 4
    //   147: astore_0
    //   148: aload 11
    //   150: invokevirtual 193	java/lang/String:length	()I
    //   153: istore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 10
    //   160: aload 12
    //   162: iload 5
    //   164: iload 5
    //   166: bipush 19
    //   168: iadd
    //   169: invokevirtual 197	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 201	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 206	java/util/Date:getTime	()J
    //   178: lload_2
    //   179: lsub
    //   180: lstore 6
    //   182: lload 6
    //   184: ldc2_w 207
    //   187: lcmp
    //   188: iflt -98 -> 90
    //   191: lload 6
    //   193: ldc2_w 209
    //   196: lcmp
    //   197: ifgt -107 -> 90
    //   200: iconst_1
    //   201: istore_1
    //   202: goto -112 -> 90
    //   205: aload 4
    //   207: astore_0
    //   208: aload 9
    //   210: aload 12
    //   212: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: bipush 10
    //   217: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: astore_0
    //   224: aload 12
    //   226: ldc 212
    //   228: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   231: ifeq +8 -> 239
    //   234: iconst_2
    //   235: istore_1
    //   236: goto -146 -> 90
    //   239: aload 4
    //   241: astore_0
    //   242: aload 12
    //   244: ldc 214
    //   246: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   249: istore 8
    //   251: iload 8
    //   253: ifeq -163 -> 90
    //   256: aload 4
    //   258: invokevirtual 217	java/io/BufferedReader:close	()V
    //   261: aconst_null
    //   262: areturn
    //   263: aload 4
    //   265: astore_0
    //   266: aload 12
    //   268: ldc 219
    //   270: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +25 -> 298
    //   276: aload 4
    //   278: astore_0
    //   279: aload 9
    //   281: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 9
    //   286: aload 4
    //   288: invokevirtual 217	java/io/BufferedReader:close	()V
    //   291: aload 9
    //   293: areturn
    //   294: astore_0
    //   295: aload 9
    //   297: areturn
    //   298: aload 4
    //   300: astore_0
    //   301: aload 9
    //   303: aload 12
    //   305: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: bipush 10
    //   310: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: goto -224 -> 90
    //   317: astore 9
    //   319: aload 4
    //   321: astore_0
    //   322: ldc 221
    //   324: aload 9
    //   326: ldc 223
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload 4
    //   337: ifnull +8 -> 345
    //   340: aload 4
    //   342: invokevirtual 217	java/io/BufferedReader:close	()V
    //   345: aconst_null
    //   346: areturn
    //   347: aload 4
    //   349: invokevirtual 217	java/io/BufferedReader:close	()V
    //   352: goto -7 -> 345
    //   355: astore_0
    //   356: goto -11 -> 345
    //   359: astore 4
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 217	java/io/BufferedReader:close	()V
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
  private static StringBuilder a(String paramString1, boolean paramBoolean, String paramString2, c.b paramb)
  {
    // Byte code:
    //   0: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3: astore 8
    //   5: new 126	java/lang/StringBuilder
    //   8: dup
    //   9: sipush 600
    //   12: invokespecial 152	java/lang/StringBuilder:<init>	(I)V
    //   15: astore 7
    //   17: aload 7
    //   19: ldc 239
    //   21: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 7
    //   27: new 126	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 241
    //   33: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: invokestatic 246	com/tencent/mm/sdk/platformtools/BuildInfo:info	()Ljava/lang/String;
    //   39: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: bipush 10
    //   50: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: ldc 248
    //   58: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: bipush 10
    //   67: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: ldc 250
    //   75: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iconst_4
    //   79: invokestatic 256	com/tencent/mm/model/cq:vg	(I)Ljava/lang/String;
    //   82: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: bipush 10
    //   87: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 7
    //   93: ldc_w 258
    //   96: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: getstatic 261	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
    //   102: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: bipush 10
    //   107: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 7
    //   113: ldc_w 263
    //   116: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 269	com/tencent/mm/model/bg:ltv	Lcom/tencent/mm/model/bg;
    //   122: ldc_w 271
    //   125: invokestatic 276	com/tencent/mm/compatible/deviceinfo/q:auM	()Ljava/lang/String;
    //   128: invokevirtual 279	java/lang/String:hashCode	()I
    //   131: invokestatic 284	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   134: invokevirtual 288	com/tencent/mm/model/bg:aD	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   137: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: bipush 10
    //   142: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 7
    //   148: ldc_w 290
    //   151: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokestatic 276	com/tencent/mm/compatible/deviceinfo/q:auM	()Ljava/lang/String;
    //   157: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: bipush 10
    //   162: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 7
    //   168: ldc_w 292
    //   171: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: getstatic 295	com/tencent/mm/sdk/platformtools/BuildInfo:TIME	Ljava/lang/String;
    //   177: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 297
    //   183: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: getstatic 300	com/tencent/mm/sdk/platformtools/BuildInfo:HOSTNAME	Ljava/lang/String;
    //   189: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 297
    //   195: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: getstatic 306	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   201: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: bipush 10
    //   206: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 7
    //   212: ldc_w 308
    //   215: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokestatic 83	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   221: getstatic 85	com/tencent/mm/app/t:fcW	J
    //   224: lsub
    //   225: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 313
    //   231: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: getstatic 98	com/tencent/mm/app/t:fdg	Ljava/lang/String;
    //   237: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 319
    //   246: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 7
    //   252: ldc_w 321
    //   255: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iconst_1
    //   259: invokestatic 325	com/tencent/mm/compatible/deviceinfo/q:dR	(Z)Ljava/lang/String;
    //   262: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: bipush 10
    //   267: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 7
    //   273: ldc_w 327
    //   276: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: getstatic 332	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   282: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: bipush 10
    //   287: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 7
    //   293: ldc_w 334
    //   296: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 8
    //   301: invokestatic 340	com/tencent/xweb/WebView:getInstalledTbsCoreVersion	(Landroid/content/Context;)I
    //   304: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: bipush 10
    //   309: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 7
    //   315: ldc_w 342
    //   318: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 8
    //   323: invokestatic 345	com/tencent/xweb/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   326: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: bipush 10
    //   331: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 7
    //   337: ldc_w 347
    //   340: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: astore 8
    //   345: invokestatic 353	com/tencent/mm/sdk/crash/CrashReportFactory:isDualByTools	()Z
    //   348: ifeq +1077 -> 1425
    //   351: ldc_w 355
    //   354: astore_2
    //   355: aload 8
    //   357: aload_2
    //   358: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: bipush 10
    //   363: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 7
    //   369: ldc_w 357
    //   372: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: astore 8
    //   377: invokestatic 360	com/tencent/mm/sdk/crash/CrashReportFactory:isHookedByXposed	()Z
    //   380: ifeq +1052 -> 1432
    //   383: ldc_w 355
    //   386: astore_2
    //   387: aload 8
    //   389: aload_2
    //   390: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: bipush 10
    //   395: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 7
    //   401: ldc_w 362
    //   404: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: astore 8
    //   409: invokestatic 365	com/tencent/mm/sdk/crash/CrashReportFactory:isX86Env	()Z
    //   412: ifeq +1027 -> 1439
    //   415: ldc_w 355
    //   418: astore_2
    //   419: aload 8
    //   421: aload_2
    //   422: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: bipush 10
    //   427: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 7
    //   433: ldc_w 367
    //   436: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 7
    //   442: ldc_w 369
    //   445: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: getstatic 375	com/tencent/mm/app/AppForegroundDelegate:fby	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   451: getfield 378	com/tencent/mm/app/AppForegroundDelegate:cQt	Z
    //   454: invokevirtual 381	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   457: bipush 10
    //   459: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 7
    //   465: ldc_w 383
    //   468: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokestatic 389	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   474: invokevirtual 392	java/lang/Thread:getName	()Ljava/lang/String;
    //   477: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: bipush 10
    //   482: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 7
    //   488: ldc_w 394
    //   491: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore_2
    //   495: getstatic 375	com/tencent/mm/app/AppForegroundDelegate:fby	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   498: astore 8
    //   500: aload_2
    //   501: invokestatic 397	com/tencent/mm/app/AppForegroundDelegate:aaw	()Ljava/lang/String;
    //   504: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: bipush 10
    //   509: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: new 203	java/util/Date
    //   516: dup
    //   517: invokespecial 398	java/util/Date:<init>	()V
    //   520: astore_2
    //   521: new 154	java/text/SimpleDateFormat
    //   524: dup
    //   525: ldc_w 400
    //   528: invokestatic 406	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   531: invokespecial 409	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   534: astore 8
    //   536: aload 7
    //   538: ldc_w 411
    //   541: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 8
    //   546: aload_2
    //   547: invokevirtual 415	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   550: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: bipush 10
    //   555: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc 221
    //   561: ldc_w 417
    //   564: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: new 423	android/os/StatFs
    //   570: dup
    //   571: invokestatic 429	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   574: invokevirtual 434	java/io/File:getPath	()Ljava/lang/String;
    //   577: invokespecial 435	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   580: astore_2
    //   581: new 423	android/os/StatFs
    //   584: dup
    //   585: invokestatic 440	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   588: invokespecial 435	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   591: astore 8
    //   593: new 442	java/util/concurrent/CountDownLatch
    //   596: dup
    //   597: iconst_1
    //   598: invokespecial 443	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   601: astore 9
    //   603: getstatic 449	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   606: new 20	com/tencent/mm/app/t$2
    //   609: dup
    //   610: aload 9
    //   612: invokespecial 452	com/tencent/mm/app/t$2:<init>	(Ljava/util/concurrent/CountDownLatch;)V
    //   615: invokeinterface 458 2 0
    //   620: pop
    //   621: aload 9
    //   623: ldc2_w 459
    //   626: getstatic 466	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   629: invokevirtual 470	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   632: pop
    //   633: ldc_w 472
    //   636: bipush 11
    //   638: anewarray 4	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: invokestatic 429	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   646: invokevirtual 475	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   649: aastore
    //   650: dup
    //   651: iconst_1
    //   652: aload_2
    //   653: invokevirtual 478	android/os/StatFs:getBlockSizeLong	()J
    //   656: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   659: aastore
    //   660: dup
    //   661: iconst_2
    //   662: aload_2
    //   663: invokevirtual 487	android/os/StatFs:getBlockCountLong	()J
    //   666: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   669: aastore
    //   670: dup
    //   671: iconst_3
    //   672: aload_2
    //   673: invokevirtual 490	android/os/StatFs:getAvailableBlocksLong	()J
    //   676: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   679: aastore
    //   680: dup
    //   681: iconst_4
    //   682: getstatic 111	com/tencent/mm/app/t:fdl	[J
    //   685: iconst_0
    //   686: laload
    //   687: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   690: aastore
    //   691: dup
    //   692: iconst_5
    //   693: getstatic 111	com/tencent/mm/app/t:fdl	[J
    //   696: iconst_1
    //   697: laload
    //   698: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   701: aastore
    //   702: dup
    //   703: bipush 6
    //   705: getstatic 111	com/tencent/mm/app/t:fdl	[J
    //   708: iconst_2
    //   709: laload
    //   710: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   713: aastore
    //   714: dup
    //   715: bipush 7
    //   717: invokestatic 440	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   720: aastore
    //   721: dup
    //   722: bipush 8
    //   724: aload 8
    //   726: invokevirtual 478	android/os/StatFs:getBlockSizeLong	()J
    //   729: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   732: aastore
    //   733: dup
    //   734: bipush 9
    //   736: aload 8
    //   738: invokevirtual 487	android/os/StatFs:getBlockCountLong	()J
    //   741: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   744: aastore
    //   745: dup
    //   746: bipush 10
    //   748: aload 8
    //   750: invokevirtual 490	android/os/StatFs:getAvailableBlocksLong	()J
    //   753: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: aastore
    //   757: invokestatic 493	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   760: astore_2
    //   761: aload 7
    //   763: ldc_w 495
    //   766: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_2
    //   770: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: bipush 10
    //   775: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload 7
    //   781: ldc_w 497
    //   784: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   790: invokestatic 502	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersion	(Landroid/content/Context;)I
    //   793: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   796: bipush 10
    //   798: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: invokestatic 505	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   805: ifnull +23 -> 828
    //   808: aload 7
    //   810: ldc_w 507
    //   813: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokestatic 510	org/xwalk/core/XWalkEnvironment:safeGetChromiunVersion	()I
    //   819: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: bipush 10
    //   824: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: invokestatic 516	com/tencent/xweb/xwalk/a/h:izh	()Ljava/util/List;
    //   831: astore_2
    //   832: aload_2
    //   833: invokeinterface 521 1 0
    //   838: ifne +474 -> 1312
    //   841: aload 7
    //   843: ldc_w 523
    //   846: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload_2
    //   851: invokeinterface 527 1 0
    //   856: astore_2
    //   857: aload_2
    //   858: invokeinterface 532 1 0
    //   863: ifeq +75 -> 938
    //   866: aload_2
    //   867: invokeinterface 536 1 0
    //   872: checkcast 538	com/tencent/xweb/xwalk/a/g
    //   875: astore 8
    //   877: aload 8
    //   879: ifnull -22 -> 857
    //   882: aload 7
    //   884: ldc_w 540
    //   887: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload 8
    //   892: invokevirtual 543	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   895: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 545
    //   901: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload 8
    //   906: getfield 548	com/tencent/xweb/xwalk/a/g:aajM	I
    //   909: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: bipush 10
    //   914: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: goto -61 -> 857
    //   921: astore_2
    //   922: ldc 221
    //   924: ldc_w 550
    //   927: iconst_1
    //   928: anewarray 4	java/lang/Object
    //   931: dup
    //   932: iconst_0
    //   933: aload_2
    //   934: aastore
    //   935: invokestatic 554	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   938: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   941: ldc_w 556
    //   944: iconst_4
    //   945: invokevirtual 562	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   948: ldc_w 564
    //   951: aconst_null
    //   952: invokeinterface 568 3 0
    //   957: astore_2
    //   958: aload_2
    //   959: ifnull +53 -> 1012
    //   962: aload 7
    //   964: ldc_w 570
    //   967: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_2
    //   971: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: bipush 10
    //   976: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   983: ldc_w 556
    //   986: iconst_4
    //   987: invokevirtual 562	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   990: invokeinterface 574 1 0
    //   995: astore_2
    //   996: aload_2
    //   997: ldc_w 564
    //   1000: invokeinterface 580 2 0
    //   1005: pop
    //   1006: aload_2
    //   1007: invokeinterface 583 1 0
    //   1012: iload_1
    //   1013: ifeq +37 -> 1050
    //   1016: getstatic 109	com/tencent/mm/app/t:sCrashExtraMessageGetter	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   1019: invokeinterface 588 1 0
    //   1024: astore_2
    //   1025: aload_2
    //   1026: invokestatic 591	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1029: ifne +21 -> 1050
    //   1032: aload 7
    //   1034: ldc_w 593
    //   1037: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload_2
    //   1041: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: bipush 10
    //   1046: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload_3
    //   1051: ifnull +58 -> 1109
    //   1054: ldc_w 595
    //   1057: invokestatic 601	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1060: checkcast 595	com/tencent/mm/plugin/expt/b/b
    //   1063: getstatic 607	com/tencent/mm/plugin/expt/b/b$a:wbR	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   1066: ldc2_w 608
    //   1069: invokeinterface 612 4 0
    //   1074: lstore 5
    //   1076: aload_3
    //   1077: getfield 615	com/tencent/mm/plugin/performance/watchdogs/c$b:GQV	I
    //   1080: i2l
    //   1081: lload 5
    //   1083: lcmp
    //   1084: iflt +325 -> 1409
    //   1087: aload 7
    //   1089: ldc_w 617
    //   1092: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 7
    //   1098: ldc_w 619
    //   1101: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: aload_3
    //   1105: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: invokestatic 627	com/tencent/mm/ag/a:aJc	()Ljava/lang/String;
    //   1112: astore_3
    //   1113: aload_3
    //   1114: astore_2
    //   1115: aload_3
    //   1116: invokevirtual 193	java/lang/String:length	()I
    //   1119: sipush 1024
    //   1122: if_icmple +12 -> 1134
    //   1125: aload_3
    //   1126: iconst_0
    //   1127: sipush 1024
    //   1130: invokevirtual 197	java/lang/String:substring	(II)Ljava/lang/String;
    //   1133: astore_2
    //   1134: aload 7
    //   1136: ldc_w 629
    //   1139: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: aload_2
    //   1143: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: ldc_w 631
    //   1149: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: invokestatic 636	com/tencent/mm/plugin/performance/watchdogs/e:foE	()I
    //   1156: istore 4
    //   1158: aload 7
    //   1160: ldc_w 638
    //   1163: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: iload 4
    //   1168: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: bipush 10
    //   1173: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: iload 4
    //   1179: sipush 130
    //   1182: if_icmpge +9 -> 1191
    //   1185: getstatic 641	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1188: ifeq +26 -> 1214
    //   1191: aload 7
    //   1193: ldc_w 643
    //   1196: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: aload 7
    //   1202: invokestatic 646	com/tencent/mm/plugin/performance/watchdogs/e:foF	()Ljava/util/List;
    //   1205: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1208: bipush 10
    //   1210: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload_0
    //   1215: invokestatic 591	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1218: ifne +21 -> 1239
    //   1221: aload 7
    //   1223: ldc_w 648
    //   1226: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_0
    //   1230: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: bipush 10
    //   1235: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload 7
    //   1241: ldc_w 650
    //   1244: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: invokestatic 653	com/tencent/mm/app/t:aaT	()V
    //   1251: aload 7
    //   1253: areturn
    //   1254: astore_2
    //   1255: ldc 221
    //   1257: ldc_w 655
    //   1260: iconst_1
    //   1261: anewarray 4	java/lang/Object
    //   1264: dup
    //   1265: iconst_0
    //   1266: aload_2
    //   1267: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1270: aastore
    //   1271: invokestatic 554	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1274: ldc 96
    //   1276: astore_2
    //   1277: goto -516 -> 761
    //   1280: astore_2
    //   1281: ldc 221
    //   1283: aload_2
    //   1284: ldc 96
    //   1286: iconst_0
    //   1287: anewarray 4	java/lang/Object
    //   1290: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1293: goto -465 -> 828
    //   1296: astore_0
    //   1297: ldc 221
    //   1299: aload_0
    //   1300: ldc 96
    //   1302: iconst_0
    //   1303: anewarray 4	java/lang/Object
    //   1306: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1309: aload 7
    //   1311: areturn
    //   1312: aload 7
    //   1314: ldc_w 660
    //   1317: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1324: invokestatic 664	com/tencent/xweb/xwalk/a/h:mF	(Landroid/content/Context;)Ljava/util/Map;
    //   1327: invokeinterface 670 1 0
    //   1332: invokeinterface 673 1 0
    //   1337: astore_2
    //   1338: aload_2
    //   1339: invokeinterface 532 1 0
    //   1344: ifeq -406 -> 938
    //   1347: aload_2
    //   1348: invokeinterface 536 1 0
    //   1353: checkcast 675	java/util/Map$Entry
    //   1356: astore 8
    //   1358: aload 8
    //   1360: ifnull -22 -> 1338
    //   1363: aload 7
    //   1365: ldc_w 540
    //   1368: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: aload 8
    //   1373: invokeinterface 678 1 0
    //   1378: checkcast 185	java/lang/String
    //   1381: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: ldc_w 545
    //   1387: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: aload 8
    //   1392: invokeinterface 681 1 0
    //   1397: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1400: bipush 10
    //   1402: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: goto -68 -> 1338
    //   1409: aload 7
    //   1411: ldc_w 683
    //   1414: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: goto -322 -> 1096
    //   1421: astore_2
    //   1422: goto -326 -> 1096
    //   1425: ldc_w 685
    //   1428: astore_2
    //   1429: goto -1074 -> 355
    //   1432: ldc_w 685
    //   1435: astore_2
    //   1436: goto -1049 -> 387
    //   1439: ldc_w 685
    //   1442: astore_2
    //   1443: goto -1024 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1446	0	paramString1	String
    //   0	1446	1	paramBoolean	boolean
    //   0	1446	2	paramString2	String
    //   0	1446	3	paramb	c.b
    //   1156	27	4	i	int
    //   1074	8	5	l	long
    //   15	1395	7	localStringBuilder	StringBuilder
    //   3	1388	8	localObject	Object
    //   601	21	9	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   828	857	921	java/lang/Exception
    //   857	877	921	java/lang/Exception
    //   882	918	921	java/lang/Exception
    //   1312	1338	921	java/lang/Exception
    //   1338	1358	921	java/lang/Exception
    //   1363	1406	921	java/lang/Exception
    //   567	761	1254	java/lang/Exception
    //   779	828	1280	java/lang/Exception
    //   17	351	1296	java/lang/Exception
    //   355	383	1296	java/lang/Exception
    //   387	415	1296	java/lang/Exception
    //   419	567	1296	java/lang/Exception
    //   761	779	1296	java/lang/Exception
    //   922	938	1296	java/lang/Exception
    //   938	958	1296	java/lang/Exception
    //   962	1012	1296	java/lang/Exception
    //   1016	1050	1296	java/lang/Exception
    //   1054	1096	1296	java/lang/Exception
    //   1096	1109	1296	java/lang/Exception
    //   1109	1113	1296	java/lang/Exception
    //   1115	1134	1296	java/lang/Exception
    //   1134	1177	1296	java/lang/Exception
    //   1185	1191	1296	java/lang/Exception
    //   1191	1214	1296	java/lang/Exception
    //   1214	1239	1296	java/lang/Exception
    //   1239	1251	1296	java/lang/Exception
    //   1255	1274	1296	java/lang/Exception
    //   1281	1293	1296	java/lang/Exception
    //   1409	1418	1296	java/lang/Exception
    //   1054	1096	1421	java/lang/Throwable
    //   1409	1418	1421	java/lang/Throwable
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    c.b localb = null;
    int i = 1;
    if (paramInt == 6) {}
    for (;;)
    {
      try
      {
        str = aaS();
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
      catch (Throwable paramString1)
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
        throw ((Error)paramString1);
      }
      if (paramInt != 0) {
        localb = com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 4);
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
        e(paramString1, paramInt, true);
        paramString2 = fdb.iterator();
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
  
  private static void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, String paramString3, int paramInt2)
  {
    String str4 = com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L);
    String str5 = BuildInfo.REV;
    String str6 = BuildInfo.CLIENT_VERSION;
    String str3 = "";
    String str1 = CrashReportFactory.recentlyDbPoolBusyRunningSql;
    if (fdh != null) {
      str3 = fdh.toString();
    }
    long l1 = CrashReportFactory.heavyUserFlag;
    Log.i("MicroMsg.MMCrashReporter", "reportSignalAnrReal, heavyUserflag = %d, dbPoolBusyRunningSql = %s", new Object[] { Long.valueOf(l1), str1 });
    String str7 = str1.replace(',', ' ');
    Object localObject = com.tencent.mm.plugin.appbrand.e.a.oce.getCrashReportExtraMessage();
    str1 = "";
    for (;;)
    {
      try
      {
        if (((String)localObject).contains("weapp_id"))
        {
          str1 = ((String)localObject).substring(((String)localObject).indexOf(":", ((String)localObject).indexOf("weapp_id")) + 1, ((String)localObject).indexOf(";", ((String)localObject).indexOf("weapp_id")));
          localObject = ((String)localObject).substring(((String)localObject).indexOf(":", ((String)localObject).indexOf("weapp_name")) + 1, ((String)localObject).indexOf(";", ((String)localObject).indexOf("weapp_name")));
          str1 = str1 + "-" + (String)localObject;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          i = XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext());
        }
        catch (Throwable localThrowable2)
        {
          long l2;
          String str2;
          i = 0;
        }
        try
        {
          j = XWalkEnvironment.safeGetChromiunVersion();
          m = 20210601;
          k = i;
          i = m;
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1356L, 61L, 1L, true);
          localObject = com.tencent.mm.plugin.report.f.Iyx;
          if (!paramBoolean) {
            break label503;
          }
          m = 1;
          l2 = fdi;
          if (!fdj) {
            break label509;
          }
          n = 1;
          ((com.tencent.mm.plugin.report.f)localObject).a(19664, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(m), paramString3, str4, str5, str3, Long.valueOf(l2), Integer.valueOf(paramInt2), Integer.valueOf(n), Long.valueOf(l1), str6, str7, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), str1 });
          CrashReportFactory.recentlyDbPoolBusyRunningSql = "";
          return;
        }
        catch (Throwable localThrowable3)
        {
          break label466;
        }
        localThrowable1 = localThrowable1;
        Log.e("MicroMsg.MMCrashReporter", "get weappInfo error, %s", new Object[] { localThrowable1.getMessage() });
        str2 = "";
        continue;
      }
      label466:
      Log.e("MicroMsg.MMCrashReporter", "get xweb info error, %s", new Object[] { localThrowable2.getMessage() });
      int m = 0;
      int j = 0;
      int k = i;
      int i = m;
      continue;
      label503:
      m = 0;
      continue;
      label509:
      int n = 0;
    }
  }
  
  private static String aaQ()
  {
    String str2 = bg.ltv.aD("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bg.ltv.aD("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static boolean aaR()
  {
    try
    {
      Object localObject = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getProcessesInErrorState();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
        Log.i("MicroMsg.MMCrashReporter", "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", new Object[] { localProcessErrorStateInfo.processName, Integer.valueOf(localProcessErrorStateInfo.condition) });
        if ((localProcessErrorStateInfo.uid != Process.myUid()) && (localProcessErrorStateInfo.condition == 2)) {
          Log.i("MicroMsg.MMCrashReporter", "maybe received other apps ANR signal");
        }
        if (localProcessErrorStateInfo.pid == Process.myPid())
        {
          int i = localProcessErrorStateInfo.condition;
          if (i == 2) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MMCrashReporter", "[checkErrorState] error : %s", new Object[] { localThrowable.getMessage() });
    }
    return false;
  }
  
  private static String aaS()
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
  
  private static void aaT()
  {
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        try
        {
          ((com.tencent.mm.plugin.performance.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.performance.a.d.class)).getThreadPoolProfiler().fol();
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.MMCrashReporter", localThrowable, "", new Object[0]);
        }
      }
    });
  }
  
  public static void addOnUncaughtExceptionListener(MMUncaughtExceptionHandler.IOnUncaughtExceptionListener paramIOnUncaughtExceptionListener)
  {
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(paramIOnUncaughtExceptionListener);
  }
  
  private static void bL(Context paramContext)
  {
    int i = 0;
    String str1 = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("login_user_name", "never_login_crash");
    Object localObject = paramContext.getSharedPreferences("system_config_prefs", 0);
    StringBuilder localStringBuilder = new StringBuilder("http://");
    String str2 = com.tencent.mm.network.c.kRi;
    localObject = ((SharedPreferences)localObject).getString(str2, str2);
    paramContext = new com.tencent.mm.vfs.q(paramContext.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
    if ((paramContext.ifE()) && (paramContext.isDirectory()))
    {
      paramContext = paramContext.ifJ();
      int j = paramContext.length;
      while (i < j)
      {
        localStringBuilder = paramContext[i];
        if ((localStringBuilder.isDirectory()) && (localStringBuilder.getName().endsWith("_nf"))) {
          CrashUploaderService.a(localStringBuilder, str1, com.tencent.mm.loader.j.a.kQZ, (String)localObject, "exception");
        }
        i += 1;
      }
    }
  }
  
  private static boolean dj(boolean paramBoolean)
  {
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      fdh = (Message)localObject;
      if (localObject != null)
      {
        long l1 = ((Message)localObject).getWhen();
        if (l1 == 0L) {
          return false;
        }
        long l2 = l1 - SystemClock.uptimeMillis();
        fdi = l2;
        l1 = -10000L;
        if (paramBoolean) {
          l1 = -2000L;
        }
        if (l2 < l1)
        {
          if (((Message)localObject).getTarget() == null) {
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run() {}
            });
          }
          return true;
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMCrashReporter", "firstCheckMessage errror, msessage : " + localException.getMessage());
      return false;
    }
    return false;
  }
  
  private static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    gO(paramString);
    com.tencent.mm.plugin.report.service.h.IzE.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (MMApplicationContext.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (h.bG(MMApplicationContext.getContext()) == 1)
      {
        int i = h.bH(MMApplicationContext.getContext());
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
      h.d(localContext, str, paramString);
      paramString = (String)localObject;
      if (paramInt > 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).length() > paramInt) {
          paramString = ((String)localObject).substring(0, paramInt);
        }
      }
      if (com.tencent.mm.plugin.y.d.eUZ() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", aaQ());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.y.d.eUZ().at(MMApplicationContext.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.h.IzE;
      com.tencent.mm.plugin.report.service.h.fBD();
      return;
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (MMApplicationContext.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!MMApplicationContext.isMMProcess()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean f(boolean paramBoolean, String paramString)
  {
    Object localObject4 = null;
    fdg = paramString;
    if (com.tencent.mm.plugin.y.d.eUZ() == null) {}
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
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + fdg);
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + fdg);
        localObject1 = com.tencent.mm.by.c.ny("sandbox", ".SubCoreSandBox");
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + fdg);
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
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + fdg);
            try
            {
              localObject1 = (ICrashReporter)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((ICrashReporter)localObject1).init(MMApplicationContext.getContext(), paramBoolean);
              ((ICrashReporter)localObject1).setReportID(bg.ltv.aD("last_login_uin", p.getString(com.tencent.mm.compatible.deviceinfo.q.auM().hashCode())));
              CrashReportFactory.setupCrashReporter((ICrashReporter)localObject1);
              ((ICrashReporter)localObject1).setupSubReporter(new ISubReporter()
              {
                public final void report(String paramAnonymousString)
                {
                  if (com.tencent.mm.plugin.y.d.eUZ() != null)
                  {
                    Intent localIntent = new Intent();
                    localIntent.setAction("uncatch_exception");
                    localIntent.putExtra("exceptionPid", Process.myPid());
                    localIntent.putExtra("userName", t.access$100());
                    localIntent.putExtra("tag", 0);
                    localIntent.putExtra("exceptionMsg", Base64.encodeToString((t.U("", BuildInfo.CLIENT_VERSION) + paramAnonymousString).getBytes(), 2));
                    com.tencent.mm.plugin.y.d.eUZ().at(MMApplicationContext.getContext(), localIntent);
                  }
                }
              });
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              Log.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              localObject3 = new t();
              ((t)localObject3).init(MMApplicationContext.getContext(), false);
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
    boolean bool1;
    boolean bool2;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support")))
    {
      i = 1;
      NativeCrash.class.getClassLoader();
      j.KW("wechatcrash");
      paramString = com.tencent.mm.crash.a.ayx();
      if (i != 0)
      {
        localObject3 = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
        com.tencent.mm.crash.a.LC((String)localObject3);
        Log.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
      }
      paramString.jxF = sCrashExtraMessageGetter;
      cq.Se(com.tencent.mm.loader.j.b.aSD());
      EventCenter.instance.add(new IListener() {});
      bool1 = MultiProcessMMKV.getDefault().getBoolean("clicfg_lag_report", false);
      paramBoolean = MultiProcessMMKV.getDefault().getBoolean("clicfg_anr_trace", false);
      bool2 = MultiProcessMMKV.getDefault().getBoolean("clicfg_print_trace", true);
      paramString = new a.a();
      paramString.a = true;
      if ((Build.VERSION.SDK_INT < 26) || ((!paramBoolean) && (!com.tencent.mm.protocal.d.RAG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))) {
        break label875;
      }
      paramBoolean = true;
      label603:
      fdj = paramBoolean;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MMCrashReporter", "printTrace2Xlog");
        paramString.b = true;
        localObject3 = new File(MMApplicationContext.getContext().getFilesDir(), "anr");
        if (((File)localObject3).exists()) {
          continue;
        }
        Log.i("MicroMsg.MMCrashReporter", "anrTraceDir not exists");
        Log.i("MicroMsg.MMCrashReporter", "anrTraceDir mkdirs = %b", new Object[] { Boolean.valueOf(((File)localObject3).mkdirs()) });
        paramString.d = new File((File)localObject3, "currentAnr.trace").getAbsolutePath();
      }
      catch (Throwable localThrowable1)
      {
        label875:
        Log.e("MicroMsg.MMCrashReporter", "print ANR trace failed, message : " + localThrowable1.getMessage());
        continue;
        paramBoolean = false;
        continue;
        Log.i("MicroMsg.MMCrashReporter", "printTraceDir exists");
        continue;
      }
      if ((Build.VERSION.SDK_INT < 26) || ((!bool2) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))) {
        continue;
      }
      paramBoolean = true;
      fdk = paramBoolean;
      if (paramBoolean) {}
      try
      {
        Log.i("MicroMsg.MMCrashReporter", "printTrace2Xlog");
        paramString.c = true;
        localObject3 = new File(MMApplicationContext.getContext().getFilesDir(), "anr");
        if (((File)localObject3).exists()) {
          continue;
        }
        Log.i("MicroMsg.MMCrashReporter", "printTraceDir not exists");
        Log.i("MicroMsg.MMCrashReporter", "printTraceDir mkdirs = %b", new Object[] { Boolean.valueOf(((File)localObject3).mkdirs()) });
        paramString.e = new File((File)localObject3, "print.trace").getAbsolutePath();
      }
      catch (Throwable localThrowable2)
      {
        Log.e("MicroMsg.MMCrashReporter", "print trace failed, message : " + localThrowable2.getMessage());
        continue;
      }
      if (bool1)
      {
        paramString.f = true;
        paramString.i = true;
        paramString.h = true;
      }
      paramString.g = false;
      com.tencent.mm.rabbiteye.a.a(new a.b()
      {
        public final void a(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, boolean paramAnonymousBoolean, String paramAnonymousString3)
        {
          String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.MMCrashReporter", "[RabbitEye] Happens Lag stacktrace : %s, processName :%s , scene : %s, isForeground : %b, type : %s", new Object[] { paramAnonymousString2, str, paramAnonymousString3, Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1 });
          if (paramAnonymousString1.equals("Touch"))
          {
            paramAnonymousString1 = com.tencent.mm.plugin.report.service.h.IzE;
            if (paramAnonymousBoolean)
            {
              i = 1;
              paramAnonymousString1.a(20841, new Object[] { paramAnonymousString3, paramAnonymousString2, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(paramAnonymousLong), str });
            }
          }
          while (!paramAnonymousString1.equals("IdleHandler")) {
            for (;;)
            {
              return;
              i = 0;
            }
          }
          paramAnonymousString1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            paramAnonymousString1.a(20841, new Object[] { paramAnonymousString3, paramAnonymousString2, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramAnonymousLong), str });
            return;
          }
        }
        
        public final void gP(String paramAnonymousString)
        {
          try
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1356L, 60L, 1L, true);
            com.tencent.mm.plugin.fcm.a.aAD(paramAnonymousString);
            t.gF(paramAnonymousString);
            t.access$400();
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            Log.e("MicroMsg.MMCrashReporter", "detectedAnr report failed, message = " + paramAnonymousString.getMessage());
          }
        }
      });
      com.tencent.mm.rabbiteye.a.a(paramString);
      return false;
      i = 0;
      break;
      paramBoolean = false;
      break label603;
      Log.i("MicroMsg.MMCrashReporter", "anrTraceDir exists");
    }
  }
  
  private static void gO(String paramString)
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
  
  public static void s(Context arg0, String paramString)
  {
    fdl[0] = 0L;
    fdl[1] = 0L;
    fdl[2] = 0L;
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (fdl)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new IPackageStatsObserver.Stub()
          {
            /* Error */
            public final void onGetStatsCompleted(android.content.pm.PackageStats arg1, boolean paramAnonymousBoolean)
            {
              // Byte code:
              //   0: aload_1
              //   1: ifnull +93 -> 94
              //   4: invokestatic 22	com/tencent/mm/app/t:aaX	()[J
              //   7: iconst_0
              //   8: aload_1
              //   9: getfield 28	android/content/pm/PackageStats:cacheSize	J
              //   12: lastore
              //   13: invokestatic 22	com/tencent/mm/app/t:aaX	()[J
              //   16: iconst_1
              //   17: aload_1
              //   18: getfield 31	android/content/pm/PackageStats:dataSize	J
              //   21: lastore
              //   22: invokestatic 22	com/tencent/mm/app/t:aaX	()[J
              //   25: iconst_2
              //   26: aload_1
              //   27: getfield 34	android/content/pm/PackageStats:codeSize	J
              //   30: lastore
              //   31: ldc 36
              //   33: ldc 38
              //   35: iconst_4
              //   36: anewarray 40	java/lang/Object
              //   39: dup
              //   40: iconst_0
              //   41: iload_2
              //   42: invokestatic 46	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
              //   45: aastore
              //   46: dup
              //   47: iconst_1
              //   48: aload_1
              //   49: getfield 28	android/content/pm/PackageStats:cacheSize	J
              //   52: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   55: aastore
              //   56: dup
              //   57: iconst_2
              //   58: aload_1
              //   59: getfield 31	android/content/pm/PackageStats:dataSize	J
              //   62: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   65: aastore
              //   66: dup
              //   67: iconst_3
              //   68: aload_1
              //   69: getfield 34	android/content/pm/PackageStats:codeSize	J
              //   72: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   75: aastore
              //   76: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   79: invokestatic 22	com/tencent/mm/app/t:aaX	()[J
              //   82: astore_1
              //   83: aload_1
              //   84: monitorenter
              //   85: invokestatic 22	com/tencent/mm/app/t:aaX	()[J
              //   88: invokevirtual 60	java/lang/Object:notify	()V
              //   91: aload_1
              //   92: monitorexit
              //   93: return
              //   94: ldc 36
              //   96: ldc 62
              //   98: iconst_1
              //   99: anewarray 40	java/lang/Object
              //   102: dup
              //   103: iconst_0
              //   104: iload_2
              //   105: invokestatic 46	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
              //   108: aastore
              //   109: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   112: goto -33 -> 79
              //   115: astore_1
              //   116: ldc 36
              //   118: aload_1
              //   119: ldc 63
              //   121: iconst_0
              //   122: anewarray 40	java/lang/Object
              //   125: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   128: return
              //   129: astore_3
              //   130: aload_1
              //   131: monitorexit
              //   132: aload_3
              //   133: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	134	0	this	12
              //   0	134	2	paramAnonymousBoolean	boolean
              //   129	4	3	localObject	Object
              // Exception table:
              //   from	to	target	type
              //   4	79	115	java/lang/Throwable
              //   79	85	115	java/lang/Throwable
              //   94	112	115	java/lang/Throwable
              //   130	134	115	java/lang/Throwable
              //   85	93	129	finally
            }
          } });
          fdl.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            fdl[0] = -1L;
            fdl[1] = -1L;
            fdl[2] = -1L;
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (fdl)
            {
              fdl.notify();
            }
          }
        }
      }
    }
  }
  
  final void N(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.h.IzE.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(26L, 0L, 1L, true);
    gO(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.report.service.h.fBD();
    long l = System.currentTimeMillis();
    if (l - this.fcZ < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.fcZ = l;
      h.d(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "anr");
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
    } while (com.tencent.mm.plugin.y.d.eUZ() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", bg.ltv.aD("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.y.d.eUZ().at(MMApplicationContext.getContext(), paramString);
  }
  
  public final void addCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    if (paramICrashReportListener == null) {
      return;
    }
    fdb.add(paramICrashReportListener);
  }
  
  public final void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter)
  {
    if (paramICrashReportExtraMessageGetter == null) {
      return;
    }
    fda.add(paramICrashReportExtraMessageGetter);
  }
  
  /* Error */
  public final void bK(Context paramContext)
  {
    // Byte code:
    //   0: ldc 221
    //   2: ldc_w 1554
    //   5: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 1008	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 431	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 1024	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1556
    //   25: invokespecial 1345	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 32	com/tencent/mm/app/t$7
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1559	com/tencent/mm/app/t$7:<init>	(Lcom/tencent/mm/app/t;Ljava/lang/String;)V
    //   38: invokevirtual 1563	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 11
    //   43: aload 11
    //   45: ifnull +608 -> 653
    //   48: invokestatic 699	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 126	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 152	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 12
    //   65: sipush 1024
    //   68: newarray char
    //   70: astore 13
    //   72: aload 11
    //   74: arraylength
    //   75: istore 4
    //   77: iconst_0
    //   78: istore_2
    //   79: iload_2
    //   80: iload 4
    //   82: if_icmpge +539 -> 621
    //   85: aload 11
    //   87: iload_2
    //   88: aaload
    //   89: astore 14
    //   91: aload 14
    //   93: invokevirtual 1564	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1566
    //   99: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +179 -> 281
    //   105: aload 14
    //   107: invokevirtual 1564	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1568
    //   113: invokevirtual 1046	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +134 -> 250
    //   119: ldc 221
    //   121: ldc_w 1570
    //   124: aload 14
    //   126: invokestatic 1573	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 1576	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 14
    //   137: invokevirtual 434	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 1578
    //   147: ldc_w 1568
    //   150: invokevirtual 1581	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore 7
    //   155: aload 7
    //   157: aload 8
    //   159: invokevirtual 730	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +499 -> 661
    //   165: aconst_null
    //   166: astore 7
    //   168: iconst_0
    //   169: aload 8
    //   171: aload 7
    //   173: invokestatic 1584	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   176: astore 8
    //   178: ldc 221
    //   180: new 126	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1586
    //   187: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 8
    //   192: getfield 1591	com/tencent/mm/crash/a$a:jxH	I
    //   195: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 8
    //   206: getfield 1591	com/tencent/mm/crash/a$a:jxH	I
    //   209: aload 8
    //   211: getfield 1594	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   214: ldc_w 726
    //   217: iconst_1
    //   218: aload 8
    //   220: getfield 1597	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   223: invokestatic 1599	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   226: aload 14
    //   228: invokevirtual 1602	java/io/File:delete	()Z
    //   231: pop
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: new 431	java/io/File
    //   240: dup
    //   241: aload 7
    //   243: invokespecial 896	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 1602	java/io/File:delete	()Z
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -175 -> 79
    //   257: astore 8
    //   259: ldc 221
    //   261: aload 8
    //   263: ldc_w 1604
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 14
    //   274: aastore
    //   275: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -52 -> 226
    //   281: ldc 221
    //   283: ldc_w 1570
    //   286: aload 14
    //   288: invokestatic 1573	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 1576	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   294: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: new 176	java/io/FileReader
    //   300: dup
    //   301: aload 14
    //   303: invokespecial 1607	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   306: astore 15
    //   308: aconst_null
    //   309: astore 9
    //   311: aload 12
    //   313: iconst_0
    //   314: invokevirtual 1610	java/lang/StringBuilder:setLength	(I)V
    //   317: aload 15
    //   319: aload 13
    //   321: invokevirtual 1614	java/io/FileReader:read	([C)I
    //   324: istore_3
    //   325: iload_3
    //   326: iconst_m1
    //   327: if_icmpeq +60 -> 387
    //   330: aload 12
    //   332: aload 13
    //   334: iconst_0
    //   335: iload_3
    //   336: invokevirtual 1617	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: goto -23 -> 317
    //   343: astore 8
    //   345: aload 8
    //   347: athrow
    //   348: astore 7
    //   350: aload 8
    //   352: ifnull +261 -> 613
    //   355: aload 15
    //   357: invokevirtual 1618	java/io/FileReader:close	()V
    //   360: aload 7
    //   362: athrow
    //   363: astore 7
    //   365: ldc 221
    //   367: aload 7
    //   369: ldc_w 1604
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: aload 14
    //   380: aastore
    //   381: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: goto -134 -> 250
    //   387: aload 12
    //   389: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore 8
    //   394: aload 14
    //   396: invokevirtual 1564	java/io/File:getName	()Ljava/lang/String;
    //   399: ldc_w 1620
    //   402: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   405: ifeq +24 -> 429
    //   408: aload 8
    //   410: iconst_0
    //   411: iconst_0
    //   412: invokestatic 734	com/tencent/mm/app/t:e	(Ljava/lang/String;IZ)V
    //   415: aload 14
    //   417: invokevirtual 1602	java/io/File:delete	()Z
    //   420: pop
    //   421: aload 15
    //   423: invokevirtual 1618	java/io/FileReader:close	()V
    //   426: goto -176 -> 250
    //   429: getstatic 760	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   432: astore 7
    //   434: ldc_w 1622
    //   437: invokestatic 1628	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   440: aload 8
    //   442: invokevirtual 1632	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   445: astore 16
    //   447: aload 16
    //   449: invokevirtual 1637	java/util/regex/Matcher:find	()Z
    //   452: ifeq +206 -> 658
    //   455: aload 16
    //   457: iconst_1
    //   458: invokevirtual 1640	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   461: astore 10
    //   463: aload 10
    //   465: astore 7
    //   467: aload 10
    //   469: ldc_w 1642
    //   472: invokevirtual 189	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifne +42 -> 517
    //   478: aload 10
    //   480: invokestatic 1645	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   483: istore_3
    //   484: aload 10
    //   486: astore 7
    //   488: iload_3
    //   489: ifeq +28 -> 517
    //   492: new 126	java/lang/StringBuilder
    //   495: dup
    //   496: ldc_w 1642
    //   499: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   502: iload_3
    //   503: invokestatic 1648	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   506: invokevirtual 1651	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   509: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore 7
    //   517: aload 8
    //   519: aload 16
    //   521: invokevirtual 1654	java/util/regex/Matcher:end	()I
    //   524: invokevirtual 895	java/lang/String:substring	(I)Ljava/lang/String;
    //   527: astore 8
    //   529: aload 8
    //   531: invokevirtual 1655	java/lang/String:isEmpty	()Z
    //   534: ifne +49 -> 583
    //   537: iconst_0
    //   538: istore_3
    //   539: ldc_w 1657
    //   542: invokestatic 1628	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   545: aload 8
    //   547: invokevirtual 1632	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   550: astore 10
    //   552: aload 10
    //   554: invokevirtual 1637	java/util/regex/Matcher:find	()Z
    //   557: ifeq +14 -> 571
    //   560: aload 10
    //   562: iconst_1
    //   563: invokevirtual 1640	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   566: iconst_0
    //   567: invokestatic 1660	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   570: istore_3
    //   571: iload_3
    //   572: aload 8
    //   574: ldc_w 1662
    //   577: iconst_1
    //   578: aload 7
    //   580: invokestatic 1599	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   583: aload 14
    //   585: invokevirtual 1602	java/io/File:delete	()Z
    //   588: pop
    //   589: goto -168 -> 421
    //   592: astore 7
    //   594: aload 9
    //   596: astore 8
    //   598: goto -248 -> 350
    //   601: astore 9
    //   603: aload 8
    //   605: aload 9
    //   607: invokevirtual 1666	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   610: goto -250 -> 360
    //   613: aload 15
    //   615: invokevirtual 1618	java/io/FileReader:close	()V
    //   618: goto -258 -> 360
    //   621: ldc 221
    //   623: ldc_w 1668
    //   626: iconst_2
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: lload 5
    //   634: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: invokestatic 699	java/lang/System:currentTimeMillis	()J
    //   643: lload 5
    //   645: lsub
    //   646: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: aastore
    //   650: invokestatic 773	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: aload_1
    //   654: invokestatic 1670	com/tencent/mm/app/t:bL	(Landroid/content/Context;)V
    //   657: return
    //   658: goto -129 -> 529
    //   661: goto -493 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	t
    //   0	664	1	paramContext	Context
    //   78	176	2	i	int
    //   324	248	3	j	int
    //   75	8	4	k	int
    //   51	593	5	l	long
    //   12	230	7	str	String
    //   348	13	7	localObject1	Object
    //   363	5	7	localException	Exception
    //   432	147	7	localObject2	Object
    //   592	1	7	localObject3	Object
    //   140	79	8	localObject4	Object
    //   257	5	8	localIOException	java.io.IOException
    //   343	8	8	localThrowable1	Throwable
    //   392	212	8	localObject5	Object
    //   309	286	9	localObject6	Object
    //   601	5	9	localThrowable2	Throwable
    //   461	100	10	localObject7	Object
    //   41	45	11	arrayOfFile	File[]
    //   63	325	12	localStringBuilder	StringBuilder
    //   70	263	13	arrayOfChar	char[]
    //   89	495	14	localFile	File
    //   306	308	15	localFileReader	java.io.FileReader
    //   445	75	16	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   168	226	257	java/io/IOException
    //   311	317	343	java/lang/Throwable
    //   317	325	343	java/lang/Throwable
    //   330	340	343	java/lang/Throwable
    //   387	421	343	java/lang/Throwable
    //   429	463	343	java/lang/Throwable
    //   467	484	343	java/lang/Throwable
    //   492	517	343	java/lang/Throwable
    //   517	529	343	java/lang/Throwable
    //   529	537	343	java/lang/Throwable
    //   539	552	343	java/lang/Throwable
    //   552	571	343	java/lang/Throwable
    //   571	583	343	java/lang/Throwable
    //   583	589	343	java/lang/Throwable
    //   345	348	348	finally
    //   297	308	363	java/lang/Exception
    //   355	360	363	java/lang/Exception
    //   360	363	363	java/lang/Exception
    //   421	426	363	java/lang/Exception
    //   603	610	363	java/lang/Exception
    //   613	618	363	java/lang/Exception
    //   311	317	592	finally
    //   317	325	592	finally
    //   330	340	592	finally
    //   387	421	592	finally
    //   429	463	592	finally
    //   467	484	592	finally
    //   492	517	592	finally
    //   517	529	592	finally
    //   529	537	592	finally
    //   539	552	592	finally
    //   552	571	592	finally
    //   571	583	592	finally
    //   583	589	592	finally
    //   355	360	601	java/lang/Throwable
  }
  
  public final void init(Context paramContext, boolean paramBoolean)
  {
    MMUncaughtExceptionHandler.setReporter(this);
    if (fdg.endsWith(":push")) {}
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
    this.fdd = ((File)localObject2).getParent();
    if ((this.fdd == null) || (this.fdd.length() == 0)) {
      this.fdd = "/";
    }
    this.fde = ((File)localObject2).getName();
    this.fdf = new ConditionVariable();
    Log.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.fdc = new HashSet();
    this.fcY = new a(this.fdd);
    this.fcY.startWatching();
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
    fdb.remove(paramICrashReportListener);
  }
  
  public final void reportCrashMessage(String paramString1, String paramString2)
  {
    c.b localb = com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 4);
    e(a(paramString1, true, BuildInfo.CLIENT_VERSION, localb) + paramString2 + '\n' + a(localb), 0, false);
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
      ah.e(paramThrowable);
      paramThrowable = com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 4);
      e(paramString + '\n' + a(paramThrowable) + '\n', 0, false);
      com.tencent.mm.wlogcat.b.a.ijH().ijI();
      Log.i("MicroMsg.MMCrashReporter", "Crash msg content size: %s", new Object[] { Integer.valueOf(paramString.length()) });
      return;
      paramMMUncaughtExceptionHandler = "";
    }
  }
  
  public final void reportJniCrash(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, BuildInfo.CLIENT_VERSION);
    com.tencent.mm.wlogcat.b.a.ijH().ijI();
  }
  
  public final void reportRawMessage(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.y.d.eUZ() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", aaQ());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.y.d.eUZ().at(MMApplicationContext.getContext(), localIntent);
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
      //   6: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   9: invokestatic 28	com/tencent/mm/app/t:a	(Lcom/tencent/mm/app/t;)J
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
      //   28: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   31: getfield 34	com/tencent/mm/app/t:fdc	Ljava/util/HashSet;
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
      //   109: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   112: getfield 58	com/tencent/mm/app/t:fdf	Landroid/os/ConditionVariable;
      //   115: invokevirtual 64	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   122: getfield 68	com/tencent/mm/app/t:fdm	Lcom/tencent/mm/app/t$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   132: new 70	com/tencent/mm/app/t$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   140: iconst_0
      //   141: invokespecial 73	com/tencent/mm/app/t$b:<init>	(Lcom/tencent/mm/app/t;B)V
      //   144: putfield 68	com/tencent/mm/app/t:fdm	Lcom/tencent/mm/app/t$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   151: getfield 68	com/tencent/mm/app/t:fdm	Lcom/tencent/mm/app/t$b;
      //   154: ldc 75
      //   156: invokestatic 81	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   163: getfield 34	com/tencent/mm/app/t:fdc	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/t$a:fdq	Lcom/tencent/mm/app/t;
      //   178: getfield 34	com/tencent/mm/app/t:fdc	Ljava/util/HashSet;
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
    
    private static ActivityManager.ProcessErrorStateInfo aaY()
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
        if (t.this.fdf.block(10000L)) {
          t.this.fdf.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = aaY();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = aaY();
            localObject2 = ???;
            if (??? == null)
            {
              Log.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              t.this.fdm = null;
              return;
            }
          }
          Log.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (t.this.fdc)
            {
              localObject4 = new ArrayList(t.this.fdc.size());
              int i = t.this.fde.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = t.this.fde.substring(0, i) + '_' + str + t.this.fde.substring(i);
                if (t.this.fdc.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (t.this.fdc.remove(t.this.fde)) {
                ((ArrayList)localObject4).add(t.this.fde);
              }
              ((ArrayList)localObject4).addAll(t.this.fdc);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = t.this.fdd + '/' + (String)localObject4;
                str = t.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  t.this.N(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                Log.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                t.this.fdm = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.t
 * JD-Core Version:    0.7.0.1
 */