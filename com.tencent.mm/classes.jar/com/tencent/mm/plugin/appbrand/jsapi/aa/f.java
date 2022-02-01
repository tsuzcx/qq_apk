package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends c
{
  public static final int CTRL_INDEX = 488;
  public static final String NAME = "enableGyroscope";
  
  public final void a(final e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137638);
    final l locall = new l("enableGyroscope");
    paramJSONObject = locall.a(parame, paramJSONObject, new b(parame)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137636);
        com.tencent.mm.plugin.appbrand.k.b(parame.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137636);
      }
    }, "JsApi#SensorGyroscope" + parame.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    parame.j(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137638);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 489;
    private static final String NAME = "onGyroscopeChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    f.a poN = new f.a();
    private q poo;
    private boolean poq;
    
    b(final e parame)
    {
      this.poN.j(parame);
      this.poo = new q(i.poU.bUl(), new q.a()
      {
        public final boolean i(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137637);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("y", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("z", Float.valueOf(paramAnonymousVarArgs[2]));
          f.b.this.poN.E(localHashMap);
          boolean bool = k.a.ppe.a(f.b.this.poN, parame);
          AppMethodBeat.o(137637);
          return bool;
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.poq) {}
      while (paramSensorEvent.sensor.getType() != 4) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
        return;
      }
      Log.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.poo.k(new Object[] { paramSensorEvent })) });
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.poq = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.f
 * JD-Core Version:    0.7.0.1
 */