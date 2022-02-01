package com.tencent.mm.plugin.appbrand.jsapi.al.b.b;

import com.tencent.mm.plugin.appbrand.jsapi.c.d;

public final class f
  extends d
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  /* Error */
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +127 -> 133
    //   9: aload_2
    //   10: ldc 33
    //   12: invokevirtual 39	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   15: ifeq +118 -> 133
    //   18: iconst_1
    //   19: istore 6
    //   21: iload 6
    //   23: ifeq +808 -> 831
    //   26: ldc 41
    //   28: ldc 43
    //   30: iconst_1
    //   31: anewarray 45	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_2
    //   37: aastore
    //   38: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_2
    //   42: ldc 52
    //   44: sipush 300
    //   47: invokevirtual 56	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   50: istore 8
    //   52: aload_2
    //   53: ldc 58
    //   55: sipush 150
    //   58: invokevirtual 56	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   61: istore 9
    //   63: aload_2
    //   64: ldc 60
    //   66: invokevirtual 64	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: iload 8
    //   71: i2f
    //   72: invokestatic 70	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   75: fstore 4
    //   77: aload_2
    //   78: ldc 72
    //   80: invokevirtual 64	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: iload 9
    //   85: i2f
    //   86: invokestatic 70	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   89: fstore 5
    //   91: aload_2
    //   92: ldc 33
    //   94: invokevirtual 76	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   97: astore 14
    //   99: aload 14
    //   101: instanceof 78
    //   104: ifne +35 -> 139
    //   107: ldc 41
    //   109: ldc 80
    //   111: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_1
    //   115: iload_3
    //   116: aload_0
    //   117: ldc 86
    //   119: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokeinterface 95 3 0
    //   127: ldc 25
    //   129: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: iconst_0
    //   134: istore 6
    //   136: goto -115 -> 21
    //   139: aload 14
    //   141: checkcast 78	java/nio/ByteBuffer
    //   144: astore 14
    //   146: aload 14
    //   148: invokestatic 104	com/tencent/mm/plugin/appbrand/af/d:s	(Ljava/nio/ByteBuffer;)[B
    //   151: astore 14
    //   153: aload 14
    //   155: arraylength
    //   156: iconst_4
    //   157: idiv
    //   158: newarray int
    //   160: astore 15
    //   162: iconst_0
    //   163: istore 7
    //   165: iconst_0
    //   166: istore 6
    //   168: iload 6
    //   170: aload 15
    //   172: arraylength
    //   173: if_icmpge +139 -> 312
    //   176: iload 7
    //   178: iconst_1
    //   179: iadd
    //   180: istore 11
    //   182: aload 14
    //   184: iload 7
    //   186: baload
    //   187: istore 10
    //   189: iload 11
    //   191: iconst_1
    //   192: iadd
    //   193: istore 7
    //   195: aload 14
    //   197: iload 11
    //   199: baload
    //   200: istore 11
    //   202: iload 7
    //   204: iconst_1
    //   205: iadd
    //   206: istore 12
    //   208: aload 14
    //   210: iload 7
    //   212: baload
    //   213: istore 13
    //   215: iload 12
    //   217: iconst_1
    //   218: iadd
    //   219: istore 7
    //   221: aload 15
    //   223: iload 6
    //   225: aload 14
    //   227: iload 12
    //   229: baload
    //   230: sipush 255
    //   233: iand
    //   234: bipush 24
    //   236: ishl
    //   237: iload 13
    //   239: sipush 255
    //   242: iand
    //   243: iload 10
    //   245: sipush 255
    //   248: iand
    //   249: bipush 16
    //   251: ishl
    //   252: iload 11
    //   254: sipush 255
    //   257: iand
    //   258: bipush 8
    //   260: ishl
    //   261: ior
    //   262: ior
    //   263: ior
    //   264: iastore
    //   265: iload 6
    //   267: iconst_1
    //   268: iadd
    //   269: istore 6
    //   271: goto -103 -> 168
    //   274: astore_2
    //   275: ldc 41
    //   277: ldc 106
    //   279: iconst_1
    //   280: anewarray 45	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: aload_2
    //   286: invokestatic 112	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_1
    //   294: iload_3
    //   295: aload_0
    //   296: ldc 116
    //   298: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokeinterface 95 3 0
    //   306: ldc 25
    //   308: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: aconst_null
    //   313: astore 14
    //   315: aload 15
    //   317: iload 8
    //   319: iload 9
    //   321: getstatic 122	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   324: invokestatic 128	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   327: astore 15
    //   329: aload 15
    //   331: astore 14
    //   333: aload 14
    //   335: ifnonnull +71 -> 406
    //   338: ldc 41
    //   340: ldc 130
    //   342: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_1
    //   346: iload_3
    //   347: aload_0
    //   348: ldc 132
    //   350: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   353: invokeinterface 95 3 0
    //   358: ldc 25
    //   360: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: return
    //   364: astore 15
    //   366: ldc 41
    //   368: ldc 134
    //   370: iconst_1
    //   371: anewarray 45	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 15
    //   378: aastore
    //   379: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: goto -49 -> 333
    //   385: astore 15
    //   387: ldc 41
    //   389: ldc 134
    //   391: iconst_1
    //   392: anewarray 45	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload 15
    //   399: aastore
    //   400: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: goto -70 -> 333
    //   406: aload 14
    //   408: invokevirtual 141	android/graphics/Bitmap:getWidth	()I
    //   411: i2f
    //   412: fload 4
    //   414: fcmpl
    //   415: ifne +19 -> 434
    //   418: aload 14
    //   420: astore 15
    //   422: aload 14
    //   424: invokevirtual 144	android/graphics/Bitmap:getHeight	()I
    //   427: i2f
    //   428: fload 5
    //   430: fcmpl
    //   431: ifeq +46 -> 477
    //   434: fload 4
    //   436: f2i
    //   437: istore 6
    //   439: fload 5
    //   441: f2i
    //   442: istore 7
    //   444: aload 14
    //   446: iload 6
    //   448: iload 7
    //   450: iconst_0
    //   451: invokestatic 148	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   454: astore 15
    //   456: ldc 41
    //   458: ldc 150
    //   460: iconst_2
    //   461: anewarray 45	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload 14
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: aload 15
    //   473: aastore
    //   474: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: aload 15
    //   479: ifnonnull +79 -> 558
    //   482: ldc 41
    //   484: ldc 130
    //   486: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_1
    //   490: iload_3
    //   491: aload_0
    //   492: ldc 132
    //   494: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   497: invokeinterface 95 3 0
    //   502: ldc 25
    //   504: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: return
    //   508: astore 15
    //   510: ldc 41
    //   512: ldc 152
    //   514: iconst_1
    //   515: anewarray 45	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: aload 15
    //   522: aastore
    //   523: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload 14
    //   528: astore 15
    //   530: goto -53 -> 477
    //   533: astore 15
    //   535: ldc 41
    //   537: ldc 152
    //   539: iconst_1
    //   540: anewarray 45	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload 15
    //   547: aastore
    //   548: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aload 14
    //   553: astore 15
    //   555: goto -78 -> 477
    //   558: aload_2
    //   559: invokestatic 156	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ah	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   562: astore 16
    //   564: aload 16
    //   566: getstatic 162	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   569: if_acmpne +79 -> 648
    //   572: ldc 164
    //   574: astore 14
    //   576: aload_1
    //   577: invokeinterface 168 1 0
    //   582: new 170	java/lang/StringBuilder
    //   585: dup
    //   586: ldc 172
    //   588: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   594: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   597: ldc 187
    //   599: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 14
    //   604: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokeinterface 200 2 0
    //   615: astore 17
    //   617: aload 17
    //   619: ifnonnull +36 -> 655
    //   622: ldc 41
    //   624: ldc 202
    //   626: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_1
    //   630: iload_3
    //   631: aload_0
    //   632: ldc 204
    //   634: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   637: invokeinterface 95 3 0
    //   642: ldc 25
    //   644: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   647: return
    //   648: ldc 206
    //   650: astore 14
    //   652: goto -76 -> 576
    //   655: aload 17
    //   657: invokevirtual 212	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   660: invokestatic 218	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   663: astore 17
    //   665: ldc 41
    //   667: ldc 220
    //   669: iconst_1
    //   670: anewarray 45	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: aload 17
    //   677: aastore
    //   678: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   681: aload 15
    //   683: aload_2
    //   684: invokestatic 227	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ag	(Lorg/json/JSONObject;)I
    //   687: aload 16
    //   689: aload 17
    //   691: iconst_1
    //   692: invokestatic 233	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   695: pop
    //   696: new 235	com/tencent/mm/plugin/appbrand/af/k
    //   699: dup
    //   700: invokespecial 236	com/tencent/mm/plugin/appbrand/af/k:<init>	()V
    //   703: astore_2
    //   704: aload_1
    //   705: invokeinterface 168 1 0
    //   710: new 208	com/tencent/mm/vfs/u
    //   713: dup
    //   714: aload 17
    //   716: invokespecial 237	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   719: aload 14
    //   721: iconst_1
    //   722: aload_2
    //   723: invokeinterface 240 5 0
    //   728: pop
    //   729: aload_2
    //   730: getfield 244	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
    //   733: checkcast 246	java/lang/String
    //   736: astore_2
    //   737: ldc 41
    //   739: ldc 248
    //   741: iconst_1
    //   742: anewarray 45	java/lang/Object
    //   745: dup
    //   746: iconst_0
    //   747: aload_2
    //   748: aastore
    //   749: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   752: new 250	java/util/HashMap
    //   755: dup
    //   756: invokespecial 251	java/util/HashMap:<init>	()V
    //   759: astore 14
    //   761: aload 14
    //   763: ldc 253
    //   765: aload_2
    //   766: invokeinterface 259 3 0
    //   771: pop
    //   772: aload_1
    //   773: iload_3
    //   774: aload_0
    //   775: ldc_w 261
    //   778: aload 14
    //   780: invokevirtual 265	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   783: invokeinterface 95 3 0
    //   788: ldc 25
    //   790: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   793: return
    //   794: astore_2
    //   795: ldc 41
    //   797: ldc_w 267
    //   800: iconst_1
    //   801: anewarray 45	java/lang/Object
    //   804: dup
    //   805: iconst_0
    //   806: aload_2
    //   807: aastore
    //   808: invokestatic 270	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   811: aload_1
    //   812: iload_3
    //   813: aload_0
    //   814: ldc_w 272
    //   817: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/f:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   820: invokeinterface 95 3 0
    //   825: ldc 25
    //   827: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   830: return
    //   831: aload_0
    //   832: aload_1
    //   833: aload_2
    //   834: iload_3
    //   835: invokespecial 274	com/tencent/mm/plugin/appbrand/jsapi/c/d:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Lorg/json/JSONObject;I)V
    //   838: ldc 25
    //   840: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	this	f
    //   0	844	1	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	844	2	paramJSONObject	org.json.JSONObject
    //   0	844	3	paramInt	int
    //   75	360	4	f1	float
    //   89	351	5	f2	float
    //   19	428	6	i	int
    //   163	286	7	j	int
    //   50	268	8	k	int
    //   61	259	9	m	int
    //   187	62	10	n	int
    //   180	78	11	i1	int
    //   206	22	12	i2	int
    //   213	30	13	i3	int
    //   97	682	14	localObject1	java.lang.Object
    //   160	170	15	localObject2	java.lang.Object
    //   364	13	15	localException1	java.lang.Exception
    //   385	13	15	localObject3	java.lang.Object
    //   420	58	15	localObject4	java.lang.Object
    //   508	13	15	localException2	java.lang.Exception
    //   528	1	15	localObject5	java.lang.Object
    //   533	13	15	localObject6	java.lang.Object
    //   553	129	15	localObject7	java.lang.Object
    //   562	126	16	localCompressFormat	android.graphics.Bitmap.CompressFormat
    //   615	100	17	localObject8	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   91	127	274	org/json/JSONException
    //   139	146	274	org/json/JSONException
    //   315	329	364	java/lang/Exception
    //   315	329	385	finally
    //   444	477	508	java/lang/Exception
    //   444	477	533	finally
    //   681	696	794	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.b.f
 * JD-Core Version:    0.7.0.1
 */