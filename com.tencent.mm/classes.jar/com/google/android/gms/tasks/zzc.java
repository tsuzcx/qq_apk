package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult>
  implements zzq<TResult>
{
  private final Executor zzafk;
  private final Continuation<TResult, TContinuationResult> zzafl;
  private final zzu<TContinuationResult> zzafm;
  
  public zzc(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzafk = paramExecutor;
    this.zzafl = paramContinuation;
    this.zzafm = paramzzu;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(13381);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(13381);
    throw localUnsupportedOperationException;
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13380);
    this.zzafk.execute(new zzd(this, paramTask));
    AppMethodBeat.o(13380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zzc
 * JD-Core Version:    0.7.0.1
 */