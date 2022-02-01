package com.tencent.mm.plugin.facedetectlight.Utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private boolean mHasStarted = false;
  private SensorManager mSensorManager;
  private a ryT;
  
  public final void cvR()
  {
    AppMethodBeat.i(104273);
    if (this.mHasStarted)
    {
      AppMethodBeat.o(104273);
      return;
    }
    this.mHasStarted = true;
    new StringBuilder("lightSensor has started:").append(this.mHasStarted);
    this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    Sensor localSensor = this.mSensorManager.getDefaultSensor(5);
    if (localSensor != null)
    {
      this.ryT = new a((byte)0);
      this.mSensorManager.registerListener(this.ryT, localSensor, 3);
    }
    AppMethodBeat.o(104273);
  }
  
  public final float getLux()
  {
    AppMethodBeat.i(104274);
    if (this.ryT != null)
    {
      new StringBuilder("Light lux: ").append(a.a(this.ryT));
      float f = a.a(this.ryT);
      AppMethodBeat.o(104274);
      return f;
    }
    AppMethodBeat.o(104274);
    return -1.0F;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(104275);
    if ((!this.mHasStarted) || (this.mSensorManager == null))
    {
      AppMethodBeat.o(104275);
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.ryT);
    AppMethodBeat.o(104275);
  }
  
  final class a
    implements SensorEventListener
  {
    private float lux;
    
    private a() {}
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(104271);
      if (paramSensorEvent.sensor.getType() == 5) {
        this.lux = paramSensorEvent.values[0];
      }
      AppMethodBeat.o(104271);
    }
  }
  
  public static final class b
  {
    private static a ryV;
    
    static
    {
      AppMethodBeat.i(104272);
      ryV = new a((byte)0);
      AppMethodBeat.o(104272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.a
 * JD-Core Version:    0.7.0.1
 */