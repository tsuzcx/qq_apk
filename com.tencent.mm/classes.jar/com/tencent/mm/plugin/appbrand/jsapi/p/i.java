package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class i
{
  private SensorManager aVT;
  private Handler mHandler = new Handler(n.DS().mnU.getLooper());
  
  public final f.a a(f paramf, JSONObject paramJSONObject, i.a parama, String paramString, List<Integer> paramList)
  {
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int i = paramJSONObject.optInt("interval", 200);
    if (this.aVT == null) {
      this.aVT = ((SensorManager)paramf.getContext().getSystemService("sensor"));
    }
    if (this.aVT == null)
    {
      y.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      return new f.a("fail:null system service", new Object[0]);
    }
    Object localObject = new ArrayList();
    paramJSONObject = paramList.iterator();
    while (paramJSONObject.hasNext())
    {
      int j = ((Integer)paramJSONObject.next()).intValue();
      paramList = this.aVT.getDefaultSensor(j);
      if (paramList == null)
      {
        y.i("MicroMsg.UnitSensor", "get sensor failed.");
        return new f.a("fail:null sensor", new Object[0]);
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = u.Hc().ih(paramString);
      if (paramJSONObject != null) {
        break label527;
      }
      paramJSONObject = u.Hc().v(paramString, true);
    }
    label527:
    for (;;)
    {
      if ((i.a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        y.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        return new f.a("fail, has enable, should stop pre operation", new Object[0]);
      }
      g.a(paramf.getAppId(), parama);
      paramJSONObject.h("sensor_event_listener", parama);
      paramList = ((List)localObject).iterator();
      bool1 = false;
      while (paramList.hasNext())
      {
        localObject = (Sensor)paramList.next();
        boolean bool2 = this.aVT.registerListener(parama, (Sensor)localObject, h.lA(i), this.mHandler);
        bool1 = bool2;
        if (!bool2) {
          bool1 = bool2;
        }
      }
      if (!bool1)
      {
        this.aVT.unregisterListener(parama);
        parama.ajV();
        g.b(paramf.getAppId(), parama);
        paramJSONObject.recycle();
        u.Hc().ii(paramString);
      }
      y.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {}
      for (paramf = "ok";; paramf = "fail:system error") {
        return new f.a(paramf, new Object[0]);
      }
      paramJSONObject = u.Hc().ii(paramString);
      if (paramJSONObject == null)
      {
        y.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        return new f.a("fail:fail to disable, not enable?", new Object[0]);
      }
      parama = (i.a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        y.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        return new f.a("fail:fail to disable, not enable?", new Object[0]);
      }
      this.aVT.unregisterListener(parama);
      g.b(paramf.getAppId(), parama);
      parama.ajV();
      paramJSONObject.recycle();
      y.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      return new f.a("ok", new Object[0]);
    }
  }
  
  public final void a(i.a parama)
  {
    this.aVT.unregisterListener(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i
 * JD-Core Version:    0.7.0.1
 */