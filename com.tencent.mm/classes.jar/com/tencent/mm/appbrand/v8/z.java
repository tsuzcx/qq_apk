package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class z
  implements c
{
  private static final ThreadLocal<z> cPq;
  private k cPi;
  private final Thread cQZ;
  private final l<Runnable> cRa;
  private z.a cRb;
  private volatile boolean cRc;
  private final boolean cRd;
  private c.a cRe;
  private Queue<Runnable> cRf;
  private boolean zE;
  
  static
  {
    AppMethodBeat.i(144143);
    cPq = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(193517);
    l.a locala = l.cPB;
    this.cRa = new l((Queue)new LinkedList());
    this.cRb = z.a.cRg;
    this.cPi = new k();
    this.cRf = new LinkedList();
    this.cQZ = Thread.currentThread();
    this.cRd = paramBoolean;
    ad.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(193517);
  }
  
  private int LZ()
  {
    AppMethodBeat.i(193520);
    synchronized (this.cRa)
    {
      int i = this.cRa.size();
      AppMethodBeat.o(193520);
      return i;
    }
  }
  
  public static z ch(boolean paramBoolean)
  {
    AppMethodBeat.i(193516);
    if (cPq.get() != null)
    {
      localObject = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(193516);
      throw ((Throwable)localObject);
    }
    Object localObject = new z(paramBoolean);
    cPq.set(localObject);
    AppMethodBeat.o(193516);
    return localObject;
  }
  
  private void u(Runnable paramRunnable)
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
      if (this.cRe != null) {
        this.cRe.b(paramRunnable);
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
  
  public final String Br()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.cPi.cPy.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final boolean LJ()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.cQZ.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  protected boolean LO()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.cRa.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void LP()
  {
    AppMethodBeat.i(144141);
    Iterator localIterator = this.cRf.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.cRd) && (this.cRc))
      {
        ad.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      u(localRunnable);
      if (this.cPi.enable) {
        this.cPi.cPy.pollFirst();
      }
    }
    AppMethodBeat.o(144141);
  }
  
  protected void LQ()
  {
    AppMethodBeat.i(144140);
    ad.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void LR() {}
  
  protected void LS() {}
  
  public final void a(c.a parama)
  {
    this.cRe = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(193519);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(193519);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(193519);
      throw paramRunnable;
    }
    if (this.cRc)
    {
      ad.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(193519);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.cRa)
    {
      this.cRa.b(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.cRa.notify();
      }
      if ((paramBoolean) && (bool)) {
        ad.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(LZ()) });
      }
      LR();
      AppMethodBeat.o(193519);
      return;
    }
  }
  
  public final void cg(boolean paramBoolean)
  {
    this.cPi.enable = paramBoolean;
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.zE;
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
    if (!this.cRc)
    {
      boolean bool1;
      synchronized (this.cRa)
      {
        bool1 = isPaused();
        if (bool1)
        {
          if (this.cRa.cPz >= 0)
          {
            i = 1;
            break label368;
          }
        }
        else
        {
          boolean bool2 = LO();
          if (!bool2) {
            break label171;
          }
        }
      }
      i = 0;
      break label368;
      this.cRf.clear();
      locall2 = this.cRa;
      Queue localQueue = this.cRf;
      d.g.b.k.h(localQueue, "anotherQueue");
      if (bool1) {}
      for (i = locall2.cPz;; i = locall2.cPA.size())
      {
        locall2.cPz = -1;
        Iterator localIterator = ((Iterable)locall2.cPA).iterator();
        j = 0;
        label233:
        if (!localIterator.hasNext()) {
          break label382;
        }
        Object localObject3 = localIterator.next();
        if (j < 0) {
          j.fvx();
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
      locall2.cPA.poll();
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
          LP();
          break;
          LQ();
          synchronized (this.cRa)
          {
            this.cRa.clear();
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
    ad.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(LZ()) });
    try
    {
      this.zE = true;
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
    LS();
    this.cRc = true;
    this.cQZ.interrupt();
    AppMethodBeat.o(144138);
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: ldc_w 331
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 92
    //   8: ldc_w 333
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 264	java/lang/Object:hashCode	()I
    //   21: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 245	com/tencent/mm/appbrand/v8/z:LZ	()I
    //   31: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 255	com/tencent/mm/appbrand/v8/z:zE	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 335	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 68	com/tencent/mm/appbrand/v8/z:cRa	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 276	com/tencent/mm/appbrand/v8/z$a:cRh	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 73	com/tencent/mm/appbrand/v8/z:cRb	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 68	com/tencent/mm/appbrand/v8/z:cRa	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 241	java/lang/Object:notify	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: ldc_w 331
    //   77: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 331
    //   87: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: ldc_w 331
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
  
  public final void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(193518);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(193518);
      return;
    }
    if (this.cRc)
    {
      ad.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(193518);
      return;
    }
    if (Thread.currentThread().getId() == this.cQZ.getId())
    {
      u(paramRunnable);
      if (this.cPi.enable) {
        this.cPi.cPy.remove(null);
      }
    }
    for (;;)
    {
      LR();
      AppMethodBeat.o(193518);
      return;
      boolean bool = isPaused();
      synchronized (this.cRa)
      {
        this.cRa.b(paramRunnable, false);
        if (!bool)
        {
          this.cRb = z.a.cRi;
          this.cRa.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */