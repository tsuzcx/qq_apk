package com.google.android.gms.common.stats;

public abstract interface StatisticsTracker
{
  public abstract void registerEvent(ConnectionEvent paramConnectionEvent);
  
  public abstract void registerEvent(WakeLockEvent paramWakeLockEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatisticsTracker
 * JD-Core Version:    0.7.0.1
 */