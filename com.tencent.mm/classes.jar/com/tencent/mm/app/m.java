package com.tencent.mm.app;

import android.app.AppOpsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Process;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Base64;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.e.ad;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.c;
import com.tencent.mm.sdk.platformtools.ao.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import junit.framework.AssertionFailedError;

public class m
  implements com.tencent.mm.sdk.a.c, ao.d
{
  public static final long bYl = ;
  private static final Set<c.a> bYp = new HashSet();
  private static final String bYu;
  private static final String bYv;
  private static String bYw;
  private static final String bYx;
  private static long[] bYy = { 0L, 0L, 0L };
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  private ao bYm = null;
  private m.a bYn;
  private volatile long bYo = 0L;
  HashSet<String> bYq;
  String bYr;
  String bYs;
  ConditionVariable bYt;
  volatile m.b bYz;
  
  static
  {
    String str = q.LK();
    bYu = str;
    bYv = p.getString(str.hashCode());
    bYw = "";
    bYx = "version:" + com.tencent.mm.protocal.d.whH;
    sCrashExtraMessageGetter = new CrashMonitorForJni.a()
    {
      public final String Bt()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = ah.getProcessName();
        Object localObject2;
        if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
        {
          localStringBuilder.append("\n");
          localObject1 = WebView.getCrashExtraMessage(ah.getContext());
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION });
            localObject1 = localObject2;
            if (((String)localObject2).length() > 8192) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
            }
            localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
            ab.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
          }
        }
        localObject1 = m.Br().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.a)((Iterator)localObject1).next();
          localStringBuilder.append('\n').append(((c.a)localObject2).ayP());
        }
        return localStringBuilder.toString();
      }
    };
  }
  
  private static String Bm()
  {
    String str2 = av.flM.Y("login_weixin_username", "");
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = av.flM.Y("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static String Bn()
  {
    try
    {
      localObject2 = ad.get("dalvik.vm.stack-trace-file");
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
          ab.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
          str1 = "/data/anr/traces.txt";
        }
        Object localObject2 = str1;
      } while (new File(str1).isFile());
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = ah.getProcessName();
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
  
  private static String Bo()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.pgQ.bXk()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  private static String Bp()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.pgQ.bXl()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  private static String Bq()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.pgQ.bXm()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, android.app.ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 87	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 239	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 241	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc 243
    //   21: invokespecial 244	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: new 87	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 246
    //   32: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload_1
    //   36: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 248
    //   41: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 4
    //   51: ifnull +19 -> 70
    //   54: aload 9
    //   56: aload 4
    //   58: getfield 253	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   61: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 10
    //   66: invokevirtual 177	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 255	java/io/BufferedReader
    //   73: dup
    //   74: new 257	java/io/FileReader
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 258	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 261	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: iload 5
    //   89: istore_1
    //   90: aload 4
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: ifnull +249 -> 351
    //   105: iload_1
    //   106: tableswitch	default:+297 -> 403, 0:+26->132, 1:+99->205, 2:+159->265
    //   133: iconst_1
    //   134: astore_0
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -52 -> 90
    //   145: aload 4
    //   147: astore_0
    //   148: aload 11
    //   150: invokevirtual 153	java/lang/String:length	()I
    //   153: istore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 10
    //   160: aload 12
    //   162: iload 5
    //   164: iload 5
    //   166: bipush 19
    //   168: iadd
    //   169: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 271	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 276	java/util/Date:getTime	()J
    //   178: lload_2
    //   179: lsub
    //   180: lstore 6
    //   182: lload 6
    //   184: ldc2_w 277
    //   187: lcmp
    //   188: iflt -98 -> 90
    //   191: lload 6
    //   193: ldc2_w 279
    //   196: lcmp
    //   197: ifgt -107 -> 90
    //   200: iconst_1
    //   201: istore_1
    //   202: goto -112 -> 90
    //   205: aload 4
    //   207: astore_0
    //   208: aload 9
    //   210: aload 12
    //   212: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: bipush 10
    //   217: invokevirtual 177	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: astore_0
    //   224: aload 12
    //   226: ldc_w 282
    //   229: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   232: ifeq +8 -> 240
    //   235: iconst_2
    //   236: istore_1
    //   237: goto -147 -> 90
    //   240: aload 4
    //   242: astore_0
    //   243: aload 12
    //   245: ldc_w 284
    //   248: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   251: istore 8
    //   253: iload 8
    //   255: ifeq -165 -> 90
    //   258: aload 4
    //   260: invokevirtual 287	java/io/BufferedReader:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: aload 4
    //   267: astore_0
    //   268: aload 12
    //   270: ldc_w 289
    //   273: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   276: ifeq +25 -> 301
    //   279: aload 4
    //   281: astore_0
    //   282: aload 9
    //   284: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 9
    //   289: aload 4
    //   291: invokevirtual 287	java/io/BufferedReader:close	()V
    //   294: aload 9
    //   296: areturn
    //   297: astore_0
    //   298: aload 9
    //   300: areturn
    //   301: aload 4
    //   303: astore_0
    //   304: aload 9
    //   306: aload 12
    //   308: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: bipush 10
    //   313: invokevirtual 177	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: goto -227 -> 90
    //   320: astore 9
    //   322: aload 4
    //   324: astore_0
    //   325: ldc 188
    //   327: aload 9
    //   329: ldc_w 291
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: aload 4
    //   341: ifnull +8 -> 349
    //   344: aload 4
    //   346: invokevirtual 287	java/io/BufferedReader:close	()V
    //   349: aconst_null
    //   350: areturn
    //   351: aload 4
    //   353: invokevirtual 287	java/io/BufferedReader:close	()V
    //   356: goto -7 -> 349
    //   359: astore_0
    //   360: goto -11 -> 349
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_0
    //   367: aload_0
    //   368: ifnull +7 -> 375
    //   371: aload_0
    //   372: invokevirtual 287	java/io/BufferedReader:close	()V
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
    //   0	406	4	paramProcessErrorStateInfo	android.app.ActivityManager.ProcessErrorStateInfo
    //   1	168	5	i	int
    //   180	12	6	l	long
    //   251	3	8	bool	boolean
    //   13	292	9	localObject	Object
    //   320	8	9	localException1	Exception
    //   395	1	9	localException2	Exception
    //   24	135	10	localSimpleDateFormat	java.text.SimpleDateFormat
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
  
  public static void a(ao.c paramc)
  {
    ao.a(paramc);
  }
  
  private static void b(int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramInt == 6) {}
    try
    {
      String str = Bn();
      localObject = localStringBuilder;
      if (str != null) {
        localObject = a(str, Process.myPid(), System.currentTimeMillis(), null);
      }
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("#[jin_crash]sig=").append(paramInt).append('\n');
      localStringBuilder.append("#crash.previous=").append(paramBoolean).append('\n');
      localStringBuilder.append(l("", false));
      localStringBuilder.append(paramString).append('\n');
      if (localObject != null)
      {
        localStringBuilder.append("******* ANR Trace *******\n");
        localStringBuilder.append((String)localObject);
      }
      paramString = localStringBuilder.toString();
      if (paramInt == 6) {}
      for (paramInt = 0;; paramInt = 8192)
      {
        c(paramString, paramInt, true);
        ab.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!paramBoolean) {
          ab.appenderClose();
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed reporting JNI crash.", new Object[0]);
    }
  }
  
  private static void c(String paramString, int paramInt, boolean paramBoolean)
  {
    dx(paramString);
    h.qsU.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    h.qsU.idkeyStat(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (ah.getProcessName().endsWith(":push"))
    {
      h.qsU.idkeyStat(25L, 2L, 1L, true);
      localObject = h.qsU;
      h.chS();
      localObject = paramString;
      if (f.ba(ah.getContext()) == 1)
      {
        int i = f.bb(ah.getContext());
        ab.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[] { Integer.valueOf(i) });
        localObject = paramString;
        if (paramString.length() > i) {
          localObject = paramString.substring(0, i);
        }
      }
      localContext = ah.getContext();
      str = ah.getProcessName();
      if (!paramBoolean) {
        break label353;
      }
    }
    label353:
    for (paramString = "jni";; paramString = "java")
    {
      f.e(localContext, str, paramString);
      paramString = (String)localObject;
      if (paramInt > 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).length() > paramInt) {
          paramString = ((String)localObject).substring(0, paramInt);
        }
      }
      if (com.tencent.mm.plugin.p.d.bSu() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", Bm());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.p.d.bSu().v(ah.getContext(), (Intent)localObject);
      }
      return;
      if ((ah.dsX()) || (ah.dsX()))
      {
        h.qsU.idkeyStat(25L, 3L, 1L, true);
        break;
      }
      if (ah.getProcessName().endsWith(":exdevice"))
      {
        h.qsU.idkeyStat(25L, 4L, 1L, true);
        break;
      }
      if (!ah.brt()) {
        break;
      }
      h.qsU.idkeyStat(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean dw(String paramString)
  {
    Object localObject4 = null;
    bYw = paramString;
    if (com.tencent.mm.plugin.p.d.bSu() == null) {}
    try
    {
      localObject1 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException4)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ah.getContext().getClassLoader());
        localObject4 = localClass;
        ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + bYw);
        ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + bYw);
        localObject1 = com.tencent.mm.bq.d.ia("sandbox", ".SubCoreSandBox");
        ab.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + bYw);
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
            ab.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + bYw);
            try
            {
              localObject1 = (com.tencent.mm.sdk.a.c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((com.tencent.mm.sdk.a.c)localObject1).bc(ah.getContext());
              av.flM.Y("last_login_uin", bYv);
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject1);
              new m.2();
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              ab.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              Object localObject3 = new m();
              ((m)localObject3).bc(ah.getContext());
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject3);
              localObject3 = ad.get("ro.product.cpu.abi");
              if ((localObject3 != null) && (((String)localObject3).length() != 0) && ((((String)localObject3).equals("x86")) || (((String)localObject3).equals("x86-64")))) {
                break label527;
              }
              k.a("wechatCrashForJni", m.class.getClassLoader());
              localObject4 = bYx;
              if ((paramString.contains(":tools")) || (paramString.contains(":appbrand"))) {
                break;
              }
              localObject3 = localObject4;
              if (!paramString.contains(":support")) {
                break label517;
              }
              localObject3 = (String)localObject4 + "\n" + WebView.getCrashExtraMessage(ah.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION }) + "\n";
              ab.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
              CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
              CrashMonitorForJni.setClientVersionMsg((String)localObject3);
              cf.pK(e.eQv);
            }
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", localException1, "setup sanbox Failed printing stack trace1.", new Object[0]);
            localObject2 = null;
          }
          localException4 = localException4;
          ab.printErrStackTrace("MicroMsg.MMCrashReporter", localException4, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", localException2, "", new Object[0]);
            ab.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
          }
        }
      }
    }
    label517:
    label527:
    return false;
  }
  
  private static void dx(String paramString)
  {
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i) {
          break;
        }
        ab.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      ab.e("MicroMsg.MMCrashReporter", paramString);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  /* Error */
  private static String l(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: sipush 256
    //   7: invokespecial 239	java/lang/StringBuilder:<init>	(I)V
    //   10: astore 13
    //   12: new 640	android/util/StringBuilderPrinter
    //   15: dup
    //   16: aload 13
    //   18: invokespecial 643	android/util/StringBuilderPrinter:<init>	(Ljava/lang/StringBuilder;)V
    //   21: astore 14
    //   23: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   26: astore 11
    //   28: aload 14
    //   30: new 87	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 645
    //   37: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: getstatic 98	com/tencent/mm/protocal/d:whH	I
    //   43: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   52: aload 14
    //   54: new 87	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 650
    //   61: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: invokestatic 653	com/tencent/mm/model/cf:abt	()Ljava/lang/String;
    //   67: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   76: aload 14
    //   78: new 87	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 655
    //   85: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: iconst_1
    //   89: invokestatic 659	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   92: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   101: aload 14
    //   103: new 87	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 661
    //   110: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: getstatic 664	com/tencent/mm/sdk/platformtools/f:REV	Ljava/lang/String;
    //   116: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   125: aload 14
    //   127: new 87	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 666
    //   134: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: getstatic 125	com/tencent/mm/model/av:flM	Lcom/tencent/mm/model/av;
    //   140: ldc_w 526
    //   143: getstatic 81	com/tencent/mm/app/m:bYv	Ljava/lang/String;
    //   146: invokevirtual 131	com/tencent/mm/model/av:Y	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   149: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   158: aload 14
    //   160: new 87	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 668
    //   167: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: getstatic 67	com/tencent/mm/app/m:bYu	Ljava/lang/String;
    //   173: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   182: aload 14
    //   184: new 87	java/lang/StringBuilder
    //   187: dup
    //   188: ldc_w 670
    //   191: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: invokestatic 50	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   197: getstatic 52	com/tencent/mm/app/m:bYl	J
    //   200: lsub
    //   201: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc_w 675
    //   207: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: getstatic 85	com/tencent/mm/app/m:bYw	Ljava/lang/String;
    //   213: invokestatic 678	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 680
    //   222: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   231: aload 14
    //   233: new 87	java/lang/StringBuilder
    //   236: dup
    //   237: ldc_w 682
    //   240: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: getstatic 685	com/tencent/mm/sdk/platformtools/f:TIME	Ljava/lang/String;
    //   246: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 687
    //   252: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: getstatic 690	com/tencent/mm/sdk/platformtools/f:HOSTNAME	Ljava/lang/String;
    //   258: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 687
    //   264: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 695	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   270: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   279: aload 14
    //   281: new 87	java/lang/StringBuilder
    //   284: dup
    //   285: ldc_w 697
    //   288: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload 11
    //   293: invokestatic 700	com/tencent/xweb/WebView:getInstalledTbsCoreVersion	(Landroid/content/Context;)I
    //   296: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   305: aload 14
    //   307: new 87	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 702
    //   314: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 11
    //   319: invokestatic 705	com/tencent/xweb/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   322: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   331: aload 14
    //   333: new 87	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 707
    //   340: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: invokestatic 709	com/tencent/mm/app/m:Bq	()Ljava/lang/String;
    //   346: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   355: aload 14
    //   357: new 87	java/lang/StringBuilder
    //   360: dup
    //   361: ldc_w 711
    //   364: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   367: invokestatic 713	com/tencent/mm/app/m:Bo	()Ljava/lang/String;
    //   370: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   379: aload 14
    //   381: new 87	java/lang/StringBuilder
    //   384: dup
    //   385: ldc_w 715
    //   388: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: invokestatic 717	com/tencent/mm/app/m:Bp	()Ljava/lang/String;
    //   394: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   403: aload 14
    //   405: ldc_w 719
    //   408: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   411: aload 14
    //   413: new 87	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 721
    //   420: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   426: invokestatic 726	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersion	(Landroid/content/Context;)I
    //   429: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   438: aload 14
    //   440: new 87	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 728
    //   447: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: invokestatic 731	org/xwalk/core/XWalkEnvironment:safeGetChromiunVersion	()I
    //   453: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   462: ldc 188
    //   464: ldc_w 733
    //   467: iconst_1
    //   468: anewarray 4	java/lang/Object
    //   471: dup
    //   472: iconst_0
    //   473: invokestatic 738	com/tencent/mm/ac/a:SU	()Ljava/lang/String;
    //   476: aastore
    //   477: invokestatic 393	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   483: ldc_w 740
    //   486: iconst_4
    //   487: invokevirtual 744	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   490: ldc_w 746
    //   493: aconst_null
    //   494: invokeinterface 750 3 0
    //   499: astore 10
    //   501: aload 10
    //   503: ifnull +54 -> 557
    //   506: aload 14
    //   508: ldc_w 752
    //   511: aload 10
    //   513: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   516: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   519: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   522: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   525: ldc_w 740
    //   528: iconst_4
    //   529: invokevirtual 744	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   532: invokeinterface 762 1 0
    //   537: astore 10
    //   539: aload 10
    //   541: ldc_w 746
    //   544: invokeinterface 768 2 0
    //   549: pop
    //   550: aload 10
    //   552: invokeinterface 771 1 0
    //   557: iload_1
    //   558: ifeq +16 -> 574
    //   561: aload 14
    //   563: getstatic 110	com/tencent/mm/app/m:sCrashExtraMessageGetter	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$a;
    //   566: invokeinterface 776 1 0
    //   571: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   574: new 87	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 778
    //   581: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: astore 12
    //   586: getstatic 782	com/tencent/mm/sdk/a/b:foreground	Z
    //   589: ifeq +910 -> 1499
    //   592: ldc_w 784
    //   595: astore 10
    //   597: aload 14
    //   599: aload 12
    //   601: aload 10
    //   603: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc_w 687
    //   609: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokestatic 790	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   615: invokevirtual 793	java/lang/Thread:getName	()Ljava/lang/String;
    //   618: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc_w 687
    //   624: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: getstatic 796	com/tencent/mm/sdk/a/b:ymf	Ljava/lang/String;
    //   630: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   639: invokestatic 802	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   642: astore 10
    //   644: new 804	android/os/StatFs
    //   647: dup
    //   648: aload 10
    //   650: invokevirtual 807	java/io/File:getPath	()Ljava/lang/String;
    //   653: invokespecial 808	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   656: astore 12
    //   658: new 804	android/os/StatFs
    //   661: dup
    //   662: getstatic 811	com/tencent/mm/compatible/util/e:eQx	Ljava/lang/String;
    //   665: invokespecial 808	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   668: astore 15
    //   670: aload 11
    //   672: ldc_w 813
    //   675: invokevirtual 817	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   678: checkcast 819	android/app/ActivityManager
    //   681: invokevirtual 822	android/app/ActivityManager:getMemoryClass	()I
    //   684: istore_2
    //   685: aload 11
    //   687: ldc_w 813
    //   690: invokevirtual 817	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   693: checkcast 819	android/app/ActivityManager
    //   696: invokevirtual 825	android/app/ActivityManager:getLargeMemoryClass	()I
    //   699: istore_3
    //   700: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   703: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   706: invokevirtual 828	android/content/Context:getPackageName	()Ljava/lang/String;
    //   709: invokestatic 832	com/tencent/mm/app/m:s	(Landroid/content/Context;Ljava/lang/String;)V
    //   712: ldc_w 834
    //   715: bipush 13
    //   717: anewarray 4	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: iload_2
    //   723: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   726: aastore
    //   727: dup
    //   728: iconst_1
    //   729: iload_3
    //   730: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   733: aastore
    //   734: dup
    //   735: iconst_2
    //   736: aload 10
    //   738: invokevirtual 837	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   741: aastore
    //   742: dup
    //   743: iconst_3
    //   744: aload 12
    //   746: invokevirtual 840	android/os/StatFs:getBlockSize	()I
    //   749: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   752: aastore
    //   753: dup
    //   754: iconst_4
    //   755: aload 12
    //   757: invokevirtual 843	android/os/StatFs:getBlockCount	()I
    //   760: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: aastore
    //   764: dup
    //   765: iconst_5
    //   766: aload 12
    //   768: invokevirtual 846	android/os/StatFs:getAvailableBlocks	()I
    //   771: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: dup
    //   776: bipush 6
    //   778: getstatic 112	com/tencent/mm/app/m:bYy	[J
    //   781: iconst_0
    //   782: laload
    //   783: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   786: aastore
    //   787: dup
    //   788: bipush 7
    //   790: getstatic 112	com/tencent/mm/app/m:bYy	[J
    //   793: iconst_1
    //   794: laload
    //   795: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   798: aastore
    //   799: dup
    //   800: bipush 8
    //   802: getstatic 112	com/tencent/mm/app/m:bYy	[J
    //   805: iconst_2
    //   806: laload
    //   807: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   810: aastore
    //   811: dup
    //   812: bipush 9
    //   814: getstatic 811	com/tencent/mm/compatible/util/e:eQx	Ljava/lang/String;
    //   817: aastore
    //   818: dup
    //   819: bipush 10
    //   821: aload 15
    //   823: invokevirtual 840	android/os/StatFs:getBlockSize	()I
    //   826: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   829: aastore
    //   830: dup
    //   831: bipush 11
    //   833: aload 15
    //   835: invokevirtual 843	android/os/StatFs:getBlockCount	()I
    //   838: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   841: aastore
    //   842: dup
    //   843: bipush 12
    //   845: aload 15
    //   847: invokevirtual 846	android/os/StatFs:getAvailableBlocks	()I
    //   850: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: aastore
    //   854: invokestatic 854	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   857: astore 10
    //   859: aload 14
    //   861: ldc_w 856
    //   864: aload 10
    //   866: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   869: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   872: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   875: new 273	java/util/Date
    //   878: dup
    //   879: invokespecial 857	java/util/Date:<init>	()V
    //   882: astore 10
    //   884: new 241	java/text/SimpleDateFormat
    //   887: dup
    //   888: ldc_w 859
    //   891: invokestatic 863	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   894: invokespecial 866	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   897: astore 11
    //   899: aload 14
    //   901: new 87	java/lang/StringBuilder
    //   904: dup
    //   905: ldc_w 868
    //   908: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   911: aload 11
    //   913: aload 10
    //   915: invokevirtual 871	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   918: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   927: invokestatic 378	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   930: ldc_w 813
    //   933: invokevirtual 817	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   936: checkcast 819	android/app/ActivityManager
    //   939: astore 15
    //   941: new 873	android/app/ActivityManager$MemoryInfo
    //   944: dup
    //   945: invokespecial 874	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   948: astore 16
    //   950: aload 15
    //   952: aload 16
    //   954: invokevirtual 878	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   957: lconst_0
    //   958: lstore 6
    //   960: bipush 16
    //   962: invokestatic 884	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   965: ifeq +571 -> 1536
    //   968: aload 16
    //   970: getfield 887	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   973: lstore 4
    //   975: new 87	java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   982: ldc 83
    //   984: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: ldc_w 889
    //   990: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: lload 4
    //   995: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   998: ldc_w 891
    //   1001: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 16
    //   1006: getfield 894	android/app/ActivityManager$MemoryInfo:availMem	J
    //   1009: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1012: ldc_w 891
    //   1015: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 16
    //   1020: getfield 897	android/app/ActivityManager$MemoryInfo:threshold	J
    //   1023: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1026: ldc_w 891
    //   1029: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload 16
    //   1034: getfield 900	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   1037: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1040: ldc_w 902
    //   1043: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: astore 10
    //   1051: new 87	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1058: aload 10
    //   1060: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 904
    //   1066: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokestatic 909	android/os/Debug:getNativeHeapSize	()J
    //   1072: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1075: ldc_w 891
    //   1078: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokestatic 912	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   1084: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1087: ldc_w 891
    //   1090: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokestatic 915	android/os/Debug:getNativeHeapFreeSize	()J
    //   1096: invokevirtual 673	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1099: ldc_w 902
    //   1102: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: astore 10
    //   1110: iconst_1
    //   1111: newarray int
    //   1113: astore 11
    //   1115: aload 11
    //   1117: iconst_0
    //   1118: invokestatic 305	android/os/Process:myPid	()I
    //   1121: iastore
    //   1122: aload 15
    //   1124: aload 11
    //   1126: invokevirtual 919	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   1129: astore 12
    //   1131: aload 12
    //   1133: ifnull +625 -> 1758
    //   1136: aload 12
    //   1138: arraylength
    //   1139: ifle +619 -> 1758
    //   1142: aload 12
    //   1144: iconst_0
    //   1145: aaload
    //   1146: ifnull +612 -> 1758
    //   1149: aload 12
    //   1151: iconst_0
    //   1152: aaload
    //   1153: astore 12
    //   1155: new 87	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1162: aload 10
    //   1164: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: ldc_w 921
    //   1170: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 11
    //   1175: iconst_0
    //   1176: iaload
    //   1177: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1180: ldc_w 923
    //   1183: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload 12
    //   1188: invokevirtual 928	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   1191: bipush 10
    //   1193: ishl
    //   1194: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: ldc_w 891
    //   1200: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: aload 12
    //   1205: invokevirtual 931	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   1208: bipush 10
    //   1210: ishl
    //   1211: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1214: ldc_w 891
    //   1217: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: aload 12
    //   1222: invokevirtual 934	android/os/Debug$MemoryInfo:getTotalSharedDirty	()I
    //   1225: bipush 10
    //   1227: ishl
    //   1228: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1231: ldc_w 902
    //   1234: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: astore 10
    //   1242: invokestatic 940	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1245: invokevirtual 943	java/lang/Runtime:totalMemory	()J
    //   1248: lstore 4
    //   1250: invokestatic 940	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1253: invokevirtual 946	java/lang/Runtime:freeMemory	()J
    //   1256: lstore 6
    //   1258: ldc_w 948
    //   1261: iconst_5
    //   1262: anewarray 4	java/lang/Object
    //   1265: dup
    //   1266: iconst_0
    //   1267: lload 4
    //   1269: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1272: aastore
    //   1273: dup
    //   1274: iconst_1
    //   1275: lload 6
    //   1277: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1280: aastore
    //   1281: dup
    //   1282: iconst_2
    //   1283: lload 4
    //   1285: lload 6
    //   1287: lsub
    //   1288: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_3
    //   1294: invokestatic 940	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1297: invokevirtual 951	java/lang/Runtime:maxMemory	()J
    //   1300: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1303: aastore
    //   1304: dup
    //   1305: iconst_4
    //   1306: invokestatic 956	com/tencent/mars/xlog/LogLogic:getVmSize	()Ljava/lang/String;
    //   1309: aastore
    //   1310: invokestatic 854	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1313: astore 11
    //   1315: new 87	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1322: aload 10
    //   1324: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: aload 11
    //   1329: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: astore 11
    //   1337: invokestatic 961	com/tencent/mm/plugin/performance/b/b:zq	()I
    //   1340: istore_2
    //   1341: aload 11
    //   1343: astore 10
    //   1345: iload_2
    //   1346: sipush 260
    //   1349: if_icmple +67 -> 1416
    //   1352: new 226	java/util/LinkedList
    //   1355: dup
    //   1356: invokespecial 962	java/util/LinkedList:<init>	()V
    //   1359: astore 10
    //   1361: aload 10
    //   1363: invokestatic 966	com/tencent/mm/plugin/performance/b/b:cw	(Ljava/util/List;)I
    //   1366: istore_3
    //   1367: new 87	java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1374: aload 11
    //   1376: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w 968
    //   1382: iconst_3
    //   1383: anewarray 4	java/lang/Object
    //   1386: dup
    //   1387: iconst_0
    //   1388: iload_3
    //   1389: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1392: aastore
    //   1393: dup
    //   1394: iconst_1
    //   1395: iload_2
    //   1396: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_2
    //   1402: aload 10
    //   1404: aastore
    //   1405: invokestatic 854	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1408: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: astore 10
    //   1416: aload 14
    //   1418: ldc_w 970
    //   1421: aload 10
    //   1423: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1426: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1429: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1432: aload_0
    //   1433: invokestatic 135	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1436: ifne +18 -> 1454
    //   1439: aload 14
    //   1441: ldc_w 972
    //   1444: aload_0
    //   1445: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1448: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1451: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1454: aload 14
    //   1456: ldc_w 974
    //   1459: invokevirtual 648	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1462: aload 13
    //   1464: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: areturn
    //   1468: astore 10
    //   1470: ldc 188
    //   1472: new 87	java/lang/StringBuilder
    //   1475: dup
    //   1476: ldc_w 976
    //   1479: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1482: aload 10
    //   1484: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1487: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokestatic 335	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1496: goto -1034 -> 462
    //   1499: ldc_w 977
    //   1502: astore 10
    //   1504: goto -907 -> 597
    //   1507: astore 10
    //   1509: ldc 188
    //   1511: ldc_w 979
    //   1514: iconst_1
    //   1515: anewarray 4	java/lang/Object
    //   1518: dup
    //   1519: iconst_0
    //   1520: aload 10
    //   1522: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1525: aastore
    //   1526: invokestatic 981	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1529: ldc 83
    //   1531: astore 10
    //   1533: goto -674 -> 859
    //   1536: new 983	java/io/RandomAccessFile
    //   1539: dup
    //   1540: ldc_w 985
    //   1543: ldc_w 987
    //   1546: invokespecial 989	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1549: astore 11
    //   1551: aload 11
    //   1553: astore 10
    //   1555: new 991	java/lang/StringBuffer
    //   1558: dup
    //   1559: invokespecial 992	java/lang/StringBuffer:<init>	()V
    //   1562: astore 12
    //   1564: aload 11
    //   1566: astore 10
    //   1568: aload 11
    //   1570: invokevirtual 993	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   1573: invokevirtual 997	java/lang/String:toCharArray	()[C
    //   1576: astore 17
    //   1578: aload 11
    //   1580: astore 10
    //   1582: aload 17
    //   1584: arraylength
    //   1585: istore_3
    //   1586: iconst_0
    //   1587: istore_2
    //   1588: iload_2
    //   1589: iload_3
    //   1590: if_icmpge +38 -> 1628
    //   1593: aload 17
    //   1595: iload_2
    //   1596: caload
    //   1597: bipush 57
    //   1599: if_icmpgt +162 -> 1761
    //   1602: aload 17
    //   1604: iload_2
    //   1605: caload
    //   1606: bipush 48
    //   1608: if_icmplt +153 -> 1761
    //   1611: aload 11
    //   1613: astore 10
    //   1615: aload 12
    //   1617: aload 17
    //   1619: iload_2
    //   1620: caload
    //   1621: invokevirtual 1000	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1624: pop
    //   1625: goto +136 -> 1761
    //   1628: aload 11
    //   1630: astore 10
    //   1632: aload 12
    //   1634: invokevirtual 1001	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1637: ldc2_w 1002
    //   1640: invokestatic 1007	com/tencent/mm/sdk/platformtools/bo:getLong	(Ljava/lang/String;J)J
    //   1643: lstore 8
    //   1645: lload 6
    //   1647: lstore 4
    //   1649: lload 8
    //   1651: lconst_0
    //   1652: lcmp
    //   1653: ifle +10 -> 1663
    //   1656: lload 8
    //   1658: bipush 10
    //   1660: lshl
    //   1661: lstore 4
    //   1663: aload 11
    //   1665: invokevirtual 1008	java/io/RandomAccessFile:close	()V
    //   1668: goto -693 -> 975
    //   1671: astore 10
    //   1673: goto -698 -> 975
    //   1676: astore 12
    //   1678: aconst_null
    //   1679: astore 11
    //   1681: aload 11
    //   1683: astore 10
    //   1685: ldc 188
    //   1687: aload 12
    //   1689: ldc 83
    //   1691: iconst_0
    //   1692: anewarray 4	java/lang/Object
    //   1695: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1698: lload 6
    //   1700: lstore 4
    //   1702: aload 11
    //   1704: ifnull -729 -> 975
    //   1707: aload 11
    //   1709: invokevirtual 1008	java/io/RandomAccessFile:close	()V
    //   1712: lload 6
    //   1714: lstore 4
    //   1716: goto -741 -> 975
    //   1719: astore 10
    //   1721: lload 6
    //   1723: lstore 4
    //   1725: goto -750 -> 975
    //   1728: astore_0
    //   1729: aconst_null
    //   1730: astore 10
    //   1732: aload 10
    //   1734: ifnull +8 -> 1742
    //   1737: aload 10
    //   1739: invokevirtual 1008	java/io/RandomAccessFile:close	()V
    //   1742: aload_0
    //   1743: athrow
    //   1744: astore 10
    //   1746: goto -4 -> 1742
    //   1749: astore_0
    //   1750: goto -18 -> 1732
    //   1753: astore 12
    //   1755: goto -74 -> 1681
    //   1758: goto -516 -> 1242
    //   1761: iload_2
    //   1762: iconst_1
    //   1763: iadd
    //   1764: istore_2
    //   1765: goto -177 -> 1588
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1768	0	paramString	String
    //   0	1768	1	paramBoolean	boolean
    //   684	1081	2	i	int
    //   699	892	3	j	int
    //   973	751	4	l1	long
    //   958	764	6	l2	long
    //   1643	14	8	l3	long
    //   499	923	10	localObject1	Object
    //   1468	15	10	localException1	Exception
    //   1502	1	10	str	String
    //   1507	14	10	localException2	Exception
    //   1531	100	10	localObject2	Object
    //   1671	1	10	localException3	Exception
    //   1683	1	10	localObject3	Object
    //   1719	1	10	localException4	Exception
    //   1730	8	10	localObject4	Object
    //   1744	1	10	localException5	Exception
    //   26	1682	11	localObject5	Object
    //   584	1049	12	localObject6	Object
    //   1676	12	12	localException6	Exception
    //   1753	1	12	localException7	Exception
    //   10	1453	13	localStringBuilder	StringBuilder
    //   21	1434	14	localStringBuilderPrinter	android.util.StringBuilderPrinter
    //   668	455	15	localObject7	Object
    //   948	85	16	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   1576	42	17	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   411	462	1468	java/lang/Exception
    //   639	859	1507	java/lang/Exception
    //   1663	1668	1671	java/lang/Exception
    //   1536	1551	1676	java/lang/Exception
    //   1707	1712	1719	java/lang/Exception
    //   1536	1551	1728	finally
    //   1737	1742	1744	java/lang/Exception
    //   1555	1564	1749	finally
    //   1568	1578	1749	finally
    //   1582	1586	1749	finally
    //   1615	1625	1749	finally
    //   1632	1645	1749	finally
    //   1685	1698	1749	finally
    //   1555	1564	1753	java/lang/Exception
    //   1568	1578	1753	java/lang/Exception
    //   1582	1586	1753	java/lang/Exception
    //   1615	1625	1753	java/lang/Exception
    //   1632	1645	1753	java/lang/Exception
  }
  
  private static void s(Context arg0, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      synchronized (bYy)
      {
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(???.getPackageManager(), new Object[] { paramString, new m.4() });
          bYy.wait(500L);
          return;
        }
        catch (Exception ???)
        {
          for (;;)
          {
            bYy[0] = -1L;
            bYy[1] = -1L;
            bYy[2] = -1L;
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "crash e:", new Object[0]);
            synchronized (bYy)
            {
              bYy.notify();
            }
          }
        }
      }
    }
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
          bYy[0] = ???.getCacheBytes();
          bYy[1] = ???.getDataBytes();
          bYy[2] = ???.getAppBytes();
          ab.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool), Long.valueOf(bYy[0]), Long.valueOf(bYy[1]), Long.valueOf(bYy[2]), bo.dtY() });
          return;
          bool = false;
          continue;
          if (k == 0) {}
          for (bool = true;; bool = false) {
            break;
          }
          paramString = paramString;
          ab.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "summer getStats crash1 e:", new Object[0]);
        }
        catch (Exception ???)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MMCrashReporter", ???, "summer getStats crash2 e:", new Object[0]);
            ??? = null;
          }
        }
      }
    }
  }
  
  public final void G(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.p.d.bSu() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", Bm());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.p.d.bSu().v(ah.getContext(), localIntent);
    }
  }
  
  public final void a(a parama)
  {
    ao.a(parama);
  }
  
  public final void a(c.a parama)
  {
    if (parama == null) {
      return;
    }
    bYp.add(parama);
  }
  
  public final void a(ao paramao, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str = paramThrowable.getMessage();
      if (!bo.isNullOrNil(str))
      {
        paramao = paramao.apo(str);
        if (bo.isNullOrNil(paramao)) {}
      }
    }
    for (;;)
    {
      x.f(paramThrowable);
      c(l(paramao, true) + paramString, 0, false);
      return;
      paramao = "";
    }
  }
  
  /* Error */
  public final void bc(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1140	com/tencent/mm/sdk/platformtools/ao:a	(Lcom/tencent/mm/sdk/platformtools/ao$d;)V
    //   4: getstatic 85	com/tencent/mm/app/m:bYw	Ljava/lang/String;
    //   7: ldc_w 366
    //   10: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   13: ifeq +584 -> 597
    //   16: ldc 144
    //   18: invokestatic 150	com/tencent/mm/compatible/e/ad:get	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnull +15 -> 40
    //   28: aload 8
    //   30: astore 7
    //   32: aload 8
    //   34: invokevirtual 153	java/lang/String:length	()I
    //   37: ifne +7 -> 44
    //   40: ldc 155
    //   42: astore 7
    //   44: new 181	java/io/File
    //   47: dup
    //   48: aload 7
    //   50: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: aload_0
    //   56: aload 8
    //   58: invokevirtual 1143	java/io/File:getParent	()Ljava/lang/String;
    //   61: putfield 1145	com/tencent/mm/app/m:bYr	Ljava/lang/String;
    //   64: aload_0
    //   65: getfield 1145	com/tencent/mm/app/m:bYr	Ljava/lang/String;
    //   68: ifnull +13 -> 81
    //   71: aload_0
    //   72: getfield 1145	com/tencent/mm/app/m:bYr	Ljava/lang/String;
    //   75: invokevirtual 153	java/lang/String:length	()I
    //   78: ifne +10 -> 88
    //   81: aload_0
    //   82: ldc_w 1147
    //   85: putfield 1145	com/tencent/mm/app/m:bYr	Ljava/lang/String;
    //   88: aload_0
    //   89: aload 8
    //   91: invokevirtual 1148	java/io/File:getName	()Ljava/lang/String;
    //   94: putfield 1150	com/tencent/mm/app/m:bYs	Ljava/lang/String;
    //   97: aload_0
    //   98: new 1152	android/os/ConditionVariable
    //   101: dup
    //   102: invokespecial 1153	android/os/ConditionVariable:<init>	()V
    //   105: putfield 1155	com/tencent/mm/app/m:bYt	Landroid/os/ConditionVariable;
    //   108: ldc 188
    //   110: ldc_w 1157
    //   113: aload 7
    //   115: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokestatic 495	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: new 54	java/util/HashSet
    //   128: dup
    //   129: invokespecial 57	java/util/HashSet:<init>	()V
    //   132: putfield 1159	com/tencent/mm/app/m:bYq	Ljava/util/HashSet;
    //   135: aload_0
    //   136: new 12	com/tencent/mm/app/m$a
    //   139: dup
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 1145	com/tencent/mm/app/m:bYr	Ljava/lang/String;
    //   145: invokespecial 1162	com/tencent/mm/app/m$a:<init>	(Lcom/tencent/mm/app/m;Ljava/lang/String;)V
    //   148: putfield 1164	com/tencent/mm/app/m:bYn	Lcom/tencent/mm/app/m$a;
    //   151: aload_0
    //   152: getfield 1164	com/tencent/mm/app/m:bYn	Lcom/tencent/mm/app/m$a;
    //   155: invokevirtual 1167	com/tencent/mm/app/m$a:startWatching	()V
    //   158: new 181	java/io/File
    //   161: dup
    //   162: aload_1
    //   163: invokevirtual 1170	android/content/Context:getFilesDir	()Ljava/io/File;
    //   166: ldc_w 1172
    //   169: invokespecial 1175	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   172: new 1177	com/tencent/mm/app/m$3
    //   175: dup
    //   176: aload_0
    //   177: aload_1
    //   178: invokespecial 1180	com/tencent/mm/app/m$3:<init>	(Lcom/tencent/mm/app/m;Landroid/content/Context;)V
    //   181: invokevirtual 1184	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnull +409 -> 597
    //   191: new 87	java/lang/StringBuilder
    //   194: dup
    //   195: sipush 16384
    //   198: invokespecial 239	java/lang/StringBuilder:<init>	(I)V
    //   201: astore 10
    //   203: ldc_w 1186
    //   206: invokestatic 1192	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   209: astore 11
    //   211: aload 9
    //   213: arraylength
    //   214: istore 5
    //   216: iconst_0
    //   217: istore_2
    //   218: iload_2
    //   219: iload 5
    //   221: if_icmpge +376 -> 597
    //   224: aload 9
    //   226: iload_2
    //   227: aaload
    //   228: astore 12
    //   230: iconst_m1
    //   231: istore_3
    //   232: ldc 188
    //   234: ldc_w 1194
    //   237: aload 12
    //   239: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   242: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   245: invokestatic 495	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: new 87	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 1194
    //   255: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload 12
    //   260: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 12
    //   266: invokevirtual 1148	java/io/File:getName	()Ljava/lang/String;
    //   269: ldc_w 1196
    //   272: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   275: istore 6
    //   277: new 255	java/io/BufferedReader
    //   280: dup
    //   281: new 257	java/io/FileReader
    //   284: dup
    //   285: aload 12
    //   287: invokespecial 1199	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   290: invokespecial 261	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   293: astore 7
    //   295: aload 7
    //   297: astore_1
    //   298: aload 10
    //   300: iconst_0
    //   301: invokevirtual 1202	java/lang/StringBuilder:setLength	(I)V
    //   304: aload 7
    //   306: astore_1
    //   307: aload 7
    //   309: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   312: astore 8
    //   314: aload 8
    //   316: ifnull +145 -> 461
    //   319: iload_3
    //   320: istore 4
    //   322: iload_3
    //   323: ifge +44 -> 367
    //   326: aload 7
    //   328: astore_1
    //   329: aload 11
    //   331: aload 8
    //   333: invokevirtual 1206	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   336: astore 13
    //   338: iload_3
    //   339: istore 4
    //   341: aload 7
    //   343: astore_1
    //   344: aload 13
    //   346: invokevirtual 1211	java/util/regex/Matcher:matches	()Z
    //   349: ifeq +18 -> 367
    //   352: aload 7
    //   354: astore_1
    //   355: aload 13
    //   357: iconst_1
    //   358: invokevirtual 1214	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   361: iconst_0
    //   362: invokestatic 1217	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   365: istore 4
    //   367: aload 7
    //   369: astore_1
    //   370: aload 10
    //   372: aload 8
    //   374: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: bipush 10
    //   379: invokevirtual 177	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: istore_3
    //   386: goto -82 -> 304
    //   389: astore 8
    //   391: aload 7
    //   393: astore_1
    //   394: ldc 188
    //   396: aload 8
    //   398: ldc_w 1219
    //   401: aload 12
    //   403: invokestatic 755	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   406: invokevirtual 758	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   409: iconst_0
    //   410: anewarray 4	java/lang/Object
    //   413: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: aload 7
    //   418: ifnull +8 -> 426
    //   421: aload 7
    //   423: invokevirtual 287	java/io/BufferedReader:close	()V
    //   426: aload 12
    //   428: invokevirtual 1222	java/io/File:delete	()Z
    //   431: pop
    //   432: iload_2
    //   433: iconst_1
    //   434: iadd
    //   435: istore_2
    //   436: goto -218 -> 218
    //   439: astore 7
    //   441: ldc 188
    //   443: aload 7
    //   445: ldc 190
    //   447: iconst_0
    //   448: anewarray 4	java/lang/Object
    //   451: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: ldc 155
    //   456: astore 7
    //   458: goto -414 -> 44
    //   461: aload 7
    //   463: astore_1
    //   464: aload 10
    //   466: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: getstatic 107	com/tencent/mm/app/m:bYx	Ljava/lang/String;
    //   472: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifeq +68 -> 543
    //   478: aload 7
    //   480: astore_1
    //   481: aload 10
    //   483: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: aload 10
    //   488: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: getstatic 107	com/tencent/mm/app/m:bYx	Ljava/lang/String;
    //   494: invokevirtual 1225	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   497: getstatic 107	com/tencent/mm/app/m:bYx	Ljava/lang/String;
    //   500: invokevirtual 153	java/lang/String:length	()I
    //   503: iadd
    //   504: invokevirtual 179	java/lang/String:substring	(I)Ljava/lang/String;
    //   507: astore 8
    //   509: aload 8
    //   511: ifnull +32 -> 543
    //   514: aload 7
    //   516: astore_1
    //   517: aload 8
    //   519: invokevirtual 1228	java/lang/String:trim	()Ljava/lang/String;
    //   522: invokevirtual 153	java/lang/String:length	()I
    //   525: ifle +18 -> 543
    //   528: iload 6
    //   530: ifeq +25 -> 555
    //   533: aload 7
    //   535: astore_1
    //   536: aload 8
    //   538: iconst_0
    //   539: iconst_0
    //   540: invokestatic 329	com/tencent/mm/app/m:c	(Ljava/lang/String;IZ)V
    //   543: aload 7
    //   545: invokevirtual 287	java/io/BufferedReader:close	()V
    //   548: goto -122 -> 426
    //   551: astore_1
    //   552: goto -126 -> 426
    //   555: aload 7
    //   557: astore_1
    //   558: iload_3
    //   559: aload 8
    //   561: iconst_1
    //   562: invokestatic 1230	com/tencent/mm/app/m:b	(ILjava/lang/String;Z)V
    //   565: goto -22 -> 543
    //   568: astore 8
    //   570: aload_1
    //   571: astore 7
    //   573: aload 8
    //   575: astore_1
    //   576: aload 7
    //   578: ifnull +8 -> 586
    //   581: aload 7
    //   583: invokevirtual 287	java/io/BufferedReader:close	()V
    //   586: aload_1
    //   587: athrow
    //   588: astore_1
    //   589: goto -163 -> 426
    //   592: astore 7
    //   594: goto -8 -> 586
    //   597: return
    //   598: astore_1
    //   599: aconst_null
    //   600: astore 7
    //   602: goto -26 -> 576
    //   605: astore 8
    //   607: aconst_null
    //   608: astore 7
    //   610: goto -219 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	m
    //   0	613	1	paramContext	Context
    //   217	219	2	i	int
    //   231	328	3	j	int
    //   320	64	4	k	int
    //   214	8	5	m	int
    //   275	254	6	bool	boolean
    //   30	392	7	localObject1	Object
    //   439	5	7	localException	Exception
    //   456	126	7	localObject2	Object
    //   592	1	7	localIOException1	java.io.IOException
    //   600	9	7	localObject3	Object
    //   21	352	8	localObject4	Object
    //   389	8	8	localIOException2	java.io.IOException
    //   507	53	8	str	String
    //   568	6	8	localObject5	Object
    //   605	1	8	localIOException3	java.io.IOException
    //   184	41	9	arrayOfFile	File[]
    //   201	286	10	localStringBuilder	StringBuilder
    //   209	121	11	localPattern	java.util.regex.Pattern
    //   228	199	12	localFile	File
    //   336	20	13	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   298	304	389	java/io/IOException
    //   307	314	389	java/io/IOException
    //   329	338	389	java/io/IOException
    //   344	352	389	java/io/IOException
    //   355	367	389	java/io/IOException
    //   370	383	389	java/io/IOException
    //   464	478	389	java/io/IOException
    //   481	509	389	java/io/IOException
    //   517	528	389	java/io/IOException
    //   536	543	389	java/io/IOException
    //   558	565	389	java/io/IOException
    //   16	23	439	java/lang/Exception
    //   32	40	439	java/lang/Exception
    //   543	548	551	java/io/IOException
    //   298	304	568	finally
    //   307	314	568	finally
    //   329	338	568	finally
    //   344	352	568	finally
    //   355	367	568	finally
    //   370	383	568	finally
    //   394	416	568	finally
    //   464	478	568	finally
    //   481	509	568	finally
    //   517	528	568	finally
    //   536	543	568	finally
    //   558	565	568	finally
    //   421	426	588	java/io/IOException
    //   581	586	592	java/io/IOException
    //   277	295	598	finally
    //   277	295	605	java/io/IOException
  }
  
  public final void k(int paramInt, String paramString)
  {
    b(paramInt, paramString, false);
  }
  
  final void s(String paramString, int paramInt)
  {
    Recovery.dUj();
    h.qsU.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    h.qsU.idkeyStat(26L, 0L, 1L, true);
    dx(paramString);
    Object localObject = h.qsU;
    h.chS();
    long l = System.currentTimeMillis();
    if (l - this.bYo < 120000L) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      this.bYo = l;
      f.e(ah.getContext(), ah.getProcessName(), "anr");
      localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append(l("", true));
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
    } while (com.tencent.mm.plugin.p.d.bSu() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", av.flM.Y("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(localStringBuilder.toString().getBytes(), 2));
    com.tencent.mm.plugin.p.d.bSu().v(ah.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.m
 * JD-Core Version:    0.7.0.1
 */