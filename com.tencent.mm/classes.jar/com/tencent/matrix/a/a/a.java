package com.tencent.matrix.a.a;

import com.tencent.c.a.a.a;

public final class a
{
  public final com.tencent.c.a.a cty;
  
  public final boolean GN()
  {
    return this.cty.get(a.a.Ihs.name(), true);
  }
  
  public final boolean GO()
  {
    return this.cty.get(a.a.Iht.name(), false);
  }
  
  public final boolean GP()
  {
    return this.cty.get(a.a.Ihy.name(), false);
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[] { Boolean.valueOf(GN()), Boolean.valueOf(GN()), Boolean.valueOf(GO()), Boolean.valueOf(GP()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */