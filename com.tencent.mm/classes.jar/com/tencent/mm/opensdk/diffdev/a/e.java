package com.tencent.mm.opensdk.diffdev.a;

public final class e
{
  /* Error */
  public static byte[] a(java.lang.String paramString)
  {
    // Byte code:
    //   0: sipush 3730
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 26	java/lang/String:length	()I
    //   14: ifne +18 -> 32
    //   17: ldc 28
    //   19: ldc 30
    //   21: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 3730
    //   27: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: new 41	java/net/URL
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 45	java/net/URL:<init>	(Ljava/lang/String;)V
    //   40: invokevirtual 49	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   43: checkcast 51	java/net/HttpURLConnection
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +26 -> 74
    //   51: ldc 28
    //   53: ldc 53
    //   55: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   66: sipush 3730
    //   69: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_0
    //   75: ldc 59
    //   77: invokevirtual 62	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   80: aload_0
    //   81: ldc 63
    //   83: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   86: aload_0
    //   87: ldc 63
    //   89: invokevirtual 69	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   92: aload_0
    //   93: invokevirtual 72	java/net/HttpURLConnection:getResponseCode	()I
    //   96: sipush 300
    //   99: if_icmplt +26 -> 125
    //   102: ldc 28
    //   104: ldc 74
    //   106: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   117: sipush 3730
    //   120: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aconst_null
    //   124: areturn
    //   125: aload_0
    //   126: invokevirtual 78	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: astore_2
    //   130: new 80	java/io/ByteArrayOutputStream
    //   133: dup
    //   134: invokespecial 82	java/io/ByteArrayOutputStream:<init>	()V
    //   137: astore 4
    //   139: sipush 1024
    //   142: newarray byte
    //   144: astore_3
    //   145: aload_2
    //   146: aload_3
    //   147: invokevirtual 88	java/io/InputStream:read	([B)I
    //   150: istore_1
    //   151: iload_1
    //   152: iconst_m1
    //   153: if_icmpeq +87 -> 240
    //   156: aload 4
    //   158: aload_3
    //   159: iconst_0
    //   160: iload_1
    //   161: invokevirtual 92	java/io/ByteArrayOutputStream:write	([BII)V
    //   164: goto -19 -> 145
    //   167: astore 7
    //   169: aload_0
    //   170: astore_3
    //   171: aload 4
    //   173: astore_0
    //   174: aload_0
    //   175: astore 6
    //   177: aload_2
    //   178: astore 5
    //   180: aload_3
    //   181: astore 4
    //   183: ldc 28
    //   185: new 94	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 96
    //   191: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload 7
    //   196: invokevirtual 101	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_3
    //   209: ifnull +7 -> 216
    //   212: aload_3
    //   213: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 111	java/io/InputStream:close	()V
    //   224: aload_0
    //   225: ifnull +7 -> 232
    //   228: aload_0
    //   229: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   232: sipush 3730
    //   235: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aconst_null
    //   239: areturn
    //   240: aload 4
    //   242: invokevirtual 116	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   245: astore_3
    //   246: ldc 28
    //   248: ldc 118
    //   250: invokestatic 121	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: ifnull +7 -> 261
    //   257: aload_0
    //   258: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 111	java/io/InputStream:close	()V
    //   269: aload 4
    //   271: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   274: sipush 3730
    //   277: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_3
    //   281: areturn
    //   282: astore_3
    //   283: aconst_null
    //   284: astore_0
    //   285: aconst_null
    //   286: astore 7
    //   288: aconst_null
    //   289: astore_2
    //   290: aload_0
    //   291: astore 6
    //   293: aload 7
    //   295: astore 5
    //   297: aload_2
    //   298: astore 4
    //   300: ldc 28
    //   302: new 94	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 96
    //   308: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload_3
    //   312: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   332: aload 7
    //   334: ifnull +8 -> 342
    //   337: aload 7
    //   339: invokevirtual 111	java/io/InputStream:close	()V
    //   342: aload_0
    //   343: ifnull +7 -> 350
    //   346: aload_0
    //   347: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   350: sipush 3730
    //   353: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aconst_null
    //   357: areturn
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_0
    //   361: aconst_null
    //   362: astore 7
    //   364: aconst_null
    //   365: astore_2
    //   366: aload_0
    //   367: astore 6
    //   369: aload 7
    //   371: astore 5
    //   373: aload_2
    //   374: astore 4
    //   376: ldc 28
    //   378: new 94	java/lang/StringBuilder
    //   381: dup
    //   382: ldc 96
    //   384: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_3
    //   388: invokevirtual 123	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 36	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   408: aload 7
    //   410: ifnull +8 -> 418
    //   413: aload 7
    //   415: invokevirtual 111	java/io/InputStream:close	()V
    //   418: aload_0
    //   419: ifnull +7 -> 426
    //   422: aload_0
    //   423: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   426: sipush 3730
    //   429: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aconst_null
    //   433: areturn
    //   434: astore_0
    //   435: aconst_null
    //   436: astore_3
    //   437: aconst_null
    //   438: astore 5
    //   440: aconst_null
    //   441: astore_2
    //   442: aload_2
    //   443: ifnull +7 -> 450
    //   446: aload_2
    //   447: invokevirtual 57	java/net/HttpURLConnection:disconnect	()V
    //   450: aload 5
    //   452: ifnull +8 -> 460
    //   455: aload 5
    //   457: invokevirtual 111	java/io/InputStream:close	()V
    //   460: aload_3
    //   461: ifnull +7 -> 468
    //   464: aload_3
    //   465: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   468: sipush 3730
    //   471: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: aload_0
    //   475: athrow
    //   476: astore_0
    //   477: goto -411 -> 66
    //   480: astore_0
    //   481: goto -364 -> 117
    //   484: astore_0
    //   485: goto -224 -> 261
    //   488: astore_0
    //   489: goto -220 -> 269
    //   492: astore_0
    //   493: goto -219 -> 274
    //   496: astore_3
    //   497: goto -281 -> 216
    //   500: astore_2
    //   501: goto -277 -> 224
    //   504: astore_0
    //   505: goto -273 -> 232
    //   508: astore_2
    //   509: goto -177 -> 332
    //   512: astore_2
    //   513: goto -171 -> 342
    //   516: astore_0
    //   517: goto -167 -> 350
    //   520: astore_2
    //   521: goto -113 -> 408
    //   524: astore_2
    //   525: goto -107 -> 418
    //   528: astore_0
    //   529: goto -103 -> 426
    //   532: astore_2
    //   533: goto -83 -> 450
    //   536: astore_2
    //   537: goto -77 -> 460
    //   540: astore_2
    //   541: goto -73 -> 468
    //   544: astore 4
    //   546: aconst_null
    //   547: astore_3
    //   548: aconst_null
    //   549: astore 5
    //   551: aload_0
    //   552: astore_2
    //   553: aload 4
    //   555: astore_0
    //   556: goto -114 -> 442
    //   559: astore 5
    //   561: aconst_null
    //   562: astore_3
    //   563: aload_0
    //   564: astore 4
    //   566: aload 5
    //   568: astore_0
    //   569: aload_2
    //   570: astore 5
    //   572: aload 4
    //   574: astore_2
    //   575: goto -133 -> 442
    //   578: astore_3
    //   579: aload_0
    //   580: astore 6
    //   582: aload_3
    //   583: astore_0
    //   584: aload 4
    //   586: astore_3
    //   587: aload_2
    //   588: astore 5
    //   590: aload 6
    //   592: astore_2
    //   593: goto -151 -> 442
    //   596: astore_0
    //   597: aload 6
    //   599: astore_3
    //   600: aload 4
    //   602: astore_2
    //   603: goto -161 -> 442
    //   606: astore_3
    //   607: aconst_null
    //   608: astore 4
    //   610: aconst_null
    //   611: astore 7
    //   613: aload_0
    //   614: astore_2
    //   615: aload 4
    //   617: astore_0
    //   618: goto -252 -> 366
    //   621: astore_3
    //   622: aconst_null
    //   623: astore 5
    //   625: aload_0
    //   626: astore 4
    //   628: aload 5
    //   630: astore_0
    //   631: aload_2
    //   632: astore 7
    //   634: aload 4
    //   636: astore_2
    //   637: goto -271 -> 366
    //   640: astore_3
    //   641: aload_0
    //   642: astore 5
    //   644: aload 4
    //   646: astore_0
    //   647: aload_2
    //   648: astore 7
    //   650: aload 5
    //   652: astore_2
    //   653: goto -287 -> 366
    //   656: astore_3
    //   657: aconst_null
    //   658: astore 4
    //   660: aconst_null
    //   661: astore 7
    //   663: aload_0
    //   664: astore_2
    //   665: aload 4
    //   667: astore_0
    //   668: goto -378 -> 290
    //   671: astore_3
    //   672: aconst_null
    //   673: astore 5
    //   675: aload_0
    //   676: astore 4
    //   678: aload 5
    //   680: astore_0
    //   681: aload_2
    //   682: astore 7
    //   684: aload 4
    //   686: astore_2
    //   687: goto -397 -> 290
    //   690: astore_3
    //   691: aload_0
    //   692: astore 5
    //   694: aload 4
    //   696: astore_0
    //   697: aload_2
    //   698: astore 7
    //   700: aload 5
    //   702: astore_2
    //   703: goto -413 -> 290
    //   706: astore 7
    //   708: aconst_null
    //   709: astore_0
    //   710: aconst_null
    //   711: astore_2
    //   712: aconst_null
    //   713: astore_3
    //   714: goto -540 -> 174
    //   717: astore 7
    //   719: aconst_null
    //   720: astore 4
    //   722: aconst_null
    //   723: astore_2
    //   724: aload_0
    //   725: astore_3
    //   726: aload 4
    //   728: astore_0
    //   729: goto -555 -> 174
    //   732: astore 7
    //   734: aconst_null
    //   735: astore 4
    //   737: aload_0
    //   738: astore_3
    //   739: aload 4
    //   741: astore_0
    //   742: goto -568 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	paramString	java.lang.String
    //   150	11	1	i	int
    //   129	318	2	localInputStream	java.io.InputStream
    //   500	1	2	localThrowable1	java.lang.Throwable
    //   508	1	2	localThrowable2	java.lang.Throwable
    //   512	1	2	localThrowable3	java.lang.Throwable
    //   520	1	2	localThrowable4	java.lang.Throwable
    //   524	1	2	localThrowable5	java.lang.Throwable
    //   532	1	2	localThrowable6	java.lang.Throwable
    //   536	1	2	localThrowable7	java.lang.Throwable
    //   540	1	2	localThrowable8	java.lang.Throwable
    //   552	172	2	localObject1	Object
    //   144	137	3	localObject2	Object
    //   282	30	3	localIOException1	java.io.IOException
    //   358	30	3	localException1	java.lang.Exception
    //   436	29	3	localObject3	Object
    //   496	1	3	localThrowable9	java.lang.Throwable
    //   547	16	3	localObject4	Object
    //   578	5	3	localObject5	Object
    //   586	14	3	localObject6	Object
    //   606	1	3	localException2	java.lang.Exception
    //   621	1	3	localException3	java.lang.Exception
    //   640	1	3	localException4	java.lang.Exception
    //   656	1	3	localIOException2	java.io.IOException
    //   671	1	3	localIOException3	java.io.IOException
    //   690	1	3	localIOException4	java.io.IOException
    //   713	26	3	str1	java.lang.String
    //   137	238	4	localObject7	Object
    //   544	10	4	localObject8	Object
    //   564	176	4	str2	java.lang.String
    //   178	372	5	localObject9	Object
    //   559	8	5	localObject10	Object
    //   570	131	5	localObject11	Object
    //   175	423	6	str3	java.lang.String
    //   167	28	7	localMalformedURLException1	java.net.MalformedURLException
    //   286	413	7	localObject12	Object
    //   706	1	7	localMalformedURLException2	java.net.MalformedURLException
    //   717	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   732	1	7	localMalformedURLException4	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   139	145	167	java/net/MalformedURLException
    //   145	151	167	java/net/MalformedURLException
    //   156	164	167	java/net/MalformedURLException
    //   240	253	167	java/net/MalformedURLException
    //   32	47	282	java/io/IOException
    //   32	47	358	java/lang/Exception
    //   32	47	434	finally
    //   62	66	476	java/lang/Throwable
    //   113	117	480	java/lang/Throwable
    //   257	261	484	java/lang/Throwable
    //   265	269	488	java/lang/Throwable
    //   269	274	492	java/lang/Throwable
    //   212	216	496	java/lang/Throwable
    //   220	224	500	java/lang/Throwable
    //   228	232	504	java/lang/Throwable
    //   328	332	508	java/lang/Throwable
    //   337	342	512	java/lang/Throwable
    //   346	350	516	java/lang/Throwable
    //   404	408	520	java/lang/Throwable
    //   413	418	524	java/lang/Throwable
    //   422	426	528	java/lang/Throwable
    //   446	450	532	java/lang/Throwable
    //   455	460	536	java/lang/Throwable
    //   464	468	540	java/lang/Throwable
    //   51	58	544	finally
    //   74	109	544	finally
    //   125	130	544	finally
    //   130	139	559	finally
    //   139	145	578	finally
    //   145	151	578	finally
    //   156	164	578	finally
    //   240	253	578	finally
    //   183	208	596	finally
    //   300	324	596	finally
    //   376	400	596	finally
    //   51	58	606	java/lang/Exception
    //   74	109	606	java/lang/Exception
    //   125	130	606	java/lang/Exception
    //   130	139	621	java/lang/Exception
    //   139	145	640	java/lang/Exception
    //   145	151	640	java/lang/Exception
    //   156	164	640	java/lang/Exception
    //   240	253	640	java/lang/Exception
    //   51	58	656	java/io/IOException
    //   74	109	656	java/io/IOException
    //   125	130	656	java/io/IOException
    //   130	139	671	java/io/IOException
    //   139	145	690	java/io/IOException
    //   145	151	690	java/io/IOException
    //   156	164	690	java/io/IOException
    //   240	253	690	java/io/IOException
    //   32	47	706	java/net/MalformedURLException
    //   51	58	717	java/net/MalformedURLException
    //   74	109	717	java/net/MalformedURLException
    //   125	130	717	java/net/MalformedURLException
    //   130	139	732	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.e
 * JD-Core Version:    0.7.0.1
 */