package com.tencent.d.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final int ZpN;
  public final float[] fkN;
  public final long timestamp;
  
  public j(SensorEvent paramSensorEvent, long paramLong)
  {
    AppMethodBeat.i(138414);
    this.ZpN = paramSensorEvent.sensor.getType();
    this.timestamp = paramLong;
    this.fkN = Arrays.copyOf(paramSensorEvent.values, paramSensorEvent.values.length);
    AppMethodBeat.o(138414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.j
 * JD-Core Version:    0.7.0.1
 */