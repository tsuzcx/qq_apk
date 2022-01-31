package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult>
{
  private final zzh<TResult> zzbNG = new zzh();
  
  public Task<TResult> getTask()
  {
    return this.zzbNG;
  }
  
  public void setException(Exception paramException)
  {
    this.zzbNG.setException(paramException);
  }
  
  public void setResult(TResult paramTResult)
  {
    this.zzbNG.setResult(paramTResult);
  }
  
  public boolean trySetException(Exception paramException)
  {
    return this.zzbNG.trySetException(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    return this.zzbNG.trySetResult(paramTResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskCompletionSource
 * JD-Core Version:    0.7.0.1
 */