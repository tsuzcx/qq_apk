package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.u;
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
  private static c mEe;
  public static com.tencent.mm.vending.c.a<Void, f.a> mEh;
  public static com.tencent.mm.vending.c.a<Void, f.a> mEi;
  public static com.tencent.mm.vending.c.a<Void, f.a> mEj;
  private static Map<String, Map> mEk;
  private boolean mDV;
  public final com.tencent.mm.kernel.a.b.g mDW;
  public final com.tencent.mm.kernel.a.b.g mDX;
  public final com.tencent.mm.kernel.a.b.g mDY;
  public final c mDZ;
  public final c.d mEa;
  public final b mEb;
  public final e mEc;
  public final a mEd;
  public volatile boolean mEf;
  private AtomicBoolean mEg;
  private Set<Looper> mEl;
  private ConcurrentHashMap<Object, f> mEm;
  private ConcurrentHashMap mEn;
  
  static
  {
    AppMethodBeat.i(132212);
    mEe = new c();
    mEh = new com.tencent.mm.vending.c.a() {};
    mEi = new com.tencent.mm.vending.c.a() {};
    mEj = new com.tencent.mm.vending.c.a() {};
    mEk = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.mDV = true;
    this.mDW = new com.tencent.mm.kernel.a.b.g();
    this.mDX = new com.tencent.mm.kernel.a.b.g();
    this.mDY = new com.tencent.mm.kernel.a.b.g();
    this.mDZ = new c((byte)0);
    this.mEa = new c.d();
    this.mEb = new b();
    this.mEc = new e();
    this.mEd = new a();
    this.mEf = false;
    this.mEg = new AtomicBoolean(false);
    this.mEl = new HashSet();
    this.mEm = new ConcurrentHashMap();
    this.mEn = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.bbu();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label202;
      }
      com.tencent.mm.blink.a.Q(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.mEY);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    Log.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    Log.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.f.Ozc.e("BlinkStartup", (String)localObject, paramg);
    label202:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.aF(paramClass).cX(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.mEH;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c baR()
  {
    return mEe;
  }
  
  private boolean baT()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.mEl.contains(Looper.myLooper()))
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.h.baF().mDl.mDG)
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void baU()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.mEn.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.h.baF().cS(localObject);
      mEe.cT(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void baW()
  {
    AppMethodBeat.i(132206);
    c localc = mEe;
    Iterator localIterator = com.tencent.mm.kernel.h.baA().bac().iterator();
    while (localIterator.hasNext()) {
      localc.cT((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.Ch("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void baX()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.Ch("configureAndExecutePendingPlugins");
    this.mDX.c(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.bbi().a(new e.b(), mEh, this.mDX, "configure-functional from pending plugins");
    af.jLB();
    this.mDW.c(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.bbi().a(new e.b(), mEi, this.mDW, "task-functional from pending plugins");
    com.tencent.mm.blink.a.Ch("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void baY()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) || (!com.tencent.mm.kernel.h.baC().aZN()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.mDY.c(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.bbi();
    locale.a(new e.b(), mEj, this.mDY);
    this.mDY.bbv();
    locale.start("account-init from pending plugins");
    locale.bbk();
    AppMethodBeat.o(132208);
  }
  
  public final void FD(String paramString)
  {
    AppMethodBeat.i(132193);
    this.mEb.FE(paramString);
    this.mEc.FD(paramString);
    AppMethodBeat.o(132193);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.mDZ.add((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.mEa.add((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.mEb.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.mEc.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof q)) {
      this.mEd.c((q)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void baN()
  {
    AppMethodBeat.i(369559);
    this.mEc.baN();
    AppMethodBeat.o(369559);
  }
  
  public final void baS()
  {
    AppMethodBeat.i(235311);
    this.mDX.a(new Class[] { com.tencent.mm.kernel.b.b.class });
    this.mDW.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
    this.mDY.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, av.class, com.tencent.mm.kernel.api.c.class });
    this.mDY.b(new Class[] { com.tencent.mm.kernel.api.c.class });
    ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mCB.mDQ = new com.tencent.mm.kernel.a.a.b()
    {
      public final void a(Class paramAnonymousClass, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(132156);
        if (paramAnonymousClass == com.tencent.mm.kernel.a.c.b.class)
        {
          c.baR().mDW.a(paramAnonymousClass, paramAnonymousObject1, paramAnonymousObject2);
          AppMethodBeat.o(132156);
          return;
        }
        if (paramAnonymousClass == com.tencent.mm.kernel.b.b.class) {
          c.baR().mDX.a(paramAnonymousClass, paramAnonymousObject1, paramAnonymousObject2);
        }
        AppMethodBeat.o(132156);
      }
    };
    AppMethodBeat.o(235311);
  }
  
  public final void baV()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.Ch("initializePendingPlugins");
    if (this.mEg.compareAndSet(false, true))
    {
      Log.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      baW();
      baU();
      baX();
      baY();
      this.mEf = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
        com.tencent.mm.kernel.h.baC().aZD();
      }
      com.tencent.mm.blink.a.Ch("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.Yxk) || (com.tencent.mm.protocal.d.Yxj)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && (com.tencent.mm.kernel.h.baC().aZN()))
      {
        a(this.mDW);
        a(this.mDX);
        a(this.mDY);
      }
      com.tencent.mm.kernel.a.b.e.bbi();
      com.tencent.mm.blink.a.Ch("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void cT(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      Log.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.g.cR(paramObject))
    {
      Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.mDY.df(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void cU(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.mEg.get()) || (this.mEf))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!baT())
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.mEm.containsKey(paramObject)) {
      this.mEm.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.mEm.get(paramObject);
    if (!localf.baZ())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.mDY.de(paramObject))
    {
      Log.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.mDY.df(paramObject);
    }
    try
    {
      localf.sD(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.mDX.aF(com.tencent.mm.kernel.b.b.class).dc((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(mEh);
        }
        locala = this.mDW.aF(com.tencent.mm.kernel.a.c.b.class).dc((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEi);
      }
      if (!com.tencent.mm.kernel.h.baC().aZN())
      {
        Log.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.mDY.aF(com.tencent.mm.kernel.api.h.class).dc((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEj);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.mDY.aF(com.tencent.mm.kernel.api.a.class).dc((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEj);
      }
      if ((paramObject instanceof av))
      {
        locala = this.mDY.aF(av.class).dc((av)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEj);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.mDY.aF(com.tencent.mm.kernel.api.e.class).dc((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEj);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.mDY.aF(com.tencent.mm.kernel.api.c.class).dc((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(mEj);
      }
      return;
    }
    finally
    {
      localf.sD(2);
      Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void cV(Object paramObject)
  {
    AppMethodBeat.i(132202);
    Log.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.mEn.putIfAbsent(paramObject, this.mEn);
    AppMethodBeat.o(132202);
  }
  
  public final void h(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    Log.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.mEl.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void i(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.mEd.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.mEd.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.mDV)
    {
      com.tencent.mm.blink.a.Ch("beforeAccountInit");
      this.mDY.c(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.bbi();
      paramc.a(new e.b(), mEj, this.mDY);
      this.mDY.bbv();
      paramc.start("account-init from onAccountInitialized");
      paramc.bbk();
      AppMethodBeat.o(132194);
      return;
    }
    this.mDZ.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.mDZ.onAccountRelease();
    this.mDY.c(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.mEa.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.mDV) {
      this.mEa.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public static final class a
    extends com.tencent.mm.cp.a<q>
    implements q
  {
    public final com.tencent.mm.vending.b.b<q> c(q paramq)
    {
      try
      {
        AppMethodBeat.i(132162);
        paramq = super.add(paramq);
        AppMethodBeat.o(132162);
        return paramq;
      }
      finally
      {
        paramq = finally;
        throw paramq;
      }
    }
    
    public final void onAppBackground(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132164);
        a(new com.tencent.mm.cp.a.a() {});
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
        a(new com.tencent.mm.cp.a.a() {});
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
    extends com.tencent.mm.cp.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean mEq = false;
    
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
        paramString = new u(paramList);
        if ((!paramString.jKS()) && ((!paramString.jKY()) || (!paramString.isDirectory()))) {
          Log.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
        }
        i += 1;
      }
      AppMethodBeat.o(132169);
    }
    
    public final void FE(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = baM();
        this.mEq = true;
        Log.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
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
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b paramb)
    {
      try
      {
        AppMethodBeat.i(132166);
        com.tencent.mm.vending.b.b localb = super.add(paramb);
        if (this.mEq)
        {
          List localList = paramb.baM();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.h.baE().mCJ);
          }
          Log.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> baM()
    {
      AppMethodBeat.i(132167);
      Object localObject1 = getQueue();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).aguu).baM();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(132167);
      return localLinkedList;
    }
  }
  
  public static final class c
    extends com.tencent.mm.cp.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final f.c paramc)
    {
      AppMethodBeat.i(132173);
      a(new com.tencent.mm.cp.a.a() {});
      AppMethodBeat.o(132173);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(132174);
      a(new com.tencent.mm.cp.a.a() {});
      AppMethodBeat.o(132174);
    }
  }
  
  public static final class e
    extends com.tencent.mm.cp.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean mEw = false;
    private String mEx;
    
    public final void FD(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.cp.a.a() {});
        this.mEw = true;
        this.mEx = paramString;
        AppMethodBeat.o(132184);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(132183);
        com.tencent.mm.vending.b.b localb = super.add(paramf);
        if (this.mEw)
        {
          paramf.FD(this.mEx);
          Log.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void baN()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.cp.a.a() {});
      AppMethodBeat.o(132182);
    }
  }
  
  static final class f
  {
    private long mEA;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.mEA = 0L;
      this.mStatus = 0;
      this.mEA = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean baZ()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.mEA == Thread.currentThread().getId()))
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
    
    public final void sD(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.c
 * JD-Core Version:    0.7.0.1
 */