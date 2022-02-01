package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Map;

public final class l
{
  private static l gai = null;
  private String filePath;
  private boolean gag;
  boolean gah;
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
    //   11: putfield 36	com/tencent/mm/compatible/deviceinfo/l:gag	Z
    //   14: aload_0
    //   15: ldc 38
    //   17: putfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 42	com/tencent/mm/compatible/deviceinfo/l:gah	Z
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   30: new 44	com/tencent/mm/vfs/e
    //   33: dup
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   38: invokespecial 46	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 50	com/tencent/mm/vfs/e:exists	()Z
    //   46: ifne +13 -> 59
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 42	com/tencent/mm/compatible/deviceinfo/l:gah	Z
    //   54: aload_1
    //   55: invokevirtual 53	com/tencent/mm/vfs/e:createNewFile	()Z
    //   58: pop
    //   59: aload_1
    //   60: invokevirtual 57	com/tencent/mm/vfs/e:length	()J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifne +30 -> 95
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 42	com/tencent/mm/compatible/deviceinfo/l:gah	Z
    //   73: aload_0
    //   74: new 59	java/util/HashMap
    //   77: dup
    //   78: invokespecial 60	java/util/HashMap:<init>	()V
    //   81: putfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 36	com/tencent/mm/compatible/deviceinfo/l:gag	Z
    //   89: ldc 28
    //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_1
    //   96: invokestatic 71	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
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
    //   168: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -87 -> 84
    //   174: astore_1
    //   175: ldc 90
    //   177: aload_1
    //   178: ldc 38
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   227: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   259: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -178 -> 84
    //   265: astore_1
    //   266: ldc 90
    //   268: aload_1
    //   269: ldc 38
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   322: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -30 -> 295
    //   328: astore_1
    //   329: ldc 90
    //   331: aload_1
    //   332: ldc 38
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static l aad()
  {
    try
    {
      AppMethodBeat.i(155656);
      if (gai == null) {
        gai = new l(b.arM() + "CompatibleInfo.cfg");
      }
      l locall = gai;
      AppMethodBeat.o(155656);
      return locall;
    }
    finally {}
  }
  
  /* Error */
  private void aae()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 120
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 40	com/tencent/mm/compatible/deviceinfo/l:filePath	Ljava/lang/String;
    //   11: iconst_0
    //   12: invokestatic 124	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   15: astore_1
    //   16: new 126	java/io/ObjectOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 129	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore 4
    //   28: aload_1
    //   29: astore_3
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 62	com/tencent/mm/compatible/deviceinfo/l:values	Ljava/util/Map;
    //   35: invokevirtual 133	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_2
    //   39: astore 4
    //   41: aload_1
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   47: aload_2
    //   48: astore 4
    //   50: aload_1
    //   51: astore_3
    //   52: aload_1
    //   53: invokevirtual 139	java/io/OutputStream:flush	()V
    //   56: aload_2
    //   57: astore 4
    //   59: aload_1
    //   60: astore_3
    //   61: aload_1
    //   62: invokevirtual 140	java/io/OutputStream:close	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 140	java/io/OutputStream:close	()V
    //   73: aload_2
    //   74: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   77: ldc 120
    //   79: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_1
    //   86: ldc 90
    //   88: aload_1
    //   89: ldc 38
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: goto -25 -> 73
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: ldc 90
    //   109: aload_1
    //   110: ldc 38
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: ldc 120
    //   121: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: goto -42 -> 82
    //   127: astore 5
    //   129: aconst_null
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_2
    //   134: astore 4
    //   136: aload_1
    //   137: astore_3
    //   138: ldc 90
    //   140: aload 5
    //   142: ldc 38
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 140	java/io/OutputStream:close	()V
    //   159: aload_2
    //   160: ifnull +115 -> 275
    //   163: aload_2
    //   164: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   167: ldc 120
    //   169: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: goto -90 -> 82
    //   175: astore_1
    //   176: ldc 90
    //   178: aload_1
    //   179: ldc 38
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: goto -29 -> 159
    //   191: astore_1
    //   192: ldc 90
    //   194: aload_1
    //   195: ldc 38
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: ldc 120
    //   206: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: goto -127 -> 82
    //   212: astore_2
    //   213: aconst_null
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 140	java/io/OutputStream:close	()V
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 134	java/io/ObjectOutputStream:close	()V
    //   236: ldc 120
    //   238: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_2
    //   242: athrow
    //   243: astore_1
    //   244: ldc 90
    //   246: aload_1
    //   247: ldc 38
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: goto -30 -> 226
    //   259: astore_1
    //   260: ldc 90
    //   262: aload_1
    //   263: ldc 38
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -36 -> 236
    //   275: ldc 120
    //   277: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: goto -198 -> 82
    //   283: astore_2
    //   284: aconst_null
    //   285: astore 4
    //   287: goto -69 -> 218
    //   290: astore_2
    //   291: aload_3
    //   292: astore_1
    //   293: goto -75 -> 218
    //   296: astore 5
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -167 -> 133
    //   303: astore 5
    //   305: goto -172 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	l
    //   15	55	1	localOutputStream	java.io.OutputStream
    //   85	4	1	localIOException1	java.io.IOException
    //   101	4	1	localObject1	Object
    //   106	4	1	localIOException2	java.io.IOException
    //   132	24	1	localObject2	Object
    //   175	4	1	localIOException3	java.io.IOException
    //   191	4	1	localIOException4	java.io.IOException
    //   217	6	1	localObject3	Object
    //   243	4	1	localIOException5	java.io.IOException
    //   259	4	1	localIOException6	java.io.IOException
    //   292	1	1	localObject4	Object
    //   24	140	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   212	30	2	localObject5	Object
    //   283	1	2	localObject6	Object
    //   290	1	2	localObject7	Object
    //   299	1	2	localObject8	Object
    //   29	263	3	localObject9	Object
    //   26	260	4	localObjectOutputStream2	java.io.ObjectOutputStream
    //   127	14	5	localIOException7	java.io.IOException
    //   296	1	5	localIOException8	java.io.IOException
    //   303	1	5	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   69	73	85	java/io/IOException
    //   2	7	101	finally
    //   69	73	101	finally
    //   73	77	101	finally
    //   77	82	101	finally
    //   86	98	101	finally
    //   107	124	101	finally
    //   155	159	101	finally
    //   163	167	101	finally
    //   167	172	101	finally
    //   176	188	101	finally
    //   192	209	101	finally
    //   222	226	101	finally
    //   231	236	101	finally
    //   236	243	101	finally
    //   244	256	101	finally
    //   260	272	101	finally
    //   275	280	101	finally
    //   73	77	106	java/io/IOException
    //   7	16	127	java/io/IOException
    //   155	159	175	java/io/IOException
    //   163	167	191	java/io/IOException
    //   7	16	212	finally
    //   222	226	243	java/io/IOException
    //   231	236	259	java/io/IOException
    //   16	25	283	finally
    //   30	38	290	finally
    //   43	47	290	finally
    //   52	56	290	finally
    //   61	65	290	finally
    //   138	151	290	finally
    //   16	25	296	java/io/IOException
    //   30	38	303	java/io/IOException
    //   43	47	303	java/io/IOException
    //   52	56	303	java/io/IOException
    //   61	65	303	java/io/IOException
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(155659);
    Object localObject = this.values.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(155659);
    return localObject;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(155658);
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.gag) {
        aae();
      }
      AppMethodBeat.o(155658);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.l
 * JD-Core Version:    0.7.0.1
 */