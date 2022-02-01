package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.aad;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.ba;
import com.tencent.mm.autogen.a.jo;
import com.tencent.mm.autogen.a.ri;
import com.tencent.mm.autogen.a.zd;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.fla;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue<Lcom.tencent.mm.modelmulti.e;>;
import java.util.Set;
import junit.framework.Assert;

public final class v
{
  private static Boolean oNw = null;
  public q.a appForegroundListener;
  private WakerLock lrH;
  public e oNA;
  private long oNB;
  private final d oNC;
  private final w oND;
  public Queue<e> oNx;
  public Queue<e> oNy;
  private HashMap<Integer, Long> oNz;
  
  public v()
  {
    AppMethodBeat.i(132605);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(132586);
        Log.i("MicroMsg.SyncService", "SyncService onAppForeground %s", new Object[] { paramAnonymousString });
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            v.this.wG(3);
          }
        }
        AppMethodBeat.o(132586);
      }
    };
    this.oNx = new LinkedList();
    this.oNy = new LinkedList();
    this.oNz = new HashMap();
    this.oNA = null;
    this.oNB = 0L;
    this.lrH = null;
    this.oNC = new d()
    {
      public final void a(fla paramAnonymousfla, b paramAnonymousb)
      {
        AppMethodBeat.i(243120);
        Log.i("MicroMsg.SyncService", "onContinueSync continueSyncScene:%s syncDataId:%s", new Object[] { paramAnonymousb, paramAnonymousfla.hIQ });
        com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new v.5..ExternalSyntheticLambda0(this, paramAnonymousfla, paramAnonymousb), 50L);
        AppMethodBeat.o(243120);
      }
      
      public final void a(fla paramAnonymousfla, e paramAnonymouse)
      {
        AppMethodBeat.i(243118);
        if (paramAnonymousfla.dataType == 0)
        {
          if (paramAnonymouse == null)
          {
            paramAnonymousfla = new f(paramAnonymousfla);
            Log.i("MicroMsg.SyncService", "onSceneCallback netscene is null, use:%s", new Object[] { paramAnonymousfla.toString() });
            com.tencent.mm.kernel.h.aZW().onSceneEnd(0, 0, "", paramAnonymousfla);
            AppMethodBeat.o(243118);
            return;
          }
          paramAnonymousfla = (com.tencent.mm.am.p)paramAnonymouse;
          Log.i("MicroMsg.SyncService", "onSceneCallback netscene is %s", new Object[] { Integer.valueOf(paramAnonymousfla.hashCode()) });
          com.tencent.mm.kernel.h.aZW().onSceneEnd(0, 0, "", paramAnonymousfla);
        }
        AppMethodBeat.o(243118);
      }
    };
    this.oND = new w(this.oNC);
    AppMethodBeat.o(132605);
  }
  
  /* Error */
  private void OI(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 111
    //   6: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 113
    //   11: ldc 115
    //   13: iconst_3
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: invokestatic 121	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   33: aastore
    //   34: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   41: ifnonnull +27 -> 68
    //   44: aload_0
    //   45: new 128	com/tencent/mars/comm/WakerLock
    //   48: dup
    //   49: invokestatic 134	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   52: ldc 113
    //   54: new 8	com/tencent/mm/modelmulti/v$2
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 135	com/tencent/mm/modelmulti/v$2:<init>	(Lcom/tencent/mm/modelmulti/v;)V
    //   62: invokespecial 138	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   65: putfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   68: aload_0
    //   69: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   72: invokevirtual 142	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   75: ifne +34 -> 109
    //   78: ldc 144
    //   80: iload_2
    //   81: invokestatic 148	com/tencent/mm/modelmulti/v:assertTrue	(Ljava/lang/String;Z)V
    //   84: getstatic 154	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   87: ifne +14 -> 101
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   94: ldc2_w 155
    //   97: aload_1
    //   98: invokevirtual 159	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   101: ldc 111
    //   103: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	119	0	this	v
    //   0	119	1	paramString	String
    //   1	110	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	68	114	finally
    //   68	78	114	finally
    //   78	101	114	finally
    //   101	106	114	finally
  }
  
  private void a(final e parame)
  {
    AppMethodBeat.i(243134);
    if (q.bKT())
    {
      Log.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { parame });
      AppMethodBeat.o(243134);
      return;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132588);
        if (parame != null)
        {
          if (!(parame instanceof v.d)) {
            break label53;
          }
          v.b(v.this).add(parame);
        }
        for (;;)
        {
          v.a(v.this, null);
          AppMethodBeat.o(132588);
          return;
          label53:
          v.c(v.this).add(parame);
        }
      }
    });
    AppMethodBeat.o(243134);
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
  
  private static boolean bKS()
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 45L, 1L, false);
      Log.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, Util.stackTraceToString(localException) });
      AppMethodBeat.o(132615);
    }
    return true;
  }
  
  /* Error */
  private void bLa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 479
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 142	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +61 -> 83
    //   25: aload_0
    //   26: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +40 -> 69
    //   32: ldc 243
    //   34: astore_1
    //   35: ldc 113
    //   37: ldc_w 481
    //   40: iconst_2
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: getstatic 154	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   53: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: invokestatic 484	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: ldc_w 479
    //   63: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_0
    //   70: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   73: invokevirtual 142	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   76: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   79: astore_1
    //   80: goto -45 -> 35
    //   83: aload_0
    //   84: getfield 95	com/tencent/mm/modelmulti/v:lrH	Lcom/tencent/mars/comm/WakerLock;
    //   87: invokevirtual 487	com/tencent/mars/comm/WakerLock:unLock	()V
    //   90: ldc_w 479
    //   93: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -30 -> 66
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	v
    //   34	46	1	localObject1	Object
    //   99	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	99	finally
    //   25	32	99	finally
    //   35	66	99	finally
    //   69	80	99	finally
    //   83	96	99	finally
  }
  
  private static boolean bzt()
  {
    AppMethodBeat.i(132606);
    if ((com.tencent.mm.kernel.b.aZG()) || (!com.tencent.mm.kernel.h.baz()))
    {
      AppMethodBeat.o(132606);
      return false;
    }
    if (oNw != null)
    {
      boolean bool = oNw.booleanValue();
      AppMethodBeat.o(132606);
      return bool;
    }
    oNw = Boolean.TRUE;
    AppMethodBeat.o(132606);
    return true;
  }
  
  private int o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132611);
    c localc = new c(paramInt1, paramInt2, paramBoolean);
    a(localc);
    paramInt1 = localc.hashCode();
    AppMethodBeat.o(132611);
    return paramInt1;
  }
  
  public final int a(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(132608);
    boolean bool = bzt();
    Log.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    if ((0x100 & paramLong) != 0L) {
      new zd().publish();
    }
    if ((0x200000 & paramLong) != 0L) {
      new ri().publish();
    }
    if ((0x80 & paramLong) != 0L) {
      new aad().publish();
    }
    if ((0x1000000 & paramLong) != 0L) {
      new jo().publish();
    }
    if ((0x20 & paramLong) != 0L) {
      new ba().publish();
    }
    paramLong = 0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x5F;
    int i = j;
    Object localObject;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.h.baz())
      {
        com.tencent.mm.kernel.h.baF();
        i = j;
        if (com.tencent.mm.kernel.h.baE().ban() != null)
        {
          Log.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(paramLong));
          if (bool) {
            break label391;
          }
          localObject = new p(paramInt);
          paramInt = localObject.hashCode();
          Log.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.h.baF();
          i = paramInt;
          if (!com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0)) {
            Log.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label391:
    for (i = 0;; i = o(paramInt, 7, false))
    {
      if (!Util.isNullOrNil(paramString))
      {
        localObject = new ay();
        ((ay)localObject).hAK.type = 3;
        ((ay)localObject).hAK.event = paramString;
        ((ay)localObject).publish();
      }
      AppMethodBeat.o(132608);
      return i;
    }
  }
  
  public final void a(com.tencent.mm.protocal.v.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(132609);
    boolean bool = bzt();
    Log.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new p(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(132609);
      return;
    }
    a(new d(paramb, paramInt, paramLong));
    AppMethodBeat.o(132609);
  }
  
  public final int wG(int paramInt)
  {
    AppMethodBeat.i(132610);
    boolean bool = bzt();
    Log.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Util.getStack() });
    if (!bool)
    {
      p localp = new p(paramInt);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(localp, 0);
      paramInt = localp.hashCode();
      AppMethodBeat.o(132610);
      return paramInt;
    }
    paramInt = o(paramInt, 7, false);
    AppMethodBeat.o(132610);
    return paramInt;
  }
  
  final class a
  {
    int oLT;
    boolean oNH;
    duk oNI;
    c oNJ;
    e oNK;
    MTimerHandler oNL;
    
    private a(e parame, boolean paramBoolean, duk paramduk, c paramc)
    {
      AppMethodBeat.i(243107);
      this.oLT = 0;
      this.oNH = false;
      this.oNI = null;
      this.oNJ = null;
      this.oNL = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132590);
          if ((com.tencent.mm.kernel.h.baz()) && (!com.tencent.mm.kernel.b.aZG()))
          {
            com.tencent.mm.kernel.h.baF();
            if (com.tencent.mm.kernel.h.baE() != null)
            {
              com.tencent.mm.kernel.h.baF();
              if (com.tencent.mm.kernel.h.baE().ban() != null) {
                break label118;
              }
            }
          }
          Object localObject = v.a.this.oNK;
          boolean bool1 = com.tencent.mm.kernel.h.baz();
          boolean bool2 = com.tencent.mm.kernel.b.aZG();
          com.tencent.mm.kernel.h.baF();
          Log.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.h.baE() });
          v.a.this.oNJ.wC(0);
          AppMethodBeat.o(132590);
          return false;
          label118:
          localObject = v.a.this.oNI.ZdG.vgO;
          com.tencent.mm.plugin.zero.c localc = new com.tencent.mm.plugin.zero.c();
          localc.fT(v.a.this.oNK);
          long l1 = Util.nowMilliSecond();
          long l2;
          do
          {
            if (v.a.this.oLT >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((adw)((LinkedList)localObject).get(v.a.this.oLT), false)) {
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 46L, 1L, false);
            }
            v.a locala = v.a.this;
            locala.oLT += 1;
            l2 = Util.milliSecondsToNow(l1);
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { v.a.this.oNK, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(v.a.this.oLT - 1) });
          } while (l2 < 500L);
          localc.fU(v.a.this.oNK);
          if (v.a.this.oLT < ((LinkedList)localObject).size())
          {
            Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { v.a.this.oNK, Long.valueOf(Util.milliSecondsToNow(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(v.a.this.oLT - 1) });
            AppMethodBeat.o(132590);
            return true;
          }
          v.a(v.a.this.oNH, v.a.this.oNI, v.a.this.oNK);
          v.a.this.oNJ.wC(((LinkedList)localObject).size());
          AppMethodBeat.o(132590);
          return false;
        }
      }, true);
      this.oNJ = paramc;
      this.oNK = parame;
      this.oNH = paramBoolean;
      this.oNI = paramduk;
      this.oLT = 0;
      if ((this.oNJ != null) && (this.oNK != null)) {}
      for (boolean bool = true;; bool = false)
      {
        v.Y("", bool);
        if (this.oNI != null) {
          break;
        }
        v.Y("resp Not null", false);
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.oNK });
        this.oNJ.wC(0);
        AppMethodBeat.o(243107);
        return;
      }
      if ((com.tencent.mm.kernel.h.baz()) && (!com.tencent.mm.kernel.b.aZG()))
      {
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baE() != null)
        {
          com.tencent.mm.kernel.h.baF();
          if (com.tencent.mm.kernel.h.baE().ban() != null) {
            break label271;
          }
        }
      }
      this$1 = this.oNK;
      paramBoolean = com.tencent.mm.kernel.h.baz();
      bool = com.tencent.mm.kernel.b.aZG();
      com.tencent.mm.kernel.h.baF();
      Log.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { v.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.h.baE() });
      this.oNJ.wC(0);
      AppMethodBeat.o(243107);
      return;
      label271:
      v.a(paramduk);
      long l2 = paramduk.abaw;
      long l1 = l2;
      if (String.valueOf(l2).length() == 10) {
        l1 = l2 * 1000L;
      }
      l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      Log.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRu, Long.valueOf(l3));
      cn.iw(l1);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC().ec(this.oNI.vhk, this.oNI.abav);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.kernel.b.sx(this.oNI.vhk);
      if ((this.oNI.ZdG == null) || (this.oNI.ZdG.vgO == null) || (this.oNI.ZdG.vgO.size() <= 0))
      {
        Log.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.oNK });
        v.a(paramBoolean, this.oNI, this.oNK);
        this.oNJ.wC(0);
        AppMethodBeat.o(243107);
        return;
      }
      Log.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.oNK, Integer.valueOf(this.oNI.ZdG.vgO.size()), Integer.valueOf(this.oNI.vhk), Integer.valueOf(this.oNI.abav) });
      this.oNL.startTimer(50L);
      AppMethodBeat.o(243107);
    }
  }
  
  final class b
    implements e
  {
    b() {}
    
    public final boolean d(Queue<e> paramQueue)
    {
      AppMethodBeat.i(132593);
      paramQueue = new PInt();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
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
        com.tencent.mm.protocal.v.b localb = new com.tencent.mm.protocal.v.b();
        localb.fromProtoBuf((byte[])localObject);
        localObject = localb.YyA;
        paramQueue = (Queue<e>)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 38L, 1L, false);
          Log.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", new Object[] { this, Integer.valueOf(i), localException.getMessage() });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.booter.g.dy(i, com.tencent.mm.kernel.b.getUin());
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          Log.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), localError.getMessage() });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.booter.g.dy(i, com.tencent.mm.kernel.b.getUin());
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 20L, 1L, false);
        new v.a(v.this, this, true, paramQueue, new c()
        {
          public final boolean wC(int paramAnonymousInt)
          {
            AppMethodBeat.i(132592);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { v.b.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.booter.g.dy(paramAnonymousInt, com.tencent.mm.kernel.b.getUin());
            v.a(v.this, v.b.this);
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
  
  final class c
    extends com.tencent.mm.am.p
    implements e, m
  {
    private com.tencent.mm.am.h oNO;
    private boolean oNP;
    private boolean oNQ = false;
    private com.tencent.mm.network.s ouH;
    private int scene;
    private int selector;
    
    public c(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.scene = paramInt1;
      this.selector = paramInt2;
      this.oNP = paramBoolean;
    }
    
    public final boolean d(Queue<e> paramQueue)
    {
      AppMethodBeat.i(132596);
      int i = this.scene;
      int j = this.selector;
      boolean bool1 = this.oNP;
      Object localObject;
      boolean bool2;
      label85:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        Log.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
        if (paramQueue == null) {
          break label268;
        }
        v.e(paramQueue);
        bool1 = false;
        bool2 = false;
        if (paramQueue.isEmpty()) {
          break label258;
        }
        localObject = (c)paramQueue.poll();
        this.selector |= ((c)localObject).selector;
        if (((c)localObject).scene != 3) {
          break label236;
        }
        bool3 = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((c)localObject).scene), Integer.valueOf(((c)localObject).selector), Boolean.valueOf(((c)localObject).oNP), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label85;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label236:
        bool3 = bool1;
        if (((c)localObject).oNP)
        {
          bool2 = true;
          bool3 = bool1;
        }
      }
      label258:
      if (bool1) {
        this.scene = 3;
      }
      for (;;)
      {
        label268:
        if ((com.tencent.mm.kernel.h.baz()) && (!com.tencent.mm.kernel.b.aZG()))
        {
          com.tencent.mm.kernel.h.baF();
          if (com.tencent.mm.kernel.h.baE() != null)
          {
            com.tencent.mm.kernel.h.baF();
            if (com.tencent.mm.kernel.h.baE().ban() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.h.baz();
        bool2 = com.tencent.mm.kernel.b.aZG();
        com.tencent.mm.kernel.h.baF();
        Log.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.h.baE() });
        AppMethodBeat.o(132596);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.h.baF();
      long l = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().d(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(0L));
        this.selector = ((int)(this.selector | l));
        this.selector &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label823;
        }
        this.selector |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.oNP) {
          this.scene = 6;
        }
        this.ouH = new p.a();
        paramQueue = ((com.tencent.mm.protocal.v.a)this.ouH.getReqObj()).Yyz;
        paramQueue.abau = i;
        paramQueue.ZdC = this.selector;
        paramQueue.IJG = this.scene;
        com.tencent.mm.kernel.h.baF();
        localObject = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, ""));
        paramQueue.ZdD = com.tencent.mm.platformtools.w.aN(Util.decodeHexString((String)localObject));
        paramQueue.abat = new adx();
        paramQueue.YJY = com.tencent.mm.protocal.d.nsC;
        Log.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.abau), Integer.valueOf(paramQueue.ZdC), Integer.valueOf(this.scene), paramQueue.YJY });
        Log.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.de(Util.decodeHexString((String)localObject)) });
        v.a(this);
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baD().mCm.a(this, 0)) {
          break label881;
        }
        com.tencent.mm.plugin.report.f.Ozc.b(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + CrashReportFactory.foreground + ";" + v.bLc() });
        Log.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 41L, 1L, false);
        AppMethodBeat.o(132596);
        return false;
        i = 0;
        break;
        label823:
        if (this.scene == 1011)
        {
          this.selector |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.selector |= 0x40000;
          this.scene = 3;
        }
      }
      label881:
      AppMethodBeat.o(132596);
      return true;
    }
    
    public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
    {
      AppMethodBeat.i(132598);
      Log.i("MicroMsg.SyncService", "%s doScene", new Object[] { this });
      this.oNO = paramh;
      int i = dispatch(paramg, this.ouH, this);
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
    
    public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, final String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132599);
      Log.i("MicroMsg.SyncService", "onGYNetEnd %s %s %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this });
      if ((params == null) || (params.getType() != 138))
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 44L, 1L, false);
        if (params == null) {}
        for (paramInt1 = -2;; paramInt1 = params.getType())
        {
          Log.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          AppMethodBeat.o(132599);
          return;
        }
      }
      if (this.oNQ)
      {
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        AppMethodBeat.o(132599);
        return;
      }
      this.oNQ = true;
      if (params == this.ouH)
      {
        bool1 = true;
        v.Y("Check rr failed.", bool1);
        if ((paramInt2 == 0) && (paramInt3 == 0)) {
          break label603;
        }
        Log.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, params });
        if ((paramInt2 != 4) || (paramInt3 != -2006)) {
          break label380;
        }
        Log.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 42L, 1L, false);
      }
      label603:
      for (boolean bool1 = false;; bool1 = true)
      {
        paramString = ((com.tencent.mm.protocal.v.b)params.getRespObj()).YyA;
        if (v.bLb())
        {
          params = new fla();
          params.dataType = 0;
          params.scene = this.scene;
          params.oNH = bool1;
          params.abLA = paramString;
          params.oNP = this.oNP;
          params.selector = this.selector;
          v.g(v.this).b(params, this);
          AppMethodBeat.o(132599);
          return;
          bool1 = false;
          break;
          label380:
          com.tencent.mm.plugin.report.f.Ozc.b(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + CrashReportFactory.foreground + ";" + v.bLc() });
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 43L, 1L, false);
          this.oNO.onSceneEnd(paramInt2, paramInt3, paramString, this);
          v.a(v.this, this);
          AppMethodBeat.o(132599);
          return;
        }
        boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
        paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
        paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
        int i = WXHardCoderJNI.hcReceiveMsgIO;
        if (WXHardCoderJNI.hcReceiveMsgThr) {}
        for (paramInt1 = com.tencent.mm.kernel.h.baH().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
          new v.a(v.this, this, bool1, paramString, new c()
          {
            public final boolean wC(int paramAnonymousInt)
            {
              AppMethodBeat.i(132595);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(paramString.YYp));
              boolean bool;
              if ((paramString.YYp & v.c.b(v.c.this)) != 0)
              {
                bool = true;
                Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { v.c.this, Integer.valueOf(paramString.YYp), Boolean.valueOf(bool), Integer.valueOf(paramString.YYp & 0x100), Integer.valueOf(paramString.YYp & 0x80), Integer.valueOf(v.c.b(v.c.this)) });
                if (!bool) {
                  new com.tencent.mm.plugin.zero.c().fW(v.c.this);
                }
                if ((!bool) && ((paramString.YYp & 0x100) != 0))
                {
                  zd localzd = new zd();
                  localzd.icq.sourceType = 3;
                  localzd.publish();
                }
                if ((!bool) && ((paramString.YYp & 0x200000) != 0)) {
                  new ri().publish();
                }
                if ((!bool) && ((paramString.YYp & 0x80) != 0)) {
                  new aad().publish();
                }
                if ((!bool) && ((paramString.YYp & 0x1000000) != 0)) {
                  new jo().publish();
                }
                if ((!bool) && ((paramString.YYp & 0x20) != 0)) {
                  new ba().publish();
                }
                if (bool)
                {
                  if ((paramAnonymousInt != 0) || (!v.c.c(v.c.this))) {
                    break label401;
                  }
                  Log.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { v.c.this });
                }
              }
              for (;;)
              {
                v.c.e(v.c.this).onSceneEnd(0, 0, "", v.c.this);
                v.a(v.this, v.c.this);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, paramInt1);
                AppMethodBeat.o(132595);
                return true;
                bool = false;
                break;
                label401:
                v.a(v.this, v.c.d(v.c.this), v.c.b(v.c.this));
              }
            }
          }, (byte)0);
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
  
  final class d
    implements e
  {
    long oDh;
    int oLx;
    duk oNI;
    
    public d(com.tencent.mm.protocal.v.b paramb, int paramInt, long paramLong)
    {
      AppMethodBeat.i(132602);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.YyA)
      {
        this.oNI = v.this;
        this.oDh = paramLong;
        this.oLx = paramInt;
        AppMethodBeat.o(132602);
        return;
      }
    }
    
    public final boolean d(Queue<e> paramQueue)
    {
      AppMethodBeat.i(132603);
      if (this.oNI == null)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 40L, 1L, false);
        Log.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (10018 == z.pCm)
      {
        Log.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        AppMethodBeat.o(132603);
        return false;
      }
      if (v.bLb())
      {
        paramQueue = new fla();
        paramQueue.dataType = 1;
        paramQueue.oNH = true;
        paramQueue.abLA = this.oNI;
        paramQueue.oLx = this.oLx;
        paramQueue.oDh = this.oDh;
        v.g(v.this).b(paramQueue, this);
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132601);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", new Object[] { v.d.this, Integer.valueOf(v.d.this.oNI.YYp) });
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(v.d.this.oNI.YYp));
            if ((v.d.this.oNI.YYp & 0x100) != 0)
            {
              zd localzd = new zd();
              localzd.icq.sourceType = 2;
              localzd.publish();
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 22L, 1L, false);
              Log.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", new Object[] { v.d.this });
            }
            AppMethodBeat.o(132601);
          }
        }, 100L);
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 21L, 1L, false);
        AppMethodBeat.o(132603);
        return true;
        new v.a(v.this, this, true, this.oNI, new c()
        {
          public final boolean wC(int paramAnonymousInt)
          {
            AppMethodBeat.i(132600);
            Log.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { v.d.this, v.d.this.oNI, Integer.valueOf(v.d.this.oLx), Long.valueOf(v.d.this.oDh) });
            if ((v.d.this.oLx & 0x1) > 0)
            {
              com.tencent.mm.kernel.h.baF();
              byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)));
              com.tencent.mm.kernel.h.aZW().a(new l(v.d.this.oDh, arrayOfByte), 0);
            }
            v.a(v.this, v.d.this);
            AppMethodBeat.o(132600);
            return true;
          }
        }, (byte)0);
      }
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
 * Qualified Name:     com.tencent.mm.modelmulti.v
 * JD-Core Version:    0.7.0.1
 */