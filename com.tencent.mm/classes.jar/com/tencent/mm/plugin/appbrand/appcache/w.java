package com.tencent.mm.plugin.appbrand.appcache;

public final class w
{
  /* Error */
  public static java.lang.String a(ao paramao, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 21	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +10 -> 23
    //   16: ldc 9
    //   18: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 30	com/tencent/mm/plugin/appbrand/appcache/ao:avO	()Z
    //   27: pop
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 34	com/tencent/mm/plugin/appbrand/appcache/ao:yw	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   57: invokestatic 49	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_2
    //   62: invokevirtual 53	java/io/InputStream:reset	()V
    //   65: new 55	java/io/File
    //   68: dup
    //   69: new 57	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: getfield 64	com/tencent/mm/plugin/appbrand/appcache/ao:gVL	Ljava/io/File;
    //   80: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 74
    //   88: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 84	java/io/File:getParentFile	()Ljava/io/File;
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 87	java/io/File:exists	()Z
    //   111: ifeq +15 -> 126
    //   114: aload_1
    //   115: invokevirtual 90	java/io/File:isFile	()Z
    //   118: ifeq +8 -> 126
    //   121: aload_1
    //   122: invokevirtual 93	java/io/File:delete	()Z
    //   125: pop
    //   126: aload_1
    //   127: invokevirtual 96	java/io/File:mkdirs	()Z
    //   130: pop
    //   131: aload_3
    //   132: aload_0
    //   133: invokestatic 100	com/tencent/mm/a/g:r	(Ljava/io/File;)Ljava/lang/String;
    //   136: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +55 -> 194
    //   142: aload_0
    //   143: invokevirtual 109	java/io/File:isDirectory	()Z
    //   146: ifeq +64 -> 210
    //   149: invokestatic 115	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   152: new 57	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 117
    //   158: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   165: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokevirtual 122	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   174: pop
    //   175: new 124	java/io/FileOutputStream
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   183: astore_1
    //   184: aload_2
    //   185: aload_1
    //   186: invokestatic 133	com/tencent/mm/a/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   189: pop2
    //   190: aload_1
    //   191: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   194: aload_0
    //   195: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   198: astore_0
    //   199: aload_2
    //   200: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   203: ldc 9
    //   205: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_0
    //   209: areturn
    //   210: aload_0
    //   211: invokevirtual 93	java/io/File:delete	()Z
    //   214: pop
    //   215: goto -40 -> 175
    //   218: astore_0
    //   219: ldc 138
    //   221: aload_0
    //   222: ldc 140
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 146	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: aload_2
    //   232: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   235: ldc 9
    //   237: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_0
    //   243: aload_2
    //   244: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   247: ldc 9
    //   249: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramao	ao
    //   0	254	1	paramString	java.lang.String
    //   33	211	2	localInputStream	java.io.InputStream
    //   60	72	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   45	126	218	java/lang/Exception
    //   126	175	218	java/lang/Exception
    //   175	194	218	java/lang/Exception
    //   194	199	218	java/lang/Exception
    //   210	215	218	java/lang/Exception
    //   45	126	242	finally
    //   126	175	242	finally
    //   175	194	242	finally
    //   194	199	242	finally
    //   210	215	242	finally
    //   219	231	242	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */