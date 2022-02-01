package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.s;
import com.tencent.mm.am.s.a;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.model.co;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.ResetCallback;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class h
{
  public static final String[] mDj = { ":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4" };
  private static h mDk;
  public final c.a mCl;
  public i<com.tencent.mm.kernel.b.h> mDl;
  private MMHandlerThread mDm;
  private co mDn;
  public f mDo;
  public b mDp;
  public c mDq;
  public com.tencent.mm.ch.b mDr;
  public final a mDs;
  private final boolean mDt;
  private ConcurrentHashMap mDu;
  public volatile boolean mDv;
  
  private h(final com.tencent.mm.kernel.b.h paramh)
  {
    AppMethodBeat.i(132124);
    this.mDn = null;
    this.mDs = new a((byte)0);
    this.mCl = new c.a();
    this.mDu = new ConcurrentHashMap();
    this.mDv = false;
    this.mDl = i.e(paramh);
    this.mDt = ((com.tencent.mm.kernel.b.h)this.mDl.baB().bad()).bbA();
    if (this.mDt)
    {
      this.mDn = new co();
      this.mDm = new MMHandlerThread(DeprecatedThreadFactory.createHandlerThread("worker"));
      this.mDm.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182890);
          ConnectivityCompat.Companion.initSignalStrengthListener();
          AppMethodBeat.o(182890);
        }
      });
    }
    this.mDl.baA().mCz = new d.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182892);
        h.a(h.this, paramh, paramAnonymousa);
        com.tencent.mm.kernel.a.c.baR().cT(paramAnonymousa);
        AppMethodBeat.o(182892);
      }
      
      public final void b(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        AppMethodBeat.i(182891);
        h.a(h.this, paramh, paramAnonymousf);
        AppMethodBeat.o(182891);
      }
      
      public final void b(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182893);
        h.b(h.this, paramh, paramAnonymousa);
        AppMethodBeat.o(182893);
      }
      
      public final void c(com.tencent.mm.kernel.b.f paramAnonymousf)
      {
        AppMethodBeat.i(182894);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.baR();
        if (paramAnonymousf != null) {
          localc.cU(paramAnonymousf);
        }
        AppMethodBeat.o(182894);
      }
      
      public final void c(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(182895);
        com.tencent.mm.kernel.a.c localc = com.tencent.mm.kernel.a.c.baR();
        if (paramAnonymousa != null) {
          localc.cU(paramAnonymousa);
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
    //   3: ldc 163
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 165	com/tencent/mm/kernel/h:mDk	Lcom/tencent/mm/kernel/h;
    //   11: ifnull +53 -> 64
    //   14: getstatic 165	com/tencent/mm/kernel/h:mDk	Lcom/tencent/mm/kernel/h;
    //   17: getfield 100	com/tencent/mm/kernel/h:mDl	Lcom/tencent/mm/kernel/i;
    //   20: invokevirtual 104	com/tencent/mm/kernel/i:baB	()Lcom/tencent/mm/kernel/e;
    //   23: invokevirtual 110	com/tencent/mm/kernel/e:bad	()Lcom/tencent/mm/kernel/b/g;
    //   26: checkcast 112	com/tencent/mm/kernel/b/h
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 171	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
    //   34: astore_2
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 175	com/tencent/mm/kernel/b/h:mFT	Lcom/tencent/tinker/entry/ApplicationLike;
    //   40: putfield 175	com/tencent/mm/kernel/b/h:mFT	Lcom/tencent/tinker/entry/ApplicationLike;
    //   43: aload_1
    //   44: aload_2
    //   45: putfield 171	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
    //   48: ldc 177
    //   50: ldc 179
    //   52: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc 163
    //   57: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: ldc 2
    //   62: monitorexit
    //   63: return
    //   64: new 186	com/tencent/mm/kernel/h$3
    //   67: dup
    //   68: invokespecial 187	com/tencent/mm/kernel/h$3:<init>	()V
    //   71: invokestatic 192	com/tencent/mm/kernel/l:a	(Lcom/tencent/mm/kernel/l$a;)V
    //   74: ldc 177
    //   76: ldc 194
    //   78: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 2	com/tencent/mm/kernel/h
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 196	com/tencent/mm/kernel/h:<init>	(Lcom/tencent/mm/kernel/b/h;)V
    //   89: putstatic 165	com/tencent/mm/kernel/h:mDk	Lcom/tencent/mm/kernel/h;
    //   92: ldc 163
    //   94: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (!this.mDu.containsKey(paramObject))
    {
      if (this.mDu.putIfAbsent(paramObject, this.mDu) != null)
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
    com.tencent.mm.kernel.a.c.baR().add(paramObject);
    if ((paramObject instanceof ApplicationLifeCycle)) {
      paramh.a((ApplicationLifeCycle)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.mCl.add((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.g)) {
      this.mDl.a((com.tencent.mm.kernel.api.g)paramObject);
    }
    AppMethodBeat.o(132126);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.c<N> paramc)
  {
    AppMethodBeat.i(132139);
    baF();
    baA().a(paramClass, paramc);
    AppMethodBeat.o(132139);
  }
  
  public static s aZW()
  {
    AppMethodBeat.i(132141);
    baF();
    s locals = baD().mCm;
    AppMethodBeat.o(132141);
    return locals;
  }
  
  public static void aZz()
  {
    AppMethodBeat.i(235259);
    b.aZz();
    AppMethodBeat.o(235259);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(132137);
    baF();
    paramClass = baA().ax(paramClass);
    AppMethodBeat.o(132137);
    return paramClass;
  }
  
  public static void ay(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(132140);
    baF();
    baA().ay(paramClass);
    AppMethodBeat.o(132140);
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T az(Class<T> paramClass)
  {
    AppMethodBeat.i(132136);
    baF();
    paramClass = baA().az(paramClass);
    AppMethodBeat.o(132136);
    return paramClass;
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(132138);
    baF();
    baA().a(paramClass, new com.tencent.mm.kernel.c.e(paramN));
    AppMethodBeat.o(132138);
  }
  
  public static d baA()
  {
    AppMethodBeat.i(132130);
    Assert.assertNotNull("mCorePlugins not initialized!", baF().mDl.baA());
    d locald = baF().mDl.baA();
    AppMethodBeat.o(132130);
    return locald;
  }
  
  public static e<com.tencent.mm.kernel.b.h> baB()
  {
    AppMethodBeat.i(132131);
    Assert.assertNotNull("mCoreProcess not initialized!", baF().mDl.baB());
    e locale = baF().mDl.baB();
    AppMethodBeat.o(132131);
    return locale;
  }
  
  public static b baC()
  {
    AppMethodBeat.i(132132);
    Assert.assertNotNull("mCoreAccount not initialized!", baF().mDp);
    b localb = baF().mDp;
    AppMethodBeat.o(132132);
    return localb;
  }
  
  public static c baD()
  {
    AppMethodBeat.i(132133);
    Assert.assertNotNull("mCoreNetwork not initialized!", baF().mDq);
    c localc = baF().mDq;
    AppMethodBeat.o(132133);
    return localc;
  }
  
  public static f baE()
  {
    AppMethodBeat.i(132134);
    Assert.assertNotNull("mCoreStorage not initialized!", baF().mDo);
    f localf = baF().mDo;
    AppMethodBeat.o(132134);
    return localf;
  }
  
  public static h baF()
  {
    AppMethodBeat.i(132135);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", mDk);
    h localh = mDk;
    AppMethodBeat.o(132135);
    return localh;
  }
  
  public static co baG()
  {
    AppMethodBeat.i(132142);
    Assert.assertTrue(baF().mDt);
    co localco = baF().mDn;
    AppMethodBeat.o(132142);
    return localco;
  }
  
  @Deprecated
  public static MMHandlerThread baH()
  {
    AppMethodBeat.i(132143);
    Assert.assertTrue(baF().mDt);
    MMHandlerThread localMMHandlerThread = baF().mDm;
    AppMethodBeat.o(132143);
    return localMMHandlerThread;
  }
  
  public static boolean baz()
  {
    AppMethodBeat.i(132129);
    b localb = baF().mDp;
    if ((localb != null) && (localb.aZN()))
    {
      AppMethodBeat.o(132129);
      return true;
    }
    AppMethodBeat.o(132129);
    return false;
  }
  
  public static void sC(int paramInt)
  {
    AppMethodBeat.i(132145);
    b localb = baC();
    if ((b.sw(paramInt)) && (b.c.a(b.mBJ) == paramInt) && (localb.aZN()))
    {
      Log.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(132145);
      return;
    }
    synchronized (localb.mBI)
    {
      b.c.a(b.mBJ, paramInt);
      localb.aZB();
      localb.mBX = SystemClock.elapsedRealtime();
      localb.fz(true);
      AppMethodBeat.o(132145);
      return;
    }
  }
  
  public final void FB(String paramString)
  {
    AppMethodBeat.i(132146);
    Log.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { p.getString(b.getUin()), paramString, Util.getStack() });
    b.Fv(Util.getStack().toString() + paramString);
    this.mDp.aZE().iC(b.getUin());
    releaseAll();
    b.aZy();
    b.fA(false);
    AppMethodBeat.o(132146);
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132127);
    this.mDl.a(paramg);
    AppMethodBeat.o(132127);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(132148);
    this.mDl.a(paramd);
    AppMethodBeat.o(132148);
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(132128);
    this.mDl.b(paramg);
    AppMethodBeat.o(132128);
  }
  
  public final void cS(Object paramObject)
  {
    AppMethodBeat.i(132125);
    a((com.tencent.mm.kernel.b.h)baB().bad(), paramObject);
    AppMethodBeat.o(132125);
  }
  
  public final void fB(boolean paramBoolean)
  {
    AppMethodBeat.i(132149);
    this.mDl.mDI.dZ(paramBoolean);
    AppMethodBeat.o(132149);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(132147);
    long l = System.currentTimeMillis();
    if (this.mDp != null) {}
    for (String str = p.getString(b.getUin());; str = "-1")
    {
      Log.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.mDq.mCm != null) {
        this.mDq.mCm.reset();
      }
      com.tencent.threadpool.g.shutdown();
      if (this.mDm != null) {
        this.mDm.syncReset(new MMHandlerThread.ResetCallback()
        {
          public final void callback()
          {
            AppMethodBeat.i(182901);
            com.tencent.threadpool.g.a(MMApplicationContext.getContext(), new aa());
            if (h.a(h.this) != null) {
              h.a(h.this).release();
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
    extends com.tencent.mm.cp.a<s.a>
    implements s.a
  {
    public final void a(final s params)
    {
      AppMethodBeat.i(132123);
      a(new a.a() {});
      AppMethodBeat.o(132123);
    }
    
    public final void a(final s params, final boolean paramBoolean)
    {
      AppMethodBeat.i(132122);
      a(new a.a() {});
      AppMethodBeat.o(132122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.h
 * JD-Core Version:    0.7.0.1
 */