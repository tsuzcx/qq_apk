package com.tencent.mm.plugin.appbrand.jsapi.u;

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
  private n kiY;
  private boolean kjc;
  private float[] kjd = new float[3];
  private float[] kje = new float[3];
  private String kjf = "unknow";
  private int kjg = 0;
  c.a kjh = new c.a();
  
  c$b(final c paramc)
  {
    this.kjh.h(paramc);
    this.kiY = new n(i.kjA.bbO(), new n.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
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
          c.b.this.kjh.C((Map)localObject);
          boolean bool = k.a.kjH.a(c.b.this.kjh, paramc);
          AppMethodBeat.o(137627);
          return bool;
          ((Map)localObject).put("accuracy", c.b.c(c.b.this));
        }
      }
    });
  }
  
  public final void bbQ()
  {
    this.kjc = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.kjc) {
      return;
    }
    if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      ad.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      this.kje = paramSensorEvent.values;
      switch (paramSensorEvent.accuracy)
      {
      default: 
        this.kjf = "unknow";
        this.kjg = paramSensorEvent.accuracy;
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kiY.l(new Object[0])) });
      return;
      this.kjf = "low";
      continue;
      this.kjf = "medium";
      continue;
      this.kjf = "high";
      continue;
      this.kjf = "unreliable";
      continue;
      this.kjf = "no-contact";
      continue;
      if (paramSensorEvent.sensor.getType() != 1) {
        break;
      }
      this.kjd = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.c.b
 * JD-Core Version:    0.7.0.1
 */