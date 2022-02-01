package com.google.android.gms.common.stats;

import android.os.Bundle;

public class StatisticalEventTrackerProvider
{
  private static StatisticalEventTracker zzyp;
  
  public static StatisticalEventTracker getImpl()
  {
    return zzyp;
  }
  
  public static void setImpl(StatisticalEventTracker paramStatisticalEventTracker)
  {
    zzyp = paramStatisticalEventTracker;
  }
  
  public static abstract interface StatisticalEventTracker
  {
    public abstract int getLogLevel(int paramInt);
    
    public abstract Bundle getOptions();
    
    public abstract boolean isEnabled();
    
    public abstract void registerEvent(ConnectionEvent paramConnectionEvent);
    
    public abstract void registerEvent(StatsEvent paramStatsEvent);
    
    public abstract void registerEvent(WakeLockEvent paramWakeLockEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatisticalEventTrackerProvider
 * JD-Core Version:    0.7.0.1
 */