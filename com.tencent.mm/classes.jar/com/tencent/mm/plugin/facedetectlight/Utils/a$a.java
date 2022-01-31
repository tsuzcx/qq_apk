package com.tencent.mm.plugin.facedetectlight.Utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  implements SensorEventListener
{
  private float mrw;
  
  private a$a(a parama) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(749);
    if (paramSensorEvent.sensor.getType() == 5) {
      this.mrw = paramSensorEvent.values[0];
    }
    AppMethodBeat.o(749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.a.a
 * JD-Core Version:    0.7.0.1
 */