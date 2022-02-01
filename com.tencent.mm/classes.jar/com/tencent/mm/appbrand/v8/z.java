package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class z
  implements c
{
  private static final ThreadLocal<z> cYZ;
  private boolean Ct;
  private k cYR;
  private final Thread daJ;
  private final l<Runnable> daK;
  private a daL;
  private volatile boolean daM;
  private final boolean daN;
  private c.a daO;
  private Queue<Runnable> daP;
  private Queue<Runnable> daQ;
  private boolean daR;
  private int daS;
  
  static
  {
    AppMethodBeat.i(144143);
    cYZ = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(194206);
    l.a locala = l.cZk;
    this.daK = new l((Queue)new LinkedList());
    this.daL = a.daT;
    this.cYR = new k();
    this.daP = new LinkedList();
    this.daQ = new LinkedList();
    this.daR = false;
    this.daS = -1;
    this.daJ = Thread.currentThread();
    this.daN = paramBoolean;
    ae.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(194206);
  }
  
  private int NE()
  {
    AppMethodBeat.i(194209);
    synchronized (this.daK)
    {
      int i = this.daK.size();
      AppMethodBeat.o(194209);
      return i;
    }
  }
  
  public static z ck(boolean paramBoolean)
  {
    AppMethodBeat.i(194205);
    if (cYZ.get() != null)
    {
      localObject = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(194205);
      throw ((Throwable)localObject);
    }
    Object localObject = new z(paramBoolean);
    cYZ.set(localObject);
    AppMethodBeat.o(194205);
    return localObject;
  }
  
  private void t(Runnable paramRunnable)
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
      if (this.daO != null) {
        this.daO.b(paramRunnable);
      }
      AppMethodBeat.o(144142);
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      ae.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      AppMethodBeat.o(144142);
    }
  }
  
  public final String Cx()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.cYR.cZh.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final boolean Nk()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.daJ.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  protected boolean Nq()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.daK.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void Nr()
  {
    AppMethodBeat.i(144141);
    this.daS = -1;
    this.daR = false;
    Iterator localIterator = this.daP.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.daN) && (this.daM))
      {
        ae.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      this.daS += 1;
      t(localRunnable);
      if (this.cYR.enable) {
        this.cYR.cZh.pollFirst();
      }
    } while (!this.daR);
    AppMethodBeat.o(144141);
  }
  
  protected void Ns()
  {
    AppMethodBeat.i(194210);
    Iterator localIterator = this.daQ.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.daN) && (this.daM))
      {
        ae.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(194210);
        return;
      }
      t(localRunnable);
      if (this.cYR.enable) {
        this.cYR.cZh.pollFirst();
      }
    }
    AppMethodBeat.o(194210);
  }
  
  protected void Nt()
  {
    AppMethodBeat.i(144140);
    ae.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void Nu() {}
  
  protected void Nv() {}
  
  public final void a(c.a parama)
  {
    this.daO = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(194208);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(194208);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(194208);
      throw paramRunnable;
    }
    if (this.daM)
    {
      ae.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(194208);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.daK)
    {
      this.daK.c(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.daK.notify();
      }
      if ((paramBoolean) && (bool)) {
        ae.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(NE()) });
      }
      Nu();
      AppMethodBeat.o(194208);
      return;
    }
  }
  
  public final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(194207);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(194207);
      return;
    }
    if (this.daM)
    {
      ae.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(194207);
      return;
    }
    if (Thread.currentThread().getId() == this.daJ.getId())
    {
      t(paramRunnable);
      if (this.cYR.enable) {
        this.cYR.cZh.remove(null);
      }
    }
    for (;;)
    {
      Nu();
      AppMethodBeat.o(194207);
      return;
      boolean bool = isPaused();
      synchronized (this.daK)
      {
        this.daK.c(paramRunnable, paramBoolean);
        if ((paramBoolean) || (!bool))
        {
          this.daL = a.daV;
          this.daK.notify();
        }
        if ((!paramBoolean) || (!bool)) {
          continue;
        }
        ae.i("MicroMsg.V8JSRuntimeLooper", "schedule: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(NE()) });
      }
    }
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cYR.enable = paramBoolean;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(194211);
    if (this.daM)
    {
      this.daR = true;
      AppMethodBeat.o(194211);
      return true;
    }
    boolean bool1;
    synchronized (this.daK)
    {
      bool1 = isPaused();
      if ((!bool1) || (this.daK.Nw()))
      {
        boolean bool2 = Nq();
        if (!bool2) {
          break label147;
        }
      }
    }
    label147:
    this.daQ.clear();
    this.daK.a(this.daQ, bool1);
    Ns();
    AppMethodBeat.o(194211);
    return false;
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
    ae.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    while (!this.daM)
    {
      boolean bool1;
      synchronized (this.daK)
      {
        bool1 = isPaused();
        if ((!bool1) || (this.daK.Nw()))
        {
          boolean bool2 = Nq();
          if (!bool2) {
            break label156;
          }
        }
      }
      label156:
      this.daP.clear();
      this.daK.a(this.daP, bool1);
      Nr();
    }
    Nt();
    synchronized (this.daK)
    {
      this.daK.clear();
      AppMethodBeat.o(144132);
      return;
    }
  }
  
  protected void onResume() {}
  
  public final void pause()
  {
    AppMethodBeat.i(144136);
    ae.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(NE()) });
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
    ae.i("MicroMsg.V8JSRuntimeLooper", "quit %d", new Object[] { Integer.valueOf(hashCode()) });
    Nv();
    this.daM = true;
    this.daJ.interrupt();
    AppMethodBeat.o(144138);
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 103
    //   8: ldc_w 338
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 299	java/lang/Object:hashCode	()I
    //   21: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 258	com/tencent/mm/appbrand/v8/z:NE	()I
    //   31: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 314	com/tencent/mm/appbrand/v8/z:Ct	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 340	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 73	com/tencent/mm/appbrand/v8/z:daK	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 294	com/tencent/mm/appbrand/v8/z$a:daU	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 78	com/tencent/mm/appbrand/v8/z:daL	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 73	com/tencent/mm/appbrand/v8/z:daK	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 254	java/lang/Object:notify	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: ldc_w 336
    //   77: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc_w 336
    //   87: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: ldc_w 336
    //   98: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(194212);
    Iterator localIterator = this.daP.iterator();
    int i = -1;
    Runnable localRunnable;
    if (localIterator.hasNext())
    {
      localRunnable = (Runnable)localIterator.next();
      if ((!this.daN) || (!this.daM)) {
        break label71;
      }
      ae.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
    }
    for (;;)
    {
      this.daR = true;
      AppMethodBeat.o(194212);
      return;
      label71:
      int j = i + 1;
      i = j;
      if (j <= this.daS) {
        break;
      }
      this.daS = j;
      t(localRunnable);
      if (this.cYR.enable) {
        this.cYR.cZh.pollFirst();
      }
      i = j;
      if (!this.daR) {
        break;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(185105);
      daT = new a("NONE", 0);
      daU = new a("RESUME", 1);
      daV = new a("ENQUEUE", 2);
      daW = new a[] { daT, daU, daV };
      AppMethodBeat.o(185105);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */