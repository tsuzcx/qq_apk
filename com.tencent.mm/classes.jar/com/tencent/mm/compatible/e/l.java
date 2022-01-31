package com.tencent.mm.compatible.e;

import com.tencent.mm.compatible.util.e;
import java.util.Map;

public final class l
{
  private static l dxL = null;
  private boolean dxK;
  private String filePath;
  private Map<Integer, Object> values;
  
  /* Error */
  private l(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 28	com/tencent/mm/compatible/e/l:dxK	Z
    //   9: aload_0
    //   10: ldc 30
    //   12: putfield 32	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 32	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   20: new 34	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 32	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   28: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 40	java/io/File:exists	()Z
    //   36: ifne +8 -> 44
    //   39: aload_1
    //   40: invokevirtual 43	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 47	java/io/File:length	()J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifne +20 -> 70
    //   53: aload_0
    //   54: new 49	java/util/HashMap
    //   57: dup
    //   58: invokespecial 50	java/util/HashMap:<init>	()V
    //   61: putfield 52	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 28	com/tencent/mm/compatible/e/l:dxK	Z
    //   69: return
    //   70: new 54	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: astore_2
    //   79: new 59	java/io/ObjectInputStream
    //   82: dup
    //   83: aload_2
    //   84: invokespecial 62	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: aload_1
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 66	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   98: checkcast 68	java/util/Map
    //   101: putfield 52	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   104: aload_1
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: aload_1
    //   110: invokevirtual 71	java/io/ObjectInputStream:close	()V
    //   113: aload_1
    //   114: astore 4
    //   116: aload_2
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 72	java/io/FileInputStream:close	()V
    //   122: aload_2
    //   123: invokevirtual 72	java/io/FileInputStream:close	()V
    //   126: aload_1
    //   127: invokevirtual 71	java/io/ObjectInputStream:close	()V
    //   130: goto -66 -> 64
    //   133: astore_1
    //   134: ldc 74
    //   136: aload_1
    //   137: ldc 30
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: goto -82 -> 64
    //   149: astore_2
    //   150: ldc 74
    //   152: aload_2
    //   153: ldc 30
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -36 -> 126
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_1
    //   172: astore 4
    //   174: aload_2
    //   175: astore_3
    //   176: aload_0
    //   177: new 49	java/util/HashMap
    //   180: dup
    //   181: invokespecial 50	java/util/HashMap:<init>	()V
    //   184: putfield 52	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   187: aload_1
    //   188: astore 4
    //   190: aload_2
    //   191: astore_3
    //   192: ldc 74
    //   194: aload 5
    //   196: ldc 30
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 72	java/io/FileInputStream:close	()V
    //   213: aload_1
    //   214: ifnull -150 -> 64
    //   217: aload_1
    //   218: invokevirtual 71	java/io/ObjectInputStream:close	()V
    //   221: goto -157 -> 64
    //   224: astore_1
    //   225: ldc 74
    //   227: aload_1
    //   228: ldc 30
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -173 -> 64
    //   240: astore_2
    //   241: ldc 74
    //   243: aload_2
    //   244: ldc 30
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -40 -> 213
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 4
    //   260: aconst_null
    //   261: astore_2
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 72	java/io/FileInputStream:close	()V
    //   270: aload 4
    //   272: ifnull +8 -> 280
    //   275: aload 4
    //   277: invokevirtual 71	java/io/ObjectInputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_2
    //   283: ldc 74
    //   285: aload_2
    //   286: ldc 30
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: goto -25 -> 270
    //   298: astore_2
    //   299: ldc 74
    //   301: aload_2
    //   302: ldc 30
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: goto -31 -> 280
    //   314: astore_1
    //   315: aconst_null
    //   316: astore 4
    //   318: goto -56 -> 262
    //   321: astore_1
    //   322: aload_3
    //   323: astore_2
    //   324: goto -62 -> 262
    //   327: astore 5
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -160 -> 171
    //   334: astore 5
    //   336: goto -165 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	l
    //   0	339	1	paramString	String
    //   78	45	2	localFileInputStream	java.io.FileInputStream
    //   149	4	2	localIOException1	java.io.IOException
    //   170	40	2	localObject1	Object
    //   240	4	2	localIOException2	java.io.IOException
    //   261	6	2	localObject2	Object
    //   282	4	2	localIOException3	java.io.IOException
    //   298	4	2	localIOException4	java.io.IOException
    //   323	1	2	localObject3	Object
    //   92	231	3	localObject4	Object
    //   89	228	4	str	String
    //   165	30	5	localException1	java.lang.Exception
    //   327	1	5	localException2	java.lang.Exception
    //   334	1	5	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   126	130	133	java/io/IOException
    //   122	126	149	java/io/IOException
    //   20	44	165	java/lang/Exception
    //   44	64	165	java/lang/Exception
    //   70	79	165	java/lang/Exception
    //   217	221	224	java/io/IOException
    //   209	213	240	java/io/IOException
    //   20	44	256	finally
    //   44	64	256	finally
    //   70	79	256	finally
    //   266	270	282	java/io/IOException
    //   275	280	298	java/io/IOException
    //   79	88	314	finally
    //   93	104	321	finally
    //   109	113	321	finally
    //   118	122	321	finally
    //   176	187	321	finally
    //   192	205	321	finally
    //   79	88	327	java/lang/Exception
    //   93	104	334	java/lang/Exception
    //   109	113	334	java/lang/Exception
    //   118	122	334	java/lang/Exception
  }
  
  public static l yP()
  {
    try
    {
      if (dxL == null) {
        dxL = new l(e.dOP + "CompatibleInfo.cfg");
      }
      l locall = dxL;
      return locall;
    }
    finally {}
  }
  
  /* Error */
  private void yQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 104	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 32	com/tencent/mm/compatible/e/l:filePath	Ljava/lang/String;
    //   10: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 107	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 110	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: aload_1
    //   24: astore 4
    //   26: aload_2
    //   27: astore_3
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 52	com/tencent/mm/compatible/e/l:values	Ljava/util/Map;
    //   33: invokevirtual 114	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload_1
    //   37: astore 4
    //   39: aload_2
    //   40: astore_3
    //   41: aload_1
    //   42: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   45: aload_1
    //   46: astore 4
    //   48: aload_2
    //   49: astore_3
    //   50: aload_2
    //   51: invokevirtual 118	java/io/FileOutputStream:flush	()V
    //   54: aload_1
    //   55: astore 4
    //   57: aload_2
    //   58: astore_3
    //   59: aload_2
    //   60: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   63: aload_2
    //   64: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   67: aload_1
    //   68: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_2
    //   75: ldc 74
    //   77: aload_2
    //   78: ldc 30
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: goto -20 -> 67
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: ldc 74
    //   98: aload_1
    //   99: ldc 30
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -37 -> 71
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_1
    //   118: astore 4
    //   120: aload_2
    //   121: astore_3
    //   122: ldc 74
    //   124: aload 5
    //   126: ldc 30
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: ifnull -73 -> 71
    //   147: aload_1
    //   148: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   151: goto -80 -> 71
    //   154: astore_1
    //   155: ldc 74
    //   157: aload_1
    //   158: ldc 30
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -96 -> 71
    //   170: astore_2
    //   171: ldc 74
    //   173: aload_2
    //   174: ldc 30
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: goto -40 -> 143
    //   186: astore_1
    //   187: aconst_null
    //   188: astore 4
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_2
    //   213: ldc 74
    //   215: aload_2
    //   216: ldc 30
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -25 -> 200
    //   228: astore_2
    //   229: ldc 74
    //   231: aload_2
    //   232: ldc 30
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 80	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: goto -31 -> 210
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 4
    //   248: goto -56 -> 192
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: goto -62 -> 192
    //   257: astore 5
    //   259: aconst_null
    //   260: astore_1
    //   261: goto -144 -> 117
    //   264: astore 5
    //   266: goto -149 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	l
    //   22	46	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   90	4	1	localObject1	Object
    //   95	4	1	localIOException1	java.io.IOException
    //   114	34	1	localObject2	Object
    //   154	4	1	localIOException2	java.io.IOException
    //   186	25	1	localObject3	Object
    //   244	1	1	localObject4	Object
    //   251	1	1	localObject5	Object
    //   260	1	1	localObject6	Object
    //   13	51	2	localFileOutputStream	java.io.FileOutputStream
    //   74	4	2	localIOException3	java.io.IOException
    //   116	24	2	localObject7	Object
    //   170	4	2	localIOException4	java.io.IOException
    //   191	6	2	localObject8	Object
    //   212	4	2	localIOException5	java.io.IOException
    //   228	4	2	localIOException6	java.io.IOException
    //   253	1	2	localObject9	Object
    //   27	226	3	localObject10	Object
    //   24	223	4	localObject11	Object
    //   111	14	5	localIOException7	java.io.IOException
    //   257	1	5	localIOException8	java.io.IOException
    //   264	1	5	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   63	67	74	java/io/IOException
    //   63	67	90	finally
    //   67	71	90	finally
    //   75	87	90	finally
    //   96	108	90	finally
    //   139	143	90	finally
    //   147	151	90	finally
    //   155	167	90	finally
    //   171	183	90	finally
    //   196	200	90	finally
    //   205	210	90	finally
    //   210	212	90	finally
    //   213	225	90	finally
    //   229	241	90	finally
    //   67	71	95	java/io/IOException
    //   2	14	111	java/io/IOException
    //   147	151	154	java/io/IOException
    //   139	143	170	java/io/IOException
    //   2	14	186	finally
    //   196	200	212	java/io/IOException
    //   205	210	228	java/io/IOException
    //   14	23	244	finally
    //   28	36	251	finally
    //   41	45	251	finally
    //   50	54	251	finally
    //   59	63	251	finally
    //   122	135	251	finally
    //   14	23	257	java/io/IOException
    //   28	36	264	java/io/IOException
    //   41	45	264	java/io/IOException
    //   50	54	264	java/io/IOException
    //   59	63	264	java/io/IOException
  }
  
  public final Object get(int paramInt)
  {
    return this.values.get(Integer.valueOf(paramInt));
  }
  
  public final Object gz(int paramInt)
  {
    Object localObject2 = this.values.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    try
    {
      this.values.put(Integer.valueOf(paramInt), paramObject);
      if (!this.dxK) {
        yQ();
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.l
 * JD-Core Version:    0.7.0.1
 */