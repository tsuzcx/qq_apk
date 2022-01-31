package com.tencent.mm.plugin.appbrand.appcache;

final class q
{
  /* Error */
  static java.lang.String a(ai paramai, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 14	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: invokevirtual 20	com/tencent/mm/plugin/appbrand/appcache/ai:abX	()Z
    //   17: pop
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 24	com/tencent/mm/plugin/appbrand/appcache/ai:rb	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull -14 -> 11
    //   28: aload_2
    //   29: aload_2
    //   30: invokevirtual 30	java/io/InputStream:available	()I
    //   33: invokevirtual 34	java/io/InputStream:mark	(I)V
    //   36: aload_2
    //   37: sipush 4096
    //   40: invokestatic 40	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 44	java/io/InputStream:reset	()V
    //   48: new 46	java/io/File
    //   51: dup
    //   52: new 48	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   59: aload_0
    //   60: getfield 55	com/tencent/mm/plugin/appbrand/appcache/ai:fDw	Ljava/io/File;
    //   63: invokevirtual 59	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 65
    //   71: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 75	java/io/File:getParentFile	()Ljava/io/File;
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 78	java/io/File:exists	()Z
    //   94: ifeq +15 -> 109
    //   97: aload_1
    //   98: invokevirtual 81	java/io/File:isFile	()Z
    //   101: ifeq +8 -> 109
    //   104: aload_1
    //   105: invokevirtual 84	java/io/File:delete	()Z
    //   108: pop
    //   109: aload_1
    //   110: invokevirtual 87	java/io/File:mkdirs	()Z
    //   113: pop
    //   114: aload_3
    //   115: aload_0
    //   116: invokestatic 91	com/tencent/mm/a/g:m	(Ljava/io/File;)Ljava/lang/String;
    //   119: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +55 -> 177
    //   125: aload_0
    //   126: invokevirtual 100	java/io/File:isDirectory	()Z
    //   129: ifeq +59 -> 188
    //   132: invokestatic 106	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   135: new 48	java/lang/StringBuilder
    //   138: dup
    //   139: ldc 108
    //   141: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: invokevirtual 59	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 113	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   157: pop
    //   158: new 115	java/io/FileOutputStream
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: astore_1
    //   167: aload_2
    //   168: aload_1
    //   169: invokestatic 124	com/tencent/mm/a/e:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   172: pop2
    //   173: aload_1
    //   174: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: invokevirtual 59	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   181: astore_0
    //   182: aload_2
    //   183: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   186: aload_0
    //   187: areturn
    //   188: aload_0
    //   189: invokevirtual 84	java/io/File:delete	()Z
    //   192: pop
    //   193: goto -35 -> 158
    //   196: astore_0
    //   197: ldc 129
    //   199: aload_0
    //   200: ldc 131
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 137	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_2
    //   210: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aload_2
    //   217: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   220: aload_0
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramai	ai
    //   0	222	1	paramString	java.lang.String
    //   23	194	2	localInputStream	java.io.InputStream
    //   43	72	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   28	109	196	java/lang/Exception
    //   109	158	196	java/lang/Exception
    //   158	177	196	java/lang/Exception
    //   177	182	196	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   28	109	215	finally
    //   109	158	215	finally
    //   158	177	215	finally
    //   177	182	215	finally
    //   188	193	215	finally
    //   197	209	215	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */