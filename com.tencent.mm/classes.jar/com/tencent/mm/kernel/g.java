package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.z;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.b;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  public static final String[] gia = { ":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4" };
  private static g gib;
  public final b.a ghd;
  public h<com.tencent.mm.kernel.b.h> gic;
  private ap gid;
  private cf gie;
  public e gif;
  public a gig;
  public b gih;
  public com.tencent.mm.ch.b gii;
  public final a gij;
  private final boolean gik;
  private ConcurrentHashMap gil;
  public volatile boolean gim;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(132124);
    this.gie = null;
    this.gij = new a((byte)0);
    this.ghd = new b.a();
    this.gil = new ConcurrentHashMap();
    this.gim = false;
    this.gic = h.c(paramh);
    this.gik = ((com.tencent.mm.kernel.b.h)this.gic.agO().agp()).ahL();
    if (this.gik)
    {
      this.gie = new cf();
      this.gid = new ap(com.tencent.mm.sdk.g.a.aLY("worker"));
      this.gid.az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182890);
          ax.iP(ai.getContext());
          AppMethodBeat.o(182890);
        }
      });
    }
    this.gic.agN().ghs = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182892);
        g.a(g.this, paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.ahe().bp(paramAnonymousa);
        AppMethodBeat.o(182892);
      }
      
      public final void b(f paramAnonymousf)
      {
        AppMethodBeat.i(182891);
        g.a(g.this, paramh, paramAnonymousf);
        AppMethodBeat.o(182891);
      }
      
      public final void b(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182893);
        g.b(g.this, paramh, paramAnonymousa);
        AppMethodBeat.o(182893);
      }
      
      public final void c(f paramAnonymousf)
      {
        AppMethodBeat.i(182894);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ahe();
        if (paramAnonymousf != null) {
          localc.bq(paramAnonymousf);
        }
        AppMethodBeat.o(182894);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182895);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ahe();
        if (paramAnonymousa != null) {
          localc.bq(paramAnonymousa);
        }
        AppMethodBeat.o(182895);
      }
    };
    AppMethodBeat.o(132124);
  }
  
  /* Error */
  public static void a(com.tencent.mm.kernel.b.h paramh)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 165
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 167	com/tencent/mm/kernel/g:gib	Lcom/tencent/mm/kernel/g;
    //   11: ifnull +53 -> 64
    //   14: getstatic 167	com/tencent/mm/kernel/g:gib	Lcom/tencent/mm/kernel/g;
    //   17: getfield 102	com/tencent/mm/kernel/g:gic	Lcom/tencent/mm/kernel/h;
    //   20: invokevirtual 106	com/tencent/mm/kernel/h:agO	()Lcom/tencent/mm/kernel/d;
    //   23: invokevirtual 112	com/tencent/mm/kernel/d:agp	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 114	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 177	com/tencent/mm/kernel/b/h:gku	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 177	com/tencent/mm/kernel/b/h:gku	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   48: ldc 179
    //   50: ldc 181
    //   52: invokestatic 186	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc 165
    //   57: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: ldc 2
    //   62: monitorexit
    //   63: return
    //   64: new 10	com/tencent/mm/kernel/g$3
    //   67: dup
    //   68: invokespecial 187	com/tencent/mm/kernel/g$3:<init>	()V
    //   71: invokestatic 192	com/tencent/mm/kernel/j:a	(Lcom/tencent/mm/kernel/j$a;)V
    //   74: ldc 179
    //   76: ldc 194
    //   78: invokestatic 186	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 2	com/tencent/mm/kernel/g
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 196	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   89: putstatic 167	com/tencent/mm/kernel/g:gib	Lcom/tencent/mm/kernel/g;
    //   92: ldc 165
    //   94: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -37 -> 60
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramh	com.tencent.mm.kernel.b.h
    //   29	15	1	localh	com.tencent.mm.kernel.b.h
    //   34	11	2	localApplication	android.app.Application
    // Exception table:
    //   from	to	target	type
    //   3	60	100	finally
    //   64	97	100	finally
  }
  
  private void a(com.tencent.mm.kernel.b.h paramh, Object paramObject)
  {
    AppMethodBeat.i(132126);
    if (!this.gil.containsKey(paramObject))
    {
      if (this.gil.putIfAbsent(paramObject, this.gil) != null)
      {
        ac.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
        AppMethodBeat.o(132126);
      }
    }
    else
    {
      ac.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      AppMethodBeat.o(132126);
      return;
    }
    com.tencent.mm.kernel.a.c.ahe().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.ghd.bs((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.gic.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(132126);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(132139);
    agS();
    agN().a(paramClass, paramc);
    AppMethodBeat.o(132139);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(132137);
    agS();
    paramClass = agN().ab(paramClass);
    AppMethodBeat.o(132137);
    return paramClass;
  }
  
  public static void ac(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(132140);
    agS();
    agN().ac(paramClass);
    AppMethodBeat.o(132140);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T ad(Class<T> paramClass)
  {
    AppMethodBeat.i(132136);
    agS();
    paramClass = agN().ad(paramClass);
    AppMethodBeat.o(132136);
    return paramClass;
  }
  
  public static boolean agM()
  {
    AppMethodBeat.i(132129);
    a locala = agS().gig;
    if ((locala != null) && (locala.afY()))
    {
      AppMethodBeat.o(132129);
      return true;
    }
    AppMethodBeat.o(132129);
    return false;
  }
  
  public static c agN()
  {
    AppMethodBeat.i(132130);
    Assert.assertNotNull("mCorePlugins not initialized!", agS().gic.agN());
    c localc = agS().gic.agN();
    AppMethodBeat.o(132130);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.h> agO()
  {
    AppMethodBeat.i(132131);
    Assert.assertNotNull("mCoreProcess not initialized!", agS().gic.agO());
    d locald = agS().gic.agO();
    AppMethodBeat.o(132131);
    return locald;
  }
  
  public static a agP()
  {
    AppMethodBeat.i(132132);
    Assert.assertNotNull("mCoreAccount not initialized!", agS().gig);
    a locala = agS().gig;
    AppMethodBeat.o(132132);
    return locala;
  }
  
  public static b agQ()
  {
    AppMethodBeat.i(132133);
    Assert.assertNotNull("mCoreNetwork not initialized!", agS().gih);
    b localb = agS().gih;
    AppMethodBeat.o(132133);
    return localb;
  }
  
  public static e agR()
  {
    AppMethodBeat.i(132134);
    Assert.assertNotNull("mCoreStorage not initialized!", agS().gif);
    e locale = agS().gif;
    AppMethodBeat.o(132134);
    return locale;
  }
  
  public static g agS()
  {
    AppMethodBeat.i(132135);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", gib);
    g localg = gib;
    AppMethodBeat.o(132135);
    return localg;
  }
  
  public static cf agT()
  {
    AppMethodBeat.i(132142);
    Assert.assertTrue(agS().gik);
    cf localcf = agS().gie;
    AppMethodBeat.o(132142);
    return localcf;
  }
  
  @Deprecated
  public static ap agU()
  {
    AppMethodBeat.i(132143);
    Assert.assertTrue(agS().gik);
    ap localap = agS().gid;
    AppMethodBeat.o(132143);
    return localap;
  }
  
  public static q agi()
  {
    AppMethodBeat.i(132141);
    agS();
    q localq = agQ().ghe;
    AppMethodBeat.o(132141);
    return localq;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(132138);
    agS();
    agN().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(132138);
  }
  
  public static void mr(int paramInt)
  {
    AppMethodBeat.i(132145);
    a locala = agP();
    if ((a.mm(paramInt)) && (a.b.a(a.ggE) == paramInt) && (locala.afY()))
    {
      ac.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(132145);
      return;
    }
    synchronized (locala.ggD)
    {
      a.b.a(a.ggE, paramInt);
      locala.afN();
      locala.ggR = SystemClock.elapsedRealtime();
      locala.dy(true);
      AppMethodBeat.o(132145);
      return;
    }
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132127);
    this.gic.a(paramg);
    AppMethodBeat.o(132127);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(132148);
    this.gic.a(paramd);
    AppMethodBeat.o(132148);
  }
  
  public final boolean agL()
  {
    return this.gim;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132128);
    this.gic.b(paramg);
    AppMethodBeat.o(132128);
  }
  
  public final void bn(Object paramObject)
  {
    AppMethodBeat.i(132125);
    a((com.tencent.mm.kernel.b.h)agO().agp(), paramObject);
    AppMethodBeat.o(132125);
  }
  
  public final void dA(boolean paramBoolean)
  {
    AppMethodBeat.i(132149);
    this.gic.giy.cf(paramBoolean);
    AppMethodBeat.o(132149);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(132147);
    long l = System.currentTimeMillis();
    if (this.gig != null) {}
    for (String str = p.getString(a.getUin());; str = "-1")
    {
      ac.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.gih.ghe != null) {
        this.gih.ghe.reset();
      }
      com.tencent.e.g.shutdown();
      if (this.gid != null) {
        this.gid.a(new ap.b()
        {
          public final void Am()
          {
            AppMethodBeat.i(182901);
            com.tencent.e.g.a(ai.getContext(), new aa());
            if (g.a(g.this) != null) {
              g.a(g.this).release();
            }
            AppMethodBeat.o(182901);
          }
        });
      }
      ac.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", new Object[] { str, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132147);
      return;
    }
  }
  
  public final void uj(String paramString)
  {
    AppMethodBeat.i(132146);
    ac.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { p.getString(a.getUin()), paramString, bs.eWi() });
    a.ub(bs.eWi().toString() + paramString);
    this.gig.afQ().pS(a.getUin());
    releaseAll();
    a.afL();
    a.dz(false);
    AppMethodBeat.o(132146);
  }
  
  static final class a
    extends com.tencent.mm.cn.a<q.a>
    implements q.a
  {
    public final void a(final q paramq)
    {
      AppMethodBeat.i(132123);
      a(new a.a() {});
      AppMethodBeat.o(132123);
    }
    
    public final void a(final q paramq, final boolean paramBoolean)
    {
      AppMethodBeat.i(132122);
      a(new a.a() {});
      AppMethodBeat.o(132122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.g
 * JD-Core Version:    0.7.0.1
 */