package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.b;
import com.tencent.mm.sdk.platformtools.al.c;
import com.tencent.mm.sdk.platformtools.al.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.recovery.Recovery;
import com.tencent.xweb.WebView;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public class k
  implements com.tencent.mm.sdk.a.c, al.d
{
  public static final long bwC = ;
  private static final String bwK;
  private static final String bwL;
  private static String bwM;
  private static final String bwN;
  private static long[] bwO = { 0L, 0L, 0L };
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  private al bwD = null;
  private a bwE;
  private volatile long bwF = 0L;
  HashSet<String> bwG;
  String bwH;
  String bwI;
  ConditionVariable bwJ;
  volatile k.b bwP;
  
  static
  {
    String str = q.zg();
    bwK = str;
    bwL = o.getString(str.hashCode());
    bwM = "";
    bwN = "version:" + com.tencent.mm.protocal.d.spa;
    sCrashExtraMessageGetter = new k.1();
  }
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, android.app.ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 76	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 120	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 9
    //   15: new 122	java/text/SimpleDateFormat
    //   18: dup
    //   19: ldc 124
    //   21: invokespecial 125	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: new 76	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 127
    //   32: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: iload_1
    //   36: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 129
    //   41: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 4
    //   51: ifnull +19 -> 70
    //   54: aload 9
    //   56: aload 4
    //   58: getfield 137	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   61: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 10
    //   66: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 142	java/io/BufferedReader
    //   73: dup
    //   74: new 144	java/io/FileReader
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 145	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: iload 5
    //   89: istore_1
    //   90: aload 4
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: ifnull +245 -> 347
    //   105: iload_1
    //   106: tableswitch	default:+293 -> 399, 0:+26->132, 1:+99->205, 2:+157->263
    //   133: iconst_1
    //   134: astore_0
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -52 -> 90
    //   145: aload 4
    //   147: astore_0
    //   148: aload 11
    //   150: invokevirtual 158	java/lang/String:length	()I
    //   153: istore 5
    //   155: aload 4
    //   157: astore_0
    //   158: aload 10
    //   160: aload 12
    //   162: iload 5
    //   164: iload 5
    //   166: bipush 19
    //   168: iadd
    //   169: invokevirtual 162	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 166	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 171	java/util/Date:getTime	()J
    //   178: lload_2
    //   179: lsub
    //   180: lstore 6
    //   182: lload 6
    //   184: ldc2_w 172
    //   187: lcmp
    //   188: iflt -98 -> 90
    //   191: lload 6
    //   193: ldc2_w 174
    //   196: lcmp
    //   197: ifgt -107 -> 90
    //   200: iconst_1
    //   201: istore_1
    //   202: goto -112 -> 90
    //   205: aload 4
    //   207: astore_0
    //   208: aload 9
    //   210: aload 12
    //   212: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: bipush 10
    //   217: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: astore_0
    //   224: aload 12
    //   226: ldc 177
    //   228: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   231: ifeq +8 -> 239
    //   234: iconst_2
    //   235: istore_1
    //   236: goto -146 -> 90
    //   239: aload 4
    //   241: astore_0
    //   242: aload 12
    //   244: ldc 179
    //   246: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   249: istore 8
    //   251: iload 8
    //   253: ifeq -163 -> 90
    //   256: aload 4
    //   258: invokevirtual 182	java/io/BufferedReader:close	()V
    //   261: aconst_null
    //   262: areturn
    //   263: aload 4
    //   265: astore_0
    //   266: aload 12
    //   268: ldc 184
    //   270: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +25 -> 298
    //   276: aload 4
    //   278: astore_0
    //   279: aload 9
    //   281: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 9
    //   286: aload 4
    //   288: invokevirtual 182	java/io/BufferedReader:close	()V
    //   291: aload 9
    //   293: areturn
    //   294: astore_0
    //   295: aload 9
    //   297: areturn
    //   298: aload 4
    //   300: astore_0
    //   301: aload 9
    //   303: aload 12
    //   305: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: bipush 10
    //   310: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: goto -224 -> 90
    //   317: astore 9
    //   319: aload 4
    //   321: astore_0
    //   322: ldc 186
    //   324: aload 9
    //   326: ldc 188
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload 4
    //   337: ifnull +8 -> 345
    //   340: aload 4
    //   342: invokevirtual 182	java/io/BufferedReader:close	()V
    //   345: aconst_null
    //   346: areturn
    //   347: aload 4
    //   349: invokevirtual 182	java/io/BufferedReader:close	()V
    //   352: goto -7 -> 345
    //   355: astore_0
    //   356: goto -11 -> 345
    //   359: astore 4
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 182	java/io/BufferedReader:close	()V
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
    //   0	402	4	paramProcessErrorStateInfo	android.app.ActivityManager.ProcessErrorStateInfo
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
  
  public static void a(al.c paramc)
  {
    al.a(paramc);
  }
  
  private static void b(int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramInt == 6) {}
    try
    {
      String str = sS();
      localObject = localStringBuilder;
      if (str != null) {
        localObject = a(str, Process.myPid(), System.currentTimeMillis(), null);
      }
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("#[jin_crash]sig=").append(paramInt).append('\n');
      localStringBuilder.append("#crash.previous=").append(paramBoolean).append('\n');
      localStringBuilder.append(j("", false));
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
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!paramBoolean) {
          com.tencent.mm.sdk.platformtools.y.appenderClose();
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed reporting JNI crash.", new Object[0]);
    }
  }
  
  private static void c(String paramString, int paramInt, boolean paramBoolean)
  {
    cm(paramString);
    h.nFQ.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    h.nFQ.a(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (ae.getProcessName().endsWith(":push"))
    {
      h.nFQ.a(25L, 2L, 1L, true);
      localObject = h.nFQ;
      h.bwZ();
      localObject = paramString;
      if (f.aC(ae.getContext()) == 1)
      {
        int i = f.aD(ae.getContext());
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[] { Integer.valueOf(i) });
        localObject = paramString;
        if (paramString.length() > i) {
          localObject = paramString.substring(0, i);
        }
      }
      localContext = ae.getContext();
      str = ae.getProcessName();
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
      if (com.tencent.mm.plugin.w.d.bkt() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", sR());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        com.tencent.mm.plugin.w.d.bkt().s(ae.getContext(), (Intent)localObject);
      }
      return;
      if ((ae.cqY()) || (ae.cqY()))
      {
        h.nFQ.a(25L, 3L, 1L, true);
        break;
      }
      if (ae.getProcessName().endsWith(":exdevice"))
      {
        h.nFQ.a(25L, 4L, 1L, true);
        break;
      }
      if (!ae.cqV()) {
        break;
      }
      h.nFQ.a(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean cl(String paramString)
  {
    Object localObject4 = null;
    bwM = paramString;
    if (com.tencent.mm.plugin.w.d.bkt() == null) {}
    try
    {
      localObject1 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException4)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ae.getContext().getClassLoader());
        localObject4 = localClass;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + localObject1 + " thisProcName: " + bwM);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject4 + " thisProcName: " + bwM);
        localObject1 = com.tencent.mm.br.d.fZ("sandbox", ".SubCoreSandBox");
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + localObject1 + " thisProcName: " + bwM);
        if (localObject1 == null) {}
      }
      catch (Exception localException4)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = (com.tencent.mm.plugin.w.c)((Class)localObject1).newInstance();
            com.tencent.mm.plugin.w.d.a((com.tencent.mm.plugin.w.c)localObject1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + localObject1 + " thisProcName: " + bwM);
            try
            {
              localObject1 = (com.tencent.mm.sdk.a.c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              ((com.tencent.mm.sdk.a.c)localObject1).aE(ae.getContext());
              at.dVC.L("last_login_uin", bwL);
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject1);
              new k.2();
              return true;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              Object localObject3 = new k();
              ((k)localObject3).aE(ae.getContext());
              com.tencent.mm.sdk.a.b.a((com.tencent.mm.sdk.a.c)localObject3);
              localObject3 = com.tencent.mm.compatible.e.y.get("ro.product.cpu.abi");
              if ((localObject3 != null) && (((String)localObject3).length() != 0) && ((((String)localObject3).equals("x86")) || (((String)localObject3).equals("x86-64")))) {
                break label527;
              }
              com.tencent.mm.compatible.util.k.b("wechatCrashForJni", k.class.getClassLoader());
              localObject4 = bwN;
              if ((paramString.contains(":tools")) || (paramString.contains(":appbrand"))) {
                break;
              }
              localObject3 = localObject4;
              if (!paramString.contains(":support")) {
                break label517;
              }
              localObject3 = (String)localObject4 + "\n" + WebView.getCrashExtraMessage(ae.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[] { com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION }) + "\n";
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[] { localObject3 });
              CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
              CrashMonitorForJni.setClientVersionMsg((String)localObject3);
              cd.iW(e.dOP);
            }
            localException1 = localException1;
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", localException1, "setup sanbox Failed printing stack trace1.", new Object[0]);
            localObject2 = null;
          }
          localException4 = localException4;
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", localException4, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", localException2, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
          }
        }
      }
    }
    label517:
    label527:
    return false;
  }
  
  private static void cm(String paramString)
  {
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i) {
          break;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMCrashReporter", paramString);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
    }
  }
  
  /* Error */
  private static String j(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 76	java/lang/StringBuilder
    //   3: dup
    //   4: sipush 256
    //   7: invokespecial 120	java/lang/StringBuilder:<init>	(I)V
    //   10: astore 13
    //   12: new 570	android/util/StringBuilderPrinter
    //   15: dup
    //   16: aload 13
    //   18: invokespecial 573	android/util/StringBuilderPrinter:<init>	(Ljava/lang/StringBuilder;)V
    //   21: astore 14
    //   23: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   26: astore 11
    //   28: aload 14
    //   30: new 76	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 575
    //   37: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: getstatic 88	com/tencent/mm/protocal/d:spa	I
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   52: aload 14
    //   54: new 76	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 580
    //   61: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: invokestatic 583	com/tencent/mm/model/cd:Iv	()Ljava/lang/String;
    //   67: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   76: aload 14
    //   78: new 76	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 585
    //   85: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: invokestatic 588	com/tencent/mm/compatible/e/q:zf	()Ljava/lang/String;
    //   91: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   100: aload 14
    //   102: new 76	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 590
    //   109: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: getstatic 593	com/tencent/mm/sdk/platformtools/d:REV	Ljava/lang/String;
    //   115: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   124: aload 14
    //   126: new 76	java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 595
    //   133: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: getstatic 440	com/tencent/mm/model/at:dVC	Lcom/tencent/mm/model/at;
    //   139: ldc_w 442
    //   142: getstatic 70	com/tencent/mm/app/k:bwL	Ljava/lang/String;
    //   145: invokevirtual 446	com/tencent/mm/model/at:L	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   157: aload 14
    //   159: new 76	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 597
    //   166: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: getstatic 56	com/tencent/mm/app/k:bwK	Ljava/lang/String;
    //   172: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   181: aload 14
    //   183: new 76	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 599
    //   190: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: invokestatic 46	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   196: getstatic 48	com/tencent/mm/app/k:bwC	J
    //   199: lsub
    //   200: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: ldc_w 604
    //   206: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: getstatic 74	com/tencent/mm/app/k:bwM	Ljava/lang/String;
    //   212: invokestatic 607	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 609
    //   221: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   230: aload 14
    //   232: new 76	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 611
    //   239: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: getstatic 614	com/tencent/mm/sdk/platformtools/d:TIME	Ljava/lang/String;
    //   245: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 616
    //   251: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: getstatic 619	com/tencent/mm/sdk/platformtools/d:HOSTNAME	Ljava/lang/String;
    //   257: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 616
    //   263: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: getstatic 624	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   269: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   278: aload 14
    //   280: new 76	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 626
    //   287: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 11
    //   292: invokestatic 629	com/tencent/xweb/WebView:getInstalledTbsCoreVersion	(Landroid/content/Context;)I
    //   295: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   304: aload 14
    //   306: new 76	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 631
    //   313: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload 11
    //   318: invokestatic 634	com/tencent/xweb/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   321: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   330: aload 14
    //   332: new 76	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 636
    //   339: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: invokestatic 639	com/tencent/mm/app/k:sV	()Ljava/lang/String;
    //   345: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   354: aload 14
    //   356: new 76	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 641
    //   363: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: invokestatic 644	com/tencent/mm/app/k:sT	()Ljava/lang/String;
    //   369: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   378: aload 14
    //   380: new 76	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 646
    //   387: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: invokestatic 649	com/tencent/mm/app/k:sU	()Ljava/lang/String;
    //   393: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   402: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   405: ldc_w 651
    //   408: iconst_4
    //   409: invokevirtual 655	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   412: ldc_w 657
    //   415: aconst_null
    //   416: invokeinterface 661 3 0
    //   421: astore 10
    //   423: aload 10
    //   425: ifnull +61 -> 486
    //   428: aload 14
    //   430: new 76	java/lang/StringBuilder
    //   433: dup
    //   434: ldc_w 663
    //   437: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload 10
    //   442: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   451: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   454: ldc_w 651
    //   457: iconst_4
    //   458: invokevirtual 655	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   461: invokeinterface 667 1 0
    //   466: astore 10
    //   468: aload 10
    //   470: ldc_w 657
    //   473: invokeinterface 673 2 0
    //   478: pop
    //   479: aload 10
    //   481: invokeinterface 676 1 0
    //   486: iload_1
    //   487: ifeq +16 -> 503
    //   490: aload 14
    //   492: getstatic 103	com/tencent/mm/app/k:sCrashExtraMessageGetter	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$a;
    //   495: invokeinterface 681 1 0
    //   500: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   503: new 76	java/lang/StringBuilder
    //   506: dup
    //   507: ldc_w 683
    //   510: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   513: astore 12
    //   515: getstatic 687	com/tencent/mm/sdk/a/b:foreground	Z
    //   518: ifeq +918 -> 1436
    //   521: ldc_w 689
    //   524: astore 10
    //   526: aload 14
    //   528: aload 12
    //   530: aload 10
    //   532: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 616
    //   538: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokestatic 695	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   544: invokevirtual 698	java/lang/Thread:getName	()Ljava/lang/String;
    //   547: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 616
    //   553: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: getstatic 701	com/tencent/mm/sdk/a/b:udL	Ljava/lang/String;
    //   559: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   568: invokestatic 707	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   571: astore 12
    //   573: new 709	android/os/StatFs
    //   576: dup
    //   577: aload 12
    //   579: invokevirtual 714	java/io/File:getPath	()Ljava/lang/String;
    //   582: invokespecial 715	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   585: astore 15
    //   587: new 709	android/os/StatFs
    //   590: dup
    //   591: getstatic 718	com/tencent/mm/compatible/util/e:bkF	Ljava/lang/String;
    //   594: invokespecial 715	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   597: astore 16
    //   599: aload 11
    //   601: ldc_w 720
    //   604: invokevirtual 724	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   607: checkcast 726	android/app/ActivityManager
    //   610: invokevirtual 729	android/app/ActivityManager:getMemoryClass	()I
    //   613: istore_2
    //   614: aload 11
    //   616: ldc_w 720
    //   619: invokevirtual 724	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   622: checkcast 726	android/app/ActivityManager
    //   625: invokevirtual 732	android/app/ActivityManager:getLargeMemoryClass	()I
    //   628: istore_3
    //   629: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   632: astore 11
    //   634: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   637: invokevirtual 735	android/content/Context:getPackageName	()Ljava/lang/String;
    //   640: astore 17
    //   642: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   645: astore 10
    //   647: aload 10
    //   649: monitorenter
    //   650: ldc_w 737
    //   653: ldc_w 739
    //   656: iconst_2
    //   657: anewarray 383	java/lang/Class
    //   660: dup
    //   661: iconst_0
    //   662: ldc 58
    //   664: aastore
    //   665: dup
    //   666: iconst_1
    //   667: ldc_w 741
    //   670: aastore
    //   671: invokevirtual 745	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   674: aload 11
    //   676: invokevirtual 749	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   679: iconst_2
    //   680: anewarray 4	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: aload 17
    //   687: aastore
    //   688: dup
    //   689: iconst_1
    //   690: new 751	com/tencent/mm/app/k$4
    //   693: dup
    //   694: invokespecial 752	com/tencent/mm/app/k$4:<init>	()V
    //   697: aastore
    //   698: invokevirtual 758	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   701: pop
    //   702: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   705: ldc2_w 759
    //   708: invokevirtual 764	java/lang/Object:wait	(J)V
    //   711: aload 10
    //   713: monitorexit
    //   714: ldc_w 766
    //   717: bipush 13
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: iload_2
    //   725: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: dup
    //   730: iconst_1
    //   731: iload_3
    //   732: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   735: aastore
    //   736: dup
    //   737: iconst_2
    //   738: aload 12
    //   740: invokevirtual 769	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   743: aastore
    //   744: dup
    //   745: iconst_3
    //   746: aload 15
    //   748: invokevirtual 772	android/os/StatFs:getBlockSize	()I
    //   751: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   754: aastore
    //   755: dup
    //   756: iconst_4
    //   757: aload 15
    //   759: invokevirtual 775	android/os/StatFs:getBlockCount	()I
    //   762: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   765: aastore
    //   766: dup
    //   767: iconst_5
    //   768: aload 15
    //   770: invokevirtual 778	android/os/StatFs:getAvailableBlocks	()I
    //   773: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: dup
    //   778: bipush 6
    //   780: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   783: iconst_0
    //   784: laload
    //   785: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   788: aastore
    //   789: dup
    //   790: bipush 7
    //   792: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   795: iconst_1
    //   796: laload
    //   797: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   800: aastore
    //   801: dup
    //   802: bipush 8
    //   804: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   807: iconst_2
    //   808: laload
    //   809: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   812: aastore
    //   813: dup
    //   814: bipush 9
    //   816: getstatic 718	com/tencent/mm/compatible/util/e:bkF	Ljava/lang/String;
    //   819: aastore
    //   820: dup
    //   821: bipush 10
    //   823: aload 16
    //   825: invokevirtual 772	android/os/StatFs:getBlockSize	()I
    //   828: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   831: aastore
    //   832: dup
    //   833: bipush 11
    //   835: aload 16
    //   837: invokevirtual 775	android/os/StatFs:getBlockCount	()I
    //   840: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: aastore
    //   844: dup
    //   845: bipush 12
    //   847: aload 16
    //   849: invokevirtual 778	android/os/StatFs:getAvailableBlocks	()I
    //   852: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   855: aastore
    //   856: invokestatic 786	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   859: astore 10
    //   861: aload 14
    //   863: new 76	java/lang/StringBuilder
    //   866: dup
    //   867: ldc_w 788
    //   870: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   873: aload 10
    //   875: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   884: new 168	java/util/Date
    //   887: dup
    //   888: invokespecial 789	java/util/Date:<init>	()V
    //   891: astore 10
    //   893: new 122	java/text/SimpleDateFormat
    //   896: dup
    //   897: ldc_w 791
    //   900: invokestatic 795	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   903: invokespecial 798	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   906: astore 11
    //   908: aload 14
    //   910: new 76	java/lang/StringBuilder
    //   913: dup
    //   914: ldc_w 800
    //   917: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: aload 11
    //   922: aload 10
    //   924: invokevirtual 803	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   927: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   936: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   939: ldc_w 720
    //   942: invokevirtual 724	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   945: checkcast 726	android/app/ActivityManager
    //   948: astore 15
    //   950: new 805	android/app/ActivityManager$MemoryInfo
    //   953: dup
    //   954: invokespecial 806	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   957: astore 16
    //   959: aload 15
    //   961: aload 16
    //   963: invokevirtual 810	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   966: lconst_0
    //   967: lstore 6
    //   969: bipush 16
    //   971: invokestatic 816	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   974: ifeq +575 -> 1549
    //   977: aload 16
    //   979: getfield 819	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   982: lstore 4
    //   984: new 76	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 514	java/lang/StringBuilder:<init>	()V
    //   991: ldc 72
    //   993: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 821
    //   999: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: lload 4
    //   1004: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1007: ldc_w 823
    //   1010: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 16
    //   1015: getfield 826	android/app/ActivityManager$MemoryInfo:availMem	J
    //   1018: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1021: ldc_w 823
    //   1024: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: aload 16
    //   1029: getfield 829	android/app/ActivityManager$MemoryInfo:threshold	J
    //   1032: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1035: ldc_w 823
    //   1038: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 16
    //   1043: getfield 832	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   1046: invokevirtual 223	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1049: ldc_w 834
    //   1052: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: astore 10
    //   1060: new 76	java/lang/StringBuilder
    //   1063: dup
    //   1064: invokespecial 514	java/lang/StringBuilder:<init>	()V
    //   1067: aload 10
    //   1069: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: ldc_w 836
    //   1075: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: invokestatic 841	android/os/Debug:getNativeHeapSize	()J
    //   1081: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1084: ldc_w 823
    //   1087: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokestatic 844	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   1093: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: ldc_w 823
    //   1099: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: invokestatic 847	android/os/Debug:getNativeHeapFreeSize	()J
    //   1105: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1108: ldc_w 834
    //   1111: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: astore 10
    //   1119: iconst_1
    //   1120: newarray int
    //   1122: astore 11
    //   1124: aload 11
    //   1126: iconst_0
    //   1127: invokestatic 209	android/os/Process:myPid	()I
    //   1130: iastore
    //   1131: aload 15
    //   1133: aload 11
    //   1135: invokevirtual 851	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   1138: astore 12
    //   1140: aload 12
    //   1142: ifnull +629 -> 1771
    //   1145: aload 12
    //   1147: arraylength
    //   1148: ifle +623 -> 1771
    //   1151: aload 12
    //   1153: iconst_0
    //   1154: aaload
    //   1155: ifnull +616 -> 1771
    //   1158: aload 12
    //   1160: iconst_0
    //   1161: aaload
    //   1162: astore 12
    //   1164: new 76	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 514	java/lang/StringBuilder:<init>	()V
    //   1171: aload 10
    //   1173: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: ldc_w 853
    //   1179: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload 11
    //   1184: iconst_0
    //   1185: iaload
    //   1186: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: ldc_w 855
    //   1192: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload 12
    //   1197: invokevirtual 860	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   1200: bipush 10
    //   1202: ishl
    //   1203: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: ldc_w 823
    //   1209: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload 12
    //   1214: invokevirtual 863	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   1217: bipush 10
    //   1219: ishl
    //   1220: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1223: ldc_w 823
    //   1226: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload 12
    //   1231: invokevirtual 866	android/os/Debug$MemoryInfo:getTotalSharedDirty	()I
    //   1234: bipush 10
    //   1236: ishl
    //   1237: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 834
    //   1243: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: astore 10
    //   1251: invokestatic 872	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1254: invokevirtual 875	java/lang/Runtime:totalMemory	()J
    //   1257: lstore 4
    //   1259: invokestatic 872	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1262: invokevirtual 878	java/lang/Runtime:freeMemory	()J
    //   1265: lstore 6
    //   1267: ldc_w 880
    //   1270: iconst_3
    //   1271: anewarray 4	java/lang/Object
    //   1274: dup
    //   1275: iconst_0
    //   1276: lload 4
    //   1278: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1281: aastore
    //   1282: dup
    //   1283: iconst_1
    //   1284: lload 6
    //   1286: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1289: aastore
    //   1290: dup
    //   1291: iconst_2
    //   1292: lload 4
    //   1294: lload 6
    //   1296: lsub
    //   1297: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1300: aastore
    //   1301: invokestatic 786	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1304: astore 11
    //   1306: new 76	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 514	java/lang/StringBuilder:<init>	()V
    //   1313: aload 10
    //   1315: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: aload 11
    //   1320: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: astore 10
    //   1328: new 76	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 514	java/lang/StringBuilder:<init>	()V
    //   1335: aload 10
    //   1337: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 882
    //   1343: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: getstatic 888	com/tencent/mm/sdk/platformtools/an:ufL	Lcom/tencent/mm/sdk/platformtools/an;
    //   1349: iconst_0
    //   1350: invokevirtual 892	com/tencent/mm/sdk/platformtools/an:mt	(Z)Lcom/tencent/mm/sdk/platformtools/an$f;
    //   1353: invokevirtual 895	com/tencent/mm/sdk/platformtools/an$f:toString	()Ljava/lang/String;
    //   1356: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: ldc_w 834
    //   1362: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: astore 10
    //   1370: aload 14
    //   1372: new 76	java/lang/StringBuilder
    //   1375: dup
    //   1376: ldc_w 897
    //   1379: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1382: aload 10
    //   1384: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1393: aload_0
    //   1394: invokestatic 900	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1397: ifne +25 -> 1422
    //   1400: aload 14
    //   1402: new 76	java/lang/StringBuilder
    //   1405: dup
    //   1406: ldc_w 902
    //   1409: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1412: aload_0
    //   1413: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1422: aload 14
    //   1424: ldc_w 904
    //   1427: invokevirtual 578	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1430: aload 13
    //   1432: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: areturn
    //   1436: ldc_w 905
    //   1439: astore 10
    //   1441: goto -915 -> 526
    //   1444: astore 11
    //   1446: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   1449: iconst_0
    //   1450: ldc2_w 906
    //   1453: lastore
    //   1454: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   1457: iconst_1
    //   1458: ldc2_w 906
    //   1461: lastore
    //   1462: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   1465: iconst_2
    //   1466: ldc2_w 906
    //   1469: lastore
    //   1470: ldc 186
    //   1472: aload 11
    //   1474: ldc_w 909
    //   1477: iconst_0
    //   1478: anewarray 4	java/lang/Object
    //   1481: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1484: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   1487: astore 11
    //   1489: aload 11
    //   1491: monitorenter
    //   1492: getstatic 105	com/tencent/mm/app/k:bwO	[J
    //   1495: invokevirtual 912	java/lang/Object:notify	()V
    //   1498: aload 11
    //   1500: monitorexit
    //   1501: goto -790 -> 711
    //   1504: astore 12
    //   1506: aload 11
    //   1508: monitorexit
    //   1509: aload 12
    //   1511: athrow
    //   1512: astore 11
    //   1514: aload 10
    //   1516: monitorexit
    //   1517: aload 11
    //   1519: athrow
    //   1520: astore 10
    //   1522: ldc 186
    //   1524: ldc_w 914
    //   1527: iconst_1
    //   1528: anewarray 4	java/lang/Object
    //   1531: dup
    //   1532: iconst_0
    //   1533: aload 10
    //   1535: invokevirtual 470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1538: aastore
    //   1539: invokestatic 916	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1542: ldc 72
    //   1544: astore 10
    //   1546: goto -685 -> 861
    //   1549: new 918	java/io/RandomAccessFile
    //   1552: dup
    //   1553: ldc_w 920
    //   1556: ldc_w 922
    //   1559: invokespecial 924	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1562: astore 11
    //   1564: aload 11
    //   1566: astore 10
    //   1568: new 926	java/lang/StringBuffer
    //   1571: dup
    //   1572: invokespecial 927	java/lang/StringBuffer:<init>	()V
    //   1575: astore 12
    //   1577: aload 11
    //   1579: astore 10
    //   1581: aload 11
    //   1583: invokevirtual 928	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   1586: invokevirtual 932	java/lang/String:toCharArray	()[C
    //   1589: astore 17
    //   1591: aload 11
    //   1593: astore 10
    //   1595: aload 17
    //   1597: arraylength
    //   1598: istore_3
    //   1599: iconst_0
    //   1600: istore_2
    //   1601: iload_2
    //   1602: iload_3
    //   1603: if_icmpge +38 -> 1641
    //   1606: aload 17
    //   1608: iload_2
    //   1609: caload
    //   1610: bipush 57
    //   1612: if_icmpgt +162 -> 1774
    //   1615: aload 17
    //   1617: iload_2
    //   1618: caload
    //   1619: bipush 48
    //   1621: if_icmplt +153 -> 1774
    //   1624: aload 11
    //   1626: astore 10
    //   1628: aload 12
    //   1630: aload 17
    //   1632: iload_2
    //   1633: caload
    //   1634: invokevirtual 935	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1637: pop
    //   1638: goto +136 -> 1774
    //   1641: aload 11
    //   1643: astore 10
    //   1645: aload 12
    //   1647: invokevirtual 936	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1650: ldc2_w 906
    //   1653: invokestatic 940	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   1656: lstore 8
    //   1658: lload 6
    //   1660: lstore 4
    //   1662: lload 8
    //   1664: lconst_0
    //   1665: lcmp
    //   1666: ifle +10 -> 1676
    //   1669: lload 8
    //   1671: bipush 10
    //   1673: lshl
    //   1674: lstore 4
    //   1676: aload 11
    //   1678: invokevirtual 941	java/io/RandomAccessFile:close	()V
    //   1681: goto -697 -> 984
    //   1684: astore 10
    //   1686: goto -702 -> 984
    //   1689: astore 12
    //   1691: aconst_null
    //   1692: astore 11
    //   1694: aload 11
    //   1696: astore 10
    //   1698: ldc 186
    //   1700: aload 12
    //   1702: ldc 72
    //   1704: iconst_0
    //   1705: anewarray 4	java/lang/Object
    //   1708: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1711: lload 6
    //   1713: lstore 4
    //   1715: aload 11
    //   1717: ifnull -733 -> 984
    //   1720: aload 11
    //   1722: invokevirtual 941	java/io/RandomAccessFile:close	()V
    //   1725: lload 6
    //   1727: lstore 4
    //   1729: goto -745 -> 984
    //   1732: astore 10
    //   1734: lload 6
    //   1736: lstore 4
    //   1738: goto -754 -> 984
    //   1741: astore_0
    //   1742: aconst_null
    //   1743: astore 10
    //   1745: aload 10
    //   1747: ifnull +8 -> 1755
    //   1750: aload 10
    //   1752: invokevirtual 941	java/io/RandomAccessFile:close	()V
    //   1755: aload_0
    //   1756: athrow
    //   1757: astore 10
    //   1759: goto -4 -> 1755
    //   1762: astore_0
    //   1763: goto -18 -> 1745
    //   1766: astore 12
    //   1768: goto -74 -> 1694
    //   1771: goto -520 -> 1251
    //   1774: iload_2
    //   1775: iconst_1
    //   1776: iadd
    //   1777: istore_2
    //   1778: goto -177 -> 1601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1781	0	paramString	String
    //   0	1781	1	paramBoolean	boolean
    //   613	1165	2	i	int
    //   628	976	3	j	int
    //   982	755	4	l1	long
    //   967	768	6	l2	long
    //   1656	14	8	l3	long
    //   421	1094	10	localObject1	Object
    //   1520	14	10	localException1	Exception
    //   1544	100	10	localObject2	Object
    //   1684	1	10	localException2	Exception
    //   1696	1	10	localRandomAccessFile1	java.io.RandomAccessFile
    //   1732	1	10	localException3	Exception
    //   1743	8	10	localObject3	Object
    //   1757	1	10	localException4	Exception
    //   26	1293	11	localObject4	Object
    //   1444	29	11	localException5	Exception
    //   1487	20	11	arrayOfLong	long[]
    //   1512	6	11	localObject5	Object
    //   1562	159	11	localRandomAccessFile2	java.io.RandomAccessFile
    //   513	717	12	localObject6	Object
    //   1504	6	12	localObject7	Object
    //   1575	71	12	localStringBuffer	java.lang.StringBuffer
    //   1689	12	12	localException6	Exception
    //   1766	1	12	localException7	Exception
    //   10	1421	13	localStringBuilder	StringBuilder
    //   21	1402	14	localStringBuilderPrinter	android.util.StringBuilderPrinter
    //   585	547	15	localObject8	Object
    //   597	445	16	localObject9	Object
    //   640	991	17	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   650	711	1444	java/lang/Exception
    //   1492	1501	1504	finally
    //   1506	1509	1504	finally
    //   650	711	1512	finally
    //   711	714	1512	finally
    //   1446	1492	1512	finally
    //   1509	1512	1512	finally
    //   1514	1517	1512	finally
    //   568	650	1520	java/lang/Exception
    //   714	861	1520	java/lang/Exception
    //   1517	1520	1520	java/lang/Exception
    //   1676	1681	1684	java/lang/Exception
    //   1549	1564	1689	java/lang/Exception
    //   1720	1725	1732	java/lang/Exception
    //   1549	1564	1741	finally
    //   1750	1755	1757	java/lang/Exception
    //   1568	1577	1762	finally
    //   1581	1591	1762	finally
    //   1595	1599	1762	finally
    //   1628	1638	1762	finally
    //   1645	1658	1762	finally
    //   1698	1711	1762	finally
    //   1568	1577	1766	java/lang/Exception
    //   1581	1591	1766	java/lang/Exception
    //   1595	1599	1766	java/lang/Exception
    //   1628	1638	1766	java/lang/Exception
    //   1645	1658	1766	java/lang/Exception
  }
  
  private static String sR()
  {
    String str2 = at.dVC.L("login_weixin_username", "");
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = at.dVC.L("login_user_name", "never_login_crash");
    }
    return str1;
  }
  
  private static String sS()
  {
    try
    {
      localObject2 = com.tencent.mm.compatible.e.y.get("dalvik.vm.stack-trace-file");
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
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
          str1 = "/data/anr/traces.txt";
        }
        Object localObject2 = str1;
      } while (new File(str1).isFile());
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = ae.getProcessName();
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
  
  private static String sT()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.mGK.boJ()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  private static String sU()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.mGK.boK()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  private static String sV()
  {
    try
    {
      if (com.tencent.mm.plugin.normsg.a.b.mGK.boL()) {
        return "1";
      }
      return "0";
    }
    catch (Throwable localThrowable) {}
    return "-1";
  }
  
  public final void a(a parama)
  {
    al.a(parama);
  }
  
  public final void a(al paramal, String paramString, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str1 = paramThrowable.getMessage();
      if (!bk.bl(str1))
      {
        paramal = paramal.ufB.entrySet().iterator();
        while ((paramal != null) && (paramal.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramal.next();
          String str2 = (String)localEntry.getKey();
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str1.startsWith(str2)))
          {
            paramal = ((al.b)localEntry.getValue()).Jf();
            if (bk.bl(paramal)) {
              break label159;
            }
          }
        }
      }
    }
    for (;;)
    {
      s.b(paramThrowable);
      c(j(paramal, true) + paramString, 0, false);
      return;
      paramal = "";
      break;
      label159:
      paramal = "";
    }
  }
  
  /* Error */
  public final void aE(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1044	com/tencent/mm/sdk/platformtools/al:a	(Lcom/tencent/mm/sdk/platformtools/al$d;)V
    //   4: getstatic 74	com/tencent/mm/app/k:bwM	Ljava/lang/String;
    //   7: ldc_w 274
    //   10: invokevirtual 277	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   13: ifeq +556 -> 569
    //   16: ldc_w 949
    //   19: invokestatic 487	com/tencent/mm/compatible/e/y:get	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 7
    //   24: aload 7
    //   26: ifnull +15 -> 41
    //   29: aload 7
    //   31: astore 6
    //   33: aload 7
    //   35: invokevirtual 158	java/lang/String:length	()I
    //   38: ifne +8 -> 46
    //   41: ldc_w 951
    //   44: astore 6
    //   46: new 711	java/io/File
    //   49: dup
    //   50: aload 6
    //   52: invokespecial 957	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 7
    //   57: aload_0
    //   58: aload 7
    //   60: invokevirtual 1047	java/io/File:getParent	()Ljava/lang/String;
    //   63: putfield 1049	com/tencent/mm/app/k:bwH	Ljava/lang/String;
    //   66: aload_0
    //   67: getfield 1049	com/tencent/mm/app/k:bwH	Ljava/lang/String;
    //   70: ifnull +13 -> 83
    //   73: aload_0
    //   74: getfield 1049	com/tencent/mm/app/k:bwH	Ljava/lang/String;
    //   77: invokevirtual 158	java/lang/String:length	()I
    //   80: ifne +10 -> 90
    //   83: aload_0
    //   84: ldc_w 1051
    //   87: putfield 1049	com/tencent/mm/app/k:bwH	Ljava/lang/String;
    //   90: aload_0
    //   91: aload 7
    //   93: invokevirtual 1052	java/io/File:getName	()Ljava/lang/String;
    //   96: putfield 1054	com/tencent/mm/app/k:bwI	Ljava/lang/String;
    //   99: aload_0
    //   100: new 1056	android/os/ConditionVariable
    //   103: dup
    //   104: invokespecial 1057	android/os/ConditionVariable:<init>	()V
    //   107: putfield 1059	com/tencent/mm/app/k:bwJ	Landroid/os/ConditionVariable;
    //   110: ldc 186
    //   112: new 76	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 1061
    //   119: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload 6
    //   124: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 405	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: new 1063	java/util/HashSet
    //   137: dup
    //   138: invokespecial 1064	java/util/HashSet:<init>	()V
    //   141: putfield 1066	com/tencent/mm/app/k:bwG	Ljava/util/HashSet;
    //   144: aload_0
    //   145: new 10	com/tencent/mm/app/k$a
    //   148: dup
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 1049	com/tencent/mm/app/k:bwH	Ljava/lang/String;
    //   154: invokespecial 1069	com/tencent/mm/app/k$a:<init>	(Lcom/tencent/mm/app/k;Ljava/lang/String;)V
    //   157: putfield 1071	com/tencent/mm/app/k:bwE	Lcom/tencent/mm/app/k$a;
    //   160: aload_0
    //   161: getfield 1071	com/tencent/mm/app/k:bwE	Lcom/tencent/mm/app/k$a;
    //   164: invokevirtual 1074	com/tencent/mm/app/k$a:startWatching	()V
    //   167: new 711	java/io/File
    //   170: dup
    //   171: aload_1
    //   172: invokevirtual 1077	android/content/Context:getFilesDir	()Ljava/io/File;
    //   175: ldc_w 1079
    //   178: invokespecial 1082	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: new 1084	com/tencent/mm/app/k$3
    //   184: dup
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 1087	com/tencent/mm/app/k$3:<init>	(Lcom/tencent/mm/app/k;Landroid/content/Context;)V
    //   190: invokevirtual 1091	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   193: astore 8
    //   195: aload 8
    //   197: ifnull +372 -> 569
    //   200: new 76	java/lang/StringBuilder
    //   203: dup
    //   204: sipush 16384
    //   207: invokespecial 120	java/lang/StringBuilder:<init>	(I)V
    //   210: astore 9
    //   212: ldc_w 1093
    //   215: invokestatic 1099	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   218: astore 10
    //   220: aload 8
    //   222: arraylength
    //   223: istore 5
    //   225: iconst_0
    //   226: istore_2
    //   227: iload_2
    //   228: iload 5
    //   230: if_icmpge +339 -> 569
    //   233: aload 8
    //   235: iload_2
    //   236: aaload
    //   237: astore 11
    //   239: iconst_m1
    //   240: istore_3
    //   241: ldc 186
    //   243: new 76	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 1101
    //   250: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 11
    //   255: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 405	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: new 142	java/io/BufferedReader
    //   267: dup
    //   268: new 144	java/io/FileReader
    //   271: dup
    //   272: aload 11
    //   274: invokespecial 1104	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   277: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   280: astore 6
    //   282: aload 6
    //   284: astore_1
    //   285: aload 9
    //   287: iconst_0
    //   288: invokevirtual 1107	java/lang/StringBuilder:setLength	(I)V
    //   291: aload 6
    //   293: astore_1
    //   294: aload 6
    //   296: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   299: astore 7
    //   301: aload 7
    //   303: ifnull +154 -> 457
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: ifge +44 -> 354
    //   313: aload 6
    //   315: astore_1
    //   316: aload 10
    //   318: aload 7
    //   320: invokevirtual 1111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   323: astore 12
    //   325: iload_3
    //   326: istore 4
    //   328: aload 6
    //   330: astore_1
    //   331: aload 12
    //   333: invokevirtual 1116	java/util/regex/Matcher:matches	()Z
    //   336: ifeq +18 -> 354
    //   339: aload 6
    //   341: astore_1
    //   342: aload 12
    //   344: iconst_1
    //   345: invokevirtual 1119	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   348: iconst_0
    //   349: invokestatic 1123	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   352: istore 4
    //   354: aload 6
    //   356: astore_1
    //   357: aload 9
    //   359: aload 7
    //   361: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: bipush 10
    //   366: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: iload 4
    //   372: istore_3
    //   373: goto -82 -> 291
    //   376: astore 7
    //   378: aload 6
    //   380: astore_1
    //   381: ldc 186
    //   383: aload 7
    //   385: new 76	java/lang/StringBuilder
    //   388: dup
    //   389: ldc_w 1125
    //   392: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload 11
    //   397: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: iconst_0
    //   404: anewarray 4	java/lang/Object
    //   407: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 6
    //   412: ifnull +8 -> 420
    //   415: aload 6
    //   417: invokevirtual 182	java/io/BufferedReader:close	()V
    //   420: aload 11
    //   422: invokevirtual 1128	java/io/File:delete	()Z
    //   425: pop
    //   426: iload_2
    //   427: iconst_1
    //   428: iadd
    //   429: istore_2
    //   430: goto -203 -> 227
    //   433: astore 6
    //   435: ldc 186
    //   437: aload 6
    //   439: ldc_w 962
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: ldc_w 951
    //   452: astore 6
    //   454: goto -408 -> 46
    //   457: aload 6
    //   459: astore_1
    //   460: aload 9
    //   462: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: getstatic 97	com/tencent/mm/app/k:bwN	Ljava/lang/String;
    //   468: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   471: ifeq +63 -> 534
    //   474: aload 6
    //   476: astore_1
    //   477: aload 9
    //   479: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: aload 9
    //   484: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: getstatic 97	com/tencent/mm/app/k:bwN	Ljava/lang/String;
    //   490: invokevirtual 1131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   493: getstatic 97	com/tencent/mm/app/k:bwN	Ljava/lang/String;
    //   496: invokevirtual 158	java/lang/String:length	()I
    //   499: iadd
    //   500: invokevirtual 566	java/lang/String:substring	(I)Ljava/lang/String;
    //   503: astore 7
    //   505: aload 7
    //   507: ifnull +27 -> 534
    //   510: aload 6
    //   512: astore_1
    //   513: aload 7
    //   515: invokevirtual 1134	java/lang/String:trim	()Ljava/lang/String;
    //   518: invokevirtual 158	java/lang/String:length	()I
    //   521: ifle +13 -> 534
    //   524: aload 6
    //   526: astore_1
    //   527: iload_3
    //   528: aload 7
    //   530: iconst_1
    //   531: invokestatic 1136	com/tencent/mm/app/k:b	(ILjava/lang/String;Z)V
    //   534: aload 6
    //   536: invokevirtual 182	java/io/BufferedReader:close	()V
    //   539: goto -119 -> 420
    //   542: astore_1
    //   543: goto -123 -> 420
    //   546: astore 6
    //   548: aconst_null
    //   549: astore_1
    //   550: aload_1
    //   551: ifnull +7 -> 558
    //   554: aload_1
    //   555: invokevirtual 182	java/io/BufferedReader:close	()V
    //   558: aload 6
    //   560: athrow
    //   561: astore_1
    //   562: goto -142 -> 420
    //   565: astore_1
    //   566: goto -8 -> 558
    //   569: return
    //   570: astore 6
    //   572: goto -22 -> 550
    //   575: astore 7
    //   577: aconst_null
    //   578: astore 6
    //   580: goto -202 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	k
    //   0	583	1	paramContext	Context
    //   226	204	2	i	int
    //   240	288	3	j	int
    //   307	64	4	k	int
    //   223	8	5	m	int
    //   31	385	6	localObject1	Object
    //   433	5	6	localException	Exception
    //   452	83	6	str1	String
    //   546	13	6	localObject2	Object
    //   570	1	6	localObject3	Object
    //   578	1	6	localObject4	Object
    //   22	338	7	localObject5	Object
    //   376	8	7	localIOException1	java.io.IOException
    //   503	26	7	str2	String
    //   575	1	7	localIOException2	java.io.IOException
    //   193	41	8	arrayOfFile	File[]
    //   210	273	9	localStringBuilder	StringBuilder
    //   218	99	10	localPattern	java.util.regex.Pattern
    //   237	184	11	localFile	File
    //   323	20	12	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   285	291	376	java/io/IOException
    //   294	301	376	java/io/IOException
    //   316	325	376	java/io/IOException
    //   331	339	376	java/io/IOException
    //   342	354	376	java/io/IOException
    //   357	370	376	java/io/IOException
    //   460	474	376	java/io/IOException
    //   477	505	376	java/io/IOException
    //   513	524	376	java/io/IOException
    //   527	534	376	java/io/IOException
    //   16	24	433	java/lang/Exception
    //   33	41	433	java/lang/Exception
    //   534	539	542	java/io/IOException
    //   264	282	546	finally
    //   415	420	561	java/io/IOException
    //   554	558	565	java/io/IOException
    //   285	291	570	finally
    //   294	301	570	finally
    //   316	325	570	finally
    //   331	339	570	finally
    //   342	354	570	finally
    //   357	370	570	finally
    //   381	410	570	finally
    //   460	474	570	finally
    //   477	505	570	finally
    //   513	524	570	finally
    //   527	534	570	finally
    //   264	282	575	java/io/IOException
  }
  
  public final void h(int paramInt, String paramString)
  {
    b(paramInt, paramString, false);
  }
  
  final void p(String paramString, int paramInt)
  {
    Recovery.cOu();
    h.nFQ.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    h.nFQ.a(26L, 0L, 1L, true);
    cm(paramString);
    Object localObject = h.nFQ;
    h.bwZ();
    long l = System.currentTimeMillis();
    if (l - this.bwF < 120000L) {}
    do
    {
      return;
      this.bwF = l;
      f.e(ae.getContext(), ae.getProcessName(), "anr");
      localObject = new StringBuilder(4096);
      ((StringBuilder)localObject).append(j("", true));
      ((StringBuilder)localObject).append("******* ANR Trace *******\n");
      ((StringBuilder)localObject).append(paramString);
    } while (com.tencent.mm.plugin.w.d.bkt() == null);
    paramString = new Intent();
    paramString.setAction("uncatch_exception");
    paramString.putExtra("tag", "anr");
    paramString.putExtra("exceptionPid", paramInt);
    paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
    paramString.putExtra("userName", at.dVC.L("login_user_name", "never_login_crash"));
    paramString.putExtra("exceptionMsg", Base64.encodeToString(((StringBuilder)localObject).toString().getBytes(), 2));
    com.tencent.mm.plugin.w.d.bkt().s(ae.getContext(), paramString);
  }
  
  public final void t(String paramString1, String paramString2)
  {
    if (com.tencent.mm.plugin.w.d.bkt() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", sR());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      com.tencent.mm.plugin.w.d.bkt().s(ae.getContext(), localIntent);
    }
  }
  
  private final class a
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
      //   6: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   9: invokestatic 28	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)J
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
      //   28: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   31: getfield 34	com/tencent/mm/app/k:bwG	Ljava/util/HashSet;
      //   34: astore 4
      //   36: aload 4
      //   38: monitorenter
      //   39: iload_1
      //   40: lookupswitch	default:+44->84, 8:+54->94, 64:+141->181, 128:+126->166, 512:+141->181
      //   85: iconst_1
      //   86: monitorexit
      //   87: return
      //   88: astore_2
      //   89: aload 4
      //   91: monitorexit
      //   92: aload_2
      //   93: athrow
      //   94: ldc 36
      //   96: new 38	java/lang/StringBuilder
      //   99: dup
      //   100: ldc 40
      //   102: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   105: aload_2
      //   106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   112: invokestatic 57	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   115: aload_0
      //   116: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   119: getfield 61	com/tencent/mm/app/k:bwJ	Landroid/os/ConditionVariable;
      //   122: invokevirtual 67	android/os/ConditionVariable:open	()V
      //   125: aload_0
      //   126: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   129: getfield 71	com/tencent/mm/app/k:bwP	Lcom/tencent/mm/app/k$b;
      //   132: ifnonnull +34 -> 166
      //   135: aload_0
      //   136: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   139: new 73	com/tencent/mm/app/k$b
      //   142: dup
      //   143: aload_0
      //   144: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   147: iconst_0
      //   148: invokespecial 76	com/tencent/mm/app/k$b:<init>	(Lcom/tencent/mm/app/k;B)V
      //   151: putfield 71	com/tencent/mm/app/k:bwP	Lcom/tencent/mm/app/k$b;
      //   154: aload_0
      //   155: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   158: getfield 71	com/tencent/mm/app/k:bwP	Lcom/tencent/mm/app/k$b;
      //   161: ldc 78
      //   163: invokestatic 84	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   166: aload_0
      //   167: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   170: getfield 34	com/tencent/mm/app/k:bwG	Ljava/util/HashSet;
      //   173: aload_2
      //   174: invokevirtual 90	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   177: pop
      //   178: goto -94 -> 84
      //   181: aload_0
      //   182: getfield 13	com/tencent/mm/app/k$a:bwR	Lcom/tencent/mm/app/k;
      //   185: getfield 34	com/tencent/mm/app/k:bwG	Ljava/util/HashSet;
      //   188: aload_2
      //   189: invokevirtual 93	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   192: pop
      //   193: goto -109 -> 84
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	196	0	this	a
      //   0	196	1	paramInt	int
      //   1	22	3	i	int
      //   34	56	4	localHashSet	HashSet
      // Exception table:
      //   from	to	target	type
      //   84	87	88	finally
      //   89	92	88	finally
      //   94	166	88	finally
      //   166	178	88	finally
      //   181	193	88	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.k
 * JD-Core Version:    0.7.0.1
 */