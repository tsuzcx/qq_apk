package com.tencent.mm.plugin.a;

public final class b
{
  public long fileLength = -1L;
  public long pDH = -1L;
  public long pDI = -1L;
  public a pDJ = null;
  
  /* Error */
  private a J(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +9 -> 15
    //   9: lconst_0
    //   10: lconst_0
    //   11: lcmp
    //   12: ifge +17 -> 29
    //   15: ldc 37
    //   17: ldc 39
    //   19: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc 29
    //   24: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aconst_null
    //   30: astore 8
    //   32: aload_1
    //   33: lconst_0
    //   34: invokevirtual 54	java/io/InputStream:skip	(J)J
    //   37: lstore 4
    //   39: lload 4
    //   41: lconst_0
    //   42: lcmp
    //   43: ifge +10 -> 53
    //   46: ldc 29
    //   48: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: lconst_0
    //   54: lstore 4
    //   56: bipush 8
    //   58: newarray byte
    //   60: astore 10
    //   62: aload_1
    //   63: aload 10
    //   65: iconst_0
    //   66: bipush 8
    //   68: invokevirtual 58	java/io/InputStream:read	([BII)I
    //   71: istore_2
    //   72: iload_2
    //   73: bipush 8
    //   75: if_icmplt +224 -> 299
    //   78: aload 10
    //   80: iconst_0
    //   81: invokestatic 64	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   84: istore_2
    //   85: aload 10
    //   87: iconst_4
    //   88: invokestatic 64	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   91: istore_3
    //   92: lconst_0
    //   93: lstore 6
    //   95: iload_2
    //   96: iconst_1
    //   97: if_icmpne +24 -> 121
    //   100: aload_1
    //   101: aload 10
    //   103: iconst_0
    //   104: bipush 8
    //   106: invokevirtual 58	java/io/InputStream:read	([BII)I
    //   109: bipush 8
    //   111: if_icmplt +188 -> 299
    //   114: aload 10
    //   116: invokestatic 68	com/tencent/mm/plugin/a/c:aP	([B)J
    //   119: lstore 6
    //   121: aload_0
    //   122: aload 8
    //   124: putfield 24	com/tencent/mm/plugin/a/b:pDJ	Lcom/tencent/mm/plugin/a/a;
    //   127: new 70	com/tencent/mm/plugin/a/a
    //   130: dup
    //   131: iload_2
    //   132: lload 4
    //   134: iload_3
    //   135: lload 6
    //   137: invokespecial 73	com/tencent/mm/plugin/a/a:<init>	(IJIJ)V
    //   140: astore 9
    //   142: aload 9
    //   144: astore 8
    //   146: aload 9
    //   148: invokevirtual 77	com/tencent/mm/plugin/a/a:bTR	()Z
    //   151: ifne +120 -> 271
    //   154: aload 9
    //   156: astore 8
    //   158: aload 9
    //   160: invokevirtual 80	com/tencent/mm/plugin/a/a:bTS	()Z
    //   163: ifne +108 -> 271
    //   166: iload_2
    //   167: iconst_1
    //   168: if_icmple +50 -> 218
    //   171: iload_2
    //   172: bipush 8
    //   174: isub
    //   175: i2l
    //   176: lstore 6
    //   178: lload 4
    //   180: iload_2
    //   181: i2l
    //   182: ladd
    //   183: lstore 4
    //   185: aload 9
    //   187: astore 8
    //   189: aload_1
    //   190: lload 6
    //   192: invokevirtual 54	java/io/InputStream:skip	(J)J
    //   195: lload 6
    //   197: lcmp
    //   198: iflt +73 -> 271
    //   201: aload_1
    //   202: aload 10
    //   204: iconst_0
    //   205: bipush 8
    //   207: invokevirtual 58	java/io/InputStream:read	([BII)I
    //   210: istore_2
    //   211: aload 9
    //   213: astore 8
    //   215: goto -143 -> 72
    //   218: aload 9
    //   220: astore 8
    //   222: lload 6
    //   224: lconst_0
    //   225: lcmp
    //   226: ifle +45 -> 271
    //   229: lload 4
    //   231: lload 6
    //   233: ladd
    //   234: lstore 4
    //   236: lload 6
    //   238: ldc2_w 81
    //   241: lsub
    //   242: ldc2_w 81
    //   245: lsub
    //   246: lstore 6
    //   248: goto -63 -> 185
    //   251: astore 8
    //   253: aconst_null
    //   254: astore_1
    //   255: ldc 37
    //   257: aload 8
    //   259: ldc 84
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_1
    //   269: astore 8
    //   271: ldc 29
    //   273: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 8
    //   278: areturn
    //   279: astore 8
    //   281: aload 9
    //   283: astore_1
    //   284: goto -29 -> 255
    //   287: astore 9
    //   289: aload 8
    //   291: astore_1
    //   292: aload 9
    //   294: astore 8
    //   296: goto -41 -> 255
    //   299: goto -28 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	b
    //   0	302	1	paramInputStream	java.io.InputStream
    //   71	140	2	i	int
    //   91	44	3	j	int
    //   37	198	4	l1	long
    //   93	154	6	l2	long
    //   30	191	8	localObject1	Object
    //   251	7	8	localException1	java.lang.Exception
    //   269	8	8	localInputStream	java.io.InputStream
    //   279	11	8	localException2	java.lang.Exception
    //   294	1	8	localObject2	Object
    //   140	142	9	locala	a
    //   287	6	9	localException3	java.lang.Exception
    //   60	143	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   32	39	251	java/lang/Exception
    //   56	72	251	java/lang/Exception
    //   146	154	279	java/lang/Exception
    //   158	166	279	java/lang/Exception
    //   189	211	279	java/lang/Exception
    //   78	92	287	java/lang/Exception
    //   100	121	287	java/lang/Exception
    //   121	142	287	java/lang/Exception
  }
  
