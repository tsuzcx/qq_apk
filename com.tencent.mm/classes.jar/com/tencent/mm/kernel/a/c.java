package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
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
  private static c gFl;
  public static com.tencent.mm.vending.c.a<Void, f.a> gFo;
  public static com.tencent.mm.vending.c.a<Void, f.a> gFp;
  public static com.tencent.mm.vending.c.a<Void, f.a> gFq;
  private static Map<String, Map> gFr;
  private boolean gFc;
  public final com.tencent.mm.kernel.a.b.g gFd;
  public final com.tencent.mm.kernel.a.b.g gFe;
  public final com.tencent.mm.kernel.a.b.g gFf;
  public final c gFg;
  public final d gFh;
  public final b gFi;
  public final e gFj;
  public final a gFk;
  public volatile boolean gFm;
  private AtomicBoolean gFn;
  private Set<Looper> gFs;
  private ConcurrentHashMap<Object, f> gFt;
  private ConcurrentHashMap gFu;
  
  static
  {
    AppMethodBeat.i(132212);
    gFl = new c();
    gFo = new com.tencent.mm.vending.c.a() {};
    gFp = new com.tencent.mm.vending.c.a() {};
    gFq = new com.tencent.mm.vending.c.a() {};
    gFr = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.gFc = true;
    this.gFd = new com.tencent.mm.kernel.a.b.g();
    this.gFe = new com.tencent.mm.kernel.a.b.g();
    this.gFf = new com.tencent.mm.kernel.a.b.g();
    this.gFg = new c((byte)0);
    this.gFh = new d();
    this.gFi = new b();
    this.gFj = new e();
    this.gFk = new a();
    this.gFm = false;
    this.gFn = new AtomicBoolean(false);
    this.gFs = new HashSet();
    this.gFt = new ConcurrentHashMap();
    this.gFu = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.akG();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
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
        localStringBuilder.append(localf.gGg);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    ae.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    ae.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.ywz.g("BlinkStartup", (String)localObject, paramg);
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
    boolean bool = paramg.gFO;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c ake()
  {
    return gFl;
  }
  
  private boolean akf()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.gFs.contains(Looper.myLooper()))
    {
      ae.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.g.ajS().gEt.gEN)
    {
      ae.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void akg()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.gFu.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.ajS().bp(localObject);
      gFl.br(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void aki()
  {
    AppMethodBeat.i(132206);
    c localc = gFl;
    Iterator localIterator = com.tencent.mm.kernel.g.ajN().ajp().iterator();
    while (localIterator.hasNext()) {
      localc.br((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.uw("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void akj()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.uw("configureAndExecutePendingPlugins");
    this.gFe.b(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.aku().a(new e.b(), gFo, this.gFe, "configure-functional from pending plugins");
    u.fTL();
    this.gFd.b(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.aku().a(new e.b(), gFp, this.gFd, "task-functional from pending plugins");
    com.tencent.mm.blink.a.uw("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void akk()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    this.gFf.b(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.aku();
    locale.a(new e.b(), gFq, this.gFf);
    this.gFf.akH();
    locale.start("account-init from pending plugins");
    locale.akw();
    AppMethodBeat.o(132208);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.gFg.bu((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.gFh.bu((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.gFi.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.gFj.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof o)) {
      this.gFk.c((o)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void ajZ()
  {
    AppMethodBeat.i(224416);
    this.gFj.ajZ();
    AppMethodBeat.o(224416);
  }
  
  public final void akh()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.uw("initializePendingPlugins");
    if (this.gFn.compareAndSet(false, true))
    {
      ae.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      aki();
      akg();
      akj();
      akk();
      this.gFm = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        com.tencent.mm.kernel.g.ajP().aiQ();
      }
      com.tencent.mm.blink.a.uw("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.FFK) || (com.tencent.mm.protocal.d.FFJ)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) && (com.tencent.mm.kernel.g.ajP().aiZ()))
      {
        a(this.gFd);
        a(this.gFe);
        a(this.gFf);
      }
      com.tencent.mm.kernel.a.b.e.aku();
      com.tencent.mm.blink.a.uw("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void br(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
    {
      ae.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.f.bo(paramObject))
    {
      ae.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.gFf.bE(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bs(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.gFn.get()) || (this.gFm))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!akf())
    {
      ae.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.gFt.containsKey(paramObject)) {
      this.gFt.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.gFt.get(paramObject);
    if (!localf.akl())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    ae.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.gFf.bD(paramObject))
    {
      ae.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.gFf.bE(paramObject);
    }
    try
    {
      localf.mU(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.gFe.aj(com.tencent.mm.kernel.b.b.class).bB((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(gFo);
        }
        locala = this.gFd.aj(com.tencent.mm.kernel.a.c.b.class).bB((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFp);
      }
      if (!com.tencent.mm.kernel.g.ajP().aiZ())
      {
        ae.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.gFf.aj(com.tencent.mm.kernel.api.h.class).bB((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFq);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.gFf.aj(com.tencent.mm.kernel.api.a.class).bB((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFq);
      }
      if ((paramObject instanceof ap))
      {
        locala = this.gFf.aj(ap.class).bB((ap)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFq);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.gFf.aj(com.tencent.mm.kernel.api.e.class).bB((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFq);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.gFf.aj(com.tencent.mm.kernel.api.c.class).bB((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(gFq);
      }
      return;
    }
    finally
    {
      localf.mU(2);
      ae.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void bt(Object paramObject)
  {
    AppMethodBeat.i(132202);
    ae.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.gFu.putIfAbsent(paramObject, this.gFu);
    AppMethodBeat.o(132202);
  }
  
  public final void f(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    ae.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.gFs.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void f(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.gFk.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.gFk.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.gFc)
    {
      com.tencent.mm.blink.a.uw("beforeAccountInit");
      this.gFf.b(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.aku();
      paramc.a(new e.b(), gFq, this.gFf);
      this.gFf.akH();
      paramc.start("account-init from onAccountInitialized");
      paramc.akw();
      AppMethodBeat.o(132194);
      return;
    }
    this.gFg.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.gFg.onAccountRelease();
    this.gFf.b(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.gFh.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.gFc) {
      this.gFh.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public final void xK(String paramString)
  {
    AppMethodBeat.i(132193);
    this.gFi.xL(paramString);
    this.gFj.xK(paramString);
    AppMethodBeat.o(132193);
  }
  
  public static final class a
    extends com.tencent.mm.cm.a<o>
    implements o
  {
    public final com.tencent.mm.vending.b.b<o> c(o paramo)
    {
      try
      {
        AppMethodBeat.i(132162);
        paramo = super.bu(paramo);
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
        a(new com.tencent.mm.cm.a.a() {});
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
        a(new com.tencent.mm.cm.a.a() {});
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
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean gFx = false;
    
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
        paramString = new k(paramList);
        if ((!paramString.exists()) && ((!paramString.mkdirs()) || (!paramString.isDirectory()))) {
          ae.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
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
        if (this.gFx)
        {
          List localList = paramb.ajY();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.g.ajR().gDT);
          }
          ae.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> ajY()
    {
      AppMethodBeat.i(132167);
      Object localObject1 = fSr();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).LEn).ajY();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(132167);
      return localLinkedList;
    }
    
    public final void xL(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = ajY();
        this.gFx = true;
        ae.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
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
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final e.c paramc)
    {
      AppMethodBeat.i(132173);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(132173);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(132174);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(132174);
    }
  }
  
  public static final class d
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132179);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(132179);
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132178);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(132178);
    }
  }
  
  public static final class e
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean gFD = false;
    private String gFE;
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(132183);
        com.tencent.mm.vending.b.b localb = super.bu(paramf);
        if (this.gFD)
        {
          paramf.xK(this.gFE);
          ae.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void ajZ()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(132182);
    }
    
    public final void xK(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.cm.a.a() {});
        this.gFD = true;
        this.gFE = paramString;
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
    private long gFH;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.gFH = 0L;
      this.mStatus = 0;
      this.gFH = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean akl()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.gFH == Thread.currentThread().getId()))
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
    
    public final void mU(int paramInt)
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