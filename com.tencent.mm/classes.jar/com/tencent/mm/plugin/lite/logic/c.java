package com.tencent.mm.plugin.lite.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.lite.api.a;
import com.tencent.mm.plugin.lite.api.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum c
{
  public Map<Long, a> KaO;
  private m KaP;
  
  static
  {
    AppMethodBeat.i(271409);
    KaN = new c("INSTANCE");
    KaQ = new c[] { KaN };
    AppMethodBeat.o(271409);
  }
  
  private c()
  {
    AppMethodBeat.i(271391);
    this.KaO = new ConcurrentHashMap();
    this.KaP = new m()
    {
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      /* Error */
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/plugin/lite/logic/c$1:KaR	Lcom/tencent/mm/plugin/lite/logic/c;
        //   9: getfield 35	com/tencent/mm/plugin/lite/logic/c:KaO	Ljava/util/Map;
        //   12: lload_1
        //   13: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   16: invokeinterface 47 2 0
        //   21: ifne +9 -> 30
        //   24: ldc 25
        //   26: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_0
        //   31: getfield 14	com/tencent/mm/plugin/lite/logic/c$1:KaR	Lcom/tencent/mm/plugin/lite/logic/c;
        //   34: getfield 35	com/tencent/mm/plugin/lite/logic/c:KaO	Ljava/util/Map;
        //   37: lload_1
        //   38: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   41: invokeinterface 54 2 0
        //   46: checkcast 56	com/tencent/mm/plugin/lite/logic/c$a
        //   49: astore 5
        //   51: aload_3
        //   52: invokestatic 62	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   55: ifeq +88 -> 143
        //   58: aload_0
        //   59: getfield 14	com/tencent/mm/plugin/lite/logic/c$1:KaR	Lcom/tencent/mm/plugin/lite/logic/c;
        //   62: getfield 35	com/tencent/mm/plugin/lite/logic/c:KaO	Ljava/util/Map;
        //   65: lload_1
        //   66: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   69: invokeinterface 65 2 0
        //   74: pop
        //   75: aload 5
        //   77: getfield 69	com/tencent/mm/plugin/lite/logic/c$a:KaS	Ljava/lang/String;
        //   80: ldc 71
        //   82: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   85: ifeq +21 -> 106
        //   88: aload 5
        //   90: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   93: ifnull +13 -> 106
        //   96: aload 5
        //   98: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   101: invokeinterface 85 1 0
        //   106: aload 5
        //   108: getfield 69	com/tencent/mm/plugin/lite/logic/c$a:KaS	Ljava/lang/String;
        //   111: ldc 87
        //   113: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   116: ifeq +21 -> 137
        //   119: aload 5
        //   121: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   124: ifnull +13 -> 137
        //   127: aload 5
        //   129: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   132: invokeinterface 94 1 0
        //   137: ldc 25
        //   139: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   142: return
        //   143: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   146: ldc2_w 101
        //   149: ldc2_w 103
        //   152: lconst_1
        //   153: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   156: aload 5
        //   158: getfield 112	com/tencent/mm/plugin/lite/logic/c$a:KaT	Lcom/tencent/mm/plugin/boots/a/g;
        //   161: astore 6
        //   163: aload_0
        //   164: getfield 14	com/tencent/mm/plugin/lite/logic/c$1:KaR	Lcom/tencent/mm/plugin/lite/logic/c;
        //   167: getfield 35	com/tencent/mm/plugin/lite/logic/c:KaO	Ljava/util/Map;
        //   170: lload_1
        //   171: invokestatic 41	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   174: invokeinterface 65 2 0
        //   179: pop
        //   180: aload 5
        //   182: getfield 69	com/tencent/mm/plugin/lite/logic/c$a:KaS	Ljava/lang/String;
        //   185: ldc 71
        //   187: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   190: ifeq +331 -> 521
        //   193: aload 6
        //   195: getfield 117	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   198: aload 6
        //   200: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   203: aload 6
        //   205: getfield 123	com/tencent/mm/plugin/boots/a/g:vyS	Ljava/lang/String;
        //   208: invokestatic 129	com/tencent/mm/plugin/lite/logic/f:aD	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   211: astore 7
        //   213: ldc 131
        //   215: ldc 133
        //   217: iconst_4
        //   218: anewarray 4	java/lang/Object
        //   221: dup
        //   222: iconst_0
        //   223: aload 6
        //   225: getfield 117	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   228: aastore
        //   229: dup
        //   230: iconst_1
        //   231: aload_3
        //   232: aastore
        //   233: dup
        //   234: iconst_2
        //   235: aload 7
        //   237: aastore
        //   238: dup
        //   239: iconst_3
        //   240: aload 6
        //   242: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   245: aastore
        //   246: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   249: new 140	com/tencent/mm/vfs/u
        //   252: dup
        //   253: aload 7
        //   255: invokespecial 143	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   258: astore 8
        //   260: aload 8
        //   262: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
        //   265: ifne +9 -> 274
        //   268: aload 8
        //   270: invokevirtual 150	com/tencent/mm/vfs/u:jKY	()Z
        //   273: pop
        //   274: aload_3
        //   275: iconst_0
        //   276: invokestatic 156	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
        //   279: aload 7
        //   281: invokestatic 160	com/tencent/mm/plugin/lite/logic/c:jT	(Ljava/lang/String;Ljava/lang/String;)V
        //   284: new 162	com/tencent/liteapp/storage/WxaLiteAppInfo
        //   287: dup
        //   288: invokespecial 163	com/tencent/liteapp/storage/WxaLiteAppInfo:<init>	()V
        //   291: astore_3
        //   292: aload_3
        //   293: aload 6
        //   295: getfield 117	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   298: putfield 164	com/tencent/liteapp/storage/WxaLiteAppInfo:appId	Ljava/lang/String;
        //   301: aload_3
        //   302: aload 7
        //   304: putfield 167	com/tencent/liteapp/storage/WxaLiteAppInfo:path	Ljava/lang/String;
        //   307: aload_3
        //   308: aload 6
        //   310: getfield 170	com/tencent/mm/plugin/boots/a/g:egI	Ljava/lang/String;
        //   313: putfield 171	com/tencent/liteapp/storage/WxaLiteAppInfo:egI	Ljava/lang/String;
        //   316: aload_3
        //   317: aload 5
        //   319: getfield 174	com/tencent/mm/plugin/lite/logic/c$a:KaW	Ljava/lang/String;
        //   322: putfield 177	com/tencent/liteapp/storage/WxaLiteAppInfo:type	Ljava/lang/String;
        //   325: aload_3
        //   326: invokestatic 183	java/lang/System:currentTimeMillis	()J
        //   329: ldc2_w 184
        //   332: ldiv
        //   333: putfield 189	com/tencent/liteapp/storage/WxaLiteAppInfo:egK	J
        //   336: aload_3
        //   337: aload 6
        //   339: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   342: putfield 190	com/tencent/liteapp/storage/WxaLiteAppInfo:egJ	Ljava/lang/String;
        //   345: aload_3
        //   346: aload 6
        //   348: getfield 123	com/tencent/mm/plugin/boots/a/g:vyS	Ljava/lang/String;
        //   351: putfield 193	com/tencent/liteapp/storage/WxaLiteAppInfo:md5	Ljava/lang/String;
        //   354: invokestatic 199	com/tencent/mm/plugin/lite/logic/d:fUi	()Lcom/tencent/mm/plugin/lite/logic/d;
        //   357: pop
        //   358: aload_3
        //   359: invokestatic 202	com/tencent/mm/plugin/lite/logic/d:a	(Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V
        //   362: invokestatic 199	com/tencent/mm/plugin/lite/logic/d:fUi	()Lcom/tencent/mm/plugin/lite/logic/d;
        //   365: pop
        //   366: aload_3
        //   367: invokestatic 205	com/tencent/mm/plugin/lite/logic/d:c	(Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V
        //   370: aload 5
        //   372: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   375: ifnull +14 -> 389
        //   378: aload 5
        //   380: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   383: aload_3
        //   384: invokeinterface 207 2 0
        //   389: ldc 25
        //   391: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   394: return
        //   395: astore_3
        //   396: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   399: sipush 20752
        //   402: ldc 209
        //   404: iconst_1
        //   405: iconst_1
        //   406: invokevirtual 212	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   409: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   412: ldc2_w 101
        //   415: ldc2_w 213
        //   418: lconst_1
        //   419: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   422: aload 5
        //   424: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   427: ifnull +13 -> 440
        //   430: aload 5
        //   432: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   435: invokeinterface 85 1 0
        //   440: ldc 131
        //   442: aload_3
        //   443: ldc 216
        //   445: iconst_0
        //   446: anewarray 4	java/lang/Object
        //   449: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   452: ldc 25
        //   454: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   457: return
        //   458: astore_3
        //   459: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   462: ldc2_w 101
        //   465: ldc2_w 213
        //   468: lconst_1
        //   469: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   472: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   475: sipush 20752
        //   478: ldc 222
        //   480: iconst_1
        //   481: iconst_1
        //   482: invokevirtual 212	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   485: aload 5
        //   487: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   490: ifnull +13 -> 503
        //   493: aload 5
        //   495: getfield 80	com/tencent/mm/plugin/lite/logic/c$a:KaU	Lcom/tencent/mm/plugin/lite/api/b;
        //   498: invokeinterface 85 1 0
        //   503: ldc 131
        //   505: aload_3
        //   506: ldc 224
        //   508: iconst_0
        //   509: anewarray 4	java/lang/Object
        //   512: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   515: ldc 25
        //   517: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   520: return
        //   521: aload 5
        //   523: getfield 69	com/tencent/mm/plugin/lite/logic/c$a:KaS	Ljava/lang/String;
        //   526: ldc 87
        //   528: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   531: ifeq +470 -> 1001
        //   534: new 226	java/lang/StringBuilder
        //   537: dup
        //   538: invokespecial 227	java/lang/StringBuilder:<init>	()V
        //   541: getstatic 232	com/tencent/mm/storage/at:acHs	Ljava/lang/String;
        //   544: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   547: ldc 238
        //   549: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   552: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   555: astore 8
        //   557: ldc 131
        //   559: ldc 133
        //   561: iconst_4
        //   562: anewarray 4	java/lang/Object
        //   565: dup
        //   566: iconst_0
        //   567: aload 6
        //   569: getfield 117	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   572: aastore
        //   573: dup
        //   574: iconst_1
        //   575: aload_3
        //   576: aastore
        //   577: dup
        //   578: iconst_2
        //   579: aload 8
        //   581: aastore
        //   582: dup
        //   583: iconst_3
        //   584: aload 6
        //   586: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   589: aastore
        //   590: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   593: new 140	com/tencent/mm/vfs/u
        //   596: dup
        //   597: aload 8
        //   599: invokespecial 143	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   602: astore 7
        //   604: aload 7
        //   606: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
        //   609: ifne +9 -> 618
        //   612: aload 7
        //   614: invokevirtual 150	com/tencent/mm/vfs/u:jKY	()Z
        //   617: pop
        //   618: aload_3
        //   619: iconst_0
        //   620: invokestatic 156	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
        //   623: aload 8
        //   625: invokestatic 160	com/tencent/mm/plugin/lite/logic/c:jT	(Ljava/lang/String;Ljava/lang/String;)V
        //   628: aload 8
        //   630: iconst_0
        //   631: invokestatic 156	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
        //   634: invokestatic 246	com/tencent/mm/plugin/lite/logic/d:getBaseLibMajorVersionByPath	(Ljava/lang/String;)Ljava/lang/String;
        //   637: astore 7
        //   639: aload 7
        //   641: invokestatic 62	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   644: ifeq +16 -> 660
        //   647: ldc 131
        //   649: ldc 248
        //   651: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   654: ldc 25
        //   656: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   659: return
        //   660: aload 8
        //   662: invokestatic 256	com/tencent/liteapp/d/c:ev	(Ljava/lang/String;)Z
        //   665: pop
        //   666: aload 7
        //   668: aload 6
        //   670: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   673: aload 6
        //   675: getfield 123	com/tencent/mm/plugin/boots/a/g:vyS	Ljava/lang/String;
        //   678: invokestatic 259	com/tencent/mm/plugin/lite/logic/f:aE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   681: astore 8
        //   683: new 140	com/tencent/mm/vfs/u
        //   686: dup
        //   687: aload 8
        //   689: invokespecial 143	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   692: astore 9
        //   694: aload 9
        //   696: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
        //   699: ifne +9 -> 708
        //   702: aload 9
        //   704: invokevirtual 150	com/tencent/mm/vfs/u:jKY	()Z
        //   707: pop
        //   708: aload_3
        //   709: iconst_0
        //   710: invokestatic 156	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
        //   713: aload 8
        //   715: invokestatic 160	com/tencent/mm/plugin/lite/logic/c:jT	(Ljava/lang/String;Ljava/lang/String;)V
        //   718: new 261	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo
        //   721: dup
        //   722: invokespecial 262	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:<init>	()V
        //   725: astore_3
        //   726: aload_3
        //   727: aload 7
        //   729: putfield 265	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:egH	Ljava/lang/String;
        //   732: aload_3
        //   733: aload 8
        //   735: putfield 266	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:path	Ljava/lang/String;
        //   738: aload_3
        //   739: aload 6
        //   741: getfield 170	com/tencent/mm/plugin/boots/a/g:egI	Ljava/lang/String;
        //   744: putfield 267	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:egI	Ljava/lang/String;
        //   747: aload_3
        //   748: aload 5
        //   750: getfield 174	com/tencent/mm/plugin/lite/logic/c$a:KaW	Ljava/lang/String;
        //   753: putfield 268	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:type	Ljava/lang/String;
        //   756: aload_3
        //   757: invokestatic 183	java/lang/System:currentTimeMillis	()J
        //   760: ldc2_w 184
        //   763: ldiv
        //   764: putfield 269	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:egK	J
        //   767: aload_3
        //   768: aload 6
        //   770: getfield 120	com/tencent/mm/plugin/boots/a/g:egJ	Ljava/lang/String;
        //   773: putfield 270	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:egJ	Ljava/lang/String;
        //   776: aload_3
        //   777: aload 6
        //   779: getfield 123	com/tencent/mm/plugin/boots/a/g:vyS	Ljava/lang/String;
        //   782: putfield 271	com/tencent/liteapp/storage/WxaLiteAppBaselibInfo:md5	Ljava/lang/String;
        //   785: invokestatic 199	com/tencent/mm/plugin/lite/logic/d:fUi	()Lcom/tencent/mm/plugin/lite/logic/d;
        //   788: pop
        //   789: aload_3
        //   790: invokestatic 274	com/tencent/mm/plugin/lite/logic/d:b	(Lcom/tencent/liteapp/storage/WxaLiteAppBaselibInfo;)V
        //   793: aload 5
        //   795: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   798: ifnull +14 -> 812
        //   801: aload 5
        //   803: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   806: aload_3
        //   807: invokeinterface 276 2 0
        //   812: ldc 25
        //   814: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   817: return
        //   818: astore_3
        //   819: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   822: sipush 20752
        //   825: ldc 209
        //   827: iconst_1
        //   828: iconst_1
        //   829: invokevirtual 212	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   832: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   835: ldc2_w 101
        //   838: ldc2_w 213
        //   841: lconst_1
        //   842: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   845: aload 5
        //   847: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   850: ifnull +13 -> 863
        //   853: aload 5
        //   855: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   858: invokeinterface 94 1 0
        //   863: ldc 131
        //   865: aload_3
        //   866: ldc 216
        //   868: iconst_0
        //   869: anewarray 4	java/lang/Object
        //   872: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   875: ldc 25
        //   877: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   880: return
        //   881: astore_3
        //   882: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   885: ldc2_w 101
        //   888: ldc2_w 213
        //   891: lconst_1
        //   892: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   895: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   898: sipush 20752
        //   901: ldc 222
        //   903: iconst_1
        //   904: iconst_1
        //   905: invokevirtual 212	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   908: aload 5
        //   910: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   913: ifnull +13 -> 926
        //   916: aload 5
        //   918: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   921: invokeinterface 94 1 0
        //   926: ldc 131
        //   928: aload_3
        //   929: ldc 224
        //   931: iconst_0
        //   932: anewarray 4	java/lang/Object
        //   935: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   938: ldc 25
        //   940: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   943: return
        //   944: astore_3
        //   945: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   948: sipush 20752
        //   951: ldc 209
        //   953: iconst_1
        //   954: iconst_1
        //   955: invokevirtual 212	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   958: getstatic 100	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   961: ldc2_w 101
        //   964: ldc2_w 213
        //   967: lconst_1
        //   968: invokevirtual 108	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   971: aload 5
        //   973: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   976: ifnull +13 -> 989
        //   979: aload 5
        //   981: getfield 91	com/tencent/mm/plugin/lite/logic/c$a:KaV	Lcom/tencent/mm/plugin/lite/api/a;
        //   984: invokeinterface 94 1 0
        //   989: ldc 131
        //   991: aload_3
        //   992: ldc 216
        //   994: iconst_0
        //   995: anewarray 4	java/lang/Object
        //   998: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1001: ldc 25
        //   1003: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1006: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1007	0	this	1
        //   0	1007	1	paramAnonymousLong	long
        //   0	1007	3	paramAnonymousString	String
        //   0	1007	4	paramAnonymousBoolean	boolean
        //   49	931	5	locala	c.a
        //   161	617	6	localg	g
        //   211	517	7	localObject1	Object
        //   258	476	8	localObject2	Object
        //   692	11	9	localu	com.tencent.mm.vfs.u
        // Exception table:
        //   from	to	target	type
        //   274	284	395	java/lang/Exception
        //   389	394	395	java/lang/Exception
        //   459	503	395	java/lang/Exception
        //   503	515	395	java/lang/Exception
        //   284	389	458	java/lang/Exception
        //   708	718	818	java/lang/Exception
        //   812	817	818	java/lang/Exception
        //   882	926	818	java/lang/Exception
        //   926	938	818	java/lang/Exception
        //   718	812	881	java/lang/Exception
        //   618	654	944	java/lang/Exception
        //   660	708	944	java/lang/Exception
        //   819	863	944	java/lang/Exception
        //   863	875	944	java/lang/Exception
        //   938	943	944	java/lang/Exception
      }
      
      public final void c(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(271398);
        if (!c.this.KaO.containsKey(Long.valueOf(paramAnonymousLong)))
        {
          AppMethodBeat.o(271398);
          return;
        }
        Log.e("MicroMsg.LiteAppDownloadPkg", "down fail, id:".concat(String.valueOf(paramAnonymousLong)));
        h.OAn.b(20752, "0", true, true);
        h.OAn.p(1293L, 95L, 1L);
        c.a locala = (c.a)c.this.KaO.get(Long.valueOf(paramAnonymousLong));
        c.this.KaO.remove(Long.valueOf(paramAnonymousLong));
        if (locala.KaU != null)
        {
          locala.KaU.csy();
          AppMethodBeat.o(271398);
          return;
        }
        if (locala.KaV != null) {
          locala.KaV.csy();
        }
        AppMethodBeat.o(271398);
      }
      
      public final void jF(long paramAnonymousLong)
      {
        AppMethodBeat.i(271405);
        c.this.KaO.remove(Long.valueOf(paramAnonymousLong));
        AppMethodBeat.o(271405);
      }
      
      public final void jG(long paramAnonymousLong) {}
      
      public final void jH(long paramAnonymousLong) {}
      
      public final void v(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(271370);
        Log.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(271370);
      }
      
      public final void w(long paramAnonymousLong, String paramAnonymousString) {}
    };
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(this.KaP);
    AppMethodBeat.o(271391);
  }
  
  /* Error */
  public static void jT(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 76	java/util/zip/ZipInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokestatic 82	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: invokespecial 85	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_0
    //   19: aload_3
    //   20: invokevirtual 89	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +277 -> 304
    //   30: aload_3
    //   31: astore_0
    //   32: aload 4
    //   34: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_3
    //   40: astore_0
    //   41: aload 5
    //   43: ldc 97
    //   45: invokevirtual 103	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   48: ifne -31 -> 17
    //   51: aload_3
    //   52: astore_0
    //   53: aload 5
    //   55: ldc 105
    //   57: invokevirtual 103	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   60: ifne -43 -> 17
    //   63: aload_3
    //   64: astore_0
    //   65: aload 4
    //   67: invokevirtual 109	java/util/zip/ZipEntry:isDirectory	()Z
    //   70: ifeq +116 -> 186
    //   73: aload_3
    //   74: astore_0
    //   75: aload 5
    //   77: iconst_0
    //   78: aload 5
    //   80: invokevirtual 113	java/lang/String:length	()I
    //   83: iconst_1
    //   84: isub
    //   85: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: astore 4
    //   90: aload_3
    //   91: astore_0
    //   92: new 119	com/tencent/mm/vfs/u
    //   95: dup
    //   96: new 121	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 128
    //   109: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 4
    //   114: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 132	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 135	com/tencent/mm/vfs/u:jKV	()Z
    //   132: ifeq +11 -> 143
    //   135: aload_3
    //   136: astore_0
    //   137: aload 4
    //   139: invokevirtual 138	com/tencent/mm/vfs/u:diJ	()Z
    //   142: pop
    //   143: aload_3
    //   144: astore_0
    //   145: aload 4
    //   147: invokevirtual 141	com/tencent/mm/vfs/u:jKY	()Z
    //   150: pop
    //   151: goto -134 -> 17
    //   154: astore_0
    //   155: aload_3
    //   156: astore_1
    //   157: aload_0
    //   158: astore_3
    //   159: aload_1
    //   160: astore_0
    //   161: ldc 74
    //   163: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: astore_0
    //   168: aload_3
    //   169: athrow
    //   170: astore_3
    //   171: aload_0
    //   172: astore_1
    //   173: aload_3
    //   174: astore_0
    //   175: aload_1
    //   176: invokestatic 147	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   179: ldc 74
    //   181: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_0
    //   185: athrow
    //   186: aload_3
    //   187: astore_0
    //   188: new 119	com/tencent/mm/vfs/u
    //   191: dup
    //   192: new 121	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   199: aload_1
    //   200: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 128
    //   205: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 5
    //   210: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokespecial 132	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   219: astore 4
    //   221: aload_3
    //   222: astore_0
    //   223: aload 4
    //   225: invokevirtual 151	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   228: astore 5
    //   230: aload_3
    //   231: astore_0
    //   232: aload 5
    //   234: invokevirtual 154	com/tencent/mm/vfs/u:jKS	()Z
    //   237: ifne +11 -> 248
    //   240: aload_3
    //   241: astore_0
    //   242: aload 5
    //   244: invokevirtual 141	com/tencent/mm/vfs/u:jKY	()Z
    //   247: pop
    //   248: aload_3
    //   249: astore_0
    //   250: aload 4
    //   252: invokestatic 158	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   255: astore 4
    //   257: aload_3
    //   258: astore_0
    //   259: sipush 1024
    //   262: newarray byte
    //   264: astore 5
    //   266: aload_3
    //   267: astore_0
    //   268: aload_3
    //   269: aload 5
    //   271: invokevirtual 162	java/util/zip/ZipInputStream:read	([B)I
    //   274: istore_2
    //   275: iload_2
    //   276: iconst_m1
    //   277: if_icmpeq +17 -> 294
    //   280: aload_3
    //   281: astore_0
    //   282: aload 4
    //   284: aload 5
    //   286: iconst_0
    //   287: iload_2
    //   288: invokevirtual 168	java/io/OutputStream:write	([BII)V
    //   291: goto -25 -> 266
    //   294: aload_3
    //   295: astore_0
    //   296: aload 4
    //   298: invokevirtual 171	java/io/OutputStream:close	()V
    //   301: goto -284 -> 17
    //   304: aload_3
    //   305: invokestatic 147	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   308: ldc 74
    //   310: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: return
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_1
    //   317: goto -142 -> 175
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -164 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString1	String
    //   0	326	1	paramString2	String
    //   274	14	2	i	int
    //   16	153	3	localObject1	Object
    //   170	135	3	localCloseable	java.io.Closeable
    //   320	1	3	localException	java.lang.Exception
    //   23	274	4	localObject2	Object
    //   37	248	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	25	154	java/lang/Exception
    //   32	39	154	java/lang/Exception
    //   41	51	154	java/lang/Exception
    //   53	63	154	java/lang/Exception
    //   65	73	154	java/lang/Exception
    //   75	90	154	java/lang/Exception
    //   92	125	154	java/lang/Exception
    //   127	135	154	java/lang/Exception
    //   137	143	154	java/lang/Exception
    //   145	151	154	java/lang/Exception
    //   188	221	154	java/lang/Exception
    //   223	230	154	java/lang/Exception
    //   232	240	154	java/lang/Exception
    //   242	248	154	java/lang/Exception
    //   250	257	154	java/lang/Exception
    //   259	266	154	java/lang/Exception
    //   268	275	154	java/lang/Exception
    //   282	291	154	java/lang/Exception
    //   296	301	154	java/lang/Exception
    //   19	25	170	finally
    //   32	39	170	finally
    //   41	51	170	finally
    //   53	63	170	finally
    //   65	73	170	finally
    //   75	90	170	finally
    //   92	125	170	finally
    //   127	135	170	finally
    //   137	143	170	finally
    //   145	151	170	finally
    //   161	166	170	finally
    //   168	170	170	finally
    //   188	221	170	finally
    //   223	230	170	finally
    //   232	240	170	finally
    //   242	248	170	finally
    //   250	257	170	finally
    //   259	266	170	finally
    //   268	275	170	finally
    //   282	291	170	finally
    //   296	301	170	finally
    //   5	17	314	finally
    //   5	17	320	java/lang/Exception
  }
  
  public final void a(g paramg, String paramString, a parama)
  {
    AppMethodBeat.i(271426);
    h.OAn.p(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.amR(paramg.mOI);
    locala.amT(paramg.vyS);
    locala.JA(2);
    locala.nB(false);
    long l = f.duv().a(locala.xoe);
    this.KaO.put(Long.valueOf(l), new a("downloadLiteAppBaselib", paramg, paramString, null, parama));
    AppMethodBeat.o(271426);
  }
  
  public final void a(g paramg, String paramString, b paramb)
  {
    AppMethodBeat.i(271417);
    h.OAn.p(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.amR(paramg.mOI);
    locala.amT(paramg.vyS);
    locala.JA(2);
    locala.nB(false);
    long l = f.duv().a(locala.xoe);
    this.KaO.put(Long.valueOf(l), new a("downloadLiteAppPkg", paramg, paramString, paramb, null));
    AppMethodBeat.o(271417);
  }
  
  final class a
  {
    public String KaS;
    public g KaT;
    public b KaU;
    public a KaV;
    public String KaW;
    
    public a(String paramString1, g paramg, String paramString2, b paramb, a parama)
    {
      this.KaS = paramString1;
      this.KaT = paramg;
      this.KaW = paramString2;
      this.KaU = paramb;
      this.KaV = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.c
 * JD-Core Version:    0.7.0.1
 */