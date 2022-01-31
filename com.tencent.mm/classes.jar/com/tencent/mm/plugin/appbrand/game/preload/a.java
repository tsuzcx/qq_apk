package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final String fqs;
  
  static
  {
    AppMethodBeat.i(130286);
    fqs = b.aAM();
    AppMethodBeat.o(130286);
  }
  
  public static a aAL()
  {
    return a.b.htT;
  }
  
  /* Error */
  public static void bX(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 56
    //   18: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: ldc 61
    //   28: ldc 63
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload 6
    //   38: aastore
    //   39: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 70	java/io/BufferedInputStream
    //   45: dup
    //   46: new 72	java/net/URL
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 79	java/net/URL:openStream	()Ljava/io/InputStream;
    //   57: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +348 -> 412
    //   67: new 84	java/io/FileOutputStream
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   76: astore_3
    //   77: aload_3
    //   78: astore_1
    //   79: sipush 1024
    //   82: newarray byte
    //   84: astore 5
    //   86: aload_3
    //   87: astore_1
    //   88: aload 4
    //   90: aload 5
    //   92: invokevirtual 91	java/io/InputStream:read	([B)I
    //   95: istore_2
    //   96: iload_2
    //   97: iconst_m1
    //   98: if_icmpeq +107 -> 205
    //   101: aload_3
    //   102: astore_1
    //   103: aload_3
    //   104: aload 5
    //   106: iconst_0
    //   107: iload_2
    //   108: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   111: goto -25 -> 86
    //   114: astore 5
    //   116: aload_3
    //   117: astore_1
    //   118: ldc 61
    //   120: aload 5
    //   122: ldc 97
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 105	java/io/InputStream:close	()V
    //   149: new 107	java/io/File
    //   152: dup
    //   153: aload 6
    //   155: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: new 107	java/io/File
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 112	java/io/File:renameTo	(Ljava/io/File;)Z
    //   169: pop
    //   170: ldc 47
    //   172: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: astore_3
    //   177: ldc 61
    //   179: ldc 114
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_3
    //   192: invokevirtual 115	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 118	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aconst_null
    //   200: astore 4
    //   202: goto -140 -> 62
    //   205: aload_3
    //   206: astore_1
    //   207: aload_3
    //   208: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 105	java/io/InputStream:close	()V
    //   229: new 107	java/io/File
    //   232: dup
    //   233: aload 6
    //   235: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   238: new 107	java/io/File
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 112	java/io/File:renameTo	(Ljava/io/File;)Z
    //   249: pop
    //   250: ldc 47
    //   252: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: return
    //   256: astore_1
    //   257: ldc 61
    //   259: aload_1
    //   260: ldc 97
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -50 -> 219
    //   272: astore_1
    //   273: ldc 61
    //   275: aload_1
    //   276: ldc 97
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: goto -56 -> 229
    //   288: astore_1
    //   289: ldc 61
    //   291: aload_1
    //   292: ldc 97
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: goto -162 -> 139
    //   304: astore_1
    //   305: ldc 61
    //   307: aload_1
    //   308: ldc 97
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: goto -168 -> 149
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_1
    //   324: ifnull +7 -> 331
    //   327: aload_1
    //   328: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   331: aload 4
    //   333: ifnull +8 -> 341
    //   336: aload 4
    //   338: invokevirtual 105	java/io/InputStream:close	()V
    //   341: new 107	java/io/File
    //   344: dup
    //   345: aload 6
    //   347: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   350: new 107	java/io/File
    //   353: dup
    //   354: aload_0
    //   355: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   358: invokevirtual 112	java/io/File:renameTo	(Ljava/io/File;)Z
    //   361: pop
    //   362: ldc 47
    //   364: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_3
    //   368: athrow
    //   369: astore_1
    //   370: ldc 61
    //   372: aload_1
    //   373: ldc 97
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: goto -51 -> 331
    //   385: astore_1
    //   386: ldc 61
    //   388: aload_1
    //   389: ldc 97
    //   391: iconst_0
    //   392: anewarray 4	java/lang/Object
    //   395: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: goto -57 -> 341
    //   401: astore_3
    //   402: goto -79 -> 323
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_3
    //   409: goto -293 -> 116
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -203 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramString1	String
    //   0	417	1	paramString2	String
    //   95	13	2	i	int
    //   76	60	3	localFileOutputStream	java.io.FileOutputStream
    //   176	40	3	localException	java.lang.Exception
    //   320	48	3	localObject1	Object
    //   401	1	3	localObject2	Object
    //   408	6	3	localObject3	Object
    //   60	277	4	localBufferedInputStream	java.io.BufferedInputStream
    //   84	21	5	arrayOfByte	byte[]
    //   114	7	5	localIOException1	java.io.IOException
    //   405	1	5	localIOException2	java.io.IOException
    //   24	322	6	str	String
    // Exception table:
    //   from	to	target	type
    //   79	86	114	java/io/IOException
    //   88	96	114	java/io/IOException
    //   103	111	114	java/io/IOException
    //   207	211	114	java/io/IOException
    //   42	62	176	java/lang/Exception
    //   215	219	256	java/io/IOException
    //   224	229	272	java/io/IOException
    //   135	139	288	java/io/IOException
    //   144	149	304	java/io/IOException
    //   67	77	320	finally
    //   327	331	369	java/io/IOException
    //   336	341	385	java/io/IOException
    //   79	86	401	finally
    //   88	96	401	finally
    //   103	111	401	finally
    //   118	131	401	finally
    //   207	211	401	finally
    //   67	77	405	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.a
 * JD-Core Version:    0.7.0.1
 */