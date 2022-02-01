package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zze<TResult, TContinuationResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult>
{
  private final Executor zzafk;
  private final Continuation<TResult, Task<TContinuationResult>> zzafl;
  private final zzu<TContinuationResult> zzafm;
  
  public zze(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzafk = paramExecutor;
    this.zzafl = paramContinuation;
    this.zzafm = paramzzu;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(13387);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(13387);
    throw localUnsupportedOperationException;
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(13386);
    this.zzafm.zzdp();
    AppMethodBeat.o(13386);
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13383);
    this.zzafk.execute(new zzf(this, paramTask));
    AppMethodBeat.o(13383);
  }
  
  public final void onFailure(Exception paramException)
  {
    AppMethodBeat.i(13385);
    this.zzafm.setException(paramException);
    AppMethodBeat.o(13385);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult)
  {
    AppMethodBeat.i(13384);
    this.zzafm.setResult(paramTContinuationResult);
    AppMethodBeat.o(13384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zze
 * JD-Core Version:    0.7.0.1
 */