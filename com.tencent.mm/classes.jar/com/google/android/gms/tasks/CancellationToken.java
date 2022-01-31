package com.google.android.gms.tasks;

public abstract class CancellationToken
{
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.CancellationToken
 * JD-Core Version:    0.7.0.1
 */