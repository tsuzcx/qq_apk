package com.tencent.mm.plugin.appbrand.jsapi.u;

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

abstract class f$b
  extends l.a
  implements SensorEventListener
{
  private n kiY;
  private boolean kjc;
  f.a kjt = new f.a();
  
  f$b(final c paramc)
  {
    this.kjt.h(paramc);
    this.kiY = new n(i.kjA.bbO(), new n.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137637);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
        f.b.this.kjt.C(localHashMap);
        boolean bool = k.a.kjH.a(f.b.this.kjt, paramc);
        AppMethodBeat.o(137637);
        return bool;
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
    if (this.kjc) {}
    while (paramSensorEvent.sensor.getType() != 4) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ad.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
      return;
    }
    ad.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kiY.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.b
 * JD-Core Version:    0.7.0.1
 */