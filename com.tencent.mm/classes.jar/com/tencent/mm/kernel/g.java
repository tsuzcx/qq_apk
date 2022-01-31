package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p.a;
import com.tencent.mm.ai.y;
import com.tencent.mm.app.j;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.kernel.a.c.b;
import com.tencent.mm.kernel.a.c.c;
import com.tencent.mm.kernel.a.c.d;
import com.tencent.mm.kernel.a.c.e;
import com.tencent.mm.model.cc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.b;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  private static g eIm;
  public final b.a eHs;
  public h<com.tencent.mm.kernel.b.h> eIn;
  al eIo;
  private cc eIp;
  public e eIq;
  public a eIr;
  public b eIs;
  public com.tencent.mm.cf.b eIt;
  public final a eIu;
  private final boolean eIv;
  private ConcurrentHashMap eIw;
  public volatile boolean eIx;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(57995);
    this.eIp = null;
    this.eIu = new a((byte)0);
    this.eHs = new b.a();
    this.eIw = new ConcurrentHashMap();
    this.eIx = false;
    this.eIn = h.c(paramh);
    this.eIv = ((com.tencent.mm.kernel.b.h)this.eIn.RI().Rj()).SD();
    if (this.eIv)
    {
      this.eIp = new cc();
      this.eIo = com.tencent.mm.sdk.g.c.c.duH();
      com.tencent.mm.sdk.g.d.ysi = false;
      com.tencent.mm.sdk.g.d.ysn.a(new com.tencent.mm.sdk.g.a.c.a() {});
      this.eIo.ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(57979);
          at.hb(ah.getContext());
          AppMethodBeat.o(57979);
        }
      });
    }
    this.eIn.RH().eHH = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(57981);
        g.this.a(paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.RX().aq(paramAnonymousa);
        AppMethodBeat.o(57981);
      }
      
      public final void b(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        AppMethodBeat.i(57980);
        g.this.a(paramh, paramAnonymousf);
        AppMethodBeat.o(57980);
      }
      
      public final void b(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(57982);
        g localg = g.this;
        com.tencent.mm.kernel.b.h localh = paramh;
        Object localObject = com.tencent.mm.kernel.a.c.RX();
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.c)) {
          ((com.tencent.mm.kernel.a.c)localObject).eJa.remove((com.tencent.mm.kernel.api.c)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.e)) {
          ((com.tencent.mm.kernel.a.c)localObject).eJb.remove((com.tencent.mm.kernel.api.e)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.b)) {
          ((com.tencent.mm.kernel.a.c)localObject).eJc.remove((com.tencent.mm.kernel.api.b)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.f)) {
          ((com.tencent.mm.kernel.a.c)localObject).eJd.remove((com.tencent.mm.kernel.api.f)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof j)) {
          ((com.tencent.mm.kernel.a.c)localObject).eJe.remove((j)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof ApplicationLifeCycle))
        {
          localObject = (ApplicationLifeCycle)paramAnonymousa;
          localh.eKH.remove(localObject);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.d)) {
          localg.eHs.remove((com.tencent.mm.kernel.api.d)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.g)) {
          localg.eIn.b((com.tencent.mm.kernel.api.g)paramAnonymousa);
        }
        AppMethodBeat.o(57982);
      }
      
      public final void c(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        AppMethodBeat.i(57983);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.RX();
        if (paramAnonymousf != null) {
          localc.ar(paramAnonymousf);
        }
        AppMethodBeat.o(57983);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(57984);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.RX();
        if (paramAnonymousa != null) {
          localc.ar(paramAnonymousa);
        }
        AppMethodBeat.o(57984);
      }
    };
    AppMethodBeat.o(57995);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T E(Class<T> paramClass)
  {
    AppMethodBeat.i(58007);
    RM();
    paramClass = RH().E(paramClass);
    AppMethodBeat.o(58007);
    return paramClass;
  }
  
  public static void F(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(58010);
    RM();
    RH().F(paramClass);
    AppMethodBeat.o(58010);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T G(Class<T> paramClass)
  {
    AppMethodBeat.i(58006);
    RM();
    paramClass = RH().G(paramClass);
    AppMethodBeat.o(58006);
    return paramClass;
  }
  
  public static boolean RG()
  {
    AppMethodBeat.i(57999);
    a locala = RM().eIr;
    if ((locala != null) && (locala.QU()))
    {
      AppMethodBeat.o(57999);
      return true;
    }
    AppMethodBeat.o(57999);
    return false;
  }
  
  public static c RH()
  {
    AppMethodBeat.i(58000);
    Assert.assertNotNull("mCorePlugins not initialized!", RM().eIn.RH());
    c localc = RM().eIn.RH();
    AppMethodBeat.o(58000);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.h> RI()
  {
    AppMethodBeat.i(58001);
    Assert.assertNotNull("mCoreProcess not initialized!", RM().eIn.RI());
    d locald = RM().eIn.RI();
    AppMethodBeat.o(58001);
    return locald;
  }
  
  public static a RJ()
  {
    AppMethodBeat.i(58002);
    Assert.assertNotNull("mCoreAccount not initialized!", RM().eIr);
    a locala = RM().eIr;
    AppMethodBeat.o(58002);
    return locala;
  }
  
  public static b RK()
  {
    AppMethodBeat.i(58003);
    Assert.assertNotNull("mCoreNetwork not initialized!", RM().eIs);
    b localb = RM().eIs;
    AppMethodBeat.o(58003);
    return localb;
  }
  
  public static e RL()
  {
    AppMethodBeat.i(58004);
    Assert.assertNotNull("mCoreStorage not initialized!", RM().eIq);
    e locale = RM().eIq;
    AppMethodBeat.o(58004);
    return locale;
  }
  
  public static g RM()
  {
    AppMethodBeat.i(58005);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", eIm);
    g localg = eIm;
    AppMethodBeat.o(58005);
    return localg;
  }
  
  public static cc RN()
  {
    AppMethodBeat.i(58012);
    Assert.assertTrue(RM().eIv);
    cc localcc = RM().eIp;
    AppMethodBeat.o(58012);
    return localcc;
  }
  
  @Deprecated
  public static al RO()
  {
    AppMethodBeat.i(58013);
    Assert.assertTrue(RM().eIv);
    al localal = RM().eIo;
    AppMethodBeat.o(58013);
    return localal;
  }
  
  public static com.tencent.mm.ai.p Rc()
  {
    AppMethodBeat.i(58011);
    RM();
    com.tencent.mm.ai.p localp = RK().eHt;
    AppMethodBeat.o(58011);
    return localp;
  }
  
  /* Error */
  public static void a(com.tencent.mm.kernel.b.h paramh)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 249
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 226	com/tencent/mm/kernel/g:eIm	Lcom/tencent/mm/kernel/g;
    //   11: ifnull +55 -> 66
    //   14: getstatic 226	com/tencent/mm/kernel/g:eIm	Lcom/tencent/mm/kernel/g;
    //   17: getfield 86	com/tencent/mm/kernel/g:eIn	Lcom/tencent/mm/kernel/h;
    //   20: invokevirtual 90	com/tencent/mm/kernel/h:RI	()Lcom/tencent/mm/kernel/d;
    //   23: invokevirtual 96	com/tencent/mm/kernel/d:Rj	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 98	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 255	com/tencent/mm/kernel/b/g:bX	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 259	com/tencent/mm/kernel/b/h:eKG	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 259	com/tencent/mm/kernel/b/h:eKG	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 255	com/tencent/mm/kernel/b/g:bX	Landroid/app/Application;
    //   48: ldc_w 261
    //   51: ldc_w 263
    //   54: invokestatic 268	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc 249
    //   59: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: new 12	com/tencent/mm/kernel/g$4
    //   69: dup
    //   70: invokespecial 269	com/tencent/mm/kernel/g$4:<init>	()V
    //   73: invokestatic 274	com/tencent/mm/kernel/j:a	(Lcom/tencent/mm/kernel/j$a;)V
    //   76: ldc_w 261
    //   79: ldc_w 276
    //   82: invokestatic 268	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: new 2	com/tencent/mm/kernel/g
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 278	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   93: putstatic 226	com/tencent/mm/kernel/g:eIm	Lcom/tencent/mm/kernel/g;
    //   96: ldc 249
    //   98: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: goto -39 -> 62
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramh	com.tencent.mm.kernel.b.h
    //   29	15	1	localh	com.tencent.mm.kernel.b.h
    //   34	11	2	localApplication	android.app.Application
    // Exception table:
    //   from	to	target	type
    //   3	62	104	finally
    //   66	101	104	finally
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(58009);
    RM();
    RH().a(paramClass, paramc);
    AppMethodBeat.o(58009);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(58008);
    RM();
    RH().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(58008);
  }
  
  public static void jO(int paramInt)
  {
    AppMethodBeat.i(58015);
    a locala = RJ();
    if ((a.jK(paramInt)) && (a.b.a(a.eGR) == paramInt) && (locala.QU()))
    {
      ab.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(58015);
      return;
    }
    synchronized (locala.eGQ)
    {
      a.b.a(a.eGR, paramInt);
      locala.QK();
      locala.eHe = SystemClock.elapsedRealtime();
      locala.cu(true);
      AppMethodBeat.o(58015);
      return;
    }
  }
  
  public final boolean RF()
  {
    return this.eIx;
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(57997);
    this.eIn.a(paramg);
    AppMethodBeat.o(57997);
  }
  
  final void a(com.tencent.mm.kernel.b.h paramh, Object paramObject)
  {
    AppMethodBeat.i(57996);
    if (!this.eIw.containsKey(paramObject))
    {
      if (this.eIw.putIfAbsent(paramObject, this.eIw) != null)
      {
        ab.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
        AppMethodBeat.o(57996);
      }
    }
    else
    {
      ab.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      AppMethodBeat.o(57996);
      return;
    }
    com.tencent.mm.kernel.a.c.RX().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.eHs.at((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.eIn.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(57996);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(58018);
    this.eIn.a(paramd);
    AppMethodBeat.o(58018);
  }
  
  public final void ao(Object paramObject)
  {
    AppMethodBeat.i(146100);
    a((com.tencent.mm.kernel.b.h)RI().Rj(), paramObject);
    AppMethodBeat.o(146100);
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(57998);
    this.eIn.b(paramg);
    AppMethodBeat.o(57998);
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(58019);
    this.eIn.eIJ.br(paramBoolean);
    AppMethodBeat.o(58019);
  }
  
  public final void mD(String paramString)
  {
    AppMethodBeat.i(58016);
    ab.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { com.tencent.mm.a.p.getString(a.getUin()), paramString, bo.dtY() });
    a.mw(bo.dtY().toString() + paramString);
    this.eIr.QN().gE(a.getUin());
    releaseAll();
    a.QI();
    a.cv(false);
    AppMethodBeat.o(58016);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(58017);
    long l = System.currentTimeMillis();
    if (this.eIr != null) {}
    for (String str = com.tencent.mm.a.p.getString(a.getUin());; str = "-1")
    {
      ab.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.eIs.eHt != null) {
        this.eIs.eHt.reset();
      }
      com.tencent.mm.sdk.g.d.ysm.cjN().shutdown();
      if (this.eIo != null) {
        this.eIo.a(new al.b()
        {
          public final void tU()
          {
            AppMethodBeat.i(57990);
            com.tencent.mm.sdk.g.d.ysm.cjN().reset();
            if (g.this.eIr != null) {
              g.this.eIr.release();
            }
            AppMethodBeat.o(57990);
          }
        });
      }
      ab.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", new Object[] { str, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(58017);
      return;
    }
  }
  
  static final class a
    extends com.tencent.mm.cm.a<p.a>
    implements p.a
  {
    public final void a(final com.tencent.mm.ai.p paramp)
    {
      AppMethodBeat.i(57994);
      a(new a.a() {});
      AppMethodBeat.o(57994);
    }
    
    public final void a(final com.tencent.mm.ai.p paramp, final boolean paramBoolean)
    {
      AppMethodBeat.i(57993);
      a(new a.a() {});
      AppMethodBeat.o(57993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.g
 * JD-Core Version:    0.7.0.1
 */