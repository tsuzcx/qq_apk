package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

abstract class d$b
  extends l.a
  implements SensorEventListener
{
  private o mqi;
  private boolean mqm;
  d.a mqu = new d.a();
  float[] mqv = new float[9];
  float[] mqw = new float[3];
  final double mqx = 6.283185307179586D;
  float[] values = new float[3];
  
  d$b(final f paramf)
  {
    this.mqu.h(paramf);
    this.mqi = new o(i.mqN.bID(), new o.a()
    {
      public final boolean j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137630);
        paramAnonymousVarArgs = (float[])paramAnonymousVarArgs[0];
        HashMap localHashMap = new HashMap();
        localHashMap.put("alpha", Float.valueOf(paramAnonymousVarArgs[0]));
        localHashMap.put("beta", Float.valueOf(paramAnonymousVarArgs[1]));
        localHashMap.put("gamma", Float.valueOf(paramAnonymousVarArgs[2]));
        d.b.this.mqu.L(localHashMap);
        boolean bool = k.a.mqW.a(d.b.this.mqu, paramf);
        AppMethodBeat.o(137630);
        return bool;
      }
    });
  }
  
  public final void bIH()
  {
    this.mqm = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.mqm) {}
    do
    {
      do
      {
        return;
        if (!i.mqN.bIG()) {
          break;
        }
      } while (paramSensorEvent.sensor.getType() != 11);
      SensorManager.getRotationMatrixFromVector(this.mqv, paramSensorEvent.values);
      SensorManager.getOrientation(this.mqv, this.mqw);
      if (this.mqw[0] < 0.0F)
      {
        paramSensorEvent = this.mqw;
        paramSensorEvent[0] = ((float)(paramSensorEvent[0] + 6.283185307179586D));
      }
      this.mqw[2] = (-this.mqw[2]);
      this.values[0] = ((float)Math.toDegrees(this.mqw[0]));
      this.values[1] = ((float)Math.toDegrees(this.mqw[1]));
      this.values[2] = ((float)Math.toDegrees(this.mqw[2]));
      Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.mqi.l(new Object[] { this.values })) });
      return;
    } while (paramSensorEvent.sensor.getType() != 3);
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent == null) || (paramSensorEvent.length < 3))
    {
      Log.w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
      return;
    }
    Log.v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.mqi.l(new Object[] { paramSensorEvent })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.d.b
 * JD-Core Version:    0.7.0.1
 */