package com.google.android.gms.tasks;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract TContinuationResult then(Task<TResult> paramTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tasks.Continuation
 * JD-Core Version:    0.7.0.1
 */