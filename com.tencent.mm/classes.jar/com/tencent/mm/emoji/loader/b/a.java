package com.tencent.mm.emoji.loader.b;

import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";
  
  /* Error */
  public final android.graphics.drawable.Drawable a(com.tencent.mm.storage.emotion.EmojiInfo paramEmojiInfo, d.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, d.y> paramm)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 44
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 51
    //   11: invokestatic 57	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   18: getstatic 69	com/tencent/mm/storage/emotion/EmojiGroupInfo:LBO	I
    //   21: if_icmpeq +23 -> 44
    //   24: aload_1
    //   25: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   28: getstatic 72	com/tencent/mm/storage/emotion/EmojiInfo:LBV	I
    //   31: if_icmpeq +13 -> 44
    //   34: aload_1
    //   35: invokevirtual 63	com/tencent/mm/storage/emotion/EmojiInfo:getGroup	()I
    //   38: getstatic 75	com/tencent/mm/storage/emotion/EmojiInfo:LBU	I
    //   41: if_icmpne +151 -> 192
    //   44: aload_1
    //   45: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: ldc 80
    //   54: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
    //   100: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: invokestatic 114	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   106: astore 8
    //   108: aload 8
    //   110: ldc 116
    //   112: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   115: aload 8
    //   117: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   120: aload 7
    //   122: ldc 124
    //   124: invokestatic 127	com/tencent/mm/sdk/platformtools/aj:getPackageName	()Ljava/lang/String;
    //   127: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   130: istore_3
    //   131: invokestatic 114	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   134: astore 7
    //   136: aload 7
    //   138: ldc 116
    //   140: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
    //   161: ifnull +589 -> 750
    //   164: aload_2
    //   165: ifnull +19 -> 184
    //   168: aload_2
    //   169: iload 4
    //   171: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: iload_3
    //   175: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: invokeinterface 149 3 0
    //   183: pop
    //   184: ldc 44
    //   186: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 7
    //   191: areturn
    //   192: aload_1
    //   193: invokevirtual 156	com/tencent/mm/storage/emotion/EmojiInfo:fZQ	()Z
    //   196: ifeq +131 -> 327
    //   199: aload_1
    //   200: invokevirtual 78	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   203: astore 7
    //   205: aload 7
    //   207: ldc 80
    //   209: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   212: aload 7
    //   214: checkcast 85	java/lang/CharSequence
    //   217: iconst_1
    //   218: anewarray 87	java/lang/String
    //   221: dup
    //   222: iconst_0
    //   223: ldc 89
    //   225: aastore
    //   226: invokestatic 94	d/n/n:a	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   229: iconst_0
    //   230: invokeinterface 100 2 0
    //   235: checkcast 87	java/lang/String
    //   238: astore 7
    //   240: aload_0
    //   241: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   244: ldc 102
    //   246: iconst_1
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload 7
    //   254: aastore
    //   255: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: invokestatic 114	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   261: astore 8
    //   263: aload 8
    //   265: ldc 116
    //   267: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   270: aload 8
    //   272: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   275: aload 7
    //   277: ldc 124
    //   279: invokestatic 127	com/tencent/mm/sdk/platformtools/aj:getPackageName	()Ljava/lang/String;
    //   282: invokevirtual 133	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   285: istore_3
    //   286: invokestatic 114	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   289: astore 7
    //   291: aload 7
    //   293: ldc 116
    //   295: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   298: new 158	com/tencent/mm/plugin/gif/d
    //   301: dup
    //   302: aload 7
    //   304: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   307: iload_3
    //   308: invokevirtual 162	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   311: invokespecial 165	com/tencent/mm/plugin/gif/d:<init>	(Ljava/io/InputStream;)V
    //   314: checkcast 167	android/graphics/drawable/Drawable
    //   317: astore 7
    //   319: iconst_0
    //   320: istore_3
    //   321: iconst_0
    //   322: istore 4
    //   324: goto -165 -> 159
    //   327: aload_1
    //   328: invokevirtual 170	com/tencent/mm/storage/emotion/EmojiInfo:fZM	()Z
    //   331: ifne +10 -> 341
    //   334: ldc 44
    //   336: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: ldc 172
    //   343: invokestatic 178	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   346: astore 7
    //   348: aload 7
    //   350: ldc 180
    //   352: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   355: aload 7
    //   357: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   360: invokeinterface 184 1 0
    //   365: aload_1
    //   366: invokeinterface 189 2 0
    //   371: astore 9
    //   373: aload 9
    //   375: invokestatic 195	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   378: ifeq +40 -> 418
    //   381: aload_0
    //   382: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   385: new 197	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 199
    //   391: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_1
    //   395: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:JS	()Ljava/lang/String;
    //   398: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload_1
    //   408: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fZN	()V
    //   411: ldc 44
    //   413: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aconst_null
    //   417: areturn
    //   418: aload 9
    //   420: invokestatic 223	com/tencent/mm/sdk/platformtools/t:cp	([B)Z
    //   423: ifeq +130 -> 553
    //   426: new 225	com/tencent/mm/plugin/gif/h
    //   429: dup
    //   430: aload 9
    //   432: aload_1
    //   433: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:JS	()Ljava/lang/String;
    //   436: invokespecial 228	com/tencent/mm/plugin/gif/h:<init>	([BLjava/lang/String;)V
    //   439: checkcast 167	android/graphics/drawable/Drawable
    //   442: astore 7
    //   444: ldc 172
    //   446: invokestatic 178	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   449: astore 8
    //   451: aload 8
    //   453: ldc 180
    //   455: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   458: aload 8
    //   460: checkcast 172	com/tencent/mm/plugin/emoji/b/d
    //   463: invokeinterface 184 1 0
    //   468: astore 8
    //   470: aload 8
    //   472: ldc 230
    //   474: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   477: aload 8
    //   479: invokeinterface 233 1 0
    //   484: ifne +327 -> 811
    //   487: aload_0
    //   488: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   491: ldc 235
    //   493: invokestatic 238	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload_1
    //   497: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fZN	()V
    //   500: getstatic 244	com/tencent/mm/emoji/loader/e:fLn	Lcom/tencent/mm/emoji/loader/e;
    //   503: astore 8
    //   505: aload_1
    //   506: iconst_1
    //   507: aconst_null
    //   508: invokestatic 247	com/tencent/mm/emoji/loader/e:a	(Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/loader/d/i$a;)Lcom/tencent/mm/emoji/loader/d/e;
    //   511: pop
    //   512: aload 7
    //   514: instanceof 158
    //   517: ifeq +57 -> 574
    //   520: aload 7
    //   522: checkcast 158	com/tencent/mm/plugin/gif/d
    //   525: invokevirtual 250	com/tencent/mm/plugin/gif/d:cEI	()I
    //   528: istore 4
    //   530: iload 4
    //   532: istore_3
    //   533: iload 4
    //   535: istore 5
    //   537: aload 7
    //   539: checkcast 158	com/tencent/mm/plugin/gif/d
    //   542: invokevirtual 253	com/tencent/mm/plugin/gif/d:cEJ	()I
    //   545: istore 6
    //   547: iload 6
    //   549: istore_3
    //   550: goto -391 -> 159
    //   553: new 158	com/tencent/mm/plugin/gif/d
    //   556: dup
    //   557: aload 9
    //   559: aload_1
    //   560: invokevirtual 205	com/tencent/mm/storage/emotion/EmojiInfo:JS	()Ljava/lang/String;
    //   563: invokespecial 254	com/tencent/mm/plugin/gif/d:<init>	([BLjava/lang/String;)V
    //   566: checkcast 167	android/graphics/drawable/Drawable
    //   569: astore 7
    //   571: goto -59 -> 512
    //   574: aload 7
    //   576: checkcast 225	com/tencent/mm/plugin/gif/h
    //   579: invokevirtual 255	com/tencent/mm/plugin/gif/h:cEI	()I
    //   582: istore 4
    //   584: iload 4
    //   586: istore_3
    //   587: iload 4
    //   589: istore 5
    //   591: aload 7
    //   593: checkcast 225	com/tencent/mm/plugin/gif/h
    //   596: invokevirtual 256	com/tencent/mm/plugin/gif/h:cEJ	()I
    //   599: istore 6
    //   601: iload 6
    //   603: istore_3
    //   604: goto -445 -> 159
    //   607: astore 8
    //   609: aconst_null
    //   610: astore 7
    //   612: iconst_0
    //   613: istore 4
    //   615: aload 8
    //   617: invokevirtual 259	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   620: bipush 103
    //   622: if_icmpne +184 -> 806
    //   625: aload 9
    //   627: invokestatic 265	com/tencent/mm/sdk/platformtools/f:cl	([B)Landroid/graphics/Bitmap;
    //   630: astore 8
    //   632: aload 8
    //   634: ifnonnull +24 -> 658
    //   637: aload_0
    //   638: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   641: ldc_w 267
    //   644: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_1
    //   648: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fZN	()V
    //   651: ldc 44
    //   653: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   656: aconst_null
    //   657: areturn
    //   658: aload 8
    //   660: sipush 320
    //   663: invokevirtual 272	android/graphics/Bitmap:setDensity	(I)V
    //   666: invokestatic 114	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   669: astore 7
    //   671: aload 7
    //   673: ldc 116
    //   675: invokestatic 83	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   678: new 274	android/graphics/drawable/BitmapDrawable
    //   681: dup
    //   682: aload 7
    //   684: invokevirtual 122	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   687: aload 8
    //   689: invokespecial 277	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   692: checkcast 167	android/graphics/drawable/Drawable
    //   695: astore 7
    //   697: aload 8
    //   699: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   702: istore 4
    //   704: aload 8
    //   706: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   709: istore_3
    //   710: goto -551 -> 159
    //   713: astore 9
    //   715: iconst_0
    //   716: istore 4
    //   718: aload 8
    //   720: astore 7
    //   722: aload 9
    //   724: astore 8
    //   726: aload_0
    //   727: getfield 36	com/tencent/mm/emoji/loader/b/a:TAG	Ljava/lang/String;
    //   730: aload 8
    //   732: checkcast 285	java/lang/Throwable
    //   735: ldc_w 286
    //   738: iconst_0
    //   739: anewarray 4	java/lang/Object
    //   742: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: iconst_0
    //   746: istore_3
    //   747: goto -588 -> 159
    //   750: aload_1
    //   751: invokevirtual 218	com/tencent/mm/storage/emotion/EmojiInfo:fZN	()V
    //   754: goto -570 -> 184
    //   757: astore 8
    //   759: iconst_0
    //   760: istore 4
    //   762: goto -36 -> 726
    //   765: astore 8
    //   767: iconst_0
    //   768: istore 4
    //   770: goto -44 -> 726
    //   773: astore 8
    //   775: iload_3
    //   776: istore 4
    //   778: goto -52 -> 726
    //   781: astore 8
    //   783: iconst_0
    //   784: istore 4
    //   786: goto -171 -> 615
    //   789: astore 8
    //   791: iconst_0
    //   792: istore 4
    //   794: goto -179 -> 615
    //   797: astore 8
    //   799: iload 5
    //   801: istore 4
    //   803: goto -188 -> 615
    //   806: iconst_0
    //   807: istore_3
    //   808: goto -649 -> 159
    //   811: goto -299 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	this	a
    //   0	814	1	paramEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    //   0	814	2	paramm	d.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, d.y>
    //   130	678	3	i	int
    //   157	645	4	j	int
    //   535	265	5	k	int
    //   545	57	6	m	int
    //   48	673	7	localObject1	Object
    //   1	503	8	localObject2	Object
    //   607	9	8	localMMGIFException1	com.tencent.mm.plugin.gif.MMGIFException
    //   630	101	8	localObject3	Object
    //   757	1	8	localIOException1	java.io.IOException
    //   765	1	8	localIOException2	java.io.IOException
    //   773	1	8	localIOException3	java.io.IOException
    //   781	1	8	localMMGIFException2	com.tencent.mm.plugin.gif.MMGIFException
    //   789	1	8	localMMGIFException3	com.tencent.mm.plugin.gif.MMGIFException
    //   797	1	8	localMMGIFException4	com.tencent.mm.plugin.gif.MMGIFException
    //   371	255	9	arrayOfByte	byte[]
    //   713	10	9	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   418	444	607	com/tencent/mm/plugin/gif/MMGIFException
    //   553	571	607	com/tencent/mm/plugin/gif/MMGIFException
    //   418	444	713	java/io/IOException
    //   553	571	713	java/io/IOException
    //   444	512	757	java/io/IOException
    //   512	530	765	java/io/IOException
    //   574	584	765	java/io/IOException
    //   537	547	773	java/io/IOException
    //   591	601	773	java/io/IOException
    //   444	512	781	com/tencent/mm/plugin/gif/MMGIFException
    //   512	530	789	com/tencent/mm/plugin/gif/MMGIFException
    //   574	584	789	com/tencent/mm/plugin/gif/MMGIFException
    //   537	547	797	com/tencent/mm/plugin/gif/MMGIFException
    //   591	601	797	com/tencent/mm/plugin/gif/MMGIFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b.a
 * JD-Core Version:    0.7.0.1
 */