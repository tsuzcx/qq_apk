package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
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

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(final e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137628);
    final l locall = new l("enableCompass");
    paramJSONObject = locall.a(parame, paramJSONObject, new b(parame)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137626);
        com.tencent.mm.plugin.appbrand.k.b(parame.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + parame.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    parame.j(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private q poo;
    private boolean poq;
    private float[] pou = new float[3];
    private float[] pov = new float[3];
    private String pow = "unknow";
    private int pox = 0;
    c.a poy = new c.a();
    
    b(final e parame)
    {
      this.poy.j(parame);
      this.poo = new q(i.poU.bUl(), new q.a()
      {
        public final boolean i(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(137627);
          Log.v("MicroMsg.JsApiEnableCompass", "onAction.");
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
            c.b.this.poy.E((Map)localObject);
            boolean bool = k.a.ppe.a(c.b.this.poy, parame);
            AppMethodBeat.o(137627);
            return bool;
            ((Map)localObject).put("accuracy", c.b.c(c.b.this));
          }
        }
      });
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (this.poq) {
        return;
      }
      if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
        return;
      }
      if (paramSensorEvent.sensor.getType() == 2)
      {
        this.pov = paramSensorEvent.values;
        switch (paramSensorEvent.accuracy)
        {
        default: 
          this.pow = "unknow";
          this.pox = paramSensorEvent.accuracy;
        }
      }
      for (;;)
      {
        Log.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.poo.k(new Object[0])) });
        return;
        this.pow = "low";
        continue;
        this.pow = "medium";
        continue;
        this.pow = "high";
        continue;
        this.pow = "unreliable";
        continue;
        this.pow = "no-contact";
        continue;
        if (paramSensorEvent.sensor.getType() != 1) {
          break;
        }
        this.pou = paramSensorEvent.values;
      }
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.poq = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c
 * JD-Core Version:    0.7.0.1
 */