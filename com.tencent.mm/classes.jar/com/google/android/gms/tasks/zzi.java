package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzi<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  @GuardedBy("mLock")
  private OnCompleteListener<TResult> zzafs;
  
  public zzi(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(57393);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafs = paramOnCompleteListener;
    AppMethodBeat.o(57393);
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
    AppMethodBeat.i(57394);
    synchronized (this.mLock)
    {
      if (this.zzafs == null)
      {
        AppMethodBeat.o(57394);
        return;
      }
      this.zzafk.execute(new zzj(this, paramTask));
      AppMethodBeat.o(57394);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzi
 * JD-Core Version:    0.7.0.1
 */