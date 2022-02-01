package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

abstract class c$b
  extends l.a
  implements SensorEventListener
{
  private o mqi;
  private boolean mqm;
  private float[] mqn = new float[3];
  private float[] mqo = new float[3];
  private String mqp = "unknow";
  private int mqq = 0;
  c.a mqr = new c.a();
  
  c$b(final f paramf)
  {
    this.mqr.h(paramf);
    this.mqi = new o(i.mqN.bID(), new o.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137627);
        Log.v("MicroMsg.JsApiEnableCompass", "onAction.");
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
          c.b.this.mqr.L((Map)localObject);
          boolean bool = k.a.mqW.a(c.b.this.mqr, paramf);
          AppMethodBeat.o(137627);
          return bool;
          ((Map)localObject).put("accuracy", c.b.c(c.b.this));
        }
      }
    });
  }
  
  public final void bIH()
  {
    this.mqm = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.mqm) {
      return;
    }
    if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      Log.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      this.mqo = paramSensorEvent.values;
      switch (paramSensorEvent.accuracy)
      {
      default: 
        this.mqp = "unknow";
        this.mqq = paramSensorEvent.accuracy;
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.mqi.l(new Object[0])) });
      return;
      this.mqp = "low";
      continue;
      this.mqp = "medium";
      continue;
      this.mqp = "high";
      continue;
      this.mqp = "unreliable";
      continue;
      this.mqp = "no-contact";
      continue;
      if (paramSensorEvent.sensor.getType() != 1) {
        break;
      }
      this.mqn = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.c.b
 * JD-Core Version:    0.7.0.1
 */