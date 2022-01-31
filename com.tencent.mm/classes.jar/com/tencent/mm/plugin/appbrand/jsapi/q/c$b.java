package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.k;
import com.tencent.mm.sdk.platformtools.ab;

abstract class c$b
  extends l.a
  implements SensorEventListener
{
  private boolean hYA;
  private float[] hYB = new float[3];
  private float[] hYC = new float[3];
  private String hYD = "unknow";
  private int hYE = 0;
  c.a hYF = new c.a();
  private k hYw;
  
  c$b(c paramc)
  {
    this.hYF.j(paramc);
    this.hYw = new k(i.hYY.aEB(), new c.b.1(this, paramc));
  }
  
  public final void aED()
  {
    this.hYA = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.hYA) {
      return;
    }
    if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      ab.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      this.hYC = paramSensorEvent.values;
      switch (paramSensorEvent.accuracy)
      {
      default: 
        this.hYD = "unknow";
        this.hYE = paramSensorEvent.accuracy;
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.hYw.l(new Object[0])) });
      return;
      this.hYD = "low";
      continue;
      this.hYD = "medium";
      continue;
      this.hYD = "high";
      continue;
      this.hYD = "unreliable";
      continue;
      this.hYD = "no-contact";
      continue;
      if (paramSensorEvent.sensor.getType() != 1) {
        break;
      }
      this.hYB = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.c.b
 * JD-Core Version:    0.7.0.1
 */