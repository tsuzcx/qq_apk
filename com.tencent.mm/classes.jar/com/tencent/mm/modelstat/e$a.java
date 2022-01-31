package com.tencent.mm.modelstat;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
{
  public int accuracy;
  public float[] values;
  
  public e$a(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(78717);
    this.accuracy = 0;
    if (paramSensorEvent != null)
    {
      this.accuracy = paramSensorEvent.accuracy;
      this.values = new float[paramSensorEvent.values.length];
      System.arraycopy(paramSensorEvent.values, 0, this.values, 0, paramSensorEvent.values.length);
    }
    AppMethodBeat.o(78717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.a
 * JD-Core Version:    0.7.0.1
 */