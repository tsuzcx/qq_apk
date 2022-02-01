package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.av;
import com.tencent.mm.f.a.is;
import com.tencent.mm.f.a.pv;
import com.tencent.mm.f.a.xk;
import com.tencent.mm.f.a.yk;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private static Boolean lUD = null;
  public o.a appForegroundListener;
  private WakerLock iPM;
  public Queue<c> lUE;
  public Queue<c> lUF;
  private HashMap<c, Long> lUG;
  public c lUH;
  private long lUI;
  
  public q()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(132586);
        Log.i("MicroMsg.SyncService", "SyncService onAppForeground %s", new Object[] { paramAnonymousString });
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            q.this.wE(3);
          }
        }
        AppMethodBeat.o(132586);
      }
    };
    this.lUE = new LinkedList();
    this.lUF = new LinkedList();
    this.lUG = new HashMap();
    this.lUH = null;
    this.lUI = 0L;
    this.iPM = null;
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void WJ(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 107
    //   6: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 109
    //   11: ldc 111
    //   13: iconst_3
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   33: aastore
    //   34: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 124	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 130	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   52: ldc 109
    //   54: new 8	com/tencent/mm/modelmulti/q$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 131	com/tencent/mm/modelmulti/q$2:<init>	(Lcom/tencent/mm/modelmulti/q;)V
    //   62: invokespecial 134	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 138	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 140
    //   80: iload_2
    //   81: invokestatic 104	com/tencent/mm/modelmulti/q:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 146	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   94: ldc2_w 147
    //   97: aload_1
    //   98: invokevirtual 151	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   101: ldc 107
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
    if (l.bni())
    {
      Log.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    h.aHJ().postToWorker(new Runnable()
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
  
  private static void assertTrue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132607);
    if (paramBoolean)
    {
      AppMethodBeat.o(132607);
      return;
    }
    Log.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(132607);
  }
  
  private static boolean bbF()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.b.aGE()) || (!h.aHB()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (lUD != null)
    {
      boolean bool = lUD.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    lUD = Boolean.TRUE;
    AppMethodBeat.o(132606);
    return true;
  }
  
  private static boolean bnh()
  {
    AppMethodBeat.i(132615);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)MMApplicationContext.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132615);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 45L, 1L, false);
      Log.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, Util.stackTraceToString(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void bnp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 483
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 138	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 485
    //   35: astore_1
    //   36: ldc 109
    //   38: ldc_w 487
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 146	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   54: invokestatic 319	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 483
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 138	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 319	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 95	com/tencent/mm/modelmulti/q:iPM	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 493	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 483
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
  
  private int o(int paramInt1, int paramInt2, boolean paramBoolean)
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
    boolean bool = bbF();
    Log.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new xk();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new pv();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new yk();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new is();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x20 & paramLong) != 0L)
    {
      localObject = new av();
      EventCenter.instance.publish((IEvent)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (h.aHB())
      {
        h.aHH();
        i = j;
        if (h.aHG().aHp() != null)
        {
          Log.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          h.aHH();
          h.aHG().aHp().i(8196, Long.valueOf(paramLong));
          if (bool) {
            break label429;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          Log.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          h.aHH();
          i = paramInt;
          if (!h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0)) {
            Log.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label429:
    for (i = 0;; i = o(paramInt, 7, false))
    {
      if (!Util.isNullOrNil(paramString))
      {
        localObject = new at();
        ((at)localObject).fwm.type = 3;
        ((at)localObject).fwm.event = paramString;
        EventCenter.instance.publish((IEvent)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = bbF();
    Log.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      h.aHH();
      h.aHF().kcd.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int wE(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = bbF();
    Log.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Util.getStack() });
    if (!bool)
    {
      k localk = new k(paramInt);
      h.aHH();
      h.aHF().kcd.a(localk, 0);
      paramInt = localk.hashCode();
      AppMethodBeat.o(132610);
      return paramInt;
    }
    paramInt = o(paramInt, 7, false);
    AppMethodBeat.o(132610);
    return paramInt;
  }
  
  final class a
  {
    int lTa;
    boolean lUM;
    dcr lUN;
    q.b lUO;
    q.c lUP;
    MTimerHandler lUQ;
    
    private a(q.c paramc, boolean paramBoolean, dcr paramdcr, q.b paramb)
    {
      AppMethodBeat.i(132591);
      this.lTa = 0;
      this.lUM = false;
      this.lUN = null;
      this.lUO = null;
      this.lUQ = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((h.aHB()) && (!com.tencent.mm.kernel.b.aGE()))
          {
            h.aHH();
            if (h.aHG() != null)
            {
              h.aHH();
              if (h.aHG().aHp() != null) {
                break label118;
              }
            }
          }
          Object localObject = q.a.this.lUP;
          boolean bool1 = h.aHB();
          boolean bool2 = com.tencent.mm.kernel.b.aGE();
          h.aHH();
          Log.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), h.aHG() });
          q.a.this.lUO.wF(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = q.a.this.lUN.SfL.rVy;
          com.tencent.mm.plugin.zero.c localc = new com.tencent.mm.plugin.zero.c();
          localc.dC(q.a.this.lUP);
          long l1 = Util.nowMilliSecond();
          long l2;
          do
          {
            if (q.a.this.lTa >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((abu)((LinkedList)localObject).get(q.a.this.lTa), false)) {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 46L, 1L, false);
            }
            q.a locala = q.a.this;
            locala.lTa += 1;
            l2 = Util.milliSecondsToNow(l1);
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { q.a.this.lUP, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.lTa - 1) });
          } while (l2 < 500L);
          localc.dD(q.a.this.lUP);
          if (q.a.this.lTa < ((LinkedList)localObject).size())
          {
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { q.a.this.lUP, Long.valueOf(Util.milliSecondsToNow(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.lTa - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          q.a(q.a.this.lUM, q.a.this.lUN, q.a.this.lUP);
          q.a.this.lUO.wF(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.lUO = paramb;
      this.lUP = paramc;
      this.lUM = paramBoolean;
      this.lUN = paramdcr;
      this.lTa = 0;
      if ((this.lUO != null) && (this.lUP != null)) {}
      for (boolean bool = true;; bool = false)
      {
        q.U("", bool);
        if (this.lUN != null) {
          break;
        }
        q.U("resp Not null", false);
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.lUP });
        this.lUO.wF(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((h.aHB()) && (!com.tencent.mm.kernel.b.aGE()))
      {
        h.aHH();
        if (h.aHG() != null)
        {
          h.aHH();
          if (h.aHG().aHp() != null) {
            break label271;
          }
        }
      }
      this$1 = this.lUP;
      paramBoolean = h.aHB();
      bool = com.tencent.mm.kernel.b.aGE();
      h.aHH();
      Log.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { q.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), h.aHG() });
      this.lUO.wF(0);
      AppMethodBeat.o(132591);
      return;
      label271:
      q.a(paramdcr);
      long l2 = paramdcr.TKD;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      Log.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      h.aHH();
      h.aHG().aHp().set(ar.a.VpS, Long.valueOf(l3));
      cm.Gm(l1);
      h.aHH();
      h.aHE().dp(this.lUN.rVU, this.lUN.TKC);
      h.aHH();
      h.aHE();
      com.tencent.mm.kernel.b.sB(this.lUN.rVU);
      if ((this.lUN.SfL == null) || (this.lUN.SfL.rVy == null) || (this.lUN.SfL.rVy.size() <= 0))
      {
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.lUP });
        q.a(paramBoolean, this.lUN, this.lUP);
        this.lUO.wF(0);
        AppMethodBeat.o(132591);
        return;
      }
      Log.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.lUP, Integer.valueOf(this.lUN.SfL.rVy.size()), Integer.valueOf(this.lUN.rVU), Integer.valueOf(this.lUN.TKC) });
      this.lUQ.startTimer(50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean wF(int paramInt);
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
      h.aHH();
      h.aHE();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, com.tencent.mm.kernel.b.getUin());
      int j = paramQueue.value;
      if (localObject != null) {}
      for (final int i = localObject.length;; i = -1)
      {
        Log.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((paramQueue.value != 0) && (!Util.isNullOrNil((byte[])localObject))) {
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
        localObject = localb.RBX;
        paramQueue = (Queue<q.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 38L, 1L, false);
          Log.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          h.aHH();
          h.aHE();
          com.tencent.mm.booter.g.cI(i, com.tencent.mm.kernel.b.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          Log.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          h.aHH();
          h.aHE();
          com.tencent.mm.booter.g.cI(i, com.tencent.mm.kernel.b.getUin());
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 20L, 1L, false);
        new q.a(q.this, this, true, paramQueue, new q.b()
        {
          public final boolean wF(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { q.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            h.aHH();
            h.aHE();
            com.tencent.mm.booter.g.cI(paramAnonymousInt, com.tencent.mm.kernel.b.getUin());
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
    extends com.tencent.mm.an.q
    implements q.c, m
  {
    private int fFT;
    private s lCW;
    private i lUT;
    private boolean lUU;
    private boolean lUV = false;
    private int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.fFT = paramInt2;
      this.lUU = paramBoolean;
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.fFT;
      boolean bool1 = this.lUU;
      Object localObject;
      boolean bool2;
      label85:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        Log.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
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
        this.fFT |= ((e)localObject).fFT;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).fFT), Boolean.valueOf(((e)localObject).lUU), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).lUU)
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
        if ((h.aHB()) && (!com.tencent.mm.kernel.b.aGE()))
        {
          h.aHH();
          if (h.aHG() != null)
          {
            h.aHH();
            if (h.aHG().aHp() != null) {
              break;
            }
          }
        }
        bool1 = h.aHB();
        bool2 = com.tencent.mm.kernel.b.aGE();
        h.aHH();
        Log.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), h.aHG() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      h.aHH();
      long l = Util.nullAs((Long)h.aHG().aHp().b(8196, null), 0L);
      if (l != 0L)
      {
        h.aHH();
        h.aHG().aHp().i(8196, Long.valueOf(0L));
        this.fFT = ((int)(this.fFT | l));
        this.fFT &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label826;
        }
        this.fFT |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.lUU) {
          this.scene = 6;
        }
        this.lCW = new k.a();
        paramQueue = ((v.a)this.lCW.getReqObj()).RBW;
        paramQueue.TKB = i;
        paramQueue.SfH = this.fFT;
        paramQueue.CPw = this.scene;
        h.aHH();
        localObject = Util.nullAsNil((String)h.aHG().aHp().b(8195, ""));
        paramQueue.SfI = z.aN(Util.decodeHexString((String)localObject));
        paramQueue.TKA = new abv();
        paramQueue.RMK = d.kQZ;
        Log.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.TKB), Integer.valueOf(paramQueue.SfH), Integer.valueOf(this.scene), paramQueue.RMK });
        Log.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.db(Util.decodeHexString((String)localObject)) });
        q.a(this);
        h.aHH();
        if (h.aHF().kcd.a(this, 0)) {
          break label884;
        }
        com.tencent.mm.plugin.report.f.Iyx.a(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + CrashReportFactory.foreground + ";" + q.bnq() });
        Log.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label826:
        if (this.scene == 1011)
        {
          this.fFT |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.fFT |= 0x40000;
          this.scene = 3;
        }
      }
      label884:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.g paramg, i parami)
    {
      AppMethodBeat.i(132598);
      this.lUT = parami;
      int i = dispatch(paramg, this.lCW, this);
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
    
    public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132599);
      if ((params == null) || (params.getType() != 138))
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 44L, 1L, false);
        if (params == null) {}
        for (paramInt1 = -2;; paramInt1 = params.getType())
        {
          Log.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.lUV)
      {
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.lUV = true;
      if (params == this.lCW)
      {
        bool1 = true;
        q.U("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label479;
        }
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, params });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        Log.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label479:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)params.getRespObj()).RBX;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = h.aHJ().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new q.a(q.this, this, bool1, paramString, new q.b()
          {
            public final boolean wF(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              h.aHH();
              h.aHG().aHp().i(8196, Long.valueOf(paramString.Saq));
              boolean bool;
              if ((paramString.Saq & q.e.b(q.e.this)) != 0)
              {
                bool = true;
                Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { q.e.this, Integer.valueOf(paramString.Saq), Boolean.valueOf(bool), Integer.valueOf(paramString.Saq & 0x100), Integer.valueOf(paramString.Saq & 0x80), Integer.valueOf(q.e.b(q.e.this)) });
                if (!bool) {
                  new com.tencent.mm.plugin.zero.c().dF(q.e.this);
                }
                Object localObject;
                if ((!bool) && ((paramString.Saq & 0x100) != 0))
                {
                  localObject = new xk();
                  ((xk)localObject).fWr.sourceType = 3;
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.Saq & 0x200000) != 0))
                {
                  localObject = new pv();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.Saq & 0x80) != 0))
                {
                  localObject = new yk();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.Saq & 0x1000000) != 0))
                {
                  localObject = new is();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.Saq & 0x20) != 0))
                {
                  localObject = new av();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!q.e.c(q.e.this))) {
                    break label424;
                  }
                  Log.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { q.e.this });
                }
              }
              for (;;)
              {
                q.e.e(q.e.this).onSceneEnd(0, 0, "", q.e.this);
                q.a(q.this, q.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label424:
                q.a(q.this, q.e.d(q.e.this), q.e.b(q.e.this));
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.f.Iyx.a(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + CrashReportFactory.foreground + ";" + q.bnq() });
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 43L, 1L, false);
          this.lUT.onSceneEnd(paramInt2, paramInt3, paramString, this);
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
    long lKF;
    int lSE;
    dcr lUN;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.RBX)
      {
        this.lUN = q.this;
        this.lKF = paramLong;
        this.lSE = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.lUN == null)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 40L, 1L, false);
        Log.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == ac.mFM)
      {
        Log.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new q.a(q.this, this, true, this.lUN, new q.b()
      {
        public final boolean wF(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          Log.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { q.f.this, q.f.this.lUN, Integer.valueOf(q.f.this.lSE), Long.valueOf(q.f.this.lKF) });
          if ((q.f.this.lSE & 0x1) > 0)
          {
            h.aHH();
            byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)h.aHG().aHp().b(8195, null)));
            h.aGY().a(new g(q.f.this.lKF, arrayOfByte), 0);
          }
          q.a(q.this, q.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      h.aHJ().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132601);
          Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { q.f.this, Integer.valueOf(q.f.this.lUN.Saq) });
          h.aHH();
          h.aHG().aHp().i(8196, Long.valueOf(q.f.this.lUN.Saq));
          if ((q.f.this.lUN.Saq & 0x100) != 0)
          {
            xk localxk = new xk();
            localxk.fWr.sourceType = 2;
            EventCenter.instance.publish(localxk);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 22L, 1L, false);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { q.f.this });
          }
          AppMethodBeat.o(132601);
        }
      }, 100L);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 21L, 1L, false);
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
 * Qualified Name:     com.tencent.mm.modelmulti.q
 * JD-Core Version:    0.7.0.1
 */