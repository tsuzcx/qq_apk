package com.tencent.mm.plugin.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b.e;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.w;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  implements c
{
  /* Error */
  public final com.tencent.mm.av.a.d.b CD(String paramString)
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 41
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: aload 4
    //   15: astore 6
    //   17: aload 4
    //   19: astore 7
    //   21: aload 4
    //   23: astore 8
    //   25: aload 4
    //   27: astore 9
    //   29: aload 4
    //   31: astore 10
    //   33: aload 4
    //   35: astore 11
    //   37: aload 4
    //   39: astore 12
    //   41: new 43	com/tencent/mm/network/b$b
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 46	com/tencent/mm/network/b$b:<init>	(Ljava/lang/String;)V
    //   49: astore 13
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: astore 5
    //   58: aload 4
    //   60: astore 6
    //   62: aload 4
    //   64: astore 7
    //   66: aload 4
    //   68: astore 8
    //   70: aload 4
    //   72: astore 9
    //   74: aload 4
    //   76: astore 10
    //   78: aload 4
    //   80: astore 11
    //   82: aload 4
    //   84: astore 12
    //   86: aload 13
    //   88: getfield 50	com/tencent/mm/network/b$b:ip	Ljava/lang/String;
    //   91: invokestatic 56	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   94: ifne +41 -> 135
    //   97: aload 4
    //   99: astore 5
    //   101: aload 4
    //   103: astore 6
    //   105: aload 4
    //   107: astore 7
    //   109: aload 4
    //   111: astore 8
    //   113: aload 4
    //   115: astore 9
    //   117: aload 4
    //   119: astore 10
    //   121: aload 4
    //   123: astore 11
    //   125: aload 4
    //   127: astore 12
    //   129: aload 13
    //   131: getfield 50	com/tencent/mm/network/b$b:ip	Ljava/lang/String;
    //   134: astore_3
    //   135: aload_3
    //   136: astore 5
    //   138: aload_3
    //   139: astore 6
    //   141: aload_3
    //   142: astore 7
    //   144: aload_3
    //   145: astore 8
    //   147: aload_3
    //   148: astore 9
    //   150: aload_3
    //   151: astore 10
    //   153: aload_3
    //   154: astore 11
    //   156: aload_3
    //   157: astore 12
    //   159: aload 13
    //   161: getfield 50	com/tencent/mm/network/b$b:ip	Ljava/lang/String;
    //   164: astore 4
    //   166: aload 13
    //   168: getfield 60	com/tencent/mm/network/b$b:ili	I
    //   171: istore_2
    //   172: aload_1
    //   173: aload 13
    //   175: invokestatic 64	com/tencent/mm/plugin/emoji/d/a$a:c	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/av/a/d/b;
    //   178: astore 5
    //   180: ldc 33
    //   182: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 5
    //   187: areturn
    //   188: astore 6
    //   190: iconst_0
    //   191: istore_2
    //   192: ldc 41
    //   194: astore 4
    //   196: aload 5
    //   198: astore_3
    //   199: aload 6
    //   201: astore 5
    //   203: ldc 69
    //   205: ldc 71
    //   207: iconst_5
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_1
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload_3
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: aload 4
    //   223: aastore
    //   224: dup
    //   225: iconst_3
    //   226: iload_2
    //   227: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: dup
    //   232: iconst_4
    //   233: aload 5
    //   235: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   238: aastore
    //   239: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   245: ldc2_w 94
    //   248: ldc2_w 96
    //   251: lconst_1
    //   252: iconst_0
    //   253: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   256: aload_3
    //   257: astore_1
    //   258: iload_2
    //   259: iconst_1
    //   260: if_icmpne +16 -> 276
    //   263: invokestatic 107	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   266: invokestatic 113	com/tencent/mm/sdk/platformtools/ax:isConnected	(Landroid/content/Context;)Z
    //   269: ifeq +7 -> 276
    //   272: aload_1
    //   273: invokestatic 118	com/tencent/mm/network/b:reportFailIp	(Ljava/lang/String;)V
    //   276: new 120	com/tencent/mm/av/a/d/b
    //   279: dup
    //   280: aconst_null
    //   281: aconst_null
    //   282: invokespecial 123	com/tencent/mm/av/a/d/b:<init>	([BLjava/lang/String;)V
    //   285: astore_1
    //   286: ldc 33
    //   288: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_1
    //   292: areturn
    //   293: astore 5
    //   295: iconst_0
    //   296: istore_2
    //   297: ldc 41
    //   299: astore 4
    //   301: aload 6
    //   303: astore_3
    //   304: ldc 69
    //   306: ldc 71
    //   308: iconst_5
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_1
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: aload_3
    //   319: aastore
    //   320: dup
    //   321: iconst_2
    //   322: aload 4
    //   324: aastore
    //   325: dup
    //   326: iconst_3
    //   327: iload_2
    //   328: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: aastore
    //   332: dup
    //   333: iconst_4
    //   334: aload 5
    //   336: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   339: aastore
    //   340: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   346: ldc2_w 94
    //   349: lconst_0
    //   350: lconst_1
    //   351: iconst_0
    //   352: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   355: aload_3
    //   356: astore_1
    //   357: goto -99 -> 258
    //   360: astore 5
    //   362: iconst_0
    //   363: istore_2
    //   364: ldc 41
    //   366: astore 4
    //   368: aload 7
    //   370: astore_3
    //   371: ldc 69
    //   373: ldc 71
    //   375: iconst_5
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_1
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: aload_3
    //   386: aastore
    //   387: dup
    //   388: iconst_2
    //   389: aload 4
    //   391: aastore
    //   392: dup
    //   393: iconst_3
    //   394: iload_2
    //   395: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: aastore
    //   399: dup
    //   400: iconst_4
    //   401: aload 5
    //   403: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   413: ldc2_w 94
    //   416: lconst_1
    //   417: lconst_1
    //   418: iconst_0
    //   419: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   422: aload_3
    //   423: astore_1
    //   424: goto -166 -> 258
    //   427: astore 5
    //   429: iconst_0
    //   430: istore_2
    //   431: ldc 41
    //   433: astore 4
    //   435: aload 8
    //   437: astore_3
    //   438: ldc 69
    //   440: ldc 71
    //   442: iconst_5
    //   443: anewarray 4	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload_1
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: aload_3
    //   453: aastore
    //   454: dup
    //   455: iconst_2
    //   456: aload 4
    //   458: aastore
    //   459: dup
    //   460: iconst_3
    //   461: iload_2
    //   462: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: aastore
    //   466: dup
    //   467: iconst_4
    //   468: aload 5
    //   470: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   473: aastore
    //   474: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   480: ldc2_w 94
    //   483: ldc2_w 124
    //   486: lconst_1
    //   487: iconst_0
    //   488: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   491: aload_3
    //   492: astore_1
    //   493: goto -235 -> 258
    //   496: astore 5
    //   498: iconst_0
    //   499: istore_2
    //   500: ldc 41
    //   502: astore 4
    //   504: aload 9
    //   506: astore_3
    //   507: ldc 69
    //   509: ldc 71
    //   511: iconst_5
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: aload_1
    //   518: aastore
    //   519: dup
    //   520: iconst_1
    //   521: aload_3
    //   522: aastore
    //   523: dup
    //   524: iconst_2
    //   525: aload 4
    //   527: aastore
    //   528: dup
    //   529: iconst_3
    //   530: iload_2
    //   531: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: aastore
    //   535: dup
    //   536: iconst_4
    //   537: aload 5
    //   539: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   542: aastore
    //   543: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   546: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   549: ldc2_w 94
    //   552: ldc2_w 126
    //   555: lconst_1
    //   556: iconst_0
    //   557: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   560: aload_3
    //   561: astore_1
    //   562: goto -304 -> 258
    //   565: astore 5
    //   567: iconst_0
    //   568: istore_2
    //   569: ldc 41
    //   571: astore 4
    //   573: aload 10
    //   575: astore_3
    //   576: ldc 69
    //   578: ldc 71
    //   580: iconst_5
    //   581: anewarray 4	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload_1
    //   587: aastore
    //   588: dup
    //   589: iconst_1
    //   590: aload_3
    //   591: aastore
    //   592: dup
    //   593: iconst_2
    //   594: aload 4
    //   596: aastore
    //   597: dup
    //   598: iconst_3
    //   599: iload_2
    //   600: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: aastore
    //   604: dup
    //   605: iconst_4
    //   606: aload 5
    //   608: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   611: aastore
    //   612: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   618: ldc2_w 94
    //   621: ldc2_w 128
    //   624: lconst_1
    //   625: iconst_0
    //   626: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   629: aload_3
    //   630: astore_1
    //   631: goto -373 -> 258
    //   634: astore 5
    //   636: iconst_0
    //   637: istore_2
    //   638: ldc 41
    //   640: astore 4
    //   642: aload 11
    //   644: astore_3
    //   645: ldc 69
    //   647: ldc 71
    //   649: iconst_5
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: aload_1
    //   656: aastore
    //   657: dup
    //   658: iconst_1
    //   659: aload_3
    //   660: aastore
    //   661: dup
    //   662: iconst_2
    //   663: aload 4
    //   665: aastore
    //   666: dup
    //   667: iconst_3
    //   668: iload_2
    //   669: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   672: aastore
    //   673: dup
    //   674: iconst_4
    //   675: aload 5
    //   677: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   680: aastore
    //   681: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   684: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   687: ldc2_w 94
    //   690: ldc2_w 130
    //   693: lconst_1
    //   694: iconst_0
    //   695: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   698: aload_3
    //   699: astore_1
    //   700: goto -442 -> 258
    //   703: astore 5
    //   705: iconst_0
    //   706: istore_2
    //   707: ldc 41
    //   709: astore 4
    //   711: aload 12
    //   713: astore_3
    //   714: ldc 69
    //   716: ldc 71
    //   718: iconst_5
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: aload_1
    //   725: aastore
    //   726: dup
    //   727: iconst_1
    //   728: aload_3
    //   729: aastore
    //   730: dup
    //   731: iconst_2
    //   732: aload 4
    //   734: aastore
    //   735: dup
    //   736: iconst_3
    //   737: iload_2
    //   738: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   741: aastore
    //   742: dup
    //   743: iconst_4
    //   744: aload 5
    //   746: invokestatic 81	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   749: aastore
    //   750: invokestatic 87	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   753: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   756: ldc2_w 94
    //   759: ldc2_w 132
    //   762: lconst_1
    //   763: iconst_0
    //   764: invokevirtual 101	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   767: aload_3
    //   768: astore_1
    //   769: goto -511 -> 258
    //   772: astore 5
    //   774: iconst_0
    //   775: istore_2
    //   776: goto -62 -> 714
    //   779: astore 5
    //   781: goto -67 -> 714
    //   784: astore 5
    //   786: iconst_0
    //   787: istore_2
    //   788: goto -143 -> 645
    //   791: astore 5
    //   793: goto -148 -> 645
    //   796: astore 5
    //   798: iconst_0
    //   799: istore_2
    //   800: goto -224 -> 576
    //   803: astore 5
    //   805: goto -229 -> 576
    //   808: astore 5
    //   810: iconst_0
    //   811: istore_2
    //   812: goto -305 -> 507
    //   815: astore 5
    //   817: goto -310 -> 507
    //   820: astore 5
    //   822: iconst_0
    //   823: istore_2
    //   824: goto -386 -> 438
    //   827: astore 5
    //   829: goto -391 -> 438
    //   832: astore 5
    //   834: iconst_0
    //   835: istore_2
    //   836: goto -465 -> 371
    //   839: astore 5
    //   841: goto -470 -> 371
    //   844: astore 5
    //   846: iconst_0
    //   847: istore_2
    //   848: goto -544 -> 304
    //   851: astore 5
    //   853: goto -549 -> 304
    //   856: astore 5
    //   858: iconst_0
    //   859: istore_2
    //   860: goto -657 -> 203
    //   863: astore 5
    //   865: goto -662 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	868	0	this	a
    //   0	868	1	paramString	String
    //   171	689	2	i	int
    //   53	715	3	localObject1	Object
    //   7	726	4	str	String
    //   11	223	5	localObject2	Object
    //   293	42	5	localInterruptedException1	java.lang.InterruptedException
    //   360	42	5	localUnknownHostException1	java.net.UnknownHostException
    //   427	42	5	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   496	42	5	localSocketException1	java.net.SocketException
    //   565	42	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   634	42	5	localIOException1	java.io.IOException
    //   703	42	5	localException1	Exception
    //   772	1	5	localException2	Exception
    //   779	1	5	localException3	Exception
    //   784	1	5	localIOException2	java.io.IOException
    //   791	1	5	localIOException3	java.io.IOException
    //   796	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   803	1	5	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   808	1	5	localSocketException2	java.net.SocketException
    //   815	1	5	localSocketException3	java.net.SocketException
    //   820	1	5	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   827	1	5	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   832	1	5	localUnknownHostException2	java.net.UnknownHostException
    //   839	1	5	localUnknownHostException3	java.net.UnknownHostException
    //   844	1	5	localInterruptedException2	java.lang.InterruptedException
    //   851	1	5	localInterruptedException3	java.lang.InterruptedException
    //   856	1	5	localProtocolException1	java.net.ProtocolException
    //   863	1	5	localProtocolException2	java.net.ProtocolException
    //   15	125	6	localObject3	Object
    //   188	114	6	localProtocolException3	java.net.ProtocolException
    //   19	350	7	localObject4	Object
    //   23	413	8	localObject5	Object
    //   27	478	9	localObject6	Object
    //   31	543	10	localObject7	Object
    //   35	608	11	localObject8	Object
    //   39	673	12	localObject9	Object
    //   49	125	13	localb	b.b
    // Exception table:
    //   from	to	target	type
    //   41	51	188	java/net/ProtocolException
    //   86	97	188	java/net/ProtocolException
    //   129	135	188	java/net/ProtocolException
    //   159	166	188	java/net/ProtocolException
    //   41	51	293	java/lang/InterruptedException
    //   86	97	293	java/lang/InterruptedException
    //   129	135	293	java/lang/InterruptedException
    //   159	166	293	java/lang/InterruptedException
    //   41	51	360	java/net/UnknownHostException
    //   86	97	360	java/net/UnknownHostException
    //   129	135	360	java/net/UnknownHostException
    //   159	166	360	java/net/UnknownHostException
    //   41	51	427	javax/net/ssl/SSLHandshakeException
    //   86	97	427	javax/net/ssl/SSLHandshakeException
    //   129	135	427	javax/net/ssl/SSLHandshakeException
    //   159	166	427	javax/net/ssl/SSLHandshakeException
    //   41	51	496	java/net/SocketException
    //   86	97	496	java/net/SocketException
    //   129	135	496	java/net/SocketException
    //   159	166	496	java/net/SocketException
    //   41	51	565	java/net/SocketTimeoutException
    //   86	97	565	java/net/SocketTimeoutException
    //   129	135	565	java/net/SocketTimeoutException
    //   159	166	565	java/net/SocketTimeoutException
    //   41	51	634	java/io/IOException
    //   86	97	634	java/io/IOException
    //   129	135	634	java/io/IOException
    //   159	166	634	java/io/IOException
    //   41	51	703	java/lang/Exception
    //   86	97	703	java/lang/Exception
    //   129	135	703	java/lang/Exception
    //   159	166	703	java/lang/Exception
    //   166	172	772	java/lang/Exception
    //   172	180	779	java/lang/Exception
    //   166	172	784	java/io/IOException
    //   172	180	791	java/io/IOException
    //   166	172	796	java/net/SocketTimeoutException
    //   172	180	803	java/net/SocketTimeoutException
    //   166	172	808	java/net/SocketException
    //   172	180	815	java/net/SocketException
    //   166	172	820	javax/net/ssl/SSLHandshakeException
    //   172	180	827	javax/net/ssl/SSLHandshakeException
    //   166	172	832	java/net/UnknownHostException
    //   172	180	839	java/net/UnknownHostException
    //   166	172	844	java/lang/InterruptedException
    //   172	180	851	java/lang/InterruptedException
    //   166	172	856	java/net/ProtocolException
    //   172	180	863	java/net/ProtocolException
  }
  
  static final class a
  {
    private static w b(String paramString, b.b paramb)
    {
      AppMethodBeat.i(104563);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaf, false))
      {
        paramString = com.tencent.mm.network.b.Fd(paramString);
        ((x)paramString).imC = 1195;
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbR, false);
        ((x)paramString).imD = bool;
        h.wUl.idkeyStat(1195L, 96L, 1L, false);
      }
      for (;;)
      {
        String str = "";
        paramb = str;
        if (ai.ciE())
        {
          paramb = str;
          if (g.agM())
          {
            int i = d.DIc;
            g.agP();
            paramb = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ax.getNetTypeForStat(ai.getContext())), Integer.valueOf(ax.getStrength(ai.getContext())) });
          }
        }
        ac.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", new Object[] { paramb });
        paramString.setRequestMethod("GET");
        paramString.setRequestProperty("referer", paramb);
        paramString.setConnectTimeout(15000);
        paramString.setReadTimeout(20000);
        AppMethodBeat.o(104563);
        return paramString;
        paramString = com.tencent.mm.network.b.a(paramString, paramb);
        h.wUl.idkeyStat(1195L, 95L, 1L, false);
      }
    }
    
    public static com.tencent.mm.av.a.d.b c(String paramString, b.b paramb)
    {
      AppMethodBeat.i(104564);
      w localw2 = b(paramString, paramb);
      if ((localw2 instanceof x)) {}
      for (int i = 1;; i = 0)
      {
        if (localw2 == null) {
          ac.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
        }
        long l = System.currentTimeMillis();
        int j = localw2.getResponseCode();
        w localw1 = localw2;
        b.b localb = paramb;
        if (j == 302) {}
        for (;;)
        {
          try
          {
            ac.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", new Object[] { paramString });
            String str = localw2.getHeaderField("location");
            localw1 = localw2;
            localb = paramb;
            if (!bs.isNullOrNil(str)) {
              localb = new b.b(str);
            }
            ac.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", localException1, "httpURLConnectionGet 302 redirect", new Object[0]);
          }
          catch (Exception localException1)
          {
            try
            {
              localw2.disconnect();
              localw1 = b(str, localb);
              if (com.tencent.mm.network.b.a(localw1) == 0) {
                break;
              }
              i = localw1.getResponseCode();
              ac.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[] { paramString, localb.ip, localb.ip, Integer.valueOf(localb.ili), Integer.valueOf(i) });
              switch (i)
              {
              default: 
                h.wUl.idkeyStat(315L, 12L, 1L, false);
                i = localb.ili;
                paramString = localb.ip;
                if ((i == 1) && (ax.isConnected(ai.getContext()))) {
                  com.tencent.mm.network.b.reportFailIp(paramString);
                }
                AppMethodBeat.o(104564);
                return null;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                paramb = (b.b)localObject;
                Object localObject = localException2;
              }
            }
            localException1 = localException1;
          }
          localw1 = localw2;
          localObject = paramb;
          continue;
          h.wUl.idkeyStat(315L, 8L, 1L, false);
          continue;
          h.wUl.idkeyStat(315L, 9L, 1L, false);
          continue;
          h.wUl.idkeyStat(315L, 10L, 1L, false);
          continue;
          h.wUl.idkeyStat(315L, 11L, 1L, false);
        }
        paramb = localw1.getInputStream();
        if (paramb == null)
        {
          ac.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[] { paramString });
          AppMethodBeat.o(104564);
          return null;
        }
        paramString = localw1.getContentType();
        paramb = e.a(paramb, false);
        localw1.disconnect();
        l = System.currentTimeMillis() - l;
        if (j == 200)
        {
          if (i == 0) {
            break label516;
          }
          h.wUl.idkeyStat(99L, 99L, l, false);
          h.wUl.idkeyStat(97L, 97L, 1L, false);
          ac.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "cronet request time ".concat(String.valueOf(l)));
        }
        for (;;)
        {
          paramString = new com.tencent.mm.av.a.d.b(paramb, paramString);
          AppMethodBeat.o(104564);
          return paramString;
          label516:
          h.wUl.idkeyStat(98L, 98L, l, false);
          h.wUl.idkeyStat(100L, 100L, 1L, false);
          ac.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "normal request time ".concat(String.valueOf(l)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d.a
 * JD-Core Version:    0.7.0.1
 */