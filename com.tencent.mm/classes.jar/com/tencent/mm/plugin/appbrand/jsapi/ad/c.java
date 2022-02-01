package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
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

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137628);
    final l locall = new l("enableCompass");
    paramJSONObject = locall.a(paramf, paramJSONObject, new b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137626);
        setDisable(true);
        com.tencent.mm.plugin.appbrand.k.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + paramf.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramf.callback(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
  
  static abstract class b
    extends l.a
    implements SensorEventListener
  {
    private t ssZ;
    private boolean stb;
    private float[] ste = new float[3];
    private float[] stf = new float[3];
    private String sth = "unknow";
    private int sti = 0;
    c.a stj = new c.a();
    
    b(final f paramf)
    {
      this.stj.i(paramf);
      this.ssZ = new t(i.stI.cuy(), new t.a()
      {
        public final boolean k(Object... paramAnonymousVarArgs)
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
            c.b.this.stj.L((Map)localObject);
            boolean bool = k.a.stS.a(c.b.this.stj, paramf);
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
      if (this.stb) {
        return;
      }
      if ((paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
      {
        Log.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
        return;
      }
      if (paramSensorEvent.sensor.getType() == 2)
      {
        this.stf = paramSensorEvent.values;
        switch (paramSensorEvent.accuracy)
        {
        default: 
          this.sth = "unknow";
          this.sti = paramSensorEvent.accuracy;
        }
      }
      for (;;)
      {
        Log.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.ssZ.m(new Object[0])) });
        return;
        this.sth = "low";
        continue;
        this.sth = "medium";
        continue;
        this.sth = "high";
        continue;
        this.sth = "unreliable";
        continue;
        this.sth = "no-contact";
        continue;
        if (paramSensorEvent.sensor.getType() != 1) {
          break;
        }
        this.ste = paramSensorEvent.values;
      }
    }
    
    public final void setDisable(boolean paramBoolean)
    {
      this.stb = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c
 * JD-Core Version:    0.7.0.1
 */