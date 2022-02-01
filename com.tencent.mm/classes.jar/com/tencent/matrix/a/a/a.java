package com.tencent.matrix.a.a;

import com.tencent.c.a.a.a;

public final class a
{
  public final com.tencent.c.a.a cBC;
  
  public final boolean HT()
  {
    return this.cBC.get(a.a.LCJ.name(), true);
  }
  
  public final boolean HU()
  {
    return this.cBC.get(a.a.LCK.name(), false);
  }
  
  public final boolean HV()
  {
    return this.cBC.get(a.a.LCP.name(), false);
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(HT()), Boolean.valueOf(HT()), Boolean.valueOf(HU()), Boolean.valueOf(HV()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */