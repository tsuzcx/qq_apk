package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.be;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class v
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static MMHandler paK;
  private q.a appForegroundListener;
  private volatile ac paD;
  private volatile aa paE;
  private volatile af paF;
  private volatile ag.a paG;
  private volatile s paH;
  private volatile r paI;
  private volatile t paJ;
  private j paL;
  private p paM;
  private w paN;
  
  static
  {
    AppMethodBeat.i(126943);
    paK = null;
    baseDBFactories = new HashMap();
    Iterator localIterator = aa.d.oHy.iterator();
    while (localIterator.hasNext())
    {
      aa.c localc = (aa.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return v.this.oHv;
        }
      });
    }
    baseDBFactories.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return af.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return s.SQL_CREATE;
      }
    });
    AppMethodBeat.o(126943);
  }
  
  public v()
  {
    AppMethodBeat.i(126928);
    this.paD = new ac();
    this.paG = null;
    this.paH = null;
    this.paI = null;
    this.paJ = null;
    this.paL = null;
    this.paM = null;
    this.paN = new w();
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(126926);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(126926);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(126925);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126924);
                v.bOm().run();
                AppMethodBeat.o(126924);
              }
            });
          }
        }
        AppMethodBeat.o(126925);
      }
    };
    AppMethodBeat.o(126928);
  }
  
  public static boolean N(Runnable paramRunnable)
  {
    AppMethodBeat.i(126939);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126939);
      return true;
    }
    bOo();
    if (paK == null)
    {
      Log.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      AppMethodBeat.o(126939);
      return false;
    }
    paK.removeCallbacks(paramRunnable);
    AppMethodBeat.o(126939);
    return true;
  }
  
  public static v bOg()
  {
    AppMethodBeat.i(126929);
    v localv = (v)com.tencent.mm.model.y.aL(v.class);
    AppMethodBeat.o(126929);
    return localv;
  }
  
  public static aa bOh()
  {
    try
    {
      AppMethodBeat.i(126930);
      if (!com.tencent.mm.kernel.h.baz())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126930);
        throw localb;
      }
    }
    finally {}
    if (bOg().paE == null) {
      bOg().paE = new aa(com.tencent.mm.kernel.h.baE().mCN);
    }
    aa localaa = bOg().paE;
    AppMethodBeat.o(126930);
    return localaa;
  }
  
  public static j bOi()
  {
    int j = 0;
    AppMethodBeat.i(126931);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bOg().paL == null) {
      bOg().paL = new j();
    }
    if (k.bHX().ozH == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = k.bHX();
        j localj = bOg().paL;
        ((d)localObject).ozH = localj;
        int k = localObject.hashCode();
        i = j;
        if (localj != null) {
          i = localj.hashCode();
        }
        Log.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      Object localObject = bOg().paL;
      AppMethodBeat.o(126931);
      return localObject;
    }
  }
  
  public static p bOj()
  {
    AppMethodBeat.i(126932);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bOg().paM == null) {
      bOg().paM = new p();
    }
    p localp = bOg().paM;
    AppMethodBeat.o(126932);
    return localp;
  }
  
  public static af bOk()
  {
    AppMethodBeat.i(126933);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126933);
      throw ((Throwable)localObject);
    }
    if (bOg().paF == null) {
      bOg().paF = new af(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = bOg().paF;
    AppMethodBeat.o(126933);
    return localObject;
  }
  
  public static s bOl()
  {
    try
    {
      AppMethodBeat.i(126934);
      if (!com.tencent.mm.kernel.h.baz())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126934);
        throw localb;
      }
    }
    finally {}
    if (bOg().paH == null) {
      bOg().paH = new s(com.tencent.mm.kernel.h.baE().mCN);
    }
    s locals = bOg().paH;
    AppMethodBeat.o(126934);
    return locals;
  }
  
  public static ag.a bOm()
  {
    AppMethodBeat.i(126935);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126935);
      throw ((Throwable)localObject);
    }
    if (bOg().paG == null) {
      bOg().paG = new ag.a();
    }
    Object localObject = bOg().paG;
    AppMethodBeat.o(126935);
    return localObject;
  }
  
  public static t bOn()
  {
    AppMethodBeat.i(126936);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126936);
      throw ((Throwable)localObject);
    }
    if (bOg().paJ == null) {
      bOg().paJ = new t();
    }
    Object localObject = bOg().paJ;
    AppMethodBeat.o(126936);
    return localObject;
  }
  
  private static void bOo()
  {
    AppMethodBeat.i(126937);
    if ((paK == null) || (paK.isQuit()))
    {
      MMHandler localMMHandler = new MMHandler("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
      paK = localMMHandler;
      localMMHandler.setLogging(false);
    }
    AppMethodBeat.o(126937);
  }
  
  public static String bOp()
  {
    AppMethodBeat.i(241285);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.vfs.y.n(com.tencent.mm.kernel.h.baE().mCJ + "subvideo/", true);
    AppMethodBeat.o(241285);
    return localObject;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(126942);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.vfs.y.n(com.tencent.mm.kernel.h.baE().mCJ + "video/", true);
    AppMethodBeat.o(126942);
    return localObject;
  }
  
  public static boolean h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126938);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126938);
      return false;
    }
    bOo();
    if (paramLong > 0L) {
      paK.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(126938);
      return true;
      paK.post(paramRunnable);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(126941);
    Log.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    bOm().a(this.paN);
    this.appForegroundListener.alive();
    g.d.a(Integer.valueOf(43), this.paD);
    g.d.a(Integer.valueOf(44), this.paD);
    g.d.a(Integer.valueOf(62), this.paD);
    g.d.a(Integer.valueOf(486539313), this.paD);
    if (paK != null) {
      paK.removeCallbacksAndMessages(null);
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126927);
        if (!com.tencent.mm.kernel.h.baz())
        {
          AppMethodBeat.o(126927);
          return;
        }
        Object localObject1 = v.bOh();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
        Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((aa)localObject1).omV.execSQL("videoinfo2", (String)localObject2);
        v.bOl().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = v.bOl();
        if (1209600000L <= 0L)
        {
          Log.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((s)localObject1).db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = v.bOl().bOb().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (q)((Iterator)localObject1).next();
            Log.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((q)localObject2).field_fileName });
            com.tencent.mm.vfs.y.deleteFile(r.PG(((q)localObject2).field_fileName));
            com.tencent.mm.vfs.y.deleteFile(r.PH(((q)localObject2).field_fileName));
          }
          l = Util.nowMilliSecond() - 1209600000L;
          Log.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(l));
          ((s)localObject1).db.execSQL("SightDraftInfo", (String)localObject2);
        }
        AppMethodBeat.o(126927);
      }
    });
    u localu = new u(r.bOa());
    if ((!localu.jKS()) || (!localu.isDirectory())) {
      localu.jKY();
    }
    AppMethodBeat.o(126941);
  }
  
  /* Error */
  public void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 405
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 157
    //   8: ldc_w 407
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 238	java/lang/Object:hashCode	()I
    //   21: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: invokestatic 354	com/tencent/mm/modelvideo/v:bOm	()Lcom/tencent/mm/modelvideo/ag$a;
    //   31: aload_0
    //   32: getfield 144	com/tencent/mm/modelvideo/v:paN	Lcom/tencent/mm/modelvideo/w;
    //   35: invokevirtual 410	com/tencent/mm/modelvideo/ag$a:b	(Lcom/tencent/mm/modelvideo/ad;)V
    //   38: aload_0
    //   39: getfield 149	com/tencent/mm/modelvideo/v:appForegroundListener	Lcom/tencent/mm/app/q$a;
    //   42: invokevirtual 413	com/tencent/mm/app/q$a:dead	()V
    //   45: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   48: getfield 129	com/tencent/mm/modelvideo/v:paG	Lcom/tencent/mm/modelvideo/ag$a;
    //   51: ifnull +83 -> 134
    //   54: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   57: getfield 129	com/tencent/mm/modelvideo/v:paG	Lcom/tencent/mm/modelvideo/ag$a;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: putfield 417	com/tencent/mm/modelvideo/ag$a:hxJ	I
    //   66: aload_1
    //   67: getfield 421	com/tencent/mm/modelvideo/ag$a:pcb	Lcom/tencent/mm/modelvideo/h;
    //   70: ifnull +13 -> 83
    //   73: invokestatic 425	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   76: aload_1
    //   77: getfield 421	com/tencent/mm/modelvideo/ag$a:pcb	Lcom/tencent/mm/modelvideo/h;
    //   80: invokevirtual 430	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;)V
    //   83: aload_1
    //   84: getfield 434	com/tencent/mm/modelvideo/ag$a:pcc	Lcom/tencent/mm/modelvideo/k;
    //   87: ifnull +13 -> 100
    //   90: invokestatic 425	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   93: aload_1
    //   94: getfield 434	com/tencent/mm/modelvideo/ag$a:pcc	Lcom/tencent/mm/modelvideo/k;
    //   97: invokevirtual 430	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;)V
    //   100: invokestatic 425	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   103: sipush 149
    //   106: aload_1
    //   107: invokevirtual 437	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   110: invokestatic 425	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   113: sipush 150
    //   116: aload_1
    //   117: invokevirtual 437	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   120: invokestatic 439	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   123: aload_1
    //   124: invokevirtual 442	com/tencent/mm/modelvideo/aa:a	(Lcom/tencent/mm/modelvideo/aa$a;)V
    //   127: aload_1
    //   128: getfield 446	com/tencent/mm/modelvideo/ag$a:pcd	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 451	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   134: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   137: getfield 135	com/tencent/mm/modelvideo/v:paJ	Lcom/tencent/mm/modelvideo/t;
    //   140: ifnull +56 -> 196
    //   143: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   146: getfield 135	com/tencent/mm/modelvideo/v:paJ	Lcom/tencent/mm/modelvideo/t;
    //   149: astore_1
    //   150: aload_1
    //   151: iconst_0
    //   152: putfield 452	com/tencent/mm/modelvideo/t:hxJ	I
    //   155: ldc_w 454
    //   158: ldc_w 456
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: getfield 459	com/tencent/mm/modelvideo/t:pad	Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_1
    //   176: getfield 459	com/tencent/mm/modelvideo/t:pad	Ljava/lang/String;
    //   179: invokestatic 465	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifne +14 -> 196
    //   185: invokestatic 469	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   188: aload_1
    //   189: getfield 459	com/tencent/mm/modelvideo/t:pad	Ljava/lang/String;
    //   192: invokevirtual 474	com/tencent/mm/modelcdntran/g:Ny	(Ljava/lang/String;)Z
    //   195: pop
    //   196: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   199: getfield 139	com/tencent/mm/modelvideo/v:paM	Lcom/tencent/mm/modelvideo/p;
    //   202: ifnull +21 -> 223
    //   205: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   208: getfield 139	com/tencent/mm/modelvideo/v:paM	Lcom/tencent/mm/modelvideo/p;
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 477	com/tencent/mm/modelvideo/p:stopDownload	()V
    //   216: aload_1
    //   217: getfield 481	com/tencent/mm/modelvideo/p:oZN	Ljava/util/LinkedList;
    //   220: invokevirtual 484	java/util/LinkedList:clear	()V
    //   223: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   226: getfield 137	com/tencent/mm/modelvideo/v:paL	Lcom/tencent/mm/modelcdntran/j;
    //   229: ifnull +12 -> 241
    //   232: invokestatic 193	com/tencent/mm/modelvideo/v:bOg	()Lcom/tencent/mm/modelvideo/v;
    //   235: getfield 137	com/tencent/mm/modelvideo/v:paL	Lcom/tencent/mm/modelcdntran/j;
    //   238: invokevirtual 487	com/tencent/mm/modelcdntran/j:release	()V
    //   241: bipush 43
    //   243: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aload_0
    //   247: getfield 127	com/tencent/mm/modelvideo/v:paD	Lcom/tencent/mm/modelvideo/ac;
    //   250: invokestatic 489	com/tencent/mm/am/g$d:b	(Ljava/lang/Object;Lcom/tencent/mm/am/g;)V
    //   253: bipush 44
    //   255: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload_0
    //   259: getfield 127	com/tencent/mm/modelvideo/v:paD	Lcom/tencent/mm/modelvideo/ac;
    //   262: invokestatic 489	com/tencent/mm/am/g$d:b	(Ljava/lang/Object;Lcom/tencent/mm/am/g;)V
    //   265: bipush 62
    //   267: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 127	com/tencent/mm/modelvideo/v:paD	Lcom/tencent/mm/modelvideo/ac;
    //   274: invokestatic 489	com/tencent/mm/am/g$d:b	(Ljava/lang/Object;Lcom/tencent/mm/am/g;)V
    //   277: ldc_w 369
    //   280: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/modelvideo/v:paD	Lcom/tencent/mm/modelvideo/ac;
    //   287: invokestatic 489	com/tencent/mm/am/g$d:b	(Ljava/lang/Object;Lcom/tencent/mm/am/g;)V
    //   290: getstatic 56	com/tencent/mm/modelvideo/v:paK	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   293: ifnull +10 -> 303
    //   296: getstatic 56	com/tencent/mm/modelvideo/v:paK	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   299: aconst_null
    //   300: invokevirtual 373	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   303: invokestatic 354	com/tencent/mm/modelvideo/v:bOm	()Lcom/tencent/mm/modelvideo/ag$a;
    //   306: astore_1
    //   307: ldc_w 491
    //   310: ldc_w 493
    //   313: invokestatic 495	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: getfield 498	com/tencent/mm/modelvideo/ag$a:pbW	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +66 -> 388
    //   325: aload_1
    //   326: getfield 498	com/tencent/mm/modelvideo/ag$a:pbW	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   329: invokevirtual 501	com/tencent/mm/sdk/platformtools/MMHandler:quit	()Z
    //   332: pop
    //   333: aload_1
    //   334: iconst_0
    //   335: putfield 505	com/tencent/mm/modelvideo/ag$a:pbX	Z
    //   338: aload_1
    //   339: aconst_null
    //   340: putfield 498	com/tencent/mm/modelvideo/ag$a:pbW	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   343: ldc_w 405
    //   346: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: astore_1
    //   351: ldc 157
    //   353: aload_1
    //   354: ldc_w 507
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 511	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -123 -> 241
    //   367: astore_1
    //   368: ldc_w 491
    //   371: ldc_w 513
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc_w 405
    //   391: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    //   395: astore_1
    //   396: ldc 157
    //   398: ldc_w 520
    //   401: iconst_1
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload_1
    //   408: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   411: aastore
    //   412: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: ldc_w 405
    //   418: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	v
    //   60	279	1	localObject	Object
    //   350	4	1	localException1	java.lang.Exception
    //   367	14	1	localException2	java.lang.Exception
    //   395	13	1	localException3	java.lang.Exception
    //   320	2	2	localMMHandler	MMHandler
    // Exception table:
    //   from	to	target	type
    //   45	83	350	java/lang/Exception
    //   83	100	350	java/lang/Exception
    //   100	134	350	java/lang/Exception
    //   134	196	350	java/lang/Exception
    //   196	223	350	java/lang/Exception
    //   223	241	350	java/lang/Exception
    //   325	343	367	java/lang/Exception
    //   303	321	395	java/lang/Exception
    //   343	349	395	java/lang/Exception
    //   368	388	395	java/lang/Exception
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.v
 * JD-Core Version:    0.7.0.1
 */