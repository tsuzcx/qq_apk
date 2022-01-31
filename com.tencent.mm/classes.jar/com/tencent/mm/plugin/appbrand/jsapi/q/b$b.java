package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.k;
import com.tencent.mm.sdk.platformtools.ab;

abstract class b$b
  extends l.a
  implements SensorEventListener
{
  private k hYw;
  b.a hYx = new b.a();
  
  b$b(c paramc)
  {
    this.hYx.j(paramc);
    this.hYw = new k(i.hYY.aEB(), new b.b.1(this, paramc));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ab.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
      return;
    }
    ab.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.hYw.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.b.b
 * JD-Core Version:    0.7.0.1
 */