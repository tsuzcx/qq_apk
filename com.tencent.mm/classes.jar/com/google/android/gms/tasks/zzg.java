package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzg<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  private OnCanceledListener zzafq;
  
  public zzg(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(13389);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafq = paramOnCanceledListener;
    AppMethodBeat.o(13389);
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
    AppMethodBeat.i(13390);
    if (???.isCanceled()) {}
    synchronized (this.mLock)
    {
      if (this.zzafq == null)
      {
        AppMethodBeat.o(13390);
        return;
      }
      this.zzafk.execute(new zzh(this));
      AppMethodBeat.o(13390);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.zzg
 * JD-Core Version:    0.7.0.1
 */