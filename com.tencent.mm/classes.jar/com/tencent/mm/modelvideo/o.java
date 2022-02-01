package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.an.f;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static aq iwH;
  private o.a appForegroundListener;
  private volatile v iwA;
  private volatile t iwB;
  private volatile x iwC;
  private volatile y.a iwD;
  private volatile l iwE;
  private volatile k iwF;
  private volatile m iwG;
  private com.tencent.mm.an.e iwI;
  private i iwJ;
  private p iwK;
  
  static
  {
    AppMethodBeat.i(126943);
    iwH = null;
    baseDBFactories = new HashMap();
    Iterator localIterator = t.d.idw.iterator();
    while (localIterator.hasNext())
    {
      t.c localc = (t.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.iwN.idt;
        }
      });
    }
    baseDBFactories.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return x.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    AppMethodBeat.o(126943);
  }
  
  public o()
  {
    AppMethodBeat.i(126928);
    this.iwA = new v();
    this.iwD = null;
    this.iwE = null;
    this.iwF = null;
    this.iwG = null;
    this.iwI = null;
    this.iwJ = null;
    this.iwK = new p();
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(126926);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          com.tencent.mm.kernel.a.aiT();
        }
        AppMethodBeat.o(126926);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(126925);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT()) {
            com.tencent.mm.blink.b.Wq().u(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126924);
                o.aNm().run();
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
  
  public static boolean E(Runnable paramRunnable)
  {
    AppMethodBeat.i(126939);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126939);
      return true;
    }
    aNo();
    if (iwH == null)
    {
      ae.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      AppMethodBeat.o(126939);
      return false;
    }
    iwH.removeCallbacks(paramRunnable);
    AppMethodBeat.o(126939);
    return true;
  }
  
  public static o aNg()
  {
    AppMethodBeat.i(126929);
    o localo = (o)u.ap(o.class);
    AppMethodBeat.o(126929);
    return localo;
  }
  
  public static t aNh()
  {
    try
    {
      AppMethodBeat.i(126930);
      if (!g.ajM())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126930);
        throw localb;
      }
    }
    finally {}
    if (aNg().iwB == null) {
      aNg().iwB = new t(g.ajR().gDX);
    }
    t localt = aNg().iwB;
    AppMethodBeat.o(126930);
    return localt;
  }
  
  public static com.tencent.mm.an.e aNi()
  {
    int j = 0;
    AppMethodBeat.i(126931);
    g.ajP().aiU();
    if (aNg().iwI == null) {
      aNg().iwI = new com.tencent.mm.an.e();
    }
    if (f.aHa().hWq == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = f.aHa();
        com.tencent.mm.an.e locale = aNg().iwI;
        ((com.tencent.mm.an.a)localObject).hWq = locale;
        int k = localObject.hashCode();
        i = j;
        if (locale != null) {
          i = locale.hashCode();
        }
        ae.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      Object localObject = aNg().iwI;
      AppMethodBeat.o(126931);
      return localObject;
    }
  }
  
  public static i aNj()
  {
    AppMethodBeat.i(126932);
    g.ajP().aiU();
    if (aNg().iwJ == null) {
      aNg().iwJ = new i();
    }
    i locali = aNg().iwJ;
    AppMethodBeat.o(126932);
    return locali;
  }
  
  public static x aNk()
  {
    AppMethodBeat.i(126933);
    if (!g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126933);
      throw ((Throwable)localObject);
    }
    if (aNg().iwC == null) {
      aNg().iwC = new x(g.ajR().gDX);
    }
    Object localObject = aNg().iwC;
    AppMethodBeat.o(126933);
    return localObject;
  }
  
  public static l aNl()
  {
    try
    {
      AppMethodBeat.i(126934);
      if (!g.ajM())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126934);
        throw localb;
      }
    }
    finally {}
    if (aNg().iwE == null) {
      aNg().iwE = new l(g.ajR().gDX);
    }
    l locall = aNg().iwE;
    AppMethodBeat.o(126934);
    return locall;
  }
  
  public static y.a aNm()
  {
    AppMethodBeat.i(126935);
    if (!g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126935);
      throw ((Throwable)localObject);
    }
    if (aNg().iwD == null) {
      aNg().iwD = new y.a();
    }
    Object localObject = aNg().iwD;
    AppMethodBeat.o(126935);
    return localObject;
  }
  
  public static m aNn()
  {
    AppMethodBeat.i(126936);
    if (!g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126936);
      throw ((Throwable)localObject);
    }
    if (aNg().iwG == null) {
      aNg().iwG = new m();
    }
    Object localObject = aNg().iwG;
    AppMethodBeat.o(126936);
    return localObject;
  }
  
  private static void aNo()
  {
    AppMethodBeat.i(126937);
    if ((iwH == null) || (iwH.isQuit()))
    {
      aq localaq = new aq("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
      iwH = localaq;
      localaq.setLogging(false);
    }
    AppMethodBeat.o(126937);
  }
  
  public static String aNp()
  {
    AppMethodBeat.i(217481);
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = com.tencent.mm.vfs.o.k(g.ajR().gDT + "subvideo/", true);
    AppMethodBeat.o(217481);
    return localObject;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(126942);
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = com.tencent.mm.vfs.o.k(g.ajR().gDT + "video/", true);
    AppMethodBeat.o(126942);
    return localObject;
  }
  
  public static boolean i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126938);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126938);
      return false;
    }
    aNo();
    if (paramLong > 0L) {
      iwH.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(126938);
      return true;
      iwH.post(paramRunnable);
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
    ae.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    aNm().a(this.iwK);
    this.appForegroundListener.alive();
    e.d.a(Integer.valueOf(43), this.iwA);
    e.d.a(Integer.valueOf(44), this.iwA);
    e.d.a(Integer.valueOf(62), this.iwA);
    e.d.a(Integer.valueOf(486539313), this.iwA);
    if (iwH != null) {
      iwH.removeCallbacksAndMessages(null);
    }
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126927);
        if (!g.ajM())
        {
          AppMethodBeat.o(126927);
          return;
        }
        Object localObject1 = o.aNh();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
        ae.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((t)localObject1).hKK.execSQL("videoinfo2", (String)localObject2);
        o.aNl().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = o.aNl();
        if (1209600000L <= 0L)
        {
          ae.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((l)localObject1).db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = o.aNl().aNb().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            ae.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((j)localObject2).field_fileName });
            com.tencent.mm.vfs.o.deleteFile(k.Hu(((j)localObject2).field_fileName));
            com.tencent.mm.vfs.o.deleteFile(k.Hv(((j)localObject2).field_fileName));
          }
          l = bu.fpO() - 1209600000L;
          ae.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(l));
          ((l)localObject1).db.execSQL("SightDraftInfo", (String)localObject2);
        }
        AppMethodBeat.o(126927);
      }
    });
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(k.aNa());
    if ((!localk.exists()) || (!localk.isDirectory())) {
      localk.mkdirs();
    }
    AppMethodBeat.o(126941);
  }
  
  /* Error */
  public void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 404
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 157
    //   8: ldc_w 406
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 238	java/lang/Object:hashCode	()I
    //   21: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 245	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: invokestatic 353	com/tencent/mm/modelvideo/o:aNm	()Lcom/tencent/mm/modelvideo/y$a;
    //   31: aload_0
    //   32: getfield 144	com/tencent/mm/modelvideo/o:iwK	Lcom/tencent/mm/modelvideo/p;
    //   35: invokevirtual 409	com/tencent/mm/modelvideo/y$a:b	(Lcom/tencent/mm/modelvideo/w;)V
    //   38: aload_0
    //   39: getfield 149	com/tencent/mm/modelvideo/o:appForegroundListener	Lcom/tencent/mm/app/o$a;
    //   42: invokevirtual 412	com/tencent/mm/app/o$a:dead	()V
    //   45: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   48: getfield 129	com/tencent/mm/modelvideo/o:iwD	Lcom/tencent/mm/modelvideo/y$a;
    //   51: ifnull +83 -> 134
    //   54: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   57: getfield 129	com/tencent/mm/modelvideo/o:iwD	Lcom/tencent/mm/modelvideo/y$a;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: putfield 416	com/tencent/mm/modelvideo/y$a:dju	I
    //   66: aload_1
    //   67: getfield 420	com/tencent/mm/modelvideo/y$a:ixL	Lcom/tencent/mm/modelvideo/d;
    //   70: ifnull +13 -> 83
    //   73: invokestatic 424	com/tencent/mm/kernel/g:ajj	()Lcom/tencent/mm/ak/q;
    //   76: aload_1
    //   77: getfield 420	com/tencent/mm/modelvideo/y$a:ixL	Lcom/tencent/mm/modelvideo/d;
    //   80: invokevirtual 429	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;)V
    //   83: aload_1
    //   84: getfield 433	com/tencent/mm/modelvideo/y$a:ixM	Lcom/tencent/mm/modelvideo/g;
    //   87: ifnull +13 -> 100
    //   90: invokestatic 424	com/tencent/mm/kernel/g:ajj	()Lcom/tencent/mm/ak/q;
    //   93: aload_1
    //   94: getfield 433	com/tencent/mm/modelvideo/y$a:ixM	Lcom/tencent/mm/modelvideo/g;
    //   97: invokevirtual 429	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;)V
    //   100: invokestatic 424	com/tencent/mm/kernel/g:ajj	()Lcom/tencent/mm/ak/q;
    //   103: sipush 149
    //   106: aload_1
    //   107: invokevirtual 436	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
    //   110: invokestatic 424	com/tencent/mm/kernel/g:ajj	()Lcom/tencent/mm/ak/q;
    //   113: sipush 150
    //   116: aload_1
    //   117: invokevirtual 436	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
    //   120: invokestatic 438	com/tencent/mm/modelvideo/o:aNh	()Lcom/tencent/mm/modelvideo/t;
    //   123: aload_1
    //   124: invokevirtual 441	com/tencent/mm/modelvideo/t:a	(Lcom/tencent/mm/modelvideo/t$a;)V
    //   127: aload_1
    //   128: getfield 445	com/tencent/mm/modelvideo/y$a:ixN	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 450	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   134: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   137: getfield 135	com/tencent/mm/modelvideo/o:iwG	Lcom/tencent/mm/modelvideo/m;
    //   140: ifnull +56 -> 196
    //   143: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   146: getfield 135	com/tencent/mm/modelvideo/o:iwG	Lcom/tencent/mm/modelvideo/m;
    //   149: astore_1
    //   150: aload_1
    //   151: iconst_0
    //   152: putfield 451	com/tencent/mm/modelvideo/m:dju	I
    //   155: ldc_w 453
    //   158: ldc_w 455
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: getfield 458	com/tencent/mm/modelvideo/m:iwe	Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 245	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_1
    //   176: getfield 458	com/tencent/mm/modelvideo/m:iwe	Ljava/lang/String;
    //   179: invokestatic 464	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifne +14 -> 196
    //   185: invokestatic 468	com/tencent/mm/an/f:aGZ	()Lcom/tencent/mm/an/b;
    //   188: aload_1
    //   189: getfield 458	com/tencent/mm/modelvideo/m:iwe	Ljava/lang/String;
    //   192: invokevirtual 473	com/tencent/mm/an/b:Fr	(Ljava/lang/String;)Z
    //   195: pop
    //   196: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   199: getfield 139	com/tencent/mm/modelvideo/o:iwJ	Lcom/tencent/mm/modelvideo/i;
    //   202: ifnull +21 -> 223
    //   205: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   208: getfield 139	com/tencent/mm/modelvideo/o:iwJ	Lcom/tencent/mm/modelvideo/i;
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 476	com/tencent/mm/modelvideo/i:stopDownload	()V
    //   216: aload_1
    //   217: getfield 480	com/tencent/mm/modelvideo/i:ivO	Ljava/util/LinkedList;
    //   220: invokevirtual 483	java/util/LinkedList:clear	()V
    //   223: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   226: getfield 137	com/tencent/mm/modelvideo/o:iwI	Lcom/tencent/mm/an/e;
    //   229: ifnull +12 -> 241
    //   232: invokestatic 193	com/tencent/mm/modelvideo/o:aNg	()Lcom/tencent/mm/modelvideo/o;
    //   235: getfield 137	com/tencent/mm/modelvideo/o:iwI	Lcom/tencent/mm/an/e;
    //   238: invokevirtual 486	com/tencent/mm/an/e:release	()V
    //   241: bipush 43
    //   243: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aload_0
    //   247: getfield 127	com/tencent/mm/modelvideo/o:iwA	Lcom/tencent/mm/modelvideo/v;
    //   250: invokestatic 488	com/tencent/mm/ak/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ak/e;)V
    //   253: bipush 44
    //   255: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload_0
    //   259: getfield 127	com/tencent/mm/modelvideo/o:iwA	Lcom/tencent/mm/modelvideo/v;
    //   262: invokestatic 488	com/tencent/mm/ak/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ak/e;)V
    //   265: bipush 62
    //   267: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 127	com/tencent/mm/modelvideo/o:iwA	Lcom/tencent/mm/modelvideo/v;
    //   274: invokestatic 488	com/tencent/mm/ak/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ak/e;)V
    //   277: ldc_w 368
    //   280: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/modelvideo/o:iwA	Lcom/tencent/mm/modelvideo/v;
    //   287: invokestatic 488	com/tencent/mm/ak/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ak/e;)V
    //   290: getstatic 56	com/tencent/mm/modelvideo/o:iwH	Lcom/tencent/mm/sdk/platformtools/aq;
    //   293: ifnull +10 -> 303
    //   296: getstatic 56	com/tencent/mm/modelvideo/o:iwH	Lcom/tencent/mm/sdk/platformtools/aq;
    //   299: aconst_null
    //   300: invokevirtual 372	com/tencent/mm/sdk/platformtools/aq:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   303: invokestatic 353	com/tencent/mm/modelvideo/o:aNm	()Lcom/tencent/mm/modelvideo/y$a;
    //   306: astore_1
    //   307: ldc_w 490
    //   310: ldc_w 492
    //   313: invokestatic 494	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: getfield 497	com/tencent/mm/modelvideo/y$a:ixG	Lcom/tencent/mm/sdk/platformtools/aq;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +66 -> 388
    //   325: aload_1
    //   326: getfield 497	com/tencent/mm/modelvideo/y$a:ixG	Lcom/tencent/mm/sdk/platformtools/aq;
    //   329: invokevirtual 500	com/tencent/mm/sdk/platformtools/aq:quit	()Z
    //   332: pop
    //   333: aload_1
    //   334: iconst_0
    //   335: putfield 504	com/tencent/mm/modelvideo/y$a:ixH	Z
    //   338: aload_1
    //   339: aconst_null
    //   340: putfield 497	com/tencent/mm/modelvideo/y$a:ixG	Lcom/tencent/mm/sdk/platformtools/aq;
    //   343: ldc_w 404
    //   346: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: astore_1
    //   351: ldc 157
    //   353: aload_1
    //   354: ldc_w 506
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 510	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -123 -> 241
    //   367: astore_1
    //   368: ldc_w 490
    //   371: ldc_w 512
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: invokevirtual 515	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc_w 404
    //   391: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    //   395: astore_1
    //   396: ldc 157
    //   398: ldc_w 519
    //   401: iconst_1
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload_1
    //   408: invokevirtual 515	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   411: aastore
    //   412: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: ldc_w 404
    //   418: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	o
    //   60	279	1	localObject	Object
    //   350	4	1	localException1	java.lang.Exception
    //   367	14	1	localException2	java.lang.Exception
    //   395	13	1	localException3	java.lang.Exception
    //   320	2	2	localaq	aq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o
 * JD-Core Version:    0.7.0.1
 */