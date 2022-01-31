package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.k;
import com.tencent.mm.sdk.platformtools.ab;

abstract class d$b
  extends l.a
  implements SensorEventListener
{
  private boolean hYA;
  d.a hYI = new d.a();
  private k hYw;
  
  d$b(c paramc)
  {
    this.hYI.j(paramc);
    this.hYw = new k(i.hYY.aEB(), new d.b.1(this, paramc));
  }
  
  public final void aED()
  {
    this.hYA = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.hYA) {}
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ab.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
      return;
    }
    ab.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.hYw.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d.b
 * JD-Core Version:    0.7.0.1
 */