package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import java.util.Map;

public final class l
{
  private static l epL = null;
  private boolean epJ;
  boolean epK;
  private String filePath;
  private Map<Integer, Object> values;
  
  /* Error */
  private l(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: ldc 28
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 36	com/tencent/mm/compatible/e/l:epJ	Z
    //   14: aload_0
    //   15: ldc 38
    //   17: putfield 40	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 42	com/tencent/mm/compatible/e/l:epK	Z
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 40	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   30: new 44	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   38: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 50	java/io/File:exists	()Z
    //   46: ifne +13 -> 59
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 42	com/tencent/mm/compatible/e/l:epK	Z
    //   54: aload_1
    //   55: invokevirtual 53	java/io/File:createNewFile	()Z
    //   58: pop
    //   59: aload_1
    //   60: invokevirtual 57	java/io/File:length	()J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifne +30 -> 95
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 42	com/tencent/mm/compatible/e/l:epK	Z
    //   73: aload_0
    //   74: new 59	java/util/HashMap
    //   77: dup
    //   78: invokespecial 60	java/util/HashMap:<init>	()V
    //   81: putfield 62	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 36	com/tencent/mm/compatible/e/l:epJ	Z
    //   89: ldc 28
    //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: new 67	java/io/FileInputStream
    //   98: dup
    //   99: aload_1
    //   100: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   103: astore_2
    //   104: new 72	java/io/ObjectInputStream
    //   107: dup
    //   108: aload_2
    //   109: invokespecial 75	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   112: astore_1
    //   113: aload_1
    //   114: astore 4
    //   116: aload_2
    //   117: astore_3
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 79	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   123: checkcast 81	java/util/Map
    //   126: putfield 62	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   129: aload_1
    //   130: astore 4
    //   132: aload_2
    //   133: astore_3
    //   134: aload_1
    //   135: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: astore_3
    //   143: aload_2
    //   144: invokevirtual 85	java/io/FileInputStream:close	()V
    //   147: aload_2
    //   148: invokevirtual 85	java/io/FileInputStream:close	()V
    //   151: aload_1
    //   152: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   155: goto -71 -> 84
    //   158: astore_1
    //   159: ldc 87
    //   161: aload_1
    //   162: ldc 38
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -87 -> 84
    //   174: astore_2
    //   175: ldc 87
    //   177: aload_2
    //   178: ldc 38
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -36 -> 151
    //   190: astore 5
    //   192: aconst_null
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_1
    //   197: astore 4
    //   199: aload_2
    //   200: astore_3
    //   201: aload_0
    //   202: new 59	java/util/HashMap
    //   205: dup
    //   206: invokespecial 60	java/util/HashMap:<init>	()V
    //   209: putfield 62	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   212: aload_1
    //   213: astore 4
    //   215: aload_2
    //   216: astore_3
    //   217: ldc 87
    //   219: aload 5
    //   221: ldc 38
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 85	java/io/FileInputStream:close	()V
    //   238: aload_1
    //   239: ifnull -155 -> 84
    //   242: aload_1
    //   243: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   246: goto -162 -> 84
    //   249: astore_1
    //   250: ldc 87
    //   252: aload_1
    //   253: ldc 38
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -178 -> 84
    //   265: astore_2
    //   266: ldc 87
    //   268: aload_2
    //   269: ldc 38
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -40 -> 238
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_2
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 85	java/io/FileInputStream:close	()V
    //   295: aload 4
    //   297: ifnull +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   305: ldc 28
    //   307: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload_1
    //   311: athrow
    //   312: astore_2
    //   313: ldc 87
    //   315: aload_2
    //   316: ldc 38
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -30 -> 295
    //   328: astore_2
    //   329: ldc 87
    //   331: aload_2
    //   332: ldc 38
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: goto -36 -> 305
    //   344: astore_1
    //   345: aconst_null
    //   346: astore 4
    //   348: goto -61 -> 287
    //   351: astore_1
    //   352: aload_3
    //   353: astore_2
    //   354: goto -67 -> 287
    //   357: astore 5
    //   359: aconst_null
    //   360: astore_1
    //   361: goto -165 -> 196
    //   364: astore 5
    //   366: goto -170 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	l
    //   0	369	1	paramString	String
    //   103	45	2	localFileInputStream	java.io.FileInputStream
    //   174	4	2	localIOException1	java.io.IOException
    //   195	40	2	localObject1	Object
    //   265	4	2	localIOException2	java.io.IOException
    //   286	6	2	localObject2	Object
    //   312	4	2	localIOException3	java.io.IOException
    //   328	4	2	localIOException4	java.io.IOException
    //   353	1	2	localObject3	Object
    //   117	236	3	localObject4	Object
    //   114	233	4	str	String
    //   190	30	5	localException1	java.lang.Exception
    //   357	1	5	localException2	java.lang.Exception
    //   364	1	5	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   151	155	158	java/io/IOException
    //   147	151	174	java/io/IOException
    //   30	59	190	java/lang/Exception
    //   59	84	190	java/lang/Exception
    //   95	104	190	java/lang/Exception
    //   242	246	249	java/io/IOException
    //   234	238	265	java/io/IOException
    //   30	59	281	finally
    //   59	84	281	finally
    //   95	104	281	finally
    //   291	295	312	java/io/IOException
    //   300	305	328	java/io/IOException
    //   104	113	344	finally
    //   118	129	351	finally
    //   134	138	351	finally
    //   143	147	351	finally
    //   201	212	351	finally
    //   217	230	351	finally
    //   104	113	357	java/lang/Exception
    //   118	129	364	java/lang/Exception
    //   134	138	364	java/lang/Exception
    //   143	147	364	java/lang/Exception
  }
  
  public static l Lm()
  {
    try
    {
      AppMethodBeat.i(92935);
      if (epL == null) {
        epL = new l(e.eQv + "CompatibleInfo.cfg");
      }
      l locall = epL;
      AppMethodBeat.o(92935);
      return locall;
    }
    finally {}
  }
  
  /* Error */
  private void Ln()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 119	java/io/FileOutputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   15: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: new 122	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 125	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore 4
    //   31: aload_2
    //   32: astore_3
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 62	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   38: invokevirtual 129	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload_1
    //   42: astore 4
    //   44: aload_2
    //   45: astore_3
    //   46: aload_1
    //   47: invokevirtual 130	java/io/ObjectOutputStream:close	()V
    //   50: aload_1
    //   51: astore 4
    //   53: aload_2
    //   54: astore_3
    //   55: aload_2
    //   56: invokevirtual 133	java/io/FileOutputStream:flush	()V
    //   59: aload_1
    //   60: astore 4
    //   62: aload_2
    //   63: astore_3
    //   64: aload_2
    //   65: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   68: aload_2
    //   69: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   72: aload_1
    //   73: invokevirtual 130	java/io/ObjectOutputStream:close	()V
    //   76: ldc 117
    //   78: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_2
    //   85: ldc 87
    //   87: aload_2
    //   88: ldc 38
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: goto -25 -> 72
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: ldc 87
    //   108: aload_1
    //   109: ldc 38
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: ldc 117
    //   120: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -42 -> 81
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_1
    //   133: astore 4
    //   135: aload_2
    //   136: astore_3
    //   137: ldc 87
    //   139: aload 5
    //   141: ldc 38
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   158: aload_1
    //   159: ifnull +115 -> 274
    //   162: aload_1
    //   163: invokevirtual 130	java/io/ObjectOutputStream:close	()V
    //   166: ldc 117
    //   168: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: goto -90 -> 81
    //   174: astore_2
    //   175: ldc 87
    //   177: aload_2
    //   178: ldc 38
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -29 -> 158
    //   190: astore_1
    //   191: ldc 87
    //   193: aload_1
    //   194: ldc 38
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: ldc 117
    //   205: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: goto -127 -> 81
    //   211: astore_1
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 130	java/io/ObjectOutputStream:close	()V
    //   235: ldc 117
    //   237: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_2
    //   243: ldc 87
    //   245: aload_2
    //   246: ldc 38
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: goto -30 -> 225
    //   258: astore_2
    //   259: ldc 87
    //   261: aload_2
    //   262: ldc 38
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -36 -> 235
    //   274: ldc 117
    //   276: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: goto -198 -> 81
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 4
    //   286: goto -69 -> 217
    //   289: astore_1
    //   290: aload_3
    //   291: astore_2
    //   292: goto -75 -> 217
    //   295: astore 5
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -167 -> 132
    //   302: astore 5
    //   304: goto -172 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	l
    //   27	46	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   100	4	1	localObject1	Object
    //   105	4	1	localIOException1	java.io.IOException
    //   129	34	1	localObject2	Object
    //   190	4	1	localIOException2	java.io.IOException
    //   211	30	1	localObject3	Object
    //   282	1	1	localObject4	Object
    //   289	1	1	localObject5	Object
    //   298	1	1	localObject6	Object
    //   18	51	2	localFileOutputStream	java.io.FileOutputStream
    //   84	4	2	localIOException3	java.io.IOException
    //   131	24	2	localObject7	Object
    //   174	4	2	localIOException4	java.io.IOException
    //   216	6	2	localObject8	Object
    //   242	4	2	localIOException5	java.io.IOException
    //   258	4	2	localIOException6	java.io.IOException
    //   291	1	2	localObject9	Object
    //   32	259	3	localObject10	Object
    //   29	256	4	localObject11	Object
    //   126	14	5	localIOException7	java.io.IOException
    //   295	1	5	localIOException8	java.io.IOException
    //   302	1	5	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   68	72	84	java/io/IOException
    //   2	7	100	finally
    //   68	72	100	finally
    //   72	76	100	finally
    //   76	81	100	finally
    //   85	97	100	finally
    //   106	123	100	finally
    //   154	158	100	finally
    //   162	166	100	finally
    //   166	171	100	finally
    //   175	187	100	finally
    //   191	208	100	finally
    //   221	225	100	finally
    //   230	235	100	finally
    //   235	242	100	finally
    //   243	255	100	finally
    //   259	271	100	finally
    //   274	279	100	finally
    //   72	76	105	java/io/IOException
    //   7	19	126	java/io/IOException
    //   154	158	174	java/io/IOException
    //   162	166	190	java/io/IOException
    //   7	19	211	finally
    //   221	225	242	java/io/IOException
    //   230	235	258	java/io/IOException
    //   19	28	282	finally
    //   33	41	289	finally
    //   46	50	289	finally
    //   55	59	289	finally
    //   64	68	289	finally
    //   137	150	289	finally
    //   19	28	295	java/io/IOException
    //   33	41	302	java/io/IOException
    //   46	50	302	java/io/IOException
    //   55	59	302	java/io/IOException
    //   64	68	302	java/io/IOException
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(92938);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(92938);
    return localObject;
  }
  
  public final Object iN(int paramInt)
  {
    AppMethodBeat.i(92939);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(92939);
      return null;
    }
    AppMethodBeat.o(92939);
    return localObject;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(92937);
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.epJ) {
        Ln();
      }
      AppMethodBeat.o(92937);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.l
 * JD-Core Version:    0.7.0.1
 */