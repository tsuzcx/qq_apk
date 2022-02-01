package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.sdk.platformtools.ac;
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
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137629);
      }
    }, "JsApi#SensorDeviceMotion" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramc.h(paramInt, k(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137631);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 490;
    private static final String NAME = "onDeviceMotionChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    d.a kKB = new d.a();
    private n kKp;
    private boolean kKt;
    
    b(final c paramc)
    {
      this.kKB.h(paramc);
      this.kKp = new n(i.kKR.biJ(), new n.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137630);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
          d.b.this.kKB.B(localHashMap);
          boolean bool = k.a.kKY.a(d.b.this.kKB, paramc);
          AppMethodBeat.o(137630);
          return bool;
        }
      });
    }
    
    public final void biL()
    {
      this.kKt = true;
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.kKt) {}
      while (paramSensorEvent.sensor.getType() != 3) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        ac.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
        return;
      }
      ac.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kKp.m(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.d
 * JD-Core Version:    0.7.0.1
 */