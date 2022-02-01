package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.am;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static c giU;
  public static com.tencent.mm.vending.c.a<Void, f.a> giX;
  public static com.tencent.mm.vending.c.a<Void, f.a> giY;
  public static com.tencent.mm.vending.c.a<Void, f.a> giZ;
  private static Map<String, Map> gja;
  private boolean giL;
  public final com.tencent.mm.kernel.a.b.g giM;
  public final com.tencent.mm.kernel.a.b.g giN;
  public final com.tencent.mm.kernel.a.b.g giO;
  public final c giP;
  public final d giQ;
  public final b giR;
  public final e giS;
  public final a giT;
  public volatile boolean giV;
  private AtomicBoolean giW;
  private Set<Looper> gjb;
  private ConcurrentHashMap<Object, f> gjc;
  private ConcurrentHashMap gjd;
  
  static
  {
    AppMethodBeat.i(132212);
    giU = new c();
    giX = new com.tencent.mm.vending.c.a() {};
    giY = new com.tencent.mm.vending.c.a() {};
    giZ = new com.tencent.mm.vending.c.a() {};
    gja = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.giL = true;
    this.giM = new com.tencent.mm.kernel.a.b.g();
    this.giN = new com.tencent.mm.kernel.a.b.g();
    this.giO = new com.tencent.mm.kernel.a.b.g();
    this.giP = new c((byte)0);
    this.giQ = new d();
    this.giR = new b();
    this.giS = new e();
    this.giT = new a();
    this.giV = false;
    this.giW = new AtomicBoolean(false);
    this.gjb = new HashSet();
    this.gjc = new ConcurrentHashMap();
    this.gjd = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.ahG();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
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
        localStringBuilder.append(localf.gjP);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    ac.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    ac.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.wTc.g("BlinkStartup", (String)localObject, paramg);
    label202:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.aj(paramClass).bu(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.gjx;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c ahe()
  {
    return giU;
  }
  
  private boolean ahf()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.gjb.contains(Looper.myLooper()))
    {
      ac.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.g.agS().gic.giw)
    {
      ac.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void ahg()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.gjd.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.agS().bn(localObject);
      giU.bp(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void ahi()
  {
    AppMethodBeat.i(132206);
    c localc = giU;
    Iterator localIterator = com.tencent.mm.kernel.g.agN().ago().iterator();
    while (localIterator.hasNext()) {
      localc.bp((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.rp("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void ahj()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.rp("configureAndExecutePendingPlugins");
    this.giN.b(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.ahu().a(new e.b(), giX, this.giN, "configure-functional from pending plugins");
    o.fyt();
    this.giM.b(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.ahu().a(new e.b(), giY, this.giM, "task-functional from pending plugins");
    com.tencent.mm.blink.a.rp("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void ahk()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) || (!com.tencent.mm.kernel.g.agP().afY()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.giO.b(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.ahu();
    locale.a(new e.b(), giZ, this.giO);
    this.giO.ahH();
    locale.start("account-init from pending plugins");
    locale.ahw();
    AppMethodBeat.o(132208);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.giP.bs((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.giQ.bs((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.giR.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.giS.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof n)) {
      this.giT.c((n)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void agZ()
  {
    AppMethodBeat.i(210301);
    this.giS.agZ();
    AppMethodBeat.o(210301);
  }
  
  public final void ahh()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.rp("initializePendingPlugins");
    if (this.giW.compareAndSet(false, true))
    {
      ac.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      ahi();
      ahg();
      ahj();
      ahk();
      this.giV = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
        com.tencent.mm.kernel.g.agP().afP();
      }
      com.tencent.mm.blink.a.rp("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.DIf) || (com.tencent.mm.protocal.d.DIe)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) && (com.tencent.mm.kernel.g.agP().afY()))
      {
        a(this.giM);
        a(this.giN);
        a(this.giO);
      }
      com.tencent.mm.kernel.a.b.e.ahu();
      com.tencent.mm.blink.a.rp("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void bp(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      ac.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.f.bm(paramObject))
    {
      ac.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.giO.bC(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bq(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.giW.get()) || (this.giV))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!ahf())
    {
      ac.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.gjc.containsKey(paramObject)) {
      this.gjc.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.gjc.get(paramObject);
    if (!localf.ahl())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    ac.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.giO.bB(paramObject))
    {
      ac.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.giO.bC(paramObject);
    }
    try
    {
      localf.ms(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.giN.aj(com.tencent.mm.kernel.b.b.class).bz((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(giX);
        }
        locala = this.giM.aj(com.tencent.mm.kernel.a.c.b.class).bz((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giY);
      }
      if (!com.tencent.mm.kernel.g.agP().afY())
      {
        ac.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.giO.aj(com.tencent.mm.kernel.api.h.class).bz((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.giO.aj(com.tencent.mm.kernel.api.a.class).bz((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giZ);
      }
      if ((paramObject instanceof am))
      {
        locala = this.giO.aj(am.class).bz((am)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.giO.aj(com.tencent.mm.kernel.api.e.class).bz((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.giO.aj(com.tencent.mm.kernel.api.c.class).bz((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(giZ);
      }
      return;
    }
    finally
    {
      localf.ms(2);
      ac.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void br(Object paramObject)
  {
    AppMethodBeat.i(132202);
    ac.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.gjd.putIfAbsent(paramObject, this.gjd);
    AppMethodBeat.o(132202);
  }
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.giT.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.giT.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void f(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    ac.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.gjb.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.giL)
    {
      com.tencent.mm.blink.a.rp("beforeAccountInit");
      this.giO.b(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.ahu();
      paramc.a(new e.b(), giZ, this.giO);
      this.giO.ahH();
      paramc.start("account-init from onAccountInitialized");
      paramc.ahw();
      AppMethodBeat.o(132194);
      return;
    }
    this.giP.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.giP.onAccountRelease();
    this.giO.b(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.giQ.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.giL) {
      this.giQ.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public final void ul(String paramString)
  {
    AppMethodBeat.i(132193);
    this.giR.um(paramString);
    this.giS.ul(paramString);
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
        paramn = super.bs(paramn);
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
    private boolean gjg = false;
    
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
          ac.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
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
        com.tencent.mm.vending.b.b localb = super.bs(paramb);
        if (this.gjg)
        {
          List localList = paramb.agY();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.g.agR().ghC);
          }
          ac.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> agY()
    {
      AppMethodBeat.i(132167);
      Object localObject1 = fxj();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).Jqg).agY();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(132167);
      return localLinkedList;
    }
    
    public final void um(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = agY();
        this.gjg = true;
        ac.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
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
    private boolean gjm = false;
    private String gjn;
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(132183);
        com.tencent.mm.vending.b.b localb = super.bs(paramf);
        if (this.gjm)
        {
          paramf.ul(this.gjn);
          ac.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void agZ()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(132182);
    }
    
    public final void ul(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.cn.a.a() {});
        this.gjm = true;
        this.gjn = paramString;
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
    private long gjq;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.gjq = 0L;
      this.mStatus = 0;
      this.gjq = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean ahl()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.gjq == Thread.currentThread().getId()))
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
    
    public final void ms(int paramInt)
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