package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class hb
{
  private static final a a;
  private static final a b;
  private static final a c;
  private static final a d;
  private static final a e;
  private static ScheduledThreadPoolExecutor f;
  private static ThreadPoolExecutor g;
  private static ThreadPoolExecutor h;
  private static ThreadPoolExecutor i;
  private static ThreadPoolExecutor j;
  
  static
  {
    AppMethodBeat.i(225683);
    a = new a("sw");
    b = new a("lw");
    c = new a("mlw");
    d = new a("qw");
    e = new a("mqw");
    AppMethodBeat.o(225683);
  }
  
  public static ScheduledThreadPoolExecutor a()
  {
    try
    {
      AppMethodBeat.i(225617);
      if (a(f)) {
        f = new ScheduledThreadPoolExecutor(2, a.a(), new ThreadPoolExecutor.DiscardPolicy());
      }
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = f;
      AppMethodBeat.o(225617);
      return localScheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a(java.util.concurrent.ExecutorService paramExecutorService)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 76
    //   7: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ifnull +62 -> 73
    //   14: aload_0
    //   15: invokeinterface 82 1 0
    //   20: ifne +53 -> 73
    //   23: aload_0
    //   24: invokeinterface 85 1 0
    //   29: ifne +44 -> 73
    //   32: iconst_1
    //   33: istore_1
    //   34: iload_1
    //   35: istore_2
    //   36: aload_0
    //   37: instanceof 87
    //   40: ifeq +19 -> 59
    //   43: iload_1
    //   44: ifeq +34 -> 78
    //   47: aload_0
    //   48: checkcast 87	java/util/concurrent/ThreadPoolExecutor
    //   51: invokevirtual 90	java/util/concurrent/ThreadPoolExecutor:isTerminating	()Z
    //   54: ifne +24 -> 78
    //   57: iconst_1
    //   58: istore_2
    //   59: iload_2
    //   60: ifne +23 -> 83
    //   63: ldc 76
    //   65: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -41 -> 34
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -21 -> 59
    //   83: ldc 76
    //   85: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -22 -> 68
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramExecutorService	java.util.concurrent.ExecutorService
    //   33	42	1	k	int
    //   35	45	2	m	int
    //   1	89	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	93	finally
    //   14	32	93	finally
    //   36	43	93	finally
    //   47	57	93	finally
    //   63	68	93	finally
    //   83	88	93	finally
  }
  
  public static ThreadPoolExecutor b()
  {
    try
    {
      AppMethodBeat.i(225624);
      if (a(g)) {
        g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), d.a(), new ThreadPoolExecutor.DiscardPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = g;
      AppMethodBeat.o(225624);
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  public static ThreadPoolExecutor c()
  {
    try
    {
      AppMethodBeat.i(225632);
      if (a(h))
      {
        int k = Math.max(4, Runtime.getRuntime().availableProcessors());
        h = new ThreadPoolExecutor(k / 2, k, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.a(), new ThreadPoolExecutor.DiscardPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = h;
      AppMethodBeat.o(225632);
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  public static ThreadPoolExecutor d()
  {
    try
    {
      AppMethodBeat.i(225637);
      if (a(i)) {
        i = new ThreadPoolExecutor(0, 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a(), new ThreadPoolExecutor.DiscardPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = i;
      AppMethodBeat.o(225637);
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  private static ThreadPoolExecutor e()
  {
    try
    {
      AppMethodBeat.i(225648);
      if (a(j)) {
        j = new ThreadPoolExecutor(0, Math.max(4, Runtime.getRuntime().availableProcessors()) / 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.a(), new ThreadPoolExecutor.DiscardPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = j;
      AppMethodBeat.o(225648);
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  private static String f()
  {
    AppMethodBeat.i(225675);
    Object localObject = Thread.currentThread();
    localObject = localObject + ";" + ((Thread)localObject).getState() + ";interrupted=" + Thread.interrupted() + "|" + ((Thread)localObject).isInterrupted();
    AppMethodBeat.o(225675);
    return localObject;
  }
  
  public static final class a
    implements ThreadFactory
  {
    private String a;
    private final AtomicInteger b;
    
    public a(String paramString)
    {
      AppMethodBeat.i(226138);
      this.b = new AtomicInteger(0);
      this.a = paramString;
      if (TextUtils.isEmpty(paramString)) {
        this.a = "def";
      }
      AppMethodBeat.o(226138);
    }
    
    private int b()
    {
      AppMethodBeat.i(226145);
      int i = this.b.get();
      AppMethodBeat.o(226145);
      return i;
    }
    
    final a a()
    {
      AppMethodBeat.i(226164);
      this.b.set(0);
      AppMethodBeat.o(226164);
      return this;
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      AppMethodBeat.i(226157);
      paramRunnable = new Thread(paramRunnable, "tms-" + this.a + "-" + this.b.incrementAndGet());
      String str = "创建线程：".concat(String.valueOf(paramRunnable));
      if (kh.a != null) {
        kh.a.c(str);
      }
      for (;;)
      {
        AppMethodBeat.o(226157);
        return paramRunnable;
        System.out.println(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hb
 * JD-Core Version:    0.7.0.1
 */