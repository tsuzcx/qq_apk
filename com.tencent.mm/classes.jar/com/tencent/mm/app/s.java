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
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Base64;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.CoreService.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.au.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import com.tencent.xweb.xwalk.a.e;
import java.io.File;
import java.io.FilenameFilter;
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
import junit.framework.AssertionFailedError;
import org.xwalk.core.XWalkEnvironment;

public class s
  implements CoreService.b, com.tencent.mm.sdk.a.c, au.d
{
  public static final long cLI = ;
  private static final Set<c.a> cLM = new HashSet();
  private static final String cLR;
  private static final String cLS;
  private static String cLT;
  private static long[] cLU = { 0L, 0L, 0L };
  private static volatile boolean cLW;
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  private au cLJ = null;
  private a cLK;
  private volatile long cLL = 0L;
  HashSet<String> cLN;
  String cLO;
  String cLP;
  ConditionVariable cLQ;
  volatile b cLV;
  
  static
  {
    String str = q.Xa();
    cLR = str;
    cLS = p.getString(str.hashCode());
    cLT = "";
    sCrashExtraMessageGetter = new CrashMonitorForJni.a()
    {
      public final String KQ()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = aj.getProcessName();
        Object localObject2;
        if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
        {
          localStringBuilder.append("\n");
          localObject1 = WebView.getCrashExtraMessage(aj.getContext());
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.h.glW });
            localObject1 = localObject2;
            if (((String)localObject2).length() > 8192) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
            }
            localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
            ad.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
          }
        }
        localObject1 = s.KP().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.a)((Iterator)localObject1).next();
          localStringBuilder.append('\n').append(((c.a)localObject2).aTX());
        }
        return localStringBuilder.toString();
      }
    };
  }
  
  private static String KN()
  {
    String str2 = ay.gNa.ao("login_weixin_username", "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = ay.gNa.ao("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static String KO()
  {
    try
    {
      localObject2 = af.get("dalvik.vm.stack-trace-file");
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
    //   3: new 161	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 211	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 213	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc 215
    //   21: invokespecial 216	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: new 161	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 218
    //   32: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload_1
    //   36: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 224
    //   41: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 4
    //   51: ifnull +19 -> 70
    //   54: aload 9
    //   56: aload 4
    //   58: getfield 229	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   61: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 10
    //   66: invokevirtual 173	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 231	java/io/BufferedReader
    //   73: dup
    //   74: new 233	java/io/FileReader
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 234	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 237	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: iload 5
    //   89: istore_1
    //   90: aload 4
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: ifnull +249 -> 351
    //   105: iload_1
    //   106: tableswitch	default:+297 -> 403, 0:+26->132, 1:+99->205, 2:+159->265
    //   133: iconst_1
    //   134: astore_0
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -52 -> 90
    //   145: aload 4
    //   147: astore_0
    //   148: aload 11
    //   150: invokevirtual 146	java/lang/String:length	()I
    //   153: istore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 10
    //   160: aload 12
    //   162: iload 5
    //   164: iload 5
    //   166: bipush 19
    //   168: iadd
    //   169: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 247	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 252	java/util/Date:getTime	()J
    //   178: lload_2
    //   179: lsub
    //   180: lstore 6
    //   182: lload 6
    //   184: ldc2_w 253
    //   187: lcmp
    //   188: iflt -98 -> 90
    //   191: lload 6
    //   193: ldc2_w 255
    //   196: lcmp
    //   197: ifgt -107 -> 90
    //   200: iconst_1
    //   201: istore_1
    //   202: goto -112 -> 90
    //   205: aload 4
    //   207: astore_0
    //   208: aload 9
    //   210: aload 12
    //   212: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: bipush 10
    //   217: invokevirtual 173	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: astore_0
    //   224: aload 12
    //   226: ldc_w 258
    //   229: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   232: ifeq +8 -> 240
    //   235: iconst_2
    //   236: istore_1
    //   237: goto -147 -> 90
    //   240: aload 4
    //   242: astore_0
    //   243: aload 12
    //   245: ldc_w 260
    //   248: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   251: istore 8
    //   253: iload 8
    //   255: ifeq -165 -> 90
    //   258: aload 4
    //   260: invokevirtual 263	java/io/BufferedReader:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: aload 4
    //   267: astore_0
    //   268: aload 12
    //   270: ldc_w 265
    //   273: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   276: ifeq +25 -> 301
    //   279: aload 4
    //   281: astore_0
    //   282: aload 9
    //   284: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 9
    //   289: aload 4
    //   291: invokevirtual 263	java/io/BufferedReader:close	()V
    //   294: aload 9
    //   296: areturn
    //   297: astore_0
    //   298: aload 9
    //   300: areturn
    //   301: aload 4
    //   303: astore_0
    //   304: aload 9
    //   306: aload 12
    //   308: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: bipush 10
    //   313: invokevirtual 173	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: goto -227 -> 90
    //   320: astore 9
    //   322: aload 4
    //   324: astore_0
    //   325: ldc 189
    //   327: aload 9
    //   329: ldc_w 267
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokestatic 197	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: aload 4
    //   341: ifnull +8 -> 349
    //   344: aload 4
    //   346: invokevirtual 263	java/io/BufferedReader:close	()V
    //   349: aconst_null
    //   350: areturn
    //   351: aload 4
    //   353: invokevirtual 263	java/io/BufferedReader:close	()V
    //   356: goto -7 -> 349
    //   359: astore_0
    //   360: goto -11 -> 349
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_0
    //   367: aload_0
    //   368: ifnull +7 -> 375
    //   371: aload_0
    //   372: invokevirtual 263	java/io/BufferedReader:close	()V
    //   375: aload 4
    //   377: athrow
    //   378: astore_0
    //   379: goto -116 -> 263
    //   382: astore_0
    //   383: goto -34 -> 349
    //   386: astore_0
    //   387: goto -12 -> 375
    //   390: astore 4
    //   392: goto -25 -> 367
    //   395: astore 9
    //   397: aconst_null
    //   398: astore 4
    //   400: goto -78 -> 322
    //   403: goto -313 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramString	String
    //   0	406	1	paramInt	int
    //   0	406	2	paramLong	long
    //   0	406	4	paramProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    //   1	168	5	i	int
    //   180	12	6	l	long
    //   251	3	8	bool	boolean
    //   13	292	9	localObject	Object
    //   320	8	9	localException1	Exception
    //   395	1	9	localException2	Exception
    //   24	135	10	localSimpleDateFormat	SimpleDateFormat
    //   47	102	11	str1	String
    //   98	209	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   289	294	297	java/io/IOException
    //   93	100	320	java/lang/Exception
    //   135	145	320	java/lang/Exception
    //   148	155	320	java/lang/Exception
    //   158	182	320	java/lang/Exception
    //   208	221	320	java/lang/Exception
    //   224	235	320	java/lang/Exception
    //   243	253	320	java/lang/Exception
    //   268	279	320	java/lang/Exception
    //   282	289	320	java/lang/Exception
    //   304	317	320	java/lang/Exception
    //   351	356	359	java/io/IOException
    //   70	87	363	finally
    //   258	263	378	java/io/IOException
    //   344	349	382	java/io/IOException
    //   371	375	386	java/io/IOException
    //   93	100	390	finally
    //   135	145	390	finally
    //   148	155	390	finally
    //   158	182	390	finally
    //   208	221	390	finally
    //   224	235	390	finally
    //   243	253	390	finally
    //   268	279	390	finally
    //   282	289	390	finally
    //   304	317	390	finally
    //   325	339	390	finally
    //   70	87	395	java/lang/Exception
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
        localStringBuilder.append("#client.verHistory=").append(ci.nr(4)).append('\n');
        localStringBuilder.append("#client.revision=").append(com.tencent.mm.sdk.platformtools.h.REV).append('\n');
        localStringBuilder.append("#client.uin=").append(ay.gNa.ao("last_login_uin", p.getString(q.Xa().hashCode()))).append('\n');
        localStringBuilder.append("#client.dev=").append(q.Xa()).append('\n');
        localStringBuilder.append("#client.build=").append(com.tencent.mm.sdk.platformtools.h.TIME).append(":").append(com.tencent.mm.sdk.platformtools.h.HOSTNAME).append(":").append(i.cJR).append('\n');
        localStringBuilder.append("#client.runtime=").append(bt.eGO() - cLI).append("(").append(bt.nullAsNil(cLT)).append(")\n");
        localStringBuilder.append("#client.IMEI=").append(q.cG(true)).append('\n');
        localStringBuilder.append("#client.abi=").append(Build.CPU_ABI).append('\n');
        localStringBuilder.append("#qbrwoser.coreVersion=").append(WebView.getInstalledTbsCoreVersion((Context)localObject)).append('\n');
        localStringBuilder.append("#qbrwoser.ver=").append(WebView.getTbsSDKVersion((Context)localObject)).append('\n');
        localObject = localStringBuilder.append("#status.dwx_bt=");
        if (!com.tencent.mm.sdk.a.b.cWT()) {
          break label1278;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.xh=");
        if (!com.tencent.mm.sdk.a.b.cWR()) {
          break label1285;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localObject = localStringBuilder.append("#status.x86_env=");
        if (!com.tencent.mm.sdk.a.b.cWS()) {
          break label1292;
        }
        paramString2 = "1";
        ((StringBuilder)localObject).append(paramString2).append('\n');
        localStringBuilder.append("#xsdkver=200502\n");
        localStringBuilder.append("#accinfo.foreground=").append(AppForegroundDelegate.cKE.csU).append('\n');
        localStringBuilder.append("#accinfo.currentThread=").append(Thread.currentThread().getName()).append('\n');
        localStringBuilder.append("#accinfo.currentActivity=").append(AppForegroundDelegate.cKE.cKI.cKU.activity).append('\n');
        paramString2 = new Date();
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilder.append("#accinfo.crashTime=").append(((SimpleDateFormat)localObject).format(paramString2)).append('\n');
        ad.i("MicroMsg.MMCrashReporter", "build header.");
        try
        {
          paramString2 = new StatFs(Environment.getDataDirectory().getPath());
          localObject = new StatFs(com.tencent.mm.loader.j.b.aib());
          r(aj.getContext(), aj.getContext().getPackageName());
          paramString2 = String.format("%s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Long.valueOf(paramString2.getBlockSizeLong()), Long.valueOf(paramString2.getBlockCountLong()), Long.valueOf(paramString2.getAvailableBlocksLong()), Long.valueOf(cLU[0]), Long.valueOf(cLU[1]), Long.valueOf(cLU[2]), com.tencent.mm.loader.j.b.aib(), Long.valueOf(((StatFs)localObject).getBlockSizeLong()), Long.valueOf(((StatFs)localObject).getBlockCountLong()), Long.valueOf(((StatFs)localObject).getAvailableBlocksLong()) });
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
              paramString2 = com.tencent.xweb.xwalk.a.g.ftk();
              if (paramString2.isEmpty()) {
                break label1181;
              }
              localStringBuilder.append("#xwalk.pluginInit=true\n");
              paramString2 = paramString2.iterator();
              if (paramString2.hasNext())
              {
                localObject = (e)paramString2.next();
                if (localObject == null) {
                  continue;
                }
                localStringBuilder.append("#xwalk.").append(((e)localObject).getPluginName()).append("=").append(((e)localObject).IUH).append('\n');
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
            if ((paramBoolean) && (!bt.isNullOrNil(sCrashExtraMessageGetter.KQ()))) {
              localStringBuilder.append("#extraCrashMsg=").append(sCrashExtraMessageGetter.KQ()).append('\n');
            }
            localStringBuilder.append("#runtime.memory=").append(com.tencent.mm.performance.a.a.aFM().l(true, 0)).append('\n');
            int i = com.tencent.mm.plugin.performance.c.b.HM();
            localStringBuilder.append("#runtime.processThreadCount=").append(i).append('\n');
            if ((i >= 130) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
            {
              localStringBuilder.append("#runtime.threadInfo=");
              localStringBuilder.append(com.tencent.matrix.f.a.HN()).append('\n');
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
      label1181:
      paramString2 = com.tencent.xweb.xwalk.a.g.le(aj.getContext()).entrySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (Map.Entry)paramString2.next();
        if (localObject != null) {
          localStringBuilder.append("#xwalk.").append((String)((Map.Entry)localObject).getKey()).append("=").append(((Map.Entry)localObject).getValue()).append('\n');
        }
      }
      continue;
      label1278:
      paramString2 = "0";
      continue;
      label1285:
      paramString2 = "0";
      continue;
      label1292:
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
        String str = KO();
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
  
  private static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    eB(paramString);
    com.tencent.mm.plugin.report.service.h.vKh.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (aj.getProcessName().endsWith(":push"))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(25L, 2L, 1L, true);
      localObject = paramString;
      if (h.bl(aj.getContext()) == 1)
      {
        int i = h.bm(aj.getContext());
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
      if (com.tencent.mm.plugin.q.d.cRq() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", KN());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.q.d.cRq().I(aj.getContext(), (Intent)localObject);
      }
      paramString = com.tencent.mm.plugin.report.service.h.vKh;
      com.tencent.mm.plugin.report.service.h.dkP();
      return;
      if ((aj.eFK()) || (aj.eFK()))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (aj.getProcessName().endsWith(":exdevice"))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!aj.cbv()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean eA(String paramString)
  {
    Object localObject4 = null;
    cLT = paramString;
    if (com.tencent.mm.plugin.q.d.cRq() == null) {}
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
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + cLT);
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + cLT);
        localObject1 = com.tencent.mm.bs.d.kH("sandbox", ".SubCoreSandBox");
        ad.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + cLT);
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
            ad.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + cLT);
            try
            {
              localObject1 = (com.tencent.mm.sdk.a.c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((com.tencent.mm.sdk.a.c)localObject1).bp(aj.getContext());
              ay.gNa.ao("last_login_uin", p.getString(q.Xa().hashCode()));
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
    int i;
    boolean bool;
    if ((paramString.contains(":appbrand")) || (paramString.contains(":support")))
    {
      i = 1;
      if ((!q.is64BitRuntime()) && (!bu.eGT())) {
        break label554;
      }
      bool = true;
      label417:
      if (bool) {
        break label622;
      }
      s.class.getClassLoader();
      j.pq("wechatCrashForJni");
      paramString = "version:" + com.tencent.mm.sdk.platformtools.h.glW;
      if (i == 0) {
        break label680;
      }
      paramString = paramString + "\n" + WebView.getCrashExtraMessage(aj.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.h.glW }) + "\n";
      ad.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { paramString });
    }
    label680:
    for (;;)
    {
      CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
      CrashMonitorForJni.setClientVersionMsg(paramString);
      for (;;)
      {
        ci.uy(com.tencent.mm.loader.j.b.ahZ());
        return false;
        i = 0;
        break;
        label554:
        bool = paramString.equals("com.tencent.mm");
        cLW = new File(aj.getContext().getFilesDir(), "new-native-crash").exists();
        if (bool)
        {
          com.tencent.mm.sdk.b.a.ESL.b(new com.tencent.mm.sdk.b.c()
          {
            private static boolean KR()
            {
              try
              {
                s.cb(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvj, false));
                return true;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Cannot load A/B test", new Object[0]);
                }
              }
            }
          });
          com.tencent.mm.sdk.b.a.ESL.b(new com.tencent.mm.sdk.b.c()
          {
            private static boolean GL()
            {
              try
              {
                s.cb(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvj, false));
                return true;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Cannot load A/B test", new Object[0]);
                }
              }
            }
          });
        }
        bool = cLW;
        break label417;
        label622:
        NativeCrash.class.getClassLoader();
        j.pq("wechatcrash");
        paramString = com.tencent.mm.crash.a.aab();
        if (i != 0)
        {
          localObject3 = WebView.getCrashExtraMessage(aj.getContext());
          com.tencent.mm.crash.a.pN((String)localObject3);
          ad.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
        }
        paramString.fIh = sCrashExtraMessageGetter;
      }
    }
  }
  
  private static void eB(String paramString)
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
      ad.eFw();
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  private static void r(Context arg0, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (cLU)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new s.4() });
          cLU.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            cLU[0] = -1L;
            cLU[1] = -1L;
            cLU[2] = -1L;
            ad.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (cLU)
            {
              cLU.notify();
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
          cLU[0] = ???.getCacheBytes();
          cLU[1] = ???.getDataBytes();
          cLU[2] = ???.getAppBytes();
          ad.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool), Long.valueOf(cLU[0]), Long.valueOf(cLU[1]), Long.valueOf(cLU[2]), bt.eGN() });
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
  
  public final void M(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.q.d.cRq() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", KN());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.q.d.cRq().I(aj.getContext(), localIntent);
    }
  }
  
  public final void N(String paramString1, String paramString2)
  {
    b(a(paramString1, true, com.tencent.mm.sdk.platformtools.h.glW) + paramString2, 0, false);
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
    cLM.add(parama);
  }
  
  public final void a(au paramau, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str = paramThrowable.getMessage();
      if (!bt.isNullOrNil(str))
      {
        paramau = paramau.aFA(str);
        if (bt.isNullOrNil(paramau)) {}
      }
    }
    for (;;)
    {
      ae.e(paramThrowable);
      b(paramString, 0, false);
      return;
      paramau = "";
    }
  }
  
  /* Error */
  public final void bo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 189
    //   2: ldc_w 1152
    //   5: invokestatic 437	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 459	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: astore 7
    //   14: new 180	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 823	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 1154
    //   25: invokespecial 828	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: new 16	com/tencent/mm/app/s$3
    //   31: dup
    //   32: aload_0
    //   33: aload 7
    //   35: invokespecial 1157	com/tencent/mm/app/s$3:<init>	(Lcom/tencent/mm/app/s;Ljava/lang/String;)V
    //   38: invokevirtual 1161	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   41: astore 10
    //   43: aload 10
    //   45: ifnull +592 -> 637
    //   48: invokestatic 662	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: new 161	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 16384
    //   60: invokespecial 211	java/lang/StringBuilder:<init>	(I)V
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
    //   93: invokevirtual 1162	java/io/File:getName	()Ljava/lang/String;
    //   96: ldc_w 1164
    //   99: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +173 -> 275
    //   105: aload 13
    //   107: invokevirtual 1162	java/io/File:getName	()Ljava/lang/String;
    //   110: ldc_w 1166
    //   113: invokevirtual 726	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +128 -> 244
    //   119: ldc 189
    //   121: ldc_w 1168
    //   124: aload 13
    //   126: invokestatic 1171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 1174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 437	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 13
    //   137: invokevirtual 448	java/io/File:getPath	()Ljava/lang/String;
    //   140: astore 7
    //   142: aload 7
    //   144: ldc_w 1176
    //   147: ldc_w 1166
    //   150: invokevirtual 1180	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   153: astore_1
    //   154: aload_1
    //   155: aload 7
    //   157: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +481 -> 641
    //   163: aconst_null
    //   164: astore_1
    //   165: iconst_0
    //   166: aload 7
    //   168: aload_1
    //   169: invokestatic 1184	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   172: astore 7
    //   174: ldc 189
    //   176: new 161	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 1186
    //   183: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: getfield 1191	com/tencent/mm/crash/a$a:fIi	I
    //   191: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 437	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 7
    //   202: getfield 1191	com/tencent/mm/crash/a$a:fIi	I
    //   205: aload 7
    //   207: getfield 1194	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   210: ldc_w 679
    //   213: iconst_1
    //   214: aload 7
    //   216: getfield 1197	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   219: invokestatic 1199	com/tencent/mm/app/s:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   222: aload 13
    //   224: invokevirtual 836	java/io/File:delete	()Z
    //   227: pop
    //   228: aload_1
    //   229: ifnull +15 -> 244
    //   232: new 180	java/io/File
    //   235: dup
    //   236: aload_1
    //   237: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 836	java/io/File:delete	()Z
    //   243: pop
    //   244: iload_2
    //   245: iconst_1
    //   246: iadd
    //   247: istore_2
    //   248: goto -169 -> 79
    //   251: astore 7
    //   253: ldc 189
    //   255: aload 7
    //   257: ldc_w 1201
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 13
    //   268: aastore
    //   269: invokestatic 197	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -50 -> 222
    //   275: ldc 189
    //   277: ldc_w 1168
    //   280: aload 13
    //   282: invokestatic 1171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 1174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 437	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: new 233	java/io/FileReader
    //   294: dup
    //   295: aload 13
    //   297: invokespecial 1204	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   300: astore 14
    //   302: aconst_null
    //   303: astore 8
    //   305: aload 11
    //   307: iconst_0
    //   308: invokevirtual 1207	java/lang/StringBuilder:setLength	(I)V
    //   311: aload 14
    //   313: aload 12
    //   315: invokevirtual 1211	java/io/FileReader:read	([C)I
    //   318: istore_3
    //   319: iload_3
    //   320: iconst_m1
    //   321: if_icmpeq +56 -> 377
    //   324: aload 11
    //   326: aload 12
    //   328: iconst_0
    //   329: iload_3
    //   330: invokevirtual 1214	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: goto -23 -> 311
    //   337: astore 7
    //   339: aload 7
    //   341: athrow
    //   342: astore_1
    //   343: aload 7
    //   345: ifnull +252 -> 597
    //   348: aload 14
    //   350: invokevirtual 1215	java/io/FileReader:close	()V
    //   353: aload_1
    //   354: athrow
    //   355: astore_1
    //   356: ldc 189
    //   358: aload_1
    //   359: ldc_w 1201
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload 13
    //   370: aastore
    //   371: invokestatic 197	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: goto -130 -> 244
    //   377: aload 11
    //   379: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore 7
    //   384: aload 13
    //   386: invokevirtual 1162	java/io/File:getName	()Ljava/lang/String;
    //   389: ldc_w 1217
    //   392: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   395: ifeq +24 -> 419
    //   398: aload 7
    //   400: iconst_0
    //   401: iconst_0
    //   402: invokestatic 687	com/tencent/mm/app/s:b	(Ljava/lang/String;IZ)V
    //   405: aload 13
    //   407: invokevirtual 836	java/io/File:delete	()Z
    //   410: pop
    //   411: aload 14
    //   413: invokevirtual 1215	java/io/FileReader:close	()V
    //   416: goto -172 -> 244
    //   419: getstatic 941	com/tencent/mm/sdk/platformtools/h:glW	Ljava/lang/String;
    //   422: astore_1
    //   423: ldc_w 1219
    //   426: invokestatic 1225	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   429: aload 7
    //   431: invokevirtual 1229	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   434: astore 15
    //   436: aload 15
    //   438: invokevirtual 1234	java/util/regex/Matcher:find	()Z
    //   441: ifeq +197 -> 638
    //   444: aload 15
    //   446: iconst_1
    //   447: invokevirtual 1237	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   450: astore 9
    //   452: aload 9
    //   454: astore_1
    //   455: aload 9
    //   457: ldc_w 1239
    //   460: invokevirtual 243	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   463: ifne +40 -> 503
    //   466: aload 9
    //   468: invokestatic 1242	com/tencent/mm/sdk/platformtools/bt:aGh	(Ljava/lang/String;)I
    //   471: istore_3
    //   472: aload 9
    //   474: astore_1
    //   475: iload_3
    //   476: ifeq +27 -> 503
    //   479: new 161	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 1239
    //   486: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: iload_3
    //   490: invokestatic 1245	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   493: invokevirtual 1248	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   496: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: astore_1
    //   503: aload 7
    //   505: aload 15
    //   507: invokevirtual 1251	java/util/regex/Matcher:end	()I
    //   510: invokevirtual 175	java/lang/String:substring	(I)Ljava/lang/String;
    //   513: astore 7
    //   515: aload 7
    //   517: invokevirtual 1252	java/lang/String:isEmpty	()Z
    //   520: ifne +48 -> 568
    //   523: iconst_0
    //   524: istore_3
    //   525: ldc_w 1254
    //   528: invokestatic 1225	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   531: aload 7
    //   533: invokevirtual 1229	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   536: astore 9
    //   538: aload 9
    //   540: invokevirtual 1234	java/util/regex/Matcher:find	()Z
    //   543: ifeq +14 -> 557
    //   546: aload 9
    //   548: iconst_1
    //   549: invokevirtual 1237	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   552: iconst_0
    //   553: invokestatic 1257	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   556: istore_3
    //   557: iload_3
    //   558: aload 7
    //   560: ldc_w 1259
    //   563: iconst_1
    //   564: aload_1
    //   565: invokestatic 1199	com/tencent/mm/app/s:a	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   568: aload 13
    //   570: invokevirtual 836	java/io/File:delete	()Z
    //   573: pop
    //   574: goto -163 -> 411
    //   577: astore_1
    //   578: aload 8
    //   580: astore 7
    //   582: goto -239 -> 343
    //   585: astore 8
    //   587: aload 7
    //   589: aload 8
    //   591: invokevirtual 1262	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   594: goto -241 -> 353
    //   597: aload 14
    //   599: invokevirtual 1215	java/io/FileReader:close	()V
    //   602: goto -249 -> 353
    //   605: ldc 189
    //   607: ldc_w 1264
    //   610: iconst_2
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: lload 5
    //   618: invokestatic 477	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: invokestatic 662	java/lang/System:currentTimeMillis	()J
    //   627: lload 5
    //   629: lsub
    //   630: invokestatic 477	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   633: aastore
    //   634: invokestatic 740	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    if (cLT.endsWith(":push")) {}
    try
    {
      localObject2 = af.get("dalvik.vm.stack-trace-file");
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
    this.cLO = ((File)localObject2).getParent();
    if ((this.cLO == null) || (this.cLO.length() == 0)) {
      this.cLO = "/";
    }
    this.cLP = ((File)localObject2).getName();
    this.cLQ = new ConditionVariable();
    ad.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(localObject1)));
    this.cLN = new HashSet();
    this.cLK = new a(this.cLO);
    this.cLK.startWatching();
    CoreService.a(this);
    if (aj.cbe()) {
      paramContext.sendBroadcast(new Intent(paramContext, CrashUploadAlarmReceiver.class));
    }
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false, com.tencent.mm.sdk.platformtools.h.glW);
  }
  
  final void r(String paramString, int paramInt)
  {
    Recovery.anr();
    com.tencent.mm.plugin.report.service.h.vKh.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(26L, 0L, 1L, true);
    eB(paramString);
    Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
    com.tencent.mm.plugin.report.service.h.dkP();
    long l = System.currentTimeMillis();
    if (l - this.cLL < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.cLL = l;
      h.d(aj.getContext(), aj.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(a("", true, com.tencent.mm.sdk.platformtools.h.glW));
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
    } while (com.tencent.mm.plugin.q.d.cRq() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", ay.gNa.ao("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.q.d.cRq().I(aj.getContext(), paramString);
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
      //   6: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   9: invokestatic 28	com/tencent/mm/app/s:a	(Lcom/tencent/mm/app/s;)J
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
      //   28: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   31: getfield 34	com/tencent/mm/app/s:cLN	Ljava/util/HashSet;
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
      //   105: invokestatic 54	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   108: aload_0
      //   109: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   112: getfield 58	com/tencent/mm/app/s:cLQ	Landroid/os/ConditionVariable;
      //   115: invokevirtual 64	android/os/ConditionVariable:open	()V
      //   118: aload_0
      //   119: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   122: getfield 68	com/tencent/mm/app/s:cLV	Lcom/tencent/mm/app/s$b;
      //   125: ifnonnull +34 -> 159
      //   128: aload_0
      //   129: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   132: new 70	com/tencent/mm/app/s$b
      //   135: dup
      //   136: aload_0
      //   137: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   140: iconst_0
      //   141: invokespecial 73	com/tencent/mm/app/s$b:<init>	(Lcom/tencent/mm/app/s;B)V
      //   144: putfield 68	com/tencent/mm/app/s:cLV	Lcom/tencent/mm/app/s$b;
      //   147: aload_0
      //   148: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   151: getfield 68	com/tencent/mm/app/s:cLV	Lcom/tencent/mm/app/s$b;
      //   154: ldc 75
      //   156: invokestatic 81	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   159: aload_0
      //   160: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   163: getfield 34	com/tencent/mm/app/s:cLN	Ljava/util/HashSet;
      //   166: aload_2
      //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   170: pop
      //   171: goto -87 -> 84
      //   174: aload_0
      //   175: getfield 13	com/tencent/mm/app/s$a:cLY	Lcom/tencent/mm/app/s;
      //   178: getfield 34	com/tencent/mm/app/s:cLN	Ljava/util/HashSet;
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
    
    private static ActivityManager.ProcessErrorStateInfo KS()
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
        if (s.this.cLQ.block(10000L)) {
          s.this.cLQ.close();
        }
        try
        {
          Thread.sleep(500L);
          label46:
          Object localObject2 = KS();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = KS();
            localObject2 = ???;
            if (??? == null)
            {
              ad.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              s.this.cLV = null;
              return;
            }
          }
          ad.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (s.this.cLN)
            {
              localObject4 = new ArrayList(s.this.cLN.size());
              int i = s.this.cLP.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = s.this.cLP.substring(0, i) + '_' + str + s.this.cLP.substring(i);
                if (s.this.cLN.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (s.this.cLN.remove(s.this.cLP)) {
                ((ArrayList)localObject4).add(s.this.cLP);
              }
              ((ArrayList)localObject4).addAll(s.this.cLN);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = s.this.cLO + '/' + (String)localObject4;
                str = s.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  ad.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  s.this.r(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                ad.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                s.this.cLV = null;
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