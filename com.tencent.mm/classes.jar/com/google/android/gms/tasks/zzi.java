package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzi<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  private OnCompleteListener<TResult> zzafs;
  
  public zzi(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(13392);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafs = paramOnCompleteListener;
    AppMethodBeat.o(13392);
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzafs = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13393);
    synchronized (this.mLock)
    {
      if (this.zzafs == null)
      {
        AppMethodBeat.o(13393);
        return;
      }
      this.zzafk.execute(new zzj(this, paramTask));
      AppMethodBeat.o(13393);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.zzi
 * JD-Core Version:    0.7.0.1
 */