package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.q;
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
  private static c kdU;
  public static com.tencent.mm.vending.c.a<Void, f.a> kdX;
  public static com.tencent.mm.vending.c.a<Void, f.a> kdY;
  public static com.tencent.mm.vending.c.a<Void, f.a> kdZ;
  private static Map<String, Map> kea;
  private boolean kdL;
  public final com.tencent.mm.kernel.a.b.g kdM;
  public final com.tencent.mm.kernel.a.b.g kdN;
  public final com.tencent.mm.kernel.a.b.g kdO;
  public final c kdP;
  public final d kdQ;
  public final b kdR;
  public final e kdS;
  public final a kdT;
  public volatile boolean kdV;
  private AtomicBoolean kdW;
  private Set<Looper> keb;
  private ConcurrentHashMap<Object, f> kec;
  private ConcurrentHashMap ked;
  
  static
  {
    AppMethodBeat.i(132212);
    kdU = new c();
    kdX = new com.tencent.mm.vending.c.a() {};
    kdY = new com.tencent.mm.vending.c.a() {};
    kdZ = new com.tencent.mm.vending.c.a() {};
    kea = new ConcurrentHashMap();
    AppMethodBeat.o(132212);
  }
  
  private c()
  {
    AppMethodBeat.i(132188);
    this.kdL = true;
    this.kdM = new com.tencent.mm.kernel.a.b.g();
    this.kdN = new com.tencent.mm.kernel.a.b.g();
    this.kdO = new com.tencent.mm.kernel.a.b.g();
    this.kdP = new c((byte)0);
    this.kdQ = new d();
    this.kdR = new b();
    this.kdS = new e();
    this.kdT = new a();
    this.kdV = false;
    this.kdW = new AtomicBoolean(false);
    this.keb = new HashSet();
    this.kec = new ConcurrentHashMap();
    this.ked = new ConcurrentHashMap();
    AppMethodBeat.o(132188);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(132205);
    Object localObject = paramg.aIz();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label204;
      }
      com.tencent.mm.blink.a.t(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.keP);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    Log.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    Log.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.f.Iyx.e("BlinkStartup", (String)localObject, paramg);
    label204:
    AppMethodBeat.o(132205);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(132189);
    paramg = (f.a)paramg.am(paramClass).bE(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(132189);
      return false;
    }
    boolean bool = paramg.kex;
    AppMethodBeat.o(132189);
    return bool;
  }
  
  public static c aHV()
  {
    return kdU;
  }
  
  private void aHX()
  {
    AppMethodBeat.i(197216);
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199516);
        if (!com.tencent.mm.kernel.h.aHE().kbT)
        {
          Log.e("MicroMsg.CallbacksProxy", "account has not done all notification!");
          try
          {
            com.tencent.mm.rabbiteye.a.hpL();
            AppMethodBeat.o(199516);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("MicroMsg.CallbacksProxy", "printTrace error, message = %s", new Object[] { localThrowable.getMessage() });
          }
        }
        AppMethodBeat.o(199516);
      }
    }, 180000L);
    AppMethodBeat.o(197216);
  }
  
  private boolean aHY()
  {
    AppMethodBeat.i(132200);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      AppMethodBeat.o(132200);
      return false;
    }
    if (this.keb.contains(Looper.myLooper()))
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(132200);
      return false;
    }
    if (!com.tencent.mm.kernel.h.aHH().kdc.kdw)
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(132200);
      return false;
    }
    AppMethodBeat.o(132200);
    return true;
  }
  
  private void aHZ()
  {
    AppMethodBeat.i(132203);
    Iterator localIterator = this.ked.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.h.aHH().by(localObject);
      kdU.bA(localObject);
    }
    AppMethodBeat.o(132203);
  }
  
  private static void aIb()
  {
    AppMethodBeat.i(132206);
    c localc = kdU;
    Iterator localIterator = com.tencent.mm.kernel.h.aHC().aHe().iterator();
    while (localIterator.hasNext()) {
      localc.bA((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.JB("makePluginsParallelsDependency");
    AppMethodBeat.o(132206);
  }
  
  private void aIc()
  {
    AppMethodBeat.i(132207);
    com.tencent.mm.blink.a.JB("configureAndExecutePendingPlugins");
    this.kdN.c(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.aIn().a(new e.b(), kdX, this.kdN, "configure-functional from pending plugins");
    ab.igo();
    this.kdM.c(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.aIn().a(new e.b(), kdY, this.kdM, "task-functional from pending plugins");
    com.tencent.mm.blink.a.JB("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(132207);
  }
  
  private void aId()
  {
    AppMethodBeat.i(132208);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      AppMethodBeat.o(132208);
      return;
    }
    aHX();
    this.kdO.c(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.aIn();
    locale.a(new e.b(), kdZ, this.kdO);
    this.kdO.aIA();
    locale.start("account-init from pending plugins");
    locale.aIp();
    AppMethodBeat.o(132208);
  }
  
  public final void MU(String paramString)
  {
    AppMethodBeat.i(132193);
    this.kdR.MV(paramString);
    this.kdS.MU(paramString);
    AppMethodBeat.o(132193);
  }
  
  public final void aHQ()
  {
    AppMethodBeat.i(292864);
    this.kdS.aHQ();
    AppMethodBeat.o(292864);
  }
  
  public final void aHW()
  {
    AppMethodBeat.i(197207);
    this.kdN.a(new Class[] { com.tencent.mm.kernel.b.b.class });
    this.kdM.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
    this.kdO.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, au.class, com.tencent.mm.kernel.api.c.class });
    this.kdO.b(new Class[] { com.tencent.mm.kernel.api.c.class });
    ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).kct.kdG = new com.tencent.mm.kernel.a.a.b()
    {
      public final void a(Class paramAnonymousClass, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(132156);
        if (paramAnonymousClass == com.tencent.mm.kernel.a.c.b.class)
        {
          c.aHV().kdM.a(paramAnonymousClass, paramAnonymousObject1, paramAnonymousObject2);
          AppMethodBeat.o(132156);
          return;
        }
        if (paramAnonymousClass == com.tencent.mm.kernel.b.b.class) {
          c.aHV().kdN.a(paramAnonymousClass, paramAnonymousObject1, paramAnonymousObject2);
        }
        AppMethodBeat.o(132156);
      }
    };
    AppMethodBeat.o(197207);
  }
  
  public final void aIa()
  {
    AppMethodBeat.i(132204);
    com.tencent.mm.blink.a.JB("initializePendingPlugins");
    if (this.kdW.compareAndSet(false, true))
    {
      Log.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      aIb();
      aHZ();
      aIc();
      aId();
      this.kdV = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
        com.tencent.mm.kernel.h.aHE().aGB();
      }
      com.tencent.mm.blink.a.JB("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.RAG) || (com.tencent.mm.protocal.d.RAF)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) && (com.tencent.mm.kernel.h.aHE().aGM()))
      {
        a(this.kdM);
        a(this.kdN);
        a(this.kdO);
      }
      com.tencent.mm.kernel.a.b.e.aIn();
      com.tencent.mm.blink.a.JB("checkAllUnConsumed done");
    }
    AppMethodBeat.o(132204);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(132198);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.kdP.add((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.kdQ.add((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.kdR.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.kdS.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof o)) {
      this.kdT.c((o)paramObject);
    }
    AppMethodBeat.o(132198);
  }
  
  public final void bA(Object paramObject)
  {
    AppMethodBeat.i(132190);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      Log.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(132190);
      return;
    }
    if (com.tencent.mm.kernel.g.bx(paramObject))
    {
      Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(132190);
      return;
    }
    this.kdO.bM(paramObject);
    AppMethodBeat.o(132190);
  }
  
  public final void bB(Object paramObject)
  {
    AppMethodBeat.i(132201);
    if ((!this.kdW.get()) || (this.kdV))
    {
      AppMethodBeat.o(132201);
      return;
    }
    if (!aHY())
    {
      Log.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(132201);
      return;
    }
    if (!this.kec.containsKey(paramObject)) {
      this.kec.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.kec.get(paramObject);
    if (!localf.aIe())
    {
      AppMethodBeat.o(132201);
      return;
    }
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.kdO.bL(paramObject))
    {
      Log.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.kdO.bM(paramObject);
    }
    try
    {
      localf.sH(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.kdN.am(com.tencent.mm.kernel.b.b.class).bJ((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(kdX);
        }
        locala = this.kdM.am(com.tencent.mm.kernel.a.c.b.class).bJ((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdY);
      }
      if (!com.tencent.mm.kernel.h.aHE().aGM())
      {
        Log.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.kdO.am(com.tencent.mm.kernel.api.h.class).bJ((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.kdO.am(com.tencent.mm.kernel.api.a.class).bJ((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdZ);
      }
      if ((paramObject instanceof au))
      {
        locala = this.kdO.am(au.class).bJ((au)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.kdO.am(com.tencent.mm.kernel.api.e.class).bJ((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdZ);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.kdO.am(com.tencent.mm.kernel.api.c.class).bJ((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(kdZ);
      }
      return;
    }
    finally
    {
      localf.sH(2);
      Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132201);
    }
  }
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(132202);
    Log.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.ked.putIfAbsent(paramObject, this.ked);
    AppMethodBeat.o(132202);
  }
  
  public final void g(Looper paramLooper)
  {
    AppMethodBeat.i(132199);
    Log.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.keb.add(paramLooper);
    AppMethodBeat.o(132199);
  }
  
  public final void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132191);
    if (paramBoolean)
    {
      this.kdT.onAppForeground(paramString);
      AppMethodBeat.o(132191);
      return;
    }
    this.kdT.onAppBackground(paramString);
    AppMethodBeat.o(132191);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(132194);
    if (this.kdL)
    {
      com.tencent.mm.blink.a.JB("beforeAccountInit");
      aHX();
      this.kdO.c(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.aIn();
      paramc.a(new e.b(), kdZ, this.kdO);
      this.kdO.aIA();
      paramc.start("account-init from onAccountInitialized");
      paramc.aIp();
      AppMethodBeat.o(132194);
      return;
    }
    this.kdP.onAccountInitialized(paramc);
    AppMethodBeat.o(132194);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(132195);
    this.kdP.onAccountRelease();
    this.kdO.c(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(132195);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132197);
    this.kdQ.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(132197);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(132196);
    if (!this.kdL) {
      this.kdQ.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(132196);
  }
  
  public static final class a
    extends com.tencent.mm.cw.a<o>
    implements o
  {
    public final com.tencent.mm.vending.b.b<o> c(o paramo)
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
        a(new com.tencent.mm.cw.a.a() {});
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
        a(new com.tencent.mm.cw.a.a() {});
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
    extends com.tencent.mm.cw.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean keg = false;
    
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
        paramString = new q(paramList);
        if ((!paramString.ifE()) && ((!paramString.ifL()) || (!paramString.isDirectory()))) {
          Log.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", new Object[] { paramList });
        }
        i += 1;
      }
      AppMethodBeat.o(132169);
    }
    
    public final void MV(String paramString)
    {
      try
      {
        AppMethodBeat.i(132168);
        List localList = aHP();
        this.keg = true;
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
        if (this.keg)
        {
          List localList = paramb.aHP();
          if ((localList != null) && (localList.size() > 0)) {
            d(localList, com.tencent.mm.kernel.h.aHG().kcB);
          }
          Log.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(132166);
        return localb;
      }
      finally {}
    }
    
    public final List<String> aHP()
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
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).YzW).aHP();
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
    extends com.tencent.mm.cw.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final f.c paramc)
    {
      AppMethodBeat.i(132173);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(132173);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(132174);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(132174);
    }
  }
  
  public static final class d
    extends com.tencent.mm.cw.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132179);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(132179);
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.storagebase.h paramh1, final com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(132178);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(132178);
    }
  }
  
  public static final class e
    extends com.tencent.mm.cw.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean kem = false;
    private String ken;
    
    public final void MU(final String paramString)
    {
      try
      {
        AppMethodBeat.i(132184);
        a(new com.tencent.mm.cw.a.a() {});
        this.kem = true;
        this.ken = paramString;
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
        if (this.kem)
        {
          paramf.MU(this.ken);
          Log.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(132183);
        return localb;
      }
      finally {}
    }
    
    public final void aHQ()
    {
      AppMethodBeat.i(132182);
      a(new com.tencent.mm.cw.a.a() {});
      AppMethodBeat.o(132182);
    }
  }
  
  static final class f
  {
    private long keq;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(132186);
      this.keq = 0L;
      this.mStatus = 0;
      this.keq = Thread.currentThread().getId();
      AppMethodBeat.o(132186);
    }
    
    public final boolean aIe()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(132187);
          if ((this.mStatus == 1) && (this.keq == Thread.currentThread().getId()))
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
    
    public final void sH(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.c
 * JD-Core Version:    0.7.0.1
 */