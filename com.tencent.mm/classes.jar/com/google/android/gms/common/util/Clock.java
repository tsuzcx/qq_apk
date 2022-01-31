package com.google.android.gms.common.util;

public abstract interface Clock
{
  public abstract long currentThreadTimeMillis();
  
  public abstract long currentTimeMillis();
  
  public abstract long elapsedRealtime();
  
  public abstract long nanoTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.Clock
 * JD-Core Version:    0.7.0.1
 */