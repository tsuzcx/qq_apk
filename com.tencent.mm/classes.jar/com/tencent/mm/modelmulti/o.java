package com.tencent.mm.modelmulti;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.ln;
import com.tencent.mm.h.a.qt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import junit.framework.Assert;

public final class o
{
  private static Boolean etH = null;
  private WakerLock dhK = null;
  public Queue<o.c> etI = new LinkedList();
  public Queue<o.c> etJ = new LinkedList();
  private HashMap<o.c, Long> etK = new HashMap();
  public o.c etL = null;
  private long etM = 0L;
  
  private static boolean Fp()
  {
    if ((com.tencent.mm.kernel.a.CW()) || (!g.DK())) {
      return false;
    }
    if (etH != null) {
      return etH.booleanValue();
    }
    etH = Boolean.valueOf(true);
    return true;
  }
  
  private static boolean Pi()
  {
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ae.getContext().getSystemService("power"), new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      f.nEG.a(99L, 45L, 1L, false);
      y.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.valueOf(true), bk.j(localException) });
    }
    return true;
  }
  
  /* Error */
  private void Po()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   13: invokevirtual 156	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   16: ifne +54 -> 70
    //   19: aload_0
    //   20: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   23: ifnonnull +33 -> 56
    //   26: ldc 158
    //   28: astore_1
    //   29: ldc 136
    //   31: ldc 160
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: getstatic 166	com/tencent/mm/sdk/a/b:foreground	Z
    //   46: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: aastore
    //   50: invokestatic 169	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   60: invokevirtual 156	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   63: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: astore_1
    //   67: goto -38 -> 29
    //   70: aload_0
    //   71: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   74: invokevirtual 172	com/tencent/mars/comm/WakerLock:unLock	()V
    //   77: goto -24 -> 53
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	o
    //   28	39	1	localObject1	Object
    //   80	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	80	finally
    //   19	26	80	finally
    //   29	53	80	finally
    //   56	67	80	finally
    //   70	77	80	finally
  }
  
  private void a(o.c paramc)
  {
    if (k.Pj())
    {
      y.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      return;
    }
    g.DS().O(new o.2(this, paramc));
  }
  
  private static void assertTrue(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    y.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
  }
  
  private int e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    o.e locale = new o.e(this, paramInt1, paramInt2, paramBoolean);
    a(locale);
    return locale.hashCode();
  }
  
  /* Error */
  private void mF(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 136
    //   6: ldc_w 454
    //   9: iconst_3
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_0
    //   20: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: invokestatic 458	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   29: aastore
    //   30: invokestatic 318	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   37: ifnonnull +27 -> 64
    //   40: aload_0
    //   41: new 153	com/tencent/mars/comm/WakerLock
    //   44: dup
    //   45: invokestatic 106	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   48: ldc 136
    //   50: new 6	com/tencent/mm/modelmulti/o$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 460	com/tencent/mm/modelmulti/o$1:<init>	(Lcom/tencent/mm/modelmulti/o;)V
    //   58: invokespecial 463	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   61: putfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   64: aload_0
    //   65: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   68: invokevirtual 156	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   71: ifne +30 -> 101
    //   74: ldc_w 465
    //   77: iload_2
    //   78: invokestatic 87	com/tencent/mm/modelmulti/o:assertTrue	(Ljava/lang/String;Z)V
    //   81: getstatic 166	com/tencent/mm/sdk/a/b:foreground	Z
    //   84: ifne +14 -> 98
    //   87: aload_0
    //   88: getfield 61	com/tencent/mm/modelmulti/o:dhK	Lcom/tencent/mars/comm/WakerLock;
    //   91: ldc2_w 466
    //   94: aload_1
    //   95: invokevirtual 470	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: iconst_0
    //   102: istore_2
    //   103: goto -29 -> 74
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	o
    //   0	111	1	paramString	String
    //   1	102	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	64	106	finally
    //   64	74	106	finally
    //   74	98	106	finally
  }
  
  public final int a(long paramLong, int paramInt, String paramString)
  {
    int j = 0;
    boolean bool = Fp();
    y.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString, bk.csb() });
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new qt();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new ln();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFFFFFEFF & paramLong & 0xFFDFFFFF & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (g.DK())
      {
        g.DQ();
        i = j;
        if (g.DP().Dz() != null)
        {
          g.DQ();
          g.DP().Dz().o(8196, Long.valueOf(paramLong));
          if (bool) {
            break label313;
          }
          localObject = new j(paramInt);
          i = localObject.hashCode();
          y.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(i) });
          g.DQ();
          if (g.DO().dJT.a((m)localObject, 0)) {
            break label326;
          }
          y.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(i) });
          i = j;
        }
      }
    }
    label313:
    label326:
    for (;;)
    {
      if (!bk.bl(paramString))
      {
        localObject = new aj();
        ((aj)localObject).bGr.type = 3;
        ((aj)localObject).bGr.bGt = paramString;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      return i;
      i = e(paramInt, 7, false);
    }
  }
  
  public final void a(s.b paramb, int paramInt, long paramLong)
  {
    boolean bool = Fp();
    y.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong), bk.csb() });
    if (!bool)
    {
      g.DQ();
      g.DO().dJT.a(new j(paramb, paramInt, paramLong), 0);
      return;
    }
    a(new o.f(this, paramb, paramInt, paramLong));
  }
  
  public final int iT(int paramInt)
  {
    boolean bool = Fp();
    y.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bk.csb() });
    if (!bool)
    {
      j localj = new j(paramInt);
      g.DQ();
      g.DO().dJT.a(localj, 0);
      return localj.hashCode();
    }
    return e(paramInt, 7, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */