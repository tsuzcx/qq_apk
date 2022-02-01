package com.tencent.e.h;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.e.e.d;
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

public final class c
  extends a
  implements Handler.Callback
{
  private final Handler LUZ;
  private final a LVf;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(183358);
    this.LUZ = d.a("HotPoolLeader", this);
    this.LVf = new a(paramInt);
    AppMethodBeat.o(183358);
  }
  
  protected final a.a fVM()
  {
    return this.LVf;
  }
  
  public final List<String> fVN()
  {
    AppMethodBeat.i(183361);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.LVf.getQueue().iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((localRunnable instanceof k)) {
        localLinkedList.add(((k)localRunnable).getKey());
      }
    }
    AppMethodBeat.o(183361);
    return localLinkedList;
  }
  
  public final String getName()
  {
    return "HotPool";
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(219282);
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof k))
    {
      this.LVf.execute((k)paramMessage);
      AppMethodBeat.o(219282);
      return true;
    }
    AppMethodBeat.o(219282);
    return false;
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(183360);
    if (this.LVf.getQueue().size() > 0)
    {
      AppMethodBeat.o(183360);
      return true;
    }
    AppMethodBeat.o(183360);
    return false;
  }
  
  public final void j(k<?> paramk)
  {
    AppMethodBeat.i(183359);
    this.LUZ.removeCallbacksAndMessages(paramk);
    this.LVf.remove(paramk);
    AppMethodBeat.o(183359);
  }
  
  public final void onShutdown()
  {
    AppMethodBeat.i(183362);
    this.LVf.shutdownNow();
    AppMethodBeat.o(183362);
  }
  
  final class a
    extends ThreadPoolExecutor
    implements a.a
  {
    a(int paramInt)
    {
      super(paramInt, 2147483647L, TimeUnit.HOURS, new LinkedBlockingQueue(), new ThreadFactory()new RejectedExecutionHandler
      {
        AtomicInteger LVd;
        
        public final Thread newThread(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(183354);
          paramAnonymousRunnable = com.tencent.e.c.c.a("HotPool#" + this.LVd.getAndIncrement(), paramAnonymousRunnable, 7);
          AppMethodBeat.o(183354);
          return paramAnonymousRunnable;
        }
      }, new RejectedExecutionHandler()
      {
        public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor) {}
      });
      AppMethodBeat.i(183355);
      AppMethodBeat.o(183355);
    }
    
    public final void i(k<?> paramk)
    {
      AppMethodBeat.i(183357);
      long l = paramk.getDelay(TimeUnit.MILLISECONDS);
      if (l <= 0L)
      {
        execute(paramk);
        AppMethodBeat.o(183357);
        return;
      }
      c.a(c.this).sendMessageAtTime(c.a(c.this).obtainMessage(0, paramk), l + SystemClock.uptimeMillis());
      AppMethodBeat.o(183357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.c
 * JD-Core Version:    0.7.0.1
 */