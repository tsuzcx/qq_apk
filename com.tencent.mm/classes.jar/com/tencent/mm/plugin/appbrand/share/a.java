package com.tencent.mm.plugin.appbrand.share;

import com.tencent.mm.modelappbrand.a.b.e;

public final class a
  implements b.e
{
  private int mHeight;
  private int mWidth;
  
  public a(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  /* Error */
  public final android.graphics.Bitmap o(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 6
    //   3: aload_1
    //   4: astore 8
    //   6: aload_1
    //   7: astore 7
    //   9: aload_1
    //   10: invokevirtual 29	java/io/InputStream:markSupported	()Z
    //   13: ifne +35 -> 48
    //   16: aload_1
    //   17: astore 8
    //   19: aload_1
    //   20: astore 7
    //   22: aload_1
    //   23: instanceof 31
    //   26: ifeq +204 -> 230
    //   29: aload_1
    //   30: astore 8
    //   32: aload_1
    //   33: astore 7
    //   35: new 33	com/tencent/mm/sdk/platformtools/i
    //   38: dup
    //   39: aload_1
    //   40: checkcast 31	java/io/FileInputStream
    //   43: invokespecial 36	com/tencent/mm/sdk/platformtools/i:<init>	(Ljava/io/FileInputStream;)V
    //   46: astore 6
    //   48: aload 6
    //   50: astore 8
    //   52: aload 6
    //   54: astore 7
    //   56: new 38	android/graphics/BitmapFactory$Options
    //   59: dup
    //   60: invokespecial 39	android/graphics/BitmapFactory$Options:<init>	()V
    //   63: astore_1
    //   64: aload 6
    //   66: astore 8
    //   68: aload 6
    //   70: astore 7
    //   72: aload_1
    //   73: iconst_1
    //   74: putfield 43	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   77: aload 6
    //   79: astore 8
    //   81: aload 6
    //   83: astore 7
    //   85: aload 6
    //   87: ldc 44
    //   89: invokevirtual 48	java/io/InputStream:mark	(I)V
    //   92: aload 6
    //   94: astore 8
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: aconst_null
    //   103: aload_1
    //   104: invokestatic 54	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   107: astore 9
    //   109: aload 6
    //   111: astore 8
    //   113: aload 6
    //   115: astore 7
    //   117: aload 6
    //   119: invokevirtual 57	java/io/InputStream:reset	()V
    //   122: aload 9
    //   124: ifnull +16 -> 140
    //   127: aload 6
    //   129: astore 8
    //   131: aload 6
    //   133: astore 7
    //   135: aload 9
    //   137: invokevirtual 62	android/graphics/Bitmap:recycle	()V
    //   140: aload 6
    //   142: astore 8
    //   144: aload 6
    //   146: astore 7
    //   148: aload_1
    //   149: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   152: ifle +18 -> 170
    //   155: aload 6
    //   157: astore 8
    //   159: aload 6
    //   161: astore 7
    //   163: aload_1
    //   164: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   167: ifgt +98 -> 265
    //   170: aload 6
    //   172: astore 8
    //   174: aload 6
    //   176: astore 7
    //   178: ldc 70
    //   180: ldc 72
    //   182: iconst_3
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload 6
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload_1
    //   194: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   197: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: aload_1
    //   204: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   207: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload 6
    //   216: ifnull +8 -> 224
    //   219: aload 6
    //   221: invokevirtual 87	java/io/InputStream:close	()V
    //   224: aconst_null
    //   225: astore 7
    //   227: aload 7
    //   229: areturn
    //   230: aload_1
    //   231: astore 6
    //   233: aload_1
    //   234: astore 8
    //   236: aload_1
    //   237: astore 7
    //   239: aload_1
    //   240: invokevirtual 29	java/io/InputStream:markSupported	()Z
    //   243: ifne -195 -> 48
    //   246: aload_1
    //   247: astore 8
    //   249: aload_1
    //   250: astore 7
    //   252: new 89	java/io/BufferedInputStream
    //   255: dup
    //   256: aload_1
    //   257: invokespecial 92	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   260: astore 6
    //   262: goto -214 -> 48
    //   265: aload 6
    //   267: astore 8
    //   269: aload 6
    //   271: astore 7
    //   273: aload_1
    //   274: aload_1
    //   275: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   278: i2d
    //   279: dconst_1
    //   280: dmul
    //   281: aload_0
    //   282: getfield 16	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   285: i2d
    //   286: ddiv
    //   287: d2i
    //   288: putfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   291: aload 6
    //   293: astore 8
    //   295: aload 6
    //   297: astore 7
    //   299: aload_1
    //   300: getfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   303: iconst_1
    //   304: if_icmpgt +16 -> 320
    //   307: aload 6
    //   309: astore 8
    //   311: aload 6
    //   313: astore 7
    //   315: aload_1
    //   316: iconst_1
    //   317: putfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   320: aload 6
    //   322: astore 8
    //   324: aload 6
    //   326: astore 7
    //   328: aload_1
    //   329: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   332: aload_1
    //   333: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   336: imul
    //   337: aload_1
    //   338: getfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   341: idiv
    //   342: aload_1
    //   343: getfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   346: idiv
    //   347: ldc 96
    //   349: if_icmple +56 -> 405
    //   352: aload 6
    //   354: astore 8
    //   356: aload 6
    //   358: astore 7
    //   360: aload_1
    //   361: aload_1
    //   362: getfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   365: iconst_1
    //   366: iadd
    //   367: putfield 95	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   370: goto -50 -> 320
    //   373: astore_1
    //   374: aload 8
    //   376: astore 7
    //   378: ldc 70
    //   380: ldc 98
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_1
    //   389: aastore
    //   390: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: aload 8
    //   395: ifnull +8 -> 403
    //   398: aload 8
    //   400: invokevirtual 87	java/io/InputStream:close	()V
    //   403: aconst_null
    //   404: areturn
    //   405: aload 6
    //   407: astore 8
    //   409: aload 6
    //   411: astore 7
    //   413: aload_1
    //   414: iconst_0
    //   415: putfield 43	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   418: aload 6
    //   420: astore 8
    //   422: aload 6
    //   424: astore 7
    //   426: aload_1
    //   427: iconst_1
    //   428: putfield 101	android/graphics/BitmapFactory$Options:inMutable	Z
    //   431: aload 6
    //   433: astore 8
    //   435: aload 6
    //   437: astore 7
    //   439: aload_1
    //   440: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   443: i2f
    //   444: aload_1
    //   445: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   448: i2f
    //   449: fdiv
    //   450: aload_0
    //   451: getfield 16	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   454: i2f
    //   455: aload_0
    //   456: getfield 18	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   459: i2f
    //   460: fdiv
    //   461: fcmpl
    //   462: ifle +98 -> 560
    //   465: aload 6
    //   467: astore 8
    //   469: aload 6
    //   471: astore 7
    //   473: aload_1
    //   474: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   477: istore 4
    //   479: aload 6
    //   481: astore 8
    //   483: aload 6
    //   485: astore 7
    //   487: aload_1
    //   488: getfield 65	android/graphics/BitmapFactory$Options:outHeight	I
    //   491: i2f
    //   492: fconst_1
    //   493: fmul
    //   494: aload_0
    //   495: getfield 16	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   498: i2f
    //   499: fmul
    //   500: aload_0
    //   501: getfield 18	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   504: i2f
    //   505: fdiv
    //   506: f2i
    //   507: istore 5
    //   509: aload 6
    //   511: astore 8
    //   513: aload 6
    //   515: astore 7
    //   517: aload 6
    //   519: iconst_0
    //   520: invokestatic 107	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   523: new 109	android/graphics/Rect
    //   526: dup
    //   527: iconst_0
    //   528: iconst_0
    //   529: iload 5
    //   531: iload 4
    //   533: invokespecial 112	android/graphics/Rect:<init>	(IIII)V
    //   536: aload_1
    //   537: invokevirtual 116	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   540: astore_1
    //   541: aload_1
    //   542: astore 7
    //   544: aload 6
    //   546: ifnull -319 -> 227
    //   549: aload 6
    //   551: invokevirtual 87	java/io/InputStream:close	()V
    //   554: aload_1
    //   555: areturn
    //   556: astore 6
    //   558: aload_1
    //   559: areturn
    //   560: aload 6
    //   562: astore 8
    //   564: aload 6
    //   566: astore 7
    //   568: aload_1
    //   569: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   572: istore 5
    //   574: aload 6
    //   576: astore 8
    //   578: aload 6
    //   580: astore 7
    //   582: aload_1
    //   583: getfield 68	android/graphics/BitmapFactory$Options:outWidth	I
    //   586: i2f
    //   587: fstore_2
    //   588: aload 6
    //   590: astore 8
    //   592: aload 6
    //   594: astore 7
    //   596: aload_0
    //   597: getfield 18	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   600: i2f
    //   601: fstore_3
    //   602: aload 6
    //   604: astore 8
    //   606: aload 6
    //   608: astore 7
    //   610: aload_0
    //   611: getfield 16	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   614: istore 4
    //   616: fload_2
    //   617: fconst_1
    //   618: fmul
    //   619: fload_3
    //   620: fmul
    //   621: iload 4
    //   623: i2f
    //   624: fdiv
    //   625: f2i
    //   626: istore 4
    //   628: goto -119 -> 509
    //   631: astore_1
    //   632: aload 7
    //   634: ifnull +8 -> 642
    //   637: aload 7
    //   639: invokevirtual 87	java/io/InputStream:close	()V
    //   642: aload_1
    //   643: athrow
    //   644: astore_1
    //   645: goto -421 -> 224
    //   648: astore_1
    //   649: goto -246 -> 403
    //   652: astore 6
    //   654: goto -12 -> 642
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	a
    //   0	657	1	paramInputStream	java.io.InputStream
    //   587	30	2	f1	float
    //   601	19	3	f2	float
    //   477	150	4	i	int
    //   507	66	5	j	int
    //   1	549	6	localObject1	Object
    //   556	51	6	localIOException1	java.io.IOException
    //   652	1	6	localIOException2	java.io.IOException
    //   7	631	7	localObject2	Object
    //   4	601	8	localObject3	Object
    //   107	29	9	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	16	373	java/io/IOException
    //   22	29	373	java/io/IOException
    //   35	48	373	java/io/IOException
    //   56	64	373	java/io/IOException
    //   72	77	373	java/io/IOException
    //   85	92	373	java/io/IOException
    //   100	109	373	java/io/IOException
    //   117	122	373	java/io/IOException
    //   135	140	373	java/io/IOException
    //   148	155	373	java/io/IOException
    //   163	170	373	java/io/IOException
    //   178	214	373	java/io/IOException
    //   239	246	373	java/io/IOException
    //   252	262	373	java/io/IOException
    //   273	291	373	java/io/IOException
    //   299	307	373	java/io/IOException
    //   315	320	373	java/io/IOException
    //   328	352	373	java/io/IOException
    //   360	370	373	java/io/IOException
    //   413	418	373	java/io/IOException
    //   426	431	373	java/io/IOException
    //   439	465	373	java/io/IOException
    //   473	479	373	java/io/IOException
    //   487	509	373	java/io/IOException
    //   517	541	373	java/io/IOException
    //   568	574	373	java/io/IOException
    //   582	588	373	java/io/IOException
    //   596	602	373	java/io/IOException
    //   610	616	373	java/io/IOException
    //   549	554	556	java/io/IOException
    //   9	16	631	finally
    //   22	29	631	finally
    //   35	48	631	finally
    //   56	64	631	finally
    //   72	77	631	finally
    //   85	92	631	finally
    //   100	109	631	finally
    //   117	122	631	finally
    //   135	140	631	finally
    //   148	155	631	finally
    //   163	170	631	finally
    //   178	214	631	finally
    //   239	246	631	finally
    //   252	262	631	finally
    //   273	291	631	finally
    //   299	307	631	finally
    //   315	320	631	finally
    //   328	352	631	finally
    //   360	370	631	finally
    //   378	393	631	finally
    //   413	418	631	finally
    //   426	431	631	finally
    //   439	465	631	finally
    //   473	479	631	finally
    //   487	509	631	finally
    //   517	541	631	finally
    //   568	574	631	finally
    //   582	588	631	finally
    //   596	602	631	finally
    //   610	616	631	finally
    //   219	224	644	java/io/IOException
    //   398	403	648	java/io/IOException
    //   637	642	652	java/io/IOException
  }
  
  public final String pU()
  {
    return String.format("Decoder_w%s_h%s", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a
 * JD-Core Version:    0.7.0.1
 */