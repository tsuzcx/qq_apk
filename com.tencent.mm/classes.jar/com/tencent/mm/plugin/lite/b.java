package com.tencent.mm.plugin.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.lite.logic.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  public Map<Long, a> tVx;
  private m tVy;
  
  static
  {
    AppMethodBeat.i(205673);
    tVw = new b("INSTANCE");
    tVz = new b[] { tVw };
    AppMethodBeat.o(205673);
  }
  
  private b()
  {
    AppMethodBeat.i(205670);
    this.tVx = new ConcurrentHashMap();
    this.tVy = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205666);
        if (!b.this.tVx.containsKey(Long.valueOf(paramAnonymousLong)))
        {
          AppMethodBeat.o(205666);
          return;
        }
        h.wUl.n(1293L, 95L, 1L);
        b.a locala = (b.a)b.this.tVx.get(Long.valueOf(paramAnonymousLong));
        b.this.tVx.remove(Long.valueOf(paramAnonymousLong));
        if (locala.tVC != null) {
          locala.tVC.cOG();
        }
        AppMethodBeat.o(205666);
      }
      
      /* Error */
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        // Byte code:
        //   0: ldc 83
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/plugin/lite/b$1:tVA	Lcom/tencent/mm/plugin/lite/b;
        //   9: getfield 31	com/tencent/mm/plugin/lite/b:tVx	Ljava/util/Map;
        //   12: lload_1
        //   13: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   16: invokeinterface 43 2 0
        //   21: ifne +9 -> 30
        //   24: ldc 83
        //   26: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_0
        //   31: getfield 14	com/tencent/mm/plugin/lite/b$1:tVA	Lcom/tencent/mm/plugin/lite/b;
        //   34: getfield 31	com/tencent/mm/plugin/lite/b:tVx	Ljava/util/Map;
        //   37: lload_1
        //   38: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   41: invokeinterface 64 2 0
        //   46: checkcast 66	com/tencent/mm/plugin/lite/b$a
        //   49: astore 5
        //   51: aload_3
        //   52: ifnull +10 -> 62
        //   55: aload_3
        //   56: invokevirtual 89	java/lang/String:isEmpty	()Z
        //   59: ifeq +44 -> 103
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/lite/b$1:tVA	Lcom/tencent/mm/plugin/lite/b;
        //   66: getfield 31	com/tencent/mm/plugin/lite/b:tVx	Ljava/util/Map;
        //   69: lload_1
        //   70: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   73: invokeinterface 69 2 0
        //   78: pop
        //   79: aload 5
        //   81: getfield 73	com/tencent/mm/plugin/lite/b$a:tVC	Lcom/tencent/mm/plugin/lite/logic/a;
        //   84: ifnull +13 -> 97
        //   87: aload 5
        //   89: getfield 73	com/tencent/mm/plugin/lite/b$a:tVC	Lcom/tencent/mm/plugin/lite/logic/a;
        //   92: invokeinterface 78 1 0
        //   97: ldc 83
        //   99: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: return
        //   103: getstatic 52	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
        //   106: ldc2_w 53
        //   109: ldc2_w 90
        //   112: lconst_1
        //   113: invokevirtual 60	com/tencent/mm/plugin/report/service/h:n	(JJJ)V
        //   116: aload 5
        //   118: getfield 95	com/tencent/mm/plugin/lite/b$a:tVB	Lcom/tencent/mm/plugin/boots/a/g;
        //   121: astore 6
        //   123: aload_0
        //   124: getfield 14	com/tencent/mm/plugin/lite/b$1:tVA	Lcom/tencent/mm/plugin/lite/b;
        //   127: getfield 31	com/tencent/mm/plugin/lite/b:tVx	Ljava/util/Map;
        //   130: lload_1
        //   131: invokestatic 37	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   134: invokeinterface 69 2 0
        //   139: pop
        //   140: ldc 97
        //   142: ldc 99
        //   144: iconst_2
        //   145: anewarray 4	java/lang/Object
        //   148: dup
        //   149: iconst_0
        //   150: aload 6
        //   152: getfield 105	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   155: aastore
        //   156: dup
        //   157: iconst_1
        //   158: aload_3
        //   159: aastore
        //   160: invokestatic 110	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   163: new 112	java/lang/StringBuilder
        //   166: dup
        //   167: invokespecial 113	java/lang/StringBuilder:<init>	()V
        //   170: getstatic 118	com/tencent/mm/storage/ah:GDw	Ljava/lang/String;
        //   173: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: getstatic 127	java/io/File:separator	Ljava/lang/String;
        //   179: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: aload 6
        //   184: getfield 105	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   187: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: bipush 95
        //   192: invokevirtual 130	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   195: aload 6
        //   197: getfield 133	com/tencent/mm/plugin/boots/a/g:ntk	Ljava/lang/String;
        //   200: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   206: astore 7
        //   208: new 124	java/io/File
        //   211: dup
        //   212: aload 7
        //   214: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
        //   217: astore 8
        //   219: aload 8
        //   221: invokevirtual 143	java/io/File:exists	()Z
        //   224: ifne +9 -> 233
        //   227: aload 8
        //   229: invokevirtual 146	java/io/File:mkdirs	()Z
        //   232: pop
        //   233: aload_3
        //   234: aload 7
        //   236: invokestatic 150	com/tencent/mm/plugin/lite/b:ht	(Ljava/lang/String;Ljava/lang/String;)V
        //   239: new 152	com/tencent/mm/plugin/lite/d/b
        //   242: dup
        //   243: invokespecial 153	com/tencent/mm/plugin/lite/d/b:<init>	()V
        //   246: astore_3
        //   247: aload_3
        //   248: aload 6
        //   250: getfield 105	com/tencent/mm/plugin/boots/a/g:appId	Ljava/lang/String;
        //   253: putfield 156	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   256: aload_3
        //   257: aload 7
        //   259: putfield 159	com/tencent/mm/plugin/lite/d/b:field_pkgPath	Ljava/lang/String;
        //   262: aload_3
        //   263: aload 6
        //   265: getfield 162	com/tencent/mm/plugin/boots/a/g:ntm	Ljava/lang/String;
        //   268: putfield 165	com/tencent/mm/plugin/lite/d/b:field_signatureKey	Ljava/lang/String;
        //   271: aload_3
        //   272: aload 5
        //   274: getfield 168	com/tencent/mm/plugin/lite/b$a:tVD	Ljava/lang/String;
        //   277: putfield 171	com/tencent/mm/plugin/lite/d/b:field_pkgType	Ljava/lang/String;
        //   280: aload_3
        //   281: invokestatic 177	java/lang/System:currentTimeMillis	()J
        //   284: ldc2_w 178
        //   287: ldiv
        //   288: putfield 183	com/tencent/mm/plugin/lite/d/b:field_updateTime	J
        //   291: aload_3
        //   292: aload 6
        //   294: getfield 186	com/tencent/mm/plugin/boots/a/g:ntl	Ljava/lang/String;
        //   297: putfield 189	com/tencent/mm/plugin/lite/d/b:field_patchId	Ljava/lang/String;
        //   300: invokestatic 195	com/tencent/mm/plugin/lite/logic/c:cWu	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   303: pop
        //   304: new 197	android/os/Bundle
        //   307: dup
        //   308: invokespecial 198	android/os/Bundle:<init>	()V
        //   311: astore 6
        //   313: aload 6
        //   315: ldc 199
        //   317: aload_3
        //   318: getfield 156	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   321: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   324: aload 6
        //   326: ldc 204
        //   328: aload_3
        //   329: getfield 165	com/tencent/mm/plugin/lite/d/b:field_signatureKey	Ljava/lang/String;
        //   332: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   335: aload 6
        //   337: ldc 206
        //   339: aload_3
        //   340: getfield 171	com/tencent/mm/plugin/lite/d/b:field_pkgType	Ljava/lang/String;
        //   343: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   346: aload 6
        //   348: ldc 208
        //   350: aload_3
        //   351: getfield 189	com/tencent/mm/plugin/lite/d/b:field_patchId	Ljava/lang/String;
        //   354: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   357: aload 6
        //   359: ldc 210
        //   361: aload_3
        //   362: getfield 159	com/tencent/mm/plugin/lite/d/b:field_pkgPath	Ljava/lang/String;
        //   365: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   368: aload 6
        //   370: ldc 212
        //   372: aload_3
        //   373: getfield 183	com/tencent/mm/plugin/lite/d/b:field_updateTime	J
        //   376: invokevirtual 216	android/os/Bundle:putLong	(Ljava/lang/String;J)V
        //   379: invokestatic 222	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
        //   382: invokevirtual 228	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   385: invokestatic 232	com/tencent/mm/plugin/lite/logic/c:getUri	()Landroid/net/Uri;
        //   388: ldc 234
        //   390: aload_3
        //   391: getfield 156	com/tencent/mm/plugin/lite/d/b:field_appId	Ljava/lang/String;
        //   394: aload 6
        //   396: invokevirtual 240	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
        //   399: pop
        //   400: invokestatic 195	com/tencent/mm/plugin/lite/logic/c:cWu	()Lcom/tencent/mm/plugin/lite/logic/c;
        //   403: pop
        //   404: aload_3
        //   405: invokestatic 244	com/tencent/mm/plugin/lite/logic/c:d	(Lcom/tencent/mm/plugin/lite/d/b;)V
        //   408: aload 5
        //   410: getfield 73	com/tencent/mm/plugin/lite/b$a:tVC	Lcom/tencent/mm/plugin/lite/logic/a;
        //   413: ifnull +14 -> 427
        //   416: aload 5
        //   418: getfield 73	com/tencent/mm/plugin/lite/b$a:tVC	Lcom/tencent/mm/plugin/lite/logic/a;
        //   421: aload_3
        //   422: invokeinterface 246 2 0
        //   427: ldc 83
        //   429: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   432: return
        //   433: astore_3
        //   434: ldc 97
        //   436: aload_3
        //   437: ldc 248
        //   439: iconst_0
        //   440: anewarray 4	java/lang/Object
        //   443: invokestatic 252	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   446: ldc 83
        //   448: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   451: return
        //   452: astore 6
        //   454: ldc 254
        //   456: aload 6
        //   458: ldc_w 256
        //   461: iconst_0
        //   462: anewarray 4	java/lang/Object
        //   465: invokestatic 252	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   468: goto -68 -> 400
        //   471: astore_3
        //   472: ldc 83
        //   474: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   477: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	478	0	this	1
        //   0	478	1	paramAnonymousLong	long
        //   0	478	3	paramAnonymousString	String
        //   0	478	4	paramAnonymousBoolean	boolean
        //   49	368	5	locala	b.a
        //   121	274	6	localObject	Object
        //   452	5	6	localException	java.lang.Exception
        //   206	52	7	str	String
        //   217	11	8	localFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   233	239	433	java/lang/Exception
        //   427	432	433	java/lang/Exception
        //   379	400	452	java/lang/Exception
        //   239	379	471	java/lang/Exception
        //   400	427	471	java/lang/Exception
        //   454	468	471	java/lang/Exception
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void onTaskPaused(long paramAnonymousLong) {}
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(205667);
        b.this.tVx.remove(Long.valueOf(paramAnonymousLong));
        AppMethodBeat.o(205667);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(205664);
        ac.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(205664);
      }
      
      public final void qN(long paramAnonymousLong) {}
      
      public final void qO(long paramAnonymousLong) {}
    };
    f.bXJ();
    c.a(this.tVy);
    AppMethodBeat.o(205670);
  }
  
  public final void a(g paramg, String paramString, a parama)
  {
    AppMethodBeat.i(205671);
    h.wUl.n(1293L, 93L, 1L);
    g.a locala = new g.a();
    locala.WD(paramg.gnO);
    locala.WF(paramg.ntk);
    locala.AG(2);
    locala.jG(false);
    long l = f.bXJ().a(locala.oJg);
    this.tVx.put(Long.valueOf(l), new a(paramg, paramString, parama));
    AppMethodBeat.o(205671);
  }
  
  final class a
  {
    public g tVB;
    public a tVC;
    public String tVD;
    
    public a(g paramg, String paramString, a parama)
    {
      this.tVB = paramg;
      this.tVD = paramString;
      this.tVC = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */