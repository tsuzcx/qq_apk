package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.plugin.appbrand.utils.t.a;
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
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137625);
    final l locall = new l("enableAccelerometer");
    paramJSONObject = locall.a(paramf, paramJSONObject, new b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137623);
        setDisable(true);
        com.tencent.mm.plugin.appbrand.k.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137623);
      }
    }, "JsApi#SensorAccelerometer" + paramf.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    paramf.callback(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137625);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 93;
    private static final String NAME = "onAccelerometerChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private t ssZ;
    b.a sta = new b.a();
    boolean stb = false;
    
    b(final f paramf)
    {
      this.sta.i(paramf);
      this.ssZ = new t(i.stI.cuy(), new t.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137624);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("x", Float.valueOf(-paramAnonymousVarArgs[0] / 10.0F));
          localHashMap.put("y", Float.valueOf(-paramAnonymousVarArgs[1] / 10.0F));
          localHashMap.put("z", Float.valueOf(-paramAnonymousVarArgs[2] / 10.0F));
          b.b.this.sta.L(localHashMap);
          boolean bool = k.a.stS.a(b.b.this.sta, paramf);
          AppMethodBeat.o(137624);
          return bool;
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.stb) {}
      while (paramSensorEvent.sensor.getType() != 1) {
        return;
      }
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
        return;
      }
      Log.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.ssZ.m(new Object[] { paramSensorEvent })) });
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.stb = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b
 * JD-Core Version:    0.7.0.1
 */