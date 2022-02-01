package com.tencent.h.a.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.g.c.e;
import com.tencent.g.c.i;
import com.tencent.h.a.a.c;
import com.tencent.h.a.h.a;
import com.tencent.h.a.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  implements com.tencent.g.a.b
{
  private com.tencent.h.a.c.b ZSN;
  private c ZSp;
  
  public a(Context paramContext, m paramm)
  {
    i.itz();
    this.ZSp = new c(paramContext, paramm);
    this.ZSp.ZSs = this;
  }
  
  public static boolean a(com.tencent.h.a.c.b.a parama, com.tencent.h.a.b.a.a parama1)
  {
    if ((parama == null) || (parama1 == null) || (parama1.ZSJ == null)) {
      return false;
    }
    parama.ZTw = parama1.ZSJ;
    return true;
  }
  
  public static boolean a(com.tencent.h.a.c.b.a parama, Map<File, String> paramMap)
  {
    if ((parama == null) || (paramMap == null) || (paramMap.isEmpty())) {}
    while (TextUtils.isEmpty("")) {
      return false;
    }
    i.i("sensor_AbsTuringSMIImpl", "[method: buildStatisticsField ] statistics : " + "" + ", allStatistics size : " + paramMap.size());
    parama.ZTx = "";
    return true;
  }
  
  public final com.tencent.h.a.c.b.a a(com.tencent.h.a.b.a.a parama, Map<File, String> paramMap)
  {
    if (parama == null) {
      return null;
    }
    paramMap = new com.tencent.h.a.c.b.a();
    com.tencent.h.a.a.b.a.a(this.ZSp, paramMap, com.tencent.h.a.b.ZRM);
    Object localObject = new ArrayList();
    com.tencent.h.a.c.b.d locald = new com.tencent.h.a.c.b.d();
    locald.ZTM = "usage";
    locald.ZTN = "crashVal";
    ((ArrayList)localObject).add(locald);
    paramMap.ZTt = ((ArrayList)localObject);
    localObject = com.tencent.h.a.a.b.a.ms(this.ZSp.mAppContext);
    if (!((Map)localObject).isEmpty())
    {
      if (paramMap.ZTy == null) {
        paramMap.ZTy = new HashMap();
      }
      paramMap.ZTy.putAll((Map)localObject);
    }
    a(paramMap, parama);
    a(paramMap, null);
    return paramMap;
  }
  
  protected final boolean a(h.a parama, com.tencent.h.a.c.a parama1)
  {
    boolean bool2 = false;
    try
    {
      bool1 = this.ZSN.b(parama, parama1);
      return bool1;
    }
    catch (Throwable parama)
    {
      do
      {
        do
        {
          bool1 = bool2;
        } while (this.ZSp == null);
        boolean bool1 = bool2;
      } while (this.ZSp.ZSs == null);
      this.ZSp.ZSs.b(parama, "start_ct");
    }
    return false;
  }
  
  /* Error */
  public final boolean b(Throwable paramThrowable, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 176	com/tencent/h/a/b/a/b:itT	()Lcom/tencent/h/a/b/a/b;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   11: astore 7
    //   13: aload 7
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_1
    //   21: invokestatic 182	com/tencent/g/a/a/a:p	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   24: astore 8
    //   26: new 184	com/tencent/g/a/a/a$a
    //   29: dup
    //   30: invokespecial 185	com/tencent/g/a/a/a$a:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: aload 8
    //   39: putfield 188	com/tencent/g/a/a/a$a:ZRq	Ljava/lang/String;
    //   42: aload 5
    //   44: invokestatic 194	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   47: invokevirtual 197	java/lang/Thread:getName	()Ljava/lang/String;
    //   50: putfield 200	com/tencent/g/a/a/a$a:mThreadName	Ljava/lang/String;
    //   53: aload 5
    //   55: aload 7
    //   57: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   60: invokestatic 206	com/tencent/g/c/c:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   63: putfield 209	com/tencent/g/a/a/a$a:mProcessName	Ljava/lang/String;
    //   66: aload 5
    //   68: aload_2
    //   69: putfield 212	com/tencent/g/a/a/a$a:ZRt	Ljava/lang/String;
    //   72: aload 7
    //   74: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +567 -> 648
    //   84: aload_1
    //   85: ifnonnull +102 -> 187
    //   88: goto +560 -> 648
    //   91: aload 8
    //   93: invokestatic 216	com/tencent/g/a/a/a:bDX	(Ljava/lang/String;)I
    //   96: istore_3
    //   97: iconst_m1
    //   98: iload_3
    //   99: if_icmpeq +559 -> 658
    //   102: aload 7
    //   104: getfield 220	com/tencent/h/a/a/c:ZSu	Lcom/tencent/h/a/d/b;
    //   107: astore 5
    //   109: aload_1
    //   110: ifnull +548 -> 658
    //   113: aload 5
    //   115: getfield 226	com/tencent/h/a/d/b:ZUW	Lcom/tencent/h/a/d/a;
    //   118: aload 5
    //   120: getfield 227	com/tencent/h/a/d/b:ZSp	Lcom/tencent/h/a/a/c;
    //   123: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   126: invokevirtual 233	com/tencent/h/a/d/a:mt	(Landroid/content/Context;)Ljava/io/File;
    //   129: ldc 235
    //   131: invokestatic 239	com/tencent/h/a/d/a:j	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   134: astore 6
    //   136: aload 6
    //   138: ifnull +520 -> 658
    //   141: iload_3
    //   142: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: aload 6
    //   148: invokevirtual 250	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: aload_2
    //   152: invokestatic 254	com/tencent/h/a/d/a:oN	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: ifne +503 -> 658
    //   158: aload_1
    //   159: invokevirtual 260	com/qq/taf/jce/JceStruct:toByteArray	()[B
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +489 -> 653
    //   167: aload_1
    //   168: arraylength
    //   169: ifgt +231 -> 400
    //   172: goto +481 -> 653
    //   175: aload_1
    //   176: ifnull +482 -> 658
    //   179: aload_1
    //   180: arraylength
    //   181: ifgt +233 -> 414
    //   184: goto +474 -> 658
    //   187: new 262	d/d
    //   190: dup
    //   191: invokespecial 263	d/d:<init>	()V
    //   194: astore_2
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 267	java/lang/Object:getClass	()Ljava/lang/Class;
    //   200: invokevirtual 270	java/lang/Class:getName	()Ljava/lang/String;
    //   203: putfield 273	d/d:aanu	Ljava/lang/String;
    //   206: aload_2
    //   207: aload 5
    //   209: getfield 188	com/tencent/g/a/a/a$a:ZRq	Ljava/lang/String;
    //   212: putfield 276	d/d:aann	Ljava/lang/String;
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 279	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   220: putfield 282	d/d:aanp	Ljava/lang/String;
    //   223: aload_2
    //   224: aload 5
    //   226: getfield 209	com/tencent/g/a/a/a$a:mProcessName	Ljava/lang/String;
    //   229: putfield 285	d/d:processName	Ljava/lang/String;
    //   232: aload_2
    //   233: aload 5
    //   235: getfield 288	com/tencent/g/a/a/a$a:ZRr	Ljava/lang/String;
    //   238: putfield 291	d/d:aant	Ljava/lang/String;
    //   241: aload_2
    //   242: aload 5
    //   244: getfield 200	com/tencent/g/a/a/a$a:mThreadName	Ljava/lang/String;
    //   247: putfield 294	d/d:threadName	Ljava/lang/String;
    //   250: aload_2
    //   251: aload 5
    //   253: getfield 298	com/tencent/g/a/a/a$a:ZRs	J
    //   256: putfield 301	d/d:aanr	J
    //   259: aload_2
    //   260: ldc 53
    //   262: putfield 304	d/d:aans	Ljava/lang/String;
    //   265: aload_2
    //   266: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   269: putfield 313	d/d:aano	J
    //   272: aload_2
    //   273: ldc_w 315
    //   276: putfield 318	d/d:type	Ljava/lang/String;
    //   279: aload 6
    //   281: ifnonnull +15 -> 296
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_2
    //   287: aload_1
    //   288: putfield 322	d/d:aanw	Ld/f;
    //   291: aload_2
    //   292: astore_1
    //   293: goto -202 -> 91
    //   296: new 324	d/f
    //   299: dup
    //   300: invokespecial 325	d/f:<init>	()V
    //   303: astore 5
    //   305: ldc_w 327
    //   308: astore_1
    //   309: aload 6
    //   311: invokestatic 330	com/tencent/g/c/c:lX	(Landroid/content/Context;)Ljava/lang/String;
    //   314: astore 6
    //   316: ldc_w 327
    //   319: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   322: ifeq +6 -> 328
    //   325: ldc 53
    //   327: astore_1
    //   328: aload 5
    //   330: aload_1
    //   331: putfield 333	d/f:aanF	Ljava/lang/String;
    //   334: aload 6
    //   336: astore_1
    //   337: aload 6
    //   339: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifeq +6 -> 348
    //   345: ldc 53
    //   347: astore_1
    //   348: aload 5
    //   350: aload_1
    //   351: putfield 336	d/f:fzB	Ljava/lang/String;
    //   354: aload 5
    //   356: getstatic 341	android/os/Build:MODEL	Ljava/lang/String;
    //   359: putfield 344	d/f:model	Ljava/lang/String;
    //   362: aload 5
    //   364: getstatic 347	android/os/Build:BRAND	Ljava/lang/String;
    //   367: putfield 350	d/f:brand	Ljava/lang/String;
    //   370: aload 5
    //   372: new 62	java/lang/StringBuilder
    //   375: dup
    //   376: ldc_w 352
    //   379: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: getstatic 355	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   385: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: putfield 358	d/f:aamZ	Ljava/lang/String;
    //   394: aload 5
    //   396: astore_1
    //   397: goto -111 -> 286
    //   400: aload_1
    //   401: invokestatic 364	com/tencent/g/c/a:compress	([B)[B
    //   404: invokestatic 369	com/tencent/g/c/b:ion	()[B
    //   407: invokestatic 372	com/tencent/g/c/b:p	([B[B)[B
    //   410: astore_1
    //   411: goto -236 -> 175
    //   414: aload 6
    //   416: invokevirtual 250	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   419: astore 7
    //   421: new 62	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   428: aload_2
    //   429: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 375
    //   435: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   441: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: astore_2
    //   448: aload 7
    //   450: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +210 -> 663
    //   456: aload_2
    //   457: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifeq +80 -> 540
    //   463: goto +200 -> 663
    //   466: aload_2
    //   467: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifne +188 -> 658
    //   473: aload_2
    //   474: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   477: ifeq +92 -> 569
    //   480: iconst_0
    //   481: istore_3
    //   482: iload_3
    //   483: ifeq +175 -> 658
    //   486: aload 6
    //   488: invokevirtual 250	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   491: invokestatic 382	com/tencent/h/a/d/a:bEb	(Ljava/lang/String;)Ljava/util/List;
    //   494: astore_1
    //   495: aload 5
    //   497: getfield 226	com/tencent/h/a/d/b:ZUW	Lcom/tencent/h/a/d/a;
    //   500: astore_2
    //   501: aload_1
    //   502: ifnull +166 -> 668
    //   505: aload_1
    //   506: invokeinterface 385 1 0
    //   511: ifne +157 -> 668
    //   514: aload_1
    //   515: invokeinterface 386 1 0
    //   520: bipush 20
    //   522: if_icmpgt +92 -> 614
    //   525: goto +143 -> 668
    //   528: aload_1
    //   529: ifnull +129 -> 658
    //   532: aload_1
    //   533: invokevirtual 389	java/io/File:delete	()Z
    //   536: pop
    //   537: goto +121 -> 658
    //   540: new 62	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   547: aload 7
    //   549: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: getstatic 392	java/io/File:separator	Ljava/lang/String;
    //   555: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_2
    //   559: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: astore_2
    //   566: goto -100 -> 466
    //   569: new 394	java/io/BufferedOutputStream
    //   572: dup
    //   573: new 396	java/io/FileOutputStream
    //   576: dup
    //   577: aload_2
    //   578: invokespecial 397	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   581: invokespecial 400	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   584: astore_2
    //   585: aload_2
    //   586: aload_1
    //   587: invokevirtual 404	java/io/BufferedOutputStream:write	([B)V
    //   590: aload_2
    //   591: invokevirtual 407	java/io/BufferedOutputStream:flush	()V
    //   594: aload_2
    //   595: invokestatic 413	com/tencent/g/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   598: goto +75 -> 673
    //   601: aload_2
    //   602: invokestatic 413	com/tencent/g/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   605: goto +68 -> 673
    //   608: aload_2
    //   609: invokestatic 413	com/tencent/g/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   612: aload_1
    //   613: athrow
    //   614: aload_1
    //   615: new 415	com/tencent/h/a/d/a$1
    //   618: dup
    //   619: aload_2
    //   620: invokespecial 418	com/tencent/h/a/d/a$1:<init>	(Lcom/tencent/h/a/d/a;)V
    //   623: invokestatic 424	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   626: aload_1
    //   627: iconst_0
    //   628: invokeinterface 428 2 0
    //   633: checkcast 247	java/io/File
    //   636: astore_1
    //   637: goto -109 -> 528
    //   640: astore_1
    //   641: goto -33 -> 608
    //   644: astore_1
    //   645: goto -44 -> 601
    //   648: aconst_null
    //   649: astore_1
    //   650: goto -559 -> 91
    //   653: aconst_null
    //   654: astore_1
    //   655: goto -480 -> 175
    //   658: iconst_1
    //   659: ireturn
    //   660: astore_1
    //   661: iconst_0
    //   662: ireturn
    //   663: aconst_null
    //   664: astore_2
    //   665: goto -199 -> 466
    //   668: aconst_null
    //   669: astore_1
    //   670: goto -142 -> 528
    //   673: iconst_1
    //   674: istore_3
    //   675: goto -193 -> 482
    //   678: astore_1
    //   679: aconst_null
    //   680: astore_2
    //   681: goto -80 -> 601
    //   684: astore_1
    //   685: aload 4
    //   687: astore_2
    //   688: goto -80 -> 608
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	this	a
    //   0	691	1	paramThrowable	Throwable
    //   0	691	2	paramString	String
    //   96	579	3	i	int
    //   1	685	4	localObject1	Object
    //   33	463	5	localObject2	Object
    //   77	410	6	localObject3	Object
    //   11	537	7	localObject4	Object
    //   24	68	8	str	String
    // Exception table:
    //   from	to	target	type
    //   585	594	640	finally
    //   585	594	644	java/lang/Throwable
    //   3	13	660	java/lang/Throwable
    //   20	79	660	java/lang/Throwable
    //   91	97	660	java/lang/Throwable
    //   102	109	660	java/lang/Throwable
    //   113	136	660	java/lang/Throwable
    //   141	163	660	java/lang/Throwable
    //   167	172	660	java/lang/Throwable
    //   179	184	660	java/lang/Throwable
    //   187	279	660	java/lang/Throwable
    //   286	291	660	java/lang/Throwable
    //   296	305	660	java/lang/Throwable
    //   309	316	660	java/lang/Throwable
    //   316	325	660	java/lang/Throwable
    //   328	334	660	java/lang/Throwable
    //   337	345	660	java/lang/Throwable
    //   348	394	660	java/lang/Throwable
    //   400	411	660	java/lang/Throwable
    //   414	463	660	java/lang/Throwable
    //   466	480	660	java/lang/Throwable
    //   486	501	660	java/lang/Throwable
    //   505	525	660	java/lang/Throwable
    //   532	537	660	java/lang/Throwable
    //   540	566	660	java/lang/Throwable
    //   594	598	660	java/lang/Throwable
    //   601	605	660	java/lang/Throwable
    //   608	614	660	java/lang/Throwable
    //   614	637	660	java/lang/Throwable
    //   569	585	678	java/lang/Throwable
    //   569	585	684	finally
  }
  
  protected final c itK()
  {
    return this.ZSp;
  }
  
  protected final com.tencent.h.a.c.b itV()
  {
    return this.ZSN;
  }
  
  /* Error */
  public final boolean itW()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   4: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   7: ifnonnull +14 -> 21
    //   10: new 435	com/tencent/h/a/k
    //   13: dup
    //   14: ldc_w 437
    //   17: invokespecial 438	com/tencent/h/a/k:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_0
    //   22: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   25: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   28: astore 7
    //   30: aload_0
    //   31: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   34: getfield 442	com/tencent/h/a/a/c:ZSr	Lcom/tencent/h/a/a/b/b;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +76 -> 117
    //   44: aload 7
    //   46: ldc_w 444
    //   49: invokevirtual 450	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 452	android/hardware/SensorManager
    //   55: astore 7
    //   57: iconst_0
    //   58: istore_1
    //   59: iconst_1
    //   60: istore_2
    //   61: iconst_1
    //   62: istore 4
    //   64: iload_1
    //   65: iconst_3
    //   66: if_icmpge +38 -> 104
    //   69: aload 7
    //   71: iconst_3
    //   72: newarray int
    //   74: dup
    //   75: iconst_0
    //   76: iconst_1
    //   77: iastore
    //   78: dup
    //   79: iconst_1
    //   80: iconst_4
    //   81: iastore
    //   82: dup
    //   83: iconst_2
    //   84: bipush 9
    //   86: iastore
    //   87: iload_1
    //   88: iaload
    //   89: invokevirtual 456	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnonnull +167 -> 263
    //   99: iconst_0
    //   100: istore_3
    //   101: goto +141 -> 242
    //   104: aload 6
    //   106: iload 4
    //   108: putfield 462	com/tencent/h/a/a/b/b:ZSA	Z
    //   111: aload 6
    //   113: iload_2
    //   114: putfield 466	com/tencent/h/a/a/b/b:ZSB	I
    //   117: aload_0
    //   118: new 468	com/tencent/h/a/c/d
    //   121: dup
    //   122: aload_0
    //   123: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   126: invokespecial 471	com/tencent/h/a/c/d:<init>	(Lcom/tencent/h/a/a/c;)V
    //   129: putfield 160	com/tencent/h/a/b/b/a:ZSN	Lcom/tencent/h/a/c/b;
    //   132: new 473	com/tencent/h/a/a/e
    //   135: dup
    //   136: aload_0
    //   137: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   140: ldc_w 475
    //   143: invokespecial 478	com/tencent/h/a/a/e:<init>	(Lcom/tencent/h/a/a/c;Ljava/lang/String;)V
    //   146: pop
    //   147: new 62	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 480
    //   154: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   161: getfield 442	com/tencent/h/a/a/c:ZSr	Lcom/tencent/h/a/a/b/b;
    //   164: getfield 462	com/tencent/h/a/a/b/b:ZSA	Z
    //   167: invokevirtual 483	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 485
    //   173: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: iconst_1
    //   178: istore 5
    //   180: iload 5
    //   182: ireturn
    //   183: astore 6
    //   185: iconst_0
    //   186: istore 4
    //   188: iload 4
    //   190: istore 5
    //   192: aload_0
    //   193: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   196: ifnull -16 -> 180
    //   199: iload 4
    //   201: istore 5
    //   203: aload_0
    //   204: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   207: getfield 30	com/tencent/h/a/a/c:ZSs	Lcom/tencent/g/a/b;
    //   210: ifnull -30 -> 180
    //   213: aload_0
    //   214: getfield 26	com/tencent/h/a/b/b/a:ZSp	Lcom/tencent/h/a/a/c;
    //   217: getfield 30	com/tencent/h/a/a/c:ZSs	Lcom/tencent/g/a/b;
    //   220: aload 6
    //   222: ldc_w 487
    //   225: invokeinterface 170 3 0
    //   230: pop
    //   231: iload 4
    //   233: ireturn
    //   234: astore 6
    //   236: iconst_1
    //   237: istore 4
    //   239: goto -51 -> 188
    //   242: iload_2
    //   243: iload_3
    //   244: iload_1
    //   245: ishl
    //   246: ior
    //   247: istore_2
    //   248: aload 8
    //   250: ifnonnull +6 -> 256
    //   253: iconst_0
    //   254: istore 4
    //   256: iload_1
    //   257: iconst_1
    //   258: iadd
    //   259: istore_1
    //   260: goto -196 -> 64
    //   263: iconst_1
    //   264: istore_3
    //   265: goto -23 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	a
    //   58	202	1	i	int
    //   60	188	2	j	int
    //   100	165	3	k	int
    //   62	193	4	bool1	boolean
    //   178	24	5	bool2	boolean
    //   37	75	6	localb	com.tencent.h.a.a.b.b
    //   183	38	6	localThrowable1	Throwable
    //   234	1	6	localThrowable2	Throwable
    //   28	42	7	localObject	Object
    //   92	157	8	localSensor	android.hardware.Sensor
    // Exception table:
    //   from	to	target	type
    //   21	39	183	java/lang/Throwable
    //   44	57	183	java/lang/Throwable
    //   69	94	183	java/lang/Throwable
    //   104	117	183	java/lang/Throwable
    //   117	147	183	java/lang/Throwable
    //   147	177	234	java/lang/Throwable
  }
  
  public final List<com.tencent.h.a.b.a.a> itX()
  {
    com.tencent.h.a.b.a.b localb = com.tencent.h.a.b.a.b.itT();
    c localc = this.ZSp;
    com.tencent.h.a.b.a.b.itT();
    com.tencent.h.a.b.a.b.itU();
    if (localc == null) {
      return null;
    }
    Object localObject1 = localc.ZSu;
    if (((com.tencent.h.a.d.b)localObject1).ZSp == null) {
      localObject1 = null;
    }
    while ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      return null;
      localObject1 = com.tencent.h.a.d.a.j(((com.tencent.h.a.d.b)localObject1).ZUW.mt(((com.tencent.h.a.d.b)localObject1).ZSp.mAppContext), "2");
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = com.tencent.h.a.d.a.bEc(((File)localObject1).getAbsolutePath());
        if (localObject2 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = new ArrayList();
          int m = localObject2.length;
          int i = 0;
          int k;
          for (int j = 0; i < m; j = k)
          {
            localObject3 = localObject2[i];
            if (j >= 5) {
              break;
            }
            localObject3 = ((File)localObject3).getAbsolutePath();
            k = j;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              k = j + 1;
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
        }
      }
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    label392:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str)) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label392;
        }
        d.d locald = new d.d();
        locald.readFrom(new JceInputStream((byte[])localObject1));
        ((ArrayList)localObject3).add(str);
        localArrayList.add(locald);
        if (localArrayList.size() < 5) {
          break;
        }
        localObject1 = localb.a(localc, localArrayList, (ArrayList)localObject3);
        if (localObject1 == null) {
          break;
        }
        ((List)localObject2).add(localObject1);
        break;
        localObject1 = com.tencent.g.c.b.q(e.T(new File(str)), com.tencent.g.c.b.ion());
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = com.tencent.g.c.a.dt((byte[])localObject1);
        }
      }
    }
    localObject1 = localb.a(localc, localArrayList, (ArrayList)localObject3);
    if (localObject1 != null) {
      ((List)localObject2).add(localObject1);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */