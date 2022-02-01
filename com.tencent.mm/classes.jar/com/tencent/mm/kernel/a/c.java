package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.api.f
{
  private static c gCE;
  public static com.tencent.mm.vending.c.a<Void, f.a> gCH;
  public static com.tencent.mm.vending.c.a<Void, f.a> gCI;
  public static com.tencent.mm.vending.c.a<Void, f.a> gCJ;
  private static Map<String, Map> gCK;
  public final d gCA;
  public final b gCB;
  public final e gCC;
  public final a gCD;
  public volatile boolean gCF;
  private AtomicBoolean gCG;
  private Set<Looper> gCL;
  private ConcurrentHashMap<Object, f> gCM;
  private ConcurrentHashMap gCN;
  private boolean gCv;
  public final com.tencent.mm.kernel.a.b.g gCw;
  public final com.tencent.mm.kernel.a.b.g gCx;
  public final com.tencent.mm.kernel.a.b.g gCy;
  public final c gCz;
  
  static
  {
    AppMethodBeat.i(132212);
    gCE = new c();
    gCH = new com.tencent.mm.vending.c.a() {};
    gCI = new com.tencent.mm.vending.c.a() {};
    gCJ = new com.tencent.mm.vending.c.a() {};
    gCK = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.gCv = true;
    this.gCw = new com.tencent.mm.kernel.a.b.g();
    this.gCx = new com.tencent.mm.kernel.a.b.g();
    this.gCy = new com.tencent.mm.kernel.a.b.g();
    this.gCz = new c((byte)0);
    this.gCA = new d();
    this.gCB = new b();
    this.gCC = new e();
    this.gCD = new a();
    this.gCF = false;
    this.gCG = new AtomicBoolean(false);
    this.gCL = new HashSet();
    this.gCM = new ConcurrentHashMap();
    this.gCN = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.akr();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label202;
      }
      com.tencent.mm.blink.a.s(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.gDz);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    ad.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    ad.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.ygI.g("BlinkStartup", (String)localObject, paramg);
    label202:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.aj(paramClass).bw(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.gDh;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c ajP()
  {
    return gCE;
  }
  
  private boolean ajQ()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.gCL.contains(Looper.myLooper()))
    {
      ad.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.g.ajD().gBM.gCg)
    {
      ad.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void ajR()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.gCN.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.ajD().bp(localObject);
      gCE.br(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void ajT()
  {
    AppMethodBeat.i(132206);
    c localc = gCE;
    Iterator localIterator = com.tencent.mm.kernel.g.ajy().aja().iterator();
    while (localIterator.hasNext()) {
      localc.br((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.ub("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void ajU()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.ub("configureAndExecutePendingPlugins");
    this.gCx.b(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.akf().a(new e.b(), gCH, this.gCx, "configure-functional from pending plugins");
    o.fPo();
    this.gCw.b(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.akf().a(new e.b(), gCI, this.gCw, "task-functional from pending plugins");
    com.tencent.mm.blink.a.ub("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void ajV()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.gCy.b(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.akf();
    locale.a(new e.b(), gCJ, this.gCy);
    this.gCy.aks();
    locale.start("account-init from pending plugins");
    locale.akh();
    AppMethodBeat.o(132208);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.gCz.bu((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.gCA.bu((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.gCB.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.gCC.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof n)) {
      this.gCD.c((n)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void ajK()
  {
    AppMethodBeat.i(221708);
    this.gCC.ajK();
    AppMethodBeat.o(221708);
  }
  
  public final void ajS()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.ub("initializePendingPlugins");
    if (this.gCG.compareAndSet(false, true))
    {
      ad.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      ajT();
      ajR();
      ajU();
      ajV();
      this.gCF = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        com.tencent.mm.kernel.g.ajA().aiB();
      }
      com.tencent.mm.blink.a.ub("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.Fnm) || (com.tencent.mm.protocal.d.Fnl)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) && (com.tencent.mm.kernel.g.ajA().aiK()))
      {
        a(this.gCw);
        a(this.gCx);
        a(this.gCy);
      }
      com.tencent.mm.kernel.a.b.e.akf();
      com.tencent.mm.blink.a.ub("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void br(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      ad.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.f.bo(paramObject))
    {
      ad.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.gCy.bE(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bs(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.gCG.get()) || (this.gCF))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!ajQ())
    {
      ad.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.gCM.containsKey(paramObject)) {
      this.gCM.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.gCM.get(paramObject);
    if (!localf.ajW())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    ad.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.gCy.bD(paramObject))
    {
      ad.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.gCy.bE(paramObject);
    }
    try
    {
      localf.mR(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.gCx.aj(com.tencent.mm.kernel.b.b.class).bB((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(gCH);
        }
        locala = this.gCw.aj(com.tencent.mm.kernel.a.c.b.class).bB((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCI);
      }
      if (!com.tencent.mm.kernel.g.ajA().aiK())
      {
        ad.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.gCy.aj(com.tencent.mm.kernel.api.h.class).bB((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCJ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.gCy.aj(com.tencent.mm.kernel.api.a.class).bB((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCJ);
      }
      if ((paramObject instanceof an))
      {
        locala = this.gCy.aj(an.class).bB((an)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCJ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.gCy.aj(com.tencent.mm.kernel.api.e.class).bB((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCJ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.gCy.aj(com.tencent.mm.kernel.api.c.class).bB((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gCJ);
      }
      return;
    }
    finally
    {
      localf.mR(2);
      ad.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void bt(Object paramObject)
  {
    AppMethodBeat.i(132202);
    ad.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.gCN.putIfAbsent(paramObject, this.gCN);
    AppMethodBeat.o(132202);
  }
  
  public final void f(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    ad.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.gCL.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void f(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.gCD.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.gCD.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.gCv)
    {
      com.tencent.mm.blink.a.ub("beforeAccountInit");
      this.gCy.b(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.akf();
      paramc.a(new e.b(), gCJ, this.gCy);
      this.gCy.aks();
      paramc.start("account-init from onAccountInitialized");
      paramc.akh();
      AppMethodBeat.o(132194);
      return;
    }
    this.gCz.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.gCz.onAccountRelease();
    this.gCy.b(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.gCA.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.gCv) {
      this.gCA.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public final void xb(String paramString)
  {
    AppMethodBeat.i(132193);
    this.gCB.xc(paramString);
    this.gCC.xb(paramString);
    AppMethodBeat.o(132193);
  }
  
  public static final class a
    extends com.tencent.mm.cn.a<n>
    implements n
  {
    public final com.tencent.mm.vending.b.b<n> c(n paramn)
    {
      try
      {
        AppMethodBeat.i(132162);
        paramn = super.bu(paramn);
        AppMethodBeat.o(132162);
        return paramn;
      }
      finally
      {
        paramn = finally;
        throw paramn;
      }
    }
    
    public final void onAppBackground(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132164);
        a(new com.tencent.mm.cn.a.a() {});
        AppMethodBeat.o(132164);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void onAppForeground(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132163);
        a(new com.tencent.mm.cn.a.a() {});
        AppMethodBeat.o(132163);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  public static final class b
    extends com.tencent.mm.cn.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean gCQ = false;
    
    private static void d(List<String> paramList, String paramString)
    {
      AppMethodBeat.i(132169);
      String[] arrayOfString = new String[paramList.size() + 1];
      arrayOfString[0] = paramString;
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfString[(i + 1)] = (paramString + (String)paramList.get(i));
        i += 1;
      }
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramList = arrayOfString[i];
        paramString = new com.tencent.mm.vfs.e(paramList);
        if ((!paramString.exists()) && ((!paramString.mkdirs()) || (!paramString.isDirectory()))) {
          ad.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
        }
        i += 1;
      }
      AppMethodBeat.o(132169);
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b paramb)
    {
      try
      {
        AppMethodBeat.i(132166);
        com.tencent.mm.vending.b.b localb = super.bu(paramb);
        if (this.gCQ)
        {
          List localList = paramb.ajJ();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.g.ajC().gBm);
          }
          ad.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> ajJ()
    {
      AppMethodBeat.i(132167);
      Object localObject1 = fNW();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).LhL).ajJ();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(132167);
      return localLinkedList;
    }
    
    public final void xc(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = ajJ();
        this.gCQ = true;
        ad.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
        d(localList, paramString);
        AppMethodBeat.o(132168);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  public static final class c
    extends com.tencent.mm.cn.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final e.c paramc)
    {
      AppMethodBeat.i(132173);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132173);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(132174);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132174);
    }
  }
  
  public static final class d
    extends com.tencent.mm.cn.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132179);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132179);
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132178);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132178);
    }
  }
  
  public static final class e
    extends com.tencent.mm.cn.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean gCW = false;
    private String gCX;
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(132183);
        com.tencent.mm.vending.b.b localb = super.bu(paramf);
        if (this.gCW)
        {
          paramf.xb(this.gCX);
          ad.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void ajK()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132182);
    }
    
    public final void xb(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.cn.a.a() {});
        this.gCW = true;
        this.gCX = paramString;
        AppMethodBeat.o(132184);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  static final class f
  {
    private long gDa;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.gDa = 0L;
      this.mStatus = 0;
      this.gDa = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean ajW()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.gDa == Thread.currentThread().getId()))
          {
            AppMethodBeat.o(132187);
            return bool;
          }
          if (this.mStatus == 2)
          {
            AppMethodBeat.o(132187);
            continue;
          }
          AppMethodBeat.o(132187);
        }
        finally {}
        bool = true;
      }
    }
    
    public final void mR(int paramInt)
    {
      try
      {
        if (paramInt > this.mStatus) {
          this.mStatus = paramInt;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.c
 * JD-Core Version:    0.7.0.1
 */