package com.tencent.mm.modelstat;

import android.hardware.SensorEvent;

final class e$a
{
  public int accuracy = 0;
  public float[] values;
  
  public e$a(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent != null)
    {
      this.accuracy = paramSensorEvent.accuracy;
      this.values = new float[paramSensorEvent.values.length];
      System.arraycopy(paramSensorEvent.values, 0, this.values, 0, paramSensorEvent.values.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.a
 * JD-Core Version:    0.7.0.1
 */