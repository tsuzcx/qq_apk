package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements h
{
  protected g.i sEA;
  protected g.a sEB;
  protected g.j sEC;
  protected g.d sED;
  protected g.f sEE;
  private final Set<g.h> sEF = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<g.i> sEG = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<g.b> sEH = Collections.newSetFromMap(new ConcurrentHashMap());
  public int sEu = 0;
  private volatile boolean sEv;
  protected g.g sEw;
  protected g.e sEx;
  protected g.h sEy;
  protected g.b sEz;
  
  public void Bq(int paramInt)
  {
    try
    {
      if (this.sEv) {}
      do
      {
        return;
      } while (this.sEB == null);
      this.sEB.onBufferingUpdate(this, paramInt);
      return;
    }
    finally {}
  }
  
  public void M(String paramString1, String paramString2, String paramString3)
  {
    fB(-1010, -1010);
  }
  
  public final void a(g.a parama)
  {
    this.sEB = parama;
  }
  
  public final void a(g.b paramb)
  {
    this.sEz = paramb;
  }
  
  public final void a(g.d paramd)
  {
    this.sED = paramd;
  }
  
  public final void a(g.e parame)
  {
    this.sEx = parame;
  }
  
  public final void a(g.f paramf)
  {
    this.sEE = paramf;
  }
  
  public final void a(g.g paramg)
  {
    this.sEw = paramg;
  }
  
  public final void a(g.h paramh)
  {
    this.sEy = paramh;
  }
  
  public final void a(g.i parami)
  {
    this.sEA = parami;
  }
  
  public final void a(g.j paramj)
  {
    this.sEC = paramj;
  }
  
  public void a(String paramString1, String paramString2, g.c paramc)
  {
    ey(paramString1, paramString2);
    if (paramc != null) {
      paramc.cwA();
    }
  }
  
  public final void acn(String paramString)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.sEv) {}
      do
      {
        return;
      } while (this.sED == null);
      this.sED.onDownstreamChanged(paramString);
      return;
    }
    finally {}
  }
  
  public final void b(g.b paramb)
  {
    this.sEH.add(paramb);
  }
  
  public final void b(g.h paramh)
  {
    this.sEF.add(paramh);
  }
  
  public final void b(g.i parami)
  {
    this.sEG.add(parami);
  }
  
  /* Error */
  public final void cwu()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc 138
    //   4: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEv	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 95	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEy	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$h;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 95	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEy	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$h;
    //   32: aload_0
    //   33: invokeinterface 146 2 0
    //   38: aload_0
    //   39: getfield 52	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEF	Ljava/util/Set;
    //   42: invokeinterface 150 1 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 156 1 0
    //   54: ifeq -36 -> 18
    //   57: aload_1
    //   58: invokeinterface 160 1 0
    //   63: checkcast 142	com/tencent/mm/plugin/appbrand/jsapi/video/e/g$h
    //   66: aload_0
    //   67: invokeinterface 146 2 0
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   47	11	1	localIterator	java.util.Iterator
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	75	finally
  }
  
  /* Error */
  public final void cwv()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc 163
    //   4: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEv	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 80	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEz	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$b;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 80	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEz	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$b;
    //   32: aload_0
    //   33: invokeinterface 168 2 0
    //   38: aload_0
    //   39: getfield 56	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEH	Ljava/util/Set;
    //   42: invokeinterface 150 1 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 156 1 0
    //   54: ifeq -36 -> 18
    //   57: aload_1
    //   58: invokeinterface 160 1 0
    //   63: checkcast 165	com/tencent/mm/plugin/appbrand/jsapi/video/e/g$b
    //   66: aload_0
    //   67: invokeinterface 168 2 0
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   47	11	1	localIterator	java.util.Iterator
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	75	finally
  }
  
  /* Error */
  protected void cww()
  {
    // Byte code:
    //   0: ldc 115
    //   2: ldc 171
    //   4: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEv	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 98	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEA	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$i;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 98	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEA	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g$i;
    //   32: aload_0
    //   33: invokeinterface 176 2 0
    //   38: aload_0
    //   39: getfield 54	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:sEG	Ljava/util/Set;
    //   42: invokeinterface 150 1 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 156 1 0
    //   54: ifeq -36 -> 18
    //   57: aload_1
    //   58: invokeinterface 160 1 0
    //   63: checkcast 173	com/tencent/mm/plugin/appbrand/jsapi/video/e/g$i
    //   66: aload_0
    //   67: invokeinterface 176 2 0
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   47	11	1	localIterator	java.util.Iterator
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	75	finally
  }
  
  public final void fA(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.sEv) {}
      do
      {
        return;
      } while (this.sEC == null);
      this.sEC.onVideoSizeChanged(this, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  public boolean fB(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.sEv) {}
      do
      {
        return false;
      } while ((this.sEx == null) || (!this.sEx.onError(this, paramInt1, paramInt2)));
      return true;
    }
    finally {}
  }
  
  public final boolean fC(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.sEv) {}
      do
      {
        return false;
      } while ((this.sEw == null) || (!this.sEw.onInfo(this, paramInt1, paramInt2)));
      return true;
    }
    finally {}
  }
  
  public final int getState()
  {
    return this.sEu;
  }
  
  protected final void jK(boolean paramBoolean)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnHitPreloadChange");
    try
    {
      if (this.sEv) {}
      do
      {
        return;
      } while (this.sEE == null);
      this.sEE.onHitPreload(Boolean.valueOf(paramBoolean));
      return;
    }
    finally {}
  }
  
  public void release()
  {
    this.sEv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a
 * JD-Core Version:    0.7.0.1
 */