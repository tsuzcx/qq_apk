package com.tencent.mm.emoji.loader.b;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";
  
  /* Error */
  public final android.graphics.drawable.Drawable a(com.tencent.mm.storage.emotion.EmojiInfo paramEmojiInfo, kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.x> paramm)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 44
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 51
    //   11: invokestatic 57	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 62	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   18: invokestatic 68	com/tencent/mm/plugin/emoji/i/b:avc	(Ljava/lang/String;)Z
    //   21: ifeq +202 -> 223
    //   24: aload_1
    //   25: invokevirtual 71	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   28: astore 7
    //   30: aload 7
    //   32: ldc 73
    //   34: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   37: aload 7
    //   39: checkcast 78	java/lang/CharSequence
    //   42: iconst_1
    //   43: anewarray 80	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 82
    //   50: aastore
    //   51: invokestatic 87	kotlin/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   54: iconst_0
    //   55: invokeinterface 93 2 0
    //   60: checkcast 80	java/lang/String
    //   63: astore 7
    //   65: aload_0
    //   66: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   69: ldc 95
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload 7
    //   79: aastore
    //   80: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   86: astore 8
    //   88: aload 8
    //   90: ldc 109
    //   92: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   95: aload 8
    //   97: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   100: aload 7
    //   102: ldc 117
    //   104: invokestatic 120	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   107: invokevirtual 126	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   110: istore_3
    //   111: iload_3
    //   112: ifeq +737 -> 849
    //   115: aload_1
    //   116: invokevirtual 62	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   119: invokestatic 129	com/tencent/mm/plugin/emoji/i/b:avd	(Ljava/lang/String;)Z
    //   122: ifeq +60 -> 182
    //   125: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   128: astore 7
    //   130: aload 7
    //   132: ldc 109
    //   134: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   137: aload 7
    //   139: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   142: iload_3
    //   143: invokevirtual 133	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   146: astore 7
    //   148: iconst_0
    //   149: istore_3
    //   150: iconst_0
    //   151: istore 4
    //   153: aload 7
    //   155: ifnull +630 -> 785
    //   158: aload_2
    //   159: iload 4
    //   161: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: iload_3
    //   165: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: invokeinterface 145 3 0
    //   173: pop
    //   174: ldc 44
    //   176: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 7
    //   181: areturn
    //   182: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   185: astore 7
    //   187: aload 7
    //   189: ldc 109
    //   191: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   194: new 150	com/tencent/mm/plugin/gif/d
    //   197: dup
    //   198: aload 7
    //   200: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   203: iload_3
    //   204: invokevirtual 154	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   207: invokespecial 157	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   210: checkcast 159	android/graphics/drawable/Drawable
    //   213: astore 7
    //   215: iconst_0
    //   216: istore_3
    //   217: iconst_0
    //   218: istore 4
    //   220: goto -67 -> 153
    //   223: aload_1
    //   224: invokevirtual 163	com/tencent/mm/storage/emotion/EmojiInfo:hBu	()Z
    //   227: ifeq +135 -> 362
    //   230: aload_1
    //   231: invokevirtual 71	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   234: astore 7
    //   236: aload 7
    //   238: ldc 73
    //   240: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   243: aload 7
    //   245: checkcast 78	java/lang/CharSequence
    //   248: iconst_1
    //   249: anewarray 80	java/lang/String
    //   252: dup
    //   253: iconst_0
    //   254: ldc 82
    //   256: aastore
    //   257: invokestatic 87	kotlin/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   260: iconst_0
    //   261: invokeinterface 93 2 0
    //   266: checkcast 80	java/lang/String
    //   269: astore 7
    //   271: aload_0
    //   272: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   275: ldc 95
    //   277: iconst_1
    //   278: anewarray 4	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: aload 7
    //   285: aastore
    //   286: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   292: astore 8
    //   294: aload 8
    //   296: ldc 109
    //   298: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   301: aload 8
    //   303: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   306: aload 7
    //   308: ldc 117
    //   310: invokestatic 120	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   313: invokevirtual 126	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   316: istore_3
    //   317: iload_3
    //   318: ifeq +531 -> 849
    //   321: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   324: astore 7
    //   326: aload 7
    //   328: ldc 109
    //   330: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   333: new 150	com/tencent/mm/plugin/gif/d
    //   336: dup
    //   337: aload 7
    //   339: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   342: iload_3
    //   343: invokevirtual 154	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   346: invokespecial 157	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   349: checkcast 159	android/graphics/drawable/Drawable
    //   352: astore 7
    //   354: iconst_0
    //   355: istore_3
    //   356: iconst_0
    //   357: istore 4
    //   359: goto -206 -> 153
    //   362: aload_1
    //   363: invokevirtual 166	com/tencent/mm/storage/emotion/EmojiInfo:hBp	()Z
    //   366: ifne +10 -> 376
    //   369: ldc 44
    //   371: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aconst_null
    //   375: areturn
    //   376: ldc 168
    //   378: invokestatic 174	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   381: astore 7
    //   383: aload 7
    //   385: ldc 176
    //   387: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   390: aload 7
    //   392: checkcast 168	com/tencent/mm/plugin/emoji/b/d
    //   395: invokeinterface 180 1 0
    //   400: aload_1
    //   401: invokeinterface 185 2 0
    //   406: astore 9
    //   408: aload 9
    //   410: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   413: ifeq +40 -> 453
    //   416: aload_0
    //   417: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   420: new 193	java/lang/StringBuilder
    //   423: dup
    //   424: ldc 195
    //   426: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: aload_1
    //   430: invokevirtual 62	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   433: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_1
    //   443: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:hBq	()V
    //   446: ldc 44
    //   448: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aconst_null
    //   452: areturn
    //   453: aload 9
    //   455: invokestatic 216	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	([B)Z
    //   458: ifeq +130 -> 588
    //   461: new 218	com/tencent/mm/plugin/gif/h
    //   464: dup
    //   465: aload 9
    //   467: aload_1
    //   468: invokevirtual 62	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   471: invokespecial 221	com/tencent/mm/plugin/gif/h:<init>	([BLjava/lang/String;)V
    //   474: checkcast 159	android/graphics/drawable/Drawable
    //   477: astore 7
    //   479: ldc 168
    //   481: invokestatic 174	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   484: astore 8
    //   486: aload 8
    //   488: ldc 176
    //   490: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   493: aload 8
    //   495: checkcast 168	com/tencent/mm/plugin/emoji/b/d
    //   498: invokeinterface 180 1 0
    //   503: astore 8
    //   505: aload 8
    //   507: ldc 223
    //   509: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   512: aload 8
    //   514: invokeinterface 226 1 0
    //   519: ifne +327 -> 846
    //   522: aload_0
    //   523: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   526: ldc 228
    //   528: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload_1
    //   532: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:hBq	()V
    //   535: getstatic 237	com/tencent/mm/emoji/loader/e:jGI	Lcom/tencent/mm/emoji/loader/e;
    //   538: astore 8
    //   540: aload_1
    //   541: iconst_1
    //   542: aconst_null
    //   543: invokestatic 240	com/tencent/mm/emoji/loader/e:a	(Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/loader/d/i$a;)Lcom/tencent/mm/emoji/loader/d/e;
    //   546: pop
    //   547: aload 7
    //   549: instanceof 150
    //   552: ifeq +57 -> 609
    //   555: aload 7
    //   557: checkcast 150	com/tencent/mm/plugin/gif/d
    //   560: invokevirtual 244	com/tencent/mm/plugin/gif/d:eAW	()I
    //   563: istore 4
    //   565: iload 4
    //   567: istore_3
    //   568: iload 4
    //   570: istore 5
    //   572: aload 7
    //   574: checkcast 150	com/tencent/mm/plugin/gif/d
    //   577: invokevirtual 247	com/tencent/mm/plugin/gif/d:eAX	()I
    //   580: istore 6
    //   582: iload 6
    //   584: istore_3
    //   585: goto -432 -> 153
    //   588: new 150	com/tencent/mm/plugin/gif/d
    //   591: dup
    //   592: aload 9
    //   594: aload_1
    //   595: invokevirtual 62	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   598: invokespecial 248	com/tencent/mm/plugin/gif/d:<init>	([BLjava/lang/String;)V
    //   601: checkcast 159	android/graphics/drawable/Drawable
    //   604: astore 7
    //   606: goto -59 -> 547
    //   609: aload 7
    //   611: checkcast 218	com/tencent/mm/plugin/gif/h
    //   614: invokevirtual 249	com/tencent/mm/plugin/gif/h:eAW	()I
    //   617: istore 4
    //   619: iload 4
    //   621: istore_3
    //   622: iload 4
    //   624: istore 5
    //   626: aload 7
    //   628: checkcast 218	com/tencent/mm/plugin/gif/h
    //   631: invokevirtual 250	com/tencent/mm/plugin/gif/h:eAX	()I
    //   634: istore 6
    //   636: iload 6
    //   638: istore_3
    //   639: goto -486 -> 153
    //   642: astore 8
    //   644: aconst_null
    //   645: astore 7
    //   647: iconst_0
    //   648: istore 4
    //   650: aload 8
    //   652: invokevirtual 253	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   655: bipush 103
    //   657: if_icmpne +184 -> 841
    //   660: aload 9
    //   662: invokestatic 259	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([B)Landroid/graphics/Bitmap;
    //   665: astore 8
    //   667: aload 8
    //   669: ifnonnull +24 -> 693
    //   672: aload_0
    //   673: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   676: ldc_w 261
    //   679: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload_1
    //   683: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:hBq	()V
    //   686: ldc 44
    //   688: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   691: aconst_null
    //   692: areturn
    //   693: aload 8
    //   695: sipush 320
    //   698: invokevirtual 266	android/graphics/Bitmap:setDensity	(I)V
    //   701: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   704: astore 7
    //   706: aload 7
    //   708: ldc 109
    //   710: invokestatic 76	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   713: new 268	android/graphics/drawable/BitmapDrawable
    //   716: dup
    //   717: aload 7
    //   719: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   722: aload 8
    //   724: invokespecial 271	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   727: checkcast 159	android/graphics/drawable/Drawable
    //   730: astore 7
    //   732: aload 8
    //   734: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   737: istore 4
    //   739: aload 8
    //   741: invokevirtual 277	android/graphics/Bitmap:getHeight	()I
    //   744: istore_3
    //   745: goto -592 -> 153
    //   748: astore 9
    //   750: iconst_0
    //   751: istore 4
    //   753: aload 8
    //   755: astore 7
    //   757: aload 9
    //   759: astore 8
    //   761: aload_0
    //   762: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   765: aload 8
    //   767: checkcast 279	java/lang/Throwable
    //   770: ldc_w 280
    //   773: iconst_0
    //   774: anewarray 4	java/lang/Object
    //   777: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   780: iconst_0
    //   781: istore_3
    //   782: goto -629 -> 153
    //   785: aload_1
    //   786: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:hBq	()V
    //   789: goto -615 -> 174
    //   792: astore 8
    //   794: iconst_0
    //   795: istore 4
    //   797: goto -36 -> 761
    //   800: astore 8
    //   802: iconst_0
    //   803: istore 4
    //   805: goto -44 -> 761
    //   808: astore 8
    //   810: iload_3
    //   811: istore 4
    //   813: goto -52 -> 761
    //   816: astore 8
    //   818: iconst_0
    //   819: istore 4
    //   821: goto -171 -> 650
    //   824: astore 8
    //   826: iconst_0
    //   827: istore 4
    //   829: goto -179 -> 650
    //   832: astore 8
    //   834: iload 5
    //   836: istore 4
    //   838: goto -188 -> 650
    //   841: iconst_0
    //   842: istore_3
    //   843: goto -690 -> 153
    //   846: goto -299 -> 547
    //   849: aconst_null
    //   850: astore 7
    //   852: iconst_0
    //   853: istore_3
    //   854: iconst_0
    //   855: istore 4
    //   857: goto -704 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	this	a
    //   0	860	1	paramEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    //   0	860	2	paramm	kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.x>
    //   110	744	3	i	int
    //   151	705	4	j	int
    //   570	265	5	k	int
    //   580	57	6	m	int
    //   28	823	7	localObject1	Object
    //   1	538	8	localObject2	Object
    //   642	9	8	localMMGIFException1	com.tencent.mm.plugin.gif.MMGIFException
    //   665	101	8	localObject3	Object
    //   792	1	8	localIOException1	java.io.IOException
    //   800	1	8	localIOException2	java.io.IOException
    //   808	1	8	localIOException3	java.io.IOException
    //   816	1	8	localMMGIFException2	com.tencent.mm.plugin.gif.MMGIFException
    //   824	1	8	localMMGIFException3	com.tencent.mm.plugin.gif.MMGIFException
    //   832	1	8	localMMGIFException4	com.tencent.mm.plugin.gif.MMGIFException
    //   406	255	9	arrayOfByte	byte[]
    //   748	10	9	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   453	479	642	com/tencent/mm/plugin/gif/MMGIFException
    //   588	606	642	com/tencent/mm/plugin/gif/MMGIFException
    //   453	479	748	java/io/IOException
    //   588	606	748	java/io/IOException
    //   479	547	792	java/io/IOException
    //   547	565	800	java/io/IOException
    //   609	619	800	java/io/IOException
    //   572	582	808	java/io/IOException
    //   626	636	808	java/io/IOException
    //   479	547	816	com/tencent/mm/plugin/gif/MMGIFException
    //   547	565	824	com/tencent/mm/plugin/gif/MMGIFException
    //   609	619	824	com/tencent/mm/plugin/gif/MMGIFException
    //   572	582	832	com/tencent/mm/plugin/gif/MMGIFException
    //   626	636	832	com/tencent/mm/plugin/gif/MMGIFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b.a
 * JD-Core Version:    0.7.0.1
 */