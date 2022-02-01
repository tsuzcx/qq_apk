package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "hardWaitDurationMs", "", "(J)V", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "isLoading", "", "()Z", "setLoading", "(Z)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "getResponse", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "setResponse", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", "clearCache", "getCache", "", "call", "Lkotlin/Function1;", "isHasCached", "request", "Lkotlin/Function0;", "setCache", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q<T extends k>
  implements l<T>
{
  private final long BkN;
  public volatile IResponse<T> BkO;
  private final ReentrantLock bKF;
  private final Condition hbM;
  public volatile boolean isLoading;
  
  private q()
  {
    AppMethodBeat.i(366510);
    this.BkN = 0L;
    this.bKF = new ReentrantLock();
    this.hbM = this.bKF.newCondition();
    AppMethodBeat.o(366510);
  }
  
  public final void aT(a<ah> parama)
  {
    AppMethodBeat.i(366529);
    s.u(parama, "call");
    this.bKF.lock();
    try
    {
      this.isLoading = true;
      this.bKF.unlock();
      parama.invoke();
      AppMethodBeat.o(366529);
      return;
    }
    finally
    {
      this.bKF.unlock();
      AppMethodBeat.o(366529);
    }
  }
  
  /* Error */
  public final void al(kotlin.g.a.b<? super IResponse<T>, ah> paramb)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 89
    //   8: invokestatic 95	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   15: invokevirtual 97	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: getfield 99	com/tencent/mm/plugin/finder/feed/model/internal/q:isLoading	Z
    //   22: ifeq +85 -> 107
    //   25: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   28: lstore_2
    //   29: aload_0
    //   30: getfield 79	com/tencent/mm/plugin/finder/feed/model/internal/q:hbM	Ljava/util/concurrent/locks/Condition;
    //   33: lconst_1
    //   34: getstatic 125	java/util/concurrent/TimeUnit:MINUTES	Ljava/util/concurrent/TimeUnit;
    //   37: invokeinterface 131 4 0
    //   42: pop
    //   43: aload_0
    //   44: getfield 68	com/tencent/mm/plugin/finder/feed/model/internal/q:BkN	J
    //   47: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   50: lload_2
    //   51: lsub
    //   52: lsub
    //   53: lstore_2
    //   54: lload_2
    //   55: lconst_0
    //   56: lcmp
    //   57: ifle +17 -> 74
    //   60: aload_0
    //   61: getfield 79	com/tencent/mm/plugin/finder/feed/model/internal/q:hbM	Ljava/util/concurrent/locks/Condition;
    //   64: lload_2
    //   65: getstatic 134	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   68: invokeinterface 131 4 0
    //   73: pop
    //   74: aload_0
    //   75: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   78: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   81: aload_0
    //   82: getfield 136	com/tencent/mm/plugin/finder/feed/model/internal/q:BkO	Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;
    //   85: astore 4
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 136	com/tencent/mm/plugin/finder/feed/model/internal/q:BkO	Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;
    //   92: aload_1
    //   93: aload 4
    //   95: invokeinterface 141 2 0
    //   100: pop
    //   101: ldc 113
    //   103: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: aload_0
    //   108: getfield 136	com/tencent/mm/plugin/finder/feed/model/internal/q:BkO	Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;
    //   111: ifnull -37 -> 74
    //   114: aload_0
    //   115: getfield 68	com/tencent/mm/plugin/finder/feed/model/internal/q:BkN	J
    //   118: lconst_0
    //   119: lcmp
    //   120: ifle -46 -> 74
    //   123: aload_0
    //   124: getfield 79	com/tencent/mm/plugin/finder/feed/model/internal/q:hbM	Ljava/util/concurrent/locks/Condition;
    //   127: aload_0
    //   128: getfield 68	com/tencent/mm/plugin/finder/feed/model/internal/q:BkN	J
    //   131: getstatic 134	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   134: invokeinterface 131 4 0
    //   139: pop
    //   140: goto -66 -> 74
    //   143: astore_1
    //   144: aload_0
    //   145: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   148: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   151: ldc 113
    //   153: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	q
    //   0	158	1	paramb	kotlin.g.a.b<? super IResponse<T>, ah>
    //   28	37	2	l	long
    //   85	9	4	localIResponse	IResponse
    // Exception table:
    //   from	to	target	type
    //   18	54	143	finally
    //   60	74	143	finally
    //   107	140	143	finally
  }
  
  public final void b(IResponse<T> paramIResponse)
  {
    AppMethodBeat.i(366523);
    s.u(paramIResponse, "response");
    this.bKF.lock();
    try
    {
      this.BkO = paramIResponse;
      this.hbM.signalAll();
      return;
    }
    finally
    {
      this.isLoading = false;
      this.bKF.unlock();
      AppMethodBeat.o(366523);
    }
  }
  
  /* Error */
  public final boolean clearCache()
  {
    // Byte code:
    //   0: ldc 150
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 97	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: getfield 136	com/tencent/mm/plugin/finder/feed/model/internal/q:BkO	Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;
    //   16: ifnull +24 -> 40
    //   19: iconst_1
    //   20: istore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 136	com/tencent/mm/plugin/finder/feed/model/internal/q:BkO	Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;
    //   26: aload_0
    //   27: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   30: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   33: ldc 150
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iload_1
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_1
    //   42: goto -21 -> 21
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 73	com/tencent/mm/plugin/finder/feed/model/internal/q:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: ldc 150
    //   55: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	q
    //   20	22	1	bool	boolean
    //   45	14	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	19	45	finally
    //   21	26	45	finally
  }
  
  public final boolean eee()
  {
    return this.BkO != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.q
 * JD-Core Version:    0.7.0.1
 */