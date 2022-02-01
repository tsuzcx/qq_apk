package com.tencent.mm.aj;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

@SuppressLint({"DefaultLocale"})
final class f$b
  implements bf.a
{
  public boolean aGQ;
  boolean bGj;
  public String hPB;
  String hPC;
  private com.tencent.mm.compatible.util.f.a hPE;
  public i hPj;
  
  public f$b(f paramf, i parami)
  {
    AppMethodBeat.i(150271);
    this.hPj = null;
    this.hPB = null;
    this.aGQ = true;
    this.bGj = false;
    this.hPj = parami;
    p.aEA();
    this.hPB = e.J(parami.getUsername(), true);
    this.hPC = (this.hPB + ".tmp");
    this.hPE = new com.tencent.mm.compatible.util.f.a();
    AppMethodBeat.o(150271);
  }
  
  /* Error */
  public final boolean aEC()
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 40	com/tencent/mm/aj/f$b:hPj	Lcom/tencent/mm/aj/i;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 92
    //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 40	com/tencent/mm/aj/f$b:hPj	Lcom/tencent/mm/aj/i;
    //   23: invokevirtual 95	com/tencent/mm/aj/i:aEG	()Ljava/lang/String;
    //   26: astore 6
    //   28: ldc 97
    //   30: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   33: checkcast 97	com/tencent/mm/plugin/emoji/b/c
    //   36: invokeinterface 106 1 0
    //   41: istore_3
    //   42: ldc 108
    //   44: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   47: checkcast 108	com/tencent/mm/plugin/expt/b/b
    //   50: getstatic 114	com/tencent/mm/plugin/expt/b/b$a:qFm	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   53: iconst_0
    //   54: invokeinterface 118 3 0
    //   59: istore 4
    //   61: aload_0
    //   62: getfield 28	com/tencent/mm/aj/f$b:hPD	Lcom/tencent/mm/aj/f;
    //   65: getfield 121	com/tencent/mm/aj/f:hPz	Z
    //   68: ifeq +1081 -> 1149
    //   71: iload_3
    //   72: ifeq +1077 -> 1149
    //   75: iload 4
    //   77: ifeq +1072 -> 1149
    //   80: ldc 123
    //   82: ldc 125
    //   84: invokestatic 130	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 6
    //   89: ldc 132
    //   91: invokevirtual 138	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +291 -> 385
    //   97: new 66	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   104: aload 6
    //   106: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 140
    //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 5
    //   119: getstatic 146	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   122: sipush 138
    //   125: bipush 60
    //   127: invokevirtual 150	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   130: aload 5
    //   132: astore 6
    //   134: invokestatic 154	com/tencent/mm/kernel/g:ajP	()Lcom/tencent/mm/kernel/a;
    //   137: invokevirtual 159	com/tencent/mm/kernel/a:aiZ	()Z
    //   140: ifeq +1001 -> 1141
    //   143: getstatic 165	com/tencent/mm/protocal/d:FFH	I
    //   146: istore_1
    //   147: invokestatic 154	com/tencent/mm/kernel/g:ajP	()Lcom/tencent/mm/kernel/a;
    //   150: pop
    //   151: ldc 167
    //   153: iconst_4
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload_1
    //   160: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: invokestatic 177	com/tencent/mm/kernel/a:getUin	()I
    //   169: invokestatic 183	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: invokestatic 189	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   178: invokestatic 195	com/tencent/mm/sdk/platformtools/az:getNetTypeForStat	(Landroid/content/Context;)I
    //   181: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_3
    //   187: invokestatic 189	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   190: invokestatic 198	com/tencent/mm/sdk/platformtools/az:getStrength	(Landroid/content/Context;)I
    //   193: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 202	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   200: astore 7
    //   202: ldc 123
    //   204: ldc 204
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_0
    //   213: getfield 40	com/tencent/mm/aj/f$b:hPj	Lcom/tencent/mm/aj/i;
    //   216: invokevirtual 58	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload 7
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload 6
    //   229: aastore
    //   230: invokestatic 208	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 44	com/tencent/mm/aj/f$b:aGQ	Z
    //   238: ldc 108
    //   240: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   243: checkcast 108	com/tencent/mm/plugin/expt/b/b
    //   246: getstatic 211	com/tencent/mm/plugin/expt/b/b$a:qNh	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   249: iconst_0
    //   250: invokeinterface 118 3 0
    //   255: ifeq +156 -> 411
    //   258: aload 6
    //   260: invokestatic 217	com/tencent/mm/network/b:IT	(Ljava/lang/String;)Lcom/tencent/mm/network/x;
    //   263: astore 5
    //   265: ldc 108
    //   267: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   270: checkcast 108	com/tencent/mm/plugin/expt/b/b
    //   273: getstatic 220	com/tencent/mm/plugin/expt/b/b$a:qPj	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   276: iconst_0
    //   277: invokeinterface 118 3 0
    //   282: istore_3
    //   283: aload 5
    //   285: checkcast 222	com/tencent/mm/network/x
    //   288: iload_3
    //   289: putfield 225	com/tencent/mm/network/x:iIN	Z
    //   292: aload 5
    //   294: checkcast 222	com/tencent/mm/network/x
    //   297: sipush 1223
    //   300: putfield 228	com/tencent/mm/network/x:iIM	I
    //   303: aload 5
    //   305: astore 8
    //   307: aload 8
    //   309: ldc 230
    //   311: invokeinterface 236 2 0
    //   316: aload 8
    //   318: ldc 238
    //   320: aload 7
    //   322: invokeinterface 241 3 0
    //   327: aload 8
    //   329: sipush 5000
    //   332: invokeinterface 244 2 0
    //   337: aload 8
    //   339: sipush 5000
    //   342: invokeinterface 247 2 0
    //   347: aload 8
    //   349: invokestatic 250	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/w;)I
    //   352: ifeq +115 -> 467
    //   355: ldc 123
    //   357: ldc 252
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload 6
    //   367: aastore
    //   368: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload 8
    //   373: invokeinterface 258 1 0
    //   378: ldc 92
    //   380: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: iconst_1
    //   384: ireturn
    //   385: new 66	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   392: aload 6
    //   394: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 260
    //   400: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: astore 5
    //   408: goto -289 -> 119
    //   411: aload 6
    //   413: aconst_null
    //   414: invokestatic 263	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   417: astore 8
    //   419: goto -112 -> 307
    //   422: astore 5
    //   424: ldc 123
    //   426: ldc_w 265
    //   429: iconst_1
    //   430: anewarray 4	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload 5
    //   437: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   440: aastore
    //   441: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: ldc 123
    //   446: ldc_w 272
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload 5
    //   457: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   460: aastore
    //   461: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: goto -86 -> 378
    //   467: aload 8
    //   469: ldc_w 277
    //   472: iconst_0
    //   473: invokeinterface 281 3 0
    //   478: iconst_1
    //   479: if_icmpne +65 -> 544
    //   482: iconst_1
    //   483: istore_3
    //   484: aload_0
    //   485: iload_3
    //   486: putfield 46	com/tencent/mm/aj/f$b:bGj	Z
    //   489: aload 8
    //   491: invokeinterface 285 1 0
    //   496: astore 5
    //   498: aload 5
    //   500: ifnonnull +94 -> 594
    //   503: ldc 123
    //   505: ldc_w 287
    //   508: iconst_1
    //   509: anewarray 4	java/lang/Object
    //   512: dup
    //   513: iconst_0
    //   514: aload 6
    //   516: aastore
    //   517: invokestatic 208	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: aload 8
    //   522: invokeinterface 258 1 0
    //   527: aload 5
    //   529: ifnull +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 292	java/io/InputStream:close	()V
    //   537: ldc 92
    //   539: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: iconst_1
    //   543: ireturn
    //   544: iconst_0
    //   545: istore_3
    //   546: goto -62 -> 484
    //   549: astore 5
    //   551: ldc 123
    //   553: ldc_w 265
    //   556: iconst_1
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: aload 5
    //   564: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: ldc 123
    //   573: ldc_w 272
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 5
    //   584: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: aastore
    //   588: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: goto -54 -> 537
    //   594: sipush 1024
    //   597: newarray byte
    //   599: astore 7
    //   601: aload_0
    //   602: getfield 78	com/tencent/mm/aj/f$b:hPC	Ljava/lang/String;
    //   605: iconst_0
    //   606: invokestatic 298	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   609: astore 6
    //   611: iconst_0
    //   612: istore_1
    //   613: aload 5
    //   615: aload 7
    //   617: invokevirtual 302	java/io/InputStream:read	([B)I
    //   620: istore_2
    //   621: iload_2
    //   622: iconst_m1
    //   623: if_icmpeq +19 -> 642
    //   626: aload 6
    //   628: aload 7
    //   630: iconst_0
    //   631: iload_2
    //   632: invokevirtual 308	java/io/OutputStream:write	([BII)V
    //   635: iload_1
    //   636: iload_2
    //   637: iadd
    //   638: istore_1
    //   639: goto -26 -> 613
    //   642: iload_1
    //   643: aload 8
    //   645: ldc_w 310
    //   648: aload 8
    //   650: invokeinterface 313 1 0
    //   655: invokeinterface 281 3 0
    //   660: if_icmpne +42 -> 702
    //   663: aload_0
    //   664: iconst_0
    //   665: putfield 44	com/tencent/mm/aj/f$b:aGQ	Z
    //   668: aload 8
    //   670: invokeinterface 258 1 0
    //   675: aload 5
    //   677: ifnull +8 -> 685
    //   680: aload 5
    //   682: invokevirtual 292	java/io/InputStream:close	()V
    //   685: aload 6
    //   687: ifnull +8 -> 695
    //   690: aload 6
    //   692: invokevirtual 314	java/io/OutputStream:close	()V
    //   695: ldc 92
    //   697: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   700: iconst_1
    //   701: ireturn
    //   702: ldc 123
    //   704: ldc_w 316
    //   707: iconst_3
    //   708: anewarray 4	java/lang/Object
    //   711: dup
    //   712: iconst_0
    //   713: iload_1
    //   714: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: aastore
    //   718: dup
    //   719: iconst_1
    //   720: aload 8
    //   722: ldc_w 310
    //   725: invokeinterface 320 2 0
    //   730: aastore
    //   731: dup
    //   732: iconst_2
    //   733: aload 8
    //   735: invokeinterface 313 1 0
    //   740: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: aastore
    //   744: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   747: goto -79 -> 668
    //   750: astore 9
    //   752: aload 6
    //   754: astore 7
    //   756: aload 5
    //   758: astore 6
    //   760: aload 9
    //   762: astore 5
    //   764: ldc 123
    //   766: ldc_w 265
    //   769: iconst_1
    //   770: anewarray 4	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: aload 5
    //   777: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   780: aastore
    //   781: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   784: aload 8
    //   786: ifnull +10 -> 796
    //   789: aload 8
    //   791: invokeinterface 258 1 0
    //   796: aload 6
    //   798: ifnull +8 -> 806
    //   801: aload 6
    //   803: invokevirtual 292	java/io/InputStream:close	()V
    //   806: aload 7
    //   808: ifnull -113 -> 695
    //   811: aload 7
    //   813: invokevirtual 314	java/io/OutputStream:close	()V
    //   816: goto -121 -> 695
    //   819: astore 5
    //   821: ldc 123
    //   823: ldc_w 265
    //   826: iconst_1
    //   827: anewarray 4	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: aload 5
    //   834: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   837: aastore
    //   838: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: ldc 123
    //   843: ldc_w 272
    //   846: iconst_1
    //   847: anewarray 4	java/lang/Object
    //   850: dup
    //   851: iconst_0
    //   852: aload 5
    //   854: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   857: aastore
    //   858: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   861: goto -166 -> 695
    //   864: astore 5
    //   866: ldc 123
    //   868: ldc_w 265
    //   871: iconst_1
    //   872: anewarray 4	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: aload 5
    //   879: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   882: aastore
    //   883: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: ldc 123
    //   888: ldc_w 272
    //   891: iconst_1
    //   892: anewarray 4	java/lang/Object
    //   895: dup
    //   896: iconst_0
    //   897: aload 5
    //   899: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   902: aastore
    //   903: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   906: goto -211 -> 695
    //   909: astore 5
    //   911: aconst_null
    //   912: astore 6
    //   914: aconst_null
    //   915: astore 7
    //   917: aconst_null
    //   918: astore 8
    //   920: aload 8
    //   922: ifnull +10 -> 932
    //   925: aload 8
    //   927: invokeinterface 258 1 0
    //   932: aload 6
    //   934: ifnull +8 -> 942
    //   937: aload 6
    //   939: invokevirtual 292	java/io/InputStream:close	()V
    //   942: aload 7
    //   944: ifnull +8 -> 952
    //   947: aload 7
    //   949: invokevirtual 314	java/io/OutputStream:close	()V
    //   952: ldc 92
    //   954: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   957: aload 5
    //   959: athrow
    //   960: astore 6
    //   962: ldc 123
    //   964: ldc_w 265
    //   967: iconst_1
    //   968: anewarray 4	java/lang/Object
    //   971: dup
    //   972: iconst_0
    //   973: aload 6
    //   975: invokestatic 270	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   978: aastore
    //   979: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   982: ldc 123
    //   984: ldc_w 272
    //   987: iconst_1
    //   988: anewarray 4	java/lang/Object
    //   991: dup
    //   992: iconst_0
    //   993: aload 6
    //   995: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   998: aastore
    //   999: invokestatic 255	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1002: goto -50 -> 952
    //   1005: astore 9
    //   1007: aconst_null
    //   1008: astore 6
    //   1010: aconst_null
    //   1011: astore 7
    //   1013: aload 5
    //   1015: astore 8
    //   1017: aload 9
    //   1019: astore 5
    //   1021: goto -101 -> 920
    //   1024: astore 5
    //   1026: aconst_null
    //   1027: astore 6
    //   1029: aconst_null
    //   1030: astore 7
    //   1032: goto -112 -> 920
    //   1035: astore 9
    //   1037: aload 5
    //   1039: astore 6
    //   1041: aconst_null
    //   1042: astore 7
    //   1044: aload 9
    //   1046: astore 5
    //   1048: goto -128 -> 920
    //   1051: astore 10
    //   1053: aload 5
    //   1055: astore 7
    //   1057: aload 6
    //   1059: astore 9
    //   1061: aload 10
    //   1063: astore 5
    //   1065: aload 7
    //   1067: astore 6
    //   1069: aload 9
    //   1071: astore 7
    //   1073: goto -153 -> 920
    //   1076: astore 5
    //   1078: goto -158 -> 920
    //   1081: astore 5
    //   1083: aconst_null
    //   1084: astore 6
    //   1086: aconst_null
    //   1087: astore 7
    //   1089: aconst_null
    //   1090: astore 8
    //   1092: goto -328 -> 764
    //   1095: astore 9
    //   1097: aconst_null
    //   1098: astore 6
    //   1100: aconst_null
    //   1101: astore 7
    //   1103: aload 5
    //   1105: astore 8
    //   1107: aload 9
    //   1109: astore 5
    //   1111: goto -347 -> 764
    //   1114: astore 5
    //   1116: aconst_null
    //   1117: astore 6
    //   1119: aconst_null
    //   1120: astore 7
    //   1122: goto -358 -> 764
    //   1125: astore 9
    //   1127: aload 5
    //   1129: astore 6
    //   1131: aconst_null
    //   1132: astore 7
    //   1134: aload 9
    //   1136: astore 5
    //   1138: goto -374 -> 764
    //   1141: ldc_w 322
    //   1144: astore 7
    //   1146: goto -944 -> 202
    //   1149: goto -1015 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1152	0	this	b
    //   146	568	1	i	int
    //   620	18	2	j	int
    //   41	505	3	bool1	boolean
    //   59	17	4	bool2	boolean
    //   117	290	5	localObject1	Object
    //   422	34	5	localException1	java.lang.Exception
    //   496	37	5	localInputStream	java.io.InputStream
    //   549	208	5	localException2	java.lang.Exception
    //   762	14	5	localObject2	Object
    //   819	34	5	localException3	java.lang.Exception
    //   864	34	5	localException4	java.lang.Exception
    //   909	105	5	localObject3	Object
    //   1019	1	5	localObject4	Object
    //   1024	14	5	localObject5	Object
    //   1046	18	5	localObject6	Object
    //   1076	1	5	localObject7	Object
    //   1081	23	5	localException5	java.lang.Exception
    //   1109	1	5	localObject8	Object
    //   1114	14	5	localException6	java.lang.Exception
    //   1136	1	5	localObject9	Object
    //   26	912	6	localObject10	Object
    //   960	34	6	localException7	java.lang.Exception
    //   1008	122	6	localObject11	Object
    //   200	945	7	localObject12	Object
    //   305	801	8	localObject13	Object
    //   750	11	9	localException8	java.lang.Exception
    //   1005	13	9	localObject14	Object
    //   1035	10	9	localObject15	Object
    //   1059	11	9	localObject16	Object
    //   1095	13	9	localException9	java.lang.Exception
    //   1125	10	9	localException10	java.lang.Exception
    //   1051	11	10	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   371	378	422	java/lang/Exception
    //   520	527	549	java/lang/Exception
    //   532	537	549	java/lang/Exception
    //   613	621	750	java/lang/Exception
    //   626	635	750	java/lang/Exception
    //   642	668	750	java/lang/Exception
    //   702	747	750	java/lang/Exception
    //   789	796	819	java/lang/Exception
    //   801	806	819	java/lang/Exception
    //   811	816	819	java/lang/Exception
    //   668	675	864	java/lang/Exception
    //   680	685	864	java/lang/Exception
    //   690	695	864	java/lang/Exception
    //   238	265	909	finally
    //   411	419	909	finally
    //   925	932	960	java/lang/Exception
    //   937	942	960	java/lang/Exception
    //   947	952	960	java/lang/Exception
    //   265	303	1005	finally
    //   307	371	1024	finally
    //   467	482	1024	finally
    //   484	498	1024	finally
    //   503	520	1035	finally
    //   594	611	1035	finally
    //   613	621	1051	finally
    //   626	635	1051	finally
    //   642	668	1051	finally
    //   702	747	1051	finally
    //   764	784	1076	finally
    //   238	265	1081	java/lang/Exception
    //   411	419	1081	java/lang/Exception
    //   265	303	1095	java/lang/Exception
    //   307	371	1114	java/lang/Exception
    //   467	482	1114	java/lang/Exception
    //   484	498	1114	java/lang/Exception
    //   503	520	1125	java/lang/Exception
    //   594	611	1125	java/lang/Exception
  }
  
  public final boolean aED()
  {
    AppMethodBeat.i(150273);
    if (this.hPD.hPx)
    {
      AppMethodBeat.o(150273);
      return false;
    }
    if ((this.aGQ) || (bu.isNullOrNil(this.hPB)))
    {
      this.hPD.hPv.df(4, -1);
      AppMethodBeat.o(150273);
      return false;
    }
    ae.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.hPj.getUsername() + " urltime:" + this.hPE.abs());
    if (au.a.hIH != null) {
      au.a.hIH.db((int)o.aZR(this.hPC), 0);
    }
    this.hPD.hPA.c(new f.a(this.hPD, this.hPD.hPg, this.hPB, this.hPC));
    AppMethodBeat.o(150273);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.f.b
 * JD-Core Version:    0.7.0.1
 */