package com.tencent.e.e.a;

import com.tencent.e.e.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
  extends c
{
  long BkM = 0L;
  int mCount = 1;
  int mMaxCount = 3;
  
  private e$a(e parame) {}
  
  /* Error */
  public final void dUF()
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 43	com/tencent/e/e/a/a/k
    //   8: dup
    //   9: invokespecial 44	com/tencent/e/e/a/a/k:<init>	()V
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   18: astore 8
    //   20: aload 8
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   27: invokestatic 47	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/d;
    //   30: getfield 53	com/tencent/e/e/a/d:context	Landroid/content/Context;
    //   33: astore 9
    //   35: getstatic 58	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 20
    //   40: if_icmplt +374 -> 414
    //   43: ldc 60
    //   45: invokestatic 66	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: astore 10
    //   50: aload 9
    //   52: invokevirtual 72	java/lang/Object:getClass	()Ljava/lang/Class;
    //   55: ldc 74
    //   57: invokevirtual 78	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   60: astore 11
    //   62: aload 11
    //   64: iconst_1
    //   65: invokevirtual 84	java/lang/reflect/Field:setAccessible	(Z)V
    //   68: aload 9
    //   70: aload 11
    //   72: aload 9
    //   74: invokevirtual 88	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: checkcast 90	java/lang/String
    //   80: invokevirtual 96	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   83: astore 11
    //   85: aload 11
    //   87: ifnonnull +175 -> 262
    //   90: iconst_0
    //   91: istore_1
    //   92: aload 7
    //   94: iload_1
    //   95: putfield 99	com/tencent/e/e/a/a/k:Blf	I
    //   98: new 101	java/io/File
    //   101: dup
    //   102: ldc 103
    //   104: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokestatic 112	com/tencent/e/f/f:ae	(Ljava/io/File;)Ljava/lang/String;
    //   110: astore 10
    //   112: aload 10
    //   114: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +19 -> 136
    //   120: ldc 120
    //   122: aload 10
    //   124: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +333 -> 460
    //   130: aload 7
    //   132: iconst_1
    //   133: putfield 127	com/tencent/e/e/a/a/k:Blh	I
    //   136: aload 9
    //   138: aconst_null
    //   139: new 129	android/content/IntentFilter
    //   142: dup
    //   143: ldc 131
    //   145: invokespecial 132	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 136	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   151: astore 9
    //   153: aload 9
    //   155: ifnull +35 -> 190
    //   158: aload 9
    //   160: ldc 138
    //   162: iconst_m1
    //   163: invokevirtual 144	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   166: istore_1
    //   167: iload_1
    //   168: iconst_2
    //   169: if_icmpeq +521 -> 690
    //   172: iload_1
    //   173: iconst_5
    //   174: if_icmpne +542 -> 716
    //   177: goto +513 -> 690
    //   180: iload_1
    //   181: ifne +330 -> 511
    //   184: aload 7
    //   186: iconst_1
    //   187: putfield 147	com/tencent/e/e/a/a/k:Bli	I
    //   190: aload 8
    //   192: monitorexit
    //   193: aload_0
    //   194: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   197: invokestatic 151	com/tencent/e/e/a/e:b	(Lcom/tencent/e/e/a/e;)Ljava/util/List;
    //   200: astore 8
    //   202: aload 8
    //   204: monitorenter
    //   205: aload_0
    //   206: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   209: invokestatic 151	com/tencent/e/e/a/e:b	(Lcom/tencent/e/e/a/e;)Ljava/util/List;
    //   212: aload 7
    //   214: invokeinterface 156 2 0
    //   219: pop
    //   220: aload 8
    //   222: monitorexit
    //   223: aload_0
    //   224: getfield 23	com/tencent/e/e/a/e$a:mCount	I
    //   227: aload_0
    //   228: getfield 25	com/tencent/e/e/a/e$a:mMaxCount	I
    //   231: if_icmplt +369 -> 600
    //   234: aload_0
    //   235: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   238: astore 7
    //   240: aload 7
    //   242: monitorenter
    //   243: aload_0
    //   244: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   247: invokestatic 160	com/tencent/e/e/a/e:c	(Lcom/tencent/e/e/a/e;)Z
    //   250: ifne +320 -> 570
    //   253: aload 7
    //   255: monitorexit
    //   256: ldc 35
    //   258: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: aload 10
    //   264: ldc 165
    //   266: iconst_0
    //   267: anewarray 62	java/lang/Class
    //   270: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   273: astore 10
    //   275: aload 10
    //   277: ifnonnull +8 -> 285
    //   280: iconst_0
    //   281: istore_1
    //   282: goto -190 -> 92
    //   285: aload 10
    //   287: iconst_1
    //   288: invokevirtual 172	java/lang/reflect/Method:setAccessible	(Z)V
    //   291: aload 10
    //   293: aload 11
    //   295: iconst_0
    //   296: anewarray 68	java/lang/Object
    //   299: invokevirtual 176	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 178	[Landroid/view/Display;
    //   305: checkcast 178	[Landroid/view/Display;
    //   308: astore 10
    //   310: ldc 180
    //   312: ldc 182
    //   314: iconst_0
    //   315: anewarray 62	java/lang/Class
    //   318: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   321: astore 11
    //   323: aload 11
    //   325: iconst_1
    //   326: invokevirtual 172	java/lang/reflect/Method:setAccessible	(Z)V
    //   329: ldc 180
    //   331: ldc 184
    //   333: invokevirtual 78	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   336: astore 12
    //   338: aload 12
    //   340: iconst_1
    //   341: invokevirtual 84	java/lang/reflect/Field:setAccessible	(Z)V
    //   344: iconst_0
    //   345: istore_1
    //   346: aload 10
    //   348: arraylength
    //   349: istore_3
    //   350: iconst_0
    //   351: istore_2
    //   352: iload_2
    //   353: iload_3
    //   354: if_icmpge +348 -> 702
    //   357: aload 10
    //   359: iload_2
    //   360: aaload
    //   361: astore 13
    //   363: aload 12
    //   365: aload 13
    //   367: invokevirtual 188	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   370: istore 4
    //   372: aload 11
    //   374: aload 13
    //   376: iconst_0
    //   377: anewarray 68	java/lang/Object
    //   380: invokevirtual 176	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   383: checkcast 190	java/lang/Integer
    //   386: invokevirtual 194	java/lang/Integer:intValue	()I
    //   389: iload 4
    //   391: if_icmpeq +296 -> 687
    //   394: iconst_1
    //   395: istore_1
    //   396: goto +299 -> 695
    //   399: aload 7
    //   401: iload_1
    //   402: putfield 99	com/tencent/e/e/a/a/k:Blf	I
    //   405: aload 7
    //   407: getfield 99	com/tencent/e/e/a/a/k:Blf	I
    //   410: istore_1
    //   411: goto -319 -> 92
    //   414: aload 9
    //   416: ldc 196
    //   418: invokevirtual 96	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   421: checkcast 198	android/os/PowerManager
    //   424: astore 10
    //   426: aload 10
    //   428: ifnull -330 -> 98
    //   431: aload 10
    //   433: invokevirtual 202	android/os/PowerManager:isScreenOn	()Z
    //   436: ifeq +19 -> 455
    //   439: iconst_1
    //   440: istore_1
    //   441: aload 7
    //   443: iload_1
    //   444: putfield 99	com/tencent/e/e/a/a/k:Blf	I
    //   447: goto -349 -> 98
    //   450: astore 10
    //   452: goto -354 -> 98
    //   455: iconst_2
    //   456: istore_1
    //   457: goto -16 -> 441
    //   460: ldc 204
    //   462: aload 10
    //   464: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +25 -> 492
    //   470: aload 7
    //   472: iconst_2
    //   473: putfield 127	com/tencent/e/e/a/a/k:Blh	I
    //   476: goto -340 -> 136
    //   479: astore 7
    //   481: aload 8
    //   483: monitorexit
    //   484: ldc 35
    //   486: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   489: aload 7
    //   491: athrow
    //   492: ldc 206
    //   494: aload 10
    //   496: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   499: ifeq -363 -> 136
    //   502: aload 7
    //   504: iconst_3
    //   505: putfield 127	com/tencent/e/e/a/a/k:Blh	I
    //   508: goto -372 -> 136
    //   511: aload 9
    //   513: ldc 208
    //   515: iconst_m1
    //   516: invokevirtual 144	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   519: istore_1
    //   520: iload_1
    //   521: iconst_2
    //   522: if_icmpne +12 -> 534
    //   525: aload 7
    //   527: iconst_3
    //   528: putfield 147	com/tencent/e/e/a/a/k:Bli	I
    //   531: goto -341 -> 190
    //   534: iload_1
    //   535: iconst_1
    //   536: if_icmpne +12 -> 548
    //   539: aload 7
    //   541: iconst_2
    //   542: putfield 147	com/tencent/e/e/a/a/k:Bli	I
    //   545: goto -355 -> 190
    //   548: aload 7
    //   550: iconst_0
    //   551: putfield 147	com/tencent/e/e/a/a/k:Bli	I
    //   554: goto -364 -> 190
    //   557: astore 7
    //   559: aload 8
    //   561: monitorexit
    //   562: ldc 35
    //   564: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   567: aload 7
    //   569: athrow
    //   570: aload_0
    //   571: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   574: invokevirtual 211	com/tencent/e/e/a/e:Ez	()Z
    //   577: pop
    //   578: aload 7
    //   580: monitorexit
    //   581: ldc 35
    //   583: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: return
    //   587: astore 8
    //   589: aload 7
    //   591: monitorexit
    //   592: ldc 35
    //   594: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aload 8
    //   599: athrow
    //   600: aload_0
    //   601: aload_0
    //   602: getfield 23	com/tencent/e/e/a/e$a:mCount	I
    //   605: iconst_1
    //   606: iadd
    //   607: putfield 23	com/tencent/e/e/a/e$a:mCount	I
    //   610: aload_0
    //   611: getfield 27	com/tencent/e/e/a/e$a:BkM	J
    //   614: getstatic 216	com/tencent/e/e/a/a/f:BkP	J
    //   617: aload_0
    //   618: getfield 23	com/tencent/e/e/a/e$a:mCount	I
    //   621: i2l
    //   622: lmul
    //   623: ladd
    //   624: invokestatic 222	java/lang/System:currentTimeMillis	()J
    //   627: lsub
    //   628: lstore 5
    //   630: lload 5
    //   632: lconst_0
    //   633: lcmp
    //   634: ifle +29 -> 663
    //   637: aload_0
    //   638: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   641: invokestatic 226	com/tencent/e/e/a/e:e	(Lcom/tencent/e/e/a/e;)Landroid/os/Handler;
    //   644: aload_0
    //   645: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   648: invokestatic 230	com/tencent/e/e/a/e:d	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/e$a;
    //   651: lload 5
    //   653: invokevirtual 236	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   656: pop
    //   657: ldc 35
    //   659: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   662: return
    //   663: aload_0
    //   664: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   667: invokestatic 226	com/tencent/e/e/a/e:e	(Lcom/tencent/e/e/a/e;)Landroid/os/Handler;
    //   670: aload_0
    //   671: getfield 18	com/tencent/e/e/a/e$a:BkG	Lcom/tencent/e/e/a/e;
    //   674: invokestatic 230	com/tencent/e/e/a/e:d	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/e$a;
    //   677: invokevirtual 240	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   680: pop
    //   681: ldc 35
    //   683: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   686: return
    //   687: goto +8 -> 695
    //   690: iconst_1
    //   691: istore_1
    //   692: goto -512 -> 180
    //   695: iload_2
    //   696: iconst_1
    //   697: iadd
    //   698: istore_2
    //   699: goto -347 -> 352
    //   702: iload_1
    //   703: ifeq +8 -> 711
    //   706: iconst_1
    //   707: istore_1
    //   708: goto -309 -> 399
    //   711: iconst_2
    //   712: istore_1
    //   713: goto -314 -> 399
    //   716: iconst_0
    //   717: istore_1
    //   718: goto -538 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	a
    //   91	627	1	i	int
    //   351	348	2	j	int
    //   349	6	3	k	int
    //   370	22	4	m	int
    //   628	24	5	l	long
    //   479	70	7	localObject2	java.lang.Object
    //   557	33	7	localObject3	java.lang.Object
    //   587	11	8	localObject5	java.lang.Object
    //   33	479	9	localObject6	java.lang.Object
    //   48	384	10	localObject7	java.lang.Object
    //   450	45	10	localThrowable	java.lang.Throwable
    //   60	313	11	localObject8	java.lang.Object
    //   336	28	12	localField	java.lang.reflect.Field
    //   361	14	13	localObject9	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   35	85	450	java/lang/Throwable
    //   92	98	450	java/lang/Throwable
    //   262	275	450	java/lang/Throwable
    //   285	344	450	java/lang/Throwable
    //   346	350	450	java/lang/Throwable
    //   363	394	450	java/lang/Throwable
    //   399	411	450	java/lang/Throwable
    //   414	426	450	java/lang/Throwable
    //   431	439	450	java/lang/Throwable
    //   441	447	450	java/lang/Throwable
    //   23	35	479	finally
    //   35	85	479	finally
    //   92	98	479	finally
    //   98	136	479	finally
    //   136	153	479	finally
    //   158	167	479	finally
    //   184	190	479	finally
    //   190	193	479	finally
    //   262	275	479	finally
    //   285	344	479	finally
    //   346	350	479	finally
    //   363	394	479	finally
    //   399	411	479	finally
    //   414	426	479	finally
    //   431	439	479	finally
    //   441	447	479	finally
    //   460	476	479	finally
    //   481	484	479	finally
    //   492	508	479	finally
    //   511	520	479	finally
    //   525	531	479	finally
    //   539	545	479	finally
    //   548	554	479	finally
    //   205	223	557	finally
    //   559	562	557	finally
    //   243	256	587	finally
    //   570	581	587	finally
    //   589	592	587	finally
  }
  
  public final void dUG()
  {
    AppMethodBeat.i(114543);
    if (e.f(this.BkG) != null) {
      e.f(this.BkG);
    }
    AppMethodBeat.o(114543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.e.a
 * JD-Core Version:    0.7.0.1
 */