package com.tencent.mm.modelappbrand.a;

final class b$l$4
  implements Runnable
{
  b$l$4(b.l paraml) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 17	com/tencent/mm/modelappbrand/a/b$l$4:fqQ	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   9: astore 10
    //   11: new 35	java/net/URL
    //   14: dup
    //   15: aload 10
    //   17: getfield 39	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   20: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 46	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 48	java/net/HttpURLConnection
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 52	java/net/HttpURLConnection:getResponseCode	()I
    //   42: sipush 301
    //   45: if_icmpeq +24 -> 69
    //   48: aload 4
    //   50: astore_2
    //   51: aload 4
    //   53: astore 5
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: invokevirtual 52	java/net/HttpURLConnection:getResponseCode	()I
    //   63: sipush 302
    //   66: if_icmpne +287 -> 353
    //   69: aload 4
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: ldc 54
    //   79: invokevirtual 58	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 5
    //   84: aload 4
    //   86: astore_2
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   95: invokevirtual 67	java/io/InputStream:close	()V
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   109: aload 4
    //   111: astore_2
    //   112: aload 4
    //   114: astore_3
    //   115: aload 5
    //   117: invokestatic 76	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
    //   120: ifne +17 -> 137
    //   123: aload 4
    //   125: astore_2
    //   126: aload 4
    //   128: astore_3
    //   129: aload 5
    //   131: invokestatic 79	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   134: ifne +184 -> 318
    //   137: aload 4
    //   139: astore_2
    //   140: aload 4
    //   142: astore_3
    //   143: new 81	java/net/MalformedURLException
    //   146: dup
    //   147: ldc 83
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload 10
    //   157: getfield 39	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 5
    //   165: aastore
    //   166: invokestatic 89	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokespecial 90	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   172: astore 5
    //   174: aload 4
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: ldc 27
    //   182: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 4
    //   187: astore_2
    //   188: aload 4
    //   190: astore_3
    //   191: aload 5
    //   193: athrow
    //   194: astore_3
    //   195: aload_2
    //   196: astore 6
    //   198: aconst_null
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_2
    //   203: aload 6
    //   205: astore 9
    //   207: aload 4
    //   209: astore 8
    //   211: aload_2
    //   212: astore 7
    //   214: ldc 95
    //   216: aload_3
    //   217: ldc 97
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload 10
    //   227: getfield 39	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload 6
    //   236: astore 9
    //   238: aload 4
    //   240: astore 8
    //   242: aload_2
    //   243: astore 7
    //   245: aload 10
    //   247: getfield 107	com/tencent/mm/modelappbrand/a/b$l:fqr	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   250: aload 10
    //   252: getfield 39	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   255: invokestatic 112	com/tencent/mm/modelappbrand/a/b:qB	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokeinterface 117 2 0
    //   263: pop
    //   264: aload 4
    //   266: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   269: aload_2
    //   270: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   273: aload 6
    //   275: ifnull +16 -> 291
    //   278: aload 6
    //   280: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   283: invokevirtual 67	java/io/InputStream:close	()V
    //   286: aload 6
    //   288: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   291: aload_0
    //   292: getfield 17	com/tencent/mm/modelappbrand/a/b$l$4:fqQ	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   295: getfield 127	com/tencent/mm/modelappbrand/a/b$l:fqH	Lcom/tencent/mm/modelappbrand/a/b;
    //   298: invokestatic 131	com/tencent/mm/modelappbrand/a/b:d	(Lcom/tencent/mm/modelappbrand/a/b;)Lcom/tencent/mm/modelappbrand/a/b$d;
    //   301: new 133	com/tencent/mm/modelappbrand/a/b$l$4$1
    //   304: dup
    //   305: aload_0
    //   306: invokespecial 136	com/tencent/mm/modelappbrand/a/b$l$4$1:<init>	(Lcom/tencent/mm/modelappbrand/a/b$l$4;)V
    //   309: invokevirtual 142	com/tencent/mm/modelappbrand/a/b$d:post	(Ljava/lang/Runnable;)V
    //   312: ldc 27
    //   314: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: return
    //   318: aload 4
    //   320: astore_2
    //   321: aload 4
    //   323: astore_3
    //   324: new 35	java/net/URL
    //   327: dup
    //   328: aload 5
    //   330: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 46	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   336: checkcast 48	java/net/HttpURLConnection
    //   339: astore 5
    //   341: aload 5
    //   343: astore_2
    //   344: aload 5
    //   346: astore_3
    //   347: aload 5
    //   349: iconst_0
    //   350: invokevirtual 146	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   353: aload 5
    //   355: astore 4
    //   357: aload 10
    //   359: getfield 107	com/tencent/mm/modelappbrand/a/b$l:fqr	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   362: aload 10
    //   364: getfield 39	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   367: invokestatic 112	com/tencent/mm/modelappbrand/a/b:qB	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokeinterface 150 2 0
    //   375: astore 5
    //   377: aload 5
    //   379: ifnonnull +46 -> 425
    //   382: aload 5
    //   384: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   387: aconst_null
    //   388: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   391: aload 4
    //   393: ifnull -102 -> 291
    //   396: aload 4
    //   398: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   401: invokevirtual 67	java/io/InputStream:close	()V
    //   404: aload 4
    //   406: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   409: goto -118 -> 291
    //   412: astore_2
    //   413: ldc 95
    //   415: aload_2
    //   416: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -18 -> 404
    //   425: new 160	java/io/BufferedInputStream
    //   428: dup
    //   429: aload 4
    //   431: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   434: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   437: astore_2
    //   438: aload 4
    //   440: astore 9
    //   442: aload 5
    //   444: astore 8
    //   446: aload_2
    //   447: astore 7
    //   449: sipush 16384
    //   452: newarray byte
    //   454: astore_3
    //   455: aload 4
    //   457: astore 9
    //   459: aload 5
    //   461: astore 8
    //   463: aload_2
    //   464: astore 7
    //   466: aload_2
    //   467: aload_3
    //   468: iconst_0
    //   469: sipush 16384
    //   472: invokevirtual 167	java/io/InputStream:read	([BII)I
    //   475: istore_1
    //   476: iload_1
    //   477: iconst_m1
    //   478: if_icmpeq +25 -> 503
    //   481: aload 4
    //   483: astore 9
    //   485: aload 5
    //   487: astore 8
    //   489: aload_2
    //   490: astore 7
    //   492: aload 5
    //   494: aload_3
    //   495: iconst_0
    //   496: iload_1
    //   497: invokevirtual 173	java/io/OutputStream:write	([BII)V
    //   500: goto -45 -> 455
    //   503: aload 4
    //   505: astore 9
    //   507: aload 5
    //   509: astore 8
    //   511: aload_2
    //   512: astore 7
    //   514: aload 5
    //   516: invokevirtual 176	java/io/OutputStream:flush	()V
    //   519: aload 5
    //   521: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   524: aload_2
    //   525: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   528: aload 4
    //   530: ifnull -239 -> 291
    //   533: aload 4
    //   535: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   538: invokevirtual 67	java/io/InputStream:close	()V
    //   541: aload 4
    //   543: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   546: goto -255 -> 291
    //   549: astore_2
    //   550: ldc 95
    //   552: aload_2
    //   553: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   556: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -18 -> 541
    //   562: astore_2
    //   563: ldc 95
    //   565: aload_2
    //   566: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: goto -286 -> 286
    //   575: astore_2
    //   576: aconst_null
    //   577: astore 6
    //   579: aconst_null
    //   580: astore_3
    //   581: aconst_null
    //   582: astore 4
    //   584: aload_3
    //   585: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   588: aload 4
    //   590: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   593: aload 6
    //   595: ifnull +16 -> 611
    //   598: aload 6
    //   600: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   603: invokevirtual 67	java/io/InputStream:close	()V
    //   606: aload 6
    //   608: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   611: ldc 27
    //   613: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: aload_2
    //   617: athrow
    //   618: astore_3
    //   619: ldc 95
    //   621: aload_3
    //   622: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   625: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: goto -22 -> 606
    //   631: astore_2
    //   632: aconst_null
    //   633: astore 5
    //   635: aconst_null
    //   636: astore 4
    //   638: aload_3
    //   639: astore 6
    //   641: aload 5
    //   643: astore_3
    //   644: goto -60 -> 584
    //   647: astore_2
    //   648: aconst_null
    //   649: astore_3
    //   650: aconst_null
    //   651: astore 5
    //   653: aload 4
    //   655: astore 6
    //   657: aload 5
    //   659: astore 4
    //   661: goto -77 -> 584
    //   664: astore_2
    //   665: aconst_null
    //   666: astore 7
    //   668: aload 4
    //   670: astore 6
    //   672: aload 5
    //   674: astore_3
    //   675: aload 7
    //   677: astore 4
    //   679: goto -95 -> 584
    //   682: astore_2
    //   683: aload 9
    //   685: astore 6
    //   687: aload 8
    //   689: astore_3
    //   690: aload 7
    //   692: astore 4
    //   694: goto -110 -> 584
    //   697: astore_3
    //   698: aconst_null
    //   699: astore 6
    //   701: aconst_null
    //   702: astore 4
    //   704: aconst_null
    //   705: astore_2
    //   706: goto -503 -> 203
    //   709: astore_3
    //   710: aconst_null
    //   711: astore 5
    //   713: aconst_null
    //   714: astore_2
    //   715: aload 4
    //   717: astore 6
    //   719: aload 5
    //   721: astore 4
    //   723: goto -520 -> 203
    //   726: astore_3
    //   727: aconst_null
    //   728: astore_2
    //   729: aload 4
    //   731: astore 6
    //   733: aload 5
    //   735: astore 4
    //   737: goto -534 -> 203
    //   740: astore_2
    //   741: goto -632 -> 109
    //   744: astore_3
    //   745: aload 4
    //   747: astore 6
    //   749: aload 5
    //   751: astore 4
    //   753: goto -550 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	4
    //   475	22	1	i	int
    //   33	311	2	localObject1	Object
    //   412	4	2	localException1	java.lang.Exception
    //   437	88	2	localBufferedInputStream	java.io.BufferedInputStream
    //   549	4	2	localException2	java.lang.Exception
    //   562	4	2	localException3	java.lang.Exception
    //   575	42	2	localObject2	Object
    //   631	1	2	localObject3	Object
    //   647	1	2	localObject4	Object
    //   664	1	2	localObject5	Object
    //   682	1	2	localObject6	Object
    //   705	24	2	localObject7	Object
    //   740	1	2	localThrowable	java.lang.Throwable
    //   36	155	3	localObject8	Object
    //   194	23	3	localException4	java.lang.Exception
    //   323	262	3	localObject9	Object
    //   618	21	3	localException5	java.lang.Exception
    //   643	47	3	localObject10	Object
    //   697	1	3	localException6	java.lang.Exception
    //   709	1	3	localException7	java.lang.Exception
    //   726	1	3	localException8	java.lang.Exception
    //   744	1	3	localException9	java.lang.Exception
    //   29	723	4	localObject11	Object
    //   53	697	5	localObject12	Object
    //   196	552	6	localObject13	Object
    //   212	479	7	localObject14	Object
    //   209	479	8	localObject15	Object
    //   205	479	9	localObject16	Object
    //   9	354	10	locall	b.l
    // Exception table:
    //   from	to	target	type
    //   37	48	194	java/lang/Exception
    //   58	69	194	java/lang/Exception
    //   75	84	194	java/lang/Exception
    //   90	98	194	java/lang/Exception
    //   104	109	194	java/lang/Exception
    //   115	123	194	java/lang/Exception
    //   129	137	194	java/lang/Exception
    //   143	174	194	java/lang/Exception
    //   180	185	194	java/lang/Exception
    //   191	194	194	java/lang/Exception
    //   324	341	194	java/lang/Exception
    //   347	353	194	java/lang/Exception
    //   396	404	412	java/lang/Exception
    //   533	541	549	java/lang/Exception
    //   278	286	562	java/lang/Exception
    //   11	31	575	finally
    //   598	606	618	java/lang/Exception
    //   37	48	631	finally
    //   58	69	631	finally
    //   75	84	631	finally
    //   90	98	631	finally
    //   104	109	631	finally
    //   115	123	631	finally
    //   129	137	631	finally
    //   143	174	631	finally
    //   180	185	631	finally
    //   191	194	631	finally
    //   324	341	631	finally
    //   347	353	631	finally
    //   357	377	647	finally
    //   425	438	664	finally
    //   214	234	682	finally
    //   245	264	682	finally
    //   449	455	682	finally
    //   466	476	682	finally
    //   492	500	682	finally
    //   514	519	682	finally
    //   11	31	697	java/lang/Exception
    //   357	377	709	java/lang/Exception
    //   425	438	726	java/lang/Exception
    //   90	98	740	java/lang/Throwable
    //   104	109	740	java/lang/Throwable
    //   449	455	744	java/lang/Exception
    //   466	476	744	java/lang/Exception
    //   492	500	744	java/lang/Exception
    //   514	519	744	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.l.4
 * JD-Core Version:    0.7.0.1
 */