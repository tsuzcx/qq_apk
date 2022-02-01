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
  private static final ThreadLocal<z> fil;
  private boolean arU;
  private k fid;
  private final Thread fka;
  private final l<Runnable> fkb;
  private z.a fkc;
  private volatile boolean fkd;
  private final boolean fke;
  private c.a fkf;
  private Queue<Runnable> fkg;
  private Queue<Runnable> fkh;
  private boolean fki;
  private int fkj;
  
  static
  {
    AppMethodBeat.i(144143);
    fil = new ThreadLocal();
    AppMethodBeat.o(144143);
  }
  
  z(boolean paramBoolean)
  {
    AppMethodBeat.i(262803);
    l.a locala = l.fix;
    this.fkb = new l((Queue)new LinkedList());
    this.fkc = z.a.fkk;
    this.fid = new k();
    this.fkg = new LinkedList();
    this.fkh = new LinkedList();
    this.fki = false;
    this.fkj = -1;
    this.fka = Thread.currentThread();
    this.fke = paramBoolean;
    Log.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(262803);
  }
  
  private int acw()
  {
    AppMethodBeat.i(262814);
    synchronized (this.fkb)
    {
      int i = this.fkb.size();
      AppMethodBeat.o(262814);
      return i;
    }
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
      if (this.fkf != null) {
        this.fkf.b(paramRunnable);
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
  
  public final String OG()
  {
    AppMethodBeat.i(185106);
    String str = (String)this.fid.fiu.peek();
    AppMethodBeat.o(185106);
    return str;
  }
  
  public final void a(c.a parama)
  {
    this.fkf = parama;
  }
  
  public final boolean abY()
  {
    AppMethodBeat.i(144133);
    if (Thread.currentThread().getId() == this.fka.getId())
    {
      AppMethodBeat.o(144133);
      return true;
    }
    AppMethodBeat.o(144133);
    return false;
  }
  
  public final void acb()
  {
    AppMethodBeat.i(144132);
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    while (!this.fkd)
    {
      boolean bool1;
      synchronized (this.fkb)
      {
        bool1 = isPaused();
        if ((!bool1) || (this.fkb.acl()))
        {
          boolean bool2 = acf();
          if (!bool2) {
            break label151;
          }
        }
      }
      label151:
      this.fkg.clear();
      this.fkb.a(this.fkg, bool1);
      acg();
    }
    aci();
    synchronized (this.fkb)
    {
      this.fkb.clear();
      AppMethodBeat.o(144132);
      return;
    }
  }
  
  protected boolean acf()
  {
    AppMethodBeat.i(144139);
    boolean bool = this.fkb.isEmpty();
    AppMethodBeat.o(144139);
    return bool;
  }
  
  protected void acg()
  {
    AppMethodBeat.i(144141);
    this.fkj = -1;
    this.fki = false;
    Iterator localIterator = this.fkg.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.fke) && (this.fkd))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(144141);
        return;
      }
      this.fkj += 1;
      u(localRunnable);
      if (this.fid.enable) {
        this.fid.fiu.pollFirst();
      }
    } while (!this.fki);
    AppMethodBeat.o(144141);
  }
  
  protected void ach()
  {
    AppMethodBeat.i(262827);
    Iterator localIterator = this.fkh.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.fke) && (this.fkd))
      {
        Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        AppMethodBeat.o(262827);
        return;
      }
      u(localRunnable);
      if (this.fid.enable) {
        this.fid.fiu.pollFirst();
      }
    }
    AppMethodBeat.o(262827);
  }
  
  protected void aci()
  {
    AppMethodBeat.i(144140);
    Log.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(144140);
  }
  
  protected void acj() {}
  
  protected void ack() {}
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(262812);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(262812);
      return;
    }
    if (paramLong != 0L)
    {
      paramRunnable = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
      AppMethodBeat.o(262812);
      throw paramRunnable;
    }
    if (this.fkd)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
      AppMethodBeat.o(262812);
      return;
    }
    boolean bool = isPaused();
    synchronized (this.fkb)
    {
      this.fkb.c(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool)) {
        this.fkb.notify();
      }
      if ((paramBoolean) && (bool)) {
        Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(acw()) });
      }
      acj();
      AppMethodBeat.o(262812);
      return;
    }
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(262829);
    if (this.fkd)
    {
      this.fki = true;
      AppMethodBeat.o(262829);
      return true;
    }
    boolean bool1;
    synchronized (this.fkb)
    {
      bool1 = isPaused();
      if ((!bool1) || (this.fkb.acl()))
      {
        boolean bool2 = acf();
        if (!bool2) {
          break label145;
        }
      }
    }
    label145:
    this.fkh.clear();
    this.fkb.a(this.fkh, bool1);
    ach();
    AppMethodBeat.o(262829);
    return false;
  }
  
  public final void dp(boolean paramBoolean)
  {
    this.fid.enable = paramBoolean;
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.arU;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void onResume() {}
  
  public final void pause()
  {
    AppMethodBeat.i(144136);
    Log.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(acw()) });
    try
    {
      this.arU = true;
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
    ack();
    this.fkd = true;
    this.fka.interrupt();
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
    //   18: invokevirtual 194	java/lang/Object:hashCode	()I
    //   21: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: invokespecial 295	com/tencent/mm/appbrand/v8/z:acw	()I
    //   31: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 304	com/tencent/mm/appbrand/v8/z:arU	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokevirtual 321	com/tencent/mm/appbrand/v8/z:onResume	()V
    //   51: aload_0
    //   52: getfield 72	com/tencent/mm/appbrand/v8/z:fkb	Lcom/tencent/mm/appbrand/v8/l;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getstatic 216	com/tencent/mm/appbrand/v8/z$a:fkl	Lcom/tencent/mm/appbrand/v8/z$a;
    //   62: putfield 77	com/tencent/mm/appbrand/v8/z:fkc	Lcom/tencent/mm/appbrand/v8/z$a;
    //   65: aload_0
    //   66: getfield 72	com/tencent/mm/appbrand/v8/z:fkb	Lcom/tencent/mm/appbrand/v8/l;
    //   69: invokevirtual 291	java/lang/Object:notify	()V
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
    AppMethodBeat.i(262831);
    Iterator localIterator = this.fkg.iterator();
    int i = -1;
    Runnable localRunnable;
    if (localIterator.hasNext())
    {
      localRunnable = (Runnable)localIterator.next();
      if ((!this.fke) || (!this.fkd)) {
        break label72;
      }
      Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
    }
    for (;;)
    {
      this.fki = true;
      AppMethodBeat.o(262831);
      return;
      label72:
      int j = i + 1;
      i = j;
      if (j <= this.fkj) {
        break;
      }
      this.fkj = j;
      u(localRunnable);
      if (this.fid.enable) {
        this.fid.fiu.pollFirst();
      }
      i = j;
      if (!this.fki) {
        break;
      }
    }
  }
  
  public final void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(262811);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(262811);
      return;
    }
    if (this.fkd)
    {
      Log.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      AppMethodBeat.o(262811);
      return;
    }
    if (Thread.currentThread().getId() == this.fka.getId())
    {
      u(paramRunnable);
      if (this.fid.enable) {
        this.fid.fiu.remove(null);
      }
    }
    for (;;)
    {
      acj();
      AppMethodBeat.o(262811);
      return;
      boolean bool = isPaused();
      synchronized (this.fkb)
      {
        this.fkb.c(paramRunnable, false);
        if (!bool)
        {
          this.fkc = z.a.fkm;
          this.fkb.notify();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */