package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private SensorManager bmB;
  private Handler mHandler;
  
  public l()
  {
    AppMethodBeat.i(126402);
    this.mHandler = new Handler(m.aNS().oNc.getLooper());
    AppMethodBeat.o(126402);
  }
  
  public final h.a a(c paramc, JSONObject paramJSONObject, l.a parama, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(126403);
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int j = paramJSONObject.optInt("interval", 200);
    if (this.bmB == null) {
      this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    }
    if (this.bmB == null)
    {
      ab.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      paramc = new h.a("fail:null system service", new Object[0]);
      AppMethodBeat.o(126403);
      return paramc;
    }
    Object localObject = new ArrayList();
    paramJSONObject = paramList.iterator();
    int i;
    while (paramJSONObject.hasNext())
    {
      i = ((Integer)paramJSONObject.next()).intValue();
      paramList = this.bmB.getDefaultSensor(i);
      if (paramList == null)
      {
        ab.i("MicroMsg.UnitSensor", "get sensor failed.");
        paramc = new h.a("fail:null sensor", new Object[0]);
        AppMethodBeat.o(126403);
        return paramc;
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = v.aae().oO(paramString);
      if (paramJSONObject != null) {
        break label649;
      }
      paramJSONObject = v.aae().z(paramString, true);
    }
    label649:
    for (;;)
    {
      if ((l.a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        ab.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        paramc = new h.a("fail, has enable, should stop pre operation", new Object[0]);
        AppMethodBeat.o(126403);
        return paramc;
      }
      e.a(paramc.getAppId(), parama);
      paramJSONObject.i("sensor_event_listener", parama);
      paramList = ((List)localObject).iterator();
      bool1 = false;
      while (paramList.hasNext())
      {
        localObject = (Sensor)paramList.next();
        SensorManager localSensorManager = this.bmB;
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
        this.bmB.unregisterListener(parama);
        parama.aED();
        e.b(paramc.getAppId(), parama);
        paramJSONObject.recycle();
        v.aae().oP(paramString);
      }
      ab.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {}
      for (paramc = "ok";; paramc = "fail:system error")
      {
        paramc = new h.a(paramc, new Object[0]);
        AppMethodBeat.o(126403);
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
      paramJSONObject = v.aae().oP(paramString);
      if (paramJSONObject == null)
      {
        ab.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        paramc = new h.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(126403);
        return paramc;
      }
      parama = (l.a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        ab.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        paramc = new h.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(126403);
        return paramc;
      }
      this.bmB.unregisterListener(parama);
      e.b(paramc.getAppId(), parama);
      parama.aED();
      paramJSONObject.recycle();
      ab.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      paramc = new h.a("ok", new Object[0]);
      AppMethodBeat.o(126403);
      return paramc;
    }
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(126404);
    this.bmB.unregisterListener(parama);
    AppMethodBeat.o(126404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.l
 * JD-Core Version:    0.7.0.1
 */