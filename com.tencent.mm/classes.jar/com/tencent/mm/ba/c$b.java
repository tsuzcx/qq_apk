package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

final class c$b
  implements QueueWorkerThread.ThreadObject
{
  private String fullPath;
  private String imageUrl;
  private c.a oRO;
  private boolean success = false;
  private String username;
  
  public c$b(c paramc, String paramString1, String paramString2, c.a parama)
  {
    this.username = paramString1;
    this.imageUrl = paramString2;
    this.oRO = parama;
  }
  
  /* Error */
  public final boolean doInBackground()
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 30	com/tencent/mm/ba/c$b:username	Ljava/lang/String;
    //   9: invokestatic 52	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 40
    //   17: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 30	com/tencent/mm/ba/c$b:username	Ljava/lang/String;
    //   27: invokestatic 59	com/tencent/mm/ba/c:OO	(Ljava/lang/String;)Ljava/lang/String;
    //   30: putfield 61	com/tencent/mm/ba/c$b:fullPath	Ljava/lang/String;
    //   33: invokestatic 67	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   36: invokevirtual 72	com/tencent/mm/kernel/b:aZN	()Z
    //   39: ifeq +935 -> 974
    //   42: new 74	java/lang/StringBuilder
    //   45: dup
    //   46: ldc 76
    //   48: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: getstatic 85	com/tencent/mm/plugin/messenger/b$e:host_weixin_qq_com	I
    //   54: invokestatic 91	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 97
    //   62: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: getstatic 106	com/tencent/mm/protocal/d:Yxh	I
    //   72: istore_1
    //   73: invokestatic 67	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   76: pop
    //   77: aload_2
    //   78: iconst_4
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: iload_1
    //   85: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: invokestatic 116	com/tencent/mm/kernel/b:getUin	()I
    //   94: invokestatic 121	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: invokestatic 127	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   103: invokestatic 133	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
    //   106: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_3
    //   112: getstatic 139	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   115: invokevirtual 144	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getCompatMixStrength	()I
    //   118: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: astore_2
    //   126: ldc 152
    //   128: ldc 154
    //   130: iconst_3
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: getfield 30	com/tencent/mm/ba/c$b:username	Ljava/lang/String;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload_2
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: aload_0
    //   148: getfield 32	com/tencent/mm/ba/c$b:imageUrl	Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 28	com/tencent/mm/ba/c$b:success	Z
    //   160: ldc 162
    //   162: invokestatic 166	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   165: checkcast 162	com/tencent/mm/plugin/expt/b/c
    //   168: getstatic 172	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   171: iconst_0
    //   172: invokeinterface 176 3 0
    //   177: pop
    //   178: aload_0
    //   179: getfield 32	com/tencent/mm/ba/c$b:imageUrl	Ljava/lang/String;
    //   182: aconst_null
    //   183: invokestatic 181	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   186: astore 5
    //   188: aload 5
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 32	com/tencent/mm/ba/c$b:imageUrl	Ljava/lang/String;
    //   195: invokestatic 185	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
    //   198: astore 4
    //   200: aload 4
    //   202: astore_3
    //   203: aload 4
    //   205: astore 5
    //   207: aload 4
    //   209: ldc 187
    //   211: invokeinterface 192 2 0
    //   216: aload 4
    //   218: astore_3
    //   219: aload 4
    //   221: astore 5
    //   223: aload 4
    //   225: ldc 194
    //   227: aload_2
    //   228: invokeinterface 198 3 0
    //   233: aload 4
    //   235: astore_3
    //   236: aload 4
    //   238: astore 5
    //   240: aload 4
    //   242: sipush 5000
    //   245: invokeinterface 201 2 0
    //   250: aload 4
    //   252: astore_3
    //   253: aload 4
    //   255: astore 5
    //   257: aload 4
    //   259: sipush 5000
    //   262: invokeinterface 204 2 0
    //   267: aload 4
    //   269: astore_3
    //   270: aload 4
    //   272: astore 5
    //   274: aload 4
    //   276: instanceof 206
    //   279: ifeq +21 -> 300
    //   282: aload 4
    //   284: astore_3
    //   285: aload 4
    //   287: astore 5
    //   289: aload 4
    //   291: checkcast 206	com/tencent/mm/network/aa
    //   294: sipush 1196
    //   297: putfield 209	com/tencent/mm/network/aa:pps	I
    //   300: aload 4
    //   302: astore_3
    //   303: aload 4
    //   305: astore 5
    //   307: aload 4
    //   309: invokestatic 212	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/z;)I
    //   312: ifeq +69 -> 381
    //   315: aload 4
    //   317: astore_3
    //   318: aload 4
    //   320: astore 5
    //   322: ldc 152
    //   324: ldc 214
    //   326: iconst_1
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_0
    //   333: getfield 32	com/tencent/mm/ba/c$b:imageUrl	Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload 4
    //   342: ifnull +10 -> 352
    //   345: aload 4
    //   347: invokeinterface 220 1 0
    //   352: ldc 40
    //   354: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: iconst_1
    //   358: ireturn
    //   359: astore_2
    //   360: ldc 152
    //   362: ldc 222
    //   364: iconst_1
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload_2
    //   371: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   374: aastore
    //   375: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: goto -26 -> 352
    //   381: aload 4
    //   383: astore_3
    //   384: aload 4
    //   386: astore 5
    //   388: aload 4
    //   390: invokeinterface 230 1 0
    //   395: astore_2
    //   396: aload_2
    //   397: astore 5
    //   399: aload 5
    //   401: ifnonnull +94 -> 495
    //   404: ldc 152
    //   406: ldc 232
    //   408: iconst_1
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: aload_0
    //   415: getfield 32	com/tencent/mm/ba/c$b:imageUrl	Ljava/lang/String;
    //   418: aastore
    //   419: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: aload 4
    //   424: ifnull +10 -> 434
    //   427: aload 4
    //   429: invokeinterface 220 1 0
    //   434: aload 5
    //   436: ifnull +8 -> 444
    //   439: aload 5
    //   441: invokevirtual 237	java/io/InputStream:close	()V
    //   444: ldc 40
    //   446: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_1
    //   450: ireturn
    //   451: astore_2
    //   452: ldc 152
    //   454: ldc 222
    //   456: iconst_1
    //   457: anewarray 4	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: aload_2
    //   463: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   466: aastore
    //   467: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: goto -36 -> 434
    //   473: astore_2
    //   474: ldc 152
    //   476: ldc 222
    //   478: iconst_1
    //   479: anewarray 4	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: aload_2
    //   485: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   488: aastore
    //   489: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   492: goto -48 -> 444
    //   495: sipush 1024
    //   498: newarray byte
    //   500: astore_3
    //   501: new 74	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   508: aload_0
    //   509: getfield 61	com/tencent/mm/ba/c$b:fullPath	Ljava/lang/String;
    //   512: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc 240
    //   517: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: iconst_0
    //   524: invokestatic 246	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   527: astore_2
    //   528: aload 5
    //   530: aload_3
    //   531: invokevirtual 250	java/io/InputStream:read	([B)I
    //   534: istore_1
    //   535: iload_1
    //   536: iconst_m1
    //   537: if_icmpeq +80 -> 617
    //   540: aload_2
    //   541: aload_3
    //   542: iconst_0
    //   543: iload_1
    //   544: invokevirtual 256	java/io/OutputStream:write	([BII)V
    //   547: goto -19 -> 528
    //   550: astore 6
    //   552: aload_2
    //   553: astore_3
    //   554: aload 6
    //   556: astore_2
    //   557: ldc 152
    //   559: ldc 222
    //   561: iconst_1
    //   562: anewarray 4	java/lang/Object
    //   565: dup
    //   566: iconst_0
    //   567: aload_2
    //   568: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   571: aastore
    //   572: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   575: aload_0
    //   576: iconst_0
    //   577: putfield 28	com/tencent/mm/ba/c$b:success	Z
    //   580: aload 4
    //   582: ifnull +10 -> 592
    //   585: aload 4
    //   587: invokeinterface 220 1 0
    //   592: aload 5
    //   594: ifnull +8 -> 602
    //   597: aload 5
    //   599: invokevirtual 237	java/io/InputStream:close	()V
    //   602: aload_3
    //   603: ifnull +7 -> 610
    //   606: aload_3
    //   607: invokevirtual 257	java/io/OutputStream:close	()V
    //   610: ldc 40
    //   612: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   615: iconst_1
    //   616: ireturn
    //   617: aload_0
    //   618: iconst_1
    //   619: putfield 28	com/tencent/mm/ba/c$b:success	Z
    //   622: aload 4
    //   624: ifnull +10 -> 634
    //   627: aload 4
    //   629: invokeinterface 220 1 0
    //   634: aload 5
    //   636: ifnull +8 -> 644
    //   639: aload 5
    //   641: invokevirtual 237	java/io/InputStream:close	()V
    //   644: aload_2
    //   645: ifnull -35 -> 610
    //   648: aload_2
    //   649: invokevirtual 257	java/io/OutputStream:close	()V
    //   652: goto -42 -> 610
    //   655: astore_2
    //   656: ldc 152
    //   658: ldc 222
    //   660: iconst_1
    //   661: anewarray 4	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload_2
    //   667: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   670: aastore
    //   671: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: goto -64 -> 610
    //   677: astore_3
    //   678: ldc 152
    //   680: ldc 222
    //   682: iconst_1
    //   683: anewarray 4	java/lang/Object
    //   686: dup
    //   687: iconst_0
    //   688: aload_3
    //   689: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   692: aastore
    //   693: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   696: goto -62 -> 634
    //   699: astore_3
    //   700: ldc 152
    //   702: ldc 222
    //   704: iconst_1
    //   705: anewarray 4	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: aload_3
    //   711: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   714: aastore
    //   715: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: goto -74 -> 644
    //   721: astore_2
    //   722: ldc 152
    //   724: ldc 222
    //   726: iconst_1
    //   727: anewarray 4	java/lang/Object
    //   730: dup
    //   731: iconst_0
    //   732: aload_2
    //   733: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   736: aastore
    //   737: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: goto -148 -> 592
    //   743: astore_2
    //   744: ldc 152
    //   746: ldc 222
    //   748: iconst_1
    //   749: anewarray 4	java/lang/Object
    //   752: dup
    //   753: iconst_0
    //   754: aload_2
    //   755: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   758: aastore
    //   759: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: goto -160 -> 602
    //   765: astore_2
    //   766: ldc 152
    //   768: ldc 222
    //   770: iconst_1
    //   771: anewarray 4	java/lang/Object
    //   774: dup
    //   775: iconst_0
    //   776: aload_2
    //   777: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   780: aastore
    //   781: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   784: goto -174 -> 610
    //   787: astore_2
    //   788: aconst_null
    //   789: astore 5
    //   791: aconst_null
    //   792: astore_3
    //   793: aconst_null
    //   794: astore 4
    //   796: aload 4
    //   798: ifnull +10 -> 808
    //   801: aload 4
    //   803: invokeinterface 220 1 0
    //   808: aload 5
    //   810: ifnull +8 -> 818
    //   813: aload 5
    //   815: invokevirtual 237	java/io/InputStream:close	()V
    //   818: aload_3
    //   819: ifnull +7 -> 826
    //   822: aload_3
    //   823: invokevirtual 257	java/io/OutputStream:close	()V
    //   826: ldc 40
    //   828: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   831: aload_2
    //   832: athrow
    //   833: astore 4
    //   835: ldc 152
    //   837: ldc 222
    //   839: iconst_1
    //   840: anewarray 4	java/lang/Object
    //   843: dup
    //   844: iconst_0
    //   845: aload 4
    //   847: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   850: aastore
    //   851: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   854: goto -46 -> 808
    //   857: astore 4
    //   859: ldc 152
    //   861: ldc 222
    //   863: iconst_1
    //   864: anewarray 4	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload 4
    //   871: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   874: aastore
    //   875: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   878: goto -60 -> 818
    //   881: astore_3
    //   882: ldc 152
    //   884: ldc 222
    //   886: iconst_1
    //   887: anewarray 4	java/lang/Object
    //   890: dup
    //   891: iconst_0
    //   892: aload_3
    //   893: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   896: aastore
    //   897: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: goto -74 -> 826
    //   903: astore_2
    //   904: aconst_null
    //   905: astore 5
    //   907: aconst_null
    //   908: astore 6
    //   910: aload_3
    //   911: astore 4
    //   913: aload 6
    //   915: astore_3
    //   916: goto -120 -> 796
    //   919: astore_2
    //   920: aconst_null
    //   921: astore_3
    //   922: goto -126 -> 796
    //   925: astore 6
    //   927: aload_2
    //   928: astore_3
    //   929: aload 6
    //   931: astore_2
    //   932: goto -136 -> 796
    //   935: astore_2
    //   936: goto -140 -> 796
    //   939: astore_2
    //   940: aconst_null
    //   941: astore 5
    //   943: aconst_null
    //   944: astore_3
    //   945: aconst_null
    //   946: astore 4
    //   948: goto -391 -> 557
    //   951: astore_2
    //   952: aconst_null
    //   953: astore 6
    //   955: aconst_null
    //   956: astore_3
    //   957: aload 5
    //   959: astore 4
    //   961: aload 6
    //   963: astore 5
    //   965: goto -408 -> 557
    //   968: astore_2
    //   969: aconst_null
    //   970: astore_3
    //   971: goto -414 -> 557
    //   974: ldc_w 259
    //   977: astore_2
    //   978: goto -852 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	981	0	this	b
    //   72	472	1	i	int
    //   68	160	2	str1	String
    //   359	12	2	localException1	java.lang.Exception
    //   395	2	2	localInputStream	java.io.InputStream
    //   451	12	2	localException2	java.lang.Exception
    //   473	12	2	localException3	java.lang.Exception
    //   527	122	2	localObject1	Object
    //   655	12	2	localException4	java.lang.Exception
    //   721	12	2	localException5	java.lang.Exception
    //   743	12	2	localException6	java.lang.Exception
    //   765	12	2	localException7	java.lang.Exception
    //   787	45	2	localObject2	Object
    //   903	1	2	localObject3	Object
    //   919	9	2	localObject4	Object
    //   931	1	2	localObject5	Object
    //   935	1	2	localObject6	Object
    //   939	1	2	localException8	java.lang.Exception
    //   951	1	2	localException9	java.lang.Exception
    //   968	1	2	localException10	java.lang.Exception
    //   977	1	2	str2	String
    //   190	417	3	localObject7	Object
    //   677	12	3	localException11	java.lang.Exception
    //   699	12	3	localException12	java.lang.Exception
    //   792	31	3	localObject8	Object
    //   881	30	3	localException13	java.lang.Exception
    //   915	56	3	localObject9	Object
    //   198	604	4	localaa	com.tencent.mm.network.aa
    //   833	13	4	localException14	java.lang.Exception
    //   857	13	4	localException15	java.lang.Exception
    //   911	49	4	localObject10	Object
    //   186	778	5	localObject11	Object
    //   550	5	6	localException16	java.lang.Exception
    //   908	6	6	localObject12	Object
    //   925	5	6	localObject13	Object
    //   953	9	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   345	352	359	java/lang/Exception
    //   427	434	451	java/lang/Exception
    //   439	444	473	java/lang/Exception
    //   528	535	550	java/lang/Exception
    //   540	547	550	java/lang/Exception
    //   617	622	550	java/lang/Exception
    //   648	652	655	java/lang/Exception
    //   627	634	677	java/lang/Exception
    //   639	644	699	java/lang/Exception
    //   585	592	721	java/lang/Exception
    //   597	602	743	java/lang/Exception
    //   606	610	765	java/lang/Exception
    //   160	188	787	finally
    //   801	808	833	java/lang/Exception
    //   813	818	857	java/lang/Exception
    //   822	826	881	java/lang/Exception
    //   191	200	903	finally
    //   207	216	903	finally
    //   223	233	903	finally
    //   240	250	903	finally
    //   257	267	903	finally
    //   274	282	903	finally
    //   289	300	903	finally
    //   307	315	903	finally
    //   322	340	903	finally
    //   388	396	903	finally
    //   404	422	919	finally
    //   495	528	919	finally
    //   528	535	925	finally
    //   540	547	925	finally
    //   617	622	925	finally
    //   557	580	935	finally
    //   160	188	939	java/lang/Exception
    //   191	200	951	java/lang/Exception
    //   207	216	951	java/lang/Exception
    //   223	233	951	java/lang/Exception
    //   240	250	951	java/lang/Exception
    //   257	267	951	java/lang/Exception
    //   274	282	951	java/lang/Exception
    //   289	300	951	java/lang/Exception
    //   307	315	951	java/lang/Exception
    //   322	340	951	java/lang/Exception
    //   388	396	951	java/lang/Exception
    //   404	422	968	java/lang/Exception
    //   495	528	968	java/lang/Exception
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(90693);
    if (!this.success)
    {
      this.oRO.hk(false);
      AppMethodBeat.o(90693);
      return false;
    }
    y.deleteFile(this.fullPath);
    new u(this.fullPath + ".tmp").am(new u(this.fullPath));
    this.oRO.hk(true);
    AppMethodBeat.o(90693);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ba.c.b
 * JD-Core Version:    0.7.0.1
 */