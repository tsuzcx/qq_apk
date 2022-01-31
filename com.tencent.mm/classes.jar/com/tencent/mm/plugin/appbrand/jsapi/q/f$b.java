package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

abstract class f$b
  extends l.a
  implements SensorEventListener
{
  private boolean hYA;
  f.a hYR = new f.a();
  private com.tencent.mm.plugin.appbrand.t.k hYw;
  
  f$b(final c paramc)
  {
    this.hYR.j(paramc);
    this.hYw = new com.tencent.mm.plugin.appbrand.t.k(i.hYY.aEB(), new com.tencent.mm.plugin.appbrand.t.k.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(126383);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
        f.b.this.hYR.x(localHashMap);
        boolean bool = k.a.hZf.a(f.b.this.hYR, paramc);
        AppMethodBeat.o(126383);
        return bool;
      }
    });
  }
  
  public final void aED()
  {
    this.hYA = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.hYA) {}
    while (paramSensorEvent.sensor.getType() != 4) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ab.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
      return;
    }
    ab.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.hYw.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.f.b
 * JD-Core Version:    0.7.0.1
 */