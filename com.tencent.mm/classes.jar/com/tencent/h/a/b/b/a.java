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
  private c ahWN;
  private com.tencent.h.a.c.b ahXn;
  
  public a(Context paramContext, m paramm)
  {
    i.kcU();
    this.ahWN = new c(paramContext, paramm);
    this.ahWN.ahWQ = this;
  }
  
  public static boolean a(com.tencent.h.a.c.b.a parama, com.tencent.h.a.b.a.a parama1)
  {
    if ((parama == null) || (parama1 == null) || (parama1.ahXj == null)) {
      return false;
    }
    parama.ahXW = parama1.ahXj;
    return true;
  }
  
  public static boolean a(com.tencent.h.a.c.b.a parama, Map<File, String> paramMap)
  {
    if ((parama == null) || (paramMap == null) || (paramMap.isEmpty())) {}
    while (TextUtils.isEmpty("")) {
      return false;
    }
    i.i("sensor_AbsTuringSMIImpl", "[method: buildStatisticsField ] statistics : " + "" + ", allStatistics size : " + paramMap.size());
    parama.ahXX = "";
    return true;
  }
  
  public final com.tencent.h.a.c.b.a a(com.tencent.h.a.b.a.a parama, Map<File, String> paramMap)
  {
    if (parama == null) {
      return null;
    }
    paramMap = new com.tencent.h.a.c.b.a();
    com.tencent.h.a.a.b.a.a(this.ahWN, paramMap, com.tencent.h.a.b.ahWj);
    Object localObject = new ArrayList();
    com.tencent.h.a.c.b.d locald = new com.tencent.h.a.c.b.d();
    locald.ahYm = "usage";
    locald.ahYn = "crashVal";
    ((ArrayList)localObject).add(locald);
    paramMap.ahXT = ((ArrayList)localObject);
    localObject = com.tencent.h.a.a.b.a.oI(this.ahWN.mAppContext);
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      if (paramMap.ahXY == null) {
        paramMap.ahXY = new HashMap();
      }
      paramMap.ahXY.putAll((Map)localObject);
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
      bool1 = this.ahXn.b(parama, parama1);
      return bool1;
    }
    finally
    {
      do
      {
        do
        {
          bool1 = bool2;
        } while (this.ahWN == null);
        boolean bool1 = bool2;
      } while (this.ahWN.ahWQ == null);
      this.ahWN.ahWQ.b(parama, "start_ct");
    }
    return false;
  }
  
  /* Error */
  public final boolean b(java.lang.Throwable paramThrowable, String paramString)
  {
    // Byte code:
    //   0: invokestatic 174	com/tencent/h/a/b/a/b:kdp	()Lcom/tencent/h/a/b/a/b;
    //   3: pop
    //   4: aload_0
    //   5: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_1
    //   18: invokestatic 180	com/tencent/g/a/a/a:F	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   21: astore 8
    //   23: new 182	com/tencent/g/a/a/a$a
    //   26: dup
    //   27: invokespecial 183	com/tencent/g/a/a/a$a:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: aload 8
    //   36: putfield 186	com/tencent/g/a/a/a$a:ahVL	Ljava/lang/String;
    //   39: aload 4
    //   41: invokestatic 192	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   44: invokevirtual 195	java/lang/Thread:getName	()Ljava/lang/String;
    //   47: putfield 198	com/tencent/g/a/a/a$a:mThreadName	Ljava/lang/String;
    //   50: aload 4
    //   52: aload 7
    //   54: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   57: invokestatic 204	com/tencent/g/c/c:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   60: putfield 207	com/tencent/g/a/a/a$a:mProcessName	Ljava/lang/String;
    //   63: aload 4
    //   65: aload_2
    //   66: putfield 210	com/tencent/g/a/a/a$a:ahVO	Ljava/lang/String;
    //   69: aload 7
    //   71: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   74: astore 5
    //   76: aload 5
    //   78: ifnull +560 -> 638
    //   81: aload_1
    //   82: ifnonnull +102 -> 184
    //   85: goto +553 -> 638
    //   88: aload 8
    //   90: invokestatic 214	com/tencent/g/a/a/a:bGw	(Ljava/lang/String;)I
    //   93: istore_3
    //   94: iconst_m1
    //   95: iload_3
    //   96: if_icmpeq +552 -> 648
    //   99: aload 7
    //   101: getfield 218	com/tencent/h/a/a/c:ahWS	Lcom/tencent/h/a/d/b;
    //   104: astore 4
    //   106: aload_1
    //   107: ifnull +541 -> 648
    //   110: aload 4
    //   112: getfield 224	com/tencent/h/a/d/b:ahZv	Lcom/tencent/h/a/d/a;
    //   115: aload 4
    //   117: getfield 225	com/tencent/h/a/d/b:ahWN	Lcom/tencent/h/a/a/c;
    //   120: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   123: invokevirtual 231	com/tencent/h/a/d/a:oJ	(Landroid/content/Context;)Ljava/io/File;
    //   126: ldc 233
    //   128: invokestatic 237	com/tencent/h/a/d/a:j	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   131: astore 5
    //   133: aload 5
    //   135: ifnull +513 -> 648
    //   138: iload_3
    //   139: invokestatic 243	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   142: astore_2
    //   143: aload 5
    //   145: invokevirtual 248	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: aload_2
    //   149: invokestatic 252	com/tencent/h/a/d/a:qL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   152: ifne +496 -> 648
    //   155: aload_1
    //   156: invokevirtual 258	com/qq/taf/jce/JceStruct:toByteArray	()[B
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +482 -> 643
    //   164: aload_1
    //   165: arraylength
    //   166: ifgt +232 -> 398
    //   169: goto +474 -> 643
    //   172: aload_1
    //   173: ifnull +475 -> 648
    //   176: aload_1
    //   177: arraylength
    //   178: ifgt +234 -> 412
    //   181: goto +467 -> 648
    //   184: new 260	e/d
    //   187: dup
    //   188: invokespecial 261	e/d:<init>	()V
    //   191: astore_2
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual 265	java/lang/Object:getClass	()Ljava/lang/Class;
    //   197: invokevirtual 268	java/lang/Class:getName	()Ljava/lang/String;
    //   200: putfield 271	e/d:aitL	Ljava/lang/String;
    //   203: aload_2
    //   204: aload 4
    //   206: getfield 186	com/tencent/g/a/a/a$a:ahVL	Ljava/lang/String;
    //   209: putfield 274	e/d:aitE	Ljava/lang/String;
    //   212: aload_2
    //   213: aload_1
    //   214: invokevirtual 279	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   217: putfield 282	e/d:aitG	Ljava/lang/String;
    //   220: aload_2
    //   221: aload 4
    //   223: getfield 207	com/tencent/g/a/a/a$a:mProcessName	Ljava/lang/String;
    //   226: putfield 285	e/d:processName	Ljava/lang/String;
    //   229: aload_2
    //   230: aload 4
    //   232: getfield 288	com/tencent/g/a/a/a$a:ahVM	Ljava/lang/String;
    //   235: putfield 291	e/d:aitK	Ljava/lang/String;
    //   238: aload_2
    //   239: aload 4
    //   241: getfield 198	com/tencent/g/a/a/a$a:mThreadName	Ljava/lang/String;
    //   244: putfield 294	e/d:threadName	Ljava/lang/String;
    //   247: aload_2
    //   248: aload 4
    //   250: getfield 298	com/tencent/g/a/a/a$a:ahVN	J
    //   253: putfield 301	e/d:aitI	J
    //   256: aload_2
    //   257: ldc 53
    //   259: putfield 304	e/d:aitJ	Ljava/lang/String;
    //   262: aload_2
    //   263: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   266: putfield 313	e/d:aitF	J
    //   269: aload_2
    //   270: ldc_w 315
    //   273: putfield 318	e/d:type	Ljava/lang/String;
    //   276: aload 5
    //   278: ifnonnull +15 -> 293
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_2
    //   284: aload_1
    //   285: putfield 322	e/d:aitN	Le/f;
    //   288: aload_2
    //   289: astore_1
    //   290: goto -202 -> 88
    //   293: new 324	e/f
    //   296: dup
    //   297: invokespecial 325	e/f:<init>	()V
    //   300: astore 4
    //   302: invokestatic 328	com/tencent/g/c/c:kcQ	()Ljava/lang/String;
    //   305: astore 6
    //   307: invokestatic 331	com/tencent/g/c/c:jXA	()Ljava/lang/String;
    //   310: astore 5
    //   312: aload 6
    //   314: astore_1
    //   315: aload 6
    //   317: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +6 -> 326
    //   323: ldc 53
    //   325: astore_1
    //   326: aload 4
    //   328: aload_1
    //   329: putfield 334	e/f:aitW	Ljava/lang/String;
    //   332: aload 5
    //   334: astore_1
    //   335: aload 5
    //   337: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifeq +6 -> 346
    //   343: ldc 53
    //   345: astore_1
    //   346: aload 4
    //   348: aload_1
    //   349: putfield 337	e/f:hEl	Ljava/lang/String;
    //   352: aload 4
    //   354: getstatic 342	android/os/Build:MODEL	Ljava/lang/String;
    //   357: putfield 345	e/f:model	Ljava/lang/String;
    //   360: aload 4
    //   362: getstatic 348	android/os/Build:BRAND	Ljava/lang/String;
    //   365: putfield 351	e/f:brand	Ljava/lang/String;
    //   368: aload 4
    //   370: new 62	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 353
    //   377: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: getstatic 356	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   383: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: putfield 359	e/f:aitq	Ljava/lang/String;
    //   392: aload 4
    //   394: astore_1
    //   395: goto -112 -> 283
    //   398: aload_1
    //   399: invokestatic 365	com/tencent/g/c/a:compress	([B)[B
    //   402: invokestatic 370	com/tencent/g/c/b:jXz	()[B
    //   405: invokestatic 374	com/tencent/g/c/b:q	([B[B)[B
    //   408: astore_1
    //   409: goto -237 -> 172
    //   412: aload 5
    //   414: invokevirtual 248	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   417: astore 6
    //   419: new 62	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   426: aload_2
    //   427: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 377
    //   433: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   439: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   442: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: astore_2
    //   446: aload 6
    //   448: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   451: ifne +202 -> 653
    //   454: aload_2
    //   455: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   458: ifeq +80 -> 538
    //   461: goto +192 -> 653
    //   464: aload_2
    //   465: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   468: ifne +180 -> 648
    //   471: aload_2
    //   472: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifeq +92 -> 567
    //   478: iconst_0
    //   479: istore_3
    //   480: iload_3
    //   481: ifeq +167 -> 648
    //   484: aload 5
    //   486: invokevirtual 248	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   489: invokestatic 384	com/tencent/h/a/d/a:bGA	(Ljava/lang/String;)Ljava/util/List;
    //   492: astore_1
    //   493: aload 4
    //   495: getfield 224	com/tencent/h/a/d/b:ahZv	Lcom/tencent/h/a/d/a;
    //   498: astore_2
    //   499: aload_1
    //   500: ifnull +158 -> 658
    //   503: aload_1
    //   504: invokeinterface 387 1 0
    //   509: ifne +149 -> 658
    //   512: aload_1
    //   513: invokeinterface 388 1 0
    //   518: bipush 20
    //   520: if_icmpgt +86 -> 606
    //   523: goto +135 -> 658
    //   526: aload_1
    //   527: ifnull +121 -> 648
    //   530: aload_1
    //   531: invokevirtual 391	java/io/File:delete	()Z
    //   534: pop
    //   535: goto +113 -> 648
    //   538: new 62	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   545: aload 6
    //   547: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: getstatic 394	java/io/File:separator	Ljava/lang/String;
    //   553: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_2
    //   557: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: astore_2
    //   564: goto -100 -> 464
    //   567: new 396	java/io/BufferedOutputStream
    //   570: dup
    //   571: new 398	java/io/FileOutputStream
    //   574: dup
    //   575: aload_2
    //   576: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   579: invokespecial 402	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   582: astore_2
    //   583: aload_2
    //   584: aload_1
    //   585: invokevirtual 406	java/io/BufferedOutputStream:write	([B)V
    //   588: aload_2
    //   589: invokevirtual 409	java/io/BufferedOutputStream:flush	()V
    //   592: aload_2
    //   593: invokestatic 415	com/tencent/g/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   596: goto +67 -> 663
    //   599: aload_1
    //   600: invokestatic 415	com/tencent/g/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   603: goto +60 -> 663
    //   606: aload_1
    //   607: new 417	com/tencent/h/a/d/a$1
    //   610: dup
    //   611: aload_2
    //   612: invokespecial 420	com/tencent/h/a/d/a$1:<init>	(Lcom/tencent/h/a/d/a;)V
    //   615: invokestatic 426	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   618: aload_1
    //   619: iconst_0
    //   620: invokeinterface 430 2 0
    //   625: checkcast 245	java/io/File
    //   628: astore_1
    //   629: goto -103 -> 526
    //   632: astore_1
    //   633: aload_2
    //   634: astore_1
    //   635: goto -36 -> 599
    //   638: aconst_null
    //   639: astore_1
    //   640: goto -552 -> 88
    //   643: aconst_null
    //   644: astore_1
    //   645: goto -473 -> 172
    //   648: iconst_1
    //   649: ireturn
    //   650: astore_1
    //   651: iconst_0
    //   652: ireturn
    //   653: aconst_null
    //   654: astore_2
    //   655: goto -191 -> 464
    //   658: aconst_null
    //   659: astore_1
    //   660: goto -134 -> 526
    //   663: iconst_1
    //   664: istore_3
    //   665: goto -185 -> 480
    //   668: astore_1
    //   669: aconst_null
    //   670: astore_1
    //   671: goto -72 -> 599
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	a
    //   0	674	1	paramThrowable	java.lang.Throwable
    //   0	674	2	paramString	String
    //   93	572	3	i	int
    //   30	464	4	localObject1	Object
    //   74	411	5	localObject2	Object
    //   305	241	6	str1	String
    //   8	92	7	localc	c
    //   21	68	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   583	592	632	finally
    //   0	10	650	finally
    //   17	76	650	finally
    //   88	94	650	finally
    //   99	106	650	finally
    //   110	133	650	finally
    //   138	160	650	finally
    //   164	169	650	finally
    //   176	181	650	finally
    //   184	276	650	finally
    //   283	288	650	finally
    //   293	312	650	finally
    //   315	323	650	finally
    //   326	332	650	finally
    //   335	343	650	finally
    //   346	392	650	finally
    //   398	409	650	finally
    //   412	461	650	finally
    //   464	478	650	finally
    //   484	499	650	finally
    //   503	523	650	finally
    //   530	535	650	finally
    //   538	564	650	finally
    //   592	596	650	finally
    //   599	603	650	finally
    //   606	629	650	finally
    //   567	583	668	finally
  }
  
  protected final c kdg()
  {
    return this.ahWN;
  }
  
  protected final com.tencent.h.a.c.b kdr()
  {
    return this.ahXn;
  }
  
  /* Error */
  public final boolean kds()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   4: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   7: ifnonnull +14 -> 21
    //   10: new 437	com/tencent/h/a/k
    //   13: dup
    //   14: ldc_w 439
    //   17: invokespecial 440	com/tencent/h/a/k:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_0
    //   22: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   25: getfield 135	com/tencent/h/a/a/c:mAppContext	Landroid/content/Context;
    //   28: astore 7
    //   30: aload_0
    //   31: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   34: getfield 444	com/tencent/h/a/a/c:ahWP	Lcom/tencent/h/a/a/b/b;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +76 -> 117
    //   44: aload 7
    //   46: ldc_w 446
    //   49: invokevirtual 452	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 454	android/hardware/SensorManager
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
    //   89: invokevirtual 458	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnonnull +167 -> 263
    //   99: iconst_0
    //   100: istore_3
    //   101: goto +141 -> 242
    //   104: aload 6
    //   106: iload 4
    //   108: putfield 464	com/tencent/h/a/a/b/b:ahXa	Z
    //   111: aload 6
    //   113: iload_2
    //   114: putfield 468	com/tencent/h/a/a/b/b:ahXb	I
    //   117: aload_0
    //   118: new 470	com/tencent/h/a/c/d
    //   121: dup
    //   122: aload_0
    //   123: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   126: invokespecial 473	com/tencent/h/a/c/d:<init>	(Lcom/tencent/h/a/a/c;)V
    //   129: putfield 158	com/tencent/h/a/b/b/a:ahXn	Lcom/tencent/h/a/c/b;
    //   132: new 475	com/tencent/h/a/a/f
    //   135: dup
    //   136: aload_0
    //   137: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   140: ldc_w 477
    //   143: invokespecial 480	com/tencent/h/a/a/f:<init>	(Lcom/tencent/h/a/a/c;Ljava/lang/String;)V
    //   146: pop
    //   147: new 62	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 482
    //   154: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   161: getfield 444	com/tencent/h/a/a/c:ahWP	Lcom/tencent/h/a/a/b/b;
    //   164: getfield 464	com/tencent/h/a/a/b/b:ahXa	Z
    //   167: invokevirtual 485	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 487
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
    //   193: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   196: ifnull -16 -> 180
    //   199: iload 4
    //   201: istore 5
    //   203: aload_0
    //   204: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   207: getfield 30	com/tencent/h/a/a/c:ahWQ	Lcom/tencent/g/a/b;
    //   210: ifnull -30 -> 180
    //   213: aload_0
    //   214: getfield 26	com/tencent/h/a/b/b/a:ahWN	Lcom/tencent/h/a/a/c;
    //   217: getfield 30	com/tencent/h/a/a/c:ahWQ	Lcom/tencent/g/a/b;
    //   220: aload 6
    //   222: ldc_w 489
    //   225: invokeinterface 168 3 0
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
    //   183	38	6	localThrowable	java.lang.Throwable
    //   234	1	6	localObject1	Object
    //   28	42	7	localObject2	Object
    //   92	157	8	localSensor	android.hardware.Sensor
    // Exception table:
    //   from	to	target	type
    //   21	39	183	finally
    //   44	57	183	finally
    //   69	94	183	finally
    //   104	117	183	finally
    //   117	147	183	finally
    //   147	177	234	finally
  }
  
  public final List<com.tencent.h.a.b.a.a> kdt()
  {
    com.tencent.h.a.b.a.b localb = com.tencent.h.a.b.a.b.kdp();
    c localc = this.ahWN;
    com.tencent.h.a.b.a.b.kdp();
    int m = com.tencent.h.a.b.a.b.kdq();
    if (localc == null) {
      return null;
    }
    Object localObject1 = localc.ahWS;
    if ((((com.tencent.h.a.d.b)localObject1).ahWN == null) || (m <= 0)) {
      localObject1 = null;
    }
    while ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      return null;
      localObject1 = com.tencent.h.a.d.a.j(((com.tencent.h.a.d.b)localObject1).ahZv.oJ(((com.tencent.h.a.d.b)localObject1).ahWN.mAppContext), "2");
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = com.tencent.h.a.d.a.bGB(((File)localObject1).getAbsolutePath());
        if (localObject2 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = new ArrayList();
          int n = localObject2.length;
          int i = 0;
          int k;
          for (int j = 0; i < n; j = k)
          {
            localObject3 = localObject2[i];
            if (j >= m) {
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
    label399:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str)) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label399;
        }
        e.d locald = new e.d();
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
        localObject1 = com.tencent.g.c.b.r(e.Y(new File(str)), com.tencent.g.c.b.jXz());
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = com.tencent.g.c.a.dv((byte[])localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */