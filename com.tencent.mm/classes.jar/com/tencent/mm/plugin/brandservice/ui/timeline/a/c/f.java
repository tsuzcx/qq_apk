package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f
{
  private static volatile f iiF = null;
  ExecutorService iiG = Executors.newFixedThreadPool(1);
  
  /* Error */
  public static boolean a(int paramInt, java.lang.String paramString1, java.util.Map<java.lang.String, java.lang.String> paramMap, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 42	java/lang/String:length	()I
    //   8: ifgt +19 -> 27
    //   11: ldc 44
    //   13: ldc 46
    //   15: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iload_0
    //   19: bipush 9
    //   21: iconst_1
    //   22: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   25: iconst_0
    //   26: ireturn
    //   27: new 60	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 67	java/io/File:exists	()Z
    //   40: ifeq +8 -> 48
    //   43: aload_3
    //   44: invokevirtual 70	java/io/File:delete	()Z
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 73	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: new 75	java/io/FileOutputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore 8
    //   63: aconst_null
    //   64: astore 6
    //   66: aconst_null
    //   67: astore 7
    //   69: aconst_null
    //   70: astore 5
    //   72: aload 7
    //   74: astore_3
    //   75: new 80	java/net/URL
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   83: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   86: checkcast 87	java/net/HttpURLConnection
    //   89: astore 9
    //   91: aload 7
    //   93: astore_3
    //   94: aload 9
    //   96: ldc 89
    //   98: ldc 91
    //   100: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 7
    //   105: astore_3
    //   106: aload 9
    //   108: ldc 89
    //   110: ldc 96
    //   112: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 7
    //   117: astore_3
    //   118: aload 9
    //   120: iconst_0
    //   121: invokevirtual 100	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   124: aload_2
    //   125: ifnull +204 -> 329
    //   128: aload 7
    //   130: astore_3
    //   131: aload_2
    //   132: invokeinterface 105 1 0
    //   137: ifle +192 -> 329
    //   140: aload 7
    //   142: astore_3
    //   143: ldc 44
    //   145: ldc 107
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_2
    //   154: invokeinterface 105 1 0
    //   159: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 117	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 7
    //   168: astore_3
    //   169: aload_2
    //   170: invokeinterface 121 1 0
    //   175: invokeinterface 127 1 0
    //   180: astore_1
    //   181: aload 7
    //   183: astore_3
    //   184: aload_1
    //   185: invokeinterface 132 1 0
    //   190: ifeq +139 -> 329
    //   193: aload 7
    //   195: astore_3
    //   196: aload_1
    //   197: invokeinterface 136 1 0
    //   202: checkcast 38	java/lang/String
    //   205: astore 10
    //   207: aload 7
    //   209: astore_3
    //   210: aload 9
    //   212: aload 10
    //   214: aload_2
    //   215: aload 10
    //   217: invokeinterface 140 2 0
    //   222: checkcast 38	java/lang/String
    //   225: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -47 -> 181
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_1
    //   235: astore_2
    //   236: ldc 44
    //   238: aload_3
    //   239: ldc 142
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 8
    //   250: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   253: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   256: aload 8
    //   258: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 161	java/io/InputStream:close	()V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_1
    //   272: ldc 44
    //   274: ldc 163
    //   276: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: ldc 44
    //   281: aload_1
    //   282: ldc 142
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: iload_0
    //   292: bipush 7
    //   294: iconst_1
    //   295: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_1
    //   301: ldc 44
    //   303: ldc 165
    //   305: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: ldc 44
    //   310: aload_1
    //   311: ldc 142
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: iload_0
    //   321: bipush 7
    //   323: iconst_1
    //   324: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   327: iconst_0
    //   328: ireturn
    //   329: aload 7
    //   331: astore_3
    //   332: aload 9
    //   334: iconst_0
    //   335: invokevirtual 168	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   338: aload 7
    //   340: astore_3
    //   341: aload 9
    //   343: ldc 170
    //   345: invokevirtual 173	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   348: aload 7
    //   350: astore_3
    //   351: aload 9
    //   353: sipush 10000
    //   356: invokevirtual 177	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   359: aload 7
    //   361: astore_3
    //   362: aload 9
    //   364: sipush 3000
    //   367: invokevirtual 180	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   370: aload 7
    //   372: astore_3
    //   373: aload 9
    //   375: invokevirtual 183	java/net/HttpURLConnection:connect	()V
    //   378: aload 7
    //   380: astore_3
    //   381: aload 9
    //   383: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   386: astore_1
    //   387: aload_1
    //   388: astore_2
    //   389: aload 9
    //   391: invokevirtual 190	java/net/HttpURLConnection:getResponseCode	()I
    //   394: istore 4
    //   396: iload 4
    //   398: sipush 200
    //   401: if_icmpne +83 -> 484
    //   404: aload_1
    //   405: astore_2
    //   406: sipush 8192
    //   409: newarray byte
    //   411: astore_3
    //   412: aload_1
    //   413: astore_2
    //   414: aload_1
    //   415: aload_3
    //   416: invokevirtual 194	java/io/InputStream:read	([B)I
    //   419: istore 4
    //   421: iload 4
    //   423: iconst_m1
    //   424: if_icmpeq +21 -> 445
    //   427: aload_1
    //   428: astore_2
    //   429: aload 8
    //   431: aload_3
    //   432: iconst_0
    //   433: iload 4
    //   435: invokevirtual 198	java/io/FileOutputStream:write	([BII)V
    //   438: goto -26 -> 412
    //   441: astore_3
    //   442: goto -208 -> 234
    //   445: aload 8
    //   447: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   450: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   453: aload 8
    //   455: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 161	java/io/InputStream:close	()V
    //   466: iconst_1
    //   467: ireturn
    //   468: astore_1
    //   469: ldc 44
    //   471: aload_1
    //   472: ldc 142
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: goto -15 -> 466
    //   484: aload_1
    //   485: astore_2
    //   486: ldc 44
    //   488: new 200	java/lang/StringBuilder
    //   491: dup
    //   492: ldc 202
    //   494: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: iload 4
    //   499: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 4
    //   510: sipush 500
    //   513: if_icmple +35 -> 548
    //   516: aload_1
    //   517: astore_2
    //   518: iload_0
    //   519: bipush 11
    //   521: iconst_1
    //   522: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   525: aload 8
    //   527: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   530: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   533: aload 8
    //   535: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   538: aload_1
    //   539: ifnull +7 -> 546
    //   542: aload_1
    //   543: invokevirtual 161	java/io/InputStream:close	()V
    //   546: iconst_0
    //   547: ireturn
    //   548: iload 4
    //   550: sipush 400
    //   553: if_icmple -28 -> 525
    //   556: aload_1
    //   557: astore_2
    //   558: iload_0
    //   559: bipush 10
    //   561: iconst_1
    //   562: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   565: goto -40 -> 525
    //   568: astore_2
    //   569: aload_1
    //   570: astore_3
    //   571: ldc 44
    //   573: aload_2
    //   574: ldc 142
    //   576: iconst_0
    //   577: anewarray 4	java/lang/Object
    //   580: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   583: aload 8
    //   585: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   588: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   591: aload 8
    //   593: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   596: aload_1
    //   597: ifnull -328 -> 269
    //   600: aload_1
    //   601: invokevirtual 161	java/io/InputStream:close	()V
    //   604: goto -335 -> 269
    //   607: astore_1
    //   608: ldc 44
    //   610: aload_1
    //   611: ldc 142
    //   613: iconst_0
    //   614: anewarray 4	java/lang/Object
    //   617: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: goto -351 -> 269
    //   623: astore_1
    //   624: ldc 44
    //   626: aload_1
    //   627: ldc 142
    //   629: iconst_0
    //   630: anewarray 4	java/lang/Object
    //   633: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: goto -90 -> 546
    //   639: astore_1
    //   640: ldc 44
    //   642: aload_1
    //   643: ldc 142
    //   645: iconst_0
    //   646: anewarray 4	java/lang/Object
    //   649: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   652: goto -383 -> 269
    //   655: astore_2
    //   656: aload 6
    //   658: astore_1
    //   659: aload_1
    //   660: astore_3
    //   661: ldc 44
    //   663: aload_2
    //   664: ldc 142
    //   666: iconst_0
    //   667: anewarray 4	java/lang/Object
    //   670: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: aload_1
    //   674: astore_3
    //   675: iload_0
    //   676: bipush 7
    //   678: iconst_1
    //   679: invokestatic 58	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   682: aload 8
    //   684: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   687: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   690: aload 8
    //   692: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   695: aload_1
    //   696: ifnull -427 -> 269
    //   699: aload_1
    //   700: invokevirtual 161	java/io/InputStream:close	()V
    //   703: goto -434 -> 269
    //   706: astore_1
    //   707: ldc 44
    //   709: aload_1
    //   710: ldc 142
    //   712: iconst_0
    //   713: anewarray 4	java/lang/Object
    //   716: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   719: goto -450 -> 269
    //   722: astore_1
    //   723: aload 8
    //   725: invokevirtual 150	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   728: invokevirtual 155	java/io/FileDescriptor:sync	()V
    //   731: aload 8
    //   733: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   736: aload_3
    //   737: ifnull +7 -> 744
    //   740: aload_3
    //   741: invokevirtual 161	java/io/InputStream:close	()V
    //   744: aload_1
    //   745: athrow
    //   746: astore_2
    //   747: ldc 44
    //   749: aload_2
    //   750: ldc 142
    //   752: iconst_0
    //   753: anewarray 4	java/lang/Object
    //   756: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: goto -15 -> 744
    //   762: astore_2
    //   763: goto -32 -> 731
    //   766: astore_1
    //   767: aload_2
    //   768: astore_3
    //   769: goto -46 -> 723
    //   772: astore_2
    //   773: goto -83 -> 690
    //   776: astore_2
    //   777: goto -118 -> 659
    //   780: astore_2
    //   781: goto -190 -> 591
    //   784: astore_2
    //   785: aload 5
    //   787: astore_1
    //   788: goto -219 -> 569
    //   791: astore_2
    //   792: goto -536 -> 256
    //   795: astore_2
    //   796: goto -263 -> 533
    //   799: astore_2
    //   800: goto -347 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	803	0	paramInt	int
    //   0	803	1	paramString1	java.lang.String
    //   0	803	2	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   0	803	3	paramString2	java.lang.String
    //   394	160	4	i	int
    //   70	716	5	localObject1	Object
    //   64	593	6	localObject2	Object
    //   67	312	7	localObject3	Object
    //   61	671	8	localFileOutputStream	java.io.FileOutputStream
    //   89	301	9	localHttpURLConnection	java.net.HttpURLConnection
    //   205	11	10	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   75	91	231	java/net/ProtocolException
    //   94	103	231	java/net/ProtocolException
    //   106	115	231	java/net/ProtocolException
    //   118	124	231	java/net/ProtocolException
    //   131	140	231	java/net/ProtocolException
    //   143	166	231	java/net/ProtocolException
    //   169	181	231	java/net/ProtocolException
    //   184	193	231	java/net/ProtocolException
    //   196	207	231	java/net/ProtocolException
    //   210	228	231	java/net/ProtocolException
    //   332	338	231	java/net/ProtocolException
    //   341	348	231	java/net/ProtocolException
    //   351	359	231	java/net/ProtocolException
    //   362	370	231	java/net/ProtocolException
    //   373	378	231	java/net/ProtocolException
    //   381	387	231	java/net/ProtocolException
    //   48	53	271	java/io/IOException
    //   53	63	300	java/io/FileNotFoundException
    //   389	396	441	java/net/ProtocolException
    //   406	412	441	java/net/ProtocolException
    //   414	421	441	java/net/ProtocolException
    //   429	438	441	java/net/ProtocolException
    //   486	508	441	java/net/ProtocolException
    //   518	525	441	java/net/ProtocolException
    //   558	565	441	java/net/ProtocolException
    //   445	453	468	java/io/IOException
    //   453	458	468	java/io/IOException
    //   462	466	468	java/io/IOException
    //   389	396	568	java/net/MalformedURLException
    //   406	412	568	java/net/MalformedURLException
    //   414	421	568	java/net/MalformedURLException
    //   429	438	568	java/net/MalformedURLException
    //   486	508	568	java/net/MalformedURLException
    //   518	525	568	java/net/MalformedURLException
    //   558	565	568	java/net/MalformedURLException
    //   583	591	607	java/io/IOException
    //   591	596	607	java/io/IOException
    //   600	604	607	java/io/IOException
    //   525	533	623	java/io/IOException
    //   533	538	623	java/io/IOException
    //   542	546	623	java/io/IOException
    //   248	256	639	java/io/IOException
    //   256	261	639	java/io/IOException
    //   265	269	639	java/io/IOException
    //   75	91	655	java/io/IOException
    //   94	103	655	java/io/IOException
    //   106	115	655	java/io/IOException
    //   118	124	655	java/io/IOException
    //   131	140	655	java/io/IOException
    //   143	166	655	java/io/IOException
    //   169	181	655	java/io/IOException
    //   184	193	655	java/io/IOException
    //   196	207	655	java/io/IOException
    //   210	228	655	java/io/IOException
    //   332	338	655	java/io/IOException
    //   341	348	655	java/io/IOException
    //   351	359	655	java/io/IOException
    //   362	370	655	java/io/IOException
    //   373	378	655	java/io/IOException
    //   381	387	655	java/io/IOException
    //   682	690	706	java/io/IOException
    //   690	695	706	java/io/IOException
    //   699	703	706	java/io/IOException
    //   75	91	722	finally
    //   94	103	722	finally
    //   106	115	722	finally
    //   118	124	722	finally
    //   131	140	722	finally
    //   143	166	722	finally
    //   169	181	722	finally
    //   184	193	722	finally
    //   196	207	722	finally
    //   210	228	722	finally
    //   332	338	722	finally
    //   341	348	722	finally
    //   351	359	722	finally
    //   362	370	722	finally
    //   373	378	722	finally
    //   381	387	722	finally
    //   571	583	722	finally
    //   661	673	722	finally
    //   675	682	722	finally
    //   723	731	746	java/io/IOException
    //   731	736	746	java/io/IOException
    //   740	744	746	java/io/IOException
    //   723	731	762	java/lang/Exception
    //   236	248	766	finally
    //   389	396	766	finally
    //   406	412	766	finally
    //   414	421	766	finally
    //   429	438	766	finally
    //   486	508	766	finally
    //   518	525	766	finally
    //   558	565	766	finally
    //   682	690	772	java/lang/Exception
    //   389	396	776	java/io/IOException
    //   406	412	776	java/io/IOException
    //   414	421	776	java/io/IOException
    //   429	438	776	java/io/IOException
    //   486	508	776	java/io/IOException
    //   518	525	776	java/io/IOException
    //   558	565	776	java/io/IOException
    //   583	591	780	java/lang/Exception
    //   75	91	784	java/net/MalformedURLException
    //   94	103	784	java/net/MalformedURLException
    //   106	115	784	java/net/MalformedURLException
    //   118	124	784	java/net/MalformedURLException
    //   131	140	784	java/net/MalformedURLException
    //   143	166	784	java/net/MalformedURLException
    //   169	181	784	java/net/MalformedURLException
    //   184	193	784	java/net/MalformedURLException
    //   196	207	784	java/net/MalformedURLException
    //   210	228	784	java/net/MalformedURLException
    //   332	338	784	java/net/MalformedURLException
    //   341	348	784	java/net/MalformedURLException
    //   351	359	784	java/net/MalformedURLException
    //   362	370	784	java/net/MalformedURLException
    //   373	378	784	java/net/MalformedURLException
    //   381	387	784	java/net/MalformedURLException
    //   248	256	791	java/lang/Exception
    //   525	533	795	java/lang/Exception
    //   445	453	799	java/lang/Exception
  }
  
  static f ayA()
  {
    if (iiF == null) {}
    try
    {
      if (iiF == null) {
        iiF = new f();
      }
      return iiF;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.f
 * JD-Core Version:    0.7.0.1
 */