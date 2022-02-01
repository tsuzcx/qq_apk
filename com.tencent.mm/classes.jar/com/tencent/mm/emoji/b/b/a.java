package com.tencent.mm.emoji.b.b;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";
  
  /* Error */
  public final android.graphics.drawable.Drawable a(com.tencent.mm.storage.emotion.EmojiInfo paramEmojiInfo, kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.ah> paramm)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 54
    //   8: invokestatic 60	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 65	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   15: invokestatic 71	com/tencent/mm/plugin/emoji/g/d:apc	(Ljava/lang/String;)Z
    //   18: ifeq +169 -> 187
    //   21: aload_1
    //   22: invokevirtual 74	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   25: astore 7
    //   27: aload 7
    //   29: ldc 76
    //   31: invokestatic 79	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload 7
    //   36: checkcast 81	java/lang/CharSequence
    //   39: iconst_1
    //   40: anewarray 83	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc 85
    //   47: aastore
    //   48: invokestatic 90	kotlin/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   51: iconst_0
    //   52: invokeinterface 96 2 0
    //   57: checkcast 83	java/lang/String
    //   60: astore 7
    //   62: aload_0
    //   63: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   66: ldc 98
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload 7
    //   76: aastore
    //   77: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   83: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   86: aload 7
    //   88: ldc 118
    //   90: invokestatic 121	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   93: invokevirtual 127	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +641 -> 739
    //   101: aload_1
    //   102: invokevirtual 65	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   105: invokestatic 130	com/tencent/mm/plugin/emoji/g/d:apd	(Ljava/lang/String;)Z
    //   108: ifeq +49 -> 157
    //   111: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   114: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   117: iload_3
    //   118: invokevirtual 134	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   121: astore 7
    //   123: iconst_0
    //   124: istore_3
    //   125: iconst_0
    //   126: istore 4
    //   128: aload 7
    //   130: ifnull +545 -> 675
    //   133: aload_2
    //   134: iload 4
    //   136: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: iload_3
    //   140: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokeinterface 146 3 0
    //   148: pop
    //   149: ldc 47
    //   151: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 7
    //   156: areturn
    //   157: new 151	com/tencent/mm/plugin/gif/d
    //   160: dup
    //   161: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   164: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   167: iload_3
    //   168: invokevirtual 155	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   171: invokespecial 158	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   174: checkcast 160	android/graphics/drawable/Drawable
    //   177: astore 7
    //   179: iconst_0
    //   180: istore_3
    //   181: iconst_0
    //   182: istore 4
    //   184: goto -56 -> 128
    //   187: aload_1
    //   188: invokevirtual 164	com/tencent/mm/storage/emotion/EmojiInfo:kMe	()Z
    //   191: ifeq +113 -> 304
    //   194: aload_1
    //   195: invokevirtual 74	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   198: astore 7
    //   200: aload 7
    //   202: ldc 76
    //   204: invokestatic 79	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   207: aload 7
    //   209: checkcast 81	java/lang/CharSequence
    //   212: iconst_1
    //   213: anewarray 83	java/lang/String
    //   216: dup
    //   217: iconst_0
    //   218: ldc 85
    //   220: aastore
    //   221: invokestatic 90	kotlin/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   224: iconst_0
    //   225: invokeinterface 96 2 0
    //   230: checkcast 83	java/lang/String
    //   233: astore 7
    //   235: aload_0
    //   236: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   239: ldc 98
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload 7
    //   249: aastore
    //   250: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   256: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   259: aload 7
    //   261: ldc 118
    //   263: invokestatic 121	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   266: invokevirtual 127	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   269: istore_3
    //   270: iload_3
    //   271: ifeq +468 -> 739
    //   274: new 151	com/tencent/mm/plugin/gif/d
    //   277: dup
    //   278: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   281: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   284: iload_3
    //   285: invokevirtual 155	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   288: invokespecial 158	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   291: checkcast 160	android/graphics/drawable/Drawable
    //   294: astore 7
    //   296: iconst_0
    //   297: istore_3
    //   298: iconst_0
    //   299: istore 4
    //   301: goto -173 -> 128
    //   304: aload_1
    //   305: invokevirtual 167	com/tencent/mm/storage/emotion/EmojiInfo:kLZ	()Z
    //   308: ifne +10 -> 318
    //   311: ldc 47
    //   313: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aconst_null
    //   317: areturn
    //   318: ldc 169
    //   320: invokestatic 175	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   323: checkcast 169	com/tencent/mm/plugin/emoji/c/d
    //   326: invokeinterface 179 1 0
    //   331: aload_1
    //   332: invokeinterface 184 2 0
    //   337: astore 9
    //   339: aload 9
    //   341: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   344: ifeq +30 -> 374
    //   347: aload_0
    //   348: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   351: ldc 192
    //   353: aload_1
    //   354: invokevirtual 65	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   357: invokestatic 196	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   360: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 202	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   367: ldc 47
    //   369: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aconst_null
    //   373: areturn
    //   374: aload 9
    //   376: invokestatic 207	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	([B)Z
    //   379: ifeq +112 -> 491
    //   382: new 209	com/tencent/mm/plugin/gif/h
    //   385: dup
    //   386: aload 9
    //   388: aload_1
    //   389: invokevirtual 65	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   392: invokespecial 212	com/tencent/mm/plugin/gif/h:<init>	([BLjava/lang/String;)V
    //   395: checkcast 160	android/graphics/drawable/Drawable
    //   398: astore 7
    //   400: ldc 169
    //   402: invokestatic 175	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   405: checkcast 169	com/tencent/mm/plugin/emoji/c/d
    //   408: invokeinterface 179 1 0
    //   413: invokeinterface 215 1 0
    //   418: ifne +318 -> 736
    //   421: aload_0
    //   422: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   425: ldc 217
    //   427: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload_1
    //   431: invokevirtual 202	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   434: getstatic 226	com/tencent/mm/emoji/b/e:mgl	Lcom/tencent/mm/emoji/b/e;
    //   437: astore 8
    //   439: aload_1
    //   440: iconst_1
    //   441: aconst_null
    //   442: invokestatic 229	com/tencent/mm/emoji/b/e:a	(Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/b/d/h$a;)Lcom/tencent/mm/emoji/b/d/e;
    //   445: pop
    //   446: aload 7
    //   448: instanceof 151
    //   451: ifeq +61 -> 512
    //   454: aload 7
    //   456: checkcast 151	com/tencent/mm/plugin/gif/d
    //   459: getfield 233	com/tencent/mm/plugin/gif/d:JgK	[I
    //   462: iconst_0
    //   463: iaload
    //   464: istore 4
    //   466: iload 4
    //   468: istore_3
    //   469: iload 4
    //   471: istore 5
    //   473: aload 7
    //   475: checkcast 151	com/tencent/mm/plugin/gif/d
    //   478: getfield 233	com/tencent/mm/plugin/gif/d:JgK	[I
    //   481: iconst_1
    //   482: iaload
    //   483: istore 6
    //   485: iload 6
    //   487: istore_3
    //   488: goto -360 -> 128
    //   491: new 151	com/tencent/mm/plugin/gif/d
    //   494: dup
    //   495: aload 9
    //   497: aload_1
    //   498: invokevirtual 65	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   501: invokespecial 234	com/tencent/mm/plugin/gif/d:<init>	([BLjava/lang/String;)V
    //   504: checkcast 160	android/graphics/drawable/Drawable
    //   507: astore 7
    //   509: goto -63 -> 446
    //   512: aload 7
    //   514: checkcast 209	com/tencent/mm/plugin/gif/h
    //   517: getfield 235	com/tencent/mm/plugin/gif/h:JgK	[I
    //   520: iconst_1
    //   521: iaload
    //   522: istore 4
    //   524: iload 4
    //   526: istore_3
    //   527: iload 4
    //   529: istore 5
    //   531: aload 7
    //   533: checkcast 209	com/tencent/mm/plugin/gif/h
    //   536: getfield 235	com/tencent/mm/plugin/gif/h:JgK	[I
    //   539: iconst_2
    //   540: iaload
    //   541: istore 6
    //   543: iload 6
    //   545: istore_3
    //   546: goto -418 -> 128
    //   549: astore 8
    //   551: aconst_null
    //   552: astore 7
    //   554: iconst_0
    //   555: istore 4
    //   557: aload 8
    //   559: invokevirtual 239	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   562: bipush 103
    //   564: if_icmpne +167 -> 731
    //   567: aload 9
    //   569: invokestatic 245	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([B)Landroid/graphics/Bitmap;
    //   572: astore 8
    //   574: aload 8
    //   576: ifnonnull +23 -> 599
    //   579: aload_0
    //   580: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   583: ldc 247
    //   585: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload_1
    //   589: invokevirtual 202	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   592: ldc 47
    //   594: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aconst_null
    //   598: areturn
    //   599: aload 8
    //   601: sipush 320
    //   604: invokevirtual 252	android/graphics/Bitmap:setDensity	(I)V
    //   607: new 254	android/graphics/drawable/BitmapDrawable
    //   610: dup
    //   611: invokestatic 110	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   614: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   617: aload 8
    //   619: invokespecial 257	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   622: checkcast 160	android/graphics/drawable/Drawable
    //   625: astore 7
    //   627: aload 8
    //   629: invokevirtual 260	android/graphics/Bitmap:getWidth	()I
    //   632: istore 4
    //   634: aload 8
    //   636: invokevirtual 263	android/graphics/Bitmap:getHeight	()I
    //   639: istore_3
    //   640: goto -512 -> 128
    //   643: astore 8
    //   645: aconst_null
    //   646: astore 7
    //   648: iconst_0
    //   649: istore 4
    //   651: aload_0
    //   652: getfield 39	com/tencent/mm/emoji/b/b/a:TAG	Ljava/lang/String;
    //   655: aload 8
    //   657: checkcast 265	java/lang/Throwable
    //   660: ldc_w 266
    //   663: iconst_0
    //   664: anewarray 4	java/lang/Object
    //   667: invokestatic 270	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   670: iconst_0
    //   671: istore_3
    //   672: goto -544 -> 128
    //   675: aload_1
    //   676: invokevirtual 202	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   679: goto -530 -> 149
    //   682: astore 8
    //   684: iconst_0
    //   685: istore 4
    //   687: goto -36 -> 651
    //   690: astore 8
    //   692: iconst_0
    //   693: istore 4
    //   695: goto -44 -> 651
    //   698: astore 8
    //   700: iload_3
    //   701: istore 4
    //   703: goto -52 -> 651
    //   706: astore 8
    //   708: iconst_0
    //   709: istore 4
    //   711: goto -154 -> 557
    //   714: astore 8
    //   716: iconst_0
    //   717: istore 4
    //   719: goto -162 -> 557
    //   722: astore 8
    //   724: iload 5
    //   726: istore 4
    //   728: goto -171 -> 557
    //   731: iconst_0
    //   732: istore_3
    //   733: goto -605 -> 128
    //   736: goto -290 -> 446
    //   739: aconst_null
    //   740: astore 7
    //   742: iconst_0
    //   743: istore_3
    //   744: iconst_0
    //   745: istore 4
    //   747: goto -619 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	a
    //   0	750	1	paramEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    //   0	750	2	paramm	kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.ah>
    //   96	648	3	i	int
    //   126	620	4	j	int
    //   471	254	5	k	int
    //   483	61	6	m	int
    //   25	716	7	localObject	Object
    //   437	1	8	locale	com.tencent.mm.emoji.b.e
    //   549	9	8	localMMGIFException1	com.tencent.mm.plugin.gif.MMGIFException
    //   572	63	8	localBitmap	android.graphics.Bitmap
    //   643	13	8	localIOException1	java.io.IOException
    //   682	1	8	localIOException2	java.io.IOException
    //   690	1	8	localIOException3	java.io.IOException
    //   698	1	8	localIOException4	java.io.IOException
    //   706	1	8	localMMGIFException2	com.tencent.mm.plugin.gif.MMGIFException
    //   714	1	8	localMMGIFException3	com.tencent.mm.plugin.gif.MMGIFException
    //   722	1	8	localMMGIFException4	com.tencent.mm.plugin.gif.MMGIFException
    //   337	231	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   374	400	549	com/tencent/mm/plugin/gif/MMGIFException
    //   491	509	549	com/tencent/mm/plugin/gif/MMGIFException
    //   374	400	643	java/io/IOException
    //   491	509	643	java/io/IOException
    //   400	446	682	java/io/IOException
    //   446	466	690	java/io/IOException
    //   512	524	690	java/io/IOException
    //   473	485	698	java/io/IOException
    //   531	543	698	java/io/IOException
    //   400	446	706	com/tencent/mm/plugin/gif/MMGIFException
    //   446	466	714	com/tencent/mm/plugin/gif/MMGIFException
    //   512	524	714	com/tencent/mm/plugin/gif/MMGIFException
    //   473	485	722	com/tencent/mm/plugin/gif/MMGIFException
    //   531	543	722	com/tencent/mm/plugin/gif/MMGIFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.a
 * JD-Core Version:    0.7.0.1
 */