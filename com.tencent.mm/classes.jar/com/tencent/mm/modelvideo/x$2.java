package com.tencent.mm.modelvideo;

final class x$2
  implements Runnable
{
  x$2(x paramx, String paramString1, String paramString2, String paramString3) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 32
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 44	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   8: lstore 8
    //   10: aload_0
    //   11: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   14: invokestatic 50	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   17: l2i
    //   18: istore 5
    //   20: aload_0
    //   21: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   24: invokestatic 50	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   27: l2i
    //   28: istore 6
    //   30: ldc 52
    //   32: ldc 54
    //   34: iconst_5
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: lload 8
    //   42: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: iload 5
    //   50: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: iload 6
    //   58: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: aload_0
    //   65: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_4
    //   71: aload_0
    //   72: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: iload 6
    //   81: iload 5
    //   83: if_icmpeq +126 -> 209
    //   86: iload 6
    //   88: ifgt +111 -> 199
    //   91: bipush 10
    //   93: istore_1
    //   94: iload 5
    //   96: ifgt +108 -> 204
    //   99: bipush 20
    //   101: istore_2
    //   102: getstatic 76	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   105: sipush 12696
    //   108: iconst_5
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iload_2
    //   115: iload_1
    //   116: bipush 106
    //   118: iadd
    //   119: iadd
    //   120: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 24	com/tencent/mm/modelvideo/x$2:mij	Ljava/lang/String;
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: ldc 78
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: ldc 78
    //   140: aastore
    //   141: dup
    //   142: iconst_4
    //   143: iload 6
    //   145: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokevirtual 82	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   152: ldc 52
    //   154: ldc 84
    //   156: iconst_4
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: iload 5
    //   164: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: iload 6
    //   172: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_0
    //   179: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_3
    //   185: aload_0
    //   186: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: ldc 32
    //   195: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: iconst_0
    //   200: istore_1
    //   201: goto -107 -> 94
    //   204: iconst_0
    //   205: istore_2
    //   206: goto -104 -> 102
    //   209: iconst_0
    //   210: istore 4
    //   212: iconst_0
    //   213: istore_1
    //   214: iconst_0
    //   215: istore_3
    //   216: aconst_null
    //   217: astore 11
    //   219: aconst_null
    //   220: astore 13
    //   222: aload 13
    //   224: astore 10
    //   226: iload 4
    //   228: istore_2
    //   229: aload_0
    //   230: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   233: invokestatic 94	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   236: astore 12
    //   238: aload 13
    //   240: astore 10
    //   242: aload 12
    //   244: astore 11
    //   246: iload 4
    //   248: istore_2
    //   249: aload_0
    //   250: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   253: invokestatic 94	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   256: astore 13
    //   258: aload 13
    //   260: astore 10
    //   262: aload 12
    //   264: astore 11
    //   266: iload 4
    //   268: istore_2
    //   269: sipush 4096
    //   272: newarray byte
    //   274: astore 14
    //   276: aload 13
    //   278: astore 10
    //   280: aload 12
    //   282: astore 11
    //   284: iload 4
    //   286: istore_2
    //   287: sipush 4096
    //   290: newarray byte
    //   292: astore 15
    //   294: aload 13
    //   296: astore 10
    //   298: aload 12
    //   300: astore 11
    //   302: iload_1
    //   303: istore_2
    //   304: aload 12
    //   306: aload 14
    //   308: invokevirtual 100	java/io/InputStream:read	([B)I
    //   311: istore 7
    //   313: aload 13
    //   315: astore 10
    //   317: aload 12
    //   319: astore 11
    //   321: iload_1
    //   322: istore_2
    //   323: aload 13
    //   325: aload 15
    //   327: invokevirtual 100	java/io/InputStream:read	([B)I
    //   330: istore 4
    //   332: iload_3
    //   333: istore_2
    //   334: iload 7
    //   336: iload 4
    //   338: if_icmpeq +5 -> 343
    //   341: iconst_1
    //   342: istore_2
    //   343: iload 7
    //   345: iconst_m1
    //   346: if_icmpeq +45 -> 391
    //   349: iconst_0
    //   350: istore_3
    //   351: iload_3
    //   352: iload 7
    //   354: if_icmpge +32 -> 386
    //   357: iload_1
    //   358: istore 4
    //   360: aload 14
    //   362: iload_3
    //   363: baload
    //   364: aload 15
    //   366: iload_3
    //   367: baload
    //   368: if_icmpeq +8 -> 376
    //   371: iload_1
    //   372: iconst_1
    //   373: iadd
    //   374: istore 4
    //   376: iload_3
    //   377: iconst_1
    //   378: iadd
    //   379: istore_3
    //   380: iload 4
    //   382: istore_1
    //   383: goto -32 -> 351
    //   386: iload_2
    //   387: istore_3
    //   388: goto -94 -> 294
    //   391: iload_1
    //   392: istore_3
    //   393: aload 12
    //   395: astore 11
    //   397: aload 13
    //   399: astore 10
    //   401: iload_2
    //   402: istore_1
    //   403: aload 10
    //   405: invokevirtual 103	java/io/InputStream:close	()V
    //   408: aload 11
    //   410: invokevirtual 103	java/io/InputStream:close	()V
    //   413: iload_1
    //   414: ifeq +106 -> 520
    //   417: ldc 52
    //   419: ldc 105
    //   421: iconst_4
    //   422: anewarray 4	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: iload 5
    //   429: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: aastore
    //   433: dup
    //   434: iconst_1
    //   435: iload 6
    //   437: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_2
    //   443: aload_0
    //   444: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   447: aastore
    //   448: dup
    //   449: iconst_3
    //   450: aload_0
    //   451: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   454: aastore
    //   455: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: getstatic 76	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   461: sipush 12696
    //   464: iconst_2
    //   465: anewarray 4	java/lang/Object
    //   468: dup
    //   469: iconst_0
    //   470: bipush 107
    //   472: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: aastore
    //   476: dup
    //   477: iconst_1
    //   478: aload_0
    //   479: getfield 24	com/tencent/mm/modelvideo/x$2:mij	Ljava/lang/String;
    //   482: aastore
    //   483: invokevirtual 82	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   486: ldc 32
    //   488: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   491: return
    //   492: astore 12
    //   494: ldc 52
    //   496: ldc 107
    //   498: iconst_1
    //   499: anewarray 4	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: aload 12
    //   506: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   509: aastore
    //   510: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   513: iconst_1
    //   514: istore_1
    //   515: iload_2
    //   516: istore_3
    //   517: goto -114 -> 403
    //   520: lload 8
    //   522: invokestatic 115	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   525: lstore 8
    //   527: getstatic 76	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   530: sipush 12696
    //   533: iconst_4
    //   534: anewarray 4	java/lang/Object
    //   537: dup
    //   538: iconst_0
    //   539: sipush 400
    //   542: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: aload_0
    //   549: getfield 24	com/tencent/mm/modelvideo/x$2:mij	Ljava/lang/String;
    //   552: aastore
    //   553: dup
    //   554: iconst_2
    //   555: iload_3
    //   556: invokestatic 120	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   559: aastore
    //   560: dup
    //   561: iconst_3
    //   562: lload 8
    //   564: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   567: aastore
    //   568: invokevirtual 82	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   571: ldc 52
    //   573: ldc 122
    //   575: iconst_4
    //   576: anewarray 4	java/lang/Object
    //   579: dup
    //   580: iconst_0
    //   581: lload 8
    //   583: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   586: aastore
    //   587: dup
    //   588: iconst_1
    //   589: iload_3
    //   590: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   593: aastore
    //   594: dup
    //   595: iconst_2
    //   596: aload_0
    //   597: getfield 20	com/tencent/mm/modelvideo/x$2:mih	Ljava/lang/String;
    //   600: aastore
    //   601: dup
    //   602: iconst_3
    //   603: aload_0
    //   604: getfield 22	com/tencent/mm/modelvideo/x$2:mii	Ljava/lang/String;
    //   607: aastore
    //   608: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   611: ldc 32
    //   613: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: return
    //   617: astore 10
    //   619: goto -211 -> 408
    //   622: astore 10
    //   624: goto -211 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	2
    //   93	422	1	i	int
    //   101	415	2	j	int
    //   215	375	3	k	int
    //   210	171	4	m	int
    //   18	410	5	n	int
    //   28	408	6	i1	int
    //   311	44	7	i2	int
    //   8	574	8	l	long
    //   224	180	10	localInputStream1	java.io.InputStream
    //   617	1	10	localException1	java.lang.Exception
    //   622	1	10	localException2	java.lang.Exception
    //   217	192	11	localObject	Object
    //   236	158	12	localInputStream2	java.io.InputStream
    //   492	13	12	localException3	java.lang.Exception
    //   220	178	13	localInputStream3	java.io.InputStream
    //   274	87	14	arrayOfByte1	byte[]
    //   292	73	15	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   229	238	492	java/lang/Exception
    //   249	258	492	java/lang/Exception
    //   269	276	492	java/lang/Exception
    //   287	294	492	java/lang/Exception
    //   304	313	492	java/lang/Exception
    //   323	332	492	java/lang/Exception
    //   403	408	617	java/lang/Exception
    //   408	413	622	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.x.2
 * JD-Core Version:    0.7.0.1
 */