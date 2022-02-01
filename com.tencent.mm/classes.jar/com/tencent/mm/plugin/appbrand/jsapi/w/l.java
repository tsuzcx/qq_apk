package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private static final HashMap<String, HandlerThread> lll;
  private String llk;
  private Handler mHandler;
  private SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(197254);
    lll = new HashMap();
    AppMethodBeat.o(197254);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(197253);
    this.llk = null;
    this.mHandler = new Handler(Rg(paramString).getLooper());
    AppMethodBeat.o(197253);
  }
  
  private static HandlerThread Rg(String paramString)
  {
    AppMethodBeat.i(197252);
    String str = "MicroMsg.UnitSensor.".concat(String.valueOf(paramString));
    synchronized (lll)
    {
      HandlerThread localHandlerThread = (HandlerThread)lll.get(str);
      paramString = localHandlerThread;
      if (localHandlerThread == null)
      {
        paramString = d.hj(str, 5);
        lll.put(str, paramString);
      }
      if (paramString.getLooper() == null) {
        paramString.start();
      }
      AppMethodBeat.o(197252);
      return paramString;
    }
  }
  
  public final i.a a(c paramc, JSONObject paramJSONObject, a parama, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(137657);
    this.llk = paramString;
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int j = paramJSONObject.optInt("interval", 200);
    ae.i("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", new Object[] { paramString, Integer.valueOf(j), Boolean.valueOf(bool1) });
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    }
    if (this.mSensorManager == null)
    {
      ae.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      paramc = new i.a("fail:null system service", new Object[0]);
      AppMethodBeat.o(137657);
      return paramc;
    }
    Object localObject = new ArrayList();
    paramJSONObject = paramList.iterator();
    int i;
    while (paramJSONObject.hasNext())
    {
      i = ((Integer)paramJSONObject.next()).intValue();
      paramList = this.mSensorManager.getDefaultSensor(i);
      if (paramList == null)
      {
        ae.i("MicroMsg.UnitSensor", "get sensor failed.");
        paramc = new i.a("fail:null sensor", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = z.aBG().Bp(paramString);
      if (paramJSONObject != null) {
        break label697;
      }
      paramJSONObject = z.aBG().F(paramString, true);
    }
    label697:
    for (;;)
    {
      if ((a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        ae.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        paramc = new i.a("fail, has enable, should stop pre operation", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      h.a(paramc.getAppId(), parama);
      paramJSONObject.k("sensor_event_listener", parama);
      paramList = ((List)localObject).iterator();
      bool1 = false;
      while (paramList.hasNext())
      {
        localObject = (Sensor)paramList.next();
        SensorManager localSensorManager = this.mSensorManager;
        switch (j)
        {
        default: 
          i = 3;
          boolean bool2 = localSensorManager.registerListener(parama, (Sensor)localObject, i, this.mHandler);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
          break;
        }
      }
      if (!bool1)
      {
        this.mSensorManager.unregisterListener(parama);
        parama.bng();
        h.b(paramc.getAppId(), parama);
        paramJSONObject.recycle();
        z.aBG().Bq(paramString);
      }
      ae.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {}
      for (paramc = "ok";; paramc = "fail:system error")
      {
        paramc = new i.a(paramc, new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
        i = 0;
        break;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
      }
      paramJSONObject = z.aBG().Bq(paramString);
      if (paramJSONObject == null)
      {
        ae.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        paramc = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      parama = (a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        ae.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        paramc = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      this.mSensorManager.unregisterListener(parama);
      h.b(paramc.getAppId(), parama);
      parama.bng();
      paramJSONObject.recycle();
      ae.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      paramc = new i.a("ok", new Object[0]);
      AppMethodBeat.o(137657);
      return paramc;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(137658);
    this.mSensorManager.unregisterListener(parama);
    if (!TextUtils.isEmpty(this.llk)) {
      z.aBG().Bq(this.llk);
    }
    AppMethodBeat.o(137658);
  }
  
  public static abstract class a
    extends h.c
    implements SensorEventListener
  {
    public void bng() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.l
 * JD-Core Version:    0.7.0.1
 */