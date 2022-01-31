package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.jsapi.a;

public final class c
  extends a<com.tencent.mm.plugin.appbrand.game.c>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  /* Error */
  public static com.tencent.mm.plugin.appbrand.jsapi.file.f.a a(com.tencent.mm.plugin.appbrand.game.page.f paramf, org.json.JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 29
    //   3: invokevirtual 35	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore 12
    //   8: new 37	android/os/Bundle
    //   11: dup
    //   12: invokespecial 38	android/os/Bundle:<init>	()V
    //   15: astore 13
    //   17: aload 13
    //   19: ldc 29
    //   21: iload 12
    //   23: invokevirtual 42	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   26: aload 13
    //   28: ldc 44
    //   30: iload_2
    //   31: invokevirtual 48	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   34: aload 13
    //   36: invokestatic 54	com/tencent/mm/plugin/appbrand/game/page/f:p	(Landroid/os/Bundle;)Lcom/tencent/magicbrush/handler/image/MBCanvasContentHolder;
    //   39: astore 13
    //   41: aload 13
    //   43: ifnull +11 -> 54
    //   46: aload 13
    //   48: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   51: ifnonnull +54 -> 105
    //   54: ldc 62
    //   56: ldc 64
    //   58: invokestatic 70	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   64: dup
    //   65: ldc 74
    //   67: iconst_0
    //   68: anewarray 76	java/lang/Object
    //   71: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: areturn
    //   75: astore_0
    //   76: ldc 62
    //   78: ldc 81
    //   80: iconst_1
    //   81: anewarray 76	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: aastore
    //   88: invokestatic 84	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   94: dup
    //   95: ldc 86
    //   97: iconst_0
    //   98: anewarray 76	java/lang/Object
    //   101: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: areturn
    //   105: aload 13
    //   107: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   110: invokevirtual 92	android/graphics/Bitmap:getWidth	()I
    //   113: i2f
    //   114: fstore 8
    //   116: aload 13
    //   118: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   121: invokevirtual 95	android/graphics/Bitmap:getHeight	()I
    //   124: i2f
    //   125: fstore 9
    //   127: fload 8
    //   129: fconst_0
    //   130: fcmpl
    //   131: ifeq +10 -> 141
    //   134: fload 9
    //   136: fconst_0
    //   137: fcmpl
    //   138: ifne +52 -> 190
    //   141: ldc 62
    //   143: ldc 97
    //   145: iconst_3
    //   146: anewarray 76	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: fload 8
    //   153: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: fload 9
    //   161: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: iload 12
    //   169: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: invokestatic 111	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   179: dup
    //   180: ldc 113
    //   182: iconst_0
    //   183: anewarray 76	java/lang/Object
    //   186: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: areturn
    //   190: aload 13
    //   192: getfield 116	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:width	I
    //   195: ifne +517 -> 712
    //   198: fload 8
    //   200: fstore 6
    //   202: aload 13
    //   204: getfield 119	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:height	I
    //   207: ifne +516 -> 723
    //   210: fload 9
    //   212: fstore 7
    //   214: ldc 62
    //   216: ldc 121
    //   218: iconst_4
    //   219: anewarray 76	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: fload 8
    //   226: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: fload 9
    //   234: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: fload 6
    //   242: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: fload 7
    //   250: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   253: aastore
    //   254: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload_1
    //   258: ldc 126
    //   260: dconst_0
    //   261: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   264: d2f
    //   265: fstore 4
    //   267: aload_1
    //   268: ldc 132
    //   270: dconst_0
    //   271: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   274: d2f
    //   275: fstore 5
    //   277: aload_1
    //   278: ldc 133
    //   280: fload 6
    //   282: f2d
    //   283: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   286: d2f
    //   287: fstore 10
    //   289: aload_1
    //   290: ldc 134
    //   292: fload 7
    //   294: f2d
    //   295: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   298: d2f
    //   299: fstore 11
    //   301: ldc 62
    //   303: ldc 136
    //   305: iconst_4
    //   306: anewarray 76	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: fload 4
    //   313: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: fload 5
    //   321: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: fload 10
    //   329: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   332: aastore
    //   333: dup
    //   334: iconst_3
    //   335: fload 11
    //   337: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   340: aastore
    //   341: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: fload 6
    //   346: fconst_0
    //   347: fcmpl
    //   348: ifle +995 -> 1343
    //   351: fload 7
    //   353: fconst_0
    //   354: fcmpl
    //   355: ifle +988 -> 1343
    //   358: fload 8
    //   360: fload 6
    //   362: fcmpl
    //   363: ifne +11 -> 374
    //   366: fload 9
    //   368: fload 7
    //   370: fcmpl
    //   371: ifeq +972 -> 1343
    //   374: fload 4
    //   376: fstore_3
    //   377: fload 4
    //   379: fconst_0
    //   380: fcmpl
    //   381: ifle +12 -> 393
    //   384: fload 4
    //   386: fload 6
    //   388: fdiv
    //   389: fload 8
    //   391: fmul
    //   392: fstore_3
    //   393: fload 5
    //   395: fstore 4
    //   397: fload 5
    //   399: fconst_0
    //   400: fcmpl
    //   401: ifle +13 -> 414
    //   404: fload 5
    //   406: fload 7
    //   408: fdiv
    //   409: fload 9
    //   411: fmul
    //   412: fstore 4
    //   414: fload 10
    //   416: fload 6
    //   418: fdiv
    //   419: fstore 5
    //   421: fload 11
    //   423: fload 7
    //   425: fdiv
    //   426: fload 9
    //   428: fmul
    //   429: fstore 7
    //   431: fload 5
    //   433: fload 8
    //   435: fmul
    //   436: fstore 10
    //   438: fload_3
    //   439: fstore 6
    //   441: fload 4
    //   443: fstore 5
    //   445: fload 10
    //   447: fstore 4
    //   449: fload 7
    //   451: fstore_3
    //   452: fload 6
    //   454: fload 4
    //   456: fadd
    //   457: fload 8
    //   459: fcmpl
    //   460: ifle +880 -> 1340
    //   463: fload 8
    //   465: fload 6
    //   467: fsub
    //   468: fstore 4
    //   470: fload 5
    //   472: fload_3
    //   473: fadd
    //   474: fload 9
    //   476: fcmpl
    //   477: ifle +860 -> 1337
    //   480: fload 9
    //   482: fload 5
    //   484: fsub
    //   485: fstore_3
    //   486: aload_1
    //   487: ldc 138
    //   489: fload 4
    //   491: f2d
    //   492: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   495: d2f
    //   496: fstore 7
    //   498: aload_1
    //   499: ldc 140
    //   501: fload_3
    //   502: f2d
    //   503: invokevirtual 130	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   506: d2f
    //   507: fstore 10
    //   509: ldc 62
    //   511: ldc 142
    //   513: bipush 8
    //   515: anewarray 76	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: fload 6
    //   522: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   525: aastore
    //   526: dup
    //   527: iconst_1
    //   528: fload 5
    //   530: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   533: aastore
    //   534: dup
    //   535: iconst_2
    //   536: fload 8
    //   538: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   541: aastore
    //   542: dup
    //   543: iconst_3
    //   544: fload 9
    //   546: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   549: aastore
    //   550: dup
    //   551: iconst_4
    //   552: fload 4
    //   554: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   557: aastore
    //   558: dup
    //   559: iconst_5
    //   560: fload_3
    //   561: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   564: aastore
    //   565: dup
    //   566: bipush 6
    //   568: fload 7
    //   570: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   573: aastore
    //   574: dup
    //   575: bipush 7
    //   577: fload 10
    //   579: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   582: aastore
    //   583: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   586: fload 6
    //   588: fconst_0
    //   589: fcmpg
    //   590: iflt +58 -> 648
    //   593: fload 5
    //   595: fconst_0
    //   596: fcmpg
    //   597: iflt +51 -> 648
    //   600: fload 4
    //   602: fconst_0
    //   603: fcmpg
    //   604: ifle +44 -> 648
    //   607: fload_3
    //   608: fconst_0
    //   609: fcmpg
    //   610: ifle +38 -> 648
    //   613: fload 6
    //   615: fload 4
    //   617: fadd
    //   618: fload 8
    //   620: fcmpl
    //   621: ifgt +27 -> 648
    //   624: fload 5
    //   626: fload_3
    //   627: fadd
    //   628: fload 9
    //   630: fcmpl
    //   631: ifgt +17 -> 648
    //   634: fload 7
    //   636: fconst_0
    //   637: fcmpg
    //   638: ifle +10 -> 648
    //   641: fload 10
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifgt +89 -> 734
    //   648: ldc 62
    //   650: ldc 144
    //   652: iconst_5
    //   653: anewarray 76	java/lang/Object
    //   656: dup
    //   657: iconst_0
    //   658: fload 6
    //   660: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   663: aastore
    //   664: dup
    //   665: iconst_1
    //   666: fload 5
    //   668: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   671: aastore
    //   672: dup
    //   673: iconst_2
    //   674: fload 4
    //   676: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   679: aastore
    //   680: dup
    //   681: iconst_3
    //   682: fload_3
    //   683: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   686: aastore
    //   687: dup
    //   688: iconst_4
    //   689: iload 12
    //   691: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   694: aastore
    //   695: invokestatic 111	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   698: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   701: dup
    //   702: ldc 146
    //   704: iconst_0
    //   705: anewarray 76	java/lang/Object
    //   708: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   711: areturn
    //   712: aload 13
    //   714: getfield 116	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:width	I
    //   717: i2f
    //   718: fstore 6
    //   720: goto -518 -> 202
    //   723: aload 13
    //   725: getfield 119	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:height	I
    //   728: i2f
    //   729: fstore 7
    //   731: goto -517 -> 214
    //   734: fload 4
    //   736: fload 8
    //   738: fcmpl
    //   739: ifne +10 -> 749
    //   742: fload_3
    //   743: fload 9
    //   745: fcmpl
    //   746: ifeq +41 -> 787
    //   749: aload 13
    //   751: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   754: fload 6
    //   756: f2i
    //   757: fload 5
    //   759: f2i
    //   760: fload 4
    //   762: f2i
    //   763: fload_3
    //   764: f2i
    //   765: aconst_null
    //   766: iconst_0
    //   767: invokestatic 150	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   770: astore 14
    //   772: aload 13
    //   774: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   777: invokevirtual 153	android/graphics/Bitmap:recycle	()V
    //   780: aload 13
    //   782: aload 14
    //   784: putfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   787: aload 13
    //   789: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   792: ifnonnull +24 -> 816
    //   795: ldc 62
    //   797: ldc 155
    //   799: invokestatic 157	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   805: dup
    //   806: ldc 159
    //   808: iconst_0
    //   809: anewarray 76	java/lang/Object
    //   812: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   815: areturn
    //   816: aload 13
    //   818: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   821: invokevirtual 92	android/graphics/Bitmap:getWidth	()I
    //   824: ifle +14 -> 838
    //   827: aload 13
    //   829: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   832: invokevirtual 95	android/graphics/Bitmap:getHeight	()I
    //   835: ifgt +24 -> 859
    //   838: ldc 62
    //   840: ldc 161
    //   842: invokestatic 157	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   848: dup
    //   849: ldc 159
    //   851: iconst_0
    //   852: anewarray 76	java/lang/Object
    //   855: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   858: areturn
    //   859: fload 4
    //   861: fload 7
    //   863: fcmpl
    //   864: ifne +10 -> 874
    //   867: fload_3
    //   868: fload 10
    //   870: fcmpl
    //   871: ifeq +35 -> 906
    //   874: aload 13
    //   876: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   879: fload 7
    //   881: f2i
    //   882: fload 10
    //   884: f2i
    //   885: iconst_0
    //   886: invokestatic 165	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   889: astore 14
    //   891: aload 13
    //   893: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   896: invokevirtual 153	android/graphics/Bitmap:recycle	()V
    //   899: aload 13
    //   901: aload 14
    //   903: putfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   906: aload_0
    //   907: getfield 170	com/tencent/mm/plugin/appbrand/page/q:mAppId	Ljava/lang/String;
    //   910: new 172	java/lang/StringBuilder
    //   913: dup
    //   914: ldc 174
    //   916: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   919: iload 12
    //   921: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 191	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:genMediaFilePath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   930: astore 14
    //   932: aload_1
    //   933: invokestatic 197	com/tencent/mm/plugin/appbrand/jsapi/b/c:u	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   936: astore 15
    //   938: aload 13
    //   940: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   943: aload_1
    //   944: invokestatic 201	com/tencent/mm/plugin/appbrand/jsapi/b/c:t	(Lorg/json/JSONObject;)I
    //   947: aload 15
    //   949: aload 14
    //   951: iconst_1
    //   952: invokestatic 206	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   955: aload_0
    //   956: getfield 170	com/tencent/mm/plugin/appbrand/page/q:mAppId	Ljava/lang/String;
    //   959: astore_1
    //   960: aload 15
    //   962: getstatic 212	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   965: if_acmpne +298 -> 1263
    //   968: ldc 214
    //   970: astore_0
    //   971: aload_1
    //   972: aload 14
    //   974: aload_0
    //   975: iconst_1
    //   976: invokestatic 218	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:attach	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject;
    //   979: astore_0
    //   980: aload_0
    //   981: ifnonnull +289 -> 1270
    //   984: ldc 62
    //   986: ldc 220
    //   988: iconst_1
    //   989: anewarray 76	java/lang/Object
    //   992: dup
    //   993: iconst_0
    //   994: iload 12
    //   996: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   999: aastore
    //   1000: invokestatic 84	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1003: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   1006: dup
    //   1007: ldc 222
    //   1009: iconst_0
    //   1010: anewarray 76	java/lang/Object
    //   1013: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: areturn
    //   1017: astore_0
    //   1018: aload 13
    //   1020: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1023: ifnull +58 -> 1081
    //   1026: ldc 62
    //   1028: ldc 224
    //   1030: iconst_4
    //   1031: anewarray 76	java/lang/Object
    //   1034: dup
    //   1035: iconst_0
    //   1036: aload 13
    //   1038: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1041: invokevirtual 92	android/graphics/Bitmap:getWidth	()I
    //   1044: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_1
    //   1050: aload 13
    //   1052: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1055: invokevirtual 95	android/graphics/Bitmap:getHeight	()I
    //   1058: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_2
    //   1064: fload 7
    //   1066: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_3
    //   1072: fload 10
    //   1074: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1077: aastore
    //   1078: invokestatic 84	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: ldc 62
    //   1083: aload_0
    //   1084: ldc 226
    //   1086: iconst_0
    //   1087: anewarray 76	java/lang/Object
    //   1090: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1093: getstatic 236	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1096: ldc2_w 237
    //   1099: ldc2_w 239
    //   1102: lconst_1
    //   1103: invokevirtual 244	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   1106: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   1109: dup
    //   1110: ldc 246
    //   1112: iconst_0
    //   1113: anewarray 76	java/lang/Object
    //   1116: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1119: areturn
    //   1120: astore_0
    //   1121: aload 13
    //   1123: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1126: ifnull +58 -> 1184
    //   1129: ldc 62
    //   1131: ldc 248
    //   1133: iconst_4
    //   1134: anewarray 76	java/lang/Object
    //   1137: dup
    //   1138: iconst_0
    //   1139: aload 13
    //   1141: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1144: invokevirtual 92	android/graphics/Bitmap:getWidth	()I
    //   1147: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1150: aastore
    //   1151: dup
    //   1152: iconst_1
    //   1153: aload 13
    //   1155: getfield 60	com/tencent/magicbrush/handler/image/MBCanvasContentHolder:content	Landroid/graphics/Bitmap;
    //   1158: invokevirtual 95	android/graphics/Bitmap:getHeight	()I
    //   1161: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1164: aastore
    //   1165: dup
    //   1166: iconst_2
    //   1167: fload 7
    //   1169: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1172: aastore
    //   1173: dup
    //   1174: iconst_3
    //   1175: fload 10
    //   1177: invokestatic 103	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1180: aastore
    //   1181: invokestatic 84	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1184: ldc 62
    //   1186: aload_0
    //   1187: ldc 250
    //   1189: iconst_0
    //   1190: anewarray 76	java/lang/Object
    //   1193: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1196: getstatic 236	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1199: ldc2_w 237
    //   1202: ldc2_w 251
    //   1205: lconst_1
    //   1206: invokevirtual 244	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   1209: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   1212: dup
    //   1213: ldc 254
    //   1215: iconst_0
    //   1216: anewarray 76	java/lang/Object
    //   1219: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1222: areturn
    //   1223: astore_0
    //   1224: ldc 62
    //   1226: ldc_w 256
    //   1229: iconst_2
    //   1230: anewarray 76	java/lang/Object
    //   1233: dup
    //   1234: iconst_0
    //   1235: iload 12
    //   1237: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1240: aastore
    //   1241: dup
    //   1242: iconst_1
    //   1243: aload_0
    //   1244: aastore
    //   1245: invokestatic 84	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1248: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   1251: dup
    //   1252: ldc_w 258
    //   1255: iconst_0
    //   1256: anewarray 76	java/lang/Object
    //   1259: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1262: areturn
    //   1263: ldc_w 260
    //   1266: astore_0
    //   1267: goto -296 -> 971
    //   1270: new 262	java/util/HashMap
    //   1273: dup
    //   1274: invokespecial 263	java/util/HashMap:<init>	()V
    //   1277: astore_1
    //   1278: aload_1
    //   1279: ldc_w 265
    //   1282: aload_0
    //   1283: getfield 270	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:bMB	Ljava/lang/String;
    //   1286: invokeinterface 276 3 0
    //   1291: pop
    //   1292: ldc 62
    //   1294: ldc_w 278
    //   1297: iconst_2
    //   1298: anewarray 76	java/lang/Object
    //   1301: dup
    //   1302: iconst_0
    //   1303: aload_0
    //   1304: getfield 270	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:bMB	Ljava/lang/String;
    //   1307: aastore
    //   1308: dup
    //   1309: iconst_1
    //   1310: aload_0
    //   1311: getfield 281	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:dXY	Ljava/lang/String;
    //   1314: aastore
    //   1315: invokestatic 284	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1318: new 72	com/tencent/mm/plugin/appbrand/jsapi/file/f$a
    //   1321: dup
    //   1322: ldc_w 286
    //   1325: iconst_0
    //   1326: anewarray 76	java/lang/Object
    //   1329: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1332: aload_1
    //   1333: invokevirtual 289	com/tencent/mm/plugin/appbrand/jsapi/file/f$a:t	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/file/f$a;
    //   1336: areturn
    //   1337: goto -851 -> 486
    //   1340: goto -870 -> 470
    //   1343: fload 11
    //   1345: fstore_3
    //   1346: fload 10
    //   1348: fstore 7
    //   1350: fload 4
    //   1352: fstore 6
    //   1354: fload 7
    //   1356: fstore 4
    //   1358: goto -906 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1361	0	paramf	com.tencent.mm.plugin.appbrand.game.page.f
    //   0	1361	1	paramJSONObject	org.json.JSONObject
    //   0	1361	2	paramBoolean	boolean
    //   376	970	3	f1	float
    //   265	1092	4	f2	float
    //   275	483	5	f3	float
    //   200	1153	6	f4	float
    //   212	1143	7	f5	float
    //   114	623	8	f6	float
    //   125	619	9	f7	float
    //   287	1060	10	f8	float
    //   299	1045	11	f9	float
    //   6	1230	12	i	int
    //   15	1139	13	localObject1	java.lang.Object
    //   770	203	14	localObject2	java.lang.Object
    //   936	25	15	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   0	8	75	org/json/JSONException
    //   874	906	1017	java/lang/NullPointerException
    //   874	906	1120	java/lang/IllegalArgumentException
    //   938	955	1223	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.c
 * JD-Core Version:    0.7.0.1
 */