package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.v.b.a;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class f
{
  public static a.b bjt;
  private static Map<String, HashMap<String, b>> gvc = new ConcurrentHashMap();
  private static Set<b> gvd = new HashSet();
  public static a gve;
  public static SensorManager sensorManager;
  
  public static b a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    if (paramInt == -1)
    {
      y.e("MicroMsg.AppBrandMapManager", "[createMapView]INVALID_MAP_ID");
      paramContext = null;
      return paramContext;
    }
    HashMap localHashMap = (HashMap)gvc.get(paramString1);
    if (localHashMap == null)
    {
      localHashMap = new HashMap();
      gvc.put(paramString1, localHashMap);
    }
    for (;;)
    {
      b localb = (b)localHashMap.get(paramString2 + "&" + paramInt);
      if (localb != null)
      {
        y.i("MicroMsg.AppBrandMapManager", "map is exist, return");
        paramString1 = localb.getView();
        paramContext = localb;
        if (paramString1 == null) {
          break;
        }
        paramContext = localb;
        if (!ViewGroup.class.isInstance(paramString1.getParent())) {
          break;
        }
        ((ViewGroup)paramString1.getParent()).removeView(paramString1);
        return localb;
      }
      y.i("MicroMsg.AppBrandMapManager", "createMapView appId:%s, componentId:%s mapId:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      paramContext = ((c)com.tencent.luggage.b.e.i(c.class)).a(paramContext, paramString1, paramString2, paramInt, paramJSONObject);
      paramContext.ajg();
      paramContext.onResume();
      localHashMap.put(paramString2 + "&" + paramInt, paramContext);
      y.i("MicroMsg.AppBrandMapManager", "appId:%s, map count:%d", new Object[] { paramString1, Integer.valueOf(localHashMap.size()) });
      return paramContext;
    }
  }
  
  public static void a(b paramb)
  {
    try
    {
      y.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", new Object[] { paramb });
      gvd.add(paramb);
      if (gvd.size() == 1) {
        init();
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private static Bundle ajr()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = gvd.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).x(localBundle);
    }
    return localBundle;
  }
  
  public static void b(b paramb)
  {
    try
    {
      y.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", new Object[] { paramb });
      gvd.remove(paramb);
      if (gvd.size() == 0) {
        uninit();
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private static void init()
  {
    try
    {
      y.i("MicroMsg.AppBrandMapManager", "init");
      if (bjt == null)
      {
        bjt = new f.1();
        ((a)com.tencent.luggage.b.e.i(a.class)).a("gcj02", bjt, ajr());
      }
      if (gve == null)
      {
        gve = new a();
        Object localObject1 = (SensorManager)ae.getContext().getSystemService("sensor");
        sensorManager = (SensorManager)localObject1;
        localObject1 = ((SensorManager)localObject1).getDefaultSensor(3);
        sensorManager.registerListener(gve, (Sensor)localObject1, 1);
      }
      return;
    }
    finally {}
  }
  
  public static b o(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == -1)
    {
      y.e("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
      return null;
    }
    paramString1 = (HashMap)gvc.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (b)paramString1.get(paramString2 + "&" + paramInt);
  }
  
  public static void p(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = (HashMap)gvc.get(paramString1);
    if (localHashMap == null) {
      return;
    }
    b localb = (b)localHashMap.get(paramString2 + "&" + paramInt);
    if (localb == null)
    {
      y.e("MicroMsg.AppBrandMapManager", "[destroyMapView] mapview not exist, err");
      return;
    }
    y.i("MicroMsg.AppBrandMapManager", "destoryMapView map:%s", new Object[] { localb });
    localHashMap.remove(paramString2 + "&" + paramInt);
    b(localb);
    if (localHashMap.size() <= 0) {
      gvc.remove(paramString1);
    }
    localb.onDestroy();
    y.i("MicroMsg.AppBrandMapManager", "[destroyMapView]appid:%s, map count:%d", new Object[] { paramString1, Integer.valueOf(localHashMap.size()) });
  }
  
  private static void uninit()
  {
    try
    {
      y.i("MicroMsg.AppBrandMapManager", "uninit");
      if (bjt != null)
      {
        y.i("MicroMsg.AppBrandMapManager", "locationListener uninit");
        ((a)com.tencent.luggage.b.e.i(a.class)).b("gcj02", bjt, ajr());
        bjt = null;
      }
      if ((gve != null) && (sensorManager != null))
      {
        y.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
        sensorManager.unregisterListener(gve);
        sensorManager = null;
        gve = null;
      }
      return;
    }
    finally {}
  }
  
  private static final class a
    implements SensorEventListener
  {
    private float gvf = 0.0F;
    private long timestamp = 200L;
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent arg1)
    {
      if (???.sensor.getType() == 3)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.timestamp;
        float f = e.ag(???.values[0]);
        if ((l1 - l2 > 200L) && (Math.abs(f - this.gvf) > 3.0F))
        {
          synchronized (f.Qq())
          {
            Iterator localIterator1 = f.Qq().values().iterator();
            b localb;
            do
            {
              Iterator localIterator2;
              while (!localIterator2.hasNext())
              {
                if (!localIterator1.hasNext()) {
                  break;
                }
                localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
              }
              localb = (b)localIterator2.next();
            } while (localb == null);
            localb.G(this.gvf, f);
          }
          this.gvf = f;
          this.timestamp = System.currentTimeMillis();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.f
 * JD-Core Version:    0.7.0.1
 */