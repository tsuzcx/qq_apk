package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.ao.f;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static ap hzR;
  private n.a appForegroundListener;
  private volatile v hzK;
  private volatile t hzL;
  private volatile x hzM;
  private volatile y.a hzN;
  private volatile l hzO;
  private volatile k hzP;
  private volatile m hzQ;
  private com.tencent.mm.ao.e hzS;
  private i hzT;
  private p hzU;
  
  static
  {
    AppMethodBeat.i(126943);
    hzR = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
      }
    });
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
    this.hzK = new v();
    this.hzN = null;
    this.hzO = null;
    this.hzP = null;
    this.hzQ = null;
    this.hzS = null;
    this.hzT = null;
    this.hzU = new p();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(126926);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          com.tencent.mm.kernel.a.aeC();
        }
        AppMethodBeat.o(126926);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(126925);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            com.tencent.mm.blink.b.SX().v(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126924);
                o.aCN().run();
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
  
  public static boolean F(Runnable paramRunnable)
  {
    AppMethodBeat.i(126939);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126939);
      return true;
    }
    aCP();
    if (hzR == null)
    {
      ad.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      AppMethodBeat.o(126939);
      return false;
    }
    hzR.removeCallbacks(paramRunnable);
    AppMethodBeat.o(126939);
    return true;
  }
  
  public static o aCH()
  {
    AppMethodBeat.i(126929);
    o localo = (o)com.tencent.mm.model.t.ap(o.class);
    AppMethodBeat.o(126929);
    return localo;
  }
  
  public static t aCI()
  {
    try
    {
      AppMethodBeat.i(126930);
      if (!g.afw())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126930);
        throw localb;
      }
    }
    finally {}
    if (aCH().hzL == null) {
      aCH().hzL = new t(g.afB().gda);
    }
    t localt = aCH().hzL;
    AppMethodBeat.o(126930);
    return localt;
  }
  
  public static com.tencent.mm.ao.e aCJ()
  {
    int j = 0;
    AppMethodBeat.i(126931);
    g.afz().aeD();
    if (aCH().hzS == null) {
      aCH().hzS = new com.tencent.mm.ao.e();
    }
    if (f.awM().haC == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = f.awM();
        com.tencent.mm.ao.e locale = aCH().hzS;
        ((com.tencent.mm.ao.a)localObject).haC = locale;
        int k = localObject.hashCode();
        i = j;
        if (locale != null) {
          i = locale.hashCode();
        }
        ad.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      Object localObject = aCH().hzS;
      AppMethodBeat.o(126931);
      return localObject;
    }
  }
  
  public static i aCK()
  {
    AppMethodBeat.i(126932);
    g.afz().aeD();
    if (aCH().hzT == null) {
      aCH().hzT = new i();
    }
    i locali = aCH().hzT;
    AppMethodBeat.o(126932);
    return locali;
  }
  
  public static x aCL()
  {
    AppMethodBeat.i(126933);
    if (!g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126933);
      throw ((Throwable)localObject);
    }
    if (aCH().hzM == null) {
      aCH().hzM = new x(g.afB().gda);
    }
    Object localObject = aCH().hzM;
    AppMethodBeat.o(126933);
    return localObject;
  }
  
  public static l aCM()
  {
    try
    {
      AppMethodBeat.i(126934);
      if (!g.afw())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126934);
        throw localb;
      }
    }
    finally {}
    if (aCH().hzO == null) {
      aCH().hzO = new l(g.afB().gda);
    }
    l locall = aCH().hzO;
    AppMethodBeat.o(126934);
    return locall;
  }
  
  public static y.a aCN()
  {
    AppMethodBeat.i(126935);
    if (!g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126935);
      throw ((Throwable)localObject);
    }
    if (aCH().hzN == null) {
      aCH().hzN = new y.a();
    }
    Object localObject = aCH().hzN;
    AppMethodBeat.o(126935);
    return localObject;
  }
  
  public static m aCO()
  {
    AppMethodBeat.i(126936);
    if (!g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126936);
      throw ((Throwable)localObject);
    }
    if (aCH().hzQ == null) {
      aCH().hzQ = new m();
    }
    Object localObject = aCH().hzQ;
    AppMethodBeat.o(126936);
    return localObject;
  }
  
  private static void aCP()
  {
    AppMethodBeat.i(126937);
    if ((hzR == null) || (hzR.isQuit()))
    {
      ap localap = new ap("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
      hzR = localap;
      localap.setLogging(false);
    }
    AppMethodBeat.o(126937);
  }
  
  public static String fQN()
  {
    AppMethodBeat.i(202421);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = com.tencent.mm.vfs.i.k(g.afB().gcW + "subvideo/", true);
    AppMethodBeat.o(202421);
    return localObject;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(126942);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = com.tencent.mm.vfs.i.k(g.afB().gcW + "video/", true);
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
    aCP();
    if (paramLong > 0L) {
      hzR.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(126938);
      return true;
      hzR.post(paramRunnable);
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
    ad.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    aCN().a(this.hzU);
    this.appForegroundListener.alive();
    f.d.a(Integer.valueOf(43), this.hzK);
    f.d.a(Integer.valueOf(44), this.hzK);
    f.d.a(Integer.valueOf(62), this.hzK);
    f.d.a(Integer.valueOf(486539313), this.hzK);
    if (hzR != null) {
      hzR.removeCallbacksAndMessages(null);
    }
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126927);
        if (!g.afw())
        {
          AppMethodBeat.o(126927);
          return;
        }
        Object localObject1 = o.aCI();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
        ad.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((t)localObject1).gPa.execSQL("videoinfo2", (String)localObject2);
        o.aCM().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = o.aCM();
        if (1209600000L <= 0L)
        {
          ad.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((l)localObject1).db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = o.aCM().aCC().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            ad.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((j)localObject2).field_fileName });
            com.tencent.mm.vfs.i.deleteFile(k.zH(((j)localObject2).field_fileName));
            com.tencent.mm.vfs.i.deleteFile(k.zI(((j)localObject2).field_fileName));
          }
          l = bt.eGO() - 1209600000L;
          ad.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(l));
          ((l)localObject1).db.execSQL("SightDraftInfo", (String)localObject2);
        }
        AppMethodBeat.o(126927);
      }
    });
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(k.aCB());
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    AppMethodBeat.o(126941);
  }
  
  /* Error */
  public void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 379
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 129
    //   8: ldc_w 381
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 211	java/lang/Object:hashCode	()I
    //   21: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: invokestatic 328	com/tencent/mm/modelvideo/o:aCN	()Lcom/tencent/mm/modelvideo/y$a;
    //   31: aload_0
    //   32: getfield 116	com/tencent/mm/modelvideo/o:hzU	Lcom/tencent/mm/modelvideo/p;
    //   35: invokevirtual 384	com/tencent/mm/modelvideo/y$a:b	(Lcom/tencent/mm/modelvideo/w;)V
    //   38: aload_0
    //   39: getfield 121	com/tencent/mm/modelvideo/o:appForegroundListener	Lcom/tencent/mm/app/n$a;
    //   42: invokevirtual 387	com/tencent/mm/app/n$a:dead	()V
    //   45: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   48: getfield 101	com/tencent/mm/modelvideo/o:hzN	Lcom/tencent/mm/modelvideo/y$a;
    //   51: ifnull +83 -> 134
    //   54: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   57: getfield 101	com/tencent/mm/modelvideo/o:hzN	Lcom/tencent/mm/modelvideo/y$a;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: putfield 391	com/tencent/mm/modelvideo/y$a:cZF	I
    //   66: aload_1
    //   67: getfield 395	com/tencent/mm/modelvideo/y$a:hAU	Lcom/tencent/mm/modelvideo/d;
    //   70: ifnull +13 -> 83
    //   73: invokestatic 399	com/tencent/mm/kernel/g:aeS	()Lcom/tencent/mm/al/q;
    //   76: aload_1
    //   77: getfield 395	com/tencent/mm/modelvideo/y$a:hAU	Lcom/tencent/mm/modelvideo/d;
    //   80: invokevirtual 404	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;)V
    //   83: aload_1
    //   84: getfield 408	com/tencent/mm/modelvideo/y$a:hAV	Lcom/tencent/mm/modelvideo/g;
    //   87: ifnull +13 -> 100
    //   90: invokestatic 399	com/tencent/mm/kernel/g:aeS	()Lcom/tencent/mm/al/q;
    //   93: aload_1
    //   94: getfield 408	com/tencent/mm/modelvideo/y$a:hAV	Lcom/tencent/mm/modelvideo/g;
    //   97: invokevirtual 404	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;)V
    //   100: invokestatic 399	com/tencent/mm/kernel/g:aeS	()Lcom/tencent/mm/al/q;
    //   103: sipush 149
    //   106: aload_1
    //   107: invokevirtual 411	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/g;)V
    //   110: invokestatic 399	com/tencent/mm/kernel/g:aeS	()Lcom/tencent/mm/al/q;
    //   113: sipush 150
    //   116: aload_1
    //   117: invokevirtual 411	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/g;)V
    //   120: invokestatic 413	com/tencent/mm/modelvideo/o:aCI	()Lcom/tencent/mm/modelvideo/t;
    //   123: aload_1
    //   124: invokevirtual 416	com/tencent/mm/modelvideo/t:a	(Lcom/tencent/mm/modelvideo/t$a;)V
    //   127: aload_1
    //   128: getfield 420	com/tencent/mm/modelvideo/y$a:hAW	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 425	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   134: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   137: getfield 107	com/tencent/mm/modelvideo/o:hzQ	Lcom/tencent/mm/modelvideo/m;
    //   140: ifnull +56 -> 196
    //   143: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   146: getfield 107	com/tencent/mm/modelvideo/o:hzQ	Lcom/tencent/mm/modelvideo/m;
    //   149: astore_1
    //   150: aload_1
    //   151: iconst_0
    //   152: putfield 426	com/tencent/mm/modelvideo/m:cZF	I
    //   155: ldc_w 428
    //   158: ldc_w 430
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: getfield 433	com/tencent/mm/modelvideo/m:hzo	Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_1
    //   176: getfield 433	com/tencent/mm/modelvideo/m:hzo	Ljava/lang/String;
    //   179: invokestatic 439	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifne +14 -> 196
    //   185: invokestatic 443	com/tencent/mm/ao/f:awL	()Lcom/tencent/mm/ao/b;
    //   188: aload_1
    //   189: getfield 433	com/tencent/mm/modelvideo/m:hzo	Ljava/lang/String;
    //   192: invokevirtual 448	com/tencent/mm/ao/b:xK	(Ljava/lang/String;)Z
    //   195: pop
    //   196: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   199: getfield 111	com/tencent/mm/modelvideo/o:hzT	Lcom/tencent/mm/modelvideo/i;
    //   202: ifnull +21 -> 223
    //   205: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   208: getfield 111	com/tencent/mm/modelvideo/o:hzT	Lcom/tencent/mm/modelvideo/i;
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 451	com/tencent/mm/modelvideo/i:stopDownload	()V
    //   216: aload_1
    //   217: getfield 455	com/tencent/mm/modelvideo/i:hyY	Ljava/util/LinkedList;
    //   220: invokevirtual 458	java/util/LinkedList:clear	()V
    //   223: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   226: getfield 109	com/tencent/mm/modelvideo/o:hzS	Lcom/tencent/mm/ao/e;
    //   229: ifnull +12 -> 241
    //   232: invokestatic 166	com/tencent/mm/modelvideo/o:aCH	()Lcom/tencent/mm/modelvideo/o;
    //   235: getfield 109	com/tencent/mm/modelvideo/o:hzS	Lcom/tencent/mm/ao/e;
    //   238: invokevirtual 461	com/tencent/mm/ao/e:release	()V
    //   241: bipush 43
    //   243: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aload_0
    //   247: getfield 99	com/tencent/mm/modelvideo/o:hzK	Lcom/tencent/mm/modelvideo/v;
    //   250: invokestatic 463	com/tencent/mm/al/f$d:b	(Ljava/lang/Object;Lcom/tencent/mm/al/f;)V
    //   253: bipush 44
    //   255: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload_0
    //   259: getfield 99	com/tencent/mm/modelvideo/o:hzK	Lcom/tencent/mm/modelvideo/v;
    //   262: invokestatic 463	com/tencent/mm/al/f$d:b	(Ljava/lang/Object;Lcom/tencent/mm/al/f;)V
    //   265: bipush 62
    //   267: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 99	com/tencent/mm/modelvideo/o:hzK	Lcom/tencent/mm/modelvideo/v;
    //   274: invokestatic 463	com/tencent/mm/al/f$d:b	(Ljava/lang/Object;Lcom/tencent/mm/al/f;)V
    //   277: ldc_w 343
    //   280: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aload_0
    //   284: getfield 99	com/tencent/mm/modelvideo/o:hzK	Lcom/tencent/mm/modelvideo/v;
    //   287: invokestatic 463	com/tencent/mm/al/f$d:b	(Ljava/lang/Object;Lcom/tencent/mm/al/f;)V
    //   290: getstatic 56	com/tencent/mm/modelvideo/o:hzR	Lcom/tencent/mm/sdk/platformtools/ap;
    //   293: ifnull +10 -> 303
    //   296: getstatic 56	com/tencent/mm/modelvideo/o:hzR	Lcom/tencent/mm/sdk/platformtools/ap;
    //   299: aconst_null
    //   300: invokevirtual 347	com/tencent/mm/sdk/platformtools/ap:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   303: invokestatic 328	com/tencent/mm/modelvideo/o:aCN	()Lcom/tencent/mm/modelvideo/y$a;
    //   306: astore_1
    //   307: ldc_w 465
    //   310: ldc_w 467
    //   313: invokestatic 469	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: getfield 472	com/tencent/mm/modelvideo/y$a:hAP	Lcom/tencent/mm/sdk/platformtools/ap;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +66 -> 388
    //   325: aload_1
    //   326: getfield 472	com/tencent/mm/modelvideo/y$a:hAP	Lcom/tencent/mm/sdk/platformtools/ap;
    //   329: invokevirtual 475	com/tencent/mm/sdk/platformtools/ap:quit	()Z
    //   332: pop
    //   333: aload_1
    //   334: iconst_0
    //   335: putfield 479	com/tencent/mm/modelvideo/y$a:hAQ	Z
    //   338: aload_1
    //   339: aconst_null
    //   340: putfield 472	com/tencent/mm/modelvideo/y$a:hAP	Lcom/tencent/mm/sdk/platformtools/ap;
    //   343: ldc_w 379
    //   346: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: astore_1
    //   351: ldc 129
    //   353: aload_1
    //   354: ldc_w 481
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 485	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -123 -> 241
    //   367: astore_1
    //   368: ldc_w 465
    //   371: ldc_w 487
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: invokevirtual 490	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc_w 379
    //   391: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    //   395: astore_1
    //   396: ldc 129
    //   398: ldc_w 494
    //   401: iconst_1
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload_1
    //   408: invokevirtual 490	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   411: aastore
    //   412: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: ldc_w 379
    //   418: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	o
    //   60	279	1	localObject	Object
    //   350	4	1	localException1	java.lang.Exception
    //   367	14	1	localException2	java.lang.Exception
    //   395	13	1	localException3	java.lang.Exception
    //   320	2	2	localap	ap
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o
 * JD-Core Version:    0.7.0.1
 */