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
    //   0: invokestatic 30	com/tencent/mm/plugin/fts/b/b:aVJ	()Lcom/tencent/mm/vfs/b;
    //   3: invokestatic 34	com/tencent/mm/plugin/fts/b/b:i	(Lcom/tencent/mm/vfs/b;)I
    //   6: istore_1
    //   7: ldc 36
    //   9: ldc 38
    //   11: iconst_1
    //   12: anewarray 40	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 51	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iload_1
    //   26: ifge +201 -> 227
    //   29: new 53	com/tencent/mm/vfs/b
    //   32: dup
    //   33: invokestatic 59	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   36: invokevirtual 65	android/content/Context:getCacheDir	()Ljava/io/File;
    //   39: ldc 67
    //   41: invokespecial 70	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 7
    //   46: invokestatic 59	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   49: invokevirtual 74	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   52: astore_2
    //   53: aload_2
    //   54: ldc 67
    //   56: invokevirtual 80	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore_2
    //   60: aload 7
    //   62: invokevirtual 83	com/tencent/mm/vfs/b:exists	()Z
    //   65: ifeq +9 -> 74
    //   68: aload 7
    //   70: invokevirtual 86	com/tencent/mm/vfs/b:delete	()Z
    //   73: pop
    //   74: new 88	com/tencent/mm/vfs/f
    //   77: dup
    //   78: aload 7
    //   80: invokespecial 91	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   83: astore_3
    //   84: aload_3
    //   85: astore 5
    //   87: aload_2
    //   88: astore 4
    //   90: sipush 1024
    //   93: newarray byte
    //   95: astore 6
    //   97: aload_3
    //   98: astore 5
    //   100: aload_2
    //   101: astore 4
    //   103: aload_2
    //   104: aload 6
    //   106: invokevirtual 97	java/io/InputStream:read	([B)I
    //   109: istore_1
    //   110: iload_1
    //   111: iconst_m1
    //   112: if_icmpeq +117 -> 229
    //   115: aload_3
    //   116: astore 5
    //   118: aload_2
    //   119: astore 4
    //   121: aload_3
    //   122: aload 6
    //   124: iconst_0
    //   125: iload_1
    //   126: invokevirtual 103	java/io/OutputStream:write	([BII)V
    //   129: goto -32 -> 97
    //   132: astore 6
    //   134: aload_3
    //   135: astore 5
    //   137: aload_2
    //   138: astore 4
    //   140: ldc 36
    //   142: aload 6
    //   144: ldc 105
    //   146: iconst_0
    //   147: anewarray 40	java/lang/Object
    //   150: invokestatic 109	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 112	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 113	java/io/OutputStream:close	()V
    //   169: aload 7
    //   171: invokevirtual 83	com/tencent/mm/vfs/b:exists	()Z
    //   174: ifeq +53 -> 227
    //   177: new 115	com/tencent/mm/h/a/be
    //   180: dup
    //   181: invokespecial 116	com/tencent/mm/h/a/be:<init>	()V
    //   184: astore_2
    //   185: aload_2
    //   186: getfield 120	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   189: bipush 35
    //   191: putfield 126	com/tencent/mm/h/a/be$a:bHv	I
    //   194: aload_2
    //   195: getfield 120	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   198: iconst_1
    //   199: putfield 129	com/tencent/mm/h/a/be$a:brC	I
    //   202: aload_2
    //   203: getfield 120	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   206: aload 7
    //   208: invokevirtual 133	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   211: invokestatic 139	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   214: putfield 143	com/tencent/mm/h/a/be$a:filePath	Ljava/lang/String;
    //   217: getstatic 149	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   220: aload_2
    //   221: invokestatic 155	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   224: invokevirtual 159	com/tencent/mm/sdk/b/a:a	(Lcom/tencent/mm/sdk/b/b;Landroid/os/Looper;)V
    //   227: iconst_1
    //   228: ireturn
    //   229: aload_2
    //   230: ifnull +7 -> 237
    //   233: aload_2
    //   234: invokevirtual 112	java/io/InputStream:close	()V
    //   237: aload_3
    //   238: invokevirtual 113	java/io/OutputStream:close	()V
    //   241: goto -72 -> 169
    //   244: astore_2
    //   245: goto -76 -> 169
    //   248: astore_3
    //   249: aconst_null
    //   250: astore 5
    //   252: aconst_null
    //   253: astore_2
    //   254: aload_2
    //   255: ifnull +7 -> 262
    //   258: aload_2
    //   259: invokevirtual 112	java/io/InputStream:close	()V
    //   262: aload 5
    //   264: ifnull +8 -> 272
    //   267: aload 5
    //   269: invokevirtual 113	java/io/OutputStream:close	()V
    //   272: aload_3
    //   273: athrow
    //   274: astore_2
    //   275: goto -38 -> 237
    //   278: astore_2
    //   279: goto -118 -> 161
    //   282: astore_2
    //   283: goto -114 -> 169
    //   286: astore_2
    //   287: goto -25 -> 262
    //   290: astore_2
    //   291: goto -19 -> 272
    //   294: astore_3
    //   295: aconst_null
    //   296: astore 5
    //   298: goto -44 -> 254
    //   301: astore_3
    //   302: aload 4
    //   304: astore_2
    //   305: goto -51 -> 254
    //   308: astore 6
    //   310: aconst_null
    //   311: astore_3
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -180 -> 134
    //   317: astore 6
    //   319: aconst_null
    //   320: astore_3
    //   321: goto -187 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	b
    //   6	120	1	i	int
    //   52	182	2	localObject1	java.lang.Object
    //   244	1	2	localIOException1	java.io.IOException
    //   253	6	2	localObject2	java.lang.Object
    //   274	1	2	localIOException2	java.io.IOException
    //   278	1	2	localIOException3	java.io.IOException
    //   282	1	2	localIOException4	java.io.IOException
    //   286	1	2	localIOException5	java.io.IOException
    //   290	1	2	localIOException6	java.io.IOException
    //   304	10	2	localObject3	java.lang.Object
    //   83	155	3	localf1	com.tencent.mm.vfs.f
    //   248	25	3	localObject4	java.lang.Object
    //   294	1	3	localObject5	java.lang.Object
    //   301	1	3	localObject6	java.lang.Object
    //   311	10	3	localObject7	java.lang.Object
    //   88	215	4	localObject8	java.lang.Object
    //   85	212	5	localf2	com.tencent.mm.vfs.f
    //   95	28	6	arrayOfByte	byte[]
    //   132	11	6	localException1	java.lang.Exception
    //   308	1	6	localException2	java.lang.Exception
    //   317	1	6	localException3	java.lang.Exception
    //   44	163	7	localb	com.tencent.mm.vfs.b
    // Exception table:
    //   from	to	target	type
    //   90	97	132	java/lang/Exception
    //   103	110	132	java/lang/Exception
    //   121	129	132	java/lang/Exception
    //   237	241	244	java/io/IOException
    //   53	60	248	finally
    //   233	237	274	java/io/IOException
    //   157	161	278	java/io/IOException
    //   165	169	282	java/io/IOException
    //   258	262	286	java/io/IOException
    //   267	272	290	java/io/IOException
    //   60	74	294	finally
    //   74	84	294	finally
    //   90	97	301	finally
    //   103	110	301	finally
    //   121	129	301	finally
    //   140	153	301	finally
    //   53	60	308	java/lang/Exception
    //   60	74	317	java/lang/Exception
    //   74	84	317	java/lang/Exception
  }
  
  public final String getName()
  {
    return "CheckFeatureResourceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.b
 * JD-Core Version:    0.7.0.1
 */