package com.tencent.mm.plugin.a;

public final class b
{
  public long eUb = -1L;
  public long eUc = -1L;
  public long eUd = -1L;
  public a eUe = null;
  
  /* Error */
  private a s(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lconst_0
    //   2: lcmp
    //   3: ifge +16 -> 19
    //   6: ldc 31
    //   8: ldc 33
    //   10: invokestatic 39	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 9
    //   16: aload 9
    //   18: areturn
    //   19: aconst_null
    //   20: astore 9
    //   22: aload_1
    //   23: lconst_0
    //   24: invokevirtual 45	java/io/InputStream:skip	(J)J
    //   27: lconst_0
    //   28: lcmp
    //   29: ifge +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: lconst_0
    //   35: lstore 4
    //   37: bipush 8
    //   39: newarray byte
    //   41: astore 10
    //   43: aload_1
    //   44: aload 10
    //   46: iconst_0
    //   47: bipush 8
    //   49: invokevirtual 49	java/io/InputStream:read	([BII)I
    //   52: istore_2
    //   53: iload_2
    //   54: bipush 8
    //   56: if_icmplt +207 -> 263
    //   59: aload 10
    //   61: iconst_0
    //   62: invokestatic 55	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   65: istore_2
    //   66: aload 10
    //   68: iconst_4
    //   69: invokestatic 55	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   72: istore_3
    //   73: lconst_0
    //   74: lstore 6
    //   76: iload_2
    //   77: iconst_1
    //   78: if_icmpne +24 -> 102
    //   81: aload_1
    //   82: aload 10
    //   84: iconst_0
    //   85: bipush 8
    //   87: invokevirtual 49	java/io/InputStream:read	([BII)I
    //   90: bipush 8
    //   92: if_icmplt +171 -> 263
    //   95: aload 10
    //   97: invokestatic 59	com/tencent/mm/plugin/a/c:K	([B)J
    //   100: lstore 6
    //   102: aload_0
    //   103: aload 9
    //   105: putfield 24	com/tencent/mm/plugin/a/b:eUe	Lcom/tencent/mm/plugin/a/a;
    //   108: new 61	com/tencent/mm/plugin/a/a
    //   111: dup
    //   112: iload_2
    //   113: lload 4
    //   115: iload_3
    //   116: lload 6
    //   118: invokespecial 64	com/tencent/mm/plugin/a/a:<init>	(IJIJ)V
    //   121: astore 8
    //   123: aload 8
    //   125: astore 9
    //   127: aload 8
    //   129: invokevirtual 68	com/tencent/mm/plugin/a/a:Vc	()Z
    //   132: ifne -116 -> 16
    //   135: aload 8
    //   137: astore 9
    //   139: aload 8
    //   141: invokevirtual 71	com/tencent/mm/plugin/a/a:Vd	()Z
    //   144: ifne -128 -> 16
    //   147: iload_2
    //   148: iconst_1
    //   149: if_icmple +50 -> 199
    //   152: iload_2
    //   153: bipush 8
    //   155: isub
    //   156: i2l
    //   157: lstore 6
    //   159: lload 4
    //   161: iload_2
    //   162: i2l
    //   163: ladd
    //   164: lstore 4
    //   166: aload 8
    //   168: astore 9
    //   170: aload_1
    //   171: lload 6
    //   173: invokevirtual 45	java/io/InputStream:skip	(J)J
    //   176: lload 6
    //   178: lcmp
    //   179: iflt -163 -> 16
    //   182: aload_1
    //   183: aload 10
    //   185: iconst_0
    //   186: bipush 8
    //   188: invokevirtual 49	java/io/InputStream:read	([BII)I
    //   191: istore_2
    //   192: aload 8
    //   194: astore 9
    //   196: goto -143 -> 53
    //   199: aload 8
    //   201: astore 9
    //   203: lload 6
    //   205: lconst_0
    //   206: lcmp
    //   207: ifle -191 -> 16
    //   210: lload 4
    //   212: lload 6
    //   214: ladd
    //   215: lstore 4
    //   217: lload 6
    //   219: ldc2_w 72
    //   222: lsub
    //   223: ldc2_w 72
    //   226: lsub
    //   227: lstore 6
    //   229: goto -63 -> 166
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 8
    //   236: ldc 31
    //   238: aload_1
    //   239: ldc 75
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 79	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 8
    //   250: areturn
    //   251: astore_1
    //   252: goto -16 -> 236
    //   255: astore_1
    //   256: aload 9
    //   258: astore 8
    //   260: goto -24 -> 236
    //   263: aload 9
    //   265: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	b
    //   0	266	1	paramInputStream	java.io.InputStream
    //   52	140	2	i	int
    //   72	44	3	j	int
    //   35	181	4	l1	long
    //   74	154	6	l2	long
    //   121	138	8	localObject1	Object
    //   14	250	9	localObject2	Object
    //   41	143	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	32	232	java/lang/Exception
    //   37	53	232	java/lang/Exception
    //   127	135	251	java/lang/Exception
    //   139	147	251	java/lang/Exception
    //   170	192	251	java/lang/Exception
    //   59	73	255	java/lang/Exception
    //   81	102	255	java/lang/Exception
    //   102	123	255	java/lang/Exception
  }
  
  /* Error */
  public final long po(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 87	com/tencent/mm/plugin/a/c:bl	(Ljava/lang/String;)Z
    //   4: ifeq +14 -> 18
    //   7: ldc 31
    //   9: ldc 89
    //   11: invokestatic 39	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc2_w 15
    //   17: lreturn
    //   18: new 91	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 11
    //   28: aconst_null
    //   29: astore 9
    //   31: new 96	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: astore 8
    //   41: aload_0
    //   42: aload 11
    //   44: invokevirtual 101	java/io/File:length	()J
    //   47: putfield 22	com/tencent/mm/plugin/a/b:eUd	J
    //   50: aload_0
    //   51: aload 8
    //   53: invokespecial 103	com/tencent/mm/plugin/a/b:s	(Ljava/io/InputStream;)Lcom/tencent/mm/plugin/a/a;
    //   56: astore 9
    //   58: aload 9
    //   60: ifnonnull +102 -> 162
    //   63: ldc 31
    //   65: ldc 105
    //   67: invokestatic 39	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: ldc2_w 15
    //   73: lstore_2
    //   74: ldc2_w 15
    //   77: lstore 4
    //   79: aload 8
    //   81: invokevirtual 108	java/io/InputStream:close	()V
    //   84: lload_2
    //   85: lstore 6
    //   87: aload_0
    //   88: lload 4
    //   90: putfield 18	com/tencent/mm/plugin/a/b:eUb	J
    //   93: aload_0
    //   94: lload 6
    //   96: putfield 20	com/tencent/mm/plugin/a/b:eUc	J
    //   99: ldc 31
    //   101: new 110	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 112
    //   107: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: lload 4
    //   112: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: ldc 119
    //   117: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 20	com/tencent/mm/plugin/a/b:eUc	J
    //   124: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc 124
    //   129: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 11
    //   134: invokevirtual 101	java/io/File:length	()J
    //   137: ldc2_w 125
    //   140: ldiv
    //   141: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: ldc 128
    //   146: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 135	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: lload 4
    //   161: lreturn
    //   162: aload 9
    //   164: invokevirtual 68	com/tencent/mm/plugin/a/a:Vc	()Z
    //   167: ifeq +19 -> 186
    //   170: aload 9
    //   172: getfield 138	com/tencent/mm/plugin/a/a:eUa	J
    //   175: lstore 4
    //   177: aload 9
    //   179: invokevirtual 141	com/tencent/mm/plugin/a/a:getSize	()J
    //   182: lstore_2
    //   183: goto -104 -> 79
    //   186: aload 9
    //   188: invokevirtual 71	com/tencent/mm/plugin/a/a:Vd	()Z
    //   191: ifeq +22 -> 213
    //   194: ldc 31
    //   196: ldc 143
    //   198: invokestatic 39	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: ldc2_w 15
    //   204: lstore_2
    //   205: ldc2_w 15
    //   208: lstore 4
    //   210: goto -131 -> 79
    //   213: aload 9
    //   215: invokevirtual 141	com/tencent/mm/plugin/a/a:getSize	()J
    //   218: lconst_0
    //   219: lcmp
    //   220: ifle +182 -> 402
    //   223: aload 9
    //   225: invokevirtual 146	com/tencent/mm/plugin/a/a:Ve	()J
    //   228: lstore 4
    //   230: ldc2_w 15
    //   233: lstore_2
    //   234: goto -155 -> 79
    //   237: astore 8
    //   239: ldc 31
    //   241: aload 8
    //   243: ldc 75
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 79	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: lload_2
    //   253: lstore 6
    //   255: goto -168 -> 87
    //   258: astore 10
    //   260: ldc2_w 15
    //   263: lstore_2
    //   264: aload 9
    //   266: astore 8
    //   268: aload 10
    //   270: astore 9
    //   272: ldc 31
    //   274: aload 9
    //   276: ldc 75
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 79	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload 8
    //   287: ifnull +104 -> 391
    //   290: aload 8
    //   292: invokevirtual 108	java/io/InputStream:close	()V
    //   295: ldc2_w 15
    //   298: lstore 6
    //   300: lload_2
    //   301: lstore 4
    //   303: goto -216 -> 87
    //   306: astore 8
    //   308: ldc 31
    //   310: aload 8
    //   312: ldc 75
    //   314: iconst_0
    //   315: anewarray 4	java/lang/Object
    //   318: invokestatic 79	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: ldc2_w 15
    //   324: lstore 6
    //   326: lload_2
    //   327: lstore 4
    //   329: goto -242 -> 87
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 8
    //   336: aload 8
    //   338: ifnull +8 -> 346
    //   341: aload 8
    //   343: invokevirtual 108	java/io/InputStream:close	()V
    //   346: aload_1
    //   347: athrow
    //   348: astore 8
    //   350: ldc 31
    //   352: aload 8
    //   354: ldc 75
    //   356: iconst_0
    //   357: anewarray 4	java/lang/Object
    //   360: invokestatic 79	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   363: goto -17 -> 346
    //   366: astore_1
    //   367: goto -31 -> 336
    //   370: astore_1
    //   371: goto -35 -> 336
    //   374: astore 9
    //   376: ldc2_w 15
    //   379: lstore_2
    //   380: goto -108 -> 272
    //   383: astore 9
    //   385: lload 4
    //   387: lstore_2
    //   388: goto -116 -> 272
    //   391: ldc2_w 15
    //   394: lstore 6
    //   396: lload_2
    //   397: lstore 4
    //   399: goto -312 -> 87
    //   402: ldc2_w 15
    //   405: lstore_2
    //   406: ldc2_w 15
    //   409: lstore 4
    //   411: goto -332 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	b
    //   0	414	1	paramString	java.lang.String
    //   73	333	2	l1	long
    //   77	333	4	l2	long
    //   85	310	6	l3	long
    //   39	41	8	localFileInputStream	java.io.FileInputStream
    //   237	5	8	localIOException1	java.io.IOException
    //   266	25	8	localObject1	Object
    //   306	5	8	localIOException2	java.io.IOException
    //   334	8	8	localObject2	Object
    //   348	5	8	localIOException3	java.io.IOException
    //   29	246	9	localObject3	Object
    //   374	1	9	localException1	java.lang.Exception
    //   383	1	9	localException2	java.lang.Exception
    //   258	11	10	localException3	java.lang.Exception
    //   26	107	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   79	84	237	java/io/IOException
    //   31	41	258	java/lang/Exception
    //   290	295	306	java/io/IOException
    //   31	41	332	finally
    //   341	346	348	java/io/IOException
    //   41	58	366	finally
    //   63	70	366	finally
    //   162	177	366	finally
    //   177	183	366	finally
    //   186	201	366	finally
    //   213	230	366	finally
    //   272	285	370	finally
    //   41	58	374	java/lang/Exception
    //   63	70	374	java/lang/Exception
    //   162	177	374	java/lang/Exception
    //   186	201	374	java/lang/Exception
    //   213	230	374	java/lang/Exception
    //   177	183	383	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */