package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements f
{
  private final Set<e.h> pzA = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<e.i> pzB = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<e.b> pzC = Collections.newSetFromMap(new ConcurrentHashMap());
  protected int pzp = 0;
  private volatile boolean pzq;
  protected e.g pzr;
  protected e.e pzs;
  protected e.h pzt;
  protected e.b pzu;
  protected e.i pzv;
  protected e.a pzw;
  protected e.j pzx;
  protected e.d pzy;
  protected e.f pzz;
  
  public void Bc(int paramInt)
  {
    try
    {
      if (this.pzq) {}
      do
      {
        return;
      } while (this.pzw == null);
      this.pzw.jg(paramInt);
      return;
    }
    finally {}
  }
  
  public final void a(e.a parama)
  {
    this.pzw = parama;
  }
  
  public final void a(e.b paramb)
  {
    this.pzu = paramb;
  }
  
  public final void a(e.d paramd)
  {
    this.pzy = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.pzs = parame;
  }
  
  public final void a(e.f paramf)
  {
    this.pzz = paramf;
  }
  
  public final void a(e.g paramg)
  {
    this.pzr = paramg;
  }
  
  public final void a(e.h paramh)
  {
    this.pzt = paramh;
  }
  
  public final void a(e.i parami)
  {
    this.pzv = parami;
  }
  
  public final void a(e.j paramj)
  {
    this.pzx = paramj;
  }
  
  public void a(String paramString1, String paramString2, e.c paramc)
  {
    ef(paramString1, paramString2);
    if (paramc != null) {
      paramc.bWl();
    }
  }
  
  public final void ajn(String paramString)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.pzq) {}
      do
      {
        return;
      } while (this.pzy == null);
      this.pzy.ajo(paramString);
      return;
    }
    finally {}
  }
  
  public final void b(e.b paramb)
  {
    this.pzC.add(paramb);
  }
  
  public final void b(e.h paramh)
  {
    this.pzA.add(paramh);
  }
  
  public final void b(e.i parami)
  {
    this.pzB.add(parami);
  }
  
  /* Error */
  public final void bWi()
  {
    // Byte code:
    //   0: ldc 108
    //   2: ldc 131
    //   4: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzq	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzt	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$h;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzt	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$h;
    //   32: aload_0
    //   33: invokeinterface 138 2 0
    //   38: aload_0
    //   39: getfield 52	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzA	Ljava/util/Set;
    //   42: invokeinterface 142 1 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 148 1 0
    //   54: ifeq -36 -> 18
    //   57: aload_1
    //   58: invokeinterface 152 1 0
    //   63: checkcast 135	com/tencent/mm/plugin/appbrand/jsapi/video/e/e$h
    //   66: aload_0
    //   67: invokeinterface 138 2 0
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
  public final void bWj()
  {
    // Byte code:
    //   0: ldc 108
    //   2: ldc 155
    //   4: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzq	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzu	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$b;
    //   25: ifnull +12 -> 37
    //   28: aload_0
    //   29: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzu	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$b;
    //   32: invokeinterface 160 1 0
    //   37: aload_0
    //   38: getfield 56	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzC	Ljava/util/Set;
    //   41: invokeinterface 142 1 0
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 148 1 0
    //   53: ifeq -35 -> 18
    //   56: aload_1
    //   57: invokeinterface 152 1 0
    //   62: checkcast 157	com/tencent/mm/plugin/appbrand/jsapi/video/e/e$b
    //   65: invokeinterface 160 1 0
    //   70: goto -23 -> 47
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	a
    //   46	11	1	localIterator	java.util.Iterator
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	73	finally
  }
  
  /* Error */
  protected void bWk()
  {
    // Byte code:
    //   0: ldc 108
    //   2: ldc 163
    //   4: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzq	Z
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 91	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzv	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$i;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 91	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzv	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/e$i;
    //   32: aload_0
    //   33: invokeinterface 167 2 0
    //   38: aload_0
    //   39: getfield 54	com/tencent/mm/plugin/appbrand/jsapi/video/e/a:pzB	Ljava/util/Set;
    //   42: invokeinterface 142 1 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 148 1 0
    //   54: ifeq -36 -> 18
    //   57: aload_1
    //   58: invokeinterface 152 1 0
    //   63: checkcast 165	com/tencent/mm/plugin/appbrand/jsapi/video/e/e$i
    //   66: aload_0
    //   67: invokeinterface 167 2 0
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
  
  public final void eG(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.pzq) {}
      do
      {
        return;
      } while (this.pzx == null);
      this.pzx.a(this, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  public boolean eH(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.pzq) {}
      do
      {
        return false;
      } while ((this.pzs == null) || (!this.pzs.cu(paramInt1, paramInt2)));
      return true;
    }
    finally {}
  }
  
  public final boolean eI(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.pzq) {}
      do
      {
        return false;
      } while ((this.pzr == null) || (!this.pzr.ct(paramInt1, paramInt2)));
      return true;
    }
    finally {}
  }
  
  public final int getState()
  {
    return this.pzp;
  }
  
  protected final void iH(boolean paramBoolean)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnHitPreloadChange");
    try
    {
      if (this.pzq) {}
      do
      {
        return;
      } while (this.pzz == null);
      this.pzz.k(Boolean.valueOf(paramBoolean));
      return;
    }
    finally {}
  }
  
  public void release()
  {
    this.pzq = true;
  }
  
  public final void setState(int paramInt)
  {
    this.pzp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a
 * JD-Core Version:    0.7.0.1
 */