package com.tencent.mm.bi;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  /* Error */
  public static int a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: ldc 12
    //   2: ldc 14
    //   4: invokestatic 20	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 26	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   10: lstore 6
    //   12: new 28	com/tencent/mm/bi/g
    //   15: dup
    //   16: invokespecial 32	com/tencent/mm/bi/g:<init>	()V
    //   19: astore 10
    //   21: ldc 34
    //   23: invokestatic 40	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   26: checkcast 34	com/tencent/mm/plugin/zero/b/a
    //   29: invokeinterface 44 1 0
    //   34: ldc 46
    //   36: iconst_1
    //   37: invokevirtual 52	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   40: iconst_1
    //   41: if_icmpne +433 -> 474
    //   44: iconst_1
    //   45: istore 9
    //   47: getstatic 58	com/tencent/mm/compatible/e/q:dyn	Lcom/tencent/mm/compatible/e/k;
    //   50: getfield 64	com/tencent/mm/compatible/e/k:dxJ	I
    //   53: istore_3
    //   54: iload_3
    //   55: iconst_m1
    //   56: if_icmpeq +430 -> 486
    //   59: iload_3
    //   60: iconst_1
    //   61: if_icmpne +419 -> 480
    //   64: iconst_1
    //   65: istore 8
    //   67: ldc 12
    //   69: ldc 66
    //   71: iconst_3
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: iload 9
    //   79: invokestatic 72	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: iload_3
    //   86: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload 8
    //   94: invokestatic 72	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: aastore
    //   98: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: ldc 82
    //   103: new 84	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 86
    //   109: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 95
    //   118: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 97
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc 102
    //   136: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: invokestatic 26	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   148: lstore 4
    //   150: aload_0
    //   151: invokestatic 113	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   154: ifne +14 -> 168
    //   157: aload_1
    //   158: invokestatic 113	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   161: ifne +7 -> 168
    //   164: aload_2
    //   165: ifnonnull +338 -> 503
    //   168: new 115	java/lang/IllegalArgumentException
    //   171: dup
    //   172: getstatic 121	java/util/Locale:CHINA	Ljava/util/Locale;
    //   175: ldc 123
    //   177: iconst_3
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload_1
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload_2
    //   192: aastore
    //   193: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokespecial 130	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: astore_1
    //   201: ldc 12
    //   203: ldc 132
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload_1
    //   212: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 140	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload_0
    //   220: invokestatic 144	com/tencent/mm/bi/e:op	(Ljava/lang/String;)I
    //   223: i2l
    //   224: lstore 4
    //   226: ldc 82
    //   228: ldc 146
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 10
    //   238: getfield 150	com/tencent/mm/bi/g:isInited	Z
    //   241: invokestatic 72	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   244: aastore
    //   245: invokestatic 140	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 10
    //   250: getfield 150	com/tencent/mm/bi/g:isInited	Z
    //   253: ifne +10 -> 263
    //   256: ldc 82
    //   258: ldc 152
    //   260: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 10
    //   265: lconst_0
    //   266: putfield 158	com/tencent/mm/bi/g:eJg	J
    //   269: aload 10
    //   271: getfield 162	com/tencent/mm/bi/g:eJa	Ljava/util/List;
    //   274: iconst_0
    //   275: invokeinterface 168 2 0
    //   280: checkcast 170	com/tencent/mm/bi/g$a
    //   283: getfield 174	com/tencent/mm/bi/g$a:eIG	Landroid/media/MediaFormat;
    //   286: astore_0
    //   287: aload_0
    //   288: ldc 176
    //   290: invokevirtual 181	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   293: ifne +417 -> 710
    //   296: new 8	com/tencent/mm/bi/f
    //   299: dup
    //   300: ldc 183
    //   302: invokespecial 184	com/tencent/mm/bi/f:<init>	(Ljava/lang/String;)V
    //   305: athrow
    //   306: astore_0
    //   307: iconst_m1
    //   308: istore_3
    //   309: ldc 12
    //   311: ldc 186
    //   313: iconst_1
    //   314: anewarray 4	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload_0
    //   320: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   323: aastore
    //   324: invokestatic 140	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: getstatic 192	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   330: invokevirtual 195	com/tencent/mm/bi/b:ET	()V
    //   333: iload_3
    //   334: ifge +21 -> 355
    //   337: ldc 12
    //   339: ldc 197
    //   341: iconst_1
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: iload_3
    //   348: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aastore
    //   352: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: ldc 12
    //   357: ldc 199
    //   359: invokestatic 20	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: invokestatic 26	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   365: lload 6
    //   367: lsub
    //   368: lstore 4
    //   370: ldc 12
    //   372: ldc 201
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: lload 4
    //   382: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   385: aastore
    //   386: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: new 208	java/util/ArrayList
    //   392: dup
    //   393: invokespecial 209	java/util/ArrayList:<init>	()V
    //   396: astore_0
    //   397: new 211	com/tencent/mars/smc/IDKey
    //   400: dup
    //   401: invokespecial 212	com/tencent/mars/smc/IDKey:<init>	()V
    //   404: astore_1
    //   405: aload_1
    //   406: sipush 354
    //   409: invokevirtual 216	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   412: aload_1
    //   413: sipush 253
    //   416: invokevirtual 219	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   419: aload_1
    //   420: lload 4
    //   422: invokevirtual 223	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   425: new 211	com/tencent/mars/smc/IDKey
    //   428: dup
    //   429: invokespecial 212	com/tencent/mars/smc/IDKey:<init>	()V
    //   432: astore_2
    //   433: aload_2
    //   434: sipush 354
    //   437: invokevirtual 216	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   440: aload_2
    //   441: sipush 254
    //   444: invokevirtual 219	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   447: aload_2
    //   448: lconst_1
    //   449: invokevirtual 223	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   452: aload_0
    //   453: aload_1
    //   454: invokevirtual 227	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   457: pop
    //   458: aload_0
    //   459: aload_2
    //   460: invokevirtual 227	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   463: pop
    //   464: getstatic 233	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   467: aload_0
    //   468: iconst_0
    //   469: invokevirtual 237	com/tencent/mm/plugin/report/service/h:b	(Ljava/util/ArrayList;Z)V
    //   472: iload_3
    //   473: ireturn
    //   474: iconst_0
    //   475: istore 9
    //   477: goto -430 -> 47
    //   480: iconst_0
    //   481: istore 8
    //   483: goto -416 -> 67
    //   486: iload 9
    //   488: ifne +9 -> 497
    //   491: iconst_1
    //   492: istore 8
    //   494: goto -427 -> 67
    //   497: iconst_0
    //   498: istore 8
    //   500: goto -433 -> 67
    //   503: new 239	java/io/File
    //   506: dup
    //   507: aload_0
    //   508: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   511: astore 11
    //   513: new 239	java/io/File
    //   516: dup
    //   517: aload_1
    //   518: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   521: pop
    //   522: aload_0
    //   523: invokestatic 245	com/tencent/mm/modelsfs/FileOp:bK	(Ljava/lang/String;)Z
    //   526: ifeq +21 -> 547
    //   529: aload 11
    //   531: invokevirtual 249	java/io/File:canRead	()Z
    //   534: ifeq +13 -> 547
    //   537: aload 11
    //   539: invokevirtual 252	java/io/File:length	()J
    //   542: lconst_0
    //   543: lcmp
    //   544: ifne +27 -> 571
    //   547: new 115	java/lang/IllegalArgumentException
    //   550: dup
    //   551: getstatic 121	java/util/Locale:CHINA	Ljava/util/Locale;
    //   554: ldc 254
    //   556: iconst_1
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: aload_0
    //   563: aastore
    //   564: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   567: invokespecial 130	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   570: athrow
    //   571: aload 10
    //   573: aload_0
    //   574: putfield 258	com/tencent/mm/bi/g:eJc	Ljava/lang/String;
    //   577: aload 10
    //   579: aload_1
    //   580: putfield 261	com/tencent/mm/bi/g:eJd	Ljava/lang/String;
    //   583: aload 10
    //   585: aload_2
    //   586: putfield 265	com/tencent/mm/bi/g:eJf	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   589: aload 10
    //   591: new 267	android/media/MediaExtractor
    //   594: dup
    //   595: invokespecial 268	android/media/MediaExtractor:<init>	()V
    //   598: putfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   601: aload 10
    //   603: getfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   606: aload_0
    //   607: invokevirtual 275	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   610: aload 10
    //   612: aload 10
    //   614: getfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   617: invokevirtual 278	com/tencent/mm/bi/g:a	(Landroid/media/MediaExtractor;)V
    //   620: aload 10
    //   622: getfield 162	com/tencent/mm/bi/g:eJa	Ljava/util/List;
    //   625: ifnull +16 -> 641
    //   628: aload 10
    //   630: getfield 162	com/tencent/mm/bi/g:eJa	Ljava/util/List;
    //   633: invokeinterface 282 1 0
    //   638: ifne +14 -> 652
    //   641: new 8	com/tencent/mm/bi/f
    //   644: dup
    //   645: ldc_w 284
    //   648: invokespecial 184	com/tencent/mm/bi/f:<init>	(Ljava/lang/String;)V
    //   651: athrow
    //   652: aload 10
    //   654: aload 10
    //   656: invokevirtual 287	com/tencent/mm/bi/g:SU	()I
    //   659: putfield 290	com/tencent/mm/bi/g:eJi	I
    //   662: aload 10
    //   664: aload_0
    //   665: invokestatic 293	com/tencent/mm/bi/g:oq	(Ljava/lang/String;)I
    //   668: putfield 296	com/tencent/mm/bi/g:eJj	I
    //   671: aload 10
    //   673: iconst_1
    //   674: putfield 150	com/tencent/mm/bi/g:isInited	Z
    //   677: ldc 82
    //   679: ldc_w 298
    //   682: iconst_1
    //   683: anewarray 4	java/lang/Object
    //   686: dup
    //   687: iconst_0
    //   688: lload 4
    //   690: invokestatic 302	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   693: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   696: aastore
    //   697: invokestatic 140	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   700: aload 10
    //   702: iload 8
    //   704: putfield 305	com/tencent/mm/bi/g:eJk	Z
    //   707: goto -488 -> 219
    //   710: lload 4
    //   712: lconst_0
    //   713: lcmp
    //   714: ifle +19 -> 733
    //   717: lload 4
    //   719: aload_0
    //   720: ldc 176
    //   722: invokevirtual 309	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   725: ldc2_w 310
    //   728: ldiv
    //   729: lcmp
    //   730: ifle +188 -> 918
    //   733: aload_0
    //   734: ldc 176
    //   736: invokevirtual 309	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   739: ldc2_w 310
    //   742: ldiv
    //   743: lstore 4
    //   745: aload 10
    //   747: lload 4
    //   749: putfield 314	com/tencent/mm/bi/g:eJh	J
    //   752: aload 10
    //   754: aload 10
    //   756: getfield 162	com/tencent/mm/bi/g:eJa	Ljava/util/List;
    //   759: iconst_0
    //   760: invokeinterface 168 2 0
    //   765: checkcast 170	com/tencent/mm/bi/g$a
    //   768: putfield 318	com/tencent/mm/bi/g:eIY	Lcom/tencent/mm/bi/g$a;
    //   771: aload 10
    //   773: getfield 321	com/tencent/mm/bi/g:eJb	Ljava/util/List;
    //   776: ifnull +35 -> 811
    //   779: aload 10
    //   781: getfield 321	com/tencent/mm/bi/g:eJb	Ljava/util/List;
    //   784: invokeinterface 282 1 0
    //   789: ifeq +22 -> 811
    //   792: aload 10
    //   794: aload 10
    //   796: getfield 321	com/tencent/mm/bi/g:eJb	Ljava/util/List;
    //   799: iconst_0
    //   800: invokeinterface 168 2 0
    //   805: checkcast 170	com/tencent/mm/bi/g$a
    //   808: putfield 324	com/tencent/mm/bi/g:eIZ	Lcom/tencent/mm/bi/g$a;
    //   811: aload 10
    //   813: getfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   816: astore_0
    //   817: aload 10
    //   819: getfield 290	com/tencent/mm/bi/g:eJi	I
    //   822: ifgt +69 -> 891
    //   825: ldc_w 325
    //   828: istore_3
    //   829: aload 10
    //   831: aload_0
    //   832: iload_3
    //   833: aload 10
    //   835: getfield 328	com/tencent/mm/bi/g:eIz	I
    //   838: aload 10
    //   840: getfield 258	com/tencent/mm/bi/g:eJc	Ljava/lang/String;
    //   843: invokevirtual 331	com/tencent/mm/bi/g:a	(Landroid/media/MediaExtractor;IILjava/lang/String;)I
    //   846: iconst_m1
    //   847: if_icmpne +53 -> 900
    //   850: ldc 82
    //   852: ldc_w 333
    //   855: invokestatic 154	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload 10
    //   860: iconst_0
    //   861: putfield 150	com/tencent/mm/bi/g:isInited	Z
    //   864: aload 10
    //   866: getfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   869: ifnull +11 -> 880
    //   872: aload 10
    //   874: getfield 272	com/tencent/mm/bi/g:mMediaExtractor	Landroid/media/MediaExtractor;
    //   877: invokevirtual 336	android/media/MediaExtractor:release	()V
    //   880: iconst_m1
    //   881: istore_3
    //   882: getstatic 192	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   885: invokevirtual 195	com/tencent/mm/bi/b:ET	()V
    //   888: goto -555 -> 333
    //   891: aload 10
    //   893: getfield 290	com/tencent/mm/bi/g:eJi	I
    //   896: istore_3
    //   897: goto -68 -> 829
    //   900: iconst_0
    //   901: istore_3
    //   902: goto -20 -> 882
    //   905: astore_0
    //   906: getstatic 192	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   909: invokevirtual 195	com/tencent/mm/bi/b:ET	()V
    //   912: aload_0
    //   913: athrow
    //   914: astore_0
    //   915: goto -608 -> 307
    //   918: goto -173 -> 745
    //   921: astore_1
    //   922: goto -721 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	925	0	paramString1	String
    //   0	925	1	paramString2	String
    //   0	925	2	paramVideoTransPara	VideoTransPara
    //   53	849	3	i	int
    //   148	600	4	l1	long
    //   10	356	6	l2	long
    //   65	638	8	bool1	boolean
    //   45	442	9	bool2	boolean
    //   19	873	10	localg	g
    //   511	27	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   21	44	200	com/tencent/mm/bi/f
    //   47	54	200	com/tencent/mm/bi/f
    //   67	164	200	com/tencent/mm/bi/f
    //   168	200	200	com/tencent/mm/bi/f
    //   503	547	200	com/tencent/mm/bi/f
    //   547	571	200	com/tencent/mm/bi/f
    //   571	641	200	com/tencent/mm/bi/f
    //   641	652	200	com/tencent/mm/bi/f
    //   652	707	200	com/tencent/mm/bi/f
    //   219	263	306	com/tencent/mm/bi/f
    //   263	306	306	com/tencent/mm/bi/f
    //   717	733	306	com/tencent/mm/bi/f
    //   733	745	306	com/tencent/mm/bi/f
    //   745	811	306	com/tencent/mm/bi/f
    //   811	825	306	com/tencent/mm/bi/f
    //   829	880	306	com/tencent/mm/bi/f
    //   891	897	306	com/tencent/mm/bi/f
    //   219	263	905	finally
    //   263	306	905	finally
    //   309	327	905	finally
    //   717	733	905	finally
    //   733	745	905	finally
    //   745	811	905	finally
    //   811	825	905	finally
    //   829	880	905	finally
    //   891	897	905	finally
    //   219	263	914	java/io/IOException
    //   263	306	914	java/io/IOException
    //   717	733	914	java/io/IOException
    //   733	745	914	java/io/IOException
    //   745	811	914	java/io/IOException
    //   811	825	914	java/io/IOException
    //   829	880	914	java/io/IOException
    //   891	897	914	java/io/IOException
    //   21	44	921	java/io/IOException
    //   47	54	921	java/io/IOException
    //   67	164	921	java/io/IOException
    //   168	200	921	java/io/IOException
    //   503	547	921	java/io/IOException
    //   547	571	921	java/io/IOException
    //   571	641	921	java/io/IOException
    //   641	652	921	java/io/IOException
    //   652	707	921	java/io/IOException
  }
  
  public static VideoTransPara a(VideoTransPara paramVideoTransPara, String paramString)
  {
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.d.Nl().b(paramVideoTransPara);
    VideoTransPara localVideoTransPara1;
    if (localVideoTransPara2 == null)
    {
      y.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      localVideoTransPara1 = oo(paramString);
    }
    do
    {
      do
      {
        return localVideoTransPara1;
        y.d("MicroMsg.TransferUtil", "compress new para is %s", new Object[] { localVideoTransPara2 });
        if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara2.videoBitrate > paramVideoTransPara.videoBitrate))
        {
          y.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara2, paramVideoTransPara });
          return oo(paramString);
        }
        localVideoTransPara1 = localVideoTransPara2;
      } while (paramVideoTransPara.fps < 45);
      localVideoTransPara1 = localVideoTransPara2;
    } while (paramVideoTransPara.duration * 1000 < 180000);
    return oo(paramString);
  }
  
  /* Error */
  private static void a(String paramString, VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 267	android/media/MediaExtractor
    //   5: dup
    //   6: invokespecial 268	android/media/MediaExtractor:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: astore 4
    //   15: aload 5
    //   17: aload_0
    //   18: invokevirtual 275	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: astore 4
    //   25: aload 5
    //   27: invokevirtual 376	android/media/MediaExtractor:getTrackCount	()I
    //   30: istore_3
    //   31: iload_2
    //   32: iload_3
    //   33: if_icmpge +140 -> 173
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: iload_2
    //   43: invokevirtual 380	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   46: astore 6
    //   48: aload 5
    //   50: astore 4
    //   52: aload 6
    //   54: ldc_w 382
    //   57: invokevirtual 181	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   60: ifeq +119 -> 179
    //   63: aload 5
    //   65: astore 4
    //   67: aload 6
    //   69: ldc_w 382
    //   72: invokevirtual 386	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 113	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   78: ifne +101 -> 179
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: ldc_w 382
    //   90: invokevirtual 386	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 7
    //   95: aload 5
    //   97: astore 4
    //   99: ldc 12
    //   101: ldc_w 388
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload 7
    //   112: aastore
    //   113: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload 5
    //   118: astore 4
    //   120: aload 7
    //   122: ldc_w 390
    //   125: invokevirtual 393	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   128: ifeq +51 -> 179
    //   131: aload 5
    //   133: astore 4
    //   135: aload_1
    //   136: aload 6
    //   138: ldc_w 395
    //   141: invokevirtual 398	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   144: putfield 368	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   147: aload 5
    //   149: astore 4
    //   151: ldc 12
    //   153: ldc_w 400
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_1
    //   163: getfield 368	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   166: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload 5
    //   175: invokevirtual 336	android/media/MediaExtractor:release	()V
    //   178: return
    //   179: iload_2
    //   180: iconst_1
    //   181: iadd
    //   182: istore_2
    //   183: goto -152 -> 31
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 5
    //   191: aload 5
    //   193: astore 4
    //   195: ldc 12
    //   197: aload 6
    //   199: ldc_w 402
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 406	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 5
    //   211: astore 4
    //   213: aload_0
    //   214: invokestatic 412	com/tencent/mm/plugin/sight/base/d:MH	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   217: astore_0
    //   218: aload_0
    //   219: ifnull +41 -> 260
    //   222: aload 5
    //   224: astore 4
    //   226: aload_1
    //   227: aload_0
    //   228: getfield 417	com/tencent/mm/plugin/sight/base/a:eIM	I
    //   231: putfield 368	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   234: aload 5
    //   236: astore 4
    //   238: ldc 12
    //   240: ldc_w 419
    //   243: iconst_1
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_0
    //   250: getfield 417	com/tencent/mm/plugin/sight/base/a:eIM	I
    //   253: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aastore
    //   257: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 5
    //   262: ifnull -84 -> 178
    //   265: aload 5
    //   267: invokevirtual 336	android/media/MediaExtractor:release	()V
    //   270: return
    //   271: astore_0
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 336	android/media/MediaExtractor:release	()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_0
    //   288: goto -13 -> 275
    //   291: astore 6
    //   293: goto -102 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString	String
    //   0	296	1	paramVideoTransPara	VideoTransPara
    //   1	182	2	i	int
    //   30	4	3	j	int
    //   13	268	4	localMediaExtractor1	MediaExtractor
    //   9	257	5	localMediaExtractor2	MediaExtractor
    //   46	91	6	localMediaFormat	MediaFormat
    //   186	12	6	localException1	Exception
    //   291	1	6	localException2	Exception
    //   93	28	7	str	String
    // Exception table:
    //   from	to	target	type
    //   2	11	186	java/lang/Exception
    //   2	11	271	finally
    //   15	21	287	finally
    //   25	31	287	finally
    //   40	48	287	finally
    //   52	63	287	finally
    //   67	81	287	finally
    //   85	95	287	finally
    //   99	116	287	finally
    //   120	131	287	finally
    //   135	147	287	finally
    //   151	173	287	finally
    //   195	209	287	finally
    //   213	218	287	finally
    //   226	234	287	finally
    //   238	260	287	finally
    //   15	21	291	java/lang/Exception
    //   25	31	291	java/lang/Exception
    //   40	48	291	java/lang/Exception
    //   52	63	291	java/lang/Exception
    //   67	81	291	java/lang/Exception
    //   85	95	291	java/lang/Exception
    //   99	116	291	java/lang/Exception
    //   120	131	291	java/lang/Exception
    //   135	147	291	java/lang/Exception
    //   151	173	291	java/lang/Exception
  }
  
  public static boolean om(String paramString)
  {
    y.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    try
    {
      localMediaExtractor = new MediaExtractor();
      localMediaExtractor.setDataSource(paramString);
      j = localMediaExtractor.getTrackCount();
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        MediaExtractor localMediaExtractor;
        int j;
        int i;
        y.printErrStackTrace("MicroMsg.TransferUtil", paramString, "check H265 error", new Object[0]);
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      paramString = localMediaExtractor.getTrackFormat(i);
      if ((paramString.containsKey("mime")) && (!bk.bl(paramString.getString("mime"))))
      {
        paramString = paramString.getString("mime");
        y.i("MicroMsg.TransferUtil", "mime: %s", new Object[] { paramString });
        if (paramString.startsWith("video/hevc")) {
          return true;
        }
      }
    }
    else
    {
      localMediaExtractor.release();
      return false;
    }
  }
  
  public static VideoTransPara on(String paramString)
  {
    y.i("MicroMsg.TransferUtil", "buildPara：srcPath %s ", new Object[] { paramString });
    if (com.tencent.mm.modelcontrol.d.Nl().lQ(paramString))
    {
      y.i("MicroMsg.TransferUtil", "This video is not  wx meta：%s ", new Object[] { paramString });
      return null;
    }
    VideoTransPara localVideoTransPara = new VideoTransPara();
    Object localObject = Boolean.valueOf(om(paramString));
    y.i("MicroMsg.TransferUtil", "Video format is h265 : %s", new Object[] { localObject });
    if (((Boolean)localObject).booleanValue())
    {
      localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      localVideoTransPara.duration = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(9), 0);
      localVideoTransPara.duration = bk.hv(localVideoTransPara.duration);
      localVideoTransPara.width = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
      localVideoTransPara.height = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
      localVideoTransPara.videoBitrate = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), 0);
      a(paramString, localVideoTransPara);
      ((MediaMetadataRetriever)localObject).release();
    }
    for (;;)
    {
      y.d("MicroMsg.TransferUtil", "VideoPara is : %s", new Object[] { localVideoTransPara });
      return localVideoTransPara;
      localObject = new PInt();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      PInt localPInt3 = new PInt();
      PInt localPInt4 = new PInt();
      com.tencent.mm.plugin.sight.base.d.a(paramString, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
      localVideoTransPara.duration = bk.hv(((PInt)localObject).value);
      localVideoTransPara.width = localPInt1.value;
      localVideoTransPara.height = localPInt2.value;
      localVideoTransPara.fps = localPInt3.value;
      localVideoTransPara.videoBitrate = localPInt4.value;
    }
  }
  
  /* Error */
  private static VideoTransPara oo(String paramString)
  {
    // Byte code:
    //   0: new 359	com/tencent/mm/modelcontrol/VideoTransPara
    //   3: dup
    //   4: invokespecial 435	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   7: astore 5
    //   9: iconst_2
    //   10: newarray int
    //   12: astore 6
    //   14: new 444	android/media/MediaMetadataRetriever
    //   17: dup
    //   18: invokespecial 445	android/media/MediaMetadataRetriever:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: aload_0
    //   26: invokevirtual 446	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   29: aload 4
    //   31: bipush 18
    //   33: invokevirtual 450	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 451	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   40: istore_3
    //   41: aload 4
    //   43: bipush 19
    //   45: invokevirtual 450	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   48: iconst_0
    //   49: invokestatic 451	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   52: istore_2
    //   53: aload 6
    //   55: iconst_0
    //   56: iload_3
    //   57: iastore
    //   58: aload 6
    //   60: iconst_1
    //   61: iload_2
    //   62: iastore
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_3
    //   67: if_icmpge +119 -> 186
    //   70: iload_3
    //   71: iconst_2
    //   72: irem
    //   73: ifne +9 -> 82
    //   76: iload_2
    //   77: iconst_2
    //   78: irem
    //   79: ifeq +69 -> 148
    //   82: aload 4
    //   84: invokevirtual 464	android/media/MediaMetadataRetriever:release	()V
    //   87: aload 5
    //   89: aload 6
    //   91: iconst_0
    //   92: iaload
    //   93: putfield 458	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   96: aload 5
    //   98: aload 6
    //   100: iconst_1
    //   101: iaload
    //   102: putfield 461	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   105: aload 5
    //   107: getstatic 480	com/tencent/mm/plugin/sight/base/b:oeb	I
    //   110: putfield 362	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   113: aload 5
    //   115: getstatic 483	com/tencent/mm/plugin/sight/base/b:oea	I
    //   118: putfield 486	com/tencent/mm/modelcontrol/VideoTransPara:ejP	I
    //   121: aload 5
    //   123: iconst_2
    //   124: putfield 489	com/tencent/mm/modelcontrol/VideoTransPara:ejO	I
    //   127: aload 5
    //   129: getstatic 493	com/tencent/mm/plugin/sight/base/b:oec	F
    //   132: f2i
    //   133: putfield 368	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   136: aload 5
    //   138: aload_0
    //   139: invokestatic 144	com/tencent/mm/bi/e:op	(Ljava/lang/String;)I
    //   142: putfield 371	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   145: aload 5
    //   147: areturn
    //   148: iload_3
    //   149: iload_2
    //   150: if_icmplt +17 -> 167
    //   153: iload_3
    //   154: sipush 640
    //   157: if_icmple +29 -> 186
    //   160: iload_2
    //   161: sipush 480
    //   164: if_icmple +22 -> 186
    //   167: iload_3
    //   168: iload_2
    //   169: if_icmpgt +58 -> 227
    //   172: iload_3
    //   173: sipush 480
    //   176: if_icmple +10 -> 186
    //   179: iload_2
    //   180: sipush 640
    //   183: if_icmpgt +44 -> 227
    //   186: aload 6
    //   188: iconst_0
    //   189: iload_3
    //   190: iastore
    //   191: aload 6
    //   193: iconst_1
    //   194: iload_2
    //   195: iastore
    //   196: aload 4
    //   198: invokevirtual 464	android/media/MediaMetadataRetriever:release	()V
    //   201: goto -114 -> 87
    //   204: astore_0
    //   205: ldc 12
    //   207: aload_0
    //   208: ldc_w 495
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 406	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aconst_null
    //   226: areturn
    //   227: iload_3
    //   228: iconst_2
    //   229: idiv
    //   230: istore_3
    //   231: iload_2
    //   232: iconst_2
    //   233: idiv
    //   234: istore_2
    //   235: iload_1
    //   236: iconst_1
    //   237: iadd
    //   238: istore_1
    //   239: goto -174 -> 65
    //   242: astore_0
    //   243: aconst_null
    //   244: astore 4
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 464	android/media/MediaMetadataRetriever:release	()V
    //   256: aload_0
    //   257: athrow
    //   258: astore_0
    //   259: goto -13 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramString	String
    //   64	175	1	i	int
    //   52	183	2	j	int
    //   40	191	3	k	int
    //   21	231	4	localMediaMetadataRetriever	MediaMetadataRetriever
    //   7	139	5	localVideoTransPara	VideoTransPara
    //   12	180	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   0	14	204	java/lang/Exception
    //   82	87	204	java/lang/Exception
    //   87	145	204	java/lang/Exception
    //   196	201	204	java/lang/Exception
    //   251	256	204	java/lang/Exception
    //   256	258	204	java/lang/Exception
    //   14	23	242	finally
    //   23	53	258	finally
    //   227	235	258	finally
  }
  
  public static int op(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(9);
    localMediaMetadataRetriever.release();
    if (paramString == null) {
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bi.e
 * JD-Core Version:    0.7.0.1
 */