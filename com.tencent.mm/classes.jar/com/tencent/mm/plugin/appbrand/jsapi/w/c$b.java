package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

abstract class c$b
  extends l.a
  implements SensorEventListener
{
  private n lgO;
  private boolean lgS;
  private float[] lgT = new float[3];
  private float[] lgU = new float[3];
  private String lgV = "unknow";
  private int lgW = 0;
  c.a lgX = new c.a();
  
  c$b(final c paramc)
  {
    this.lgX.h(paramc);
    this.lgO = new n(i.lhq.bmv(), new n.a()
    {
      public final boolean k(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137627);
        ad.v("MicroMsg.JsApiEnableCompass", "onAction.");
        paramAnonymousVarArgs = new float[3];
        Object localObject = new float[9];
        SensorManager.getRotationMatrix((float[])localObject, null, c.b.a(c.b.this), c.b.b(c.b.this));
        SensorManager.getOrientation((float[])localObject, paramAnonymousVarArgs);
        localObject = new HashMap();
        float f2 = (float)Math.toDegrees(paramAnonymousVarArgs[0]);
        float f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 + 360.0F;
        }
        ((Map)localObject).put("direction", Float.valueOf(f1));
        if (c.b.c(c.b.this).equalsIgnoreCase("unknow")) {
          ((Map)localObject).put("accuracy", c.b.c(c.b.this) + "{value:" + c.b.d(c.b.this) + "}");
        }
        for (;;)
        {
          c.b.this.lgX.B((Map)localObject);
          boolean bool = k.a.lhx.a(c.b.this.lgX, paramc);
          AppMethodBeat.o(137627);
          return bool;
          ((Map)localObject).put("accuracy", c.b.c(c.b.this));
        }
      }
    });
  }
  
  public final void bmx()
  {
    this.lgS = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.lgS) {
      return;
    }
    if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      ad.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      this.lgU = paramSensorEvent.values;
      switch (paramSensorEvent.accuracy)
      {
      default: 
        this.lgV = "unknow";
        this.lgW = paramSensorEvent.accuracy;
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lgO.m(new Object[0])) });
      return;
      this.lgV = "low";
      continue;
      this.lgV = "medium";
      continue;
      this.lgV = "high";
      continue;
      this.lgV = "unreliable";
      continue;
      this.lgV = "no-contact";
      continue;
      if (paramSensorEvent.sensor.getType() != 1) {
        break;
      }
      this.lgT = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.c.b
 * JD-Core Version:    0.7.0.1
 */