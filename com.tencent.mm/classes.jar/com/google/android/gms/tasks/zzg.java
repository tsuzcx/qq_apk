package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzg<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  @GuardedBy("mLock")
  private OnCanceledListener zzafq;
  
  public zzg(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(57390);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafq = paramOnCanceledListener;
    AppMethodBeat.o(57390);
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzafq = null;
      return;
    }
  }
  
  public final void onComplete(Task arg1)
  {
    AppMethodBeat.i(57391);
    if (???.isCanceled()) {}
    synchronized (this.mLock)
    {
      if (this.zzafq == null)
      {
        AppMethodBeat.o(57391);
        return;
      }
      this.zzafk.execute(new zzh(this));
      AppMethodBeat.o(57391);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzg
 * JD-Core Version:    0.7.0.1
 */