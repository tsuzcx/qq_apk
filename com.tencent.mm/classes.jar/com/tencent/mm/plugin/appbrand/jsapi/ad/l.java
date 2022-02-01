package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private static final HashMap<String, HandlerThread> stU;
  private Handler mHandler;
  private SensorManager mSensorManager;
  private String stT;
  
  static
  {
    AppMethodBeat.i(329499);
    stU = new HashMap();
    AppMethodBeat.o(329499);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(329496);
    this.stT = null;
    this.mHandler = new Handler(abA(paramString).getLooper());
    AppMethodBeat.o(329496);
  }
  
  private static HandlerThread abA(String paramString)
  {
    AppMethodBeat.i(329492);
    String str = "MicroMsg.UnitSensor.".concat(String.valueOf(paramString));
    synchronized (stU)
    {
      HandlerThread localHandlerThread = (HandlerThread)stU.get(str);
      paramString = localHandlerThread;
      if (localHandlerThread == null)
      {
        paramString = d.bFT(str);
        stU.put(str, paramString);
      }
      if (paramString.getLooper() == null) {
        paramString.start();
      }
      AppMethodBeat.o(329492);
      return paramString;
    }
  }
  
  public final i.a a(f paramf, JSONObject paramJSONObject, a parama, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(137657);
    this.stT = paramString;
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int j = paramJSONObject.optInt("interval", 200);
    Log.i("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", new Object[] { paramString, Integer.valueOf(j), Boolean.valueOf(bool1) });
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    }
    if (this.mSensorManager == null)
    {
      Log.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      paramf = new i.a("fail:null system service", new Object[0]);
      AppMethodBeat.o(137657);
      return paramf;
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
        Log.i("MicroMsg.UnitSensor", "get sensor failed.");
        paramf = new i.a("fail:null sensor", new Object[0]);
        AppMethodBeat.o(137657);
        return paramf;
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = ad.bCb().Jm(paramString);
      if (paramJSONObject != null) {
        break label700;
      }
      paramJSONObject = ad.bCb().M(paramString, true);
    }
    label700:
    for (;;)
    {
      if ((a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        Log.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        paramf = new i.a("fail, has enable, should stop pre operation", new Object[0]);
        AppMethodBeat.o(137657);
        return paramf;
      }
      k.a(paramf.getAppId(), parama);
      paramJSONObject.q("sensor_event_listener", parama);
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
        parama.setDisable(true);
        k.b(paramf.getAppId(), parama);
        paramJSONObject.recycle();
        ad.bCb().Jn(paramString);
      }
      Log.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {}
      for (paramf = "ok";; paramf = "fail:system error")
      {
        paramf = new i.a(paramf, new Object[0]);
        AppMethodBeat.o(137657);
        return paramf;
        i = 0;
        break;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
      }
      paramJSONObject = ad.bCb().Jn(paramString);
      if (paramJSONObject == null)
      {
        Log.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        paramf = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramf;
      }
      parama = (a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        Log.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        paramf = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return paramf;
      }
      this.mSensorManager.unregisterListener(parama);
      k.b(paramf.getAppId(), parama);
      parama.setDisable(true);
      paramJSONObject.recycle();
      Log.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      paramf = new i.a("ok", new Object[0]);
      AppMethodBeat.o(137657);
      return paramf;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(137658);
    this.mSensorManager.unregisterListener(parama);
    if (!TextUtils.isEmpty(this.stT)) {
      ad.bCb().Jn(this.stT);
    }
    AppMethodBeat.o(137658);
  }
  
  public static abstract class a
    extends k.c
    implements SensorEventListener
  {
    public final void a(k.d paramd)
    {
      switch (l.1.qLA[paramd.ordinal()])
      {
      }
      do
      {
        return;
      } while (!i.stI.cuC());
      setDisable(true);
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onResume()
    {
      if (i.stI.cuC()) {
        setDisable(false);
      }
    }
    
    public void onSensorChanged(SensorEvent paramSensorEvent) {}
    
    public void setDisable(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.l
 * JD-Core Version:    0.7.0.1
 */