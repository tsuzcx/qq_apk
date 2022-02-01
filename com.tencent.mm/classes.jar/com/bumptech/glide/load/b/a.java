package com.bumptech.glide.load.b;

import android.os.Process;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class a
{
  private final boolean aCC;
  final ReferenceQueue<p<?>> aFA;
  p.a aFB;
  volatile boolean aFC;
  volatile a aFD;
  private final Executor aFy;
  final Map<g, b> aFz;
  
  a(boolean paramBoolean)
  {
    this(paramBoolean, Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public final Thread newThread(final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(204455);
        paramAnonymousRunnable = new Thread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204454);
            Process.setThreadPriority(10);
            paramAnonymousRunnable.run();
            AppMethodBeat.o(204454);
          }
        }, "glide-active-resources");
        AppMethodBeat.o(204455);
        return paramAnonymousRunnable;
      }
    }));
    AppMethodBeat.i(76918);
    AppMethodBeat.o(76918);
  }
  
  private a(boolean paramBoolean, Executor paramExecutor)
  {
    AppMethodBeat.i(204456);
    this.aFz = new HashMap();
    this.aFA = new ReferenceQueue();
    this.aCC = paramBoolean;
    this.aFy = paramExecutor;
    paramExecutor.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76915);
        a locala = a.this;
        while (!locala.aFC) {
          try
          {
            locala.a((a.b)locala.aFA.remove());
            a.a locala1 = locala.aFD;
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
        AppMethodBeat.o(76915);
      }
    });
    AppMethodBeat.o(204456);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(76920);
    synchronized (this.aFB)
    {
      try
      {
        this.aFz.remove(paramb.aFH);
        if ((!paramb.aFI) || (paramb.aFJ == null)) {
          return;
        }
        p localp = new p(paramb.aFJ, true, false);
        localp.a(paramb.aFH, this.aFB);
        this.aFB.b(paramb.aFH, localp);
        return;
      }
      finally
      {
        AppMethodBeat.o(76920);
      }
    }
  }
  
  final void a(g paramg)
  {
    try
    {
      AppMethodBeat.i(204457);
      paramg = (b)this.aFz.remove(paramg);
      if (paramg != null) {
        paramg.reset();
      }
      AppMethodBeat.o(204457);
      return;
    }
    finally {}
  }
  
  final void a(g paramg, p<?> paramp)
  {
    try
    {
      AppMethodBeat.i(76919);
      paramp = new b(paramg, paramp, this.aFA, this.aCC);
      paramg = (b)this.aFz.put(paramg, paramp);
      if (paramg != null) {
        paramg.reset();
      }
      AppMethodBeat.o(76919);
      return;
    }
    finally {}
  }
  
  /* Error */
  final p<?> b(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 132
    //   4: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/bumptech/glide/load/b/a:aFz	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 135 2 0
    //   17: checkcast 15	com/bumptech/glide/load/b/a$b
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +14 -> 36
    //   25: aconst_null
    //   26: astore_1
    //   27: ldc 132
    //   29: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aload_2
    //   37: invokevirtual 138	com/bumptech/glide/load/b/a$b:get	()Ljava/lang/Object;
    //   40: checkcast 104	com/bumptech/glide/load/b/p
    //   43: astore_1
    //   44: aload_1
    //   45: ifnonnull +8 -> 53
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 140	com/bumptech/glide/load/b/a:a	(Lcom/bumptech/glide/load/b/a$b;)V
    //   53: ldc 132
    //   55: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   0	66	1	paramg	g
    //   20	30	2	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	21	61	finally
    //   27	32	61	finally
    //   36	44	61	finally
    //   48	53	61	finally
    //   53	58	61	finally
  }
  
  static abstract interface a {}
  
  static final class b
    extends WeakReference<p<?>>
  {
    final g aFH;
    final boolean aFI;
    v<?> aFJ;
    
    b(g paramg, p<?> paramp, ReferenceQueue<? super p<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      AppMethodBeat.i(76916);
      this.aFH = ((g)j.checkNotNull(paramg, "Argument must not be null"));
      if ((paramp.aFI) && (paramBoolean)) {}
      for (paramg = (v)j.checkNotNull(paramp.aFJ, "Argument must not be null");; paramg = null)
      {
        this.aFJ = paramg;
        this.aFI = paramp.aFI;
        AppMethodBeat.o(76916);
        return;
      }
    }
    
    final void reset()
    {
      AppMethodBeat.i(76917);
      this.aFJ = null;
      clear();
      AppMethodBeat.o(76917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a
 * JD-Core Version:    0.7.0.1
 */