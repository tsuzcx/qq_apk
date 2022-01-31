package com.tencent.mm.modelstat.a;

public final class b
{
  /* Error */
  public static int a(java.io.File paramFile, int paramInt)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_1
    //   6: iconst_1
    //   7: if_icmpne +223 -> 230
    //   10: ldc 23
    //   12: astore_2
    //   13: new 25	java/net/URL
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 29	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 33	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 35	javax/net/ssl/HttpsURLConnection
    //   27: astore 4
    //   29: aload 4
    //   31: iconst_1
    //   32: invokevirtual 39	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   35: aload 4
    //   37: iconst_1
    //   38: invokevirtual 42	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   41: aload 4
    //   43: iconst_0
    //   44: invokevirtual 45	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   47: aload 4
    //   49: ldc 47
    //   51: invokevirtual 50	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   54: aload 4
    //   56: ldc 52
    //   58: new 54	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: invokevirtual 63	java/io/File:length	()J
    //   69: invokevirtual 67	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 4
    //   80: ldc 77
    //   82: ldc 79
    //   84: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 4
    //   89: ldc 81
    //   91: ldc 83
    //   93: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: invokestatic 89	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   99: pop
    //   100: aload 4
    //   102: ldc 91
    //   104: invokestatic 96	com/tencent/mm/kernel/a:QC	()Ljava/lang/String;
    //   107: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: invokestatic 89	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   113: pop
    //   114: aload 4
    //   116: ldc 98
    //   118: invokestatic 96	com/tencent/mm/kernel/a:QC	()Ljava/lang/String;
    //   121: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iload_1
    //   125: iconst_1
    //   126: if_icmpne +110 -> 236
    //   129: aload 4
    //   131: ldc 100
    //   133: ldc 102
    //   135: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 4
    //   140: ldc 104
    //   142: ldc 106
    //   144: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 4
    //   149: ldc 108
    //   151: aconst_null
    //   152: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 4
    //   157: invokevirtual 112	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   160: astore_2
    //   161: sipush 10240
    //   164: newarray byte
    //   166: astore_3
    //   167: new 114	java/io/FileInputStream
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_0
    //   176: aload_0
    //   177: aload_3
    //   178: iconst_0
    //   179: sipush 10240
    //   182: invokevirtual 121	java/io/FileInputStream:read	([BII)I
    //   185: istore_1
    //   186: iload_1
    //   187: iconst_m1
    //   188: if_icmpeq +95 -> 283
    //   191: aload_2
    //   192: aload_3
    //   193: iconst_0
    //   194: iload_1
    //   195: invokevirtual 127	java/io/OutputStream:write	([BII)V
    //   198: goto -22 -> 176
    //   201: astore_2
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 130	java/io/FileInputStream:close	()V
    //   210: aload 4
    //   212: invokevirtual 134	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   215: invokevirtual 137	java/io/InputStream:close	()V
    //   218: aload 4
    //   220: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   223: ldc 15
    //   225: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: iconst_m1
    //   229: ireturn
    //   230: ldc 145
    //   232: astore_2
    //   233: goto -220 -> 13
    //   236: aload 4
    //   238: ldc 100
    //   240: ldc 147
    //   242: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload 4
    //   247: ldc 149
    //   249: ldc 147
    //   251: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 4
    //   256: ldc 104
    //   258: ldc 147
    //   260: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -116 -> 147
    //   266: astore_0
    //   267: ldc 151
    //   269: aload_0
    //   270: invokevirtual 154	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   273: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: ldc 15
    //   278: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: iconst_0
    //   282: ireturn
    //   283: aload_0
    //   284: invokevirtual 130	java/io/FileInputStream:close	()V
    //   287: ldc 151
    //   289: ldc 161
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload 4
    //   299: invokevirtual 165	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   302: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: invokestatic 174	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: aload 4
    //   311: invokevirtual 134	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   314: invokevirtual 137	java/io/InputStream:close	()V
    //   317: aload 4
    //   319: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   322: aload_2
    //   323: invokevirtual 175	java/io/OutputStream:close	()V
    //   326: goto -50 -> 276
    //   329: astore_0
    //   330: ldc 151
    //   332: aload_0
    //   333: invokevirtual 176	java/net/ProtocolException:getMessage	()Ljava/lang/String;
    //   336: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -63 -> 276
    //   342: astore_0
    //   343: ldc 151
    //   345: aload_0
    //   346: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   349: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -35 -> 317
    //   355: astore_0
    //   356: ldc 151
    //   358: aload_0
    //   359: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   362: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: goto -89 -> 276
    //   368: astore_0
    //   369: ldc 151
    //   371: aload_0
    //   372: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   375: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: ldc 15
    //   380: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: iconst_m1
    //   384: ireturn
    //   385: astore_0
    //   386: ldc 151
    //   388: aload_0
    //   389: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   392: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: goto -177 -> 218
    //   398: astore_0
    //   399: aconst_null
    //   400: astore_2
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 130	java/io/FileInputStream:close	()V
    //   409: aload 4
    //   411: invokevirtual 134	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   414: invokevirtual 137	java/io/InputStream:close	()V
    //   417: aload 4
    //   419: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   422: ldc 15
    //   424: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_0
    //   428: athrow
    //   429: astore_0
    //   430: ldc 151
    //   432: aload_0
    //   433: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   436: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: ldc 15
    //   441: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   444: iconst_m1
    //   445: ireturn
    //   446: astore_2
    //   447: ldc 151
    //   449: aload_2
    //   450: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   453: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: goto -39 -> 417
    //   459: astore_2
    //   460: aload_0
    //   461: astore_3
    //   462: aload_2
    //   463: astore_0
    //   464: aload_3
    //   465: astore_2
    //   466: goto -65 -> 401
    //   469: astore_0
    //   470: aconst_null
    //   471: astore_0
    //   472: goto -270 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramFile	java.io.File
    //   0	475	1	paramInt	int
    //   12	180	2	localObject1	Object
    //   201	1	2	localException1	java.lang.Exception
    //   232	174	2	str	java.lang.String
    //   446	4	2	localException2	java.lang.Exception
    //   459	4	2	localObject2	Object
    //   465	1	2	localObject3	Object
    //   166	299	3	localObject4	Object
    //   27	391	4	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   176	186	201	java/lang/Exception
    //   191	198	201	java/lang/Exception
    //   283	287	201	java/lang/Exception
    //   13	124	266	java/net/MalformedURLException
    //   129	147	266	java/net/MalformedURLException
    //   147	167	266	java/net/MalformedURLException
    //   206	210	266	java/net/MalformedURLException
    //   210	218	266	java/net/MalformedURLException
    //   218	223	266	java/net/MalformedURLException
    //   236	263	266	java/net/MalformedURLException
    //   309	317	266	java/net/MalformedURLException
    //   317	326	266	java/net/MalformedURLException
    //   343	352	266	java/net/MalformedURLException
    //   369	378	266	java/net/MalformedURLException
    //   386	395	266	java/net/MalformedURLException
    //   405	409	266	java/net/MalformedURLException
    //   409	417	266	java/net/MalformedURLException
    //   417	429	266	java/net/MalformedURLException
    //   430	439	266	java/net/MalformedURLException
    //   447	456	266	java/net/MalformedURLException
    //   13	124	329	java/net/ProtocolException
    //   129	147	329	java/net/ProtocolException
    //   147	167	329	java/net/ProtocolException
    //   206	210	329	java/net/ProtocolException
    //   210	218	329	java/net/ProtocolException
    //   218	223	329	java/net/ProtocolException
    //   236	263	329	java/net/ProtocolException
    //   309	317	329	java/net/ProtocolException
    //   317	326	329	java/net/ProtocolException
    //   343	352	329	java/net/ProtocolException
    //   369	378	329	java/net/ProtocolException
    //   386	395	329	java/net/ProtocolException
    //   405	409	329	java/net/ProtocolException
    //   409	417	329	java/net/ProtocolException
    //   417	429	329	java/net/ProtocolException
    //   430	439	329	java/net/ProtocolException
    //   447	456	329	java/net/ProtocolException
    //   309	317	342	java/lang/Exception
    //   13	124	355	java/io/IOException
    //   129	147	355	java/io/IOException
    //   147	167	355	java/io/IOException
    //   210	218	355	java/io/IOException
    //   218	223	355	java/io/IOException
    //   236	263	355	java/io/IOException
    //   309	317	355	java/io/IOException
    //   317	326	355	java/io/IOException
    //   343	352	355	java/io/IOException
    //   369	378	355	java/io/IOException
    //   386	395	355	java/io/IOException
    //   409	417	355	java/io/IOException
    //   417	429	355	java/io/IOException
    //   430	439	355	java/io/IOException
    //   447	456	355	java/io/IOException
    //   206	210	368	java/io/IOException
    //   210	218	385	java/lang/Exception
    //   167	176	398	finally
    //   287	309	398	finally
    //   405	409	429	java/io/IOException
    //   409	417	446	java/lang/Exception
    //   176	186	459	finally
    //   191	198	459	finally
    //   283	287	459	finally
    //   167	176	469	java/lang/Exception
    //   287	309	469	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.b
 * JD-Core Version:    0.7.0.1
 */