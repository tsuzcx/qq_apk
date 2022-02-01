package com.tencent.e;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.e.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h
  implements c, i
{
  public static i MqF;
  public static c MqG;
  private AtomicBoolean MqH;
  private a MqI;
  final com.tencent.e.h.e MqJ;
  
  private h(a parama)
  {
    AppMethodBeat.i(183164);
    this.MqH = new AtomicBoolean(false);
    this.MqI = parama;
    this.MqJ = new com.tencent.e.h.e(parama);
    AppMethodBeat.o(183164);
  }
  
  private com.tencent.e.i.d<?> a(Runnable paramRunnable, final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(216737);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(216737);
    return paramRunnable;
  }
  
  private com.tencent.e.i.d<?> a(Runnable paramRunnable, final long paramLong, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(183188);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(183188);
    return paramRunnable;
  }
  
  static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(183163);
      parama = new h(parama);
      MqF = parama;
      MqG = parama;
      AppMethodBeat.o(183163);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private com.tencent.e.i.d<?> c(Runnable paramRunnable, final long paramLong, String paramString)
  {
    AppMethodBeat.i(216736);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(216736);
    return paramRunnable;
  }
  
  private com.tencent.e.i.d<?> c(Runnable paramRunnable, final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(183186);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(183186);
    return paramRunnable;
  }
  
  private com.tencent.e.i.d<?> j(Runnable paramRunnable, final String paramString)
  {
    AppMethodBeat.i(216735);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(216735);
    return paramRunnable;
  }
  
  private com.tencent.e.i.d<?> t(Runnable paramRunnable, final long paramLong)
  {
    AppMethodBeat.i(183187);
    paramRunnable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramRunnable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(183187);
    return paramRunnable;
  }
  
  public final b a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    AppMethodBeat.i(183185);
    paramString = new b(paramString, paramInt1, paramInt2, paramBlockingQueue, new b.a());
    AppMethodBeat.o(183185);
    return paramString;
  }
  
  public final com.tencent.e.i.d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216734);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, paramLong1, paramLong2, false);
    AppMethodBeat.o(216734);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> a(Runnable paramRunnable, long paramLong, String paramString)
  {
    AppMethodBeat.i(183174);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, paramLong, paramString, false);
    AppMethodBeat.o(183174);
    return paramRunnable;
  }
  
  public final <T> com.tencent.e.i.d<T> a(Callable<T> paramCallable, final String paramString)
  {
    AppMethodBeat.i(183172);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramCallable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(183172);
    return paramCallable;
  }
  
  public final com.tencent.e.i.d<?> aM(Runnable paramRunnable)
  {
    AppMethodBeat.i(183165);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, false);
    AppMethodBeat.o(183165);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(183167);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, true);
    AppMethodBeat.o(183167);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> aO(Runnable paramRunnable)
  {
    AppMethodBeat.i(183168);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = r(paramRunnable, 0L);
    AppMethodBeat.o(183168);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> aP(Runnable paramRunnable)
  {
    AppMethodBeat.i(183175);
    Objects.requireNonNull(paramRunnable);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = j(paramRunnable, null);
    AppMethodBeat.o(183175);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> aQ(Runnable paramRunnable)
  {
    AppMethodBeat.i(183176);
    Objects.requireNonNull(paramRunnable);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, null);
    AppMethodBeat.o(183176);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> aR(Runnable paramRunnable)
  {
    AppMethodBeat.i(183178);
    paramRunnable = aP(paramRunnable);
    AppMethodBeat.o(183178);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> b(Runnable paramRunnable, long paramLong, String paramString)
  {
    AppMethodBeat.i(216733);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, paramLong, paramString);
    AppMethodBeat.o(216733);
    return paramRunnable;
  }
  
  public final boolean bbc(String paramString)
  {
    AppMethodBeat.i(183179);
    Objects.requireNonNull(paramString);
    paramString = com.tencent.e.j.a.bbj(paramString);
    if (paramString != null)
    {
      paramString.Msx.clear();
      AppMethodBeat.o(183179);
      return true;
    }
    AppMethodBeat.o(183179);
    return false;
  }
  
  public final b bbd(String paramString)
  {
    AppMethodBeat.i(183184);
    paramString = new b(paramString, 1, 1, new LinkedBlockingQueue(), new b.a());
    AppMethodBeat.o(183184);
    return paramString;
  }
  
  public final <T> com.tencent.e.i.d<T> d(Callable<T> paramCallable)
  {
    AppMethodBeat.i(216731);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.e.i.d)com.tencent.e.e.e.ez(paramCallable).a(new com.tencent.e.e.a() {}).a(new com.tencent.e.e.a() {}).take();
    AppMethodBeat.o(216731);
    return paramCallable;
  }
  
  public final com.tencent.e.i.d<?> f(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(183171);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, 0L, paramString);
    AppMethodBeat.o(183171);
    return paramRunnable;
  }
  
  public final Map<String, Integer> fZS()
  {
    AppMethodBeat.i(183182);
    Map localMap = com.tencent.e.g.h.MrI.gak();
    AppMethodBeat.o(183182);
    return localMap;
  }
  
  public final Map<String, List<Pair<String, Integer>>> fZT()
  {
    AppMethodBeat.i(183183);
    long l1 = SystemClock.uptimeMillis();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.MqJ.fZT().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Object localObject = new HashMap();
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      if (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        Pair localPair = (Pair)((HashMap)localObject).get(str);
        if (localPair == null) {}
        for (int i = 1;; i = ((Integer)localPair.second).intValue() + 1)
        {
          ((HashMap)localObject).put(str, new Pair(str, Integer.valueOf(i))
          {
            public final String toString()
            {
              AppMethodBeat.i(183145);
              String str = "(" + (String)this.first + " -> " + this.second + ")";
              AppMethodBeat.o(183145);
              return str;
            }
          });
          break;
        }
      }
      localObject = new LinkedList(((HashMap)localObject).values());
      Collections.sort((List)localObject, new Comparator() {});
      localHashMap.put(localEntry.getKey(), localObject);
    }
    long l2 = SystemClock.uptimeMillis();
    d.Mqv.i("ThreadPool", "[dumpWaitingTask] cost=" + (l2 - l1) + "ms", new Object[0]);
    AppMethodBeat.o(183183);
    return localHashMap;
  }
  
  /* Error */
  public final boolean fZV()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 385
    //   7: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 73	com/tencent/e/h:MqH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokevirtual 389	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   19: ifeq +74 -> 93
    //   22: invokestatic 392	com/tencent/e/j/a:release	()V
    //   25: aload_0
    //   26: getfield 81	com/tencent/e/h:MqJ	Lcom/tencent/e/h/e;
    //   29: astore_2
    //   30: aload_2
    //   31: getfield 396	com/tencent/e/h/e:Msd	Lcom/tencent/e/h/b;
    //   34: invokevirtual 401	com/tencent/e/h/b:shutdown	()V
    //   37: aload_2
    //   38: getfield 405	com/tencent/e/h/e:Mse	Lcom/tencent/e/h/c;
    //   41: invokevirtual 408	com/tencent/e/h/c:shutdown	()V
    //   44: aload_2
    //   45: getfield 412	com/tencent/e/h/e:Msf	Lcom/tencent/e/h/f;
    //   48: invokevirtual 415	com/tencent/e/h/f:shutdown	()V
    //   51: getstatic 355	com/tencent/e/d:Mqv	Lcom/tencent/e/d$a;
    //   54: ldc_w 417
    //   57: ldc_w 419
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokeinterface 382 4 0
    //   69: invokestatic 422	com/tencent/e/e/h:release	()V
    //   72: invokestatic 425	com/tencent/e/e/d:release	()V
    //   75: getstatic 429	com/tencent/e/d:Mqt	Lcom/tencent/e/d$e;
    //   78: invokeinterface 432 1 0
    //   83: ldc_w 385
    //   86: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: iload_1
    //   92: ireturn
    //   93: ldc_w 385
    //   96: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_0
    //   100: istore_1
    //   101: goto -12 -> 89
    //   104: astore_2
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	h
    //   1	100	1	bool	boolean
    //   29	16	2	locale	com.tencent.e.h.e
    //   104	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	89	104	finally
    //   93	99	104	finally
  }
  
  public final a fZW()
  {
    return this.MqI;
  }
  
  public final com.tencent.e.i.d<?> g(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(183173);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, 0L, paramString, true);
    AppMethodBeat.o(183173);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> h(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(216730);
    Objects.requireNonNull(paramRunnable);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = j(paramRunnable, paramString);
    AppMethodBeat.o(216730);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> i(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(216732);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = b(paramRunnable, 0L, paramString);
    AppMethodBeat.o(216732);
    return paramRunnable;
  }
  
  public final boolean isShutdown()
  {
    AppMethodBeat.i(183180);
    boolean bool = this.MqH.get();
    AppMethodBeat.o(183180);
    return bool;
  }
  
  public final com.tencent.e.i.d<?> q(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183166);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, paramLong, false);
    AppMethodBeat.o(183166);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183170);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = t(paramRunnable, paramLong);
    AppMethodBeat.o(183170);
    return paramRunnable;
  }
  
  public final com.tencent.e.i.d<?> s(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183177);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, 0L, paramLong, true);
    AppMethodBeat.o(183177);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h
 * JD-Core Version:    0.7.0.1
 */