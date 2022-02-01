package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

abstract class b$b
  extends l.a
  implements SensorEventListener
{
  private o mqi;
  b.a mqj = new b.a();
  
  b$b(final f paramf)
  {
    this.mqj.h(paramf);
    this.mqi = new o(i.mqN.bID(), new o.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137624);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
        localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
        localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
        b.b.this.mqj.L(localHashMap);
        boolean bool = k.a.mqW.a(b.b.this.mqj, paramf);
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
      Log.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
      return;
    }
    Log.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.mqi.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.b.b
 * JD-Core Version:    0.7.0.1
 */