package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.v.g;
import com.tencent.mm.sdk.platformtools.y;

abstract class c$b
  extends i.a
  implements SensorEventListener
{
  private g gAD;
  private boolean gAH;
  c.a gAP = new c.a();
  
  c$b(f paramf)
  {
    this.gAP.d(paramf);
    this.gAD = new g(h.ajY(), new c.b.1(this, paramf));
  }
  
  public final void ajV()
  {
    this.gAH = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.gAH) {}
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      y.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
      return;
    }
    y.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.gAD.k(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c.b
 * JD-Core Version:    0.7.0.1
 */