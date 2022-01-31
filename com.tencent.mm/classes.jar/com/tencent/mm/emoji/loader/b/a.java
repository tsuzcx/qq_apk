package com.tencent.mm.emoji.loader.b;

import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";
  
  /* Error */
  public final android.graphics.drawable.Drawable a(com.tencent.mm.storage.emotion.EmojiInfo paramEmojiInfo, a.f.a.m<? super java.lang.Integer, ? super java.lang.Integer, a.y> paramm)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 51
    //   8: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   15: getstatic 69	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPe	I
    //   18: if_icmpeq +23 -> 41
    //   21: aload_1
    //   22: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   25: getstatic 72	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   28: if_icmpeq +13 -> 41
    //   31: aload_1
    //   32: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   35: getstatic 75	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   38: if_icmpne +151 -> 189
    //   41: aload_1
    //   42: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   45: astore 7
    //   47: aload 7
    //   49: ldc 80
    //   51: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   54: aload 7
    //   56: checkcast 85	java/lang/CharSequence
    //   59: iconst_1
    //   60: anewarray 87	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: ldc 89
    //   67: aastore
    //   68: invokestatic 94	a/l/m:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   71: iconst_0
    //   72: invokeinterface 100 2 0
    //   77: checkcast 87	java/lang/String
    //   80: astore 7
    //   82: aload_0
    //   83: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   86: ldc 102
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload 7
    //   96: aastore
    //   97: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: invokestatic 114	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   103: astore 8
    //   105: aload 8
    //   107: ldc 116
    //   109: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   112: aload 8
    //   114: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   117: aload 7
    //   119: ldc 124
    //   121: invokestatic 127	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   124: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   127: istore_3
    //   128: invokestatic 114	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   131: astore 7
    //   133: aload 7
    //   135: ldc 116
    //   137: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   140: aload 7
    //   142: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   145: iload_3
    //   146: invokevirtual 137	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   149: astore 7
    //   151: iconst_0
    //   152: istore_3
    //   153: iconst_0
    //   154: istore 4
    //   156: aload 7
    //   158: ifnull +576 -> 734
    //   161: aload_2
    //   162: ifnull +19 -> 181
    //   165: aload_2
    //   166: iload 4
    //   168: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: iload_3
    //   172: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: invokeinterface 149 3 0
    //   180: pop
    //   181: ldc 44
    //   183: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload 7
    //   188: areturn
    //   189: aload_1
    //   190: invokevirtual 156	com/tencent/mm/storage/emotion/EmojiInfo:dzq	()Z
    //   193: ifeq +131 -> 324
    //   196: aload_1
    //   197: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   200: astore 7
    //   202: aload 7
    //   204: ldc 80
    //   206: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   209: aload 7
    //   211: checkcast 85	java/lang/CharSequence
    //   214: iconst_1
    //   215: anewarray 87	java/lang/String
    //   218: dup
    //   219: iconst_0
    //   220: ldc 89
    //   222: aastore
    //   223: invokestatic 94	a/l/m:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   226: iconst_0
    //   227: invokeinterface 100 2 0
    //   232: checkcast 87	java/lang/String
    //   235: astore 7
    //   237: aload_0
    //   238: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   241: ldc 102
    //   243: iconst_1
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload 7
    //   251: aastore
    //   252: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: invokestatic 114	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   258: astore 8
    //   260: aload 8
    //   262: ldc 116
    //   264: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   267: aload 8
    //   269: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   272: aload 7
    //   274: ldc 124
    //   276: invokestatic 127	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   279: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   282: istore_3
    //   283: invokestatic 114	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   286: astore 7
    //   288: aload 7
    //   290: ldc 116
    //   292: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   295: new 158	com/tencent/mm/plugin/gif/d
    //   298: dup
    //   299: aload 7
    //   301: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   304: iload_3
    //   305: invokevirtual 162	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   308: invokespecial 165	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   311: checkcast 167	android/graphics/drawable/Drawable
    //   314: astore 7
    //   316: iconst_0
    //   317: istore_3
    //   318: iconst_0
    //   319: istore 4
    //   321: goto -165 -> 156
    //   324: aload_1
    //   325: invokevirtual 170	com/tencent/mm/storage/emotion/EmojiInfo:dzn	()Z
    //   328: ifne +10 -> 338
    //   331: ldc 44
    //   333: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aconst_null
    //   337: areturn
    //   338: ldc 172
    //   340: invokestatic 178	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   343: astore 7
    //   345: aload 7
    //   347: ldc 180
    //   349: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   352: aload 7
    //   354: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   357: invokeinterface 184 1 0
    //   362: aload_1
    //   363: invokeinterface 190 2 0
    //   368: astore 9
    //   370: aload 9
    //   372: invokestatic 196	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   375: ifeq +40 -> 415
    //   378: aload_0
    //   379: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   382: new 198	java/lang/StringBuilder
    //   385: dup
    //   386: ldc 200
    //   388: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: aload_1
    //   392: invokevirtual 206	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   395: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_1
    //   405: invokevirtual 219	com/tencent/mm/storage/emotion/EmojiInfo:dzo	()V
    //   408: ldc 44
    //   410: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: aconst_null
    //   414: areturn
    //   415: aload 9
    //   417: invokestatic 224	com/tencent/mm/sdk/platformtools/r:bX	([B)Z
    //   420: ifeq +126 -> 546
    //   423: new 226	com/tencent/mm/plugin/gif/h
    //   426: dup
    //   427: aload 9
    //   429: invokespecial 229	com/tencent/mm/plugin/gif/h:<init>	([B)V
    //   432: checkcast 167	android/graphics/drawable/Drawable
    //   435: astore 7
    //   437: ldc 172
    //   439: invokestatic 178	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   442: astore 8
    //   444: aload 8
    //   446: ldc 180
    //   448: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   451: aload 8
    //   453: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   456: invokeinterface 184 1 0
    //   461: astore 8
    //   463: aload 8
    //   465: ldc 231
    //   467: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   470: aload 8
    //   472: invokeinterface 234 1 0
    //   477: ifne +318 -> 795
    //   480: aload_0
    //   481: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   484: ldc 236
    //   486: invokestatic 239	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_1
    //   490: invokevirtual 219	com/tencent/mm/storage/emotion/EmojiInfo:dzo	()V
    //   493: getstatic 245	com/tencent/mm/emoji/loader/a:evk	Lcom/tencent/mm/emoji/loader/a;
    //   496: astore 8
    //   498: aload_1
    //   499: iconst_1
    //   500: aconst_null
    //   501: invokestatic 248	com/tencent/mm/emoji/loader/a:a	(Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/loader/d/h$a;)Lcom/tencent/mm/emoji/loader/d/d;
    //   504: pop
    //   505: aload 7
    //   507: instanceof 158
    //   510: ifeq +53 -> 563
    //   513: aload 7
    //   515: checkcast 158	com/tencent/mm/plugin/gif/d
    //   518: invokevirtual 251	com/tencent/mm/plugin/gif/d:bHL	()I
    //   521: istore 4
    //   523: iload 4
    //   525: istore_3
    //   526: iload 4
    //   528: istore 5
    //   530: aload 7
    //   532: checkcast 158	com/tencent/mm/plugin/gif/d
    //   535: invokevirtual 254	com/tencent/mm/plugin/gif/d:bHM	()I
    //   538: istore 6
    //   540: iload 6
    //   542: istore_3
    //   543: goto -387 -> 156
    //   546: new 158	com/tencent/mm/plugin/gif/d
    //   549: dup
    //   550: aload 9
    //   552: invokespecial 255	com/tencent/mm/plugin/gif/d:<init>	([B)V
    //   555: checkcast 167	android/graphics/drawable/Drawable
    //   558: astore 7
    //   560: goto -55 -> 505
    //   563: aload 7
    //   565: checkcast 226	com/tencent/mm/plugin/gif/h
    //   568: invokevirtual 256	com/tencent/mm/plugin/gif/h:bHL	()I
    //   571: istore 4
    //   573: iload 4
    //   575: istore_3
    //   576: iload 4
    //   578: istore 5
    //   580: aload 7
    //   582: checkcast 226	com/tencent/mm/plugin/gif/h
    //   585: invokevirtual 257	com/tencent/mm/plugin/gif/h:bHM	()I
    //   588: istore 6
    //   590: iload 6
    //   592: istore_3
    //   593: goto -437 -> 156
    //   596: astore 8
    //   598: aconst_null
    //   599: astore 7
    //   601: iconst_0
    //   602: istore 4
    //   604: aload 8
    //   606: invokevirtual 260	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   609: bipush 103
    //   611: if_icmpne +179 -> 790
    //   614: aload 9
    //   616: invokestatic 266	com/tencent/mm/sdk/platformtools/d:bT	([B)Landroid/graphics/Bitmap;
    //   619: astore 8
    //   621: aload 8
    //   623: ifnonnull +24 -> 647
    //   626: aload_0
    //   627: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   630: ldc_w 268
    //   633: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload_1
    //   637: invokevirtual 219	com/tencent/mm/storage/emotion/EmojiInfo:dzo	()V
    //   640: ldc 44
    //   642: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   645: aconst_null
    //   646: areturn
    //   647: aload 8
    //   649: sipush 320
    //   652: invokevirtual 273	android/graphics/Bitmap:setDensity	(I)V
    //   655: invokestatic 114	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   658: astore 7
    //   660: aload 7
    //   662: ldc 116
    //   664: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   667: new 275	android/graphics/drawable/BitmapDrawable
    //   670: dup
    //   671: aload 7
    //   673: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   676: aload 8
    //   678: invokespecial 278	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   681: checkcast 167	android/graphics/drawable/Drawable
    //   684: astore 7
    //   686: aload 8
    //   688: invokevirtual 281	android/graphics/Bitmap:getWidth	()I
    //   691: istore 4
    //   693: aload 8
    //   695: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   698: istore_3
    //   699: goto -543 -> 156
    //   702: astore 8
    //   704: aconst_null
    //   705: astore 7
    //   707: iconst_0
    //   708: istore 4
    //   710: aload_0
    //   711: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   714: aload 8
    //   716: checkcast 286	java/lang/Throwable
    //   719: ldc_w 287
    //   722: iconst_0
    //   723: anewarray 4	java/lang/Object
    //   726: invokestatic 291	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   729: iconst_0
    //   730: istore_3
    //   731: goto -575 -> 156
    //   734: aload_1
    //   735: invokevirtual 219	com/tencent/mm/storage/emotion/EmojiInfo:dzo	()V
    //   738: goto -557 -> 181
    //   741: astore 8
    //   743: iconst_0
    //   744: istore 4
    //   746: goto -36 -> 710
    //   749: astore 8
    //   751: iconst_0
    //   752: istore 4
    //   754: goto -44 -> 710
    //   757: astore 8
    //   759: iload_3
    //   760: istore 4
    //   762: goto -52 -> 710
    //   765: astore 8
    //   767: iconst_0
    //   768: istore 4
    //   770: goto -166 -> 604
    //   773: astore 8
    //   775: iconst_0
    //   776: istore 4
    //   778: goto -174 -> 604
    //   781: astore 8
    //   783: iload 5
    //   785: istore 4
    //   787: goto -183 -> 604
    //   790: iconst_0
    //   791: istore_3
    //   792: goto -636 -> 156
    //   795: goto -290 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	a
    //   0	798	1	paramEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    //   0	798	2	paramm	a.f.a.m<? super java.lang.Integer, ? super java.lang.Integer, a.y>
    //   127	665	3	i	int
    //   154	632	4	j	int
    //   528	256	5	k	int
    //   538	53	6	m	int
    //   45	661	7	localObject1	Object
    //   103	394	8	localObject2	Object
    //   596	9	8	localMMGIFException1	com.tencent.mm.plugin.gif.MMGIFException
    //   619	75	8	localBitmap	android.graphics.Bitmap
    //   702	13	8	localIOException1	java.io.IOException
    //   741	1	8	localIOException2	java.io.IOException
    //   749	1	8	localIOException3	java.io.IOException
    //   757	1	8	localIOException4	java.io.IOException
    //   765	1	8	localMMGIFException2	com.tencent.mm.plugin.gif.MMGIFException
    //   773	1	8	localMMGIFException3	com.tencent.mm.plugin.gif.MMGIFException
    //   781	1	8	localMMGIFException4	com.tencent.mm.plugin.gif.MMGIFException
    //   368	247	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   415	437	596	com/tencent/mm/plugin/gif/MMGIFException
    //   546	560	596	com/tencent/mm/plugin/gif/MMGIFException
    //   415	437	702	java/io/IOException
    //   546	560	702	java/io/IOException
    //   437	505	741	java/io/IOException
    //   505	523	749	java/io/IOException
    //   563	573	749	java/io/IOException
    //   530	540	757	java/io/IOException
    //   580	590	757	java/io/IOException
    //   437	505	765	com/tencent/mm/plugin/gif/MMGIFException
    //   505	523	773	com/tencent/mm/plugin/gif/MMGIFException
    //   563	573	773	com/tencent/mm/plugin/gif/MMGIFException
    //   530	540	781	com/tencent/mm/plugin/gif/MMGIFException
    //   580	590	781	com/tencent/mm/plugin/gif/MMGIFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b.a
 * JD-Core Version:    0.7.0.1
 */