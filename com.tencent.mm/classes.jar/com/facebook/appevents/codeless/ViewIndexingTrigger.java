package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewIndexingTrigger
  implements SensorEventListener
{
  private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284D;
  private OnShakeListener mListener;
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(17526);
    if (this.mListener != null)
    {
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      double d1 = f1 / 9.80665F;
      double d2 = f2 / 9.80665F;
      double d3 = f3 / 9.80665F;
      if (Math.sqrt(d2 * d2 + d1 * d1 + d3 * d3) > 2.299999952316284D) {
        this.mListener.onShake();
      }
    }
    AppMethodBeat.o(17526);
  }
  
  public void setOnShakeListener(OnShakeListener paramOnShakeListener)
  {
    this.mListener = paramOnShakeListener;
  }
  
  public static abstract interface OnShakeListener
  {
    public abstract void onShake();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexingTrigger
 * JD-Core Version:    0.7.0.1
 */