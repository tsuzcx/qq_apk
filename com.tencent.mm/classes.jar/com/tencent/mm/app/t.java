package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.AppOpsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Base64;
import com.tencent.f.i;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.CoreService.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.crash.CrashUploaderService;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.i.f;
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
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import junit.framework.AssertionFailedError;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements CoreService.b, ICrashReporter, MMUncaughtExceptionHandler.IReporter
{
  private static String dlA;
  private static Message dlB;
  private static long dlC;
  private static boolean dlD;
  private static boolean dlE;
  private static long[] dlF = { 0L, 0L, 0L };
  public static final long dlq = ;
  private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> dlu = new HashSet();
  private static final Set<ICrashReporter.ICrashReportListener> dlv = new HashSet();
  private static CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter;
  volatile b dlG;
  private MMUncaughtExceptionHandler dlr = null;
  private a dls;
  private volatile long dlt = 0L;
  HashSet<String> dlw;
  String dlx;
  String dly;
  ConditionVariable dlz;
  
  static
  {
    dlA = "";
    dlB = null;
    dlC = 0L;
    dlD = false;
    dlE = false;
    sCrashExtraMessageGetter = new CrashMonitorForJni.CrashExtraMessageGetter()
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
        localObject1 = t.Wy().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ICrashReporter.ICrashReportExtraMessageGetter)((Iterator)localObject1).next();
          localStringBuilder.append('\n').append(((ICrashReporter.ICrashReportExtraMessageGetter)localObject2).getCrashReportExtraMessage());
        }
        return localStringBuilder.toString();
      }
    };
  }
  
  private static String Wv()
  {
    String str2 = bf.iDu.aA("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bf.iDu.aA("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static boolean Ww()
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
  
  private static String Wx()
  {
    try
    {
      localObject2 = com.tencent.mm.compatible.deviceinfo.af.get("dalvik.vm.stack-trace-file");
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
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 212	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 408	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 410	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc_w 412
    //   22: invokespecial 413	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   25: astore 10
    //   27: new 212	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 415
    //   34: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_1
    //   38: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 420
    //   44: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 11
    //   52: aload 4
    //   54: ifnull +19 -> 73
    //   57: aload 9
    //   59: aload 4
    //   61: getfield 423	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   64: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: bipush 10
    //   69: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: new 425	java/io/BufferedReader
    //   76: dup
    //   77: new 427	java/io/FileReader
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 428	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   85: invokespecial 431	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 4
    //   90: iload 5
    //   92: istore_1
    //   93: aload 4
    //   95: astore_0
    //   96: aload 4
    //   98: invokevirtual 434	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 12
    //   103: aload 12
    //   105: ifnull +250 -> 355
    //   108: iload_1
    //   109: tableswitch	default:+298 -> 407, 0:+27->136, 1:+100->209, 2:+160->269
    //   137: iconst_1
    //   138: astore_0
    //   139: aload 12
    //   141: aload 11
    //   143: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifeq -53 -> 93
    //   149: aload 4
    //   151: astore_0
    //   152: aload 11
    //   154: invokevirtual 339	java/lang/String:length	()I
    //   157: istore 5
    //   159: aload 4
    //   161: astore_0
    //   162: aload 10
    //   164: aload 12
    //   166: iload 5
    //   168: iload 5
    //   170: bipush 19
    //   172: iadd
    //   173: invokevirtual 356	java/lang/String:substring	(II)Ljava/lang/String;
    //   176: invokevirtual 441	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   179: invokevirtual 446	java/util/Date:getTime	()J
    //   182: lload_2
    //   183: lsub
    //   184: lstore 6
    //   186: lload 6
    //   188: ldc2_w 447
    //   191: lcmp
    //   192: iflt -99 -> 93
    //   195: lload 6
    //   197: ldc2_w 449
    //   200: lcmp
    //   201: ifgt -108 -> 93
    //   204: iconst_1
    //   205: istore_1
    //   206: goto -113 -> 93
    //   209: aload 4
    //   211: astore_0
    //   212: aload 9
    //   214: aload 12
    //   216: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: bipush 10
    //   221: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: astore_0
    //   228: aload 12
    //   230: ldc_w 452
    //   233: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   236: ifeq +8 -> 244
    //   239: iconst_2
    //   240: istore_1
    //   241: goto -148 -> 93
    //   244: aload 4
    //   246: astore_0
    //   247: aload 12
    //   249: ldc_w 454
    //   252: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: istore 8
    //   257: iload 8
    //   259: ifeq -166 -> 93
    //   262: aload 4
    //   264: invokevirtual 457	java/io/BufferedReader:close	()V
    //   267: aconst_null
    //   268: areturn
    //   269: aload 4
    //   271: astore_0
    //   272: aload 12
    //   274: ldc_w 459
    //   277: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   280: ifeq +25 -> 305
    //   283: aload 4
    //   285: astore_0
    //   286: aload 9
    //   288: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload 4
    //   295: invokevirtual 457	java/io/BufferedReader:close	()V
    //   298: aload 9
    //   300: areturn
    //   301: astore_0
    //   302: aload 9
    //   304: areturn
    //   305: aload 4
    //   307: astore_0
    //   308: aload 9
    //   310: aload 12
    //   312: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: bipush 10
    //   317: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: goto -228 -> 93
    //   324: astore 9
    //   326: aload 4
    //   328: astore_0
    //   329: ldc 170
    //   331: aload 9
    //   333: ldc_w 461
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 457	java/io/BufferedReader:close	()V
    //   353: aconst_null
    //   354: areturn
    //   355: aload 4
    //   357: invokevirtual 457	java/io/BufferedReader:close	()V
    //   360: goto -7 -> 353
    //   363: astore_0
    //   364: goto -11 -> 353
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_0
    //   371: aload_0
    //   372: ifnull +7 -> 379
    //   375: aload_0
    //   376: invokevirtual 457	java/io/BufferedReader:close	()V
    //   379: aload 4
    //   381: athrow
    //   382: astore_0
    //   383: goto -116 -> 267
    //   386: astore_0
    //   387: goto -34 -> 353
    //   390: astore_0
    //   391: goto -12 -> 379
    //   394: astore 4
    //   396: goto -25 -> 371
    //   399: astore 9
    //   401: aconst_null
    //   402: astore 4
    //   404: goto -78 -> 326
    //   407: goto -314 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramString	String
    //   0	410	1	paramInt	int
    //   0	410	2	paramLong	long
    //   0	410	4	paramProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    //   1	172	5	i	int
    //   184	12	6	l	long
    //   255	3	8	bool	boolean
    //   13	296	9	localObject	Object
    //   324	8	9	localException1	Exception
    //   399	1	9	localException2	Exception
    //   25	138	10	localSimpleDateFormat	SimpleDateFormat
    //   50	103	11	str1	String
    //   101	210	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   293	298	301	java/io/IOException
    //   96	103	324	java/lang/Exception
    //   139	149	324	java/lang/Exception
    //   152	159	324	java/lang/Exception
    //   162	186	324	java/lang/Exception
    //   212	225	324	java/lang/Exception
    //   228	239	324	java/lang/Exception
    //   247	257	324	java/lang/Exception
    //   272	283	324	java/lang/Exception
    //   286	293	324	java/lang/Exception
    //   308	321	324	java/lang/Exception
    //   355	360	363	java/io/IOException
    //   73	90	367	finally
    //   262	267	382	java/io/IOException
    //   348	353	386	java/io/IOException
    //   375	379	390	java/io/IOException
    //   96	103	394	finally
    //   139	149	394	finally
    //   152	159	394	finally
    //   162	186	394	finally
    //   212	225	394	finally
    //   228	239	394	finally
    //   247	257	394	finally
    //   272	283	394	finally
    //   286	293	394	finally
    //   308	321	394	finally
    //   329	343	394	finally
    //   73	90	399	java/lang/Exception
  }
  
  private static StringBuilder a(String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject = MMApplicationContext.getContext();
    StringBuilder localStringBuilder = new StringBuilder(600);
    for (;;)
    {
      try
      {
        localStringBuilder.append(" \n");
        localStringBuilder.append("#build.info=" + BuildInfo.info()).append('\n');
        localStringBuilder.append("#client.version=").append(paramString2).append('\n');
        localStringBuilder.append("#client.verHistory=").append(cp.sj(4)).append('\n');
        localStringBuilder.append("#client.revision=").append(BuildInfo.REV).append('\n');
        localStringBuilder.append("#client.uin=").append(bf.iDu.aA("last_login_uin", p.getString(q.aoG().hashCode()))).append('\n');
        localStringBuilder.append("#client.dev=").append(q.aoG()).append('\n');
        localStringBuilder.append("#client.build=").append(BuildInfo.TIME).append(":").append(BuildInfo.HOSTNAME).append(":").append(ChannelUtil.channelId).append('\n');
        localStringBuilder.append("#client.runtime=").append(Util.nowMilliSecond() - dlq).append("(").append(Util.nullAsNil(dlA)).append(")\n");
        localStringBuilder.append("#client.IMEI=").append(q.dr(true)).append('\n');
        localStringBuilder.append("#client.abi=").append(Build.CPU_ABI).append('\n');
        localStringBuilder.append("#qbrwoser.coreVersion=").append(WebView.getInstalledTbsCoreVersion((Context)localObject)).append('\n');
        localStringBuilder.append("#qbrwoser.ver=").append(WebView.getTbsSDKVersion((Context)localObject)).append('\n');
        localObject = localStringBuilder.append("#status.dwx_bt=");
        if (!CrashReportFactory.isDualByTools()) {
          break label1372;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.xh=");
        if (!CrashReportFactory.isHookedByXposed()) {
          break label1379;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.x86_env=");
        if (!CrashReportFactory.isX86Env()) {
          break label1386;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localStringBuilder.append("#xsdkver=201201\n");
        localStringBuilder.append("#accinfo.foreground=").append(AppForegroundDelegate.djR.cPB).append('\n');
        localStringBuilder.append("#accinfo.currentThread=").append(Thread.currentThread().getName()).append('\n');
        paramString2 = localStringBuilder.append("#accinfo.currentActivity=");
        localObject = AppForegroundDelegate.djR;
        paramString2.append(AppForegroundDelegate.Wb()).append('\n');
        paramString2 = new Date();
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilder.append("#accinfo.crashTime=").append(((SimpleDateFormat)localObject).format(paramString2)).append('\n');
        Log.i("MicroMsg.MMCrashReporter", "build header.");
        try
        {
          paramString2 = new StatFs(Environment.getDataDirectory().getPath());
          localObject = new StatFs(com.tencent.mm.loader.j.b.aKD());
          CountDownLatch localCountDownLatch = new CountDownLatch(1);
          com.tencent.f.h.RTc.aX(new Runnable()
          {
            public final void run()
            {
              try
              {
                t.q(MMApplicationContext.getContext(), MMApplicationContext.getContext().getPackageName());
                this.dlH.countDown();
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("MicroMsg.MMCrashReporter", "getPkgSize failed :%s", new Object[] { localException.getMessage() });
                }
              }
            }
          });
          localCountDownLatch.await(2L, TimeUnit.SECONDS);
          paramString2 = String.format("%s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Long.valueOf(paramString2.getBlockSizeLong()), Long.valueOf(paramString2.getBlockCountLong()), Long.valueOf(paramString2.getAvailableBlocksLong()), Long.valueOf(dlF[0]), Long.valueOf(dlF[1]), Long.valueOf(dlF[2]), com.tencent.mm.loader.j.b.aKD(), Long.valueOf(((StatFs)localObject).getBlockSizeLong()), Long.valueOf(((StatFs)localObject).getBlockCountLong()), Long.valueOf(((StatFs)localObject).getAvailableBlocksLong()) });
          localStringBuilder.append("#accinfo.data=").append(paramString2).append('\n');
        }
        catch (Exception paramString2)
        {
          try
          {
            localStringBuilder.append("#xwalk.coreVersion=").append(XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext())).append('\n');
            if (XWalkEnvironment.getApplicationContext() != null) {
              localStringBuilder.append("#xwalk.sysWebCore=").append(XWalkEnvironment.safeGetChromiunVersion()).append('\n');
            }
            try
            {
              paramString2 = com.tencent.xweb.xwalk.a.h.hvo();
              if (paramString2.isEmpty()) {
                break label1275;
              }
              localStringBuilder.append("#xwalk.pluginInit=true\n");
              paramString2 = paramString2.iterator();
              if (paramString2.hasNext())
              {
                localObject = (com.tencent.xweb.xwalk.a.g)paramString2.next();
                if (localObject == null) {
                  continue;
                }
                localStringBuilder.append("#xwalk.").append(((com.tencent.xweb.xwalk.a.g)localObject).getPluginName()).append("=").append(((com.tencent.xweb.xwalk.a.g)localObject).SHU).append('\n');
                continue;
              }
              paramString2 = MMApplicationContext.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            }
            catch (Exception paramString2)
            {
              Log.e("MicroMsg.MMCrashReporter", "get xwalk plugin info error ", new Object[] { paramString2 });
            }
            if (paramString2 != null)
            {
              localStringBuilder.append("#qbrowser.url=").append(paramString2).append('\n');
              paramString2 = MMApplicationContext.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
              paramString2.remove("url");
              paramString2.apply();
            }
            if (paramBoolean)
            {
              paramString2 = sCrashExtraMessageGetter.getExtraMessage();
              if (!Util.isNullOrNil(paramString2)) {
                localStringBuilder.append("#extraCrashMsg=").append(paramString2).append('\n');
              }
            }
            localStringBuilder.append("#runtime.memory=").append(com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0));
            localObject = com.tencent.mm.ad.a.aBz();
            paramString2 = (String)localObject;
            if (((String)localObject).length() > 1024) {
              paramString2 = ((String)localObject).substring(0, 1024);
            }
            localStringBuilder.append("#runtime.Activity dump [").append(paramString2).append("]\n\n");
            int i = ThreadWatchDog.getProcessThreadCount();
            localStringBuilder.append("#runtime.processThreadCount=").append(i).append('\n');
            if ((i >= 130) || (BuildInfo.DEBUG))
            {
              localStringBuilder.append("#runtime.threadInfo=");
              localStringBuilder.append(com.tencent.matrix.f.a.To()).append('\n');
            }
            if (!Util.isNullOrNil(paramString1)) {
              localStringBuilder.append("#subHeader=").append(paramString1).append('\n');
            }
            localStringBuilder.append("#crashContent=\n");
            return localStringBuilder;
            paramString2 = paramString2;
            Log.e("MicroMsg.MMCrashReporter", "check data size failed :%s", new Object[] { paramString2.getMessage() });
            paramString2 = "";
          }
          catch (Exception paramString2)
          {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", paramString2, "", new Object[0]);
            continue;
          }
        }
        localStringBuilder.append("#xwalk.pluginInit=false\n");
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "", new Object[0]);
        return localStringBuilder;
      }
      label1275:
      paramString2 = com.tencent.xweb.xwalk.a.h.lI(MMApplicationContext.getContext()).entrySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (Map.Entry)paramString2.next();
        if (localObject != null) {
          localStringBuilder.append("#xwalk.").append((String)((Map.Entry)localObject).getKey()).append("=").append(((Map.Entry)localObject).getValue()).append('\n');
        }
      }
      continue;
      label1372:
      paramString2 = "0";
      continue;
      label1379:
      paramString2 = "0";
      continue;
      label1386:
      paramString2 = "0";
    }
  }
  
  /* Error */
  private static void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: iload_0
    //   8: bipush 6
    //   10: if_icmpne +31 -> 41
    //   13: invokestatic 841	com/tencent/mm/app/t:Wx	()Ljava/lang/String;
    //   16: astore 7
    //   18: aload 6
    //   20: astore 5
    //   22: aload 7
    //   24: ifnull +17 -> 41
    //   27: aload 7
    //   29: invokestatic 326	android/os/Process:myPid	()I
    //   32: invokestatic 846	java/lang/System:currentTimeMillis	()J
    //   35: aconst_null
    //   36: invokestatic 848	com/tencent/mm/app/t:a	(Ljava/lang/String;IJLandroid/app/ActivityManager$ProcessErrorStateInfo;)Ljava/lang/String;
    //   39: astore 5
    //   41: new 212	java/lang/StringBuilder
    //   44: dup
    //   45: sipush 1024
    //   48: invokespecial 408	java/lang/StringBuilder:<init>	(I)V
    //   51: astore 6
    //   53: aload 6
    //   55: ldc_w 850
    //   58: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_0
    //   62: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: bipush 10
    //   67: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: ldc_w 852
    //   76: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_3
    //   80: invokevirtual 591	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: bipush 10
    //   85: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 6
    //   91: ldc_w 854
    //   94: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: bipush 10
    //   103: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 6
    //   109: ldc 94
    //   111: iconst_0
    //   112: aload 4
    //   114: invokestatic 120	com/tencent/mm/app/t:a	(Ljava/lang/String;ZLjava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 857	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 6
    //   123: aload_1
    //   124: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: bipush 10
    //   129: invokevirtual 359	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: ifnull +20 -> 155
    //   138: aload 6
    //   140: ldc_w 859
    //   143: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 6
    //   149: aload 5
    //   151: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore_1
    //   161: getstatic 92	com/tencent/mm/app/t:dlv	Ljava/util/Set;
    //   164: invokeinterface 828 1 0
    //   169: astore 4
    //   171: aload 4
    //   173: invokeinterface 288 1 0
    //   178: ifeq +48 -> 226
    //   181: aload 4
    //   183: invokeinterface 292 1 0
    //   188: checkcast 861	com/tencent/mm/sdk/crash/ICrashReporter$ICrashReportListener
    //   191: aload_1
    //   192: invokeinterface 864 2 0
    //   197: goto -26 -> 171
    //   200: astore_1
    //   201: ldc 170
    //   203: aload_1
    //   204: ldc_w 866
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_1
    //   215: instanceof 868
    //   218: ifeq +36 -> 254
    //   221: aload_1
    //   222: checkcast 868	java/lang/RuntimeException
    //   225: athrow
    //   226: ldc_w 870
    //   229: aload_2
    //   230: invokevirtual 874	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +14 -> 247
    //   236: ldc_w 875
    //   239: istore_0
    //   240: aload_1
    //   241: iload_0
    //   242: iconst_1
    //   243: invokestatic 878	com/tencent/mm/app/t:b	(Ljava/lang/String;IZ)V
    //   246: return
    //   247: sipush 8192
    //   250: istore_0
    //   251: goto -11 -> 240
    //   254: aload_1
    //   255: instanceof 880
    //   258: ifeq -12 -> 246
    //   261: aload_1
    //   262: checkcast 880	java/lang/Error
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramInt	int
    //   0	266	1	paramString1	String
    //   0	266	2	paramString2	String
    //   0	266	3	paramBoolean	boolean
    //   0	266	4	paramString3	String
    //   5	145	5	localObject	Object
    //   1	155	6	localStringBuilder	StringBuilder
    //   16	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   13	18	200	java/lang/Throwable
    //   27	41	200	java/lang/Throwable
    //   41	133	200	java/lang/Throwable
    //   138	155	200	java/lang/Throwable
    //   155	171	200	java/lang/Throwable
    //   171	197	200	java/lang/Throwable
    //   226	236	200	java/lang/Throwable
    //   240	246	200	java/lang/Throwable
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, String paramString3, int paramInt2)
  {
    String str2 = f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L);
    String str3 = BuildInfo.REV;
    String str4 = BuildInfo.CLIENT_VERSION;
    String str1 = "";
    if (dlB != null) {
      str1 = dlB.toString();
    }
    long l1 = CrashReportFactory.heavyUserFlag;
    Log.i("MicroMsg.MMCrashReporter", "reportSignalAnrReal, heavyUserflag = %d", new Object[] { Long.valueOf(l1) });
    e.Cxv.idkeyStat(1356L, 61L, 1L, true);
    e locale = e.Cxv;
    int i;
    long l2;
    if (paramBoolean)
    {
      i = 1;
      l2 = dlC;
      if (!dlD) {
        break label215;
      }
    }
    label215:
    for (int j = 1;; j = 0)
    {
      locale.a(19664, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), paramString3, str2, str3, str1, Long.valueOf(l2), Integer.valueOf(paramInt2), Integer.valueOf(j), Long.valueOf(l1), str4 });
      return;
      i = 0;
      break;
    }
  }
  
  public static void addOnUncaughtExceptionListener(MMUncaughtExceptionHandler.IOnUncaughtExceptionListener paramIOnUncaughtExceptionListener)
  {
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(paramIOnUncaughtExceptionListener);
  }
  
  private static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    ge(paramString);
    com.tencent.mm.plugin.report.service.h.CyF.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (MMApplicationContext.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (h.bH(MMApplicationContext.getContext()) == 1)
      {
        int i = h.bI(MMApplicationContext.getContext());
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
      if (com.tencent.mm.plugin.p.d.elq() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", Wv());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.p.d.elq().ak(MMApplicationContext.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.h.CyF;
      com.tencent.mm.plugin.report.service.h.eOI();
      return;
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (MMApplicationContext.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!MMApplicationContext.isMMProcess()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  private static void bM(Context paramContext)
  {
    int i = 0;
    String str1 = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("login_user_name", "never_login_crash");
    Object localObject = paramContext.getSharedPreferences("system_config_prefs", 0);
    StringBuilder localStringBuilder = new StringBuilder("http://");
    String str2 = com.tencent.mm.network.c.icB;
    localObject = ((SharedPreferences)localObject).getString(str2, str2);
    paramContext = new o(paramContext.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramContext = paramContext.het();
      int j = paramContext.length;
      while (i < j)
      {
        localStringBuilder = paramContext[i];
        if ((localStringBuilder.isDirectory()) && (localStringBuilder.getName().endsWith("_nf"))) {
          CrashUploaderService.a(localStringBuilder, str1, com.tencent.mm.loader.j.a.ics, (String)localObject, "exception");
        }
        i += 1;
      }
    }
  }
  
  private static boolean cN(boolean paramBoolean)
  {
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      dlB = (Message)localObject;
      if (localObject != null)
      {
        long l1 = ((Message)localObject).getWhen();
        if (l1 == 0L) {
          return false;
        }
        long l2 = l1 - SystemClock.uptimeMillis();
        dlC = l2;
        l1 = -10000L;
        if (paramBoolean) {
          l1 = -2000L;
        }
        if (l2 < l1)
        {
          if (((Message)localObject).getTarget() == null) {
            com.tencent.f.h.RTc.aX(new Runnable()
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
  
  public static boolean d(boolean paramBoolean, String paramString)
  {
    Object localObject4 = null;
    dlA = paramString;
    if (com.tencent.mm.plugin.p.d.elq() == null) {}
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
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + dlA);
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + dlA);
        localObject1 = com.tencent.mm.br.c.mI("sandbox", ".SubCoreSandBox");
        Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + dlA);
        if (localObject1 == null) {}
      }
      catch (Exception localException4)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = (com.tencent.mm.plugin.p.c)((Class)localObject1).newInstance();
            com.tencent.mm.plugin.p.d.a((com.tencent.mm.plugin.p.c)localObject1);
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + dlA);
            try
            {
              localObject1 = (ICrashReporter)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((ICrashReporter)localObject1).init(MMApplicationContext.getContext(), paramBoolean);
              ((ICrashReporter)localObject1).setReportID(bf.iDu.aA("last_login_uin", p.getString(q.aoG().hashCode())));
              CrashReportFactory.setupCrashReporter((ICrashReporter)localObject1);
              ((ICrashReporter)localObject1).setupSubReporter(new ISubReporter()
              {
                public final void report(String paramAnonymousString)
                {
                  if (com.tencent.mm.plugin.p.d.elq() != null)
                  {
                    Intent localIntent = new Intent();
                    localIntent.setAction("uncatch_exception");
                    localIntent.putExtra("exceptionPid", Process.myPid());
                    localIntent.putExtra("userName", t.access$100());
                    localIntent.putExtra("tag", 0);
                    localIntent.putExtra("exceptionMsg", Base64.encodeToString((t.Q("", BuildInfo.CLIENT_VERSION) + paramAnonymousString).getBytes(), 2));
                    com.tencent.mm.plugin.p.d.elq().ak(MMApplicationContext.getContext(), localIntent);
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
    boolean bool;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support")))
    {
      i = 1;
      NativeCrash.class.getClassLoader();
      j.Ed("wechatcrash");
      paramString = com.tencent.mm.crash.a.arO();
      if (i != 0)
      {
        localObject3 = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
        com.tencent.mm.crash.a.EJ((String)localObject3);
        Log.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
      }
      paramString.gNl = sCrashExtraMessageGetter;
      cp.KL(com.tencent.mm.loader.j.b.aKB());
      EventCenter.instance.add(new IListener() {});
      bool = MultiProcessMMKV.getDefault().getBoolean("clicfg_lag_report", false);
      paramBoolean = MultiProcessMMKV.getDefault().getBoolean("clicfg_anr_trace", false);
      paramString = new a.a();
      paramString.a = true;
      if ((Build.VERSION.SDK_INT < 26) || ((!paramBoolean) && (!com.tencent.mm.protocal.d.KyR) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))) {
        break label733;
      }
      paramBoolean = true;
      label591:
      dlD = paramBoolean;
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
        paramString.c = new File((File)localObject3, "currentAnr.trace").getAbsolutePath();
      }
      catch (Throwable localThrowable)
      {
        label733:
        Log.e("MicroMsg.MMCrashReporter", "print ANR trace failed, message : " + localThrowable.getMessage());
        continue;
      }
      if (bool)
      {
        paramString.d = true;
        paramString.g = true;
        paramString.f = true;
      }
      paramString.e = false;
      com.tencent.mm.rabbiteye.a.a(new a.b()
      {
        public final void a(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, boolean paramAnonymousBoolean, String paramAnonymousString3)
        {
          String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.MMCrashReporter", "[RabbitEye] Happens Lag stacktrace : %s, processName :%s , scene : %s, isForeground : %b, type : %s", new Object[] { paramAnonymousString2, str, paramAnonymousString3, Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1 });
          if (paramAnonymousString1.equals("Touch"))
          {
            paramAnonymousString1 = com.tencent.mm.plugin.report.service.h.CyF;
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
          paramAnonymousString1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            paramAnonymousString1.a(20841, new Object[] { paramAnonymousString3, paramAnonymousString2, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramAnonymousLong), str });
            return;
          }
        }
        
        public final void gf(String paramAnonymousString)
        {
          try
          {
            e.Cxv.idkeyStat(1356L, 60L, 1L, true);
            com.tencent.mm.plugin.fcm.a.asz(paramAnonymousString);
            t.fV(paramAnonymousString);
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
      break label591;
      Log.i("MicroMsg.MMCrashReporter", "anrTraceDir exists");
    }
  }
  
  private static void ge(String paramString)
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
  
  public static void q(Context arg0, String paramString)
  {
    dlF[0] = 0L;
    dlF[1] = 0L;
    dlF[2] = 0L;
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (dlF)
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
              //   4: invokestatic 22	com/tencent/mm/app/t:WC	()[J
              //   7: iconst_0
              //   8: aload_1
              //   9: getfield 28	android/content/pm/PackageStats:cacheSize	J
              //   12: lastore
              //   13: invokestatic 22	com/tencent/mm/app/t:WC	()[J
              //   16: iconst_1
              //   17: aload_1
              //   18: getfield 31	android/content/pm/PackageStats:dataSize	J
              //   21: lastore
              //   22: invokestatic 22	com/tencent/mm/app/t:WC	()[J
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
              //   79: invokestatic 22	com/tencent/mm/app/t:WC	()[J
              //   82: astore_1
              //   83: aload_1
              //   84: monitorenter
              //   85: invokestatic 22	com/tencent/mm/app/t:WC	()[J
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
              //   0	134	0	this	11
              //   0	134	2	paramAnonymousBoolean	boolean
              //   129	4	3	localObject	Object
              // Exception table:
              //   from	to	target	type
              //   4	79	115	java/lang/Throwable
              //   79	85	115	java/lang/Throwable
              //   94	112	115	java/lang/Throwable
              //   132	134	115	java/lang/Throwable
              //   85	93	129	finally
              //   130	132	129	finally
            }
          } });
          dlF.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            dlF[0] = -1L;
            dlF[1] = -1L;
            dlF[2] = -1L;
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (dlF)
            {
              dlF.notify();
            }
          }
        }
      }
    }
    Log.i("MicroMsg.MMCrashReporter", "getStats, %s", new Object[] { paramString });
    int k = ((AppOpsManager)???.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), paramString);
    boolean bool;
    if (k == 3) {
      if (???.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      ??? = (StorageStatsManager)???.getSystemService("storagestats");
      int i = -1;
      try
      {
        int j = ???.getPackageManager().getPackageUid(paramString, 128);
        i = j;
        ???.getSystemService("storage");
      }
      catch (Exception paramString)
      {
        try
        {
          ??? = ((StorageStatsManager)???).queryStatsForUid(StorageManager.UUID_DEFAULT, i);
          dlF[0] = ???.getCacheBytes();
          dlF[1] = ???.getDataBytes();
          dlF[2] = ???.getAppBytes();
          Log.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool), Long.valueOf(dlF[0]), Long.valueOf(dlF[1]), Long.valueOf(dlF[2]), Util.getStack() });
          return;
          bool = false;
          continue;
          if (k == 0) {}
          for (bool = true;; bool = false) {
            break;
          }
          paramString = paramString;
          Log.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "summer getStats crash1 e:", new Object[0]);
        }
        catch (Exception ???)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "summer getStats crash2 e:", new Object[0]);
            ??? = null;
          }
        }
      }
    }
  }
  
  public final void addCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    if (paramICrashReportListener == null) {
      return;
    }
    dlv.add(paramICrashReportListener);
  }
  
  public final void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter)
  {
    if (paramICrashReportExtraMessageGetter == null) {
      return;
    }
    dlu.add(paramICrashReportExtraMessageGetter);
  }
  
  /* Error */
  public final void bL(Context paramContext)
  {
    // Byte code:
    //   0: ldc 170
    //   2: ldc_w 1506
    //   5: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 1039	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 364	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 1055	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1508
    //   25: invokespecial 1265	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 28	com/tencent/mm/app/t$6
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1511	com/tencent/mm/app/t$6:<init>	(Lcom/tencent/mm/app/t;Ljava/lang/String;)V
    //   38: invokevirtual 1515	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 11
    //   43: aload 11
    //   45: ifnull +608 -> 653
    //   48: invokestatic 846	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 212	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 408	java/lang/StringBuilder:<init>	(I)V
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
    //   93: invokevirtual 1516	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1518
    //   99: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +179 -> 281
    //   105: aload 14
    //   107: invokevirtual 1516	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1520
    //   113: invokevirtual 946	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +134 -> 250
    //   119: ldc 170
    //   121: ldc_w 1522
    //   124: aload 14
    //   126: invokestatic 1525	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 1528	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 14
    //   137: invokevirtual 638	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 1530
    //   147: ldc_w 1520
    //   150: invokevirtual 1534	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore 7
    //   155: aload 7
    //   157: aload 8
    //   159: invokevirtual 874	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +499 -> 661
    //   165: aconst_null
    //   166: astore 7
    //   168: iconst_0
    //   169: aload 8
    //   171: aload 7
    //   173: invokestatic 1537	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   176: astore 8
    //   178: ldc 170
    //   180: new 212	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1539
    //   187: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 8
    //   192: getfield 1544	com/tencent/mm/crash/a$a:gNm	I
    //   195: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 8
    //   206: getfield 1544	com/tencent/mm/crash/a$a:gNm	I
    //   209: aload 8
    //   211: getfield 1547	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   214: ldc_w 870
    //   217: iconst_1
    //   218: aload 8
    //   220: getfield 1550	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   223: invokestatic 1552	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   226: aload 14
    //   228: invokevirtual 1555	java/io/File:delete	()Z
    //   231: pop
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: new 364	java/io/File
    //   240: dup
    //   241: aload 7
    //   243: invokespecial 365	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 1555	java/io/File:delete	()Z
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -175 -> 79
    //   257: astore 8
    //   259: ldc 170
    //   261: aload 8
    //   263: ldc_w 1557
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 14
    //   274: aastore
    //   275: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -52 -> 226
    //   281: ldc 170
    //   283: ldc_w 1522
    //   286: aload 14
    //   288: invokestatic 1525	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 1528	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   294: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: new 427	java/io/FileReader
    //   300: dup
    //   301: aload 14
    //   303: invokespecial 1560	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   306: astore 15
    //   308: aconst_null
    //   309: astore 9
    //   311: aload 12
    //   313: iconst_0
    //   314: invokevirtual 1563	java/lang/StringBuilder:setLength	(I)V
    //   317: aload 15
    //   319: aload 13
    //   321: invokevirtual 1567	java/io/FileReader:read	([C)I
    //   324: istore_3
    //   325: iload_3
    //   326: iconst_m1
    //   327: if_icmpeq +60 -> 387
    //   330: aload 12
    //   332: aload 13
    //   334: iconst_0
    //   335: iload_3
    //   336: invokevirtual 1570	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: goto -23 -> 317
    //   343: astore 8
    //   345: aload 8
    //   347: athrow
    //   348: astore 7
    //   350: aload 8
    //   352: ifnull +261 -> 613
    //   355: aload 15
    //   357: invokevirtual 1571	java/io/FileReader:close	()V
    //   360: aload 7
    //   362: athrow
    //   363: astore 7
    //   365: ldc 170
    //   367: aload 7
    //   369: ldc_w 1557
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: aload 14
    //   380: aastore
    //   381: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: goto -134 -> 250
    //   387: aload 12
    //   389: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore 8
    //   394: aload 14
    //   396: invokevirtual 1516	java/io/File:getName	()Ljava/lang/String;
    //   399: ldc_w 1573
    //   402: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   405: ifeq +24 -> 429
    //   408: aload 8
    //   410: iconst_0
    //   411: iconst_0
    //   412: invokestatic 878	com/tencent/mm/app/t:b	(Ljava/lang/String;IZ)V
    //   415: aload 14
    //   417: invokevirtual 1555	java/io/File:delete	()Z
    //   420: pop
    //   421: aload 15
    //   423: invokevirtual 1571	java/io/FileReader:close	()V
    //   426: goto -176 -> 250
    //   429: getstatic 895	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   432: astore 7
    //   434: ldc_w 1575
    //   437: invokestatic 1581	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   440: aload 8
    //   442: invokevirtual 1585	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   445: astore 16
    //   447: aload 16
    //   449: invokevirtual 1590	java/util/regex/Matcher:find	()Z
    //   452: ifeq +206 -> 658
    //   455: aload 16
    //   457: iconst_1
    //   458: invokevirtual 1593	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   461: astore 10
    //   463: aload 10
    //   465: astore 7
    //   467: aload 10
    //   469: ldc_w 1595
    //   472: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifne +42 -> 517
    //   478: aload 10
    //   480: invokestatic 1598	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   483: istore_3
    //   484: aload 10
    //   486: astore 7
    //   488: iload_3
    //   489: ifeq +28 -> 517
    //   492: new 212	java/lang/StringBuilder
    //   495: dup
    //   496: ldc_w 1595
    //   499: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   502: iload_3
    //   503: invokestatic 1601	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   506: invokevirtual 1604	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   509: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore 7
    //   517: aload 8
    //   519: aload 16
    //   521: invokevirtual 1607	java/util/regex/Matcher:end	()I
    //   524: invokevirtual 362	java/lang/String:substring	(I)Ljava/lang/String;
    //   527: astore 8
    //   529: aload 8
    //   531: invokevirtual 1608	java/lang/String:isEmpty	()Z
    //   534: ifne +49 -> 583
    //   537: iconst_0
    //   538: istore_3
    //   539: ldc_w 1610
    //   542: invokestatic 1581	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   545: aload 8
    //   547: invokevirtual 1585	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   550: astore 10
    //   552: aload 10
    //   554: invokevirtual 1590	java/util/regex/Matcher:find	()Z
    //   557: ifeq +14 -> 571
    //   560: aload 10
    //   562: iconst_1
    //   563: invokevirtual 1593	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   566: iconst_0
    //   567: invokestatic 1613	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   570: istore_3
    //   571: iload_3
    //   572: aload 8
    //   574: ldc_w 1615
    //   577: iconst_1
    //   578: aload 7
    //   580: invokestatic 1552	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   583: aload 14
    //   585: invokevirtual 1555	java/io/File:delete	()Z
    //   588: pop
    //   589: goto -168 -> 421
    //   592: astore 7
    //   594: aload 9
    //   596: astore 8
    //   598: goto -248 -> 350
    //   601: astore 9
    //   603: aload 8
    //   605: aload 9
    //   607: invokevirtual 1619	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   610: goto -250 -> 360
    //   613: aload 15
    //   615: invokevirtual 1571	java/io/FileReader:close	()V
    //   618: goto -258 -> 360
    //   621: ldc 170
    //   623: ldc_w 1621
    //   626: iconst_2
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: lload 5
    //   634: invokestatic 210	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: invokestatic 846	java/lang/System:currentTimeMillis	()J
    //   643: lload 5
    //   645: lsub
    //   646: invokestatic 210	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: aastore
    //   650: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: aload_1
    //   654: invokestatic 1623	com/tencent/mm/app/t:bM	(Landroid/content/Context;)V
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
    if (dlA.endsWith(":push")) {}
    try
    {
      localObject2 = com.tencent.mm.compatible.deviceinfo.af.get("dalvik.vm.stack-trace-file");
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
    this.dlx = ((File)localObject2).getParent();
    if ((this.dlx == null) || (this.dlx.length() == 0)) {
      this.dlx = "/";
    }
    this.dly = ((File)localObject2).getName();
    this.dlz = new ConditionVariable();
    Log.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.dlw = new HashSet();
    this.dls = new a(this.dlx);
    this.dls.startWatching();
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
    dlv.remove(paramICrashReportListener);
  }
  
  public final void reportCrashMessage(String paramString1, String paramString2)
  {
    b(a(paramString1, true, BuildInfo.CLIENT_VERSION) + paramString2, 0, false);
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
      af.e(paramThrowable);
      b(paramString, 0, false);
      com.tencent.mm.wlogcat.b.a.hig().hih();
      return;
      paramMMUncaughtExceptionHandler = "";
    }
  }
  
  public final void reportJniCrash(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, BuildInfo.CLIENT_VERSION);
    com.tencent.mm.wlogcat.b.a.hig().hih();
  }
  
  public final void reportRawMessage(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.p.d.elq() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", Wv());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.p.d.elq().ak(MMApplicationContext.getContext(), localIntent);
    }
  }
  
  public final void setCallbackForReset(CallbackForReset paramCallbackForReset)
  {
    MMUncaughtExceptionHandler.setCallbackForReset(paramCallbackForReset);
  }
  
  public final void setReportID(String paramString) {}
  
  public final void setupSubReporter(ISubReporter paramISubReporter) {}
  
  final void v(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.h.CyF.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(26L, 0L, 1L, true);
    ge(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
    com.tencent.mm.plugin.report.service.h.eOI();
    long l = System.currentTimeMillis();
    if (l - this.dlt < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.dlt = l;
      h.d(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(a("", true, BuildInfo.CLIENT_VERSION));
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
    } while (com.tencent.mm.plugin.p.d.elq() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", bf.iDu.aA("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.p.d.elq().ak(MMApplicationContext.getContext(), paramString);
  }
  
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
      //   6: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
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
      //   28: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   31: getfield 34	com/tencent/mm/app/t:dlw	Ljava/util/HashSet;
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
      //   109: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   112: getfield 58	com/tencent/mm/app/t:dlz	Landroid/os/ConditionVariable;
      //   115: invokevirtual 64	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   122: getfield 68	com/tencent/mm/app/t:dlG	Lcom/tencent/mm/app/t$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   132: new 70	com/tencent/mm/app/t$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   140: iconst_0
      //   141: invokespecial 73	com/tencent/mm/app/t$b:<init>	(Lcom/tencent/mm/app/t;B)V
      //   144: putfield 68	com/tencent/mm/app/t:dlG	Lcom/tencent/mm/app/t$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   151: getfield 68	com/tencent/mm/app/t:dlG	Lcom/tencent/mm/app/t$b;
      //   154: ldc 75
      //   156: invokestatic 81	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   163: getfield 34	com/tencent/mm/app/t:dlw	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/t$a:dlK	Lcom/tencent/mm/app/t;
      //   178: getfield 34	com/tencent/mm/app/t:dlw	Ljava/util/HashSet;
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
      //   89	92	88	finally
      //   94	159	88	finally
      //   159	171	88	finally
      //   174	186	88	finally
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    private static ActivityManager.ProcessErrorStateInfo WD()
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
        if (t.this.dlz.block(10000L)) {
          t.this.dlz.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = WD();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = WD();
            localObject2 = ???;
            if (??? == null)
            {
              Log.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              t.this.dlG = null;
              return;
            }
          }
          Log.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (t.this.dlw)
            {
              localObject4 = new ArrayList(t.this.dlw.size());
              int i = t.this.dly.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = t.this.dly.substring(0, i) + '_' + str + t.this.dly.substring(i);
                if (t.this.dlw.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (t.this.dlw.remove(t.this.dly)) {
                ((ArrayList)localObject4).add(t.this.dly);
              }
              ((ArrayList)localObject4).addAll(t.this.dlw);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = t.this.dlx + '/' + (String)localObject4;
                str = t.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  t.this.v(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                Log.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                t.this.dlG = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.t
 * JD-Core Version:    0.7.0.1
 */