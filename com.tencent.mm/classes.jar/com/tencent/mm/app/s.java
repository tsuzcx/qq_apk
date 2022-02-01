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
import com.tencent.mm.model.az;
import com.tencent.mm.model.cj;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.au.d;
import com.tencent.mm.sdk.platformtools.bt;
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
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import junit.framework.AssertionFailedError;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class s
  implements CoreService.b, com.tencent.mm.sdk.a.c, au.d
{
  public static final long cTZ = ;
  private static final Set<c.a> cUd = new HashSet();
  private static final String cUi;
  private static final String cUj;
  private static String cUk;
  private static long[] cUn = { 0L, 0L, 0L };
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  private au cUa = null;
  private a cUb;
  private volatile long cUc = 0L;
  HashSet<String> cUe;
  String cUf;
  String cUg;
  ConditionVariable cUh;
  private Message cUl = null;
  private long cUm = 0L;
  volatile b cUo;
  
  static
  {
    String str = q.aay();
    cUi = str;
    cUj = p.getString(str.hashCode());
    cUk = "";
    sCrashExtraMessageGetter = new s.1();
  }
  
  private static String Mc()
  {
    String str2 = az.hFS.ax("login_weixin_username", "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = az.hFS.ax("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private boolean Md()
  {
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      if (localObject != null)
      {
        long l = ((Message)localObject).getWhen();
        if (l == 0L) {
          return false;
        }
        if (l - SystemClock.uptimeMillis() < -1000L)
        {
          if (((Message)localObject).getTarget() == null) {
            com.tencent.e.h.LTJ.aR(new Runnable()
            {
              public final void run()
              {
                s.a(s.this);
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
      ad.e("MicroMsg.MMCrashReporter", "firstCheckMessage errror, msessage : " + localException.getMessage());
      return false;
    }
    return false;
  }
  
  private static boolean Me()
  {
    try
    {
      Object localObject = ((ActivityManager)aj.getContext().getSystemService("activity")).getProcessesInErrorState();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
        ad.i("MicroMsg.MMCrashReporter", "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", new Object[] { localProcessErrorStateInfo.processName, Integer.valueOf(localProcessErrorStateInfo.condition) });
        if ((localProcessErrorStateInfo.uid != Process.myUid()) && (localProcessErrorStateInfo.condition == 2)) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1356L, 71L, 1L, true);
        }
        if (localProcessErrorStateInfo.uid == Process.myUid())
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
      ad.e("MicroMsg.MMCrashReporter", "[checkErrorState] error : %s", new Object[] { localThrowable.getMessage() });
    }
    return false;
  }
  
  private static String Mf()
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
          ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
          str1 = "/data/anr/traces.txt";
        }
        Object localObject2 = str1;
      } while (new File(str1).isFile());
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = aj.getProcessName();
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
    //   3: new 210	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 379	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 381	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc_w 383
    //   22: invokespecial 384	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   25: astore 10
    //   27: new 210	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 386
    //   34: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_1
    //   38: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 391
    //   44: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 11
    //   52: aload 4
    //   54: ifnull +19 -> 73
    //   57: aload 9
    //   59: aload 4
    //   61: getfield 394	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   64: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: bipush 10
    //   69: invokevirtual 347	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: new 396	java/io/BufferedReader
    //   76: dup
    //   77: new 398	java/io/FileReader
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 399	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   85: invokespecial 402	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 4
    //   90: iload 5
    //   92: istore_1
    //   93: aload 4
    //   95: astore_0
    //   96: aload 4
    //   98: invokevirtual 405	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 12
    //   103: aload 12
    //   105: ifnull +250 -> 355
    //   108: iload_1
    //   109: tableswitch	default:+298 -> 407, 0:+27->136, 1:+100->209, 2:+160->269
    //   137: iconst_1
    //   138: astore_0
    //   139: aload 12
    //   141: aload 11
    //   143: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifeq -53 -> 93
    //   149: aload 4
    //   151: astore_0
    //   152: aload 11
    //   154: invokevirtual 328	java/lang/String:length	()I
    //   157: istore 5
    //   159: aload 4
    //   161: astore_0
    //   162: aload 10
    //   164: aload 12
    //   166: iload 5
    //   168: iload 5
    //   170: bipush 19
    //   172: iadd
    //   173: invokevirtual 344	java/lang/String:substring	(II)Ljava/lang/String;
    //   176: invokevirtual 412	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   179: invokevirtual 417	java/util/Date:getTime	()J
    //   182: lload_2
    //   183: lsub
    //   184: lstore 6
    //   186: lload 6
    //   188: ldc2_w 418
    //   191: lcmp
    //   192: iflt -99 -> 93
    //   195: lload 6
    //   197: ldc2_w 420
    //   200: lcmp
    //   201: ifgt -108 -> 93
    //   204: iconst_1
    //   205: istore_1
    //   206: goto -113 -> 93
    //   209: aload 4
    //   211: astore_0
    //   212: aload 9
    //   214: aload 12
    //   216: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: bipush 10
    //   221: invokevirtual 347	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: astore_0
    //   228: aload 12
    //   230: ldc_w 423
    //   233: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   236: ifeq +8 -> 244
    //   239: iconst_2
    //   240: istore_1
    //   241: goto -148 -> 93
    //   244: aload 4
    //   246: astore_0
    //   247: aload 12
    //   249: ldc_w 425
    //   252: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: istore 8
    //   257: iload 8
    //   259: ifeq -166 -> 93
    //   262: aload 4
    //   264: invokevirtual 428	java/io/BufferedReader:close	()V
    //   267: aconst_null
    //   268: areturn
    //   269: aload 4
    //   271: astore_0
    //   272: aload 12
    //   274: ldc_w 430
    //   277: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   280: ifeq +25 -> 305
    //   283: aload 4
    //   285: astore_0
    //   286: aload 9
    //   288: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload 4
    //   295: invokevirtual 428	java/io/BufferedReader:close	()V
    //   298: aload 9
    //   300: areturn
    //   301: astore_0
    //   302: aload 9
    //   304: areturn
    //   305: aload 4
    //   307: astore_0
    //   308: aload 9
    //   310: aload 12
    //   312: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: bipush 10
    //   317: invokevirtual 347	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: goto -228 -> 93
    //   324: astore 9
    //   326: aload 4
    //   328: astore_0
    //   329: ldc 208
    //   331: aload 9
    //   333: ldc_w 432
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 428	java/io/BufferedReader:close	()V
    //   353: aconst_null
    //   354: areturn
    //   355: aload 4
    //   357: invokevirtual 428	java/io/BufferedReader:close	()V
    //   360: goto -7 -> 353
    //   363: astore_0
    //   364: goto -11 -> 353
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_0
    //   371: aload_0
    //   372: ifnull +7 -> 379
    //   375: aload_0
    //   376: invokevirtual 428	java/io/BufferedReader:close	()V
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
    Object localObject = aj.getContext();
    StringBuilder localStringBuilder = new StringBuilder(600);
    for (;;)
    {
      try
      {
        localStringBuilder.append(" \n");
        localStringBuilder.append("#client.version=").append(paramString2).append('\n');
        localStringBuilder.append("#client.verHistory=").append(cj.oF(4)).append('\n');
        localStringBuilder.append("#client.revision=").append(com.tencent.mm.sdk.platformtools.i.REV).append('\n');
        localStringBuilder.append("#client.uin=").append(az.hFS.ax("last_login_uin", p.getString(q.aay().hashCode()))).append('\n');
        localStringBuilder.append("#client.dev=").append(q.aay()).append('\n');
        localStringBuilder.append("#client.build=").append(com.tencent.mm.sdk.platformtools.i.TIME).append(":").append(com.tencent.mm.sdk.platformtools.i.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.j.cSc).append('\n');
        localStringBuilder.append("#client.runtime=").append(bt.flT() - cTZ).append("(").append(bt.nullAsNil(cUk)).append(")\n");
        localStringBuilder.append("#client.IMEI=").append(q.cH(true)).append('\n');
        localStringBuilder.append("#client.abi=").append(Build.CPU_ABI).append('\n');
        localStringBuilder.append("#qbrwoser.coreVersion=").append(WebView.getInstalledTbsCoreVersion((Context)localObject)).append('\n');
        localStringBuilder.append("#qbrwoser.ver=").append(WebView.getTbsSDKVersion((Context)localObject)).append('\n');
        localObject = localStringBuilder.append("#status.dwx_bt=");
        if (!com.tencent.mm.sdk.a.b.duN()) {
          break label1310;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.xh=");
        if (!com.tencent.mm.sdk.a.b.duL()) {
          break label1317;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.x86_env=");
        if (!com.tencent.mm.sdk.a.b.duM()) {
          break label1324;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localStringBuilder.append("#xsdkver=200801\n");
        localStringBuilder.append("#accinfo.foreground=").append(AppForegroundDelegate.cSQ.cAU).append('\n');
        localStringBuilder.append("#accinfo.currentThread=").append(Thread.currentThread().getName()).append('\n');
        localStringBuilder.append("#accinfo.currentActivity=").append(AppForegroundDelegate.cSQ.LG()).append('\n');
        paramString2 = new Date();
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilder.append("#accinfo.crashTime=").append(((SimpleDateFormat)localObject).format(paramString2)).append('\n');
        ad.i("MicroMsg.MMCrashReporter", "build header.");
        try
        {
          paramString2 = new StatFs(Environment.getDataDirectory().getPath());
          localObject = new StatFs(com.tencent.mm.loader.j.b.arO());
          p(aj.getContext(), aj.getContext().getPackageName());
          paramString2 = String.format("%s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Long.valueOf(paramString2.getBlockSizeLong()), Long.valueOf(paramString2.getBlockCountLong()), Long.valueOf(paramString2.getAvailableBlocksLong()), Long.valueOf(cUn[0]), Long.valueOf(cUn[1]), Long.valueOf(cUn[2]), com.tencent.mm.loader.j.b.arO(), Long.valueOf(((StatFs)localObject).getBlockSizeLong()), Long.valueOf(((StatFs)localObject).getBlockCountLong()), Long.valueOf(((StatFs)localObject).getAvailableBlocksLong()) });
          localStringBuilder.append("#accinfo.data=").append(paramString2).append('\n');
        }
        catch (Exception paramString2)
        {
          try
          {
            localStringBuilder.append("#xwalk.coreVersion=").append(XWalkEnvironment.getInstalledNewstVersion(aj.getContext())).append('\n');
            if (XWalkEnvironment.getApplicationContext() != null) {
              localStringBuilder.append("#xwalk.sysWebCore=").append(XWalkEnvironment.safeGetChromiunVersion()).append('\n');
            }
            try
            {
              paramString2 = com.tencent.xweb.xwalk.a.g.gdm();
              if (paramString2.isEmpty()) {
                break label1213;
              }
              localStringBuilder.append("#xwalk.pluginInit=true\n");
              paramString2 = paramString2.iterator();
              if (paramString2.hasNext())
              {
                localObject = (f)paramString2.next();
                if (localObject == null) {
                  continue;
                }
                localStringBuilder.append("#xwalk.").append(((f)localObject).getPluginName()).append("=").append(((f)localObject).MxJ).append('\n');
                continue;
              }
              paramString2 = aj.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            }
            catch (Exception paramString2)
            {
              ad.e("MicroMsg.MMCrashReporter", "get xwalk plugin info error ", new Object[] { paramString2 });
            }
            if (paramString2 != null)
            {
              localStringBuilder.append("#qbrowser.url=").append(paramString2).append('\n');
              paramString2 = aj.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
              paramString2.remove("url");
              paramString2.apply();
            }
            if (paramBoolean)
            {
              paramString2 = sCrashExtraMessageGetter.Mj();
              if (!bt.isNullOrNil(paramString2)) {
                localStringBuilder.append("#extraCrashMsg=").append(paramString2).append('\n');
              }
            }
            localStringBuilder.append("#runtime.memory=").append(com.tencent.mm.plugin.performance.c.c.dyZ().M(true, 0));
            localObject = com.tencent.mm.ae.a.akR();
            paramString2 = (String)localObject;
            if (((String)localObject).length() > 1024) {
              paramString2 = ((String)localObject).substring(0, 1024);
            }
            localStringBuilder.append("#runtime.Activity dump [").append(paramString2).append("]\n\n");
            int i = com.tencent.mm.plugin.performance.c.e.IS();
            localStringBuilder.append("#runtime.processThreadCount=").append(i).append('\n');
            if ((i >= 130) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
            {
              localStringBuilder.append("#runtime.threadInfo=");
              localStringBuilder.append(com.tencent.matrix.f.a.IT()).append('\n');
            }
            if (!bt.isNullOrNil(paramString1)) {
              localStringBuilder.append("#subHeader=").append(paramString1).append('\n');
            }
            localStringBuilder.append("#crashContent=\n");
            return localStringBuilder;
            paramString2 = paramString2;
            ad.e("MicroMsg.MMCrashReporter", "check data size failed :%s", new Object[] { paramString2.getMessage() });
            paramString2 = "";
          }
          catch (Exception paramString2)
          {
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString2, "", new Object[0]);
            continue;
          }
        }
        localStringBuilder.append("#xwalk.pluginInit=false\n");
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "", new Object[0]);
        return localStringBuilder;
      }
      label1213:
      paramString2 = com.tencent.xweb.xwalk.a.g.lE(aj.getContext()).entrySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (Map.Entry)paramString2.next();
        if (localObject != null) {
          localStringBuilder.append("#xwalk.").append((String)((Map.Entry)localObject).getKey()).append("=").append(((Map.Entry)localObject).getValue()).append('\n');
        }
      }
      continue;
      label1310:
      paramString2 = "0";
      continue;
      label1317:
      paramString2 = "0";
      continue;
      label1324:
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
        String str = Mf();
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
        ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString1, "Failed reporting JNI crash.", new Object[0]);
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
  
  public static void a(au.c paramc)
  {
    au.a(paramc);
  }
  
  private static void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    int i = 1;
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1356L, 61L, 1L, true);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.ygI;
    if (paramBoolean) {}
    for (;;)
    {
      locale.f(19664, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString3 });
      return;
      i = 0;
    }
  }
  
  private static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    fl(paramString);
    com.tencent.mm.plugin.report.service.g.yhR.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (aj.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (h.bm(aj.getContext()) == 1)
      {
        int i = h.bn(aj.getContext());
        ad.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[] { Integer.valueOf(i) });
        localObject = paramString;
        if (paramString.length() > i) {
          localObject = paramString.substring(0, i);
        }
      }
      localContext = aj.getContext();
      str = aj.getProcessName();
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
      if (com.tencent.mm.plugin.q.d.doy() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", Mc());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.q.d.doy().Y(aj.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.g.yhR;
      com.tencent.mm.plugin.report.service.g.dKq();
      return;
      if ((aj.fkJ()) || (aj.fkJ()))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (aj.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!aj.cnC()) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean fk(String paramString)
  {
    Object localObject4 = null;
    cUk = paramString;
    if (com.tencent.mm.plugin.q.d.doy() == null) {}
    try
    {
      localObject1 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException4)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, aj.getContext().getClassLoader());
        localObject4 = localClass;
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + cUk);
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + cUk);
        localObject1 = com.tencent.mm.bs.d.lD("sandbox", ".SubCoreSandBox");
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + cUk);
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
            ad.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + cUk);
            try
            {
              localObject1 = (com.tencent.mm.sdk.a.c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((com.tencent.mm.sdk.a.c)localObject1).bp(aj.getContext());
              az.hFS.ax("last_login_uin", p.getString(q.aay().hashCode()));
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject1);
              new Object() {};
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              ad.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              localObject3 = new s();
              ((s)localObject3).bp(aj.getContext());
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject3);
              if (paramString.contains(":tools")) {
                break;
              }
            }
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException1, "setup sanbox Failed printing stack trace1.", new Object[0]);
            localObject2 = null;
          }
          localException4 = localException4;
          ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException4, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException2, "", new Object[0]);
            ad.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
          }
        }
      }
    }
    Object localObject3;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support"))) {}
    for (int i = 1;; i = 0)
    {
      NativeCrash.class.getClassLoader();
      com.tencent.mm.compatible.util.j.vr("wechatcrash");
      paramString = com.tencent.mm.crash.a.adz();
      if (i != 0)
      {
        localObject3 = WebView.getCrashExtraMessage(aj.getContext());
        com.tencent.mm.crash.a.vN((String)localObject3);
        ad.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
      }
      paramString.gfn = sCrashExtraMessageGetter;
      cj.BD(com.tencent.mm.loader.j.b.arM());
      return false;
    }
  }
  
  private static void fl(String paramString)
  {
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i)
        {
          ad.e("MicroMsg.MMCrashReporter", paramString.substring(0, 896));
          paramString = paramString.substring(897);
        }
        else
        {
          ad.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
          paramString = paramString.substring(i + 1);
        }
      }
      ad.e("MicroMsg.MMCrashReporter", paramString);
      ad.fku();
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  private static void p(Context arg0, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (cUn)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new s.8() });
          cUn.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            cUn[0] = -1L;
            cUn[1] = -1L;
            cUn[2] = -1L;
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (cUn)
            {
              cUn.notify();
            }
          }
        }
      }
    }
    ad.i("MicroMsg.MMCrashReporter", "getStats, %s", new Object[] { paramString });
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
          cUn[0] = ???.getCacheBytes();
          cUn[1] = ???.getDataBytes();
          cUn[2] = ???.getAppBytes();
          ad.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool), Long.valueOf(cUn[0]), Long.valueOf(cUn[1]), Long.valueOf(cUn[2]), bt.flS() });
          return;
          bool = false;
          continue;
          if (k == 0) {}
          for (bool = true;; bool = false) {
            break;
          }
          paramString = paramString;
          ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "summer getStats crash1 e:", new Object[0]);
        }
        catch (Exception ???)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "summer getStats crash2 e:", new Object[0]);
            ??? = null;
          }
        }
      }
    }
  }
  
  public final void O(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.q.d.doy() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", Mc());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.q.d.doy().Y(aj.getContext(), localIntent);
    }
  }
  
  public final void P(String paramString1, String paramString2)
  {
    b(a(paramString1, true, com.tencent.mm.sdk.platformtools.i.hgG) + paramString2, 0, false);
  }
  
  public final void a(com.tencent.mm.sdk.a.a parama)
  {
    au.a(parama);
  }
  
  public final void a(c.a parama)
  {
    if (parama == null) {
      return;
    }
    cUd.add(parama);
  }
  
  public final void b(au paramau, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str = paramThrowable.getMessage();
      if (!bt.isNullOrNil(str))
      {
        paramau = paramau.aQx(str);
        if (bt.isNullOrNil(paramau)) {}
      }
    }
    for (;;)
    {
      af.e(paramThrowable);
      b(paramString, 0, false);
      return;
      paramau = "";
    }
  }
  
  /* Error */
  public final void bo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 208
    //   2: ldc_w 1233
    //   5: invokestatic 584	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 604	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 351	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 1236	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1238
    //   25: invokespecial 1241	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 14	com/tencent/mm/app/s$3
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1244	com/tencent/mm/app/s$3:<init>	(Lcom/tencent/mm/app/s;Ljava/lang/String;)V
    //   38: invokevirtual 1248	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 10
    //   43: aload 10
    //   45: ifnull +592 -> 637
    //   48: invokestatic 788	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 210	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 379	java/lang/StringBuilder:<init>	(I)V
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
    //   82: if_icmpge +523 -> 605
    //   85: aload 10
    //   87: iload_2
    //   88: aaload
    //   89: astore 13
    //   91: aload 13
    //   93: invokevirtual 1249	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1251
    //   99: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +173 -> 275
    //   105: aload 13
    //   107: invokevirtual 1249	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1253
    //   113: invokevirtual 888	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +128 -> 244
    //   119: ldc 208
    //   121: ldc_w 1255
    //   124: aload 13
    //   126: invokestatic 1258	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 1261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 584	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 13
    //   137: invokevirtual 595	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 7
    //   142: aload 7
    //   144: ldc_w 1263
    //   147: ldc_w 1253
    //   150: invokevirtual 1267	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore_1
    //   154: aload_1
    //   155: aload 7
    //   157: invokevirtual 809	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +481 -> 641
    //   163: aconst_null
    //   164: astore_1
    //   165: iconst_0
    //   166: aload 7
    //   168: aload_1
    //   169: invokestatic 1271	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   172: astore 7
    //   174: ldc 208
    //   176: new 210	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 1273
    //   183: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: getfield 1278	com/tencent/mm/crash/a$a:gfo	I
    //   191: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 584	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 7
    //   202: getfield 1278	com/tencent/mm/crash/a$a:gfo	I
    //   205: aload 7
    //   207: getfield 1281	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   210: ldc_w 805
    //   213: iconst_1
    //   214: aload 7
    //   216: getfield 1284	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   219: invokestatic 1286	com/tencent/mm/app/s:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   222: aload 13
    //   224: invokevirtual 1289	java/io/File:delete	()Z
    //   227: pop
    //   228: aload_1
    //   229: ifnull +15 -> 244
    //   232: new 351	java/io/File
    //   235: dup
    //   236: aload_1
    //   237: invokespecial 352	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 1289	java/io/File:delete	()Z
    //   243: pop
    //   244: iload_2
    //   245: iconst_1
    //   246: iadd
    //   247: istore_2
    //   248: goto -169 -> 79
    //   251: astore 7
    //   253: ldc 208
    //   255: aload 7
    //   257: ldc_w 1291
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 13
    //   268: aastore
    //   269: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -50 -> 222
    //   275: ldc 208
    //   277: ldc_w 1255
    //   280: aload 13
    //   282: invokestatic 1258	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 1261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 584	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: new 398	java/io/FileReader
    //   294: dup
    //   295: aload 13
    //   297: invokespecial 1294	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   300: astore 14
    //   302: aconst_null
    //   303: astore 8
    //   305: aload 11
    //   307: iconst_0
    //   308: invokevirtual 1297	java/lang/StringBuilder:setLength	(I)V
    //   311: aload 14
    //   313: aload 12
    //   315: invokevirtual 1301	java/io/FileReader:read	([C)I
    //   318: istore_3
    //   319: iload_3
    //   320: iconst_m1
    //   321: if_icmpeq +56 -> 377
    //   324: aload 11
    //   326: aload 12
    //   328: iconst_0
    //   329: iload_3
    //   330: invokevirtual 1304	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: goto -23 -> 311
    //   337: astore 7
    //   339: aload 7
    //   341: athrow
    //   342: astore_1
    //   343: aload 7
    //   345: ifnull +252 -> 597
    //   348: aload 14
    //   350: invokevirtual 1305	java/io/FileReader:close	()V
    //   353: aload_1
    //   354: athrow
    //   355: astore_1
    //   356: ldc 208
    //   358: aload_1
    //   359: ldc_w 1291
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload 13
    //   370: aastore
    //   371: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: goto -130 -> 244
    //   377: aload 11
    //   379: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore 7
    //   384: aload 13
    //   386: invokevirtual 1249	java/io/File:getName	()Ljava/lang/String;
    //   389: ldc_w 1307
    //   392: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   395: ifeq +24 -> 419
    //   398: aload 7
    //   400: iconst_0
    //   401: iconst_0
    //   402: invokestatic 813	com/tencent/mm/app/s:b	(Ljava/lang/String;IZ)V
    //   405: aload 13
    //   407: invokevirtual 1289	java/io/File:delete	()Z
    //   410: pop
    //   411: aload 14
    //   413: invokevirtual 1305	java/io/FileReader:close	()V
    //   416: goto -172 -> 244
    //   419: getstatic 1212	com/tencent/mm/sdk/platformtools/i:hgG	Ljava/lang/String;
    //   422: astore_1
    //   423: ldc_w 1309
    //   426: invokestatic 1315	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   429: aload 7
    //   431: invokevirtual 1319	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   434: astore 15
    //   436: aload 15
    //   438: invokevirtual 1324	java/util/regex/Matcher:find	()Z
    //   441: ifeq +197 -> 638
    //   444: aload 15
    //   446: iconst_1
    //   447: invokevirtual 1327	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   450: astore 9
    //   452: aload 9
    //   454: astore_1
    //   455: aload 9
    //   457: ldc_w 1329
    //   460: invokevirtual 408	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   463: ifne +40 -> 503
    //   466: aload 9
    //   468: invokestatic 1332	com/tencent/mm/sdk/platformtools/bt:aRe	(Ljava/lang/String;)I
    //   471: istore_3
    //   472: aload 9
    //   474: astore_1
    //   475: iload_3
    //   476: ifeq +27 -> 503
    //   479: new 210	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 1329
    //   486: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: iload_3
    //   490: invokestatic 1335	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   493: invokevirtual 1338	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   496: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: astore_1
    //   503: aload 7
    //   505: aload 15
    //   507: invokevirtual 1341	java/util/regex/Matcher:end	()I
    //   510: invokevirtual 349	java/lang/String:substring	(I)Ljava/lang/String;
    //   513: astore 7
    //   515: aload 7
    //   517: invokevirtual 1342	java/lang/String:isEmpty	()Z
    //   520: ifne +48 -> 568
    //   523: iconst_0
    //   524: istore_3
    //   525: ldc_w 1344
    //   528: invokestatic 1315	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   531: aload 7
    //   533: invokevirtual 1319	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   536: astore 9
    //   538: aload 9
    //   540: invokevirtual 1324	java/util/regex/Matcher:find	()Z
    //   543: ifeq +14 -> 557
    //   546: aload 9
    //   548: iconst_1
    //   549: invokevirtual 1327	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   552: iconst_0
    //   553: invokestatic 1347	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   556: istore_3
    //   557: iload_3
    //   558: aload 7
    //   560: ldc_w 1349
    //   563: iconst_1
    //   564: aload_1
    //   565: invokestatic 1286	com/tencent/mm/app/s:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   568: aload 13
    //   570: invokevirtual 1289	java/io/File:delete	()Z
    //   573: pop
    //   574: goto -163 -> 411
    //   577: astore_1
    //   578: aload 8
    //   580: astore 7
    //   582: goto -239 -> 343
    //   585: astore 8
    //   587: aload 7
    //   589: aload 8
    //   591: invokevirtual 1352	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   594: goto -241 -> 353
    //   597: aload 14
    //   599: invokevirtual 1305	java/io/FileReader:close	()V
    //   602: goto -249 -> 353
    //   605: ldc 208
    //   607: ldc_w 1354
    //   610: iconst_2
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: lload 5
    //   618: invokestatic 621	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: invokestatic 788	java/lang/System:currentTimeMillis	()J
    //   627: lload 5
    //   629: lsub
    //   630: invokestatic 621	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   633: aastore
    //   634: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: return
    //   638: goto -123 -> 515
    //   641: goto -476 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	s
    //   0	644	1	paramContext	Context
    //   78	170	2	i	int
    //   318	240	3	j	int
    //   75	8	4	k	int
    //   51	577	5	l	long
    //   12	203	7	localObject1	Object
    //   251	5	7	localIOException	java.io.IOException
    //   337	7	7	localThrowable1	Throwable
    //   382	206	7	localObject2	Object
    //   303	276	8	localObject3	Object
    //   585	5	8	localThrowable2	Throwable
    //   450	97	9	localObject4	Object
    //   41	45	10	arrayOfFile	File[]
    //   63	315	11	localStringBuilder	StringBuilder
    //   70	257	12	arrayOfChar	char[]
    //   89	480	13	localFile	File
    //   300	298	14	localFileReader	java.io.FileReader
    //   434	72	15	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   165	222	251	java/io/IOException
    //   305	311	337	java/lang/Throwable
    //   311	319	337	java/lang/Throwable
    //   324	334	337	java/lang/Throwable
    //   377	411	337	java/lang/Throwable
    //   419	452	337	java/lang/Throwable
    //   455	472	337	java/lang/Throwable
    //   479	503	337	java/lang/Throwable
    //   503	515	337	java/lang/Throwable
    //   515	523	337	java/lang/Throwable
    //   525	538	337	java/lang/Throwable
    //   538	557	337	java/lang/Throwable
    //   557	568	337	java/lang/Throwable
    //   568	574	337	java/lang/Throwable
    //   339	342	342	finally
    //   291	302	355	java/lang/Exception
    //   348	353	355	java/lang/Exception
    //   353	355	355	java/lang/Exception
    //   411	416	355	java/lang/Exception
    //   587	594	355	java/lang/Exception
    //   597	602	355	java/lang/Exception
    //   305	311	577	finally
    //   311	319	577	finally
    //   324	334	577	finally
    //   377	411	577	finally
    //   419	452	577	finally
    //   455	472	577	finally
    //   479	503	577	finally
    //   503	515	577	finally
    //   515	523	577	finally
    //   525	538	577	finally
    //   538	557	577	finally
    //   557	568	577	finally
    //   568	574	577	finally
    //   348	353	585	java/lang/Throwable
  }
  
  public final void bp(Context paramContext)
  {
    au.a(this);
    if (cUk.endsWith(":push")) {}
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
        ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
        String str = "/data/anr/traces.txt";
      }
    }
    localObject2 = new File((String)localObject1);
    this.cUf = ((File)localObject2).getParent();
    if ((this.cUf == null) || (this.cUf.length() == 0)) {
      this.cUf = "/";
    }
    this.cUg = ((File)localObject2).getName();
    this.cUh = new ConditionVariable();
    ad.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.cUe = new HashSet();
    this.cUb = new a(this.cUf);
    this.cUb.startWatching();
    CoreService.a(this);
    if (aj.cmR()) {
      paramContext.sendBroadcast(new Intent(paramContext, CrashUploadAlarmReceiver.class));
    }
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, com.tencent.mm.sdk.platformtools.i.hgG);
  }
  
  public final void fm(final String paramString)
  {
    ad.i("MicroMsg.MMCrashReporter", "start to reportSignalAnr");
    bool1 = Md();
    final boolean bool2 = com.tencent.matrix.a.cAS.cAU;
    Object localObject1 = AppForegroundDelegate.cSQ.LG();
    try
    {
      str = com.tencent.matrix.a.cAS.cAV;
      localObject1 = str;
      if (com.tencent.matrix.d.cBd.cBe == null) {
        break label347;
      }
      localObject1 = str;
      Object localObject2 = (h.d)com.tencent.matrix.d.cBd.cBe.cFp.getFirst();
      if (localObject2 == null) {
        break label347;
      }
      localObject1 = str;
      long l = ((com.tencent.matrix.report.c)localObject2).cEZ.getLong("time");
      localObject1 = str;
      localObject2 = ((com.tencent.matrix.report.c)localObject2).cEZ.getString("detail");
      localObject1 = str;
      ad.i("MicroMsg.MMCrashReporter", "latest Matrix ANR issueTime = %d", new Object[] { Long.valueOf(l) });
      localObject1 = str;
      if (!((String)localObject2).equalsIgnoreCase(a.a.cJN.toString())) {
        break label347;
      }
      localObject1 = str;
      if (System.currentTimeMillis() - l >= 5000L) {
        break label347;
      }
      localObject1 = str;
      ad.i("MicroMsg.MMCrashReporter", "Matrix ANR happens recently");
      i = 11;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        final String str;
        ad.e("MicroMsg.MMCrashReporter", "get scene from Matrix failed , e : " + localException.getMessage());
        final int i = 10;
        continue;
        bool1 = false;
        continue;
        i = 10;
      }
    }
    localObject1 = str;
    str = aj.getProcessName();
    if (bool1)
    {
      a(paramString, (String)localObject1, i, bool2, str);
      bool1 = true;
      ad.i("MicroMsg.MMCrashReporter", "happens ANR stacktrace : %s, processName :%s , scene : %s, isForeground : %b, type : %d, status: %s", new Object[] { paramString, str, localObject1, Boolean.valueOf(bool2), Integer.valueOf(i), Looper.getMainLooper().getThread().getState() });
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          int i = 0;
          while (i < 5)
          {
            s.b(s.this);
            i += 1;
            try
            {
              Thread.sleep(1000L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      });
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          int i = 0;
          for (;;)
          {
            if (i < 30)
            {
              boolean bool = s.Mh();
              ad.i("MicroMsg.MMCrashReporter", "[checkErrorStateCycle] my anr = ".concat(String.valueOf(bool)));
              if ((bool) && (!bool1))
              {
                ad.i("MicroMsg.MMCrashReporter", "[checkErrorStateCycle] has detected anr state, report ");
                s.b(paramString, this.cBp, i, bool2, str);
              }
            }
            else
            {
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
  
  final void t(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.g.yhR.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(26L, 0L, 1L, true);
    fl(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
    com.tencent.mm.plugin.report.service.g.dKq();
    long l = System.currentTimeMillis();
    if (l - this.cUc < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.cUc = l;
      h.d(aj.getContext(), aj.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(a("", true, com.tencent.mm.sdk.platformtools.i.hgG));
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
    } while (com.tencent.mm.plugin.q.d.doy() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", az.hFS.ax("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.q.d.doy().Y(aj.getContext(), paramString);
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
      //   6: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   9: invokestatic 29	com/tencent/mm/app/s:c	(Lcom/tencent/mm/app/s;)J
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
      //   28: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   31: getfield 35	com/tencent/mm/app/s:cUe	Ljava/util/HashSet;
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
      //   105: invokestatic 55	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   108: aload_0
      //   109: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   112: getfield 59	com/tencent/mm/app/s:cUh	Landroid/os/ConditionVariable;
      //   115: invokevirtual 65	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   122: getfield 69	com/tencent/mm/app/s:cUo	Lcom/tencent/mm/app/s$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   132: new 71	com/tencent/mm/app/s$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   140: iconst_0
      //   141: invokespecial 74	com/tencent/mm/app/s$b:<init>	(Lcom/tencent/mm/app/s;B)V
      //   144: putfield 69	com/tencent/mm/app/s:cUo	Lcom/tencent/mm/app/s$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   151: getfield 69	com/tencent/mm/app/s:cUo	Lcom/tencent/mm/app/s$b;
      //   154: ldc 76
      //   156: invokestatic 81	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   163: getfield 35	com/tencent/mm/app/s:cUe	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/s$a:cUq	Lcom/tencent/mm/app/s;
      //   178: getfield 35	com/tencent/mm/app/s:cUe	Ljava/util/HashSet;
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
    
    private static ActivityManager.ProcessErrorStateInfo Mk()
    {
      Object localObject = ((ActivityManager)aj.getContext().getSystemService("activity")).getProcessesInErrorState();
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
      ad.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
      ??? = null;
      for (;;)
      {
        if (s.this.cUh.block(10000L)) {
          s.this.cUh.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = Mk();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = Mk();
            localObject2 = ???;
            if (??? == null)
            {
              ad.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              s.this.cUo = null;
              return;
            }
          }
          ad.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (s.this.cUe)
            {
              localObject4 = new ArrayList(s.this.cUe.size());
              int i = s.this.cUg.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = s.this.cUg.substring(0, i) + '_' + str + s.this.cUg.substring(i);
                if (s.this.cUe.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (s.this.cUe.remove(s.this.cUg)) {
                ((ArrayList)localObject4).add(s.this.cUg);
              }
              ((ArrayList)localObject4).addAll(s.this.cUe);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = s.this.cUf + '/' + (String)localObject4;
                str = s.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  ad.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  s.this.t(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                ad.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                s.this.cUo = null;
                return;
              }
            }
            ad.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
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
 * Qualified Name:     com.tencent.mm.app.s
 * JD-Core Version:    0.7.0.1
 */