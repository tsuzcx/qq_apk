package com.tencent.mm.plugin.freewifi.model;

public final class g
{
  int mKs = 5;
  
  /* Error */
  static java.lang.String OG(java.lang.String paramString)
  {
    // Byte code:
    //   0: sipush 20726
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 29	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 38	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +85 -> 107
    //   25: aload_0
    //   26: sipush 30000
    //   29: invokevirtual 41	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload_0
    //   33: iconst_0
    //   34: invokevirtual 45	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   37: aload_0
    //   38: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
    //   41: istore_1
    //   42: aload_0
    //   43: ldc 51
    //   45: invokevirtual 54	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_2
    //   49: ldc 56
    //   51: ldc 58
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: iload_1
    //   60: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: aastore
    //   68: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: ifnull +14 -> 86
    //   75: aload_0
    //   76: invokevirtual 73	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   79: invokevirtual 78	java/io/InputStream:close	()V
    //   82: aload_0
    //   83: invokevirtual 81	java/net/HttpURLConnection:disconnect	()V
    //   86: sipush 20726
    //   89: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: astore_3
    //   95: ldc 56
    //   97: aload_3
    //   98: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: goto -22 -> 82
    //   107: aload_0
    //   108: ifnull +14 -> 122
    //   111: aload_0
    //   112: invokevirtual 73	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   115: invokevirtual 78	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: invokevirtual 81	java/net/HttpURLConnection:disconnect	()V
    //   122: sipush 20726
    //   125: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: ldc 56
    //   133: aload_2
    //   134: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -22 -> 118
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_0
    //   146: ldc 56
    //   148: ldc 94
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_2
    //   157: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   160: aastore
    //   161: invokestatic 96	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: ifnull -43 -> 122
    //   168: aload_0
    //   169: invokevirtual 73	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   172: invokevirtual 78	java/io/InputStream:close	()V
    //   175: aload_0
    //   176: invokevirtual 81	java/net/HttpURLConnection:disconnect	()V
    //   179: goto -57 -> 122
    //   182: astore_2
    //   183: ldc 56
    //   185: aload_2
    //   186: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   189: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -17 -> 175
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: ifnull +14 -> 213
    //   202: aload_0
    //   203: invokevirtual 73	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   206: invokevirtual 78	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: invokevirtual 81	java/net/HttpURLConnection:disconnect	()V
    //   213: sipush 20726
    //   216: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: athrow
    //   221: astore_3
    //   222: ldc 56
    //   224: aload_3
    //   225: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   228: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -22 -> 209
    //   234: astore_2
    //   235: goto -37 -> 198
    //   238: astore_2
    //   239: goto -41 -> 198
    //   242: astore_2
    //   243: goto -97 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	java.lang.String
    //   41	19	1	i	int
    //   48	45	2	str	java.lang.String
    //   130	4	2	localException1	java.lang.Exception
    //   143	14	2	localException2	java.lang.Exception
    //   182	4	2	localException3	java.lang.Exception
    //   195	25	2	localObject1	Object
    //   234	1	2	localObject2	Object
    //   238	1	2	localObject3	Object
    //   242	1	2	localException4	java.lang.Exception
    //   94	4	3	localException5	java.lang.Exception
    //   221	4	3	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   75	82	94	java/lang/Exception
    //   111	118	130	java/lang/Exception
    //   6	21	143	java/lang/Exception
    //   168	175	182	java/lang/Exception
    //   6	21	195	finally
    //   202	209	221	java/lang/Exception
    //   25	71	234	finally
    //   146	164	238	finally
    //   25	71	242	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.g
 * JD-Core Version:    0.7.0.1
 */