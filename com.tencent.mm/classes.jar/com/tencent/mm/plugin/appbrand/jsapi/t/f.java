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

public final class f
  extends a
{
  public static final int CTRL_INDEX = 488;
  public static final String NAME = "enableGyroscope";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137638);
    final l locall = new l("enableGyroscope");
    paramJSONObject = locall.a(paramc, paramJSONObject, new b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137636);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137636);
      }
    }, "JsApi#SensorGyroscope" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    paramc.h(paramInt, k(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137638);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 489;
    private static final String NAME = "onGyroscopeChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    f.a kKK = new f.a();
    private n kKp;
    private boolean kKt;
    
    b(final c paramc)
    {
      this.kKK.h(paramc);
      this.kKp = new n(i.kKR.biJ(), new n.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137637);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
          f.b.this.kKK.B(localHashMap);
          boolean bool = k.a.kKY.a(f.b.this.kKK, paramc);
          AppMethodBeat.o(137637);
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
      while (paramSensorEvent.sensor.getType() != 4) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        ac.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
        return;
      }
      ac.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kKp.m(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.f
 * JD-Core Version:    0.7.0.1
 */