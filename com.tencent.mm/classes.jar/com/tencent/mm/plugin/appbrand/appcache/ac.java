package com.tencent.mm.plugin.appbrand.appcache;

public final class ac
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
    //   24: invokevirtual 30	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bGl	()Z
    //   27: pop
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 34	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:acB	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   57: invokestatic 49	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_2
    //   62: invokevirtual 53	java/io/InputStream:reset	()V
    //   65: new 55	com/tencent/mm/vfs/q
    //   68: dup
    //   69: new 57	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: getfield 64	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/q;
    //   80: invokevirtual 68	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 74
    //   88: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 80	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 84	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 87	com/tencent/mm/vfs/q:ifE	()Z
    //   111: ifeq +15 -> 126
    //   114: aload_1
    //   115: invokevirtual 90	com/tencent/mm/vfs/q:ifH	()Z
    //   118: ifeq +8 -> 126
    //   121: aload_1
    //   122: invokevirtual 93	com/tencent/mm/vfs/q:cFq	()Z
    //   125: pop
    //   126: aload_1
    //   127: invokevirtual 96	com/tencent/mm/vfs/q:ifL	()Z
    //   130: pop
    //   131: aload_3
    //   132: aload_0
    //   133: invokevirtual 99	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   136: invokestatic 105	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifne +51 -> 193
    //   145: aload_0
    //   146: invokevirtual 114	com/tencent/mm/vfs/q:isDirectory	()Z
    //   149: ifeq +60 -> 209
    //   152: invokestatic 120	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   155: new 57	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 122
    //   161: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: invokevirtual 68	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   168: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 127	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   177: pop
    //   178: aload_0
    //   179: invokestatic 131	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   182: astore_1
    //   183: aload_2
    //   184: aload_1
    //   185: invokestatic 137	com/tencent/mm/b/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   188: pop2
    //   189: aload_1
    //   190: invokestatic 141	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   193: aload_0
    //   194: invokevirtual 68	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   197: astore_0
    //   198: aload_2
    //   199: invokestatic 141	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   202: ldc 9
    //   204: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_0
    //   208: areturn
    //   209: aload_0
    //   210: invokevirtual 93	com/tencent/mm/vfs/q:cFq	()Z
    //   213: pop
    //   214: goto -36 -> 178
    //   217: astore_0
    //   218: ldc 143
    //   220: aload_0
    //   221: ldc 145
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload_2
    //   231: invokestatic 141	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   234: ldc 9
    //   236: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_0
    //   242: aload_2
    //   243: invokestatic 141	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   246: ldc 9
    //   248: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_0
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramWxaPkg	WxaPkg
    //   0	253	1	paramString	java.lang.String
    //   33	210	2	localInputStream	java.io.InputStream
    //   60	72	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   45	126	217	java/lang/Exception
    //   126	178	217	java/lang/Exception
    //   178	193	217	java/lang/Exception
    //   193	198	217	java/lang/Exception
    //   209	214	217	java/lang/Exception
    //   45	126	241	finally
    //   126	178	241	finally
    //   178	193	241	finally
    //   193	198	241	finally
    //   209	214	241	finally
    //   218	230	241	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */