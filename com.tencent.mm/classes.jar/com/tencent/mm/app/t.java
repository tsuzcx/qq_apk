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
import com.tencent.matrix.report.h.d;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.CoreService.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.crash.CrashUploaderService;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cl;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.av.d;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import com.tencent.xweb.xwalk.a.f;
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
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import junit.framework.AssertionFailedError;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements CoreService.b, com.tencent.mm.sdk.a.c, av.d
{
  public static final long cUY = ;
  private static final Set<c.a> cVc = new HashSet();
  private static final String cVh;
  private static final String cVi;
  private static String cVj;
  private static Message cVk;
  private static long cVl;
  private static long[] cVm = { 0L, 0L, 0L };
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  private av cUZ = null;
  private a cVa;
  private volatile long cVb = 0L;
  HashSet<String> cVd;
  String cVe;
  String cVf;
  ConditionVariable cVg;
  volatile b cVn;
  
  static
  {
    String str = q.aaH();
    cVh = str;
    cVi = p.getString(str.hashCode());
    cVj = "";
    cVk = null;
    cVl = 0L;
    sCrashExtraMessageGetter = new CrashMonitorForJni.a()
    {
      public final String Mr()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = ak.getProcessName();
        Object localObject2;
        if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
        {
          localStringBuilder.append("\n");
          localObject1 = WebView.getCrashExtraMessage(ak.getContext());
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.j.hju });
            localObject1 = localObject2;
            if (((String)localObject2).length() > 8192) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
            }
            localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
            ae.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
          }
        }
        localObject1 = t.Mn().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.a)((Iterator)localObject1).next();
          localStringBuilder.append('\n').append(((c.a)localObject2).bfd());
        }
        return localStringBuilder.toString();
      }
    };
  }
  
  private static String Mk()
  {
    String str2 = bb.hIK.ay("login_weixin_username", "");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = bb.hIK.ay("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static boolean Ml()
  {
    try
    {
      Object localObject = ((ActivityManager)ak.getContext().getSystemService("activity")).getProcessesInErrorState();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
        ae.i("MicroMsg.MMCrashReporter", "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", new Object[] { localProcessErrorStateInfo.processName, Integer.valueOf(localProcessErrorStateInfo.condition) });
        if ((localProcessErrorStateInfo.uid != Process.myUid()) && (localProcessErrorStateInfo.condition == 2))
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1356L, 81L, 1L, true);
          ae.i("MicroMsg.MMCrashReporter", "maybe received other apps ANR signal");
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
      ae.e("MicroMsg.MMCrashReporter", "[checkErrorState] error : %s", new Object[] { localThrowable.getMessage() });
    }
    return false;
  }
  
  private static String Mm()
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
          ae.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
          str1 = "/data/anr/traces.txt";
        }
        Object localObject2 = str1;
      } while (new File(str1).isFile());
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = ak.getProcessName();
      if (str2 != null)
      {
        localObject2 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        localObject2 = "com.tencent.mm";
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
    //   3: new 273	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 395	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 397	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc_w 399
    //   22: invokespecial 400	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   25: astore 10
    //   27: new 273	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 402
    //   34: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_1
    //   38: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 407
    //   44: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 11
    //   52: aload 4
    //   54: ifnull +19 -> 73
    //   57: aload 9
    //   59: aload 4
    //   61: getfield 410	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   64: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: bipush 10
    //   69: invokevirtual 285	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: new 412	java/io/BufferedReader
    //   76: dup
    //   77: new 414	java/io/FileReader
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 415	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   85: invokespecial 418	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 4
    //   90: iload 5
    //   92: istore_1
    //   93: aload 4
    //   95: astore_0
    //   96: aload 4
    //   98: invokevirtual 421	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 12
    //   103: aload 12
    //   105: ifnull +250 -> 355
    //   108: iload_1
    //   109: tableswitch	default:+298 -> 407, 0:+27->136, 1:+100->209, 2:+160->269
    //   137: iconst_1
    //   138: astore_0
    //   139: aload 12
    //   141: aload 11
    //   143: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifeq -53 -> 93
    //   149: aload 4
    //   151: astore_0
    //   152: aload 11
    //   154: invokevirtual 260	java/lang/String:length	()I
    //   157: istore 5
    //   159: aload 4
    //   161: astore_0
    //   162: aload 10
    //   164: aload 12
    //   166: iload 5
    //   168: iload 5
    //   170: bipush 19
    //   172: iadd
    //   173: invokevirtual 278	java/lang/String:substring	(II)Ljava/lang/String;
    //   176: invokevirtual 428	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   179: invokevirtual 433	java/util/Date:getTime	()J
    //   182: lload_2
    //   183: lsub
    //   184: lstore 6
    //   186: lload 6
    //   188: ldc2_w 434
    //   191: lcmp
    //   192: iflt -99 -> 93
    //   195: lload 6
    //   197: ldc2_w 436
    //   200: lcmp
    //   201: ifgt -108 -> 93
    //   204: iconst_1
    //   205: istore_1
    //   206: goto -113 -> 93
    //   209: aload 4
    //   211: astore_0
    //   212: aload 9
    //   214: aload 12
    //   216: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: bipush 10
    //   221: invokevirtual 285	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: astore_0
    //   228: aload 12
    //   230: ldc_w 439
    //   233: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   236: ifeq +8 -> 244
    //   239: iconst_2
    //   240: istore_1
    //   241: goto -148 -> 93
    //   244: aload 4
    //   246: astore_0
    //   247: aload 12
    //   249: ldc_w 441
    //   252: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: istore 8
    //   257: iload 8
    //   259: ifeq -166 -> 93
    //   262: aload 4
    //   264: invokevirtual 444	java/io/BufferedReader:close	()V
    //   267: aconst_null
    //   268: areturn
    //   269: aload 4
    //   271: astore_0
    //   272: aload 12
    //   274: ldc_w 446
    //   277: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   280: ifeq +25 -> 305
    //   283: aload 4
    //   285: astore_0
    //   286: aload 9
    //   288: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload 4
    //   295: invokevirtual 444	java/io/BufferedReader:close	()V
    //   298: aload 9
    //   300: areturn
    //   301: astore_0
    //   302: aload 9
    //   304: areturn
    //   305: aload 4
    //   307: astore_0
    //   308: aload 9
    //   310: aload 12
    //   312: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: bipush 10
    //   317: invokevirtual 285	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: goto -228 -> 93
    //   324: astore 9
    //   326: aload 4
    //   328: astore_0
    //   329: ldc 184
    //   331: aload 9
    //   333: ldc_w 448
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 304	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 444	java/io/BufferedReader:close	()V
    //   353: aconst_null
    //   354: areturn
    //   355: aload 4
    //   357: invokevirtual 444	java/io/BufferedReader:close	()V
    //   360: goto -7 -> 353
    //   363: astore_0
    //   364: goto -11 -> 353
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_0
    //   371: aload_0
    //   372: ifnull +7 -> 379
    //   375: aload_0
    //   376: invokevirtual 444	java/io/BufferedReader:close	()V
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
    Object localObject = ak.getContext();
    StringBuilder localStringBuilder = new StringBuilder(600);
    for (;;)
    {
      try
      {
        localStringBuilder.append(" \n");
        localStringBuilder.append("#client.version=").append(paramString2).append('\n');
        localStringBuilder.append("#client.verHistory=").append(cl.oI(4)).append('\n');
        localStringBuilder.append("#client.revision=").append(com.tencent.mm.sdk.platformtools.j.REV).append('\n');
        localStringBuilder.append("#client.uin=").append(bb.hIK.ay("last_login_uin", p.getString(q.aaH().hashCode()))).append('\n');
        localStringBuilder.append("#client.dev=").append(q.aaH()).append('\n');
        localStringBuilder.append("#client.build=").append(com.tencent.mm.sdk.platformtools.j.TIME).append(":").append(com.tencent.mm.sdk.platformtools.j.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.k.cSM).append('\n');
        localStringBuilder.append("#client.runtime=").append(bu.fpO() - cUY).append("(").append(bu.nullAsNil(cVj)).append(")\n");
        localStringBuilder.append("#client.IMEI=").append(q.cH(true)).append('\n');
        localStringBuilder.append("#client.abi=").append(Build.CPU_ABI).append('\n');
        localStringBuilder.append("#qbrwoser.coreVersion=").append(WebView.getInstalledTbsCoreVersion((Context)localObject)).append('\n');
        localStringBuilder.append("#qbrwoser.ver=").append(WebView.getTbsSDKVersion((Context)localObject)).append('\n');
        localObject = localStringBuilder.append("#status.dwx_bt=");
        if (!com.tencent.mm.sdk.a.b.dyd()) {
          break label1338;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.xh=");
        if (!com.tencent.mm.sdk.a.b.dyb()) {
          break label1345;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.x86_env=");
        if (!com.tencent.mm.sdk.a.b.dyc()) {
          break label1352;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localStringBuilder.append("#xsdkver=200901\n");
        localStringBuilder.append("#accinfo.foreground=").append(AppForegroundDelegate.cTA.cBB).append('\n');
        localStringBuilder.append("#accinfo.currentThread=").append(Thread.currentThread().getName()).append('\n');
        localStringBuilder.append("#accinfo.currentActivity=").append(AppForegroundDelegate.cTA.LO()).append('\n');
        paramString2 = new Date();
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilder.append("#accinfo.crashTime=").append(((SimpleDateFormat)localObject).format(paramString2)).append('\n');
        ae.i("MicroMsg.MMCrashReporter", "build header.");
        try
        {
          paramString2 = new StatFs(Environment.getDataDirectory().getPath());
          localObject = new StatFs(com.tencent.mm.loader.j.b.asd());
          CountDownLatch localCountDownLatch = new CountDownLatch(1);
          com.tencent.e.h.MqF.aO(new Runnable()
          {
            public final void run()
            {
              try
              {
                t.q(ak.getContext(), ak.getContext().getPackageName());
                this.cVt.countDown();
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.e("MicroMsg.MMCrashReporter", "getPkgSize failed :%s", new Object[] { localException.getMessage() });
                }
              }
            }
          });
          localCountDownLatch.await(2L, TimeUnit.SECONDS);
          paramString2 = String.format("%s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Long.valueOf(paramString2.getBlockSizeLong()), Long.valueOf(paramString2.getBlockCountLong()), Long.valueOf(paramString2.getAvailableBlocksLong()), Long.valueOf(cVm[0]), Long.valueOf(cVm[1]), Long.valueOf(cVm[2]), com.tencent.mm.loader.j.b.asd(), Long.valueOf(((StatFs)localObject).getBlockSizeLong()), Long.valueOf(((StatFs)localObject).getBlockCountLong()), Long.valueOf(((StatFs)localObject).getAvailableBlocksLong()) });
          localStringBuilder.append("#accinfo.data=").append(paramString2).append('\n');
        }
        catch (Exception paramString2)
        {
          try
          {
            localStringBuilder.append("#xwalk.coreVersion=").append(XWalkEnvironment.getInstalledNewstVersion(ak.getContext())).append('\n');
            if (XWalkEnvironment.getApplicationContext() != null) {
              localStringBuilder.append("#xwalk.sysWebCore=").append(XWalkEnvironment.safeGetChromiunVersion()).append('\n');
            }
            try
            {
              paramString2 = com.tencent.xweb.xwalk.a.g.ghO();
              if (paramString2.isEmpty()) {
                break label1241;
              }
              localStringBuilder.append("#xwalk.pluginInit=true\n");
              paramString2 = paramString2.iterator();
              if (paramString2.hasNext())
              {
                localObject = (f)paramString2.next();
                if (localObject == null) {
                  continue;
                }
                localStringBuilder.append("#xwalk.").append(((f)localObject).getPluginName()).append("=").append(((f)localObject).MUN).append('\n');
                continue;
              }
              paramString2 = ak.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            }
            catch (Exception paramString2)
            {
              ae.e("MicroMsg.MMCrashReporter", "get xwalk plugin info error ", new Object[] { paramString2 });
            }
            if (paramString2 != null)
            {
              localStringBuilder.append("#qbrowser.url=").append(paramString2).append('\n');
              paramString2 = ak.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
              paramString2.remove("url");
              paramString2.apply();
            }
            if (paramBoolean)
            {
              paramString2 = sCrashExtraMessageGetter.Mr();
              if (!bu.isNullOrNil(paramString2)) {
                localStringBuilder.append("#extraCrashMsg=").append(paramString2).append('\n');
              }
            }
            localStringBuilder.append("#runtime.memory=").append(com.tencent.mm.plugin.performance.c.c.dCq().P(true, 0));
            localObject = com.tencent.mm.ad.a.alg();
            paramString2 = (String)localObject;
            if (((String)localObject).length() > 1024) {
              paramString2 = ((String)localObject).substring(0, 1024);
            }
            localStringBuilder.append("#runtime.Activity dump [").append(paramString2).append("]\n\n");
            int i = com.tencent.mm.plugin.performance.c.e.Ja();
            localStringBuilder.append("#runtime.processThreadCount=").append(i).append('\n');
            if ((i >= 130) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
            {
              localStringBuilder.append("#runtime.threadInfo=");
              localStringBuilder.append(com.tencent.matrix.f.a.Jb()).append('\n');
            }
            if (!bu.isNullOrNil(paramString1)) {
              localStringBuilder.append("#subHeader=").append(paramString1).append('\n');
            }
            localStringBuilder.append("#crashContent=\n");
            return localStringBuilder;
            paramString2 = paramString2;
            ae.e("MicroMsg.MMCrashReporter", "check data size failed :%s", new Object[] { paramString2.getMessage() });
            paramString2 = "";
          }
          catch (Exception paramString2)
          {
            ae.printErrStackTrace("MicroMsg.MMCrashReporter", paramString2, "", new Object[0]);
            continue;
          }
        }
        localStringBuilder.append("#xwalk.pluginInit=false\n");
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "", new Object[0]);
        return localStringBuilder;
      }
      label1241:
      paramString2 = com.tencent.xweb.xwalk.a.g.lK(ak.getContext()).entrySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (Map.Entry)paramString2.next();
        if (localObject != null) {
          localStringBuilder.append("#xwalk.").append((String)((Map.Entry)localObject).getKey()).append("=").append(((Map.Entry)localObject).getValue()).append('\n');
        }
      }
      continue;
      label1338:
      paramString2 = "0";
      continue;
      label1345:
      paramString2 = "0";
      continue;
      label1352:
      paramString2 = "0";
    }
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramInt == 6) {}
    for (;;)
    {
      try
      {
        String str = Mm();
        localObject = localStringBuilder;
        if (str != null) {
          localObject = a(str, Process.myPid(), System.currentTimeMillis(), null);
        }
        localStringBuilder = new StringBuilder(1024);
        localStringBuilder.append("#[jin_crash]sig=").append(paramInt).append('\n');
        localStringBuilder.append("#crash.previous=").append(paramBoolean).append('\n');
        localStringBuilder.append("#crash.provider=").append(paramString2).append('\n');
        localStringBuilder.append(a("", false, paramString3));
        localStringBuilder.append(paramString1).append('\n');
        if (localObject != null)
        {
          localStringBuilder.append("******* ANR Trace *******\n");
          localStringBuilder.append((String)localObject);
        }
        paramString1 = localStringBuilder.toString();
        if ("NativeCrash".equals(paramString2))
        {
          paramInt = 32768;
          b(paramString1, paramInt, true);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        ae.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "Failed reporting JNI crash.", new Object[0]);
        if (!(paramString1 instanceof RuntimeException)) {
          continue;
        }
        throw ((RuntimeException)paramString1);
        if (!(paramString1 instanceof Error)) {
          continue;
        }
        throw ((Error)paramString1);
      }
      paramInt = 8192;
    }
  }
  
  public static void a(av.c paramc)
  {
    av.a(paramc);
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, String paramString3, int paramInt2)
  {
    String str2 = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L);
    String str3 = com.tencent.mm.sdk.platformtools.j.REV;
    String str1 = "";
    if (cVk != null) {
      str1 = cVk.toString();
    }
    ae.i("MicroMsg.MMCrashReporter", "reportSignalAnrReal");
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1356L, 61L, 1L, true);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.ywz;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.f(19664, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), paramString3, str2, str3, str1, Long.valueOf(cVl), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  private static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    fr(paramString);
    com.tencent.mm.plugin.report.service.g.yxI.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (ak.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (h.bn(ak.getContext()) == 1)
      {
        int i = h.bo(ak.getContext());
        ae.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[] { Integer.valueOf(i) });
        localObject = paramString;
        if (paramString.length() > i) {
          localObject = paramString.substring(0, i);
        }
      }
      localContext = ak.getContext();
      str = ak.getProcessName();
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
      if (com.tencent.mm.plugin.q.d.drw() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", Mk());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.q.d.drw().Y(ak.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.g.yxI;
      com.tencent.mm.plugin.report.service.g.dNI();
      return;
      if ((ak.foC()) || (ak.foD()))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (ak.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!ak.cpe()) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  private static void bs(Context paramContext)
  {
    int i = 0;
    String str = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("login_user_name", "never_login_crash");
    Object localObject = paramContext.getSharedPreferences("system_config_prefs", 0);
    localObject = "http://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
    paramContext = new com.tencent.mm.vfs.k(paramContext.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramContext = paramContext.fTj();
      int j = paramContext.length;
      while (i < j)
      {
        com.tencent.mm.vfs.k localk = paramContext[i];
        if ((localk.isDirectory()) && (localk.getName().endsWith("_nf"))) {
          CrashUploaderService.a(localk, str, com.tencent.mm.loader.j.a.hjv, (String)localObject, "exception");
        }
        i += 1;
      }
    }
  }
  
  private boolean ce(boolean paramBoolean)
  {
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      cVk = (Message)localObject;
      if (localObject != null)
      {
        long l1 = ((Message)localObject).getWhen();
        if (l1 == 0L) {
          return false;
        }
        long l2 = l1 - SystemClock.uptimeMillis();
        cVl = l2;
        l1 = -10000L;
        if (paramBoolean) {
          l1 = -2000L;
        }
        if (l2 < l1)
        {
          if (((Message)localObject).getTarget() == null) {
            com.tencent.e.h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                t.a(t.this);
              }
            });
          }
          return true;
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMCrashReporter", "firstCheckMessage errror, msessage : " + localException.getMessage());
      return false;
    }
    return false;
  }
  
  public static boolean fq(String paramString)
  {
    Object localObject4 = null;
    cVj = paramString;
    if (com.tencent.mm.plugin.q.d.drw() == null) {}
    try
    {
      localObject1 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException4)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ak.getContext().getClassLoader());
        localObject4 = localClass;
        ae.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + cVj);
        ae.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + cVj);
        localObject1 = com.tencent.mm.br.d.lK("sandbox", ".SubCoreSandBox");
        ae.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + cVj);
        if (localObject1 == null) {}
      }
      catch (Exception localException4)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = (com.tencent.mm.plugin.q.c)((Class)localObject1).newInstance();
            com.tencent.mm.plugin.q.d.a((com.tencent.mm.plugin.q.c)localObject1);
            ae.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + cVj);
            try
            {
              localObject1 = (com.tencent.mm.sdk.a.c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((com.tencent.mm.sdk.a.c)localObject1).bt(ak.getContext());
              bb.hIK.ay("last_login_uin", p.getString(q.aaH().hashCode()));
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject1);
              new Object() {};
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              ae.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              localObject3 = new t();
              ((t)localObject3).bt(ak.getContext());
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject3);
              if (paramString.contains(":tools")) {
                break;
              }
            }
            localException1 = localException1;
            ae.printErrStackTrace("MicroMsg.MMCrashReporter", localException1, "setup sanbox Failed printing stack trace1.", new Object[0]);
            localObject2 = null;
          }
          localException4 = localException4;
          ae.printErrStackTrace("MicroMsg.MMCrashReporter", localException4, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MMCrashReporter", localException2, "", new Object[0]);
            ae.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
          }
        }
      }
    }
    Object localObject3;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support"))) {}
    for (int i = 1;; i = 0)
    {
      NativeCrash.class.getClassLoader();
      com.tencent.mm.compatible.util.j.vN("wechatcrash");
      paramString = com.tencent.mm.crash.a.adL();
      if (i != 0)
      {
        localObject3 = WebView.getCrashExtraMessage(ak.getContext());
        com.tencent.mm.crash.a.wu((String)localObject3);
        ae.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
      }
      paramString.ghF = sCrashExtraMessageGetter;
      cl.Cf(com.tencent.mm.loader.j.b.asb());
      return false;
    }
  }
  
  private static void fr(String paramString)
  {
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i)
        {
          ae.e("MicroMsg.MMCrashReporter", paramString.substring(0, 896));
          paramString = paramString.substring(897);
        }
        else
        {
          ae.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
          paramString = paramString.substring(i + 1);
        }
      }
      ae.e("MicroMsg.MMCrashReporter", paramString);
      ae.foo();
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  public static void q(Context arg0, String paramString)
  {
    cVm[0] = 0L;
    cVm[1] = 0L;
    cVm[2] = 0L;
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (cVm)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new t.8() });
          cVm.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            cVm[0] = -1L;
            cVm[1] = -1L;
            cVm[2] = -1L;
            ae.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (cVm)
            {
              cVm.notify();
            }
          }
        }
      }
    }
    ae.i("MicroMsg.MMCrashReporter", "getStats, %s", new Object[] { paramString });
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
          cVm[0] = ???.getCacheBytes();
          cVm[1] = ???.getDataBytes();
          cVm[2] = ???.getAppBytes();
          ae.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool), Long.valueOf(cVm[0]), Long.valueOf(cVm[1]), Long.valueOf(cVm[2]), bu.fpN() });
          return;
          bool = false;
          continue;
          if (k == 0) {}
          for (bool = true;; bool = false) {
            break;
          }
          paramString = paramString;
          ae.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "summer getStats crash1 e:", new Object[0]);
        }
        catch (Exception ???)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "summer getStats crash2 e:", new Object[0]);
            ??? = null;
          }
        }
      }
    }
  }
  
  public final void O(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.q.d.drw() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", Mk());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.q.d.drw().Y(ak.getContext(), localIntent);
    }
  }
  
  public final void P(String paramString1, String paramString2)
  {
    b(a(paramString1, true, com.tencent.mm.sdk.platformtools.j.hju) + paramString2, 0, false);
  }
  
  public final void a(com.tencent.mm.sdk.a.a parama)
  {
    av.a(parama);
  }
  
  public final void a(c.a parama)
  {
    if (parama == null) {
      return;
    }
    cVc.add(parama);
  }
  
  public final void b(av paramav, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str = paramThrowable.getMessage();
      if (!bu.isNullOrNil(str))
      {
        paramav = paramav.aRU(str);
        if (bu.isNullOrNil(paramav)) {}
      }
    }
    for (;;)
    {
      af.e(paramThrowable);
      b(paramString, 0, false);
      return;
      paramav = "";
    }
  }
  
  /* Error */
  public final void br(Context paramContext)
  {
    // Byte code:
    //   0: ldc 184
    //   2: ldc_w 1314
    //   5: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 1009	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 292	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 1022	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1316
    //   25: invokespecial 1319	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 16	com/tencent/mm/app/t$3
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1322	com/tencent/mm/app/t$3:<init>	(Lcom/tencent/mm/app/t;Ljava/lang/String;)V
    //   38: invokevirtual 1326	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 11
    //   43: aload 11
    //   45: ifnull +608 -> 653
    //   48: invokestatic 817	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 273	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 395	java/lang/StringBuilder:<init>	(I)V
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
    //   93: invokevirtual 1327	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1329
    //   99: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +179 -> 281
    //   105: aload 14
    //   107: invokevirtual 1327	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1331
    //   113: invokevirtual 914	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +134 -> 250
    //   119: ldc 184
    //   121: ldc_w 1333
    //   124: aload 14
    //   126: invokestatic 1336	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 1339	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 14
    //   137: invokevirtual 609	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 1341
    //   147: ldc_w 1331
    //   150: invokevirtual 1345	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore 7
    //   155: aload 7
    //   157: aload 8
    //   159: invokevirtual 838	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +499 -> 661
    //   165: aconst_null
    //   166: astore 7
    //   168: iconst_0
    //   169: aload 8
    //   171: aload 7
    //   173: invokestatic 1349	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   176: astore 8
    //   178: ldc 184
    //   180: new 273	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1351
    //   187: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 8
    //   192: getfield 1356	com/tencent/mm/crash/a$a:ghG	I
    //   195: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 8
    //   206: getfield 1356	com/tencent/mm/crash/a$a:ghG	I
    //   209: aload 8
    //   211: getfield 1359	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   214: ldc_w 834
    //   217: iconst_1
    //   218: aload 8
    //   220: getfield 1362	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   223: invokestatic 1364	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   226: aload 14
    //   228: invokevirtual 1367	java/io/File:delete	()Z
    //   231: pop
    //   232: aload 7
    //   234: ifnull +16 -> 250
    //   237: new 292	java/io/File
    //   240: dup
    //   241: aload 7
    //   243: invokespecial 295	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 1367	java/io/File:delete	()Z
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -175 -> 79
    //   257: astore 8
    //   259: ldc 184
    //   261: aload 8
    //   263: ldc_w 1369
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 14
    //   274: aastore
    //   275: invokestatic 304	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -52 -> 226
    //   281: ldc 184
    //   283: ldc_w 1333
    //   286: aload 14
    //   288: invokestatic 1336	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 1339	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   294: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: new 414	java/io/FileReader
    //   300: dup
    //   301: aload 14
    //   303: invokespecial 1372	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   306: astore 15
    //   308: aconst_null
    //   309: astore 9
    //   311: aload 12
    //   313: iconst_0
    //   314: invokevirtual 1375	java/lang/StringBuilder:setLength	(I)V
    //   317: aload 15
    //   319: aload 13
    //   321: invokevirtual 1379	java/io/FileReader:read	([C)I
    //   324: istore_3
    //   325: iload_3
    //   326: iconst_m1
    //   327: if_icmpeq +60 -> 387
    //   330: aload 12
    //   332: aload 13
    //   334: iconst_0
    //   335: iload_3
    //   336: invokevirtual 1382	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: goto -23 -> 317
    //   343: astore 8
    //   345: aload 8
    //   347: athrow
    //   348: astore 7
    //   350: aload 8
    //   352: ifnull +261 -> 613
    //   355: aload 15
    //   357: invokevirtual 1383	java/io/FileReader:close	()V
    //   360: aload 7
    //   362: athrow
    //   363: astore 7
    //   365: ldc 184
    //   367: aload 7
    //   369: ldc_w 1369
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: aload 14
    //   380: aastore
    //   381: invokestatic 304	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: goto -134 -> 250
    //   387: aload 12
    //   389: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore 8
    //   394: aload 14
    //   396: invokevirtual 1327	java/io/File:getName	()Ljava/lang/String;
    //   399: ldc_w 1385
    //   402: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   405: ifeq +24 -> 429
    //   408: aload 8
    //   410: iconst_0
    //   411: iconst_0
    //   412: invokestatic 842	com/tencent/mm/app/t:b	(Ljava/lang/String;IZ)V
    //   415: aload 14
    //   417: invokevirtual 1367	java/io/File:delete	()Z
    //   420: pop
    //   421: aload 15
    //   423: invokevirtual 1383	java/io/FileReader:close	()V
    //   426: goto -176 -> 250
    //   429: getstatic 1293	com/tencent/mm/sdk/platformtools/j:hju	Ljava/lang/String;
    //   432: astore 7
    //   434: ldc_w 1387
    //   437: invokestatic 1393	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   440: aload 8
    //   442: invokevirtual 1397	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   445: astore 16
    //   447: aload 16
    //   449: invokevirtual 1402	java/util/regex/Matcher:find	()Z
    //   452: ifeq +206 -> 658
    //   455: aload 16
    //   457: iconst_1
    //   458: invokevirtual 1405	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   461: astore 10
    //   463: aload 10
    //   465: astore 7
    //   467: aload 10
    //   469: ldc_w 1407
    //   472: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifne +42 -> 517
    //   478: aload 10
    //   480: invokestatic 1410	com/tencent/mm/sdk/platformtools/bu:aSB	(Ljava/lang/String;)I
    //   483: istore_3
    //   484: aload 10
    //   486: astore 7
    //   488: iload_3
    //   489: ifeq +28 -> 517
    //   492: new 273	java/lang/StringBuilder
    //   495: dup
    //   496: ldc_w 1407
    //   499: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   502: iload_3
    //   503: invokestatic 1413	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   506: invokevirtual 1416	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   509: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore 7
    //   517: aload 8
    //   519: aload 16
    //   521: invokevirtual 1419	java/util/regex/Matcher:end	()I
    //   524: invokevirtual 287	java/lang/String:substring	(I)Ljava/lang/String;
    //   527: astore 8
    //   529: aload 8
    //   531: invokevirtual 1420	java/lang/String:isEmpty	()Z
    //   534: ifne +49 -> 583
    //   537: iconst_0
    //   538: istore_3
    //   539: ldc_w 1422
    //   542: invokestatic 1393	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   545: aload 8
    //   547: invokevirtual 1397	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   550: astore 10
    //   552: aload 10
    //   554: invokevirtual 1402	java/util/regex/Matcher:find	()Z
    //   557: ifeq +14 -> 571
    //   560: aload 10
    //   562: iconst_1
    //   563: invokevirtual 1405	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   566: iconst_0
    //   567: invokestatic 1425	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   570: istore_3
    //   571: iload_3
    //   572: aload 8
    //   574: ldc_w 1427
    //   577: iconst_1
    //   578: aload 7
    //   580: invokestatic 1364	com/tencent/mm/app/t:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   583: aload 14
    //   585: invokevirtual 1367	java/io/File:delete	()Z
    //   588: pop
    //   589: goto -168 -> 421
    //   592: astore 7
    //   594: aload 9
    //   596: astore 8
    //   598: goto -248 -> 350
    //   601: astore 9
    //   603: aload 8
    //   605: aload 9
    //   607: invokevirtual 1430	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   610: goto -250 -> 360
    //   613: aload 15
    //   615: invokevirtual 1383	java/io/FileReader:close	()V
    //   618: goto -258 -> 360
    //   621: ldc 184
    //   623: ldc_w 1432
    //   626: iconst_2
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: lload 5
    //   634: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: invokestatic 817	java/lang/System:currentTimeMillis	()J
    //   643: lload 5
    //   645: lsub
    //   646: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: aastore
    //   650: invokestatic 205	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: aload_1
    //   654: invokestatic 1434	com/tencent/mm/app/t:bs	(Landroid/content/Context;)V
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
  
  public final void bt(Context paramContext)
  {
    av.a(this);
    if (cVj.endsWith(":push")) {}
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
        ae.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
        String str = "/data/anr/traces.txt";
      }
    }
    localObject2 = new File((String)localObject1);
    this.cVe = ((File)localObject2).getParent();
    if ((this.cVe == null) || (this.cVe.length() == 0)) {
      this.cVe = "/";
    }
    this.cVf = ((File)localObject2).getName();
    this.cVg = new ConditionVariable();
    ae.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.cVd = new HashSet();
    this.cVa = new a(this.cVe);
    this.cVa.startWatching();
    CoreService.a(this);
    if (ak.coh()) {
      paramContext.sendBroadcast(new Intent(paramContext, CrashUploadAlarmReceiver.class));
    }
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, com.tencent.mm.sdk.platformtools.j.hju);
  }
  
  public final void fs(final String paramString)
  {
    ae.i("MicroMsg.MMCrashReporter", "start to reportSignalAnr");
    if ((com.tencent.matrix.a.cBz.cBB) || (AppForegroundDelegate.cTA.cBB)) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      bool2 = ce(bool1);
      Object localObject1 = AppForegroundDelegate.cTA.LO();
      i = 10;
      try
      {
        str = com.tencent.matrix.a.cBz.cBC;
        localObject1 = str;
        if (com.tencent.matrix.d.cBK.cBL == null) {
          break label368;
        }
        localObject1 = str;
        Object localObject2 = (h.d)com.tencent.matrix.d.cBK.cBL.cFY.getFirst();
        if (localObject2 == null) {
          break label368;
        }
        localObject1 = str;
        long l = ((com.tencent.matrix.report.c)localObject2).cFG.getLong("time");
        localObject1 = str;
        localObject2 = ((com.tencent.matrix.report.c)localObject2).cFG.getString("detail");
        localObject1 = str;
        ae.i("MicroMsg.MMCrashReporter", "latest Matrix ANR issueTime = %d", new Object[] { Long.valueOf(l) });
        localObject1 = str;
        if (!((String)localObject2).equalsIgnoreCase(a.a.cKw.toString())) {
          break label368;
        }
        localObject1 = str;
        if (System.currentTimeMillis() - l >= 5000L) {
          break label368;
        }
        localObject1 = str;
        ae.i("MicroMsg.MMCrashReporter", "Matrix ANR happens recently");
        i = 11;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          final String str;
          ae.e("MicroMsg.MMCrashReporter", "get scene from Matrix failed , e : " + localException.getMessage());
          continue;
          bool2 = false;
          continue;
          i = 10;
        }
      }
      localObject1 = str;
      str = ak.getProcessName();
      if (!bool2) {
        break;
      }
      a(paramString, (String)localObject1, i, bool1, str, 0);
      bool2 = true;
      ae.i("MicroMsg.MMCrashReporter", "happens ANR stacktrace : %s, processName :%s , scene : %s, isForeground : %b, type : %d, status: %s", new Object[] { paramString, str, localObject1, Boolean.valueOf(bool1), Integer.valueOf(i), Looper.getMainLooper().getThread().getState() });
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          int i = 0;
          while (i < 5)
          {
            t.Mp();
            i += 1;
            try
            {
              Thread.sleep(1000L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      });
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          int i = 0;
          for (;;)
          {
            boolean bool;
            if (i < 40)
            {
              bool = t.Mo();
              ae.i("MicroMsg.MMCrashReporter", "[checkErrorStateCycle] my anr = ".concat(String.valueOf(bool)));
              if ((bool) && (!bool2))
              {
                ae.i("MicroMsg.MMCrashReporter", "[checkErrorStateCycle] has detected anr state, report ");
                t.a(paramString, this.cBW, i, bool1, str);
              }
            }
            else
            {
              return;
            }
            if (bool)
            {
              ae.i("MicroMsg.MMCrashReporter", "[checkErrorStateCycle] has detected anr state but has reported before");
              return;
            }
            i += 1;
            try
            {
              Thread.sleep(500L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      });
      return;
    }
  }
  
  final void u(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.g.yxI.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(26L, 0L, 1L, true);
    fr(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
    com.tencent.mm.plugin.report.service.g.dNI();
    long l = System.currentTimeMillis();
    if (l - this.cVb < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.cVb = l;
      h.d(ak.getContext(), ak.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(a("", true, com.tencent.mm.sdk.platformtools.j.hju));
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
    } while (com.tencent.mm.plugin.q.d.drw() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", bb.hIK.ay("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.q.d.drw().Y(ak.getContext(), paramString);
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
      //   6: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   9: invokestatic 29	com/tencent/mm/app/t:b	(Lcom/tencent/mm/app/t;)J
      //   12: lsub
      //   13: ldc2_w 30
      //   16: lcmp
      //   17: ifge +5 -> 22
      //   20: iconst_1
      //   21: istore_3
      //   22: iload_3
      //   23: ifeq +4 -> 27
      //   26: return
      //   27: aload_0
      //   28: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   31: getfield 35	com/tencent/mm/app/t:cVd	Ljava/util/HashSet;
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
      //   94: ldc 37
      //   96: ldc 39
      //   98: aload_2
      //   99: invokestatic 45	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   102: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   105: invokestatic 55	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   108: aload_0
      //   109: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   112: getfield 59	com/tencent/mm/app/t:cVg	Landroid/os/ConditionVariable;
      //   115: invokevirtual 65	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   122: getfield 69	com/tencent/mm/app/t:cVn	Lcom/tencent/mm/app/t$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   132: new 71	com/tencent/mm/app/t$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   140: iconst_0
      //   141: invokespecial 74	com/tencent/mm/app/t$b:<init>	(Lcom/tencent/mm/app/t;B)V
      //   144: putfield 69	com/tencent/mm/app/t:cVn	Lcom/tencent/mm/app/t$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   151: getfield 69	com/tencent/mm/app/t:cVn	Lcom/tencent/mm/app/t$b;
      //   154: ldc 76
      //   156: invokestatic 82	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   163: getfield 35	com/tencent/mm/app/t:cVd	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 88	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/t$a:cVp	Lcom/tencent/mm/app/t;
      //   178: getfield 35	com/tencent/mm/app/t:cVd	Ljava/util/HashSet;
      //   181: aload_2
      //   182: invokevirtual 91	java/util/HashSet:remove	(Ljava/lang/Object;)Z
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
    
    private static ActivityManager.ProcessErrorStateInfo Ms()
    {
      Object localObject = ((ActivityManager)ak.getContext().getSystemService("activity")).getProcessesInErrorState();
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
      ae.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
      ??? = null;
      for (;;)
      {
        if (t.this.cVg.block(10000L)) {
          t.this.cVg.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = Ms();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = Ms();
            localObject2 = ???;
            if (??? == null)
            {
              ae.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              t.this.cVn = null;
              return;
            }
          }
          ae.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (t.this.cVd)
            {
              localObject4 = new ArrayList(t.this.cVd.size());
              int i = t.this.cVf.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = t.this.cVf.substring(0, i) + '_' + str + t.this.cVf.substring(i);
                if (t.this.cVd.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (t.this.cVd.remove(t.this.cVf)) {
                ((ArrayList)localObject4).add(t.this.cVf);
              }
              ((ArrayList)localObject4).addAll(t.this.cVd);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = t.this.cVe + '/' + (String)localObject4;
                str = t.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  ae.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  t.this.u(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                ae.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                t.this.cVn = null;
                return;
              }
            }
            ae.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
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