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

public final class b
  extends c
{
  public static final int CTRL_INDEX = 92;
  public static final String NAME = "enableAccelerometer";
  
  public final void a(final e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137625);
    final l locall = new l("enableAccelerometer");
    paramJSONObject = locall.a(parame, paramJSONObject, new b(parame)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137623);
        com.tencent.mm.plugin.appbrand.k.b(parame.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137623);
      }
    }, "JsApi#SensorAccelerometer" + parame.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    parame.j(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137625);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 93;
    private static final String NAME = "onAccelerometerChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private q poo;
    b.a pop = new b.a();
    boolean poq = false;
    
    b(final e parame)
    {
      this.pop.j(parame);
      this.poo = new q(i.poU.bUl(), new q.a()
      {
        public final boolean i(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137624);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
          localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
          localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
          b.b.this.pop.E(localHashMap);
          boolean bool = k.a.ppe.a(b.b.this.pop, parame);
          AppMethodBeat.o(137624);
          return bool;
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.poq) {}
      while (paramSensorEvent.sensor.getType() != 1) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
        return;
      }
      Log.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.poo.k(new Object[] { paramSensorEvent })) });
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.poq = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b
 * JD-Core Version:    0.7.0.1
 */