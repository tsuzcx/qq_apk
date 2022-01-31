package com.tencent.mm.plugin.a;

public final class b
{
  public long glZ = -1L;
  public long gma = -1L;
  public long gmb = -1L;
  public a gmc = null;
  
  /* Error */
  private a v(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 30
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lconst_0
    //   6: lconst_0
    //   7: lcmp
    //   8: ifge +17 -> 25
    //   11: ldc 38
    //   13: ldc 40
    //   15: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 30
    //   20: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aconst_null
    //   26: astore 8
    //   28: aload_1
    //   29: lconst_0
    //   30: invokevirtual 55	java/io/InputStream:skip	(J)J
    //   33: lstore 4
    //   35: lload 4
    //   37: lconst_0
    //   38: lcmp
    //   39: ifge +10 -> 49
    //   42: ldc 30
    //   44: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aconst_null
    //   48: areturn
    //   49: lconst_0
    //   50: lstore 4
    //   52: bipush 8
    //   54: newarray byte
    //   56: astore 10
    //   58: aload_1
    //   59: aload 10
    //   61: iconst_0
    //   62: bipush 8
    //   64: invokevirtual 59	java/io/InputStream:read	([BII)I
    //   67: istore_2
    //   68: iload_2
    //   69: bipush 8
    //   71: if_icmplt +224 -> 295
    //   74: aload 10
    //   76: iconst_0
    //   77: invokestatic 65	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   80: istore_2
    //   81: aload 10
    //   83: iconst_4
    //   84: invokestatic 65	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   87: istore_3
    //   88: lconst_0
    //   89: lstore 6
    //   91: iload_2
    //   92: iconst_1
    //   93: if_icmpne +24 -> 117
    //   96: aload_1
    //   97: aload 10
    //   99: iconst_0
    //   100: bipush 8
    //   102: invokevirtual 59	java/io/InputStream:read	([BII)I
    //   105: bipush 8
    //   107: if_icmplt +188 -> 295
    //   110: aload 10
    //   112: invokestatic 69	com/tencent/mm/plugin/a/c:ae	([B)J
    //   115: lstore 6
    //   117: aload_0
    //   118: aload 8
    //   120: putfield 24	com/tencent/mm/plugin/a/b:gmc	Lcom/tencent/mm/plugin/a/a;
    //   123: new 71	com/tencent/mm/plugin/a/a
    //   126: dup
    //   127: iload_2
    //   128: lload 4
    //   130: iload_3
    //   131: lload 6
    //   133: invokespecial 74	com/tencent/mm/plugin/a/a:<init>	(IJIJ)V
    //   136: astore 9
    //   138: aload 9
    //   140: astore 8
    //   142: aload 9
    //   144: invokevirtual 78	com/tencent/mm/plugin/a/a:aoB	()Z
    //   147: ifne +120 -> 267
    //   150: aload 9
    //   152: astore 8
    //   154: aload 9
    //   156: invokevirtual 81	com/tencent/mm/plugin/a/a:aoC	()Z
    //   159: ifne +108 -> 267
    //   162: iload_2
    //   163: iconst_1
    //   164: if_icmple +50 -> 214
    //   167: iload_2
    //   168: bipush 8
    //   170: isub
    //   171: i2l
    //   172: lstore 6
    //   174: lload 4
    //   176: iload_2
    //   177: i2l
    //   178: ladd
    //   179: lstore 4
    //   181: aload 9
    //   183: astore 8
    //   185: aload_1
    //   186: lload 6
    //   188: invokevirtual 55	java/io/InputStream:skip	(J)J
    //   191: lload 6
    //   193: lcmp
    //   194: iflt +73 -> 267
    //   197: aload_1
    //   198: aload 10
    //   200: iconst_0
    //   201: bipush 8
    //   203: invokevirtual 59	java/io/InputStream:read	([BII)I
    //   206: istore_2
    //   207: aload 9
    //   209: astore 8
    //   211: goto -143 -> 68
    //   214: aload 9
    //   216: astore 8
    //   218: lload 6
    //   220: lconst_0
    //   221: lcmp
    //   222: ifle +45 -> 267
    //   225: lload 4
    //   227: lload 6
    //   229: ladd
    //   230: lstore 4
    //   232: lload 6
    //   234: ldc2_w 82
    //   237: lsub
    //   238: ldc2_w 82
    //   241: lsub
    //   242: lstore 6
    //   244: goto -63 -> 181
    //   247: astore 8
    //   249: aconst_null
    //   250: astore_1
    //   251: ldc 38
    //   253: aload 8
    //   255: ldc 85
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_1
    //   265: astore 8
    //   267: ldc 30
    //   269: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload 8
    //   274: areturn
    //   275: astore 8
    //   277: aload 9
    //   279: astore_1
    //   280: goto -29 -> 251
    //   283: astore 9
    //   285: aload 8
    //   287: astore_1
    //   288: aload 9
    //   290: astore 8
    //   292: goto -41 -> 251
    //   295: goto -28 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	b
    //   0	298	1	paramInputStream	java.io.InputStream
    //   67	140	2	i	int
    //   87	44	3	j	int
    //   33	198	4	l1	long
    //   89	154	6	l2	long
    //   26	191	8	localObject1	Object
    //   247	7	8	localException1	java.lang.Exception
    //   265	8	8	localInputStream	java.io.InputStream
    //   275	11	8	localException2	java.lang.Exception
    //   290	1	8	localObject2	Object
    //   136	142	9	locala	a
    //   283	6	9	localException3	java.lang.Exception
    //   56	143	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	35	247	java/lang/Exception
    //   52	68	247	java/lang/Exception
    //   142	150	275	java/lang/Exception
    //   154	162	275	java/lang/Exception
    //   185	207	275	java/lang/Exception
    //   74	88	283	java/lang/Exception
    //   96	117	283	java/lang/Exception
    //   117	138	283	java/lang/Exception
  }
  
  /* Error */
  public final long wD(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 98	com/tencent/mm/plugin/a/c:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +19 -> 28
    //   12: ldc 38
    //   14: ldc 100
    //   16: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 94
    //   21: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc2_w 15
    //   27: lreturn
    //   28: new 102	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 11
    //   38: aconst_null
    //   39: astore 9
    //   41: new 107	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: astore 8
    //   51: aload_0
    //   52: aload 11
    //   54: invokevirtual 112	java/io/File:length	()J
    //   57: putfield 22	com/tencent/mm/plugin/a/b:gmb	J
    //   60: aload_0
    //   61: aload 8
    //   63: invokespecial 114	com/tencent/mm/plugin/a/b:v	(Ljava/io/InputStream;)Lcom/tencent/mm/plugin/a/a;
    //   66: astore 9
    //   68: aload 9
    //   70: ifnonnull +107 -> 177
    //   73: ldc 38
    //   75: ldc 116
    //   77: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc2_w 15
    //   83: lstore_2
    //   84: ldc2_w 15
    //   87: lstore 4
    //   89: aload 8
    //   91: invokevirtual 119	java/io/InputStream:close	()V
    //   94: lload_2
    //   95: lstore 6
    //   97: aload_0
    //   98: lload 4
    //   100: putfield 18	com/tencent/mm/plugin/a/b:glZ	J
    //   103: aload_0
    //   104: lload 6
    //   106: putfield 20	com/tencent/mm/plugin/a/b:gma	J
    //   109: ldc 38
    //   111: new 121	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 123
    //   117: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: lload 4
    //   122: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: ldc 130
    //   127: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 20	com/tencent/mm/plugin/a/b:gma	J
    //   134: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc 135
    //   139: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 11
    //   144: invokevirtual 112	java/io/File:length	()J
    //   147: ldc2_w 136
    //   150: ldiv
    //   151: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: ldc 139
    //   156: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: ldc 94
    //   171: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: lload 4
    //   176: lreturn
    //   177: aload 9
    //   179: invokevirtual 78	com/tencent/mm/plugin/a/a:aoB	()Z
    //   182: ifeq +19 -> 201
    //   185: aload 9
    //   187: getfield 148	com/tencent/mm/plugin/a/a:glY	J
    //   190: lstore 4
    //   192: aload 9
    //   194: invokevirtual 151	com/tencent/mm/plugin/a/a:getSize	()J
    //   197: lstore_2
    //   198: goto -109 -> 89
    //   201: aload 9
    //   203: invokevirtual 81	com/tencent/mm/plugin/a/a:aoC	()Z
    //   206: ifeq +22 -> 228
    //   209: ldc 38
    //   211: ldc 153
    //   213: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: ldc2_w 15
    //   219: lstore_2
    //   220: ldc2_w 15
    //   223: lstore 4
    //   225: goto -136 -> 89
    //   228: aload 9
    //   230: invokevirtual 151	com/tencent/mm/plugin/a/a:getSize	()J
    //   233: lconst_0
    //   234: lcmp
    //   235: ifle +187 -> 422
    //   238: aload 9
    //   240: invokevirtual 156	com/tencent/mm/plugin/a/a:getEndPos	()J
    //   243: lstore 4
    //   245: ldc2_w 15
    //   248: lstore_2
    //   249: goto -160 -> 89
    //   252: astore 8
    //   254: ldc 38
    //   256: aload 8
    //   258: ldc 85
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: lload_2
    //   268: lstore 6
    //   270: goto -173 -> 97
    //   273: astore 10
    //   275: ldc2_w 15
    //   278: lstore_2
    //   279: aload 9
    //   281: astore 8
    //   283: aload 10
    //   285: astore 9
    //   287: ldc 38
    //   289: aload 9
    //   291: ldc 85
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload 8
    //   302: ifnull +109 -> 411
    //   305: aload 8
    //   307: invokevirtual 119	java/io/InputStream:close	()V
    //   310: ldc2_w 15
    //   313: lstore 6
    //   315: lload_2
    //   316: lstore 4
    //   318: goto -221 -> 97
    //   321: astore 8
    //   323: ldc 38
    //   325: aload 8
    //   327: ldc 85
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: ldc2_w 15
    //   339: lstore 6
    //   341: lload_2
    //   342: lstore 4
    //   344: goto -247 -> 97
    //   347: astore_1
    //   348: aconst_null
    //   349: astore 8
    //   351: aload 8
    //   353: ifnull +8 -> 361
    //   356: aload 8
    //   358: invokevirtual 119	java/io/InputStream:close	()V
    //   361: ldc 94
    //   363: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore 8
    //   370: ldc 38
    //   372: aload 8
    //   374: ldc 85
    //   376: iconst_0
    //   377: anewarray 4	java/lang/Object
    //   380: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: goto -22 -> 361
    //   386: astore_1
    //   387: goto -36 -> 351
    //   390: astore_1
    //   391: goto -40 -> 351
    //   394: astore 9
    //   396: ldc2_w 15
    //   399: lstore_2
    //   400: goto -113 -> 287
    //   403: astore 9
    //   405: lload 4
    //   407: lstore_2
    //   408: goto -121 -> 287
    //   411: ldc2_w 15
    //   414: lstore 6
    //   416: lload_2
    //   417: lstore 4
    //   419: goto -322 -> 97
    //   422: ldc2_w 15
    //   425: lstore_2
    //   426: ldc2_w 15
    //   429: lstore 4
    //   431: goto -342 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	b
    //   0	434	1	paramString	java.lang.String
    //   83	343	2	l1	long
    //   87	343	4	l2	long
    //   95	320	6	l3	long
    //   49	41	8	localFileInputStream	java.io.FileInputStream
    //   252	5	8	localIOException1	java.io.IOException
    //   281	25	8	localObject1	Object
    //   321	5	8	localIOException2	java.io.IOException
    //   349	8	8	localObject2	Object
    //   368	5	8	localIOException3	java.io.IOException
    //   39	251	9	localObject3	Object
    //   394	1	9	localException1	java.lang.Exception
    //   403	1	9	localException2	java.lang.Exception
    //   273	11	10	localException3	java.lang.Exception
    //   36	107	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	94	252	java/io/IOException
    //   41	51	273	java/lang/Exception
    //   305	310	321	java/io/IOException
    //   41	51	347	finally
    //   356	361	368	java/io/IOException
    //   51	68	386	finally
    //   73	80	386	finally
    //   177	192	386	finally
    //   192	198	386	finally
    //   201	216	386	finally
    //   228	245	386	finally
    //   287	300	390	finally
    //   51	68	394	java/lang/Exception
    //   73	80	394	java/lang/Exception
    //   177	192	394	java/lang/Exception
    //   201	216	394	java/lang/Exception
    //   228	245	394	java/lang/Exception
    //   192	198	403	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */