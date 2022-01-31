package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;

final class b$b
  extends a
{
  private b$b(b paramb) {}
  
  /* Error */
  public final boolean execute()
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 37	com/tencent/mm/plugin/fts/b/b:bCl	()Lcom/tencent/mm/vfs/b;
    //   8: invokestatic 41	com/tencent/mm/plugin/fts/b/b:k	(Lcom/tencent/mm/vfs/b;)I
    //   11: istore_2
    //   12: invokestatic 45	com/tencent/mm/plugin/fts/b/b:bCm	()I
    //   15: istore_3
    //   16: ldc 47
    //   18: ldc 49
    //   20: iconst_2
    //   21: anewarray 51	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: iload_2
    //   27: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: iload_3
    //   34: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iload_2
    //   42: istore_1
    //   43: iload_3
    //   44: iload_2
    //   45: if_icmple +11 -> 56
    //   48: iload_2
    //   49: istore_1
    //   50: iload_3
    //   51: ifle +5 -> 56
    //   54: iconst_m1
    //   55: istore_1
    //   56: iload_1
    //   57: ifge +224 -> 281
    //   60: new 64	com/tencent/mm/vfs/b
    //   63: dup
    //   64: invokestatic 70	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   67: invokevirtual 76	android/content/Context:getCacheDir	()Ljava/io/File;
    //   70: ldc 78
    //   72: invokespecial 81	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 9
    //   77: invokestatic 70	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   80: invokevirtual 85	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   83: astore 4
    //   85: aload 4
    //   87: ldc 78
    //   89: invokevirtual 91	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   92: astore 4
    //   94: aload 9
    //   96: invokevirtual 94	com/tencent/mm/vfs/b:exists	()Z
    //   99: ifeq +9 -> 108
    //   102: aload 9
    //   104: invokevirtual 97	com/tencent/mm/vfs/b:delete	()Z
    //   107: pop
    //   108: new 99	com/tencent/mm/vfs/f
    //   111: dup
    //   112: aload 9
    //   114: invokespecial 102	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   117: astore 5
    //   119: aload 5
    //   121: astore 7
    //   123: aload 4
    //   125: astore 6
    //   127: sipush 1024
    //   130: newarray byte
    //   132: astore 8
    //   134: aload 5
    //   136: astore 7
    //   138: aload 4
    //   140: astore 6
    //   142: aload 4
    //   144: aload 8
    //   146: invokevirtual 108	java/io/InputStream:read	([B)I
    //   149: istore_1
    //   150: iload_1
    //   151: iconst_m1
    //   152: if_icmpeq +136 -> 288
    //   155: aload 5
    //   157: astore 7
    //   159: aload 4
    //   161: astore 6
    //   163: aload 5
    //   165: aload 8
    //   167: iconst_0
    //   168: iload_1
    //   169: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   172: goto -38 -> 134
    //   175: astore 8
    //   177: aload 5
    //   179: astore 7
    //   181: aload 4
    //   183: astore 6
    //   185: ldc 47
    //   187: aload 8
    //   189: ldc 116
    //   191: iconst_0
    //   192: anewarray 51	java/lang/Object
    //   195: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 123	java/io/InputStream:close	()V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 124	java/io/OutputStream:close	()V
    //   218: aload 9
    //   220: invokevirtual 94	com/tencent/mm/vfs/b:exists	()Z
    //   223: ifeq +58 -> 281
    //   226: new 126	com/tencent/mm/g/a/bg
    //   229: dup
    //   230: invokespecial 127	com/tencent/mm/g/a/bg:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: getfield 131	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   240: bipush 35
    //   242: putfield 137	com/tencent/mm/g/a/bg$a:coJ	I
    //   245: aload 4
    //   247: getfield 131	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   250: iconst_1
    //   251: putfield 140	com/tencent/mm/g/a/bg$a:subType	I
    //   254: aload 4
    //   256: getfield 131	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   259: aload 9
    //   261: invokevirtual 144	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   264: invokestatic 150	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   267: putfield 154	com/tencent/mm/g/a/bg$a:filePath	Ljava/lang/String;
    //   270: getstatic 160	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   273: aload 4
    //   275: invokestatic 166	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   278: invokevirtual 170	com/tencent/mm/sdk/b/a:a	(Lcom/tencent/mm/sdk/b/b;Landroid/os/Looper;)V
    //   281: ldc 27
    //   283: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_1
    //   287: ireturn
    //   288: aload 4
    //   290: ifnull +8 -> 298
    //   293: aload 4
    //   295: invokevirtual 123	java/io/InputStream:close	()V
    //   298: aload 5
    //   300: invokevirtual 124	java/io/OutputStream:close	()V
    //   303: goto -85 -> 218
    //   306: astore 4
    //   308: goto -90 -> 218
    //   311: astore 5
    //   313: aconst_null
    //   314: astore 7
    //   316: aconst_null
    //   317: astore 4
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 123	java/io/InputStream:close	()V
    //   329: aload 7
    //   331: ifnull +8 -> 339
    //   334: aload 7
    //   336: invokevirtual 124	java/io/OutputStream:close	()V
    //   339: ldc 27
    //   341: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload 5
    //   346: athrow
    //   347: astore 4
    //   349: goto -51 -> 298
    //   352: astore 4
    //   354: goto -146 -> 208
    //   357: astore 4
    //   359: goto -141 -> 218
    //   362: astore 4
    //   364: goto -35 -> 329
    //   367: astore 4
    //   369: goto -30 -> 339
    //   372: astore 5
    //   374: aconst_null
    //   375: astore 7
    //   377: goto -58 -> 319
    //   380: astore 5
    //   382: aload 6
    //   384: astore 4
    //   386: goto -67 -> 319
    //   389: astore 8
    //   391: aconst_null
    //   392: astore 5
    //   394: aconst_null
    //   395: astore 4
    //   397: goto -220 -> 177
    //   400: astore 8
    //   402: aconst_null
    //   403: astore 5
    //   405: goto -228 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	b
    //   42	127	1	i	int
    //   11	38	2	j	int
    //   15	36	3	k	int
    //   83	211	4	localObject1	java.lang.Object
    //   306	1	4	localIOException1	java.io.IOException
    //   317	8	4	localObject2	java.lang.Object
    //   347	1	4	localIOException2	java.io.IOException
    //   352	1	4	localIOException3	java.io.IOException
    //   357	1	4	localIOException4	java.io.IOException
    //   362	1	4	localIOException5	java.io.IOException
    //   367	1	4	localIOException6	java.io.IOException
    //   384	12	4	localObject3	java.lang.Object
    //   117	182	5	localf1	com.tencent.mm.vfs.f
    //   311	34	5	localObject4	java.lang.Object
    //   372	1	5	localObject5	java.lang.Object
    //   380	1	5	localObject6	java.lang.Object
    //   392	12	5	localObject7	java.lang.Object
    //   125	258	6	localObject8	java.lang.Object
    //   121	255	7	localf2	com.tencent.mm.vfs.f
    //   132	34	8	arrayOfByte	byte[]
    //   175	13	8	localException1	java.lang.Exception
    //   389	1	8	localException2	java.lang.Exception
    //   400	1	8	localException3	java.lang.Exception
    //   75	185	9	localb	com.tencent.mm.vfs.b
    // Exception table:
    //   from	to	target	type
    //   127	134	175	java/lang/Exception
    //   142	150	175	java/lang/Exception
    //   163	172	175	java/lang/Exception
    //   298	303	306	java/io/IOException
    //   85	94	311	finally
    //   293	298	347	java/io/IOException
    //   203	208	352	java/io/IOException
    //   213	218	357	java/io/IOException
    //   324	329	362	java/io/IOException
    //   334	339	367	java/io/IOException
    //   94	108	372	finally
    //   108	119	372	finally
    //   127	134	380	finally
    //   142	150	380	finally
    //   163	172	380	finally
    //   185	198	380	finally
    //   85	94	389	java/lang/Exception
    //   94	108	400	java/lang/Exception
    //   108	119	400	java/lang/Exception
  }
  
  public final String getName()
  {
    return "CheckFeatureResourceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.b
 * JD-Core Version:    0.7.0.1
 */