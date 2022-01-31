package com.google.android.gms.tasks;

abstract interface zzf<TResult>
{
  public abstract void cancel();
  
  public abstract void onComplete(Task<TResult> paramTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.zzf
 * JD-Core Version:    0.7.0.1
 */