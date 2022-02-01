package com.tencent.mm.plugin.flash.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  public a BBZ;
  private boolean mHasStarted = false;
  private SensorManager mSensorManager;
  
  public final void epP()
  {
    AppMethodBeat.i(194132);
    if (this.mHasStarted)
    {
      AppMethodBeat.o(194132);
      return;
    }
    this.mHasStarted = true;
    new StringBuilder("lightSensor has started:").append(this.mHasStarted);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    Sensor localSensor = this.mSensorManager.getDefaultSensor(5);
    if (localSensor != null)
    {
      this.BBZ = new a((byte)0);
      this.mSensorManager.registerListener(this.BBZ, localSensor, 3);
    }
    AppMethodBeat.o(194132);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194133);
    if ((!this.mHasStarted) || (this.mSensorManager == null))
    {
      AppMethodBeat.o(194133);
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.BBZ);
    AppMethodBeat.o(194133);
  }
  
  public final class a
    implements SensorEventListener
  {
    private float lux;
    
    private a() {}
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(197151);
      if (paramSensorEvent.sensor.getType() == 5) {
        this.lux = paramSensorEvent.values[0];
      }
      AppMethodBeat.o(197151);
    }
  }
  
  public static final class b
  {
    private static b BCb;
    
    static
    {
      AppMethodBeat.i(192033);
      BCb = new b((byte)0);
      AppMethodBeat.o(192033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.d.b
 * JD-Core Version:    0.7.0.1
 */