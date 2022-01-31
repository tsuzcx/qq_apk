package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.f.a;
import com.tencent.mm.kernel.a.b.g.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.y;
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
  private static c dLF = new c();
  public static com.tencent.mm.vending.c.a<Void, f.a> dLI = new com.tencent.mm.vending.c.a() {};
  public static com.tencent.mm.vending.c.a<Void, f.a> dLJ = new com.tencent.mm.vending.c.a() {};
  public static com.tencent.mm.vending.c.a<Void, f.a> dLK = new com.tencent.mm.vending.c.a() {};
  private static Map<Integer, Map> dLL = new ConcurrentHashMap();
  public final com.tencent.mm.kernel.a.b.g dLA = new com.tencent.mm.kernel.a.b.g();
  public final b dLB = new b((byte)0);
  public final c dLC = new c();
  public final a dLD = new a();
  public final d dLE = new d();
  public volatile boolean dLG = false;
  private AtomicBoolean dLH = new AtomicBoolean(false);
  private Set<Looper> dLM = new HashSet();
  private ConcurrentHashMap<Object, e> dLN = new ConcurrentHashMap();
  public ConcurrentHashMap dLO = new ConcurrentHashMap();
  private boolean dLx = true;
  public final com.tencent.mm.kernel.a.b.g dLy = new com.tencent.mm.kernel.a.b.g();
  public final com.tencent.mm.kernel.a.b.g dLz = new com.tencent.mm.kernel.a.b.g();
  
  public static c DY()
  {
    return dLF;
  }
  
  private static void a(com.tencent.mm.kernel.a.b.g paramg)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramg.dMJ.values().iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.kernel.a.b.f)((Iterator)localObject2).next();
      localObject4 = ((com.tencent.mm.kernel.a.b.f)localObject3).Ep();
      if (((List)localObject4).size() > 0) {
        ((Map)localObject1).put(localObject3, localObject4);
      }
    }
    if (((Map)localObject1).size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", new Object[] { Boolean.valueOf(bool), paramg });
      if (((Map)localObject1).size() <= 0) {
        return;
      }
      com.tencent.mm.blink.a.n(0L, 1L);
      paramg = new HashMap();
      localObject2 = new StringBuilder();
      localObject3 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.kernel.a.b.f)((Iterator)localObject3).next();
        List localList = (List)((Map)localObject1).get(localObject4);
        ((StringBuilder)localObject2).append(((com.tencent.mm.kernel.a.b.f)localObject4).dMz);
        ((StringBuilder)localObject2).append(" : ");
        ((StringBuilder)localObject2).append(localList.toString());
        ((StringBuilder)localObject2).append("\n");
      }
    }
    localObject1 = ((StringBuilder)localObject2).toString();
    y.e("MicroMsg.CallbacksProxy", "unconsumed message %s", new Object[] { localObject1 });
    y.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
    com.tencent.mm.plugin.report.f.nEG.d("BlinkStartup", (String)localObject1, paramg);
  }
  
  public static boolean a(com.tencent.mm.kernel.a.b.g paramg, Class paramClass, Object paramObject)
  {
    paramg = (f.a)paramg.y(paramClass).al(paramObject);
    if (paramg == null) {
      return false;
    }
    return paramg.dMh;
  }
  
  public final void DU()
  {
    this.dLE.DU();
  }
  
  public final void DZ()
  {
    com.tencent.mm.blink.a.el("initializePendingPlugins");
    Object localObject1;
    if (this.dLH.compareAndSet(false, true))
    {
      y.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
      localObject1 = dLF;
      Object localObject2 = com.tencent.mm.kernel.g.DL().Dq().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).ah((com.tencent.mm.kernel.b.f)((Iterator)localObject2).next());
      }
      com.tencent.mm.blink.a.el("makePluginsParallelsDependency");
      localObject1 = this.dLO.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.DQ().a((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr(), localObject2);
        dLF.ah(localObject2);
      }
      com.tencent.mm.blink.a.el("configureAndExecutePendingPlugins");
      this.dLz.b(com.tencent.mm.kernel.b.b.class, false);
      com.tencent.mm.kernel.a.b.e.Ej().a(new e.b(), dLI, this.dLz, "configure-functional from pending plugins");
      this.dLy.b(com.tencent.mm.kernel.a.c.b.class, false);
      com.tencent.mm.kernel.a.b.e.Ej().a(new e.b(), dLJ, this.dLy, "task-functional from pending plugins");
      com.tencent.mm.blink.a.el("configureAndExecutePendingPlugins done");
      if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) && (com.tencent.mm.kernel.g.DN().Dc())) {
        break label334;
      }
    }
    for (;;)
    {
      this.dLG = true;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
        com.tencent.mm.kernel.g.DN().CT();
      }
      com.tencent.mm.blink.a.el("initializePendingPlugins done");
      if (((com.tencent.mm.protocal.d.spd) || (com.tencent.mm.protocal.d.spc)) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) && (com.tencent.mm.kernel.g.DN().Dc()))
      {
        a(this.dLy);
        a(this.dLz);
        a(this.dLA);
      }
      com.tencent.mm.kernel.a.b.e.Ej().stop();
      com.tencent.mm.blink.a.el("checkAllUnConsumed done");
      return;
      label334:
      this.dLA.b(com.tencent.mm.kernel.api.h.class, false);
      localObject1 = com.tencent.mm.kernel.a.b.e.Ej();
      ((com.tencent.mm.kernel.a.b.e)localObject1).a(new e.b(), dLK, this.dLA);
      this.dLA.Ev();
      ((com.tencent.mm.kernel.a.b.e)localObject1).start("account-init from pending plugins");
      ((com.tencent.mm.kernel.a.b.e)localObject1).El();
    }
  }
  
  public final void add(Object paramObject)
  {
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.dLB.aj((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.dLC.aj((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.dLD.a((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.dLE.a((com.tencent.mm.kernel.api.f)paramObject);
    }
  }
  
  public final void ah(Object paramObject)
  {
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
    {
      y.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
      return;
    }
    if (com.tencent.mm.kernel.f.af(paramObject))
    {
      y.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
      return;
    }
    this.dLA.aq(paramObject);
  }
  
  public final void ai(Object paramObject)
  {
    if ((!this.dLH.get()) || (this.dLG)) {}
    int i;
    e locale;
    do
    {
      return;
      if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
        i = 0;
      }
      while (i == 0)
      {
        y.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", new Object[] { paramObject });
        return;
        if (this.dLM.contains(Looper.myLooper()))
        {
          y.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", new Object[] { Looper.myLooper() });
          i = 0;
        }
        else if (!com.tencent.mm.kernel.g.DQ().dKP.dLj)
        {
          y.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
      if (!this.dLN.containsKey(paramObject)) {
        this.dLN.putIfAbsent(paramObject, new e());
      }
      locale = (e)this.dLN.get(paramObject);
    } while (!locale.Ea());
    long l = System.currentTimeMillis();
    y.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", new Object[] { paramObject });
    y.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
    Object localObject1 = (g.a)this.dLA.dMP.get(paramObject);
    if ((localObject1 != null) && (((g.a)localObject1).Ew())) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        y.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
        this.dLA.aq(paramObject);
      }
      try
      {
        locale.hy(1);
        if ((paramObject instanceof com.tencent.mm.kernel.b.f))
        {
          if (!((com.tencent.mm.kernel.b.f)paramObject).isConfigured())
          {
            localObject1 = this.dLz.y(com.tencent.mm.kernel.b.b.class).ap((com.tencent.mm.kernel.b.b)paramObject);
            Assert.assertNotNull(localObject1);
            ((f.a)localObject1).a(dLI);
          }
          localObject1 = this.dLy.y(com.tencent.mm.kernel.a.c.b.class).ap((com.tencent.mm.kernel.a.c.b)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLJ);
        }
        if (!com.tencent.mm.kernel.g.DN().Dc())
        {
          y.i("MicroMsg.CallbacksProxy", "account not init, return.");
          return;
          i = 0;
          continue;
        }
        if ((paramObject instanceof com.tencent.mm.kernel.api.h))
        {
          localObject1 = this.dLA.y(com.tencent.mm.kernel.api.h.class).ap((com.tencent.mm.kernel.api.h)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLK);
        }
        if ((paramObject instanceof com.tencent.mm.kernel.api.a))
        {
          localObject1 = this.dLA.y(com.tencent.mm.kernel.api.a.class).ap((com.tencent.mm.kernel.api.a)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLK);
        }
        if ((paramObject instanceof ai))
        {
          localObject1 = this.dLA.y(ai.class).ap((ai)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLK);
        }
        if ((paramObject instanceof com.tencent.mm.kernel.api.e))
        {
          localObject1 = this.dLA.y(com.tencent.mm.kernel.api.e.class).ap((com.tencent.mm.kernel.api.e)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLK);
        }
        if ((paramObject instanceof com.tencent.mm.kernel.api.c))
        {
          localObject1 = this.dLA.y(com.tencent.mm.kernel.api.c.class).ap((com.tencent.mm.kernel.api.c)paramObject);
          Assert.assertNotNull(localObject1);
          ((f.a)localObject1).a(dLK);
        }
        return;
      }
      finally
      {
        locale.hy(2);
        y.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", new Object[] { paramObject, Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void b(Looper paramLooper)
  {
    y.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", new Object[] { paramLooper });
    this.dLM.add(paramLooper);
  }
  
  public final void gj(String paramString)
  {
    this.dLD.gk(paramString);
    this.dLE.gj(paramString);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    if (this.dLx)
    {
      com.tencent.mm.blink.a.el("beforeAccountInit");
      this.dLA.b(com.tencent.mm.kernel.api.c.class, true);
      paramc = com.tencent.mm.kernel.a.b.e.Ej();
      paramc.a(new e.b(), dLK, this.dLA);
      this.dLA.Ev();
      paramc.start("account-init from onAccountInitialized");
      paramc.El();
      return;
    }
    this.dLB.onAccountInitialized(paramc);
  }
  
  public final void onAccountRelease()
  {
    this.dLB.onAccountRelease();
    this.dLA.b(com.tencent.mm.kernel.api.h.class, true);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    this.dLC.onDataBaseClosed(paramh1, paramh2);
  }
  
  public final void onDataBaseOpened(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    if (!this.dLx) {
      this.dLC.onDataBaseOpened(paramh1, paramh2);
    }
  }
  
  public static final class a
    extends com.tencent.mm.ck.a<com.tencent.mm.kernel.api.b>
    implements com.tencent.mm.kernel.api.b
  {
    private boolean dLQ = false;
    
    private static void b(List<String> paramList, String paramString)
    {
      String[] arrayOfString = new String[paramList.size() + 1];
      arrayOfString[0] = paramString;
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfString[(i + 1)] = (paramString + (String)paramList.get(i));
        i += 1;
      }
      com.tencent.mm.a.e.d(arrayOfString);
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b paramb)
    {
      try
      {
        com.tencent.mm.vending.b.b localb = super.aj(paramb);
        if (this.dLQ)
        {
          List localList = paramb.collectStoragePaths();
          if ((localList != null) && (localList.size() > 0)) {
            b(localList, com.tencent.mm.kernel.g.DP().dKt);
          }
          y.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", new Object[] { paramb });
        }
        return localb;
      }
      finally {}
    }
    
    public final List<String> collectStoragePaths()
    {
      Object localObject1 = cKT();
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vending.b.b)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.kernel.api.b)((com.tencent.mm.vending.b.b)localObject2).d).collectStoragePaths();
          if (localObject2 != null) {
            localLinkedList.addAll((Collection)localObject2);
          }
        }
      }
      return localLinkedList;
    }
    
    public final void gk(String paramString)
    {
      try
      {
        List localList = collectStoragePaths();
        this.dLQ = true;
        y.i("MicroMsg.CallbacksProxy", "all account storage folder %s", new Object[] { localList.toString() });
        b(localList, paramString);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  private static final class b
    extends com.tencent.mm.ck.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public final void onAccountInitialized(final e.c paramc)
    {
      a(new com.tencent.mm.ck.a.a() {});
    }
    
    public final void onAccountRelease()
    {
      a(new com.tencent.mm.ck.a.a() {});
    }
  }
  
  public static final class c
    extends com.tencent.mm.ck.a<com.tencent.mm.kernel.api.e>
    implements com.tencent.mm.kernel.api.e
  {
    public final void onDataBaseClosed(final com.tencent.mm.cf.h paramh1, final com.tencent.mm.cf.h paramh2)
    {
      a(new com.tencent.mm.ck.a.a() {});
    }
    
    public final void onDataBaseOpened(final com.tencent.mm.cf.h paramh1, final com.tencent.mm.cf.h paramh2)
    {
      a(new com.tencent.mm.ck.a.a() {});
    }
  }
  
  public static final class d
    extends com.tencent.mm.ck.a<com.tencent.mm.kernel.api.f>
    implements com.tencent.mm.kernel.api.f
  {
    private boolean dLW = false;
    private String dLX;
    
    public final void DU()
    {
      a(new com.tencent.mm.ck.a.a() {});
    }
    
    public final com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f paramf)
    {
      try
      {
        com.tencent.mm.vending.b.b localb = super.aj(paramf);
        if (this.dLW)
        {
          paramf.gj(this.dLX);
          y.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", new Object[] { paramf });
        }
        return localb;
      }
      finally
      {
        paramf = finally;
        throw paramf;
      }
    }
    
    public final void gj(final String paramString)
    {
      try
      {
        a(new com.tencent.mm.ck.a.a() {});
        this.dLW = true;
        this.dLX = paramString;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  private static final class e
  {
    private long dMa = 0L;
    private int mStatus = 0;
    
    /* Error */
    public final boolean Ea()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 19	com/tencent/mm/kernel/a/c$e:mStatus	I
      //   8: iconst_1
      //   9: if_icmpne +27 -> 36
      //   12: aload_0
      //   13: getfield 17	com/tencent/mm/kernel/a/c$e:dMa	J
      //   16: lstore_3
      //   17: invokestatic 25	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   20: invokevirtual 29	java/lang/Thread:getId	()J
      //   23: lstore 5
      //   25: lload_3
      //   26: lload 5
      //   28: lcmp
      //   29: ifne +7 -> 36
      //   32: aload_0
      //   33: monitorexit
      //   34: iload_2
      //   35: ireturn
      //   36: aload_0
      //   37: getfield 19	com/tencent/mm/kernel/a/c$e:mStatus	I
      //   40: istore_1
      //   41: iload_1
      //   42: iconst_2
      //   43: if_icmpeq -11 -> 32
      //   46: iconst_1
      //   47: istore_2
      //   48: goto -16 -> 32
      //   51: astore 7
      //   53: aload_0
      //   54: monitorexit
      //   55: aload 7
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	e
      //   40	4	1	i	int
      //   1	47	2	bool	boolean
      //   16	10	3	l1	long
      //   23	4	5	l2	long
      //   51	5	7	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	25	51	finally
      //   36	41	51	finally
    }
    
    public final void hy(int paramInt)
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