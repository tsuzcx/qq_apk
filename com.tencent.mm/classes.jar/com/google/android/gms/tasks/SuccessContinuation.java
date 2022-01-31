package com.google.android.gms.tasks;

public abstract interface SuccessContinuation<TResult, TContinuationResult>
{
  public abstract Task<TContinuationResult> then(TResult paramTResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.SuccessContinuation
 * JD-Core Version:    0.7.0.1
 */