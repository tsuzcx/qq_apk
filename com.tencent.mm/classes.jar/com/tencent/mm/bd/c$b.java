package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

final class c$b
  implements QueueWorkerThread.ThreadObject
{
  private String fullPath;
  private String imageUrl;
  private c.a jig;
  private boolean success = false;
  private String username;
  
  public c$b(c paramc, String paramString1, String paramString2, c.a parama)
  {
    this.username = paramString1;
    this.imageUrl = paramString2;
    this.jig = parama;
  }
  
  /* Error */
  public final boolean doInBackground()
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 30	com/tencent/mm/bd/c$b:username	Ljava/lang/String;
    //   9: invokestatic 52	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 40
    //   17: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 30	com/tencent/mm/bd/c$b:username	Ljava/lang/String;
    //   27: invokestatic 59	com/tencent/mm/bd/c:Pr	(Ljava/lang/String;)Ljava/lang/String;
    //   30: putfield 61	com/tencent/mm/bd/c$b:fullPath	Ljava/lang/String;
    //   33: invokestatic 67	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
    //   36: invokevirtual 72	com/tencent/mm/kernel/a:azp	()Z
    //   39: ifeq +904 -> 943
    //   42: new 74	java/lang/StringBuilder
    //   45: dup
    //   46: ldc 76
    //   48: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: ldc 80
    //   53: invokestatic 86	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   56: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 92
    //   61: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_2
    //   68: getstatic 102	com/tencent/mm/protocal/d:KyO	I
    //   71: istore_1
    //   72: invokestatic 67	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
    //   75: pop
    //   76: aload_2
    //   77: iconst_4
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload_1
    //   84: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: invokestatic 112	com/tencent/mm/kernel/a:getUin	()I
    //   93: invokestatic 117	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: invokestatic 123	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   102: invokestatic 129	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
    //   105: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: dup
    //   110: iconst_3
    //   111: invokestatic 123	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   114: invokestatic 132	com/tencent/mm/sdk/platformtools/NetStatusUtil:getStrength	(Landroid/content/Context;)I
    //   117: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: astore_2
    //   125: ldc 140
    //   127: ldc 142
    //   129: iconst_3
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield 30	com/tencent/mm/bd/c$b:username	Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_2
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload_0
    //   147: getfield 32	com/tencent/mm/bd/c$b:imageUrl	Ljava/lang/String;
    //   150: aastore
    //   151: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 28	com/tencent/mm/bd/c$b:success	Z
    //   159: ldc 150
    //   161: invokestatic 154	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   164: checkcast 150	com/tencent/mm/plugin/expt/b/b
    //   167: getstatic 160	com/tencent/mm/plugin/expt/b/b$a:skc	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   170: iconst_0
    //   171: invokeinterface 164 3 0
    //   176: pop
    //   177: aload_0
    //   178: getfield 32	com/tencent/mm/bd/c$b:imageUrl	Ljava/lang/String;
    //   181: aconst_null
    //   182: invokestatic 169	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   185: astore 5
    //   187: aload 5
    //   189: astore_3
    //   190: aload_0
    //   191: getfield 32	com/tencent/mm/bd/c$b:imageUrl	Ljava/lang/String;
    //   194: invokestatic 173	com/tencent/mm/network/d:RQ	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
    //   197: astore 4
    //   199: aload 4
    //   201: astore_3
    //   202: aload 4
    //   204: astore 5
    //   206: aload 4
    //   208: ldc 175
    //   210: invokeinterface 180 2 0
    //   215: aload 4
    //   217: astore_3
    //   218: aload 4
    //   220: astore 5
    //   222: aload 4
    //   224: ldc 182
    //   226: aload_2
    //   227: invokeinterface 186 3 0
    //   232: aload 4
    //   234: astore_3
    //   235: aload 4
    //   237: astore 5
    //   239: aload 4
    //   241: sipush 5000
    //   244: invokeinterface 189 2 0
    //   249: aload 4
    //   251: astore_3
    //   252: aload 4
    //   254: astore 5
    //   256: aload 4
    //   258: sipush 5000
    //   261: invokeinterface 192 2 0
    //   266: aload 4
    //   268: astore_3
    //   269: aload 4
    //   271: astore 5
    //   273: aload 4
    //   275: checkcast 194	com/tencent/mm/network/z
    //   278: sipush 1196
    //   281: putfield 197	com/tencent/mm/network/z:jFq	I
    //   284: aload 4
    //   286: astore_3
    //   287: aload 4
    //   289: astore 5
    //   291: aload 4
    //   293: invokestatic 200	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/y;)I
    //   296: ifeq +64 -> 360
    //   299: aload 4
    //   301: astore_3
    //   302: aload 4
    //   304: astore 5
    //   306: ldc 140
    //   308: ldc 202
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_0
    //   317: getfield 32	com/tencent/mm/bd/c$b:imageUrl	Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: aload 4
    //   326: invokeinterface 208 1 0
    //   331: ldc 40
    //   333: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: iconst_1
    //   337: ireturn
    //   338: astore_2
    //   339: ldc 140
    //   341: ldc 210
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: aload_2
    //   350: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: goto -26 -> 331
    //   360: aload 4
    //   362: astore_3
    //   363: aload 4
    //   365: astore 5
    //   367: aload 4
    //   369: invokeinterface 218 1 0
    //   374: astore_2
    //   375: aload_2
    //   376: astore 5
    //   378: aload 5
    //   380: ifnonnull +89 -> 469
    //   383: ldc 140
    //   385: ldc 220
    //   387: iconst_1
    //   388: anewarray 4	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: aload_0
    //   394: getfield 32	com/tencent/mm/bd/c$b:imageUrl	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload 4
    //   403: invokeinterface 208 1 0
    //   408: aload 5
    //   410: ifnull +8 -> 418
    //   413: aload 5
    //   415: invokevirtual 225	java/io/InputStream:close	()V
    //   418: ldc 40
    //   420: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: iconst_1
    //   424: ireturn
    //   425: astore_2
    //   426: ldc 140
    //   428: ldc 210
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload_2
    //   437: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   440: aastore
    //   441: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: goto -36 -> 408
    //   447: astore_2
    //   448: ldc 140
    //   450: ldc 210
    //   452: iconst_1
    //   453: anewarray 4	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload_2
    //   459: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   462: aastore
    //   463: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: goto -48 -> 418
    //   469: sipush 1024
    //   472: newarray byte
    //   474: astore_3
    //   475: new 74	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   482: aload_0
    //   483: getfield 61	com/tencent/mm/bd/c$b:fullPath	Ljava/lang/String;
    //   486: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc 228
    //   491: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: iconst_0
    //   498: invokestatic 234	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   501: astore_2
    //   502: aload 5
    //   504: aload_3
    //   505: invokevirtual 238	java/io/InputStream:read	([B)I
    //   508: istore_1
    //   509: iload_1
    //   510: iconst_m1
    //   511: if_icmpeq +80 -> 591
    //   514: aload_2
    //   515: aload_3
    //   516: iconst_0
    //   517: iload_1
    //   518: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   521: goto -19 -> 502
    //   524: astore 6
    //   526: aload_2
    //   527: astore_3
    //   528: aload 6
    //   530: astore_2
    //   531: ldc 140
    //   533: ldc 210
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload_2
    //   542: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   545: aastore
    //   546: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: aload_0
    //   550: iconst_0
    //   551: putfield 28	com/tencent/mm/bd/c$b:success	Z
    //   554: aload 4
    //   556: ifnull +10 -> 566
    //   559: aload 4
    //   561: invokeinterface 208 1 0
    //   566: aload 5
    //   568: ifnull +8 -> 576
    //   571: aload 5
    //   573: invokevirtual 225	java/io/InputStream:close	()V
    //   576: aload_3
    //   577: ifnull +7 -> 584
    //   580: aload_3
    //   581: invokevirtual 245	java/io/OutputStream:close	()V
    //   584: ldc 40
    //   586: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   589: iconst_1
    //   590: ireturn
    //   591: aload_0
    //   592: iconst_1
    //   593: putfield 28	com/tencent/mm/bd/c$b:success	Z
    //   596: aload 4
    //   598: invokeinterface 208 1 0
    //   603: aload 5
    //   605: ifnull +8 -> 613
    //   608: aload 5
    //   610: invokevirtual 225	java/io/InputStream:close	()V
    //   613: aload_2
    //   614: ifnull -30 -> 584
    //   617: aload_2
    //   618: invokevirtual 245	java/io/OutputStream:close	()V
    //   621: goto -37 -> 584
    //   624: astore_2
    //   625: ldc 140
    //   627: ldc 210
    //   629: iconst_1
    //   630: anewarray 4	java/lang/Object
    //   633: dup
    //   634: iconst_0
    //   635: aload_2
    //   636: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   639: aastore
    //   640: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: goto -59 -> 584
    //   646: astore_3
    //   647: ldc 140
    //   649: ldc 210
    //   651: iconst_1
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: aload_3
    //   658: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   661: aastore
    //   662: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   665: goto -62 -> 603
    //   668: astore_3
    //   669: ldc 140
    //   671: ldc 210
    //   673: iconst_1
    //   674: anewarray 4	java/lang/Object
    //   677: dup
    //   678: iconst_0
    //   679: aload_3
    //   680: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   683: aastore
    //   684: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   687: goto -74 -> 613
    //   690: astore_2
    //   691: ldc 140
    //   693: ldc 210
    //   695: iconst_1
    //   696: anewarray 4	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: aload_2
    //   702: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   705: aastore
    //   706: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: goto -143 -> 566
    //   712: astore_2
    //   713: ldc 140
    //   715: ldc 210
    //   717: iconst_1
    //   718: anewarray 4	java/lang/Object
    //   721: dup
    //   722: iconst_0
    //   723: aload_2
    //   724: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   727: aastore
    //   728: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: goto -155 -> 576
    //   734: astore_2
    //   735: ldc 140
    //   737: ldc 210
    //   739: iconst_1
    //   740: anewarray 4	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload_2
    //   746: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   749: aastore
    //   750: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   753: goto -169 -> 584
    //   756: astore_2
    //   757: aconst_null
    //   758: astore 5
    //   760: aconst_null
    //   761: astore_3
    //   762: aconst_null
    //   763: astore 4
    //   765: aload 4
    //   767: ifnull +10 -> 777
    //   770: aload 4
    //   772: invokeinterface 208 1 0
    //   777: aload 5
    //   779: ifnull +8 -> 787
    //   782: aload 5
    //   784: invokevirtual 225	java/io/InputStream:close	()V
    //   787: aload_3
    //   788: ifnull +7 -> 795
    //   791: aload_3
    //   792: invokevirtual 245	java/io/OutputStream:close	()V
    //   795: ldc 40
    //   797: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   800: aload_2
    //   801: athrow
    //   802: astore 4
    //   804: ldc 140
    //   806: ldc 210
    //   808: iconst_1
    //   809: anewarray 4	java/lang/Object
    //   812: dup
    //   813: iconst_0
    //   814: aload 4
    //   816: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   819: aastore
    //   820: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   823: goto -46 -> 777
    //   826: astore 4
    //   828: ldc 140
    //   830: ldc 210
    //   832: iconst_1
    //   833: anewarray 4	java/lang/Object
    //   836: dup
    //   837: iconst_0
    //   838: aload 4
    //   840: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   843: aastore
    //   844: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   847: goto -60 -> 787
    //   850: astore_3
    //   851: ldc 140
    //   853: ldc 210
    //   855: iconst_1
    //   856: anewarray 4	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload_3
    //   862: invokestatic 214	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   865: aastore
    //   866: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   869: goto -74 -> 795
    //   872: astore_2
    //   873: aconst_null
    //   874: astore 5
    //   876: aconst_null
    //   877: astore 6
    //   879: aload_3
    //   880: astore 4
    //   882: aload 6
    //   884: astore_3
    //   885: goto -120 -> 765
    //   888: astore_2
    //   889: aconst_null
    //   890: astore_3
    //   891: goto -126 -> 765
    //   894: astore 6
    //   896: aload_2
    //   897: astore_3
    //   898: aload 6
    //   900: astore_2
    //   901: goto -136 -> 765
    //   904: astore_2
    //   905: goto -140 -> 765
    //   908: astore_2
    //   909: aconst_null
    //   910: astore 5
    //   912: aconst_null
    //   913: astore_3
    //   914: aconst_null
    //   915: astore 4
    //   917: goto -386 -> 531
    //   920: astore_2
    //   921: aconst_null
    //   922: astore 6
    //   924: aconst_null
    //   925: astore_3
    //   926: aload 5
    //   928: astore 4
    //   930: aload 6
    //   932: astore 5
    //   934: goto -403 -> 531
    //   937: astore_2
    //   938: aconst_null
    //   939: astore_3
    //   940: goto -409 -> 531
    //   943: ldc 247
    //   945: astore_2
    //   946: goto -821 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	b
    //   71	447	1	i	int
    //   67	160	2	str1	String
    //   338	12	2	localException1	java.lang.Exception
    //   374	2	2	localInputStream	java.io.InputStream
    //   425	12	2	localException2	java.lang.Exception
    //   447	12	2	localException3	java.lang.Exception
    //   501	117	2	localObject1	Object
    //   624	12	2	localException4	java.lang.Exception
    //   690	12	2	localException5	java.lang.Exception
    //   712	12	2	localException6	java.lang.Exception
    //   734	12	2	localException7	java.lang.Exception
    //   756	45	2	localObject2	Object
    //   872	1	2	localObject3	Object
    //   888	9	2	localObject4	Object
    //   900	1	2	localObject5	Object
    //   904	1	2	localObject6	Object
    //   908	1	2	localException8	java.lang.Exception
    //   920	1	2	localException9	java.lang.Exception
    //   937	1	2	localException10	java.lang.Exception
    //   945	1	2	str2	String
    //   189	392	3	localObject7	Object
    //   646	12	3	localException11	java.lang.Exception
    //   668	12	3	localException12	java.lang.Exception
    //   761	31	3	localObject8	Object
    //   850	30	3	localException13	java.lang.Exception
    //   884	56	3	localObject9	Object
    //   197	574	4	localz	com.tencent.mm.network.z
    //   802	13	4	localException14	java.lang.Exception
    //   826	13	4	localException15	java.lang.Exception
    //   880	49	4	localObject10	Object
    //   185	748	5	localObject11	Object
    //   524	5	6	localException16	java.lang.Exception
    //   877	6	6	localObject12	Object
    //   894	5	6	localObject13	Object
    //   922	9	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   324	331	338	java/lang/Exception
    //   401	408	425	java/lang/Exception
    //   413	418	447	java/lang/Exception
    //   502	509	524	java/lang/Exception
    //   514	521	524	java/lang/Exception
    //   591	596	524	java/lang/Exception
    //   617	621	624	java/lang/Exception
    //   596	603	646	java/lang/Exception
    //   608	613	668	java/lang/Exception
    //   559	566	690	java/lang/Exception
    //   571	576	712	java/lang/Exception
    //   580	584	734	java/lang/Exception
    //   159	187	756	finally
    //   770	777	802	java/lang/Exception
    //   782	787	826	java/lang/Exception
    //   791	795	850	java/lang/Exception
    //   190	199	872	finally
    //   206	215	872	finally
    //   222	232	872	finally
    //   239	249	872	finally
    //   256	266	872	finally
    //   273	284	872	finally
    //   291	299	872	finally
    //   306	324	872	finally
    //   367	375	872	finally
    //   383	401	888	finally
    //   469	502	888	finally
    //   502	509	894	finally
    //   514	521	894	finally
    //   591	596	894	finally
    //   531	554	904	finally
    //   159	187	908	java/lang/Exception
    //   190	199	920	java/lang/Exception
    //   206	215	920	java/lang/Exception
    //   222	232	920	java/lang/Exception
    //   239	249	920	java/lang/Exception
    //   256	266	920	java/lang/Exception
    //   273	284	920	java/lang/Exception
    //   291	299	920	java/lang/Exception
    //   306	324	920	java/lang/Exception
    //   367	375	920	java/lang/Exception
    //   383	401	937	java/lang/Exception
    //   469	502	937	java/lang/Exception
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(90693);
    if (!this.success)
    {
      this.jig.fI(false);
      AppMethodBeat.o(90693);
      return false;
    }
    s.deleteFile(this.fullPath);
    new o(this.fullPath + ".tmp").am(new o(this.fullPath));
    this.jig.fI(true);
    AppMethodBeat.o(90693);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.c.b
 * JD-Core Version:    0.7.0.1
 */