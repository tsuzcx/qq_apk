package com.tencent.mm.modelavatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class f$c
  extends f.a
{
  boolean djI;
  public j orW;
  public String osq;
  String osr;
  public boolean oss;
  private com.tencent.mm.compatible.util.f.a osu;
  
  public f$c(f paramf, j paramj)
  {
    super(f.a(paramf));
    AppMethodBeat.i(150271);
    this.orW = null;
    this.osq = null;
    this.oss = true;
    this.djI = false;
    this.orW = paramj;
    q.bFp();
    this.osq = AvatarStorage.Q(paramj.getUsername(), true);
    this.osr = (this.osq + ".tmp");
    this.osu = new com.tencent.mm.compatible.util.f.a();
    AppMethodBeat.o(150271);
  }
  
  /* Error */
  public final boolean doInBackground()
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 39	com/tencent/mm/modelavatar/f$c:orW	Lcom/tencent/mm/modelavatar/j;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 93
    //   14: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 39	com/tencent/mm/modelavatar/f$c:orW	Lcom/tencent/mm/modelavatar/j;
    //   23: invokevirtual 96	com/tencent/mm/modelavatar/j:bFw	()Ljava/lang/String;
    //   26: astore 6
    //   28: ldc 98
    //   30: invokestatic 104	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   33: checkcast 98	com/tencent/mm/plugin/emoji/c/c
    //   36: invokeinterface 107 1 0
    //   41: istore_3
    //   42: ldc 109
    //   44: invokestatic 104	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   47: checkcast 109	com/tencent/mm/plugin/expt/b/c
    //   50: getstatic 115	com/tencent/mm/plugin/expt/b/c$a:yUS	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   53: iconst_0
    //   54: invokeinterface 118 3 0
    //   59: istore 4
    //   61: aload_0
    //   62: getfield 23	com/tencent/mm/modelavatar/f$c:ost	Lcom/tencent/mm/modelavatar/f;
    //   65: invokestatic 122	com/tencent/mm/modelavatar/f:b	(Lcom/tencent/mm/modelavatar/f;)Z
    //   68: ifeq +1127 -> 1195
    //   71: iload_3
    //   72: ifeq +1123 -> 1195
    //   75: iload 4
    //   77: ifeq +1118 -> 1195
    //   80: ldc 124
    //   82: ldc 126
    //   84: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 6
    //   89: ldc 133
    //   91: invokevirtual 139	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +327 -> 421
    //   97: new 65	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   104: aload 6
    //   106: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 141
    //   111: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 5
    //   119: getstatic 147	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   122: sipush 138
    //   125: bipush 60
    //   127: invokevirtual 151	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   130: aload 5
    //   132: astore 6
    //   134: invokestatic 155	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   137: invokevirtual 160	com/tencent/mm/kernel/b:aZN	()Z
    //   140: ifeq +1047 -> 1187
    //   143: new 65	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 162
    //   149: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: getstatic 171	com/tencent/mm/plugin/comm/c$h:host_weixin_qq_com	I
    //   155: invokestatic 177	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   158: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 179
    //   163: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 5
    //   171: getstatic 184	com/tencent/mm/protocal/d:Yxh	I
    //   174: istore_1
    //   175: invokestatic 155	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   178: pop
    //   179: aload 5
    //   181: iconst_4
    //   182: anewarray 186	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: iload_1
    //   188: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: invokestatic 196	com/tencent/mm/kernel/b:getUin	()I
    //   197: invokestatic 201	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: invokestatic 207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   206: invokestatic 213	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
    //   209: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_3
    //   215: getstatic 219	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   218: invokevirtual 224	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getCompatMixStrength	()I
    //   221: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: aastore
    //   225: invokestatic 228	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: astore 7
    //   230: ldc 124
    //   232: ldc 230
    //   234: iconst_3
    //   235: anewarray 186	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield 39	com/tencent/mm/modelavatar/f$c:orW	Lcom/tencent/mm/modelavatar/j;
    //   244: invokevirtual 57	com/tencent/mm/modelavatar/j:getUsername	()Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload 7
    //   252: aastore
    //   253: dup
    //   254: iconst_2
    //   255: aload 6
    //   257: aastore
    //   258: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_0
    //   262: iconst_1
    //   263: putfield 43	com/tencent/mm/modelavatar/f$c:oss	Z
    //   266: ldc 109
    //   268: invokestatic 104	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   271: checkcast 109	com/tencent/mm/plugin/expt/b/c
    //   274: getstatic 237	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   277: iconst_0
    //   278: invokeinterface 118 3 0
    //   283: ifeq +164 -> 447
    //   286: aload 6
    //   288: invokestatic 243	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
    //   291: astore 5
    //   293: ldc 109
    //   295: invokestatic 104	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   298: checkcast 109	com/tencent/mm/plugin/expt/b/c
    //   301: getstatic 246	com/tencent/mm/plugin/expt/b/c$a:zpP	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   304: iconst_0
    //   305: invokeinterface 118 3 0
    //   310: istore_3
    //   311: aload 5
    //   313: checkcast 248	com/tencent/mm/network/aa
    //   316: iload_3
    //   317: putfield 251	com/tencent/mm/network/aa:ppt	Z
    //   320: aload 5
    //   322: checkcast 248	com/tencent/mm/network/aa
    //   325: sipush 1223
    //   328: putfield 254	com/tencent/mm/network/aa:pps	I
    //   331: aload 5
    //   333: astore 8
    //   335: aload 8
    //   337: ldc_w 256
    //   340: invokeinterface 261 2 0
    //   345: aload 8
    //   347: ldc_w 263
    //   350: aload 7
    //   352: invokeinterface 266 3 0
    //   357: aload 8
    //   359: sipush 5000
    //   362: invokeinterface 269 2 0
    //   367: aload 8
    //   369: sipush 5000
    //   372: invokeinterface 272 2 0
    //   377: aload 8
    //   379: invokestatic 275	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/z;)I
    //   382: ifeq +121 -> 503
    //   385: ldc 124
    //   387: ldc_w 277
    //   390: iconst_1
    //   391: anewarray 186	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload 6
    //   398: aastore
    //   399: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 8
    //   404: ifnull +10 -> 414
    //   407: aload 8
    //   409: invokeinterface 283 1 0
    //   414: ldc 93
    //   416: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: iconst_1
    //   420: ireturn
    //   421: new 65	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   428: aload 6
    //   430: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 285
    //   436: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: astore 5
    //   444: goto -325 -> 119
    //   447: aload 6
    //   449: aconst_null
    //   450: invokestatic 288	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   453: astore 8
    //   455: goto -120 -> 335
    //   458: astore 5
    //   460: ldc 124
    //   462: ldc_w 290
    //   465: iconst_1
    //   466: anewarray 186	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 5
    //   473: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: aastore
    //   477: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: ldc 124
    //   482: ldc_w 298
    //   485: iconst_1
    //   486: anewarray 186	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: aload 5
    //   493: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   496: aastore
    //   497: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: goto -86 -> 414
    //   503: aload 8
    //   505: ldc_w 303
    //   508: iconst_0
    //   509: invokeinterface 307 3 0
    //   514: iconst_1
    //   515: if_icmpne +70 -> 585
    //   518: iconst_1
    //   519: istore_3
    //   520: aload_0
    //   521: iload_3
    //   522: putfield 45	com/tencent/mm/modelavatar/f$c:djI	Z
    //   525: aload 8
    //   527: invokeinterface 311 1 0
    //   532: astore 5
    //   534: aload 5
    //   536: ifnonnull +99 -> 635
    //   539: ldc 124
    //   541: ldc_w 313
    //   544: iconst_1
    //   545: anewarray 186	java/lang/Object
    //   548: dup
    //   549: iconst_0
    //   550: aload 6
    //   552: aastore
    //   553: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: aload 8
    //   558: ifnull +10 -> 568
    //   561: aload 8
    //   563: invokeinterface 283 1 0
    //   568: aload 5
    //   570: ifnull +8 -> 578
    //   573: aload 5
    //   575: invokevirtual 318	java/io/InputStream:close	()V
    //   578: ldc 93
    //   580: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   583: iconst_1
    //   584: ireturn
    //   585: iconst_0
    //   586: istore_3
    //   587: goto -67 -> 520
    //   590: astore 5
    //   592: ldc 124
    //   594: ldc_w 290
    //   597: iconst_1
    //   598: anewarray 186	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: aload 5
    //   605: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   608: aastore
    //   609: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: ldc 124
    //   614: ldc_w 298
    //   617: iconst_1
    //   618: anewarray 186	java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: aload 5
    //   625: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   628: aastore
    //   629: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: goto -54 -> 578
    //   635: sipush 1024
    //   638: newarray byte
    //   640: astore 7
    //   642: aload_0
    //   643: getfield 79	com/tencent/mm/modelavatar/f$c:osr	Ljava/lang/String;
    //   646: iconst_0
    //   647: invokestatic 324	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   650: astore 6
    //   652: iconst_0
    //   653: istore_1
    //   654: aload 5
    //   656: aload 7
    //   658: invokevirtual 328	java/io/InputStream:read	([B)I
    //   661: istore_2
    //   662: iload_2
    //   663: iconst_m1
    //   664: if_icmpeq +19 -> 683
    //   667: aload 6
    //   669: aload 7
    //   671: iconst_0
    //   672: iload_2
    //   673: invokevirtual 334	java/io/OutputStream:write	([BII)V
    //   676: iload_1
    //   677: iload_2
    //   678: iadd
    //   679: istore_1
    //   680: goto -26 -> 654
    //   683: iload_1
    //   684: aload 8
    //   686: ldc_w 336
    //   689: aload 8
    //   691: invokeinterface 339 1 0
    //   696: invokeinterface 307 3 0
    //   701: if_icmpne +47 -> 748
    //   704: aload_0
    //   705: iconst_0
    //   706: putfield 43	com/tencent/mm/modelavatar/f$c:oss	Z
    //   709: aload 8
    //   711: ifnull +10 -> 721
    //   714: aload 8
    //   716: invokeinterface 283 1 0
    //   721: aload 5
    //   723: ifnull +8 -> 731
    //   726: aload 5
    //   728: invokevirtual 318	java/io/InputStream:close	()V
    //   731: aload 6
    //   733: ifnull +8 -> 741
    //   736: aload 6
    //   738: invokevirtual 340	java/io/OutputStream:close	()V
    //   741: ldc 93
    //   743: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   746: iconst_1
    //   747: ireturn
    //   748: ldc 124
    //   750: ldc_w 342
    //   753: iconst_3
    //   754: anewarray 186	java/lang/Object
    //   757: dup
    //   758: iconst_0
    //   759: iload_1
    //   760: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: aastore
    //   764: dup
    //   765: iconst_1
    //   766: aload 8
    //   768: ldc_w 336
    //   771: invokeinterface 346 2 0
    //   776: aastore
    //   777: dup
    //   778: iconst_2
    //   779: aload 8
    //   781: invokeinterface 339 1 0
    //   786: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   789: aastore
    //   790: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   793: goto -84 -> 709
    //   796: astore 9
    //   798: aload 6
    //   800: astore 7
    //   802: aload 5
    //   804: astore 6
    //   806: aload 9
    //   808: astore 5
    //   810: ldc 124
    //   812: ldc_w 290
    //   815: iconst_1
    //   816: anewarray 186	java/lang/Object
    //   819: dup
    //   820: iconst_0
    //   821: aload 5
    //   823: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   826: aastore
    //   827: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   830: aload 8
    //   832: ifnull +10 -> 842
    //   835: aload 8
    //   837: invokeinterface 283 1 0
    //   842: aload 6
    //   844: ifnull +8 -> 852
    //   847: aload 6
    //   849: invokevirtual 318	java/io/InputStream:close	()V
    //   852: aload 7
    //   854: ifnull -113 -> 741
    //   857: aload 7
    //   859: invokevirtual 340	java/io/OutputStream:close	()V
    //   862: goto -121 -> 741
    //   865: astore 5
    //   867: ldc 124
    //   869: ldc_w 290
    //   872: iconst_1
    //   873: anewarray 186	java/lang/Object
    //   876: dup
    //   877: iconst_0
    //   878: aload 5
    //   880: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   883: aastore
    //   884: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   887: ldc 124
    //   889: ldc_w 298
    //   892: iconst_1
    //   893: anewarray 186	java/lang/Object
    //   896: dup
    //   897: iconst_0
    //   898: aload 5
    //   900: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   903: aastore
    //   904: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: goto -166 -> 741
    //   910: astore 5
    //   912: ldc 124
    //   914: ldc_w 290
    //   917: iconst_1
    //   918: anewarray 186	java/lang/Object
    //   921: dup
    //   922: iconst_0
    //   923: aload 5
    //   925: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   928: aastore
    //   929: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   932: ldc 124
    //   934: ldc_w 298
    //   937: iconst_1
    //   938: anewarray 186	java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: aload 5
    //   945: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   948: aastore
    //   949: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   952: goto -211 -> 741
    //   955: astore 5
    //   957: aconst_null
    //   958: astore 6
    //   960: aconst_null
    //   961: astore 7
    //   963: aconst_null
    //   964: astore 8
    //   966: aload 8
    //   968: ifnull +10 -> 978
    //   971: aload 8
    //   973: invokeinterface 283 1 0
    //   978: aload 6
    //   980: ifnull +8 -> 988
    //   983: aload 6
    //   985: invokevirtual 318	java/io/InputStream:close	()V
    //   988: aload 7
    //   990: ifnull +8 -> 998
    //   993: aload 7
    //   995: invokevirtual 340	java/io/OutputStream:close	()V
    //   998: ldc 93
    //   1000: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1003: aload 5
    //   1005: athrow
    //   1006: astore 6
    //   1008: ldc 124
    //   1010: ldc_w 290
    //   1013: iconst_1
    //   1014: anewarray 186	java/lang/Object
    //   1017: dup
    //   1018: iconst_0
    //   1019: aload 6
    //   1021: invokestatic 296	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1024: aastore
    //   1025: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1028: ldc 124
    //   1030: ldc_w 298
    //   1033: iconst_1
    //   1034: anewarray 186	java/lang/Object
    //   1037: dup
    //   1038: iconst_0
    //   1039: aload 6
    //   1041: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1044: aastore
    //   1045: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1048: goto -50 -> 998
    //   1051: astore 9
    //   1053: aconst_null
    //   1054: astore 6
    //   1056: aconst_null
    //   1057: astore 7
    //   1059: aload 5
    //   1061: astore 8
    //   1063: aload 9
    //   1065: astore 5
    //   1067: goto -101 -> 966
    //   1070: astore 5
    //   1072: aconst_null
    //   1073: astore 6
    //   1075: aconst_null
    //   1076: astore 7
    //   1078: goto -112 -> 966
    //   1081: astore 9
    //   1083: aload 5
    //   1085: astore 6
    //   1087: aconst_null
    //   1088: astore 7
    //   1090: aload 9
    //   1092: astore 5
    //   1094: goto -128 -> 966
    //   1097: astore 10
    //   1099: aload 5
    //   1101: astore 7
    //   1103: aload 6
    //   1105: astore 9
    //   1107: aload 10
    //   1109: astore 5
    //   1111: aload 7
    //   1113: astore 6
    //   1115: aload 9
    //   1117: astore 7
    //   1119: goto -153 -> 966
    //   1122: astore 5
    //   1124: goto -158 -> 966
    //   1127: astore 5
    //   1129: aconst_null
    //   1130: astore 6
    //   1132: aconst_null
    //   1133: astore 7
    //   1135: aconst_null
    //   1136: astore 8
    //   1138: goto -328 -> 810
    //   1141: astore 9
    //   1143: aconst_null
    //   1144: astore 6
    //   1146: aconst_null
    //   1147: astore 7
    //   1149: aload 5
    //   1151: astore 8
    //   1153: aload 9
    //   1155: astore 5
    //   1157: goto -347 -> 810
    //   1160: astore 5
    //   1162: aconst_null
    //   1163: astore 6
    //   1165: aconst_null
    //   1166: astore 7
    //   1168: goto -358 -> 810
    //   1171: astore 9
    //   1173: aload 5
    //   1175: astore 6
    //   1177: aconst_null
    //   1178: astore 7
    //   1180: aload 9
    //   1182: astore 5
    //   1184: goto -374 -> 810
    //   1187: ldc_w 348
    //   1190: astore 7
    //   1192: goto -962 -> 230
    //   1195: goto -1061 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1198	0	this	c
    //   174	586	1	i	int
    //   661	18	2	j	int
    //   41	546	3	bool1	boolean
    //   59	17	4	bool2	boolean
    //   117	326	5	localObject1	java.lang.Object
    //   458	34	5	localException1	java.lang.Exception
    //   532	42	5	localInputStream	java.io.InputStream
    //   590	213	5	localException2	java.lang.Exception
    //   808	14	5	localObject2	java.lang.Object
    //   865	34	5	localException3	java.lang.Exception
    //   910	34	5	localException4	java.lang.Exception
    //   955	105	5	localObject3	java.lang.Object
    //   1065	1	5	localObject4	java.lang.Object
    //   1070	14	5	localObject5	java.lang.Object
    //   1092	18	5	localObject6	java.lang.Object
    //   1122	1	5	localObject7	java.lang.Object
    //   1127	23	5	localException5	java.lang.Exception
    //   1155	1	5	localObject8	java.lang.Object
    //   1160	14	5	localException6	java.lang.Exception
    //   1182	1	5	localObject9	java.lang.Object
    //   26	958	6	localObject10	java.lang.Object
    //   1006	34	6	localException7	java.lang.Exception
    //   1054	122	6	localObject11	java.lang.Object
    //   228	963	7	localObject12	java.lang.Object
    //   333	819	8	localObject13	java.lang.Object
    //   796	11	9	localException8	java.lang.Exception
    //   1051	13	9	localObject14	java.lang.Object
    //   1081	10	9	localObject15	java.lang.Object
    //   1105	11	9	localObject16	java.lang.Object
    //   1141	13	9	localException9	java.lang.Exception
    //   1171	10	9	localException10	java.lang.Exception
    //   1097	11	10	localObject17	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   407	414	458	java/lang/Exception
    //   561	568	590	java/lang/Exception
    //   573	578	590	java/lang/Exception
    //   654	662	796	java/lang/Exception
    //   667	676	796	java/lang/Exception
    //   683	709	796	java/lang/Exception
    //   748	793	796	java/lang/Exception
    //   835	842	865	java/lang/Exception
    //   847	852	865	java/lang/Exception
    //   857	862	865	java/lang/Exception
    //   714	721	910	java/lang/Exception
    //   726	731	910	java/lang/Exception
    //   736	741	910	java/lang/Exception
    //   266	293	955	finally
    //   447	455	955	finally
    //   971	978	1006	java/lang/Exception
    //   983	988	1006	java/lang/Exception
    //   993	998	1006	java/lang/Exception
    //   293	331	1051	finally
    //   335	402	1070	finally
    //   503	518	1070	finally
    //   520	534	1070	finally
    //   539	556	1081	finally
    //   635	652	1081	finally
    //   654	662	1097	finally
    //   667	676	1097	finally
    //   683	709	1097	finally
    //   748	793	1097	finally
    //   810	830	1122	finally
    //   266	293	1127	java/lang/Exception
    //   447	455	1127	java/lang/Exception
    //   293	331	1141	java/lang/Exception
    //   335	402	1160	java/lang/Exception
    //   503	518	1160	java/lang/Exception
    //   520	534	1160	java/lang/Exception
    //   539	556	1171	java/lang/Exception
    //   635	652	1171	java/lang/Exception
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(150273);
    if (this.ost.osl)
    {
      AppMethodBeat.o(150273);
      return false;
    }
    if ((this.oss) || (Util.isNullOrNil(this.osq)))
    {
      this.ost.osj.resultCallback(4, -1);
      AppMethodBeat.o(150273);
      return false;
    }
    Log.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.orW.getUsername() + " urltime:" + this.osu.aPY());
    if (az.a.okQ != null) {
      az.a.okQ.eB((int)y.bEl(this.osr), 0);
    }
    f.b(new f.b(this.ost, this.ost.orT, this.osq, this.osr));
    AppMethodBeat.o(150273);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelavatar.f.c
 * JD-Core Version:    0.7.0.1
 */