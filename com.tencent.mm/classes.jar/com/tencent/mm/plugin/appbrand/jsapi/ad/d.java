package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

public final class d
  extends c
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  private static String E(f paramf)
  {
    AppMethodBeat.i(329503);
    paramf = "JsApi#SensorDeviceMotion" + paramf.hashCode();
    AppMethodBeat.o(329503);
    return paramf;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137631);
    final l locall = new l("enableDeviceMotionChangeListening");
    b local1 = new b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137629);
        setDisable(true);
        com.tencent.mm.plugin.appbrand.k.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137629);
      }
    };
    if (i.stI.cuB())
    {
      paramJSONObject = locall.a(paramf, paramJSONObject, local1, E(paramf), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(11) })));
      paramf.callback(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
      AppMethodBeat.o(137631);
      return;
    }
    paramJSONObject = locall.a(paramf, paramJSONObject, local1, E(paramf), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramf.callback(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137631);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 490;
    private static final String NAME = "onDeviceMotionChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    float[] hpa = new float[3];
    private t ssZ;
    private boolean stb;
    d.a stm = new d.a();
    float[] stn = new float[9];
    float[] sto = new float[3];
    final double stp = 6.283185307179586D;
    
    b(final f paramf)
    {
      this.stm.i(paramf);
      this.ssZ = new t(i.stI.cuy(), new t.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137630);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
          d.b.this.stm.L(localHashMap);
          boolean bool = k.a.stS.a(d.b.this.stm, paramf);
          AppMethodBeat.o(137630);
          return bool;
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.stb) {}
      do
      {
        do
        {
          return;
          if (!i.stI.cuB()) {
            break;
          }
        } while (paramSensorEvent.sensor.getType() != 11);
        SensorManager.getRotationMatrixFromVector(this.stn, paramSensorEvent.values);
        SensorManager.getOrientation(this.stn, this.sto);
        if (this.sto[0] < 0.0F)
        {
          paramSensorEvent = this.sto;
          paramSensorEvent[0] = ((float)(paramSensorEvent[0] + 6.283185307179586D));
        }
        this.sto[2] = (-this.sto[2]);
        this.hpa[0] = ((float)Math.toDegrees(this.sto[0]));
        this.hpa[1] = ((float)Math.toDegrees(this.sto[1]));
        this.hpa[2] = ((float)Math.toDegrees(this.sto[2]));
        Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.ssZ.m(new Object[] { this.hpa })) });
        return;
      } while (paramSensorEvent.sensor.getType() != 3);
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
        return;
      }
      Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.ssZ.m(new Object[] { paramSensorEvent })) });
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.stb = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d
 * JD-Core Version:    0.7.0.1
 */