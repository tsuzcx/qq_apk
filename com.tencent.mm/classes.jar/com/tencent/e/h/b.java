package com.tencent.e.h;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.e.c.c;
import com.tencent.e.d.a;
import com.tencent.e.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
  implements Handler.Callback
{
  private final a LUY;
  private final Handler LUZ;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183349);
    this.LUZ = com.tencent.e.e.d.a("ColdPoolLeader", this);
    this.LUY = new a(paramInt1, paramInt2);
    AppMethodBeat.o(183349);
  }
  
  protected final a.a fVM()
  {
    return this.LUY;
  }
  
  public final List<String> fVN()
  {
    AppMethodBeat.i(183352);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.LUY.getQueue().iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((localRunnable instanceof k)) {
        localLinkedList.add(((k)localRunnable).getKey());
      } else {
        localLinkedList.add(localRunnable.toString());
      }
    }
    AppMethodBeat.o(183352);
    return localLinkedList;
  }
  
  public final String getName()
  {
    return "ColdPool";
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(219281);
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof k))
    {
      this.LUY.execute((k)paramMessage);
      AppMethodBeat.o(219281);
      return true;
    }
    AppMethodBeat.o(219281);
    return false;
  }
  
  public final void j(k<?> paramk)
  {
    AppMethodBeat.i(183350);
    this.LUZ.removeCallbacksAndMessages(paramk);
    this.LUY.remove(paramk);
    AppMethodBeat.o(183350);
  }
  
  protected final void onShutdown()
  {
    AppMethodBeat.i(183351);
    this.LUY.shutdown();
    AppMethodBeat.o(183351);
  }
  
  final class a
    extends ThreadPoolExecutor
    implements a.a
  {
    private int LVa;
    private int LVb;
    private int ddL;
    
    a(int paramInt1, int paramInt2)
    {
      super(paramInt2, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactory()new RejectedExecutionHandler
      {
        AtomicInteger LVd;
        
        public final Thread newThread(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(183342);
          paramAnonymousRunnable = c.a("ColdPool#" + this.LVd.getAndIncrement(), paramAnonymousRunnable, 5);
          AppMethodBeat.o(183342);
          return paramAnonymousRunnable;
        }
      }, new RejectedExecutionHandler()
      {
        public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor) {}
      });
      AppMethodBeat.i(183345);
      this.LVb = 1;
      this.ddL = paramInt1;
      this.LVa = paramInt2;
      AppMethodBeat.o(183345);
    }
    
    protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      AppMethodBeat.i(183348);
      super.afterExecute(paramRunnable, paramThrowable);
      if ((getQueue().isEmpty()) && (getCorePoolSize() > this.ddL))
      {
        setCorePoolSize(this.ddL);
        this.LVb = 1;
        com.tencent.e.d.LTy.w("ColdPool", "reset to corePoolSize(%s)", new Object[] { Integer.valueOf(this.ddL) });
      }
      AppMethodBeat.o(183348);
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(219280);
      int i = getCorePoolSize();
      if ((getQueue().size() >= this.LVb * 10) && (i + 1 <= this.LVa))
      {
        setCorePoolSize(i + 1);
        com.tencent.e.d.LTy.w("ColdPool", "increment to expand cold pool; queue size=%s currentCoreSize=%s bufferSizeFactor=%s", new Object[] { Integer.valueOf(getQueue().size()), Integer.valueOf(i), Integer.valueOf(this.LVb) });
        this.LVb += 1;
      }
      super.execute(paramRunnable);
      AppMethodBeat.o(219280);
    }
    
    public final void i(k<?> paramk)
    {
      AppMethodBeat.i(183347);
      long l = paramk.getDelay(TimeUnit.MILLISECONDS);
      if (l <= 0L)
      {
        execute(paramk);
        AppMethodBeat.o(183347);
        return;
      }
      b.a(b.this).sendMessageAtTime(b.a(b.this).obtainMessage(0, paramk), l + SystemClock.uptimeMillis());
      AppMethodBeat.o(183347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.b
 * JD-Core Version:    0.7.0.1
 */