package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.al.q.a;
import com.tencent.mm.al.z;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.cg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.b;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  public static final String[] gBK = { ":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4" };
  private static g gBL;
  public final b.a gAN;
  public h<com.tencent.mm.kernel.b.h> gBM;
  private aq gBN;
  private cg gBO;
  public e gBP;
  public a gBQ;
  public b gBR;
  public com.tencent.mm.ch.b gBS;
  public final a gBT;
  private final boolean gBU;
  private ConcurrentHashMap gBV;
  public volatile boolean gBW;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(132124);
    this.gBO = null;
    this.gBT = new a((byte)0);
    this.gAN = new b.a();
    this.gBV = new ConcurrentHashMap();
    this.gBW = false;
    this.gBM = h.c(paramh);
    this.gBU = ((com.tencent.mm.kernel.b.h)this.gBM.ajz().ajb()).akw();
    if (this.gBU)
    {
      this.gBO = new cg();
      this.gBN = new aq(com.tencent.mm.sdk.g.a.aRF("worker"));
      this.gBN.ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182890);
          ay.iZ(aj.getContext());
          AppMethodBeat.o(182890);
        }
      });
    }
    this.gBM.ajy().gBc = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182892);
        g.a(g.this, paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.ajP().br(paramAnonymousa);
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
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ajP();
        if (paramAnonymousf != null) {
          localc.bs(paramAnonymousf);
        }
        AppMethodBeat.o(182894);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182895);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.ajP();
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
    //   8: getstatic 167	com/tencent/mm/kernel/g:gBL	Lcom/tencent/mm/kernel/g;
    //   11: ifnull +53 -> 64
    //   14: getstatic 167	com/tencent/mm/kernel/g:gBL	Lcom/tencent/mm/kernel/g;
    //   17: getfield 102	com/tencent/mm/kernel/g:gBM	Lcom/tencent/mm/kernel/h;
    //   20: invokevirtual 106	com/tencent/mm/kernel/h:ajz	()Lcom/tencent/mm/kernel/d;
    //   23: invokevirtual 112	com/tencent/mm/kernel/d:ajb	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 114	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 177	com/tencent/mm/kernel/b/h:gEe	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 177	com/tencent/mm/kernel/b/h:gEe	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 173	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   48: ldc 179
    //   50: ldc 181
    //   52: invokestatic 186	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   78: invokestatic 186	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 2	com/tencent/mm/kernel/g
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 196	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   89: putstatic 167	com/tencent/mm/kernel/g:gBL	Lcom/tencent/mm/kernel/g;
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
    if (!this.gBV.containsKey(paramObject))
    {
      if (this.gBV.putIfAbsent(paramObject, this.gBV) != null)
      {
        ad.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
        AppMethodBeat.o(132126);
      }
    }
    else
    {
      ad.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      AppMethodBeat.o(132126);
      return;
    }
    com.tencent.mm.kernel.a.c.ajP().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.gAN.bu((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.gBM.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(132126);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(132139);
    ajD();
    ajy().a(paramClass, paramc);
    AppMethodBeat.o(132139);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(132137);
    ajD();
    paramClass = ajy().ab(paramClass);
    AppMethodBeat.o(132137);
    return paramClass;
  }
  
  public static void ac(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(132140);
    ajD();
    ajy().ac(paramClass);
    AppMethodBeat.o(132140);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T ad(Class<T> paramClass)
  {
    AppMethodBeat.i(132136);
    ajD();
    paramClass = ajy().ad(paramClass);
    AppMethodBeat.o(132136);
    return paramClass;
  }
  
  public static q aiU()
  {
    AppMethodBeat.i(132141);
    ajD();
    q localq = ajB().gAO;
    AppMethodBeat.o(132141);
    return localq;
  }
  
  public static a ajA()
  {
    AppMethodBeat.i(132132);
    Assert.assertNotNull("mCoreAccount not initialized!", ajD().gBQ);
    a locala = ajD().gBQ;
    AppMethodBeat.o(132132);
    return locala;
  }
  
  public static b ajB()
  {
    AppMethodBeat.i(132133);
    Assert.assertNotNull("mCoreNetwork not initialized!", ajD().gBR);
    b localb = ajD().gBR;
    AppMethodBeat.o(132133);
    return localb;
  }
  
  public static e ajC()
  {
    AppMethodBeat.i(132134);
    Assert.assertNotNull("mCoreStorage not initialized!", ajD().gBP);
    e locale = ajD().gBP;
    AppMethodBeat.o(132134);
    return locale;
  }
  
  public static g ajD()
  {
    AppMethodBeat.i(132135);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", gBL);
    g localg = gBL;
    AppMethodBeat.o(132135);
    return localg;
  }
  
  public static cg ajE()
  {
    AppMethodBeat.i(132142);
    Assert.assertTrue(ajD().gBU);
    cg localcg = ajD().gBO;
    AppMethodBeat.o(132142);
    return localcg;
  }
  
  @Deprecated
  public static aq ajF()
  {
    AppMethodBeat.i(132143);
    Assert.assertTrue(ajD().gBU);
    aq localaq = ajD().gBN;
    AppMethodBeat.o(132143);
    return localaq;
  }
  
  public static boolean ajx()
  {
    AppMethodBeat.i(132129);
    a locala = ajD().gBQ;
    if ((locala != null) && (locala.aiK()))
    {
      AppMethodBeat.o(132129);
      return true;
    }
    AppMethodBeat.o(132129);
    return false;
  }
  
  public static c ajy()
  {
    AppMethodBeat.i(132130);
    Assert.assertNotNull("mCorePlugins not initialized!", ajD().gBM.ajy());
    c localc = ajD().gBM.ajy();
    AppMethodBeat.o(132130);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.h> ajz()
  {
    AppMethodBeat.i(132131);
    Assert.assertNotNull("mCoreProcess not initialized!", ajD().gBM.ajz());
    d locald = ajD().gBM.ajz();
    AppMethodBeat.o(132131);
    return locald;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(132138);
    ajD();
    ajy().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(132138);
  }
  
  public static void mQ(int paramInt)
  {
    AppMethodBeat.i(132145);
    a locala = ajA();
    if ((a.mL(paramInt)) && (a.b.a(a.gAo) == paramInt) && (locala.aiK()))
    {
      ad.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(132145);
      return;
    }
    synchronized (locala.gAn)
    {
      a.b.a(a.gAo, paramInt);
      locala.aiz();
      locala.gAB = SystemClock.elapsedRealtime();
      locala.dA(true);
      AppMethodBeat.o(132145);
      return;
    }
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132127);
    this.gBM.a(paramg);
    AppMethodBeat.o(132127);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(132148);
    this.gBM.a(paramd);
    AppMethodBeat.o(132148);
  }
  
  public final boolean ajw()
  {
    return this.gBW;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132128);
    this.gBM.b(paramg);
    AppMethodBeat.o(132128);
  }
  
  public final void bp(Object paramObject)
  {
    AppMethodBeat.i(132125);
    a((com.tencent.mm.kernel.b.h)ajz().ajb(), paramObject);
    AppMethodBeat.o(132125);
  }
  
  public final void dC(boolean paramBoolean)
  {
    AppMethodBeat.i(132149);
    this.gBM.gCi.cg(paramBoolean);
    AppMethodBeat.o(132149);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(132147);
    long l = System.currentTimeMillis();
    if (this.gBQ != null) {}
    for (String str = p.getString(a.getUin());; str = "-1")
    {
      ad.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.gBR.gAO != null) {
        this.gBR.gAO.reset();
      }
      com.tencent.e.g.shutdown();
      if (this.gBN != null) {
        this.gBN.a(new aq.b()
        {
          public final void BJ()
          {
            AppMethodBeat.i(182901);
            com.tencent.e.g.a(aj.getContext(), new aa());
            if (g.a(g.this) != null) {
              g.a(g.this).release();
            }
            AppMethodBeat.o(182901);
          }
        });
      }
      ad.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", new Object[] { str, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(132147);
      return;
    }
  }
  
  public final void wZ(String paramString)
  {
    AppMethodBeat.i(132146);
    ad.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { p.getString(a.getUin()), paramString, bt.flS() });
    a.wR(bt.flS().toString() + paramString);
    this.gBQ.aiC().rR(a.getUin());
    releaseAll();
    a.aix();
    a.dB(false);
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