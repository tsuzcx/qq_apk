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

abstract class f$b
  extends l.a
  implements SensorEventListener
{
  private n lgO;
  private boolean lgS;
  f.a lhj = new f.a();
  
  f$b(final c paramc)
  {
    this.lhj.h(paramc);
    this.lgO = new n(i.lhq.bmv(), new n.a()
    {
      public final boolean k(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137637);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
        f.b.this.lhj.B(localHashMap);
        boolean bool = k.a.lhx.a(f.b.this.lhj, paramc);
        AppMethodBeat.o(137637);
        return bool;
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
    if (this.lgS) {}
    while (paramSensorEvent.sensor.getType() != 4) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ad.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
      return;
    }
    ad.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lgO.m(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.f.b
 * JD-Core Version:    0.7.0.1
 */