package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class o
{
  private static Boolean fJu = null;
  public j.a appForegroundListener;
  private WakerLock dZd;
  public Queue<o.c> fJv;
  public Queue<o.c> fJw;
  private HashMap<o.c, Long> fJx;
  public o.c fJy;
  private long fJz;
  
  public o()
  {
    AppMethodBeat.i(58414);
    this.appForegroundListener = new o.1(this);
    this.fJv = new LinkedList();
    this.fJw = new LinkedList();
    this.fJx = new HashMap();
    this.fJy = null;
    this.fJz = 0L;
    this.dZd = null;
    AppMethodBeat.o(58414);
  }
  
  private static boolean Yt()
  {
    AppMethodBeat.i(58415);
    if ((com.tencent.mm.kernel.a.QP()) || (!g.RG()))
    {
      AppMethodBeat.o(58415);
      return false;
    }
    if (fJu != null)
    {
      boolean bool = fJu.booleanValue();
      AppMethodBeat.o(58415);
      return bool;
    }
    fJu = Boolean.TRUE;
    AppMethodBeat.o(58415);
    return true;
  }
  
  private void a(o.c paramc)
  {
    AppMethodBeat.i(58423);
    if (k.ail())
    {
      ab.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      AppMethodBeat.o(58423);
      return;
    }
    g.RO().ac(new o.3(this, paramc));
    AppMethodBeat.o(58423);
  }
  
  private static boolean aik()
  {
    AppMethodBeat.i(58424);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(58424);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 45L, 1L, false);
      ab.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bo.l(localException) });
      AppMethodBeat.o(58424);
    }
    return true;
  }
  
  /* Error */
  private void aiq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 396
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   19: invokevirtual 401	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   22: ifne +62 -> 84
    //   25: aload_0
    //   26: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   29: ifnonnull +41 -> 70
    //   32: ldc_w 403
    //   35: astore_1
    //   36: ldc 121
    //   38: ldc_w 405
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
    //   58: invokestatic 408	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 396
    //   64: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 401	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: invokestatic 296	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: goto -45 -> 36
    //   84: aload_0
    //   85: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   88: invokevirtual 411	com/tencent/mars/comm/WakerLock:unLock	()V
    //   91: ldc_w 396
    //   94: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -30 -> 67
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	o
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
    AppMethodBeat.i(58416);
    if (paramBoolean)
    {
      AppMethodBeat.o(58416);
      return;
    }
    ab.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    AppMethodBeat.o(58416);
  }
  
  private int h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(58420);
    o.e locale = new o.e(this, paramInt1, paramInt2, paramBoolean);
    a(locale);
    paramInt1 = locale.hashCode();
    AppMethodBeat.o(58420);
    return paramInt1;
  }
  
  /* Error */
  private void tP(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 498
    //   7: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 121
    //   12: ldc_w 500
    //   15: iconst_3
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: invokestatic 504	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   35: aastore
    //   36: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   43: ifnonnull +27 -> 70
    //   46: aload_0
    //   47: new 398	com/tencent/mars/comm/WakerLock
    //   50: dup
    //   51: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   54: ldc 121
    //   56: new 506	com/tencent/mm/modelmulti/o$2
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 507	com/tencent/mm/modelmulti/o$2:<init>	(Lcom/tencent/mm/modelmulti/o;)V
    //   64: invokespecial 510	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   67: putfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   70: aload_0
    //   71: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 401	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   77: ifne +36 -> 113
    //   80: ldc_w 512
    //   83: iload_2
    //   84: invokestatic 82	com/tencent/mm/modelmulti/o:assertTrue	(Ljava/lang/String;Z)V
    //   87: getstatic 191	com/tencent/mm/sdk/a/b:foreground	Z
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 73	com/tencent/mm/modelmulti/o:dZd	Lcom/tencent/mars/comm/WakerLock;
    //   97: ldc2_w 513
    //   100: aload_1
    //   101: invokevirtual 517	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   104: ldc_w 498
    //   107: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	123	0	this	o
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
    AppMethodBeat.i(58417);
    boolean bool = Yt();
    ab.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new sf();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new mc();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x80 & paramLong) != 0L)
    {
      localObject = new sz();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFFFFFEFF & paramLong & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (g.RG())
      {
        g.RM();
        i = j;
        if (g.RL().Ru() != null)
        {
          ab.i("MicroMsg.SyncService", "ContinueFlag:%s", new Object[] { Long.valueOf(paramLong) });
          g.RM();
          g.RL().Ru().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label365;
          }
          localObject = new j(paramInt);
          paramInt = localObject.hashCode();
          ab.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          g.RM();
          i = paramInt;
          if (!g.RK().eHt.a((m)localObject, 0)) {
            ab.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label365:
    for (i = 0;; i = h(paramInt, 7, false))
    {
      if (!bo.isNullOrNil(paramString))
      {
        localObject = new ak();
        ((ak)localObject).cnA.type = 3;
        ((ak)localObject).cnA.cnC = paramString;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      AppMethodBeat.o(58417);
      return i;
    }
  }
  
  public final void a(t.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(58418);
    boolean bool = Yt();
    ab.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if (!bool)
    {
      g.RM();
      g.RK().eHt.a(new j(paramb, paramInt, paramLong), 0);
      AppMethodBeat.o(58418);
      return;
    }
    a(new o.f(this, paramb, paramInt, paramLong));
    AppMethodBeat.o(58418);
  }
  
  public final int lL(int paramInt)
  {
    AppMethodBeat.i(58419);
    boolean bool = Yt();
    ab.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bo.dtY() });
    if (!bool)
    {
      j localj = new j(paramInt);
      g.RM();
      g.RK().eHt.a(localj, 0);
      paramInt = localj.hashCode();
      AppMethodBeat.o(58419);
      return paramInt;
    }
    paramInt = h(paramInt, 7, false);
    AppMethodBeat.o(58419);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */