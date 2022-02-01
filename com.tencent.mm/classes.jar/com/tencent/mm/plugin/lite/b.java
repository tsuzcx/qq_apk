package com.tencent.mm.plugin.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.lite.logic.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  public Map<Long, a> vjO;
  private m vjP;
  
  static
  {
    AppMethodBeat.i(217759);
    vjN = new b("INSTANCE");
    vjQ = new b[] { vjN };
    AppMethodBeat.o(217759);
  }
  
  private b()
  {
    AppMethodBeat.i(217756);
    this.vjO = new ConcurrentHashMap();
    this.vjP = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(217752);
        if (!b.this.vjO.containsKey(Long.valueOf(paramAnonymousLong)))
        {
          AppMethodBeat.o(217752);
          return;
        }
        ae.e("MicroMsg.LiteAppDownloadPkg", "down fail, id:".concat(String.valueOf(paramAnonymousLong)));
        com.tencent.mm.plugin.report.service.g.yxI.a(20752, "0", true, true);
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 95L, 1L);
        b.a locala = (b.a)b.this.vjO.get(Long.valueOf(paramAnonymousLong));
        b.this.vjO.remove(Long.valueOf(paramAnonymousLong));
        if (locala.vjT != null) {
          locala.vjT.cZO();
        }
        AppMethodBeat.o(217752);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      /* Error */
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: ldc 108
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/plugin/lite/b$1:vjR	Lcom/tencent/mm/plugin/lite/b;
        //   9: getfield 31	com/tencent/mm/plugin/lite/b:vjO	Ljava/util/Map;
        //   12: lload_1
        //   13: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   16: invokeinterface 43 2 0
        //   21: ifne +9 -> 30
        //   24: ldc 108
        //   26: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_0
        //   31: getfield 14	com/tencent/mm/plugin/lite/b$1:vjR	Lcom/tencent/mm/plugin/lite/b;
        //   34: getfield 31	com/tencent/mm/plugin/lite/b:vjO	Ljava/util/Map;
        //   37: lload_1
        //   38: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   41: invokeinterface 88 2 0
        //   46: checkcast 90	com/tencent/mm/plugin/lite/b$a
        //   49: astore 5
        //   51: aload_3
        //   52: ifnull +10 -> 62
        //   55: aload_3
        //   56: invokevirtual 112	java/lang/String:isEmpty	()Z
        //   59: ifeq +44 -> 103
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/lite/b$1:vjR	Lcom/tencent/mm/plugin/lite/b;
        //   66: getfield 31	com/tencent/mm/plugin/lite/b:vjO	Ljava/util/Map;
        //   69: lload_1
        //   70: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   73: invokeinterface 93 2 0
        //   78: pop
        //   79: aload 5
        //   81: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   84: ifnull +13 -> 97
        //   87: aload 5
        //   89: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   92: invokeinterface 102 1 0
        //   97: ldc 108
        //   99: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: return
        //   103: getstatic 71	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   106: ldc2_w 77
        //   109: ldc2_w 113
        //   112: lconst_1
        //   113: invokevirtual 84	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
        //   116: aload 5
        //   118: getfield 118	com/tencent/mm/plugin/lite/b$a:vjS	Lcom/tencent/mm/plugin/boots/a/g;
        //   121: astore 6
        //   123: aload_0
        //   124: getfield 14	com/tencent/mm/plugin/lite/b$1:vjR	Lcom/tencent/mm/plugin/lite/b;
        //   127: getfield 31	com/tencent/mm/plugin/lite/b:vjO	Ljava/util/Map;
        //   130: lload_1
        //   131: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   134: invokeinterface 93 2 0
        //   139: pop
        //   140: new 120	java/lang/StringBuilder
        //   143: dup
        //   144: invokespecial 121	java/lang/StringBuilder:<init>	()V
        //   147: getstatic 127	com/tencent/mm/storage/am:IKj	Ljava/lang/String;
        //   150: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   153: ldc 133
        //   155: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload 6
        //   160: getfield 138	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   163: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: bipush 95
        //   168: invokevirtual 141	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   171: aload 6
        //   173: getfield 144	com/tencent/mm/plugin/boots/a/g:nZM	Ljava/lang/String;
        //   176: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   182: astore 7
        //   184: ldc 48
        //   186: ldc 150
        //   188: iconst_4
        //   189: anewarray 4	java/lang/Object
        //   192: dup
        //   193: iconst_0
        //   194: aload 6
        //   196: getfield 138	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   199: aastore
        //   200: dup
        //   201: iconst_1
        //   202: aload_3
        //   203: aastore
        //   204: dup
        //   205: iconst_2
        //   206: aload 7
        //   208: aastore
        //   209: dup
        //   210: iconst_3
        //   211: aload 6
        //   213: getfield 153	com/tencent/mm/plugin/boots/a/g:nZN	Ljava/lang/String;
        //   216: aastore
        //   217: invokestatic 156	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   220: new 158	java/io/File
        //   223: dup
        //   224: aload 7
        //   226: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
        //   229: astore 8
        //   231: aload 8
        //   233: invokevirtual 164	java/io/File:exists	()Z
        //   236: ifne +9 -> 245
        //   239: aload 8
        //   241: invokevirtual 167	java/io/File:mkdirs	()Z
        //   244: pop
        //   245: aload_3
        //   246: aload 7
        //   248: invokestatic 170	com/tencent/mm/plugin/lite/b:hM	(Ljava/lang/String;Ljava/lang/String;)V
        //   251: new 172	com/tencent/mm/plugin/lite/d/e
        //   254: dup
        //   255: invokespecial 173	com/tencent/mm/plugin/lite/d/e:<init>	()V
        //   258: astore_3
        //   259: aload_3
        //   260: aload 6
        //   262: getfield 138	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   265: putfield 176	com/tencent/mm/plugin/lite/d/e:field_appId	Ljava/lang/String;
        //   268: aload_3
        //   269: aload 7
        //   271: putfield 179	com/tencent/mm/plugin/lite/d/e:field_pkgPath	Ljava/lang/String;
        //   274: aload_3
        //   275: aload 6
        //   277: getfield 182	com/tencent/mm/plugin/boots/a/g:nZO	Ljava/lang/String;
        //   280: putfield 185	com/tencent/mm/plugin/lite/d/e:field_signatureKey	Ljava/lang/String;
        //   283: aload_3
        //   284: aload 5
        //   286: getfield 188	com/tencent/mm/plugin/lite/b$a:vjU	Ljava/lang/String;
        //   289: putfield 191	com/tencent/mm/plugin/lite/d/e:field_pkgType	Ljava/lang/String;
        //   292: aload_3
        //   293: invokestatic 197	java/lang/System:currentTimeMillis	()J
        //   296: ldc2_w 198
        //   299: ldiv
        //   300: putfield 203	com/tencent/mm/plugin/lite/d/e:field_updateTime	J
        //   303: aload_3
        //   304: aload 6
        //   306: getfield 153	com/tencent/mm/plugin/boots/a/g:nZN	Ljava/lang/String;
        //   309: putfield 206	com/tencent/mm/plugin/lite/d/e:field_patchId	Ljava/lang/String;
        //   312: invokestatic 212	com/tencent/mm/plugin/lite/logic/c:diz	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   315: pop
        //   316: new 214	android/os/Bundle
        //   319: dup
        //   320: invokespecial 215	android/os/Bundle:<init>	()V
        //   323: astore 6
        //   325: aload 6
        //   327: ldc 216
        //   329: aload_3
        //   330: getfield 176	com/tencent/mm/plugin/lite/d/e:field_appId	Ljava/lang/String;
        //   333: invokevirtual 219	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   336: aload 6
        //   338: ldc 221
        //   340: aload_3
        //   341: getfield 185	com/tencent/mm/plugin/lite/d/e:field_signatureKey	Ljava/lang/String;
        //   344: invokevirtual 219	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   347: aload 6
        //   349: ldc 223
        //   351: aload_3
        //   352: getfield 191	com/tencent/mm/plugin/lite/d/e:field_pkgType	Ljava/lang/String;
        //   355: invokevirtual 219	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   358: aload 6
        //   360: ldc 225
        //   362: aload_3
        //   363: getfield 206	com/tencent/mm/plugin/lite/d/e:field_patchId	Ljava/lang/String;
        //   366: invokevirtual 219	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   369: aload 6
        //   371: ldc 227
        //   373: aload_3
        //   374: getfield 179	com/tencent/mm/plugin/lite/d/e:field_pkgPath	Ljava/lang/String;
        //   377: invokevirtual 219	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   380: aload 6
        //   382: ldc 229
        //   384: aload_3
        //   385: getfield 203	com/tencent/mm/plugin/lite/d/e:field_updateTime	J
        //   388: invokevirtual 233	android/os/Bundle:putLong	(Ljava/lang/String;J)V
        //   391: invokestatic 239	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
        //   394: invokevirtual 245	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   397: invokestatic 249	com/tencent/mm/plugin/lite/logic/c:getUri	()Landroid/net/Uri;
        //   400: ldc 251
        //   402: aload_3
        //   403: getfield 176	com/tencent/mm/plugin/lite/d/e:field_appId	Ljava/lang/String;
        //   406: aload 6
        //   408: invokevirtual 257	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
        //   411: pop
        //   412: invokestatic 212	com/tencent/mm/plugin/lite/logic/c:diz	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   415: pop
        //   416: aload_3
        //   417: invokestatic 260	com/tencent/mm/plugin/lite/logic/c:b	(Lcom/tencent/mm/plugin/lite/d/e;)V
        //   420: aload 5
        //   422: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   425: ifnull +14 -> 439
        //   428: aload 5
        //   430: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   433: aload_3
        //   434: invokeinterface 262 2 0
        //   439: ldc 108
        //   441: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   444: return
        //   445: astore_3
        //   446: getstatic 71	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   449: sipush 20752
        //   452: ldc_w 264
        //   455: iconst_1
        //   456: iconst_1
        //   457: invokevirtual 76	com/tencent/mm/plugin/report/service/g:a	(ILjava/lang/String;ZZ)V
        //   460: getstatic 71	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   463: ldc2_w 77
        //   466: ldc2_w 265
        //   469: lconst_1
        //   470: invokevirtual 84	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
        //   473: aload 5
        //   475: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   478: ifnull +13 -> 491
        //   481: aload 5
        //   483: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   486: invokeinterface 102 1 0
        //   491: ldc 48
        //   493: aload_3
        //   494: ldc_w 268
        //   497: iconst_0
        //   498: anewarray 4	java/lang/Object
        //   501: invokestatic 272	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   504: ldc 108
        //   506: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   509: return
        //   510: astore 6
        //   512: ldc_w 274
        //   515: aload 6
        //   517: ldc_w 276
        //   520: iconst_0
        //   521: anewarray 4	java/lang/Object
        //   524: invokestatic 272	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   527: goto -115 -> 412
        //   530: astore_3
        //   531: getstatic 71	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   534: ldc2_w 77
        //   537: ldc2_w 265
        //   540: lconst_1
        //   541: invokevirtual 84	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
        //   544: getstatic 71	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   547: sipush 20752
        //   550: ldc_w 278
        //   553: iconst_1
        //   554: iconst_1
        //   555: invokevirtual 76	com/tencent/mm/plugin/report/service/g:a	(ILjava/lang/String;ZZ)V
        //   558: aload 5
        //   560: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   563: ifnull +13 -> 576
        //   566: aload 5
        //   568: getfield 97	com/tencent/mm/plugin/lite/b$a:vjT	Lcom/tencent/mm/plugin/lite/logic/a;
        //   571: invokeinterface 102 1 0
        //   576: ldc 48
        //   578: aload_3
        //   579: ldc_w 276
        //   582: iconst_0
        //   583: anewarray 4	java/lang/Object
        //   586: invokestatic 272	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   589: ldc 108
        //   591: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   594: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	595	0	this	1
        //   0	595	1	paramAnonymousLong	long
        //   0	595	3	paramAnonymousString	String
        //   0	595	4	paramAnonymousBoolean	boolean
        //   49	518	5	locala	b.a
        //   121	286	6	localObject	Object
        //   510	6	6	localException	java.lang.Exception
        //   182	88	7	str	String
        //   229	11	8	localFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   245	251	445	java/lang/Exception
        //   439	444	445	java/lang/Exception
        //   531	576	445	java/lang/Exception
        //   576	589	445	java/lang/Exception
        //   391	412	510	java/lang/Exception
        //   251	391	530	java/lang/Exception
        //   412	439	530	java/lang/Exception
        //   512	527	530	java/lang/Exception
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(217750);
        ae.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(217750);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void sY(long paramAnonymousLong)
      {
        AppMethodBeat.i(217753);
        b.this.vjO.remove(Long.valueOf(paramAnonymousLong));
        AppMethodBeat.o(217753);
      }
      
      public final void sZ(long paramAnonymousLong) {}
      
      public final void ta(long paramAnonymousLong) {}
    };
    f.cdA();
    c.a(this.vjP);
    AppMethodBeat.o(217756);
  }
  
  public final void a(com.tencent.mm.plugin.boots.a.g paramg, String paramString, a parama)
  {
    AppMethodBeat.i(217757);
    com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.abb(paramg.gKg);
    locala.abd(paramg.nZM);
    locala.BB(2);
    locala.jQ(false);
    long l = f.cdA().a(locala.ptu);
    this.vjO.put(Long.valueOf(l), new a(paramg, paramString, parama));
    AppMethodBeat.o(217757);
  }
  
  final class a
  {
    public com.tencent.mm.plugin.boots.a.g vjS;
    public a vjT;
    public String vjU;
    
    public a(com.tencent.mm.plugin.boots.a.g paramg, String paramString, a parama)
    {
      this.vjS = paramg;
      this.vjU = paramString;
      this.vjT = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */