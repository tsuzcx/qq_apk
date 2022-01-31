package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.g;

final class b$a
  implements Runnable
{
  g muk;
  
  public b$a(g paramg)
  {
    this.muk = paramg;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   9: getfield 37	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/acq;
    //   12: getfield 43	com/tencent/mm/protocal/protobuf/acq:wVc	Ljava/util/LinkedList;
    //   15: astore 13
    //   17: aload 13
    //   19: invokeinterface 49 1 0
    //   24: ifle +881 -> 905
    //   27: iconst_0
    //   28: istore 4
    //   30: iconst_0
    //   31: istore_3
    //   32: aload 13
    //   34: invokeinterface 49 1 0
    //   39: istore_2
    //   40: ldc 51
    //   42: ldc 53
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   54: getfield 57	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   57: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   68: getfield 57	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   71: bipush 18
    //   73: if_icmpne +63 -> 136
    //   76: aload_0
    //   77: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   80: getfield 71	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
    //   83: bipush 6
    //   85: if_icmpne +51 -> 136
    //   88: iconst_0
    //   89: istore_1
    //   90: iload_3
    //   91: istore 4
    //   93: iload_1
    //   94: iload_2
    //   95: if_icmpge +797 -> 892
    //   98: aload 13
    //   100: iload_1
    //   101: invokeinterface 75 2 0
    //   106: checkcast 77	com/tencent/mm/protocal/protobuf/aca
    //   109: astore 9
    //   111: aload 9
    //   113: getfield 81	com/tencent/mm/protocal/protobuf/aca:wTo	Z
    //   116: ifeq +11 -> 127
    //   119: aload 9
    //   121: getfield 84	com/tencent/mm/protocal/protobuf/aca:wTq	Z
    //   124: ifne +807 -> 931
    //   127: iconst_1
    //   128: istore_3
    //   129: iload_1
    //   130: iconst_1
    //   131: iadd
    //   132: istore_1
    //   133: goto -43 -> 90
    //   136: iconst_0
    //   137: istore_1
    //   138: iload 4
    //   140: istore_3
    //   141: iload_3
    //   142: istore 4
    //   144: iload_1
    //   145: iload_2
    //   146: if_icmpge +746 -> 892
    //   149: aload 13
    //   151: iload_1
    //   152: invokeinterface 75 2 0
    //   157: checkcast 77	com/tencent/mm/protocal/protobuf/aca
    //   160: astore 14
    //   162: aload 14
    //   164: getfield 88	com/tencent/mm/protocal/protobuf/aca:mBq	Ljava/lang/String;
    //   167: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   170: ifeq +24 -> 194
    //   173: aload 14
    //   175: aload 14
    //   177: invokevirtual 98	java/lang/Object:toString	()Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   184: getfield 57	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   187: invokestatic 104	com/tencent/mm/plugin/fav/a/b:cj	(Ljava/lang/String;I)Ljava/lang/String;
    //   190: invokevirtual 108	com/tencent/mm/protocal/protobuf/aca:anD	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   193: pop
    //   194: aload 14
    //   196: getfield 81	com/tencent/mm/protocal/protobuf/aca:wTo	Z
    //   199: ifeq +11 -> 210
    //   202: aload 14
    //   204: getfield 84	com/tencent/mm/protocal/protobuf/aca:wTq	Z
    //   207: ifne +5 -> 212
    //   210: iconst_1
    //   211: istore_3
    //   212: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   215: lstore 5
    //   217: aload 14
    //   219: getfield 117	com/tencent/mm/protocal/protobuf/aca:wTa	Ljava/lang/String;
    //   222: astore 15
    //   224: aload 15
    //   226: invokestatic 122	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   229: ifeq +469 -> 698
    //   232: aload 15
    //   234: invokestatic 128	com/tencent/mm/a/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   237: astore 9
    //   239: aload 15
    //   241: invokestatic 131	com/tencent/mm/a/g:cT	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 10
    //   246: aload 14
    //   248: aload 9
    //   250: invokevirtual 134	com/tencent/mm/protocal/protobuf/aca:anB	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   253: pop
    //   254: aload 14
    //   256: aload 10
    //   258: invokevirtual 137	com/tencent/mm/protocal/protobuf/aca:anC	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   261: pop
    //   262: aload 14
    //   264: new 139	com/tencent/mm/vfs/b
    //   267: dup
    //   268: aload 15
    //   270: invokespecial 142	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   273: invokevirtual 145	com/tencent/mm/vfs/b:length	()J
    //   276: invokevirtual 149	com/tencent/mm/protocal/protobuf/aca:nC	(J)Lcom/tencent/mm/protocal/protobuf/aca;
    //   279: pop
    //   280: aload 14
    //   282: invokestatic 153	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/protobuf/aca;)Ljava/lang/String;
    //   285: astore 9
    //   287: aload 15
    //   289: aload 9
    //   291: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifne +11 -> 305
    //   297: aload 15
    //   299: aload 9
    //   301: invokestatic 163	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   304: pop2
    //   305: aload 14
    //   307: getfield 166	com/tencent/mm/protocal/protobuf/aca:wTc	Ljava/lang/String;
    //   310: astore 9
    //   312: aload 9
    //   314: astore 11
    //   316: aload 9
    //   318: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   321: ifeq +178 -> 499
    //   324: aload 9
    //   326: astore 11
    //   328: aload 15
    //   330: invokestatic 122	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   333: ifeq +166 -> 499
    //   336: aload 9
    //   338: astore 11
    //   340: aload_0
    //   341: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   344: getfield 57	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   347: iconst_4
    //   348: if_icmpne +151 -> 499
    //   351: aload 9
    //   353: astore 11
    //   355: aload_0
    //   356: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   359: getfield 37	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/acq;
    //   362: getfield 170	com/tencent/mm/protocal/protobuf/acq:wVa	Lcom/tencent/mm/protocal/protobuf/acw;
    //   365: getfield 175	com/tencent/mm/protocal/protobuf/acw:cpG	I
    //   368: bipush 13
    //   370: if_icmpne +129 -> 499
    //   373: new 177	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   380: aload 14
    //   382: invokestatic 153	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/protobuf/aca;)Ljava/lang/String;
    //   385: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc 184
    //   390: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: astore 12
    //   398: aload 15
    //   400: invokestatic 191	com/tencent/mm/plugin/fav/ui/c:NW	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   403: astore 9
    //   405: aload 9
    //   407: ifnull +23 -> 430
    //   410: ldc 51
    //   412: ldc 193
    //   414: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload 9
    //   419: bipush 60
    //   421: getstatic 202	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   424: aload 12
    //   426: iconst_1
    //   427: invokestatic 207	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   430: aload 14
    //   432: aload 12
    //   434: invokevirtual 210	com/tencent/mm/protocal/protobuf/aca:anF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   437: pop
    //   438: ldc 51
    //   440: ldc 212
    //   442: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: new 214	android/media/MediaMetadataRetriever
    //   448: dup
    //   449: invokespecial 215	android/media/MediaMetadataRetriever:<init>	()V
    //   452: astore 10
    //   454: aload 10
    //   456: astore 9
    //   458: aload 10
    //   460: aload 15
    //   462: invokevirtual 218	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   465: aload 10
    //   467: astore 9
    //   469: aload 14
    //   471: aload 10
    //   473: bipush 9
    //   475: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   478: iconst_0
    //   479: invokestatic 226	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   482: i2l
    //   483: invokestatic 230	com/tencent/mm/sdk/platformtools/bo:nX	(J)I
    //   486: invokevirtual 234	com/tencent/mm/protocal/protobuf/aca:MH	(I)Lcom/tencent/mm/protocal/protobuf/aca;
    //   489: pop
    //   490: aload 10
    //   492: invokevirtual 237	android/media/MediaMetadataRetriever:release	()V
    //   495: aload 12
    //   497: astore 11
    //   499: aload 11
    //   501: invokestatic 122	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   504: ifeq +368 -> 872
    //   507: aconst_null
    //   508: astore 10
    //   510: aconst_null
    //   511: astore 9
    //   513: aload 11
    //   515: invokestatic 241	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   518: astore 12
    //   520: aload 12
    //   522: astore 9
    //   524: aload 12
    //   526: astore 10
    //   528: aload 12
    //   530: sipush 4096
    //   533: invokestatic 244	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   536: invokestatic 247	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 15
    //   541: aload 12
    //   543: astore 9
    //   545: aload 12
    //   547: astore 10
    //   549: aload 11
    //   551: invokestatic 251	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   554: lstore 7
    //   556: aload 12
    //   558: astore 9
    //   560: aload 12
    //   562: astore 10
    //   564: aload 12
    //   566: invokestatic 255	com/tencent/mm/a/g:n	(Ljava/io/InputStream;)Ljava/lang/String;
    //   569: astore 16
    //   571: aload 12
    //   573: astore 9
    //   575: aload 12
    //   577: astore 10
    //   579: aload 14
    //   581: aload 15
    //   583: invokevirtual 258	com/tencent/mm/protocal/protobuf/aca:anG	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   586: pop
    //   587: aload 12
    //   589: astore 9
    //   591: aload 12
    //   593: astore 10
    //   595: aload 14
    //   597: aload 16
    //   599: invokevirtual 261	com/tencent/mm/protocal/protobuf/aca:anH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aca;
    //   602: pop
    //   603: aload 12
    //   605: astore 9
    //   607: aload 12
    //   609: astore 10
    //   611: aload 14
    //   613: lload 7
    //   615: invokevirtual 264	com/tencent/mm/protocal/protobuf/aca:nD	(J)Lcom/tencent/mm/protocal/protobuf/aca;
    //   618: pop
    //   619: aload 12
    //   621: ifnull +8 -> 629
    //   624: aload 12
    //   626: invokevirtual 269	java/io/InputStream:close	()V
    //   629: aload 14
    //   631: invokestatic 272	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/protocal/protobuf/aca;)Ljava/lang/String;
    //   634: astore 9
    //   636: aload 11
    //   638: aload 9
    //   640: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   643: ifne +11 -> 654
    //   646: aload 11
    //   648: aload 9
    //   650: invokestatic 163	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   653: pop2
    //   654: ldc 51
    //   656: ldc_w 274
    //   659: iconst_2
    //   660: anewarray 4	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: aload_0
    //   666: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:muk	Lcom/tencent/mm/plugin/fav/a/g;
    //   669: getfield 278	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   672: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: aastore
    //   676: dup
    //   677: iconst_1
    //   678: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   681: lload 5
    //   683: lsub
    //   684: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   687: aastore
    //   688: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: iload_1
    //   692: iconst_1
    //   693: iadd
    //   694: istore_1
    //   695: goto -554 -> 141
    //   698: ldc 51
    //   700: ldc_w 285
    //   703: iconst_2
    //   704: anewarray 4	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload 14
    //   711: getfield 288	com/tencent/mm/protocal/protobuf/aca:dataType	I
    //   714: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: aastore
    //   718: dup
    //   719: iconst_1
    //   720: aload 15
    //   722: aastore
    //   723: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   726: goto -421 -> 305
    //   729: astore 9
    //   731: ldc 51
    //   733: aload 9
    //   735: ldc_w 290
    //   738: iconst_0
    //   739: anewarray 4	java/lang/Object
    //   742: invokestatic 294	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: goto -315 -> 430
    //   748: astore 11
    //   750: aconst_null
    //   751: astore 10
    //   753: aload 10
    //   755: astore 9
    //   757: ldc 51
    //   759: aload 11
    //   761: ldc_w 296
    //   764: iconst_1
    //   765: anewarray 4	java/lang/Object
    //   768: dup
    //   769: iconst_0
    //   770: aload 15
    //   772: aastore
    //   773: invokestatic 294	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: aload 12
    //   778: astore 11
    //   780: aload 10
    //   782: ifnull -283 -> 499
    //   785: aload 10
    //   787: invokevirtual 237	android/media/MediaMetadataRetriever:release	()V
    //   790: aload 12
    //   792: astore 11
    //   794: goto -295 -> 499
    //   797: astore 10
    //   799: aconst_null
    //   800: astore 9
    //   802: aload 9
    //   804: ifnull +8 -> 812
    //   807: aload 9
    //   809: invokevirtual 237	android/media/MediaMetadataRetriever:release	()V
    //   812: ldc 25
    //   814: invokestatic 299	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   817: aload 10
    //   819: athrow
    //   820: astore 10
    //   822: aload 9
    //   824: astore 10
    //   826: ldc 51
    //   828: ldc_w 301
    //   831: invokestatic 304	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload 9
    //   836: ifnull -207 -> 629
    //   839: aload 9
    //   841: invokevirtual 269	java/io/InputStream:close	()V
    //   844: goto -215 -> 629
    //   847: astore 9
    //   849: goto -220 -> 629
    //   852: astore 9
    //   854: aload 10
    //   856: ifnull +8 -> 864
    //   859: aload 10
    //   861: invokevirtual 269	java/io/InputStream:close	()V
    //   864: ldc 25
    //   866: invokestatic 299	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   869: aload 9
    //   871: athrow
    //   872: ldc 51
    //   874: ldc_w 306
    //   877: iconst_1
    //   878: anewarray 4	java/lang/Object
    //   881: dup
    //   882: iconst_0
    //   883: aload 11
    //   885: aastore
    //   886: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   889: goto -235 -> 654
    //   892: new 308	com/tencent/mm/plugin/fav/ui/b$a$1
    //   895: dup
    //   896: aload_0
    //   897: iload 4
    //   899: invokespecial 311	com/tencent/mm/plugin/fav/ui/b$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/b$a;Z)V
    //   902: invokestatic 317	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   905: ldc 25
    //   907: invokestatic 299	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: return
    //   911: astore 9
    //   913: goto -284 -> 629
    //   916: astore 10
    //   918: goto -54 -> 864
    //   921: astore 10
    //   923: goto -121 -> 802
    //   926: astore 11
    //   928: goto -175 -> 753
    //   931: goto -802 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	a
    //   89	606	1	i	int
    //   39	108	2	j	int
    //   31	181	3	bool1	boolean
    //   28	870	4	bool2	boolean
    //   215	467	5	l1	long
    //   554	60	7	l2	long
    //   109	540	9	localObject1	Object
    //   729	5	9	localException1	java.lang.Exception
    //   755	85	9	localObject2	Object
    //   847	1	9	localException2	java.lang.Exception
    //   852	18	9	localObject3	Object
    //   911	1	9	localException3	java.lang.Exception
    //   244	542	10	localObject4	Object
    //   797	21	10	localObject5	Object
    //   820	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   824	36	10	localObject6	Object
    //   916	1	10	localException4	java.lang.Exception
    //   921	1	10	localObject7	Object
    //   314	333	11	localObject8	Object
    //   748	12	11	localException5	java.lang.Exception
    //   778	106	11	localObject9	Object
    //   926	1	11	localException6	java.lang.Exception
    //   396	395	12	localObject10	Object
    //   15	135	13	localLinkedList	java.util.LinkedList
    //   160	550	14	localaca	com.tencent.mm.protocal.protobuf.aca
    //   222	549	15	str1	java.lang.String
    //   569	29	16	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   410	430	729	java/lang/Exception
    //   438	454	748	java/lang/Exception
    //   438	454	797	finally
    //   513	520	820	java/io/FileNotFoundException
    //   528	541	820	java/io/FileNotFoundException
    //   549	556	820	java/io/FileNotFoundException
    //   564	571	820	java/io/FileNotFoundException
    //   579	587	820	java/io/FileNotFoundException
    //   595	603	820	java/io/FileNotFoundException
    //   611	619	820	java/io/FileNotFoundException
    //   839	844	847	java/lang/Exception
    //   513	520	852	finally
    //   528	541	852	finally
    //   549	556	852	finally
    //   564	571	852	finally
    //   579	587	852	finally
    //   595	603	852	finally
    //   611	619	852	finally
    //   826	834	852	finally
    //   624	629	911	java/lang/Exception
    //   859	864	916	java/lang/Exception
    //   458	465	921	finally
    //   469	490	921	finally
    //   757	776	921	finally
    //   458	465	926	java/lang/Exception
    //   469	490	926	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */