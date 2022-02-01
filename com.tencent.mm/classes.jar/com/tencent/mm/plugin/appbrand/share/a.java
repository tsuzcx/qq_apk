package com.tencent.mm.plugin.appbrand.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.k.a;

public final class a
  implements b.f
{
  private int mHeight;
  private int mWidth;
  public k.a mww = k.a.hKr;
  
  public a(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public final String BM()
  {
    AppMethodBeat.i(48316);
    String str = String.format("Decoder_w%s_h%s", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(48316);
    return str;
  }
  
  /* Error */
  public final android.graphics.Bitmap x(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 63
    //   7: ldc 65
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: getfield 23	com/tencent/mm/plugin/appbrand/share/a:mww	Lcom/tencent/mm/modelappbrand/k$a;
    //   19: invokevirtual 69	com/tencent/mm/modelappbrand/k$a:ordinal	()I
    //   22: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: aastore
    //   26: invokestatic 75	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: astore 6
    //   32: aload_1
    //   33: astore 8
    //   35: aload_1
    //   36: astore 7
    //   38: aload_1
    //   39: invokevirtual 81	java/io/InputStream:markSupported	()Z
    //   42: ifne +35 -> 77
    //   45: aload_1
    //   46: astore 8
    //   48: aload_1
    //   49: astore 7
    //   51: aload_1
    //   52: instanceof 83
    //   55: ifeq +232 -> 287
    //   58: aload_1
    //   59: astore 8
    //   61: aload_1
    //   62: astore 7
    //   64: new 85	com/tencent/mm/sdk/platformtools/o
    //   67: dup
    //   68: aload_1
    //   69: checkcast 83	java/io/FileInputStream
    //   72: invokespecial 88	com/tencent/mm/sdk/platformtools/o:<init>	(Ljava/io/FileInputStream;)V
    //   75: astore 6
    //   77: aload 6
    //   79: astore 8
    //   81: aload 6
    //   83: astore 7
    //   85: new 90	android/graphics/BitmapFactory$Options
    //   88: dup
    //   89: invokespecial 91	android/graphics/BitmapFactory$Options:<init>	()V
    //   92: astore 10
    //   94: aload 6
    //   96: astore 8
    //   98: aload 6
    //   100: astore 7
    //   102: aload 10
    //   104: iconst_1
    //   105: putfield 95	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   108: aload 6
    //   110: astore 8
    //   112: aload 6
    //   114: astore 7
    //   116: aload 6
    //   118: ldc 96
    //   120: invokevirtual 99	java/io/InputStream:mark	(I)V
    //   123: aload 6
    //   125: astore 8
    //   127: aload 6
    //   129: astore 7
    //   131: aload 6
    //   133: aconst_null
    //   134: aload 10
    //   136: invokestatic 105	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore_1
    //   140: aload 6
    //   142: astore 8
    //   144: aload 6
    //   146: astore 7
    //   148: aload 6
    //   150: invokevirtual 108	java/io/InputStream:reset	()V
    //   153: aload_1
    //   154: ifnull +38 -> 192
    //   157: aload 6
    //   159: astore 8
    //   161: aload 6
    //   163: astore 7
    //   165: ldc 63
    //   167: ldc 110
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: aastore
    //   177: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload 6
    //   182: astore 8
    //   184: aload 6
    //   186: astore 7
    //   188: aload_1
    //   189: invokevirtual 117	android/graphics/Bitmap:recycle	()V
    //   192: aload 6
    //   194: astore 8
    //   196: aload 6
    //   198: astore 7
    //   200: aload 10
    //   202: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   205: ifle +19 -> 224
    //   208: aload 6
    //   210: astore 8
    //   212: aload 6
    //   214: astore 7
    //   216: aload 10
    //   218: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   221: ifgt +101 -> 322
    //   224: aload 6
    //   226: astore 8
    //   228: aload 6
    //   230: astore 7
    //   232: ldc 63
    //   234: ldc 125
    //   236: iconst_3
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 6
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload 10
    //   249: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   252: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: iconst_2
    //   258: aload 10
    //   260: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   263: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload 6
    //   272: ifnull +8 -> 280
    //   275: aload 6
    //   277: invokevirtual 131	java/io/InputStream:close	()V
    //   280: ldc 61
    //   282: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aconst_null
    //   286: areturn
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: astore 8
    //   293: aload_1
    //   294: astore 7
    //   296: aload_1
    //   297: invokevirtual 81	java/io/InputStream:markSupported	()Z
    //   300: ifne -223 -> 77
    //   303: aload_1
    //   304: astore 8
    //   306: aload_1
    //   307: astore 7
    //   309: new 133	java/io/BufferedInputStream
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   317: astore 6
    //   319: goto -242 -> 77
    //   322: aload 6
    //   324: astore 8
    //   326: aload 6
    //   328: astore 7
    //   330: aload 10
    //   332: aload 10
    //   334: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   337: i2d
    //   338: dconst_1
    //   339: dmul
    //   340: aload_0
    //   341: getfield 25	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   344: i2d
    //   345: ddiv
    //   346: d2i
    //   347: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   350: aload 6
    //   352: astore 8
    //   354: aload 6
    //   356: astore 7
    //   358: aload 10
    //   360: getfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   363: iconst_1
    //   364: if_icmpgt +17 -> 381
    //   367: aload 6
    //   369: astore 8
    //   371: aload 6
    //   373: astore 7
    //   375: aload 10
    //   377: iconst_1
    //   378: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   381: aload 6
    //   383: astore 8
    //   385: aload 6
    //   387: astore 7
    //   389: aload 10
    //   391: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   394: aload 10
    //   396: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   399: imul
    //   400: aload 10
    //   402: getfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   405: idiv
    //   406: aload 10
    //   408: getfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   411: idiv
    //   412: ldc 140
    //   414: if_icmple +63 -> 477
    //   417: aload 6
    //   419: astore 8
    //   421: aload 6
    //   423: astore 7
    //   425: aload 10
    //   427: aload 10
    //   429: getfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   432: iconst_1
    //   433: iadd
    //   434: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   437: goto -56 -> 381
    //   440: astore_1
    //   441: aload 8
    //   443: astore 7
    //   445: ldc 63
    //   447: ldc 142
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload_1
    //   456: aastore
    //   457: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload 8
    //   462: ifnull +8 -> 470
    //   465: aload 8
    //   467: invokevirtual 131	java/io/InputStream:close	()V
    //   470: ldc 61
    //   472: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aconst_null
    //   476: areturn
    //   477: aload 6
    //   479: astore 8
    //   481: aload 6
    //   483: astore 7
    //   485: aload 10
    //   487: iconst_0
    //   488: putfield 95	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   491: aload 6
    //   493: astore 8
    //   495: aload 6
    //   497: astore 7
    //   499: aload 10
    //   501: iconst_1
    //   502: putfield 145	android/graphics/BitmapFactory$Options:inMutable	Z
    //   505: aload 6
    //   507: astore 8
    //   509: aload 6
    //   511: astore 7
    //   513: aload 10
    //   515: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   518: i2f
    //   519: aload 10
    //   521: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   524: i2f
    //   525: fdiv
    //   526: fstore_2
    //   527: aload 6
    //   529: astore 8
    //   531: aload 6
    //   533: astore 7
    //   535: aload_0
    //   536: getfield 25	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   539: i2f
    //   540: aload_0
    //   541: getfield 27	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   544: i2f
    //   545: fdiv
    //   546: fstore_3
    //   547: aload 6
    //   549: astore 8
    //   551: aload 6
    //   553: astore 7
    //   555: getstatic 151	com/tencent/mm/plugin/appbrand/share/a$1:mwx	[I
    //   558: aload_0
    //   559: getfield 23	com/tencent/mm/plugin/appbrand/share/a:mww	Lcom/tencent/mm/modelappbrand/k$a;
    //   562: invokevirtual 69	com/tencent/mm/modelappbrand/k$a:ordinal	()I
    //   565: iaload
    //   566: istore 4
    //   568: iload 4
    //   570: tableswitch	default:+22 -> 592, 1:+41->611, 2:+310->880
    //   593: astore_1
    //   594: aload 6
    //   596: ifnull +8 -> 604
    //   599: aload 6
    //   601: invokevirtual 131	java/io/InputStream:close	()V
    //   604: ldc 61
    //   606: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   609: aload_1
    //   610: areturn
    //   611: fload_2
    //   612: fload_3
    //   613: fcmpl
    //   614: ifle +173 -> 787
    //   617: aload 6
    //   619: astore 8
    //   621: aload 6
    //   623: astore 7
    //   625: aload 10
    //   627: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   630: istore 4
    //   632: aload 6
    //   634: astore 8
    //   636: aload 6
    //   638: astore 7
    //   640: aload 10
    //   642: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   645: i2f
    //   646: fconst_1
    //   647: fmul
    //   648: aload_0
    //   649: getfield 25	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   652: i2f
    //   653: fmul
    //   654: aload_0
    //   655: getfield 27	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   658: i2f
    //   659: fdiv
    //   660: f2i
    //   661: istore 5
    //   663: aload 6
    //   665: astore 8
    //   667: aload 6
    //   669: astore 7
    //   671: aload 6
    //   673: iconst_0
    //   674: invokestatic 157	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   677: new 159	android/graphics/Rect
    //   680: dup
    //   681: iconst_0
    //   682: iconst_0
    //   683: iload 5
    //   685: iload 4
    //   687: invokespecial 162	android/graphics/Rect:<init>	(IIII)V
    //   690: aload 10
    //   692: invokevirtual 166	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   695: astore 9
    //   697: aload 9
    //   699: astore_1
    //   700: aload 9
    //   702: ifnonnull -108 -> 594
    //   705: aload 6
    //   707: astore 8
    //   709: aload 6
    //   711: astore 7
    //   713: ldc 63
    //   715: ldc 168
    //   717: iconst_4
    //   718: anewarray 4	java/lang/Object
    //   721: dup
    //   722: iconst_0
    //   723: aload 10
    //   725: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   728: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   731: aastore
    //   732: dup
    //   733: iconst_1
    //   734: aload 10
    //   736: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   739: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   742: aastore
    //   743: dup
    //   744: iconst_2
    //   745: iload 5
    //   747: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: dup
    //   752: iconst_3
    //   753: iload 4
    //   755: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   758: aastore
    //   759: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: aload 6
    //   764: astore 7
    //   766: aload 6
    //   768: invokevirtual 108	java/io/InputStream:reset	()V
    //   771: aload 6
    //   773: astore 7
    //   775: aload 6
    //   777: aconst_null
    //   778: aload 10
    //   780: invokestatic 171	com/tencent/mm/compatible/e/a:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   783: astore_1
    //   784: goto -190 -> 594
    //   787: aload 6
    //   789: astore 8
    //   791: aload 6
    //   793: astore 7
    //   795: aload 10
    //   797: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   800: istore 5
    //   802: aload 6
    //   804: astore 8
    //   806: aload 6
    //   808: astore 7
    //   810: aload 10
    //   812: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   815: i2f
    //   816: fconst_1
    //   817: fmul
    //   818: aload_0
    //   819: getfield 27	com/tencent/mm/plugin/appbrand/share/a:mHeight	I
    //   822: i2f
    //   823: fmul
    //   824: aload_0
    //   825: getfield 25	com/tencent/mm/plugin/appbrand/share/a:mWidth	I
    //   828: i2f
    //   829: fdiv
    //   830: f2i
    //   831: istore 4
    //   833: goto -170 -> 663
    //   836: aload 6
    //   838: astore 8
    //   840: aload 6
    //   842: astore 7
    //   844: ldc 63
    //   846: aload_1
    //   847: ldc 173
    //   849: iconst_0
    //   850: anewarray 4	java/lang/Object
    //   853: invokestatic 177	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   856: aload 9
    //   858: astore_1
    //   859: goto -265 -> 594
    //   862: astore_1
    //   863: aload 7
    //   865: ifnull +8 -> 873
    //   868: aload 7
    //   870: invokevirtual 131	java/io/InputStream:close	()V
    //   873: ldc 61
    //   875: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   878: aload_1
    //   879: athrow
    //   880: aload 6
    //   882: astore 8
    //   884: aload 6
    //   886: astore 7
    //   888: aload 6
    //   890: aconst_null
    //   891: aload 10
    //   893: invokestatic 171	com/tencent/mm/compatible/e/a:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   896: astore_1
    //   897: goto -303 -> 594
    //   900: astore_1
    //   901: goto -621 -> 280
    //   904: astore 6
    //   906: goto -302 -> 604
    //   909: astore_1
    //   910: goto -440 -> 470
    //   913: astore 6
    //   915: goto -42 -> 873
    //   918: astore_1
    //   919: goto -83 -> 836
    //   922: astore_1
    //   923: goto -87 -> 836
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	a
    //   0	926	1	paramInputStream	java.io.InputStream
    //   526	86	2	f1	float
    //   546	67	3	f2	float
    //   566	266	4	i	int
    //   661	140	5	j	int
    //   30	859	6	localObject1	Object
    //   904	1	6	localIOException1	java.io.IOException
    //   913	1	6	localIOException2	java.io.IOException
    //   36	851	7	localObject2	Object
    //   33	850	8	localObject3	Object
    //   695	162	9	localBitmap	android.graphics.Bitmap
    //   92	800	10	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   38	45	440	java/io/IOException
    //   51	58	440	java/io/IOException
    //   64	77	440	java/io/IOException
    //   85	94	440	java/io/IOException
    //   102	108	440	java/io/IOException
    //   116	123	440	java/io/IOException
    //   131	140	440	java/io/IOException
    //   148	153	440	java/io/IOException
    //   165	180	440	java/io/IOException
    //   188	192	440	java/io/IOException
    //   200	208	440	java/io/IOException
    //   216	224	440	java/io/IOException
    //   232	270	440	java/io/IOException
    //   296	303	440	java/io/IOException
    //   309	319	440	java/io/IOException
    //   330	350	440	java/io/IOException
    //   358	367	440	java/io/IOException
    //   375	381	440	java/io/IOException
    //   389	417	440	java/io/IOException
    //   425	437	440	java/io/IOException
    //   485	491	440	java/io/IOException
    //   499	505	440	java/io/IOException
    //   513	527	440	java/io/IOException
    //   535	547	440	java/io/IOException
    //   555	568	440	java/io/IOException
    //   625	632	440	java/io/IOException
    //   640	663	440	java/io/IOException
    //   671	697	440	java/io/IOException
    //   713	762	440	java/io/IOException
    //   795	802	440	java/io/IOException
    //   810	833	440	java/io/IOException
    //   844	856	440	java/io/IOException
    //   888	897	440	java/io/IOException
    //   38	45	862	finally
    //   51	58	862	finally
    //   64	77	862	finally
    //   85	94	862	finally
    //   102	108	862	finally
    //   116	123	862	finally
    //   131	140	862	finally
    //   148	153	862	finally
    //   165	180	862	finally
    //   188	192	862	finally
    //   200	208	862	finally
    //   216	224	862	finally
    //   232	270	862	finally
    //   296	303	862	finally
    //   309	319	862	finally
    //   330	350	862	finally
    //   358	367	862	finally
    //   375	381	862	finally
    //   389	417	862	finally
    //   425	437	862	finally
    //   445	460	862	finally
    //   485	491	862	finally
    //   499	505	862	finally
    //   513	527	862	finally
    //   535	547	862	finally
    //   555	568	862	finally
    //   625	632	862	finally
    //   640	663	862	finally
    //   671	697	862	finally
    //   713	762	862	finally
    //   766	771	862	finally
    //   775	784	862	finally
    //   795	802	862	finally
    //   810	833	862	finally
    //   844	856	862	finally
    //   888	897	862	finally
    //   275	280	900	java/io/IOException
    //   599	604	904	java/io/IOException
    //   465	470	909	java/io/IOException
    //   868	873	913	java/io/IOException
    //   766	771	918	java/io/IOException
    //   775	784	918	java/io/IOException
    //   766	771	922	java/lang/OutOfMemoryError
    //   775	784	922	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a
 * JD-Core Version:    0.7.0.1
 */