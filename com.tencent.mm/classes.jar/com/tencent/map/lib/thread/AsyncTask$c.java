package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.Executor;

class AsyncTask$c
  implements Executor
{
  final LinkedList<Runnable> a;
  Runnable b;
  
  private AsyncTask$c()
  {
    AppMethodBeat.i(98171);
    this.a = new LinkedList();
    AppMethodBeat.o(98171);
  }
  
  protected void a()
  {
    try
    {
      AppMethodBeat.i(98173);
      Runnable localRunnable = (Runnable)this.a.poll();
      this.b = localRunnable;
      if (localRunnable != null) {
        AsyncTask.sHighThreadExecutor.execute(this.b);
      }
      AppMethodBeat.o(98173);
      return;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      AppMethodBeat.i(98172);
      this.a.offer(new AsyncTask.c.1(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      AppMethodBeat.o(98172);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.c
 * JD-Core Version:    0.7.0.1
 */