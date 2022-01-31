package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.g;

final class b$a
  implements Runnable
{
  g jZN;
  
  public b$a(g paramg)
  {
    this.jZN = paramg;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   4: getfield 30	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   7: getfield 36	com/tencent/mm/protocal/c/yj:sXc	Ljava/util/LinkedList;
    //   10: astore 13
    //   12: aload 13
    //   14: invokeinterface 42 1 0
    //   19: ifle +871 -> 890
    //   22: iconst_0
    //   23: istore 4
    //   25: iconst_0
    //   26: istore_3
    //   27: aload 13
    //   29: invokeinterface 42 1 0
    //   34: istore_2
    //   35: ldc 44
    //   37: ldc 46
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   49: getfield 50	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   52: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 62	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   63: getfield 50	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   66: bipush 18
    //   68: if_icmpne +63 -> 131
    //   71: aload_0
    //   72: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   75: getfield 65	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
    //   78: bipush 6
    //   80: if_icmpne +51 -> 131
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_3
    //   86: istore 4
    //   88: iload_1
    //   89: iload_2
    //   90: if_icmpge +787 -> 877
    //   93: aload 13
    //   95: iload_1
    //   96: invokeinterface 69 2 0
    //   101: checkcast 71	com/tencent/mm/protocal/c/xv
    //   104: astore 9
    //   106: aload 9
    //   108: getfield 75	com/tencent/mm/protocal/c/xv:sVs	Z
    //   111: ifeq +11 -> 122
    //   114: aload 9
    //   116: getfield 78	com/tencent/mm/protocal/c/xv:sVu	Z
    //   119: ifne +792 -> 911
    //   122: iconst_1
    //   123: istore_3
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: goto -43 -> 85
    //   131: iconst_0
    //   132: istore_1
    //   133: iload 4
    //   135: istore_3
    //   136: iload_3
    //   137: istore 4
    //   139: iload_1
    //   140: iload_2
    //   141: if_icmpge +736 -> 877
    //   144: aload 13
    //   146: iload_1
    //   147: invokeinterface 69 2 0
    //   152: checkcast 71	com/tencent/mm/protocal/c/xv
    //   155: astore 14
    //   157: aload 14
    //   159: getfield 82	com/tencent/mm/protocal/c/xv:kgC	Ljava/lang/String;
    //   162: invokestatic 88	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   165: ifeq +24 -> 189
    //   168: aload 14
    //   170: aload 14
    //   172: invokevirtual 92	java/lang/Object:toString	()Ljava/lang/String;
    //   175: aload_0
    //   176: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   179: getfield 50	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   182: invokestatic 98	com/tencent/mm/plugin/fav/a/b:bB	(Ljava/lang/String;I)Ljava/lang/String;
    //   185: invokevirtual 102	com/tencent/mm/protocal/c/xv:XH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   188: pop
    //   189: aload 14
    //   191: getfield 75	com/tencent/mm/protocal/c/xv:sVs	Z
    //   194: ifeq +11 -> 205
    //   197: aload 14
    //   199: getfield 78	com/tencent/mm/protocal/c/xv:sVu	Z
    //   202: ifne +5 -> 207
    //   205: iconst_1
    //   206: istore_3
    //   207: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   210: lstore 5
    //   212: aload 14
    //   214: getfield 111	com/tencent/mm/protocal/c/xv:sVe	Ljava/lang/String;
    //   217: astore 15
    //   219: aload 15
    //   221: invokestatic 116	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   224: ifeq +469 -> 693
    //   227: aload 15
    //   229: invokestatic 122	com/tencent/mm/a/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 9
    //   234: aload 15
    //   236: invokestatic 125	com/tencent/mm/a/g:bR	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 10
    //   241: aload 14
    //   243: aload 9
    //   245: invokevirtual 128	com/tencent/mm/protocal/c/xv:XF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   248: pop
    //   249: aload 14
    //   251: aload 10
    //   253: invokevirtual 131	com/tencent/mm/protocal/c/xv:XG	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   256: pop
    //   257: aload 14
    //   259: new 133	com/tencent/mm/vfs/b
    //   262: dup
    //   263: aload 15
    //   265: invokespecial 136	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   268: invokevirtual 139	com/tencent/mm/vfs/b:length	()J
    //   271: invokevirtual 143	com/tencent/mm/protocal/c/xv:hf	(J)Lcom/tencent/mm/protocal/c/xv;
    //   274: pop
    //   275: aload 14
    //   277: invokestatic 147	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   280: astore 9
    //   282: aload 15
    //   284: aload 9
    //   286: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   289: ifne +11 -> 300
    //   292: aload 15
    //   294: aload 9
    //   296: invokestatic 157	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   299: pop2
    //   300: aload 14
    //   302: getfield 160	com/tencent/mm/protocal/c/xv:sVg	Ljava/lang/String;
    //   305: astore 9
    //   307: aload 9
    //   309: astore 11
    //   311: aload 9
    //   313: invokestatic 88	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   316: ifeq +178 -> 494
    //   319: aload 9
    //   321: astore 11
    //   323: aload 15
    //   325: invokestatic 116	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   328: ifeq +166 -> 494
    //   331: aload 9
    //   333: astore 11
    //   335: aload_0
    //   336: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   339: getfield 50	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   342: iconst_4
    //   343: if_icmpne +151 -> 494
    //   346: aload 9
    //   348: astore 11
    //   350: aload_0
    //   351: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   354: getfield 30	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   357: getfield 164	com/tencent/mm/protocal/c/yj:sXa	Lcom/tencent/mm/protocal/c/yp;
    //   360: getfield 169	com/tencent/mm/protocal/c/yp:bIl	I
    //   363: bipush 13
    //   365: if_icmpne +129 -> 494
    //   368: new 171	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   375: aload 14
    //   377: invokestatic 147	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   380: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc 178
    //   385: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: astore 12
    //   393: aload 15
    //   395: invokestatic 185	com/tencent/mm/plugin/fav/ui/c:CU	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   398: astore 9
    //   400: aload 9
    //   402: ifnull +23 -> 425
    //   405: ldc 44
    //   407: ldc 187
    //   409: invokestatic 190	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 9
    //   414: bipush 60
    //   416: getstatic 196	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   419: aload 12
    //   421: iconst_1
    //   422: invokestatic 201	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   425: aload 14
    //   427: aload 12
    //   429: invokevirtual 204	com/tencent/mm/protocal/c/xv:XJ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   432: pop
    //   433: ldc 44
    //   435: ldc 206
    //   437: invokestatic 190	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: new 208	android/media/MediaMetadataRetriever
    //   443: dup
    //   444: invokespecial 209	android/media/MediaMetadataRetriever:<init>	()V
    //   447: astore 10
    //   449: aload 10
    //   451: astore 9
    //   453: aload 10
    //   455: aload 15
    //   457: invokevirtual 212	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   460: aload 10
    //   462: astore 9
    //   464: aload 14
    //   466: aload 10
    //   468: bipush 9
    //   470: invokevirtual 216	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   473: iconst_0
    //   474: invokestatic 220	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   477: i2l
    //   478: invokestatic 224	com/tencent/mm/sdk/platformtools/bk:hv	(J)I
    //   481: invokevirtual 228	com/tencent/mm/protocal/c/xv:EG	(I)Lcom/tencent/mm/protocal/c/xv;
    //   484: pop
    //   485: aload 10
    //   487: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
    //   490: aload 12
    //   492: astore 11
    //   494: aload 11
    //   496: invokestatic 116	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   499: ifeq +358 -> 857
    //   502: aconst_null
    //   503: astore 10
    //   505: aconst_null
    //   506: astore 9
    //   508: aload 11
    //   510: invokestatic 235	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   513: astore 12
    //   515: aload 12
    //   517: astore 9
    //   519: aload 12
    //   521: astore 10
    //   523: aload 12
    //   525: sipush 4096
    //   528: invokestatic 238	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   531: invokestatic 241	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   534: astore 15
    //   536: aload 12
    //   538: astore 9
    //   540: aload 12
    //   542: astore 10
    //   544: aload 11
    //   546: invokestatic 245	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   549: lstore 7
    //   551: aload 12
    //   553: astore 9
    //   555: aload 12
    //   557: astore 10
    //   559: aload 12
    //   561: invokestatic 249	com/tencent/mm/a/g:l	(Ljava/io/InputStream;)Ljava/lang/String;
    //   564: astore 16
    //   566: aload 12
    //   568: astore 9
    //   570: aload 12
    //   572: astore 10
    //   574: aload 14
    //   576: aload 15
    //   578: invokevirtual 252	com/tencent/mm/protocal/c/xv:XK	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   581: pop
    //   582: aload 12
    //   584: astore 9
    //   586: aload 12
    //   588: astore 10
    //   590: aload 14
    //   592: aload 16
    //   594: invokevirtual 255	com/tencent/mm/protocal/c/xv:XL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   597: pop
    //   598: aload 12
    //   600: astore 9
    //   602: aload 12
    //   604: astore 10
    //   606: aload 14
    //   608: lload 7
    //   610: invokevirtual 258	com/tencent/mm/protocal/c/xv:hg	(J)Lcom/tencent/mm/protocal/c/xv;
    //   613: pop
    //   614: aload 12
    //   616: ifnull +8 -> 624
    //   619: aload 12
    //   621: invokevirtual 263	java/io/InputStream:close	()V
    //   624: aload 14
    //   626: invokestatic 266	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   629: astore 9
    //   631: aload 11
    //   633: aload 9
    //   635: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   638: ifne +11 -> 649
    //   641: aload 11
    //   643: aload 9
    //   645: invokestatic 157	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   648: pop2
    //   649: ldc 44
    //   651: ldc_w 268
    //   654: iconst_2
    //   655: anewarray 4	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: aload_0
    //   661: getfield 18	com/tencent/mm/plugin/fav/ui/b$a:jZN	Lcom/tencent/mm/plugin/fav/a/g;
    //   664: getfield 272	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   667: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   670: aastore
    //   671: dup
    //   672: iconst_1
    //   673: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   676: lload 5
    //   678: lsub
    //   679: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   682: aastore
    //   683: invokestatic 62	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   686: iload_1
    //   687: iconst_1
    //   688: iadd
    //   689: istore_1
    //   690: goto -554 -> 136
    //   693: ldc 44
    //   695: ldc_w 279
    //   698: iconst_2
    //   699: anewarray 4	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: aload 14
    //   706: getfield 282	com/tencent/mm/protocal/c/xv:aYU	I
    //   709: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   712: aastore
    //   713: dup
    //   714: iconst_1
    //   715: aload 15
    //   717: aastore
    //   718: invokestatic 62	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   721: goto -421 -> 300
    //   724: astore 9
    //   726: ldc 44
    //   728: aload 9
    //   730: ldc_w 284
    //   733: iconst_0
    //   734: anewarray 4	java/lang/Object
    //   737: invokestatic 288	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: goto -315 -> 425
    //   743: astore 11
    //   745: aconst_null
    //   746: astore 10
    //   748: aload 10
    //   750: astore 9
    //   752: ldc 44
    //   754: aload 11
    //   756: ldc_w 290
    //   759: iconst_1
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: aload 15
    //   767: aastore
    //   768: invokestatic 288	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   771: aload 12
    //   773: astore 11
    //   775: aload 10
    //   777: ifnull -283 -> 494
    //   780: aload 10
    //   782: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
    //   785: aload 12
    //   787: astore 11
    //   789: goto -295 -> 494
    //   792: astore 10
    //   794: aconst_null
    //   795: astore 9
    //   797: aload 9
    //   799: ifnull +8 -> 807
    //   802: aload 9
    //   804: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
    //   807: aload 10
    //   809: athrow
    //   810: astore 10
    //   812: aload 9
    //   814: astore 10
    //   816: ldc 44
    //   818: ldc_w 292
    //   821: invokestatic 295	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: aload 9
    //   826: ifnull -202 -> 624
    //   829: aload 9
    //   831: invokevirtual 263	java/io/InputStream:close	()V
    //   834: goto -210 -> 624
    //   837: astore 9
    //   839: goto -215 -> 624
    //   842: astore 9
    //   844: aload 10
    //   846: ifnull +8 -> 854
    //   849: aload 10
    //   851: invokevirtual 263	java/io/InputStream:close	()V
    //   854: aload 9
    //   856: athrow
    //   857: ldc 44
    //   859: ldc_w 297
    //   862: iconst_1
    //   863: anewarray 4	java/lang/Object
    //   866: dup
    //   867: iconst_0
    //   868: aload 11
    //   870: aastore
    //   871: invokestatic 62	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: goto -225 -> 649
    //   877: new 299	com/tencent/mm/plugin/fav/ui/b$a$1
    //   880: dup
    //   881: aload_0
    //   882: iload 4
    //   884: invokespecial 302	com/tencent/mm/plugin/fav/ui/b$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/b$a;Z)V
    //   887: invokestatic 308	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   890: return
    //   891: astore 9
    //   893: goto -269 -> 624
    //   896: astore 10
    //   898: goto -44 -> 854
    //   901: astore 10
    //   903: goto -106 -> 797
    //   906: astore 11
    //   908: goto -160 -> 748
    //   911: goto -787 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	this	a
    //   84	606	1	i	int
    //   34	108	2	j	int
    //   26	181	3	bool1	boolean
    //   23	860	4	bool2	boolean
    //   210	467	5	l1	long
    //   549	60	7	l2	long
    //   104	540	9	localObject1	Object
    //   724	5	9	localException1	java.lang.Exception
    //   750	80	9	localObject2	Object
    //   837	1	9	localException2	java.lang.Exception
    //   842	13	9	localObject3	Object
    //   891	1	9	localException3	java.lang.Exception
    //   239	542	10	localObject4	Object
    //   792	16	10	localObject5	Object
    //   810	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   814	36	10	localObject6	Object
    //   896	1	10	localException4	java.lang.Exception
    //   901	1	10	localObject7	Object
    //   309	333	11	localObject8	Object
    //   743	12	11	localException5	java.lang.Exception
    //   773	96	11	localObject9	Object
    //   906	1	11	localException6	java.lang.Exception
    //   391	395	12	localObject10	Object
    //   10	135	13	localLinkedList	java.util.LinkedList
    //   155	550	14	localxv	com.tencent.mm.protocal.c.xv
    //   217	549	15	str1	java.lang.String
    //   564	29	16	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   405	425	724	java/lang/Exception
    //   433	449	743	java/lang/Exception
    //   433	449	792	finally
    //   508	515	810	java/io/FileNotFoundException
    //   523	536	810	java/io/FileNotFoundException
    //   544	551	810	java/io/FileNotFoundException
    //   559	566	810	java/io/FileNotFoundException
    //   574	582	810	java/io/FileNotFoundException
    //   590	598	810	java/io/FileNotFoundException
    //   606	614	810	java/io/FileNotFoundException
    //   829	834	837	java/lang/Exception
    //   508	515	842	finally
    //   523	536	842	finally
    //   544	551	842	finally
    //   559	566	842	finally
    //   574	582	842	finally
    //   590	598	842	finally
    //   606	614	842	finally
    //   816	824	842	finally
    //   619	624	891	java/lang/Exception
    //   849	854	896	java/lang/Exception
    //   453	460	901	finally
    //   464	485	901	finally
    //   752	771	901	finally
    //   453	460	906	java/lang/Exception
    //   464	485	906	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */