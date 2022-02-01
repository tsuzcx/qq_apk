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
  private boolean mHasStarted = false;
  private SensorManager mSensorManager;
  public a wIL;
  
  public final void dLl()
  {
    AppMethodBeat.i(186700);
    if (this.mHasStarted)
    {
      AppMethodBeat.o(186700);
      return;
    }
    this.mHasStarted = true;
    new StringBuilder("lightSensor has started:").append(this.mHasStarted);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    Sensor localSensor = this.mSensorManager.getDefaultSensor(5);
    if (localSensor != null)
    {
      this.wIL = new a((byte)0);
      this.mSensorManager.registerListener(this.wIL, localSensor, 3);
    }
    AppMethodBeat.o(186700);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(186701);
    if ((!this.mHasStarted) || (this.mSensorManager == null))
    {
      AppMethodBeat.o(186701);
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.wIL);
    AppMethodBeat.o(186701);
  }
  
  public final class a
    implements SensorEventListener
  {
    private float lux;
    
    private a() {}
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(186698);
      if (paramSensorEvent.sensor.getType() == 5) {
        this.lux = paramSensorEvent.values[0];
      }
      AppMethodBeat.o(186698);
    }
  }
  
  public static final class b
  {
    private static b wIN;
    
    static
    {
      AppMethodBeat.i(186699);
      wIN = new b((byte)0);
      AppMethodBeat.o(186699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.d.b
 * JD-Core Version:    0.7.0.1
 */