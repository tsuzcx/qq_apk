package com.tencent.mm.plugin.lite.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.lite.launch.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum e
{
  public Map<Long, a> Egu;
  private m Egv;
  
  static
  {
    AppMethodBeat.i(233782);
    Egt = new e("INSTANCE");
    Egw = new e[] { Egt };
    AppMethodBeat.o(233782);
  }
  
  private e()
  {
    AppMethodBeat.i(233779);
    this.Egu = new ConcurrentHashMap();
    this.Egv = new m()
    {
      public final void Hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(234220);
        e.this.Egu.remove(Long.valueOf(paramAnonymousLong));
        AppMethodBeat.o(234220);
      }
      
      public final void Hq(long paramAnonymousLong) {}
      
      public final void Hr(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234218);
        if (!e.this.Egu.containsKey(Long.valueOf(paramAnonymousLong)))
        {
          AppMethodBeat.o(234218);
          return;
        }
        Log.e("MicroMsg.LiteAppDownloadPkg", "down fail, id:".concat(String.valueOf(paramAnonymousLong)));
        h.IzE.b(20752, "0", true, true);
        h.IzE.p(1293L, 95L, 1L);
        e.a locala = (e.a)e.this.Egu.get(Long.valueOf(paramAnonymousLong));
        e.this.Egu.remove(Long.valueOf(paramAnonymousLong));
        if (locala.Egz != null) {
          locala.Egz.ewD();
        }
        AppMethodBeat.o(234218);
      }
      
      /* Error */
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: ldc 113
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/plugin/lite/b/e$1:Egx	Lcom/tencent/mm/plugin/lite/b/e;
        //   9: getfield 31	com/tencent/mm/plugin/lite/b/e:Egu	Ljava/util/Map;
        //   12: lload_1
        //   13: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   16: invokeinterface 57 2 0
        //   21: ifne +9 -> 30
        //   24: ldc 113
        //   26: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_0
        //   31: getfield 14	com/tencent/mm/plugin/lite/b/e$1:Egx	Lcom/tencent/mm/plugin/lite/b/e;
        //   34: getfield 31	com/tencent/mm/plugin/lite/b/e:Egu	Ljava/util/Map;
        //   37: lload_1
        //   38: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   41: invokeinterface 98 2 0
        //   46: checkcast 100	com/tencent/mm/plugin/lite/b/e$a
        //   49: astore 5
        //   51: aload_3
        //   52: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   55: ifeq +44 -> 99
        //   58: aload_0
        //   59: getfield 14	com/tencent/mm/plugin/lite/b/e$1:Egx	Lcom/tencent/mm/plugin/lite/b/e;
        //   62: getfield 31	com/tencent/mm/plugin/lite/b/e:Egu	Ljava/util/Map;
        //   65: lload_1
        //   66: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   69: invokeinterface 43 2 0
        //   74: pop
        //   75: aload 5
        //   77: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   80: ifnull +13 -> 93
        //   83: aload 5
        //   85: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   88: invokeinterface 109 1 0
        //   93: ldc 113
        //   95: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   98: return
        //   99: getstatic 82	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   102: ldc2_w 88
        //   105: ldc2_w 120
        //   108: lconst_1
        //   109: invokevirtual 95	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   112: aload 5
        //   114: getfield 125	com/tencent/mm/plugin/lite/b/e$a:Egy	Lcom/tencent/mm/plugin/boots/a/g;
        //   117: astore 6
        //   119: aload_0
        //   120: getfield 14	com/tencent/mm/plugin/lite/b/e$1:Egx	Lcom/tencent/mm/plugin/lite/b/e;
        //   123: getfield 31	com/tencent/mm/plugin/lite/b/e:Egu	Ljava/util/Map;
        //   126: lload_1
        //   127: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   130: invokeinterface 43 2 0
        //   135: pop
        //   136: aload 6
        //   138: getfield 131	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   141: aload 6
        //   143: getfield 134	com/tencent/mm/plugin/boots/a/g:coY	Ljava/lang/String;
        //   146: aload 6
        //   148: getfield 137	com/tencent/mm/plugin/boots/a/g:smU	Ljava/lang/String;
        //   151: invokestatic 143	com/tencent/mm/plugin/lite/b/h:aq	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   154: astore 7
        //   156: ldc 59
        //   158: ldc 145
        //   160: iconst_4
        //   161: anewarray 4	java/lang/Object
        //   164: dup
        //   165: iconst_0
        //   166: aload 6
        //   168: getfield 131	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   171: aastore
        //   172: dup
        //   173: iconst_1
        //   174: aload_3
        //   175: aastore
        //   176: dup
        //   177: iconst_2
        //   178: aload 7
        //   180: aastore
        //   181: dup
        //   182: iconst_3
        //   183: aload 6
        //   185: getfield 134	com/tencent/mm/plugin/boots/a/g:coY	Ljava/lang/String;
        //   188: aastore
        //   189: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   192: new 150	com/tencent/mm/vfs/q
        //   195: dup
        //   196: aload 7
        //   198: invokespecial 153	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
        //   201: astore 8
        //   203: aload 8
        //   205: invokevirtual 157	com/tencent/mm/vfs/q:ifE	()Z
        //   208: ifne +9 -> 217
        //   211: aload 8
        //   213: invokevirtual 160	com/tencent/mm/vfs/q:ifL	()Z
        //   216: pop
        //   217: aload_3
        //   218: iconst_0
        //   219: invokestatic 166	com/tencent/mm/vfs/u:n	(Ljava/lang/String;Z)Ljava/lang/String;
        //   222: aload 7
        //   224: invokestatic 169	com/tencent/mm/plugin/lite/b/e:iJ	(Ljava/lang/String;Ljava/lang/String;)V
        //   227: new 171	com/tencent/liteapp/storage/WxaLiteAppInfo
        //   230: dup
        //   231: invokespecial 172	com/tencent/liteapp/storage/WxaLiteAppInfo:<init>	()V
        //   234: astore_3
        //   235: aload_3
        //   236: aload 6
        //   238: getfield 131	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   241: putfield 173	com/tencent/liteapp/storage/WxaLiteAppInfo:appId	Ljava/lang/String;
        //   244: aload_3
        //   245: aload 7
        //   247: putfield 176	com/tencent/liteapp/storage/WxaLiteAppInfo:path	Ljava/lang/String;
        //   250: aload_3
        //   251: aload 6
        //   253: getfield 179	com/tencent/mm/plugin/boots/a/g:coX	Ljava/lang/String;
        //   256: putfield 180	com/tencent/liteapp/storage/WxaLiteAppInfo:coX	Ljava/lang/String;
        //   259: aload_3
        //   260: aload 5
        //   262: getfield 183	com/tencent/mm/plugin/lite/b/e$a:EgA	Ljava/lang/String;
        //   265: putfield 186	com/tencent/liteapp/storage/WxaLiteAppInfo:type	Ljava/lang/String;
        //   268: aload_3
        //   269: invokestatic 192	java/lang/System:currentTimeMillis	()J
        //   272: ldc2_w 193
        //   275: ldiv
        //   276: putfield 198	com/tencent/liteapp/storage/WxaLiteAppInfo:coZ	J
        //   279: aload_3
        //   280: aload 6
        //   282: getfield 134	com/tencent/mm/plugin/boots/a/g:coY	Ljava/lang/String;
        //   285: putfield 199	com/tencent/liteapp/storage/WxaLiteAppInfo:coY	Ljava/lang/String;
        //   288: aload_3
        //   289: aload 6
        //   291: getfield 137	com/tencent/mm/plugin/boots/a/g:smU	Ljava/lang/String;
        //   294: putfield 202	com/tencent/liteapp/storage/WxaLiteAppInfo:md5	Ljava/lang/String;
        //   297: invokestatic 208	com/tencent/mm/plugin/lite/b/f:eLH	()Lcom/tencent/mm/plugin/lite/b/f;
        //   300: pop
        //   301: aload_3
        //   302: invokestatic 211	com/tencent/mm/plugin/lite/b/f:b	(Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V
        //   305: invokestatic 208	com/tencent/mm/plugin/lite/b/f:eLH	()Lcom/tencent/mm/plugin/lite/b/f;
        //   308: pop
        //   309: aload_3
        //   310: invokestatic 214	com/tencent/mm/plugin/lite/b/f:c	(Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V
        //   313: aload 5
        //   315: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   318: ifnull +14 -> 332
        //   321: aload 5
        //   323: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   326: aload_3
        //   327: invokeinterface 216 2 0
        //   332: ldc 113
        //   334: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   337: return
        //   338: astore_3
        //   339: getstatic 82	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   342: sipush 20752
        //   345: ldc 218
        //   347: iconst_1
        //   348: iconst_1
        //   349: invokevirtual 87	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   352: getstatic 82	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   355: ldc2_w 88
        //   358: ldc2_w 219
        //   361: lconst_1
        //   362: invokevirtual 95	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   365: aload 5
        //   367: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   370: ifnull +13 -> 383
        //   373: aload 5
        //   375: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   378: invokeinterface 109 1 0
        //   383: ldc 59
        //   385: aload_3
        //   386: ldc 222
        //   388: iconst_0
        //   389: anewarray 4	java/lang/Object
        //   392: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   395: ldc 113
        //   397: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   400: return
        //   401: astore_3
        //   402: getstatic 82	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   405: ldc2_w 88
        //   408: ldc2_w 219
        //   411: lconst_1
        //   412: invokevirtual 95	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
        //   415: getstatic 82	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   418: sipush 20752
        //   421: ldc 228
        //   423: iconst_1
        //   424: iconst_1
        //   425: invokevirtual 87	com/tencent/mm/plugin/report/service/h:b	(ILjava/lang/String;ZZ)V
        //   428: aload 5
        //   430: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   433: ifnull +13 -> 446
        //   436: aload 5
        //   438: getfield 104	com/tencent/mm/plugin/lite/b/e$a:Egz	Lcom/tencent/mm/plugin/lite/launch/a;
        //   441: invokeinterface 109 1 0
        //   446: ldc 59
        //   448: aload_3
        //   449: ldc 230
        //   451: iconst_0
        //   452: anewarray 4	java/lang/Object
        //   455: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   458: ldc 113
        //   460: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   463: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	464	0	this	1
        //   0	464	1	paramAnonymousLong	long
        //   0	464	3	paramAnonymousString	String
        //   0	464	4	paramAnonymousBoolean	boolean
        //   49	388	5	locala	e.a
        //   117	173	6	localg	g
        //   154	92	7	str	String
        //   201	11	8	localq	com.tencent.mm.vfs.q
        // Exception table:
        //   from	to	target	type
        //   217	227	338	java/lang/Exception
        //   332	337	338	java/lang/Exception
        //   402	446	338	java/lang/Exception
        //   446	458	338	java/lang/Exception
        //   227	332	401	java/lang/Exception
      }
      
      public final void m(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(234212);
        Log.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(234212);
      }
      
      public final void n(long paramAnonymousLong, String paramAnonymousString) {}
    };
    f.cPZ();
    c.a(this.Egv);
    AppMethodBeat.o(233779);
  }
  
  /* Error */
  public static void iJ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 76	java/util/zip/ZipInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokestatic 82	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   92: new 119	com/tencent/mm/vfs/q
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
    //   120: invokespecial 132	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 135	com/tencent/mm/vfs/q:ifH	()Z
    //   132: ifeq +11 -> 143
    //   135: aload_3
    //   136: astore_0
    //   137: aload 4
    //   139: invokevirtual 138	com/tencent/mm/vfs/q:cFq	()Z
    //   142: pop
    //   143: aload_3
    //   144: astore_0
    //   145: aload 4
    //   147: invokevirtual 141	com/tencent/mm/vfs/q:ifL	()Z
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
    //   176: invokestatic 147	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   179: ldc 74
    //   181: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_0
    //   185: athrow
    //   186: aload_3
    //   187: astore_0
    //   188: new 119	com/tencent/mm/vfs/q
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
    //   216: invokespecial 132	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   219: astore 4
    //   221: aload_3
    //   222: astore_0
    //   223: aload 4
    //   225: invokevirtual 151	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   228: astore 5
    //   230: aload_3
    //   231: astore_0
    //   232: aload 5
    //   234: invokevirtual 154	com/tencent/mm/vfs/q:ifE	()Z
    //   237: ifne +11 -> 248
    //   240: aload_3
    //   241: astore_0
    //   242: aload 5
    //   244: invokevirtual 141	com/tencent/mm/vfs/q:ifL	()Z
    //   247: pop
    //   248: aload_3
    //   249: astore_0
    //   250: aload 4
    //   252: invokestatic 158	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
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
    //   305: invokestatic 147	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
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
    AppMethodBeat.i(233781);
    h.IzE.p(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.atc(paramg.smT);
    locala.ate(paramg.smU);
    locala.IS(2);
    locala.mf(false);
    long l = f.cPZ().a(locala.uhY);
    this.Egu.put(Long.valueOf(l), new a(paramg, paramString, parama));
    AppMethodBeat.o(233781);
  }
  
  final class a
  {
    public String EgA;
    public g Egy;
    public a Egz;
    
    public a(g paramg, String paramString, a parama)
    {
      this.Egy = paramg;
      this.EgA = paramString;
      this.Egz = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.e
 * JD-Core Version:    0.7.0.1
 */