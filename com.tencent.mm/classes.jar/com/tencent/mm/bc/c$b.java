package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.az.a;
import java.io.File;

final class c$b
  implements az.a
{
  private String eNO;
  private c.a fNt;
  private String ffp;
  private boolean success = false;
  private String username;
  
  public c$b(c paramc, String paramString1, String paramString2, c.a parama)
  {
    this.username = paramString1;
    this.ffp = paramString2;
    this.fNt = parama;
  }
  
  /* Error */
  public final boolean acS()
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 30	com/tencent/mm/bc/c$b:username	Ljava/lang/String;
    //   9: invokestatic 52	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 40
    //   17: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 30	com/tencent/mm/bc/c$b:username	Ljava/lang/String;
    //   27: invokestatic 59	com/tencent/mm/bc/c:tU	(Ljava/lang/String;)Ljava/lang/String;
    //   30: putfield 61	com/tencent/mm/bc/c$b:eNO	Ljava/lang/String;
    //   33: ldc 63
    //   35: astore_2
    //   36: invokestatic 69	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   39: invokevirtual 74	com/tencent/mm/kernel/a:QU	()Z
    //   42: ifeq +61 -> 103
    //   45: getstatic 80	com/tencent/mm/protocal/d:whH	I
    //   48: istore_1
    //   49: invokestatic 69	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   52: pop
    //   53: ldc 82
    //   55: iconst_4
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: iload_1
    //   62: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: invokestatic 92	com/tencent/mm/kernel/a:getUin	()I
    //   71: invokestatic 98	com/tencent/mm/a/p:getString	(I)Ljava/lang/String;
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: invokestatic 104	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   80: invokestatic 110	com/tencent/mm/sdk/platformtools/at:getNetTypeForStat	(Landroid/content/Context;)I
    //   83: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: invokestatic 104	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   92: invokestatic 113	com/tencent/mm/sdk/platformtools/at:getStrength	(Landroid/content/Context;)I
    //   95: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 119	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: astore_2
    //   103: ldc 121
    //   105: ldc 123
    //   107: iconst_3
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: getfield 30	com/tencent/mm/bc/c$b:username	Ljava/lang/String;
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: aload_0
    //   125: getfield 32	com/tencent/mm/bc/c$b:ffp	Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 28	com/tencent/mm/bc/c$b:success	Z
    //   137: aload_0
    //   138: getfield 32	com/tencent/mm/bc/c$b:ffp	Ljava/lang/String;
    //   141: aconst_null
    //   142: invokestatic 135	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   145: astore_3
    //   146: aload_3
    //   147: ldc 137
    //   149: invokevirtual 143	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: ldc 145
    //   155: aload_2
    //   156: invokevirtual 149	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_3
    //   160: sipush 5000
    //   163: invokevirtual 152	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   166: aload_3
    //   167: sipush 5000
    //   170: invokevirtual 155	com/tencent/mm/network/v:setReadTimeout	(I)V
    //   173: aload_3
    //   174: invokestatic 158	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/v;)I
    //   177: ifeq +54 -> 231
    //   180: ldc 121
    //   182: ldc 160
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload_0
    //   191: getfield 32	com/tencent/mm/bc/c$b:ffp	Ljava/lang/String;
    //   194: aastore
    //   195: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_3
    //   199: invokevirtual 166	com/tencent/mm/network/v:disconnect	()V
    //   202: ldc 40
    //   204: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: iconst_1
    //   208: ireturn
    //   209: astore_2
    //   210: ldc 121
    //   212: ldc 168
    //   214: iconst_1
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload_2
    //   221: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   224: aastore
    //   225: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: goto -26 -> 202
    //   231: aload_3
    //   232: invokevirtual 176	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   235: astore 4
    //   237: aload 4
    //   239: ifnonnull +86 -> 325
    //   242: ldc 121
    //   244: ldc 178
    //   246: iconst_1
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload_0
    //   253: getfield 32	com/tencent/mm/bc/c$b:ffp	Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_3
    //   261: invokevirtual 166	com/tencent/mm/network/v:disconnect	()V
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 183	java/io/InputStream:close	()V
    //   274: ldc 40
    //   276: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: iconst_1
    //   280: ireturn
    //   281: astore_2
    //   282: ldc 121
    //   284: ldc 168
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload_2
    //   293: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -36 -> 264
    //   303: astore_2
    //   304: ldc 121
    //   306: ldc 168
    //   308: iconst_1
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_2
    //   315: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -48 -> 274
    //   325: sipush 1024
    //   328: newarray byte
    //   330: astore 5
    //   332: new 185	java/io/FileOutputStream
    //   335: dup
    //   336: new 187	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   343: aload_0
    //   344: getfield 61	com/tencent/mm/bc/c$b:eNO	Ljava/lang/String;
    //   347: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 194
    //   352: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 200	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   361: astore_2
    //   362: aload 4
    //   364: astore 8
    //   366: aload_2
    //   367: astore 7
    //   369: aload_3
    //   370: astore 6
    //   372: aload 4
    //   374: aload 5
    //   376: invokevirtual 204	java/io/InputStream:read	([B)I
    //   379: istore_1
    //   380: iload_1
    //   381: iconst_m1
    //   382: if_icmpeq +103 -> 485
    //   385: aload 4
    //   387: astore 8
    //   389: aload_2
    //   390: astore 7
    //   392: aload_3
    //   393: astore 6
    //   395: aload_2
    //   396: aload 5
    //   398: iconst_0
    //   399: iload_1
    //   400: invokevirtual 210	java/io/OutputStream:write	([BII)V
    //   403: goto -41 -> 362
    //   406: astore 5
    //   408: aload 4
    //   410: astore 8
    //   412: aload_2
    //   413: astore 7
    //   415: aload_3
    //   416: astore 6
    //   418: ldc 121
    //   420: ldc 168
    //   422: iconst_1
    //   423: anewarray 4	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: aload 5
    //   430: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   433: aastore
    //   434: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: aload 4
    //   439: astore 8
    //   441: aload_2
    //   442: astore 7
    //   444: aload_3
    //   445: astore 6
    //   447: aload_0
    //   448: iconst_0
    //   449: putfield 28	com/tencent/mm/bc/c$b:success	Z
    //   452: aload_3
    //   453: ifnull +7 -> 460
    //   456: aload_3
    //   457: invokevirtual 166	com/tencent/mm/network/v:disconnect	()V
    //   460: aload 4
    //   462: ifnull +8 -> 470
    //   465: aload 4
    //   467: invokevirtual 183	java/io/InputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 211	java/io/OutputStream:close	()V
    //   478: ldc 40
    //   480: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   483: iconst_1
    //   484: ireturn
    //   485: aload 4
    //   487: astore 8
    //   489: aload_2
    //   490: astore 7
    //   492: aload_3
    //   493: astore 6
    //   495: aload_0
    //   496: iconst_1
    //   497: putfield 28	com/tencent/mm/bc/c$b:success	Z
    //   500: aload_3
    //   501: invokevirtual 166	com/tencent/mm/network/v:disconnect	()V
    //   504: aload 4
    //   506: ifnull +8 -> 514
    //   509: aload 4
    //   511: invokevirtual 183	java/io/InputStream:close	()V
    //   514: aload_2
    //   515: invokevirtual 211	java/io/OutputStream:close	()V
    //   518: goto -40 -> 478
    //   521: astore_2
    //   522: ldc 121
    //   524: ldc 168
    //   526: iconst_1
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload_2
    //   533: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   536: aastore
    //   537: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   540: goto -62 -> 478
    //   543: astore_3
    //   544: ldc 121
    //   546: ldc 168
    //   548: iconst_1
    //   549: anewarray 4	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: aload_3
    //   555: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   558: aastore
    //   559: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   562: goto -58 -> 504
    //   565: astore_3
    //   566: ldc 121
    //   568: ldc 168
    //   570: iconst_1
    //   571: anewarray 4	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload_3
    //   577: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   580: aastore
    //   581: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   584: goto -70 -> 514
    //   587: astore_3
    //   588: ldc 121
    //   590: ldc 168
    //   592: iconst_1
    //   593: anewarray 4	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: aload_3
    //   599: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   602: aastore
    //   603: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   606: goto -146 -> 460
    //   609: astore_3
    //   610: ldc 121
    //   612: ldc 168
    //   614: iconst_1
    //   615: anewarray 4	java/lang/Object
    //   618: dup
    //   619: iconst_0
    //   620: aload_3
    //   621: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   624: aastore
    //   625: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   628: goto -158 -> 470
    //   631: astore_2
    //   632: ldc 121
    //   634: ldc 168
    //   636: iconst_1
    //   637: anewarray 4	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: aload_2
    //   643: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   646: aastore
    //   647: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: goto -172 -> 478
    //   653: astore_2
    //   654: aconst_null
    //   655: astore 4
    //   657: aconst_null
    //   658: astore 5
    //   660: aconst_null
    //   661: astore_3
    //   662: aload_3
    //   663: ifnull +7 -> 670
    //   666: aload_3
    //   667: invokevirtual 166	com/tencent/mm/network/v:disconnect	()V
    //   670: aload 4
    //   672: ifnull +8 -> 680
    //   675: aload 4
    //   677: invokevirtual 183	java/io/InputStream:close	()V
    //   680: aload 5
    //   682: ifnull +8 -> 690
    //   685: aload 5
    //   687: invokevirtual 211	java/io/OutputStream:close	()V
    //   690: ldc 40
    //   692: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   695: aload_2
    //   696: athrow
    //   697: astore_3
    //   698: ldc 121
    //   700: ldc 168
    //   702: iconst_1
    //   703: anewarray 4	java/lang/Object
    //   706: dup
    //   707: iconst_0
    //   708: aload_3
    //   709: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   712: aastore
    //   713: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: goto -46 -> 670
    //   719: astore_3
    //   720: ldc 121
    //   722: ldc 168
    //   724: iconst_1
    //   725: anewarray 4	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: aload_3
    //   731: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   734: aastore
    //   735: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: goto -58 -> 680
    //   741: astore_3
    //   742: ldc 121
    //   744: ldc 168
    //   746: iconst_1
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: aload_3
    //   753: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   756: aastore
    //   757: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   760: goto -70 -> 690
    //   763: astore_2
    //   764: aconst_null
    //   765: astore 4
    //   767: aconst_null
    //   768: astore 5
    //   770: goto -108 -> 662
    //   773: astore_2
    //   774: aconst_null
    //   775: astore 5
    //   777: goto -115 -> 662
    //   780: astore_2
    //   781: aload 8
    //   783: astore 4
    //   785: aload 7
    //   787: astore 5
    //   789: aload 6
    //   791: astore_3
    //   792: goto -130 -> 662
    //   795: astore 5
    //   797: aconst_null
    //   798: astore 4
    //   800: aconst_null
    //   801: astore_2
    //   802: aconst_null
    //   803: astore_3
    //   804: goto -396 -> 408
    //   807: astore 5
    //   809: aconst_null
    //   810: astore 4
    //   812: aconst_null
    //   813: astore_2
    //   814: goto -406 -> 408
    //   817: astore 5
    //   819: aconst_null
    //   820: astore_2
    //   821: goto -413 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	b
    //   48	352	1	i	int
    //   35	121	2	str	String
    //   209	12	2	localException1	java.lang.Exception
    //   281	12	2	localException2	java.lang.Exception
    //   303	12	2	localException3	java.lang.Exception
    //   361	154	2	localFileOutputStream1	java.io.FileOutputStream
    //   521	12	2	localException4	java.lang.Exception
    //   631	12	2	localException5	java.lang.Exception
    //   653	43	2	localObject1	Object
    //   763	1	2	localObject2	Object
    //   773	1	2	localObject3	Object
    //   780	1	2	localObject4	Object
    //   801	20	2	localObject5	Object
    //   145	356	3	localv1	com.tencent.mm.network.v
    //   543	12	3	localException6	java.lang.Exception
    //   565	12	3	localException7	java.lang.Exception
    //   587	12	3	localException8	java.lang.Exception
    //   609	12	3	localException9	java.lang.Exception
    //   661	6	3	localObject6	Object
    //   697	12	3	localException10	java.lang.Exception
    //   719	12	3	localException11	java.lang.Exception
    //   741	12	3	localException12	java.lang.Exception
    //   791	13	3	localObject7	Object
    //   235	576	4	localObject8	Object
    //   330	67	5	arrayOfByte	byte[]
    //   406	23	5	localException13	java.lang.Exception
    //   658	130	5	localObject9	Object
    //   795	1	5	localException14	java.lang.Exception
    //   807	1	5	localException15	java.lang.Exception
    //   817	1	5	localException16	java.lang.Exception
    //   370	420	6	localv2	com.tencent.mm.network.v
    //   367	419	7	localFileOutputStream2	java.io.FileOutputStream
    //   364	418	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   198	202	209	java/lang/Exception
    //   260	264	281	java/lang/Exception
    //   269	274	303	java/lang/Exception
    //   372	380	406	java/lang/Exception
    //   395	403	406	java/lang/Exception
    //   495	500	406	java/lang/Exception
    //   514	518	521	java/lang/Exception
    //   500	504	543	java/lang/Exception
    //   509	514	565	java/lang/Exception
    //   456	460	587	java/lang/Exception
    //   465	470	609	java/lang/Exception
    //   474	478	631	java/lang/Exception
    //   137	146	653	finally
    //   666	670	697	java/lang/Exception
    //   675	680	719	java/lang/Exception
    //   685	690	741	java/lang/Exception
    //   146	198	763	finally
    //   231	237	763	finally
    //   242	260	773	finally
    //   325	362	773	finally
    //   372	380	780	finally
    //   395	403	780	finally
    //   418	437	780	finally
    //   447	452	780	finally
    //   495	500	780	finally
    //   137	146	795	java/lang/Exception
    //   146	198	807	java/lang/Exception
    //   231	237	807	java/lang/Exception
    //   242	260	817	java/lang/Exception
    //   325	362	817	java/lang/Exception
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(136863);
    if (!this.success)
    {
      this.fNt.db(false);
      AppMethodBeat.o(136863);
      return false;
    }
    e.deleteFile(this.eNO);
    new File(this.eNO + ".tmp").renameTo(new File(this.eNO));
    this.fNt.db(true);
    AppMethodBeat.o(136863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bc.c.b
 * JD-Core Version:    0.7.0.1
 */