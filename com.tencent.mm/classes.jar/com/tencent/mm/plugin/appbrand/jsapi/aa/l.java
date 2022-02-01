package com.tencent.mm.plugin.appbrand.jsapi.aa;

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
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private static final HashMap<String, HandlerThread> ppg;
  private Handler mHandler;
  private SensorManager mSensorManager;
  private String ppf;
  
  static
  {
    AppMethodBeat.i(205589);
    ppg = new HashMap();
    AppMethodBeat.o(205589);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(205587);
    this.ppf = null;
    this.mHandler = new Handler(aiA(paramString).getLooper());
    AppMethodBeat.o(205587);
  }
  
  private static HandlerThread aiA(String paramString)
  {
    AppMethodBeat.i(205586);
    String str = "MicroMsg.UnitSensor.".concat(String.valueOf(paramString));
    synchronized (ppg)
    {
      HandlerThread localHandlerThread = (HandlerThread)ppg.get(str);
      paramString = localHandlerThread;
      if (localHandlerThread == null)
      {
        paramString = d.bDl(str);
        ppg.put(str, paramString);
      }
      if (paramString.getLooper() == null) {
        paramString.start();
      }
      AppMethodBeat.o(205586);
      return paramString;
    }
  }
  
  public final i.a a(e parame, JSONObject paramJSONObject, a parama, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(137657);
    this.ppf = paramString;
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int j = paramJSONObject.optInt("interval", 200);
    Log.i("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", new Object[] { paramString, Integer.valueOf(j), Boolean.valueOf(bool1) });
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    }
    if (this.mSensorManager == null)
    {
      Log.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      parame = new i.a("fail:null system service", new Object[0]);
      AppMethodBeat.o(137657);
      return parame;
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
        parame = new i.a("fail:null sensor", new Object[0]);
        AppMethodBeat.o(137657);
        return parame;
      }
      ((List)localObject).add(paramList);
    }
    if (bool1)
    {
      paramJSONObject = ad.beh().Rn(paramString);
      if (paramJSONObject != null) {
        break label700;
      }
      paramJSONObject = ad.beh().I(paramString, true);
    }
    label700:
    for (;;)
    {
      if ((a)paramJSONObject.get("sensor_event_listener", null) != null)
      {
        Log.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        parame = new i.a("fail, has enable, should stop pre operation", new Object[0]);
        AppMethodBeat.o(137657);
        return parame;
      }
      k.a(parame.getAppId(), parama);
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
        parama.setDisable(true);
        k.b(parame.getAppId(), parama);
        paramJSONObject.recycle();
        ad.beh().Ro(paramString);
      }
      Log.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {}
      for (parame = "ok";; parame = "fail:system error")
      {
        parame = new i.a(parame, new Object[0]);
        AppMethodBeat.o(137657);
        return parame;
        i = 0;
        break;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
      }
      paramJSONObject = ad.beh().Ro(paramString);
      if (paramJSONObject == null)
      {
        Log.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
        parame = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return parame;
      }
      parama = (a)paramJSONObject.get("sensor_event_listener", null);
      if (parama == null)
      {
        Log.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
        parame = new i.a("fail:fail to disable, not enable?", new Object[0]);
        AppMethodBeat.o(137657);
        return parame;
      }
      this.mSensorManager.unregisterListener(parama);
      k.b(parame.getAppId(), parama);
      parama.setDisable(true);
      paramJSONObject.recycle();
      Log.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
      parame = new i.a("ok", new Object[0]);
      AppMethodBeat.o(137657);
      return parame;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(137658);
    this.mSensorManager.unregisterListener(parama);
    if (!TextUtils.isEmpty(this.ppf)) {
      ad.beh().Ro(this.ppf);
    }
    AppMethodBeat.o(137658);
  }
  
  public static abstract class a
    extends k.c
    implements SensorEventListener
  {
    public final void a(k.d paramd)
    {
      switch (l.1.nLM[paramd.ordinal()])
      {
      }
      do
      {
        return;
      } while (!i.poU.bUp());
      setDisable(true);
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onResume()
    {
      if (i.poU.bUp()) {
        setDisable(false);
      }
    }
    
    public void onSensorChanged(SensorEvent paramSensorEvent) {}
    
    public void setDisable(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.l
 * JD-Core Version:    0.7.0.1
 */