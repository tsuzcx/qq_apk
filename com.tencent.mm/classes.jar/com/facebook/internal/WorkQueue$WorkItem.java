package com.facebook.internal;

public abstract interface WorkQueue$WorkItem
{
  public abstract boolean cancel();
  
  public abstract boolean isRunning();
  
  public abstract void moveToFront();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.WorkQueue.WorkItem
 * JD-Core Version:    0.7.0.1
 */