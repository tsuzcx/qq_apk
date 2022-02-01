package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

public final class d
  extends c
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  private static String C(e parame)
  {
    AppMethodBeat.i(207147);
    parame = "JsApi#SensorDeviceMotion" + parame.hashCode();
    AppMethodBeat.o(207147);
    return parame;
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137631);
    final l locall = new l("enableDeviceMotionChangeListening");
    b local1 = new b(parame)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137629);
        com.tencent.mm.plugin.appbrand.k.b(parame.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137629);
      }
    };
    if (i.poU.bUo())
    {
      paramJSONObject = locall.a(parame, paramJSONObject, local1, C(parame), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(11) })));
      parame.j(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
      AppMethodBeat.o(137631);
      return;
    }
    paramJSONObject = locall.a(parame, paramJSONObject, local1, C(parame), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    parame.j(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137631);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 490;
    private static final String NAME = "onDeviceMotionChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    float[] fkN = new float[3];
    d.a poB = new d.a();
    float[] poC = new float[9];
    float[] poD = new float[3];
    final double poE = 6.283185307179586D;
    private q poo;
    private boolean poq;
    
    b(final e parame)
    {
      this.poB.j(parame);
      this.poo = new q(i.poU.bUl(), new q.a()
      {
        public final boolean i(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137630);
          paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
          HashMap localHashMap = new HashMap();
          localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
          localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
          localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
          d.b.this.poB.E(localHashMap);
          boolean bool = k.a.ppe.a(d.b.this.poB, parame);
          AppMethodBeat.o(137630);
          return bool;
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.poq) {}
      do
      {
        do
        {
          return;
          if (!i.poU.bUo()) {
            break;
          }
        } while (paramSensorEvent.sensor.getType() != 11);
        SensorManager.getRotationMatrixFromVector(this.poC, paramSensorEvent.values);
        SensorManager.getOrientation(this.poC, this.poD);
        if (this.poD[0] < 0.0F)
        {
          paramSensorEvent = this.poD;
          paramSensorEvent[0] = ((float)(paramSensorEvent[0] + 6.283185307179586D));
        }
        this.poD[2] = (-this.poD[2]);
        this.fkN[0] = ((float)Math.toDegrees(this.poD[0]));
        this.fkN[1] = ((float)Math.toDegrees(this.poD[1]));
        this.fkN[2] = ((float)Math.toDegrees(this.poD[2]));
        Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.poo.k(new Object[] { this.fkN })) });
        return;
      } while (paramSensorEvent.sensor.getType() != 3);
      paramSensorEvent = paramSensorEvent.values;
      if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
        return;
      }
      Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.poo.k(new Object[] { paramSensorEvent })) });
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.poq = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d
 * JD-Core Version:    0.7.0.1
 */