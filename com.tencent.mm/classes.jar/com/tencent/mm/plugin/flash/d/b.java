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
  public a HjG;
  private boolean mHasStarted = false;
  private SensorManager mSensorManager;
  
  public final void fuR()
  {
    AppMethodBeat.i(264519);
    if (this.mHasStarted)
    {
      AppMethodBeat.o(264519);
      return;
    }
    this.mHasStarted = true;
    new StringBuilder("lightSensor has started:").append(this.mHasStarted);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    Sensor localSensor = this.mSensorManager.getDefaultSensor(5);
    if (localSensor != null)
    {
      this.HjG = new a((byte)0);
      this.mSensorManager.registerListener(this.HjG, localSensor, 3);
    }
    AppMethodBeat.o(264519);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(264528);
    if ((!this.mHasStarted) || (this.mSensorManager == null))
    {
      AppMethodBeat.o(264528);
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.HjG);
    AppMethodBeat.o(264528);
  }
  
  public final class a
    implements SensorEventListener
  {
    private float lux;
    
    private a() {}
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(264531);
      if (paramSensorEvent.sensor.getType() == 5) {
        this.lux = paramSensorEvent.values[0];
      }
      AppMethodBeat.o(264531);
    }
  }
  
  public static final class b
  {
    private static b HjI;
    
    static
    {
      AppMethodBeat.i(264515);
      HjI = new b((byte)0);
      AppMethodBeat.o(264515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.d.b
 * JD-Core Version:    0.7.0.1
 */