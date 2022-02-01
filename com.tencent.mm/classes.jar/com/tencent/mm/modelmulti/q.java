package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
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
  private static Boolean jee = null;
  public o.a appForegroundListener;
  private WakerLock glE;
  public Queue<c> jef;
  public Queue<c> jeg;
  private HashMap<c, Long> jeh;
  public c jei;
  private long jej;
  
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
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!a.azj()) {
            q.this.tE(3);
          }
        }
        AppMethodBeat.o(132586);
      }
    };
    this.jef = new LinkedList();
    this.jeg = new LinkedList();
    this.jeh = new HashMap();
    this.jei = null;
    this.jej = 0L;
    this.glE = null;
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void Pm(String paramString)
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
    //   24: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   33: aastore
    //   34: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 118	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 124	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   52: ldc 103
    //   54: new 8	com/tencent/mm/modelmulti/q$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 125	com/tencent/mm/modelmulti/q$2:<init>	(Lcom/tencent/mm/modelmulti/q;)V
    //   62: invokespecial 128	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 134
    //   80: iload_2
    //   81: invokestatic 138	com/tencent/mm/modelmulti/q:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 144	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
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
    if (l.bdN())
    {
      Log.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(132614);
      return;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
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
  
  private static boolean aSG()
  {
    AppMethodBeat.i(132606);
    if ((a.azj()) || (!com.tencent.mm.kernel.g.aAc()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (jee != null)
    {
      boolean bool = jee.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    jee = Boolean.TRUE;
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
    Log.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(132607);
  }
  
  private static boolean bdM()
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
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 45L, 1L, false);
      Log.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, Util.stackTraceToString(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void bdU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 486
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 488
    //   35: astore_1
    //   36: ldc 103
    //   38: ldc_w 490
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 144	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   54: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 486
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 132	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 95	com/tencent/mm/modelmulti/q:glE	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 496	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 486
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
  
  private int n(int paramInt1, int paramInt2, boolean paramBoolean)
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
    boolean bool = aSG();
    Log.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new wf();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new oy();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new xd();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x1000000 & paramLong) != 0L)
    {
      localObject = new id();
      EventCenter.instance.publish((IEvent)localObject);
    }
    if ((0x20 & paramLong) != 0L)
    {
      localObject = new at();
      EventCenter.instance.publish((IEvent)localObject);
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.g.aAc())
      {
        com.tencent.mm.kernel.g.aAi();
        i = j;
        if (com.tencent.mm.kernel.g.aAh().azQ() != null)
        {
          Log.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label429;
          }
          localObject = new k(paramInt);
          paramInt = localObject.hashCode();
          Log.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.aAi();
          i = paramInt;
          if (!com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0)) {
            Log.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label429:
    for (i = 0;; i = n(paramInt, 7, false))
    {
      if (!Util.isNullOrNil(paramString))
      {
        localObject = new ar();
        ((ar)localObject).dDD.type = 3;
        ((ar)localObject).dDD.event = paramString;
        EventCenter.instance.publish((IEvent)localObject);
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = aSG();
    Log.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(new k(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int tE(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = aSG();
    Log.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Util.getStack() });
    if (!bool)
    {
      k localk = new k(paramInt);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(localk, 0);
      paramInt = localk.hashCode();
      AppMethodBeat.o(132610);
      return paramInt;
    }
    paramInt = n(paramInt, 7, false);
    AppMethodBeat.o(132610);
    return paramInt;
  }
  
  final class a
  {
    int jcB;
    boolean jen;
    cts jeo;
    q.b jep;
    q.c jeq;
    MTimerHandler jer;
    
    private a(q.c paramc, boolean paramBoolean, cts paramcts, q.b paramb)
    {
      AppMethodBeat.i(132591);
      this.jcB = 0;
      this.jen = false;
      this.jeo = null;
      this.jep = null;
      this.jer = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.g.aAc()) && (!a.azj()))
          {
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAh() != null)
            {
              com.tencent.mm.kernel.g.aAi();
              if (com.tencent.mm.kernel.g.aAh().azQ() != null) {
                break label118;
              }
            }
          }
          Object localObject = q.a.this.jeq;
          boolean bool1 = com.tencent.mm.kernel.g.aAc();
          boolean bool2 = a.azj();
          com.tencent.mm.kernel.g.aAi();
          Log.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.aAh() });
          q.a.this.jep.tF(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = q.a.this.jeo.Ley.oTA;
          c localc = new c();
          localc.dz(q.a.this.jeq);
          long l1 = Util.nowMilliSecond();
          long l2;
          do
          {
            if (q.a.this.jcB >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((abn)((LinkedList)localObject).get(q.a.this.jcB), false)) {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 46L, 1L, false);
            }
            q.a locala = q.a.this;
            locala.jcB += 1;
            l2 = Util.milliSecondsToNow(l1);
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { q.a.this.jeq, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.jcB - 1) });
          } while (l2 < 500L);
          localc.dA(q.a.this.jeq);
          if (q.a.this.jcB < ((LinkedList)localObject).size())
          {
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { q.a.this.jeq, Long.valueOf(Util.milliSecondsToNow(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(q.a.this.jcB - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          q.a(q.a.this.jen, q.a.this.jeo, q.a.this.jeq);
          q.a.this.jep.tF(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.jep = paramb;
      this.jeq = paramc;
      this.jen = paramBoolean;
      this.jeo = paramcts;
      this.jcB = 0;
      if ((this.jep != null) && (this.jeq != null)) {}
      for (boolean bool = true;; bool = false)
      {
        q.S("", bool);
        if (this.jeo != null) {
          break;
        }
        q.S("resp Not null", false);
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.jeq });
        this.jep.tF(0);
        AppMethodBeat.o(132591);
        return;
      }
      if ((com.tencent.mm.kernel.g.aAc()) && (!a.azj()))
      {
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAh() != null)
        {
          com.tencent.mm.kernel.g.aAi();
          if (com.tencent.mm.kernel.g.aAh().azQ() != null) {
            break label271;
          }
        }
      }
      this$1 = this.jeq;
      paramBoolean = com.tencent.mm.kernel.g.aAc();
      bool = a.azj();
      com.tencent.mm.kernel.g.aAi();
      Log.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { q.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.g.aAh() });
      this.jep.tF(0);
      AppMethodBeat.o(132591);
      return;
      label271:
      q.a(paramcts);
      long l2 = paramcts.Mzc;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      Log.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.ObP, Long.valueOf(l3));
      cl.Af(l1);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf().cU(this.jeo.oTW, this.jeo.Mzb);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      a.qc(this.jeo.oTW);
      if ((this.jeo.Ley == null) || (this.jeo.Ley.oTA == null) || (this.jeo.Ley.oTA.size() <= 0))
      {
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.jeq });
        q.a(paramBoolean, this.jeo, this.jeq);
        this.jep.tF(0);
        AppMethodBeat.o(132591);
        return;
      }
      Log.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.jeq, Integer.valueOf(this.jeo.Ley.oTA.size()), Integer.valueOf(this.jeo.oTW), Integer.valueOf(this.jeo.Mzb) });
      this.jer.startTimer(50L);
      AppMethodBeat.o(132591);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean tF(int paramInt);
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
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      Object localObject = com.tencent.mm.booter.g.a(paramQueue, a.getUin());
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
        localObject = localb.KAh;
        paramQueue = (Queue<q.c>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 38L, 1L, false);
          Log.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.booter.g.cq(i, a.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          Log.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.booter.g.cq(i, a.getUin());
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 20L, 1L, false);
        new q.a(q.this, this, true, paramQueue, new q.b()
        {
          public final boolean tF(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { q.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAf();
            com.tencent.mm.booter.g.cq(paramAnonymousInt, a.getUin());
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
    extends com.tencent.mm.ak.q
    implements q.c, m
  {
    int dML;
    private s iMO;
    i jeu;
    boolean jev;
    private boolean jew = false;
    int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.dML = paramInt2;
      this.jev = paramBoolean;
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.dML;
      boolean bool1 = this.jev;
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
        this.dML |= ((e)localObject).dML;
        if (((e)localObject).scene != 3) {
          break label239;
        }
        bool3 = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).dML), Boolean.valueOf(((e)localObject).jev), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label239:
        bool3 = bool1;
        if (((e)localObject).jev)
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
        if ((com.tencent.mm.kernel.g.aAc()) && (!a.azj()))
        {
          com.tencent.mm.kernel.g.aAi();
          if (com.tencent.mm.kernel.g.aAh() != null)
          {
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAh().azQ() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.g.aAc();
        bool2 = a.azj();
        com.tencent.mm.kernel.g.aAi();
        Log.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.g.aAh() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.g.aAi();
      long l = Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(0L));
        this.dML = ((int)(this.dML | l));
        this.dML &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label826;
        }
        this.dML |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.jev) {
          this.scene = 6;
        }
        this.iMO = new k.a();
        paramQueue = ((v.a)this.iMO.getReqObj()).KAg;
        paramQueue.Mza = i;
        paramQueue.Leu = this.dML;
        paramQueue.Scene = this.scene;
        com.tencent.mm.kernel.g.aAi();
        localObject = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, ""));
        paramQueue.Lev = z.aC(Util.decodeHexString((String)localObject));
        paramQueue.MyZ = new abo();
        paramQueue.KLO = d.ics;
        Log.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.Mza), Integer.valueOf(paramQueue.Leu), Integer.valueOf(this.scene), paramQueue.KLO });
        Log.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.cK(Util.decodeHexString((String)localObject)) });
        q.a(this);
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAg().hqi.a(this, 0)) {
          break label884;
        }
        com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + CrashReportFactory.foreground + ";" + q.bdV() });
        Log.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label826:
        if (this.scene == 1011)
        {
          this.dML |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.dML |= 0x40000;
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
      this.jeu = parami;
      int i = dispatch(paramg, this.iMO, this);
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
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 44L, 1L, false);
        if (params == null) {}
        for (paramInt1 = -2;; paramInt1 = params.getType())
        {
          Log.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.jew)
      {
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.jew = true;
      if (params == this.iMO)
      {
        bool1 = true;
        q.S("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label479;
        }
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, params });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label345;
        }
        Log.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 42L, 1L, false);
      }
      label345:
      label479:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((v.b)params.getRespObj()).KAh;
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.aAk().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new q.a(q.this, this, bool1, paramString, new q.b()
          {
            public final boolean tF(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(paramString.KZh));
              boolean bool;
              if ((paramString.KZh & q.e.this.dML) != 0)
              {
                bool = true;
                Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { q.e.this, Integer.valueOf(paramString.KZh), Boolean.valueOf(bool), Integer.valueOf(paramString.KZh & 0x100), Integer.valueOf(paramString.KZh & 0x80), Integer.valueOf(q.e.this.dML) });
                Object localObject;
                if (!bool)
                {
                  localObject = new c();
                  q.e locale = q.e.this;
                  if (((c)localObject).JSf != null) {
                    ((c)localObject).JSf.dC(locale);
                  }
                }
                if ((!bool) && ((paramString.KZh & 0x100) != 0))
                {
                  localObject = new wf();
                  ((wf)localObject).ecp.sourceType = 3;
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.KZh & 0x200000) != 0))
                {
                  localObject = new oy();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.KZh & 0x80) != 0))
                {
                  localObject = new xd();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.KZh & 0x1000000) != 0))
                {
                  localObject = new id();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if ((!bool) && ((paramString.KZh & 0x20) != 0))
                {
                  localObject = new at();
                  EventCenter.instance.publish((IEvent)localObject);
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!q.e.this.jev)) {
                    break label442;
                  }
                  Log.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { q.e.this });
                }
              }
              for (;;)
              {
                q.e.this.jeu.onSceneEnd(0, 0, "", q.e.this);
                q.a(q.this, q.e.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label442:
                q.a(q.this, q.e.this.scene, q.e.this.dML);
              }
            }
          }, (byte)0);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + CrashReportFactory.foreground + ";" + q.bdV() });
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 43L, 1L, false);
          this.jeu.onSceneEnd(paramInt2, paramInt3, paramString, this);
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
    long iUm;
    int jce;
    cts jeo;
    
    public f(v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.KAh)
      {
        this.jeo = q.this;
        this.iUm = paramLong;
        this.jce = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean c(Queue<q.c> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.jeo == null)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 40L, 1L, false);
        Log.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == ac.jOC)
      {
        Log.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      new q.a(q.this, this, true, this.jeo, new q.b()
      {
        public final boolean tF(int paramAnonymousInt)
        {
          AppMethodBeat.i(132600);
          Log.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { q.f.this, q.f.this.jeo, Integer.valueOf(q.f.this.jce), Long.valueOf(q.f.this.iUm) });
          if ((q.f.this.jce & 0x1) > 0)
          {
            com.tencent.mm.kernel.g.aAi();
            byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null)));
            com.tencent.mm.kernel.g.azz().a(new g(q.f.this.iUm, arrayOfByte), 0);
          }
          q.a(q.this, q.f.this);
          AppMethodBeat.o(132600);
          return true;
        }
      }, (byte)0);
      com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132601);
          Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { q.f.this, Integer.valueOf(q.f.this.jeo.KZh) });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(q.f.this.jeo.KZh));
          if ((q.f.this.jeo.KZh & 0x100) != 0)
          {
            wf localwf = new wf();
            localwf.ecp.sourceType = 2;
            EventCenter.instance.publish(localwf);
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 22L, 1L, false);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { q.f.this });
          }
          AppMethodBeat.o(132601);
        }
      }, 100L);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 21L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q
 * JD-Core Version:    0.7.0.1
 */