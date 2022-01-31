package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.v.g;
import com.tencent.mm.sdk.platformtools.y;

abstract class b$b
  extends i.a
  implements SensorEventListener
{
  private g gAD;
  private boolean gAH;
  private float[] gAI = new float[3];
  private float[] gAJ = new float[3];
  private String gAK = "unknow";
  private int gAL = 0;
  b.a gAM = new b.a();
  
  b$b(f paramf)
  {
    this.gAM.d(paramf);
    this.gAD = new g(h.ajY(), new b.b.1(this, paramf));
  }
  
  public final void ajV()
  {
    this.gAH = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.gAH) {
      return;
    }
    if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      y.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      this.gAJ = paramSensorEvent.values;
      label51:
      switch (paramSensorEvent.accuracy)
      {
      default: 
        this.gAK = "unknow";
        this.gAL = paramSensorEvent.accuracy;
      }
    }
    for (;;)
    {
      y.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.gAD.k(new Object[0])) });
      return;
      if (paramSensorEvent.sensor.getType() != 1) {
        break;
      }
      this.gAI = paramSensorEvent.values;
      break label51;
      this.gAK = "low";
      continue;
      this.gAK = "medium";
      continue;
      this.gAK = "high";
      continue;
      this.gAK = "unreliable";
      continue;
      this.gAK = "no-contact";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.b
 * JD-Core Version:    0.7.0.1
 */