package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private static Boolean iji = null;
  public o.a appForegroundListener;
  private WakerLock fGv;
  public Queue<c> ijj;
  public Queue<c> ijk;
  private HashMap<c, Long> ijl;
  public c ijm;
  private long ijn;
  
  public q()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new q.1(this);
    this.ijj = new LinkedList();
    this.ijk = new LinkedList();
    this.ijl = new HashMap();
    this.ijm = null;
    this.ijn = 0L;
    this.fGv = null;
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void GA(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 99
    //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 101
    //   11: ldc 103
    //   13: iconst_3
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 109	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
    //   33: aastore
    //   34: invokestatic 114	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 116	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 122	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   52: ldc 101
    //   54: new 6	com/tencent/mm/modelmulti/q$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 123	com/tencent/mm/modelmulti/q$2:<init>	(Lcom/tencent/mm/modelmulti/q;)V
    //   62: invokespecial 126	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 130	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 132
    //   80: iload_2
    //   81: invokestatic 136	com/tencent/mm/modelmulti/q:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 142	com/tencent/mm/sdk/a/b:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   94: ldc2_w 143
    //   97: aload_1
    //   98: invokevirtual 147	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   101: ldc 99
    //   103: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (l.aJL())
    {
      ae.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
  
  private static boolean aJK()
  {
    AppMethodBeat.i(132615);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ak.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132615);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 45L, 1L, false);
      ae.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bu.o(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void aJS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 422
    //   5: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 130	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 424
    //   35: astore_1
    //   36: ldc 101
    //   38: ldc_w 426
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 142	com/tencent/mm/sdk/a/b:foreground	Z
    //   54: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 429	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 422
    //   64: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 130	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 93	com/tencent/mm/modelmulti/q:fGv	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 432	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 422
    //   94: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    ae.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(132607);
  }
  
  private static boolean azz()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.a.aiT()) || (!com.tencent.mm.kernel.g.ajM()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (iji != null)
    {
      boolean bool = iji.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    iji = Boolean.TRUE;
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
    boolean bool = azz();
    ae.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new vg();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new og();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new wd();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new hq();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x20 & paramLong) != 0L)
    {
      localObject = new com.tencent.mm.g.a.ar();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.g.ajM())
      {
        com.tencent.mm.kernel.g.ajS();
        i = j;
        if (com.tencent.mm.kernel.g.ajR().ajA() != null)
        {
          ae.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label429;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          ae.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.ajS();
          i = paramInt;
          if (!com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0)) {
            ae.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label429:
    for (i = 0;; i = m(paramInt, 7, false))
    {
      if (!bu.isNullOrNil(paramString))
      {
        localObject = new ap();
        ((ap)localObject).dmn.type = 3;
        ((ap)localObject).dmn.dmp = paramString;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = azz();
    ae.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int pP(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = azz();
    ae.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bu.fpN() });
    if (!bool)
    {
      k localk = new k(paramInt);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(localk, 0);
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
    int ihG;
    boolean ijr;
    cdm ijs;
    q.b ijt;
    q.c iju;
    aw ijv;
    
    private a(q.c paramc, boolean paramBoolean, cdm paramcdm, q.b paramb)
    {
      AppMethodBeat.i(132591);
      this.ihG = 0;
      this.ijr = false;
      this.ijs = null;
      this.ijt = null;
      this.ijv = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.g.ajM()) && (!com.tencent.mm.kernel.a.aiT()))
          {
            com.tencent.mm.kernel.g.ajS();
            if (com.tencent.mm.kernel.g.ajR() != null)
            {
              com.tencent.mm.kernel.g.ajS();
              if (com.tencent.mm.kernel.g.ajR().ajA() != null) {
                break label118;
              }
            }
          }
          Object localObject = q.a.this.iju;
          boolean bool1 = com.tencent.mm.kernel.g.ajM();
          boolean bool2 = com.tencent.mm.kernel.a.aiT();
          com.tencent.mm.kernel.g.ajS();
          ae.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.ajR() });
          q.a.this.ijt.pQ(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = q.a.this.ijs.GjT.nIE;
          c localc = new c();
          localc.ds(q.a.this.iju);
          long l1 = bu.fpO();
          long l2;
          do
          {
            if (q.a.this.ihG >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((zx)((LinkedList)localObject).get(q.a.this.ihG), false)) {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 46L, 1L, false);
            }
            q.a locala = q.a.this;
            locala.ihG += 1;
            l2 = bu.DD(l1);
            ae.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { q.a.this.iju, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.ihG - 1) });
          } while (l2 < 500L);
          localc.dt(q.a.this.iju);
          if (q.a.this.ihG < ((LinkedList)localObject).size())
          {
            ae.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { q.a.this.iju, Long.valueOf(bu.DD(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.ihG - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          q.a(q.a.this.ijr, q.a.this.ijs, q.a.this.iju);
          q.a.this.ijt.pQ(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.ijt = paramb;
      this.iju = paramc;
      this.ijr = paramBoolean;
      this.ijs = paramcdm;
      this.ihG = 0;
      if ((this.ijt != null) && (this.iju != null)) {}
      for (boolean bool = true;; bool = false)
      {
        q.S("", bool);
        if (this.ijs != null) {
          break;
        }
        q.S("resp Not null", false);
        ae.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.iju });
        this.ijt.pQ(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((com.tencent.mm.kernel.g.ajM()) && (!com.tencent.mm.kernel.a.aiT()))
      {
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajR() != null)
        {
          com.tencent.mm.kernel.g.ajS();
          if (com.tencent.mm.kernel.g.ajR().ajA() != null) {
            break label274;
          }
        }
      }
      this$1 = this.iju;
      paramBoolean = com.tencent.mm.kernel.g.ajM();
      bool = com.tencent.mm.kernel.a.aiT();
      com.tencent.mm.kernel.g.ajS();
      ae.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { q.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.g.ajR() });
      this.ijt.pQ(0);
      AppMethodBeat.o(132591);
      return;
      label274:
      q.a(paramcdm);
      long l2 = paramcdm.Hqw;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      ae.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITB, Long.valueOf(l3));
      ch.rY(l1);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP().cO(this.ijs.nJb, this.ijs.Hqv);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.kernel.a.mP(this.ijs.nJb);
      if ((this.ijs.GjT == null) || (this.ijs.GjT.nIE == null) || (this.ijs.GjT.nIE.size() <= 0))
      {
        ae.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.iju });
        q.a(paramBoolean, this.ijs, this.iju);
        this.ijt.pQ(0);
        AppMethodBeat.o(132591);
        return;
      }
      ae.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.iju, Integer.valueOf(this.ijs.GjT.nIE.size()), Integer.valueOf(this.ijs.nJb), Integer.valueOf(this.ijs.Hqv) });
      this.ijv.ay(50L, 50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean pQ(int paramInt);
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
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, com.tencent.mm.kernel.a.getUin());
      int j = paramQueue.value;
      if (localObject != null) {}
      for (final int i = localObject.length;; i = -1)
      {
        ae.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((paramQueue.value != 0) && (!bu.cF((byte[])localObject))) {
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
        localObject = localb.FGW;
        paramQueue = (Queue<q.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 38L, 1L, false);
          ae.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          ae.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 20L, 1L, false);
        new q.a(q.this, this, true, paramQueue, new q.b()
        {
          public final boolean pQ(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            ae.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { q.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajP();
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
    int dvk;
    private com.tencent.mm.network.q hRG;
    private boolean ijA = false;
    com.tencent.mm.ak.f ijy;
    boolean ijz;
    int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.dvk = paramInt2;
      this.ijz = paramBoolean;
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.dvk;
      boolean bool1 = this.ijz;
      Object localObject;
      boolean bool2;
      label85:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        ae.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
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
        this.dvk |= ((e)localObject).dvk;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        ae.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).dvk), Boolean.valueOf(((e)localObject).ijz), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).ijz)
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
        if ((com.tencent.mm.kernel.g.ajM()) && (!com.tencent.mm.kernel.a.aiT()))
        {
          com.tencent.mm.kernel.g.ajS();
          if (com.tencent.mm.kernel.g.ajR() != null)
          {
            com.tencent.mm.kernel.g.ajS();
            if (com.tencent.mm.kernel.g.ajR().ajA() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.g.ajM();
        bool2 = com.tencent.mm.kernel.a.aiT();
        com.tencent.mm.kernel.g.ajS();
        ae.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.ajR() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.g.ajS();
      long l = bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(0L));
        this.dvk = ((int)(this.dvk | l));
        this.dvk &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label824;
        }
        this.dvk |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.ijz) {
          this.scene = 6;
        }
        this.hRG = new k.a();
        paramQueue = ((v.a)this.hRG.getReqObj()).FGV;
        paramQueue.Hqu = i;
        paramQueue.GjP = this.dvk;
        paramQueue.Scene = this.scene;
        com.tencent.mm.kernel.g.ajS();
        localObject = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, ""));
        paramQueue.GjQ = z.al(bu.aSx((String)localObject));
        paramQueue.Hqt = new zy();
        paramQueue.FSh = d.hjv;
        ae.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.Hqu), Integer.valueOf(paramQueue.GjP), Integer.valueOf(this.scene), paramQueue.FSh });
        ae.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.ct(bu.aSx((String)localObject)) });
        q.a(this);
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajQ().gDv.a(this, 0)) {
          break label882;
        }
        com.tencent.mm.plugin.report.e.ywz.f(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + q.aJT() });
        ae.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label824:
        if (this.scene == 1011)
        {
          this.dvk |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.dvk |= 0x40000;
          this.scene = 3;
        }
      }
      label882:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
    {
      AppMethodBeat.i(132598);
      this.ijy = paramf;
      int i = dispatch(parame, this.hRG, this);
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
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 44L, 1L, false);
        if (paramq == null) {}
        for (paramInt1 = -2;; paramInt1 = paramq.getType())
        {
          ae.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.ijA)
      {
        ae.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.ijA = true;
      if (paramq == this.hRG)
      {
        bool1 = true;
        q.S("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label475;
        }
        ae.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        ae.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label475:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)paramq.getRespObj()).FGW;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.ajU().foN();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new q.a(q.this, this, bool1, paramString, new q.b()
          {
            public final boolean pQ(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(paramString.GeQ));
              boolean bool;
              if ((paramString.GeQ & q.e.this.dvk) != 0)
              {
                bool = true;
                ae.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { q.e.this, Integer.valueOf(paramString.GeQ), Boolean.valueOf(bool), Integer.valueOf(paramString.GeQ & 0x100), Integer.valueOf(paramString.GeQ & 0x80), Integer.valueOf(q.e.this.dvk) });
                Object localObject;
                if (!bool)
                {
                  localObject = new c();
                  q.e locale = q.e.this;
                  if (((c)localObject).Fbl != null) {
                    ((c)localObject).Fbl.dv(locale);
                  }
                }
                if ((!bool) && ((paramString.GeQ & 0x100) != 0))
                {
                  localObject = new vg();
                  ((vg)localObject).dKB.sourceType = 3;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.GeQ & 0x200000) != 0))
                {
                  localObject = new og();
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.GeQ & 0x80) != 0))
                {
                  localObject = new wd();
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.GeQ & 0x1000000) != 0))
                {
                  localObject = new hq();
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.GeQ & 0x20) != 0))
                {
                  localObject = new com.tencent.mm.g.a.ar();
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!q.e.this.ijz)) {
                    break label442;
                  }
                  ae.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { q.e.this });
                }
              }
              for (;;)
              {
                q.e.this.ijy.onSceneEnd(0, 0, "", q.e.this);
                q.a(q.this, q.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label442:
                q.a(q.this, q.e.this.scene, q.e.this.dvk);
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.e.ywz.f(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + q.aJT() });
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 43L, 1L, false);
          this.ijy.onSceneEnd(paramInt2, paramInt3, paramString, this);
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
    long hZo;
    int ihj;
    cdm ijs;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.FGW)
      {
        this.ijs = q.this;
        this.hZo = paramLong;
        this.ihj = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.ijs == null)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 40L, 1L, false);
        ae.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == ac.iRH)
      {
        ae.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new q.a(q.this, this, true, this.ijs, new q.b()
      {
        public final boolean pQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          ae.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { q.f.this, q.f.this.ijs, Integer.valueOf(q.f.this.ihj), Long.valueOf(q.f.this.hZo) });
          if ((q.f.this.ihj & 0x1) > 0)
          {
            com.tencent.mm.kernel.g.ajS();
            byte[] arrayOfByte = bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, null)));
            com.tencent.mm.kernel.g.ajj().a(new g(q.f.this.hZo, arrayOfByte), 0);
          }
          q.a(q.this, q.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      com.tencent.mm.kernel.g.ajU().n(new q.f.2(this), 100L);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 21L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q
 * JD-Core Version:    0.7.0.1
 */