package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
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
        h.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137623);
      }
    }, "JsApi#SensorAccelerometer" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    paramc.h(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137625);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 93;
    private static final String NAME = "onAccelerometerChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private o lkA;
    b.a lkB = new b.a();
    
    b(final c paramc)
    {
      this.lkB.h(paramc);
      this.lkA = new o(i.llc.bne(), new o.a()
      {
        public final boolean j(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137624);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
          localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
          localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
          b.b.this.lkB.I(localHashMap);
          boolean bool = k.a.llj.a(b.b.this.lkB, paramc);
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
        ae.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
        return;
      }
      ae.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lkA.l(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.b
 * JD-Core Version:    0.7.0.1
 */