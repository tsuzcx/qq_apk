package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static ArrayList<String> lrA;
  private static Map<String, Boolean> lrB;
  private static Map<String, c> lry;
  private static Map<String, com.tencent.mm.sdk.b.c> lrz;
  
  static
  {
    AppMethodBeat.i(145783);
    lry = new ConcurrentHashMap();
    lrz = new HashMap();
    lrA = new ArrayList();
    lrB = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void LP(String paramString)
  {
    AppMethodBeat.i(145776);
    ac.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.LP(paramString);
    lry.clear();
    Iterator localIterator = lrA.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.sdk.b.c)lrz.remove(localObject);
      if (localObject != null) {
        com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)localObject);
      }
    }
    lrz.clear();
    lrA.clear();
    lrB.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static c OJ(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)lry.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void OK(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!lrz.containsKey(paramString))
    {
      ac.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    ac.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    lrA.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lrz.remove(paramString);
    if (paramString != null) {
      com.tencent.mm.sdk.b.a.GpY.d(paramString);
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean OL(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!lrB.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)lrB.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    lry.put(paramString, paramc);
    AppMethodBeat.o(145777);
  }
  
  public static void a(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(145779);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      AppMethodBeat.o(145779);
      return;
    }
    if (paramc == null)
    {
      ac.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      AppMethodBeat.o(145779);
      return;
    }
    if (lrz.containsKey(paramString)) {
      OK(paramString);
    }
    ac.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    lrz.put(paramString, paramc);
    if (!lrA.contains(paramString)) {
      lrA.add(paramString);
    }
    com.tencent.mm.sdk.b.a.GpY.b(paramc);
    AppMethodBeat.o(145779);
  }
  
  public static void at(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    lrB.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    ac.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    lry.clear();
    b.onCreate(paramString);
    lrB.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */