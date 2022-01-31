package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.al.f;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.b;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static al fXf;
  private static ak fXg;
  private j.a appForegroundListener;
  private volatile v fWY;
  private volatile t fWZ;
  private volatile x fXa;
  private volatile y.a fXb;
  private volatile l fXc;
  private volatile k fXd;
  private volatile m fXe;
  private com.tencent.mm.al.e fXh;
  private i fXi;
  private p fXj;
  
  static
  {
    AppMethodBeat.i(50778);
    fXf = null;
    fXg = null;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return x.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new o.4());
    AppMethodBeat.o(50778);
  }
  
  public o()
  {
    AppMethodBeat.i(50763);
    this.fWY = new v();
    this.fXb = null;
    this.fXc = null;
    this.fXd = null;
    this.fXe = null;
    this.fXh = null;
    this.fXi = null;
    this.fXj = new p();
    this.appForegroundListener = new o.1(this);
    AppMethodBeat.o(50763);
  }
  
  public static o alD()
  {
    AppMethodBeat.i(50764);
    o localo = (o)q.S(o.class);
    AppMethodBeat.o(50764);
    return localo;
  }
  
  public static t alE()
  {
    try
    {
      AppMethodBeat.i(50765);
      if (!g.RG())
      {
        b localb = new b();
        AppMethodBeat.o(50765);
        throw localb;
      }
    }
    finally {}
    if (alD().fWZ == null) {
      alD().fWZ = new t(g.RL().eHS);
    }
    t localt = alD().fWZ;
    AppMethodBeat.o(50765);
    return localt;
  }
  
  public static com.tencent.mm.al.e alF()
  {
    int j = 0;
    AppMethodBeat.i(50766);
    g.RJ().QQ();
    if (alD().fXh == null) {
      alD().fXh = new com.tencent.mm.al.e();
    }
    if (f.afP().fyE == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = f.afP();
        com.tencent.mm.al.e locale = alD().fXh;
        ((com.tencent.mm.al.a)localObject).fyE = locale;
        int k = localObject.hashCode();
        i = j;
        if (locale != null) {
          i = locale.hashCode();
        }
        ab.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      Object localObject = alD().fXh;
      AppMethodBeat.o(50766);
      return localObject;
    }
  }
  
  public static i alG()
  {
    AppMethodBeat.i(50767);
    g.RJ().QQ();
    if (alD().fXi == null) {
      alD().fXi = new i();
    }
    i locali = alD().fXi;
    AppMethodBeat.o(50767);
    return locali;
  }
  
  public static x alH()
  {
    AppMethodBeat.i(50768);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(50768);
      throw ((Throwable)localObject);
    }
    if (alD().fXa == null) {
      alD().fXa = new x(g.RL().eHS);
    }
    Object localObject = alD().fXa;
    AppMethodBeat.o(50768);
    return localObject;
  }
  
  public static l alI()
  {
    try
    {
      AppMethodBeat.i(50769);
      if (!g.RG())
      {
        b localb = new b();
        AppMethodBeat.o(50769);
        throw localb;
      }
    }
    finally {}
    if (alD().fXc == null) {
      alD().fXc = new l(g.RL().eHS);
    }
    l locall = alD().fXc;
    AppMethodBeat.o(50769);
    return locall;
  }
  
  public static y.a alJ()
  {
    AppMethodBeat.i(50770);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(50770);
      throw ((Throwable)localObject);
    }
    if (alD().fXb == null) {
      alD().fXb = new y.a();
    }
    Object localObject = alD().fXb;
    AppMethodBeat.o(50770);
    return localObject;
  }
  
  public static m alK()
  {
    AppMethodBeat.i(50771);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(50771);
      throw ((Throwable)localObject);
    }
    if (alD().fXe == null) {
      alD().fXe = new m();
    }
    Object localObject = alD().fXe;
    AppMethodBeat.o(50771);
    return localObject;
  }
  
  private static void alL()
  {
    boolean bool2 = false;
    AppMethodBeat.i(50772);
    if ((fXg != null) && (fXf != null))
    {
      AppMethodBeat.o(50772);
      return;
    }
    boolean bool1;
    if (fXg != null)
    {
      bool1 = true;
      if (fXf != null) {
        bool2 = true;
      }
      ab.w("MicroMsg.SubCoreVideo", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bo.dtY() });
      if (fXg != null) {
        fXg.removeCallbacksAndMessages(null);
      }
      if (fXf == null) {
        break label129;
      }
      fXf.a(null);
    }
    for (;;)
    {
      fXg = new ak(fXf.oNc.getLooper());
      AppMethodBeat.o(50772);
      return;
      bool1 = false;
      break;
      label129:
      fXf = new al("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
    }
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(50777);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "video/";
    AppMethodBeat.o(50777);
    return localObject;
  }
  
  public static boolean j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(50773);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(50773);
      return false;
    }
    alL();
    if (paramLong > 0L) {
      fXg.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(50773);
      return true;
      fXg.post(paramRunnable);
    }
  }
  
  public static boolean x(Runnable paramRunnable)
  {
    AppMethodBeat.i(50774);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(50774);
      return true;
    }
    alL();
    if (fXg == null)
    {
      ab.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      AppMethodBeat.o(50774);
      return false;
    }
    fXg.removeCallbacks(paramRunnable);
    AppMethodBeat.o(50774);
    return true;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(50776);
    ab.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    alJ().a(this.fXj);
    this.appForegroundListener.alive();
    e.d.a(Integer.valueOf(43), this.fWY);
    e.d.a(Integer.valueOf(44), this.fWY);
    e.d.a(Integer.valueOf(62), this.fWY);
    if (fXg != null) {
      fXg.removeCallbacksAndMessages(null);
    }
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139646);
        if (!g.RG())
        {
          AppMethodBeat.o(139646);
          return;
        }
        Object localObject1 = o.alE();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
        ab.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((t)localObject1).fnw.execSQL("videoinfo2", (String)localObject2);
        o.alI().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = o.alI();
        if (1209600000L <= 0L)
        {
          ab.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((l)localObject1).db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = o.alI().aly().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            ab.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((j)localObject2).field_fileName });
            com.tencent.mm.a.e.deleteFile(k.uV(((j)localObject2).field_fileName));
            com.tencent.mm.a.e.deleteFile(k.uW(((j)localObject2).field_fileName));
          }
          l = bo.aoy() - 1209600000L;
          ab.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(l));
          ((l)localObject1).db.execSQL("SightDraftInfo", (String)localObject2);
        }
        AppMethodBeat.o(139646);
      }
    });
    File localFile = new File(k.alx());
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(50776);
  }
  
  /* Error */
  public void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 396
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 238
    //   8: ldc_w 398
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 191	java/lang/Object:hashCode	()I
    //   21: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: invokestatic 353	com/tencent/mm/modelvideo/o:alJ	()Lcom/tencent/mm/modelvideo/y$a;
    //   31: aload_0
    //   32: getfield 116	com/tencent/mm/modelvideo/o:fXj	Lcom/tencent/mm/modelvideo/p;
    //   35: invokevirtual 401	com/tencent/mm/modelvideo/y$a:b	(Lcom/tencent/mm/modelvideo/w;)V
    //   38: aload_0
    //   39: getfield 123	com/tencent/mm/modelvideo/o:appForegroundListener	Lcom/tencent/mm/app/j$a;
    //   42: invokevirtual 404	com/tencent/mm/app/j$a:dead	()V
    //   45: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   48: getfield 101	com/tencent/mm/modelvideo/o:fXb	Lcom/tencent/mm/modelvideo/y$a;
    //   51: ifnull +76 -> 127
    //   54: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   57: getfield 101	com/tencent/mm/modelvideo/o:fXb	Lcom/tencent/mm/modelvideo/y$a;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: putfield 408	com/tencent/mm/modelvideo/y$a:ckM	I
    //   66: aload_1
    //   67: getfield 412	com/tencent/mm/modelvideo/y$a:fYh	Lcom/tencent/mm/modelvideo/d;
    //   70: ifnull +13 -> 83
    //   73: invokestatic 416	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   76: aload_1
    //   77: getfield 412	com/tencent/mm/modelvideo/y$a:fYh	Lcom/tencent/mm/modelvideo/d;
    //   80: invokevirtual 421	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;)V
    //   83: aload_1
    //   84: getfield 425	com/tencent/mm/modelvideo/y$a:fYi	Lcom/tencent/mm/modelvideo/g;
    //   87: ifnull +13 -> 100
    //   90: invokestatic 416	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   93: aload_1
    //   94: getfield 425	com/tencent/mm/modelvideo/y$a:fYi	Lcom/tencent/mm/modelvideo/g;
    //   97: invokevirtual 421	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;)V
    //   100: invokestatic 416	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   103: sipush 149
    //   106: aload_1
    //   107: invokevirtual 428	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   110: invokestatic 416	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   113: sipush 150
    //   116: aload_1
    //   117: invokevirtual 428	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   120: invokestatic 430	com/tencent/mm/modelvideo/o:alE	()Lcom/tencent/mm/modelvideo/t;
    //   123: aload_1
    //   124: invokevirtual 433	com/tencent/mm/modelvideo/t:a	(Lcom/tencent/mm/modelvideo/t$a;)V
    //   127: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   130: getfield 107	com/tencent/mm/modelvideo/o:fXe	Lcom/tencent/mm/modelvideo/m;
    //   133: ifnull +56 -> 189
    //   136: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   139: getfield 107	com/tencent/mm/modelvideo/o:fXe	Lcom/tencent/mm/modelvideo/m;
    //   142: astore_1
    //   143: aload_1
    //   144: iconst_0
    //   145: putfield 434	com/tencent/mm/modelvideo/m:ckM	I
    //   148: ldc_w 436
    //   151: ldc_w 438
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_1
    //   161: getfield 441	com/tencent/mm/modelvideo/m:fWC	Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_1
    //   169: getfield 441	com/tencent/mm/modelvideo/m:fWC	Ljava/lang/String;
    //   172: invokestatic 445	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   175: ifne +14 -> 189
    //   178: invokestatic 449	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   181: aload_1
    //   182: getfield 441	com/tencent/mm/modelvideo/m:fWC	Ljava/lang/String;
    //   185: invokevirtual 454	com/tencent/mm/al/b:sI	(Ljava/lang/String;)Z
    //   188: pop
    //   189: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   192: getfield 111	com/tencent/mm/modelvideo/o:fXi	Lcom/tencent/mm/modelvideo/i;
    //   195: ifnull +21 -> 216
    //   198: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   201: getfield 111	com/tencent/mm/modelvideo/o:fXi	Lcom/tencent/mm/modelvideo/i;
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 457	com/tencent/mm/modelvideo/i:stopDownload	()V
    //   209: aload_1
    //   210: getfield 461	com/tencent/mm/modelvideo/i:fWm	Ljava/util/LinkedList;
    //   213: invokevirtual 466	java/util/LinkedList:clear	()V
    //   216: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   219: getfield 109	com/tencent/mm/modelvideo/o:fXh	Lcom/tencent/mm/al/e;
    //   222: ifnull +12 -> 234
    //   225: invokestatic 146	com/tencent/mm/modelvideo/o:alD	()Lcom/tencent/mm/modelvideo/o;
    //   228: getfield 109	com/tencent/mm/modelvideo/o:fXh	Lcom/tencent/mm/al/e;
    //   231: invokevirtual 469	com/tencent/mm/al/e:release	()V
    //   234: bipush 43
    //   236: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aload_0
    //   240: getfield 99	com/tencent/mm/modelvideo/o:fWY	Lcom/tencent/mm/modelvideo/v;
    //   243: invokestatic 471	com/tencent/mm/ai/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ai/e;)V
    //   246: bipush 44
    //   248: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aload_0
    //   252: getfield 99	com/tencent/mm/modelvideo/o:fWY	Lcom/tencent/mm/modelvideo/v;
    //   255: invokestatic 471	com/tencent/mm/ai/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ai/e;)V
    //   258: bipush 62
    //   260: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aload_0
    //   264: getfield 99	com/tencent/mm/modelvideo/o:fWY	Lcom/tencent/mm/modelvideo/v;
    //   267: invokestatic 471	com/tencent/mm/ai/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ai/e;)V
    //   270: getstatic 54	com/tencent/mm/modelvideo/o:fXg	Lcom/tencent/mm/sdk/platformtools/ak;
    //   273: ifnull +10 -> 283
    //   276: getstatic 54	com/tencent/mm/modelvideo/o:fXg	Lcom/tencent/mm/sdk/platformtools/ak;
    //   279: aconst_null
    //   280: invokevirtual 260	com/tencent/mm/sdk/platformtools/ak:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   283: invokestatic 353	com/tencent/mm/modelvideo/o:alJ	()Lcom/tencent/mm/modelvideo/y$a;
    //   286: astore_1
    //   287: ldc_w 473
    //   290: ldc_w 475
    //   293: iconst_1
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_1
    //   300: getfield 478	com/tencent/mm/modelvideo/y$a:fYb	Landroid/os/HandlerThread;
    //   303: aastore
    //   304: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_1
    //   308: getfield 478	com/tencent/mm/modelvideo/y$a:fYb	Landroid/os/HandlerThread;
    //   311: astore_2
    //   312: aload_2
    //   313: ifnull +71 -> 384
    //   316: aload_1
    //   317: getfield 478	com/tencent/mm/modelvideo/y$a:fYb	Landroid/os/HandlerThread;
    //   320: invokevirtual 481	android/os/HandlerThread:quit	()Z
    //   323: pop
    //   324: aload_1
    //   325: iconst_0
    //   326: putfield 485	com/tencent/mm/modelvideo/y$a:fYd	Z
    //   329: aload_1
    //   330: aconst_null
    //   331: putfield 488	com/tencent/mm/modelvideo/y$a:fYc	Lcom/tencent/mm/sdk/platformtools/ak;
    //   334: aload_1
    //   335: aconst_null
    //   336: putfield 478	com/tencent/mm/modelvideo/y$a:fYb	Landroid/os/HandlerThread;
    //   339: ldc_w 396
    //   342: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: astore_1
    //   347: ldc 238
    //   349: aload_1
    //   350: ldc_w 490
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokestatic 494	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -126 -> 234
    //   363: astore_1
    //   364: ldc_w 473
    //   367: ldc_w 496
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_1
    //   377: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   380: aastore
    //   381: invokestatic 501	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: ldc_w 396
    //   387: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: return
    //   391: astore_1
    //   392: ldc 238
    //   394: ldc_w 503
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_1
    //   404: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   407: aastore
    //   408: invokestatic 501	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: ldc_w 396
    //   414: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	o
    //   60	275	1	localObject	Object
    //   346	4	1	localException1	java.lang.Exception
    //   363	14	1	localException2	java.lang.Exception
    //   391	13	1	localException3	java.lang.Exception
    //   311	2	2	localHandlerThread	HandlerThread
    // Exception table:
    //   from	to	target	type
    //   45	83	346	java/lang/Exception
    //   83	100	346	java/lang/Exception
    //   100	127	346	java/lang/Exception
    //   127	189	346	java/lang/Exception
    //   189	216	346	java/lang/Exception
    //   216	234	346	java/lang/Exception
    //   316	339	363	java/lang/Exception
    //   283	312	391	java/lang/Exception
    //   339	345	391	java/lang/Exception
    //   364	384	391	java/lang/Exception
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o
 * JD-Core Version:    0.7.0.1
 */