  /* Error */
  public final long Sl(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 97	com/tencent/mm/plugin/a/c:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +19 -> 28
    //   12: ldc 37
    //   14: ldc 99
    //   16: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 93
    //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc2_w 15
    //   27: lreturn
    //   28: new 101	com/tencent/mm/vfs/u
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   36: astore 12
    //   38: aconst_null
    //   39: astore 10
    //   41: aload_1
    //   42: invokestatic 110	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore 11
    //   47: aload 11
    //   49: astore 10
    //   51: aload_0
    //   52: aload 12
    //   54: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   57: putfield 22	com/tencent/mm/plugin/a/b:fileLength	J
    //   60: aload_0
    //   61: aload 10
    //   63: invokespecial 116	com/tencent/mm/plugin/a/b:J	(Ljava/io/InputStream;)Lcom/tencent/mm/plugin/a/a;
    //   66: astore 11
    //   68: aload 11
    //   70: ifnonnull +123 -> 193
    //   73: ldc 37
    //   75: ldc 118
    //   77: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc2_w 15
    //   83: lstore_2
    //   84: ldc2_w 15
    //   87: lstore 4
    //   89: lload_2
    //   90: lstore 6
    //   92: lload 4
    //   94: lstore 8
    //   96: aload 10
    //   98: ifnull +15 -> 113
    //   101: aload 10
    //   103: invokevirtual 121	java/io/InputStream:close	()V
    //   106: lload 4
    //   108: lstore 8
    //   110: lload_2
    //   111: lstore 6
    //   113: aload_0
    //   114: lload 8
    //   116: putfield 18	com/tencent/mm/plugin/a/b:pDH	J
    //   119: aload_0
    //   120: lload 6
    //   122: putfield 20	com/tencent/mm/plugin/a/b:pDI	J
    //   125: ldc 37
    //   127: new 123	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 125
    //   133: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: lload 8
    //   138: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: ldc 132
    //   143: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 20	com/tencent/mm/plugin/a/b:pDI	J
    //   150: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc 137
    //   155: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 12
    //   160: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   163: ldc2_w 138
    //   166: ldiv
    //   167: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: ldc 141
    //   172: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: ldc 93
    //   187: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: lload 8
    //   192: lreturn
    //   193: aload 11
    //   195: invokevirtual 77	com/tencent/mm/plugin/a/a:bTR	()Z
    //   198: ifeq +19 -> 217
    //   201: aload 11
    //   203: getfield 150	com/tencent/mm/plugin/a/a:pDG	J
    //   206: lstore 4
    //   208: aload 11
    //   210: invokevirtual 153	com/tencent/mm/plugin/a/a:getSize	()J
    //   213: lstore_2
    //   214: goto -125 -> 89
    //   217: aload 11
    //   219: invokevirtual 80	com/tencent/mm/plugin/a/a:bTS	()Z
    //   222: ifeq +22 -> 244
    //   225: ldc 37
    //   227: ldc 155
    //   229: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: ldc2_w 15
    //   235: lstore_2
    //   236: ldc2_w 15
    //   239: lstore 4
    //   241: goto -152 -> 89
    //   244: aload 11
    //   246: invokevirtual 153	com/tencent/mm/plugin/a/a:getSize	()J
    //   249: lconst_0
    //   250: lcmp
    //   251: ifle +183 -> 434
    //   254: aload 11
    //   256: invokevirtual 158	com/tencent/mm/plugin/a/a:getEndPos	()J
    //   259: lstore 4
    //   261: ldc2_w 15
    //   264: lstore_2
    //   265: goto -176 -> 89
    //   268: astore 10
    //   270: ldc 37
    //   272: aload 10
    //   274: ldc 84
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: lload_2
    //   284: lstore 6
    //   286: lload 4
    //   288: lstore 8
    //   290: goto -177 -> 113
    //   293: astore 11
    //   295: ldc2_w 15
    //   298: lstore_2
    //   299: ldc 37
    //   301: aload 11
    //   303: ldc 84
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload 10
    //   314: ifnull +109 -> 423
    //   317: aload 10
    //   319: invokevirtual 121	java/io/InputStream:close	()V
    //   322: ldc2_w 15
    //   325: lstore 6
    //   327: lload_2
    //   328: lstore 8
    //   330: goto -217 -> 113
    //   333: astore 10
    //   335: ldc 37
    //   337: aload 10
    //   339: ldc 84
    //   341: iconst_0
    //   342: anewarray 4	java/lang/Object
    //   345: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: ldc2_w 15
    //   351: lstore 6
    //   353: lload_2
    //   354: lstore 8
    //   356: goto -243 -> 113
    //   359: astore_1
    //   360: aconst_null
    //   361: astore 10
    //   363: aload 10
    //   365: ifnull +8 -> 373
    //   368: aload 10
    //   370: invokevirtual 121	java/io/InputStream:close	()V
    //   373: ldc 93
    //   375: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload_1
    //   379: athrow
    //   380: astore 10
    //   382: ldc 37
    //   384: aload 10
    //   386: ldc 84
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: goto -22 -> 373
    //   398: astore_1
    //   399: goto -36 -> 363
    //   402: astore_1
    //   403: goto -40 -> 363
    //   406: astore 11
    //   408: ldc2_w 15
    //   411: lstore_2
    //   412: goto -113 -> 299
    //   415: astore 11
    //   417: lload 4
    //   419: lstore_2
    //   420: goto -121 -> 299
    //   423: ldc2_w 15
    //   426: lstore 6
    //   428: lload_2
    //   429: lstore 8
    //   431: goto -318 -> 113
    //   434: ldc2_w 15
    //   437: lstore_2
    //   438: ldc2_w 15
    //   441: lstore 4
    //   443: goto -354 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	b
    //   0	446	1	paramString	java.lang.String
    //   83	355	2	l1	long
    //   87	355	4	l2	long
    //   90	337	6	l3	long
    //   94	336	8	l4	long
    //   39	63	10	localObject1	Object
    //   268	50	10	localIOException1	java.io.IOException
    //   333	5	10	localIOException2	java.io.IOException
    //   361	8	10	localObject2	Object
    //   380	5	10	localIOException3	java.io.IOException
    //   45	210	11	localObject3	Object
    //   293	9	11	localException1	java.lang.Exception
    //   406	1	11	localException2	java.lang.Exception
    //   415	1	11	localException3	java.lang.Exception
    //   36	123	12	localu	com.tencent.mm.vfs.u
    // Exception table:
    //   from	to	target	type
    //   101	106	268	java/io/IOException
    //   41	47	293	java/lang/Exception
    //   317	322	333	java/io/IOException
    //   41	47	359	finally
    //   368	373	380	java/io/IOException
    //   51	68	398	finally
    //   73	80	398	finally
    //   193	208	398	finally
    //   208	214	398	finally
    //   217	232	398	finally
    //   244	261	398	finally
    //   299	312	402	finally
    //   51	68	406	java/lang/Exception
    //   73	80	406	java/lang/Exception
    //   193	208	406	java/lang/Exception
    //   217	232	406	java/lang/Exception
    //   244	261	406	java/lang/Exception
    //   208	214	415	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */