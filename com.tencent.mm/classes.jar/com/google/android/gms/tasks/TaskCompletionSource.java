package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskCompletionSource<TResult>
{
  private final zzu<TResult> zzafh;
  
  public TaskCompletionSource()
  {
    AppMethodBeat.i(13340);
    this.zzafh = new zzu();
    AppMethodBeat.o(13340);
  }
  
  public TaskCompletionSource(CancellationToken paramCancellationToken)
  {
    AppMethodBeat.i(13341);
    this.zzafh = new zzu();
    paramCancellationToken.onCanceledRequested(new zzs(this));
    AppMethodBeat.o(13341);
  }
  
  public Task<TResult> getTask()
  {
    return this.zzafh;
  }
  
  public void setException(Exception paramException)
  {
    AppMethodBeat.i(13344);
    this.zzafh.setException(paramException);
    AppMethodBeat.o(13344);
  }
  
  public void setResult(TResult paramTResult)
  {
    AppMethodBeat.i(13342);
    this.zzafh.setResult(paramTResult);
    AppMethodBeat.o(13342);
  }
  
  public boolean trySetException(Exception paramException)
  {
    AppMethodBeat.i(13345);
    boolean bool = this.zzafh.trySetException(paramException);
    AppMethodBeat.o(13345);
    return bool;
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(13343);
    boolean bool = this.zzafh.trySetResult(paramTResult);
    AppMethodBeat.o(13343);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskCompletionSource
 * JD-Core Version:    0.7.0.1
 */