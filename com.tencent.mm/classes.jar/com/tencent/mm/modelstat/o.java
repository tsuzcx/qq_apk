package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public final class o
{
  private static am byQ;
  private static final byte[] dMQ;
  private static float eEA = 0.0F;
  private static int eEB = 0;
  private static int eEC = 0;
  private static long eED = 0L;
  private static String eEE = "";
  private static long eEs = 86400000L;
  private static HashMap<String, Long> eEt = new HashMap();
  private static String eEu = null;
  private static long eEv;
  private static int eEw;
  private static long eEx;
  private static long eEy;
  private static float eEz;
  
  static
  {
    dMQ = new byte[0];
    eEv = 9223372036854775807L;
    eEw = 0;
    byQ = new am(g.DS().mnU.getLooper(), new o.4(), false);
    eEx = 0L;
    eEy = 0L;
    eEz = 0.0F;
  }
  
  private static long Ry()
  {
    synchronized (dMQ)
    {
      try
      {
        long l = bk.a((Long)g.DP().Dz().get(ac.a.uoy, null), 1L);
        g.DP().Dz().c(ac.a.uoy, Long.valueOf(1L + l));
        g.DP().Dz().mC(true);
        y.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[] { Long.valueOf(l), Long.valueOf(bk.a((Long)g.DP().Dz().get(ac.a.uoy, null), 1L)) });
        return l;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[] { bk.j(localException) });
        return -1L;
      }
    }
  }
  
  public static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    if ((paramInt1 < 2000) || (paramFloat1 == 0.0F) || (paramFloat2 == 0.0F)) {}
    for (;;)
    {
      try
      {
        y.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
        return;
      }
      finally {}
      if (bk.co(eED) < 60000L)
      {
        y.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
      }
      else
      {
        y.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(bk.co(eED)) });
        eED = bk.UY();
        eEC = paramInt1;
        eEy = bk.UY();
        eEB = paramInt2;
        eEz = paramFloat2;
        eEA = paramFloat1;
        try
        {
          ((WifiManager)ae.getContext().getSystemService("wifi")).startScan();
          g.DS().k(new o.5(), 5000L);
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.NetTypeReporter", "reportGps :%s", new Object[] { bk.j(localException) });
        }
      }
    }
  }
  
  private static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    long l1 = bk.UY();
    if ((eEx > 0L) && (l1 - eEx > 5000L))
    {
      y.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[] { Long.valueOf(eEx), Long.valueOf(l1 - eEx) });
      return;
    }
    String[] arrayOfString = jk(paramInt1);
    if ((arrayOfString == null) || (arrayOfString.length != 4) || (bk.bl(arrayOfString[0])))
    {
      y.e("MicroMsg.NetTypeReporter", "report get failed val");
      return;
    }
    y.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bk.co(l1)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(paramLong), arrayOfString[0] });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bjh();
    ((b.a)localObject).ecI = new bji();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((b.a)localObject).ecG = 716;
    com.tencent.mm.ah.b localb = ((b.a)localObject).Kt();
    bjh localbjh = (bjh)localb.ecE.ecN;
    localbjh.sEc = d.soV;
    localbjh.sEd = d.soU;
    localbjh.sEe = d.soX;
    localbjh.sEf = d.soY;
    localbjh.sEg = x.cqJ();
    localbjh.tou = 11747;
    long l2 = bk.co(eEx);
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
      localbjh.nFs = ((String)localObject + "," + arrayOfString[1] + "," + arrayOfString[2] + "," + arrayOfString[3]);
      w.a(localb, new o.2(bk.UY(), localbjh, arrayOfString, paramFloat1, paramFloat2, paramInt2, paramLong), true);
      return;
    }
  }
  
  private static void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    try
    {
      y.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bk.co(eEv)), Long.valueOf(eEv) });
      if ((paramInt1 > 2000) || (bk.co(eEv) > 300000L))
      {
        y.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bk.co(eEv)), Long.valueOf(eEv) });
        eEw = paramInt1;
        eEv = 9223372036854775807L;
        a(paramInt1, paramFloat1, paramFloat2, paramInt2, paramLong);
        return;
      }
      if (eEv == 9223372036854775807L) {
        eEv = bk.UY() + 60000L;
      }
      eEw = paramInt1;
      byQ.S(60000L, 60000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[] { bk.j(localThrowable) });
    }
  }
  
  public static void bE(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      y.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
      return;
    }
    catch (Throwable paramContext)
    {
      o.a locala;
      IntentFilter localIntentFilter;
      y.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[] { bk.j(paramContext) });
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
    y.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    return;
  }
  
  public static void cc(boolean paramBoolean)
  {
    if (paramBoolean) {
      eEx = 0L;
    }
    while (byQ.crl()) {
      return;
    }
    y.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
    eEx = bk.UY();
    byQ.S(0L, 0L);
  }
  
  /* Error */
  private static boolean h(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 442	java/util/ArrayList:size	()I
    //   4: ifne +13 -> 17
    //   7: ldc 147
    //   9: ldc_w 444
    //   12: invokestatic 447	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: iconst_0
    //   16: ireturn
    //   17: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   20: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   23: ifeq +31 -> 54
    //   26: new 326	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   33: invokestatic 107	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   36: getfield 450	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   39: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 452
    //   45: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: putstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   54: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   57: invokevirtual 453	java/util/HashMap:size	()I
    //   60: ifne +171 -> 231
    //   63: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   66: invokestatic 459	com/tencent/mm/a/e:bJ	(Ljava/lang/String;)I
    //   69: ldc_w 460
    //   72: if_icmple +10 -> 82
    //   75: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   78: invokestatic 463	com/tencent/mm/a/e:deleteFile	(Ljava/lang/String;)Z
    //   81: pop
    //   82: new 465	java/io/FileInputStream
    //   85: dup
    //   86: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   89: invokespecial 467	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   92: astore 5
    //   94: new 469	java/io/ObjectInputStream
    //   97: dup
    //   98: new 471	java/io/BufferedInputStream
    //   101: dup
    //   102: aload 5
    //   104: invokespecial 474	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: invokespecial 475	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore 4
    //   112: aload 4
    //   114: astore 7
    //   116: aload 5
    //   118: astore 6
    //   120: aload 4
    //   122: invokevirtual 479	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   125: checkcast 37	java/util/HashMap
    //   128: putstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   131: aload 4
    //   133: astore 7
    //   135: aload 5
    //   137: astore 6
    //   139: ldc 147
    //   141: ldc_w 481
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   153: invokevirtual 453	java/util/HashMap:size	()I
    //   156: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload 4
    //   165: invokevirtual 484	java/io/ObjectInputStream:close	()V
    //   168: aload 5
    //   170: invokevirtual 485	java/io/FileInputStream:close	()V
    //   173: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   176: invokevirtual 453	java/util/HashMap:size	()I
    //   179: ifle +15 -> 194
    //   182: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   185: invokevirtual 453	java/util/HashMap:size	()I
    //   188: sipush 1000
    //   191: if_icmple +40 -> 231
    //   194: ldc 147
    //   196: ldc_w 487
    //   199: iconst_2
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   208: invokevirtual 453	java/util/HashMap:size	()I
    //   211: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   227: invokestatic 463	com/tencent/mm/a/e:deleteFile	(Ljava/lang/String;)Z
    //   230: pop
    //   231: aload_0
    //   232: invokevirtual 491	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   235: astore_0
    //   236: iconst_0
    //   237: istore_1
    //   238: aload_0
    //   239: invokeinterface 496 1 0
    //   244: ifeq +298 -> 542
    //   247: aload_0
    //   248: invokeinterface 499 1 0
    //   253: checkcast 370	java/lang/String
    //   256: astore 4
    //   258: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   261: aload 4
    //   263: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: invokestatic 506	com/tencent/mm/sdk/platformtools/bk:bU	(Ljava/lang/Object;)J
    //   269: invokestatic 184	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   272: lstore_2
    //   273: ldc 147
    //   275: ldc_w 508
    //   278: iconst_2
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload 4
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: lload_2
    //   290: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   293: aastore
    //   294: invokestatic 245	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: lload_2
    //   298: lconst_0
    //   299: lcmp
    //   300: ifle +11 -> 311
    //   303: lload_2
    //   304: getstatic 35	com/tencent/mm/modelstat/o:eEs	J
    //   307: lcmp
    //   308: ifle +547 -> 855
    //   311: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   314: aload 4
    //   316: invokestatic 193	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   319: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: invokevirtual 512	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: iconst_1
    //   327: istore_1
    //   328: goto -90 -> 238
    //   331: astore 4
    //   333: ldc 147
    //   335: ldc_w 514
    //   338: iconst_1
    //   339: anewarray 4	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: aload 4
    //   346: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: new 37	java/util/HashMap
    //   356: dup
    //   357: invokespecial 40	java/util/HashMap:<init>	()V
    //   360: putstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   363: goto -190 -> 173
    //   366: astore 8
    //   368: aconst_null
    //   369: astore 4
    //   371: aconst_null
    //   372: astore 5
    //   374: aload 4
    //   376: astore 7
    //   378: aload 5
    //   380: astore 6
    //   382: ldc 147
    //   384: ldc_w 514
    //   387: iconst_1
    //   388: anewarray 4	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: aload 8
    //   395: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   398: aastore
    //   399: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 4
    //   404: astore 7
    //   406: aload 5
    //   408: astore 6
    //   410: new 37	java/util/HashMap
    //   413: dup
    //   414: invokespecial 40	java/util/HashMap:<init>	()V
    //   417: putstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 484	java/io/ObjectInputStream:close	()V
    //   430: aload 5
    //   432: ifnull -259 -> 173
    //   435: aload 5
    //   437: invokevirtual 485	java/io/FileInputStream:close	()V
    //   440: goto -267 -> 173
    //   443: astore 4
    //   445: ldc 147
    //   447: ldc_w 514
    //   450: iconst_1
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: aload 4
    //   458: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: aastore
    //   462: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: new 37	java/util/HashMap
    //   468: dup
    //   469: invokespecial 40	java/util/HashMap:<init>	()V
    //   472: putstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   475: goto -302 -> 173
    //   478: astore_0
    //   479: aconst_null
    //   480: astore 7
    //   482: aconst_null
    //   483: astore 5
    //   485: aload 7
    //   487: ifnull +8 -> 495
    //   490: aload 7
    //   492: invokevirtual 484	java/io/ObjectInputStream:close	()V
    //   495: aload 5
    //   497: ifnull +8 -> 505
    //   500: aload 5
    //   502: invokevirtual 485	java/io/FileInputStream:close	()V
    //   505: aload_0
    //   506: athrow
    //   507: astore 4
    //   509: ldc 147
    //   511: ldc_w 514
    //   514: iconst_1
    //   515: anewarray 4	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: aload 4
    //   522: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   525: aastore
    //   526: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: new 37	java/util/HashMap
    //   532: dup
    //   533: invokespecial 40	java/util/HashMap:<init>	()V
    //   536: putstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   539: goto -34 -> 505
    //   542: iload_1
    //   543: ifeq +100 -> 643
    //   546: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   549: invokevirtual 453	java/util/HashMap:size	()I
    //   552: ifle +91 -> 643
    //   555: new 516	java/io/FileOutputStream
    //   558: dup
    //   559: getstatic 44	com/tencent/mm/modelstat/o:eEu	Ljava/lang/String;
    //   562: invokespecial 517	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   565: astore 4
    //   567: new 519	java/io/ObjectOutputStream
    //   570: dup
    //   571: aload 4
    //   573: invokespecial 522	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   576: astore_0
    //   577: aload_0
    //   578: astore 6
    //   580: aload 4
    //   582: astore 5
    //   584: aload_0
    //   585: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   588: invokevirtual 526	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   591: aload_0
    //   592: astore 6
    //   594: aload 4
    //   596: astore 5
    //   598: aload 4
    //   600: invokevirtual 529	java/io/FileOutputStream:flush	()V
    //   603: aload_0
    //   604: astore 6
    //   606: aload 4
    //   608: astore 5
    //   610: ldc 147
    //   612: ldc_w 531
    //   615: iconst_1
    //   616: anewarray 4	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: getstatic 42	com/tencent/mm/modelstat/o:eEt	Ljava/util/HashMap;
    //   624: invokevirtual 453	java/util/HashMap:size	()I
    //   627: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: aastore
    //   631: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: aload_0
    //   635: invokevirtual 532	java/io/ObjectOutputStream:close	()V
    //   638: aload 4
    //   640: invokevirtual 533	java/io/FileOutputStream:close	()V
    //   643: iload_1
    //   644: ireturn
    //   645: astore_0
    //   646: ldc 147
    //   648: ldc_w 535
    //   651: iconst_1
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: aload_0
    //   658: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   661: aastore
    //   662: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   665: goto -22 -> 643
    //   668: astore 7
    //   670: aconst_null
    //   671: astore_0
    //   672: aconst_null
    //   673: astore 4
    //   675: aload_0
    //   676: astore 6
    //   678: aload 4
    //   680: astore 5
    //   682: ldc 147
    //   684: ldc_w 535
    //   687: iconst_1
    //   688: anewarray 4	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: aload 7
    //   695: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   698: aastore
    //   699: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: aload_0
    //   703: ifnull +7 -> 710
    //   706: aload_0
    //   707: invokevirtual 532	java/io/ObjectOutputStream:close	()V
    //   710: aload 4
    //   712: ifnull -69 -> 643
    //   715: aload 4
    //   717: invokevirtual 533	java/io/FileOutputStream:close	()V
    //   720: goto -77 -> 643
    //   723: astore_0
    //   724: ldc 147
    //   726: ldc_w 535
    //   729: iconst_1
    //   730: anewarray 4	java/lang/Object
    //   733: dup
    //   734: iconst_0
    //   735: aload_0
    //   736: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   739: aastore
    //   740: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   743: goto -100 -> 643
    //   746: astore_0
    //   747: aconst_null
    //   748: astore 6
    //   750: aconst_null
    //   751: astore 4
    //   753: aload 6
    //   755: ifnull +8 -> 763
    //   758: aload 6
    //   760: invokevirtual 532	java/io/ObjectOutputStream:close	()V
    //   763: aload 4
    //   765: ifnull +8 -> 773
    //   768: aload 4
    //   770: invokevirtual 533	java/io/FileOutputStream:close	()V
    //   773: aload_0
    //   774: athrow
    //   775: astore 4
    //   777: ldc 147
    //   779: ldc_w 535
    //   782: iconst_1
    //   783: anewarray 4	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: aload 4
    //   790: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   793: aastore
    //   794: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   797: goto -24 -> 773
    //   800: astore_0
    //   801: aconst_null
    //   802: astore 6
    //   804: goto -51 -> 753
    //   807: astore_0
    //   808: aload 5
    //   810: astore 4
    //   812: goto -59 -> 753
    //   815: astore 7
    //   817: aconst_null
    //   818: astore_0
    //   819: goto -144 -> 675
    //   822: astore 7
    //   824: goto -149 -> 675
    //   827: astore_0
    //   828: aconst_null
    //   829: astore 7
    //   831: goto -346 -> 485
    //   834: astore_0
    //   835: aload 6
    //   837: astore 5
    //   839: goto -354 -> 485
    //   842: astore 8
    //   844: aconst_null
    //   845: astore 4
    //   847: goto -473 -> 374
    //   850: astore 8
    //   852: goto -478 -> 374
    //   855: goto -527 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	paramArrayList	java.util.ArrayList<String>
    //   237	407	1	bool	boolean
    //   272	32	2	l	long
    //   110	205	4	localObject1	Object
    //   331	14	4	localException1	Exception
    //   369	57	4	localObject2	Object
    //   443	14	4	localException2	Exception
    //   507	14	4	localException3	Exception
    //   565	204	4	localFileOutputStream	java.io.FileOutputStream
    //   775	14	4	localException4	Exception
    //   810	36	4	localObject3	Object
    //   92	746	5	localObject4	Object
    //   118	718	6	localObject5	Object
    //   114	377	7	localObject6	Object
    //   668	26	7	localException5	Exception
    //   815	1	7	localException6	Exception
    //   822	1	7	localException7	Exception
    //   829	1	7	localObject7	Object
    //   366	28	8	localException8	Exception
    //   842	1	8	localException9	Exception
    //   850	1	8	localException10	Exception
    // Exception table:
    //   from	to	target	type
    //   163	173	331	java/lang/Exception
    //   63	82	366	java/lang/Exception
    //   82	94	366	java/lang/Exception
    //   425	430	443	java/lang/Exception
    //   435	440	443	java/lang/Exception
    //   63	82	478	finally
    //   82	94	478	finally
    //   490	495	507	java/lang/Exception
    //   500	505	507	java/lang/Exception
    //   634	643	645	java/lang/Exception
    //   555	567	668	java/lang/Exception
    //   706	710	723	java/lang/Exception
    //   715	720	723	java/lang/Exception
    //   555	567	746	finally
    //   758	763	775	java/lang/Exception
    //   768	773	775	java/lang/Exception
    //   567	577	800	finally
    //   584	591	807	finally
    //   598	603	807	finally
    //   610	634	807	finally
    //   682	702	807	finally
    //   567	577	815	java/lang/Exception
    //   584	591	822	java/lang/Exception
    //   598	603	822	java/lang/Exception
    //   610	634	822	java/lang/Exception
    //   94	112	827	finally
    //   120	131	834	finally
    //   139	163	834	finally
    //   382	402	834	finally
    //   410	420	834	finally
    //   94	112	842	java/lang/Exception
    //   120	131	850	java/lang/Exception
    //   139	163	850	java/lang/Exception
  }
  
  /* Error */
  private static String[] jk(int paramInt)
  {
    // Byte code:
    //   0: ldc 147
    //   2: ldc_w 539
    //   5: iconst_4
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_0
    //   12: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: getstatic 350	com/tencent/mm/sdk/a/b:foreground	Z
    //   21: invokestatic 544	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: dup
    //   26: iconst_2
    //   27: getstatic 82	com/tencent/mm/modelstat/o:eEx	J
    //   30: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   33: aastore
    //   34: dup
    //   35: iconst_3
    //   36: getstatic 82	com/tencent/mm/modelstat/o:eEx	J
    //   39: invokestatic 184	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   42: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: aastore
    //   46: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: iload_0
    //   50: ifgt +24 -> 74
    //   53: ldc 147
    //   55: ldc_w 546
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: iload_0
    //   65: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aconst_null
    //   73: areturn
    //   74: invokestatic 199	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   77: astore 12
    //   79: aload 12
    //   81: ifnonnull +24 -> 105
    //   84: ldc 147
    //   86: ldc_w 548
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: iload_0
    //   96: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aconst_null
    //   104: areturn
    //   105: ldc 147
    //   107: ldc_w 550
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: iload_0
    //   117: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: getstatic 350	com/tencent/mm/sdk/a/b:foreground	Z
    //   126: invokestatic 544	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   129: aastore
    //   130: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: invokestatic 555	com/tencent/mm/compatible/e/w:zx	()I
    //   136: istore_2
    //   137: ldc 147
    //   139: ldc_w 557
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: iload_2
    //   149: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: ldc 96
    //   158: astore 8
    //   160: ldc 96
    //   162: astore 17
    //   164: aload 8
    //   166: astore 7
    //   168: aload 12
    //   170: ldc 201
    //   172: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   175: checkcast 209	android/net/wifi/WifiManager
    //   178: astore 15
    //   180: aload 8
    //   182: astore 7
    //   184: aload 15
    //   186: invokevirtual 561	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   189: astore 14
    //   191: aload 8
    //   193: astore 7
    //   195: new 563	java/lang/StringBuffer
    //   198: dup
    //   199: invokespecial 564	java/lang/StringBuffer:<init>	()V
    //   202: astore 11
    //   204: aload 8
    //   206: astore 7
    //   208: new 563	java/lang/StringBuffer
    //   211: dup
    //   212: invokespecial 564	java/lang/StringBuffer:<init>	()V
    //   215: astore 9
    //   217: aload 8
    //   219: astore 7
    //   221: new 563	java/lang/StringBuffer
    //   224: dup
    //   225: invokespecial 564	java/lang/StringBuffer:<init>	()V
    //   228: astore 10
    //   230: iconst_0
    //   231: istore 4
    //   233: iconst_0
    //   234: istore_1
    //   235: aload 8
    //   237: astore 7
    //   239: new 439	java/util/ArrayList
    //   242: dup
    //   243: invokespecial 565	java/util/ArrayList:<init>	()V
    //   246: astore 13
    //   248: aload 8
    //   250: astore 7
    //   252: aload 11
    //   254: aload 14
    //   256: invokevirtual 570	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   259: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 8
    //   265: astore 7
    //   267: aload 9
    //   269: aload 14
    //   271: invokevirtual 576	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   274: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   277: pop
    //   278: aload 8
    //   280: astore 7
    //   282: aload 14
    //   284: invokevirtual 576	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   287: astore 14
    //   289: aload 8
    //   291: astore 7
    //   293: aload 13
    //   295: aload 14
    //   297: invokevirtual 580	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   300: pop
    //   301: aload 8
    //   303: astore 7
    //   305: aload 15
    //   307: invokevirtual 584	android/net/wifi/WifiManager:getScanResults	()Ljava/util/List;
    //   310: astore 15
    //   312: aload 15
    //   314: ifnull +296 -> 610
    //   317: aload 8
    //   319: astore 7
    //   321: aload 15
    //   323: new 586	com/tencent/mm/modelstat/o$1
    //   326: dup
    //   327: invokespecial 587	com/tencent/mm/modelstat/o$1:<init>	()V
    //   330: invokestatic 593	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   333: aload 8
    //   335: astore 7
    //   337: aload 15
    //   339: invokeinterface 596 1 0
    //   344: astore 15
    //   346: bipush 20
    //   348: istore_3
    //   349: iload_1
    //   350: istore 4
    //   352: aload 8
    //   354: astore 7
    //   356: aload 15
    //   358: invokeinterface 496 1 0
    //   363: ifeq +247 -> 610
    //   366: aload 8
    //   368: astore 7
    //   370: aload 15
    //   372: invokeinterface 499 1 0
    //   377: checkcast 598	android/net/wifi/ScanResult
    //   380: astore 16
    //   382: aload 16
    //   384: ifnull -35 -> 349
    //   387: aload 8
    //   389: astore 7
    //   391: aload 16
    //   393: getfield 601	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   396: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   399: ifne -50 -> 349
    //   402: aload 8
    //   404: astore 7
    //   406: aload 16
    //   408: getfield 601	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   411: aload 14
    //   413: invokevirtual 604	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +43 -> 459
    //   419: aload 8
    //   421: astore 7
    //   423: aload 16
    //   425: getfield 607	android/net/wifi/ScanResult:level	I
    //   428: istore_1
    //   429: goto -80 -> 349
    //   432: astore 7
    //   434: ldc 147
    //   436: ldc_w 609
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 7
    //   447: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   450: aastore
    //   451: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: iconst_0
    //   455: istore_2
    //   456: goto -319 -> 137
    //   459: iload_1
    //   460: istore 4
    //   462: iload_3
    //   463: ifle +147 -> 610
    //   466: aload 8
    //   468: astore 7
    //   470: aload 11
    //   472: ldc_w 611
    //   475: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   478: pop
    //   479: aload 8
    //   481: astore 7
    //   483: aload 11
    //   485: aload 16
    //   487: getfield 614	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   490: invokestatic 618	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   493: ldc_w 611
    //   496: ldc 96
    //   498: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   501: ldc_w 624
    //   504: ldc 96
    //   506: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   509: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   512: pop
    //   513: aload 8
    //   515: astore 7
    //   517: aload 9
    //   519: ldc_w 611
    //   522: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   525: pop
    //   526: aload 8
    //   528: astore 7
    //   530: aload 9
    //   532: aload 16
    //   534: getfield 601	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   537: invokestatic 618	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   540: ldc_w 611
    //   543: ldc 96
    //   545: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   548: ldc_w 624
    //   551: ldc 96
    //   553: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   556: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   559: pop
    //   560: aload 8
    //   562: astore 7
    //   564: aload 13
    //   566: aload 16
    //   568: getfield 601	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   571: invokevirtual 580	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   574: pop
    //   575: aload 8
    //   577: astore 7
    //   579: aload 10
    //   581: ldc_w 611
    //   584: invokevirtual 573	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   587: pop
    //   588: aload 8
    //   590: astore 7
    //   592: aload 10
    //   594: aload 16
    //   596: getfield 607	android/net/wifi/ScanResult:level	I
    //   599: invokevirtual 627	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   602: pop
    //   603: iload_3
    //   604: iconst_1
    //   605: isub
    //   606: istore_3
    //   607: goto -258 -> 349
    //   610: iload_0
    //   611: sipush 2000
    //   614: if_icmpge +40 -> 654
    //   617: aload 8
    //   619: astore 7
    //   621: aload 13
    //   623: invokestatic 629	com/tencent/mm/modelstat/o:h	(Ljava/util/ArrayList;)Z
    //   626: ifne +28 -> 654
    //   629: aload 8
    //   631: astore 7
    //   633: ldc 147
    //   635: ldc_w 631
    //   638: iconst_1
    //   639: anewarray 4	java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: iload_0
    //   645: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: invokestatic 633	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   652: aconst_null
    //   653: areturn
    //   654: aload 8
    //   656: astore 7
    //   658: aload 11
    //   660: invokevirtual 634	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   663: astore 8
    //   665: aload 8
    //   667: astore 7
    //   669: aload 9
    //   671: invokevirtual 634	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   674: astore 9
    //   676: aload 9
    //   678: astore 7
    //   680: new 326	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   687: iload 4
    //   689: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: aload 10
    //   694: invokevirtual 634	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   697: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: astore 9
    //   705: aload 9
    //   707: astore 17
    //   709: aload 8
    //   711: astore 19
    //   713: aload 7
    //   715: astore 18
    //   717: ldc 147
    //   719: ldc_w 636
    //   722: iconst_2
    //   723: anewarray 4	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload 18
    //   730: aastore
    //   731: dup
    //   732: iconst_1
    //   733: aload 19
    //   735: aastore
    //   736: invokestatic 245	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: ldc 96
    //   741: astore 20
    //   743: aload 12
    //   745: ldc_w 638
    //   748: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   751: checkcast 640	android/telephony/TelephonyManager
    //   754: astore 7
    //   756: aload 7
    //   758: ifnull +1109 -> 1867
    //   761: aload 7
    //   763: invokevirtual 643	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   766: astore 7
    //   768: aload 7
    //   770: astore 20
    //   772: ldc 147
    //   774: ldc_w 645
    //   777: iconst_1
    //   778: anewarray 4	java/lang/Object
    //   781: dup
    //   782: iconst_0
    //   783: aload 20
    //   785: aastore
    //   786: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: ldc 96
    //   791: astore 11
    //   793: ldc 96
    //   795: astore 10
    //   797: ldc 96
    //   799: astore 7
    //   801: ldc 96
    //   803: astore 8
    //   805: ldc 96
    //   807: astore 9
    //   809: aload 12
    //   811: invokestatic 651	com/tencent/mm/sdk/platformtools/aq:fM	(Landroid/content/Context;)Ljava/util/List;
    //   814: astore 21
    //   816: iconst_0
    //   817: istore_1
    //   818: ldc 96
    //   820: astore 9
    //   822: aload 11
    //   824: astore 13
    //   826: aload 10
    //   828: astore 12
    //   830: aload 8
    //   832: astore 11
    //   834: aload 7
    //   836: astore 10
    //   838: aload 12
    //   840: astore 16
    //   842: aload 13
    //   844: astore 15
    //   846: iload_1
    //   847: aload 21
    //   849: invokeinterface 652 1 0
    //   854: if_icmpge +624 -> 1478
    //   857: aload 8
    //   859: astore 11
    //   861: aload 7
    //   863: astore 10
    //   865: aload 12
    //   867: astore 16
    //   869: aload 13
    //   871: astore 15
    //   873: aload 21
    //   875: iload_1
    //   876: invokeinterface 655 2 0
    //   881: checkcast 657	com/tencent/mm/sdk/platformtools/aq$a
    //   884: astore 22
    //   886: aload 8
    //   888: astore 11
    //   890: aload 7
    //   892: astore 10
    //   894: aload 12
    //   896: astore 16
    //   898: aload 13
    //   900: astore 15
    //   902: aload 22
    //   904: getfield 660	com/tencent/mm/sdk/platformtools/aq$a:mdQ	Ljava/lang/String;
    //   907: ldc 96
    //   909: invokestatic 664	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   912: astore 13
    //   914: aload 8
    //   916: astore 11
    //   918: aload 7
    //   920: astore 10
    //   922: aload 12
    //   924: astore 16
    //   926: aload 13
    //   928: astore 15
    //   930: aload 22
    //   932: getfield 667	com/tencent/mm/sdk/platformtools/aq$a:mdR	Ljava/lang/String;
    //   935: ldc 96
    //   937: invokestatic 664	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   940: astore 14
    //   942: aload 7
    //   944: astore 12
    //   946: aload 8
    //   948: astore 11
    //   950: aload 7
    //   952: astore 10
    //   954: aload 14
    //   956: astore 16
    //   958: aload 13
    //   960: astore 15
    //   962: aload 7
    //   964: invokevirtual 670	java/lang/String:length	()I
    //   967: ifle +73 -> 1040
    //   970: aload 7
    //   972: astore 12
    //   974: aload 8
    //   976: astore 11
    //   978: aload 7
    //   980: astore 10
    //   982: aload 14
    //   984: astore 16
    //   986: aload 13
    //   988: astore 15
    //   990: aload 22
    //   992: getfield 673	com/tencent/mm/sdk/platformtools/aq$a:mdS	Ljava/lang/String;
    //   995: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   998: ifne +42 -> 1040
    //   1001: aload 8
    //   1003: astore 11
    //   1005: aload 7
    //   1007: astore 10
    //   1009: aload 14
    //   1011: astore 16
    //   1013: aload 13
    //   1015: astore 15
    //   1017: new 326	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1024: aload 7
    //   1026: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc_w 611
    //   1032: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: astore 12
    //   1040: aload 12
    //   1042: astore 7
    //   1044: aload 8
    //   1046: astore 11
    //   1048: aload 12
    //   1050: astore 10
    //   1052: aload 14
    //   1054: astore 16
    //   1056: aload 13
    //   1058: astore 15
    //   1060: aload 22
    //   1062: getfield 673	com/tencent/mm/sdk/platformtools/aq$a:mdS	Ljava/lang/String;
    //   1065: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1068: ifne +44 -> 1112
    //   1071: aload 8
    //   1073: astore 11
    //   1075: aload 12
    //   1077: astore 10
    //   1079: aload 14
    //   1081: astore 16
    //   1083: aload 13
    //   1085: astore 15
    //   1087: new 326	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1094: aload 12
    //   1096: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload 22
    //   1101: getfield 673	com/tencent/mm/sdk/platformtools/aq$a:mdS	Ljava/lang/String;
    //   1104: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: astore 7
    //   1112: aload 8
    //   1114: astore 12
    //   1116: aload 8
    //   1118: astore 11
    //   1120: aload 7
    //   1122: astore 10
    //   1124: aload 14
    //   1126: astore 16
    //   1128: aload 13
    //   1130: astore 15
    //   1132: aload 8
    //   1134: invokevirtual 670	java/lang/String:length	()I
    //   1137: ifle +73 -> 1210
    //   1140: aload 8
    //   1142: astore 12
    //   1144: aload 8
    //   1146: astore 11
    //   1148: aload 7
    //   1150: astore 10
    //   1152: aload 14
    //   1154: astore 16
    //   1156: aload 13
    //   1158: astore 15
    //   1160: aload 22
    //   1162: getfield 676	com/tencent/mm/sdk/platformtools/aq$a:qvN	Ljava/lang/String;
    //   1165: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1168: ifne +42 -> 1210
    //   1171: aload 8
    //   1173: astore 11
    //   1175: aload 7
    //   1177: astore 10
    //   1179: aload 14
    //   1181: astore 16
    //   1183: aload 13
    //   1185: astore 15
    //   1187: new 326	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1194: aload 8
    //   1196: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: ldc_w 611
    //   1202: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: astore 12
    //   1210: aload 12
    //   1212: astore 8
    //   1214: aload 12
    //   1216: astore 11
    //   1218: aload 7
    //   1220: astore 10
    //   1222: aload 14
    //   1224: astore 16
    //   1226: aload 13
    //   1228: astore 15
    //   1230: aload 22
    //   1232: getfield 676	com/tencent/mm/sdk/platformtools/aq$a:qvN	Ljava/lang/String;
    //   1235: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1238: ifne +44 -> 1282
    //   1241: aload 12
    //   1243: astore 11
    //   1245: aload 7
    //   1247: astore 10
    //   1249: aload 14
    //   1251: astore 16
    //   1253: aload 13
    //   1255: astore 15
    //   1257: new 326	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1264: aload 12
    //   1266: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: aload 22
    //   1271: getfield 676	com/tencent/mm/sdk/platformtools/aq$a:qvN	Ljava/lang/String;
    //   1274: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: astore 8
    //   1282: aload 8
    //   1284: astore 11
    //   1286: aload 7
    //   1288: astore 10
    //   1290: aload 14
    //   1292: astore 16
    //   1294: aload 13
    //   1296: astore 15
    //   1298: aload 9
    //   1300: invokevirtual 670	java/lang/String:length	()I
    //   1303: ifle +561 -> 1864
    //   1306: aload 8
    //   1308: astore 11
    //   1310: aload 7
    //   1312: astore 10
    //   1314: aload 14
    //   1316: astore 16
    //   1318: aload 13
    //   1320: astore 15
    //   1322: new 326	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1329: aload 9
    //   1331: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: ldc_w 611
    //   1337: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: astore 12
    //   1345: aload 12
    //   1347: astore 9
    //   1349: new 326	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1356: aload 9
    //   1358: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: astore 11
    //   1363: aload 22
    //   1365: getfield 679	com/tencent/mm/sdk/platformtools/aq$a:qvR	Ljava/lang/String;
    //   1368: invokestatic 235	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1371: ifeq +97 -> 1468
    //   1374: ldc_w 681
    //   1377: astore 10
    //   1379: aload 11
    //   1381: aload 10
    //   1383: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: astore 10
    //   1391: aload 10
    //   1393: astore 9
    //   1395: iload_1
    //   1396: iconst_1
    //   1397: iadd
    //   1398: istore_1
    //   1399: aload 14
    //   1401: astore 12
    //   1403: goto -573 -> 830
    //   1406: astore 8
    //   1408: ldc 96
    //   1410: astore 9
    //   1412: ldc 147
    //   1414: ldc_w 683
    //   1417: iconst_1
    //   1418: anewarray 4	java/lang/Object
    //   1421: dup
    //   1422: iconst_0
    //   1423: aload 8
    //   1425: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1428: aastore
    //   1429: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1432: aload 9
    //   1434: astore 18
    //   1436: aload 7
    //   1438: astore 19
    //   1440: goto -723 -> 717
    //   1443: astore 7
    //   1445: ldc 147
    //   1447: ldc_w 609
    //   1450: iconst_1
    //   1451: anewarray 4	java/lang/Object
    //   1454: dup
    //   1455: iconst_0
    //   1456: aload 7
    //   1458: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1461: aastore
    //   1462: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1465: goto -693 -> 772
    //   1468: aload 22
    //   1470: getfield 679	com/tencent/mm/sdk/platformtools/aq$a:qvR	Ljava/lang/String;
    //   1473: astore 10
    //   1475: goto -96 -> 1379
    //   1478: aload 13
    //   1480: astore 11
    //   1482: aload 12
    //   1484: astore 10
    //   1486: ldc 147
    //   1488: ldc_w 685
    //   1491: iconst_3
    //   1492: anewarray 4	java/lang/Object
    //   1495: dup
    //   1496: iconst_0
    //   1497: aload 11
    //   1499: aastore
    //   1500: dup
    //   1501: iconst_1
    //   1502: aload 10
    //   1504: aastore
    //   1505: dup
    //   1506: iconst_2
    //   1507: aload 7
    //   1509: aastore
    //   1510: invokestatic 245	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1513: new 326	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1520: astore 12
    //   1522: aload 12
    //   1524: invokestatic 688	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   1527: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1530: ldc_w 338
    //   1533: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload 12
    //   1539: iload_0
    //   1540: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: ldc_w 338
    //   1546: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: aload 12
    //   1552: iload_2
    //   1553: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1556: ldc_w 338
    //   1559: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload 12
    //   1565: aload 19
    //   1567: ldc_w 338
    //   1570: ldc_w 624
    //   1573: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1576: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: ldc_w 338
    //   1582: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 12
    //   1588: aload 18
    //   1590: ldc_w 338
    //   1593: ldc_w 624
    //   1596: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1599: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1602: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: ldc_w 338
    //   1608: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: pop
    //   1612: aload 12
    //   1614: aload 20
    //   1616: ldc_w 338
    //   1619: ldc_w 624
    //   1622: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1625: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: ldc_w 338
    //   1631: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: pop
    //   1635: aload 12
    //   1637: aload 11
    //   1639: ldc_w 338
    //   1642: ldc_w 624
    //   1645: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1648: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1651: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: ldc_w 338
    //   1657: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: pop
    //   1661: aload 12
    //   1663: aload 10
    //   1665: ldc_w 338
    //   1668: ldc_w 624
    //   1671: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1674: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1677: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: ldc_w 338
    //   1683: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: aload 12
    //   1689: aload 7
    //   1691: ldc_w 338
    //   1694: ldc_w 624
    //   1697: invokevirtual 622	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1700: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1703: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: ldc_w 338
    //   1709: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: pop
    //   1713: invokestatic 693	com/tencent/mm/modelstat/o:Ry	()J
    //   1716: lstore 5
    //   1718: lload 5
    //   1720: lconst_0
    //   1721: lcmp
    //   1722: ifge +30 -> 1752
    //   1725: aconst_null
    //   1726: areturn
    //   1727: astore 12
    //   1729: ldc 147
    //   1731: ldc_w 609
    //   1734: iconst_1
    //   1735: anewarray 4	java/lang/Object
    //   1738: dup
    //   1739: iconst_0
    //   1740: aload 12
    //   1742: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1745: aastore
    //   1746: invokestatic 164	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1749: goto -263 -> 1486
    //   1752: iconst_4
    //   1753: anewarray 370	java/lang/String
    //   1756: dup
    //   1757: iconst_0
    //   1758: new 326	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   1765: lload 5
    //   1767: invokevirtual 344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1770: ldc_w 338
    //   1773: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: aload 12
    //   1778: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1781: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1787: aastore
    //   1788: dup
    //   1789: iconst_1
    //   1790: aload 17
    //   1792: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1795: aastore
    //   1796: dup
    //   1797: iconst_2
    //   1798: aload 8
    //   1800: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1803: aastore
    //   1804: dup
    //   1805: iconst_3
    //   1806: aload 9
    //   1808: invokestatic 691	com/tencent/mm/modelstat/o:nt	(Ljava/lang/String;)Ljava/lang/String;
    //   1811: aastore
    //   1812: areturn
    //   1813: astore 12
    //   1815: aload 14
    //   1817: astore 10
    //   1819: aload 13
    //   1821: astore 11
    //   1823: goto -94 -> 1729
    //   1826: astore 12
    //   1828: aload 11
    //   1830: astore 8
    //   1832: aload 10
    //   1834: astore 7
    //   1836: aload 16
    //   1838: astore 10
    //   1840: aload 15
    //   1842: astore 11
    //   1844: goto -115 -> 1729
    //   1847: astore 10
    //   1849: aload 7
    //   1851: astore 9
    //   1853: aload 8
    //   1855: astore 7
    //   1857: aload 10
    //   1859: astore 8
    //   1861: goto -449 -> 1412
    //   1864: goto -515 -> 1349
    //   1867: ldc 96
    //   1869: astore 7
    //   1871: goto -1103 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1874	0	paramInt	int
    //   234	1165	1	i	int
    //   136	1417	2	j	int
    //   348	259	3	k	int
    //   231	457	4	m	int
    //   1716	50	5	l	long
    //   166	256	7	localObject1	Object
    //   432	14	7	localException1	Exception
    //   468	969	7	localObject2	Object
    //   1443	247	7	localException2	Exception
    //   1834	36	7	localObject3	Object
    //   158	1149	8	localObject4	Object
    //   1406	393	8	localException3	Exception
    //   1830	30	8	localObject5	Object
    //   215	1637	9	localObject6	Object
    //   228	1611	10	localObject7	Object
    //   1847	11	10	localException4	Exception
    //   202	1641	11	localObject8	Object
    //   77	1611	12	localObject9	Object
    //   1727	50	12	localException5	Exception
    //   1813	1	12	localException6	Exception
    //   1826	1	12	localException7	Exception
    //   246	1574	13	localObject10	Object
    //   189	1627	14	localObject11	Object
    //   178	1663	15	localObject12	Object
    //   380	1457	16	localObject13	Object
    //   162	1629	17	localObject14	Object
    //   715	874	18	localObject15	Object
    //   711	855	19	localObject16	Object
    //   741	874	20	localObject17	Object
    //   814	60	21	localList	java.util.List
    //   884	585	22	locala	com.tencent.mm.sdk.platformtools.aq.a
    // Exception table:
    //   from	to	target	type
    //   133	137	432	java/lang/Exception
    //   168	180	1406	java/lang/Exception
    //   184	191	1406	java/lang/Exception
    //   195	204	1406	java/lang/Exception
    //   208	217	1406	java/lang/Exception
    //   221	230	1406	java/lang/Exception
    //   239	248	1406	java/lang/Exception
    //   252	263	1406	java/lang/Exception
    //   267	278	1406	java/lang/Exception
    //   282	289	1406	java/lang/Exception
    //   293	301	1406	java/lang/Exception
    //   305	312	1406	java/lang/Exception
    //   321	333	1406	java/lang/Exception
    //   337	346	1406	java/lang/Exception
    //   356	366	1406	java/lang/Exception
    //   370	382	1406	java/lang/Exception
    //   391	402	1406	java/lang/Exception
    //   406	419	1406	java/lang/Exception
    //   423	429	1406	java/lang/Exception
    //   470	479	1406	java/lang/Exception
    //   483	513	1406	java/lang/Exception
    //   517	526	1406	java/lang/Exception
    //   530	560	1406	java/lang/Exception
    //   564	575	1406	java/lang/Exception
    //   579	588	1406	java/lang/Exception
    //   592	603	1406	java/lang/Exception
    //   621	629	1406	java/lang/Exception
    //   633	652	1406	java/lang/Exception
    //   658	665	1406	java/lang/Exception
    //   669	676	1406	java/lang/Exception
    //   743	756	1443	java/lang/Exception
    //   761	768	1443	java/lang/Exception
    //   809	816	1727	java/lang/Exception
    //   1349	1374	1813	java/lang/Exception
    //   1379	1391	1813	java/lang/Exception
    //   1468	1475	1813	java/lang/Exception
    //   846	857	1826	java/lang/Exception
    //   873	886	1826	java/lang/Exception
    //   902	914	1826	java/lang/Exception
    //   930	942	1826	java/lang/Exception
    //   962	970	1826	java/lang/Exception
    //   990	1001	1826	java/lang/Exception
    //   1017	1040	1826	java/lang/Exception
    //   1060	1071	1826	java/lang/Exception
    //   1087	1112	1826	java/lang/Exception
    //   1132	1140	1826	java/lang/Exception
    //   1160	1171	1826	java/lang/Exception
    //   1187	1210	1826	java/lang/Exception
    //   1230	1241	1826	java/lang/Exception
    //   1257	1282	1826	java/lang/Exception
    //   1298	1306	1826	java/lang/Exception
    //   1322	1345	1826	java/lang/Exception
    //   680	705	1847	java/lang/Exception
  }
  
  public static void jl(int paramInt)
  {
    for (;;)
    {
      long l;
      try
      {
        y.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(eEy), eEE });
        if (paramInt == 1005) {}
        try
        {
          if (eEy > 0L)
          {
            y.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(eEC), Float.valueOf(eEA), Float.valueOf(eEz), Integer.valueOf(eEB), Long.valueOf(eEy) });
            l = bk.co(eEy);
            paramInt = eEC;
            float f1 = eEz;
            float f2 = eEA;
            int i = eEB;
            eEy = 0L;
            eEz = 0.0F;
            eEA = 0.0F;
            eEB = 0;
            eEC = 0;
            b(paramInt, f2, f1, i, l);
            return;
          }
          if (!com.tencent.mm.sdk.a.b.foreground)
          {
            y.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", new Object[] { Integer.valueOf(paramInt) });
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          y.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { bk.j(localThrowable) });
          continue;
        }
        if (paramInt != 3) {
          break label333;
        }
      }
      finally {}
      String str = ((WifiManager)ae.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
      y.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", new Object[] { Integer.valueOf(paramInt), str, eEE });
      if ((!bk.bl(str)) && (!str.equals(eEE)))
      {
        eEE = str;
        b(paramInt, 0.0F, 0.0F, 0, 0L);
        continue;
        label333:
        if (paramInt == 4)
        {
          l = bk.co(bk.a((Long)g.DP().Dz().get(ac.a.uoz, null), 0L));
          y.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) });
          if (l >= 21600000L) {
            b(paramInt, 0.0F, 0.0F, 0, 0L);
          }
        }
        else
        {
          b(paramInt, 0.0F, 0.0F, 0, 0L);
        }
      }
    }
  }
  
  private static String nt(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      int k = arrayOfChar[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && ((k < 48) || (k > 57)) && (k != 124) && (k != 45) && (k != 32) && (k != 58)) {
        return "";
      }
      i += 1;
    }
  }
  
  public static void s(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bjh();
    ((b.a)localObject).ecI = new bji();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((b.a)localObject).ecG = 716;
    localObject = ((b.a)localObject).Kt();
    bjh localbjh = (bjh)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localbjh.sEc = d.soV;
    localbjh.sEd = d.soU;
    localbjh.sEe = d.soX;
    localbjh.sEf = d.soY;
    localbjh.sEg = x.cqJ();
    localbjh.tou = paramInt;
    localbjh.nFs = paramString;
    y.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    w.a((com.tencent.mm.ah.b)localObject, new o.3(bk.UY(), localbjh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.o
 * JD-Core Version:    0.7.0.1
 */