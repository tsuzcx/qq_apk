package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class z
  implements c
{
  private static final ThreadLocal<z> hmy;
  private boolean cgD;
  private k hmq;
  private final Thread hon;
  private final l<Runnable> hoo;
  private z.a hop;
  private volatile boolean hoq;
  private final boolean hor;
  private c.a hos;
  private Queue<Runnable> hot;
  private Queue<Runnable> hou;
  private boolean hov;
  private int how;
  
  static
  {
    AppMethodBeat.i(144143);
    hmy = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(238631);
    l.a locala = l.hmH;
    this.hoo = new l((Queue)new LinkedList());
    this.hop = z.a.hox;
    this.hmq = new k();
    this.hot = new LinkedList();
    this.hou = new LinkedList();
    this.hov = false;
    this.how = -1;
    this.hon = Thread.currentThread();
    this.hor = paramBoolean;
    Log.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(238631);
  }
  
  private int aEw()
  {
    AppMethodBeat.i(238634);
    synchronized (this.hoo)
    {
      int i = this.hoo.size();
      AppMethodBeat.o(238634);
      return i;
    }
  }
  
  private void y(Runnable paramRunnable)
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
      if (this.hos != null) {
        this.hos.b(paramRunnable);
      }
      if (paramRunnable.getCause() != null) {
        Log.e("MicroMsg.V8JSRuntimeLooper", "runTask V8ScriptException: %s, %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      }
      AppMethodBeat.o(144142);
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      Log.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      AppMethodBeat.o(144142);
      return;
    }
    catch (Exception paramRunnable)
    {
      Log.printErrStackTrace("MicroMsg.V8JSRuntimeLooper", paramRunnable, "runTask", new Object[0]);
      AppMethodBeat.o(144142);
      throw paramRunnable;
    }
  }
  
  public final void a(c.a parama)
  {
    this.hos = parama;
  }
  
  public final boolean aDX()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.hon.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  public final void aEa()
  {
    AppMethodBeat.i(144132);
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    while (!this.hoq)
    {
      for (;;)
      {
        synchronized (this.hoo)
        {
          if (!isPaused())
          {
            boolean bool = aEe();
            if (!bool) {
              break label136;
            }
          }
        }
        try
        {
          this.hoo.wait();
          if (z.a.hoy == this.hop) {
            Log.i("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", new Object[] { this.hop, Integer.valueOf(hashCode()) });
          }
          this.hop = z.a.hox;
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
          this.hon.interrupt();
        }
      }
      localObject1 = finally;
      AppMethodBeat.o(144132);
      throw localObject1;
      label136:
      this.hot.clear();
      this.hoo.a(this.hot, this.cgD);
      aEf();
    }
    aEh();
    synchronized (this.hoo)
    {
      this.hoo.clear();
      AppMethodBeat.o(144132);
      return;
    }
  }
  
  protected boolean aEe()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.hoo.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void aEf()
  {
    AppMethodBeat.i(144141);
    this.how = -1;
    this.hov = false;
    Iterator localIterator = this.hot.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.hor) && (this.hoq))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      this.how += 1;
      y(localRunnable);
      if (this.hmq.enable) {
        this.hmq.hmG.pollFirst();
      }
    } while (!this.hov);
    AppMethodBeat.o(144141);
  }
  
  protected void aEg()
  {
    AppMethodBeat.i(238696);
    Iterator localIterator = this.hou.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.hor) && (this.hoq))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(238696);
        return;
      }
      y(localRunnable);
      if (this.hmq.enable) {
        this.hmq.hmG.pollFirst();
      }
    }
    AppMethodBeat.o(238696);
  }
  
  protected void aEh()
  {
    AppMethodBeat.i(144140);
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void aEi() {}
  
  protected void aEj() {}
  
  public final String aoO()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.hmq.hmG.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(238653);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(238653);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(238653);
      throw paramRunnable;
    }
    if (this.hoq)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(238653);
      return;
    }
    synchronized (this.hoo)
    {
      this.hoo.d(paramRunnable, paramBoolean);
      if (!isPaused()) {
        this.hoo.notify();
      }
      if ((paramBoolean) && (this.cgD)) {
        Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(aEw()) });
      }
      aEi();
      AppMethodBeat.o(238653);
      return;
    }
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(238703);
    if (this.hoq)
    {
      this.hov = true;
      AppMethodBeat.o(238703);
      return true;
    }
    for (;;)
    {
      synchronized (this.hoo)
      {
        if (!isPaused())
        {
          boolean bool = aEe();
          if (!bool) {
            break label130;
          }
        }
      }
      try
      {
        this.hoo.wait();
        if (z.a.hoy == this.hop) {
          Log.i("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", new Object[] { this.hop, Integer.valueOf(hashCode()) });
        }
        this.hop = z.a.hox;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
        this.hon.interrupt();
      }
    }
    localObject = finally;
    AppMethodBeat.o(238703);
    throw localObject;
    label130:
    this.hou.clear();
    this.hoo.a(this.hou, this.cgD);
    aEg();
    AppMethodBeat.o(238703);
    return false;
  }
  
  public final void eb(boolean paramBoolean)
  {
    this.hmq.enable = paramBoolean;
  }
  
  /* Error */
  protected final boolean isPaused()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 213	com/tencent/mm/appbrand/v8/z:cgD	Z
    //   8: ifeq +30 -> 38
    //   11: aload_0
    //   12: getfield 72	com/tencent/mm/appbrand/v8/z:hoo	Lcom/tencent/mm/appbrand/v8/l;
    //   15: getfield 304	com/tencent/mm/appbrand/v8/l:hmJ	I
    //   18: istore_1
    //   19: iload_1
    //   20: iflt +13 -> 33
    //   23: iconst_1
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +12 -> 38
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -10 -> 25
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -11 -> 29
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	z
    //   18	17	1	i	int
    //   1	39	2	bool	boolean
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	19	43	finally
  }
  
  protected void onResume() {}
  
  public final void pause()
  {
    AppMethodBeat.i(144136);
    Log.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(aEw()) });
    try
    {
      this.cgD = true;
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
    Log.i("MicroMsg.V8JSRuntimeLooper", "quit %d", new Object[] { Integer.valueOf(hashCode()) });
    aEj();
    this.hoq = true;
    this.hon.interrupt();
    AppMethodBeat.o(144138);
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: ldc_w 317
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 102
    //   8: ldc_w 319
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 179	java/lang/Object:hashCode	()I
    //   21: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 294	com/tencent/mm/appbrand/v8/z:aEw	()I
    //   31: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 213	com/tencent/mm/appbrand/v8/z:cgD	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 321	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 72	com/tencent/mm/appbrand/v8/z:hoo	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 198	com/tencent/mm/appbrand/v8/z$a:hoy	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 77	com/tencent/mm/appbrand/v8/z:hop	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 72	com/tencent/mm/appbrand/v8/z:hoo	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 290	java/lang/Object:notify	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: ldc_w 317
    //   77: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 317
    //   87: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: ldc_w 317
    //   98: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   58	74	92	finally
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(238710);
    Iterator localIterator = this.hot.iterator();
    int i = -1;
    Runnable localRunnable;
    if (localIterator.hasNext())
    {
      localRunnable = (Runnable)localIterator.next();
      if ((!this.hor) || (!this.hoq)) {
        break label71;
      }
      Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
    }
    for (;;)
    {
      this.hov = true;
      AppMethodBeat.o(238710);
      return;
      label71:
      int j = i + 1;
      i = j;
      if (j <= this.how) {
        break;
      }
      this.how = j;
      y(localRunnable);
      if (this.hmq.enable) {
        this.hmq.hmG.pollFirst();
      }
      i = j;
      if (!this.hov) {
        break;
      }
    }
  }
  
  public final void x(Runnable paramRunnable)
  {
    AppMethodBeat.i(238649);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(238649);
      return;
    }
    if (this.hoq)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(238649);
      return;
    }
    if (Thread.currentThread().getId() == this.hon.getId())
    {
      y(paramRunnable);
      if (this.hmq.enable) {
        this.hmq.hmG.remove(null);
      }
    }
    for (;;)
    {
      aEi();
      AppMethodBeat.o(238649);
      return;
      synchronized (this.hoo)
      {
        this.hoo.d(paramRunnable, false);
        if (!isPaused())
        {
          this.hop = z.a.hoz;
          this.hoo.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */