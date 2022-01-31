package com.tencent.mm.plugin.appbrand.appstorage;

final class q$11
  implements q.a
{
  q$11(q paramq) {}
  
  /* Error */
  public final h a(java.io.File paramFile, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 28	com/tencent/mm/plugin/appbrand/appstorage/i:w	(Ljava/io/File;)Z
    //   4: ifeq +7 -> 11
    //   7: getstatic 34	com/tencent/mm/plugin/appbrand/appstorage/h:fHe	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   10: areturn
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: checkcast 36	java/io/InputStream
    //   17: astore 6
    //   19: aload_2
    //   20: iconst_1
    //   21: aaload
    //   22: checkcast 38	java/lang/Boolean
    //   25: invokevirtual 42	java/lang/Boolean:booleanValue	()Z
    //   28: istore 4
    //   30: aload 6
    //   32: instanceof 44
    //   35: ifeq +65 -> 100
    //   38: aload 6
    //   40: checkcast 44	java/util/zip/ZipInputStream
    //   43: aload_1
    //   44: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokestatic 53	com/tencent/mm/plugin/appbrand/appstorage/i:a	(Ljava/util/zip/ZipInputStream;Ljava/lang/String;)I
    //   50: ifne +46 -> 96
    //   53: aload_0
    //   54: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   57: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/q:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifle +30 -> 92
    //   65: aload_0
    //   66: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   69: invokestatic 60	com/tencent/mm/plugin/appbrand/appstorage/q:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   72: aload_0
    //   73: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   76: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/q:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   79: lcmp
    //   80: ifle +12 -> 92
    //   83: aload_1
    //   84: invokevirtual 63	java/io/File:delete	()Z
    //   87: pop
    //   88: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/h:fHh	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   91: areturn
    //   92: getstatic 69	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   95: areturn
    //   96: getstatic 72	com/tencent/mm/plugin/appbrand/appstorage/h:fGV	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   99: areturn
    //   100: aload_1
    //   101: invokevirtual 75	java/io/File:isDirectory	()Z
    //   104: ifeq +7 -> 111
    //   107: getstatic 78	com/tencent/mm/plugin/appbrand/appstorage/h:fGZ	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   110: areturn
    //   111: aload_0
    //   112: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   115: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/q:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   118: lconst_0
    //   119: lcmp
    //   120: ifle +54 -> 174
    //   123: aload 6
    //   125: invokevirtual 82	java/io/InputStream:available	()I
    //   128: istore_3
    //   129: iload_3
    //   130: i2l
    //   131: aload_0
    //   132: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   135: invokestatic 60	com/tencent/mm/plugin/appbrand/appstorage/q:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   138: ladd
    //   139: aload_0
    //   140: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/q$11:fHF	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   143: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/q:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/q;)J
    //   146: lcmp
    //   147: ifle +27 -> 174
    //   150: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/h:fHh	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   153: areturn
    //   154: astore_1
    //   155: ldc 84
    //   157: ldc 86
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: invokestatic 92	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: getstatic 72	com/tencent/mm/plugin/appbrand/appstorage/h:fGV	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   173: areturn
    //   174: new 94	java/io/FileOutputStream
    //   177: dup
    //   178: aload_1
    //   179: iload 4
    //   181: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   184: astore_2
    //   185: aload_2
    //   186: astore_1
    //   187: sipush 4096
    //   190: newarray byte
    //   192: astore 5
    //   194: aload_2
    //   195: astore_1
    //   196: aload 6
    //   198: aload 5
    //   200: iconst_0
    //   201: sipush 4096
    //   204: invokevirtual 101	java/io/InputStream:read	([BII)I
    //   207: istore_3
    //   208: iload_3
    //   209: iconst_m1
    //   210: if_icmpeq +55 -> 265
    //   213: aload_2
    //   214: astore_1
    //   215: aload_2
    //   216: aload 5
    //   218: iconst_0
    //   219: iload_3
    //   220: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   223: goto -29 -> 194
    //   226: astore 5
    //   228: aload_2
    //   229: astore_1
    //   230: ldc 84
    //   232: ldc 107
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 5
    //   242: aastore
    //   243: invokestatic 110	com/tencent/luggage/j/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_2
    //   247: astore_1
    //   248: getstatic 72	com/tencent/mm/plugin/appbrand/appstorage/h:fGV	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   251: astore 5
    //   253: aload_2
    //   254: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   257: aload 6
    //   259: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   262: aload 5
    //   264: areturn
    //   265: aload_2
    //   266: astore_1
    //   267: aload_2
    //   268: invokevirtual 118	java/io/FileOutputStream:flush	()V
    //   271: aload_2
    //   272: astore_1
    //   273: getstatic 69	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   276: astore 5
    //   278: aload_2
    //   279: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   282: aload 6
    //   284: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   287: aload 5
    //   289: areturn
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_1
    //   294: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   297: aload 6
    //   299: invokestatic 115	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   302: aload_2
    //   303: athrow
    //   304: astore_2
    //   305: goto -12 -> 293
    //   308: astore 5
    //   310: aconst_null
    //   311: astore_2
    //   312: goto -84 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	11
    //   0	315	1	paramFile	java.io.File
    //   0	315	2	paramVarArgs	Object[]
    //   128	92	3	i	int
    //   28	152	4	bool	boolean
    //   192	25	5	arrayOfByte	byte[]
    //   226	15	5	localException1	java.lang.Exception
    //   251	37	5	localh	h
    //   308	1	5	localException2	java.lang.Exception
    //   17	281	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   123	129	154	java/lang/Exception
    //   187	194	226	java/lang/Exception
    //   196	208	226	java/lang/Exception
    //   215	223	226	java/lang/Exception
    //   267	271	226	java/lang/Exception
    //   273	278	226	java/lang/Exception
    //   174	185	290	finally
    //   187	194	304	finally
    //   196	208	304	finally
    //   215	223	304	finally
    //   230	246	304	finally
    //   248	253	304	finally
    //   267	271	304	finally
    //   273	278	304	finally
    //   174	185	308	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.11
 * JD-Core Version:    0.7.0.1
 */