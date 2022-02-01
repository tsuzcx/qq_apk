package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137631);
    final l locall = new l("enableDeviceMotionChangeListening");
    paramJSONObject = locall.a(paramc, paramJSONObject, new b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137629);
        h.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137629);
      }
    }, "JsApi#SensorDeviceMotion" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramc.h(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137631);
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private o lkA;
    private boolean lkE;
    d.a lkM = new d.a();
    
    b(final c paramc)
    {
      this.lkM.h(paramc);
      this.lkA = new o(i.llc.bne(), new o.a()
      {
        public final boolean j(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137630);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
          d.b.this.lkM.I(localHashMap);
          boolean bool = k.a.llj.a(d.b.this.lkM, paramc);
          AppMethodBeat.o(137630);
          return bool;
        }
      });
    }
    
    public final void bng()
    {
      this.lkE = true;
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.lkE) {}
      while (paramSensorEvent.sensor.getType() != 3) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        ae.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
        return;
      }
      ae.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lkA.l(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.d
 * JD-Core Version:    0.7.0.1
 */