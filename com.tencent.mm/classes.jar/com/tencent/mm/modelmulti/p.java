package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue<Lcom.tencent.mm.modelmulti.p.c;>;
import java.util.Set;
import junit.framework.Assert;

public final class p
{
  private static Boolean hNa = null;
  public n.a appForegroundListener;
  private WakerLock fmk;
  public Queue<c> hNb;
  public Queue<c> hNc;
  private HashMap<c, Long> hNd;
  public c hNe;
  private long hNf;
  
  public p()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(132586);
        ac.i("MicroMsg.SyncService", "SyncService onAppForeground %s", new Object[] { paramAnonymousString });
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            p.this.pj(3);
          }
        }
        AppMethodBeat.o(132586);
      }
    };
    this.hNb = new LinkedList();
    this.hNc = new LinkedList();
    this.hNd = new HashMap();
    this.hNe = null;
    this.hNf = 0L;
    this.fmk = null;
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void CT(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 101
    //   6: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 103
    //   11: ldc 105
    //   13: iconst_3
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 111	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   33: aastore
    //   34: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 118	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 124	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   52: ldc 103
    //   54: new 8	com/tencent/mm/modelmulti/p$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 125	com/tencent/mm/modelmulti/p$2:<init>	(Lcom/tencent/mm/modelmulti/p;)V
    //   62: invokespecial 128	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 134
    //   80: iload_2
    //   81: invokestatic 138	com/tencent/mm/modelmulti/p:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 144	com/tencent/mm/sdk/a/b:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   94: ldc2_w 145
    //   97: aload_1
    //   98: invokevirtual 149	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   101: ldc 101
    //   103: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: iconst_0
    //   110: istore_2
    //   111: goto -33 -> 78
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	p
    //   0	119	1	paramString	String
    //   1	110	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	68	114	finally
    //   68	78	114	finally
    //   78	101	114	finally
    //   101	106	114	finally
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(132614);
    if (l.aGj())
    {
      ac.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132588);
        if (paramc != null)
        {
          if (!(paramc instanceof p.f)) {
            break label53;
          }
          p.b(p.this).add(paramc);
        }
        for (;;)
        {
          p.a(p.this, null);
          AppMethodBeat.o(132588);
          return;
          label53:
          p.c(p.this).add(paramc);
        }
      }
    });
    AppMethodBeat.o(132614);
  }
  
  private static boolean aGi()
  {
    AppMethodBeat.i(132615);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ai.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132615);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 45L, 1L, false);
      ac.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bs.m(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void aGo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 424
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 426
    //   35: astore_1
    //   36: ldc 103
    //   38: ldc_w 428
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 144	com/tencent/mm/sdk/a/b:foreground	Z
    //   54: invokestatic 320	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 431	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 424
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 320	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 95	com/tencent/mm/modelmulti/p:fmk	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 434	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 424
    //   94: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -30 -> 67
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	p
    //   35	46	1	localObject1	Object
    //   100	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	100	finally
    //   25	32	100	finally
    //   36	67	100	finally
    //   70	81	100	finally
    //   84	97	100	finally
  }
  
  private static void assertTrue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132607);
    if (paramBoolean)
    {
      AppMethodBeat.o(132607);
      return;
    }
    ac.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(132607);
  }
  
  private static boolean awv()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.a.afS()) || (!com.tencent.mm.kernel.g.agM()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (hNa != null)
    {
      boolean bool = hNa.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    hNa = Boolean.TRUE;
    AppMethodBeat.o(132606);
    return true;
  }
  
  private int m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132611);
    e locale = new e(paramInt1, paramInt2, paramBoolean);
    a(locale);
    paramInt1 = locale.hashCode();
    AppMethodBeat.o(132611);
    return paramInt1;
  }
  
  public final int a(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(132608);
    boolean bool = awv();
    ac.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new uj();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new nx();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new vg();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new hi();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.g.agM())
      {
        com.tencent.mm.kernel.g.agS();
        i = j;
        if (com.tencent.mm.kernel.g.agR().agA() != null)
        {
          ac.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label397;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          ac.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.agS();
          i = paramInt;
          if (!com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0)) {
            ac.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label397:
    for (i = 0;; i = m(paramInt, 7, false))
    {
      if (!bs.isNullOrNil(paramString))
      {
        localObject = new com.tencent.mm.g.a.ap();
        ((com.tencent.mm.g.a.ap)localObject).cZT.type = 3;
        ((com.tencent.mm.g.a.ap)localObject).cZT.cZV = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = awv();
    ac.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int pj(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = awv();
    ac.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bs.eWi() });
    if (!bool)
    {
      k localk = new k(paramInt);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(localk, 0);
      paramInt = localk.hashCode();
      AppMethodBeat.o(132610);
      return paramInt;
    }
    paramInt = m(paramInt, 7, false);
    AppMethodBeat.o(132610);
    return paramInt;
  }
  
  final class a
  {
    int hLU;
    boolean hNj;
    byb hNk;
    p.b hNl;
    p.c hNm;
    au hNn;
    
    private a(p.c paramc, boolean paramBoolean, byb parambyb, p.b paramb)
    {
      AppMethodBeat.i(132591);
      this.hLU = 0;
      this.hNj = false;
      this.hNk = null;
      this.hNl = null;
      this.hNn = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.g.agM()) && (!com.tencent.mm.kernel.a.afS()))
          {
            com.tencent.mm.kernel.g.agS();
            if (com.tencent.mm.kernel.g.agR() != null)
            {
              com.tencent.mm.kernel.g.agS();
              if (com.tencent.mm.kernel.g.agR().agA() != null) {
                break label118;
              }
            }
          }
          Object localObject = p.a.this.hNm;
          boolean bool1 = com.tencent.mm.kernel.g.agM();
          boolean bool2 = com.tencent.mm.kernel.a.afS();
          com.tencent.mm.kernel.g.agS();
          ac.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.agR() });
          p.a.this.hNl.pk(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = p.a.this.hNk.Ekl.ncM;
          c localc = new c();
          localc.jdMethod_do(p.a.this.hNm);
          long l1 = bs.eWj();
          long l2;
          do
          {
            if (p.a.this.hLU >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((xv)((LinkedList)localObject).get(p.a.this.hLU), false)) {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 46L, 1L, false);
            }
            p.a locala = p.a.this;
            locala.hLU += 1;
            l2 = bs.Ap(l1);
            ac.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { p.a.this.hNm, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(p.a.this.hLU - 1) });
          } while (l2 < 500L);
          localc.dp(p.a.this.hNm);
          if (p.a.this.hLU < ((LinkedList)localObject).size())
          {
            ac.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { p.a.this.hNm, Long.valueOf(bs.Ap(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(p.a.this.hLU - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          p.a(p.a.this.hNj, p.a.this.hNk, p.a.this.hNm);
          p.a.this.hNl.pk(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.hNl = paramb;
      this.hNm = paramc;
      this.hNj = paramBoolean;
      this.hNk = parambyb;
      this.hLU = 0;
      if ((this.hNl != null) && (this.hNm != null)) {}
      for (boolean bool = true;; bool = false)
      {
        p.S("", bool);
        if (this.hNk != null) {
          break;
        }
        p.S("resp Not null", false);
        ac.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.hNm });
        this.hNl.pk(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((com.tencent.mm.kernel.g.agM()) && (!com.tencent.mm.kernel.a.afS()))
      {
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agR() != null)
        {
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.g.agR().agA() != null) {
            break label274;
          }
        }
      }
      this$1 = this.hNm;
      paramBoolean = com.tencent.mm.kernel.g.agM();
      bool = com.tencent.mm.kernel.a.afS();
      com.tencent.mm.kernel.g.agS();
      ac.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { p.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.g.agR() });
      this.hNl.pk(0);
      AppMethodBeat.o(132591);
      return;
      label274:
      p.a(parambyb);
      long l2 = parambyb.Fnn;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      ac.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GML, Long.valueOf(l3));
      ce.pM(l1);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP().cM(this.hNk.ndj, this.hNk.Fnm);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.kernel.a.mn(this.hNk.ndj);
      if ((this.hNk.Ekl == null) || (this.hNk.Ekl.ncM == null) || (this.hNk.Ekl.ncM.size() <= 0))
      {
        ac.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.hNm });
        p.a(paramBoolean, this.hNk, this.hNm);
        this.hNl.pk(0);
        AppMethodBeat.o(132591);
        return;
      }
      ac.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.hNm, Integer.valueOf(this.hNk.Ekl.ncM.size()), Integer.valueOf(this.hNk.ndj), Integer.valueOf(this.hNk.Fnm) });
      this.hNn.au(50L, 50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean pk(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean c(Queue<c> paramQueue);
  }
  
  final class d
    implements p.c
  {
    d() {}
    
    public final boolean c(Queue<p.c> paramQueue)
    {
      AppMethodBeat.i(132593);
      paramQueue = new PInt();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, com.tencent.mm.kernel.a.getUin());
      int j = paramQueue.value;
      if (localObject != null) {}
      for (final int i = localObject.length;; i = -1)
      {
        ac.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((paramQueue.value != 0) && (!bs.cv((byte[])localObject))) {
          break;
        }
        AppMethodBeat.o(132593);
        return false;
      }
      i = paramQueue.value;
      paramQueue = null;
      try
      {
        v.b localb = new v.b();
        localb.fromProtoBuf((byte[])localObject);
        localObject = localb.DJr;
        paramQueue = (Queue<p.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 38L, 1L, false);
          ac.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.booter.g.cm(i, com.tencent.mm.kernel.a.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          ac.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.booter.g.cm(i, com.tencent.mm.kernel.a.getUin());
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 20L, 1L, false);
        new p.a(p.this, this, true, paramQueue, new p.b()
        {
          public final boolean pk(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            ac.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { p.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.booter.g.cm(paramAnonymousInt, com.tencent.mm.kernel.a.getUin());
            p.a(p.this, p.d.this);
            AppMethodBeat.o(132592);
            return true;
          }
        }, (byte)0);
        AppMethodBeat.o(132593);
      }
      if (paramQueue == null)
      {
        AppMethodBeat.o(132593);
        return false;
      }
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132594);
      String str = "LightPush[" + hashCode() + "]";
      AppMethodBeat.o(132594);
      return str;
    }
  }
  
  final class e
    extends n
    implements p.c, com.tencent.mm.network.k
  {
    int hLw;
    com.tencent.mm.ak.g hNr;
    boolean hNs;
    private boolean hNt = false;
    private com.tencent.mm.network.q hwy;
    int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.hLw = paramInt2;
      this.hNs = paramBoolean;
    }
    
    public final boolean c(Queue<p.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.hLw;
      boolean bool1 = this.hNs;
      Object localObject;
      boolean bool2;
      label85:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        ac.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
        if (paramQueue == null) {
          break label271;
        }
        p.b(paramQueue);
        bool1 = false;
        bool2 = false;
        if (paramQueue.isEmpty()) {
          break label261;
        }
        localObject = (e)paramQueue.poll();
        this.hLw |= ((e)localObject).hLw;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        ac.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).hLw), Boolean.valueOf(((e)localObject).hNs), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).hNs)
        {
          bool2 = true;
          bool3 = bool1;
        }
      }
      label261:
      if (bool1) {
        this.scene = 3;
      }
      for (;;)
      {
        label271:
        if ((com.tencent.mm.kernel.g.agM()) && (!com.tencent.mm.kernel.a.afS()))
        {
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.g.agR() != null)
          {
            com.tencent.mm.kernel.g.agS();
            if (com.tencent.mm.kernel.g.agR().agA() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.g.agM();
        bool2 = com.tencent.mm.kernel.a.afS();
        com.tencent.mm.kernel.g.agS();
        ac.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.agR() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.g.agS();
      long l = bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(0L));
        this.hLw = ((int)(this.hLw | l));
        this.hLw &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label824;
        }
        this.hLw |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.hNs) {
          this.scene = 6;
        }
        this.hwy = new k.a();
        paramQueue = ((v.a)this.hwy.getReqObj()).DJq;
        paramQueue.Fnl = i;
        paramQueue.Ekh = this.hLw;
        paramQueue.Scene = this.scene;
        com.tencent.mm.kernel.g.agS();
        localObject = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, ""));
        paramQueue.Eki = z.al(bs.aLu((String)localObject));
        paramQueue.Fnk = new xw();
        paramQueue.DUp = d.gMK;
        ac.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.Fnl), Integer.valueOf(paramQueue.Ekh), Integer.valueOf(this.scene), paramQueue.DUp });
        ac.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.cj(bs.aLu((String)localObject)) });
        p.a(this);
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agQ().ghe.a(this, 0)) {
          break label882;
        }
        com.tencent.mm.plugin.report.e.wTc.f(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + p.aGp() });
        ac.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label824:
        if (this.scene == 1011)
        {
          this.hLw |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.hLw |= 0x40000;
          this.scene = 3;
        }
      }
      label882:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
    {
      AppMethodBeat.i(132598);
      this.hNr = paramg;
      int i = dispatch(parame, this.hwy, this);
      AppMethodBeat.o(132598);
      return i;
    }
    
    public final int getType()
    {
      return 138;
    }
    
    public final boolean needCheckCallback()
    {
      return false;
    }
    
    public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132599);
      if ((paramq == null) || (paramq.getType() != 138))
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 44L, 1L, false);
        if (paramq == null) {}
        for (paramInt1 = -2;; paramInt1 = paramq.getType())
        {
          ac.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.hNt)
      {
        ac.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.hNt = true;
      if (paramq == this.hwy)
      {
        bool1 = true;
        p.S("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label475;
        }
        ac.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        ac.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label475:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)paramq.getRespObj()).DJr;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.agU().eVl();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new p.a(p.this, this, bool1, paramString, new p.b()
          {
            public final boolean pk(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(paramString.EfS));
              boolean bool;
              if ((paramString.EfS & p.e.this.hLw) != 0)
              {
                bool = true;
                ac.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { p.e.this, Integer.valueOf(paramString.EfS), Boolean.valueOf(bool), Integer.valueOf(paramString.EfS & 0x100), Integer.valueOf(paramString.EfS & 0x80), Integer.valueOf(p.e.this.hLw) });
                Object localObject;
                if (!bool)
                {
                  localObject = new c();
                  p.e locale = p.e.this;
                  if (((c)localObject).DeU != null) {
                    ((c)localObject).DeU.dr(locale);
                  }
                }
                if ((!bool) && ((paramString.EfS & 0x100) != 0))
                {
                  localObject = new uj();
                  ((uj)localObject).dxb.sourceType = 3;
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.EfS & 0x200000) != 0))
                {
                  localObject = new nx();
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.EfS & 0x80) != 0))
                {
                  localObject = new vg();
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.EfS & 0x1000000) != 0))
                {
                  localObject = new hi();
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!p.e.this.hNs)) {
                    break label409;
                  }
                  ac.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { p.e.this });
                }
              }
              for (;;)
              {
                p.e.this.hNr.onSceneEnd(0, 0, "", p.e.this);
                p.a(p.this, p.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label409:
                p.a(p.this, p.e.this.scene, p.e.this.hLw);
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.e.wTc.f(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + p.aGp() });
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 43L, 1L, false);
          this.hNr.onSceneEnd(paramInt2, paramInt3, paramString, this);
          p.a(p.this, this);
          AppMethodBeat.o(132599);
          return;
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132597);
      String str = "NetSync[" + hashCode() + "]";
      AppMethodBeat.o(132597);
      return str;
    }
  }
  
  final class f
    implements p.c
  {
    long hDR;
    int hLx;
    byb hNk;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.DJr)
      {
        this.hNk = p.this;
        this.hDR = paramLong;
        this.hLx = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<p.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.hNk == null)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 40L, 1L, false);
        ac.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == ab.ivG)
      {
        ac.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new p.a(p.this, this, true, this.hNk, new p.b()
      {
        public final boolean pk(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          ac.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { p.f.this, p.f.this.hNk, Integer.valueOf(p.f.this.hLx), Long.valueOf(p.f.this.hDR) });
          if ((p.f.this.hLx & 0x1) > 0)
          {
            com.tencent.mm.kernel.g.agS();
            byte[] arrayOfByte = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null)));
            com.tencent.mm.kernel.g.agi().a(new g(p.f.this.hDR, arrayOfByte), 0);
          }
          p.a(p.this, p.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      com.tencent.mm.kernel.g.agU().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132601);
          ac.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { p.f.this, Integer.valueOf(p.f.this.hNk.EfS) });
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(p.f.this.hNk.EfS));
          if ((p.f.this.hNk.EfS & 0x100) != 0)
          {
            uj localuj = new uj();
            localuj.dxb.sourceType = 2;
            com.tencent.mm.sdk.b.a.GpY.l(localuj);
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 22L, 1L, false);
            ac.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { p.f.this });
          }
          AppMethodBeat.o(132601);
        }
      }, 100L);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 21L, 1L, false);
      AppMethodBeat.o(132603);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132604);
      String str = "NotifyData[" + hashCode() + "]";
      AppMethodBeat.o(132604);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */