package com.tencent.matrix.a.a;

import com.tencent.mrs.b.a.a;

public final class a
{
  public final com.tencent.mrs.b.a bMc;
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(yE()), Boolean.valueOf(yE()), Boolean.valueOf(yG()), Boolean.valueOf(yH()) });
  }
  
  public final boolean yE()
  {
    return this.bMc.get(a.a.BaH.name(), true);
  }
  
  public final boolean yF()
  {
    return this.bMc.get(a.a.BaM.name(), true);
  }
  
  public final boolean yG()
  {
    return this.bMc.get(a.a.BaI.name(), false);
  }
  
  public final boolean yH()
  {
    return this.bMc.get(a.a.BaN.name(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */