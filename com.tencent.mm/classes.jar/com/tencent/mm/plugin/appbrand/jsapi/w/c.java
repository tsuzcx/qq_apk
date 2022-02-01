package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.ae;
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
        h.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramc.h(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private o lkA;
    private boolean lkE;
    private float[] lkF = new float[3];
    private float[] lkG = new float[3];
    private String lkH = "unknow";
    private int lkI = 0;
    c.a lkJ = new c.a();
    
    b(final com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      this.lkJ.h(paramc);
      this.lkA = new o(i.llc.bne(), new o.a()
      {
        public final boolean j(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137627);
          ae.v("MicroMsg.JsApiEnableCompass", "onAction.");
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
            c.b.this.lkJ.I((Map)localObject);
            boolean bool = k.a.llj.a(c.b.this.lkJ, paramc);
            AppMethodBeat.o(137627);
            return bool;
            ((Map)localObject).put("accuracy", c.b.c(c.b.this));
          }
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
      if (this.lkE) {
        return;
      }
      if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
      {
        ae.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
        return;
      }
      if (paramSensorEvent.sensor.getType() == 2)
      {
        this.lkG = paramSensorEvent.values;
        switch (paramSensorEvent.accuracy)
        {
        default: 
          this.lkH = "unknow";
          this.lkI = paramSensorEvent.accuracy;
        }
      }
      for (;;)
      {
        ae.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.lkA.l(new Object[0])) });
        return;
        this.lkH = "low";
        continue;
        this.lkH = "medium";
        continue;
        this.lkH = "high";
        continue;
        this.lkH = "unreliable";
        continue;
        this.lkH = "no-contact";
        continue;
        if (paramSensorEvent.sensor.getType() != 1) {
          break;
        }
        this.lkF = paramSensorEvent.values;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.c
 * JD-Core Version:    0.7.0.1
 */