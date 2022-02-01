package com.tencent.mm.plugin.appbrand.appcache;

public final class ad
{
  /* Error */
  public static java.lang.String a(WxaPkg paramWxaPkg, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +10 -> 23
    //   16: ldc 9
    //   18: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 30	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:cfK	()Z
    //   27: pop
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 34	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:Va	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +10 -> 45
    //   38: ldc 9
    //   40: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_2
    //   46: aload_2
    //   47: invokevirtual 40	java/io/InputStream:available	()I
    //   50: invokevirtual 43	java/io/InputStream:mark	(I)V
    //   53: aload_2
    //   54: sipush 4096
    //   57: invokestatic 49	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_2
    //   62: invokevirtual 53	java/io/InputStream:reset	()V
    //   65: new 55	com/tencent/mm/vfs/u
    //   68: dup
    //   69: new 57	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: getfield 64	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/u;
    //   80: invokevirtual 68	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   83: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   86: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 80
    //   91: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 87	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 91	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 94	com/tencent/mm/vfs/u:jKS	()Z
    //   114: ifeq +15 -> 129
    //   117: aload_1
    //   118: invokevirtual 97	com/tencent/mm/vfs/u:jKV	()Z
    //   121: ifeq +8 -> 129
    //   124: aload_1
    //   125: invokevirtual 100	com/tencent/mm/vfs/u:diJ	()Z
    //   128: pop
    //   129: aload_1
    //   130: invokevirtual 103	com/tencent/mm/vfs/u:jKY	()Z
    //   133: pop
    //   134: aload_3
    //   135: aload_0
    //   136: getfield 107	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   139: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   142: invokestatic 113	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifne +54 -> 202
    //   151: aload_0
    //   152: invokevirtual 122	com/tencent/mm/vfs/u:isDirectory	()Z
    //   155: ifeq +66 -> 221
    //   158: invokestatic 128	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   161: new 57	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 130
    //   167: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 68	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   174: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   177: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 135	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   186: pop
    //   187: aload_0
    //   188: invokestatic 139	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   191: astore_1
    //   192: aload_2
    //   193: aload_1
    //   194: invokestatic 145	com/tencent/mm/b/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   197: pop2
    //   198: aload_1
    //   199: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   202: aload_0
    //   203: invokevirtual 68	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   206: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   209: astore_0
    //   210: aload_2
    //   211: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   214: ldc 9
    //   216: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_0
    //   220: areturn
    //   221: aload_0
    //   222: invokevirtual 100	com/tencent/mm/vfs/u:diJ	()Z
    //   225: pop
    //   226: goto -39 -> 187
    //   229: astore_0
    //   230: ldc 151
    //   232: aload_0
    //   233: ldc 153
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload_2
    //   243: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   246: ldc 9
    //   248: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_0
    //   254: aload_2
    //   255: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   258: ldc 9
    //   260: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_0
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramWxaPkg	WxaPkg
    //   0	265	1	paramString	java.lang.String
    //   33	222	2	localInputStream	java.io.InputStream
    //   60	75	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   45	129	229	java/lang/Exception
    //   129	187	229	java/lang/Exception
    //   187	202	229	java/lang/Exception
    //   202	210	229	java/lang/Exception
    //   221	226	229	java/lang/Exception
    //   45	129	253	finally
    //   129	187	253	finally
    //   187	202	253	finally
    //   202	210	253	finally
    //   221	226	253	finally
    //   230	242	253	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */