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
        h.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137636);
      }
    }, "JsApi#SensorGyroscope" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    paramc.h(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137638);
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private o lkA;
    private boolean lkE;
    f.a lkV = new f.a();
    
    b(final c paramc)
    {
      this.lkV.h(paramc);
      this.lkA = new o(i.llc.bne(), new o.a()
      {
        public final boolean j(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137637);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
          f.b.this.lkV.I(localHashMap);
          boolean bool = k.a.llj.a(f.b.this.lkV, paramc);
          AppMethodBeat.o(137637);
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
      while (paramSensorEvent.sensor.getType() != 4) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        ae.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
        return;
      }
      ae.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lkA.l(new Object[] { paramSensorEvent })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.f
 * JD-Core Version:    0.7.0.1
 */