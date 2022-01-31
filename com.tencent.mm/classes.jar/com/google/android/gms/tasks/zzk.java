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
    AppMethodBeat.i(57396);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafu = paramOnFailureListener;
    AppMethodBeat.o(57396);
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
    AppMethodBeat.i(57397);
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled())) {}
    synchronized (this.mLock)
    {
      if (this.zzafu == null)
      {
        AppMethodBeat.o(57397);
        return;
      }
      this.zzafk.execute(new zzl(this, paramTask));
      AppMethodBeat.o(57397);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzk
 * JD-Core Version:    0.7.0.1
 */