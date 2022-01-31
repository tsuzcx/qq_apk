package com.tencent.e.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final int Ble;
  public final long timestamp;
  public final float[] values;
  
  public j(SensorEvent paramSensorEvent, long paramLong)
  {
    AppMethodBeat.i(114573);
    this.Ble = paramSensorEvent.sensor.getType();
    this.timestamp = paramLong;
    this.values = Arrays.copyOf(paramSensorEvent.values, paramSensorEvent.values.length);
    AppMethodBeat.o(114573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.e.a.a.j
 * JD-Core Version:    0.7.0.1
 */