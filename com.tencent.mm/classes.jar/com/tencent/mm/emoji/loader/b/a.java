package com.tencent.mm.emoji.loader.b;

import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";
  
  /* Error */
  public final android.graphics.drawable.Drawable a(com.tencent.mm.storage.emotion.EmojiInfo paramEmojiInfo, d.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, d.z> paramm)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 44
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 51
    //   11: invokestatic 57	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   18: getstatic 69	com/tencent/mm/storage/emotion/EmojiGroupInfo:OzS	I
    //   21: if_icmpeq +23 -> 44
    //   24: aload_1
    //   25: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   28: getstatic 72	com/tencent/mm/storage/emotion/EmojiInfo:OzZ	I
    //   31: if_icmpeq +13 -> 44
    //   34: aload_1
    //   35: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   38: getstatic 75	com/tencent/mm/storage/emotion/EmojiInfo:OzY	I
    //   41: if_icmpne +147 -> 188
    //   44: aload_1
    //   45: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: ldc 80
    //   54: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   57: aload 7
    //   59: checkcast 85	java/lang/CharSequence
    //   62: iconst_1
    //   63: anewarray 87	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc 89
    //   70: aastore
    //   71: invokestatic 94	d/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   74: iconst_0
    //   75: invokeinterface 100 2 0
    //   80: checkcast 87	java/lang/String
    //   83: astore 7
    //   85: aload_0
    //   86: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   89: ldc 102
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 7
    //   99: aastore
    //   100: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: invokestatic 114	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   106: astore 8
    //   108: aload 8
    //   110: ldc 116
    //   112: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   115: aload 8
    //   117: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   120: aload 7
    //   122: ldc 124
    //   124: invokestatic 127	com/tencent/mm/sdk/platformtools/ak:getPackageName	()Ljava/lang/String;
    //   127: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   130: istore_3
    //   131: invokestatic 114	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   134: astore 7
    //   136: aload 7
    //   138: ldc 116
    //   140: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   143: aload 7
    //   145: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   148: iload_3
    //   149: invokevirtual 137	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   152: astore 7
    //   154: iconst_0
    //   155: istore_3
    //   156: iconst_0
    //   157: istore 4
    //   159: aload 7
    //   161: ifnull +585 -> 746
    //   164: aload_2
    //   165: iload 4
    //   167: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: iload_3
    //   171: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokeinterface 149 3 0
    //   179: pop
    //   180: ldc 44
    //   182: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 7
    //   187: areturn
    //   188: aload_1
    //   189: invokevirtual 156	com/tencent/mm/storage/emotion/EmojiInfo:fxr	()Z
    //   192: ifeq +131 -> 323
    //   195: aload_1
    //   196: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   199: astore 7
    //   201: aload 7
    //   203: ldc 80
    //   205: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   208: aload 7
    //   210: checkcast 85	java/lang/CharSequence
    //   213: iconst_1
    //   214: anewarray 87	java/lang/String
    //   217: dup
    //   218: iconst_0
    //   219: ldc 89
    //   221: aastore
    //   222: invokestatic 94	d/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   225: iconst_0
    //   226: invokeinterface 100 2 0
    //   231: checkcast 87	java/lang/String
    //   234: astore 7
    //   236: aload_0
    //   237: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   240: ldc 102
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 7
    //   250: aastore
    //   251: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: invokestatic 114	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   257: astore 8
    //   259: aload 8
    //   261: ldc 116
    //   263: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   266: aload 8
    //   268: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   271: aload 7
    //   273: ldc 124
    //   275: invokestatic 127	com/tencent/mm/sdk/platformtools/ak:getPackageName	()Ljava/lang/String;
    //   278: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   281: istore_3
    //   282: invokestatic 114	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   285: astore 7
    //   287: aload 7
    //   289: ldc 116
    //   291: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   294: new 158	com/tencent/mm/plugin/gif/d
    //   297: dup
    //   298: aload 7
    //   300: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   303: iload_3
    //   304: invokevirtual 162	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   307: invokespecial 165	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   310: checkcast 167	android/graphics/drawable/Drawable
    //   313: astore 7
    //   315: iconst_0
    //   316: istore_3
    //   317: iconst_0
    //   318: istore 4
    //   320: goto -161 -> 159
    //   323: aload_1
    //   324: invokevirtual 170	com/tencent/mm/storage/emotion/EmojiInfo:fxn	()Z
    //   327: ifne +10 -> 337
    //   330: ldc 44
    //   332: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aconst_null
    //   336: areturn
    //   337: ldc 172
    //   339: invokestatic 178	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   342: astore 7
    //   344: aload 7
    //   346: ldc 180
    //   348: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   351: aload 7
    //   353: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   356: invokeinterface 184 1 0
    //   361: aload_1
    //   362: invokeinterface 189 2 0
    //   367: astore 9
    //   369: aload 9
    //   371: invokestatic 195	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
    //   374: ifeq +40 -> 414
    //   377: aload_0
    //   378: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   381: new 197	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 199
    //   387: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_1
    //   391: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:Lj	()Ljava/lang/String;
    //   394: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 215	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_1
    //   404: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   407: ldc 44
    //   409: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aconst_null
    //   413: areturn
    //   414: aload 9
    //   416: invokestatic 223	com/tencent/mm/sdk/platformtools/u:cy	([B)Z
    //   419: ifeq +130 -> 549
    //   422: new 225	com/tencent/mm/plugin/gif/h
    //   425: dup
    //   426: aload 9
    //   428: aload_1
    //   429: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:Lj	()Ljava/lang/String;
    //   432: invokespecial 228	com/tencent/mm/plugin/gif/h:<init>	([BLjava/lang/String;)V
    //   435: checkcast 167	android/graphics/drawable/Drawable
    //   438: astore 7
    //   440: ldc 172
    //   442: invokestatic 178	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   445: astore 8
    //   447: aload 8
    //   449: ldc 180
    //   451: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   454: aload 8
    //   456: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   459: invokeinterface 184 1 0
    //   464: astore 8
    //   466: aload 8
    //   468: ldc 230
    //   470: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   473: aload 8
    //   475: invokeinterface 233 1 0
    //   480: ifne +327 -> 807
    //   483: aload_0
    //   484: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   487: ldc 235
    //   489: invokestatic 238	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_1
    //   493: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   496: getstatic 244	com/tencent/mm/emoji/loader/e:gkR	Lcom/tencent/mm/emoji/loader/e;
    //   499: astore 8
    //   501: aload_1
    //   502: iconst_1
    //   503: aconst_null
    //   504: invokestatic 247	com/tencent/mm/emoji/loader/e:a	(Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/loader/d/i$a;)Lcom/tencent/mm/emoji/loader/d/e;
    //   507: pop
    //   508: aload 7
    //   510: instanceof 158
    //   513: ifeq +57 -> 570
    //   516: aload 7
    //   518: checkcast 158	com/tencent/mm/plugin/gif/d
    //   521: invokevirtual 250	com/tencent/mm/plugin/gif/d:ddP	()I
    //   524: istore 4
    //   526: iload 4
    //   528: istore_3
    //   529: iload 4
    //   531: istore 5
    //   533: aload 7
    //   535: checkcast 158	com/tencent/mm/plugin/gif/d
    //   538: invokevirtual 253	com/tencent/mm/plugin/gif/d:ddQ	()I
    //   541: istore 6
    //   543: iload 6
    //   545: istore_3
    //   546: goto -387 -> 159
    //   549: new 158	com/tencent/mm/plugin/gif/d
    //   552: dup
    //   553: aload 9
    //   555: aload_1
    //   556: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:Lj	()Ljava/lang/String;
    //   559: invokespecial 254	com/tencent/mm/plugin/gif/d:<init>	([BLjava/lang/String;)V
    //   562: checkcast 167	android/graphics/drawable/Drawable
    //   565: astore 7
    //   567: goto -59 -> 508
    //   570: aload 7
    //   572: checkcast 225	com/tencent/mm/plugin/gif/h
    //   575: invokevirtual 255	com/tencent/mm/plugin/gif/h:ddP	()I
    //   578: istore 4
    //   580: iload 4
    //   582: istore_3
    //   583: iload 4
    //   585: istore 5
    //   587: aload 7
    //   589: checkcast 225	com/tencent/mm/plugin/gif/h
    //   592: invokevirtual 256	com/tencent/mm/plugin/gif/h:ddQ	()I
    //   595: istore 6
    //   597: iload 6
    //   599: istore_3
    //   600: goto -441 -> 159
    //   603: astore 8
    //   605: aconst_null
    //   606: astore 7
    //   608: iconst_0
    //   609: istore 4
    //   611: aload 8
    //   613: invokevirtual 259	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   616: bipush 103
    //   618: if_icmpne +184 -> 802
    //   621: aload 9
    //   623: invokestatic 265	com/tencent/mm/sdk/platformtools/h:cu	([B)Landroid/graphics/Bitmap;
    //   626: astore 8
    //   628: aload 8
    //   630: ifnonnull +24 -> 654
    //   633: aload_0
    //   634: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   637: ldc_w 267
    //   640: invokestatic 215	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: aload_1
    //   644: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   647: ldc 44
    //   649: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   652: aconst_null
    //   653: areturn
    //   654: aload 8
    //   656: sipush 320
    //   659: invokevirtual 272	android/graphics/Bitmap:setDensity	(I)V
    //   662: invokestatic 114	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   665: astore 7
    //   667: aload 7
    //   669: ldc 116
    //   671: invokestatic 83	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   674: new 274	android/graphics/drawable/BitmapDrawable
    //   677: dup
    //   678: aload 7
    //   680: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   683: aload 8
    //   685: invokespecial 277	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   688: checkcast 167	android/graphics/drawable/Drawable
    //   691: astore 7
    //   693: aload 8
    //   695: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   698: istore 4
    //   700: aload 8
    //   702: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   705: istore_3
    //   706: goto -547 -> 159
    //   709: astore 9
    //   711: iconst_0
    //   712: istore 4
    //   714: aload 8
    //   716: astore 7
    //   718: aload 9
    //   720: astore 8
    //   722: aload_0
    //   723: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   726: aload 8
    //   728: checkcast 285	java/lang/Throwable
    //   731: ldc_w 286
    //   734: iconst_0
    //   735: anewarray 4	java/lang/Object
    //   738: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   741: iconst_0
    //   742: istore_3
    //   743: goto -584 -> 159
    //   746: aload_1
    //   747: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   750: goto -570 -> 180
    //   753: astore 8
    //   755: iconst_0
    //   756: istore 4
    //   758: goto -36 -> 722
    //   761: astore 8
    //   763: iconst_0
    //   764: istore 4
    //   766: goto -44 -> 722
    //   769: astore 8
    //   771: iload_3
    //   772: istore 4
    //   774: goto -52 -> 722
    //   777: astore 8
    //   779: iconst_0
    //   780: istore 4
    //   782: goto -171 -> 611
    //   785: astore 8
    //   787: iconst_0
    //   788: istore 4
    //   790: goto -179 -> 611
    //   793: astore 8
    //   795: iload 5
    //   797: istore 4
    //   799: goto -188 -> 611
    //   802: iconst_0
    //   803: istore_3
    //   804: goto -645 -> 159
    //   807: goto -299 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	810	0	this	a
    //   0	810	1	paramEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    //   0	810	2	paramm	d.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, d.z>
    //   130	674	3	i	int
    //   157	641	4	j	int
    //   531	265	5	k	int
    //   541	57	6	m	int
    //   48	669	7	localObject1	Object
    //   1	499	8	localObject2	Object
    //   603	9	8	localMMGIFException1	com.tencent.mm.plugin.gif.MMGIFException
    //   626	101	8	localObject3	Object
    //   753	1	8	localIOException1	java.io.IOException
    //   761	1	8	localIOException2	java.io.IOException
    //   769	1	8	localIOException3	java.io.IOException
    //   777	1	8	localMMGIFException2	com.tencent.mm.plugin.gif.MMGIFException
    //   785	1	8	localMMGIFException3	com.tencent.mm.plugin.gif.MMGIFException
    //   793	1	8	localMMGIFException4	com.tencent.mm.plugin.gif.MMGIFException
    //   367	255	9	arrayOfByte	byte[]
    //   709	10	9	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   414	440	603	com/tencent/mm/plugin/gif/MMGIFException
    //   549	567	603	com/tencent/mm/plugin/gif/MMGIFException
    //   414	440	709	java/io/IOException
    //   549	567	709	java/io/IOException
    //   440	508	753	java/io/IOException
    //   508	526	761	java/io/IOException
    //   570	580	761	java/io/IOException
    //   533	543	769	java/io/IOException
    //   587	597	769	java/io/IOException
    //   440	508	777	com/tencent/mm/plugin/gif/MMGIFException
    //   508	526	785	com/tencent/mm/plugin/gif/MMGIFException
    //   570	580	785	com/tencent/mm/plugin/gif/MMGIFException
    //   533	543	793	com/tencent/mm/plugin/gif/MMGIFException
    //   587	597	793	com/tencent/mm/plugin/gif/MMGIFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b.a
 * JD-Core Version:    0.7.0.1
 */