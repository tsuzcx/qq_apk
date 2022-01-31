package com.tencent.mm.plugin.freewifi.model;

public final class g
{
  int koF = 5;
  
  /* Error */
  static java.lang.String Dy(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 23	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 26	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 30	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 32	java/net/HttpURLConnection
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +59 -> 75
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   26: aload_0
    //   27: iconst_0
    //   28: invokevirtual 40	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   31: aload_0
    //   32: invokevirtual 44	java/net/HttpURLConnection:getResponseCode	()I
    //   35: istore_1
    //   36: aload_0
    //   37: ldc 46
    //   39: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_2
    //   43: ldc 51
    //   45: ldc 53
    //   47: iconst_2
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_2
    //   61: aastore
    //   62: invokestatic 65	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   73: aload_2
    //   74: areturn
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: ldc 51
    //   90: ldc 70
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_2
    //   99: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 77	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull -24 -> 83
    //   110: aload_0
    //   111: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   114: goto -31 -> 83
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   128: aload_2
    //   129: athrow
    //   130: astore_2
    //   131: goto -11 -> 120
    //   134: astore_2
    //   135: goto -15 -> 120
    //   138: astore_2
    //   139: goto -51 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	java.lang.String
    //   35	19	1	i	int
    //   42	32	2	str	java.lang.String
    //   85	14	2	localException1	java.lang.Exception
    //   117	12	2	localObject1	Object
    //   130	1	2	localObject2	Object
    //   134	1	2	localObject3	Object
    //   138	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	85	java/lang/Exception
    //   0	15	117	finally
    //   19	65	130	finally
    //   88	106	134	finally
    //   19	65	138	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.g
 * JD-Core Version:    0.7.0.1
 */