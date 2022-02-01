package com.tencent.mm.plugin.appbrand.jsapi.al.b.b;

import com.tencent.mm.plugin.appbrand.jsapi.c.d;

public final class g
  extends d
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "xwebCanvasToTempFilePath";
  
  /* Error */
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 31
    //   7: ldc 33
    //   9: iconst_1
    //   10: anewarray 35	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_2
    //   16: aastore
    //   17: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_2
    //   21: ldc 42
    //   23: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: fconst_0
    //   27: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   30: f2i
    //   31: istore 6
    //   33: aload_2
    //   34: ldc 56
    //   36: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: fconst_0
    //   40: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   43: f2i
    //   44: istore 7
    //   46: aload_2
    //   47: ldc 58
    //   49: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: fconst_0
    //   53: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   56: f2i
    //   57: istore 8
    //   59: aload_2
    //   60: ldc 60
    //   62: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: fconst_0
    //   66: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   69: f2i
    //   70: istore 9
    //   72: aload_2
    //   73: ldc 62
    //   75: iconst_0
    //   76: invokevirtual 66	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   79: istore 10
    //   81: iload 10
    //   83: invokestatic 72	com/tencent/mm/plugin/appbrand/jsapi/al/b/b:BF	(I)Lcom/tencent/xweb/skia_canvas/SkiaCanvasView;
    //   86: astore 11
    //   88: aload 11
    //   90: ifnonnull +41 -> 131
    //   93: ldc 31
    //   95: ldc 74
    //   97: iconst_1
    //   98: anewarray 35	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: iload 10
    //   105: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_1
    //   113: iload_3
    //   114: aload_0
    //   115: ldc 85
    //   117: invokevirtual 88	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokeinterface 94 3 0
    //   125: ldc 23
    //   127: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: aload 11
    //   133: new 99	android/graphics/Rect
    //   136: dup
    //   137: iload 6
    //   139: iload 7
    //   141: iload 6
    //   143: iload 8
    //   145: iadd
    //   146: iload 7
    //   148: iload 9
    //   150: iadd
    //   151: invokespecial 102	android/graphics/Rect:<init>	(IIII)V
    //   154: invokevirtual 108	com/tencent/xweb/skia_canvas/SkiaCanvasView:getSnapshot	(Landroid/graphics/Rect;)Landroid/graphics/Bitmap;
    //   157: astore 12
    //   159: aload 12
    //   161: ifnonnull +29 -> 190
    //   164: ldc 31
    //   166: ldc 110
    //   168: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: iload_3
    //   173: aload_0
    //   174: ldc 115
    //   176: invokevirtual 88	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokeinterface 94 3 0
    //   184: ldc 23
    //   186: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: aload_2
    //   191: ldc 117
    //   193: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: iload 8
    //   198: i2f
    //   199: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   202: fstore 4
    //   204: aload_2
    //   205: ldc 119
    //   207: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: iload 9
    //   212: i2f
    //   213: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   216: fstore 5
    //   218: aload 12
    //   220: invokevirtual 125	android/graphics/Bitmap:getWidth	()I
    //   223: i2f
    //   224: fload 4
    //   226: fcmpl
    //   227: ifne +19 -> 246
    //   230: aload 12
    //   232: astore 11
    //   234: aload 12
    //   236: invokevirtual 128	android/graphics/Bitmap:getHeight	()I
    //   239: i2f
    //   240: fload 5
    //   242: fcmpl
    //   243: ifeq +46 -> 289
    //   246: fload 4
    //   248: f2i
    //   249: istore 6
    //   251: fload 5
    //   253: f2i
    //   254: istore 7
    //   256: aload 12
    //   258: iload 6
    //   260: iload 7
    //   262: iconst_0
    //   263: invokestatic 132	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   266: astore 11
    //   268: ldc 31
    //   270: ldc 134
    //   272: iconst_2
    //   273: anewarray 35	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 12
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload 11
    //   285: aastore
    //   286: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload 11
    //   291: ifnonnull +79 -> 370
    //   294: ldc 31
    //   296: ldc 110
    //   298: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_1
    //   302: iload_3
    //   303: aload_0
    //   304: ldc 115
    //   306: invokevirtual 88	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokeinterface 94 3 0
    //   314: ldc 23
    //   316: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: return
    //   320: astore 11
    //   322: ldc 31
    //   324: ldc 136
    //   326: iconst_1
    //   327: anewarray 35	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload 11
    //   334: aastore
    //   335: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload 12
    //   340: astore 11
    //   342: goto -53 -> 289
    //   345: astore 11
    //   347: ldc 31
    //   349: ldc 136
    //   351: iconst_1
    //   352: anewarray 35	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload 11
    //   359: aastore
    //   360: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   363: aload 12
    //   365: astore 11
    //   367: goto -78 -> 289
    //   370: aload_2
    //   371: invokestatic 143	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ah	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   374: astore 13
    //   376: aload 13
    //   378: getstatic 149	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   381: if_acmpne +79 -> 460
    //   384: ldc 151
    //   386: astore 12
    //   388: aload_1
    //   389: invokeinterface 155 1 0
    //   394: new 157	java/lang/StringBuilder
    //   397: dup
    //   398: ldc 159
    //   400: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   406: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   409: ldc 174
    //   411: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 12
    //   416: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokeinterface 187 2 0
    //   427: astore 14
    //   429: aload 14
    //   431: ifnonnull +36 -> 467
    //   434: ldc 31
    //   436: ldc 189
    //   438: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload_1
    //   442: iload_3
    //   443: aload_0
    //   444: ldc 191
    //   446: invokevirtual 88	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokeinterface 94 3 0
    //   454: ldc 23
    //   456: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: return
    //   460: ldc 193
    //   462: astore 12
    //   464: goto -76 -> 388
    //   467: aload 14
    //   469: invokevirtual 199	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   472: invokestatic 205	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   475: astore 14
    //   477: ldc 31
    //   479: ldc 207
    //   481: iconst_1
    //   482: anewarray 35	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: aload 14
    //   489: aastore
    //   490: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   493: aload 11
    //   495: aload_2
    //   496: invokestatic 214	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ag	(Lorg/json/JSONObject;)I
    //   499: aload 13
    //   501: aload 14
    //   503: iconst_1
    //   504: invokestatic 220	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   507: pop
    //   508: new 222	com/tencent/mm/plugin/appbrand/af/k
    //   511: dup
    //   512: invokespecial 223	com/tencent/mm/plugin/appbrand/af/k:<init>	()V
    //   515: astore_2
    //   516: aload_1
    //   517: invokeinterface 155 1 0
    //   522: new 195	com/tencent/mm/vfs/u
    //   525: dup
    //   526: aload 14
    //   528: invokespecial 224	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   531: aload 12
    //   533: iconst_0
    //   534: aload_2
    //   535: invokeinterface 227 5 0
    //   540: pop
    //   541: aload_2
    //   542: getfield 231	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
    //   545: checkcast 233	java/lang/String
    //   548: astore_2
    //   549: ldc 31
    //   551: ldc 235
    //   553: iconst_1
    //   554: anewarray 35	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: aload_2
    //   560: aastore
    //   561: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: new 237	java/util/HashMap
    //   567: dup
    //   568: invokespecial 238	java/util/HashMap:<init>	()V
    //   571: astore 11
    //   573: aload 11
    //   575: ldc 240
    //   577: aload_2
    //   578: invokeinterface 246 3 0
    //   583: pop
    //   584: aload_1
    //   585: iload_3
    //   586: aload_0
    //   587: ldc 248
    //   589: aload 11
    //   591: invokevirtual 252	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   594: invokeinterface 94 3 0
    //   599: ldc 23
    //   601: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: return
    //   605: astore_2
    //   606: ldc 31
    //   608: ldc 254
    //   610: iconst_1
    //   611: anewarray 35	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: aload_2
    //   617: aastore
    //   618: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   621: aload_1
    //   622: iload_3
    //   623: aload_0
    //   624: ldc_w 259
    //   627: invokevirtual 88	com/tencent/mm/plugin/appbrand/jsapi/al/b/b/g:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   630: invokeinterface 94 3 0
    //   635: ldc 23
    //   637: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	this	g
    //   0	641	1	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	641	2	paramJSONObject	org.json.JSONObject
    //   0	641	3	paramInt	int
    //   202	45	4	f1	float
    //   216	36	5	f2	float
    //   31	228	6	i	int
    //   44	217	7	j	int
    //   57	140	8	k	int
    //   70	141	9	m	int
    //   79	25	10	n	int
    //   86	204	11	localObject1	java.lang.Object
    //   320	13	11	localException	java.lang.Exception
    //   340	1	11	localObject2	java.lang.Object
    //   345	13	11	localObject3	java.lang.Object
    //   365	225	11	localObject4	java.lang.Object
    //   157	375	12	localObject5	java.lang.Object
    //   374	126	13	localCompressFormat	android.graphics.Bitmap.CompressFormat
    //   427	100	14	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   256	289	320	java/lang/Exception
    //   256	289	345	finally
    //   493	508	605	java/io/IOException
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.b.g
 * JD-Core Version:    0.7.0.1
 */