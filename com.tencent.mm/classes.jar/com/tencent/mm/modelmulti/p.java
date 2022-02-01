package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
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
  private static Boolean hmx = null;
  public n.a appForegroundListener;
  private WakerLock fiQ;
  private HashMap<c, Long> hmA;
  public c hmB;
  private long hmC;
  public Queue<c> hmy;
  public Queue<c> hmz;
  
  public p()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new p.1(this);
    this.hmy = new LinkedList();
    this.hmz = new LinkedList();
    this.hmA = new HashMap();
    this.hmB = null;
    this.hmC = 0L;
    this.fiQ = null;
    AppMethodBeat.o(132605);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(132614);
    if (l.azs())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
  
  private static boolean apG()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.a.aeC()) || (!com.tencent.mm.kernel.g.afw()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (hmx != null)
    {
      boolean bool = hmx.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    hmx = Boolean.TRUE;
    AppMethodBeat.o(132606);
    return true;
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
  
  private static boolean azr()
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 45L, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bt.m(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void azx()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 418
    //   5: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 423	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 425
    //   35: astore_1
    //   36: ldc 122
    //   38: ldc_w 427
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 191	com/tencent/mm/sdk/a/b:foreground	Z
    //   54: invokestatic 296	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 430	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 418
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 423	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 296	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 433	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 418
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
  
  private int m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132611);
    e locale = new e(paramInt1, paramInt2, paramBoolean);
    a(locale);
    paramInt1 = locale.hashCode();
    AppMethodBeat.o(132611);
    return paramInt1;
  }
  
  /* Error */
  private void yO(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 510
    //   7: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 122
    //   12: ldc_w 512
    //   15: iconst_3
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: invokestatic 516	com/tencent/mm/sdk/platformtools/bt:eGN	()Lcom/tencent/mm/sdk/platformtools/at;
    //   35: aastore
    //   36: invokestatic 298	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   43: ifnonnull +27 -> 70
    //   46: aload_0
    //   47: new 420	com/tencent/mars/comm/WakerLock
    //   50: dup
    //   51: invokestatic 202	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   54: ldc 122
    //   56: new 6	com/tencent/mm/modelmulti/p$2
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 517	com/tencent/mm/modelmulti/p$2:<init>	(Lcom/tencent/mm/modelmulti/p;)V
    //   64: invokespecial 520	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   67: putfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 423	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: ifne +36 -> 113
    //   80: ldc_w 522
    //   83: iload_2
    //   84: invokestatic 104	com/tencent/mm/modelmulti/p:assertTrue	(Ljava/lang/String;Z)V
    //   87: getstatic 191	com/tencent/mm/sdk/a/b:foreground	Z
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 95	com/tencent/mm/modelmulti/p:fiQ	Lcom/tencent/mars/comm/WakerLock;
    //   97: ldc2_w 523
    //   100: aload_1
    //   101: invokevirtual 527	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   104: ldc_w 510
    //   107: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: iconst_0
    //   114: istore_2
    //   115: goto -35 -> 80
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	p
    //   0	123	1	paramString	String
    //   1	114	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	70	118	finally
    //   70	80	118	finally
    //   80	104	118	finally
    //   104	110	118	finally
  }
  
  public final int a(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(132608);
    boolean bool = apG();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new tz();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new no();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new uw();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new he();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.g.afw())
      {
        com.tencent.mm.kernel.g.afC();
        i = j;
        if (com.tencent.mm.kernel.g.afB().afk() != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label397;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.afC();
          i = paramInt;
          if (!com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0)) {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label397:
    for (i = 0;; i = m(paramInt, 7, false))
    {
      if (!bt.isNullOrNil(paramString))
      {
        localObject = new ao();
        ((ao)localObject).dcv.type = 3;
        ((ao)localObject).dcv.dcx = paramString;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = apG();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int ov(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = apG();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bt.eGN() });
    if (!bool)
    {
      k localk = new k(paramInt);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(localk, 0);
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
    int hlr;
    boolean hmG;
    btk hmH;
    p.b hmI;
    p.c hmJ;
    av hmK;
    
    private a(p.c paramc, boolean paramBoolean, btk parambtk, p.b paramb)
    {
      AppMethodBeat.i(132591);
      this.hlr = 0;
      this.hmG = false;
      this.hmH = null;
      this.hmI = null;
      this.hmK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.g.afw()) && (!com.tencent.mm.kernel.a.aeC()))
          {
            com.tencent.mm.kernel.g.afC();
            if (com.tencent.mm.kernel.g.afB() != null)
            {
              com.tencent.mm.kernel.g.afC();
              if (com.tencent.mm.kernel.g.afB().afk() != null) {
                break label118;
              }
            }
          }
          Object localObject = p.a.this.hmJ;
          boolean bool1 = com.tencent.mm.kernel.g.afw();
          boolean bool2 = com.tencent.mm.kernel.a.aeC();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.afB() });
          p.a.this.hmI.ow(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = p.a.this.hmH.CRA.mAL;
          c localc = new c();
          localc.dn(p.a.this.hmJ);
          long l1 = bt.eGO();
          long l2;
          do
          {
            if (p.a.this.hlr >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((xd)((LinkedList)localObject).get(p.a.this.hlr), false)) {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 46L, 1L, false);
            }
            p.a locala = p.a.this;
            locala.hlr += 1;
            l2 = bt.vM(l1);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { p.a.this.hmJ, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(p.a.this.hlr - 1) });
          } while (l2 < 500L);
          localc.jdMethod_do(p.a.this.hmJ);
          if (p.a.this.hlr < ((LinkedList)localObject).size())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { p.a.this.hmJ, Long.valueOf(bt.vM(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(p.a.this.hlr - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          p.a(p.a.this.hmG, p.a.this.hmH, p.a.this.hmJ);
          p.a.this.hmI.ow(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.hmI = paramb;
      this.hmJ = paramc;
      this.hmG = paramBoolean;
      this.hmH = parambtk;
      this.hlr = 0;
      if ((this.hmI != null) && (this.hmJ != null)) {}
      for (boolean bool = true;; bool = false)
      {
        p.R("", bool);
        if (this.hmH != null) {
          break;
        }
        p.R("resp Not null", false);
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.hmJ });
        this.hmI.ow(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((com.tencent.mm.kernel.g.afw()) && (!com.tencent.mm.kernel.a.aeC()))
      {
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afB() != null)
        {
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afB().afk() != null) {
            break label274;
          }
        }
      }
      this$1 = this.hmJ;
      paramBoolean = com.tencent.mm.kernel.g.afw();
      bool = com.tencent.mm.kernel.a.aeC();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { p.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.g.afB() });
      this.hmI.ow(0);
      AppMethodBeat.o(132591);
      return;
      label274:
      p.a(parambtk);
      long l2 = parambtk.DQV;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FoW, Long.valueOf(l3));
      ce.lY(l1);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz().cO(this.hmH.mBi, this.hmH.DQU);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.kernel.a.mo(this.hmH.mBi);
      if ((this.hmH.CRA == null) || (this.hmH.CRA.mAL == null) || (this.hmH.CRA.mAL.size() <= 0))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.hmJ });
        p.a(paramBoolean, this.hmH, this.hmJ);
        this.hmI.ow(0);
        AppMethodBeat.o(132591);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.hmJ, Integer.valueOf(this.hmH.CRA.mAL.size()), Integer.valueOf(this.hmH.mBi), Integer.valueOf(this.hmH.DQU) });
      this.hmK.av(50L, 50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean ow(int paramInt);
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
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, com.tencent.mm.kernel.a.getUin());
      int j = paramQueue.value;
      if (localObject != null) {}
      for (final int i = localObject.length;; i = -1)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((paramQueue.value != 0) && (!bt.cw((byte[])localObject))) {
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
        localObject = localb.CqZ;
        paramQueue = (Queue<p.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 38L, 1L, false);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 20L, 1L, false);
        new p.a(p.this, this, true, paramQueue, new p.b()
        {
          public final boolean ow(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { p.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afz();
            com.tencent.mm.booter.g.co(paramAnonymousInt, com.tencent.mm.kernel.a.getUin());
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
    private com.tencent.mm.network.q gVZ;
    int hkT;
    com.tencent.mm.al.g hmO;
    boolean hmP;
    private boolean hmQ = false;
    int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.hkT = paramInt2;
      this.hmP = paramBoolean;
    }
    
    public final boolean c(Queue<p.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.hkT;
      boolean bool1 = this.hmP;
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
        p.b(paramQueue);
        bool1 = false;
        bool2 = false;
        if (paramQueue.isEmpty()) {
          break label261;
        }
        localObject = (e)paramQueue.poll();
        this.hkT |= ((e)localObject).hkT;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).hkT), Boolean.valueOf(((e)localObject).hmP), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).hmP)
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
        if ((com.tencent.mm.kernel.g.afw()) && (!com.tencent.mm.kernel.a.aeC()))
        {
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afB() != null)
          {
            com.tencent.mm.kernel.g.afC();
            if (com.tencent.mm.kernel.g.afB().afk() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.g.afw();
        bool2 = com.tencent.mm.kernel.a.aeC();
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.afB() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.g.afC();
      long l = bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(0L));
        this.hkT = ((int)(this.hkT | l));
        this.hkT &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label824;
        }
        this.hkT |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.hmP) {
          this.scene = 6;
        }
        this.gVZ = new k.a();
        paramQueue = ((v.a)this.gVZ.getReqObj()).CqY;
        paramQueue.DQT = i;
        paramQueue.CRw = this.hkT;
        paramQueue.Scene = this.scene;
        com.tencent.mm.kernel.g.afC();
        localObject = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, ""));
        paramQueue.CRx = z.am(bt.aGd((String)localObject));
        paramQueue.DQS = new xe();
        paramQueue.CBS = d.glX;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.DQT), Integer.valueOf(paramQueue.CRw), Integer.valueOf(this.scene), paramQueue.CBS });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, com.tencent.mm.protocal.ad.ck(bt.aGd((String)localObject)) });
        p.a(this);
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afA().gcy.a(this, 0)) {
          break label882;
        }
        com.tencent.mm.plugin.report.e.vIY.f(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + p.azy() });
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label824:
        if (this.scene == 1011)
        {
          this.hkT |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.hkT |= 0x40000;
          this.scene = 3;
        }
      }
      label882:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
    {
      AppMethodBeat.i(132598);
      this.hmO = paramg;
      int i = dispatch(parame, this.gVZ, this);
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
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 44L, 1L, false);
        if (paramq == null) {}
        for (paramInt1 = -2;; paramInt1 = paramq.getType())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.hmQ)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.hmQ = true;
      if (paramq == this.gVZ)
      {
        bool1 = true;
        p.R("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label475;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label475:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)paramq.getRespObj()).CqZ;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.afE().eFQ();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new p.a(p.this, this, bool1, paramString, new p.b()
          {
            public final boolean ow(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(paramString.CNq));
              boolean bool;
              if ((paramString.CNq & p.e.this.hkT) != 0)
              {
                bool = true;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { p.e.this, Integer.valueOf(paramString.CNq), Boolean.valueOf(bool), Integer.valueOf(paramString.CNq & 0x100), Integer.valueOf(paramString.CNq & 0x80), Integer.valueOf(p.e.this.hkT) });
                Object localObject;
                if (!bool)
                {
                  localObject = new c();
                  p.e locale = p.e.this;
                  if (((c)localObject).BMK != null) {
                    ((c)localObject).BMK.dq(locale);
                  }
                }
                if ((!bool) && ((paramString.CNq & 0x100) != 0))
                {
                  localObject = new tz();
                  ((tz)localObject).dzp.sourceType = 3;
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.CNq & 0x200000) != 0))
                {
                  localObject = new no();
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.CNq & 0x80) != 0))
                {
                  localObject = new uw();
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if ((!bool) && ((paramString.CNq & 0x1000000) != 0))
                {
                  localObject = new he();
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!p.e.this.hmP)) {
                    break label409;
                  }
                  com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { p.e.this });
                }
              }
              for (;;)
              {
                p.e.this.hmO.onSceneEnd(0, 0, "", p.e.this);
                p.a(p.this, p.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label409:
                p.a(p.this, p.e.this.scene, p.e.this.hkT);
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.e.vIY.f(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + p.azy() });
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 43L, 1L, false);
          this.hmO.onSceneEnd(paramInt2, paramInt3, paramString, this);
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
    long hdo;
    int hkU;
    btk hmH;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.CqZ)
      {
        this.hmH = p.this;
        this.hdo = paramLong;
        this.hkU = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<p.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.hmH == null)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 40L, 1L, false);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == com.tencent.mm.platformtools.ab.hVC)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new p.a(p.this, this, true, this.hmH, new p.b()
      {
        public final boolean ow(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { p.f.this, p.f.this.hmH, Integer.valueOf(p.f.this.hkU), Long.valueOf(p.f.this.hdo) });
          if ((p.f.this.hkU & 0x1) > 0)
          {
            com.tencent.mm.kernel.g.afC();
            byte[] arrayOfByte = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null)));
            com.tencent.mm.kernel.g.aeS().a(new g(p.f.this.hdo, arrayOfByte), 0);
          }
          p.a(p.this, p.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      com.tencent.mm.kernel.g.afE().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132601);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { p.f.this, Integer.valueOf(p.f.this.hmH.CNq) });
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(p.f.this.hmH.CNq));
          if ((p.f.this.hmH.CNq & 0x100) != 0)
          {
            tz localtz = new tz();
            localtz.dzp.sourceType = 2;
            com.tencent.mm.sdk.b.a.ESL.l(localtz);
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 22L, 1L, false);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { p.f.this });
          }
          AppMethodBeat.o(132601);
        }
      }, 100L);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 21L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */