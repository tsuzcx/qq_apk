package com.tencent.mm.plugin.m.a.c;

public final class a
{
  /* Error */
  public static java.lang.String aS(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokevirtual 35	java/io/InputStream:available	()I
    //   20: newarray byte
    //   22: astore_2
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual 39	java/io/InputStream:read	([B)I
    //   30: pop
    //   31: aload_1
    //   32: astore_0
    //   33: new 41	java/lang/String
    //   36: dup
    //   37: aload_2
    //   38: getstatic 47	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   41: invokespecial 51	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 55	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 55	java/io/InputStream:close	()V
    //   59: ldc 11
    //   61: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_2
    //   65: areturn
    //   66: astore_0
    //   67: ldc 60
    //   69: aload_0
    //   70: ldc 62
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -20 -> 59
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 60
    //   89: aload_2
    //   90: ldc 70
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 55	java/io/InputStream:close	()V
    //   107: ldc 11
    //   109: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: ldc 60
    //   117: aload_0
    //   118: ldc 62
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -20 -> 107
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 55	java/io/InputStream:close	()V
    //   141: ldc 11
    //   143: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_0
    //   149: ldc 60
    //   151: aload_0
    //   152: ldc 62
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: goto -20 -> 141
    //   164: astore_1
    //   165: goto -32 -> 133
    //   168: astore_2
    //   169: goto -84 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	android.content.Context
    //   0	172	1	paramString	java.lang.String
    //   22	43	2	localObject	Object
    //   82	8	2	localException1	java.lang.Exception
    //   168	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   55	59	66	java/io/IOException
    //   5	14	82	java/lang/Exception
    //   103	107	114	java/io/IOException
    //   5	14	130	finally
    //   137	141	148	java/io/IOException
    //   16	23	164	finally
    //   25	31	164	finally
    //   33	45	164	finally
    //   47	51	164	finally
    //   87	99	164	finally
    //   16	23	168	java/lang/Exception
    //   25	31	168	java/lang/Exception
    //   33	45	168	java/lang/Exception
    //   47	51	168	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.c.a
 * JD-Core Version:    0.7.0.1
 */