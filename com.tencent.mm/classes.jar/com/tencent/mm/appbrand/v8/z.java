package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class z
  implements c
{
  private static final ThreadLocal<z> cYb;
  private boolean Ct;
  private k cXT;
  private final Thread cZK;
  private final l<Runnable> cZL;
  private z.a cZM;
  private volatile boolean cZN;
  private final boolean cZO;
  private c.a cZP;
  private Queue<Runnable> cZQ;
  
  static
  {
    AppMethodBeat.i(144143);
    cYb = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(198718);
    l.a locala = l.cYm;
    this.cZL = new l((Queue)new LinkedList());
    this.cZM = z.a.cZR;
    this.cXT = new k();
    this.cZQ = new LinkedList();
    this.cZK = Thread.currentThread();
    this.cZO = paramBoolean;
    ad.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(198718);
  }
  
  private int NG()
  {
    AppMethodBeat.i(198721);
    synchronized (this.cZL)
    {
      int i = this.cZL.size();
      AppMethodBeat.o(198721);
      return i;
    }
  }
  
  public static z ck(boolean paramBoolean)
  {
    AppMethodBeat.i(198717);
    if (cYb.get() != null)
    {
      localObject = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(198717);
      throw ((Throwable)localObject);
    }
    Object localObject = new z(paramBoolean);
    cYb.set(localObject);
    AppMethodBeat.o(198717);
    return localObject;
  }
  
  private void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(144142);
    try
    {
      paramRunnable.run();
      AppMethodBeat.o(144142);
      return;
    }
    catch (V8ScriptException paramRunnable)
    {
      if (this.cZP != null) {
        this.cZP.b(paramRunnable);
      }
      AppMethodBeat.o(144142);
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      ad.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      AppMethodBeat.o(144142);
    }
  }
  
  public final String Cu()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.cXT.cYj.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final boolean Np()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.cZK.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  protected boolean Nv()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.cZL.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void Nw()
  {
    AppMethodBeat.i(144141);
    Iterator localIterator = this.cZQ.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.cZO) && (this.cZN))
      {
        ad.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      v(localRunnable);
      if (this.cXT.enable) {
        this.cXT.cYj.pollFirst();
      }
    }
    AppMethodBeat.o(144141);
  }
  
  protected void Nx()
  {
    AppMethodBeat.i(144140);
    ad.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void Ny() {}
  
  protected void Nz() {}
  
  public final void a(c.a parama)
  {
    this.cZP = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(198720);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(198720);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(198720);
      throw paramRunnable;
    }
    if (this.cZN)
    {
      ad.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(198720);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.cZL)
    {
      this.cZL.c(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.cZL.notify();
      }
      if ((paramBoolean) && (bool)) {
        ad.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(NG()) });
      }
      Ny();
      AppMethodBeat.o(198720);
      return;
    }
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cXT.enable = paramBoolean;
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.Ct;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void loop()
  {
    AppMethodBeat.i(144132);
    ad.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    int i;
    label68:
    label79:
    l locall2;
    label171:
    int j;
    if (!this.cZN)
    {
      boolean bool1;
      synchronized (this.cZL)
      {
        bool1 = isPaused();
        if (bool1)
        {
          if (this.cZL.cYk >= 0)
          {
            i = 1;
            break label368;
          }
        }
        else
        {
          boolean bool2 = Nv();
          if (!bool2) {
            break label171;
          }
        }
      }
      i = 0;
      break label368;
      this.cZQ.clear();
      locall2 = this.cZL;
      Queue localQueue = this.cZQ;
      p.h(localQueue, "anotherQueue");
      if (bool1) {}
      for (i = locall2.cYk;; i = locall2.cYl.size())
      {
        locall2.cYk = -1;
        Iterator localIterator = ((Iterable)locall2.cYl).iterator();
        j = 0;
        label233:
        if (!localIterator.hasNext()) {
          break label382;
        }
        Object localObject3 = localIterator.next();
        if (j < 0) {
          j.gfB();
        }
        if (j > i) {
          break;
        }
        localQueue.offer(localObject3);
        break;
      }
    }
    for (;;)
    {
      locall2.cYl.poll();
      if (j != i)
      {
        j += 1;
      }
      else
      {
        label368:
        label382:
        do
        {
          Nw();
          break;
          Nx();
          synchronized (this.cZL)
          {
            this.cZL.clear();
            AppMethodBeat.o(144132);
            return;
          }
          if (i == 0) {
            break label79;
          }
          break label68;
          j += 1;
          break label233;
        } while (i < 0);
        j = 0;
      }
    }
  }
  
  protected void onResume() {}
  
  public final void pause()
  {
    AppMethodBeat.i(144136);
    ad.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(NG()) });
    try
    {
      this.Ct = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(144136);
    }
  }
  
  public final void quit()
  {
    AppMethodBeat.i(144138);
    ad.i("MicroMsg.V8JSRuntimeLooper", "quit %d", new Object[] { Integer.valueOf(hashCode()) });
    Nz();
    this.cZN = true;
    this.cZK.interrupt();
    AppMethodBeat.o(144138);
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: ldc_w 332
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 92
    //   8: ldc_w 334
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 265	java/lang/Object:hashCode	()I
    //   21: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 246	com/tencent/mm/appbrand/v8/z:NG	()I
    //   31: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 256	com/tencent/mm/appbrand/v8/z:Ct	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 336	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 68	com/tencent/mm/appbrand/v8/z:cZL	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 277	com/tencent/mm/appbrand/v8/z$a:cZS	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 73	com/tencent/mm/appbrand/v8/z:cZM	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 68	com/tencent/mm/appbrand/v8/z:cZL	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 242	java/lang/Object:notify	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: ldc_w 332
    //   77: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 332
    //   87: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: ldc_w 332
    //   98: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	z
    //   81	13	1	localObject1	Object
    //   92	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	81	finally
    //   82	84	81	finally
    //   58	74	92	finally
    //   93	95	92	finally
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(198719);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(198719);
      return;
    }
    if (this.cZN)
    {
      ad.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(198719);
      return;
    }
    if (Thread.currentThread().getId() == this.cZK.getId())
    {
      v(paramRunnable);
      if (this.cXT.enable) {
        this.cXT.cYj.remove(null);
      }
    }
    for (;;)
    {
      Ny();
      AppMethodBeat.o(198719);
      return;
      boolean bool = isPaused();
      synchronized (this.cZL)
      {
        this.cZL.c(paramRunnable, false);
        if (!bool)
        {
          this.cZM = z.a.cZT;
          this.cZL.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */