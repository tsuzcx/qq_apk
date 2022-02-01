package com.tencent.mm.modelstat.a;

public final class b
{
  /* Error */
  public static int a(com.tencent.mm.vfs.e parame, int paramInt)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_1
    //   6: iconst_1
    //   7: if_icmpne +219 -> 226
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
    //   66: invokevirtual 63	com/tencent/mm/vfs/e:length	()J
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
    //   96: invokestatic 89	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
    //   99: pop
    //   100: aload 4
    //   102: ldc 91
    //   104: invokestatic 96	com/tencent/mm/kernel/a:aeo	()Ljava/lang/String;
    //   107: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: invokestatic 89	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
    //   113: pop
    //   114: aload 4
    //   116: ldc 98
    //   118: invokestatic 96	com/tencent/mm/kernel/a:aeo	()Ljava/lang/String;
    //   121: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iload_1
    //   125: iconst_1
    //   126: if_icmpne +106 -> 232
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
    //   167: aload_0
    //   168: invokestatic 118	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   171: astore_0
    //   172: aload_0
    //   173: aload_3
    //   174: iconst_0
    //   175: sipush 10240
    //   178: invokevirtual 124	java/io/InputStream:read	([BII)I
    //   181: istore_1
    //   182: iload_1
    //   183: iconst_m1
    //   184: if_icmpeq +95 -> 279
    //   187: aload_2
    //   188: aload_3
    //   189: iconst_0
    //   190: iload_1
    //   191: invokevirtual 130	java/io/OutputStream:write	([BII)V
    //   194: goto -22 -> 172
    //   197: astore_2
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 133	java/io/InputStream:close	()V
    //   206: aload 4
    //   208: invokevirtual 137	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   211: invokevirtual 133	java/io/InputStream:close	()V
    //   214: aload 4
    //   216: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   219: ldc 15
    //   221: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iconst_m1
    //   225: ireturn
    //   226: ldc 145
    //   228: astore_2
    //   229: goto -216 -> 13
    //   232: aload 4
    //   234: ldc 100
    //   236: ldc 147
    //   238: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 4
    //   243: ldc 149
    //   245: ldc 147
    //   247: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 4
    //   252: ldc 104
    //   254: ldc 147
    //   256: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -112 -> 147
    //   262: astore_0
    //   263: ldc 151
    //   265: aload_0
    //   266: invokevirtual 154	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   269: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: ldc 15
    //   274: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_0
    //   280: invokevirtual 133	java/io/InputStream:close	()V
    //   283: ldc 151
    //   285: ldc 161
    //   287: iconst_1
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload 4
    //   295: invokevirtual 165	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   298: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: aload 4
    //   307: invokevirtual 137	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   310: invokevirtual 133	java/io/InputStream:close	()V
    //   313: aload 4
    //   315: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   318: aload_2
    //   319: invokevirtual 175	java/io/OutputStream:close	()V
    //   322: goto -50 -> 272
    //   325: astore_0
    //   326: ldc 151
    //   328: aload_0
    //   329: invokevirtual 176	java/net/ProtocolException:getMessage	()Ljava/lang/String;
    //   332: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -63 -> 272
    //   338: astore_0
    //   339: ldc 151
    //   341: aload_0
    //   342: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   345: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: goto -35 -> 313
    //   351: astore_0
    //   352: ldc 151
    //   354: aload_0
    //   355: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto -89 -> 272
    //   364: astore_0
    //   365: ldc 151
    //   367: aload_0
    //   368: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   371: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: ldc 15
    //   376: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: iconst_m1
    //   380: ireturn
    //   381: astore_0
    //   382: ldc 151
    //   384: aload_0
    //   385: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: goto -177 -> 214
    //   394: astore_0
    //   395: aconst_null
    //   396: astore_2
    //   397: aload_2
    //   398: ifnull +7 -> 405
    //   401: aload_2
    //   402: invokevirtual 133	java/io/InputStream:close	()V
    //   405: aload 4
    //   407: invokevirtual 137	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   410: invokevirtual 133	java/io/InputStream:close	()V
    //   413: aload 4
    //   415: invokevirtual 140	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   418: ldc 15
    //   420: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_0
    //   424: athrow
    //   425: astore_0
    //   426: ldc 151
    //   428: aload_0
    //   429: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   432: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: ldc 15
    //   437: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iconst_m1
    //   441: ireturn
    //   442: astore_2
    //   443: ldc 151
    //   445: aload_2
    //   446: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: goto -39 -> 413
    //   455: astore_2
    //   456: aload_0
    //   457: astore_3
    //   458: aload_2
    //   459: astore_0
    //   460: aload_3
    //   461: astore_2
    //   462: goto -65 -> 397
    //   465: astore_0
    //   466: aconst_null
    //   467: astore_0
    //   468: goto -270 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	parame	com.tencent.mm.vfs.e
    //   0	471	1	paramInt	int
    //   12	176	2	localObject1	Object
    //   197	1	2	localException1	java.lang.Exception
    //   228	174	2	str	java.lang.String
    //   442	4	2	localException2	java.lang.Exception
    //   455	4	2	localObject2	Object
    //   461	1	2	localObject3	Object
    //   166	295	3	localObject4	Object
    //   27	387	4	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   172	182	197	java/lang/Exception
    //   187	194	197	java/lang/Exception
    //   279	283	197	java/lang/Exception
    //   13	124	262	java/net/MalformedURLException
    //   129	147	262	java/net/MalformedURLException
    //   147	167	262	java/net/MalformedURLException
    //   202	206	262	java/net/MalformedURLException
    //   206	214	262	java/net/MalformedURLException
    //   214	219	262	java/net/MalformedURLException
    //   232	259	262	java/net/MalformedURLException
    //   305	313	262	java/net/MalformedURLException
    //   313	322	262	java/net/MalformedURLException
    //   339	348	262	java/net/MalformedURLException
    //   365	374	262	java/net/MalformedURLException
    //   382	391	262	java/net/MalformedURLException
    //   401	405	262	java/net/MalformedURLException
    //   405	413	262	java/net/MalformedURLException
    //   413	425	262	java/net/MalformedURLException
    //   426	435	262	java/net/MalformedURLException
    //   443	452	262	java/net/MalformedURLException
    //   13	124	325	java/net/ProtocolException
    //   129	147	325	java/net/ProtocolException
    //   147	167	325	java/net/ProtocolException
    //   202	206	325	java/net/ProtocolException
    //   206	214	325	java/net/ProtocolException
    //   214	219	325	java/net/ProtocolException
    //   232	259	325	java/net/ProtocolException
    //   305	313	325	java/net/ProtocolException
    //   313	322	325	java/net/ProtocolException
    //   339	348	325	java/net/ProtocolException
    //   365	374	325	java/net/ProtocolException
    //   382	391	325	java/net/ProtocolException
    //   401	405	325	java/net/ProtocolException
    //   405	413	325	java/net/ProtocolException
    //   413	425	325	java/net/ProtocolException
    //   426	435	325	java/net/ProtocolException
    //   443	452	325	java/net/ProtocolException
    //   305	313	338	java/lang/Exception
    //   13	124	351	java/io/IOException
    //   129	147	351	java/io/IOException
    //   147	167	351	java/io/IOException
    //   206	214	351	java/io/IOException
    //   214	219	351	java/io/IOException
    //   232	259	351	java/io/IOException
    //   305	313	351	java/io/IOException
    //   313	322	351	java/io/IOException
    //   339	348	351	java/io/IOException
    //   365	374	351	java/io/IOException
    //   382	391	351	java/io/IOException
    //   405	413	351	java/io/IOException
    //   413	425	351	java/io/IOException
    //   426	435	351	java/io/IOException
    //   443	452	351	java/io/IOException
    //   202	206	364	java/io/IOException
    //   206	214	381	java/lang/Exception
    //   167	172	394	finally
    //   283	305	394	finally
    //   401	405	425	java/io/IOException
    //   405	413	442	java/lang/Exception
    //   172	182	455	finally
    //   187	194	455	finally
    //   279	283	455	finally
    //   167	172	465	java/lang/Exception
    //   283	305	465	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.b
 * JD-Core Version:    0.7.0.1
 */