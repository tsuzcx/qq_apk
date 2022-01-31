package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static c eJf;
  public static com.tencent.mm.vending.c.a<Void, f.a> eJi;
  public static com.tencent.mm.vending.c.a<Void, f.a> eJj;
  public static com.tencent.mm.vending.c.a<Void, f.a> eJk;
  private static Map<Integer, Map> eJl;
  private boolean eIW;
  public final com.tencent.mm.kernel.a.b.g eIX;
  public final com.tencent.mm.kernel.a.b.g eIY;
  public final com.tencent.mm.kernel.a.b.g eIZ;
  public final c eJa;
  public final d eJb;
  public final b eJc;
  public final e eJd;
  public final a eJe;
  public volatile boolean eJg;
  private AtomicBoolean eJh;
  private Set<Looper> eJm;
  private ConcurrentHashMap<Object, f> eJn;
  private ConcurrentHashMap eJo;
  
  static
  {
    AppMethodBeat.i(58073);
    eJf = new c();
    eJi = new com.tencent.mm.vending.c.a() {};
    eJj = new com.tencent.mm.vending.c.a() {};
    eJk = new com.tencent.mm.vending.c.a() {};
    eJl = new ConcurrentHashMap();
    AppMethodBeat.o(58073);
  }
  
  private c()
  {
    AppMethodBeat.i(58050);
    this.eIW = true;
    this.eIX = new com.tencent.mm.kernel.a.b.g();
    this.eIY = new com.tencent.mm.kernel.a.b.g();
    this.eIZ = new com.tencent.mm.kernel.a.b.g();
    this.eJa = new c((byte)0);
    this.eJb = new d();
    this.eJc = new b();
    this.eJd = new e();
    this.eJe = new a();
    this.eJg = false;
    this.eJh = new AtomicBoolean(false);
    this.eJm = new HashSet();
    this.eJn = new ConcurrentHashMap();
    this.eJo = new ConcurrentHashMap();
    AppMethodBeat.o(58050);
  }
  
  public static c RX()
  {
    return eJf;
  }
  
  private boolean RY()
  {
    AppMethodBeat.i(58061);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      AppMethodBeat.o(58061);
      return false;
    }
    if (this.eJm.contains(Looper.myLooper()))
    {
      ab.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
      AppMethodBeat.o(58061);
      return false;
    }
    if (!com.tencent.mm.kernel.g.RM().eIn.eIH)
    {
      ab.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
      AppMethodBeat.o(58061);
      return false;
    }
    AppMethodBeat.o(58061);
    return true;
  }
  
  private void RZ()
  {
    AppMethodBeat.i(58064);
    Iterator localIterator = this.eJo.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      com.tencent.mm.kernel.g.RM().ao(localObject);
      eJf.aq(localObject);
    }
    AppMethodBeat.o(58064);
  }
  
  private static void Sb()
  {
    AppMethodBeat.i(58067);
    c localc = eJf;
    Iterator localIterator = com.tencent.mm.kernel.g.RH().Ri().iterator();
    while (localIterator.hasNext()) {
      localc.aq((com.tencent.mm.kernel.b.f)localIterator.next());
    }
    com.tencent.mm.blink.a.ks("makePluginsParallelsDependency");
    AppMethodBeat.o(58067);
  }
  
  private void Sc()
  {
    AppMethodBeat.i(58068);
    com.tencent.mm.blink.a.ks("configureAndExecutePendingPlugins");
    this.eIY.c(com.tencent.mm.kernel.b.b.class, false);
    com.tencent.mm.kernel.a.b.e.Sn().a(new e.b(), eJi, this.eIY, "configure-functional from pending plugins");
    this.eIX.c(com.tencent.mm.kernel.a.c.b.class, false);
    com.tencent.mm.kernel.a.b.e.Sn().a(new e.b(), eJj, this.eIX, "task-functional from pending plugins");
    com.tencent.mm.blink.a.ks("configureAndExecutePendingPlugins done");
    AppMethodBeat.o(58068);
  }
  
  private void Sd()
  {
    AppMethodBeat.i(58069);
    if ((!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) || (!com.tencent.mm.kernel.g.RJ().QU()))
    {
      AppMethodBeat.o(58069);
      return;
    }
    this.eIZ.c(com.tencent.mm.kernel.api.h.class, false);
    com.tencent.mm.kernel.a.b.e locale = com.tencent.mm.kernel.a.b.e.Sn();
    locale.a(new e.b(), eJk, this.eIZ);
    this.eIZ.SA();
    locale.start("account-init from pending plugins");
    locale.Sp();
    AppMethodBeat.o(58069);
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    AppMethodBeat.i(58066);
    Object localObject = paramg.Sz();
    if (((Map)localObject).size() > 0) {}
    StringBuilder localStringBuilder;
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject).size() <= 0) {
        break label207;
      }
      com.tencent.mm.blink.a.u(0L, 1L);
      paramg = new HashMap();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.kernel.a.b.f localf = (com.tencent.mm.kernel.a.b.f)localIterator.next();
        List localList = (List)((Map)localObject).get(localf);
        localStringBuilder.append(localf.eKa);
        localStringBuilder.append(" : ");
        localStringBuilder.append(localList.toString());
        localStringBuilder.append("\n");
      }
    }
    localObject = localStringBuilder.toString();
    ab.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject });
    ab.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.e.qrI.g("BlinkStartup", (String)localObject, paramg);
    label207:
    AppMethodBeat.o(58066);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(58051);
    paramg = (f.a)paramg.M(paramClass).av(paramObject);
    if (paramg == null)
    {
      AppMethodBeat.o(58051);
      return false;
    }
    boolean bool = paramg.eJI;
    AppMethodBeat.o(58051);
    return bool;
  }
  
  public final void RS()
  {
    AppMethodBeat.i(156837);
    this.eJd.RS();
    AppMethodBeat.o(156837);
  }
  
  public final void Sa()
  {
    AppMethodBeat.i(58065);
    com.tencent.mm.blink.a.ks("initializePendingPlugins");
    if (this.eJh.compareAndSet(false, true))
    {
      ab.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      Sb();
      RZ();
      Sc();
      Sd();
      this.eJg = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
        com.tencent.mm.kernel.g.RJ().QM();
      }
      com.tencent.mm.blink.a.ks("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.whK) || (com.tencent.mm.protocal.d.whJ)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) && (com.tencent.mm.kernel.g.RJ().QU()))
      {
        a(this.eIX);
        a(this.eIY);
        a(this.eIZ);
      }
      com.tencent.mm.kernel.a.b.e.Sn();
      com.tencent.mm.blink.a.ks("checkAllUnConsumed done");
    }
    AppMethodBeat.o(58065);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(58059);
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.eJa.at((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.eJb.at((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.eJc.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.eJd.a((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof j)) {
      this.eJe.c((j)paramObject);
    }
    AppMethodBeat.o(58059);
  }
  
  public final void aq(Object paramObject)
  {
    AppMethodBeat.i(58052);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      ab.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      AppMethodBeat.o(58052);
      return;
    }
    if (com.tencent.mm.kernel.f.an(paramObject))
    {
      ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      AppMethodBeat.o(58052);
      return;
    }
    this.eIZ.aD(paramObject);
    AppMethodBeat.o(58052);
  }
  
  public final void ar(Object paramObject)
  {
    AppMethodBeat.i(58062);
    if ((!this.eJh.get()) || (this.eJg))
    {
      AppMethodBeat.o(58062);
      return;
    }
    if (!RY())
    {
      ab.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
      AppMethodBeat.o(58062);
      return;
    }
    if (!this.eJn.containsKey(paramObject)) {
      this.eJn.putIfAbsent(paramObject, new f());
    }
    f localf = (f)this.eJn.get(paramObject);
    if (!localf.Se())
    {
      AppMethodBeat.o(58062);
      return;
    }
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    if (!this.eIZ.aC(paramObject))
    {
      ab.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
      this.eIZ.aD(paramObject);
    }
    try
    {
      localf.jP(1);
      f.a locala;
      if ((paramObject instanceof com.tencent.mm.kernel.b.f))
      {
        if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
        {
          locala = this.eIY.M(com.tencent.mm.kernel.b.b.class).aA((com.tencent.mm.kernel.b.b)paramObject);
          Assert.assertNotNull(locala);
          locala.a(eJi);
        }
        locala = this.eIX.M(com.tencent.mm.kernel.a.c.b.class).aA((com.tencent.mm.kernel.a.c.b)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJj);
      }
      if (!com.tencent.mm.kernel.g.RJ().QU())
      {
        ab.i("MicroMsg.CallbacksProxy", "account not init, return.");
        return;
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.h))
      {
        locala = this.eIZ.M(com.tencent.mm.kernel.api.h.class).aA((com.tencent.mm.kernel.api.h)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJk);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.a))
      {
        locala = this.eIZ.M(com.tencent.mm.kernel.api.a.class).aA((com.tencent.mm.kernel.api.a)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJk);
      }
      if ((paramObject instanceof aj))
      {
        locala = this.eIZ.M(aj.class).aA((aj)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJk);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.e))
      {
        locala = this.eIZ.M(com.tencent.mm.kernel.api.e.class).aA((com.tencent.mm.kernel.api.e)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJk);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.c))
      {
        locala = this.eIZ.M(com.tencent.mm.kernel.api.c.class).aA((com.tencent.mm.kernel.api.c)paramObject);
        Assert.assertNotNull(locala);
        locala.a(eJk);
      }
      return;
    }
    finally
    {
      localf.jP(2);
      ab.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(58062);
    }
  }
  
  public final void as(Object paramObject)
  {
    AppMethodBeat.i(58063);
    ab.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramObject });
    this.eJo.putIfAbsent(paramObject, this.eJo);
    AppMethodBeat.o(58063);
  }
  
  public final void d(Looper paramLooper)
  {
    AppMethodBeat.i(58060);
    ab.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.eJm.add(paramLooper);
    AppMethodBeat.o(58060);
  }
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(146107);
    if (paramBoolean)
    {
      this.eJe.onAppForeground(paramString);
      AppMethodBeat.o(146107);
      return;
    }
    this.eJe.onAppBackground(paramString);
    AppMethodBeat.o(146107);
  }
  
  public final void mE(String paramString)
  {
    AppMethodBeat.i(58054);
    this.eJc.mF(paramString);
    this.eJd.mE(paramString);
    AppMethodBeat.o(58054);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(58055);
    if (this.eIW)
    {
      com.tencent.mm.blink.a.ks("beforeAccountInit");
      this.eIZ.c(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.Sn();
      paramc.a(new e.b(), eJk, this.eIZ);
      this.eIZ.SA();
      paramc.start("account-init from onAccountInitialized");
      paramc.Sp();
      AppMethodBeat.o(58055);
      return;
    }
    this.eJa.onAccountInitialized(paramc);
    AppMethodBeat.o(58055);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(58056);
    this.eJa.onAccountRelease();
    this.eIZ.c(com.tencent.mm.kernel.api.h.class, true);
    AppMethodBeat.o(58056);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2)
  {
    AppMethodBeat.i(58058);
    this.eJb.onDataBaseClosed(paramh1, paramh2);
    AppMethodBeat.o(58058);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2)
  {
    AppMethodBeat.i(58057);
    if (!this.eIW) {
      this.eJb.onDataBaseOpened(paramh1, paramh2);
    }
    AppMethodBeat.o(58057);
  }
  
  public static final class a
    extends com.tencent.mm.cm.a<j>
    implements j
  {
    public final com.tencent.mm.vending.b.b<j> c(j paramj)
    {
      try
      {
        AppMethodBeat.i(146103);
        paramj = super.at(paramj);
        AppMethodBeat.o(146103);
        return paramj;
      }
      finally
      {
        paramj = finally;
        throw paramj;
      }
    }
    
    public final void onAppBackground(final String paramString)
    {
      try
      {
        AppMethodBeat.i(146105);
        a(new com.tencent.mm.cm.a.a() {});
        AppMethodBeat.o(146105);
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
        AppMethodBeat.i(146104);
        a(new com.tencent.mm.cm.a.a() {});
        AppMethodBeat.o(146104);
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
    private boolean eJr = false;
    
    private static void c(List<String> paramList, String paramString)
    {
      AppMethodBeat.i(58031);
      String[] arrayOfString = new String[paramList.size() + 1];
      arrayOfString[0] = paramString;
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfString[(i + 1)] = (paramString + (String)paramList.get(i));
        i += 1;
      }
      com.tencent.mm.a.e.d(arrayOfString);
      AppMethodBeat.o(58031);
    }
    
    public final List<String> RR()
    {
      AppMethodBeat.i(58029);
      Object localObject1 = dQj();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).d).RR();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      AppMethodBeat.o(58029);
      return localLinkedList;
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b paramb)
    {
      try
      {
        AppMethodBeat.i(58028);
        com.tencent.mm.vending.b.b localb = super.at(paramb);
        if (this.eJr)
        {
          List localList = paramb.RR();
          if ((localList != null) && (localList.size() > 0)) {
            c(localList, com.tencent.mm.kernel.g.RL().eHR);
          }
          ab.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        AppMethodBeat.o(58028);
        return localb;
      }
      finally {}
    }
    
    public final void mF(String paramString)
    {
      try
      {
        AppMethodBeat.i(58030);
        List localList = RR();
        this.eJr = true;
        ab.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
        c(localList, paramString);
        AppMethodBeat.o(58030);
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
      AppMethodBeat.i(58035);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(58035);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(58036);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(58036);
    }
  }
  
  public static final class d
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.cg.h paramh1, final com.tencent.mm.cg.h paramh2)
    {
      AppMethodBeat.i(58041);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(58041);
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.cg.h paramh1, final com.tencent.mm.cg.h paramh2)
    {
      AppMethodBeat.i(58040);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(58040);
    }
  }
  
  public static final class e
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean eJx = false;
    private String eJy;
    
    public final void RS()
    {
      AppMethodBeat.i(58044);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(58044);
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        AppMethodBeat.i(58045);
        com.tencent.mm.vending.b.b localb = super.at(paramf);
        if (this.eJx)
        {
          paramf.mE(this.eJy);
          ab.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        AppMethodBeat.o(58045);
        return localb;
      }
      finally {}
    }
    
    public final void mE(final String paramString)
    {
      try
      {
        AppMethodBeat.i(58046);
        a(new com.tencent.mm.cm.a.a() {});
        this.eJx = true;
        this.eJy = paramString;
        AppMethodBeat.o(58046);
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
    private long eJB;
    private int mStatus;
    
    public f()
    {
      AppMethodBeat.i(58048);
      this.eJB = 0L;
      this.mStatus = 0;
      this.eJB = Thread.currentThread().getId();
      AppMethodBeat.o(58048);
    }
    
    public final boolean Se()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(58049);
          if ((this.mStatus == 1) && (this.eJB == Thread.currentThread().getId()))
          {
            AppMethodBeat.o(58049);
            return bool;
          }
          if (this.mStatus == 2)
          {
            AppMethodBeat.o(58049);
            continue;
          }
          AppMethodBeat.o(58049);
        }
        finally {}
        bool = true;
      }
    }
    
    public final void jP(int paramInt)
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