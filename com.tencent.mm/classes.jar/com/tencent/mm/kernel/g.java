package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.z;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.ci;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.b;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  public static final String[] gEr = { ":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4" };
  private static g gEs;
  public final b.a gDu;
  public final a gEA;
  private final boolean gEB;
  private ConcurrentHashMap gEC;
  public volatile boolean gED;
  public h<com.tencent.mm.kernel.b.h> gEt;
  private ar gEu;
  private ci gEv;
  public e gEw;
  public a gEx;
  public b gEy;
  public com.tencent.mm.cg.b gEz;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(132124);
    this.gEv = null;
    this.gEA = new a((byte)0);
    this.gDu = new b.a();
    this.gEC = new ConcurrentHashMap();
    this.gED = false;
    this.gEt = h.c(paramh);
    this.gEB = ((com.tencent.mm.kernel.b.h)this.gEt.ajO().ajq()).akL();
    if (this.gEB)
    {
      this.gEv = new ci();
      this.gEu = new ar(com.tencent.mm.sdk.g.a.aTc("worker"));
      this.gEu.aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182890);
          az.je(ak.getContext());
          AppMethodBeat.o(182890);
        }
      });
    }
    this.gEt.ajN().gDJ = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182892);
        g.a(g.this, paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.ake().br(paramAnonymousa);
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
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ake();
        if (paramAnonymousf != null) {
          localc.bs(paramAnonymousf);
        }
        AppMethodBeat.o(182894);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182895);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ake();
        if (paramAnonymousa != null) {
          localc.bs(paramAnonymousa);
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
    //   8: getstatic 167	com/tencent/mm/kernel/g:gEs	Lcom/tencent/mm/kernel/g;
    //   11: ifnull +53 -> 64
    //   14: getstatic 167	com/tencent/mm/kernel/g:gEs	Lcom/tencent/mm/kernel/g;
    //   17: getfield 102	com/tencent/mm/kernel/g:gEt	Lcom/tencent/mm/kernel/h;
    //   20: invokevirtual 106	com/tencent/mm/kernel/h:ajO	()Lcom/tencent/mm/kernel/d;
    //   23: invokevirtual 112	com/tencent/mm/kernel/d:ajq	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 114	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 177	com/tencent/mm/kernel/b/h:gGL	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 177	com/tencent/mm/kernel/b/h:gGL	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   48: ldc 179
    //   50: ldc 181
    //   52: invokestatic 186	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   78: invokestatic 186	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 2	com/tencent/mm/kernel/g
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 196	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   89: putstatic 167	com/tencent/mm/kernel/g:gEs	Lcom/tencent/mm/kernel/g;
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
    if (!this.gEC.containsKey(paramObject))
    {
      if (this.gEC.putIfAbsent(paramObject, this.gEC) != null)
      {
        ae.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
        AppMethodBeat.o(132126);
      }
    }
    else
    {
      ae.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      AppMethodBeat.o(132126);
      return;
    }
    com.tencent.mm.kernel.a.c.ake().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.gDu.bu((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.gEt.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(132126);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(132139);
    ajS();
    ajN().a(paramClass, paramc);
    AppMethodBeat.o(132139);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(132137);
    ajS();
    paramClass = ajN().ab(paramClass);
    AppMethodBeat.o(132137);
    return paramClass;
  }
  
  public static void ac(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(132140);
    ajS();
    ajN().ac(paramClass);
    AppMethodBeat.o(132140);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T ad(Class<T> paramClass)
  {
    AppMethodBeat.i(132136);
    ajS();
    paramClass = ajN().ad(paramClass);
    AppMethodBeat.o(132136);
    return paramClass;
  }
  
  public static boolean ajM()
  {
    AppMethodBeat.i(132129);
    a locala = ajS().gEx;
    if ((locala != null) && (locala.aiZ()))
    {
      AppMethodBeat.o(132129);
      return true;
    }
    AppMethodBeat.o(132129);
    return false;
  }
  
  public static c ajN()
  {
    AppMethodBeat.i(132130);
    Assert.assertNotNull("mCorePlugins not initialized!", ajS().gEt.ajN());
    c localc = ajS().gEt.ajN();
    AppMethodBeat.o(132130);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.h> ajO()
  {
    AppMethodBeat.i(132131);
    Assert.assertNotNull("mCoreProcess not initialized!", ajS().gEt.ajO());
    d locald = ajS().gEt.ajO();
    AppMethodBeat.o(132131);
    return locald;
  }
  
  public static a ajP()
  {
    AppMethodBeat.i(132132);
    Assert.assertNotNull("mCoreAccount not initialized!", ajS().gEx);
    a locala = ajS().gEx;
    AppMethodBeat.o(132132);
    return locala;
  }
  
  public static b ajQ()
  {
    AppMethodBeat.i(132133);
    Assert.assertNotNull("mCoreNetwork not initialized!", ajS().gEy);
    b localb = ajS().gEy;
    AppMethodBeat.o(132133);
    return localb;
  }
  
  public static e ajR()
  {
    AppMethodBeat.i(132134);
    Assert.assertNotNull("mCoreStorage not initialized!", ajS().gEw);
    e locale = ajS().gEw;
    AppMethodBeat.o(132134);
    return locale;
  }
  
  public static g ajS()
  {
    AppMethodBeat.i(132135);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", gEs);
    g localg = gEs;
    AppMethodBeat.o(132135);
    return localg;
  }
  
  public static ci ajT()
  {
    AppMethodBeat.i(132142);
    Assert.assertTrue(ajS().gEB);
    ci localci = ajS().gEv;
    AppMethodBeat.o(132142);
    return localci;
  }
  
  @Deprecated
  public static ar ajU()
  {
    AppMethodBeat.i(132143);
    Assert.assertTrue(ajS().gEB);
    ar localar = ajS().gEu;
    AppMethodBeat.o(132143);
    return localar;
  }
  
  public static q ajj()
  {
    AppMethodBeat.i(132141);
    ajS();
    q localq = ajQ().gDv;
    AppMethodBeat.o(132141);
    return localq;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(132138);
    ajS();
    ajN().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(132138);
  }
  
  public static void mT(int paramInt)
  {
    AppMethodBeat.i(132145);
    a locala = ajP();
    if ((a.mO(paramInt)) && (a.b.a(a.gCV) == paramInt) && (locala.aiZ()))
    {
      ae.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(132145);
      return;
    }
    synchronized (locala.gCU)
    {
      a.b.a(a.gCV, paramInt);
      locala.aiO();
      locala.gDi = SystemClock.elapsedRealtime();
      locala.dB(true);
      AppMethodBeat.o(132145);
      return;
    }
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132127);
    this.gEt.a(paramg);
    AppMethodBeat.o(132127);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(132148);
    this.gEt.a(paramd);
    AppMethodBeat.o(132148);
  }
  
  public final boolean ajL()
  {
    return this.gED;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132128);
    this.gEt.b(paramg);
    AppMethodBeat.o(132128);
  }
  
  public final void bp(Object paramObject)
  {
    AppMethodBeat.i(132125);
    a((com.tencent.mm.kernel.b.h)ajO().ajq(), paramObject);
    AppMethodBeat.o(132125);
  }
  
  public final void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(132149);
    this.gEt.gEP.ch(paramBoolean);
    AppMethodBeat.o(132149);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(132147);
    long l = System.currentTimeMillis();
    if (this.gEx != null) {}
    for (String str = p.getString(a.getUin());; str = "-1")
    {
      ae.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.gEy.gDv != null) {
        this.gEy.gDv.reset();
      }
      com.tencent.e.g.shutdown();
      if (this.gEu != null) {
        this.gEu.a(new ar.b()
        {
          public final void BK()
          {
            AppMethodBeat.i(182901);
            com.tencent.e.g.a(ak.getContext(), new aa());
            if (g.a(g.this) != null) {
              g.a(g.this).release();
            }
            AppMethodBeat.o(182901);
          }
        });
      }
      ae.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", new Object[] { str, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132147);
      return;
    }
  }
  
  public final void xI(String paramString)
  {
    AppMethodBeat.i(132146);
    ae.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { p.getString(a.getUin()), paramString, bu.fpN() });
    a.xA(bu.fpN().toString() + paramString);
    this.gEx.aiR().se(a.getUin());
    releaseAll();
    a.aiM();
    a.dC(false);
    AppMethodBeat.o(132146);
  }
  
  static final class a
    extends com.tencent.mm.cm.a<q.a>
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