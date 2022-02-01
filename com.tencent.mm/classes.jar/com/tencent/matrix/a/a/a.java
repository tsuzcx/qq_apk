package com.tencent.matrix.a.a;

import com.tencent.c.a.a.a;

public final class a
{
  public final com.tencent.c.a.a cqF;
  
  public final boolean GA()
  {
    return this.cqF.get(a.a.JJg.name(), false);
  }
  
  public final boolean Gy()
  {
    return this.cqF.get(a.a.JJa.name(), true);
  }
  
  public final boolean Gz()
  {
    return this.cqF.get(a.a.JJb.name(), false);
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(Gy()), Boolean.valueOf(Gy()), Boolean.valueOf(Gz()), Boolean.valueOf(GA()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */