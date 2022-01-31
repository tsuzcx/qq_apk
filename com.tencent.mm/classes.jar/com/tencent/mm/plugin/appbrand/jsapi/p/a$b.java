package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.v.g;
import com.tencent.mm.plugin.appbrand.v.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

abstract class a$b
  extends i.a
  implements SensorEventListener
{
  private g gAD;
  a.a gAE = new a.a();
  
  a$b(final f paramf)
  {
    this.gAE.d(paramf);
    this.gAD = new g(h.ajY(), new g.a()
    {
      public final boolean i(Object... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
        localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
        localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
        a.b.this.gAE.o(localHashMap);
        return h.ajW().a(a.b.this.gAE, paramf);
      }
    });
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
      y.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
      return;
    }
    y.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.gAD.k(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.b
 * JD-Core Version:    0.7.0.1
 */