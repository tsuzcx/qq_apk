package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137628);
    final l locall = new l("enableCompass");
    paramJSONObject = locall.a(paramc, paramJSONObject, new b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137626);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramc.h(paramInt, k(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private n kKp;
    private boolean kKt;
    private float[] kKu = new float[3];
    private float[] kKv = new float[3];
    private String kKw = "unknow";
    private int kKx = 0;
    c.a kKy = new c.a();
    
    b(final com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      this.kKy.h(paramc);
      this.kKp = new n(i.kKR.biJ(), new n.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137627);
          ac.v("MicroMsg.JsApiEnableCompass", "onAction.");
          paramAnonymousVarArgs = new float[3];
          Object localObject = new float[9];
          SensorManager.getRotationMatrix((float[])localObject, null, c.b.a(c.b.this), c.b.b(c.b.this));
          SensorManager.getOrientation((float[])localObject, paramAnonymousVarArgs);
          localObject = new HashMap();
          float f2 = (float)Math.toDegrees(paramAnonymousVarArgs[0]);
          float f1 = f2;
          if (f2 < 0.0F) {
            f1 = f2 + 360.0F;
          }
          ((Map)localObject).put("direction", Float.valueOf(f1));
          if (c.b.c(c.b.this).equalsIgnoreCase("unknow")) {
            ((Map)localObject).put("accuracy", c.b.c(c.b.this) + "{value:" + c.b.d(c.b.this) + "}");
          }
          for (;;)
          {
            c.b.this.kKy.B((Map)localObject);
            boolean bool = k.a.kKY.a(c.b.this.kKy, paramc);
            AppMethodBeat.o(137627);
            return bool;
            ((Map)localObject).put("accuracy", c.b.c(c.b.this));
          }
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
      if (this.kKt) {
        return;
      }
      if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
      {
        ac.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
        return;
      }
      if (paramSensorEvent.sensor.getType() == 2)
      {
        this.kKv = paramSensorEvent.values;
        switch (paramSensorEvent.accuracy)
        {
        default: 
          this.kKw = "unknow";
          this.kKx = paramSensorEvent.accuracy;
        }
      }
      for (;;)
      {
        ac.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.kKp.m(new Object[0])) });
        return;
        this.kKw = "low";
        continue;
        this.kKw = "medium";
        continue;
        this.kKw = "high";
        continue;
        this.kKw = "unreliable";
        continue;
        this.kKw = "no-contact";
        continue;
        if (paramSensorEvent.sensor.getType() != 1) {
          break;
        }
        this.kKu = paramSensorEvent.values;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.c
 * JD-Core Version:    0.7.0.1
 */