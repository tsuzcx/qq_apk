package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.p.a;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.kernel.a.c.b;
import com.tencent.mm.kernel.a.c.c;
import com.tencent.mm.kernel.a.c.d;
import com.tencent.mm.model.ca;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g
{
  private static g dKO;
  public final b.a dJS = new b.a();
  public h<com.tencent.mm.kernel.b.h> dKP;
  private ai dKQ;
  private ca dKR = null;
  public e dKS;
  public a dKT;
  public b dKU;
  public com.tencent.mm.ce.b dKV;
  public final a dKW = new a((byte)0);
  private final boolean dKX;
  private ConcurrentHashMap dKY = new ConcurrentHashMap();
  public volatile boolean dKZ = false;
  
  private g(final com.tencent.mm.kernel.b.h paramh)
  {
    this.dKP = h.c(paramh);
    this.dKX = ((com.tencent.mm.kernel.b.h)this.dKP.DM().Dr()).Ex();
    if (this.dKX)
    {
      this.dKR = new ca();
      this.dKQ = new ai("worker");
      this.dKQ.O(new Runnable()
      {
        public final void run()
        {
          aq.fL(ae.getContext());
        }
      });
    }
    this.dKP.DL().dKj = new c.a()
    {
      public final void b(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        g.this.a(paramh, paramAnonymousf);
      }
      
      public final void b(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        g.this.a(paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.DY().ah(paramAnonymousa);
      }
      
      public final void c(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.DY();
        if (paramAnonymousf != null) {
          localc.ai(paramAnonymousf);
        }
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        g localg = g.this;
        com.tencent.mm.kernel.b.h localh = paramh;
        Object localObject = com.tencent.mm.kernel.a.c.DY();
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.c)) {
          ((com.tencent.mm.kernel.a.c)localObject).dLB.remove((com.tencent.mm.kernel.api.c)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.e)) {
          ((com.tencent.mm.kernel.a.c)localObject).dLC.remove((com.tencent.mm.kernel.api.e)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.b)) {
          ((com.tencent.mm.kernel.a.c)localObject).dLD.remove((com.tencent.mm.kernel.api.b)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.f)) {
          ((com.tencent.mm.kernel.a.c)localObject).dLE.remove((com.tencent.mm.kernel.api.f)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof ApplicationLifeCycle))
        {
          localObject = (ApplicationLifeCycle)paramAnonymousa;
          localh.dMV.remove(localObject);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.d)) {
          localg.dJS.remove((com.tencent.mm.kernel.api.d)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.g)) {
          localg.dKP.b((com.tencent.mm.kernel.api.g)paramAnonymousa);
        }
      }
      
      public final void d(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.DY();
        if (paramAnonymousa != null) {
          localc.ai(paramAnonymousa);
        }
      }
    };
  }
  
  public static boolean DK()
  {
    a locala = DQ().dKT;
    return (locala != null) && (locala.Dc());
  }
  
  public static c DL()
  {
    Assert.assertNotNull("mCorePlugins not initialized!", DQ().dKP.DL());
    return DQ().dKP.DL();
  }
  
  public static d<com.tencent.mm.kernel.b.h> DM()
  {
    Assert.assertNotNull("mCoreProcess not initialized!", DQ().dKP.DM());
    return DQ().dKP.DM();
  }
  
  public static a DN()
  {
    Assert.assertNotNull("mCoreAccount not initialized!", DQ().dKT);
    return DQ().dKT;
  }
  
  public static b DO()
  {
    Assert.assertNotNull("mCoreNetwork not initialized!", DQ().dKU);
    return DQ().dKU;
  }
  
  public static e DP()
  {
    Assert.assertNotNull("mCoreStorage not initialized!", DQ().dKS);
    return DQ().dKS;
  }
  
  public static g DQ()
  {
    Assert.assertNotNull("Kernel not initialized by MMApplication!", dKO);
    return dKO;
  }
  
  public static ca DR()
  {
    Assert.assertTrue(DQ().dKX);
    return DQ().dKR;
  }
  
  public static ai DS()
  {
    Assert.assertTrue(DQ().dKX);
    return DQ().dKQ;
  }
  
  public static p Dk()
  {
    DQ();
    return DO().dJT;
  }
  
  /* Error */
  public static void a(com.tencent.mm.kernel.b.h paramh)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 172	com/tencent/mm/kernel/g:dKO	Lcom/tencent/mm/kernel/g;
    //   6: ifnull +48 -> 54
    //   9: getstatic 172	com/tencent/mm/kernel/g:dKO	Lcom/tencent/mm/kernel/g;
    //   12: getfield 77	com/tencent/mm/kernel/g:dKP	Lcom/tencent/mm/kernel/h;
    //   15: invokevirtual 81	com/tencent/mm/kernel/h:DM	()Lcom/tencent/mm/kernel/d;
    //   18: invokevirtual 87	com/tencent/mm/kernel/d:Dr	()Lcom/tencent/mm/kernel/b/g;
    //   21: checkcast 89	com/tencent/mm/kernel/b/h
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 196	com/tencent/mm/kernel/b/g:bT	Landroid/app/Application;
    //   29: astore_2
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 200	com/tencent/mm/kernel/b/h:dMU	Lcom/tencent/tinker/loader/app/ApplicationLike;
    //   35: putfield 200	com/tencent/mm/kernel/b/h:dMU	Lcom/tencent/tinker/loader/app/ApplicationLike;
    //   38: aload_1
    //   39: aload_2
    //   40: putfield 196	com/tencent/mm/kernel/b/g:bT	Landroid/app/Application;
    //   43: ldc 202
    //   45: ldc 204
    //   47: invokestatic 210	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: new 10	com/tencent/mm/kernel/g$3
    //   57: dup
    //   58: invokespecial 211	com/tencent/mm/kernel/g$3:<init>	()V
    //   61: invokestatic 216	com/tencent/mm/kernel/k:a	(Lcom/tencent/mm/kernel/k$a;)V
    //   64: ldc 202
    //   66: ldc 218
    //   68: invokestatic 210	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: new 2	com/tencent/mm/kernel/g
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 220	com/tencent/mm/kernel/g:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   79: putstatic 172	com/tencent/mm/kernel/g:dKO	Lcom/tencent/mm/kernel/g;
    //   82: goto -32 -> 50
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramh	com.tencent.mm.kernel.b.h
    //   24	15	1	localh	com.tencent.mm.kernel.b.h
    //   29	11	2	localApplication	android.app.Application
    // Exception table:
    //   from	to	target	type
    //   3	50	85	finally
    //   54	82	85	finally
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, N paramN)
  {
    DQ();
    DL().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    DQ();
    DL().a(paramClass, paramc);
  }
  
  public static void hx(int paramInt)
  {
    a locala = DN();
    if ((a.hu(paramInt)) && (a.b.a(a.dJt) == paramInt) && (locala.Dc()))
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    synchronized (locala.dJs)
    {
      a.b.a(a.dJt, paramInt);
      locala.CR();
      locala.dJF = SystemClock.elapsedRealtime();
      locala.bE(true);
      return;
    }
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T r(Class<T> paramClass)
  {
    DQ();
    return DL().r(paramClass);
  }
  
  public static void s(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    DQ();
    DL().s(paramClass);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T t(Class<T> paramClass)
  {
    DQ();
    return DL().t(paramClass);
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    this.dKP.a(paramg);
  }
  
  public final void a(com.tencent.mm.kernel.b.h paramh, Object paramObject)
  {
    if (!this.dKY.containsKey(paramObject))
    {
      if (this.dKY.putIfAbsent(paramObject, this.dKY) == null) {
        break label60;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMKernel", "Already add, skip[%s].", new Object[] { paramObject });
    }
    label60:
    do
    {
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMKernel", "Already add, skip it[%s].", new Object[] { paramObject });
      return;
      com.tencent.mm.kernel.a.c.DY().add(paramObject);
      if ((paramObject instanceof ApplicationLifeCycle))
      {
        ApplicationLifeCycle localApplicationLifeCycle = (ApplicationLifeCycle)paramObject;
        paramh.dMV.aj(localApplicationLifeCycle);
      }
      if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
        this.dJS.aj((com.tencent.mm.kernel.api.d)paramObject);
      }
    } while (!(paramObject instanceof com.tencent.mm.kernel.api.g));
    this.dKP.a((com.tencent.mm.kernel.api.g)paramObject);
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    this.dKP.b(paramg);
  }
  
  public final void gi(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { o.getString(a.CK()), paramString, bk.csb() });
    a.gc(bk.csb().toString() + paramString);
    this.dKT.CU().bJ(a.CK());
    releaseAll();
    a.CP();
    a.bF(false);
  }
  
  public final void releaseAll()
  {
    if (this.dKT != null) {}
    for (String str = o.getString(a.CK());; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.dKU.dJT != null) {
        this.dKU.dJT.reset();
      }
      if (this.dKQ != null) {
        this.dKQ.a(new ai.b()
        {
          public final void pQ()
          {
            if (g.this.dKT != null) {
              g.this.dKT.release();
            }
          }
        });
      }
      return;
    }
  }
  
  private static final class a
    extends com.tencent.mm.ck.a<p.a>
    implements p.a
  {
    public final void a(final p paramp)
    {
      a(new a.a() {});
    }
    
    public final void a(final p paramp, final boolean paramBoolean)
    {
      a(new a.a() {});
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.g
 * JD-Core Version:    0.7.0.1
 */