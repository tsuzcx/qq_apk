package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzo<TResult, TContinuationResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult>
{
  private final Executor zzafk;
  private final zzu<TContinuationResult> zzafm;
  private final SuccessContinuation<TResult, TContinuationResult> zzafy;
  
  public zzo(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzafk = paramExecutor;
    this.zzafy = paramSuccessContinuation;
    this.zzafm = paramzzu;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(57403);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57403);
    throw localUnsupportedOperationException;
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(57406);
    this.zzafm.zzdp();
    AppMethodBeat.o(57406);
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(57402);
    this.zzafk.execute(new zzp(this, paramTask));
    AppMethodBeat.o(57402);
  }
  
  public final void onFailure(Exception paramException)
  {
    AppMethodBeat.i(57405);
    this.zzafm.setException(paramException);
    AppMethodBeat.o(57405);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult)
  {
    AppMethodBeat.i(57404);
    this.zzafm.setResult(paramTContinuationResult);
    AppMethodBeat.o(57404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzo
 * JD-Core Version:    0.7.0.1
 */