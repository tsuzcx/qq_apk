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

abstract class d$b
  extends l.a
  implements SensorEventListener
{
  private n lgO;
  private boolean lgS;
  d.a lha = new d.a();
  
  d$b(final c paramc)
  {
    this.lha.h(paramc);
    this.lgO = new n(i.lhq.bmv(), new n.a()
    {
      public final boolean k(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137630);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
        d.b.this.lha.B(localHashMap);
        boolean bool = k.a.lhx.a(d.b.this.lha, paramc);
        AppMethodBeat.o(137630);
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
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      ad.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
      return;
    }
    ad.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lgO.m(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.d.b
 * JD-Core Version:    0.7.0.1
 */