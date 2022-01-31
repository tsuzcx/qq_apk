package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzm<TResult>
  implements zzq<TResult>
{
  private final Object mLock;
  private final Executor zzafk;
  @GuardedBy("mLock")
  private OnSuccessListener<? super TResult> zzafw;
  
  public zzm(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(57399);
    this.mLock = new Object();
    this.zzafk = paramExecutor;
    this.zzafw = paramOnSuccessListener;
    AppMethodBeat.o(57399);
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzafw = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(57400);
    if (paramTask.isSuccessful()) {}
    synchronized (this.mLock)
    {
      if (this.zzafw == null)
      {
        AppMethodBeat.o(57400);
        return;
      }
      this.zzafk.execute(new zzn(this, paramTask));
      AppMethodBeat.o(57400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzm
 * JD-Core Version:    0.7.0.1
 */