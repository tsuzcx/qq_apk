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

abstract class f$b
  extends l.a
  implements SensorEventListener
{
  f.a mqG = new f.a();
  private o mqi;
  private boolean mqm;
  
  f$b(final f paramf)
  {
    this.mqG.h(paramf);
    this.mqi = new o(i.mqN.bID(), new o.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137637);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
        f.b.this.mqG.L(localHashMap);
        boolean bool = k.a.mqW.a(f.b.this.mqG, paramf);
        AppMethodBeat.o(137637);
        return bool;
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
    if (this.mqm) {}
    while (paramSensorEvent.sensor.getType() != 4) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      Log.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
      return;
    }
    Log.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.mqi.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.f.b
 * JD-Core Version:    0.7.0.1
 */