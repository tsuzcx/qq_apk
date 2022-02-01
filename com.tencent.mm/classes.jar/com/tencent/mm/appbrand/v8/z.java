package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class z
  implements c
{
  private static final ThreadLocal<z> cML;
  private boolean AC;
  private k cMD;
  private Queue<Runnable> cOA;
  private final Thread cOu;
  private final l<Runnable> cOv;
  private z.a cOw;
  private volatile boolean cOx;
  private final boolean cOy;
  private c.a cOz;
  
  static
  {
    AppMethodBeat.i(144143);
    cML = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(200843);
    l.a locala = l.cMW;
    this.cOv = new l((Queue)new LinkedList());
    this.cOw = z.a.cOB;
    this.cMD = new k();
    this.cOA = new LinkedList();
    this.cOu = Thread.currentThread();
    this.cOy = paramBoolean;
    ac.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(200843);
  }
  
  private int LX()
  {
    AppMethodBeat.i(200846);
    synchronized (this.cOv)
    {
      int i = this.cOv.size();
      AppMethodBeat.o(200846);
      return i;
    }
  }
  
  public static z cj(boolean paramBoolean)
  {
    AppMethodBeat.i(200842);
    if (cML.get() != null)
    {
      localObject = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(200842);
      throw ((Throwable)localObject);
    }
    Object localObject = new z(paramBoolean);
    cML.set(localObject);
    AppMethodBeat.o(200842);
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
      if (this.cOz != null) {
        this.cOz.b(paramRunnable);
      }
      AppMethodBeat.o(144142);
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      ac.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      AppMethodBeat.o(144142);
    }
  }
  
  public final String AV()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.cMD.cMT.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final boolean LH()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.cOu.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  protected boolean LM()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.cOv.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void LN()
  {
    AppMethodBeat.i(144141);
    Iterator localIterator = this.cOA.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.cOy) && (this.cOx))
      {
        ac.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      v(localRunnable);
      if (this.cMD.enable) {
        this.cMD.cMT.pollFirst();
      }
    }
    AppMethodBeat.o(144141);
  }
  
  protected void LO()
  {
    AppMethodBeat.i(144140);
    ac.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void LP() {}
  
  protected void LQ() {}
  
  public final void a(c.a parama)
  {
    this.cOz = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200845);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(200845);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(200845);
      throw paramRunnable;
    }
    if (this.cOx)
    {
      ac.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(200845);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.cOv)
    {
      this.cOv.c(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.cOv.notify();
      }
      if ((paramBoolean) && (bool)) {
        ac.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(LX()) });
      }
      LP();
      AppMethodBeat.o(200845);
      return;
    }
  }
  
  public final void ci(boolean paramBoolean)
  {
    this.cMD.enable = paramBoolean;
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.AC;
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
    ac.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    int i;
    label68:
    label79:
    l locall2;
    label171:
    int j;
    if (!this.cOx)
    {
      boolean bool1;
      synchronized (this.cOv)
      {
        bool1 = isPaused();
        if (bool1)
        {
          if (this.cOv.cMU >= 0)
          {
            i = 1;
            break label368;
          }
        }
        else
        {
          boolean bool2 = LM();
          if (!bool2) {
            break label171;
          }
        }
      }
      i = 0;
      break label368;
      this.cOA.clear();
      locall2 = this.cOv;
      Queue localQueue = this.cOA;
      d.g.b.k.h(localQueue, "anotherQueue");
      if (bool1) {}
      for (i = locall2.cMU;; i = locall2.cMV.size())
      {
        locall2.cMU = -1;
        Iterator localIterator = ((Iterable)locall2.cMV).iterator();
        j = 0;
        label233:
        if (!localIterator.hasNext()) {
          break label382;
        }
        Object localObject3 = localIterator.next();
        if (j < 0) {
          j.fOc();
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
      locall2.cMV.poll();
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
          LN();
          break;
          LO();
          synchronized (this.cOv)
          {
            this.cOv.clear();
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
    ac.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(LX()) });
    try
    {
      this.AC = true;
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
    ac.i("MicroMsg.V8JSRuntimeLooper", "quit %d", new Object[] { Integer.valueOf(hashCode()) });
    LQ();
    this.cOx = true;
    this.cOu.interrupt();
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
    //   28: invokespecial 246	com/tencent/mm/appbrand/v8/z:LX	()I
    //   31: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 256	com/tencent/mm/appbrand/v8/z:AC	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 336	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 68	com/tencent/mm/appbrand/v8/z:cOv	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 277	com/tencent/mm/appbrand/v8/z$a:cOC	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 73	com/tencent/mm/appbrand/v8/z:cOw	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 68	com/tencent/mm/appbrand/v8/z:cOv	Lcom/tencent/mm/appbrand/v8/l;
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
    AppMethodBeat.i(200844);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(200844);
      return;
    }
    if (this.cOx)
    {
      ac.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(200844);
      return;
    }
    if (Thread.currentThread().getId() == this.cOu.getId())
    {
      v(paramRunnable);
      if (this.cMD.enable) {
        this.cMD.cMT.remove(null);
      }
    }
    for (;;)
    {
      LP();
      AppMethodBeat.o(200844);
      return;
      boolean bool = isPaused();
      synchronized (this.cOv)
      {
        this.cOv.c(paramRunnable, false);
        if (!bool)
        {
          this.cOw = z.a.cOD;
          this.cOv.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */