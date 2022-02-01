package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
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
  private static final ThreadLocal<z> dpE;
  private boolean CA;
  private k dpw;
  private final Thread dro;
  private final l<Runnable> drp;
  private z.a drq;
  private volatile boolean drr;
  private final boolean drs;
  private c.a drt;
  private Queue<Runnable> dru;
  private Queue<Runnable> drv;
  private boolean drw;
  private int drx;
  
  static
  {
    AppMethodBeat.i(144143);
    dpE = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(216926);
    l.a locala = l.dpP;
    this.drp = new l((Queue)new LinkedList());
    this.drq = z.a.dry;
    this.dpw = new k();
    this.dru = new LinkedList();
    this.drv = new LinkedList();
    this.drw = false;
    this.drx = -1;
    this.dro = Thread.currentThread();
    this.drs = paramBoolean;
    Log.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(216926);
  }
  
  private int XQ()
  {
    AppMethodBeat.i(216929);
    synchronized (this.drp)
    {
      int i = this.drp.size();
      AppMethodBeat.o(216929);
      return i;
    }
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
      if (this.drt != null) {
        this.drt.b(paramRunnable);
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
    catch (NullPointerException paramRunnable)
    {
      Log.printErrStackTrace("MicroMsg.V8JSRuntimeLooper", paramRunnable, "runTask", new Object[0]);
      AppMethodBeat.o(144142);
      throw paramRunnable;
    }
  }
  
  public final String LP()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.dpw.dpM.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  protected boolean XC()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.drp.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void XD()
  {
    AppMethodBeat.i(144141);
    this.drx = -1;
    this.drw = false;
    Iterator localIterator = this.dru.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.drs) && (this.drr))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      this.drx += 1;
      v(localRunnable);
      if (this.dpw.enable) {
        this.dpw.dpM.pollFirst();
      }
    } while (!this.drw);
    AppMethodBeat.o(144141);
  }
  
  protected void XE()
  {
    AppMethodBeat.i(216930);
    Iterator localIterator = this.drv.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.drs) && (this.drr))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(216930);
        return;
      }
      v(localRunnable);
      if (this.dpw.enable) {
        this.dpw.dpM.pollFirst();
      }
    }
    AppMethodBeat.o(216930);
  }
  
  protected void XF()
  {
    AppMethodBeat.i(144140);
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void XG() {}
  
  protected void XH() {}
  
  public final boolean Xw()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.dro.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  public final void a(c.a parama)
  {
    this.drt = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(216928);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(216928);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(216928);
      throw paramRunnable;
    }
    if (this.drr)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(216928);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.drp)
    {
      this.drp.b(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.drp.notify();
      }
      if ((paramBoolean) && (bool)) {
        Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(XQ()) });
      }
      XG();
      AppMethodBeat.o(216928);
      return;
    }
  }
  
  public final void cS(boolean paramBoolean)
  {
    this.dpw.enable = paramBoolean;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(216931);
    if (this.drr)
    {
      this.drw = true;
      AppMethodBeat.o(216931);
      return true;
    }
    boolean bool1;
    synchronized (this.drp)
    {
      bool1 = isPaused();
      if ((!bool1) || (this.drp.XI()))
      {
        boolean bool2 = XC();
        if (!bool2) {
          break label147;
        }
      }
    }
    label147:
    this.drv.clear();
    this.drp.a(this.drv, bool1);
    XE();
    AppMethodBeat.o(216931);
    return false;
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.CA;
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
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    while (!this.drr)
    {
      boolean bool1;
      synchronized (this.drp)
      {
        bool1 = isPaused();
        if ((!bool1) || (this.drp.XI()))
        {
          boolean bool2 = XC();
          if (!bool2) {
            break label156;
          }
        }
      }
      label156:
      this.dru.clear();
      this.drp.a(this.dru, bool1);
      XD();
    }
    XF();
    synchronized (this.drp)
    {
      this.drp.clear();
      AppMethodBeat.o(144132);
      return;
    }
  }
  
  protected void onResume() {}
  
  public final void pause()
  {
    AppMethodBeat.i(144136);
    Log.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(XQ()) });
    try
    {
      this.CA = true;
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
    XH();
    this.drr = true;
    this.dro.interrupt();
    AppMethodBeat.o(144138);
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: ldc_w 316
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 102
    //   8: ldc_w 318
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 279	java/lang/Object:hashCode	()I
    //   21: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 251	com/tencent/mm/appbrand/v8/z:XQ	()I
    //   31: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 294	com/tencent/mm/appbrand/v8/z:CA	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 320	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 72	com/tencent/mm/appbrand/v8/z:drp	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 274	com/tencent/mm/appbrand/v8/z$a:drz	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 77	com/tencent/mm/appbrand/v8/z:drq	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 72	com/tencent/mm/appbrand/v8/z:drp	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 247	java/lang/Object:notify	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: ldc_w 316
    //   77: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 316
    //   87: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: ldc_w 316
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
    //   82	84	81	finally
    //   58	74	92	finally
    //   93	95	92	finally
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(216932);
    Iterator localIterator = this.dru.iterator();
    int i = -1;
    Runnable localRunnable;
    if (localIterator.hasNext())
    {
      localRunnable = (Runnable)localIterator.next();
      if ((!this.drs) || (!this.drr)) {
        break label71;
      }
      Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
    }
    for (;;)
    {
      this.drw = true;
      AppMethodBeat.o(216932);
      return;
      label71:
      int j = i + 1;
      i = j;
      if (j <= this.drx) {
        break;
      }
      this.drx = j;
      v(localRunnable);
      if (this.dpw.enable) {
        this.dpw.dpM.pollFirst();
      }
      i = j;
      if (!this.drw) {
        break;
      }
    }
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(216927);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(216927);
      return;
    }
    if (this.drr)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(216927);
      return;
    }
    if (Thread.currentThread().getId() == this.dro.getId())
    {
      v(paramRunnable);
      if (this.dpw.enable) {
        this.dpw.dpM.remove(null);
      }
    }
    for (;;)
    {
      XG();
      AppMethodBeat.o(216927);
      return;
      boolean bool = isPaused();
      synchronized (this.drp)
      {
        this.drp.b(paramRunnable, false);
        if (!bool)
        {
          this.drq = z.a.drA;
          this.drp.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */