package com.tencent.mm.plugin.appbrand.appstorage;

final class w$11
  implements w.a
{
  w$11(w paramw) {}
  
  /* Error */
  public final j a(java.io.File paramFile, Object... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 35	com/tencent/mm/plugin/appbrand/appstorage/k:C	(Ljava/io/File;)Z
    //   9: ifeq +14 -> 23
    //   12: getstatic 41	com/tencent/mm/plugin/appbrand/appstorage/j:gZK	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   15: astore_1
    //   16: ldc 23
    //   18: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_1
    //   22: areturn
    //   23: aload_2
    //   24: iconst_0
    //   25: aaload
    //   26: checkcast 46	java/io/InputStream
    //   29: astore 6
    //   31: aload_2
    //   32: iconst_1
    //   33: aaload
    //   34: checkcast 48	java/lang/Boolean
    //   37: invokevirtual 52	java/lang/Boolean:booleanValue	()Z
    //   40: istore 4
    //   42: aload 6
    //   44: instanceof 54
    //   47: ifeq +86 -> 133
    //   50: aload 6
    //   52: checkcast 54	java/util/zip/ZipInputStream
    //   55: aload_1
    //   56: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokestatic 63	com/tencent/mm/plugin/appbrand/appstorage/k:a	(Ljava/util/zip/ZipInputStream;Ljava/lang/String;)I
    //   62: ifne +60 -> 122
    //   65: aload_0
    //   66: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   69: getfield 67	com/tencent/mm/plugin/appbrand/appstorage/w:hak	J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifle +37 -> 111
    //   77: aload_0
    //   78: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   81: invokestatic 70	com/tencent/mm/plugin/appbrand/appstorage/w:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/w;)J
    //   84: aload_0
    //   85: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   88: getfield 67	com/tencent/mm/plugin/appbrand/appstorage/w:hak	J
    //   91: lcmp
    //   92: ifle +19 -> 111
    //   95: aload_1
    //   96: invokevirtual 73	java/io/File:delete	()Z
    //   99: pop
    //   100: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/j:gZN	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   103: astore_1
    //   104: ldc 23
    //   106: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: areturn
    //   111: getstatic 79	com/tencent/mm/plugin/appbrand/appstorage/j:gZA	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   114: astore_1
    //   115: ldc 23
    //   117: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: areturn
    //   122: getstatic 82	com/tencent/mm/plugin/appbrand/appstorage/j:gZB	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   125: astore_1
    //   126: ldc 23
    //   128: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: areturn
    //   133: aload_1
    //   134: invokevirtual 85	java/io/File:isDirectory	()Z
    //   137: ifeq +14 -> 151
    //   140: getstatic 88	com/tencent/mm/plugin/appbrand/appstorage/j:gZF	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   143: astore_1
    //   144: ldc 23
    //   146: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: areturn
    //   151: aload_0
    //   152: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   155: getfield 67	com/tencent/mm/plugin/appbrand/appstorage/w:hak	J
    //   158: lconst_0
    //   159: lcmp
    //   160: ifle +68 -> 228
    //   163: aload 6
    //   165: invokevirtual 92	java/io/InputStream:available	()I
    //   168: istore_3
    //   169: iload_3
    //   170: i2l
    //   171: aload_0
    //   172: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   175: invokestatic 70	com/tencent/mm/plugin/appbrand/appstorage/w:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/w;)J
    //   178: ladd
    //   179: aload_0
    //   180: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/w$11:hay	Lcom/tencent/mm/plugin/appbrand/appstorage/w;
    //   183: getfield 67	com/tencent/mm/plugin/appbrand/appstorage/w:hak	J
    //   186: lcmp
    //   187: ifle +41 -> 228
    //   190: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/j:gZN	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   193: astore_1
    //   194: ldc 23
    //   196: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_1
    //   200: areturn
    //   201: astore_1
    //   202: ldc 94
    //   204: ldc 96
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_1
    //   213: aastore
    //   214: invokestatic 102	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: getstatic 82	com/tencent/mm/plugin/appbrand/appstorage/j:gZB	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   220: astore_1
    //   221: ldc 23
    //   223: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: areturn
    //   228: aload_1
    //   229: invokevirtual 105	java/io/File:exists	()Z
    //   232: ifne +19 -> 251
    //   235: iload 4
    //   237: ifeq +14 -> 251
    //   240: getstatic 108	com/tencent/mm/plugin/appbrand/appstorage/j:gZG	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   243: astore_1
    //   244: ldc 23
    //   246: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_1
    //   250: areturn
    //   251: new 110	java/io/FileOutputStream
    //   254: dup
    //   255: aload_1
    //   256: iload 4
    //   258: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   261: astore_2
    //   262: aload_2
    //   263: astore_1
    //   264: sipush 4096
    //   267: newarray byte
    //   269: astore 5
    //   271: aload_2
    //   272: astore_1
    //   273: aload 6
    //   275: aload 5
    //   277: iconst_0
    //   278: sipush 4096
    //   281: invokevirtual 117	java/io/InputStream:read	([BII)I
    //   284: istore_3
    //   285: iload_3
    //   286: iconst_m1
    //   287: if_icmpeq +60 -> 347
    //   290: aload_2
    //   291: astore_1
    //   292: aload_2
    //   293: aload 5
    //   295: iconst_0
    //   296: iload_3
    //   297: invokevirtual 121	java/io/FileOutputStream:write	([BII)V
    //   300: goto -29 -> 271
    //   303: astore 5
    //   305: aload_2
    //   306: astore_1
    //   307: ldc 94
    //   309: ldc 123
    //   311: iconst_1
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 5
    //   319: aastore
    //   320: invokestatic 125	com/tencent/luggage/g/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload_2
    //   324: astore_1
    //   325: getstatic 82	com/tencent/mm/plugin/appbrand/appstorage/j:gZB	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   328: astore 5
    //   330: aload_2
    //   331: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   334: aload 6
    //   336: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   339: ldc 23
    //   341: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload 5
    //   346: areturn
    //   347: aload_2
    //   348: astore_1
    //   349: aload_2
    //   350: invokevirtual 134	java/io/FileOutputStream:flush	()V
    //   353: aload_2
    //   354: astore_1
    //   355: getstatic 79	com/tencent/mm/plugin/appbrand/appstorage/j:gZA	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   358: astore 5
    //   360: aload_2
    //   361: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   364: aload 6
    //   366: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   369: ldc 23
    //   371: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload 5
    //   376: areturn
    //   377: astore_2
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_1
    //   381: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   384: aload 6
    //   386: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   389: ldc 23
    //   391: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_2
    //   395: athrow
    //   396: astore_2
    //   397: goto -17 -> 380
    //   400: astore 5
    //   402: aconst_null
    //   403: astore_2
    //   404: goto -99 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	11
    //   0	407	1	paramFile	java.io.File
    //   0	407	2	paramVarArgs	Object[]
    //   168	129	3	i	int
    //   40	217	4	bool	boolean
    //   269	25	5	arrayOfByte	byte[]
    //   303	15	5	localException1	java.lang.Exception
    //   328	47	5	localj	j
    //   400	1	5	localException2	java.lang.Exception
    //   29	356	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   163	169	201	java/lang/Exception
    //   264	271	303	java/lang/Exception
    //   273	285	303	java/lang/Exception
    //   292	300	303	java/lang/Exception
    //   349	353	303	java/lang/Exception
    //   355	360	303	java/lang/Exception
    //   251	262	377	finally
    //   264	271	396	finally
    //   273	285	396	finally
    //   292	300	396	finally
    //   307	323	396	finally
    //   325	330	396	finally
    //   349	353	396	finally
    //   355	360	396	finally
    //   251	262	400	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.11
 * JD-Core Version:    0.7.0.1
 */