package com.tencent.matrix.a.a;

import com.tencent.c.a.a.a;

public final class a
{
  public final com.tencent.c.a.a cCj;
  
  public final boolean Ib()
  {
    return this.cCj.get(a.a.LZN.name(), true);
  }
  
  public final boolean Ic()
  {
    return this.cCj.get(a.a.LZO.name(), false);
  }
  
  public final boolean Id()
  {
    return this.cCj.get(a.a.LZT.name(), false);
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(Ib()), Boolean.valueOf(Ib()), Boolean.valueOf(Ic()), Boolean.valueOf(Id()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */