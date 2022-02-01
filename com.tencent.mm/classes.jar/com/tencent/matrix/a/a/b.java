package com.tencent.matrix.a.a;

import com.tencent.c.a.a;
import com.tencent.c.a.a.a;

public final class b
{
  public final a cQF;
  
  public final boolean RR()
  {
    return this.cQF.get(a.a.RAf.name(), true);
  }
  
  public final boolean RS()
  {
    return this.cQF.get(a.a.RAg.name(), false);
  }
  
  public final boolean RT()
  {
    return this.cQF.get(a.a.RAl.name(), false);
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(RR()), Boolean.valueOf(RR()), Boolean.valueOf(RS()), Boolean.valueOf(RT()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.a.b
 * JD-Core Version:    0.7.0.1
 */