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

public final class b
  extends a
{
  public static final int CTRL_INDEX = 92;
  public static final String NAME = "enableAccelerometer";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137625);
    final l locall = new l("enableAccelerometer");
    paramJSONObject = locall.a(paramc, paramJSONObject, new b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137623);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137623);
      }
    }, "JsApi#SensorAccelerometer" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    paramc.h(paramInt, k(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137625);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 93;
    private static final String NAME = "onAccelerometerChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private n kKp;
    b.a kKq = new b.a();
    
    b(final c paramc)
    {
      this.kKq.h(paramc);
      this.kKp = new n(i.kKR.biJ(), new n.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137624);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
          localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
          localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
          b.b.this.kKq.B(localHashMap);
          boolean bool = k.a.kKY.a(b.b.this.kKq, paramc);
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
        ac.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
        return;
      }
      ac.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kKp.m(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.b
 * JD-Core Version:    0.7.0.1
 */