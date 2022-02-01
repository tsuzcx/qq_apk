package com.tencent.e.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final int ahuv;
  public final float[] hpa;
  public final long timestamp;
  
  public j(SensorEvent paramSensorEvent, long paramLong)
  {
    AppMethodBeat.i(138414);
    this.ahuv = paramSensorEvent.sensor.getType();
    this.timestamp = paramLong;
    this.hpa = Arrays.copyOf(paramSensorEvent.values, paramSensorEvent.values.length);
    AppMethodBeat.o(138414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.j
 * JD-Core Version:    0.7.0.1
 */