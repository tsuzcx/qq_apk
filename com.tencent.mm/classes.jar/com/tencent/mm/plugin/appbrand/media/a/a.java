package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> gMU = new ConcurrentHashMap();
  private static Map<String, com.tencent.mm.sdk.b.c> gMV = new HashMap();
  private static ArrayList<String> gMW = new ArrayList();
  private static Map<String, Boolean> gMX = new ConcurrentHashMap();
  
  public static void a(String paramString, c paramc)
  {
    gMU.put(paramString, paramc);
  }
  
  public static void a(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      return;
    }
    if (paramc == null)
    {
      y.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      return;
    }
    if (gMV.containsKey(paramString)) {
      va(paramString);
    }
    y.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    gMV.put(paramString, paramc);
    if (!gMW.contains(paramString)) {
      gMW.add(paramString);
    }
    com.tencent.mm.sdk.b.a.udP.b(paramc);
  }
  
  public static void aj(String paramString, boolean paramBoolean)
  {
    gMX.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void onCreate(String paramString)
  {
    y.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    gMU.clear();
    b.onCreate(paramString);
    gMX.put(paramString, Boolean.valueOf(true));
  }
  
  public static void tP(String paramString)
  {
    y.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.tP(paramString);
    gMU.clear();
    Iterator localIterator = gMW.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.sdk.b.c)gMV.remove(localObject);
      if (localObject != null) {
        com.tencent.mm.sdk.b.a.udP.d((com.tencent.mm.sdk.b.c)localObject);
      }
    }
    gMV.clear();
    gMW.clear();
    gMX.remove(paramString);
  }
  
  public static c uZ(String paramString)
  {
    return (c)gMU.get(paramString);
  }
  
  public static void va(String paramString)
  {
    if (!gMV.containsKey(paramString)) {
      y.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
    }
    do
    {
      return;
      y.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
      gMW.remove(paramString);
      paramString = (com.tencent.mm.sdk.b.c)gMV.remove(paramString);
    } while (paramString == null);
    com.tencent.mm.sdk.b.a.udP.d(paramString);
  }
  
  public static boolean vb(String paramString)
  {
    if (!gMX.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)gMX.get(paramString)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */