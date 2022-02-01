package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.am;
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
  private static c geo;
  public static com.tencent.mm.vending.c.a<Void, f.a> ger;
  public static com.tencent.mm.vending.c.a<Void, f.a> ges;
  public static com.tencent.mm.vending.c.a<Void, f.a> get;
  private static Map<String, Map> geu;
  private boolean gef;
  public final com.tencent.mm.kernel.a.b.g geg;
  public final com.tencent.mm.kernel.a.b.g geh;
  public final com.tencent.mm.kernel.a.b.g gei;
  public final c gej;
  public final d gek;
  public final b gel;
  public final e gem;
  public final a gen;
  public volatile boolean gep;
  private AtomicBoolean geq;
  private Set<Looper> gev;
  private ConcurrentHashMap<Object, f> gew;
  private ConcurrentHashMap gex;
  
  static
  {
    AppMethodBeat.i(132212);
    geo = new c();
    ger = new com.tencent.mm.vending.c.a() {};
    ges = new com.tencent.mm.vending.c.a() {};
    get = new com.tencent.mm.vending.c.a() {};
    geu = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.gef = true;
    this.geg = new com.tencent.mm.kernel.a.b.g();
    this.geh = new com.tencent.mm.kernel.a.b.g();
    this.gei = new com.tencent.mm.kernel.a.b.g();
    this.gej = new c((byte)0);
    this.gek = new d();
    this.gel = new b();
    this.gem = new e();
    this.gen = new a();
    this.gep = false;
    this.geq = new AtomicBoolean(false);
    this.gev = new HashSet();
    this.gew = new ConcurrentHashMap();
    this.gex = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.agq();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label202;
      }
      com.tencent.mm.blink.a.w(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.gfj);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    ad.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    ad.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.vIY.e("BlinkStartup", (String)localObject, paramg);
    label202:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.aj(paramClass).bx(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.geR;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c afO()
  {
    return geo;
  }
  
  private boolean afP()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.gev.contains(Looper.myLooper()))
    {
      ad.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.g.afC().gdw.gdQ)
    {
      ad.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void afQ()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.gex.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.afC().bq(localObject);
      geo.bs(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void afS()
  {
    AppMethodBeat.i(132206);
    c localc = geo;
    Iterator localIterator = com.tencent.mm.kernel.g.afx().aeY().iterator();
    while (localIterator.hasNext()) {
      localc.bs((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.oj("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void afT()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.oj("configureAndExecutePendingPlugins");
    this.geh.b(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.age().a(new e.b(), ger, this.geh, "configure-functional from pending plugins");
    o.fig();
    this.geg.b(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.age().a(new e.b(), ges, this.geg, "task-functional from pending plugins");
    com.tencent.mm.blink.a.oj("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void afU()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) || (!com.tencent.mm.kernel.g.afz().aeI()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.gei.b(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.age();
    locale.a(new e.b(), get, this.gei);
    this.gei.agr();
    locale.start("account-init from pending plugins");
    locale.agg();
    AppMethodBeat.o(132208);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.gej.bv((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.gek.bv((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.gel.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.gem.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof n)) {
      this.gen.c((n)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void afJ()
  {
    AppMethodBeat.i(202260);
    this.gem.afJ();
    AppMethodBeat.o(202260);
  }
  
  public final void afR()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.oj("initializePendingPlugins");
    if (this.geq.compareAndSet(false, true))
    {
      ad.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      afS();
      afQ();
      afT();
      afU();
      this.gep = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
        com.tencent.mm.kernel.g.afz().aez();
      }
      com.tencent.mm.blink.a.oj("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.CpN) || (com.tencent.mm.protocal.d.CpM)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) && (com.tencent.mm.kernel.g.afz().aeI()))
      {
        a(this.geg);
        a(this.geh);
        a(this.gei);
      }
      com.tencent.mm.kernel.a.b.e.age();
      com.tencent.mm.blink.a.oj("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void bs(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      ad.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.f.bp(paramObject))
    {
      ad.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.gei.bF(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bt(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.geq.get()) || (this.gep))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!afP())
    {
      ad.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.gew.containsKey(paramObject)) {
      this.gew.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.gew.get(paramObject);
    if (!localf.afV())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    ad.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.gei.bE(paramObject))
    {
      ad.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.gei.bF(paramObject);
    }
    try
    {
      localf.mt(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.geh.aj(com.tencent.mm.kernel.b.b.class).bC((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(ger);
        }
        locala = this.geg.aj(com.tencent.mm.kernel.a.c.b.class).bC((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(ges);
      }
      if (!com.tencent.mm.kernel.g.afz().aeI())
      {
        ad.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.gei.aj(com.tencent.mm.kernel.api.h.class).bC((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(get);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.gei.aj(com.tencent.mm.kernel.api.a.class).bC((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(get);
      }
      if ((paramObject instanceof am))
      {
        locala = this.gei.aj(am.class).bC((am)paramObject);
        Assert.assertNotNull(locala);
        locala.a(get);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.gei.aj(com.tencent.mm.kernel.api.e.class).bC((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(get);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.gei.aj(com.tencent.mm.kernel.api.c.class).bC((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(get);
      }
      return;
    }
    finally
    {
      localf.mt(2);
      ad.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void bu(Object paramObject)
  {
    AppMethodBeat.i(132202);
    ad.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.gex.putIfAbsent(paramObject, this.gex);
    AppMethodBeat.o(132202);
  }
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.gen.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.gen.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void f(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    ad.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.gev.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.gef)
    {
      com.tencent.mm.blink.a.oj("beforeAccountInit");
      this.gei.b(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.age();
      paramc.a(new e.b(), get, this.gei);
      this.gei.agr();
      paramc.start("account-init from onAccountInitialized");
      paramc.agg();
      AppMethodBeat.o(132194);
      return;
    }
    this.gej.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.gej.onAccountRelease();
    this.gei.b(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.gek.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.gef) {
      this.gek.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public final void qW(String paramString)
  {
    AppMethodBeat.i(132193);
    this.gel.qX(paramString);
    this.gem.qW(paramString);
    AppMethodBeat.o(132193);
  }
  
  public static final class a
    extends com.tencent.mm.co.a<n>
    implements n
  {
    public final com.tencent.mm.vending.b.b<n> c(n paramn)
    {
      try
      {
        AppMethodBeat.i(132162);
        paramn = super.bv(paramn);
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
        a(new com.tencent.mm.co.a.a() {});
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
        a(new com.tencent.mm.co.a.a() {});
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
    extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean geA = false;
    
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
        com.tencent.mm.vending.b.b localb = super.bv(paramb);
        if (this.geA)
        {
          List localList = paramb.afI();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.g.afB().gcW);
          }
          ad.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> afI()
    {
      AppMethodBeat.i(132167);
      Object localObject1 = fhh();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).HPL).afI();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(132167);
      return localLinkedList;
    }
    
    public final void qX(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = afI();
        this.geA = true;
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
    extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final e.c paramc)
    {
      AppMethodBeat.i(132173);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132173);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(132174);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132174);
    }
  }
  
  public static final class d
    extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132179);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132179);
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132178);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132178);
    }
  }
  
  public static final class e
    extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean geG = false;
    private String geH;
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(132183);
        com.tencent.mm.vending.b.b localb = super.bv(paramf);
        if (this.geG)
        {
          paramf.qW(this.geH);
          ad.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void afJ()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132182);
    }
    
    public final void qW(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.co.a.a() {});
        this.geG = true;
        this.geH = paramString;
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
    private long geK;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.geK = 0L;
      this.mStatus = 0;
      this.geK = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean afV()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.geK == Thread.currentThread().getId()))
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
    
    public final void mt(int paramInt)
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