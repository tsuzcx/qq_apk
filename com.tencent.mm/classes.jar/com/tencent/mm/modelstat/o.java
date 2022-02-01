package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
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

public final class o
{
  private static long joV;
  private static HashMap<String, Long> joW;
  private static String joX;
  private static long joY;
  private static int joZ;
  private static long jpa;
  private static long jpb;
  private static float jpc;
  private static float jpd;
  private static int jpe;
  private static int jpf;
  private static long jpg;
  private static String jph;
  private static final byte[] lock;
  private static MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(151129);
    joV = 86400000L;
    joW = new HashMap();
    joX = null;
    lock = new byte[0];
    joY = 9223372036854775807L;
    joZ = 0;
    timer = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151113);
        try
        {
          o.bgl();
          if ((o.joZ < 2000) && (o.joZ > 1000)) {
            o.tX(o.joZ);
          }
          for (;;)
          {
            AppMethodBeat.o(151113);
            return false;
            o.tY(o.joZ);
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
    jpa = 0L;
    jpb = 0L;
    jpc = 0.0F;
    jpd = 0.0F;
    jpe = 0;
    jpf = 0;
    jpg = 0L;
    jph = "";
    AppMethodBeat.o(151129);
  }
  
  public static void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(151122);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new djz();
    ((d.a)localObject).iLO = new dka();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((d.a)localObject).funcId = 716;
    localObject = ((d.a)localObject).aXF();
    djz localdjz = (djz)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localdjz.hid = com.tencent.mm.protocal.d.KyJ;
    localdjz.hie = com.tencent.mm.protocal.d.KyI;
    localdjz.hif = com.tencent.mm.protocal.d.KyL;
    localdjz.hig = com.tencent.mm.protocal.d.KyM;
    localdjz.hih = LocaleUtil.getApplicationLanguage();
    localdjz.MlF = paramInt;
    localdjz.Cyk = paramString;
    Log.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    aa.a((com.tencent.mm.ak.d)localObject, new o.3(Util.nowMilliSecond(), localdjz));
    AppMethodBeat.o(151122);
  }
  
  private static String PT(String paramString)
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
    //   3: ldc 243
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   27: ldc 195
    //   29: ldc 245
    //   31: iconst_4
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_0
    //   38: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: fload_1
    //   45: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: fload_2
    //   52: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: iload_3
    //   59: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 243
    //   68: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: getstatic 102	com/tencent/mm/modelstat/o:jpg	J
    //   78: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   81: ldc2_w 258
    //   84: lcmp
    //   85: ifge +59 -> 144
    //   88: ldc 195
    //   90: ldc_w 261
    //   93: iconst_4
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_0
    //   100: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: fload_1
    //   107: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: fload_2
    //   114: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   117: aastore
    //   118: dup
    //   119: iconst_3
    //   120: iload_3
    //   121: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 243
    //   130: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -62 -> 71
    //   136: astore 4
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload 4
    //   143: athrow
    //   144: ldc 195
    //   146: ldc_w 263
    //   149: iconst_5
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iload_0
    //   156: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: fload_1
    //   163: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: fload_2
    //   170: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   173: aastore
    //   174: dup
    //   175: iconst_3
    //   176: iload_3
    //   177: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_4
    //   183: getstatic 102	com/tencent/mm/modelstat/o:jpg	J
    //   186: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   189: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: invokestatic 216	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   199: putstatic 102	com/tencent/mm/modelstat/o:jpg	J
    //   202: iload_0
    //   203: putstatic 100	com/tencent/mm/modelstat/o:jpf	I
    //   206: invokestatic 216	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   209: putstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   212: iload_3
    //   213: putstatic 98	com/tencent/mm/modelstat/o:jpe	I
    //   216: fload_2
    //   217: putstatic 94	com/tencent/mm/modelstat/o:jpc	F
    //   220: fload_1
    //   221: putstatic 96	com/tencent/mm/modelstat/o:jpd	F
    //   224: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   227: ldc_w 276
    //   230: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   233: checkcast 284	android/net/wifi/WifiManager
    //   236: invokevirtual 288	android/net/wifi/WifiManager:startScan	()Z
    //   239: pop
    //   240: invokestatic 76	com/tencent/mm/kernel/g:aAk	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   243: new 12	com/tencent/mm/modelstat/o$5
    //   246: dup
    //   247: invokespecial 289	com/tencent/mm/modelstat/o$5:<init>	()V
    //   250: ldc2_w 290
    //   253: invokevirtual 295	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToWorkerDelayed	(Ljava/lang/Runnable;J)I
    //   256: pop
    //   257: ldc 243
    //   259: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: goto -191 -> 71
    //   265: astore 4
    //   267: ldc 195
    //   269: ldc_w 297
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 4
    //   280: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   283: aastore
    //   284: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: ldc 243
    //   289: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: goto -221 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramInt1	int
    //   0	295	1	paramFloat1	float
    //   0	295	2	paramFloat2	float
    //   0	295	3	paramInt2	int
    //   136	6	4	localObject	Object
    //   265	14	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	8	136	finally
    //   27	71	136	finally
    //   75	133	136	finally
    //   144	224	136	finally
    //   224	257	136	finally
    //   257	262	136	finally
    //   267	292	136	finally
    //   224	257	265	java/lang/Exception
  }
  
  private static void a(int paramInt1, final float paramFloat1, final float paramFloat2, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(151121);
    long l1 = Util.nowMilliSecond();
    if ((jpa > 0L) && (l1 - jpa > 5000L))
    {
      Log.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[] { Long.valueOf(jpa), Long.valueOf(l1 - jpa) });
      AppMethodBeat.o(151121);
      return;
    }
    final String[] arrayOfString = tW(paramInt1);
    if ((arrayOfString == null) || (arrayOfString.length != 4) || (Util.isNullOrNil(arrayOfString[0])))
    {
      Log.e("MicroMsg.NetTypeReporter", "report get failed val");
      AppMethodBeat.o(151121);
      return;
    }
    Log.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(l1)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(paramLong), arrayOfString[0] });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new djz();
    ((d.a)localObject).iLO = new dka();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((d.a)localObject).funcId = 716;
    com.tencent.mm.ak.d locald = ((d.a)localObject).aXF();
    djz localdjz = (djz)locald.iLK.iLR;
    localdjz.hid = com.tencent.mm.protocal.d.KyJ;
    localdjz.hie = com.tencent.mm.protocal.d.KyI;
    localdjz.hif = com.tencent.mm.protocal.d.KyL;
    localdjz.hig = com.tencent.mm.protocal.d.KyM;
    localdjz.hih = LocaleUtil.getApplicationLanguage();
    localdjz.MlF = 11747;
    long l2 = Util.milliSecondsToNow(jpa);
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
      localdjz.Cyk = ((String)localObject + "," + arrayOfString[1] + "," + arrayOfString[2] + "," + arrayOfString[3]);
      aa.a(locald, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(151111);
          Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(Util.milliSecondsToNow(this.jpi)), arrayOfString.Cyk });
          long l1;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            long l2 = Util.milliSecondsToNow(o.jpa);
            if (l2 <= 600000L)
            {
              l1 = l2;
              if (l2 >= 0L) {}
            }
            else
            {
              l1 = 0L;
            }
            paramAnonymousd = h.CyF;
            paramAnonymousq = new StringBuilder().append(paramFloat1[0]).append("1,").append(paramFloat2).append(",").append(paramInt2).append(",").append(paramLong).append(",").append(this.jpl).append(",");
            if (!CrashReportFactory.foreground) {
              break label265;
            }
          }
          label265:
          for (paramAnonymousString = "1";; paramAnonymousString = String.valueOf(l1))
          {
            paramAnonymousd.kvStat(11747, paramAnonymousString + "," + paramFloat1[1] + "," + paramFloat1[2] + "," + paramFloat1[3]);
            g.aAh().azQ().set(ar.a.NTu, Long.valueOf(Util.nowMilliSecond()));
            AppMethodBeat.o(151111);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(151121);
      return;
    }
  }
  
  private static void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151123);
    try
    {
      Log.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(joY)), Long.valueOf(joY) });
      if ((paramInt1 > 2000) || (Util.milliSecondsToNow(joY) > 300000L))
      {
        Log.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(joY)), Long.valueOf(joY) });
        joZ = paramInt1;
        joY = 9223372036854775807L;
        a(paramInt1, paramFloat1, paramFloat2, paramInt2, paramLong);
        AppMethodBeat.o(151123);
        return;
      }
      if (joY == 9223372036854775807L) {
        joY = Util.nowMilliSecond() + 60000L;
      }
      joZ = paramInt1;
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
  
  private static long bgk()
  {
    AppMethodBeat.i(151120);
    synchronized (lock)
    {
      try
      {
        long l = Util.nullAs((Long)g.aAh().azQ().get(ar.a.NTt, null), 1L);
        g.aAh().azQ().set(ar.a.NTt, Long.valueOf(1L + l));
        g.aAh().azQ().gBI();
        Log.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[] { Long.valueOf(l), Long.valueOf(Util.nullAs((Long)g.aAh().azQ().get(ar.a.NTt, null), 1L)) });
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
  
  public static void dh(Context paramContext)
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
      a locala;
      IntentFilter localIntentFilter;
      Log.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(151116);
    }
    locala = new a((byte)0);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(locala, localIntentFilter);
    Log.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    AppMethodBeat.o(151116);
    return;
  }
  
  public static void fM(boolean paramBoolean)
  {
    AppMethodBeat.i(151124);
    if (paramBoolean)
    {
      jpa = 0L;
      AppMethodBeat.o(151124);
      return;
    }
    if (timer.stopped())
    {
      AppMethodBeat.o(151124);
      return;
    }
    Log.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
    jpa = Util.nowMilliSecond();
    timer.startTimer(0L);
    AppMethodBeat.o(151124);
  }
  
  /* Error */
  public static void run(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 475
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 195
    //   11: ldc_w 477
    //   14: iconst_4
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_0
    //   21: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: getstatic 351	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   30: invokestatic 482	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: getstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   39: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: getstatic 106	com/tencent/mm/modelstat/o:jph	Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: iload_0
    //   53: sipush 1005
    //   56: if_icmpne +139 -> 195
    //   59: getstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifle +131 -> 195
    //   67: ldc 195
    //   69: ldc_w 484
    //   72: bipush 6
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: iload_0
    //   80: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: getstatic 100	com/tencent/mm/modelstat/o:jpf	I
    //   89: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: dup
    //   94: iconst_2
    //   95: getstatic 96	com/tencent/mm/modelstat/o:jpd	F
    //   98: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: getstatic 94	com/tencent/mm/modelstat/o:jpc	F
    //   107: invokestatic 250	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   110: aastore
    //   111: dup
    //   112: iconst_4
    //   113: getstatic 98	com/tencent/mm/modelstat/o:jpe	I
    //   116: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: dup
    //   121: iconst_5
    //   122: getstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   125: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: getstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   135: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   138: lstore 4
    //   140: getstatic 100	com/tencent/mm/modelstat/o:jpf	I
    //   143: istore_0
    //   144: getstatic 94	com/tencent/mm/modelstat/o:jpc	F
    //   147: fstore_1
    //   148: getstatic 96	com/tencent/mm/modelstat/o:jpd	F
    //   151: fstore_2
    //   152: getstatic 98	com/tencent/mm/modelstat/o:jpe	I
    //   155: istore_3
    //   156: lconst_0
    //   157: putstatic 92	com/tencent/mm/modelstat/o:jpb	J
    //   160: fconst_0
    //   161: putstatic 94	com/tencent/mm/modelstat/o:jpc	F
    //   164: fconst_0
    //   165: putstatic 96	com/tencent/mm/modelstat/o:jpd	F
    //   168: iconst_0
    //   169: putstatic 98	com/tencent/mm/modelstat/o:jpe	I
    //   172: iconst_0
    //   173: putstatic 100	com/tencent/mm/modelstat/o:jpf	I
    //   176: iload_0
    //   177: fload_2
    //   178: fload_1
    //   179: iload_3
    //   180: lload 4
    //   182: invokestatic 486	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   185: ldc_w 475
    //   188: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: getstatic 351	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   198: ifne +39 -> 237
    //   201: ldc 195
    //   203: ldc_w 488
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: iload_0
    //   213: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aastore
    //   217: invokestatic 491	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc_w 475
    //   223: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: goto -35 -> 191
    //   229: astore 6
    //   231: ldc 2
    //   233: monitorexit
    //   234: aload 6
    //   236: athrow
    //   237: iload_0
    //   238: iconst_3
    //   239: if_icmpne +94 -> 333
    //   242: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   245: ldc_w 276
    //   248: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   251: checkcast 284	android/net/wifi/WifiManager
    //   254: invokevirtual 495	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   257: invokevirtual 500	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   260: astore 6
    //   262: ldc 195
    //   264: ldc_w 502
    //   267: iconst_3
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_0
    //   274: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 6
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: getstatic 106	com/tencent/mm/modelstat/o:jph	Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload 6
    //   294: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   297: ifne +27 -> 324
    //   300: aload 6
    //   302: getstatic 106	com/tencent/mm/modelstat/o:jph	Ljava/lang/String;
    //   305: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifne +16 -> 324
    //   311: aload 6
    //   313: putstatic 106	com/tencent/mm/modelstat/o:jph	Ljava/lang/String;
    //   316: iload_0
    //   317: fconst_0
    //   318: fconst_0
    //   319: iconst_0
    //   320: lconst_0
    //   321: invokestatic 486	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   324: ldc_w 475
    //   327: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: goto -139 -> 191
    //   333: iload_0
    //   334: iconst_4
    //   335: if_icmpne +81 -> 416
    //   338: invokestatic 392	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   341: invokevirtual 398	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   344: getstatic 509	com/tencent/mm/storage/ar$a:NTu	Lcom/tencent/mm/storage/ar$a;
    //   347: aconst_null
    //   348: invokevirtual 410	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: checkcast 265	java/lang/Long
    //   354: lconst_0
    //   355: invokestatic 414	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Long;J)J
    //   358: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   361: lstore 4
    //   363: ldc 195
    //   365: ldc_w 511
    //   368: iconst_2
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: iload_0
    //   375: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: lload 4
    //   383: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   386: aastore
    //   387: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: lload 4
    //   392: ldc2_w 512
    //   395: lcmp
    //   396: iflt +11 -> 407
    //   399: iload_0
    //   400: fconst_0
    //   401: fconst_0
    //   402: iconst_0
    //   403: lconst_0
    //   404: invokestatic 486	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   407: ldc_w 475
    //   410: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: goto -222 -> 191
    //   416: iload_0
    //   417: fconst_0
    //   418: fconst_0
    //   419: iconst_0
    //   420: lconst_0
    //   421: invokestatic 486	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   424: ldc_w 475
    //   427: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: goto -239 -> 191
    //   433: astore 6
    //   435: ldc 195
    //   437: ldc_w 515
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: aload 6
    //   448: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   451: aastore
    //   452: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   455: ldc_w 475
    //   458: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: goto -270 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramInt	int
    //   147	32	1	f1	float
    //   151	27	2	f2	float
    //   155	25	3	i	int
    //   138	253	4	l	long
    //   229	6	6	localObject	Object
    //   260	52	6	str	String
    //   433	14	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	52	229	finally
    //   59	185	229	finally
    //   185	191	229	finally
    //   195	220	229	finally
    //   220	226	229	finally
    //   242	324	229	finally
    //   324	330	229	finally
    //   338	390	229	finally
    //   399	407	229	finally
    //   407	413	229	finally
    //   416	424	229	finally
    //   424	430	229	finally
    //   435	461	229	finally
    //   59	185	433	java/lang/Throwable
    //   195	220	433	java/lang/Throwable
    //   242	324	433	java/lang/Throwable
    //   338	390	433	java/lang/Throwable
    //   399	407	433	java/lang/Throwable
    //   416	424	433	java/lang/Throwable
  }
  
  /* Error */
  private static String[] tW(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 516
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 195
    //   8: ldc_w 518
    //   11: iconst_4
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_0
    //   18: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: getstatic 351	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   27: invokestatic 482	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: getstatic 90	com/tencent/mm/modelstat/o:jpa	J
    //   36: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: getstatic 90	com/tencent/mm/modelstat/o:jpa	J
    //   45: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   48: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: iload_0
    //   56: ifgt +30 -> 86
    //   59: ldc 195
    //   61: ldc_w 520
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: ldc_w 516
    //   81: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   89: astore 12
    //   91: aload 12
    //   93: ifnonnull +30 -> 123
    //   96: ldc 195
    //   98: ldc_w 522
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_0
    //   108: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: ldc_w 516
    //   118: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: ldc 195
    //   125: ldc_w 524
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: iload_0
    //   135: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: getstatic 351	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   144: invokestatic 482	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: invokestatic 529	com/tencent/mm/compatible/deviceinfo/ab:ape	()I
    //   154: istore_2
    //   155: ldc 195
    //   157: ldc_w 531
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: iload_2
    //   167: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 104
    //   176: astore 8
    //   178: ldc 104
    //   180: astore 16
    //   182: aload 8
    //   184: astore 7
    //   186: aload 12
    //   188: ldc_w 276
    //   191: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: checkcast 284	android/net/wifi/WifiManager
    //   197: astore 15
    //   199: aload 8
    //   201: astore 7
    //   203: new 533	java/lang/StringBuffer
    //   206: dup
    //   207: invokespecial 534	java/lang/StringBuffer:<init>	()V
    //   210: astore 11
    //   212: aload 8
    //   214: astore 7
    //   216: new 533	java/lang/StringBuffer
    //   219: dup
    //   220: invokespecial 534	java/lang/StringBuffer:<init>	()V
    //   223: astore 9
    //   225: aload 8
    //   227: astore 7
    //   229: new 533	java/lang/StringBuffer
    //   232: dup
    //   233: invokespecial 534	java/lang/StringBuffer:<init>	()V
    //   236: astore 10
    //   238: iconst_0
    //   239: istore 4
    //   241: iconst_0
    //   242: istore_1
    //   243: aload 8
    //   245: astore 7
    //   247: new 536	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 537	java/util/ArrayList:<init>	()V
    //   254: astore 13
    //   256: aload 8
    //   258: astore 7
    //   260: aload 11
    //   262: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   265: invokestatic 543	com/tencent/mm/sdk/platformtools/NetStatusUtil:getConnectedWifiSsid	(Landroid/content/Context;)Ljava/lang/String;
    //   268: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   271: pop
    //   272: aload 8
    //   274: astore 7
    //   276: aload 9
    //   278: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   281: invokestatic 549	com/tencent/mm/sdk/platformtools/NetStatusUtil:getConnectedWifiBssid	(Landroid/content/Context;)Ljava/lang/String;
    //   284: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   287: pop
    //   288: aload 8
    //   290: astore 7
    //   292: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   295: invokestatic 549	com/tencent/mm/sdk/platformtools/NetStatusUtil:getConnectedWifiBssid	(Landroid/content/Context;)Ljava/lang/String;
    //   298: astore 14
    //   300: aload 8
    //   302: astore 7
    //   304: aload 13
    //   306: aload 14
    //   308: invokevirtual 552	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   311: pop
    //   312: aload 8
    //   314: astore 7
    //   316: aload 15
    //   318: invokevirtual 556	android/net/wifi/WifiManager:getScanResults	()Ljava/util/List;
    //   321: astore 15
    //   323: aload 15
    //   325: ifnull +296 -> 621
    //   328: aload 8
    //   330: astore 7
    //   332: aload 15
    //   334: new 6	com/tencent/mm/modelstat/o$1
    //   337: dup
    //   338: invokespecial 557	com/tencent/mm/modelstat/o$1:<init>	()V
    //   341: invokestatic 563	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   344: aload 8
    //   346: astore 7
    //   348: aload 15
    //   350: invokeinterface 569 1 0
    //   355: astore 15
    //   357: bipush 20
    //   359: istore_3
    //   360: iload_1
    //   361: istore 4
    //   363: aload 8
    //   365: astore 7
    //   367: aload 15
    //   369: invokeinterface 574 1 0
    //   374: ifeq +247 -> 621
    //   377: aload 8
    //   379: astore 7
    //   381: aload 15
    //   383: invokeinterface 578 1 0
    //   388: checkcast 580	android/net/wifi/ScanResult
    //   391: astore 17
    //   393: aload 17
    //   395: ifnull -35 -> 360
    //   398: aload 8
    //   400: astore 7
    //   402: aload 17
    //   404: getfield 583	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   407: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   410: ifne -50 -> 360
    //   413: aload 8
    //   415: astore 7
    //   417: aload 17
    //   419: getfield 583	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   422: aload 14
    //   424: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: ifeq +43 -> 470
    //   430: aload 8
    //   432: astore 7
    //   434: aload 17
    //   436: getfield 586	android/net/wifi/ScanResult:level	I
    //   439: istore_1
    //   440: goto -80 -> 360
    //   443: astore 7
    //   445: ldc 195
    //   447: ldc_w 588
    //   450: iconst_1
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: aload 7
    //   458: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: aastore
    //   462: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: iconst_0
    //   466: istore_2
    //   467: goto -312 -> 155
    //   470: iload_1
    //   471: istore 4
    //   473: iload_3
    //   474: ifle +147 -> 621
    //   477: aload 8
    //   479: astore 7
    //   481: aload 11
    //   483: ldc_w 590
    //   486: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   489: pop
    //   490: aload 8
    //   492: astore 7
    //   494: aload 11
    //   496: aload 17
    //   498: getfield 593	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   501: invokestatic 596	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   504: ldc_w 590
    //   507: ldc 104
    //   509: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   512: ldc_w 602
    //   515: ldc 104
    //   517: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   520: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   523: pop
    //   524: aload 8
    //   526: astore 7
    //   528: aload 9
    //   530: ldc_w 590
    //   533: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   536: pop
    //   537: aload 8
    //   539: astore 7
    //   541: aload 9
    //   543: aload 17
    //   545: getfield 583	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   548: invokestatic 596	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   551: ldc_w 590
    //   554: ldc 104
    //   556: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   559: ldc_w 602
    //   562: ldc 104
    //   564: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   567: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   570: pop
    //   571: aload 8
    //   573: astore 7
    //   575: aload 13
    //   577: aload 17
    //   579: getfield 583	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   582: invokevirtual 552	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   585: pop
    //   586: aload 8
    //   588: astore 7
    //   590: aload 10
    //   592: ldc_w 590
    //   595: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   598: pop
    //   599: aload 8
    //   601: astore 7
    //   603: aload 10
    //   605: aload 17
    //   607: getfield 586	android/net/wifi/ScanResult:level	I
    //   610: invokevirtual 605	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   613: pop
    //   614: iload_3
    //   615: iconst_1
    //   616: isub
    //   617: istore_3
    //   618: goto -258 -> 360
    //   621: iload_0
    //   622: sipush 2000
    //   625: if_icmpge +46 -> 671
    //   628: aload 8
    //   630: astore 7
    //   632: aload 13
    //   634: invokestatic 608	com/tencent/mm/modelstat/o:w	(Ljava/util/ArrayList;)Z
    //   637: ifne +34 -> 671
    //   640: aload 8
    //   642: astore 7
    //   644: ldc 195
    //   646: ldc_w 610
    //   649: iconst_1
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: iload_0
    //   656: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: aastore
    //   660: invokestatic 491	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   663: ldc_w 516
    //   666: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   669: aconst_null
    //   670: areturn
    //   671: aload 8
    //   673: astore 7
    //   675: aload 11
    //   677: invokevirtual 611	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   680: astore 8
    //   682: aload 8
    //   684: astore 7
    //   686: aload 9
    //   688: invokevirtual 611	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   691: astore 9
    //   693: aload 9
    //   695: astore 7
    //   697: new 327	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   704: iload 4
    //   706: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: aload 10
    //   711: invokevirtual 611	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   714: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: astore 9
    //   722: aload 9
    //   724: astore 16
    //   726: aload 8
    //   728: astore 18
    //   730: aload 7
    //   732: astore 17
    //   734: ldc 195
    //   736: ldc_w 613
    //   739: iconst_2
    //   740: anewarray 4	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload 17
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: aload 18
    //   752: aastore
    //   753: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: ldc 104
    //   758: astore 19
    //   760: aload 12
    //   762: ldc_w 615
    //   765: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   768: checkcast 617	android/telephony/TelephonyManager
    //   771: astore 7
    //   773: aload 7
    //   775: ifnull +1093 -> 1868
    //   778: aload 7
    //   780: invokevirtual 620	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   783: astore 7
    //   785: aload 7
    //   787: astore 19
    //   789: ldc 195
    //   791: ldc_w 622
    //   794: iconst_1
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 19
    //   802: aastore
    //   803: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: ldc 104
    //   808: astore 11
    //   810: ldc 104
    //   812: astore 10
    //   814: ldc 104
    //   816: astore 8
    //   818: ldc 104
    //   820: astore 9
    //   822: ldc 104
    //   824: astore 7
    //   826: aload 12
    //   828: invokestatic 626	com/tencent/mm/sdk/platformtools/NetStatusUtil:getCellInfoList	(Landroid/content/Context;)Ljava/util/List;
    //   831: astore 20
    //   833: iconst_0
    //   834: istore_1
    //   835: ldc 104
    //   837: astore 9
    //   839: aload 11
    //   841: astore 12
    //   843: aload 10
    //   845: astore 11
    //   847: aload 8
    //   849: astore 10
    //   851: aload 11
    //   853: astore 15
    //   855: aload 12
    //   857: astore 14
    //   859: iload_1
    //   860: aload 20
    //   862: invokeinterface 629 1 0
    //   867: if_icmpge +572 -> 1439
    //   870: aload 8
    //   872: astore 10
    //   874: aload 11
    //   876: astore 15
    //   878: aload 12
    //   880: astore 14
    //   882: aload 20
    //   884: iload_1
    //   885: invokeinterface 632 2 0
    //   890: checkcast 634	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   893: astore 21
    //   895: aload 8
    //   897: astore 10
    //   899: aload 11
    //   901: astore 15
    //   903: aload 12
    //   905: astore 14
    //   907: aload 21
    //   909: getfield 637	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mcc	Ljava/lang/String;
    //   912: ldc 104
    //   914: invokestatic 640	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 12
    //   919: aload 8
    //   921: astore 10
    //   923: aload 11
    //   925: astore 15
    //   927: aload 12
    //   929: astore 14
    //   931: aload 21
    //   933: getfield 643	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mnc	Ljava/lang/String;
    //   936: ldc 104
    //   938: invokestatic 640	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   941: astore 13
    //   943: aload 8
    //   945: astore 11
    //   947: aload 8
    //   949: astore 10
    //   951: aload 13
    //   953: astore 15
    //   955: aload 12
    //   957: astore 14
    //   959: aload 8
    //   961: invokevirtual 646	java/lang/String:length	()I
    //   964: ifle +65 -> 1029
    //   967: aload 8
    //   969: astore 11
    //   971: aload 8
    //   973: astore 10
    //   975: aload 13
    //   977: astore 15
    //   979: aload 12
    //   981: astore 14
    //   983: aload 21
    //   985: getfield 649	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   988: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   991: ifne +38 -> 1029
    //   994: aload 8
    //   996: astore 10
    //   998: aload 13
    //   1000: astore 15
    //   1002: aload 12
    //   1004: astore 14
    //   1006: new 327	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1013: aload 8
    //   1015: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc_w 590
    //   1021: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: astore 11
    //   1029: aload 11
    //   1031: astore 8
    //   1033: aload 11
    //   1035: astore 10
    //   1037: aload 13
    //   1039: astore 15
    //   1041: aload 12
    //   1043: astore 14
    //   1045: aload 21
    //   1047: getfield 649	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   1050: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1053: ifne +40 -> 1093
    //   1056: aload 11
    //   1058: astore 10
    //   1060: aload 13
    //   1062: astore 15
    //   1064: aload 12
    //   1066: astore 14
    //   1068: new 327	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1075: aload 11
    //   1077: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload 21
    //   1082: getfield 649	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   1085: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: astore 8
    //   1093: aload 8
    //   1095: astore 10
    //   1097: aload 13
    //   1099: astore 15
    //   1101: aload 12
    //   1103: astore 14
    //   1105: aload 9
    //   1107: invokevirtual 646	java/lang/String:length	()I
    //   1110: ifle +751 -> 1861
    //   1113: aload 8
    //   1115: astore 10
    //   1117: aload 13
    //   1119: astore 15
    //   1121: aload 12
    //   1123: astore 14
    //   1125: aload 21
    //   1127: getfield 652	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1130: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1133: ifne +728 -> 1861
    //   1136: aload 8
    //   1138: astore 10
    //   1140: aload 13
    //   1142: astore 15
    //   1144: aload 12
    //   1146: astore 14
    //   1148: new 327	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1155: aload 9
    //   1157: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: ldc_w 590
    //   1163: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: astore 11
    //   1171: aload 11
    //   1173: astore 10
    //   1175: aload 10
    //   1177: astore 9
    //   1179: aload 7
    //   1181: astore 11
    //   1183: aload 10
    //   1185: astore 14
    //   1187: aload 21
    //   1189: getfield 652	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1192: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1195: ifne +36 -> 1231
    //   1198: aload 7
    //   1200: astore 11
    //   1202: aload 10
    //   1204: astore 14
    //   1206: new 327	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1213: aload 10
    //   1215: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: aload 21
    //   1220: getfield 652	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1223: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: astore 9
    //   1231: aload 7
    //   1233: astore 10
    //   1235: aload 7
    //   1237: astore 11
    //   1239: aload 9
    //   1241: astore 14
    //   1243: aload 7
    //   1245: invokevirtual 646	java/lang/String:length	()I
    //   1248: ifle +34 -> 1282
    //   1251: aload 7
    //   1253: astore 11
    //   1255: aload 9
    //   1257: astore 14
    //   1259: new 327	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1266: aload 7
    //   1268: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: ldc_w 590
    //   1274: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: astore 10
    //   1282: aload 10
    //   1284: astore 11
    //   1286: aload 9
    //   1288: astore 14
    //   1290: new 327	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1297: aload 10
    //   1299: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: astore 15
    //   1304: aload 10
    //   1306: astore 11
    //   1308: aload 9
    //   1310: astore 14
    //   1312: aload 21
    //   1314: getfield 655	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1317: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1320: ifeq +101 -> 1421
    //   1323: ldc_w 657
    //   1326: astore 7
    //   1328: aload 10
    //   1330: astore 11
    //   1332: aload 9
    //   1334: astore 14
    //   1336: aload 15
    //   1338: aload 7
    //   1340: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: astore 7
    //   1348: iload_1
    //   1349: iconst_1
    //   1350: iadd
    //   1351: istore_1
    //   1352: aload 13
    //   1354: astore 11
    //   1356: goto -509 -> 847
    //   1359: astore 8
    //   1361: ldc 104
    //   1363: astore 9
    //   1365: ldc 195
    //   1367: ldc_w 659
    //   1370: iconst_1
    //   1371: anewarray 4	java/lang/Object
    //   1374: dup
    //   1375: iconst_0
    //   1376: aload 8
    //   1378: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1381: aastore
    //   1382: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1385: aload 9
    //   1387: astore 17
    //   1389: aload 7
    //   1391: astore 18
    //   1393: goto -659 -> 734
    //   1396: astore 7
    //   1398: ldc 195
    //   1400: ldc_w 588
    //   1403: iconst_1
    //   1404: anewarray 4	java/lang/Object
    //   1407: dup
    //   1408: iconst_0
    //   1409: aload 7
    //   1411: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1414: aastore
    //   1415: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1418: goto -629 -> 789
    //   1421: aload 10
    //   1423: astore 11
    //   1425: aload 9
    //   1427: astore 14
    //   1429: aload 21
    //   1431: getfield 655	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1434: astore 7
    //   1436: goto -108 -> 1328
    //   1439: aload 11
    //   1441: astore 10
    //   1443: ldc 195
    //   1445: ldc_w 661
    //   1448: iconst_3
    //   1449: anewarray 4	java/lang/Object
    //   1452: dup
    //   1453: iconst_0
    //   1454: aload 12
    //   1456: aastore
    //   1457: dup
    //   1458: iconst_1
    //   1459: aload 10
    //   1461: aastore
    //   1462: dup
    //   1463: iconst_2
    //   1464: aload 8
    //   1466: aastore
    //   1467: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1470: new 327	java/lang/StringBuilder
    //   1473: dup
    //   1474: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1477: astore 11
    //   1479: aload 11
    //   1481: invokestatic 664	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1484: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1487: ldc_w 339
    //   1490: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 11
    //   1496: iload_0
    //   1497: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: ldc_w 339
    //   1503: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 11
    //   1509: iload_2
    //   1510: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1513: ldc_w 339
    //   1516: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: pop
    //   1520: aload 11
    //   1522: aload 18
    //   1524: ldc_w 339
    //   1527: ldc_w 602
    //   1530: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1533: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: ldc_w 339
    //   1539: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 11
    //   1545: aload 17
    //   1547: ldc_w 339
    //   1550: ldc_w 602
    //   1553: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1556: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: ldc_w 339
    //   1565: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload 11
    //   1571: aload 19
    //   1573: ldc_w 339
    //   1576: ldc_w 602
    //   1579: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1582: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: ldc_w 339
    //   1588: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: aload 11
    //   1594: aload 12
    //   1596: ldc_w 339
    //   1599: ldc_w 602
    //   1602: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1605: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1608: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: ldc_w 339
    //   1614: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 11
    //   1620: aload 10
    //   1622: ldc_w 339
    //   1625: ldc_w 602
    //   1628: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1631: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1634: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 339
    //   1640: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: pop
    //   1644: aload 11
    //   1646: aload 8
    //   1648: ldc_w 339
    //   1651: ldc_w 602
    //   1654: invokevirtual 600	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1657: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1660: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: ldc_w 339
    //   1666: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: pop
    //   1670: invokestatic 668	com/tencent/mm/modelstat/o:bgk	()J
    //   1673: lstore 5
    //   1675: lload 5
    //   1677: lconst_0
    //   1678: lcmp
    //   1679: ifge +40 -> 1719
    //   1682: ldc_w 516
    //   1685: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1688: aconst_null
    //   1689: areturn
    //   1690: astore 12
    //   1692: ldc 195
    //   1694: ldc_w 588
    //   1697: iconst_1
    //   1698: anewarray 4	java/lang/Object
    //   1701: dup
    //   1702: iconst_0
    //   1703: aload 12
    //   1705: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1708: aastore
    //   1709: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1712: aload 11
    //   1714: astore 12
    //   1716: goto -273 -> 1443
    //   1719: new 327	java/lang/StringBuilder
    //   1722: dup
    //   1723: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   1726: lload 5
    //   1728: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1731: ldc_w 339
    //   1734: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: aload 11
    //   1739: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1742: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: astore 8
    //   1750: aload 16
    //   1752: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1755: astore 10
    //   1757: aload 9
    //   1759: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1762: astore 9
    //   1764: aload 7
    //   1766: invokestatic 666	com/tencent/mm/modelstat/o:PT	(Ljava/lang/String;)Ljava/lang/String;
    //   1769: astore 7
    //   1771: ldc_w 516
    //   1774: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1777: iconst_4
    //   1778: anewarray 235	java/lang/String
    //   1781: dup
    //   1782: iconst_0
    //   1783: aload 8
    //   1785: aastore
    //   1786: dup
    //   1787: iconst_1
    //   1788: aload 10
    //   1790: aastore
    //   1791: dup
    //   1792: iconst_2
    //   1793: aload 9
    //   1795: aastore
    //   1796: dup
    //   1797: iconst_3
    //   1798: aload 7
    //   1800: aastore
    //   1801: areturn
    //   1802: astore 15
    //   1804: aload 14
    //   1806: astore 9
    //   1808: aload 11
    //   1810: astore 7
    //   1812: aload 13
    //   1814: astore 10
    //   1816: aload 12
    //   1818: astore 11
    //   1820: aload 15
    //   1822: astore 12
    //   1824: goto -132 -> 1692
    //   1827: astore 12
    //   1829: aload 10
    //   1831: astore 8
    //   1833: aload 15
    //   1835: astore 10
    //   1837: aload 14
    //   1839: astore 11
    //   1841: goto -149 -> 1692
    //   1844: astore 10
    //   1846: aload 7
    //   1848: astore 9
    //   1850: aload 8
    //   1852: astore 7
    //   1854: aload 10
    //   1856: astore 8
    //   1858: goto -493 -> 1365
    //   1861: aload 9
    //   1863: astore 10
    //   1865: goto -690 -> 1175
    //   1868: ldc 104
    //   1870: astore 7
    //   1872: goto -1087 -> 785
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1875	0	paramInt	int
    //   242	1110	1	i	int
    //   154	1356	2	j	int
    //   359	259	3	k	int
    //   239	466	4	m	int
    //   1673	54	5	l	long
    //   184	249	7	localObject1	Object
    //   443	14	7	localException1	Exception
    //   479	911	7	localObject2	Object
    //   1396	14	7	localException2	Exception
    //   1434	437	7	localObject3	Object
    //   176	961	8	localObject4	Object
    //   1359	288	8	localException3	Exception
    //   1748	109	8	localObject5	Object
    //   223	1639	9	localObject6	Object
    //   236	1600	10	localObject7	Object
    //   1844	11	10	localException4	Exception
    //   1863	1	10	localObject8	Object
    //   210	1630	11	localObject9	Object
    //   89	1506	12	localObject10	Object
    //   1690	14	12	localException5	Exception
    //   1714	109	12	localObject11	Object
    //   1827	1	12	localException6	Exception
    //   254	1559	13	localObject12	Object
    //   298	1540	14	localObject13	Object
    //   197	1140	15	localObject14	Object
    //   1802	32	15	localException7	Exception
    //   180	1571	16	localObject15	Object
    //   391	1155	17	localObject16	Object
    //   728	795	18	localObject17	Object
    //   758	814	19	localObject18	Object
    //   831	52	20	localList	java.util.List
    //   893	537	21	localCellInfo	com.tencent.mm.sdk.platformtools.NetStatusUtil.CellInfo
    // Exception table:
    //   from	to	target	type
    //   151	155	443	java/lang/Exception
    //   186	199	1359	java/lang/Exception
    //   203	212	1359	java/lang/Exception
    //   216	225	1359	java/lang/Exception
    //   229	238	1359	java/lang/Exception
    //   247	256	1359	java/lang/Exception
    //   260	272	1359	java/lang/Exception
    //   276	288	1359	java/lang/Exception
    //   292	300	1359	java/lang/Exception
    //   304	312	1359	java/lang/Exception
    //   316	323	1359	java/lang/Exception
    //   332	344	1359	java/lang/Exception
    //   348	357	1359	java/lang/Exception
    //   367	377	1359	java/lang/Exception
    //   381	393	1359	java/lang/Exception
    //   402	413	1359	java/lang/Exception
    //   417	430	1359	java/lang/Exception
    //   434	440	1359	java/lang/Exception
    //   481	490	1359	java/lang/Exception
    //   494	524	1359	java/lang/Exception
    //   528	537	1359	java/lang/Exception
    //   541	571	1359	java/lang/Exception
    //   575	586	1359	java/lang/Exception
    //   590	599	1359	java/lang/Exception
    //   603	614	1359	java/lang/Exception
    //   632	640	1359	java/lang/Exception
    //   644	663	1359	java/lang/Exception
    //   675	682	1359	java/lang/Exception
    //   686	693	1359	java/lang/Exception
    //   760	773	1396	java/lang/Exception
    //   778	785	1396	java/lang/Exception
    //   826	833	1690	java/lang/Exception
    //   1187	1198	1802	java/lang/Exception
    //   1206	1231	1802	java/lang/Exception
    //   1243	1251	1802	java/lang/Exception
    //   1259	1282	1802	java/lang/Exception
    //   1290	1304	1802	java/lang/Exception
    //   1312	1323	1802	java/lang/Exception
    //   1336	1348	1802	java/lang/Exception
    //   1429	1436	1802	java/lang/Exception
    //   859	870	1827	java/lang/Exception
    //   882	895	1827	java/lang/Exception
    //   907	919	1827	java/lang/Exception
    //   931	943	1827	java/lang/Exception
    //   959	967	1827	java/lang/Exception
    //   983	994	1827	java/lang/Exception
    //   1006	1029	1827	java/lang/Exception
    //   1045	1056	1827	java/lang/Exception
    //   1068	1093	1827	java/lang/Exception
    //   1105	1113	1827	java/lang/Exception
    //   1125	1136	1827	java/lang/Exception
    //   1148	1171	1827	java/lang/Exception
    //   697	722	1844	java/lang/Exception
  }
  
  /* Error */
  private static boolean w(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 688
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 689	java/util/ArrayList:size	()I
    //   10: ifne +19 -> 29
    //   13: ldc 195
    //   15: ldc_w 691
    //   18: invokestatic 693	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 688
    //   24: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   32: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifeq +31 -> 66
    //   38: new 327	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   45: invokestatic 392	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   48: getfield 696	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   51: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 698
    //   57: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: putstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   66: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   69: invokevirtual 699	java/util/HashMap:size	()I
    //   72: ifne +173 -> 245
    //   75: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   78: invokestatic 705	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   81: ldc2_w 706
    //   84: lcmp
    //   85: ifle +10 -> 95
    //   88: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   91: invokestatic 710	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   94: pop
    //   95: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   98: invokestatic 714	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   101: astore 4
    //   103: new 716	java/io/ObjectInputStream
    //   106: dup
    //   107: new 718	java/io/BufferedInputStream
    //   110: dup
    //   111: aload 4
    //   113: invokespecial 721	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 722	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 5
    //   121: aload 5
    //   123: astore 7
    //   125: aload 4
    //   127: astore 6
    //   129: aload 5
    //   131: invokevirtual 725	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   134: checkcast 53	java/util/HashMap
    //   137: putstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   140: aload 5
    //   142: astore 7
    //   144: aload 4
    //   146: astore 6
    //   148: ldc 195
    //   150: ldc_w 727
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   162: invokevirtual 699	java/util/HashMap:size	()I
    //   165: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 5
    //   174: invokevirtual 730	java/io/ObjectInputStream:close	()V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 733	java/io/InputStream:close	()V
    //   187: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   190: invokevirtual 699	java/util/HashMap:size	()I
    //   193: ifle +15 -> 208
    //   196: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   199: invokevirtual 699	java/util/HashMap:size	()I
    //   202: sipush 1000
    //   205: if_icmple +40 -> 245
    //   208: ldc 195
    //   210: ldc_w 735
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   222: invokevirtual 699	java/util/HashMap:size	()I
    //   225: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   241: invokestatic 710	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   244: pop
    //   245: aload_0
    //   246: invokevirtual 736	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   249: astore_0
    //   250: iconst_0
    //   251: istore_1
    //   252: aload_0
    //   253: invokeinterface 574 1 0
    //   258: ifeq +305 -> 563
    //   261: aload_0
    //   262: invokeinterface 578 1 0
    //   267: checkcast 235	java/lang/String
    //   270: astore 4
    //   272: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   275: aload 4
    //   277: invokevirtual 739	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: iconst_0
    //   281: invokestatic 743	com/tencent/mm/sdk/platformtools/Util:nullAsLong	(Ljava/lang/Object;I)J
    //   284: invokestatic 257	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   287: lstore_2
    //   288: ldc 195
    //   290: ldc_w 745
    //   293: iconst_2
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload 4
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: lload_2
    //   305: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   308: aastore
    //   309: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: lload_2
    //   313: lconst_0
    //   314: lcmp
    //   315: ifle +11 -> 326
    //   318: lload_2
    //   319: getstatic 51	com/tencent/mm/modelstat/o:joV	J
    //   322: lcmp
    //   323: ifle +564 -> 887
    //   326: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   329: aload 4
    //   331: invokestatic 216	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   334: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: invokevirtual 749	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: iconst_1
    //   342: istore_1
    //   343: goto -91 -> 252
    //   346: astore 4
    //   348: ldc 195
    //   350: ldc_w 751
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 4
    //   361: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   364: aastore
    //   365: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: new 53	java/util/HashMap
    //   371: dup
    //   372: invokespecial 56	java/util/HashMap:<init>	()V
    //   375: putstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
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
    //   397: ldc 195
    //   399: ldc_w 751
    //   402: iconst_1
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: aload 8
    //   410: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   413: aastore
    //   414: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aload 5
    //   419: astore 7
    //   421: aload 4
    //   423: astore 6
    //   425: new 53	java/util/HashMap
    //   428: dup
    //   429: invokespecial 56	java/util/HashMap:<init>	()V
    //   432: putstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   435: aload 5
    //   437: ifnull +8 -> 445
    //   440: aload 5
    //   442: invokevirtual 730	java/io/ObjectInputStream:close	()V
    //   445: aload 4
    //   447: ifnull -260 -> 187
    //   450: aload 4
    //   452: invokevirtual 733	java/io/InputStream:close	()V
    //   455: goto -268 -> 187
    //   458: astore 4
    //   460: ldc 195
    //   462: ldc_w 751
    //   465: iconst_1
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 4
    //   473: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: aastore
    //   477: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: new 53	java/util/HashMap
    //   483: dup
    //   484: invokespecial 56	java/util/HashMap:<init>	()V
    //   487: putstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   490: goto -303 -> 187
    //   493: astore_0
    //   494: aconst_null
    //   495: astore 7
    //   497: aconst_null
    //   498: astore 4
    //   500: aload 7
    //   502: ifnull +8 -> 510
    //   505: aload 7
    //   507: invokevirtual 730	java/io/ObjectInputStream:close	()V
    //   510: aload 4
    //   512: ifnull +8 -> 520
    //   515: aload 4
    //   517: invokevirtual 733	java/io/InputStream:close	()V
    //   520: ldc_w 688
    //   523: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   526: aload_0
    //   527: athrow
    //   528: astore 4
    //   530: ldc 195
    //   532: ldc_w 751
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload 4
    //   543: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   546: aastore
    //   547: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: new 53	java/util/HashMap
    //   553: dup
    //   554: invokespecial 56	java/util/HashMap:<init>	()V
    //   557: putstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   560: goto -40 -> 520
    //   563: iload_1
    //   564: ifeq +100 -> 664
    //   567: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   570: invokevirtual 699	java/util/HashMap:size	()I
    //   573: ifle +91 -> 664
    //   576: getstatic 60	com/tencent/mm/modelstat/o:joX	Ljava/lang/String;
    //   579: iconst_0
    //   580: invokestatic 755	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   583: astore_0
    //   584: new 757	java/io/ObjectOutputStream
    //   587: dup
    //   588: aload_0
    //   589: invokespecial 760	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   592: astore 4
    //   594: aload 4
    //   596: astore 6
    //   598: aload_0
    //   599: astore 5
    //   601: aload 4
    //   603: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   606: invokevirtual 764	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   609: aload 4
    //   611: astore 6
    //   613: aload_0
    //   614: astore 5
    //   616: aload_0
    //   617: invokevirtual 769	java/io/OutputStream:flush	()V
    //   620: aload 4
    //   622: astore 6
    //   624: aload_0
    //   625: astore 5
    //   627: ldc 195
    //   629: ldc_w 771
    //   632: iconst_1
    //   633: anewarray 4	java/lang/Object
    //   636: dup
    //   637: iconst_0
    //   638: getstatic 58	com/tencent/mm/modelstat/o:joW	Ljava/util/HashMap;
    //   641: invokevirtual 699	java/util/HashMap:size	()I
    //   644: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: aastore
    //   648: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   651: aload 4
    //   653: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   656: aload_0
    //   657: ifnull +7 -> 664
    //   660: aload_0
    //   661: invokevirtual 773	java/io/OutputStream:close	()V
    //   664: ldc_w 688
    //   667: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: iload_1
    //   671: ireturn
    //   672: astore_0
    //   673: ldc 195
    //   675: ldc_w 775
    //   678: iconst_1
    //   679: anewarray 4	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: aload_0
    //   685: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   688: aastore
    //   689: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: goto -28 -> 664
    //   695: astore 7
    //   697: aconst_null
    //   698: astore 4
    //   700: aconst_null
    //   701: astore_0
    //   702: aload 4
    //   704: astore 6
    //   706: aload_0
    //   707: astore 5
    //   709: ldc 195
    //   711: ldc_w 775
    //   714: iconst_1
    //   715: anewarray 4	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: aload 7
    //   722: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   725: aastore
    //   726: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   729: aload 4
    //   731: ifnull +8 -> 739
    //   734: aload 4
    //   736: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   739: aload_0
    //   740: ifnull -76 -> 664
    //   743: aload_0
    //   744: invokevirtual 773	java/io/OutputStream:close	()V
    //   747: goto -83 -> 664
    //   750: astore_0
    //   751: ldc 195
    //   753: ldc_w 775
    //   756: iconst_1
    //   757: anewarray 4	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload_0
    //   763: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: goto -106 -> 664
    //   773: astore 4
    //   775: aconst_null
    //   776: astore 6
    //   778: aconst_null
    //   779: astore_0
    //   780: aload 6
    //   782: ifnull +8 -> 790
    //   785: aload 6
    //   787: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   790: aload_0
    //   791: ifnull +7 -> 798
    //   794: aload_0
    //   795: invokevirtual 773	java/io/OutputStream:close	()V
    //   798: ldc_w 688
    //   801: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   804: aload 4
    //   806: athrow
    //   807: astore_0
    //   808: ldc 195
    //   810: ldc_w 775
    //   813: iconst_1
    //   814: anewarray 4	java/lang/Object
    //   817: dup
    //   818: iconst_0
    //   819: aload_0
    //   820: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   823: aastore
    //   824: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   827: goto -29 -> 798
    //   830: astore 4
    //   832: aconst_null
    //   833: astore 6
    //   835: goto -55 -> 780
    //   838: astore 4
    //   840: aload 5
    //   842: astore_0
    //   843: goto -63 -> 780
    //   846: astore 7
    //   848: aconst_null
    //   849: astore 4
    //   851: goto -149 -> 702
    //   854: astore 7
    //   856: goto -154 -> 702
    //   859: astore_0
    //   860: aconst_null
    //   861: astore 7
    //   863: goto -363 -> 500
    //   866: astore_0
    //   867: aload 6
    //   869: astore 4
    //   871: goto -371 -> 500
    //   874: astore 8
    //   876: aconst_null
    //   877: astore 5
    //   879: goto -490 -> 389
    //   882: astore 8
    //   884: goto -495 -> 389
    //   887: goto -544 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	paramArrayList	java.util.ArrayList<String>
    //   251	420	1	bool	boolean
    //   287	32	2	l	long
    //   101	229	4	localObject1	Object
    //   346	14	4	localException1	Exception
    //   387	64	4	localObject2	Object
    //   458	14	4	localException2	Exception
    //   498	18	4	localObject3	Object
    //   528	14	4	localException3	Exception
    //   592	143	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   773	32	4	localObject4	Object
    //   830	1	4	localObject5	Object
    //   838	1	4	localObject6	Object
    //   849	21	4	localObject7	Object
    //   119	759	5	localObject8	Object
    //   127	741	6	localObject9	Object
    //   123	383	7	localObject10	Object
    //   695	26	7	localException4	Exception
    //   846	1	7	localException5	Exception
    //   854	1	7	localException6	Exception
    //   861	1	7	localObject11	Object
    //   381	28	8	localException7	Exception
    //   874	1	8	localException8	Exception
    //   882	1	8	localException9	Exception
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
    //   651	656	672	java/lang/Exception
    //   660	664	672	java/lang/Exception
    //   576	584	695	java/lang/Exception
    //   734	739	750	java/lang/Exception
    //   743	747	750	java/lang/Exception
    //   576	584	773	finally
    //   785	790	807	java/lang/Exception
    //   794	798	807	java/lang/Exception
    //   584	594	830	finally
    //   601	609	838	finally
    //   616	620	838	finally
    //   627	651	838	finally
    //   709	729	838	finally
    //   584	594	846	java/lang/Exception
    //   601	609	854	java/lang/Exception
    //   616	620	854	java/lang/Exception
    //   627	651	854	java/lang/Exception
    //   103	121	859	finally
    //   129	140	866	finally
    //   148	172	866	finally
    //   397	417	866	finally
    //   425	435	866	finally
    //   103	121	874	java/lang/Exception
    //   129	140	882	java/lang/Exception
    //   148	172	882	java/lang/Exception
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(151115);
      try
      {
        if (g.aAf().azp())
        {
          g.aAf();
          if (!a.azj()) {}
        }
        else
        {
          bool = g.aAf().azp();
          g.aAf();
          Log.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(a.azj()) });
          AppMethodBeat.o(151115);
          return;
        }
        if ((paramIntent == null) || (Util.isNullOrNil(paramIntent.getAction())))
        {
          if (paramIntent == null) {}
          for (paramContext = "intent is null";; paramContext = "action is null")
          {
            Log.e("MicroMsg.NetTypeReporter", "onReceive %s  ", new Object[] { paramContext });
            AppMethodBeat.o(151115);
            return;
          }
        }
        paramContext = paramIntent.getAction();
        Log.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", new Object[] { paramContext, Boolean.valueOf(CrashReportFactory.foreground) });
        boolean bool = CrashReportFactory.foreground;
        if (!bool)
        {
          AppMethodBeat.o(151115);
          return;
        }
        if (paramContext.equals("android.net.wifi.supplicant.CONNECTION_CHANGE"))
        {
          o.run(1001);
          AppMethodBeat.o(151115);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("MicroMsg.NetTypeReporter", "onReceive : %s", new Object[] { Util.stackTraceToString(paramContext) });
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.wifi.supplicant.STATE_CHANGE"))
      {
        o.run(1002);
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
      {
        o.run(1003);
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED"))
      {
        o.run(1004);
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
      {
        o.run(1005);
        AppMethodBeat.o(151115);
        return;
      }
      if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        o.run(1006);
        EventCenter.instance.publish(new mb());
      }
      AppMethodBeat.o(151115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.o
 * JD-Core Version:    0.7.0.1
 */