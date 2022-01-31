package com.tencent.mm.bb;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.av.a;
import java.io.File;

final class c$b
  implements av.a
{
  private String erh;
  private String exD;
  private c.a exE;
  private boolean success = false;
  private String username;
  
  public c$b(c paramc, String paramString1, String paramString2, c.a parama)
  {
    this.username = paramString1;
    this.exD = paramString2;
    this.exE = parama;
  }
  
  /* Error */
  public final boolean JS()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mm/bb/c$b:username	Ljava/lang/String;
    //   4: invokestatic 45	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   7: ifeq +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 30	com/tencent/mm/bb/c$b:username	Ljava/lang/String;
    //   17: invokestatic 49	com/tencent/mm/bb/c:mK	(Ljava/lang/String;)Ljava/lang/String;
    //   20: putfield 51	com/tencent/mm/bb/c$b:erh	Ljava/lang/String;
    //   23: ldc 53
    //   25: astore_2
    //   26: invokestatic 59	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   29: invokevirtual 64	com/tencent/mm/kernel/a:Dc	()Z
    //   32: ifeq +61 -> 93
    //   35: getstatic 70	com/tencent/mm/protocal/d:spa	I
    //   38: istore_1
    //   39: invokestatic 59	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   42: pop
    //   43: ldc 72
    //   45: iconst_4
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: invokestatic 82	com/tencent/mm/kernel/a:CK	()I
    //   61: invokestatic 88	com/tencent/mm/a/o:getString	(I)Ljava/lang/String;
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: invokestatic 94	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   70: invokestatic 100	com/tencent/mm/sdk/platformtools/aq:getNetTypeForStat	(Landroid/content/Context;)I
    //   73: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: invokestatic 94	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   82: invokestatic 103	com/tencent/mm/sdk/platformtools/aq:getStrength	(Landroid/content/Context;)I
    //   85: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 109	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: astore_2
    //   93: ldc 111
    //   95: ldc 113
    //   97: iconst_3
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_0
    //   104: getfield 30	com/tencent/mm/bb/c$b:username	Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_2
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: aload_0
    //   115: getfield 32	com/tencent/mm/bb/c$b:exD	Ljava/lang/String;
    //   118: aastore
    //   119: invokestatic 119	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 28	com/tencent/mm/bb/c$b:success	Z
    //   127: aload_0
    //   128: getfield 32	com/tencent/mm/bb/c$b:exD	Ljava/lang/String;
    //   131: aconst_null
    //   132: invokestatic 125	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
    //   135: astore_3
    //   136: aload_3
    //   137: ldc 127
    //   139: invokevirtual 133	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
    //   142: aload_3
    //   143: ldc 135
    //   145: aload_2
    //   146: invokevirtual 139	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_3
    //   150: sipush 5000
    //   153: invokevirtual 143	com/tencent/mm/network/u:setConnectTimeout	(I)V
    //   156: aload_3
    //   157: sipush 5000
    //   160: invokevirtual 146	com/tencent/mm/network/u:setReadTimeout	(I)V
    //   163: aload_3
    //   164: invokestatic 149	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/u;)I
    //   167: ifeq +52 -> 219
    //   170: ldc 111
    //   172: ldc 151
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_0
    //   181: getfield 32	com/tencent/mm/bb/c$b:exD	Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_3
    //   189: getfield 158	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   192: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_2
    //   198: ldc 111
    //   200: ldc 165
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_2
    //   209: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -21 -> 195
    //   219: aload_3
    //   220: invokevirtual 173	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   223: astore 4
    //   225: aload 4
    //   227: ifnonnull +84 -> 311
    //   230: ldc 111
    //   232: ldc 175
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield 32	com/tencent/mm/bb/c$b:exD	Ljava/lang/String;
    //   244: aastore
    //   245: invokestatic 119	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload_3
    //   249: getfield 158	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   252: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   255: aload 4
    //   257: ifnull +8 -> 265
    //   260: aload 4
    //   262: invokevirtual 180	java/io/InputStream:close	()V
    //   265: iconst_1
    //   266: ireturn
    //   267: astore_2
    //   268: ldc 111
    //   270: ldc 165
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_2
    //   279: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   282: aastore
    //   283: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: goto -31 -> 255
    //   289: astore_2
    //   290: ldc 111
    //   292: ldc 165
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_2
    //   301: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -43 -> 265
    //   311: sipush 1024
    //   314: newarray byte
    //   316: astore 5
    //   318: new 182	java/io/FileOutputStream
    //   321: dup
    //   322: new 184	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   329: aload_0
    //   330: getfield 51	com/tencent/mm/bb/c$b:erh	Ljava/lang/String;
    //   333: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 191
    //   338: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 197	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   347: astore_2
    //   348: aload 4
    //   350: astore 8
    //   352: aload_2
    //   353: astore 7
    //   355: aload_3
    //   356: astore 6
    //   358: aload 4
    //   360: aload 5
    //   362: invokevirtual 201	java/io/InputStream:read	([B)I
    //   365: istore_1
    //   366: iload_1
    //   367: iconst_m1
    //   368: if_icmpeq +101 -> 469
    //   371: aload 4
    //   373: astore 8
    //   375: aload_2
    //   376: astore 7
    //   378: aload_3
    //   379: astore 6
    //   381: aload_2
    //   382: aload 5
    //   384: iconst_0
    //   385: iload_1
    //   386: invokevirtual 207	java/io/OutputStream:write	([BII)V
    //   389: goto -41 -> 348
    //   392: astore 5
    //   394: aload 4
    //   396: astore 8
    //   398: aload_2
    //   399: astore 7
    //   401: aload_3
    //   402: astore 6
    //   404: ldc 111
    //   406: ldc 165
    //   408: iconst_1
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: aload 5
    //   416: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   419: aastore
    //   420: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload 4
    //   425: astore 8
    //   427: aload_2
    //   428: astore 7
    //   430: aload_3
    //   431: astore 6
    //   433: aload_0
    //   434: iconst_0
    //   435: putfield 28	com/tencent/mm/bb/c$b:success	Z
    //   438: aload_3
    //   439: ifnull +10 -> 449
    //   442: aload_3
    //   443: getfield 158	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   446: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   449: aload 4
    //   451: ifnull +8 -> 459
    //   454: aload 4
    //   456: invokevirtual 180	java/io/InputStream:close	()V
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 208	java/io/OutputStream:close	()V
    //   467: iconst_1
    //   468: ireturn
    //   469: aload 4
    //   471: astore 8
    //   473: aload_2
    //   474: astore 7
    //   476: aload_3
    //   477: astore 6
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 28	com/tencent/mm/bb/c$b:success	Z
    //   484: aload_3
    //   485: getfield 158	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   488: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   491: aload 4
    //   493: ifnull +8 -> 501
    //   496: aload 4
    //   498: invokevirtual 180	java/io/InputStream:close	()V
    //   501: aload_2
    //   502: invokevirtual 208	java/io/OutputStream:close	()V
    //   505: goto -38 -> 467
    //   508: astore_2
    //   509: ldc 111
    //   511: ldc 165
    //   513: iconst_1
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload_2
    //   520: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   523: aastore
    //   524: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   527: goto -60 -> 467
    //   530: astore_3
    //   531: ldc 111
    //   533: ldc 165
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload_3
    //   542: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   545: aastore
    //   546: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: goto -58 -> 491
    //   552: astore_3
    //   553: ldc 111
    //   555: ldc 165
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_3
    //   564: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: goto -70 -> 501
    //   574: astore_3
    //   575: ldc 111
    //   577: ldc 165
    //   579: iconst_1
    //   580: anewarray 4	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: aload_3
    //   586: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   589: aastore
    //   590: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   593: goto -144 -> 449
    //   596: astore_3
    //   597: ldc 111
    //   599: ldc 165
    //   601: iconst_1
    //   602: anewarray 4	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: aload_3
    //   608: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   611: aastore
    //   612: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: goto -156 -> 459
    //   618: astore_2
    //   619: ldc 111
    //   621: ldc 165
    //   623: iconst_1
    //   624: anewarray 4	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: aload_2
    //   630: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   633: aastore
    //   634: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: goto -170 -> 467
    //   640: astore_2
    //   641: aconst_null
    //   642: astore 4
    //   644: aconst_null
    //   645: astore 5
    //   647: aconst_null
    //   648: astore_3
    //   649: aload_3
    //   650: ifnull +10 -> 660
    //   653: aload_3
    //   654: getfield 158	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   657: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   660: aload 4
    //   662: ifnull +8 -> 670
    //   665: aload 4
    //   667: invokevirtual 180	java/io/InputStream:close	()V
    //   670: aload 5
    //   672: ifnull +8 -> 680
    //   675: aload 5
    //   677: invokevirtual 208	java/io/OutputStream:close	()V
    //   680: aload_2
    //   681: athrow
    //   682: astore_3
    //   683: ldc 111
    //   685: ldc 165
    //   687: iconst_1
    //   688: anewarray 4	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: aload_3
    //   694: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   697: aastore
    //   698: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   701: goto -41 -> 660
    //   704: astore_3
    //   705: ldc 111
    //   707: ldc 165
    //   709: iconst_1
    //   710: anewarray 4	java/lang/Object
    //   713: dup
    //   714: iconst_0
    //   715: aload_3
    //   716: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   719: aastore
    //   720: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   723: goto -53 -> 670
    //   726: astore_3
    //   727: ldc 111
    //   729: ldc 165
    //   731: iconst_1
    //   732: anewarray 4	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload_3
    //   738: invokestatic 169	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: goto -65 -> 680
    //   748: astore_2
    //   749: aconst_null
    //   750: astore 4
    //   752: aconst_null
    //   753: astore 5
    //   755: goto -106 -> 649
    //   758: astore_2
    //   759: aconst_null
    //   760: astore 5
    //   762: goto -113 -> 649
    //   765: astore_2
    //   766: aload 8
    //   768: astore 4
    //   770: aload 7
    //   772: astore 5
    //   774: aload 6
    //   776: astore_3
    //   777: goto -128 -> 649
    //   780: astore 5
    //   782: aconst_null
    //   783: astore 4
    //   785: aconst_null
    //   786: astore_2
    //   787: aconst_null
    //   788: astore_3
    //   789: goto -395 -> 394
    //   792: astore 5
    //   794: aconst_null
    //   795: astore 4
    //   797: aconst_null
    //   798: astore_2
    //   799: goto -405 -> 394
    //   802: astore 5
    //   804: aconst_null
    //   805: astore_2
    //   806: goto -412 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	b
    //   38	348	1	i	int
    //   25	121	2	str	String
    //   197	12	2	localException1	java.lang.Exception
    //   267	12	2	localException2	java.lang.Exception
    //   289	12	2	localException3	java.lang.Exception
    //   347	155	2	localFileOutputStream1	java.io.FileOutputStream
    //   508	12	2	localException4	java.lang.Exception
    //   618	12	2	localException5	java.lang.Exception
    //   640	41	2	localObject1	Object
    //   748	1	2	localObject2	Object
    //   758	1	2	localObject3	Object
    //   765	1	2	localObject4	Object
    //   786	20	2	localObject5	Object
    //   135	350	3	localu1	com.tencent.mm.network.u
    //   530	12	3	localException6	java.lang.Exception
    //   552	12	3	localException7	java.lang.Exception
    //   574	12	3	localException8	java.lang.Exception
    //   596	12	3	localException9	java.lang.Exception
    //   648	6	3	localObject6	Object
    //   682	12	3	localException10	java.lang.Exception
    //   704	12	3	localException11	java.lang.Exception
    //   726	12	3	localException12	java.lang.Exception
    //   776	13	3	localObject7	Object
    //   223	573	4	localObject8	Object
    //   316	67	5	arrayOfByte	byte[]
    //   392	23	5	localException13	java.lang.Exception
    //   645	128	5	localObject9	Object
    //   780	1	5	localException14	java.lang.Exception
    //   792	1	5	localException15	java.lang.Exception
    //   802	1	5	localException16	java.lang.Exception
    //   356	419	6	localu2	com.tencent.mm.network.u
    //   353	418	7	localFileOutputStream2	java.io.FileOutputStream
    //   350	417	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   188	195	197	java/lang/Exception
    //   248	255	267	java/lang/Exception
    //   260	265	289	java/lang/Exception
    //   358	366	392	java/lang/Exception
    //   381	389	392	java/lang/Exception
    //   479	484	392	java/lang/Exception
    //   501	505	508	java/lang/Exception
    //   484	491	530	java/lang/Exception
    //   496	501	552	java/lang/Exception
    //   442	449	574	java/lang/Exception
    //   454	459	596	java/lang/Exception
    //   463	467	618	java/lang/Exception
    //   127	136	640	finally
    //   653	660	682	java/lang/Exception
    //   665	670	704	java/lang/Exception
    //   675	680	726	java/lang/Exception
    //   136	188	748	finally
    //   219	225	748	finally
    //   230	248	758	finally
    //   311	348	758	finally
    //   358	366	765	finally
    //   381	389	765	finally
    //   404	423	765	finally
    //   433	438	765	finally
    //   479	484	765	finally
    //   127	136	780	java/lang/Exception
    //   136	188	792	java/lang/Exception
    //   219	225	792	java/lang/Exception
    //   230	248	802	java/lang/Exception
    //   311	348	802	java/lang/Exception
  }
  
  public final boolean JT()
  {
    if (!this.success)
    {
      this.exE.bY(false);
      return false;
    }
    e.deleteFile(this.erh);
    new File(this.erh + ".tmp").renameTo(new File(this.erh));
    this.exE.bY(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bb.c.b
 * JD-Core Version:    0.7.0.1
 */