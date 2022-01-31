package com.tencent.d.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.Arrays;

public final class j
{
  public final long timestamp;
  public final float[] values;
  public final int wNF;
  
  public j(SensorEvent paramSensorEvent, long paramLong)
  {
    this.wNF = paramSensorEvent.sensor.getType();
    this.timestamp = paramLong;
    this.values = Arrays.copyOf(paramSensorEvent.values, paramSensorEvent.values.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.j
 * JD-Core Version:    0.7.0.1
 */