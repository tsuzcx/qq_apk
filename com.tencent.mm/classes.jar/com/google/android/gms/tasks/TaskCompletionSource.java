package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskCompletionSource<TResult>
{
  private final zzu<TResult> zzafh;
  
  public TaskCompletionSource()
  {
    AppMethodBeat.i(57341);
    this.zzafh = new zzu();
    AppMethodBeat.o(57341);
  }
  
  public TaskCompletionSource(CancellationToken paramCancellationToken)
  {
    AppMethodBeat.i(57342);
    this.zzafh = new zzu();
    paramCancellationToken.onCanceledRequested(new zzs(this));
    AppMethodBeat.o(57342);
  }
  
  public Task<TResult> getTask()
  {
    return this.zzafh;
  }
  
  public void setException(Exception paramException)
  {
    AppMethodBeat.i(57345);
    this.zzafh.setException(paramException);
    AppMethodBeat.o(57345);
  }
  
  public void setResult(TResult paramTResult)
  {
    AppMethodBeat.i(57343);
    this.zzafh.setResult(paramTResult);
    AppMethodBeat.o(57343);
  }
  
  public boolean trySetException(Exception paramException)
  {
    AppMethodBeat.i(57346);
    boolean bool = this.zzafh.trySetException(paramException);
    AppMethodBeat.o(57346);
    return bool;
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(57344);
    boolean bool = this.zzafh.trySetResult(paramTResult);
    AppMethodBeat.o(57344);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskCompletionSource
 * JD-Core Version:    0.7.0.1
 */