package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.aq.a;
import com.tencent.mm.aq.e;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
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

public class s
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static MMHandler mhz;
  private o.a appForegroundListener;
  private e mhA;
  private m mhB;
  private t mhC;
  private volatile z mhs;
  private volatile x mht;
  private volatile ab mhu;
  private volatile ac.a mhv;
  private volatile p mhw;
  private volatile o mhx;
  private volatile q mhy;
  
  static
  {
    AppMethodBeat.i(126943);
    mhz = null;
    baseDBFactories = new HashMap();
    Iterator localIterator = x.d.lOO.iterator();
    while (localIterator.hasNext())
    {
      x.c localc = (x.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.mhF.lOL;
        }
      });
    }
    baseDBFactories.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ab.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return p.SQL_CREATE;
      }
    });
    AppMethodBeat.o(126943);
  }
  
  public s()
  {
    AppMethodBeat.i(126928);
    this.mhs = new z();
    this.mhv = null;
    this.mhw = null;
    this.mhx = null;
    this.mhy = null;
    this.mhA = null;
    this.mhB = null;
    this.mhC = new t();
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(126926);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(126926);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(126925);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            com.tencent.mm.blink.b.aqa().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126924);
                s.bqG().run();
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
  
  public static boolean I(Runnable paramRunnable)
  {
    AppMethodBeat.i(126939);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126939);
      return true;
    }
    bqI();
    if (mhz == null)
    {
      Log.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      AppMethodBeat.o(126939);
      return false;
    }
    mhz.removeCallbacks(paramRunnable);
    AppMethodBeat.o(126939);
    return true;
  }
  
  public static s bqA()
  {
    AppMethodBeat.i(126929);
    s locals = (s)y.as(s.class);
    AppMethodBeat.o(126929);
    return locals;
  }
  
  public static x bqB()
  {
    try
    {
      AppMethodBeat.i(126930);
      if (!com.tencent.mm.kernel.h.aHB())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126930);
        throw localb;
      }
    }
    finally {}
    if (bqA().mht == null) {
      bqA().mht = new x(com.tencent.mm.kernel.h.aHG().kcF);
    }
    x localx = bqA().mht;
    AppMethodBeat.o(126930);
    return localx;
  }
  
  public static e bqC()
  {
    int j = 0;
    AppMethodBeat.i(126931);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bqA().mhA == null) {
      bqA().mhA = new e();
    }
    if (com.tencent.mm.aq.f.bkh().lHG == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.aq.f.bkh();
        e locale = bqA().mhA;
        ((a)localObject).lHG = locale;
        int k = localObject.hashCode();
        i = j;
        if (locale != null) {
          i = locale.hashCode();
        }
        Log.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      Object localObject = bqA().mhA;
      AppMethodBeat.o(126931);
      return localObject;
    }
  }
  
  public static m bqD()
  {
    AppMethodBeat.i(126932);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bqA().mhB == null) {
      bqA().mhB = new m();
    }
    m localm = bqA().mhB;
    AppMethodBeat.o(126932);
    return localm;
  }
  
  public static ab bqE()
  {
    AppMethodBeat.i(126933);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126933);
      throw ((Throwable)localObject);
    }
    if (bqA().mhu == null) {
      bqA().mhu = new ab(com.tencent.mm.kernel.h.aHG().kcF);
    }
    Object localObject = bqA().mhu;
    AppMethodBeat.o(126933);
    return localObject;
  }
  
  public static p bqF()
  {
    try
    {
      AppMethodBeat.i(126934);
      if (!com.tencent.mm.kernel.h.aHB())
      {
        com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
        AppMethodBeat.o(126934);
        throw localb;
      }
    }
    finally {}
    if (bqA().mhw == null) {
      bqA().mhw = new p(com.tencent.mm.kernel.h.aHG().kcF);
    }
    p localp = bqA().mhw;
    AppMethodBeat.o(126934);
    return localp;
  }
  
  public static ac.a bqG()
  {
    AppMethodBeat.i(126935);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126935);
      throw ((Throwable)localObject);
    }
    if (bqA().mhv == null) {
      bqA().mhv = new ac.a();
    }
    Object localObject = bqA().mhv;
    AppMethodBeat.o(126935);
    return localObject;
  }
  
  public static q bqH()
  {
    AppMethodBeat.i(126936);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(126936);
      throw ((Throwable)localObject);
    }
    if (bqA().mhy == null) {
      bqA().mhy = new q();
    }
    Object localObject = bqA().mhy;
    AppMethodBeat.o(126936);
    return localObject;
  }
  
  private static void bqI()
  {
    AppMethodBeat.i(126937);
    if ((mhz == null) || (mhz.isQuit()))
    {
      MMHandler localMMHandler = new MMHandler("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
      mhz = localMMHandler;
      localMMHandler.setLogging(false);
    }
    AppMethodBeat.o(126937);
  }
  
  public static String bqJ()
  {
    AppMethodBeat.i(216427);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = u.n(com.tencent.mm.kernel.h.aHG().kcB + "subvideo/", true);
    AppMethodBeat.o(216427);
    return localObject;
  }
  
  public static boolean g(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126938);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(126938);
      return false;
    }
    bqI();
    if (paramLong > 0L) {
      mhz.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(126938);
      return true;
      mhz.post(paramRunnable);
    }
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(126942);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = u.n(com.tencent.mm.kernel.h.aHG().kcB + "video/", true);
    AppMethodBeat.o(126942);
    return localObject;
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
    bqG().a(this.mhC);
    this.appForegroundListener.alive();
    h.d.a(Integer.valueOf(43), this.mhs);
    h.d.a(Integer.valueOf(44), this.mhs);
    h.d.a(Integer.valueOf(62), this.mhs);
    h.d.a(Integer.valueOf(486539313), this.mhs);
    if (mhz != null) {
      mhz.removeCallbacksAndMessages(null);
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126927);
        if (!com.tencent.mm.kernel.h.aHB())
        {
          AppMethodBeat.o(126927);
          return;
        }
        Object localObject1 = s.bqB();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
        Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((x)localObject1).lvy.execSQL("videoinfo2", (String)localObject2);
        s.bqF().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = s.bqF();
        if (1209600000L <= 0L)
        {
          Log.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((p)localObject1).db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = s.bqF().bqv().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (n)((Iterator)localObject1).next();
            Log.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((n)localObject2).field_fileName });
            u.deleteFile(o.XE(((n)localObject2).field_fileName));
            u.deleteFile(o.XF(((n)localObject2).field_fileName));
          }
          l = Util.nowMilliSecond() - 1209600000L;
          Log.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(l));
          ((p)localObject1).db.execSQL("SightDraftInfo", (String)localObject2);
        }
        AppMethodBeat.o(126927);
      }
    });
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(o.bqu());
    if ((!localq.ifE()) || (!localq.isDirectory())) {
      localq.ifL();
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
    //   28: invokestatic 354	com/tencent/mm/modelvideo/s:bqG	()Lcom/tencent/mm/modelvideo/ac$a;
    //   31: aload_0
    //   32: getfield 144	com/tencent/mm/modelvideo/s:mhC	Lcom/tencent/mm/modelvideo/t;
    //   35: invokevirtual 410	com/tencent/mm/modelvideo/ac$a:b	(Lcom/tencent/mm/modelvideo/aa;)V
    //   38: aload_0
    //   39: getfield 149	com/tencent/mm/modelvideo/s:appForegroundListener	Lcom/tencent/mm/app/o$a;
    //   42: invokevirtual 413	com/tencent/mm/app/o$a:dead	()V
    //   45: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   48: getfield 129	com/tencent/mm/modelvideo/s:mhv	Lcom/tencent/mm/modelvideo/ac$a;
    //   51: ifnull +83 -> 134
    //   54: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   57: getfield 129	com/tencent/mm/modelvideo/s:mhv	Lcom/tencent/mm/modelvideo/ac$a;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: putfield 416	com/tencent/mm/modelvideo/ac$a:ftu	I
    //   66: aload_1
    //   67: getfield 420	com/tencent/mm/modelvideo/ac$a:miE	Lcom/tencent/mm/modelvideo/h;
    //   70: ifnull +13 -> 83
    //   73: invokestatic 424	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   76: aload_1
    //   77: getfield 420	com/tencent/mm/modelvideo/ac$a:miE	Lcom/tencent/mm/modelvideo/h;
    //   80: invokevirtual 429	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;)V
    //   83: aload_1
    //   84: getfield 433	com/tencent/mm/modelvideo/ac$a:miF	Lcom/tencent/mm/modelvideo/k;
    //   87: ifnull +13 -> 100
    //   90: invokestatic 424	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   93: aload_1
    //   94: getfield 433	com/tencent/mm/modelvideo/ac$a:miF	Lcom/tencent/mm/modelvideo/k;
    //   97: invokevirtual 429	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;)V
    //   100: invokestatic 424	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   103: sipush 149
    //   106: aload_1
    //   107: invokevirtual 436	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   110: invokestatic 424	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   113: sipush 150
    //   116: aload_1
    //   117: invokevirtual 436	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   120: invokestatic 438	com/tencent/mm/modelvideo/s:bqB	()Lcom/tencent/mm/modelvideo/x;
    //   123: aload_1
    //   124: invokevirtual 441	com/tencent/mm/modelvideo/x:a	(Lcom/tencent/mm/modelvideo/x$a;)V
    //   127: aload_1
    //   128: getfield 445	com/tencent/mm/modelvideo/ac$a:miG	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 450	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   134: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   137: getfield 135	com/tencent/mm/modelvideo/s:mhy	Lcom/tencent/mm/modelvideo/q;
    //   140: ifnull +56 -> 196
    //   143: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   146: getfield 135	com/tencent/mm/modelvideo/s:mhy	Lcom/tencent/mm/modelvideo/q;
    //   149: astore_1
    //   150: aload_1
    //   151: iconst_0
    //   152: putfield 451	com/tencent/mm/modelvideo/q:ftu	I
    //   155: ldc_w 453
    //   158: ldc_w 455
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: getfield 458	com/tencent/mm/modelvideo/q:mgT	Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_1
    //   176: getfield 458	com/tencent/mm/modelvideo/q:mgT	Ljava/lang/String;
    //   179: invokestatic 464	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifne +14 -> 196
    //   185: invokestatic 468	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   188: aload_1
    //   189: getfield 458	com/tencent/mm/modelvideo/q:mgT	Ljava/lang/String;
    //   192: invokevirtual 473	com/tencent/mm/aq/b:Vy	(Ljava/lang/String;)Z
    //   195: pop
    //   196: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   199: getfield 139	com/tencent/mm/modelvideo/s:mhB	Lcom/tencent/mm/modelvideo/m;
    //   202: ifnull +21 -> 223
    //   205: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   208: getfield 139	com/tencent/mm/modelvideo/s:mhB	Lcom/tencent/mm/modelvideo/m;
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 476	com/tencent/mm/modelvideo/m:stopDownload	()V
    //   216: aload_1
    //   217: getfield 480	com/tencent/mm/modelvideo/m:mgD	Ljava/util/LinkedList;
    //   220: invokevirtual 483	java/util/LinkedList:clear	()V
    //   223: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   226: getfield 137	com/tencent/mm/modelvideo/s:mhA	Lcom/tencent/mm/aq/e;
    //   229: ifnull +12 -> 241
    //   232: invokestatic 193	com/tencent/mm/modelvideo/s:bqA	()Lcom/tencent/mm/modelvideo/s;
    //   235: getfield 137	com/tencent/mm/modelvideo/s:mhA	Lcom/tencent/mm/aq/e;
    //   238: invokevirtual 486	com/tencent/mm/aq/e:release	()V
    //   241: bipush 43
    //   243: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aload_0
    //   247: getfield 127	com/tencent/mm/modelvideo/s:mhs	Lcom/tencent/mm/modelvideo/z;
    //   250: invokestatic 488	com/tencent/mm/an/h$d:b	(Ljava/lang/Object;Lcom/tencent/mm/an/h;)V
    //   253: bipush 44
    //   255: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload_0
    //   259: getfield 127	com/tencent/mm/modelvideo/s:mhs	Lcom/tencent/mm/modelvideo/z;
    //   262: invokestatic 488	com/tencent/mm/an/h$d:b	(Ljava/lang/Object;Lcom/tencent/mm/an/h;)V
    //   265: bipush 62
    //   267: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 127	com/tencent/mm/modelvideo/s:mhs	Lcom/tencent/mm/modelvideo/z;
    //   274: invokestatic 488	com/tencent/mm/an/h$d:b	(Ljava/lang/Object;Lcom/tencent/mm/an/h;)V
    //   277: ldc_w 369
    //   280: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/modelvideo/s:mhs	Lcom/tencent/mm/modelvideo/z;
    //   287: invokestatic 488	com/tencent/mm/an/h$d:b	(Ljava/lang/Object;Lcom/tencent/mm/an/h;)V
    //   290: getstatic 56	com/tencent/mm/modelvideo/s:mhz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   293: ifnull +10 -> 303
    //   296: getstatic 56	com/tencent/mm/modelvideo/s:mhz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   299: aconst_null
    //   300: invokevirtual 373	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   303: invokestatic 354	com/tencent/mm/modelvideo/s:bqG	()Lcom/tencent/mm/modelvideo/ac$a;
    //   306: astore_1
    //   307: ldc_w 490
    //   310: ldc_w 492
    //   313: invokestatic 494	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: getfield 497	com/tencent/mm/modelvideo/ac$a:miz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +66 -> 388
    //   325: aload_1
    //   326: getfield 497	com/tencent/mm/modelvideo/ac$a:miz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   329: invokevirtual 500	com/tencent/mm/sdk/platformtools/MMHandler:quit	()Z
    //   332: pop
    //   333: aload_1
    //   334: iconst_0
    //   335: putfield 504	com/tencent/mm/modelvideo/ac$a:miA	Z
    //   338: aload_1
    //   339: aconst_null
    //   340: putfield 497	com/tencent/mm/modelvideo/ac$a:miz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   343: ldc_w 405
    //   346: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: astore_1
    //   351: ldc 157
    //   353: aload_1
    //   354: ldc_w 506
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 510	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   385: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc_w 405
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
    //   412: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: ldc_w 405
    //   418: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	s
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
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */