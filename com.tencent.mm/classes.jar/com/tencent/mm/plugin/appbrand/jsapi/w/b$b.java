package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

abstract class b$b
  extends l.a
  implements SensorEventListener
{
  private n lgO;
  b.a lgP = new b.a();
  
  b$b(final c paramc)
  {
    this.lgP.h(paramc);
    this.lgO = new n(i.lhq.bmv(), new n.a()
    {
      public final boolean k(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137624);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
        localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
        localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
        b.b.this.lgP.B(localHashMap);
        boolean bool = k.a.lhx.a(b.b.this.lgP, paramc);
        AppMethodBeat.o(137624);
        return bool;
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
      ad.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
      return;
    }
    ad.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lgO.m(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.b.b
 * JD-Core Version:    0.7.0.1
 */