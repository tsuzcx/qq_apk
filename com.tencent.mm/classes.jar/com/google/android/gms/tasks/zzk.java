package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzk<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  @GuardedBy("mLock")
  private OnFailureListener zzafu;
  
  public zzk(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(13395);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafu = paramOnFailureListener;
    AppMethodBeat.o(13395);
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzafu = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13396);
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled())) {}
    synchronized (this.mLock)
    {
      if (this.zzafu == null)
      {
        AppMethodBeat.o(13396);
        return;
      }
      this.zzafk.execute(new zzl(this, paramTask));
      AppMethodBeat.o(13396);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzk
 * JD-Core Version:    0.7.0.1
 */