package com.tencent.mm.plugin.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.lite.logic.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  public Map<Long, a> uXZ;
  private m uYa;
  
  static
  {
    AppMethodBeat.i(217150);
    uXY = new b("INSTANCE");
    uYb = new b[] { uXY };
    AppMethodBeat.o(217150);
  }
  
  private b()
  {
    AppMethodBeat.i(217147);
    this.uXZ = new ConcurrentHashMap();
    this.uYa = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(217143);
        if (!b.this.uXZ.containsKey(Long.valueOf(paramAnonymousLong)))
        {
          AppMethodBeat.o(217143);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 95L, 1L);
        b.a locala = (b.a)b.this.uXZ.get(Long.valueOf(paramAnonymousLong));
        b.this.uXZ.remove(Long.valueOf(paramAnonymousLong));
        if (locala.uYe != null) {
          locala.uYe.cXf();
        }
        AppMethodBeat.o(217143);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      /* Error */
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: ldc 84
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/plugin/lite/b$1:uYc	Lcom/tencent/mm/plugin/lite/b;
        //   9: getfield 31	com/tencent/mm/plugin/lite/b:uXZ	Ljava/util/Map;
        //   12: lload_1
        //   13: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   16: invokeinterface 43 2 0
        //   21: ifne +9 -> 30
        //   24: ldc 84
        //   26: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_0
        //   31: getfield 14	com/tencent/mm/plugin/lite/b$1:uYc	Lcom/tencent/mm/plugin/lite/b;
        //   34: getfield 31	com/tencent/mm/plugin/lite/b:uXZ	Ljava/util/Map;
        //   37: lload_1
        //   38: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   41: invokeinterface 64 2 0
        //   46: checkcast 66	com/tencent/mm/plugin/lite/b$a
        //   49: astore 5
        //   51: aload_3
        //   52: ifnull +10 -> 62
        //   55: aload_3
        //   56: invokevirtual 90	java/lang/String:isEmpty	()Z
        //   59: ifeq +44 -> 103
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/lite/b$1:uYc	Lcom/tencent/mm/plugin/lite/b;
        //   66: getfield 31	com/tencent/mm/plugin/lite/b:uXZ	Ljava/util/Map;
        //   69: lload_1
        //   70: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   73: invokeinterface 69 2 0
        //   78: pop
        //   79: aload 5
        //   81: getfield 73	com/tencent/mm/plugin/lite/b$a:uYe	Lcom/tencent/mm/plugin/lite/logic/a;
        //   84: ifnull +13 -> 97
        //   87: aload 5
        //   89: getfield 73	com/tencent/mm/plugin/lite/b$a:uYe	Lcom/tencent/mm/plugin/lite/logic/a;
        //   92: invokeinterface 78 1 0
        //   97: ldc 84
        //   99: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: return
        //   103: getstatic 52	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
        //   106: ldc2_w 53
        //   109: ldc2_w 91
        //   112: lconst_1
        //   113: invokevirtual 60	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
        //   116: aload 5
        //   118: getfield 96	com/tencent/mm/plugin/lite/b$a:uYd	Lcom/tencent/mm/plugin/boots/a/g;
        //   121: astore 6
        //   123: aload_0
        //   124: getfield 14	com/tencent/mm/plugin/lite/b$1:uYc	Lcom/tencent/mm/plugin/lite/b;
        //   127: getfield 31	com/tencent/mm/plugin/lite/b:uXZ	Ljava/util/Map;
        //   130: lload_1
        //   131: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   134: invokeinterface 69 2 0
        //   139: pop
        //   140: new 98	java/lang/StringBuilder
        //   143: dup
        //   144: invokespecial 99	java/lang/StringBuilder:<init>	()V
        //   147: getstatic 105	com/tencent/mm/storage/al:IpP	Ljava/lang/String;
        //   150: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   153: getstatic 114	java/io/File:separator	Ljava/lang/String;
        //   156: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: aload 6
        //   161: getfield 119	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   164: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   167: bipush 95
        //   169: invokevirtual 122	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   172: aload 6
        //   174: getfield 125	com/tencent/mm/plugin/boots/a/g:nUg	Ljava/lang/String;
        //   177: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   183: astore 7
        //   185: ldc 131
        //   187: ldc 133
        //   189: iconst_4
        //   190: anewarray 4	java/lang/Object
        //   193: dup
        //   194: iconst_0
        //   195: aload 6
        //   197: getfield 119	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   200: aastore
        //   201: dup
        //   202: iconst_1
        //   203: aload_3
        //   204: aastore
        //   205: dup
        //   206: iconst_2
        //   207: aload 7
        //   209: aastore
        //   210: dup
        //   211: iconst_3
        //   212: aload 6
        //   214: getfield 136	com/tencent/mm/plugin/boots/a/g:nUh	Ljava/lang/String;
        //   217: aastore
        //   218: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   221: new 111	java/io/File
        //   224: dup
        //   225: aload 7
        //   227: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
        //   230: astore 8
        //   232: aload 8
        //   234: invokevirtual 147	java/io/File:exists	()Z
        //   237: ifne +9 -> 246
        //   240: aload 8
        //   242: invokevirtual 150	java/io/File:mkdirs	()Z
        //   245: pop
        //   246: aload_3
        //   247: aload 7
        //   249: invokestatic 154	com/tencent/mm/plugin/lite/b:hF	(Ljava/lang/String;Ljava/lang/String;)V
        //   252: new 156	com/tencent/mm/plugin/lite/d/b
        //   255: dup
        //   256: invokespecial 157	com/tencent/mm/plugin/lite/d/b:<init>	()V
        //   259: astore_3
        //   260: aload_3
        //   261: aload 6
        //   263: getfield 119	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   266: putfield 160	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   269: aload_3
        //   270: aload 7
        //   272: putfield 163	com/tencent/mm/plugin/lite/d/b:field_pkgPath	Ljava/lang/String;
        //   275: aload_3
        //   276: aload 6
        //   278: getfield 166	com/tencent/mm/plugin/boots/a/g:nUi	Ljava/lang/String;
        //   281: putfield 169	com/tencent/mm/plugin/lite/d/b:field_signatureKey	Ljava/lang/String;
        //   284: aload_3
        //   285: aload 5
        //   287: getfield 172	com/tencent/mm/plugin/lite/b$a:uYf	Ljava/lang/String;
        //   290: putfield 175	com/tencent/mm/plugin/lite/d/b:field_pkgType	Ljava/lang/String;
        //   293: aload_3
        //   294: invokestatic 181	java/lang/System:currentTimeMillis	()J
        //   297: ldc2_w 182
        //   300: ldiv
        //   301: putfield 187	com/tencent/mm/plugin/lite/d/b:field_updateTime	J
        //   304: aload_3
        //   305: aload 6
        //   307: getfield 136	com/tencent/mm/plugin/boots/a/g:nUh	Ljava/lang/String;
        //   310: putfield 190	com/tencent/mm/plugin/lite/d/b:field_patchId	Ljava/lang/String;
        //   313: invokestatic 196	com/tencent/mm/plugin/lite/logic/c:dfF	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   316: pop
        //   317: new 198	android/os/Bundle
        //   320: dup
        //   321: invokespecial 199	android/os/Bundle:<init>	()V
        //   324: astore 6
        //   326: aload 6
        //   328: ldc 200
        //   330: aload_3
        //   331: getfield 160	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   334: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   337: aload 6
        //   339: ldc 205
        //   341: aload_3
        //   342: getfield 169	com/tencent/mm/plugin/lite/d/b:field_signatureKey	Ljava/lang/String;
        //   345: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   348: aload 6
        //   350: ldc 207
        //   352: aload_3
        //   353: getfield 175	com/tencent/mm/plugin/lite/d/b:field_pkgType	Ljava/lang/String;
        //   356: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   359: aload 6
        //   361: ldc 209
        //   363: aload_3
        //   364: getfield 190	com/tencent/mm/plugin/lite/d/b:field_patchId	Ljava/lang/String;
        //   367: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   370: aload 6
        //   372: ldc 211
        //   374: aload_3
        //   375: getfield 163	com/tencent/mm/plugin/lite/d/b:field_pkgPath	Ljava/lang/String;
        //   378: invokevirtual 203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   381: aload 6
        //   383: ldc 213
        //   385: aload_3
        //   386: getfield 187	com/tencent/mm/plugin/lite/d/b:field_updateTime	J
        //   389: invokevirtual 217	android/os/Bundle:putLong	(Ljava/lang/String;J)V
        //   392: invokestatic 223	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
        //   395: invokevirtual 229	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   398: invokestatic 233	com/tencent/mm/plugin/lite/logic/c:getUri	()Landroid/net/Uri;
        //   401: ldc 235
        //   403: aload_3
        //   404: getfield 160	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   407: aload 6
        //   409: invokevirtual 241	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
        //   412: pop
        //   413: invokestatic 196	com/tencent/mm/plugin/lite/logic/c:dfF	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   416: pop
        //   417: aload_3
        //   418: invokestatic 244	com/tencent/mm/plugin/lite/logic/c:b	(Lcom/tencent/mm/plugin/lite/d/b;)V
        //   421: aload 5
        //   423: getfield 73	com/tencent/mm/plugin/lite/b$a:uYe	Lcom/tencent/mm/plugin/lite/logic/a;
        //   426: ifnull +14 -> 440
        //   429: aload 5
        //   431: getfield 73	com/tencent/mm/plugin/lite/b$a:uYe	Lcom/tencent/mm/plugin/lite/logic/a;
        //   434: aload_3
        //   435: invokeinterface 246 2 0
        //   440: ldc 84
        //   442: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   445: return
        //   446: astore_3
        //   447: ldc 131
        //   449: aload_3
        //   450: ldc 248
        //   452: iconst_0
        //   453: anewarray 4	java/lang/Object
        //   456: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   459: ldc 84
        //   461: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   464: return
        //   465: astore 6
        //   467: ldc 254
        //   469: aload 6
        //   471: ldc_w 256
        //   474: iconst_0
        //   475: anewarray 4	java/lang/Object
        //   478: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   481: goto -68 -> 413
        //   484: astore_3
        //   485: ldc 84
        //   487: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   490: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	491	0	this	1
        //   0	491	1	paramAnonymousLong	long
        //   0	491	3	paramAnonymousString	String
        //   0	491	4	paramAnonymousBoolean	boolean
        //   49	381	5	locala	b.a
        //   121	287	6	localObject	Object
        //   465	5	6	localException	java.lang.Exception
        //   183	88	7	str	String
        //   230	11	8	localFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   246	252	446	java/lang/Exception
        //   440	445	446	java/lang/Exception
        //   392	413	465	java/lang/Exception
        //   252	392	484	java/lang/Exception
        //   413	440	484	java/lang/Exception
        //   467	481	484	java/lang/Exception
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(217141);
        ad.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(217141);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void sL(long paramAnonymousLong)
      {
        AppMethodBeat.i(217144);
        b.this.uXZ.remove(Long.valueOf(paramAnonymousLong));
        AppMethodBeat.o(217144);
      }
      
      public final void sM(long paramAnonymousLong) {}
      
      public final void sN(long paramAnonymousLong) {}
    };
    f.ccl();
    c.a(this.uYa);
    AppMethodBeat.o(217147);
  }
  
  public final void a(com.tencent.mm.plugin.boots.a.g paramg, String paramString, a parama)
  {
    AppMethodBeat.i(217148);
    com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.aak(paramg.gHx);
    locala.aam(paramg.nUg);
    locala.Bp(2);
    locala.jR(false);
    long l = f.ccl().a(locala.pmN);
    this.uXZ.put(Long.valueOf(l), new a(paramg, paramString, parama));
    AppMethodBeat.o(217148);
  }
  
  final class a
  {
    public com.tencent.mm.plugin.boots.a.g uYd;
    public a uYe;
    public String uYf;
    
    public a(com.tencent.mm.plugin.boots.a.g paramg, String paramString, a parama)
    {
      this.uYd = paramg;
      this.uYf = paramString;
      this.uYe = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */