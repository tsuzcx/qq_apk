package com.tencent.mm.ah;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"DefaultLocale"})
final class e$b
  implements az.a
{
  boolean bak;
  public h frE;
  public String frV;
  String frW;
  public boolean frX;
  private g.a frZ;
  
  public e$b(e parame, h paramh)
  {
    AppMethodBeat.i(77907);
    this.frE = null;
    this.frV = null;
    this.frX = true;
    this.bak = false;
    this.frE = paramh;
    o.acQ();
    this.frV = d.D(paramh.getUsername(), true);
    this.frW = (this.frV + ".tmp");
    this.frZ = new g.a();
    AppMethodBeat.o(77907);
  }
  
  /* Error */
  public final boolean acS()
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 40	com/tencent/mm/ah/e$b:frE	Lcom/tencent/mm/ah/h;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 92
    //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 40	com/tencent/mm/ah/e$b:frE	Lcom/tencent/mm/ah/h;
    //   23: invokevirtual 95	com/tencent/mm/ah/h:acX	()Ljava/lang/String;
    //   26: astore 5
    //   28: ldc 97
    //   30: invokestatic 103	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   33: checkcast 97	com/tencent/mm/plugin/emoji/b/c
    //   36: invokeinterface 106 1 0
    //   41: istore_3
    //   42: ldc 108
    //   44: invokestatic 103	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   47: checkcast 108	com/tencent/mm/plugin/expt/a/a
    //   50: getstatic 114	com/tencent/mm/plugin/expt/a/a$a:lVJ	Lcom/tencent/mm/plugin/expt/a/a$a;
    //   53: iconst_0
    //   54: invokeinterface 118 3 0
    //   59: istore 4
    //   61: aload_0
    //   62: getfield 28	com/tencent/mm/ah/e$b:frY	Lcom/tencent/mm/ah/e;
    //   65: getfield 121	com/tencent/mm/ah/e:frT	Z
    //   68: ifeq +900 -> 968
    //   71: iload_3
    //   72: ifeq +896 -> 968
    //   75: iload 4
    //   77: ifeq +891 -> 968
    //   80: ldc 123
    //   82: ldc 125
    //   84: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 5
    //   89: ldc 132
    //   91: invokevirtual 138	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +220 -> 314
    //   97: new 66	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   104: aload 5
    //   106: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 140
    //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 5
    //   119: getstatic 146	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   122: sipush 138
    //   125: bipush 60
    //   127: invokevirtual 150	com/tencent/mm/plugin/report/service/h:cT	(II)V
    //   130: ldc 152
    //   132: astore 6
    //   134: invokestatic 156	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   137: invokevirtual 161	com/tencent/mm/kernel/a:QU	()Z
    //   140: ifeq +62 -> 202
    //   143: getstatic 167	com/tencent/mm/protocal/d:whH	I
    //   146: istore_1
    //   147: invokestatic 156	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   150: pop
    //   151: ldc 169
    //   153: iconst_4
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload_1
    //   160: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: invokestatic 179	com/tencent/mm/kernel/a:getUin	()I
    //   169: invokestatic 185	com/tencent/mm/a/p:getString	(I)Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: invokestatic 191	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   178: invokestatic 197	com/tencent/mm/sdk/platformtools/at:getNetTypeForStat	(Landroid/content/Context;)I
    //   181: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_3
    //   187: invokestatic 191	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   190: invokestatic 200	com/tencent/mm/sdk/platformtools/at:getStrength	(Landroid/content/Context;)I
    //   193: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 204	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   200: astore 6
    //   202: ldc 123
    //   204: ldc 206
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_0
    //   213: getfield 40	com/tencent/mm/ah/e$b:frE	Lcom/tencent/mm/ah/h;
    //   216: invokevirtual 58	com/tencent/mm/ah/h:getUsername	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload 6
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload 5
    //   229: aastore
    //   230: invokestatic 210	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 44	com/tencent/mm/ah/e$b:frX	Z
    //   238: aload 5
    //   240: aconst_null
    //   241: invokestatic 215	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   244: astore 8
    //   246: aload 8
    //   248: ldc 217
    //   250: invokevirtual 223	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   253: aload 8
    //   255: ldc 225
    //   257: aload 6
    //   259: invokevirtual 228	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 8
    //   264: sipush 5000
    //   267: invokevirtual 231	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   270: aload 8
    //   272: sipush 5000
    //   275: invokevirtual 234	com/tencent/mm/network/v:setReadTimeout	(I)V
    //   278: aload 8
    //   280: invokestatic 237	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/v;)I
    //   283: ifeq +100 -> 383
    //   286: ldc 123
    //   288: ldc 239
    //   290: iconst_1
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload 5
    //   298: aastore
    //   299: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload 8
    //   304: invokevirtual 245	com/tencent/mm/network/v:disconnect	()V
    //   307: ldc 92
    //   309: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: iconst_1
    //   313: ireturn
    //   314: new 66	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   321: aload 5
    //   323: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 247
    //   328: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore 5
    //   336: goto -217 -> 119
    //   339: astore 5
    //   341: ldc 123
    //   343: ldc 249
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload 5
    //   353: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   356: aastore
    //   357: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: ldc 123
    //   362: ldc_w 257
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload 5
    //   373: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   376: aastore
    //   377: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: goto -73 -> 307
    //   383: aload 8
    //   385: ldc_w 262
    //   388: iconst_0
    //   389: invokevirtual 266	com/tencent/mm/network/v:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   392: iconst_1
    //   393: if_icmpne +61 -> 454
    //   396: iconst_1
    //   397: istore_3
    //   398: aload_0
    //   399: iload_3
    //   400: putfield 46	com/tencent/mm/ah/e$b:bak	Z
    //   403: aload 8
    //   405: invokevirtual 270	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   408: astore 7
    //   410: aload 7
    //   412: ifnonnull +91 -> 503
    //   415: ldc 123
    //   417: ldc_w 272
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload 5
    //   428: aastore
    //   429: invokestatic 210	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aload 8
    //   434: invokevirtual 245	com/tencent/mm/network/v:disconnect	()V
    //   437: aload 7
    //   439: ifnull +8 -> 447
    //   442: aload 7
    //   444: invokevirtual 277	java/io/InputStream:close	()V
    //   447: ldc 92
    //   449: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: iconst_1
    //   453: ireturn
    //   454: iconst_0
    //   455: istore_3
    //   456: goto -58 -> 398
    //   459: astore 5
    //   461: ldc 123
    //   463: ldc 249
    //   465: iconst_1
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 5
    //   473: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: aastore
    //   477: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: ldc 123
    //   482: ldc_w 257
    //   485: iconst_1
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: aload 5
    //   493: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   496: aastore
    //   497: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: goto -53 -> 447
    //   503: sipush 1024
    //   506: newarray byte
    //   508: astore 6
    //   510: aload_0
    //   511: getfield 78	com/tencent/mm/ah/e$b:frW	Ljava/lang/String;
    //   514: iconst_0
    //   515: invokestatic 283	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   518: astore 5
    //   520: iconst_0
    //   521: istore_1
    //   522: aload 7
    //   524: aload 6
    //   526: invokevirtual 287	java/io/InputStream:read	([B)I
    //   529: istore_2
    //   530: iload_2
    //   531: iconst_m1
    //   532: if_icmpeq +19 -> 551
    //   535: aload 5
    //   537: aload 6
    //   539: iconst_0
    //   540: iload_2
    //   541: invokevirtual 293	java/io/OutputStream:write	([BII)V
    //   544: iload_1
    //   545: iload_2
    //   546: iadd
    //   547: istore_1
    //   548: goto -26 -> 522
    //   551: iload_1
    //   552: aload 8
    //   554: ldc_w 295
    //   557: aload 8
    //   559: getfield 299	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
    //   562: invokevirtual 304	java/net/HttpURLConnection:getContentLength	()I
    //   565: invokevirtual 266	com/tencent/mm/network/v:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   568: if_icmpne +40 -> 608
    //   571: aload_0
    //   572: iconst_0
    //   573: putfield 44	com/tencent/mm/ah/e$b:frX	Z
    //   576: aload 8
    //   578: invokevirtual 245	com/tencent/mm/network/v:disconnect	()V
    //   581: aload 7
    //   583: ifnull +8 -> 591
    //   586: aload 7
    //   588: invokevirtual 277	java/io/InputStream:close	()V
    //   591: aload 5
    //   593: ifnull +8 -> 601
    //   596: aload 5
    //   598: invokevirtual 305	java/io/OutputStream:close	()V
    //   601: ldc 92
    //   603: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: iconst_1
    //   607: ireturn
    //   608: ldc 123
    //   610: ldc_w 307
    //   613: iconst_3
    //   614: anewarray 4	java/lang/Object
    //   617: dup
    //   618: iconst_0
    //   619: iload_1
    //   620: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   623: aastore
    //   624: dup
    //   625: iconst_1
    //   626: aload 8
    //   628: ldc_w 295
    //   631: invokevirtual 311	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: aload 8
    //   639: getfield 299	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
    //   642: invokevirtual 304	java/net/HttpURLConnection:getContentLength	()I
    //   645: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   652: goto -76 -> 576
    //   655: astore 9
    //   657: aload 5
    //   659: astore 6
    //   661: aload 9
    //   663: astore 5
    //   665: ldc 123
    //   667: ldc 249
    //   669: iconst_1
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: aload 5
    //   677: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   680: aastore
    //   681: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   684: aload 8
    //   686: ifnull +8 -> 694
    //   689: aload 8
    //   691: invokevirtual 245	com/tencent/mm/network/v:disconnect	()V
    //   694: aload 7
    //   696: ifnull +8 -> 704
    //   699: aload 7
    //   701: invokevirtual 277	java/io/InputStream:close	()V
    //   704: aload 6
    //   706: ifnull -105 -> 601
    //   709: aload 6
    //   711: invokevirtual 305	java/io/OutputStream:close	()V
    //   714: goto -113 -> 601
    //   717: astore 5
    //   719: ldc 123
    //   721: ldc 249
    //   723: iconst_1
    //   724: anewarray 4	java/lang/Object
    //   727: dup
    //   728: iconst_0
    //   729: aload 5
    //   731: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   734: aastore
    //   735: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: ldc 123
    //   740: ldc_w 257
    //   743: iconst_1
    //   744: anewarray 4	java/lang/Object
    //   747: dup
    //   748: iconst_0
    //   749: aload 5
    //   751: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   754: aastore
    //   755: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   758: goto -157 -> 601
    //   761: astore 5
    //   763: ldc 123
    //   765: ldc 249
    //   767: iconst_1
    //   768: anewarray 4	java/lang/Object
    //   771: dup
    //   772: iconst_0
    //   773: aload 5
    //   775: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   778: aastore
    //   779: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: ldc 123
    //   784: ldc_w 257
    //   787: iconst_1
    //   788: anewarray 4	java/lang/Object
    //   791: dup
    //   792: iconst_0
    //   793: aload 5
    //   795: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   798: aastore
    //   799: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   802: goto -201 -> 601
    //   805: astore 5
    //   807: aconst_null
    //   808: astore 7
    //   810: aconst_null
    //   811: astore 6
    //   813: aconst_null
    //   814: astore 8
    //   816: aload 8
    //   818: ifnull +8 -> 826
    //   821: aload 8
    //   823: invokevirtual 245	com/tencent/mm/network/v:disconnect	()V
    //   826: aload 7
    //   828: ifnull +8 -> 836
    //   831: aload 7
    //   833: invokevirtual 277	java/io/InputStream:close	()V
    //   836: aload 6
    //   838: ifnull +8 -> 846
    //   841: aload 6
    //   843: invokevirtual 305	java/io/OutputStream:close	()V
    //   846: ldc 92
    //   848: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   851: aload 5
    //   853: athrow
    //   854: astore 6
    //   856: ldc 123
    //   858: ldc 249
    //   860: iconst_1
    //   861: anewarray 4	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: aload 6
    //   868: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   871: aastore
    //   872: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   875: ldc 123
    //   877: ldc_w 257
    //   880: iconst_1
    //   881: anewarray 4	java/lang/Object
    //   884: dup
    //   885: iconst_0
    //   886: aload 6
    //   888: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   891: aastore
    //   892: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   895: goto -49 -> 846
    //   898: astore 5
    //   900: aconst_null
    //   901: astore 7
    //   903: aconst_null
    //   904: astore 6
    //   906: goto -90 -> 816
    //   909: astore 5
    //   911: aconst_null
    //   912: astore 6
    //   914: goto -98 -> 816
    //   917: astore 9
    //   919: aload 5
    //   921: astore 6
    //   923: aload 9
    //   925: astore 5
    //   927: goto -111 -> 816
    //   930: astore 5
    //   932: goto -116 -> 816
    //   935: astore 5
    //   937: aconst_null
    //   938: astore 7
    //   940: aconst_null
    //   941: astore 6
    //   943: aconst_null
    //   944: astore 8
    //   946: goto -281 -> 665
    //   949: astore 5
    //   951: aconst_null
    //   952: astore 7
    //   954: aconst_null
    //   955: astore 6
    //   957: goto -292 -> 665
    //   960: astore 5
    //   962: aconst_null
    //   963: astore 6
    //   965: goto -300 -> 665
    //   968: goto -838 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	b
    //   146	474	1	i	int
    //   529	18	2	j	int
    //   41	415	3	bool1	boolean
    //   59	17	4	bool2	boolean
    //   26	309	5	str	String
    //   339	88	5	localException1	java.lang.Exception
    //   459	33	5	localException2	java.lang.Exception
    //   518	158	5	localObject1	Object
    //   717	33	5	localException3	java.lang.Exception
    //   761	33	5	localException4	java.lang.Exception
    //   805	47	5	localObject2	Object
    //   898	1	5	localObject3	Object
    //   909	11	5	localObject4	Object
    //   925	1	5	localObject5	Object
    //   930	1	5	localObject6	Object
    //   935	1	5	localException5	java.lang.Exception
    //   949	1	5	localException6	java.lang.Exception
    //   960	1	5	localException7	java.lang.Exception
    //   132	710	6	localObject7	Object
    //   854	33	6	localException8	java.lang.Exception
    //   904	60	6	localObject8	Object
    //   408	545	7	localInputStream	java.io.InputStream
    //   244	701	8	localv	com.tencent.mm.network.v
    //   655	7	9	localException9	java.lang.Exception
    //   917	7	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   302	307	339	java/lang/Exception
    //   432	437	459	java/lang/Exception
    //   442	447	459	java/lang/Exception
    //   522	530	655	java/lang/Exception
    //   535	544	655	java/lang/Exception
    //   551	576	655	java/lang/Exception
    //   608	652	655	java/lang/Exception
    //   689	694	717	java/lang/Exception
    //   699	704	717	java/lang/Exception
    //   709	714	717	java/lang/Exception
    //   576	581	761	java/lang/Exception
    //   586	591	761	java/lang/Exception
    //   596	601	761	java/lang/Exception
    //   238	246	805	finally
    //   821	826	854	java/lang/Exception
    //   831	836	854	java/lang/Exception
    //   841	846	854	java/lang/Exception
    //   246	302	898	finally
    //   383	396	898	finally
    //   398	410	898	finally
    //   415	432	909	finally
    //   503	520	909	finally
    //   522	530	917	finally
    //   535	544	917	finally
    //   551	576	917	finally
    //   608	652	917	finally
    //   665	684	930	finally
    //   238	246	935	java/lang/Exception
    //   246	302	949	java/lang/Exception
    //   383	396	949	java/lang/Exception
    //   398	410	949	java/lang/Exception
    //   415	432	960	java/lang/Exception
    //   503	520	960	java/lang/Exception
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77909);
    if (this.frY.frR)
    {
      AppMethodBeat.o(77909);
      return false;
    }
    if ((this.frX) || (bo.isNullOrNil(this.frV)))
    {
      this.frY.frP.cv(4, -1);
      AppMethodBeat.o(77909);
      return false;
    }
    ab.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.frE.getUsername() + " urltime:" + this.frZ.Mm());
    if (ao.a.flJ != null) {
      ao.a.flJ.cq((int)com.tencent.mm.vfs.e.avI(this.frW), 0);
    }
    this.frY.frU.e(new e.a(this.frY, this.frY.frB, this.frV, this.frW));
    AppMethodBeat.o(77909);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.e.b
 * JD-Core Version:    0.7.0.1
 */