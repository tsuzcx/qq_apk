package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public abstract StatsEvent ReconstructCloseEvent(StatsEvent paramStatsEvent);
  
  public abstract long getDurationMillis();
  
  public abstract long getElapsedRealtime();
  
  public abstract String getEventKey();
  
  public abstract int getEventType();
  
  public abstract String getSpecificString();
  
  public abstract long getTimeMillis();
  
  public abstract long getTimeout();
  
  public abstract StatsEvent markTimeOut();
  
  public abstract StatsEvent setDurationMillis(long paramLong);
  
  public abstract StatsEvent setEventType(int paramInt);
  
  public String toString()
  {
    long l1 = getTimeMillis();
    int i = getEventType();
    long l2 = getDurationMillis();
    String str = getSpecificString();
    return String.valueOf(str).length() + 53 + l1 + "\t" + i + "\t" + l2 + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatsEvent
 * JD-Core Version:    0.7.0.1
 */