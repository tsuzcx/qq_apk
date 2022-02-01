package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
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
  private static c hrZ;
  public static com.tencent.mm.vending.c.a<Void, f.a> hsc;
  public static com.tencent.mm.vending.c.a<Void, f.a> hsd;
  public static com.tencent.mm.vending.c.a<Void, f.a> hse;
  private static Map<String, Map> hsf;
  private boolean hrQ;
  public final com.tencent.mm.kernel.a.b.g hrR;
  public final com.tencent.mm.kernel.a.b.g hrS;
  public final com.tencent.mm.kernel.a.b.g hrT;
  public final c hrU;
  public final d hrV;
  public final b hrW;
  public final e hrX;
  public final a hrY;
  public volatile boolean hsa;
  private AtomicBoolean hsb;
  private Set<Looper> hsg;
  private ConcurrentHashMap<Object, f> hsh;
  private ConcurrentHashMap hsi;
  
  static
  {
    AppMethodBeat.i(132212);
    hrZ = new c();
    hsc = new com.tencent.mm.vending.c.a() {};
    hsd = new com.tencent.mm.vending.c.a() {};
    hse = new com.tencent.mm.vending.c.a() {};
    hsf = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.hrQ = true;
    this.hrR = new com.tencent.mm.kernel.a.b.g();
    this.hrS = new com.tencent.mm.kernel.a.b.g();
    this.hrT = new com.tencent.mm.kernel.a.b.g();
    this.hrU = new c((byte)0);
    this.hrV = new d();
    this.hrW = new b();
    this.hrX = new e();
    this.hrY = new a();
    this.hsa = false;
    this.hsb = new AtomicBoolean(false);
    this.hsg = new HashSet();
    this.hsh = new ConcurrentHashMap();
    this.hsi = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.aAW();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label202;
      }
      com.tencent.mm.blink.a.t(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.hsU);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    Log.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    Log.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.Cxv.e("BlinkStartup", (String)localObject, paramg);
    label202:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.an(paramClass).bE(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.hsC;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  private void aAA()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) || (!com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.hrT.c(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.aAK();
    locale.a(new e.b(), hse, this.hrT);
    this.hrT.aAX();
    locale.start("account-init from pending plugins");
    locale.aAM();
    AppMethodBeat.o(132208);
  }
  
  public static c aAu()
  {
    return hrZ;
  }
  
  private boolean aAv()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.hsg.contains(Looper.myLooper()))
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.g.aAi().hrh.hrB)
    {
      Log.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void aAw()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.hsi.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.aAi().by(localObject);
      hrZ.bA(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void aAy()
  {
    AppMethodBeat.i(132206);
    c localc = hrZ;
    Iterator localIterator = com.tencent.mm.kernel.g.aAd().azF().iterator();
    while (localIterator.hasNext()) {
      localc.bA((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.CM("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void aAz()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.CM("configureAndExecutePendingPlugins");
    this.hrS.c(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.aAK().a(new e.b(), hsc, this.hrS, "configure-functional from pending plugins");
    y.heW();
    this.hrR.c(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.aAK().a(new e.b(), hsd, this.hrR, "task-functional from pending plugins");
    com.tencent.mm.blink.a.CM("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  public final void FU(String paramString)
  {
    AppMethodBeat.i(132193);
    this.hrW.FV(paramString);
    this.hrX.FU(paramString);
    AppMethodBeat.o(132193);
  }
  
  public final void aAp()
  {
    AppMethodBeat.i(258481);
    this.hrX.aAp();
    AppMethodBeat.o(258481);
  }
  
  public final void aAx()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.CM("initializePendingPlugins");
    if (this.hsb.compareAndSet(false, true))
    {
      Log.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      aAy();
      aAw();
      aAz();
      aAA();
      this.hsa = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
        com.tencent.mm.kernel.g.aAf().azg();
      }
      com.tencent.mm.blink.a.CM("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.KyR) || (com.tencent.mm.protocal.d.KyQ)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) && (com.tencent.mm.kernel.g.aAf().azp()))
      {
        a(this.hrR);
        a(this.hrS);
        a(this.hrT);
      }
      com.tencent.mm.kernel.a.b.e.aAK();
      com.tencent.mm.blink.a.CM("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.hrU.add((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.hrV.add((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.hrW.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.hrX.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.app.o)) {
      this.hrY.c((com.tencent.mm.app.o)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void bA(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      Log.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.f.bx(paramObject))
    {
      Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.hrT.bM(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bB(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.hsb.get()) || (this.hsa))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!aAv())
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.hsh.containsKey(paramObject)) {
      this.hsh.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.hsh.get(paramObject);
    if (!localf.aAB())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.hrT.bL(paramObject))
    {
      Log.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.hrT.bM(paramObject);
    }
    try
    {
      localf.qh(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.hrS.an(com.tencent.mm.kernel.b.b.class).bJ((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(hsc);
        }
        locala = this.hrR.an(com.tencent.mm.kernel.a.c.b.class).bJ((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hsd);
      }
      if (!com.tencent.mm.kernel.g.aAf().azp())
      {
        Log.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.hrT.an(com.tencent.mm.kernel.api.h.class).bJ((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hse);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.hrT.an(com.tencent.mm.kernel.api.a.class).bJ((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hse);
      }
      if ((paramObject instanceof at))
      {
        locala = this.hrT.an(at.class).bJ((at)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hse);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.hrT.an(com.tencent.mm.kernel.api.e.class).bJ((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hse);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.hrT.an(com.tencent.mm.kernel.api.c.class).bJ((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(hse);
      }
      return;
    }
    finally
    {
      localf.qh(2);
      Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(132202);
    Log.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.hsi.putIfAbsent(paramObject, this.hsi);
    AppMethodBeat.o(132202);
  }
  
  public final void f(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    Log.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.hsg.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.hrY.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.hrY.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.hrQ)
    {
      com.tencent.mm.blink.a.CM("beforeAccountInit");
      this.hrT.c(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.aAK();
      paramc.a(new e.b(), hse, this.hrT);
      this.hrT.aAX();
      paramc.start("account-init from onAccountInitialized");
      paramc.aAM();
      AppMethodBeat.o(132194);
      return;
    }
    this.hrU.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.hrU.onAccountRelease();
    this.hrT.c(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.hrV.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.hrQ) {
      this.hrV.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public static final class a
    extends com.tencent.mm.co.a<com.tencent.mm.app.o>
    implements com.tencent.mm.app.o
  {
    public final com.tencent.mm.vending.b.b<com.tencent.mm.app.o> c(com.tencent.mm.app.o paramo)
    {
      try
      {
        AppMethodBeat.i(132162);
        paramo = super.add(paramo);
        AppMethodBeat.o(132162);
        return paramo;
      }
      finally
      {
        paramo = finally;
        throw paramo;
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
    private boolean hsl = false;
    
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
        paramString = new com.tencent.mm.vfs.o(paramList);
        if ((!paramString.exists()) && ((!paramString.mkdirs()) || (!paramString.isDirectory()))) {
          Log.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
        }
        i += 1;
      }
      AppMethodBeat.o(132169);
    }
    
    public final void FV(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = aAo();
        this.hsl = true;
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
        if (this.hsl)
        {
          List localList = paramb.aAo();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.g.aAh().hqG);
          }
          Log.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> aAo()
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
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).QZG).aAo();
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
    private boolean hsr = false;
    private String hss;
    
    public final void FU(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.co.a.a() {});
        this.hsr = true;
        this.hss = paramString;
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
        if (this.hsr)
        {
          paramf.FU(this.hss);
          Log.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void aAp()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(132182);
    }
  }
  
  static final class f
  {
    private long hsv;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.hsv = 0L;
      this.mStatus = 0;
      this.hsv = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean aAB()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.hsv == Thread.currentThread().getId()))
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
    
    public final void qh(int paramInt)
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