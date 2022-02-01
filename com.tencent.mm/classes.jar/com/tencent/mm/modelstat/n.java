package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.WiFiScanResult;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Comparator;
import java.util.HashMap;

public final class n
{
  private static final byte[] lock;
  private static long mel;
  private static HashMap<String, Long> mem;
  private static String men;
  private static long meo;
  private static int mep;
  private static long meq;
  private static long mer;
  private static float mes;
  private static float met;
  private static int meu;
  private static int mev;
  private static long mew;
  private static MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(151129);
    mel = 86400000L;
    mem = new HashMap();
    men = null;
    lock = new byte[0];
    meo = 9223372036854775807L;
    mep = 0;
    timer = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151113);
        try
        {
          n.bpA();
          if ((n.mep < 2000) && (n.mep > 1000)) {
            n.wW(n.mep);
          }
          for (;;)
          {
            AppMethodBeat.o(151113);
            return false;
            n.wX(n.mep);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { Util.stackTraceToString(localException) });
          }
        }
      }
    }, false);
    meq = 0L;
    mer = 0L;
    mes = 0.0F;
    met = 0.0F;
    meu = 0;
    mev = 0;
    mew = 0L;
    AppMethodBeat.o(151129);
  }
  
  public static void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(151122);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dto();
    ((d.a)localObject).lBV = new dtp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((d.a)localObject).funcId = 716;
    localObject = ((d.a)localObject).bgN();
    dto localdto = (dto)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localdto.jUb = com.tencent.mm.protocal.d.RAx;
    localdto.jUc = com.tencent.mm.protocal.d.RAw;
    localdto.jUd = com.tencent.mm.protocal.d.RAz;
    localdto.jUe = com.tencent.mm.protocal.d.RAA;
    localdto.jUf = LocaleUtil.getApplicationLanguage();
    localdto.Twy = paramInt;
    localdto.Izj = paramString;
    Log.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    aa.a((com.tencent.mm.an.d)localObject, new n.3(Util.nowMilliSecond(), localdto));
    AppMethodBeat.o(151122);
  }
  
  private static String Xq(String paramString)
  {
    AppMethodBeat.i(151119);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(151119);
      return "";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfChar[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && ((k < 48) || (k > 57)) && (k != 124) && (k != 45) && (k != 32) && (k != 58))
      {
        AppMethodBeat.o(151119);
        return "";
      }
      i += 1;
    }
    AppMethodBeat.o(151119);
    return paramString;
  }
  
  /* Error */
  public static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 239
    //   5: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: sipush 2000
    //   12: if_icmplt +15 -> 27
    //   15: fload_1
    //   16: fconst_0
    //   17: fcmpl
    //   18: ifeq +9 -> 27
    //   21: fload_2
    //   22: fconst_0
    //   23: fcmpl
    //   24: ifne +51 -> 75
    //   27: ldc 188
    //   29: ldc 241
    //   31: iconst_4
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_0
    //   38: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: fload_1
    //   45: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: fload_2
    //   52: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: iload_3
    //   59: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 239
    //   68: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: getstatic 98	com/tencent/mm/modelstat/n:mew	J
    //   78: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   81: ldc2_w 254
    //   84: lcmp
    //   85: ifge +59 -> 144
    //   88: ldc 188
    //   90: ldc_w 257
    //   93: iconst_4
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_0
    //   100: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: fload_1
    //   107: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: fload_2
    //   114: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   117: aastore
    //   118: dup
    //   119: iconst_3
    //   120: iload_3
    //   121: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 239
    //   130: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -62 -> 71
    //   136: astore 4
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload 4
    //   143: athrow
    //   144: ldc 188
    //   146: ldc_w 259
    //   149: iconst_5
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iload_0
    //   156: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: fload_1
    //   163: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: fload_2
    //   170: invokestatic 246	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   173: aastore
    //   174: dup
    //   175: iconst_3
    //   176: iload_3
    //   177: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_4
    //   183: getstatic 98	com/tencent/mm/modelstat/n:mew	J
    //   186: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   189: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   199: putstatic 98	com/tencent/mm/modelstat/n:mew	J
    //   202: iload_0
    //   203: putstatic 96	com/tencent/mm/modelstat/n:mev	I
    //   206: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   209: putstatic 88	com/tencent/mm/modelstat/n:mer	J
    //   212: iload_3
    //   213: putstatic 94	com/tencent/mm/modelstat/n:meu	I
    //   216: fload_2
    //   217: putstatic 90	com/tencent/mm/modelstat/n:mes	F
    //   220: fload_1
    //   221: putstatic 92	com/tencent/mm/modelstat/n:met	F
    //   224: invokestatic 270	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   227: ldc_w 272
    //   230: invokevirtual 278	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   233: ifeq +30 -> 263
    //   236: ldc 188
    //   238: ldc_w 280
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: iload_0
    //   248: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: invokestatic 283	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: ldc 239
    //   257: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: goto -189 -> 71
    //   263: getstatic 289	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   266: invokevirtual 294	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:startScanWiFi	()V
    //   269: invokestatic 72	com/tencent/mm/kernel/h:aHJ	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   272: new 10	com/tencent/mm/modelstat/n$5
    //   275: dup
    //   276: invokespecial 295	com/tencent/mm/modelstat/n$5:<init>	()V
    //   279: ldc2_w 296
    //   282: invokevirtual 301	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToWorkerDelayed	(Ljava/lang/Runnable;J)I
    //   285: pop
    //   286: ldc 239
    //   288: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: goto -220 -> 71
    //   294: astore 4
    //   296: ldc 188
    //   298: ldc_w 303
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload 4
    //   309: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: ldc 239
    //   318: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: goto -250 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramInt1	int
    //   0	324	1	paramFloat1	float
    //   0	324	2	paramFloat2	float
    //   0	324	3	paramInt2	int
    //   136	6	4	localObject	Object
    //   294	14	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	8	136	finally
    //   27	71	136	finally
    //   75	133	136	finally
    //   144	260	136	finally
    //   263	286	136	finally
    //   286	291	136	finally
    //   296	321	136	finally
    //   263	286	294	java/lang/Exception
  }
  
  private static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151121);
    long l1 = Util.nowMilliSecond();
    if ((meq > 0L) && (l1 - meq > 5000L))
    {
      Log.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[] { Long.valueOf(meq), Long.valueOf(l1 - meq) });
      AppMethodBeat.o(151121);
      return;
    }
    String[] arrayOfString = wV(paramInt1);
    if ((arrayOfString == null) || (arrayOfString.length != 4) || (Util.isNullOrNil(arrayOfString[0])))
    {
      Log.e("MicroMsg.NetTypeReporter", "report get failed val");
      AppMethodBeat.o(151121);
      return;
    }
    Log.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(l1)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(paramLong), arrayOfString[0] });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dto();
    ((d.a)localObject).lBV = new dtp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((d.a)localObject).funcId = 716;
    com.tencent.mm.an.d locald = ((d.a)localObject).bgN();
    dto localdto = (dto)d.b.b(locald.lBR);
    localdto.jUb = com.tencent.mm.protocal.d.RAx;
    localdto.jUc = com.tencent.mm.protocal.d.RAw;
    localdto.jUd = com.tencent.mm.protocal.d.RAz;
    localdto.jUe = com.tencent.mm.protocal.d.RAA;
    localdto.jUf = LocaleUtil.getApplicationLanguage();
    localdto.Twy = 11747;
    long l2 = Util.milliSecondsToNow(meq);
    if (l2 <= 600000L)
    {
      l1 = l2;
      if (l2 >= 0L) {}
    }
    else
    {
      l1 = 0L;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(arrayOfString[0]).append("0,").append(paramFloat1).append(",").append(paramFloat2).append(",").append(paramInt2).append(",").append(paramLong).append(",");
    if (CrashReportFactory.foreground) {}
    for (localObject = "1";; localObject = String.valueOf(l1))
    {
      localdto.Izj = ((String)localObject + "," + arrayOfString[1] + "," + arrayOfString[2] + "," + arrayOfString[3]);
      aa.a(locald, new n.2(Util.nowMilliSecond(), localdto, arrayOfString, paramFloat1, paramFloat2, paramInt2, paramLong), true);
      AppMethodBeat.o(151121);
      return;
    }
  }
  
  private static void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151123);
    try
    {
      Log.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(meo)), Long.valueOf(meo) });
      if ((paramInt1 > 2000) || (Util.milliSecondsToNow(meo) > 300000L))
      {
        Log.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(meo)), Long.valueOf(meo) });
        mep = paramInt1;
        meo = 9223372036854775807L;
        a(paramInt1, paramFloat1, paramFloat2, paramInt2, paramLong);
        AppMethodBeat.o(151123);
        return;
      }
      if (meo == 9223372036854775807L) {
        meo = Util.nowMilliSecond() + 60000L;
      }
      mep = paramInt1;
      timer.startTimer(60000L);
      AppMethodBeat.o(151123);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(151123);
    }
  }
  
  private static long bpy()
  {
    AppMethodBeat.i(151120);
    synchronized (lock)
    {
      try
      {
        long l = Util.nullAs((Long)h.aHG().aHp().get(ar.a.Vht, null), 1L);
        h.aHG().aHp().set(ar.a.Vht, Long.valueOf(1L + l));
        h.aHG().aHp().hxT();
        Log.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[] { Long.valueOf(l), Long.valueOf(Util.nullAs((Long)h.aHG().aHp().get(ar.a.Vht, null), 1L)) });
        AppMethodBeat.o(151120);
        return l;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(151120);
        return -1L;
      }
    }
  }
  
  public static void bpz()
  {
    for (;;)
    {
      long l;
      int i;
      float f1;
      float f2;
      int j;
      try
      {
        AppMethodBeat.i(205509);
        Log.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d", new Object[] { Integer.valueOf(1005), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(mer) });
      }
      finally {}
      try
      {
        if (mer <= 0L) {
          continue;
        }
        Log.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", new Object[] { Integer.valueOf(1005), Integer.valueOf(mev), Float.valueOf(met), Float.valueOf(mes), Integer.valueOf(meu), Long.valueOf(mer) });
        l = Util.milliSecondsToNow(mer);
        i = mev;
        f1 = mes;
        f2 = met;
        j = meu;
        mer = 0L;
        mes = 0.0F;
        met = 0.0F;
        meu = 0;
        mev = 0;
        b(i, f2, f1, j, l);
        AppMethodBeat.o(205509);
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { Util.stackTraceToString(localThrowable) });
        AppMethodBeat.o(205509);
        continue;
      }
      return;
      if (!CrashReportFactory.foreground)
      {
        Log.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", new Object[] { Integer.valueOf(1005) });
        AppMethodBeat.o(205509);
      }
      else
      {
        b(1005, 0.0F, 0.0F, 0, 0L);
        AppMethodBeat.o(205509);
      }
    }
  }
  
  public static void de(Context paramContext)
  {
    AppMethodBeat.i(151116);
    if (paramContext == null) {}
    try
    {
      Log.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
      AppMethodBeat.o(151116);
      return;
    }
    catch (Throwable paramContext)
    {
      n.a locala;
      IntentFilter localIntentFilter;
      Log.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(151116);
    }
    locala = new n.a((byte)0);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(locala, localIntentFilter);
    Log.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    AppMethodBeat.o(151116);
    return;
  }
  
  public static void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(151124);
    if (paramBoolean)
    {
      meq = 0L;
      AppMethodBeat.o(151124);
      return;
    }
    if (timer.stopped())
    {
      AppMethodBeat.o(151124);
      return;
    }
    Log.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
    meq = Util.nowMilliSecond();
    timer.startTimer(0L);
    AppMethodBeat.o(151124);
  }
  
  /* Error */
  private static String[] wV(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 489
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 188
    //   8: ldc_w 491
    //   11: iconst_4
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_0
    //   18: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: getstatic 357	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   27: invokestatic 444	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: getstatic 86	com/tencent/mm/modelstat/n:meq	J
    //   36: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: getstatic 86	com/tencent/mm/modelstat/n:meq	J
    //   45: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   48: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: iload_0
    //   56: ifgt +30 -> 86
    //   59: ldc 188
    //   61: ldc_w 493
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: ldc_w 489
    //   81: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: invokestatic 270	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   89: astore 11
    //   91: aload 11
    //   93: ifnonnull +30 -> 123
    //   96: ldc 188
    //   98: ldc_w 495
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_0
    //   108: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: ldc_w 489
    //   118: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: ldc 188
    //   125: ldc_w 497
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: iload_0
    //   135: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: getstatic 357	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   144: invokestatic 444	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: invokestatic 502	com/tencent/mm/compatible/deviceinfo/ac:avq	()I
    //   154: istore_2
    //   155: ldc 188
    //   157: ldc_w 504
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: iload_2
    //   167: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 229
    //   176: astore 7
    //   178: ldc 229
    //   180: astore 15
    //   182: aload 7
    //   184: astore 6
    //   186: new 506	java/lang/StringBuffer
    //   189: dup
    //   190: invokespecial 507	java/lang/StringBuffer:<init>	()V
    //   193: astore 10
    //   195: aload 7
    //   197: astore 6
    //   199: new 506	java/lang/StringBuffer
    //   202: dup
    //   203: invokespecial 507	java/lang/StringBuffer:<init>	()V
    //   206: astore 8
    //   208: aload 7
    //   210: astore 6
    //   212: new 506	java/lang/StringBuffer
    //   215: dup
    //   216: invokespecial 507	java/lang/StringBuffer:<init>	()V
    //   219: astore 9
    //   221: iconst_0
    //   222: istore_1
    //   223: aload 7
    //   225: astore 6
    //   227: new 509	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 510	java/util/ArrayList:<init>	()V
    //   234: astore 12
    //   236: aload 7
    //   238: astore 6
    //   240: aload 10
    //   242: getstatic 289	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   245: invokevirtual 513	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiSsid	()Ljava/lang/String;
    //   248: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: pop
    //   252: aload 7
    //   254: astore 6
    //   256: aload 8
    //   258: getstatic 289	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   261: invokevirtual 519	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiBssid	()Ljava/lang/String;
    //   264: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   267: pop
    //   268: aload 7
    //   270: astore 6
    //   272: getstatic 289	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   275: invokevirtual 519	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiBssid	()Ljava/lang/String;
    //   278: astore 13
    //   280: aload 7
    //   282: astore 6
    //   284: aload 12
    //   286: aload 13
    //   288: invokevirtual 523	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   291: pop
    //   292: aload 7
    //   294: astore 6
    //   296: getstatic 289	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   299: invokevirtual 527	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getWiFiScanResults	()Ljava/util/List;
    //   302: astore 14
    //   304: aload 14
    //   306: ifnull +292 -> 598
    //   309: aload 7
    //   311: astore 6
    //   313: aload 14
    //   315: new 6	com/tencent/mm/modelstat/n$1
    //   318: dup
    //   319: invokespecial 528	com/tencent/mm/modelstat/n$1:<init>	()V
    //   322: invokestatic 534	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   325: bipush 20
    //   327: istore_3
    //   328: aload 7
    //   330: astore 6
    //   332: aload 14
    //   334: invokeinterface 540 1 0
    //   339: astore 14
    //   341: iconst_0
    //   342: istore_1
    //   343: aload 7
    //   345: astore 6
    //   347: aload 14
    //   349: invokeinterface 545 1 0
    //   354: ifeq +1513 -> 1867
    //   357: aload 7
    //   359: astore 6
    //   361: aload 14
    //   363: invokeinterface 549 1 0
    //   368: checkcast 551	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult
    //   371: astore 16
    //   373: aload 16
    //   375: ifnull -32 -> 343
    //   378: aload 7
    //   380: astore 6
    //   382: aload 16
    //   384: invokevirtual 554	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   387: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   390: ifne -47 -> 343
    //   393: aload 7
    //   395: astore 6
    //   397: aload 16
    //   399: invokevirtual 554	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   402: aload 13
    //   404: invokevirtual 557	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +43 -> 450
    //   410: aload 7
    //   412: astore 6
    //   414: aload 16
    //   416: invokevirtual 560	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getLevel	()I
    //   419: istore_1
    //   420: goto -77 -> 343
    //   423: astore 6
    //   425: ldc 188
    //   427: ldc_w 562
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload 6
    //   438: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   441: aastore
    //   442: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: iconst_0
    //   446: istore_2
    //   447: goto -292 -> 155
    //   450: iload_3
    //   451: ifle +1416 -> 1867
    //   454: aload 7
    //   456: astore 6
    //   458: aload 10
    //   460: ldc_w 564
    //   463: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   466: pop
    //   467: aload 7
    //   469: astore 6
    //   471: aload 10
    //   473: aload 16
    //   475: invokevirtual 567	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getSsid	()Ljava/lang/String;
    //   478: invokestatic 570	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   481: ldc_w 564
    //   484: ldc 229
    //   486: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   489: ldc_w 576
    //   492: ldc 229
    //   494: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   497: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   500: pop
    //   501: aload 7
    //   503: astore 6
    //   505: aload 8
    //   507: ldc_w 564
    //   510: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   513: pop
    //   514: aload 7
    //   516: astore 6
    //   518: aload 8
    //   520: aload 16
    //   522: invokevirtual 554	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   525: invokestatic 570	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   528: ldc_w 564
    //   531: ldc 229
    //   533: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   536: ldc_w 576
    //   539: ldc 229
    //   541: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   544: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   547: pop
    //   548: aload 7
    //   550: astore 6
    //   552: aload 12
    //   554: aload 16
    //   556: invokevirtual 554	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   559: invokevirtual 523	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   562: pop
    //   563: aload 7
    //   565: astore 6
    //   567: aload 9
    //   569: ldc_w 564
    //   572: invokevirtual 516	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   575: pop
    //   576: aload 7
    //   578: astore 6
    //   580: aload 9
    //   582: aload 16
    //   584: invokevirtual 560	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getLevel	()I
    //   587: invokevirtual 579	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   590: pop
    //   591: iload_3
    //   592: iconst_1
    //   593: isub
    //   594: istore_3
    //   595: goto -252 -> 343
    //   598: iload_0
    //   599: sipush 2000
    //   602: if_icmpge +46 -> 648
    //   605: aload 7
    //   607: astore 6
    //   609: aload 12
    //   611: invokestatic 583	com/tencent/mm/modelstat/n:x	(Ljava/util/ArrayList;)Z
    //   614: ifne +34 -> 648
    //   617: aload 7
    //   619: astore 6
    //   621: ldc 188
    //   623: ldc_w 585
    //   626: iconst_1
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: iload_0
    //   633: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   636: aastore
    //   637: invokestatic 283	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: ldc_w 489
    //   643: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   646: aconst_null
    //   647: areturn
    //   648: aload 7
    //   650: astore 6
    //   652: aload 10
    //   654: invokevirtual 586	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   657: astore 7
    //   659: aload 7
    //   661: astore 6
    //   663: aload 8
    //   665: invokevirtual 586	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   668: astore 8
    //   670: aload 8
    //   672: astore 6
    //   674: new 333	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   681: iload_1
    //   682: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: aload 9
    //   687: invokevirtual 586	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   690: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: astore 8
    //   698: aload 8
    //   700: astore 15
    //   702: aload 7
    //   704: astore 17
    //   706: aload 6
    //   708: astore 16
    //   710: ldc 188
    //   712: ldc_w 588
    //   715: iconst_2
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: aload 16
    //   723: aastore
    //   724: dup
    //   725: iconst_1
    //   726: aload 17
    //   728: aastore
    //   729: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   732: ldc 229
    //   734: astore 18
    //   736: aload 11
    //   738: ldc_w 590
    //   741: invokevirtual 594	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   744: checkcast 596	android/telephony/TelephonyManager
    //   747: astore 6
    //   749: aload 6
    //   751: ifnull +1109 -> 1860
    //   754: aload 6
    //   756: invokevirtual 599	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   759: astore 6
    //   761: aload 6
    //   763: astore 18
    //   765: ldc 188
    //   767: ldc_w 601
    //   770: iconst_1
    //   771: anewarray 4	java/lang/Object
    //   774: dup
    //   775: iconst_0
    //   776: aload 18
    //   778: aastore
    //   779: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: ldc 229
    //   784: astore 10
    //   786: ldc 229
    //   788: astore 8
    //   790: ldc 229
    //   792: astore 9
    //   794: ldc 229
    //   796: astore 7
    //   798: ldc 229
    //   800: astore 6
    //   802: aload 11
    //   804: invokestatic 607	com/tencent/mm/sdk/platformtools/NetStatusUtil:getCellInfoList	(Landroid/content/Context;)Ljava/util/List;
    //   807: astore 19
    //   809: iconst_0
    //   810: istore_1
    //   811: ldc 229
    //   813: astore 11
    //   815: aload 8
    //   817: astore 9
    //   819: aload 11
    //   821: astore 8
    //   823: aload 9
    //   825: astore 14
    //   827: aload 10
    //   829: astore 13
    //   831: iload_1
    //   832: aload 19
    //   834: invokeinterface 610 1 0
    //   839: if_icmpge +584 -> 1423
    //   842: aload 9
    //   844: astore 14
    //   846: aload 10
    //   848: astore 13
    //   850: aload 19
    //   852: iload_1
    //   853: invokeinterface 613 2 0
    //   858: checkcast 615	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   861: astore 20
    //   863: aload 9
    //   865: astore 14
    //   867: aload 10
    //   869: astore 13
    //   871: aload 20
    //   873: getfield 618	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mcc	Ljava/lang/String;
    //   876: ldc 229
    //   878: invokestatic 621	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   881: astore 11
    //   883: aload 9
    //   885: astore 14
    //   887: aload 11
    //   889: astore 13
    //   891: aload 20
    //   893: getfield 624	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mnc	Ljava/lang/String;
    //   896: ldc 229
    //   898: invokestatic 621	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   901: astore 12
    //   903: aload 12
    //   905: astore 14
    //   907: aload 11
    //   909: astore 13
    //   911: aload 8
    //   913: invokevirtual 627	java/lang/String:length	()I
    //   916: ifle +937 -> 1853
    //   919: aload 12
    //   921: astore 14
    //   923: aload 11
    //   925: astore 13
    //   927: aload 20
    //   929: getfield 630	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   932: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   935: ifne +918 -> 1853
    //   938: aload 12
    //   940: astore 14
    //   942: aload 11
    //   944: astore 13
    //   946: new 333	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   953: aload 8
    //   955: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 564
    //   961: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: astore 10
    //   969: aload 10
    //   971: astore 9
    //   973: aload 6
    //   975: astore 13
    //   977: aload 7
    //   979: astore 8
    //   981: aload 10
    //   983: astore 14
    //   985: aload 20
    //   987: getfield 630	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   990: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   993: ifne +40 -> 1033
    //   996: aload 6
    //   998: astore 13
    //   1000: aload 7
    //   1002: astore 8
    //   1004: aload 10
    //   1006: astore 14
    //   1008: new 333	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1015: aload 10
    //   1017: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 20
    //   1022: getfield 630	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   1025: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: astore 9
    //   1033: aload 7
    //   1035: astore 10
    //   1037: aload 6
    //   1039: astore 13
    //   1041: aload 7
    //   1043: astore 8
    //   1045: aload 9
    //   1047: astore 14
    //   1049: aload 7
    //   1051: invokevirtual 627	java/lang/String:length	()I
    //   1054: ifle +65 -> 1119
    //   1057: aload 7
    //   1059: astore 10
    //   1061: aload 6
    //   1063: astore 13
    //   1065: aload 7
    //   1067: astore 8
    //   1069: aload 9
    //   1071: astore 14
    //   1073: aload 20
    //   1075: getfield 633	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1078: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1081: ifne +38 -> 1119
    //   1084: aload 6
    //   1086: astore 13
    //   1088: aload 7
    //   1090: astore 8
    //   1092: aload 9
    //   1094: astore 14
    //   1096: new 333	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1103: aload 7
    //   1105: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: ldc_w 564
    //   1111: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: astore 10
    //   1119: aload 10
    //   1121: astore 7
    //   1123: aload 6
    //   1125: astore 13
    //   1127: aload 10
    //   1129: astore 8
    //   1131: aload 9
    //   1133: astore 14
    //   1135: aload 20
    //   1137: getfield 633	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1140: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1143: ifne +40 -> 1183
    //   1146: aload 6
    //   1148: astore 13
    //   1150: aload 10
    //   1152: astore 8
    //   1154: aload 9
    //   1156: astore 14
    //   1158: new 333	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1165: aload 10
    //   1167: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload 20
    //   1172: getfield 633	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1175: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: astore 7
    //   1183: aload 6
    //   1185: astore 10
    //   1187: aload 6
    //   1189: astore 13
    //   1191: aload 7
    //   1193: astore 8
    //   1195: aload 9
    //   1197: astore 14
    //   1199: aload 6
    //   1201: invokevirtual 627	java/lang/String:length	()I
    //   1204: ifle +38 -> 1242
    //   1207: aload 6
    //   1209: astore 13
    //   1211: aload 7
    //   1213: astore 8
    //   1215: aload 9
    //   1217: astore 14
    //   1219: new 333	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1226: aload 6
    //   1228: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: ldc_w 564
    //   1234: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: astore 10
    //   1242: aload 10
    //   1244: astore 13
    //   1246: aload 7
    //   1248: astore 8
    //   1250: aload 9
    //   1252: astore 14
    //   1254: new 333	java/lang/StringBuilder
    //   1257: dup
    //   1258: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1261: aload 10
    //   1263: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: astore 21
    //   1268: aload 10
    //   1270: astore 13
    //   1272: aload 7
    //   1274: astore 8
    //   1276: aload 9
    //   1278: astore 14
    //   1280: aload 20
    //   1282: getfield 636	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1285: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1288: ifeq +113 -> 1401
    //   1291: ldc_w 638
    //   1294: astore 6
    //   1296: aload 10
    //   1298: astore 13
    //   1300: aload 7
    //   1302: astore 8
    //   1304: aload 9
    //   1306: astore 14
    //   1308: aload 21
    //   1310: aload 6
    //   1312: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: astore 6
    //   1320: iload_1
    //   1321: iconst_1
    //   1322: iadd
    //   1323: istore_1
    //   1324: aload 9
    //   1326: astore 8
    //   1328: aload 12
    //   1330: astore 9
    //   1332: aload 11
    //   1334: astore 10
    //   1336: goto -513 -> 823
    //   1339: astore 7
    //   1341: ldc 229
    //   1343: astore 8
    //   1345: ldc 188
    //   1347: ldc_w 640
    //   1350: iconst_1
    //   1351: anewarray 4	java/lang/Object
    //   1354: dup
    //   1355: iconst_0
    //   1356: aload 7
    //   1358: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1361: aastore
    //   1362: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1365: aload 8
    //   1367: astore 16
    //   1369: aload 6
    //   1371: astore 17
    //   1373: goto -663 -> 710
    //   1376: astore 6
    //   1378: ldc 188
    //   1380: ldc_w 562
    //   1383: iconst_1
    //   1384: anewarray 4	java/lang/Object
    //   1387: dup
    //   1388: iconst_0
    //   1389: aload 6
    //   1391: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1394: aastore
    //   1395: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1398: goto -633 -> 765
    //   1401: aload 10
    //   1403: astore 13
    //   1405: aload 7
    //   1407: astore 8
    //   1409: aload 9
    //   1411: astore 14
    //   1413: aload 20
    //   1415: getfield 636	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1418: astore 6
    //   1420: goto -124 -> 1296
    //   1423: aload 8
    //   1425: astore 11
    //   1427: aload 9
    //   1429: astore 8
    //   1431: aload 11
    //   1433: astore 9
    //   1435: ldc 188
    //   1437: ldc_w 642
    //   1440: iconst_3
    //   1441: anewarray 4	java/lang/Object
    //   1444: dup
    //   1445: iconst_0
    //   1446: aload 10
    //   1448: aastore
    //   1449: dup
    //   1450: iconst_1
    //   1451: aload 8
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_2
    //   1456: aload 9
    //   1458: aastore
    //   1459: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1462: new 333	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1469: astore 11
    //   1471: aload 11
    //   1473: invokestatic 645	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1476: invokevirtual 351	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1479: ldc_w 345
    //   1482: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: pop
    //   1486: aload 11
    //   1488: iload_0
    //   1489: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1492: ldc_w 345
    //   1495: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: pop
    //   1499: aload 11
    //   1501: iload_2
    //   1502: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1505: ldc_w 345
    //   1508: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: pop
    //   1512: aload 11
    //   1514: aload 17
    //   1516: ldc_w 345
    //   1519: ldc_w 576
    //   1522: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1525: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 345
    //   1531: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload 11
    //   1537: aload 16
    //   1539: ldc_w 345
    //   1542: ldc_w 576
    //   1545: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1548: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1551: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: ldc_w 345
    //   1557: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload 11
    //   1563: aload 18
    //   1565: ldc_w 345
    //   1568: ldc_w 576
    //   1571: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1574: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: ldc_w 345
    //   1580: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: aload 11
    //   1586: aload 10
    //   1588: ldc_w 345
    //   1591: ldc_w 576
    //   1594: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1597: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: ldc_w 345
    //   1606: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: pop
    //   1610: aload 11
    //   1612: aload 8
    //   1614: ldc_w 345
    //   1617: ldc_w 576
    //   1620: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1623: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1626: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: ldc_w 345
    //   1632: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: pop
    //   1636: aload 11
    //   1638: aload 9
    //   1640: ldc_w 345
    //   1643: ldc_w 576
    //   1646: invokevirtual 574	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1649: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1652: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: ldc_w 345
    //   1658: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: invokestatic 649	com/tencent/mm/modelstat/n:bpy	()J
    //   1665: lstore 4
    //   1667: lload 4
    //   1669: lconst_0
    //   1670: lcmp
    //   1671: ifge +36 -> 1707
    //   1674: ldc_w 489
    //   1677: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1680: aconst_null
    //   1681: areturn
    //   1682: astore 11
    //   1684: ldc 188
    //   1686: ldc_w 562
    //   1689: iconst_1
    //   1690: anewarray 4	java/lang/Object
    //   1693: dup
    //   1694: iconst_0
    //   1695: aload 11
    //   1697: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1700: aastore
    //   1701: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1704: goto -269 -> 1435
    //   1707: new 333	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   1714: lload 4
    //   1716: invokevirtual 351	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1719: ldc_w 345
    //   1722: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: aload 11
    //   1727: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1730: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1736: astore 8
    //   1738: aload 15
    //   1740: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1743: astore 9
    //   1745: aload 7
    //   1747: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1750: astore 7
    //   1752: aload 6
    //   1754: invokestatic 647	com/tencent/mm/modelstat/n:Xq	(Ljava/lang/String;)Ljava/lang/String;
    //   1757: astore 6
    //   1759: ldc_w 489
    //   1762: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1765: iconst_4
    //   1766: anewarray 231	java/lang/String
    //   1769: dup
    //   1770: iconst_0
    //   1771: aload 8
    //   1773: aastore
    //   1774: dup
    //   1775: iconst_1
    //   1776: aload 9
    //   1778: aastore
    //   1779: dup
    //   1780: iconst_2
    //   1781: aload 7
    //   1783: aastore
    //   1784: dup
    //   1785: iconst_3
    //   1786: aload 6
    //   1788: aastore
    //   1789: areturn
    //   1790: astore 19
    //   1792: aload 14
    //   1794: astore 9
    //   1796: aload 13
    //   1798: astore 6
    //   1800: aload 8
    //   1802: astore 7
    //   1804: aload 12
    //   1806: astore 8
    //   1808: aload 11
    //   1810: astore 10
    //   1812: aload 19
    //   1814: astore 11
    //   1816: goto -132 -> 1684
    //   1819: astore 11
    //   1821: aload 8
    //   1823: astore 9
    //   1825: aload 14
    //   1827: astore 8
    //   1829: aload 13
    //   1831: astore 10
    //   1833: goto -149 -> 1684
    //   1836: astore 9
    //   1838: aload 6
    //   1840: astore 8
    //   1842: aload 7
    //   1844: astore 6
    //   1846: aload 9
    //   1848: astore 7
    //   1850: goto -505 -> 1345
    //   1853: aload 8
    //   1855: astore 10
    //   1857: goto -888 -> 969
    //   1860: ldc 229
    //   1862: astore 6
    //   1864: goto -1103 -> 761
    //   1867: goto -1269 -> 598
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1870	0	paramInt	int
    //   222	1102	1	i	int
    //   154	1348	2	j	int
    //   327	268	3	k	int
    //   1665	50	4	l	long
    //   184	229	6	localObject1	Object
    //   423	14	6	localException1	Exception
    //   456	914	6	localObject2	Object
    //   1376	14	6	localException2	Exception
    //   1418	445	6	localObject3	Object
    //   176	1125	7	localObject4	Object
    //   1339	407	7	localException3	Exception
    //   1750	99	7	localObject5	Object
    //   206	1648	8	localObject6	Object
    //   219	1605	9	localObject7	Object
    //   1836	11	9	localException4	Exception
    //   193	1663	10	localObject8	Object
    //   89	1548	11	localObject9	Object
    //   1682	127	11	localException5	Exception
    //   1814	1	11	localObject10	Object
    //   1819	1	11	localException6	Exception
    //   234	1571	12	localObject11	Object
    //   278	1552	13	localObject12	Object
    //   302	1524	14	localObject13	Object
    //   180	1559	15	localObject14	Object
    //   371	1167	16	localObject15	Object
    //   704	811	17	localObject16	Object
    //   734	830	18	localObject17	Object
    //   807	44	19	localList	java.util.List
    //   1790	23	19	localException7	Exception
    //   861	553	20	localCellInfo	com.tencent.mm.sdk.platformtools.NetStatusUtil.CellInfo
    //   1266	43	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   151	155	423	java/lang/Exception
    //   186	195	1339	java/lang/Exception
    //   199	208	1339	java/lang/Exception
    //   212	221	1339	java/lang/Exception
    //   227	236	1339	java/lang/Exception
    //   240	252	1339	java/lang/Exception
    //   256	268	1339	java/lang/Exception
    //   272	280	1339	java/lang/Exception
    //   284	292	1339	java/lang/Exception
    //   296	304	1339	java/lang/Exception
    //   313	325	1339	java/lang/Exception
    //   332	341	1339	java/lang/Exception
    //   347	357	1339	java/lang/Exception
    //   361	373	1339	java/lang/Exception
    //   382	393	1339	java/lang/Exception
    //   397	410	1339	java/lang/Exception
    //   414	420	1339	java/lang/Exception
    //   458	467	1339	java/lang/Exception
    //   471	501	1339	java/lang/Exception
    //   505	514	1339	java/lang/Exception
    //   518	548	1339	java/lang/Exception
    //   552	563	1339	java/lang/Exception
    //   567	576	1339	java/lang/Exception
    //   580	591	1339	java/lang/Exception
    //   609	617	1339	java/lang/Exception
    //   621	640	1339	java/lang/Exception
    //   652	659	1339	java/lang/Exception
    //   663	670	1339	java/lang/Exception
    //   736	749	1376	java/lang/Exception
    //   754	761	1376	java/lang/Exception
    //   802	809	1682	java/lang/Exception
    //   985	996	1790	java/lang/Exception
    //   1008	1033	1790	java/lang/Exception
    //   1049	1057	1790	java/lang/Exception
    //   1073	1084	1790	java/lang/Exception
    //   1096	1119	1790	java/lang/Exception
    //   1135	1146	1790	java/lang/Exception
    //   1158	1183	1790	java/lang/Exception
    //   1199	1207	1790	java/lang/Exception
    //   1219	1242	1790	java/lang/Exception
    //   1254	1268	1790	java/lang/Exception
    //   1280	1291	1790	java/lang/Exception
    //   1308	1320	1790	java/lang/Exception
    //   1413	1420	1790	java/lang/Exception
    //   831	842	1819	java/lang/Exception
    //   850	863	1819	java/lang/Exception
    //   871	883	1819	java/lang/Exception
    //   891	903	1819	java/lang/Exception
    //   911	919	1819	java/lang/Exception
    //   927	938	1819	java/lang/Exception
    //   946	969	1819	java/lang/Exception
    //   674	698	1836	java/lang/Exception
  }
  
  /* Error */
  private static boolean x(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 672
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 673	java/util/ArrayList:size	()I
    //   10: ifne +19 -> 29
    //   13: ldc 188
    //   15: ldc_w 675
    //   18: invokestatic 677	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 672
    //   24: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   32: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifeq +31 -> 66
    //   38: new 333	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   45: invokestatic 400	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   48: getfield 680	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
    //   51: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 682
    //   57: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: putstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   66: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   69: invokevirtual 683	java/util/HashMap:size	()I
    //   72: ifne +173 -> 245
    //   75: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   78: invokestatic 689	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   81: ldc2_w 690
    //   84: lcmp
    //   85: ifle +10 -> 95
    //   88: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   91: invokestatic 694	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   94: pop
    //   95: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   98: invokestatic 698	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   101: astore 4
    //   103: new 700	java/io/ObjectInputStream
    //   106: dup
    //   107: new 702	java/io/BufferedInputStream
    //   110: dup
    //   111: aload 4
    //   113: invokespecial 705	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 706	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 5
    //   121: aload 5
    //   123: astore 7
    //   125: aload 4
    //   127: astore 6
    //   129: aload 5
    //   131: invokevirtual 709	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   134: checkcast 49	java/util/HashMap
    //   137: putstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   140: aload 5
    //   142: astore 7
    //   144: aload 4
    //   146: astore 6
    //   148: ldc 188
    //   150: ldc_w 711
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   162: invokevirtual 683	java/util/HashMap:size	()I
    //   165: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 5
    //   174: invokevirtual 714	java/io/ObjectInputStream:close	()V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 717	java/io/InputStream:close	()V
    //   187: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   190: invokevirtual 683	java/util/HashMap:size	()I
    //   193: ifle +15 -> 208
    //   196: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   199: invokevirtual 683	java/util/HashMap:size	()I
    //   202: sipush 1000
    //   205: if_icmple +40 -> 245
    //   208: ldc 188
    //   210: ldc_w 719
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   222: invokevirtual 683	java/util/HashMap:size	()I
    //   225: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   241: invokestatic 694	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   244: pop
    //   245: aload_0
    //   246: invokevirtual 720	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   249: astore_0
    //   250: iconst_0
    //   251: istore_1
    //   252: aload_0
    //   253: invokeinterface 545 1 0
    //   258: ifeq +305 -> 563
    //   261: aload_0
    //   262: invokeinterface 549 1 0
    //   267: checkcast 231	java/lang/String
    //   270: astore 4
    //   272: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   275: aload 4
    //   277: invokevirtual 723	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: iconst_0
    //   281: invokestatic 727	com/tencent/mm/sdk/platformtools/Util:nullAsLong	(Ljava/lang/Object;I)J
    //   284: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   287: lstore_2
    //   288: ldc 188
    //   290: ldc_w 729
    //   293: iconst_2
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload 4
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: lload_2
    //   305: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   308: aastore
    //   309: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: lload_2
    //   313: lconst_0
    //   314: lcmp
    //   315: ifle +11 -> 326
    //   318: lload_2
    //   319: getstatic 47	com/tencent/mm/modelstat/n:mel	J
    //   322: lcmp
    //   323: ifle +563 -> 886
    //   326: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   329: aload 4
    //   331: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   334: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: invokevirtual 733	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: iconst_1
    //   342: istore_1
    //   343: goto -91 -> 252
    //   346: astore 4
    //   348: ldc 188
    //   350: ldc_w 735
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 4
    //   361: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   364: aastore
    //   365: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: new 49	java/util/HashMap
    //   371: dup
    //   372: invokespecial 52	java/util/HashMap:<init>	()V
    //   375: putstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   378: goto -191 -> 187
    //   381: astore 8
    //   383: aconst_null
    //   384: astore 5
    //   386: aconst_null
    //   387: astore 4
    //   389: aload 5
    //   391: astore 7
    //   393: aload 4
    //   395: astore 6
    //   397: ldc 188
    //   399: ldc_w 735
    //   402: iconst_1
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: aload 8
    //   410: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   413: aastore
    //   414: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aload 5
    //   419: astore 7
    //   421: aload 4
    //   423: astore 6
    //   425: new 49	java/util/HashMap
    //   428: dup
    //   429: invokespecial 52	java/util/HashMap:<init>	()V
    //   432: putstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   435: aload 5
    //   437: ifnull +8 -> 445
    //   440: aload 5
    //   442: invokevirtual 714	java/io/ObjectInputStream:close	()V
    //   445: aload 4
    //   447: ifnull -260 -> 187
    //   450: aload 4
    //   452: invokevirtual 717	java/io/InputStream:close	()V
    //   455: goto -268 -> 187
    //   458: astore 4
    //   460: ldc 188
    //   462: ldc_w 735
    //   465: iconst_1
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 4
    //   473: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: aastore
    //   477: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: new 49	java/util/HashMap
    //   483: dup
    //   484: invokespecial 52	java/util/HashMap:<init>	()V
    //   487: putstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   490: goto -303 -> 187
    //   493: astore_0
    //   494: aconst_null
    //   495: astore 7
    //   497: aconst_null
    //   498: astore 4
    //   500: aload 7
    //   502: ifnull +8 -> 510
    //   505: aload 7
    //   507: invokevirtual 714	java/io/ObjectInputStream:close	()V
    //   510: aload 4
    //   512: ifnull +8 -> 520
    //   515: aload 4
    //   517: invokevirtual 717	java/io/InputStream:close	()V
    //   520: ldc_w 672
    //   523: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   526: aload_0
    //   527: athrow
    //   528: astore 4
    //   530: ldc 188
    //   532: ldc_w 735
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload 4
    //   543: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   546: aastore
    //   547: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: new 49	java/util/HashMap
    //   553: dup
    //   554: invokespecial 52	java/util/HashMap:<init>	()V
    //   557: putstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   560: goto -40 -> 520
    //   563: iload_1
    //   564: ifeq +99 -> 663
    //   567: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   570: invokevirtual 683	java/util/HashMap:size	()I
    //   573: ifle +90 -> 663
    //   576: getstatic 56	com/tencent/mm/modelstat/n:men	Ljava/lang/String;
    //   579: invokestatic 739	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   582: astore_0
    //   583: new 741	java/io/ObjectOutputStream
    //   586: dup
    //   587: aload_0
    //   588: invokespecial 744	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   591: astore 4
    //   593: aload 4
    //   595: astore 6
    //   597: aload_0
    //   598: astore 5
    //   600: aload 4
    //   602: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   605: invokevirtual 748	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   608: aload 4
    //   610: astore 6
    //   612: aload_0
    //   613: astore 5
    //   615: aload_0
    //   616: invokevirtual 753	java/io/OutputStream:flush	()V
    //   619: aload 4
    //   621: astore 6
    //   623: aload_0
    //   624: astore 5
    //   626: ldc 188
    //   628: ldc_w 755
    //   631: iconst_1
    //   632: anewarray 4	java/lang/Object
    //   635: dup
    //   636: iconst_0
    //   637: getstatic 54	com/tencent/mm/modelstat/n:mem	Ljava/util/HashMap;
    //   640: invokevirtual 683	java/util/HashMap:size	()I
    //   643: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: aastore
    //   647: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: aload 4
    //   652: invokevirtual 756	java/io/ObjectOutputStream:close	()V
    //   655: aload_0
    //   656: ifnull +7 -> 663
    //   659: aload_0
    //   660: invokevirtual 757	java/io/OutputStream:close	()V
    //   663: ldc_w 672
    //   666: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   669: iload_1
    //   670: ireturn
    //   671: astore_0
    //   672: ldc 188
    //   674: ldc_w 759
    //   677: iconst_1
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: aload_0
    //   684: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   687: aastore
    //   688: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: goto -28 -> 663
    //   694: astore 7
    //   696: aconst_null
    //   697: astore 4
    //   699: aconst_null
    //   700: astore_0
    //   701: aload 4
    //   703: astore 6
    //   705: aload_0
    //   706: astore 5
    //   708: ldc 188
    //   710: ldc_w 759
    //   713: iconst_1
    //   714: anewarray 4	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: aload 7
    //   721: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   724: aastore
    //   725: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   728: aload 4
    //   730: ifnull +8 -> 738
    //   733: aload 4
    //   735: invokevirtual 756	java/io/ObjectOutputStream:close	()V
    //   738: aload_0
    //   739: ifnull -76 -> 663
    //   742: aload_0
    //   743: invokevirtual 757	java/io/OutputStream:close	()V
    //   746: goto -83 -> 663
    //   749: astore_0
    //   750: ldc 188
    //   752: ldc_w 759
    //   755: iconst_1
    //   756: anewarray 4	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: aload_0
    //   762: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   765: aastore
    //   766: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   769: goto -106 -> 663
    //   772: astore 4
    //   774: aconst_null
    //   775: astore 6
    //   777: aconst_null
    //   778: astore_0
    //   779: aload 6
    //   781: ifnull +8 -> 789
    //   784: aload 6
    //   786: invokevirtual 756	java/io/ObjectOutputStream:close	()V
    //   789: aload_0
    //   790: ifnull +7 -> 797
    //   793: aload_0
    //   794: invokevirtual 757	java/io/OutputStream:close	()V
    //   797: ldc_w 672
    //   800: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   803: aload 4
    //   805: athrow
    //   806: astore_0
    //   807: ldc 188
    //   809: ldc_w 759
    //   812: iconst_1
    //   813: anewarray 4	java/lang/Object
    //   816: dup
    //   817: iconst_0
    //   818: aload_0
    //   819: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   822: aastore
    //   823: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   826: goto -29 -> 797
    //   829: astore 4
    //   831: aconst_null
    //   832: astore 6
    //   834: goto -55 -> 779
    //   837: astore 4
    //   839: aload 5
    //   841: astore_0
    //   842: goto -63 -> 779
    //   845: astore 7
    //   847: aconst_null
    //   848: astore 4
    //   850: goto -149 -> 701
    //   853: astore 7
    //   855: goto -154 -> 701
    //   858: astore_0
    //   859: aconst_null
    //   860: astore 7
    //   862: goto -362 -> 500
    //   865: astore_0
    //   866: aload 6
    //   868: astore 4
    //   870: goto -370 -> 500
    //   873: astore 8
    //   875: aconst_null
    //   876: astore 5
    //   878: goto -489 -> 389
    //   881: astore 8
    //   883: goto -494 -> 389
    //   886: goto -543 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	paramArrayList	java.util.ArrayList<String>
    //   251	419	1	bool	boolean
    //   287	32	2	l	long
    //   101	229	4	localObject1	Object
    //   346	14	4	localException1	Exception
    //   387	64	4	localObject2	Object
    //   458	14	4	localException2	Exception
    //   498	18	4	localObject3	Object
    //   528	14	4	localException3	Exception
    //   591	143	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   772	32	4	localObject4	Object
    //   829	1	4	localObject5	Object
    //   837	1	4	localObject6	Object
    //   848	21	4	localObject7	Object
    //   119	758	5	localObject8	Object
    //   127	740	6	localObject9	Object
    //   123	383	7	localObject10	Object
    //   694	26	7	localException4	Exception
    //   845	1	7	localException5	Exception
    //   853	1	7	localException6	Exception
    //   860	1	7	localObject11	Object
    //   381	28	8	localException7	Exception
    //   873	1	8	localException8	Exception
    //   881	1	8	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   172	177	346	java/lang/Exception
    //   182	187	346	java/lang/Exception
    //   75	95	381	java/lang/Exception
    //   95	103	381	java/lang/Exception
    //   440	445	458	java/lang/Exception
    //   450	455	458	java/lang/Exception
    //   75	95	493	finally
    //   95	103	493	finally
    //   505	510	528	java/lang/Exception
    //   515	520	528	java/lang/Exception
    //   650	655	671	java/lang/Exception
    //   659	663	671	java/lang/Exception
    //   576	583	694	java/lang/Exception
    //   733	738	749	java/lang/Exception
    //   742	746	749	java/lang/Exception
    //   576	583	772	finally
    //   784	789	806	java/lang/Exception
    //   793	797	806	java/lang/Exception
    //   583	593	829	finally
    //   600	608	837	finally
    //   615	619	837	finally
    //   626	650	837	finally
    //   708	728	837	finally
    //   583	593	845	java/lang/Exception
    //   600	608	853	java/lang/Exception
    //   615	619	853	java/lang/Exception
    //   626	650	853	java/lang/Exception
    //   103	121	858	finally
    //   129	140	865	finally
    //   148	172	865	finally
    //   397	417	865	finally
    //   425	435	865	finally
    //   103	121	873	java/lang/Exception
    //   129	140	881	java/lang/Exception
    //   148	172	881	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */