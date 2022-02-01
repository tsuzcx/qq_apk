package com.tencent.mm.plugin.appbrand.jsapi.t;

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
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private static final HashMap<String, HandlerThread> kLa;
  private String kKZ;
  private Handler mHandler;
  private SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(206815);
    kLa = new HashMap();
    AppMethodBeat.o(206815);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(206814);
    this.kKZ = null;
    this.mHandler = new Handler(Na(paramString).getLooper());
    AppMethodBeat.o(206814);
  }
  
  private static HandlerThread Na(String paramString)
  {
    AppMethodBeat.i(206813);
    String str = "MicroMsg.UnitSensor.".concat(String.valueOf(paramString));
    synchronized (kLa)
    {
      HandlerThread localHandlerThread = (HandlerThread)kLa.get(str);
      paramString = localHandlerThread;
      if (localHandlerThread == null)
      {
        paramString = d.gC(str, 5);
        kLa.put(str, paramString);
      }
      if (paramString.getLooper() == null) {
        paramString.start();
      }
      AppMethodBeat.o(206813);
      return paramString;
    }
  }
  
  public final i.a a(c paramc, JSONObject paramJSONObject, a parama, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(137657);
    this.kKZ = paramString;
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int j = paramJSONObject.optInt("interval", 200);
    ac.i("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", new Object[] { paramString, Integer.valueOf(j), Boolean.valueOf(bool1) });
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
    }
    if (this.mSensorManager == null)
    {
      ac.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
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
        ac.i("MicroMsg.UnitSensor", "get sensor failed.");
        paramc = new i.a("fail:null sensor", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = y.ayq().xH(paramString);
      if (paramJSONObject != null) {
        break label697;
      }
      paramJSONObject = y.ayq().F(paramString, true);
    }
    label697:
    for (;;)
    {
      if ((a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        ac.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        paramc = new i.a("fail, has enable, should stop pre operation", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      g.a(paramc.getAppId(), parama);
      paramJSONObject.l("sensor_event_listener", parama);
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
        parama.biL();
        g.b(paramc.getAppId(), parama);
        paramJSONObject.recycle();
        y.ayq().xI(paramString);
      }
      ac.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
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
      paramJSONObject = y.ayq().xI(paramString);
      if (paramJSONObject == null)
      {
        ac.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        paramc = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      parama = (a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        ac.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        paramc = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramc;
      }
      this.mSensorManager.unregisterListener(parama);
      g.b(paramc.getAppId(), parama);
      parama.biL();
      paramJSONObject.recycle();
      ac.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      paramc = new i.a("ok", new Object[0]);
      AppMethodBeat.o(137657);
      return paramc;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(137658);
    this.mSensorManager.unregisterListener(parama);
    if (!TextUtils.isEmpty(this.kKZ)) {
      y.ayq().xI(this.kKZ);
    }
    AppMethodBeat.o(137658);
  }
  
  public static abstract class a
    extends g.c
    implements SensorEventListener
  {
    public void biL() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.l
 * JD-Core Version:    0.7.0.1
 */