package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Comparator;
import java.util.HashMap;

public final class o
{
  private static av cOx;
  private static long hwS;
  private static HashMap<String, Long> hwT;
  private static String hwU;
  private static long hwV;
  private static int hwW;
  private static long hwX;
  private static long hwY;
  private static float hwZ;
  private static float hxa;
  private static int hxb;
  private static int hxc;
  private static long hxd;
  private static String hxe;
  private static final byte[] lock;
  
  static
  {
    AppMethodBeat.i(151129);
    hwS = 86400000L;
    hwT = new HashMap();
    hwU = null;
    lock = new byte[0];
    hwV = 9223372036854775807L;
    hwW = 0;
    cOx = new av(g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151113);
        try
        {
          o.aBN();
          if ((o.hwW < 2000) && (o.hwW > 1000)) {
            o.oN(o.hwW);
          }
          for (;;)
          {
            AppMethodBeat.o(151113);
            return false;
            o.oO(o.hwW);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { bt.m(localException) });
          }
        }
      }
    }, false);
    hwX = 0L;
    hwY = 0L;
    hwZ = 0.0F;
    hxa = 0.0F;
    hxb = 0;
    hxc = 0;
    hxd = 0L;
    hxe = "";
    AppMethodBeat.o(151129);
  }
  
  public static void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(151122);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new chc();
    ((b.a)localObject).gUV = new chd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((b.a)localObject).funcId = 716;
    localObject = ((b.a)localObject).atI();
    chc localchc = (chc)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localchc.fVv = d.CpF;
    localchc.fVw = d.CpE;
    localchc.fVx = d.CpH;
    localchc.fVy = d.CpI;
    localchc.fVz = ac.eFu();
    localchc.DIc = paramInt;
    localchc.vJI = paramString;
    ad.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(151112);
        ad.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(bt.vM(this.hxf)), this.hxg.vJI });
        AppMethodBeat.o(151112);
        return 0;
      }
    });
    AppMethodBeat.o(151122);
  }
  
  /* Error */
  public static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 231
    //   5: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   27: ldc 199
    //   29: ldc 233
    //   31: iconst_4
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_0
    //   38: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: fload_1
    //   45: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: fload_2
    //   52: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: iload_3
    //   59: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 231
    //   68: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: getstatic 107	com/tencent/mm/modelstat/o:hxd	J
    //   78: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   81: ldc2_w 246
    //   84: lcmp
    //   85: ifge +58 -> 143
    //   88: ldc 199
    //   90: ldc 249
    //   92: iconst_4
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: iload_0
    //   99: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: fload_1
    //   106: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: fload_2
    //   113: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: iload_3
    //   120: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: ldc 231
    //   129: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: goto -61 -> 71
    //   135: astore 4
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload 4
    //   142: athrow
    //   143: ldc 199
    //   145: ldc 251
    //   147: iconst_5
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: iload_0
    //   154: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: fload_1
    //   161: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: fload_2
    //   168: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: iload_3
    //   175: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: dup
    //   180: iconst_4
    //   181: getstatic 107	com/tencent/mm/modelstat/o:hxd	J
    //   184: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   187: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: aastore
    //   191: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   197: putstatic 107	com/tencent/mm/modelstat/o:hxd	J
    //   200: iload_0
    //   201: putstatic 105	com/tencent/mm/modelstat/o:hxc	I
    //   204: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   207: putstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   210: iload_3
    //   211: putstatic 103	com/tencent/mm/modelstat/o:hxb	I
    //   214: fload_2
    //   215: putstatic 99	com/tencent/mm/modelstat/o:hwZ	F
    //   218: fload_1
    //   219: putstatic 101	com/tencent/mm/modelstat/o:hxa	F
    //   222: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   225: ldc_w 264
    //   228: invokevirtual 270	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   231: checkcast 272	android/net/wifi/WifiManager
    //   234: invokevirtual 276	android/net/wifi/WifiManager:startScan	()Z
    //   237: pop
    //   238: invokestatic 75	com/tencent/mm/kernel/g:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
    //   241: new 278	com/tencent/mm/modelstat/o$5
    //   244: dup
    //   245: invokespecial 279	com/tencent/mm/modelstat/o$5:<init>	()V
    //   248: ldc2_w 280
    //   251: invokevirtual 285	com/tencent/mm/sdk/platformtools/aq:m	(Ljava/lang/Runnable;J)I
    //   254: pop
    //   255: ldc 231
    //   257: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: goto -189 -> 71
    //   263: astore 4
    //   265: ldc 199
    //   267: ldc_w 287
    //   270: iconst_1
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload 4
    //   278: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   281: aastore
    //   282: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: ldc 231
    //   287: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: goto -219 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramInt1	int
    //   0	293	1	paramFloat1	float
    //   0	293	2	paramFloat2	float
    //   0	293	3	paramInt2	int
    //   135	6	4	localObject	Object
    //   263	14	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	8	135	finally
    //   27	71	135	finally
    //   75	132	135	finally
    //   143	222	135	finally
    //   222	255	135	finally
    //   255	260	135	finally
    //   265	290	135	finally
    //   222	255	263	java/lang/Exception
  }
  
  private static void a(int paramInt1, final float paramFloat1, final float paramFloat2, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(151121);
    long l1 = bt.eGO();
    if ((hwX > 0L) && (l1 - hwX > 5000L))
    {
      ad.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[] { Long.valueOf(hwX), Long.valueOf(l1 - hwX) });
      AppMethodBeat.o(151121);
      return;
    }
    final String[] arrayOfString = oM(paramInt1);
    if ((arrayOfString == null) || (arrayOfString.length != 4) || (bt.isNullOrNil(arrayOfString[0])))
    {
      ad.e("MicroMsg.NetTypeReporter", "report get failed val");
      AppMethodBeat.o(151121);
      return;
    }
    ad.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bt.vM(l1)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(paramLong), arrayOfString[0] });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new chc();
    ((b.a)localObject).gUV = new chd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((b.a)localObject).funcId = 716;
    com.tencent.mm.al.b localb = ((b.a)localObject).atI();
    chc localchc = (chc)localb.gUS.gUX;
    localchc.fVv = d.CpF;
    localchc.fVw = d.CpE;
    localchc.fVx = d.CpH;
    localchc.fVy = d.CpI;
    localchc.fVz = ac.eFu();
    localchc.DIc = 11747;
    long l2 = bt.vM(hwX);
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
    if (com.tencent.mm.sdk.a.b.foreground) {}
    for (localObject = "1";; localObject = String.valueOf(l1))
    {
      localchc.vJI = ((String)localObject + "," + arrayOfString[1] + "," + arrayOfString[2] + "," + arrayOfString[3]);
      x.a(localb, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(151111);
          ad.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(bt.vM(this.hxf)), arrayOfString.vJI });
          long l1;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            long l2 = bt.vM(o.hwX);
            if (l2 <= 600000L)
            {
              l1 = l2;
              if (l2 >= 0L) {}
            }
            else
            {
              l1 = 0L;
            }
            paramAnonymousb = h.vKh;
            paramAnonymousn = new StringBuilder().append(paramFloat1[0]).append("1,").append(paramFloat2).append(",").append(paramInt2).append(",").append(paramLong).append(",").append(this.hxi).append(",");
            if (!com.tencent.mm.sdk.a.b.foreground) {
              break label265;
            }
          }
          label265:
          for (paramAnonymousString = "1";; paramAnonymousString = String.valueOf(l1))
          {
            paramAnonymousb.kvStat(11747, paramAnonymousString + "," + paramFloat1[1] + "," + paramFloat1[2] + "," + paramFloat1[3]);
            g.afB().afk().set(ae.a.FgQ, Long.valueOf(bt.eGO()));
            AppMethodBeat.o(151111);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(151121);
      return;
    }
  }
  
  private static long aBM()
  {
    AppMethodBeat.i(151120);
    synchronized (lock)
    {
      try
      {
        long l = bt.a((Long)g.afB().afk().get(ae.a.FgP, null), 1L);
        g.afB().afk().set(ae.a.FgP, Long.valueOf(1L + l));
        g.afB().afk().eKy();
        ad.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[] { Long.valueOf(l), Long.valueOf(bt.a((Long)g.afB().afk().get(ae.a.FgP, null), 1L)) });
        AppMethodBeat.o(151120);
        return l;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[] { bt.m(localException) });
        AppMethodBeat.o(151120);
        return -1L;
      }
    }
  }
  
  private static void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151123);
    try
    {
      ad.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bt.vM(hwV)), Long.valueOf(hwV) });
      if ((paramInt1 > 2000) || (bt.vM(hwV) > 300000L))
      {
        ad.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bt.vM(hwV)), Long.valueOf(hwV) });
        hwW = paramInt1;
        hwV = 9223372036854775807L;
        a(paramInt1, paramFloat1, paramFloat2, paramInt2, paramLong);
        AppMethodBeat.o(151123);
        return;
      }
      if (hwV == 9223372036854775807L) {
        hwV = bt.eGO() + 60000L;
      }
      hwW = paramInt1;
      cOx.av(60000L, 60000L);
      AppMethodBeat.o(151123);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[] { bt.m(localThrowable) });
      AppMethodBeat.o(151123);
    }
  }
  
  public static void cE(Context paramContext)
  {
    AppMethodBeat.i(151116);
    if (paramContext == null) {}
    try
    {
      ad.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
      AppMethodBeat.o(151116);
      return;
    }
    catch (Throwable paramContext)
    {
      o.a locala;
      IntentFilter localIntentFilter;
      ad.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[] { bt.m(paramContext) });
      AppMethodBeat.o(151116);
    }
    locala = new o.a((byte)0);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(locala, localIntentFilter);
    ad.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    AppMethodBeat.o(151116);
    return;
  }
  
  public static void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(151124);
    if (paramBoolean)
    {
      hwX = 0L;
      AppMethodBeat.o(151124);
      return;
    }
    if (cOx.eFX())
    {
      AppMethodBeat.o(151124);
      return;
    }
    ad.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
    hwX = bt.eGO();
    cOx.av(0L, 0L);
    AppMethodBeat.o(151124);
  }
  
  /* Error */
  private static boolean n(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 466
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 471	java/util/ArrayList:size	()I
    //   10: ifne +19 -> 29
    //   13: ldc 199
    //   15: ldc_w 473
    //   18: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 466
    //   24: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   32: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifeq +31 -> 66
    //   38: new 316	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   45: invokestatic 362	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   48: getfield 479	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   51: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 481
    //   57: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: putstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   66: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   69: invokevirtual 482	java/util/HashMap:size	()I
    //   72: ifne +173 -> 245
    //   75: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   78: invokestatic 488	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   81: ldc2_w 489
    //   84: lcmp
    //   85: ifle +10 -> 95
    //   88: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   91: invokestatic 493	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   94: pop
    //   95: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   98: invokestatic 497	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   101: astore 4
    //   103: new 499	java/io/ObjectInputStream
    //   106: dup
    //   107: new 501	java/io/BufferedInputStream
    //   110: dup
    //   111: aload 4
    //   113: invokespecial 504	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 505	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 5
    //   121: aload 5
    //   123: astore 7
    //   125: aload 4
    //   127: astore 6
    //   129: aload 5
    //   131: invokevirtual 509	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   134: checkcast 52	java/util/HashMap
    //   137: putstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   140: aload 5
    //   142: astore 7
    //   144: aload 4
    //   146: astore 6
    //   148: ldc 199
    //   150: ldc_w 511
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   162: invokevirtual 482	java/util/HashMap:size	()I
    //   165: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 5
    //   174: invokevirtual 514	java/io/ObjectInputStream:close	()V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 517	java/io/InputStream:close	()V
    //   187: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   190: invokevirtual 482	java/util/HashMap:size	()I
    //   193: ifle +15 -> 208
    //   196: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   199: invokevirtual 482	java/util/HashMap:size	()I
    //   202: sipush 1000
    //   205: if_icmple +40 -> 245
    //   208: ldc 199
    //   210: ldc_w 519
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   222: invokevirtual 482	java/util/HashMap:size	()I
    //   225: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   241: invokestatic 493	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   244: pop
    //   245: aload_0
    //   246: invokevirtual 523	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   249: astore_0
    //   250: iconst_0
    //   251: istore_1
    //   252: aload_0
    //   253: invokeinterface 528 1 0
    //   258: ifeq +304 -> 562
    //   261: aload_0
    //   262: invokeinterface 531 1 0
    //   267: checkcast 353	java/lang/String
    //   270: astore 4
    //   272: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   275: aload 4
    //   277: invokevirtual 534	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: invokestatic 538	com/tencent/mm/sdk/platformtools/bt:dQ	(Ljava/lang/Object;)J
    //   283: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   286: lstore_2
    //   287: ldc 199
    //   289: ldc_w 540
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload 4
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: lload_2
    //   304: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   307: aastore
    //   308: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: lload_2
    //   312: lconst_0
    //   313: lcmp
    //   314: ifle +11 -> 325
    //   317: lload_2
    //   318: getstatic 50	com/tencent/mm/modelstat/o:hwS	J
    //   321: lcmp
    //   322: ifle +564 -> 886
    //   325: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   328: aload 4
    //   330: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   333: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   336: invokevirtual 544	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: iconst_1
    //   341: istore_1
    //   342: goto -90 -> 252
    //   345: astore 4
    //   347: ldc 199
    //   349: ldc_w 546
    //   352: iconst_1
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: aload 4
    //   360: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   363: aastore
    //   364: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: new 52	java/util/HashMap
    //   370: dup
    //   371: invokespecial 55	java/util/HashMap:<init>	()V
    //   374: putstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   377: goto -190 -> 187
    //   380: astore 8
    //   382: aconst_null
    //   383: astore 5
    //   385: aconst_null
    //   386: astore 4
    //   388: aload 5
    //   390: astore 7
    //   392: aload 4
    //   394: astore 6
    //   396: ldc 199
    //   398: ldc_w 546
    //   401: iconst_1
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload 8
    //   409: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   412: aastore
    //   413: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: aload 5
    //   418: astore 7
    //   420: aload 4
    //   422: astore 6
    //   424: new 52	java/util/HashMap
    //   427: dup
    //   428: invokespecial 55	java/util/HashMap:<init>	()V
    //   431: putstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   434: aload 5
    //   436: ifnull +8 -> 444
    //   439: aload 5
    //   441: invokevirtual 514	java/io/ObjectInputStream:close	()V
    //   444: aload 4
    //   446: ifnull -259 -> 187
    //   449: aload 4
    //   451: invokevirtual 517	java/io/InputStream:close	()V
    //   454: goto -267 -> 187
    //   457: astore 4
    //   459: ldc 199
    //   461: ldc_w 546
    //   464: iconst_1
    //   465: anewarray 4	java/lang/Object
    //   468: dup
    //   469: iconst_0
    //   470: aload 4
    //   472: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   475: aastore
    //   476: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   479: new 52	java/util/HashMap
    //   482: dup
    //   483: invokespecial 55	java/util/HashMap:<init>	()V
    //   486: putstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   489: goto -302 -> 187
    //   492: astore_0
    //   493: aconst_null
    //   494: astore 7
    //   496: aconst_null
    //   497: astore 4
    //   499: aload 7
    //   501: ifnull +8 -> 509
    //   504: aload 7
    //   506: invokevirtual 514	java/io/ObjectInputStream:close	()V
    //   509: aload 4
    //   511: ifnull +8 -> 519
    //   514: aload 4
    //   516: invokevirtual 517	java/io/InputStream:close	()V
    //   519: ldc_w 466
    //   522: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: aload_0
    //   526: athrow
    //   527: astore 4
    //   529: ldc 199
    //   531: ldc_w 546
    //   534: iconst_1
    //   535: anewarray 4	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: aload 4
    //   542: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   545: aastore
    //   546: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: new 52	java/util/HashMap
    //   552: dup
    //   553: invokespecial 55	java/util/HashMap:<init>	()V
    //   556: putstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   559: goto -40 -> 519
    //   562: iload_1
    //   563: ifeq +100 -> 663
    //   566: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   569: invokevirtual 482	java/util/HashMap:size	()I
    //   572: ifle +91 -> 663
    //   575: getstatic 59	com/tencent/mm/modelstat/o:hwU	Ljava/lang/String;
    //   578: iconst_0
    //   579: invokestatic 550	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   582: astore_0
    //   583: new 552	java/io/ObjectOutputStream
    //   586: dup
    //   587: aload_0
    //   588: invokespecial 555	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   591: astore 4
    //   593: aload 4
    //   595: astore 6
    //   597: aload_0
    //   598: astore 5
    //   600: aload 4
    //   602: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   605: invokevirtual 559	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   608: aload 4
    //   610: astore 6
    //   612: aload_0
    //   613: astore 5
    //   615: aload_0
    //   616: invokevirtual 564	java/io/OutputStream:flush	()V
    //   619: aload 4
    //   621: astore 6
    //   623: aload_0
    //   624: astore 5
    //   626: ldc 199
    //   628: ldc_w 566
    //   631: iconst_1
    //   632: anewarray 4	java/lang/Object
    //   635: dup
    //   636: iconst_0
    //   637: getstatic 57	com/tencent/mm/modelstat/o:hwT	Ljava/util/HashMap;
    //   640: invokevirtual 482	java/util/HashMap:size	()I
    //   643: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: aastore
    //   647: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: aload 4
    //   652: invokevirtual 567	java/io/ObjectOutputStream:close	()V
    //   655: aload_0
    //   656: ifnull +7 -> 663
    //   659: aload_0
    //   660: invokevirtual 568	java/io/OutputStream:close	()V
    //   663: ldc_w 466
    //   666: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   669: iload_1
    //   670: ireturn
    //   671: astore_0
    //   672: ldc 199
    //   674: ldc_w 570
    //   677: iconst_1
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: aload_0
    //   684: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   687: aastore
    //   688: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   708: ldc 199
    //   710: ldc_w 570
    //   713: iconst_1
    //   714: anewarray 4	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: aload 7
    //   721: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   724: aastore
    //   725: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   728: aload 4
    //   730: ifnull +8 -> 738
    //   733: aload 4
    //   735: invokevirtual 567	java/io/ObjectOutputStream:close	()V
    //   738: aload_0
    //   739: ifnull -76 -> 663
    //   742: aload_0
    //   743: invokevirtual 568	java/io/OutputStream:close	()V
    //   746: goto -83 -> 663
    //   749: astore_0
    //   750: ldc 199
    //   752: ldc_w 570
    //   755: iconst_1
    //   756: anewarray 4	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: aload_0
    //   762: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   765: aastore
    //   766: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   769: goto -106 -> 663
    //   772: astore 4
    //   774: aconst_null
    //   775: astore 6
    //   777: aconst_null
    //   778: astore_0
    //   779: aload 6
    //   781: ifnull +8 -> 789
    //   784: aload 6
    //   786: invokevirtual 567	java/io/ObjectOutputStream:close	()V
    //   789: aload_0
    //   790: ifnull +7 -> 797
    //   793: aload_0
    //   794: invokevirtual 568	java/io/OutputStream:close	()V
    //   797: ldc_w 466
    //   800: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   803: aload 4
    //   805: athrow
    //   806: astore_0
    //   807: ldc 199
    //   809: ldc_w 570
    //   812: iconst_1
    //   813: anewarray 4	java/lang/Object
    //   816: dup
    //   817: iconst_0
    //   818: aload_0
    //   819: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   822: aastore
    //   823: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   862: goto -363 -> 499
    //   865: astore_0
    //   866: aload 6
    //   868: astore 4
    //   870: goto -371 -> 499
    //   873: astore 8
    //   875: aconst_null
    //   876: astore 5
    //   878: goto -490 -> 388
    //   881: astore 8
    //   883: goto -495 -> 388
    //   886: goto -544 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	paramArrayList	java.util.ArrayList<String>
    //   251	419	1	bool	boolean
    //   286	32	2	l	long
    //   101	228	4	localObject1	Object
    //   345	14	4	localException1	Exception
    //   386	64	4	localObject2	Object
    //   457	14	4	localException2	Exception
    //   497	18	4	localObject3	Object
    //   527	14	4	localException3	Exception
    //   591	143	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   772	32	4	localObject4	Object
    //   829	1	4	localObject5	Object
    //   837	1	4	localObject6	Object
    //   848	21	4	localObject7	Object
    //   119	758	5	localObject8	Object
    //   127	740	6	localObject9	Object
    //   123	382	7	localObject10	Object
    //   694	26	7	localException4	Exception
    //   845	1	7	localException5	Exception
    //   853	1	7	localException6	Exception
    //   860	1	7	localObject11	Object
    //   380	28	8	localException7	Exception
    //   873	1	8	localException8	Exception
    //   881	1	8	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   172	177	345	java/lang/Exception
    //   182	187	345	java/lang/Exception
    //   75	95	380	java/lang/Exception
    //   95	103	380	java/lang/Exception
    //   439	444	457	java/lang/Exception
    //   449	454	457	java/lang/Exception
    //   75	95	492	finally
    //   95	103	492	finally
    //   504	509	527	java/lang/Exception
    //   514	519	527	java/lang/Exception
    //   650	655	671	java/lang/Exception
    //   659	663	671	java/lang/Exception
    //   575	583	694	java/lang/Exception
    //   733	738	749	java/lang/Exception
    //   742	746	749	java/lang/Exception
    //   575	583	772	finally
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
    //   396	416	865	finally
    //   424	434	865	finally
    //   103	121	873	java/lang/Exception
    //   129	140	881	java/lang/Exception
    //   148	172	881	java/lang/Exception
  }
  
  /* Error */
  private static String[] oM(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 573
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 199
    //   8: ldc_w 575
    //   11: iconst_4
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_0
    //   18: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: getstatic 340	com/tencent/mm/sdk/a/b:foreground	Z
    //   27: invokestatic 580	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: getstatic 95	com/tencent/mm/modelstat/o:hwX	J
    //   36: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: getstatic 95	com/tencent/mm/modelstat/o:hwX	J
    //   45: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   48: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: iload_0
    //   56: ifgt +30 -> 86
    //   59: ldc 199
    //   61: ldc_w 582
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: ldc_w 573
    //   81: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   89: astore 12
    //   91: aload 12
    //   93: ifnonnull +30 -> 123
    //   96: ldc 199
    //   98: ldc_w 584
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_0
    //   108: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: ldc_w 573
    //   118: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: ldc 199
    //   125: ldc_w 586
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: iload_0
    //   135: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: getstatic 340	com/tencent/mm/sdk/a/b:foreground	Z
    //   144: invokestatic 580	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: invokestatic 591	com/tencent/mm/compatible/deviceinfo/ab:Xx	()I
    //   154: istore_2
    //   155: ldc 199
    //   157: ldc_w 593
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: iload_2
    //   167: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 109
    //   176: astore 8
    //   178: ldc 109
    //   180: astore 16
    //   182: aload 8
    //   184: astore 7
    //   186: aload 12
    //   188: ldc_w 264
    //   191: invokevirtual 270	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: checkcast 272	android/net/wifi/WifiManager
    //   197: astore 15
    //   199: aload 8
    //   201: astore 7
    //   203: new 595	java/lang/StringBuffer
    //   206: dup
    //   207: invokespecial 596	java/lang/StringBuffer:<init>	()V
    //   210: astore 11
    //   212: aload 8
    //   214: astore 7
    //   216: new 595	java/lang/StringBuffer
    //   219: dup
    //   220: invokespecial 596	java/lang/StringBuffer:<init>	()V
    //   223: astore 9
    //   225: aload 8
    //   227: astore 7
    //   229: new 595	java/lang/StringBuffer
    //   232: dup
    //   233: invokespecial 596	java/lang/StringBuffer:<init>	()V
    //   236: astore 10
    //   238: iconst_0
    //   239: istore 4
    //   241: iconst_0
    //   242: istore_1
    //   243: aload 8
    //   245: astore 7
    //   247: new 468	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 597	java/util/ArrayList:<init>	()V
    //   254: astore 13
    //   256: aload 8
    //   258: astore 7
    //   260: aload 11
    //   262: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   265: invokestatic 603	com/tencent/mm/sdk/platformtools/ay:iA	(Landroid/content/Context;)Ljava/lang/String;
    //   268: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   271: pop
    //   272: aload 8
    //   274: astore 7
    //   276: aload 9
    //   278: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   281: invokestatic 609	com/tencent/mm/sdk/platformtools/ay:iB	(Landroid/content/Context;)Ljava/lang/String;
    //   284: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   287: pop
    //   288: aload 8
    //   290: astore 7
    //   292: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   295: invokestatic 609	com/tencent/mm/sdk/platformtools/ay:iB	(Landroid/content/Context;)Ljava/lang/String;
    //   298: astore 14
    //   300: aload 8
    //   302: astore 7
    //   304: aload 13
    //   306: aload 14
    //   308: invokevirtual 613	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   311: pop
    //   312: aload 8
    //   314: astore 7
    //   316: aload 15
    //   318: invokevirtual 617	android/net/wifi/WifiManager:getScanResults	()Ljava/util/List;
    //   321: astore 15
    //   323: aload 15
    //   325: ifnull +296 -> 621
    //   328: aload 8
    //   330: astore 7
    //   332: aload 15
    //   334: new 6	com/tencent/mm/modelstat/o$1
    //   337: dup
    //   338: invokespecial 618	com/tencent/mm/modelstat/o$1:<init>	()V
    //   341: invokestatic 624	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   344: aload 8
    //   346: astore 7
    //   348: aload 15
    //   350: invokeinterface 627 1 0
    //   355: astore 15
    //   357: bipush 20
    //   359: istore_3
    //   360: iload_1
    //   361: istore 4
    //   363: aload 8
    //   365: astore 7
    //   367: aload 15
    //   369: invokeinterface 528 1 0
    //   374: ifeq +247 -> 621
    //   377: aload 8
    //   379: astore 7
    //   381: aload 15
    //   383: invokeinterface 531 1 0
    //   388: checkcast 629	android/net/wifi/ScanResult
    //   391: astore 17
    //   393: aload 17
    //   395: ifnull -35 -> 360
    //   398: aload 8
    //   400: astore 7
    //   402: aload 17
    //   404: getfield 632	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   407: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   410: ifne -50 -> 360
    //   413: aload 8
    //   415: astore 7
    //   417: aload 17
    //   419: getfield 632	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   422: aload 14
    //   424: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: ifeq +43 -> 470
    //   430: aload 8
    //   432: astore 7
    //   434: aload 17
    //   436: getfield 638	android/net/wifi/ScanResult:level	I
    //   439: istore_1
    //   440: goto -80 -> 360
    //   443: astore 7
    //   445: ldc 199
    //   447: ldc_w 640
    //   450: iconst_1
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: aload 7
    //   458: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: aastore
    //   462: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   483: ldc_w 642
    //   486: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   489: pop
    //   490: aload 8
    //   492: astore 7
    //   494: aload 11
    //   496: aload 17
    //   498: getfield 645	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   501: invokestatic 649	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   504: ldc_w 642
    //   507: ldc 109
    //   509: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   512: ldc_w 655
    //   515: ldc 109
    //   517: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   520: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   523: pop
    //   524: aload 8
    //   526: astore 7
    //   528: aload 9
    //   530: ldc_w 642
    //   533: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   536: pop
    //   537: aload 8
    //   539: astore 7
    //   541: aload 9
    //   543: aload 17
    //   545: getfield 632	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   548: invokestatic 649	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   551: ldc_w 642
    //   554: ldc 109
    //   556: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   559: ldc_w 655
    //   562: ldc 109
    //   564: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   567: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   570: pop
    //   571: aload 8
    //   573: astore 7
    //   575: aload 13
    //   577: aload 17
    //   579: getfield 632	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   582: invokevirtual 613	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   585: pop
    //   586: aload 8
    //   588: astore 7
    //   590: aload 10
    //   592: ldc_w 642
    //   595: invokevirtual 606	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   598: pop
    //   599: aload 8
    //   601: astore 7
    //   603: aload 10
    //   605: aload 17
    //   607: getfield 638	android/net/wifi/ScanResult:level	I
    //   610: invokevirtual 658	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
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
    //   634: invokestatic 660	com/tencent/mm/modelstat/o:n	(Ljava/util/ArrayList;)Z
    //   637: ifne +34 -> 671
    //   640: aload 8
    //   642: astore 7
    //   644: ldc 199
    //   646: ldc_w 662
    //   649: iconst_1
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: iload_0
    //   656: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: aastore
    //   660: invokestatic 664	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   663: ldc_w 573
    //   666: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   669: aconst_null
    //   670: areturn
    //   671: aload 8
    //   673: astore 7
    //   675: aload 11
    //   677: invokevirtual 665	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   680: astore 8
    //   682: aload 8
    //   684: astore 7
    //   686: aload 9
    //   688: invokevirtual 665	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   691: astore 9
    //   693: aload 9
    //   695: astore 7
    //   697: new 316	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   704: iload 4
    //   706: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: aload 10
    //   711: invokevirtual 665	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   714: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: astore 9
    //   722: aload 9
    //   724: astore 16
    //   726: aload 8
    //   728: astore 18
    //   730: aload 7
    //   732: astore 17
    //   734: ldc 199
    //   736: ldc_w 667
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
    //   753: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: ldc 109
    //   758: astore 19
    //   760: aload 12
    //   762: ldc_w 669
    //   765: invokevirtual 270	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   768: checkcast 671	android/telephony/TelephonyManager
    //   771: astore 7
    //   773: aload 7
    //   775: ifnull +1093 -> 1868
    //   778: aload 7
    //   780: invokevirtual 674	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   783: astore 7
    //   785: aload 7
    //   787: astore 19
    //   789: ldc 199
    //   791: ldc_w 676
    //   794: iconst_1
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 19
    //   802: aastore
    //   803: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: ldc 109
    //   808: astore 11
    //   810: ldc 109
    //   812: astore 10
    //   814: ldc 109
    //   816: astore 8
    //   818: ldc 109
    //   820: astore 9
    //   822: ldc 109
    //   824: astore 7
    //   826: aload 12
    //   828: invokestatic 680	com/tencent/mm/sdk/platformtools/ay:iF	(Landroid/content/Context;)Ljava/util/List;
    //   831: astore 20
    //   833: iconst_0
    //   834: istore_1
    //   835: ldc 109
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
    //   862: invokeinterface 681 1 0
    //   867: if_icmpge +572 -> 1439
    //   870: aload 8
    //   872: astore 10
    //   874: aload 11
    //   876: astore 15
    //   878: aload 12
    //   880: astore 14
    //   882: aload 20
    //   884: iload_1
    //   885: invokeinterface 684 2 0
    //   890: checkcast 686	com/tencent/mm/sdk/platformtools/ay$a
    //   893: astore 21
    //   895: aload 8
    //   897: astore 10
    //   899: aload 11
    //   901: astore 15
    //   903: aload 12
    //   905: astore 14
    //   907: aload 21
    //   909: getfield 689	com/tencent/mm/sdk/platformtools/ay$a:tzr	Ljava/lang/String;
    //   912: ldc 109
    //   914: invokestatic 693	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 12
    //   919: aload 8
    //   921: astore 10
    //   923: aload 11
    //   925: astore 15
    //   927: aload 12
    //   929: astore 14
    //   931: aload 21
    //   933: getfield 696	com/tencent/mm/sdk/platformtools/ay$a:tzs	Ljava/lang/String;
    //   936: ldc 109
    //   938: invokestatic 693	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   961: invokevirtual 699	java/lang/String:length	()I
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
    //   985: getfield 702	com/tencent/mm/sdk/platformtools/ay$a:tzt	Ljava/lang/String;
    //   988: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   991: ifne +38 -> 1029
    //   994: aload 8
    //   996: astore 10
    //   998: aload 13
    //   1000: astore 15
    //   1002: aload 12
    //   1004: astore 14
    //   1006: new 316	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1013: aload 8
    //   1015: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc_w 642
    //   1021: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   1047: getfield 702	com/tencent/mm/sdk/platformtools/ay$a:tzt	Ljava/lang/String;
    //   1050: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1053: ifne +40 -> 1093
    //   1056: aload 11
    //   1058: astore 10
    //   1060: aload 13
    //   1062: astore 15
    //   1064: aload 12
    //   1066: astore 14
    //   1068: new 316	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1075: aload 11
    //   1077: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload 21
    //   1082: getfield 702	com/tencent/mm/sdk/platformtools/ay$a:tzt	Ljava/lang/String;
    //   1085: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: astore 8
    //   1093: aload 8
    //   1095: astore 10
    //   1097: aload 13
    //   1099: astore 15
    //   1101: aload 12
    //   1103: astore 14
    //   1105: aload 9
    //   1107: invokevirtual 699	java/lang/String:length	()I
    //   1110: ifle +751 -> 1861
    //   1113: aload 8
    //   1115: astore 10
    //   1117: aload 13
    //   1119: astore 15
    //   1121: aload 12
    //   1123: astore 14
    //   1125: aload 21
    //   1127: getfield 705	com/tencent/mm/sdk/platformtools/ay$a:Aep	Ljava/lang/String;
    //   1130: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1133: ifne +728 -> 1861
    //   1136: aload 8
    //   1138: astore 10
    //   1140: aload 13
    //   1142: astore 15
    //   1144: aload 12
    //   1146: astore 14
    //   1148: new 316	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1155: aload 9
    //   1157: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: ldc_w 642
    //   1163: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   1189: getfield 705	com/tencent/mm/sdk/platformtools/ay$a:Aep	Ljava/lang/String;
    //   1192: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1195: ifne +36 -> 1231
    //   1198: aload 7
    //   1200: astore 11
    //   1202: aload 10
    //   1204: astore 14
    //   1206: new 316	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1213: aload 10
    //   1215: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: aload 21
    //   1220: getfield 705	com/tencent/mm/sdk/platformtools/ay$a:Aep	Ljava/lang/String;
    //   1223: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: astore 9
    //   1231: aload 7
    //   1233: astore 10
    //   1235: aload 7
    //   1237: astore 11
    //   1239: aload 9
    //   1241: astore 14
    //   1243: aload 7
    //   1245: invokevirtual 699	java/lang/String:length	()I
    //   1248: ifle +34 -> 1282
    //   1251: aload 7
    //   1253: astore 11
    //   1255: aload 9
    //   1257: astore 14
    //   1259: new 316	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1266: aload 7
    //   1268: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: ldc_w 642
    //   1274: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: astore 10
    //   1282: aload 10
    //   1284: astore 11
    //   1286: aload 9
    //   1288: astore 14
    //   1290: new 316	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1297: aload 10
    //   1299: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: astore 15
    //   1304: aload 10
    //   1306: astore 11
    //   1308: aload 9
    //   1310: astore 14
    //   1312: aload 21
    //   1314: getfield 708	com/tencent/mm/sdk/platformtools/ay$a:Aet	Ljava/lang/String;
    //   1317: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1320: ifeq +101 -> 1421
    //   1323: ldc_w 710
    //   1326: astore 7
    //   1328: aload 10
    //   1330: astore 11
    //   1332: aload 9
    //   1334: astore 14
    //   1336: aload 15
    //   1338: aload 7
    //   1340: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: astore 7
    //   1348: iload_1
    //   1349: iconst_1
    //   1350: iadd
    //   1351: istore_1
    //   1352: aload 13
    //   1354: astore 11
    //   1356: goto -509 -> 847
    //   1359: astore 8
    //   1361: ldc 109
    //   1363: astore 9
    //   1365: ldc 199
    //   1367: ldc_w 712
    //   1370: iconst_1
    //   1371: anewarray 4	java/lang/Object
    //   1374: dup
    //   1375: iconst_0
    //   1376: aload 8
    //   1378: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1381: aastore
    //   1382: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1385: aload 9
    //   1387: astore 17
    //   1389: aload 7
    //   1391: astore 18
    //   1393: goto -659 -> 734
    //   1396: astore 7
    //   1398: ldc 199
    //   1400: ldc_w 640
    //   1403: iconst_1
    //   1404: anewarray 4	java/lang/Object
    //   1407: dup
    //   1408: iconst_0
    //   1409: aload 7
    //   1411: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1414: aastore
    //   1415: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1418: goto -629 -> 789
    //   1421: aload 10
    //   1423: astore 11
    //   1425: aload 9
    //   1427: astore 14
    //   1429: aload 21
    //   1431: getfield 708	com/tencent/mm/sdk/platformtools/ay$a:Aet	Ljava/lang/String;
    //   1434: astore 7
    //   1436: goto -108 -> 1328
    //   1439: aload 11
    //   1441: astore 10
    //   1443: ldc 199
    //   1445: ldc_w 714
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
    //   1467: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1470: new 316	java/lang/StringBuilder
    //   1473: dup
    //   1474: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1477: astore 11
    //   1479: aload 11
    //   1481: invokestatic 717	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   1484: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1487: ldc_w 328
    //   1490: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 11
    //   1496: iload_0
    //   1497: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: ldc_w 328
    //   1503: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 11
    //   1509: iload_2
    //   1510: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1513: ldc_w 328
    //   1516: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: pop
    //   1520: aload 11
    //   1522: aload 18
    //   1524: ldc_w 328
    //   1527: ldc_w 655
    //   1530: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1533: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: ldc_w 328
    //   1539: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 11
    //   1545: aload 17
    //   1547: ldc_w 328
    //   1550: ldc_w 655
    //   1553: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1556: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: ldc_w 328
    //   1565: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload 11
    //   1571: aload 19
    //   1573: ldc_w 328
    //   1576: ldc_w 655
    //   1579: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1582: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: ldc_w 328
    //   1588: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: aload 11
    //   1594: aload 12
    //   1596: ldc_w 328
    //   1599: ldc_w 655
    //   1602: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1605: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1608: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: ldc_w 328
    //   1614: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 11
    //   1620: aload 10
    //   1622: ldc_w 328
    //   1625: ldc_w 655
    //   1628: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1631: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1634: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 328
    //   1640: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: pop
    //   1644: aload 11
    //   1646: aload 8
    //   1648: ldc_w 328
    //   1651: ldc_w 655
    //   1654: invokevirtual 653	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1657: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1660: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: ldc_w 328
    //   1666: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: pop
    //   1670: invokestatic 722	com/tencent/mm/modelstat/o:aBM	()J
    //   1673: lstore 5
    //   1675: lload 5
    //   1677: lconst_0
    //   1678: lcmp
    //   1679: ifge +40 -> 1719
    //   1682: ldc_w 573
    //   1685: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1688: aconst_null
    //   1689: areturn
    //   1690: astore 12
    //   1692: ldc 199
    //   1694: ldc_w 640
    //   1697: iconst_1
    //   1698: anewarray 4	java/lang/Object
    //   1701: dup
    //   1702: iconst_0
    //   1703: aload 12
    //   1705: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1708: aastore
    //   1709: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1712: aload 11
    //   1714: astore 12
    //   1716: goto -273 -> 1443
    //   1719: new 316	java/lang/StringBuilder
    //   1722: dup
    //   1723: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   1726: lload 5
    //   1728: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1731: ldc_w 328
    //   1734: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: aload 11
    //   1739: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1742: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: astore 8
    //   1750: aload 16
    //   1752: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1755: astore 10
    //   1757: aload 9
    //   1759: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1762: astore 9
    //   1764: aload 7
    //   1766: invokestatic 720	com/tencent/mm/modelstat/o:zu	(Ljava/lang/String;)Ljava/lang/String;
    //   1769: astore 7
    //   1771: ldc_w 573
    //   1774: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1777: iconst_4
    //   1778: anewarray 353	java/lang/String
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
    //   1868: ldc 109
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
    //   893	537	21	locala	com.tencent.mm.sdk.platformtools.ay.a
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
  public static void run(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 744
    //   6: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 199
    //   11: ldc_w 746
    //   14: iconst_4
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_0
    //   21: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: getstatic 340	com/tencent/mm/sdk/a/b:foreground	Z
    //   30: invokestatic 580	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: getstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   39: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: getstatic 111	com/tencent/mm/modelstat/o:hxe	Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: iload_0
    //   53: sipush 1005
    //   56: if_icmpne +139 -> 195
    //   59: getstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifle +131 -> 195
    //   67: ldc 199
    //   69: ldc_w 748
    //   72: bipush 6
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: iload_0
    //   80: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: getstatic 105	com/tencent/mm/modelstat/o:hxc	I
    //   89: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: dup
    //   94: iconst_2
    //   95: getstatic 101	com/tencent/mm/modelstat/o:hxa	F
    //   98: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: getstatic 99	com/tencent/mm/modelstat/o:hwZ	F
    //   107: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   110: aastore
    //   111: dup
    //   112: iconst_4
    //   113: getstatic 103	com/tencent/mm/modelstat/o:hxb	I
    //   116: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: dup
    //   121: iconst_5
    //   122: getstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   125: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: getstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   135: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   138: lstore 4
    //   140: getstatic 105	com/tencent/mm/modelstat/o:hxc	I
    //   143: istore_0
    //   144: getstatic 99	com/tencent/mm/modelstat/o:hwZ	F
    //   147: fstore_1
    //   148: getstatic 101	com/tencent/mm/modelstat/o:hxa	F
    //   151: fstore_2
    //   152: getstatic 103	com/tencent/mm/modelstat/o:hxb	I
    //   155: istore_3
    //   156: lconst_0
    //   157: putstatic 97	com/tencent/mm/modelstat/o:hwY	J
    //   160: fconst_0
    //   161: putstatic 99	com/tencent/mm/modelstat/o:hwZ	F
    //   164: fconst_0
    //   165: putstatic 101	com/tencent/mm/modelstat/o:hxa	F
    //   168: iconst_0
    //   169: putstatic 103	com/tencent/mm/modelstat/o:hxb	I
    //   172: iconst_0
    //   173: putstatic 105	com/tencent/mm/modelstat/o:hxc	I
    //   176: iload_0
    //   177: fload_2
    //   178: fload_1
    //   179: iload_3
    //   180: lload 4
    //   182: invokestatic 750	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   185: ldc_w 744
    //   188: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: getstatic 340	com/tencent/mm/sdk/a/b:foreground	Z
    //   198: ifne +39 -> 237
    //   201: ldc 199
    //   203: ldc_w 752
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: iload_0
    //   213: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aastore
    //   217: invokestatic 664	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc_w 744
    //   223: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: goto -35 -> 191
    //   229: astore 6
    //   231: ldc 2
    //   233: monitorexit
    //   234: aload 6
    //   236: athrow
    //   237: iload_0
    //   238: iconst_3
    //   239: if_icmpne +94 -> 333
    //   242: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   245: ldc_w 264
    //   248: invokevirtual 270	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   251: checkcast 272	android/net/wifi/WifiManager
    //   254: invokevirtual 756	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   257: invokevirtual 761	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   260: astore 6
    //   262: ldc 199
    //   264: ldc_w 763
    //   267: iconst_3
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_0
    //   274: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 6
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: getstatic 111	com/tencent/mm/modelstat/o:hxe	Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload 6
    //   294: invokestatic 302	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   297: ifne +27 -> 324
    //   300: aload 6
    //   302: getstatic 111	com/tencent/mm/modelstat/o:hxe	Ljava/lang/String;
    //   305: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifne +16 -> 324
    //   311: aload 6
    //   313: putstatic 111	com/tencent/mm/modelstat/o:hxe	Ljava/lang/String;
    //   316: iload_0
    //   317: fconst_0
    //   318: fconst_0
    //   319: iconst_0
    //   320: lconst_0
    //   321: invokestatic 750	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   324: ldc_w 744
    //   327: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: goto -139 -> 191
    //   333: iload_0
    //   334: iconst_4
    //   335: if_icmpne +81 -> 416
    //   338: invokestatic 362	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   341: invokevirtual 368	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   344: getstatic 740	com/tencent/mm/storage/ae$a:FgQ	Lcom/tencent/mm/storage/ae$a;
    //   347: aconst_null
    //   348: invokevirtual 380	com/tencent/mm/storage/ab:get	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: checkcast 253	java/lang/Long
    //   354: lconst_0
    //   355: invokestatic 383	com/tencent/mm/sdk/platformtools/bt:a	(Ljava/lang/Long;J)J
    //   358: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   361: lstore 4
    //   363: ldc 199
    //   365: ldc_w 765
    //   368: iconst_2
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: iload_0
    //   375: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: lload 4
    //   383: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   386: aastore
    //   387: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: lload 4
    //   392: ldc2_w 766
    //   395: lcmp
    //   396: iflt +11 -> 407
    //   399: iload_0
    //   400: fconst_0
    //   401: fconst_0
    //   402: iconst_0
    //   403: lconst_0
    //   404: invokestatic 750	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   407: ldc_w 744
    //   410: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: goto -222 -> 191
    //   416: iload_0
    //   417: fconst_0
    //   418: fconst_0
    //   419: iconst_0
    //   420: lconst_0
    //   421: invokestatic 750	com/tencent/mm/modelstat/o:b	(IFFIJ)V
    //   424: ldc_w 744
    //   427: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: goto -239 -> 191
    //   433: astore 6
    //   435: ldc 199
    //   437: ldc_w 769
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: aload 6
    //   448: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   451: aastore
    //   452: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   455: ldc_w 744
    //   458: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static String zu(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.o
 * JD-Core Version:    0.7.0.1
 */