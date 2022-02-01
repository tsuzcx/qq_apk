package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue<Lcom.tencent.mm.modelmulti.q.c;>;
import java.util.Set;
import junit.framework.Assert;

public final class q
{
  private static Boolean igp = null;
  public n.a appForegroundListener;
  private WakerLock fEr;
  public Queue<c> igq;
  public Queue<c> igr;
  private HashMap<c, Long> igs;
  public c igt;
  private long igu;
  
  public q()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new q.1(this);
    this.igq = new LinkedList();
    this.igr = new LinkedList();
    this.igs = new HashMap();
    this.igt = null;
    this.igu = 0L;
    this.fEr = null;
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void FY(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 101
    //   6: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   24: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 111	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   33: aastore
    //   34: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 118	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 124	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   52: ldc 103
    //   54: new 6	com/tencent/mm/modelmulti/q$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 125	com/tencent/mm/modelmulti/q$2:<init>	(Lcom/tencent/mm/modelmulti/q;)V
    //   62: invokespecial 128	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 134
    //   80: iload_2
    //   81: invokestatic 138	com/tencent/mm/modelmulti/q:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 144	com/tencent/mm/sdk/a/b:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
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
    //   0	119	0	this	q
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
    if (l.aJs())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132588);
        if (paramc != null)
        {
          if (!(paramc instanceof q.f)) {
            break label53;
          }
          q.b(q.this).add(paramc);
        }
        for (;;)
        {
          q.a(q.this, null);
          AppMethodBeat.o(132588);
          return;
          label53:
          q.c(q.this).add(paramc);
        }
      }
    });
    AppMethodBeat.o(132614);
  }
  
  private static boolean aJr()
  {
    AppMethodBeat.i(132615);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)aj.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132615);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 45L, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bt.n(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void aJz()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 427
    //   5: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 429
    //   35: astore_1
    //   36: ldc 103
    //   38: ldc_w 431
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 144	com/tencent/mm/sdk/a/b:foreground	Z
    //   54: invokestatic 321	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 434	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 427
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 321	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 95	com/tencent/mm/modelmulti/q:fEr	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 437	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 427
    //   94: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -30 -> 67
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	q
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
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(132607);
  }
  
  private static boolean azj()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.a.aiE()) || (!com.tencent.mm.kernel.g.ajx()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (igp != null)
    {
      boolean bool = igp.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    igp = Boolean.TRUE;
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
    boolean bool = azj();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new vc();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new of();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new vz();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new hp();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x20 & paramLong) != 0L)
    {
      localObject = new ar();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.g.ajx())
      {
        com.tencent.mm.kernel.g.ajD();
        i = j;
        if (com.tencent.mm.kernel.g.ajC().ajl() != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label429;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.ajD();
          i = paramInt;
          if (!com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0)) {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label429:
    for (i = 0;; i = m(paramInt, 7, false))
    {
      if (!bt.isNullOrNil(paramString))
      {
        localObject = new ap();
        ((ap)localObject).dll.type = 3;
        ((ap)localObject).dll.dln = paramString;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = azj();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int pM(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = azj();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bt.flS() });
    if (!bool)
    {
      k localk = new k(paramInt);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(localk, 0);
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
    int ieO;
    q.b igA;
    q.c igB;
    av igC;
    boolean igy;
    ccs igz;
    
    private a(q.c paramc, boolean paramBoolean, ccs paramccs, q.b paramb)
    {
      AppMethodBeat.i(132591);
      this.ieO = 0;
      this.igy = false;
      this.igz = null;
      this.igA = null;
      this.igC = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.g.ajx()) && (!com.tencent.mm.kernel.a.aiE()))
          {
            com.tencent.mm.kernel.g.ajD();
            if (com.tencent.mm.kernel.g.ajC() != null)
            {
              com.tencent.mm.kernel.g.ajD();
              if (com.tencent.mm.kernel.g.ajC().ajl() != null) {
                break label118;
              }
            }
          }
          Object localObject = q.a.this.igB;
          boolean bool1 = com.tencent.mm.kernel.g.ajx();
          boolean bool2 = com.tencent.mm.kernel.a.aiE();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.ajC() });
          q.a.this.igA.pN(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = q.a.this.igz.FRu.nDj;
          c localc = new c();
          localc.dr(q.a.this.igB);
          long l1 = bt.flT();
          long l2;
          do
          {
            if (q.a.this.ieO >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((zu)((LinkedList)localObject).get(q.a.this.ieO), false)) {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 46L, 1L, false);
            }
            q.a locala = q.a.this;
            locala.ieO += 1;
            l2 = bt.Df(l1);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { q.a.this.igB, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.ieO - 1) });
          } while (l2 < 500L);
          localc.ds(q.a.this.igB);
          if (q.a.this.ieO < ((LinkedList)localObject).size())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { q.a.this.igB, Long.valueOf(bt.Df(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.ieO - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          q.a(q.a.this.igy, q.a.this.igz, q.a.this.igB);
          q.a.this.igA.pN(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.igA = paramb;
      this.igB = paramc;
      this.igy = paramBoolean;
      this.igz = paramccs;
      this.ieO = 0;
      if ((this.igA != null) && (this.igB != null)) {}
      for (boolean bool = true;; bool = false)
      {
        q.S("", bool);
        if (this.igz != null) {
          break;
        }
        q.S("resp Not null", false);
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.igB });
        this.igA.pN(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((com.tencent.mm.kernel.g.ajx()) && (!com.tencent.mm.kernel.a.aiE()))
      {
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajC() != null)
        {
          com.tencent.mm.kernel.g.ajD();
          if (com.tencent.mm.kernel.g.ajC().ajl() != null) {
            break label274;
          }
        }
      }
      this$1 = this.igB;
      paramBoolean = com.tencent.mm.kernel.g.ajx();
      bool = com.tencent.mm.kernel.a.aiE();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { q.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.g.ajC() });
      this.igA.pN(0);
      AppMethodBeat.o(132591);
      return;
      label274:
      q.a(paramccs);
      long l2 = paramccs.GWW;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izd, Long.valueOf(l3));
      cf.rL(l1);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA().cO(this.igz.nDG, this.igz.GWV);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.kernel.a.mM(this.igz.nDG);
      if ((this.igz.FRu == null) || (this.igz.FRu.nDj == null) || (this.igz.FRu.nDj.size() <= 0))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.igB });
        q.a(paramBoolean, this.igz, this.igB);
        this.igA.pN(0);
        AppMethodBeat.o(132591);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.igB, Integer.valueOf(this.igz.FRu.nDj.size()), Integer.valueOf(this.igz.nDG), Integer.valueOf(this.igz.GWV) });
      this.igC.az(50L, 50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean pN(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean c(Queue<c> paramQueue);
  }
  
  final class d
    implements q.c
  {
    d() {}
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132593);
      paramQueue = new PInt();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, com.tencent.mm.kernel.a.getUin());
      int j = paramQueue.value;
      if (localObject != null) {}
      for (final int i = localObject.length;; i = -1)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((paramQueue.value != 0) && (!bt.cC((byte[])localObject))) {
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
        localObject = localb.Foy;
        paramQueue = (Queue<q.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 38L, 1L, false);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 20L, 1L, false);
        new q.a(q.this, this, true, paramQueue, new q.b()
        {
          public final boolean pN(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { q.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajA();
            com.tencent.mm.booter.g.co(paramAnonymousInt, com.tencent.mm.kernel.a.getUin());
            q.a(q.this, q.d.this);
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
    implements q.c, com.tencent.mm.network.k
  {
    int duf;
    private com.tencent.mm.network.q hON;
    com.tencent.mm.al.f igF;
    boolean igG;
    private boolean igH = false;
    int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.duf = paramInt2;
      this.igG = paramBoolean;
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.duf;
      boolean bool1 = this.igG;
      Object localObject;
      boolean bool2;
      label85:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
        if (paramQueue == null) {
          break label271;
        }
        q.b(paramQueue);
        bool1 = false;
        bool2 = false;
        if (paramQueue.isEmpty()) {
          break label261;
        }
        localObject = (e)paramQueue.poll();
        this.duf |= ((e)localObject).duf;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).duf), Boolean.valueOf(((e)localObject).igG), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).igG)
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
        if ((com.tencent.mm.kernel.g.ajx()) && (!com.tencent.mm.kernel.a.aiE()))
        {
          com.tencent.mm.kernel.g.ajD();
          if (com.tencent.mm.kernel.g.ajC() != null)
          {
            com.tencent.mm.kernel.g.ajD();
            if (com.tencent.mm.kernel.g.ajC().ajl() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.g.ajx();
        bool2 = com.tencent.mm.kernel.a.aiE();
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.ajC() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.g.ajD();
      long l = bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(0L));
        this.duf = ((int)(this.duf | l));
        this.duf &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label824;
        }
        this.duf |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.igG) {
          this.scene = 6;
        }
        this.hON = new k.a();
        paramQueue = ((v.a)this.hON.getReqObj()).Fox;
        paramQueue.GWU = i;
        paramQueue.FRq = this.duf;
        paramQueue.Scene = this.scene;
        com.tencent.mm.kernel.g.ajD();
        localObject = bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, ""));
        paramQueue.FRr = z.al(bt.aRa((String)localObject));
        paramQueue.GWT = new zv();
        paramQueue.FzJ = d.hgH;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.GWU), Integer.valueOf(paramQueue.FRq), Integer.valueOf(this.scene), paramQueue.FzJ });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, com.tencent.mm.protocal.ad.cq(bt.aRa((String)localObject)) });
        q.a(this);
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajB().gAO.a(this, 0)) {
          break label882;
        }
        com.tencent.mm.plugin.report.e.ygI.f(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + q.aJA() });
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label824:
        if (this.scene == 1011)
        {
          this.duf |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.duf |= 0x40000;
          this.scene = 3;
        }
      }
      label882:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
    {
      AppMethodBeat.i(132598);
      this.igF = paramf;
      int i = dispatch(parame, this.hON, this);
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
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 44L, 1L, false);
        if (paramq == null) {}
        for (paramInt1 = -2;; paramInt1 = paramq.getType())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.igH)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.igH = true;
      if (paramq == this.hON)
      {
        bool1 = true;
        q.S("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label475;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label475:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)paramq.getRespObj()).Foy;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.ajF().fkS();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new q.a(q.this, this, bool1, paramString, new q.b()
          {
            public final boolean pN(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(paramString.FMr));
              boolean bool;
              if ((paramString.FMr & q.e.this.duf) != 0)
              {
                bool = true;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { q.e.this, Integer.valueOf(paramString.FMr), Boolean.valueOf(bool), Integer.valueOf(paramString.FMr & 0x100), Integer.valueOf(paramString.FMr & 0x80), Integer.valueOf(q.e.this.duf) });
                Object localObject;
                if (!bool)
                {
                  localObject = new c();
                  q.e locale = q.e.this;
                  if (((c)localObject).EIN != null) {
                    ((c)localObject).EIN.du(locale);
                  }
                }
                if ((!bool) && ((paramString.FMr & 0x100) != 0))
                {
                  localObject = new vc();
                  ((vc)localObject).dJn.sourceType = 3;
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.FMr & 0x200000) != 0))
                {
                  localObject = new of();
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.FMr & 0x80) != 0))
                {
                  localObject = new vz();
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.FMr & 0x1000000) != 0))
                {
                  localObject = new hp();
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.FMr & 0x20) != 0))
                {
                  localObject = new ar();
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!q.e.this.igG)) {
                    break label442;
                  }
                  com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { q.e.this });
                }
              }
              for (;;)
              {
                q.e.this.igF.onSceneEnd(0, 0, "", q.e.this);
                q.a(q.this, q.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label442:
                q.a(q.this, q.e.this.scene, q.e.this.duf);
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.e.ygI.f(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + q.aJA() });
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 43L, 1L, false);
          this.igF.onSceneEnd(paramInt2, paramInt3, paramString, this);
          q.a(q.this, this);
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
    implements q.c
  {
    long hWw;
    int ier;
    ccs igz;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.Foy)
      {
        this.igz = q.this;
        this.hWw = paramLong;
        this.ier = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.igz == null)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 40L, 1L, false);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == ac.iON)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new q.a(q.this, this, true, this.igz, new q.b()
      {
        public final boolean pN(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { q.f.this, q.f.this.igz, Integer.valueOf(q.f.this.ier), Long.valueOf(q.f.this.hWw) });
          if ((q.f.this.ier & 0x1) > 0)
          {
            com.tencent.mm.kernel.g.ajD();
            byte[] arrayOfByte = bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, null)));
            com.tencent.mm.kernel.g.aiU().a(new g(q.f.this.hWw, arrayOfByte), 0);
          }
          q.a(q.this, q.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      com.tencent.mm.kernel.g.ajF().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132601);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { q.f.this, Integer.valueOf(q.f.this.igz.FMr) });
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(q.f.this.igz.FMr));
          if ((q.f.this.igz.FMr & 0x100) != 0)
          {
            vc localvc = new vc();
            localvc.dJn.sourceType = 2;
            com.tencent.mm.sdk.b.a.IbL.l(localvc);
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 22L, 1L, false);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { q.f.this });
          }
          AppMethodBeat.o(132601);
        }
      }, 100L);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 21L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q
 * JD-Core Version:    0.7.0.1
 */