package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Map;

public final class l
{
  private static l jsh = null;
  private String filePath;
  private boolean jsf;
  boolean jsg;
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
    //   11: putfield 36	com/tencent/mm/compatible/deviceinfo/l:jsf	Z
    //   14: aload_0
    //   15: ldc 38
    //   17: putfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 42	com/tencent/mm/compatible/deviceinfo/l:jsg	Z
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   30: new 44	com/tencent/mm/vfs/q
    //   33: dup
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   38: invokespecial 46	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 50	com/tencent/mm/vfs/q:ifE	()Z
    //   46: ifne +13 -> 59
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 42	com/tencent/mm/compatible/deviceinfo/l:jsg	Z
    //   54: aload_1
    //   55: invokevirtual 53	com/tencent/mm/vfs/q:ifM	()Z
    //   58: pop
    //   59: aload_1
    //   60: invokevirtual 57	com/tencent/mm/vfs/q:length	()J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifne +30 -> 95
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 42	com/tencent/mm/compatible/deviceinfo/l:jsg	Z
    //   73: aload_0
    //   74: new 59	java/util/HashMap
    //   77: dup
    //   78: invokespecial 60	java/util/HashMap:<init>	()V
    //   81: putfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 36	com/tencent/mm/compatible/deviceinfo/l:jsf	Z
    //   89: ldc 28
    //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_1
    //   96: invokestatic 71	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   99: astore_1
    //   100: new 73	java/io/ObjectInputStream
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 76	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore_2
    //   109: aload_2
    //   110: astore 4
    //   112: aload_1
    //   113: astore_3
    //   114: aload_0
    //   115: aload_2
    //   116: invokevirtual 80	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   119: checkcast 82	java/util/Map
    //   122: putfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   125: aload_2
    //   126: astore 4
    //   128: aload_1
    //   129: astore_3
    //   130: aload_2
    //   131: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   134: aload_2
    //   135: astore 4
    //   137: aload_1
    //   138: astore_3
    //   139: aload_1
    //   140: invokevirtual 88	java/io/InputStream:close	()V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 88	java/io/InputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   155: goto -71 -> 84
    //   158: astore_1
    //   159: ldc 90
    //   161: aload_1
    //   162: ldc 38
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -87 -> 84
    //   174: astore_1
    //   175: ldc 90
    //   177: aload_1
    //   178: ldc 38
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -36 -> 151
    //   190: astore 5
    //   192: aconst_null
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_2
    //   197: astore 4
    //   199: aload_1
    //   200: astore_3
    //   201: aload_0
    //   202: new 59	java/util/HashMap
    //   205: dup
    //   206: invokespecial 60	java/util/HashMap:<init>	()V
    //   209: putfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   212: aload_2
    //   213: astore 4
    //   215: aload_1
    //   216: astore_3
    //   217: ldc 90
    //   219: aload 5
    //   221: ldc 38
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 88	java/io/InputStream:close	()V
    //   238: aload_2
    //   239: ifnull -155 -> 84
    //   242: aload_2
    //   243: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   246: goto -162 -> 84
    //   249: astore_1
    //   250: ldc 90
    //   252: aload_1
    //   253: ldc 38
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -178 -> 84
    //   265: astore_1
    //   266: ldc 90
    //   268: aload_1
    //   269: ldc 38
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -40 -> 238
    //   281: astore_2
    //   282: aconst_null
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_1
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 88	java/io/InputStream:close	()V
    //   295: aload 4
    //   297: ifnull +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   305: ldc 28
    //   307: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload_2
    //   311: athrow
    //   312: astore_1
    //   313: ldc 90
    //   315: aload_1
    //   316: ldc 38
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -30 -> 295
    //   328: astore_1
    //   329: ldc 90
    //   331: aload_1
    //   332: ldc 38
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: goto -36 -> 305
    //   344: astore_2
    //   345: aconst_null
    //   346: astore 4
    //   348: goto -61 -> 287
    //   351: astore_2
    //   352: aload_3
    //   353: astore_1
    //   354: goto -67 -> 287
    //   357: astore 5
    //   359: aconst_null
    //   360: astore_2
    //   361: goto -165 -> 196
    //   364: astore 5
    //   366: goto -170 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	l
    //   0	369	1	paramString	String
    //   108	135	2	localObjectInputStream1	java.io.ObjectInputStream
    //   281	30	2	localObject1	Object
    //   344	1	2	localObject2	Object
    //   351	1	2	localObject3	Object
    //   360	1	2	localObject4	Object
    //   113	240	3	str	String
    //   110	237	4	localObjectInputStream2	java.io.ObjectInputStream
    //   190	30	5	localException1	java.lang.Exception
    //   357	1	5	localException2	java.lang.Exception
    //   364	1	5	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   151	155	158	java/io/IOException
    //   147	151	174	java/io/IOException
    //   30	59	190	java/lang/Exception
    //   59	84	190	java/lang/Exception
    //   95	100	190	java/lang/Exception
    //   242	246	249	java/io/IOException
    //   234	238	265	java/io/IOException
    //   30	59	281	finally
    //   59	84	281	finally
    //   95	100	281	finally
    //   291	295	312	java/io/IOException
    //   300	305	328	java/io/IOException
    //   100	109	344	finally
    //   114	125	351	finally
    //   130	134	351	finally
    //   139	143	351	finally
    //   201	212	351	finally
    //   217	230	351	finally
    //   100	109	357	java/lang/Exception
    //   114	125	364	java/lang/Exception
    //   130	134	364	java/lang/Exception
    //   139	143	364	java/lang/Exception
  }
  
  public static l auq()
  {
    try
    {
      AppMethodBeat.i(155656);
      if (jsh == null) {
        jsh = new l(b.aSD() + "CompatibleInfo.cfg");
      }
      l locall = jsh;
      AppMethodBeat.o(155656);
      return locall;
    }
    finally {}
  }
  
  /* Error */
  private void aur()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 120
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   11: invokestatic 124	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   14: astore_1
    //   15: new 126	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 129	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore 4
    //   27: aload_1
    //   28: astore_3
    //   29: aload_2
    //   30: aload_0
    //   31: getfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   34: invokevirtual 133	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   37: aload_2
    //   38: astore 4
    //   40: aload_1
    //   41: astore_3
    //   42: aload_2
    //   43: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   46: aload_2
    //   47: astore 4
    //   49: aload_1
    //   50: astore_3
    //   51: aload_1
    //   52: invokevirtual 139	java/io/OutputStream:flush	()V
    //   55: aload_2
    //   56: astore 4
    //   58: aload_1
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 140	java/io/OutputStream:close	()V
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 140	java/io/OutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   76: ldc 120
    //   78: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: ldc 90
    //   87: aload_1
    //   88: ldc 38
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: goto -25 -> 72
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: ldc 90
    //   108: aload_1
    //   109: ldc 38
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: ldc 120
    //   120: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -42 -> 81
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_2
    //   133: astore 4
    //   135: aload_1
    //   136: astore_3
    //   137: ldc 90
    //   139: aload 5
    //   141: ldc 38
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 140	java/io/OutputStream:close	()V
    //   158: aload_2
    //   159: ifnull +115 -> 274
    //   162: aload_2
    //   163: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   166: ldc 120
    //   168: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: goto -90 -> 81
    //   174: astore_1
    //   175: ldc 90
    //   177: aload_1
    //   178: ldc 38
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -29 -> 158
    //   190: astore_1
    //   191: ldc 90
    //   193: aload_1
    //   194: ldc 38
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: ldc 120
    //   205: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: goto -127 -> 81
    //   211: astore_2
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 140	java/io/OutputStream:close	()V
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   235: ldc 120
    //   237: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_2
    //   241: athrow
    //   242: astore_1
    //   243: ldc 90
    //   245: aload_1
    //   246: ldc 38
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: goto -30 -> 225
    //   258: astore_1
    //   259: ldc 90
    //   261: aload_1
    //   262: ldc 38
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -36 -> 235
    //   274: ldc 120
    //   276: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: goto -198 -> 81
    //   282: astore_2
    //   283: aconst_null
    //   284: astore 4
    //   286: goto -69 -> 217
    //   289: astore_2
    //   290: aload_3
    //   291: astore_1
    //   292: goto -75 -> 217
    //   295: astore 5
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -167 -> 132
    //   302: astore 5
    //   304: goto -172 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	l
    //   14	55	1	localOutputStream	java.io.OutputStream
    //   84	4	1	localIOException1	java.io.IOException
    //   100	4	1	localObject1	Object
    //   105	4	1	localIOException2	java.io.IOException
    //   131	24	1	localObject2	Object
    //   174	4	1	localIOException3	java.io.IOException
    //   190	4	1	localIOException4	java.io.IOException
    //   216	6	1	localObject3	Object
    //   242	4	1	localIOException5	java.io.IOException
    //   258	4	1	localIOException6	java.io.IOException
    //   291	1	1	localObject4	Object
    //   23	140	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   211	30	2	localObject5	Object
    //   282	1	2	localObject6	Object
    //   289	1	2	localObject7	Object
    //   298	1	2	localObject8	Object
    //   28	263	3	localObject9	Object
    //   25	260	4	localObjectOutputStream2	java.io.ObjectOutputStream
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
    //   7	15	126	java/io/IOException
    //   154	158	174	java/io/IOException
    //   162	166	190	java/io/IOException
    //   7	15	211	finally
    //   221	225	242	java/io/IOException
    //   230	235	258	java/io/IOException
    //   15	24	282	finally
    //   29	37	289	finally
    //   42	46	289	finally
    //   51	55	289	finally
    //   60	64	289	finally
    //   137	150	289	finally
    //   15	24	295	java/io/IOException
    //   29	37	302	java/io/IOException
    //   42	46	302	java/io/IOException
    //   51	55	302	java/io/IOException
    //   60	64	302	java/io/IOException
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(155659);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(155659);
    return localObject;
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(155658);
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.jsf) {
        aur();
      }
      AppMethodBeat.o(155658);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.l
 * JD-Core Version:    0.7.0.1
 */