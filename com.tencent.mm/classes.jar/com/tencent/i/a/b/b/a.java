package com.tencent.i.a.b.b;

import android.content.Context;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.h.a;
import com.tencent.i.a.m;

public abstract class a
  implements com.tencent.h.a.b
{
  public c SqM;
  protected com.tencent.i.a.c.b Srk;
  
  public a(Context paramContext, m paramm)
  {
    h.hpU();
    this.SqM = new c(paramContext, paramm);
    this.SqM.SqP = this;
  }
  
  public static boolean a(com.tencent.i.a.c.b.a parama, com.tencent.i.a.b.a.a parama1)
  {
    if ((parama == null) || (parama1 == null) || (parama1.Srg == null)) {
      return false;
    }
    parama.SrT = parama1.Srg;
    return true;
  }
  
  protected final boolean a(h.a parama, com.tencent.i.a.c.a parama1)
  {
    boolean bool2 = false;
    try
    {
      bool1 = this.Srk.b(parama, parama1);
      return bool1;
    }
    catch (Throwable parama)
    {
      do
      {
        do
        {
          bool1 = bool2;
        } while (this.SqM == null);
        boolean bool1 = bool2;
      } while (this.SqM.SqP == null);
      this.SqM.SqP.b(parama, "start_ct");
    }
    return false;
  }
  
  /* Error */
  public final boolean b(Throwable paramThrowable, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 65	com/tencent/i/a/b/a/b:hqm	()Lcom/tencent/i/a/b/a/b;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   11: astore 8
    //   13: aload 8
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_1
    //   21: invokestatic 71	com/tencent/h/a/a/a:p	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   24: astore 9
    //   26: new 73	com/tencent/h/a/a/a$a
    //   29: dup
    //   30: invokespecial 74	com/tencent/h/a/a/a$a:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: aload 9
    //   39: putfield 78	com/tencent/h/a/a/a$a:SpL	Ljava/lang/String;
    //   42: aload 5
    //   44: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   47: invokevirtual 88	java/lang/Thread:getName	()Ljava/lang/String;
    //   50: putfield 91	com/tencent/h/a/a/a$a:mThreadName	Ljava/lang/String;
    //   53: aload 5
    //   55: aload 8
    //   57: getfield 95	com/tencent/i/a/a/c:mAppContext	Landroid/content/Context;
    //   60: invokestatic 101	com/tencent/h/c/c:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   63: putfield 104	com/tencent/h/a/a/a$a:mProcessName	Ljava/lang/String;
    //   66: aload 5
    //   68: aload_2
    //   69: putfield 107	com/tencent/h/a/a/a$a:SpO	Ljava/lang/String;
    //   72: aload 8
    //   74: getfield 95	com/tencent/i/a/a/c:mAppContext	Landroid/content/Context;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +571 -> 652
    //   84: aload_1
    //   85: ifnonnull +102 -> 187
    //   88: goto +564 -> 652
    //   91: aload 9
    //   93: invokestatic 111	com/tencent/h/a/a/a:bqY	(Ljava/lang/String;)I
    //   96: istore_3
    //   97: iconst_m1
    //   98: iload_3
    //   99: if_icmpeq +563 -> 662
    //   102: aload 8
    //   104: getfield 115	com/tencent/i/a/a/c:SqR	Lcom/tencent/i/a/d/b;
    //   107: astore 5
    //   109: aload_1
    //   110: ifnull +552 -> 662
    //   113: aload 5
    //   115: getfield 121	com/tencent/i/a/d/b:Stt	Lcom/tencent/i/a/d/a;
    //   118: aload 5
    //   120: getfield 122	com/tencent/i/a/d/b:SqM	Lcom/tencent/i/a/a/c;
    //   123: getfield 95	com/tencent/i/a/a/c:mAppContext	Landroid/content/Context;
    //   126: invokevirtual 128	com/tencent/i/a/d/a:lv	(Landroid/content/Context;)Ljava/io/File;
    //   129: ldc 130
    //   131: invokestatic 134	com/tencent/i/a/d/a:i	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   134: astore 6
    //   136: aload 6
    //   138: ifnull +524 -> 662
    //   141: iload_3
    //   142: invokestatic 140	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: aload 6
    //   148: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: aload_2
    //   152: invokestatic 149	com/tencent/i/a/d/a:nR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: ifne +507 -> 662
    //   158: aload_1
    //   159: invokevirtual 155	com/qq/taf/jce/JceStruct:toByteArray	()[B
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +493 -> 657
    //   167: aload_1
    //   168: arraylength
    //   169: ifgt +235 -> 404
    //   172: goto +485 -> 657
    //   175: aload_1
    //   176: ifnull +486 -> 662
    //   179: aload_1
    //   180: arraylength
    //   181: ifgt +237 -> 418
    //   184: goto +478 -> 662
    //   187: new 157	d/d
    //   190: dup
    //   191: invokespecial 158	d/d:<init>	()V
    //   194: astore_2
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 162	java/lang/Object:getClass	()Ljava/lang/Class;
    //   200: invokevirtual 165	java/lang/Class:getName	()Ljava/lang/String;
    //   203: putfield 168	d/d:SLz	Ljava/lang/String;
    //   206: aload_2
    //   207: aload 5
    //   209: getfield 78	com/tencent/h/a/a/a$a:SpL	Ljava/lang/String;
    //   212: putfield 171	d/d:SLs	Ljava/lang/String;
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 174	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   220: putfield 177	d/d:SLu	Ljava/lang/String;
    //   223: aload_2
    //   224: aload 5
    //   226: getfield 104	com/tencent/h/a/a/a$a:mProcessName	Ljava/lang/String;
    //   229: putfield 180	d/d:processName	Ljava/lang/String;
    //   232: aload_2
    //   233: aload 5
    //   235: getfield 183	com/tencent/h/a/a/a$a:SpM	Ljava/lang/String;
    //   238: putfield 186	d/d:SLy	Ljava/lang/String;
    //   241: aload_2
    //   242: aload 5
    //   244: getfield 91	com/tencent/h/a/a/a$a:mThreadName	Ljava/lang/String;
    //   247: putfield 189	d/d:threadName	Ljava/lang/String;
    //   250: aload_2
    //   251: aload 5
    //   253: getfield 193	com/tencent/h/a/a/a$a:SpN	J
    //   256: putfield 196	d/d:SLw	J
    //   259: aload_2
    //   260: ldc 198
    //   262: putfield 201	d/d:SLx	Ljava/lang/String;
    //   265: aload_2
    //   266: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   269: putfield 210	d/d:SLt	J
    //   272: aload_2
    //   273: ldc 212
    //   275: putfield 215	d/d:type	Ljava/lang/String;
    //   278: aload 6
    //   280: ifnonnull +15 -> 295
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_2
    //   286: aload_1
    //   287: putfield 219	d/d:SLB	Ld/f;
    //   290: aload_2
    //   291: astore_1
    //   292: goto -201 -> 91
    //   295: new 221	d/f
    //   298: dup
    //   299: invokespecial 222	d/f:<init>	()V
    //   302: astore 5
    //   304: aload 6
    //   306: invokestatic 225	com/tencent/h/c/c:getIMEI	(Landroid/content/Context;)Ljava/lang/String;
    //   309: astore 7
    //   311: aload 6
    //   313: invokestatic 228	com/tencent/h/c/c:kZ	(Landroid/content/Context;)Ljava/lang/String;
    //   316: astore 6
    //   318: aload 7
    //   320: astore_1
    //   321: aload 7
    //   323: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +6 -> 332
    //   329: ldc 198
    //   331: astore_1
    //   332: aload 5
    //   334: aload_1
    //   335: putfield 237	d/f:SLK	Ljava/lang/String;
    //   338: aload 6
    //   340: astore_1
    //   341: aload 6
    //   343: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifeq +6 -> 352
    //   349: ldc 198
    //   351: astore_1
    //   352: aload 5
    //   354: aload_1
    //   355: putfield 240	d/f:dGL	Ljava/lang/String;
    //   358: aload 5
    //   360: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   363: putfield 248	d/f:model	Ljava/lang/String;
    //   366: aload 5
    //   368: getstatic 251	android/os/Build:BRAND	Ljava/lang/String;
    //   371: putfield 254	d/f:brand	Ljava/lang/String;
    //   374: aload 5
    //   376: new 256	java/lang/StringBuilder
    //   379: dup
    //   380: ldc_w 258
    //   383: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: getstatic 264	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   389: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: putfield 274	d/f:SLe	Ljava/lang/String;
    //   398: aload 5
    //   400: astore_1
    //   401: goto -116 -> 285
    //   404: aload_1
    //   405: invokestatic 280	com/tencent/h/c/a:compress	([B)[B
    //   408: invokestatic 285	com/tencent/h/c/b:hkP	()[B
    //   411: invokestatic 289	com/tencent/h/c/b:n	([B[B)[B
    //   414: astore_1
    //   415: goto -240 -> 175
    //   418: aload 6
    //   420: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   423: astore 7
    //   425: new 256	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   432: aload_2
    //   433: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 292
    //   439: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   445: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore_2
    //   452: aload 7
    //   454: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   457: ifne +210 -> 667
    //   460: aload_2
    //   461: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +80 -> 544
    //   467: goto +200 -> 667
    //   470: aload_2
    //   471: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +188 -> 662
    //   477: aload_2
    //   478: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifeq +92 -> 573
    //   484: iconst_0
    //   485: istore_3
    //   486: iload_3
    //   487: ifeq +175 -> 662
    //   490: aload 6
    //   492: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   495: invokestatic 299	com/tencent/i/a/d/a:brc	(Ljava/lang/String;)Ljava/util/List;
    //   498: astore_1
    //   499: aload 5
    //   501: getfield 121	com/tencent/i/a/d/b:Stt	Lcom/tencent/i/a/d/a;
    //   504: astore_2
    //   505: aload_1
    //   506: ifnull +166 -> 672
    //   509: aload_1
    //   510: invokeinterface 304 1 0
    //   515: ifne +157 -> 672
    //   518: aload_1
    //   519: invokeinterface 308 1 0
    //   524: bipush 20
    //   526: if_icmpgt +92 -> 618
    //   529: goto +143 -> 672
    //   532: aload_1
    //   533: ifnull +129 -> 662
    //   536: aload_1
    //   537: invokevirtual 311	java/io/File:delete	()Z
    //   540: pop
    //   541: goto +121 -> 662
    //   544: new 256	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   551: aload 7
    //   553: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: getstatic 314	java/io/File:separator	Ljava/lang/String;
    //   559: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_2
    //   563: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: astore_2
    //   570: goto -100 -> 470
    //   573: new 316	java/io/BufferedOutputStream
    //   576: dup
    //   577: new 318	java/io/FileOutputStream
    //   580: dup
    //   581: aload_2
    //   582: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   585: invokespecial 322	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   588: astore_2
    //   589: aload_2
    //   590: aload_1
    //   591: invokevirtual 326	java/io/BufferedOutputStream:write	([B)V
    //   594: aload_2
    //   595: invokevirtual 329	java/io/BufferedOutputStream:flush	()V
    //   598: aload_2
    //   599: invokestatic 335	com/tencent/h/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   602: goto +75 -> 677
    //   605: aload_2
    //   606: invokestatic 335	com/tencent/h/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   609: goto +68 -> 677
    //   612: aload_2
    //   613: invokestatic 335	com/tencent/h/c/e:closeQuietly	(Ljava/io/Closeable;)V
    //   616: aload_1
    //   617: athrow
    //   618: aload_1
    //   619: new 337	com/tencent/i/a/d/a$1
    //   622: dup
    //   623: aload_2
    //   624: invokespecial 340	com/tencent/i/a/d/a$1:<init>	(Lcom/tencent/i/a/d/a;)V
    //   627: invokestatic 346	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   630: aload_1
    //   631: iconst_0
    //   632: invokeinterface 350 2 0
    //   637: checkcast 142	java/io/File
    //   640: astore_1
    //   641: goto -109 -> 532
    //   644: astore_1
    //   645: goto -33 -> 612
    //   648: astore_1
    //   649: goto -44 -> 605
    //   652: aconst_null
    //   653: astore_1
    //   654: goto -563 -> 91
    //   657: aconst_null
    //   658: astore_1
    //   659: goto -484 -> 175
    //   662: iconst_1
    //   663: ireturn
    //   664: astore_1
    //   665: iconst_0
    //   666: ireturn
    //   667: aconst_null
    //   668: astore_2
    //   669: goto -199 -> 470
    //   672: aconst_null
    //   673: astore_1
    //   674: goto -142 -> 532
    //   677: iconst_1
    //   678: istore_3
    //   679: goto -193 -> 486
    //   682: astore_1
    //   683: aconst_null
    //   684: astore_2
    //   685: goto -80 -> 605
    //   688: astore_1
    //   689: aload 4
    //   691: astore_2
    //   692: goto -80 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	this	a
    //   0	695	1	paramThrowable	Throwable
    //   0	695	2	paramString	java.lang.String
    //   96	583	3	i	int
    //   1	689	4	localObject1	Object
    //   33	467	5	localObject2	Object
    //   77	414	6	localObject3	Object
    //   309	243	7	str1	java.lang.String
    //   11	92	8	localc	c
    //   24	68	9	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   589	598	644	finally
    //   589	598	648	java/lang/Throwable
    //   3	13	664	java/lang/Throwable
    //   20	79	664	java/lang/Throwable
    //   91	97	664	java/lang/Throwable
    //   102	109	664	java/lang/Throwable
    //   113	136	664	java/lang/Throwable
    //   141	163	664	java/lang/Throwable
    //   167	172	664	java/lang/Throwable
    //   179	184	664	java/lang/Throwable
    //   187	278	664	java/lang/Throwable
    //   285	290	664	java/lang/Throwable
    //   295	318	664	java/lang/Throwable
    //   321	329	664	java/lang/Throwable
    //   332	338	664	java/lang/Throwable
    //   341	349	664	java/lang/Throwable
    //   352	398	664	java/lang/Throwable
    //   404	415	664	java/lang/Throwable
    //   418	467	664	java/lang/Throwable
    //   470	484	664	java/lang/Throwable
    //   490	505	664	java/lang/Throwable
    //   509	529	664	java/lang/Throwable
    //   536	541	664	java/lang/Throwable
    //   544	570	664	java/lang/Throwable
    //   598	602	664	java/lang/Throwable
    //   605	609	664	java/lang/Throwable
    //   612	618	664	java/lang/Throwable
    //   618	641	664	java/lang/Throwable
    //   573	589	682	java/lang/Throwable
    //   573	589	688	finally
  }
  
  /* Error */
  public final boolean hqo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   4: getfield 95	com/tencent/i/a/a/c:mAppContext	Landroid/content/Context;
    //   7: ifnonnull +14 -> 21
    //   10: new 353	com/tencent/i/a/k
    //   13: dup
    //   14: ldc_w 355
    //   17: invokespecial 356	com/tencent/i/a/k:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_0
    //   22: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   25: getfield 95	com/tencent/i/a/a/c:mAppContext	Landroid/content/Context;
    //   28: astore 7
    //   30: aload_0
    //   31: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   34: getfield 360	com/tencent/i/a/a/c:SqO	Lcom/tencent/i/a/a/b/b;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +76 -> 117
    //   44: aload 7
    //   46: ldc_w 362
    //   49: invokevirtual 368	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 370	android/hardware/SensorManager
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
    //   89: invokevirtual 374	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnonnull +167 -> 263
    //   99: iconst_0
    //   100: istore_3
    //   101: goto +141 -> 242
    //   104: aload 6
    //   106: iload 4
    //   108: putfield 380	com/tencent/i/a/a/b/b:SqX	Z
    //   111: aload 6
    //   113: iload_2
    //   114: putfield 384	com/tencent/i/a/a/b/b:SqY	I
    //   117: aload_0
    //   118: new 386	com/tencent/i/a/c/d
    //   121: dup
    //   122: aload_0
    //   123: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   126: invokespecial 389	com/tencent/i/a/c/d:<init>	(Lcom/tencent/i/a/a/c;)V
    //   129: putfield 49	com/tencent/i/a/b/b/a:Srk	Lcom/tencent/i/a/c/b;
    //   132: new 391	com/tencent/i/a/a/e
    //   135: dup
    //   136: aload_0
    //   137: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   140: ldc_w 393
    //   143: invokespecial 396	com/tencent/i/a/a/e:<init>	(Lcom/tencent/i/a/a/c;Ljava/lang/String;)V
    //   146: pop
    //   147: new 256	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 398
    //   154: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   161: getfield 360	com/tencent/i/a/a/c:SqO	Lcom/tencent/i/a/a/b/b;
    //   164: getfield 380	com/tencent/i/a/a/b/b:SqX	Z
    //   167: invokevirtual 401	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 403
    //   173: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   193: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   196: ifnull -16 -> 180
    //   199: iload 4
    //   201: istore 5
    //   203: aload_0
    //   204: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   207: getfield 30	com/tencent/i/a/a/c:SqP	Lcom/tencent/h/a/b;
    //   210: ifnull -30 -> 180
    //   213: aload_0
    //   214: getfield 26	com/tencent/i/a/b/b/a:SqM	Lcom/tencent/i/a/a/c;
    //   217: getfield 30	com/tencent/i/a/a/c:SqP	Lcom/tencent/h/a/b;
    //   220: aload 6
    //   222: ldc_w 405
    //   225: invokeinterface 59 3 0
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
    //   37	75	6	localb	com.tencent.i.a.a.b.b
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */