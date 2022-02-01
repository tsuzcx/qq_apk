package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.t.a;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.co.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.ResetCallback;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  public static final String[] hrf = { ":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4" };
  private static g hrg;
  public final b.a hqh;
  public h<com.tencent.mm.kernel.b.h> hrh;
  private MMHandlerThread hri;
  private cm hrj;
  public e hrk;
  public a hrl;
  public b hrm;
  public com.tencent.mm.cg.b hrn;
  public final a hro;
  private final boolean hrp;
  private ConcurrentHashMap hrq;
  public volatile boolean hrr;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(132124);
    this.hrj = null;
    this.hro = new a((byte)0);
    this.hqh = new b.a();
    this.hrq = new ConcurrentHashMap();
    this.hrr = false;
    this.hrh = h.c(paramh);
    this.hrp = ((com.tencent.mm.kernel.b.h)this.hrh.aAe().azG()).aBb();
    if (this.hrp)
    {
      this.hrj = new cm();
      this.hri = new MMHandlerThread(DeprecatedThreadFactory.createHandlerThread("worker"));
      this.hri.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182890);
          NetStatusUtil.initMobileStrengthListener(MMApplicationContext.getContext());
          AppMethodBeat.o(182890);
        }
      });
    }
    this.hrh.aAd().hqw = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182892);
        g.a(g.this, paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.aAu().bA(paramAnonymousa);
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
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.aAu();
        if (paramAnonymousf != null) {
          localc.bB(paramAnonymousf);
        }
        AppMethodBeat.o(182894);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182895);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.aAu();
        if (paramAnonymousa != null) {
          localc.bB(paramAnonymousa);
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
    //   8: getstatic 167	com/tencent/mm/kernel/g:hrg	Lcom/tencent/mm/kernel/g;
    //   11: ifnull +53 -> 64
    //   14: getstatic 167	com/tencent/mm/kernel/g:hrg	Lcom/tencent/mm/kernel/g;
    //   17: getfield 102	com/tencent/mm/kernel/g:hrh	Lcom/tencent/mm/kernel/h;
    //   20: invokevirtual 106	com/tencent/mm/kernel/h:aAe	()Lcom/tencent/mm/kernel/d;
    //   23: invokevirtual 112	com/tencent/mm/kernel/d:azG	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 114	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 177	com/tencent/mm/kernel/b/h:htz	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 177	com/tencent/mm/kernel/b/h:htz	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   48: ldc 179
    //   50: ldc 181
    //   52: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   78: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 2	com/tencent/mm/kernel/g
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 196	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   89: putstatic 167	com/tencent/mm/kernel/g:hrg	Lcom/tencent/mm/kernel/g;
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
    if (!this.hrq.containsKey(paramObject))
    {
      if (this.hrq.putIfAbsent(paramObject, this.hrq) != null)
      {
        Log.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
        AppMethodBeat.o(132126);
      }
    }
    else
    {
      Log.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      AppMethodBeat.o(132126);
      return;
    }
    com.tencent.mm.kernel.a.c.aAu().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.hqh.add((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.hrh.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(132126);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(132139);
    aAi();
    aAd().a(paramClass, paramc);
    AppMethodBeat.o(132139);
  }
  
  public static boolean aAc()
  {
    AppMethodBeat.i(132129);
    a locala = aAi().hrl;
    if ((locala != null) && (locala.azp()))
    {
      AppMethodBeat.o(132129);
      return true;
    }
    AppMethodBeat.o(132129);
    return false;
  }
  
  public static c aAd()
  {
    AppMethodBeat.i(132130);
    Assert.assertNotNull("mCorePlugins not initialized!", aAi().hrh.aAd());
    c localc = aAi().hrh.aAd();
    AppMethodBeat.o(132130);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.h> aAe()
  {
    AppMethodBeat.i(132131);
    Assert.assertNotNull("mCoreProcess not initialized!", aAi().hrh.aAe());
    d locald = aAi().hrh.aAe();
    AppMethodBeat.o(132131);
    return locald;
  }
  
  public static a aAf()
  {
    AppMethodBeat.i(132132);
    Assert.assertNotNull("mCoreAccount not initialized!", aAi().hrl);
    a locala = aAi().hrl;
    AppMethodBeat.o(132132);
    return locala;
  }
  
  public static b aAg()
  {
    AppMethodBeat.i(132133);
    Assert.assertNotNull("mCoreNetwork not initialized!", aAi().hrm);
    b localb = aAi().hrm;
    AppMethodBeat.o(132133);
    return localb;
  }
  
  public static e aAh()
  {
    AppMethodBeat.i(132134);
    Assert.assertNotNull("mCoreStorage not initialized!", aAi().hrk);
    e locale = aAi().hrk;
    AppMethodBeat.o(132134);
    return locale;
  }
  
  public static g aAi()
  {
    AppMethodBeat.i(132135);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", hrg);
    g localg = hrg;
    AppMethodBeat.o(132135);
    return localg;
  }
  
  public static cm aAj()
  {
    AppMethodBeat.i(132142);
    Assert.assertTrue(aAi().hrp);
    cm localcm = aAi().hrj;
    AppMethodBeat.o(132142);
    return localcm;
  }
  
  @Deprecated
  public static MMHandlerThread aAk()
  {
    AppMethodBeat.i(132143);
    Assert.assertTrue(aAi().hrp);
    MMHandlerThread localMMHandlerThread = aAi().hri;
    AppMethodBeat.o(132143);
    return localMMHandlerThread;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T af(Class<T> paramClass)
  {
    AppMethodBeat.i(132137);
    aAi();
    paramClass = aAd().af(paramClass);
    AppMethodBeat.o(132137);
    return paramClass;
  }
  
  public static void ag(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(132140);
    aAi();
    aAd().ag(paramClass);
    AppMethodBeat.o(132140);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T ah(Class<T> paramClass)
  {
    AppMethodBeat.i(132136);
    aAi();
    paramClass = aAd().ah(paramClass);
    AppMethodBeat.o(132136);
    return paramClass;
  }
  
  public static t azz()
  {
    AppMethodBeat.i(132141);
    aAi();
    t localt = aAg().hqi;
    AppMethodBeat.o(132141);
    return localt;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(132138);
    aAi();
    aAd().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(132138);
  }
  
  public static void qg(int paramInt)
  {
    AppMethodBeat.i(132145);
    a locala = aAf();
    if ((a.qb(paramInt)) && (a.b.a(a.hpJ) == paramInt) && (locala.azp()))
    {
      Log.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(132145);
      return;
    }
    synchronized (locala.hpI)
    {
      a.b.a(a.hpJ, paramInt);
      locala.aze();
      locala.hpW = SystemClock.elapsedRealtime();
      locala.er(true);
      AppMethodBeat.o(132145);
      return;
    }
  }
  
  public final void FS(String paramString)
  {
    AppMethodBeat.i(132146);
    Log.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { p.getString(a.getUin()), paramString, Util.getStack() });
    a.FM(Util.getStack().toString() + paramString);
    this.hrl.azh().Ak(a.getUin());
    releaseAll();
    a.azc();
    a.es(false);
    AppMethodBeat.o(132146);
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132127);
    this.hrh.a(paramg);
    AppMethodBeat.o(132127);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(132148);
    this.hrh.a(paramd);
    AppMethodBeat.o(132148);
  }
  
  public final boolean aAb()
  {
    return this.hrr;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132128);
    this.hrh.b(paramg);
    AppMethodBeat.o(132128);
  }
  
  public final void by(Object paramObject)
  {
    AppMethodBeat.i(132125);
    a((com.tencent.mm.kernel.b.h)aAe().azG(), paramObject);
    AppMethodBeat.o(132125);
  }
  
  public final void et(boolean paramBoolean)
  {
    AppMethodBeat.i(132149);
    this.hrh.hrD.cQ(paramBoolean);
    AppMethodBeat.o(132149);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(132147);
    long l = System.currentTimeMillis();
    if (this.hrl != null) {}
    for (String str = p.getString(a.getUin());; str = "-1")
    {
      Log.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.hrm.hqi != null) {
        this.hrm.hqi.reset();
      }
      com.tencent.f.g.shutdown();
      if (this.hri != null) {
        this.hri.syncReset(new MMHandlerThread.ResetCallback()
        {
          public final void callback()
          {
            AppMethodBeat.i(182901);
            com.tencent.f.g.a(MMApplicationContext.getContext(), new aa());
            if (g.a(g.this) != null) {
              g.a(g.this).release();
            }
            AppMethodBeat.o(182901);
          }
        });
      }
      Log.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", new Object[] { str, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132147);
      return;
    }
  }
  
  static final class a
    extends com.tencent.mm.co.a<t.a>
    implements t.a
  {
    public final void a(final t paramt)
    {
      AppMethodBeat.i(132123);
      a(new a.a() {});
      AppMethodBeat.o(132123);
    }
    
    public final void a(final t paramt, final boolean paramBoolean)
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